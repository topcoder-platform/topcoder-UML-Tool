/*
 * Copyright (C) 2007 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.swing.imageexporter;

import com.topcoder.util.image.manipulation.Image;
import com.topcoder.util.image.manipulation.ImageEncoder;
import com.topcoder.util.image.manipulation.ImageEncodingException;
import com.topcoder.util.image.manipulation.encoder.BMPImageEncoder;
import com.topcoder.util.image.manipulation.encoder.GIFImageEncoder;
import com.topcoder.util.image.manipulation.encoder.JPEGImageEncoder;
import com.topcoder.util.image.manipulation.encoder.PNGImageEncoder;
import com.topcoder.util.image.manipulation.encoder.PNMImageEncoder;
import com.topcoder.util.image.manipulation.encoder.TIFFImageEncoder;
import com.topcoder.util.image.manipulation.image.MutableMemoryImage;
import com.topcoder.util.objectfactory.InvalidClassSpecificationException;
import com.topcoder.util.objectfactory.ObjectFactory;

import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.RenderingHints;
import java.awt.image.BufferedImage;

import java.io.OutputStream;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

import javax.swing.JComponent;
import javax.swing.RepaintManager;


/**
 * <p>
 * This class is used to export the JComponent into OutputStream, it is the default implementation of
 * JComponentImageExporter in this component. It uses the Image Manipulation component to export
 * image, so jpeg, pnm, png, bmp, gif, tiff are supported by default. However, more formats and encoders
 * can be customized through the config. Several optimizations are also possible through RenderingHints object</p>
 * <p>Here is a sample of the config:</p>
 * <pre>&lt;!-- custom config for ImageManipulationImageExporter,
 * some of the settings are tuned, and new encoder is added--&gt;
 * &lt;Config name=&quot;ImageManipulationImageExporterProperties&quot;&gt;
 *      &lt;Property name=&quot;imageType&quot;&gt;
 *          &lt;Value&gt;TYPE_INT_RGB&lt;/Value&gt;
 *      &lt;/Property&gt;
 *
 * &lt;!-- tune for rendering hints--&gt;
 *      &lt;Property name=&quot;renderingHints&quot;&gt;
 *          &lt;Value&gt;KEY_FRACTIONALMETRICS,VALUE_FRACTIONALMETRICS_ON&lt;/Value&gt;
 *          &lt;Value&gt;KEY_STROKE_CONTROL,VALUE_STROKE_NORMALIZE&lt;/Value&gt;
 *      &lt;/Property&gt;
 *
 * &lt;!--here a new format 'custom_format' is added, the key for this encoder is 'custom_encoder' --&gt;
 *      &lt;Property name=&quot;encodersMap&quot;&gt;
 *          &lt;Value&gt;custom_format,custom_encoder&lt;/Value&gt;
 *      &lt;/Property&gt; </pre>
 *<pre>         &lt;Property name=&quot;objectFactoryNamespace&quot;&gt;
 *          &lt;Value&gt;ObjectFactory_Encoders&lt;/Value&gt;
 *      &lt;/Property&gt;
 * &lt;/Config&gt;
 *
 * &lt;!-- Config for ObjectFactory, used by ImageManipulationImageExporter--&gt;
 * &lt;Config name=&quot;ObjectFactory_Encoders&quot;&gt;
 *      &lt;Property name=&quot;custom_encoder&quot;&gt;
 *          &lt;Property name=&quot;type&quot;&gt;
 *              &lt;Value&gt;com.topcoder.swing.imageexporter.MockImageEncoder&lt;/Value&gt;
 *          &lt;/Property&gt;
 *      &lt;/Property&gt;
 * &lt;/Config&gt;</pre>
 * <p>Thread-Safety: This class is immutable and thread safe.</p>
 *
 * @author fabrizyo, TCSDEVELOPER
 * @version 1.0
  */
public class ImageManipulationImageExporter implements JComponentImageExporter {
    /**
     * <p>Represents the jpeg image format.</p>
     */
    public static final String JPEG_FORMAT = "jpeg";

    /**
     * <p>Represents the pnm image format.</p>
     */
    public static final String PNM_FORMAT = "pnm";

    /**
     * <p>Represents the png image format.</p>
     */
    public static final String PNG_FORMAT = "png";

    /**
     * <p>Represents the bmp image format.</p>
     */
    public static final String BMP_FORMAT = "bmp";

    /**
     * <p>Represents the gif image format.</p>
     */
    public static final String GIF_FORMAT = "gif";

    /**
     * <p>Represents the tiff image format.</p>
     */
    public static final String TIFF_FORMAT = "tiff";

    /**
     * <p>Represents the namespace for loading the properties of this class.</p>
     */
    private static final String IMAGE_MANIPULATION_IMAGE_EXPORTER_NAMESPACE =
        "ImageManipulationImageExporterProperties";

    /**
     * <p>Represents the names of parameter for loading the encoders. It's a multi-value property. Each value is
     * formed of &lt;imageFormat,key for Object Factory&gt;</p>
     */
    private static final String ENCODERS_PARAMETER = "encodersMap";

    /**
     * <p>Represents the namespace for loading the encoders through Object Factory.</p>
     */
    private static final String OBJECT_FACTORY_NAMESPACE_PARAMETER = "objectFactoryNamespace";

    /**
     * <p>Represents the name of rendering hints parameter.</p>
     */
    private static final String RENDERING_HINTS_PARAMETER = "renderingHints";

    /**
     * <p>Represents the name of parameter for retrieving the imageType from config file.</p>
     */
    private static final String IMAGE_TYPE_PARAMETER = "imageType";

    /**
     * <p> Represents the map of the supported format and relative encoders of this exporter.</p>
     */
    private final Map<String, ImageEncoder> encodersMap;

    /**
     * <p>Represents the rendering hints objects for optimizing the rendering result.</p>
     */
    private final Map<RenderingHints.Key, Object> renderingHints;

    /**
     * <p>Represents the image type of the created buffered image during the export process.</p>
     */
    private final int imageType;

    /**
     * <p>
     * Construct an ImageManipulationImageExporter with default configuration.
     * </p>
     * @throws ImageExporterConfigurationException if any error occurs while reading from config
     */
    public ImageManipulationImageExporter() throws ImageExporterConfigurationException {
        this.encodersMap = initEncoders(); // init encoders
        this.imageType = initImageType(); // init imageType from config
        this.renderingHints = initRenderingHints(); // init rendering hints
    }

    /**
     * <p>Exports the JComponent into OutputStream with specified format. If viewport is given, and it's
     * inside the component area, the exporting area will be set to the viewport. Currently, this exporter
     * does not support not displayable component, ImageExporterException will be thrown if it's encountered.</p>
     *
     * @param jComponent the jComponent to be exported, not be null, must be displayable
     * @param outputStream the outputStream to write the image to, not null
     * @param viewport the viewport to capture of the image's area, should be inside the component area,can be null
     * @param format the image format, should not be null or empty and must be supported by this exporter
     *
     * @throws ImageExporterException if any error occurs during the exporting process
     * @throws IllegalArgumentException if any argument is invalid
     */
    public void export(JComponent jComponent, OutputStream outputStream, Rectangle viewport, String format)
        throws ImageExporterException {
        ParameterCheck.checkNull("jComponent", jComponent);
        ParameterCheck.checkNull("outputStream", outputStream);
        ParameterCheck.checkNullEmpty("format", format);

        //retrieves the encoder from encoders map
        ImageEncoder encoder = encodersMap.get(format);

        if (encoder == null) {
            throw new IllegalArgumentException("format:" + format + " can not be recognized");
        }

        //calculates the printing area according to the component and viewport
        Rectangle printingArea = calPrintingArea(jComponent, viewport);

        //retrieves the current doubleBuffering state
        RepaintManager currentManager = RepaintManager.currentManager(jComponent);
        boolean isDoubleBuffering = currentManager.isDoubleBufferingEnabled();

        //closes double buffering if it's enable
        if (isDoubleBuffering) {
            currentManager.setDoubleBufferingEnabled(false);
        }

        //creates the bufferedImage according to the calculated printing area
        BufferedImage bufferedImage = new BufferedImage((int) printingArea.getWidth(), (int) printingArea.getHeight(),
                imageType);

        //creates graphics for printing the component
        Graphics2D graphics = bufferedImage.createGraphics();

        //uses the rendering hints if they exist
        graphics.setRenderingHints(renderingHints);

        //adjust the origin to the printingArea's left top coordinate
        graphics.translate(-printingArea.x, -printingArea.y);

        //prints the image of the component to graphics of bufferedImage
        jComponent.print(graphics);

        //creates a MutableMemoryImage from the generated BufferedImage
        Image image = new MutableMemoryImage(bufferedImage);

        //exports the image
        try {
            encoder.encode(image, outputStream, null);
        } catch (ImageEncodingException e) {
            throw new ImageExporterException("failed to export to image", e);
        } finally {
            //if double buffering is previously on, restore it
            if (isDoubleBuffering) {
                currentManager.setDoubleBufferingEnabled(true);
            }
        }
    }

    /**
     * <p>Returns the supported formats of this exporter.</p>
     *
     * @return the supported formats of this exporter.
     */
    public String[] getSupportedFormats() {
        String[] result = new String[this.encodersMap.size()];
        this.encodersMap.keySet().toArray(result);

        return result;
    }

    /**
     * Calculates the printing area according to the given JComponent and viewport. If viewport exists and it's
     * inside the component area, uses it as printing area, otherwise uses the JComponent area.
     *
     * @param jComponent JComponent to be printed, displayable, not 0 size
     * @param viewport viewport of the printing area, inside the component area, not 0 size
     *
     * @return calculated printing area
     *
     * @throws ImageExporterException if jComponent is not displayable
     * @throws IllegalArgumentException if any argument is invalid
     */
    private Rectangle calPrintingArea(JComponent jComponent, Rectangle viewport)
        throws ImageExporterException {
        //check if the component is displayable
        if (!jComponent.isDisplayable()) {
            throw new ImageExporterException("not displayable component is not exported by this exporter");
        }

        //first sets the default printing area to be the whole component
        Rectangle printingArea = new Rectangle(0, 0, jComponent.getWidth(), jComponent.getHeight());

        //if viewport specified and inside the component, use it as printing area
        if (viewport != null) {
            //viewport should be inside the component area
            if (printingArea.contains(viewport)) {
                //sets the viewport as printing area
                printingArea = viewport;
            } else {
                throw new IllegalArgumentException("viewport is not inside the component area");
            }
        }

        return printingArea;
    }

    /**
     * Gets a specified constant field value from a class. If the field name does not start with the given
     * prefix, or it's not an existent constant field, null will be return. This method is used as a helper method to
     * map a paticular string to a constant field value.
     *
     * @param clazz class from which the constant field is read
     * @param name name of the constant field
     * @param prefix prefix of the field name. If it's null, no prefix restriction will be checked
     *
     * @return value of the constant field, if it does not exist, null will be returned
     */
    private static Object getConstantField(Class clazz, String name, String prefix) {
        //checks prefix restriction if prefix specified
        if (prefix != null) {
            if (!name.startsWith(prefix)) {
                return null;
            }
        }

        try {
            return clazz.getField(name).get(clazz);
        } catch (SecurityException e) {
            return null;
        } catch (NoSuchFieldException e) {
            return null;
        } catch (IllegalArgumentException e) {
            return null;
        } catch (IllegalAccessException e) {
            return null;
        }
    }

    /**
     * Reads map-form property values from given namespace. A map-form property is similar with the string array
     * property, but the value is in form of &lt;key&gt;,&lt;value&gt; pair. These pairs will be converted into
     * map by this method.
     *
     * @param namespace namespace of the property
     * @param propertyName name of the property
     *
     * @return value of the map-form property, not null
     *
     * @throws ImageExporterConfigurationException if property is missing or malformed
     */
    private static Map<String, String> getMapProperty(String namespace, String propertyName)
        throws ImageExporterConfigurationException {
        Map<String, String> map = new HashMap<String, String>();
        String[] mapStrings = ConfigHelper.getArrayProperty(namespace, propertyName);

        if (mapStrings != null) {
            String[] pair;

            for (int i = 0; i < mapStrings.length; i++) {
                pair = mapStrings[i].split(",");

                //checks if the pair is valid
                if ((pair.length != 2) || (pair[0].trim().length() == 0) || (pair[1].trim().length() == 0)) {
                    throw new ImageExporterConfigurationException("property:" + propertyName + " in " + namespace
                            + " is not in map format:<key>,<value>(key and value are not empty string)<->"
                            + mapStrings[i]);
                }

                map.put(pair[0], pair[1]);
            }
        }

        return map;
    }

    /**
     * Reads from config to initialize the encoders map for this exporter. Encoders for BMP, JPEG, PNG, TIFF,
     * PNM, GIF from Image Manipulation component will be set as default, and other encoders will be load
     * according to the config.
     *
     * @return encodersMap encoders for this exporter
     *
     * @throws ImageExporterConfigurationException if any value is not configured properly
     */
    private static Map<String, ImageEncoder> initEncoders()
        throws ImageExporterConfigurationException {
        Map<String, ImageEncoder> encodersMap = new HashMap<String, ImageEncoder>();

        //adds default image encoders
        encodersMap.put(BMP_FORMAT, new BMPImageEncoder());
        encodersMap.put(JPEG_FORMAT, new JPEGImageEncoder());
        encodersMap.put(PNG_FORMAT, new PNGImageEncoder());
        encodersMap.put(TIFF_FORMAT, new TIFFImageEncoder());
        encodersMap.put(PNM_FORMAT, new PNMImageEncoder());
        encodersMap.put(GIF_FORMAT, new GIFImageEncoder());

        //reads the property from config as map
        Map<String, String> encoders = getMapProperty(IMAGE_MANIPULATION_IMAGE_EXPORTER_NAMESPACE,
                ENCODERS_PARAMETER);

        //if customized encoders exist, loads and maps them
        if (encoders.size() > 0) {
            //create ObjectFactory only if custom encoders exist
            ObjectFactory objectFactory = ConfigHelper.createObjectFactory(IMAGE_MANIPULATION_IMAGE_EXPORTER_NAMESPACE,
                    OBJECT_FACTORY_NAMESPACE_PARAMETER);

            Iterator<Entry<String, String>> iter = encoders.entrySet().iterator();

            Entry<String, String> entry;

            while (iter.hasNext()) {
                entry = iter.next();

                String format = entry.getKey(); //the format this encoder supports
                String objFactoryKey = entry.getValue(); //key for object factory to create the encoder

                try {
                    //creates the encoder via ObjectFactory and adds it into encodersMap
                    encodersMap.put(format, (ImageEncoder) objectFactory.createObject(objFactoryKey));
                } catch (ClassCastException e) {
                    throw new ImageExporterConfigurationException("encoder for:" + format
                            + " is not a valid subclass of ImageEncoder", e);
                } catch (InvalidClassSpecificationException e) {
                    throw new ImageExporterConfigurationException("can not create encoder:" + format, e);
                }
            }
        }

        return encodersMap;
    }

    /**
     * Reads from config to initialize the imageType for this exporter. Default value
     * BufferedImage.TYPE_INT_ARGB will be returned if this argument is not configured.
     *
     * @return imageType set in config or default value BufferedImage.TYPE_INT_ARGB
     *
     * @throws ImageExporterConfigurationException if any property is not configured properly
     */
    private static int initImageType() throws ImageExporterConfigurationException {
        String imageType = ConfigHelper.getStringProperty(IMAGE_MANIPULATION_IMAGE_EXPORTER_NAMESPACE,
                IMAGE_TYPE_PARAMETER);

        //optional field, use default if absent
        if (imageType == null) {
            return BufferedImage.TYPE_INT_ARGB;
        }

        //converts from string to int type, image type should start with TYPE_
        Object value = getConstantField(BufferedImage.class, imageType, "TYPE_");

        //the constant field should exist in BufferedImage and must not be TYPE_CUSTOM
        if ((value == null) || ((Integer) value == BufferedImage.TYPE_CUSTOM)) {
            throw new ImageExporterConfigurationException("property:" + IMAGE_TYPE_PARAMETER + " in namespace:"
                    + IMAGE_MANIPULATION_IMAGE_EXPORTER_NAMESPACE + " is invalid, unrecoginzed value:" + imageType);
        }

        return (Integer) value;
    }

    /**
     * Reads from config to initialize the renderingHints for this exporter. renderingHints is optional and this
     * method may return empty map.
     *
     * @return renderingHints set in config, may be empty map
     *
     * @throws ImageExporterConfigurationException if any value is not configured properly
     */
    private static Map<RenderingHints.Key, Object> initRenderingHints()
        throws ImageExporterConfigurationException {
        Map<RenderingHints.Key, Object> renderingHints = new HashMap<RenderingHints.Key, Object>();

        //reads the property from config, and converts it to map
        Map<String, String> hintsMap = getMapProperty(IMAGE_MANIPULATION_IMAGE_EXPORTER_NAMESPACE,
                RENDERING_HINTS_PARAMETER);

        //optional property, ignore if empty
        if (hintsMap.size() > 0) {
            Iterator<Entry<String, String>> iter = hintsMap.entrySet().iterator();

            Entry<String, String> entry;

            while (iter.hasNext()) {
                entry = iter.next();

                String key = entry.getKey(); //string representation of RenderingHints key

                //use reflection to get it's object value from RenderingHints
                RenderingHints.Key hintKey = (RenderingHints.Key) getConstantField(RenderingHints.class, key, "KEY_");

                //the key is not defined in RenderingHints
                if (hintKey == null) {
                    throw new ImageExporterConfigurationException("property:" + RENDERING_HINTS_PARAMETER
                            + " in namespace:" + IMAGE_MANIPULATION_IMAGE_EXPORTER_NAMESPACE
                            + " is invalid, unrecoginzed value:" + key);
                }

                //use reflection to get RenderingHints value, should start with VALUE_
                Object value = getConstantField(RenderingHints.class, entry.getValue(), "VALUE_");

                //the value is not defined in RenderingHints
                if (value == null) {
                    throw new ImageExporterConfigurationException("property:" + RENDERING_HINTS_PARAMETER
                            + " in namespace:" + IMAGE_MANIPULATION_IMAGE_EXPORTER_NAMESPACE
                            + " is invalid, unrecoginzed value:" + entry.getValue());
                }

                renderingHints.put(hintKey, value);
            }
        }

        return renderingHints;
    }
}
