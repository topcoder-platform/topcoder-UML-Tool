/*
 * Copyright (C) 2006 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.gui.diagramviewer.edges;

import static java.lang.Math.atan2;

import java.awt.Color;
import java.awt.Point;
import java.awt.Rectangle;
import java.util.Map;

import com.topcoder.diagraminterchange.GraphEdge;
import com.topcoder.diagraminterchange.Property;
import com.topcoder.gui.diagramviewer.DiagramViewer;

/**
 * <p>
 * Helper class for this component.
 * </p>
 *
 * <p>
 * Thread Safety : This class is immutable and so thread safe.
 * </p>
 *
 * @author TCSDEVELOPER
 * @version 1.0
 */
public final class Util {
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
     * @return the original argument
     *
     * @throws IllegalArgumentException if the given Object is null
     */
    public static Object checkNull(Object arg, String name) {
        if (arg == null) {
            throw new IllegalArgumentException(name + " should not be null.");
        }

        return arg;
    }

    /*
     * BugFix: BUGID UML-7694
     * Description:
     * The Diagram Edges component should use the color mentioned in the properties of
     * GraphEdge to paint the edge - the stroke color.
     * The component should also use the font family, font color and font size properties
     * of GraphEdge to paint the text fields anchored to the edge.
     * The names of the properties should be configurable.
     * The color values are represented like this: "#RRGGBB".
     * Solution:
     * Add the property map, which is used to get the property keys. Add strokeColor and
     * fontColor fields. Add a public notifyProperitesChange method to retrieve properties
     * from graph edge. Add a setter of fontColor to TextField class.
     */
    /**
     * <p>
     * Checks whether the given argument is <code>null</code> or empty string.
     * </p>
     * @param argument
     *            the argument to be checked
     * @param name
     *            the name of the argument
     * @throws IllegalArgumentException
     *             if the argument is <code>null</code> or empty string
     */
    static void checkNullOrEmptyString(String argument, String name) {
        checkNull(argument, name);
        if (argument.trim().length() == 0) {
            throw new IllegalArgumentException(name + " should not be empty string.");
        }
    }

    /*
     * BugFix: BUGID UML-7694
     * Description:
     * The Diagram Edges component should use the color mentioned in the properties of
     * GraphEdge to paint the edge - the stroke color.
     * The component should also use the font family, font color and font size properties
     * of GraphEdge to paint the text fields anchored to the edge.
     * The names of the properties should be configurable.
     * The color values are represented like this: "#RRGGBB".
     * Solution:
     * Add the property map, which is used to get the property keys. Add strokeColor and
     * fontColor fields. Add a public notifyProperitesChange method to retrieve properties
     * from graph edge. Add a setter of fontColor to TextField class.
     */
    /**
     * <p>
     * Checks whether the given map is <code>null</code> or contains <code>null</code> or empty string element.
     * </p>
     * @param map
     *            the map to be checked
     * @param name
     *            the name of the map
     * @throws IllegalArgumentException
     *             if the map is <code>null</code>, or contains <code>null</code> or empty string element
     */
    static void checkMapNullOrContainingEmpty(Map<String, String> map, String name) {
        checkNull(map, name);
        for (String key : map.keySet()) {
            checkNullOrEmptyString(key, "key of map");
        }
        for (String value : map.values()) {
            checkNullOrEmptyString(value, "value of map");
        }
    }


    /**
     * <p>
     * Compute the closest point on given rectangle to the given point.
     * </p>
     *
     * @param point the point to get the closest point on given rectangle
     * @param rectangle a Rectangle instance
     *
     * @return the closest point on given rectangle to the given point.
     *
     * @throws IllegalArgumentException if point is null or rectangle is null
     */
    public static Point getClosestPoint(Point point, Rectangle rectangle) {
        Util.checkNull(point, "point");
        Util.checkNull(rectangle, "rectangle");

        // the shortest distance and the closest point
        // Initially the shortest distance is the maximum value of double and the closest
        // point is (0, 0).
        double shorestDist = Double.MAX_VALUE;
        Point shorestPoint = new Point();

        // The four points on the rectangle
        Point[] rectPoints = new Point[] {new Point(rectangle.x, rectangle.y),
            new Point(rectangle.x + rectangle.width, rectangle.y),
            new Point(rectangle.x + rectangle.width, rectangle.y + rectangle.height),
            new Point(rectangle.x, rectangle.y + rectangle.height)};

        // the curPoint represents the closest point for the current segment for the rectangle
        Point curPoint = new Point();

        // iterator each segment of the rectangle
        for (int i = 0; i < rectPoints.length; i++) {
            // get the closest point and distance for each segment
            double dist = getClosestPoint(point, rectPoints[i], rectPoints[(i + 1) % rectPoints.length], curPoint);

            // a shorter distance is found, then update the shorestDist and shorestPoint
            if (dist < shorestDist) {
                shorestDist = dist;
                shorestPoint.setLocation(curPoint);
            }
        }

        return shorestPoint;
    }

    /**
     * <p>
     * Checks whether the given Object is zero or negative.
     * </p>
     *
     * @param arg the argument to check
     * @param name the name of the argument to check
     *
     * @throws IllegalArgumentException if the given argument is zero or negative
     */
    static void checkNotPositive(int arg, String name) {
        if (arg <= 0) {
            throw new IllegalArgumentException(name + " is not positive, its value is " + arg);
        }
    }

    /**
     * <p>
     * Get the offset between the given start point and end point.
     * </p>
     *
     * @param startPoint the start point
     * @param endPoint the end point
     *
     * @return the offset of start point and end point
     */
    static Point getOffset(Point startPoint, Point endPoint) {
        return new Point(endPoint.x - startPoint.x, endPoint.y - startPoint.y);
    }

    /**
     * <p>
     * Compute the angle that the vector defined by given segment makes with the X-axis..
     * </p>
     *
     * <p>
     * The angle will be in the range [-PI, PI] radians.
     * </p>
     * @param start the start point of the segment
     * @param stop the end point of the segment
     *
     * @return the angle this segment makes with the X-axis (in radians)
     */
    static double calculateLineAngle(Point start, Point stop) {
        return atan2(stop.y - start.y, stop.x - start.x);
    }

    /**
     * <p>
     * Compute the Projection Factor for the projection of the given point pt onto
     * the line segment defined by given start and end points.
     * </p>
     *
     * <p>
     * The Projection Factor is computed as the following formula:
     * <pre>
     * project factor = (AC dot AB) / (||AB|| ^ 2)
     * </pre>
     * <b>C</b> is the given point <b>pt</b>, while <b>A</b> is the given start point and <b>B</b> is the
     * given end point.
     * <p>
     *
     * <p>
     * The project factor has the following meaning:
     * <ul>
     * <li>r = 0 : P = A</li>
     * <li>r = 1 : P = B</li>
     * <li>r &lt; 0 : P is on the backward extension of AB</li>
     * <li>r &gt; 1 : P is on the forward extension of AB</li>
     * <li>0 &lt; r &lt; 1 : P is interior to AB</li>
     * </ul>
     * Note, <b>P</b> is the projected point of the given point <b>pt</b>
     * on the segment (defined by <b>A</b> and <b>B</b>)
     * </p>
     *
     * @param pt the point to get the closest point on the given segment
     * @param start the start point of the segment
     * @param stop the stop point of the segment
     *
     * @return the project factor for the projection from the given point onto the line segment
     */
    private static double projectionFactor(Point pt, Point start, Point stop) {
        if (pt.equals(start)) {
            return 0.0;
        }

        if (pt.equals(stop)) {
            return 1.0;
        }

        double dx = stop.x - start.x;
        double dy = stop.y - start.y;

        // calculate the value of (||AB|| ^ 2)
        double len2 = dx * dx + dy * dy;

        // calculate the value of (AC dot AB) / (||AB|| ^ 2)
        return ((pt.x - start.x) * dx + (pt.y - start.y) * dy) / len2;
    }

    /**
     * <p>
     * Compute the closest point on given segment defined by the given start and end points to the given point.
     * </p>
     *
     * @param pt the point to get the closest point on the given segment
     * @param start the start point of the segment
     * @param stop the stop point of the segment
     * @param destPoint the closest point on the given segment to the given point
     *
     * @return the closest distance from the given point to the given segment
     */
    static double getClosestPoint(Point pt, Point start, Point stop, Point destPoint) {

        double factor = projectionFactor(pt, start, stop);

        // the closest point is interior to the segment
        if (factor > 0 && factor < 1) {
            double x = start.x + factor * (stop.x - start.x);
            double y = start.y + factor * (stop.y - start.y);

            destPoint.setLocation(x, y);
            return destPoint.distance(pt);
        }

        double dist1 = start.distance(pt);
        double dist2 = stop.distance(pt);

        // the closest point is the start point of the segment
        if (dist1 < dist2) {
            destPoint.setLocation(start);
            return dist1;
        }

        // the closest point is the end point of the segment
        destPoint.setLocation(stop);
        return dist2;
    }

    /**
     * <p>
     * Set the edge as the active component in diagram viewer.
     * </p>
     *
     * @param edge the Edge instance to active
     */
    static void setEdgeActive(Edge edge) {
        DiagramViewer diagramViewer = edge.getDiagramViewer();
        if (diagramViewer != null) {
            diagramViewer.addSelectedElement(edge);
        }
    }

    /*
     * BugFix: BUGID UML-7694
     * Description:
     * The Diagram Edges component should use the color mentioned in the properties of
     * GraphEdge to paint the edge - the stroke color.
     * The component should also use the font family, font color and font size properties
     * of GraphEdge to paint the text fields anchored to the edge.
     * The names of the properties should be configurable.
     * The color values are represented like this: "#RRGGBB".
     * Solution:
     * Add the property map, which is used to get the property keys. Add strokeColor and
     * fontColor fields. Add a public notifyProperitesChange method to retrieve properties
     * from graph edge. Add a setter of fontColor to TextField class.
     */
    /**
     * <p>
     * Gets the property in GraphEdge through predefined key.
     * </p>
     * @param graphEdge
     *            the graph edge containing properties
     * @param properties
     *            the property names defined in node.
     * @param key
     *            the predefined key
     * @return the property value in GraphEdge, null if not found
     */
    static String getPropertyValue(GraphEdge graphEdge, Map<String, String> properties, String key) {
        String propertyKey = properties.get(key);
        if (propertyKey == null) {
            return null;
        }
        for (Property property : graphEdge.getProperties()) {
            if (property.getKey() == propertyKey) {
                return property.getValue();
            }
        }
        return null;
    }

    /**
     * <p>
     * Parses color property string.
     * </p>
     * @param value
     *            a string which means RRGGBB value (like #0F0F0F)
     * @return a Color object, null if given argument is null or incorrect
     */
    static Color parseColor(String value) {
        try {
            return Color.decode(value);
        } catch (NumberFormatException e) {
            return null;
        }
    }

    /**
     * <p>
     * Parses font family string.
     * </p>
     * @param value
     *            a string which represents font family
     * @return font family value, "Arial" if given argument is null
     */
    static String parseFontFamily(String value) {
        if (value == null) {
            return "Arial";
        }
        return value;
    }

    /**
     * <p>
     * Parses font style string.
     * </p>
     * @param value
     *            a string which represents font style
     * @return font style value, 0 if given argument is null or incorrect
     */
    static int parseFontStyle(String value) {
        if (value == null) {
            return 0;
        }
        try {
            return Integer.parseInt(value);
        } catch (NumberFormatException e) {
            return 0;
        }
    }

    /**
     * <p>
     * Parses font size string.
     * </p>
     * @param value
     *            a string which represents font size
     * @return font size value, 10.0 if given argument is null or incorrect
     */
    static double parseFontSize(String value) {
        if (value == null) {
            return 10.0;
        }
        try {
            return Double.parseDouble(value);
        } catch (NumberFormatException e) {
            return 10.0;
        }
    }
}
