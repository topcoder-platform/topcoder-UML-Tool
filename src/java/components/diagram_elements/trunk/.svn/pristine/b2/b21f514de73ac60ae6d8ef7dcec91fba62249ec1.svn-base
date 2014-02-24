/*
 * Copyright (C) 2007, TopCoder, Inc. All rights reserved
 */
package com.topcoder.gui.diagramviewer.elements.failuretests;


import java.awt.Point;
import java.awt.Rectangle;
import java.util.ArrayList;

import junit.framework.TestCase;

import com.topcoder.diagraminterchange.GraphNode;
import com.topcoder.gui.diagramviewer.elements.LocationEvent;
import com.topcoder.gui.diagramviewer.elements.MockNodeContainerFailure;
import com.topcoder.gui.diagramviewer.elements.Node;
import com.topcoder.gui.diagramviewer.elements.SelectionCornerType;

/**
 * <p>
 * This class aggregates failure tests for LocationEvent class.
 * </p>
 * 
 * @author ch_music
 * @version 1.0
 */
public class LocationEventFailureTests extends TestCase {

    /**
     * A Point object for testing purposes.
     */
    private Point location = new Point(1, 1);

    /**
     * A Node object for testing purposes.
     */
    private Node node = new MockNodeContainerFailure(new GraphNode(), location, new Rectangle(),
            new ArrayList<SelectionCornerType>());

    /**
     * Tests constructor with null node argument. IllegalArgumentException is expected.
     */
    public void testLocationEvent_NullNodeArgument() {
        try {
            new LocationEvent(null, location, location);
            fail("Did not throw IAE with null node argument.");
        } catch (IllegalArgumentException e) {
            // Expected case.
            assertNotNull("Exception message must not be null.", e.getMessage());
            assertNotSame("Exception message must not be empty string.", "", e.getMessage());
        }
    }

    /**
     * Tests constructor with null oldLocation argument. IllegalArgumentException is expected.
     */
    public void testLocationEvent_NullOldLocationArgument() {
        try {
            new LocationEvent(node, null, location);
            fail("Did not throw IAE with null oldLocation argument.");
        } catch (IllegalArgumentException e) {
            // Expected case.
            assertNotNull("Exception message must not be null.", e.getMessage());
            assertNotSame("Exception message must not be empty string.", "", e.getMessage());
        }
    }

    /**
     * Tests constructor with null newLocation argument. IllegalArgumentException is expected.
     */
    public void testLocationEvent_NullNewLocationArgument() {
        try {
            new LocationEvent(node, location, null);
            fail("Did not throw IAE with null newLocation argument.");
        } catch (IllegalArgumentException e) {
            // Expected case.
            assertNotNull("Exception message must not be null.", e.getMessage());
            assertNotSame("Exception message must not be empty string.", "", e.getMessage());
        }
    }
}
