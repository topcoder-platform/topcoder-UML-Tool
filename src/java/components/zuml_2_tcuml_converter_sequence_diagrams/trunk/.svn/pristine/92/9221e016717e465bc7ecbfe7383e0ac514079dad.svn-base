/*
 * Copyright (C) 2007 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.umltool.xmiconverters.poseidon5.converters;

import com.topcoder.diagraminterchange.Diagram;

import com.topcoder.umltool.xmiconverters.poseidon5.DefaultXMIConverter;
import com.topcoder.umltool.xmiconverters.poseidon5.Helper;
import com.topcoder.umltool.xmiconverters.poseidon5.XMIConverterChain;
import com.topcoder.umltool.xmiconverters.poseidon5.XMIConverterConfigurationException;
import com.topcoder.umltool.xmiconverters.poseidon5.XMIConvertersUtil;

import com.topcoder.util.config.ConfigManager;
import com.topcoder.util.config.Property;
import com.topcoder.util.config.UnknownNamespaceException;

import com.topcoder.xmi.reader.XMIHandler;
import com.topcoder.xmi.reader.XMIReader;

import org.xml.sax.SAXException;

import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;


/**
 * <p>
 * This converter is used to convert the title node of Diagram when the &lt;UML:Diagram&gt; element ended,
 * it will use the util methods in XMIConverterUtil class to convert the title node. If the
 * convertToTextElement is false, the title node will be just removed, otherwise, the title node will be
 * converted to text node with the title text displayed in Poseidon unchanged and with the configured properties.
 * To adjust the size of diagram correctly, this converter should be added to the chains before the
 * DiagramSizeConverter, because the title of diagram may be removed.
 * </p>
 *
 * <p>
 * <strong>Thread safety:</strong>
 * This class is stateless and immutable.
 * </p>
 *
 * @author TCSDESIGNER, TCSDEVELOPER
 * @version 1.0
 */
public class DiagramTitleConverter extends DefaultXMIConverter {
    /**
     * <p>
     * The constant represents the default namespace to configure this converter. The convertToTextElement
     * and default properties for text node will be in the namespace of ConfigManager.
     * </p>
     */
    public static final String DEFAULT_NAMESPACE = "com.topcoder.umltool.xmiconverters.poseidon5";

    /**
     * <p>The qname of Diagram element.</p>
     */
    private static final String DIAGRAM_QNAME = "UML:Diagram";

    /**
     * <p>The config property name for convertToTextElement.</p>
     */
    private static final String CONVERT = "ConvertDiagramTitleToTextElement";

    /**
     * <p>The config property name for textElementProperties.</p>
     */
    private static final String TEXTPROPERTIES = "DefaultTextElementProperties";

    /**
     * <p>
     * Whether to convert the title node in diagram in zuml to text node, true to convert.
     * It is initialized in the constructor and never be changed. It is used by endElement
     * methods.
     * </p>
     */
    private final boolean convertToTextElement;

    /**
     * <p>
     * The key-to-value pairs. The key is the key of default properties for converted text node,
     * the value is the value of default properties for converted text node. It is initialized
     * in the constructor and never be changed. It can not be null. can be empty. It is used by
     * endElement methods.
     * </p>
     */
    private final Map<String, String> textElementProperties = new HashMap<String, String>();

    /**
     * <p>
     * Construct this converter with the given namespace.
     * </p>
     *
     * @param nameSpace the namespace to configure this converter
     * @throws IllegalArgumentException if nameSpace is null or empty
     * @throws XMIConverterConfigurationException if fails to construct this converter
     */
    public DiagramTitleConverter(String nameSpace)
        throws XMIConverterConfigurationException {
        Helper.checkString(nameSpace, "nameSpace");

        ConfigManager manager = ConfigManager.getInstance();

        try {
            Property property = manager.getPropertyObject(nameSpace, CONVERT);

            if ((property != null) && (property.getValue() != null)) {
                //It should be false or true
                convertToTextElement = Boolean.parseBoolean(property.getValue()
                                                                    .trim());
            } else {
                //If not configured, using false as default
                convertToTextElement = false;
            }

            Property props = manager.getPropertyObject(nameSpace, TEXTPROPERTIES);

            if (props != null) {
                Enumeration en = props.propertyNames();

                while (en.hasMoreElements()) {
                    String name = (String) en.nextElement();
                    Property prop = props.getProperty(name);

                    //One property only should have one value
                    if ((prop.getValue() == null) ||
                            (prop.getValues().length != 1)) {
                        throw new XMIConverterConfigurationException(
                            "There are errors in DiagramTitleConverter's configuration.");
                    }

                    textElementProperties.put(name.trim(),
                        prop.getValue().trim());
                }
            }
        } catch (UnknownNamespaceException e) {
            throw new XMIConverterConfigurationException("There are errors in DiagramTitleConverter's configuration.",
                e);
        }
    }

    /**
     * <p>Construct this converter with default namespace.</p>
     *
     * @throws XMIConverterConfigurationException if fails to construct this converter
     */
    public DiagramTitleConverter() throws XMIConverterConfigurationException {
        this(DEFAULT_NAMESPACE);
    }

    /**
     * <p>
     * This method is used to convert the title node of Diagram when the &lt;UML:Diagram&gt; element ended,
     * it will use the util methods in XMIConverterUtil class to convert the title node. If the
     * convertToTextElement is false, the title node will be just removed, otherwise, the title node will
     * be converted to text node with the title text displayed in Poseidon unchanged and with the configured
     * properties.
     * </p>
     *
     * @param uri
     *        the Namespace URI, or the empty string if the element has no Namespace URI
     *        or if Namespace processing is not being performed
     * @param localName
     *        the local name (without prefix), or the empty string if Namespace processing is not being performed
     * @param qName
     *        the qualified XML name (with prefix), or the empty string if qualified names are not available
     * @param chain the next chain of the chains of converters
     * @param reader the XMIReader instance firing this callback
     * @param handler the XMIHandler instance this converter added to
     * @throws SAXException if any error occurs in this method
     */
    public void endElement(String uri, String localName, String qName,
        XMIConverterChain chain, XMIReader reader, XMIHandler handler)
        throws SAXException {
        //Save the diagram object, as the last ref object maybe set to null in the later chain
        Object obj = handler.getLastRefObject();

        chain.endElement(uri, localName, qName, reader, handler);

        String elementName = ((qName != null) && (qName.trim().length() > 0))
            ? qName : localName;

        if (DIAGRAM_QNAME.equals(elementName)) {
            Diagram diagram = (Diagram) obj;

            if (convertToTextElement) {
                XMIConvertersUtil.convertDiagramTitleToText(diagram,
                    textElementProperties);
            } else {
                XMIConvertersUtil.removeDiagramTitle(diagram);
            }
        }
    }
}
