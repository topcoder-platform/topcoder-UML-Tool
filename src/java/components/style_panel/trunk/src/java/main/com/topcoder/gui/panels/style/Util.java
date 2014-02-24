/*
 * Copyright (C) 2007-2008 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.gui.panels.style;

import java.awt.Color;
import java.awt.GraphicsEnvironment;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

import com.topcoder.diagraminterchange.DiagramElement;
import com.topcoder.diagraminterchange.GraphElement;
import com.topcoder.diagraminterchange.GraphNode;
import com.topcoder.util.config.ConfigManager;
import com.topcoder.util.config.Property;
import com.topcoder.util.config.UnknownNamespaceException;

/**
 * <p>
 * Helper class for the Style Panel component.
 * </p>
 * @author TCSDEVELOPER
 * @version 1.0
 */
public final class Util {
    /**
     * <p>
     * Represents the regular expression that is used for validating a color string.
     * </p>
     */
    private static final String COLOR_REGEX = "#[0-9a-fA-F]{6,6}";

    /**
     * <p>
     * Represents the default font size used by this component.
     * <p>
     */
    private static final int DEFAULT_FONT_SIZE = 10;

    /**
     * <p>
     * This private constructor prevents to create a new instance.
     * </p>
     */
    private Util() {
        // empty
    }

    /**
     * <p>
     * Checks whether the given Object is null.
     * </p>
     * @param arg
     *            the argument to check
     * @param name
     *            the name of the argument to check
     * @throws IllegalArgumentException
     *             if the given Object is null
     */
    public static void checkNull(Object arg, String name) {
        if (arg == null) {
            throw new IllegalArgumentException(name + " should not be null.");
        }
    }

    /**
     * <p>
     * Checks whether the given String is null or empty.
     * </p>
     * @param arg
     *            the String to check
     * @param name
     *            the name of the String argument to check
     * @throws IllegalArgumentException
     *             if the given string is null or empty
     */
    public static void checkString(String arg, String name) {
        checkNull(arg, name);

        if (arg.trim().length() == 0) {
            throw new IllegalArgumentException(name + " should not be empty.");
        }
    }

    /**
     * <p>
     * Returns the style panel that represents the style object.
     * </p>
     * @param styleObject
     *            the style object
     * @return the underlying style panel
     * @throws IllegalStateException
     *             if the style panel for the style object is not set
     */
    public static StylePanel getStylePanel(StyleObject styleObject) {
        StylePanel panel = styleObject.getStylePanel();
        if (panel == null) {
            throw new IllegalStateException("The style panel for the style object is not set yet.");
        }

        return panel;
    }

    /**
     * <p>
     * This method gets the double property value from the diagram element.
     * </p>
     * <p>
     * The double properties include x-position, y-position, width and height styles.
     * </p>
     * <p>
     * If the property value is not valid, then default value (it is zero) will be returned.
     * </p>
     * @param element
     *            the DiagramElement that the style object adapts
     * @param key
     *            the property key to get the corresponding value
     * @return the property value from the diagram element
     */
    public static double getDoubleProperty(DiagramElement element, String key) {
        if (key.equals("x") && (element instanceof GraphElement))
            return ((GraphElement) element).getPosition().getX();
        if (key.equals("y") && (element instanceof GraphElement))
            return ((GraphElement) element).getPosition().getY();
        if (key.equals("width") && (element instanceof GraphNode))
            return ((GraphNode) element).getSize().getWidth();
        if (key.equals("height") && (element instanceof GraphNode))
            return ((GraphNode) element).getSize().getHeight();
        return 0;
    }

    /**
     * <p>
     * This method gets the color property value from the diagram element.
     * </p>
     * <p>
     * The color properties include fill color, outline color, text color styles.
     * </p>
     * <p>
     * If the property value is not valid, then default value will be returned. For fill color, the default value is
     * Color.WHITE, for outline color or text color, the default value is Color.WHITE.
     * </p>
     * @param element
     *            the DiagramElement that the style object adapts
     * @param key
     *            the property key to get the corresponding value
     * @param defaultValue
     *            the default color string for the style
     * @return the property value from the diagram element, may be the default value.
     */
    public static String getColorProperty(DiagramElement element, String key, String defaultValue) {
        Map<String, String> map = Util.getStyleObjectProperties(element);
        if (map.containsKey(key)) {
            String value = map.get(key);
            if (value != null) {
                if (value.charAt(0) != '#') {
                    value = "#" + value;
                }
                if (value.matches(COLOR_REGEX)) {
                    return value;
                }
            }
        }

        return defaultValue;
    }

    /**
     * <p>
     * This method gets the font size property value from the diagram element.
     * </p>
     * <p>
     * If the property key is missing, then default value (it is ten) will be returned.
     * </p>
     * <p>
     * If the property key is not an integer or non-positive, then default value will be returned.
     * </p>
     * @param element
     *            the DiagramElement that the style object adapts
     * @param key
     *            the property key to get the corresponding value
     * @return the property value from the diagram element
     */
    public static int getFontSizeProperty(DiagramElement element, String key) {
        Map<String, String> map = Util.getStyleObjectProperties(element);
        if (map.containsKey(key)) {
            try {
                int fontSize = Integer.parseInt(map.get(key));
                if (fontSize > 0) {
                    return fontSize;
                }
            } catch (NumberFormatException e) {
                // ignore
            }
        }

        return DEFAULT_FONT_SIZE;
    }

    /**
     * <p>
     * This method gets the font name property value from the diagram element.
     * </p>
     * <p>
     * If the property key is missing, then default font name will be returned.
     * </p>
     * <p>
     * If the font name is not a valid system font, then the default font name will be returned.
     * </p>
     * @param element
     *            the DiagramElement that the style object adapts
     * @param key
     *            the property key to get the corresponding value
     * @return the property value from the style object
     */
    public static String getFontNameProperty(DiagramElement element, String key) {
        Map<String, String> map = Util.getStyleObjectProperties(element);
        if (map.containsKey(key)) {
            String value = map.get(key);
            if (getAllFontNames().contains(value)) {
                return value;
            }
        }

        return "Default";
    }

    /**
     * <p>
     * Checks whether the given List instance is null or contains null element.
     * </p>
     * @param list
     *            the List to check
     * @param name
     *            the name of the List argument to check
     * @throws IllegalArgumentException
     *             if the given list is null or contains null element
     */
    public static void checkList(List<?> list, String name) {
        checkNull(list, name);

        if (list.contains(null)) {
            throw new IllegalArgumentException("The " + name + " list contains null element.");
        }
    }

    /**
     * <p>
     * Converts the given value to its integer representation.
     * </p>
     * <p>
     * If the given value is not an integer or non-positive, then StylePanelConfigurationException will be thrown.
     * </p>
     * @param value
     *            the value to convert
     * @param propName
     *            the property name where the value is read from
     * @return an integer converts from the given value
     * @throws StylePanelConfigurationException
     *             if the given value is not an integer or non-positive
     */
    static int convertInteger(String value, String propName) {
        try {
            int result = Integer.parseInt(value);
            if (result <= 0) {
                throw new StylePanelConfigurationException("The value for " + propName
                        + " property is non-positive, its value is " + value);
            }

            return result;
        } catch (NumberFormatException e) {
            throw new StylePanelConfigurationException("The value for " + propName
                    + "property is not an integer, its value is " + value);
        }
    }

    /**
     * <p>
     * This method reads all the sub-properties under the given property names from the given namespace.
     * </p>
     * <p>
     * The sub property will have its sub properties will be excluded.
     * </p>
     * <p>
     * The properties are returned in Map representation. The key of the map is the property key, the value of the map
     * is the property value.
     * </p>
     * <p>
     * Note, null will be returned to identify that the given property name is missing.
     * </p>
     * @param namespace
     *            the namespace in the configuration file from which the configuration properties needs to be read
     * @param propertyName
     *            the property name to get all its sub-properties
     * @return the sub-properties under the given property name in the map representation, may be null
     * @throws StylePanelConfigurationException
     *             if the namespace is not configed, or some sub property has null or empty value
     */
    static Map<String, String> getPropertyMap(String namespace, String propertyName) {
        try {
            Map<String, String> map = new HashMap<String, String>();

            ConfigManager cm = ConfigManager.getInstance();
            Property property = cm.getPropertyObject(namespace, propertyName);

            // the property is missing, return null in this case
            if (property == null) {
                return null;
            }

            List props = property.list();

            for (Object obj : props) {
                Property nestedProp = (Property) obj;

                // only the property without sub properties will be saved to the map
                if (nestedProp.list().isEmpty()) {
                    String value = nestedProp.getValue();

                    // the property has null or empty value
                    if (value == null || value.trim().length() == 0) {
                        throw new StylePanelConfigurationException("The property value is empty or missing.");
                    }
                    map.put(nestedProp.getName(), value);
                }
            }

            return map;
        } catch (UnknownNamespaceException e) {
            throw new StylePanelConfigurationException(
                    "UnknownNamespaceException occurs when accessing ConfigManager.", e);
        }
    }

    /**
     * <p>
     * Returns all the font names that are available in the system.
     * </p>
     * @return all the font names that are available in the system.
     */
    static Set<String> getAllFontNames() {
        Set<String> set = new TreeSet<String>();
        String[] fontNames = GraphicsEnvironment.getLocalGraphicsEnvironment().getAvailableFontFamilyNames();
        for (String fontName : fontNames) {
            set.add(fontName);
        }
        return set;
    }

    /**
     * <p>
     * Converts a color string to its corresponding Color instance.
     * </p>
     * <p>
     * If the color string is not valid, then the given default color will be returned.
     * </p>
     * <p>
     * The color string format is <b>#RRGGBB</b>
     * </p>
     * @param colorString
     *            the color string
     * @param defaultColor
     *            the default color to be used when the given color string is not valid
     * @return the Color instance that represents the given color string, it may be the default color if the given color
     *         string is not valid.
     */
    public static Color convertColor(String colorString, Color defaultColor) {
        if (!colorString.matches(COLOR_REGEX)) {
            return defaultColor;
        }

        int r = Integer.parseInt(colorString.substring(1, 3), 16);
        int g = Integer.parseInt(colorString.substring(3, 5), 16);
        int b = Integer.parseInt(colorString.substring(5, 7), 16);

        return new Color(r, g, b);
    }

    /**
     * <p>
     * Converts a Color instance to its string representation.
     * </p>
     * <p>
     * The color string format is <b>#RRGGBB</b>
     * </p>
     * @param color
     *            the color to convert
     * @return the string representation of the given color
     */
    public static String convertColor(Color color) {
        StringBuffer sb = new StringBuffer();
        sb.append("#");
        sb.append(getHexString(color.getRed()).toUpperCase());
        sb.append(getHexString(color.getGreen()).toUpperCase());
        sb.append(getHexString(color.getBlue()).toUpperCase());
        return sb.toString();
    }

    /**
     * <p>
     * Converts an integer to its hex string.
     * </p>
     * <p>
     * If the length of the hex string is one, then a leading "0" will be appended.
     * </p>
     * @param value
     *            the integer value
     * @return the hex string of the given integer
     */
    private static String getHexString(int value) {
        String hexString = Integer.toHexString(value);
        return (hexString.length() == 1) ? "0" + hexString : hexString;
    }

    /**
     * <p>
     * Returns all the properties of the given DiagramElement instance using the map representation.
     * </p>
     * <p>
     * The key of the map is property key and the value of the map is the property value.
     * </p>
     * @param element
     *            the DiagramElement instance to get all its properties
     * @return all the properties of the given DiagramElement instance using the map representation.
     */
    private static Map<String, String> getStyleObjectProperties(DiagramElement element) {
        Map<String, String> properties = new HashMap<String, String>();
        Collection<com.topcoder.diagraminterchange.Property> elementProps = element.getProperties();
        for (com.topcoder.diagraminterchange.Property prop : elementProps) {
            properties.put(prop.getKey(), prop.getValue());
        }

        return properties;
    }
}
