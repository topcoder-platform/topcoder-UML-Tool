/*
 * Copyright (C) 2007 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.gui.diagramviewer.edges.connectors;

import java.awt.Rectangle;
import com.topcoder.gui.diagramviewer.edges.Connector;
import com.topcoder.gui.diagramviewer.edges.Util;

import java.awt.Point;

/**
 * <p>
 * This class implements the Connector interface and is the default connector for rectangle
 * shaped element.
 * </p>
 *
 * <p>
 * Thread Safety : This class is mutable, and not thread safe.
 * </p>
 *
 * @author maone, TCSDEVELOPER
 * @version 1.0
 */
public class RectangleConnector implements Connector {
    /**
     * <p>
     * Represent the rectangle for this connector.
     * </p>
     *
     * <p>
     * It will be used to compute the connection point.
     * </p>
     *
     * <p>
     * It is initialized in the constructor, and can be accessed by setter/getter.
     * It will never null.
     * </p>
     *
     */
    private Rectangle rectangle;

    /**
     * <p>
     * Construct a RectangleConnector with its rectangle given.
     * </p>
     *
     * <p>
     * Note, the given rectangle is cloned.
     * </p>
     *
     * @param rectangle the rectangle defined for this connector.
     *
     * @throws IllegalArgumentException if given arg is null.
     */
    public RectangleConnector(Rectangle rectangle) {
        Util.checkNull(rectangle, "rectangle");

        this.rectangle = new Rectangle(rectangle);
    }

    /**
     * <p>
     * Get the rectangle defined for this connector.
     * </p>
     *
     * <p>
     * Note, the rectangle is cloned.
     * </p>
     *
     * @return the rectangle defined for this connector.
     */
    public Rectangle getRectangle() {
        return new Rectangle(rectangle);
    }

    /**
     * <p>
     * Set the rectangle defined for this connector.
     * </p>
     *
     * <p>
     * Note, the given rectangle is cloned.
     * </p>
     *
     * @param rectangle the new rectangle defined for the connector
     *
     * @throws IllegalArgumentException if rectangle is null
     */
    public void setRectangle(Rectangle rectangle) {
        Util.checkNull(rectangle, "rectangle");

        this.rectangle = new Rectangle(rectangle);
    }

    /**
     * <p>
     * Get the connection point for the nearest way point of edge.
     * </p>
     *
     * <p>
     * Iterate through the four edge of rectangle, and find the nearest connection point.
     * </p>
     *
     * @return the connector way point
     *
     * @param wayPoint the way point to be connected to the rectangle
     *
     * @throws IllegalArgumentException if wayPoint is null.
     */
    public Point getConnectionPoint(Point wayPoint) {
        Util.checkNull(wayPoint, "wayPoint");

        return Util.getClosestPoint(wayPoint, rectangle);
    }
}
