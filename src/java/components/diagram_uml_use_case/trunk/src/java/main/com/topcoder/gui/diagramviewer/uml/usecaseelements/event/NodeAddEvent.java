/*
 * Copyright (C) 2007 TopCoder Inc., All Rights Reserved.
 */

package com.topcoder.gui.diagramviewer.uml.usecaseelements.event;

import com.topcoder.gui.diagramviewer.uml.usecaseelements.SubsystemNodeContainer;
import com.topcoder.gui.diagramviewer.uml.usecaseelements.Utils;

import java.awt.Point;
import java.util.EventObject;

/**
 * <p>
 * This is an event object used to indicate a new node will be added to SubsystemContainer. It contains only contains
 * one location property, which tells where the new element should be added.
 * </p>
 * <p>
 * SubsystemContainer can be retrieved by getSource(), and added node type can be retrieved from diagram viewer.
 * </p>
 * <p>
 * <b>Thread Safety</b>: This class is immutable, and thread-safe.
 * </p>
 *
 * @author maone, TCSDEVELOPER
 * @version 1.0
 */
public class NodeAddEvent extends EventObject {

    /**
     * Represents the location where the new node will be added. Initialized in constructor, never changed later. Can't
     * be null.
     */
    private final Point location;

    /**
     * Construct a node add event.
     *
     * @param source the SubsystemContainer to add new node to
     * @param location where the new node will be added
     * @throws IllegalArgumentException if any argument is null
     */
    public NodeAddEvent(SubsystemNodeContainer source, Point location) {
        super(source);
        Utils.checkNull(location, "location");
        this.location = location;
    }

    /**
     * Getter of location field. See field document for explanation.
     *
     * @return the location value.
     */
    public Point getLocation() {
        return location;
    }
}
