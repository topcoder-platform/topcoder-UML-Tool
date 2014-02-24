/*
 * Copyright (C) 2007, TopCoder, Inc. All rights reserved
 */
package com.topcoder.gui.diagramviewer.elements.failuretests;


import java.awt.Point;
import java.awt.Rectangle;
import java.util.ArrayList;

import junit.framework.TestCase;

import com.topcoder.diagraminterchange.GraphNode;
import com.topcoder.gui.diagramviewer.elements.MockNodeContainerFailure;
import com.topcoder.gui.diagramviewer.elements.Node;
import com.topcoder.gui.diagramviewer.elements.SelectionBoundEvent;
import com.topcoder.gui.diagramviewer.elements.SelectionCornerType;

/**
 * <p>
 * This class aggregates failure tests for SelectionBoundEvent class.
 * </p>
 * 
 * @author ch_music
 * @version 1.0
 */
public class SelectionBoundEventFailureTests extends TestCase {

    /**
     * A Rectangle object for testing purposes.
     */
    private Rectangle bound = new Rectangle();

    /**
     * A Node object for testing purposes.
     */
    private Node node = new MockNodeContainerFailure(new GraphNode(), new Point(1, 1), bound,
            new ArrayList<SelectionCornerType>());

    /**
     * Tests constructor with null node argument. IllegalArgumentException is expected.
     */
    public void testSelectionBoundEvent_NullNodeArgument() {
        try {
            new SelectionBoundEvent(null, bound, bound);
            fail("Did not throw IAE with null node argument.");
        } catch (IllegalArgumentException e) {
            // Expected case.
            assertNotNull("Exception message must not be null.", e.getMessage());
            assertNotSame("Exception message must not be empty string.", "", e.getMessage());
        }
    }

    /**
     * Tests constructor with null oldBound argument. IllegalArgumentException is expected.
     */
    public void testSelectionBoundEvent_NullOldBoundArgument() {
        try {
            new SelectionBoundEvent(node, null, bound);
            fail("Did not throw IAE with null oldBound argument.");
        } catch (IllegalArgumentException e) {
            // Expected case.
            assertNotNull("Exception message must not be null.", e.getMessage());
            assertNotSame("Exception message must not be empty string.", "", e.getMessage());
        }
    }

    /**
     * Tests constructor with null newBound argument. IllegalArgumentException is expected.
     */
    public void testSelectionBoundEvent_NullNewBoundArgument() {
        try {
            new SelectionBoundEvent(node, bound, null);
            fail("Did not throw IAE with null newBound argument.");
        } catch (IllegalArgumentException e) {
            // Expected case.
            assertNotNull("Exception message must not be null.", e.getMessage());
            assertNotSame("Exception message must not be empty string.", "", e.getMessage());
        }
    }
}
