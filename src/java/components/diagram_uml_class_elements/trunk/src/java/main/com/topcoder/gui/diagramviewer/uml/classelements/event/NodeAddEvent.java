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
 * This is an event object used to indicate a new node will be added to PackageNode or BaseNode. It only contains one
 * location property, which tells where the new element should be added.
 * </p>
 * <p>
 * PackageNode or BaseNode can be retrieved by getSource(), and added node type can be retrieved from diagram viewer.
 * </p>
 * <p>
 * This class is immutable, and thread-safe.
 * </p>
 * @author MiG-29, TCSDEVELOPER
 * @version 1.0
 */
public class NodeAddEvent extends EventObject {

    /**
     * <p>
     * Represents the location where the new node will be added. Initialized in constructor, never changed later. Can't
     * be null.
     * </p>
     */
    private final Point location;

    /**
     * <p>
     * Creates an instance of <code>NodeAddEvent</code>.
     * </p>
     * @param source
     *            the node (PackageNode or BaseNode) to add new node to
     * @param location
     *            where the new node will be added
     * @throws IllegalArgumentException
     *             if given source or location is null
     */
    public NodeAddEvent(Node source, Point location) {
        super(source);
        Util.checkNotNull(location, "location");
        this.location = location;
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
}
