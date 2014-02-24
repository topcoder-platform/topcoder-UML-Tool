/*
 * Copyright (C) 2007 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.gui.diagramviewer.uml.classelements.event;

import java.awt.Point;
import java.util.EventObject;

import com.topcoder.gui.diagramviewer.elements.Node;
import com.topcoder.gui.diagramviewer.uml.classelements.Util;

/**
 * <p>
 * This is an event object used to indicate a new edge will be added to the PackageNode or BaseNode. It contains two
 * properties. Location property tells where the edge ending should be added, and IsStart property tells whether the
 * ending is a start or an end of edge.
 * </p>
 * <p>
 * PackageNode or BaseNode can be retrieved by getSource(), and added edge type can be retrieved from diagram viewer.
 * </p>
 * <p>
 * This class is immutable, and thread-safe.
 * </p>
 * @author MiG-29, TCSDEVELOPER
 * @version 1.0
 */
public class EdgeAddEvent extends EventObject {

    /**
     * <p>
     * Represents the location where the edge ending should be added, Initialized in constructor, never changed later.
     * Can't be null.
     * </p>
     */
    private final Point location;

    /**
     * <p>
     * Represents a flag indicating whether the ending is a start or an end of edge. Initialized in constructor, never
     * changed later. Can be any value.
     * </p>
     */
    private final boolean isStart;

    /**
     * <p>
     * Constructs an edge add event.
     * </p>
     * @param source
     *            the node (PackageNode or BaseNode) to add new node to
     * @param location
     *            representing one of edge ending
     * @param isStart
     *            tells whether it is start of end of edge
     * @throws IllegalArgumentException
     *             if given source, or location is null
     */
    public EdgeAddEvent(Node source, Point location, boolean isStart) {
        super(source);
        Util.checkNotNull(location, "location");
        this.location = location;
        this.isStart = isStart;
    }

    /**
     * <p>
     * Getter of location field.
     * </p>
     * @return the location value
     */
    public Point getLocation() {
        return location;
    }

    /**
     * <p>
     * Getter of isStart field.
     * </p>
     * @return the isStart flag
     */
    public boolean isStart() {
        return isStart;
    }
}
