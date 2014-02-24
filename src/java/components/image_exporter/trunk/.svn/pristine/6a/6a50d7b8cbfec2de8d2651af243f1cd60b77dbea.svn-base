/*
 * Copyright (C) 2007 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.swing.imageexporter;

import com.topcoder.util.objectfactory.InvalidClassSpecificationException;
import com.topcoder.util.objectfactory.ObjectFactory;

import java.awt.Rectangle;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.swing.JComponent;


/**
 * <p>This is a Facade class of this component, a convenient utility for exporting JComponent(s) into image
 * file(s) or  OutputStream(s). Image formats can be specified for the exporting, they are supported by the plugin
 * JComponentImageExporters. By default, ImageManipulationImageExporter is plugged in, which supports BMP, JPG, GIF,
 * TIFF, PNG, PNM formats from Image Manipulation component. More JComponentImageExporters can be plugged in flexibly
 * to support more image formats via the configuration.</p>
 *  <p>Here is a sample of the config:</p>
 * <pre>
 * &lt;!-- custom exporter, with custom JComponentImageExporter and JComponentVisibleMaker--&gt;
 * &lt;Config name=&quot;custom_exporter&quot;&gt;
 *      &lt;Property name=&quot;exportersMap&quot;&gt;
 *          &lt;Value&gt;custom_exporter&lt;/Value&gt;
 *      &lt;/Property&gt;
 *          &lt;Property name=&quot;jComponentVisibleMaker&quot;&gt;
 *          &lt;Value&gt;custom_visible_maker&lt;/Value&gt;
 *      &lt;/Property&gt;
 *      &lt;Property name=&quot;objectFactoryNamespace&quot;&gt;
 *          &lt;Value&gt;ObjectFactory_Exporter&lt;/Value&gt;
 *      &lt;/Property&gt;
 * &lt;/Config&gt;
 *
 * &lt;!-- Config for ObjectFactory, used by ImageExporter--&gt;
 * &lt;Config name=&quot;ObjectFactory_Exporter&quot;&gt;
 *      &lt;Property name=&quot;custom_exporter&quot;&gt;
 *          &lt;Property name=&quot;type&quot;&gt;
 *              &lt;Value&gt;com.topcoder.swing.imageexporter.MockJComponentImageExporter&lt;/Value&gt;
 *          &lt;/Property&gt;
 *      &lt;/Property&gt;
 *
 *      &lt;Property name=&quot;custom_visible_maker&quot;&gt;
 *          &lt;Property name=&quot;type&quot;&gt;
 *              &lt;Value&gt;com.topcoder.swing.imageexporter.MockVisibleMaker&lt;/Value&gt;
 *          &lt;/Property&gt;
 *      &lt;/Property&gt;
 * &lt;/Config&gt;
 *</pre>
 *  <p>Thread-Safety: This class is immutable and thread safe.</p>
 *
 * @author fabrizyo, TCSDEVELOPER
 * @version 1.0
 */
public class ImageExporter {
    /**
     * <p>Represents the JPEG image format.</p>
     */
    public static final String JPEG_FORMAT = ImageManipulationImageExporter.JPEG_FORMAT;

    /**
     * <p>Represents the PNM image format.</p>
     */
    public static final String PNM_FORMAT = ImageManipulationImageExporter.PNM_FORMAT;

    /**
     * <p>Represents the PNG image format.</p>
     */
    public static final String PNG_FORMAT = ImageManipulationImageExporter.PNG_FORMAT;

    /**
     * <p>Represents BMP image format.</p>
     */
    public static final String BMP_FORMAT = ImageManipulationImageExporter.BMP_FORMAT;

    /**
     * <p>Represents GIF image format.</p>
     */
    public static final String GIF_FORMAT = ImageManipulationImageExporter.GIF_FORMAT;

    /**
     * <p>Represents TIFF image format.</p>
     */
    public static final String TIFF_FORMAT = ImageManipulationImageExporter.TIFF_FORMAT;

    /**
     * <p>Represents the default namespace of this component for retrieving the properties from config file,
     * using Config Manager.</p>
     */
    private static final String DEFAULT_NAMESPACE = "com.topcoder.swing.imageexporter";

    /**
     * <p>Represents the name of exporters map parameter. It's a multivalue property: each value is a key for
     * instantiating the JComponentImageExporters with Object Factory.</p>
     */
    private static final String EXPORTERS_PARAMETER = "exportersMap";

    /**
     * <p>Represents the namespace property for object factory component for initializing the exporters map and
     * jComponentVisibleMaker. This field is required when EXPORTERS_PARAMETER or JCOMPONENT_VISIBLE_MAKER_PARAMETER
     * exists.</p>
     */
    private static final String OBJECT_FACTORY_NAMESPACE_PARAMETER = "objectFactoryNamespace";

    /**
     * <p>Represents the parameter for initializing the JComponentVisibleMaker through Object Factory: the value
     * is the key for object factory initialization.</p>
     */
    private static final String JCOMPONENT_VISIBLE_MAKER_PARAMETER = "jComponentVisibleMaker";

    /**
     * <p>Represents the visible maker for rendering the visibility of jComponent. It's initialized
     * in constructor through the config file (with object factory). If it's missing, DefaultVisibleMaker will
     * be used by default.<p>
     */
    private final JComponentVisibleMaker jComponentVisibleMaker;

    /**
     * <p>Represents the map of exporters, image format as key and the relative JComponentImageExporter as value.
     * ImageManipulationImageExporter and it's supporting formats will be set by default, and more exporters
     * will be added through the config file.</p>
     */
    private final Map<String, JComponentImageExporter> exportersMap;

    /**
     * <p>
     * Constructs an ImageExporter with the default namespace.
     * </p>
     * @throws ImageExporterConfigurationException if any error occurs while reading from config
     */
    public ImageExporter() throws ImageExporterConfigurationException {
        this(DEFAULT_NAMESPACE);
    }

    /**
     * <p>
     * Constructs an ImageExporter with the given namespace.
     * </p>
     *
     * @param namespace the namespace for loading the configuration
     * @throws ImageExporterConfigurationException if any error occurs while reading from config
     * @throws IllegalArgumentException if namespace is null or trimmed empty
     */
    public ImageExporter(String namespace) throws ImageExporterConfigurationException {
        ParameterCheck.checkNullEmpty("namespace", namespace);

        ObjectFactory objectFactory = null;

        this.exportersMap = new HashMap<String, JComponentImageExporter>();

        //registers ImageManipulationImageExporter as default exporter
        registerExporter(new ImageManipulationImageExporter());

        //reads keys for other customized exporters
        String[] exporterKeys = ConfigHelper.getArrayProperty(namespace, EXPORTERS_PARAMETER);

        //creates these exporters and registers them
        if (exporterKeys != null) {
            objectFactory = ConfigHelper.createObjectFactory(namespace, OBJECT_FACTORY_NAMESPACE_PARAMETER);
            registerCustomExporters(objectFactory, exporterKeys);
        }

        //initializes the visible maker
        this.jComponentVisibleMaker = initVisibleMaker(namespace, objectFactory);
    }

    /**
     * <p>Exports a JComponent to an image file with location directory and image format.</p>
     *
     * @param component the jComponent to be exported, not null, not 0 size
     * @param location the directory of the generated file, can be null or empty
     * @param fileName the name of the file to be exported, not null
     * @param format the format of the image, not null or empty, and must be supported by this exporter
     *
     * @throws IllegalArgumentException if any argument is invalid
     * @throws ImageExporterException if any error occurs while exporting
     */
    public void exportComponent(JComponent component, String location, String fileName, String format)
        throws ImageExporterException {
        this.exportComponent(component, null, location, fileName, format);
    }

    /**
     * <p>Exports a JComponent to an image file with location directory using the image format and capturing a
     * viewport area of JComponent's image. If viewport is null, the full area of the component will be
     * exported.</p>
     *
     * @param component the jComponent to be exported, not null,  not 0 size
     * @param viewport the area within the JComponent to export, inside the component area or null
     * @param location the directory of the generated file, can be null or empty
     * @param fileName the name of the file generated, not null
     * @param format the format of the image, not null or empty, and must be supported by this exporter
     *
     * @throws IllegalArgumentException if any argument is invalid
     * @throws ImageExporterException if any error occurs while exporting
     */
    public void exportComponent(JComponent component, Rectangle viewport, String location, String fileName,
        String format) throws ImageExporterException {

        List<JComponent> components = new ArrayList<JComponent>();
        components.add(component);

        List<String> fileNames = new ArrayList<String>();
        fileNames.add(fileName);

        this.exportComponent(components, viewport, location, fileNames, format);
    }

    /**
     * <p>Exports a list of JComponents to a list of files, given with directory and format.</p>
     *
     * @param components the list of JComponents to be exported, not null, no null element, same size with fileNames
     * @param location the directory of the generated files, can be null or empty
     * @param fileNames the list of file names generated, not null, not empty, no null element
     * @param format the format of the image, not null or empty and must be supported by this exporter
     *
     * @throws IllegalArgumentException if any argument is invalid
     * @throws ImageExporterException if any error occurs while exporting
     */
    public void exportComponent(List<JComponent> components, String location, List<String> fileNames, String format)
        throws ImageExporterException {
        this.exportComponent(components, null, location, fileNames, format);
    }

    /**
     * <p>Exports a list of JComponents to a list of files, given with directory and format and capturing a
     * viewport area of JComponents image. If viewport is null, the full area of the components will be
     * exported.</p>
     *
     * @param components the list of JComponents to be exported, not null, no null element, same size with fileNames
     * @param viewport the area within the JComponent to export, inside the component area or null
     * @param location the directory of the generated files, can be null or empty
     * @param fileNames the list of file names generated, not null, not empty, no null element
     * @param format the format of the image, not null or empty and must be supported by this exporter
     *
     * @throws IllegalArgumentException if any argument is invalid
     * @throws ImageExporterException if any error occurs while exporting
     */
    public void exportComponent(List<JComponent> components, Rectangle viewport, String location,
        List<String> fileNames, String format) throws ImageExporterException {
        ParameterCheck.checkEmptyList("fileNames", fileNames);
        if (fileNames.contains("")) {
            throw new IllegalArgumentException("empty file name");
        }

        List<File> files = new ArrayList<File>(fileNames.size());
        List<OutputStream> outputStreams = new ArrayList<OutputStream>(fileNames.size());

        //null location should be considered as empty string
        // location = (location == null) ? "" : location.trim();

        //flag indicating whether exporting is successful
        //if exporting failed, all files that generated will be deleted
        boolean success = false;

        try {
            //creates a list of OutputStreams according to the files' locations and names
            for (Iterator<String> iter = fileNames.iterator(); iter.hasNext();) {
                String fileName = iter.next();

                File file = new File(location, fileName);
                files.add(file);
                outputStreams.add(new FileOutputStream(file));
            }

            //exports the components to the output streams
            this.exportComponent(components, viewport, outputStreams, format);
            success = true;
        } catch (FileNotFoundException e) {
            throw new ImageExporterException("faild to create file", e);
        } finally {
            //closes all the output streams
            closeOutputStreams(outputStreams);

            //deletes all files generated if exporting failed
            if (!success) {
                deleteFiles(files);
            }
        }
    }

    /**
     * <p>Exports a JComponent to an OutputStream using the image format.</p>
     *
     * @param component the JComponent to be exported, not null,  not 0 size
     * @param outputStream the outputStream to export the image of jComponent to, not null
     * @param format the format of the image, not null or empty, and must be supported by this exporter
     *
     * @throws IllegalArgumentException if any argument is invalid
     * @throws ImageExporterException if any error occurs while exporting
     */
    public void exportComponent(JComponent component, OutputStream outputStream, String format)
        throws ImageExporterException {
        this.exportComponent(component, null, outputStream, format);
    }

    /**
     * <p>Exports a JComponent to an OutputStream using the image format.</p>
     *
     * @param component the JComponent to be exported, not null,  not 0 size
     * @param viewport the area within the JComponent to export, inside the component area or null
     * @param outputStream the outputStream to export the image of jComponent to, not null
     * @param format the format of the image, not null or empty, and must be supported by this exporter
     *
     * @throws IllegalArgumentException if any argument is invalid
     * @throws ImageExporterException if any error occurs while exporting
     */
    public void exportComponent(JComponent component, Rectangle viewport, OutputStream outputStream, String format)
        throws ImageExporterException {
        List<JComponent> components = new ArrayList<JComponent>();
        components.add(component);

        List<OutputStream> outputStreams = new ArrayList<OutputStream>();
        outputStreams.add(outputStream);

        this.exportComponent(components, viewport, outputStreams, format);
    }

    /**
     * <p>Exports a list of JComponents to a list of relative OutputStreams using the image format.</p>
     *
     * @param components the list of JComponents to be exported, not null, no null element, same size with outputStreams
     * @param outputStreams the outputStreams to export the image of jComponent to, not null, not empty, no null element
     * @param format the format of the image, not null or empty and must be supported by this exporter
     *
     * @throws IllegalArgumentException if any argument is invalid
     * @throws ImageExporterException if any error occurs while exporting
     */
    public void exportComponent(List<JComponent> components, List<OutputStream> outputStreams, String format)
        throws ImageExporterException {
        this.exportComponent(components, null, outputStreams, format);
    }

    /**
     * <p>Exports a list of JComponents to a list of relative OutputStreams using the image format and capturing a
     * viewport area of JComponents image.</p>
     *
     * @param components the list of JComponents to be exported, not null, no null element, same size with outputStreams
     * @param viewport the area within the JComponent to export, inside the component area or null
     * @param outputStreams the outputStreams to export the image of jComponent to, not null, not empty, no null element
     * @param format the format of the image, not null or empty and must be supported by this exporter
     *
     * @throws IllegalArgumentException if any argument is invalid
     * @throws ImageExporterException if any error occurs while exporting
     */
    public void exportComponent(List<JComponent> components, Rectangle viewport, List<OutputStream> outputStreams,
        String format) throws ImageExporterException {
        ParameterCheck.checkEmptyList("components", components);
        ParameterCheck.checkEmptyList("outputStreams", outputStreams);
        ParameterCheck.checkNullEmpty("format", format);

        if (components.size() != outputStreams.size()) {
            throw new IllegalArgumentException("components and outputStreams should have the same sizes");
        }

        //retrieves an exporter supporting the given format
        JComponentImageExporter exporter = this.exportersMap.get(format);

        if (exporter == null) {
            throw new IllegalArgumentException("unrecongized image format:" + format);
        }

        JComponent component;

        for (int i = 0; i < components.size(); i++) {
            component = components.get(i);
            jComponentVisibleMaker.makeVisible(component); //makes the component visible
            try {
                exporter.export(component, outputStreams.get(i), viewport, format);
            } finally {
                jComponentVisibleMaker.restoreVisibility(component); //restores the component's visibility
            }
        }
    }

    /**
     * Helper method to close the list of OutputStreams.
     *
     * @param outputStreams the OutputStreams to be closed
     */
    private static void closeOutputStreams(List<OutputStream> outputStreams) {
        for (Iterator<OutputStream> iter = outputStreams.iterator(); iter.hasNext();) {
            try {
                iter.next().close();
            } catch (IOException e) {
                //ignores this
            }
        }
    }

    /**
     * Helper method to delete the list of files. If export is failed, all generated files should be cleared
     * by this method.
     *
     * @param files the files to be deleted
     */
    private static void deleteFiles(List<File> files) {
        for (Iterator<File> iter = files.iterator(); iter.hasNext();) {
            iter.next().delete();
        }
    }

    /**
     * Reading from config to create the JComponentVisibleMaker for this exporter facade. If it's not
     * configured, default DefaultVisibleMaker will be used.
     *
     * @param namespace the namespace to read the config
     * @param objectFactory objectFactory to create the JComponentVisibleMaker instance
     *
     * @return JComponentVisibleMaker instance of JComponentVisibleMaker
     *
     * @throws ImageExporterConfigurationException if the config is invalid
     */
    private JComponentVisibleMaker initVisibleMaker(String namespace, ObjectFactory objectFactory)
        throws ImageExporterConfigurationException {
        String visibleMakerKey = ConfigHelper.getStringProperty(namespace, JCOMPONENT_VISIBLE_MAKER_PARAMETER);

        //customized visibleMaker is configured
        if ((visibleMakerKey != null)) {

            //key should not be empty
            if (visibleMakerKey.trim().length() == 0) {
                throw new ImageExporterConfigurationException("property:" + JCOMPONENT_VISIBLE_MAKER_PARAMETER
                        + " is empty");
            }

            //if objectFactory is not created, then create one
            if (objectFactory == null) {
                objectFactory = ConfigHelper.createObjectFactory(namespace, OBJECT_FACTORY_NAMESPACE_PARAMETER);
            }

            try {
                return (JComponentVisibleMaker) objectFactory.createObject(visibleMakerKey);
            } catch (InvalidClassSpecificationException e) {
                throw new ImageExporterConfigurationException("can not create JComponentVisibleMaker:"
                        + visibleMakerKey, e);
            } catch (ClassCastException e) {
                throw new ImageExporterConfigurationException("exporter:" + visibleMakerKey
                        + " is not sub class of JComponentImageExporter", e);
            }
        } else {
            //uses DefaultVisibleMaker by default
            return new DefaultVisibleMaker();
        }
    }

    /**
     * Registers custom exporters to this exporter facade, given with objectFactory and keys. Specified
     * JComponentImageExporters will be created by ObjectFactory and then be registered.
     *
     * @param objectFactory the ObjectFactory to create the instance
     * @param exporterKeys the object factory keys for creating the JComponentImageExporter instances
     *
     * @throws ImageExporterConfigurationException if any error occurs while creating the instance
     */
    private void registerCustomExporters(ObjectFactory objectFactory, String[] exporterKeys)
        throws ImageExporterConfigurationException {
        for (int i = 0; i < exporterKeys.length; i++) {
            String key = exporterKeys[i];

            //key should not be empty string
            if (key.trim().length() == 0) {
                throw new ImageExporterConfigurationException("property:" + EXPORTERS_PARAMETER
                        + " not allows empty string");
            }

            JComponentImageExporter exporter;

            try {
                exporter = (JComponentImageExporter) objectFactory.createObject(key);
            } catch (InvalidClassSpecificationException e) {
                throw new ImageExporterConfigurationException("can not create JComponentImageExporter:" + key, e);
            } catch (ClassCastException e) {
                throw new ImageExporterConfigurationException("exporter:" + key
                        + " is not sub class of JComponentImageExporter", e);
            }

            //registers the instance to this exporter facade
            registerExporter(exporter);
        }
    }

    /**
     * Register the given exporter to exportersMap by mapping it with its supporting image formats.
     *
     * @param exporter the exporter to be registered
     */
    private void registerExporter(JComponentImageExporter exporter) {
        String[] formats = exporter.getSupportedFormats();

        for (int i = 0; i < formats.length; i++) {
            this.exportersMap.put(formats[i], exporter);
        }
    }
}
