/*
 * Copyright (C) 2007 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.gui.diagramviewer.edges;

import java.awt.Point;

/**
 * <p>
 * This interface defines the contract every connector must follow.
 * </p>
 *
 * <p>
 * Edge should be connected to the closest point of node. However,
 * nodes have difference shapes, so we need to compute the connection point differently.
 * </p>
 *
 * <p>
 * This interface contains the method which receives the nearest way point of edge and will
 * return the connector point.
 * </p>
 *
 * <p>
 * Thread Safety : The implementations of this interface are not required to be thread safe.
 * UI components' thread safe issue should be cared by user.
 * </p>
 *
 * @author maone, TCSDEVELOPER
 * @version 1.0
 */
public interface Connector {
    /**
     * <p>
     * Get the connection point with given way point of edge.
     * </p>
     *
     * @param wayPoint the nearest way point of edge.
     * @return the connector point.
     *
     * @throws IllegalArgumentException if wayPoint is null.
     */
    public Point getConnectionPoint(Point wayPoint);
}
