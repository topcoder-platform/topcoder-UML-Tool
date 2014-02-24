/*
 * Copyright (C) 2007 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.gui.diagramviewer.uml.sequenceelements;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.lang.reflect.Field;
import java.util.List;

import com.topcoder.diagraminterchange.DiagramElement;
import com.topcoder.diagraminterchange.Property;
import com.topcoder.gui.diagramviewer.edges.LineStyle;
import com.topcoder.gui.diagramviewer.edges.SelectionCorner;
import com.topcoder.util.config.ConfigManager;
import com.topcoder.util.config.UnknownNamespaceException;

/**
 * <p>
 * Helper class for this component.
 * </p>
 *
 * <p>
 * Thread Safety : This class is immutable and so thread safe.
 * </p>
 *
 * <p>
 * Change for v1.1: Add helper check method for int value:checkInt_Negative,checkInt_NegativeOrNil.
 * </p>
 *
 * @author TCSDEVELOPER
 * @author gniuxiao, TCSDEVELOPER
 *
 * @version 1.1
 * @since 1.0
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
     *
     * @param arg the argument to check
     * @param name the name of the argument to check
     *
     * @throws IllegalArgumentException if the given Object is null
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
     *
     * @param arg the String to check
     * @param name the name of the String argument to check
     *
     * @throws IllegalArgumentException if the given string is null or empty
     */
    public static void checkString(String arg, String name) {
        checkNull(arg, name);

        if (arg.trim().length() == 0) {
            throw new IllegalArgumentException(name + " should not be empty.");
        }
    }


    /**
     * <p>
     * Checks whether the given int value is Negative or Nil.
     * </p>
     *
     * @param arg the argument to check
     * @param name the name of the argument to check
     *
     * @throws IllegalArgumentException if the given value is Negative or Nil
     *
     * @since 1.1
     */
    public static void checkInt_NegativeOrNil(int arg, String name) {
        if (arg <= 0) {
            throw new IllegalArgumentException(name + " should not be 0 or negative.");
        }
    }


    /**
     * <p>
     * Checks whether the given int value is negative.
     * </p>
     *
     * @param arg the argument to check
     * @param name the name of the argument to check
     *
     * @throws IllegalArgumentException if the given value negative
     *
     * @since 1.1
     */
    public static void checkInt_Negative(int arg, String name) {
        if (arg < 0) {
            throw new IllegalArgumentException(name + " should not be negative.");
        }
    }


    /**
     * <p>
     * This method loads a property from the properties inside the given <code>element</code> with the property
     * name <code>nameInDiagramElement</code>, or from the given namespace <code>namespace</code> with the
     * property name <code>nameInConfig</code>.
     * </p>
     *
     * <p>
     * If the property doesn't exist, then the default value will be returned.
     * </p>
     *
     * @param element the <code>DiagramElement</code> instance to find the property
     * @param nameInDiagramElement the property name in the given <code>element</code>
     * @param namespace the namespace to load configuration values
     * @param nameInConfig the property name under the given namespace
     * @param defaultValue the default property value
     *
     * @return the property value in String representation
     */
    public static String readStringProperty(DiagramElement element, String nameInDiagramElement, String namespace,
        String nameInConfig, String defaultValue) {
        String value = Util.parseStringProperty(element, nameInDiagramElement);
        if (value == null) {
            value = Util.parseStringProperty(namespace, nameInConfig);
        }
        if (value == null) {
            value = defaultValue;
        }

        return value;
    }

    /**
     * <p>
     * This method loads a property from the properties inside the given <code>element</code> with the property
     * name <code>nameInDiagramElement</code>, or from the given namespace <code>namespace</code> with the
     * property name <code>nameInConfig</code>.
     * </p>
     *
     * <p>
     * If the property doesn't exist, then the default value will be returned.
     * </p>
     *
     * @param element the <code>DiagramElement</code> instance to find the property
     * @param nameInDiagramElement the property name in the given <code>element</code>
     * @param namespace the namespace to load configuration values
     * @param nameInConfig the property name under the given namespace
     * @param defaultColor the default property color
     *
     * @return the property value in Color representation
     */
    public static Color readColorProperty(DiagramElement element, String nameInDiagramElement, String namespace,
        String nameInConfig, Color defaultColor) {
        Color color = Util.parseColorProperty(element, nameInDiagramElement);
        if (color == null) {
            color = Util.parseColorProperty(namespace, nameInConfig);
        }
        if (color == null) {
            color = defaultColor;
        }

        return color;
    }

    /**
     * <p>
     * This method loads a property from the properties inside the given <code>element</code> with the property
     * name <code>nameInDiagramElement</code>, or from the given namespace <code>namespace</code> with the
     * property name <code>nameInConfig</code>.
     * </p>
     *
     * <p>
     * If the property doesn't exist, then the default value will be returned.
     * </p>
     *
     * @param element the <code>DiagramElement</code> instance to find the property
     * @param nameInDiagramElement the property name in the given <code>element</code>
     * @param namespace the namespace to load configuration values
     * @param nameInConfig the property name under the given namespace
     * @param defaultValue the default property value
     *
     * @return the property value in int representation
     */
    public static int readIntegerProperty(DiagramElement element, String nameInDiagramElement, String namespace,
        String nameInConfig, int defaultValue) {
        Integer value = Util.parseIntegerProperty(element, nameInDiagramElement);
        if (value == null) {
            value = Util.parseIntegerProperty(namespace, nameInConfig);
        }
        if (value == null) {
            value = defaultValue;
        }

        return value;
    }

    /**
     * <p>
     * This method loads a property from from the given namespace <code>namespace</code> with the
     * property name <code>name</code>.
     * </p>
     *
     * <p>
     * If the property doesn't exist, then null will be returned.
     * </p>
     *
     * @param namespace the namespace to load configuration values
     * @param name the property name under the given namespace
     *
     * @return the property value in Color representation, or null if the property is not found
     */
    public static Color parseColorProperty(String namespace, String name) {
        String value = parseStringProperty(namespace, name);

        if (value == null) {
            return null;
        }

        String prefix = "Color.";

        if (value.startsWith(prefix)) {
            String fieldValue = value.substring(prefix.length());

            try {
                Field field = Color.class.getField(fieldValue);
                return (Color) field.get(null);
            } catch (SecurityException e) {
                // ignore
            } catch (NoSuchFieldException e) {
                // ignore
            } catch (IllegalArgumentException e) {
                // ignore
            } catch (IllegalAccessException e) {
                // ignore
            }
        }

        return null;
    }

    /**
     * <p>
     * This method loads a property from from the given namespace <code>namespace</code> with the
     * property name <code>name</code>.
     * </p>
     *
     * <p>
     * If the property doesn't exist, then null will be returned.
     * </p>
     *
     * @param namespace the namespace to load configuration values
     * @param name the property name under the given namespace
     *
     * @return the property value in String representation, or null if the property is not found
     */
    public static String parseStringProperty(String namespace, String name) {
        ConfigManager manager = ConfigManager.getInstance();

        try {
            return manager.getString(namespace, name);
        } catch (UnknownNamespaceException e) {
            return null;
        }
    }

    /**
     * <p>
     * This method loads a property from from the given namespace <code>namespace</code> with the
     * property name <code>name</code>.
     * </p>
     *
     * <p>
     * If the property doesn't exist, then null will be returned.
     * </p>
     *
     * @param namespace the namespace to load configuration values
     * @param name the property name under the given namespace
     *
     * @return the property value in Integer representation, or null if the property is not found
     */
    public static Integer parseIntegerProperty(String namespace, String name) {
        String value = parseStringProperty(namespace, name);

        if (value == null) {
            return null;
        }

        try {
            return Integer.parseInt(value);
        } catch (NumberFormatException e) {
            return null;
        }
    }

    /**
     * <p>
     * This method loads a property from the properties inside the given <code>element</code> with the property
     * name <code>name</code>.
     * </p>
     *
     * <p>
     * If the property doesn't exist, then null will be returned.
     * </p>
     *
     * @param element the <code>DiagramElement</code> instance to find the property
     * @param name the property name in the given <code>element</code>
     *
     * @return the property value in Color representation
     */
    public static Color parseColorProperty(DiagramElement element, String name) {
        String value = parseStringProperty(element, name);
        if (value != null) {
            return convertColor(value);
        }

        return null;
    }

    /**
     * <p>
     * This method loads a property from the properties inside the given <code>element</code> with the property
     * name <code>name</code>.
     * </p>
     *
     * <p>
     * If the property doesn't exist, then null will be returned.
     * </p>
     *
     * @param element the <code>DiagramElement</code> instance to find the property
     * @param name the property name in the given <code>element</code>
     *
     * @return the property value in Integer representation
     */
    public static Integer parseIntegerProperty(DiagramElement element, String name) {
        String value = parseStringProperty(element, name);
        if (value != null) {
            try {
                return new Integer(value);
            } catch (NumberFormatException e) {
                return null;
            }
        }

        return null;
    }

    /**
     * <p>
     * This method loads a property from the properties inside the given <code>element</code> with the property
     * name <code>name</code>.
     * </p>
     *
     * <p>
     * If the property doesn't exist, then null will be returned.
     * </p>
     *
     * <p>
     * Note, if the given <code>element</code> or <code>name</code> is null, then null will be returned.
     * </p>
     *
     * @param element the <code>DiagramElement</code> instance to find the property
     * @param name the property name in the given <code>element</code>
     *
     * @return the property value in String representation
     */
    public static String parseStringProperty(DiagramElement element, String name) {
        if (element == null) {
            return null;
        }

        if (name == null) {
            return null;
        }

        for (Property property : element.getProperties()) {
            if (name.equals(property.getKey())) {
                return property.getValue();
            }
        }

        return null;
    }

    /**
     * <p>
     * This method loads the <code>RenderScheme</code> property from the properties inside the given
     * <code>element</code> with the property name <code>nameInDiagramElement</code>, or from the
     * given namespace <code>namespace</code> with the property name <code>nameInConfig</code>.
     * </p>
     *
     * <p>
     * If the property doesn't exist, then the default value will be returned.
     * </p>
     *
     * @param element the <code>DiagramElement</code> instance to find the property
     * @param nameInDiagramElement the property name in the given <code>element</code>
     * @param namespace the namespace to load configuration values
     * @param nameInConfig the property name under the given namespace
     * @param defaultValue the default property value
     *
     * @return the property value in RenderScheme representation
     */
    public static RenderScheme parseReaderSchemeProperty(DiagramElement element, String nameInDiagramElement,
        String namespace, String nameInConfig, int defaultValue) {
        int renderSchemeValue = readIntegerProperty(element, nameInDiagramElement, namespace, nameInConfig,
            defaultValue);

        if (renderSchemeValue != 0 && renderSchemeValue != 1) {
            renderSchemeValue = defaultValue;
        }

        return (renderSchemeValue == 0) ? RenderScheme.SimpleScheme : RenderScheme.TopCoderScheme;
    }

    /**
     * <p>
     * This method loads the <code>FontStyle</code> property from the properties inside the given
     * <code>element</code> with the property name <code>nameInDiagramElement</code>, or from the
     * given namespace <code>namespace</code> with the property name <code>nameInConfig</code>.
     * </p>
     *
     * <p>
     * If the property doesn't exist, then the default value will be returned.
     * </p>
     *
     * @param element the <code>DiagramElement</code> instance to find the property
     * @param nameInDiagramElement the property name in the given <code>element</code>
     * @param namespace the namespace to load configuration values
     * @param nameInConfig the property name under the given namespace
     * @param defaultValue the default property value
     *
     * @return the property value in int representation
     */
    static int parseFontStyleProperty(DiagramElement element, String nameInDiagramElement, String namespace,
        String nameInConfig, int defaultValue) {
        Integer fontStyleValue = Util.parseIntegerProperty(element, nameInDiagramElement);
        if (fontStyleValue == null) {
            String value = Util.parseStringProperty(namespace, nameInConfig);
            if (value == null) {
                return defaultValue;
            }

            String prefix = "Font.";
            if (value.startsWith(prefix)) {
                String fieldValue = value.substring(prefix.length());

                try {
                    Field field = Font.class.getField(fieldValue);
                    fontStyleValue = (Integer) field.get(null);
                } catch (SecurityException e) {
                    // ignore
                } catch (NoSuchFieldException e) {
                    // ignore
                } catch (IllegalArgumentException e) {
                    // ignore
                } catch (IllegalAccessException e) {
                    // ignore
                }
            }
        }

        return (fontStyleValue == null) ? defaultValue : fontStyleValue;
    }

    /**
     * <p>
     * Converts a color string to its corresponding Color instance.
     * </p>
     *
     * <p>
     * If the color string is not valid, then null will be returned.
     * </p>
     *
     * <p>
     * The color string format is <b>RRGGBB</b>
     * </p>
     *
     * @param colorString the color string
     *
     * @return the Color instance that represents the given color string, it may be the
     * default color if the given color string is not valid.
     */
    private static Color convertColor(String colorString) {
        if (!colorString.matches(COLOR_REGEX)) {
            return null;
        }

        int r = Integer.parseInt(colorString.substring(1, 3), 16);
        int g = Integer.parseInt(colorString.substring(3, 5), 16);
        int b = Integer.parseInt(colorString.substring(5, 7), 16);

        return new Color(r, g, b);
    }

    /**
     * <p>
     * Pains the sequence edge instance to the given <code>Graphics</code> instance.
     * </p>
     *
     * <p>
     * All the way points of the edge will be drawn, and the colors of the selection
     * corners will be updated too.
     * </p>
     *
     * @param g a <code>Graphics</code> instance to draw the sequence edge
     * @param edge <code>SequenceEdge</code> instance to be drawn
     *
     * @throws IllegalArgumentException if g is null
     */
    static void paintSequenceEdge(Graphics g, SequenceEdge edge) {
        Util.checkNull(g, "g");

        LineStyle lineStyle = edge.getLineStyle();
        lineStyle.setBlankLength(edge.getBlankLength());
        lineStyle.setDashLength(edge.getDashLength());

        List<SelectionCorner> corners = edge.getWayPoints();

        for (SelectionCorner corner : corners) {
            corner.setFillColor(edge.getFillColor());
            corner.setStrokeColor(edge.getStrokeColor());
        }

        Color oldColor = g.getColor();

        g.setColor(edge.getStrokeColor());
        for (int i = 0; i < corners.size() - 1; i++) {
            // paint the line
            lineStyle.paint(g, corners.get(i).getCenter(), corners.get(i + 1).getCenter());
        }
        g.setColor(oldColor);
    }
}
