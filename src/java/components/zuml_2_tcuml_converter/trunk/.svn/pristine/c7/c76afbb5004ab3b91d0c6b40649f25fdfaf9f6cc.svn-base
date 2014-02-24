/*
 * Copyright (C) 2007 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.umltool.xmiconverters.poseidon5.converters;

import com.topcoder.diagraminterchange.Diagram;

import com.topcoder.umltool.xmiconverters.poseidon5.DefaultXMIConverter;
import com.topcoder.umltool.xmiconverters.poseidon5.Helper;
import com.topcoder.umltool.xmiconverters.poseidon5.PropertyValueTransformer;
import com.topcoder.umltool.xmiconverters.poseidon5.XMIConverterChain;
import com.topcoder.umltool.xmiconverters.poseidon5.XMIConverterConfigurationException;
import com.topcoder.umltool.xmiconverters.poseidon5.XMIConvertersUtil;

import com.topcoder.util.config.ConfigManager;
import com.topcoder.util.config.Property;
import com.topcoder.util.config.UnknownNamespaceException;
import com.topcoder.util.objectfactory.InvalidClassSpecificationException;
import com.topcoder.util.objectfactory.ObjectFactory;
import com.topcoder.util.objectfactory.impl.ConfigManagerSpecificationFactory;
import com.topcoder.util.objectfactory.impl.IllegalReferenceException;
import com.topcoder.util.objectfactory.impl.SpecificationConfigurationException;

import com.topcoder.xmi.reader.XMIHandler;
import com.topcoder.xmi.reader.XMIReader;

import org.xml.sax.SAXException;

import java.util.ArrayList;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


/**
 * <p>
 * This converter is used to convert the properties of Diagram and contained elements when the
 * &lt;UML:Diagram&gt; element ended, it will use the util methods in XMIConverterUtil class
 * to convert the properties. The converter will be configured with the key-to-key pairs. If a
 * pair of keys is ('fill', 'FILL_COLOR'), it will replace the property ('fill', '#0000000')
 * with ('FILL_COLOR', '#0000000'). This is needed because the properties of the graph nodes
 * from the .zuml have the same meaning as those from .tcuml, only different keys or different
 * format for the values.
 * </p>
 *
 * <p>
 * This converter will also be configured by a list of property value transformers, the transformers
 * will transform the value of matched property. The properties in the daigram will be replaced/transformed
 * recursively for all the contained diagram elements. It uses the util methods in XMIConverterUtil
 * classes to replace keys and transform values.
 * </p>
 *
 * <p>Here is sample config:</p>
 *
 * <p>&lt;Property name="ObjectFactoryNamespace"&gt;</p>
 * <p>    &lt;Value&gt;object_factory_namespace&lt;/Value&gt;</p>
 * <p>&lt;/Property&gt;</p>
 * <p>&lt;Property name="PropertyValueTransformers"&gt;</p>
 * <p>    &lt;Value&gt;transformer&lt;/Value&gt;</p>
 * <p>&lt;/Property&gt;</p>
 * <p>&lt;Property name="ToReplacePropertyKeys"&gt;</p>
 * <p>    &lt;Property name="fill"&gt;</p>
 * <p>        &lt;Value&gt;FILL_COLOR&lt;/Value&gt;</p>
 * <p>    &lt;/Property&gt;</p>
 * <p>    &lt;Property name="font-color"&gt;</p>
 * <p>        &lt;Value&gt;FONT_COLOR&lt;/Value&gt;</p>
 * <p>    &lt;/Property&gt;</p>
 * <p>&lt;/Property&gt;</p>
 * <p>Note: The value for PropertyValueTransformers are keys in the object factory's config.</p>
 *
 * <p>
 * <strong>Thread safety: </strong>
 * This class is stateless and immutable.
 * </p>
 *
 * @author TCSDESIGNER, TCSDEVELOPER
 * @version 1.0
 */
public class GraphPropertiesConverter extends DefaultXMIConverter {
    /**
     * <p>
     * The constant represents the default namespace to configure this converter. The key-to-key pairs
     * and the transformers ObjectFactory names will be in the namespace of ConfigManager.
     * </p>
     */
    public static final String DEFAULT_NAMESPACE = "com.topcoder.umltool.xmiconverters.poseidon5";

    /**
     * <p>The qname for diagram element.</p>
     */
    public static final String DIAGRAM_QNAME = "UML:Diagram";

    /**
     * <p>The property name of toReplacePropertyKeys in the configuration file.</p>
     */
    private static final String TO_REPLACE_PROPERTY_KEYS = "ToReplacePropertyKeys";

    /**
     * <p>The property name of object factory in the configuration file.</p>
     */
    private static final String OBJECT_FACTORY = "ObjectFactoryNamespace";

    /**
     * <p>The property name of transformers in the configuration file.</p>
     */
    private static final String TRANSFORMERS = "PropertyValueTransformers";

    /**
     * <p>
     * The key-to-key pairs. The key is the properties' keys in diagram elements in zuml file, the value
     * is the properties' keys in tcuml file. It is initialized in the constructor and never be changed.
     * It can not be null. can be empty. It is used by endElement methods.
     * </p>
     */
    private final Map<String, String> toReplacePropertyKeys = new HashMap<String, String>();

    /**
     * <p>
     * The the transformers list to transform the matched properties' values. It is initialized in the
     * constructor and never be changed. It can not be null. can be empty. It is used by endElement methods.
     * </p>
     */
    private final List<PropertyValueTransformer> transformers = new ArrayList<PropertyValueTransformer>();

    /**
     * <p>
     * Construct this converter with the given namespace. It will first initialize the toReplacePropertyKeys
     * from 'ToReplacePropertyKeys' item, each property should have only one value. Then, it will use the config
     * item 'ObjectFactoryNamespace' to create Object Factory, this item is required. At the end, it will read
     * items from 'PropertyValueTransformers', the values are key:identifier in Object factory configuration.
     * Create transformers from object factory and then add them to the transformers list.
     * </p>
     *
     * @param nameSpace the namespace to configure this converter
     * @throws IllegalArgumentException if nameSpace is null or empty
     * @throws XMIConverterConfigurationException if fails to construct this converter
     */
    public GraphPropertiesConverter(String nameSpace)
        throws XMIConverterConfigurationException {
        Helper.checkString(nameSpace, "nameSpace");

        try {
            configToReplacePropertyKeys(nameSpace);

            ObjectFactory of = createObjectFactory(nameSpace);
            configTransformers(nameSpace, of);
        } catch (UnknownNamespaceException e) {
            throw new XMIConverterConfigurationException("The namespace '" +
                nameSpace + "' doesn't exist.", e);
        } catch (SpecificationConfigurationException e) {
            throw new XMIConverterConfigurationException("The namespace for object factory is wrong.",
                e);
        } catch (IllegalReferenceException e) {
            throw new XMIConverterConfigurationException("The namespace for object factory is wrong.",
                e);
        } catch (InvalidClassSpecificationException e) {
            throw new XMIConverterConfigurationException("Could not create specified object from object factory.",
                e);
        }
    }

    /**
     * <p>Construct this converter with default namespace.</p>
     * @throws XMIConverterConfigurationException if fails to construct this converter
     */
    public GraphPropertiesConverter() throws XMIConverterConfigurationException {
        this(DEFAULT_NAMESPACE);
    }

    /**
     * <p>
     * Initialize the toReplacePropertyKeys from configuration file. It will read properties
     * from ToReplacePropertyKeys item in nameSpace.
     * </p>
     *
     * @param nameSpace the namespace to get configuration information
     * @throws UnknownNamespaceException if the namespace doesn't exist
     * @throws XMIConverterConfigurationException if one property key have more than one values
     */
    private void configToReplacePropertyKeys(String nameSpace)
        throws UnknownNamespaceException, XMIConverterConfigurationException {
        Property property = ConfigManager.getInstance()
                                         .getPropertyObject(nameSpace,
                TO_REPLACE_PROPERTY_KEYS);

        if (property != null) {
            //Initialize the toReplacePropertyKeys from config
            Enumeration en = property.propertyNames();

            while (en.hasMoreElements()) {
                String name = (String) en.nextElement();
                Property prop = property.getProperty(name);

                if ((prop.getValue() == null) ||
                        (prop.getValues().length != 1)) {
                    throw new XMIConverterConfigurationException(
                        "There are errors in GraphPropertiesConverter's configuration.");
                }

                toReplacePropertyKeys.put(name.trim(), prop.getValue().trim());
            }
        }
    }

    /**
     * <p>
     * Get the keys in PropertyValueTransformers config item, and then using object factory to create
     * the transformers, and then add it to the transformer's list.
     * </p>
     *
     * @param nameSpace the namespace to get configuration items
     * @param of the object factory used to create transformers
     * @throws UnknownNamespaceException if the nameSpace doesn't exist
     * @throws XMIConverterConfigurationException if the keys are invalid format
     * @throws InvalidClassSpecificationException if the transformer's specification in object factory is wrong
     */
    private void configTransformers(String nameSpace, ObjectFactory of)
        throws UnknownNamespaceException, XMIConverterConfigurationException,
            InvalidClassSpecificationException {
        //The string value should be trimmed first
        Property property = ConfigManager.getInstance()
                                         .getPropertyObject(nameSpace,
                TRANSFORMERS);

        if (property != null) {
            for (String value : property.getValues()) {
                //Create the object from ObjectFactory using value as key
                Object obj = Helper.createObject(of, value);

                if (!(obj instanceof PropertyValueTransformer)) {
                    throw new XMIConverterConfigurationException(
                        "The transformer in object factory should implements interface PropertyValueTransformer.");
                }

                PropertyValueTransformer transformer = (PropertyValueTransformer) obj;
                transformers.add(transformer);
            }
        }
    }

    /**
     * <p>
     * Create Object Factory from the nameSpace's config item 'ObjectFactoryNamespace'.
     * </p>
     *
     * @param nameSpace the namespace of the configuration
     * @return the object factory instance
     * @throws UnknownNamespaceException if the namespace doesn't exist in the ConfigManager
     * @throws XMIConverterConfigurationException if the ObjectFactoryNamespace item doesn't exist
     * @throws SpecificationConfigurationException if the object factory's config has errors
     * @throws IllegalReferenceException if the object factory's config has errors
     */
    private ObjectFactory createObjectFactory(String nameSpace)
        throws UnknownNamespaceException, XMIConverterConfigurationException,
            SpecificationConfigurationException, IllegalReferenceException {
        Property property = ConfigManager.getInstance()
                                         .getPropertyObject(nameSpace,
                OBJECT_FACTORY);

        if ((property == null) || (property.getValue() == null)) {
            throw new XMIConverterConfigurationException(
                "The object factory's namespace should be specified.");
        }

        return new ObjectFactory(new ConfigManagerSpecificationFactory(
                property.getValue()));
    }

    /**
     * <p>
     * This method is used to convert the properties of Diagram and contained elements when the
     * &lt;UML:Diagram&gt; element ended, it will use the util methods in XMIConverterUtil class
     * to convert the properties.
     * </p>
     * <p>
     * The converter will be configured with the key-to-key pairs. If a pair of keys is
     * ('fill', 'FILL_COLOR'), it will replace the property ('fill', '#0000000') with
     * ('FILL_COLOR', '#0000000'). This is needed because the properties of the graph nodes
     * from the .zuml have the same meaning as those from .tcuml, only different keys or
     * different format for the values.
     * </p>
     * <p>
     * Note: the property values will be first transformed because the keys may be changed.
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
        //Save the object, as it maybe set to null in later chain
        Object obj = handler.getLastRefObject();

        //Transfer to next chain element
        chain.endElement(uri, localName, qName, reader, handler);

        String elementName = ((qName != null) && (qName.trim().length() > 0))
            ? qName : localName;

        if (DIAGRAM_QNAME.equals(elementName)) {
            Diagram diagram = (Diagram) obj;

            //Transform the properties
            if (transformers.size() > 0) {
                XMIConvertersUtil.transformPropertyValues(diagram, transformers);
            }

            //Replace the properties
            if (toReplacePropertyKeys.size() > 0) {
                XMIConvertersUtil.replacePropertyKeys(diagram,
                    toReplacePropertyKeys);
            }
        }
    }
}
