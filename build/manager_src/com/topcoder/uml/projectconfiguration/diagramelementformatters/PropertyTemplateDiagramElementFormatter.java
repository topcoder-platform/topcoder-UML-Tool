/*
 * Copyright (C) 2006 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.uml.projectconfiguration.diagramelementformatters;

import java.util.Collection;
import java.util.Enumeration;

import com.topcoder.diagraminterchange.DiagramElement;
import com.topcoder.uml.projectconfiguration.InitialDiagramElementFormatter;
import com.topcoder.uml.projectconfiguration.ProjectConfigurationException;
import com.topcoder.uml.projectconfiguration.Util;
import com.topcoder.util.config.ConfigManager;
import com.topcoder.util.config.Property;
import com.topcoder.util.config.UnknownNamespaceException;

/**
 * <p>
 * This formatter will add Property instances to the diagram element.
 * </p>
 *
 * <p>
 * Note, it will be created by the client application directly. And it will
 * be registered to the project configuration manager to perform formatting.
 * The project configuration manager will call format() to perform formatting.
 * </p>
 *
 * <p>
 * Sample Configuration :
 * &lt;Property name=&quot;com.topcoder.diagraminterchange.Reference&quot;&gt;
 *     &lt;Property name=&quot;property1&quot;&gt;
 *         &lt;Value&gt;value1&lt;/Value&gt;
 *         &lt;/Property&gt;
 *     &lt;Property name=&quot;property2&quot;&gt;
 *         &lt;Value&gt;value2&lt;/Value&gt;
 *     &lt;/Property&gt;
 * &lt;/Property&gt;
 *
 * &lt;Property name=&quot;com.topcoder.diagraminterchange.GraphNode&quot;&gt;
 *     &lt;Property name=&quot;property1&quot;&gt;
 *         &lt;Value&gt;value1&lt;/Value&gt;
 *    &lt;/Property&gt;
 * &lt;/Property&gt;
 * </p>
 *
 * <p>
 * Thread Safety : This class is immutable and so is thread safe.
 * </p>
 *
 * @author kinzz, biotrail
 * @version 1.0
 */
public class PropertyTemplateDiagramElementFormatter implements InitialDiagramElementFormatter {
    /**
     * <p>
     * Represents the namespace used by this formatter.
     * </p>
     *
     * <p>
     * This variable is set in the constructor, is immutable (the reference)
     * and will never be null.
     * </p>
     *
     * <p>
     * This variable is referenced in the format method.
     * </p>
     *
     */
    private final String namespace;

    /**
     * <p>
     * Constructs the formatter with the class name as the namespace.
     * </p>
     *
     */
    public PropertyTemplateDiagramElementFormatter() {
        this(PropertyTemplateDiagramElementFormatter.class.getName());
    }

    /**
     * <p>
     * Constructs the formatter with the given namespace.
     * </p>
     *
     * @param namespace the non null, non empty namespace used by this formatter.
     *
     * @throws IllegalArgumentException if the namespace is null or empty.
     */
    public PropertyTemplateDiagramElementFormatter(String namespace) {
        Util.checkString(namespace, "namespace");
        this.namespace = namespace;
    }

    /**
     * <p>
     * This formatter will add Property instances to the diagram element according to the XML file.
     * </p>
     *
     * @param element the non null element to be formatted
     * @return true if the passed in diagram element was modified, otherwise false.
     *
     * @throws IllegalArgumentException if the element is null
     * @throws ProjectConfigurationException if any exception occurs during configuration
     */
    public boolean format(DiagramElement element) throws ProjectConfigurationException {
        Util.checkNull(element, "element");

        // flag used to represent the DiagramElemment state, whether is modified or not
        boolean isModified = false;

        //Get the elementProperty with given namespace and propertyName
        Property elementProperty = null;

        try {
            elementProperty = ConfigManager.getInstance().getPropertyObject(namespace, element.getClass().getName());
        } catch (UnknownNamespaceException e) {
            throw new ProjectConfigurationException("Unknown namespace: " + namespace, e);
        }

        // elementProperty is missed
        if (elementProperty == null) {
            throw new ProjectConfigurationException("Missed property: " + element.getClass().getName());
        }

        Enumeration namesEnum = elementProperty.propertyNames();
        while (namesEnum.hasMoreElements()) {
            String propName = (String) namesEnum.nextElement();
            String value = elementProperty.getValue(propName);

            //Create a property with the propName as the key and the value as the value.
            com.topcoder.diagraminterchange.Property elementProp = new com.topcoder.diagraminterchange.Property();
            elementProp.setKey(propName);
            elementProp.setValue(value);

            boolean isContained = false;
            Collection<com.topcoder.diagraminterchange.Property> props = element.getProperties();
            for (com.topcoder.diagraminterchange.Property prop : props) {
                if (prop.getKey().equals(propName) && prop.getValue().equals(value)) {
                    isContained = true;
                }
            }

            if (!isContained) {
                element.addProperty(elementProp);
                isModified = true;
            }
        }

        // return true if the diagram element is modified, false otherwise
        return isModified;
    }
}
