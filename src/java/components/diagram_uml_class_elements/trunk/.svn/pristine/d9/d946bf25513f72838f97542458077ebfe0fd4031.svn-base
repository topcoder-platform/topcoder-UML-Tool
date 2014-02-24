/*
 * Copyright (C) 2007 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.gui.diagramviewer.uml.classelements;

import java.awt.Dimension;
import java.awt.Point;
import java.awt.Rectangle;

import com.topcoder.gui.diagramviewer.edges.Connector;
import com.topcoder.gui.diagramviewer.edges.connectors.RectangleConnector;

/**
 * <p>
 * This class is the connector used to connect to ClassNode. It is relatively simple, as the shape of class is a
 * rectangle, some compartments are contained in the rectangle, and others are tightly stacked on the body rectangle.
 * </p>
 * <p>
 * This class is immutable, and thread-safe.
 * </p>
 * @author MiG-29, TCSDEVELOPER
 * @version 1.0
 */
public class ClassConnector implements Connector {
    /**
     * <p>
     * Represents the node containing this connector. Initialized in constructor, never changed later. Can't be null.
     * </p>
     */
    private final ClassNode parent;

    /**
     * <p>
     * Creates an instance of <code>ClassConnector</code>.
     * </p>
     * @param parent
     *            the node containing this connector
     * @throws IllegalArgumentException
     *             if parent is null
     */
    public ClassConnector(ClassNode parent) {
        Util.checkNotNull(parent, "parent");
        this.parent = parent;
    }

    /**
     * <p>
     * Implements the getConnectionPoint method in Connector interface.
     * </p>
     * @param wayPoint
     *            the way point to be connected
     * @return the target connection point
     * @throws IllegalArgumentException
     *             if given wayPoint is null
     */
    public Point getConnectionPoint(Point wayPoint) {
        Util.checkNotNull(wayPoint, "wayPoint");

        // Get the visual node's bound
        Point position = parent.getLocation();
        position.x += parent.getSelectionBound().x;
        position.y += parent.getSelectionBound().y;
        Dimension size = parent.getSelectionBound().getSize();
        Rectangle bound = new Rectangle(position, size);

        return new RectangleConnector(bound).getConnectionPoint(wayPoint);
    }
}
