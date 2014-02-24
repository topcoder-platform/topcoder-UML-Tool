/*
 * Copyright (C) 2007 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.gui.diagramviewer.elements;

import java.awt.Point;
import java.awt.Rectangle;
import java.lang.reflect.Field;
import java.util.Iterator;
import java.io.File;

import com.topcoder.diagraminterchange.Dimension;
import com.topcoder.util.config.ConfigManager;

/**
 * Defines helper methods used in unit tests of this component.
 *
 * @author TCSDEVELOPER
 * @version 1.0
 */
final class TestHelper {

    /**
     * This private constructor prevents the creation of a new instance.
     */
    private TestHelper() {
    }

    /**
     * Gets the value of a private field in the given class. The field has the given name. The value is retrieved from
     * the given instance. If the instance is null, the field is a static field. If any error occurs, null is returned.
     *
     * @param type
     *            the class which the private field belongs to
     * @param instance
     *            the instance which the private field belongs to
     * @param name
     *            the name of the private field to be retrieved
     * @return the value of the private field
     */
    static Object getPrivateField(Class type, Object instance, String name) {
        Field field = null;
        Object obj = null;
        try {
            // get the reflection of the field
            field = type.getDeclaredField(name);
            // set the field accessible
            field.setAccessible(true);
            // get the value
            obj = field.get(instance);
        } catch (NoSuchFieldException e) {
            // ignore
        } catch (IllegalAccessException e) {
            // ignore
        } finally {
            if (field != null) {
                // reset the accessibility
                field.setAccessible(false);
            }
        }
        return obj;
    }

    /**
     * Sets the value of a private field in the given class.
     *
     * @param type
     *            the class which the private field belongs to
     * @param instance
     *            the instance which the private field belongs to
     * @param name
     *            the name of the private field to be set
     * @param value
     *            the value to set
     */
    static void setPrivateField(Class type, Object instance, String name, Object value) {
        Field field = null;
        try {
            // get the reflection of the field
            field = type.getDeclaredField(name);
            // set the field accessible
            field.setAccessible(true);
            // set the value
            field.set(instance, value);
        } catch (NoSuchFieldException e) {
            // ignore
        } catch (IllegalAccessException e) {
            // ignore
        } finally {
            if (field != null) {
                // reset the accessibility
                field.setAccessible(false);
            }
        }
    }

    /**
     * Validates whether the center of the given corner is set correctly basing its type and node selection bound.
     *
     * @param bound
     *            the selection bound of node
     * @param type
     *            the type of corner
     * @param center
     *            the center of corner
     * @return true if the center is correctly set, otherwise false
     */
    static boolean validateCornerCenter(Rectangle bound, SelectionCornerType type, Point center) {
        if (type == SelectionCornerType.EAST) {
            return new Point(bound.x + bound.width, (int) Math.round(bound.y + bound.getHeight() / 2)).equals(center);
        } else if (type == SelectionCornerType.SOUTH) {
            return new Point((int) Math.round(bound.x + bound.getWidth() / 2), bound.y + bound.height).equals(center);
        } else if (type == SelectionCornerType.WEST) {
            return new Point(bound.x, (int) Math.round(bound.y + bound.getHeight() / 2)).equals(center);
        } else if (type == SelectionCornerType.NORTH) {
            return new Point((int) Math.round(bound.x + bound.getWidth() / 2), bound.y).equals(center);
        } else if (type == SelectionCornerType.NORTHEAST) {
            return new Point(bound.x + bound.width, bound.y).equals(center);
        } else if (type == SelectionCornerType.NORTHWEST) {
            return new Point(bound.x, bound.y).equals(center);
        } else if (type == SelectionCornerType.SOUTHEAST) {
            return new Point(bound.x + bound.width, bound.y + bound.height).equals(center);
        } else {
            return new Point(bound.x, bound.y + bound.height).equals(center);
        }
    }

    /**
     * <p>
     * This method creates a Point instance defined in Diagram Interchange component.
     * </p>
     *
     * @param x the x-coordinate position of the point
     * @param y the y-coordinate position of the points
     *
     * @return the point instance defined in Diagram Interchange component with the given x and y coordinate value.
     */
    public static com.topcoder.diagraminterchange.Point createDiagramInterchangePoint(int x, int y) {
        com.topcoder.diagraminterchange.Point pt = new com.topcoder.diagraminterchange.Point();
        pt.setX(x);
        pt.setY(y);

        return pt;
    }

    /**
     * <p>
     * This method creates a Dimension instance defined in Diagram Interchange component.
     * </p>
     *
     * @param width the width
     * @param height the height
     *
     * @return the Dimension instance defined in Diagram Interchange component with the given width and height value.
     */
    public static Dimension createDiagramInterchangeDimension(int width, int height) {
        Dimension dimension = new Dimension();
        dimension.setWidth(width);
        dimension.setHeight(height);

        return dimension;
    }

    /**
     * <p>
     * Uses the given file to config the configuration manager.
     * </p>
     *
     * @param fileName config file to set up environment
     *
     * @throws Exception when any exception occurs
     */
    public static void loadXMLConfig(String fileName) throws Exception {
        //set up environment
        ConfigManager config = ConfigManager.getInstance();
        File file = new File(fileName);

        config.add(file.getCanonicalPath());
    }

    /**
     * <p>
     * Clears all the namespaces from the configuration manager.
     * </p>
     *
     * @throws Exception to JUnit.
     */
    public static void clearConfig() throws Exception {
        ConfigManager cm = ConfigManager.getInstance();

        for (Iterator i = cm.getAllNamespaces(); i.hasNext();) {
            cm.removeNamespace((String) i.next());
        }
    }
}