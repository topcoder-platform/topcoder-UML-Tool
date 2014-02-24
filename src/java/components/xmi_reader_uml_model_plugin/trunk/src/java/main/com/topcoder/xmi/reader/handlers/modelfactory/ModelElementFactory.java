/*
 * Copyright (C) 2006 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.xmi.reader.handlers.modelfactory;

import java.util.HashMap;
import java.util.Map;

import com.topcoder.util.config.ConfigManager;
import com.topcoder.util.config.Property;
import com.topcoder.util.config.UnknownNamespaceException;

/**
 * <p>
 * This is a configurable factory, which creates Diagram Interchange class instances based on a mapping
 * from xml element name to a class name of the diagram that currently represents it.
 * </p>
 *
 * <p>
 * Sample configuration:
 * &lt;Property name=&quot;xml_to_element_mapping&quot;&gt;
 *   &lt;Value&gt;UML:Property,com.topcoder.diagraminterchange.Property&lt;/Value&gt;
 *   &lt;Value&gt;UML:Reference,com.topcoder.diagraminterchange.Reference&lt;/Value&gt;
 *   &lt;Value&gt;UML:DiagramLink,com.topcoder.diagraminterchange.DiagramLink&lt;/Value&gt;
 *   &lt;Value&gt;UML:GraphConnector,com.topcoder.diagraminterchange.GraphConnector&lt;/Value&gt;
 *   &lt;Value&gt;UML:GraphEdge,com.topcoder.diagraminterchange.GraphEdge&lt;/Value&gt;
 *   &lt;Value&gt;UML:Point,com.topcoder.diagraminterchange.Point&lt;/Value&gt;
 *   &lt;Value&gt;UML:BezierPoint,com.topcoder.diagraminterchange.BezierPoint&lt;/Value&gt;
 *   &lt;Value&gt;UML:Dimension,com.topcoder.diagraminterchange.Dimension&lt;/Value&gt;
 *   &lt;Value&gt;UML:Polyline,com.topcoder.diagraminterchange.Polyline&lt;/Value&gt;
 *   &lt;Value&gt;UML:TextElement,com.topcoder.diagraminterchange.TextElement&lt;/Value&gt;
 *   &lt;Value&gt;UML:Image,com.topcoder.diagraminterchange.Image&lt;/Value&gt;
 *   &lt;Value&gt;UML:CoreSemanticModelBridge,com.topcoder.diagraminterchange.CoreSemanticModelBridge&lt;/Value&gt;
 *   &lt;Value&gt;UML:Uml1SemanticModelBridge,com.topcoder.diagraminterchange.Uml1SemanticModelBridge&lt;/Value&gt;
 *   &lt;Value&gt;UML:SimpleSemanticModelElement,
 *   com.topcoder.diagraminterchange.SimpleSemanticModelElement&lt;/Value&gt;
 *   &lt;Value&gt;UML:GraphNode,com.topcoder.diagraminterchange.GraphNode&lt;/Value&gt;
 *   &lt;Value&gt;UML:Diagram,com.topcoder.diagraminterchange.Diagram&lt;/Value&gt;
 * &lt;/Property&gt;
 * </p>
 *
 * <p>
 * Thread Safety : This implementation is thread-safe.
 * Even though it is not anticipated that many thread will be hitting the handler, it was
 * decided that it might be worthwhile to have a single copy of the factory (to save memory
 * and configuration read time). Synchronization is done in a block to minimize performance
 * impact.
 * </p>
 *
 * @author AleaActaEst, biotrail
 * @version 1.0
 */
public class ModelElementFactory {
    /**
     * <p>
     * Represents the <b>xml_to_element_mapping</b> element name in the configuration file.
     * </p>
     */
    private static final String XML_TO_ELEMENT_MAPPING = "xml_to_element_mapping";

    /**
     * <p>
     * Represents a mapping of xml elements in xmi format to class names for
     * the corresponding model elements.
     * </p>
     *
     * <p>
     * Note, the mapping is as follows:
     * <b>uml_element, model_element_classname</b>
     * As an example would have the following set up:
     * <ul>
     * <li>"UML:Diagram",  "com.topcoder.diagraminterchange.Diagram"</li>
     * <li>"UML:DiagramLink",  "com.topcoder.diagraminterchange.DiagramLink"</li>
     * <li>"UML:BezierPoint",  "com.topcoder.diagraminterchange.BezierPoint"</li>
     * </ul>
     * </p>
     *
     * <p>
     * This is initialized through the first constructor to an empty hash map, is set either
     * in the second constructor through configuration factory, or through the addMapping
     * method in the API. Values of this map are mutable and can be accessed through
     * xxxMapping(s) methods.
     * </p>
     */
    private final Map<String, String> xmlElementToModelElementMap = new HashMap<String, String>();

    /**
     * <p>
     * Creates an empty instance of the class.
     * </p>
     */
    public ModelElementFactory() {
        // empty
    }

    /**
     * <p>
     * Creates an instance of this class initialized with configuration data
     * for the mapping of xml elements to class names.
     * </p>
     *
     * @param namespace configuration namespace
     *
     * @throws IllegalArgumentException if the namespace is null or empty
     * @throws ConfigurationException if there were any issues with configuration
     */
    public ModelElementFactory(String namespace) throws ConfigurationException {
        checkString(namespace, "namespace");

        Property property;

        // Get values with the given namespace and propertyName
        try {
            property = ConfigManager.getInstance().getPropertyObject(namespace, XML_TO_ELEMENT_MAPPING);
        } catch (UnknownNamespaceException e) {
            throw new ConfigurationException("UnknownNamespaceException occurs when accessing ConfigManager.", e);
        }

        // property were missed
        if (property == null) {
            throw new ConfigurationException("Missing property: " + XML_TO_ELEMENT_MAPPING);
        }

        String[] values = property.getValues();

        // values were missed
        if (values == null) {
            throw new ConfigurationException("Missing values: " + XML_TO_ELEMENT_MAPPING);
        }

        // values exist but contain empty value, xml element name or class name did not exist
        for (int i = 0; i < values.length; i++) {
            if (values[i].trim().length() == 0) {
                throw new ConfigurationException(XML_TO_ELEMENT_MAPPING + " contains empty string value.");
            }

            String[] tokens = values[i].split(",");
            if (tokens.length != 2) {
                throw new ConfigurationException(
                    "The values did not followed the expect format[xml element name ,  class name]");
            }
            if (tokens[0].trim().length() == 0) {
                throw new ConfigurationException("The xml element name does not exist.");
            }
            if (tokens[1].trim().length() == 0) {
                throw new ConfigurationException("The class name for xml element " + tokens[0] + " does not exist.");
            }

            xmlElementToModelElementMap.put(tokens[0].trim(), tokens[1].trim());
        }
    }

    /**
     * <p>
     * Adds a new mapping to the class.
     * </p>
     *
     * <p>
     * Note, if the key(xmlElement) already exists in the xmlElementToModelElementMap,
     * simply replace the current value with the new one.
     * </p>
     *
     * @param xmlElement name of the UML tag to be used as a key to map
     * to a specific class implementation name
     * @param className The name of the class which will be used to
     * create an instance for the xmlElement
     *
     * @throws IllegalArgumentException if the xmlElement or className
     *  is null or empty
     */
    public void addMapping(String xmlElement, String className) {
        checkString(xmlElement, "xmlElement");
        checkString(className, "className");

        synchronized (this.xmlElementToModelElementMap) {
            xmlElementToModelElementMap.put(xmlElement, className);
        }
    }

    /**
     * <p>
     * Gets the class name for the given xml element.
     * </p>
     *
     * @param xmlElement xml element mapping value that are looking for
     * @return class name associated with this xml element
     *
     * @throws IllegalArgumentException if the xmlElement is null or empty
     */
    public String getMapping(String xmlElement) {
        checkString(xmlElement, "xmlElement");

        synchronized (this.xmlElementToModelElementMap) {
            return xmlElementToModelElementMap.get(xmlElement);
        }
    }

    /**
     * <p>
     * Return the complete mapping.
     * </p>
     *
     * <p>
     * Note, it returns a shallow copy of the Map.
     * </p>
     *
     * @return copy of the xml element to element model map
     */
    public Map<String, String> getAllMappings() {
        synchronized (this.xmlElementToModelElementMap) {
            return new HashMap<String, String>(xmlElementToModelElementMap);
        }
    }

    /**
     * <p>
     * Remove the xml element mapping.
     * </p>
     *
     * <p>
     * Note, if the element is not found do nothing.
     * </p>
     *
     * @param xmlElement xml element mapping value that are going to remove
     *
     * @throws IllegalArgumentException if the xmlElement is null or empty
     */
    public void removeMapping(String xmlElement) {
        checkString(xmlElement, "xmlElement");

        synchronized (this.xmlElementToModelElementMap) {
            xmlElementToModelElementMap.remove(xmlElement);
        }
    }

    /**
     * <p>
     * The heart of this component. Creates an actual instance of the class
     * which maps to the specific xml element.
     * </P>
     *
     * <p>
     * Note, if the mapping is not found then a null is returned.
     * </p>
     *
     * @param xmlElement xml element mapping value that are going to
     * use to create an instance
     * @return new instance of the mapped element or null if not found
     *
     * @throws IllegalArgumentException if the xmlElement is null or empty
     * @throws ElementCreationException if there are any issues when creating the object
     */
    public Object createModelElement(String xmlElement) throws ElementCreationException {
        checkString(xmlElement, "xmlElement");

        String className = null;

        // Get the class name
        synchronized (this.xmlElementToModelElementMap) {
            className = xmlElementToModelElementMap.get(xmlElement);
        }

        // The class name is not found
        if (className == null) {
            return null;
        }

        // Create an actual instance
        try {
            return Class.forName(className).newInstance();
        } catch (InstantiationException e) {
            throw new ElementCreationException("InstantiationException occurs "
                + "when creating the requested instance.", e);
        } catch (IllegalAccessException e) {
            throw new ElementCreationException("IllegalAccessException occurs "
                + "when creating the requested instance.", e);
        } catch (ClassNotFoundException e) {
            throw new ElementCreationException("ClassNotFoundException occurs "
                + "when creating the requested instance.", e);
        }
    }

    /**
     * <p>
     * Checks whether the given String is null or empty.
     * </p>
     *
     * @param arg the String to check
     * @param name the name of the String argument to check
     *
     * @throws IllegalArgumentException if the given string is null or empty
     */
     private void checkString(String arg, String name) {
         if (arg == null) {
             throw new IllegalArgumentException(name + " must not be null");
         }

        if (arg.trim().length() == 0) {
            throw new IllegalArgumentException(name + " should not be empty.");
        }
    }
}
