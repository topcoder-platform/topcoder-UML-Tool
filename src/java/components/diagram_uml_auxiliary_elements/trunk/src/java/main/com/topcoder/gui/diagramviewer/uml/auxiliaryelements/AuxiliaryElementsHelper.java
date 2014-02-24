/*
 * Copyright (C) 2007 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.gui.diagramviewer.uml.auxiliaryelements;

import com.topcoder.diagraminterchange.GraphNode;
import com.topcoder.diagraminterchange.SemanticModelBridge;
import com.topcoder.diagraminterchange.Uml1SemanticModelBridge;
import com.topcoder.diagraminterchange.SimpleSemanticModelElement;
import com.topcoder.diagraminterchange.DiagramElement;
import com.topcoder.diagraminterchange.TextElement;

import com.topcoder.uml.model.core.auxiliaryelements.Comment;

import com.topcoder.util.config.ConfigManager;
import com.topcoder.util.config.UnknownNamespaceException;

import java.awt.Point;
import java.awt.Polygon;
import java.awt.Color;


/**
 * <p>
 * <strong>Helper class:</strong>
 * </p><p>
 * This class contains some help functions provided for
 * classes in package <code>com.topcoder.gui.diagramviewer.uml.auxiliaryelements</code>.
 * </p>
 *
 * <p>
 * This class is immutable, and thread-safe.
 * </p>
 *
 * @author maone, TCSDEVELOPER
 * @version 1.0
 */
final class AuxiliaryElementsHelper {
    /**
     * <p>
     * Constant for text "FreeText".
     * </p>
     */
    private static final String FREE_TEXT = "FreeText";

    /**
     * <p>
     * The private constructor which prevents instantiation.
     * </p>
     */
    private AuxiliaryElementsHelper() {
        // empty
    }

    /**
     * <p>
     * <strong>Help function:</strong>
     * </p><p>
     * This function checks an object.
     * If the object is null, throw a <code>IllegalArgumentException</code>.
     * </p>
     *
     * @param obj - the object to be checked
     * @param name - the name of the obj
     *
     * @throws IllegalArgumentException - If the Object is null.
     */
    static void checkNotNull(Object obj, String name) {
        if (obj == null) {
            throw new IllegalArgumentException("The " + name + " should not be null.");
        }
    }

    /**
     * <p>
     * <strong>Help function:</strong>
     * </p><p>
     * This function checks a string.
     * If the string is null or empty, throw a <code>IllegalArgumentException</code>.
     * </p>
     *
     * @param str - the string to be checked
     * @param name - the name of the str
     *
     * @throws IllegalArgumentException - If the string is empty.
     */
    static void checkNotNullAndNotEmptyString(String str, String name) {
        checkNotNull(str, name);
        if (str.trim().length() == 0) {
            throw new IllegalArgumentException("The " + name + " should not be empty.");
        }
    }

    /**
     * <p>
     * <strong>Help function:</strong>
     * </p><p>
     * This function determine the connection point on polygon,
     * Which is the nearest point to the given point.
     * </p>
     *
     * @return the connection point on the polygon
     *
     * @param wayPoint - the given point
     * @param polygon - the given Polygon
     */
    static Point determineConnectionPoint(Point wayPoint, Polygon polygon) {
        // the shortest distance and the connection point.
        double shortestDistance = Double.MAX_VALUE;
        Point connectionPoint = new Point();

        // for every segment of the polygon, calculates the shortest distance,
        // and then updates the shortestDistance and connectionPoint if necessary.
        for (int i = 0; i < polygon.npoints; i++) {
            // the port of the segment.
            Point start = new Point(polygon.xpoints[i], polygon.ypoints[i]);
            Point end =
                new Point(polygon.xpoints[(i + 1) % polygon.npoints], polygon.ypoints[(i + 1) % polygon.npoints]);

            // Calculates shortest distance and updates the shortestDistance and connectionPoint if necessary
            double distance = Double.MAX_VALUE;
            if (dot(start, end, wayPoint) >= 0) {
                distance = wayPoint.distance(end);
                if (Double.compare(distance, shortestDistance) < 0) {
                    shortestDistance = distance;
                    connectionPoint = end;
                }
            } else if (dot(end, start, wayPoint) >= 0) {
                distance = wayPoint.distance(start);
                if (Double.compare(distance, shortestDistance) < 0) {
                    shortestDistance = distance;
                    connectionPoint = start;
                }
            } else {
                distance = Math.abs(cross(start, end, wayPoint)) / start.distance(end);
                if (Double.compare(distance, shortestDistance) < 0) {
                    shortestDistance = distance;
                    connectionPoint = getNearestPoint(start, end, wayPoint);
                }
            }
        }

        return connectionPoint;
    }

    /**
     * <p>
     * <strong>Help function:</strong>
     * </p><p>
     * This function calculates the dot product of vector ab and bc.
     * </p>
     *
     * @return the dot product of ab and bc
     *
     * @param a - one of the given point
     * @param b - one of the given point
     * @param c - one of the given point
     */
    static int dot(Point a, Point b, Point c) {
        return (b.x - a.x) * (c.x - b.x) + (b.y - a.y) * (c.y - b.y);
    }

    /**
     * <p>
     * <strong>Help function:</strong>
     * </p><p>
     * This function calculates the cross product of vector ab and bc.
     * </p>
     *
     * @return the cross product of ab and bc
     *
     * @param a - one of the given point
     * @param b - one of the given point
     * @param c - one of the given point
     */
    static int cross(Point a, Point b, Point c) {
        return (b.x - a.x) * (c.y - a.y) - (b.y - a.y) * (c.x - a.x);
    }

    /**
     * <p>
     * <strong>Help function:</strong>
     * </p><p>
     * This function finds the nearest point in segment ab to c.
     * </p>
     *
     * @return the nearest point in segment ab to c
     *
     * @param a - one of the given point
     * @param b - one of the given point
     * @param c - one of the given point
     */
    static Point getNearestPoint(Point a, Point b, Point c) {
        int x, y;
        int m, n;

        // if a and b is the same point, return a.
        if ((a.x == b.x) && (a.y == b.y)) {
            return a;
        }

        // calculates the nearest point in segment ab to c.
        m = b.x - a.x;
        n = b.y - a.y;
        x = (m * m * c.x + n * n * a.x + m * n * c.y - m * n * a.y) / (m * m + n * n);
        y = (m * m * a.y + n * n * c.y + m * n * c.x - m * n * a.x) / (m * m + n * n);

        return new Point(x, y);
    }

    /**
     * <p>
     * <strong>Help function:</strong>
     * </p><p>
     * This function checks a color string.
     * If it is valid, return the corresponding color.
     * Otherwise, throw a <code>IllegalGraphNodeException</code>.
     * </p>
     *
     * @return the corresponding color
     *
     * @param graphNode - the GraphNode
     * @param colorString - the color string to be parsed
     *
     * @throws IllegalGraphNodeException - If the color string is invalid.
     */
    static Color parseColor(GraphNode graphNode, String colorString) {
        try {
            return Color.decode(colorString);
        } catch (NumberFormatException nfe) {
            throw new IllegalGraphNodeException(graphNode, "The colorString is not valid.");
        }
    }

    /**
     * <p>
     * <strong>Helper function:</strong>
     * Validate if the graphNode is valid for TextNode.
     * </p>
     *
     * @return if the graphNode is valid, return it.
     *
     * @param graphNode - the graphNode to be validated.
     *
     * @throws IllegalArgumentException - if any argument is null.
     * @throws IllegalGraphNodeException - if graphNode is invalid.
     */
    static GraphNode validateGraphNodeForTextNode(GraphNode graphNode) {
        checkNotNull(graphNode, "graphNode");

        // Validate the SemanticModel
        SemanticModelBridge smb = graphNode.getSemanticModel();
        if (smb == null) {
            throw new IllegalGraphNodeException(
                    graphNode, "SemanticModel of the graphNode should not be null!");
        }

        return graphNode;
    }

    /**
     * <p>
     * <strong>Helper function:</strong>
     * Validate if the graphNode is valid for CommentNode.
     * </p>
     *
     * @return if the graphNode is valid, return it.
     *
     * @param graphNode - the graphNode to be validated.
     *
     * @throws IllegalArgumentException - if any argument is null.
     * @throws IllegalGraphNodeException - if graphNode isn't a CommentNode.
     */
    static GraphNode validateGraphNodeForCommentNode(GraphNode graphNode) {
        checkNotNull(graphNode, "graphNode");

        // Validates the SemanticModel
        SemanticModelBridge smb = graphNode.getSemanticModel();
        if (!(smb instanceof Uml1SemanticModelBridge)) {
            throw new IllegalGraphNodeException(
                    graphNode, "SemanticModel of the graphNode should be Uml1SemanticModelBridge!");
        }

        Uml1SemanticModelBridge usmb = (Uml1SemanticModelBridge) smb;
        // validates if the Uml1SemanticModelBridge contains a Comment as its element attribute.
        if (usmb.getElement() == null || !(usmb.getElement() instanceof Comment)) {
            throw new IllegalGraphNodeException(
                    graphNode,
                    "The Uml1SemanticModelBridge of the graphNode should contain a Comment as its element!");
        }

        return graphNode;
    }

    /**
     * <p>
     * <strong>Helper function:</strong>
     * Validate if the graphNode is valid for FreeTextNode.
     * </p>
     *
     * @return if the graphNode is valid, return it.
     *
     * @param graphNode - the graphNode to be validated.
     *
     * @throws IllegalArgumentException - if any argument is null.
     * @throws IllegalGraphNodeException - if graphNode isn't a FreeTextNode.
     */
    static GraphNode validateGraphNodeForFreeTextNode(GraphNode graphNode) {
        checkNotNull(graphNode, "graphNode");

        // Validates the SemanticModel
        SemanticModelBridge smb = graphNode.getSemanticModel();
        if (!(smb instanceof SimpleSemanticModelElement)) {
            throw new IllegalGraphNodeException(
                    graphNode, "SemanticModel of the graphNode should be SimpleSemanticModelElement!");
        }

        SimpleSemanticModelElement ssme = (SimpleSemanticModelElement) smb;
        if (!FREE_TEXT.equals(ssme.getTypeInfo())) {
            throw new IllegalGraphNodeException(
                    graphNode, "TypeInfo of graphNode's SemanticModel should be '" + FREE_TEXT + "'!");
        }

        // validates if the graphNode contains a TextElement
        boolean valid = false;
        for (DiagramElement de : graphNode.getContaineds()) {
            if (de instanceof TextElement) {
                valid = true;
                break;
            }
        }
        if (!valid) {
            throw new IllegalGraphNodeException(graphNode, "The graphNode should contain a TextElement!");
        }

        return graphNode;
    }

    /**
     * <p>
     * <strong>Helper function:</strong>
     * Get the string property value in <code>ConfigManager</code> with specified namespace and name.
     * </p>
     *
     * @param namespace - the namespace of the config string property value.
     * @param name - the name of the config string property value.
     * @param required - whether the property value is required to get.
     *
     * @return the config string property value in <code>ConfigManager</code>.
     *
     * @throws ConfigurationException - if the namespace doesn't exist,
     *                                  or the name is null or empty,
     *                                  or the parameter doesn't exist if it is required to get,
     *                                  or the parameter value is an empty string.
     */
    static String getStringPropertyValue(String namespace, String name, boolean required)
        throws ConfigurationException {
        checkNotNullAndNotEmptyString(namespace, "namespace");

        if (name == null) {
            throw new ConfigurationException(
                    "The property name " + name + " in namespace " + namespace + " doesn't exist.");
        }

        if (name.trim().length() == 0) {
            throw new ConfigurationException(
                    "The property name " + name + " in namespace " + namespace + " is an empty string.");
        }

        try {
            String value = ConfigManager.getInstance().getString(namespace, name);

            if ((value == null)) {
                if (required) {
                    throw new ConfigurationException(
                            "The required parameter " + name + " in namespace " + namespace + " doesn't exist.");
                }

                return null;
            }

            if (required && (value.trim().length() == 0)) {
                throw new ConfigurationException(
                        "The parameter value of " + name + " in namespace " + namespace + " is an empty string.");
            }

            return value;
        } catch (UnknownNamespaceException une) {
            throw new ConfigurationException(
                    "The namespace with the name of " + namespace + " doesn't exist.", une);
        }
    }
}
