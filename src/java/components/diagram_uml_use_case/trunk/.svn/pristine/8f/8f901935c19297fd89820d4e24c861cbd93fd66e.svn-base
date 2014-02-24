/*
 * Copyright (C) 2007 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.gui.diagramviewer.uml.usecaseelements;

import com.topcoder.gui.diagramviewer.edges.Connector;
import java.awt.Point;
import java.awt.geom.Ellipse2D;

/**
 * <p>
 * This class is the connector used to connect to UseCaseNode. It is relatively simple, as the shape of usecase is an
 * ellipse, and compartments are contained in ellipse, which we don't take consideration.
 * </p>
 * <p>
 * <b>Thread Safety</b>: This class is immutable, and thread-safe.
 * </p>
 *
 * @author maone, TCSDEVELOPER
 * @version 1.0
 */
public class UseCaseConnector implements Connector {
    /**
     * <p>
     * Represents the node containing this connector. Initialized in constructor, never changed later. Can't be null.
     * </p>
     */
    private final UseCaseNode parent;

    /**
     * <p>
     * Constructor. Simply assign the argument to fields.
     * </p>
     *
     * @param parent the node containing this connector.
     * @throws IllegalArgumentException if parent is null.
     */
    public UseCaseConnector(UseCaseNode parent) {
        Utils.checkNull(parent, "parent");
        this.parent = parent;
    }

    /**
     * <p>
     * Implement the getConnectionPoint method in Connector interface.
     * </p>
     *
     * <pre>
     *  1) Get bounded rectangle of ellipse as parent.getGraphNode().getSize();
     *  2) Compute an ellipse from the bounded rect
     *  3) Calculate connection point to ellipse.
     * </pre>
     *
     * @param wayPoint the way point to be connected
     * @return the target connection point.
     * @throws IllegalArgumentException if any argument is null.
     */
    public Point getConnectionPoint(Point wayPoint) {
        Utils.checkNull(wayPoint, "wayPoint");
        /*
         * BugFix: UML-10120
         */
        // old code
//        double x = parent.getGraphNode().getPosition().getX();
//        double y = parent.getGraphNode().getPosition().getY();
        Point location = Utils.getAbsolutePosition(parent.getGraphNode());
        double x = location.x;
        double y = location.y;
        double a = parent.getGraphNode().getSize().getWidth() / 2;
        double b = parent.getGraphNode().getSize().getHeight() / 2;

        Ellipse2D.Double ellipse = new Ellipse2D.Double(x, y, a * 2, b * 2);
        if (ellipse.contains(wayPoint.getX(), wayPoint.getY())) {
            // if the wayPoint in the ellipse, just return it
            return wayPoint;
        }

        double centerX = x + a;
        double centerY = y + b;

        if (wayPoint.x == centerX) {
            if (wayPoint.y <= y) {
                return new Point(wayPoint.x, (int) Math.round(y));
            } else {
                return new Point(wayPoint.x, (int) Math.round(centerY + b));
            }
        }

        double k = (wayPoint.y - centerY) / (wayPoint.x - centerX);
        double intersectX = Math.sqrt(1 / (1 / (a * a) + k * k / (b * b)));
        double intersectY = Math.abs(k * intersectX);
        if (wayPoint.x > centerX) {
            x = centerX + intersectX;
        } else {
            x = centerX - intersectX;
        }
        if (wayPoint.y > centerY) {
            y = centerY + intersectY;
        } else {
            y = centerY - intersectY;
        }

        return new Point((int) Math.round(x), (int) Math.round(y));
    }
}
