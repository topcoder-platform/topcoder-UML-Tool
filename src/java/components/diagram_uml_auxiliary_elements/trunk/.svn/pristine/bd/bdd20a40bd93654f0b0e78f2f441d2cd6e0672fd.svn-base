/*
 * Copyright (C) 2007 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.gui.diagramviewer.uml.auxiliaryelements;

import com.topcoder.util.config.ConfigManager;
import com.topcoder.util.config.UnknownNamespaceException;

import java.util.Map;
import java.util.Set;
import java.util.Enumeration;
import java.util.HashMap;


/**
 * <p>
 * This class contains the property mappings.
 * A property may have different key for the same meaning, because property names are not standardized.
 * This class maps a property name to an actual property key.
 * It can load such mappings from configuration.
 * </p>
 *
 * <p>
 * This class is used to separate property keys configuration from <code>Node</code> or <code>Edge</code>.
 * Because an application have same property keys configuration for all Nodes and Edges,
 * with this strategy, we only need to load configuration once.
 * It will be passed to <code>Node/Edge</code>'s constructor.
 * </p>
 *
 * <p>
 * This class needs configuration and here is a sample:
 * </p><p>
 * <pre>
 * &lt;CMConfig&gt;
 *   &lt;Config name="com.topcoder.gui.diagramviewer.uml.auxiliaryelements"&gt;
 *     &lt;Property name="StrokeColor"&gt;
 *       &lt;Value&gt;stroke_color&lt;/Value&gt;
 *     &lt;/Property&gt;
 *     &lt;Property name="FillColor"&gt;
 *       &lt;Value&gt;fillColor&lt;/Value&gt;
 *     &lt;/Property&gt;
 *     &lt;Property name="FontFamily"&gt;
 *       &lt;Value&gt;FontFamily&lt;/Value&gt;
 *     &lt;/Property&gt;
 *     &lt;Property name="FontSize"&gt;
 *       &lt;Value&gt;Font_Size&lt;/Value&gt;
 *     &lt;/Property&gt;
 *     &lt;Property name="FontColor"&gt;
 *       &lt;Value&gt;FontColorProperty&lt;/Value&gt;
 *     &lt;/Property&gt;
 *   &lt;/Config&gt;
 * &lt;/CMConfig&gt;
 * </pre>
 * </p>
 *
 * <p>
 * This class is mutable, and not thread safe.
 * </p>
 *
 * @author maone, TCSDEVELOPER
 * @version 1.0
 */
public class PropertyMapping {
    /**
     * <p>
     * The name used to retrieve stroke color property key.
     * Stroke color is used to draw the shape of nodes.
     * </p>
     */
    public static final String STROKE_COLOR = "StrokeColor";

    /**
     * <p>
     * The name used to retrieve fill color property key.
     * Fill color is used to fill the shape of nodes.
     * </p>
     */
    public static final String FILL_COLOR = "FillColor";

    /**
     * <p>
     * The name used to retrieve font family property key.
     * Font family will be used together with font size to determine the actual font.
     * </p>
     */
    public static final String FONT_FAMILY = "FontFamily";

    /**
     * <p>
     * The name used to retrieve font size property key.
     * Font family will be used together with font size to determine the actual font.
     * </p>
     */
    public static final String FONT_SIZE = "FontSize";

    /**
     * <p>
     * The name used to retrieve font color property key.
     * Font color is used to draw text.
     * </p>
     */
    public static final String FONT_COLOR = "FontColor";

    /**
     * <p>
     * The key is property name, which is fixed, and known by our application.
     * The value is property key which is used to retrieve value from <code>GraphNode</code>.
     * The value may different between different <code>GraphNode</code>.
     * For example, "StrokeColor" may be stored as a "stroke_color" property of <code>GraphNode</code>,
     * or as a "StrokeColorProperty" property of <code>GraphNode</code>.
     * </p>
     *
     * <p>
     * Initialized in constructor, not <code>null</code>.
     * Itself is never changed later. But the content can be changed.
     * Both the key and value should not be <code>null</code> or empty.
     * </p>
     *
     * <p>
     * <code>HashMap</code> should be used in implementation.
     * </p>
     */
    private final Map<String,String> propertyNameToKeyMap = new HashMap<String, String>();

    /**
     * <p>
     * Constructs a PropertyMapping.
     * Load mappings from <code>ConfigManager</code> namespace.
     * </p>
     *
     * @param namespace - the namespace to load configuration.
     *
     * @throws IllegalArgumentException - if namespace is null or empty (trimmed).
     * @throws ConfigurationException - if any other error occurs.
     */
    public PropertyMapping(String namespace) throws ConfigurationException {
        // Checks whether the namespace is null or empty,
        // if it is null or empty, a IAE will be thrown.
        AuxiliaryElementsHelper.checkNotNullAndNotEmptyString(namespace, "namespace");

        try {
            // Gets the ConfigManager instance.
            ConfigManager cm = ConfigManager.getInstance();

            // Gets all property names.
            Enumeration enums = cm.getPropertyNames(namespace);
            while (enums.hasMoreElements()) {
                // Gets a property name.
                String name = (String) enums.nextElement();

                // Gets a property key.
                String key = AuxiliaryElementsHelper.getStringPropertyValue(namespace, name, true);

                // Adds the name-key pair to the propertyNameToKeyMap.
                this.propertyNameToKeyMap.put(name, key);
            }
        } catch (UnknownNamespaceException une) {
            throw new ConfigurationException("The namespace " + namespace + " is unknown!", une);
        }
    }

    /**
     * <p>
     * Constructs a PropertyMapping.
     * Create an empty mapping.
     * </p>
     */
    public PropertyMapping() {
        // empty
    }

    /**
     * <p>
     * Determines whether the property name exists.
     * </p>
     *
     * @return whether the name is contained
     *
     * @param name - the name of property
     *
     * @throws IllegalArgumentException - if name is null or empty (trimmed).
     */
    public boolean containsPropertyKey(String name) {
        // Checks whether the name is null or empty,
        // if it is null or empty, a IAE will be thrown.
        AuxiliaryElementsHelper.checkNotNullAndNotEmptyString(name, "name");

        return this.propertyNameToKeyMap.containsKey(name);
    }

    /**
     * <p>
     * Gets property key for the specific property name.
     * </p>
     *
     * <p>
     * If no such name, the name itself should be returned.
     * </p>
     *
     * @return the property key according to the name.
     *
     * @param name - the property name
     *
     * @throws IllegalArgumentException - if name is null or empty (trimmed).
     */
    public String getPropertyKey(String name) {
        // Checks whether the name is null or empty,
        // if it is null or empty, a IAE will be thrown.
        AuxiliaryElementsHelper.checkNotNullAndNotEmptyString(name, "name");

        // Gets the key according to the name.
        String key = (String) this.propertyNameToKeyMap.get(name);

        // If the key exist, return it.
        // If no such name, return the name itself.
        return key != null ? key : name;
    }

    /**
     * <p>
     * Adds property key for specific property name.
     * It should override the old value.
     * </p>
     *
     * @return the old key of property or null
     *
     * @param name - the name of property
     * @param key - the key of property
     *
     * @throws IllegalArgumentException - if any arg is null or empty.
     */
    public String addPropertyKey(String name, String key) {
        // Checks whether the args is null or empty,
        // if any arg is null or empty, a IAE will be thrown.
        AuxiliaryElementsHelper.checkNotNullAndNotEmptyString(name, "name");
        AuxiliaryElementsHelper.checkNotNullAndNotEmptyString(key, "key");

        return this.propertyNameToKeyMap.put(name, key);
    }

    /**
     * <p>
     * Removes the property name/key pair.
     * </p>
     *
     * @return the key for the removed name.
     *
     * @param name - the name of property.
     *
     * @throws IllegalArgumentException - if any arg is null or empty.
     */
    public String removePropertyKey(String name) {
        // Checks whether the name is null or empty,
        // if it is null or empty, a IAE will be thrown.
        AuxiliaryElementsHelper.checkNotNullAndNotEmptyString(name, "name");

        return this.propertyNameToKeyMap.remove(name);
    }

    /**
     * <p>
     * Gets all the configured property names.
     * </p>
     *
     * @return a set of configured property names.
     */
    public Set getPropertyNames() {
        return this.propertyNameToKeyMap.keySet();
    }
}
