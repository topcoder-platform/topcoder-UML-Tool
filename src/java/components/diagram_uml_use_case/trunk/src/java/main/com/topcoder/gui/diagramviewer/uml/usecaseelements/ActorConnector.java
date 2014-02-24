/*
 * Copyright (C) 2007 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.gui.diagramviewer.uml.usecaseelements;

import com.topcoder.gui.diagramviewer.edges.Connector;
import java.awt.Point;
import java.awt.Rectangle;

/**
 * <p>
 * This class is the connector used to connect to ActorNode.
 * </p>
 * <p>
 * If name, stereotype and namespace compartments are visible, they will be taken in consideration. For simplicity (like
 * Poseidon), the actor shape is treated as a rectangle.
 * </p>
 * <p>
 * <b>Thread Safety</b>: This class is immutable, and thread-safe.
 * </p>
 *
 * @author maone, TCSDEVELOPER
 * @version 1.0
 */
public class ActorConnector implements Connector {
    /**
     * <p>
     * Represents the node containing this connector. Initialized in constructor, never changed later. Can't be null.
     * </p>
     */
    private final ActorNode parent;

    /**
     * <p>
     * Constructor. Simply assign the argument to fields.
     * </p>
     *
     * @param parent the node containing this connector.
     * @throws IllegalArgumentException if parent is null.
     */
    public ActorConnector(ActorNode parent) {
        Utils.checkNull(parent, "parent");
        this.parent = parent;
    }

    /**
     * <p>
     * Implement the getConnectionPoint method in Connector interface.
     * </p>
     *
     * @param wayPoint the way point to be connected
     * @return the target connection point.
     * @throws IllegalArgumentException if any argument is null.
     */
    public Point getConnectionPoint(Point wayPoint) {
        Utils.checkNull(wayPoint, "wayPoint");
        double shortestDist;
        Point shortestPoint = new Point();

        Point parentLocation = parent.getLocation(null);
        // rect will be the bounding rectangle of parent in swing coordinate
        Rectangle rect = new Rectangle(parentLocation.x + parent.getRelativePosition().x,
                parentLocation.y + parent.getRelativePosition().y,
                parent.getSelectionBound().width,
                parent.getSelectionBound().height);
        shortestDist = connectToRect(rect, wayPoint, shortestPoint);

        shortestDist = getShortestPoint(parent.getNameCompartment(), shortestDist, wayPoint, shortestPoint);
        shortestDist = getShortestPoint(parent.getStereotypeCompartment(), shortestDist, wayPoint, shortestPoint);
        getShortestPoint(parent.getNamespaceCompartment(), shortestDist, wayPoint, shortestPoint);

        return shortestPoint;
    }

    /**
     * <p>
     * Helper function that is used in getConnectionPoint().
     * </p>
     * <p>
     * If the textField is visible, and the distance connects to it is less than the shortestDist, then the shortestDist
     * and shortestPath will be set.
     * </p>
     *
     * @param textField the TextField that needs to calculate the shortest point
     * @param shortestDist the current shortest distance used to compare
     * @param wayPoint the way point to be connected
     * @param shortestPoint the shortest point. It is passed by caller, and filled in this method.
     * @return the shortest distance
     */
    private double getShortestPoint(TextField textField, double shortestDist, Point wayPoint, Point shortestPoint) {
        Point curPoint = new Point();
        if (textField.isVisible()) {
            double curDist = connectToRect(getTextFieldRect(textField), wayPoint, curPoint);
            if (curDist < shortestDist) {
                shortestDist = curDist;
                shortestPoint.setLocation(curPoint);
            }
        }
        return shortestDist;
    }

    /**
     * <p>
     * Helper function that return the rectangle of the given TextField.
     * </p>
     *
     * @param textField the desired TextField
     * @return the rectangle of the given textField
     */
    private Rectangle getTextFieldRect(TextField textField) {
        /*
         * BugFix: UML-10114
         */
        // old code
//        return new Rectangle(textField.getLocation().x, textField.getLocation().y,
//                textField.getSize().width, textField.getSize().height);
        return new Rectangle(textField.getLocation().x + textField.getParent().getX(), textField.getLocation().y +
                textField.getParent().getY(), textField.getSize().width, textField.getSize().height);
    }

    /**
     * <p>
     * Compute the connection point to a rectangle.
     * </p>
     *
     * @param rect the rectangle to connect to
     * @param point the point to connect
     * @param target the target point in the border of rectangle. It is passed by caller, and filled in this method.
     * @return the distance.
     */
    private double connectToRect(Rectangle rect, Point point, Point target) {
        // the shortest distance and the closest point
        // Initially the shortest distance is the maximum value of double and the closest point is (0, 0).
        double shorestDist = Double.MAX_VALUE;
        Point shorestPoint = new Point();

        // The four points on the rectangle
        Point[] rectPoints = new Point[] {rect.getLocation(), new Point(rect.x + rect.width, rect.y),
            new Point(rect.x + rect.width, rect.y + rect.height), new Point(rect.x, rect.y + rect.height)};

        // the curPoint represents the closest point for the current segment for the rectangle
        Point curPoint = new Point();

        // iterator each segment of the rectangle
        for (int i = 0; i < rectPoints.length; i++) {
            // get the closest point and distance for each segment
            double dist = Utils
                    .getClosestPoint(point, rectPoints[i], rectPoints[(i + 1) % rectPoints.length], curPoint);

            // a shorter distance is found, then update the shorestDist and shorestPoint
            if (dist < shorestDist) {
                shorestDist = dist;
                shorestPoint.setLocation(curPoint);
            }
        }

        target.setLocation(shorestPoint);
        return shorestDist;
    }
}
