/*
 * Copyright (C) 2007 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.gui.diagramviewer.uml.usecaseelements.event;

import java.awt.Point;
import java.util.EventObject;

import com.topcoder.gui.diagramviewer.uml.usecaseelements.SubsystemNodeContainer;
import com.topcoder.gui.diagramviewer.uml.usecaseelements.Utils;

/**
 * <p>
 * This is an event object used to indicate a new edge will be added to SubsystemContainer. It contains two properties.
 * Location property tells where the edge ending should be added, and IsStart property tells whether the ending is a
 * start or an end of edge.
 * </p>
 * <p>
 * SubsystemContainer can be retrieved by getSource(), and added edge type can be retrieved from diagram viewer.
 * </p>
 * <p>
 * <b>Thread Safety</b>: This class is immutable, and thread-safe.
 * </p>
 *
 * @author maone, TCSDEVELOPER
 * @version 1.0
 */
public class EdgeAddEvent extends EventObject {

    /**
     * Represents the location where the edge ending should be added, Initialized in constructor, never changed later.
     * Can't be null.
     */
    private final Point location;

    /**
     * Represents a flag indicating whether the ending is a start or an end of edge. Initialized in constructor, never
     * changed later.
     */
    private final boolean isStart;

    /**
     * Construct an edge add event.
     *
     * @param source the SubsystemContainer to add new node to
     * @param location representing one of edge ending.
     * @param isStart tells whether it is start of end of edge.
     * @throws IllegalArgumentException if parameter source or location is null
     */
    public EdgeAddEvent(SubsystemNodeContainer source, Point location, boolean isStart) {
        super(source);
        Utils.checkNull(location, "location");
        this.location = location;
        this.isStart = isStart;
    }

    /**
     * Getter of location field. See field document for explanation.
     *
     * @return the location value.
     */
    public Point getLocation() {
        return this.location;
    }

    /**
     * Getter of isStart field. See field document for explanation.
     *
     * @return the isStart flag.
     */
    public boolean isStart() {
        return this.isStart;
    }
}
