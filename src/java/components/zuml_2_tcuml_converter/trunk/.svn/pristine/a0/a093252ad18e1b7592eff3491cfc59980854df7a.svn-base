/*
 * Copyright (C) 2007 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.umltool.xmiconverters.poseidon5.converters;

import com.topcoder.umltool.xmiconverters.poseidon5.DefaultXMIConverter;
import com.topcoder.umltool.xmiconverters.poseidon5.Helper;
import com.topcoder.umltool.xmiconverters.poseidon5.XMIConverterChain;
import com.topcoder.umltool.xmiconverters.poseidon5.XMIConverterConfigurationException;

import com.topcoder.util.config.ConfigManager;
import com.topcoder.util.config.Property;
import com.topcoder.util.config.UnknownNamespaceException;

import com.topcoder.xmi.reader.XMIHandler;
import com.topcoder.xmi.reader.XMIReader;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;

import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;


/**
 * <p>
 * This converter is used to rename the elements in startElement and endElement method
 * so that the original handler for the elements can work. The elements need to rename
 * can be configured. This converter will rename the elements before calling the next
 * chain processsing.
 * </p>
 *
 * <p>Here is sample config:</p>
 * <p>&lt;Property name="ToRenameNames"&gt;</p>
 * <p>    &lt;Property name="UML2:TypedElement$type"&gt;</p>
 * <p>        &lt;Value&gt;UML:StructuralFeature.type&lt;/Value&gt;</p>
 * <p>    &lt;/Property&gt;</p>
 * <p>    &lt;Property name="UML:Class"&gt;</p>
 * <p>        &lt;Value&gt;UML:Classifier&lt;/Value&gt;</p>
 * <p>    &lt;/Property&gt;</p>
 * <p>    &lt;Property name="UML:DateType"&gt;</p>
 * <p>        &lt;Value&gt;UML:Classifier&lt;/Value&gt;</p>
 * <p>    &lt;/Property&gt;</p>
 * <p>&lt;/Property&gt;</p>
 *
 * <p>
 * <strong>Thread safety:</strong>
 * This class is stateless and immutable.
 * </p>
 *
 * @author TCSDESIGNER, TCSDEVELOPER
 * @version 1.0
 */
public class RenameConverter extends DefaultXMIConverter {
    /**
     * <p>
     * The constant represents the default namespace to configure this converter.
     * The name-to-name pairs will be in the namespace of ConfigManager.
     * </p>
     */
    public static final String DEFAULT_NAMESPACE = "com.topcoder.umltool.xmiconverters.poseidon5";

    /**
     * <p>The property name of configuration item for RenameConverter.</p>
     */
    private static final String TO_RENAME_NAMES = "ToRenameNames";

    /**
     * <p>
     * The name-to-name pairs. The key is the name in zuml file, the value is the
     * name in tcuml file. It is initialized in the constructor and never be changed.
     * It can not be null. can be empty. It is used by startElement, endElement methods.
     * </p>
     */
    private final Map<String, String> toRenameNames = new HashMap<String, String>();

    /**
     * <p>Construct this converter with default namespace.</p>
     *
     * @throws XMIConverterConfigurationException if fails to construct this converter
     */
    public RenameConverter() throws XMIConverterConfigurationException {
        this(DEFAULT_NAMESPACE);
    }

    /**
     * <p>
     * Construct this converter with the given namespace. It will read configuration
     * items from ToRenameNames property.
     * </p>
     *
     * @param nameSpace the namespace to configure this converter
     * @throws IllegalArgumentException if nameSpace is null or empty
     * @throws XMIConverterConfigurationException if fails to construct this converter
     */
    public RenameConverter(String nameSpace)
        throws XMIConverterConfigurationException {
        Helper.checkString(nameSpace, "nameSpace");

        ConfigManager manager = ConfigManager.getInstance();

        try {
            //Get the property of toRenameNames
            Property property = manager.getPropertyObject(nameSpace,
                    TO_RENAME_NAMES);

            if (property != null) {
                Enumeration en = property.propertyNames();

                while (en.hasMoreElements()) {
                    String name = (String) en.nextElement();

                    Property map = property.getProperty(name);

                    //Each property should has only one value
                    if ((map.getValue() == null) ||
                            (map.getValues().length != 1)) {
                        throw new XMIConverterConfigurationException(
                            "There are errors in RenameConverter's configuration.");
                    }

                    //The ConfigManager cannot read property name with '.'
                    //Here, use '$' in the config file instead of '.', and change back here
                    toRenameNames.put(name.trim().replace('$', '.'),
                        map.getValue().trim());
                }
            }
        } catch (UnknownNamespaceException e) {
            throw new XMIConverterConfigurationException("The nameSpace '" +
                nameSpace + "' doesn't exist.", e);
        }
    }

    /**
     * <p>
     * This method is used to rename the localName and qName if the element matched
     * with toRenameNames keys before the handler processing it.
     * </p>
     *
     * <p>For example:</p>
     * <p>
     * If "UML2:TypedElement.type" - "UML:StructuralFeature.type" is in the toRenameNames,
     * and the handler is for "UML:Class", all the "UML2:TypedElement.type" element will be
     * renamed to "UML:StructuralFeature.type" when the "UML:Class" handler processing the
     * elements.
     * </p>
     *
     * @param uri
     *        the Namespace URI, or the empty string if the element has no Namespace URI
     *        or if Namespace processing is not being performed
     * @param localName
     *        the local name (without prefix), or the empty string if Namespace processing is not being performed
     * @param qName
     *        the qualified name (with prefix), or the empty string if qualified names are not available
     * @param attrs
     *        the attributes attached to the element. If there are no attributes,
     *        it shall be an empty Attributes object. The value of this object after startElement returns is undefined
     * @param chain the next chain of the chains of converters
     * @param reader the XMIReader instance firing this callback
     * @param handler the XMIHandler instance this converter added to
     * @throws SAXException if any error occurs in this method
     */
    public void startElement(String uri, String localName, String qName,
        Attributes attrs, XMIConverterChain chain, XMIReader reader,
        XMIHandler handler) throws SAXException {
        String elementName = ((qName != null) && (qName.trim().length() > 0))
            ? qName : localName;

        if (toRenameNames.containsKey(elementName)) {
            chain.startElement(uri, toRenameNames.get(elementName),
                toRenameNames.get(elementName), attrs, reader, handler);
        } else {
            chain.startElement(uri, localName, qName, attrs, reader, handler);
        }
    }

    /**
     * <p>
     * This method is used to rename the localName and qName if the element matched
     * with toRenameNames keys before the handler processing it.
     * </p>
     *
     * <p>For example:</p>
     * <p>
     * If "UML2:TypedElement.type" - "UML:StructuralFeature.type" is in the toRenameNames,
     * and the handler is for "UML:Class", all the "UML2:TypedElement.type" element will
     * be renamed to "UML:StructuralFeature.type" when the "UML:Class" handler processing
     * the elements.
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
        String elementName = ((qName != null) && (qName.trim().length() > 0))
            ? qName : localName;

        if (toRenameNames.containsKey(elementName)) {
            chain.endElement(uri, toRenameNames.get(elementName),
                toRenameNames.get(elementName), reader, handler);
        } else {
            chain.endElement(uri, localName, qName, reader, handler);
        }
    }
}
