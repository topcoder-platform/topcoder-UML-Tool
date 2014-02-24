/*
 * Copyright (C) 2007 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.gui.diagramviewer.uml.usecaseelements.event;

import java.awt.Rectangle;

import junit.framework.TestCase;

import com.topcoder.gui.diagramviewer.elements.Node;
import com.topcoder.gui.diagramviewer.uml.usecaseelements.TestHelper;

/**
 * <p>
 * Unit test cases for BoundaryChangedEvent.
 * </p>
 *
 * @author TCSDEVELOPER
 * @version 1.0
 */
public class BoundaryChangedEventTests extends TestCase {
    /**
     * <p>
     * BoundaryChangedEvent instance for testing.
     * </p>
     */
    private BoundaryChangedEvent event;

    /**
     * <p>
     * Node instance for testing.
     * </p>
     */
    private Node node;

    /**
     * <p>
     * Rectangle instance for testing.
     * </p>
     */
    private Rectangle oldBound;

    /**
     * <p>
     * Rectangle instance for testing.
     * </p>
     */
    private Rectangle newBound;

    /**
     * <p>
     * String instance for testing.
     * </p>
     */
    private String message = "reason";

    /**
     * <p>
     * Sets up test environment.
     * </p>
     */
    protected void setUp() {
        node = (Node) TestHelper.createSubsystemNodeContainer();
        oldBound = new Rectangle(10, 10);
        newBound = new Rectangle(20, 20);
    }

    /**
     * <p>
     * Tears down test environment.
     * </p>
     */
    protected void tearDown() {
        node = null;
        oldBound = null;
        newBound = null;
    }

    /**
     * <p>
     * Tests BoundaryChangedEvent#BoundaryChangedEvent(Node,Rectangle,Rectangle) for accuracy.
     * </p>
     * <p>
     * It verifies the newly created BoundaryChangedEvent instance should not be null.
     * </p>
     */
    public void testCtor1() {
        event = new BoundaryChangedEvent(node, oldBound, newBound);
        assertNotNull("Failed to create a BoundaryChangedEvent instance.", event);
    }

    /**
     * <p>
     * Tests BoundaryChangedEvent#BoundaryChangedEvent(Node,Rectangle,Rectangle,string) for accuracy.
     * </p>
     * <p>
     * It verifies the newly created BoundaryChangedEvent instance should not be null.
     * </p>
     */
    public void testCtor2() {
        event = new BoundaryChangedEvent(node, oldBound, newBound, message);
        assertNotNull("Failed to create a BoundaryChangedEvent instance.", event);
    }

    /**
     * <p>
     * Tests BoundaryChangedEvent#BoundaryChangedEvent(Node,Rectangle,Rectangle) for failure.
     * </p>
     * <p>
     * It tests the case that when node is null and expects IllegalArgumentException.
     * </p>
     */
    public void testCtor1_NullNode() {
        try {
            new BoundaryChangedEvent(null, oldBound, newBound);
            fail("IllegalArgumentException expected.");
        } catch (IllegalArgumentException iae) {
            // the expected case
        }
    }

    /**
     * <p>
     * Tests BoundaryChangedEvent#BoundaryChangedEvent(Node,Rectangle,Rectangle,String) for failure.
     * </p>
     * <p>
     * It tests the case that when node is null and expects IllegalArgumentException.
     * </p>
     */
    public void testCtor2_NullNode() {
        try {
            new BoundaryChangedEvent(null, oldBound, newBound, message);
            fail("IllegalArgumentException expected.");
        } catch (IllegalArgumentException iae) {
            // the expected case
        }
    }

    /**
     * <p>
     * Tests BoundaryChangedEvent#BoundaryChangedEvent(Node,Rectangle,Rectangle) for failure.
     * </p>
     * <p>
     * It tests the case that when oldBound is null and expects IllegalArgumentException.
     * </p>
     */
    public void testCtor1_NullOldBound() {
        try {
            new BoundaryChangedEvent(node, null, newBound);
            fail("IllegalArgumentException expected.");
        } catch (IllegalArgumentException iae) {
            // the expected case
        }
    }

    /**
     * <p>
     * Tests BoundaryChangedEvent#BoundaryChangedEvent(Node,Rectangle,Rectangle,String) for failure.
     * </p>
     * <p>
     * It tests the case that when oldBound is null and expects IllegalArgumentException.
     * </p>
     */
    public void testCtor2_NullOldBound() {
        try {
            new BoundaryChangedEvent(node, null, newBound, message);
            fail("IllegalArgumentException expected.");
        } catch (IllegalArgumentException iae) {
            // the expected case
        }
    }

    /**
     * <p>
     * Tests BoundaryChangedEvent#BoundaryChangedEvent(Node,Rectangle,Rectangle) for failure.
     * </p>
     * <p>
     * It tests the case that when newBound is null and expects IllegalArgumentException.
     * </p>
     */
    public void testCtor1_NullNewBound() {
        try {
            new BoundaryChangedEvent(node, oldBound, null);
            fail("IllegalArgumentException expected.");
        } catch (IllegalArgumentException iae) {
            // the expected case
        }
    }

    /**
     * <p>
     * Tests BoundaryChangedEvent#BoundaryChangedEvent(Node,Rectangle,Rectangle,String) for failure.
     * </p>
     * <p>
     * It tests the case that when newBound is null and expects IllegalArgumentException.
     * </p>
     */
    public void testCtor2_NullNewBound() {
        try {
            new BoundaryChangedEvent(node, oldBound, null, message);
            fail("IllegalArgumentException expected.");
        } catch (IllegalArgumentException iae) {
            // the expected case
        }
    }

    /**
     * <p>
     * Tests BoundaryChangedEvent#getSource() for accuracy.
     * </p>
     * <p>
     * It verifies BoundaryChangedEvent#getSource() is correct when use BoundaryChangedEvent(Node,Rectangle,Rectangle)
     * to construct the instance.
     * </p>
     */
    public void testGetSource1() {
        event = new BoundaryChangedEvent(node, oldBound, newBound);
        assertSame("Failed to get the source correctly.", node, event.getSource());
        assertTrue("Failed to get the source correctly.", event.getSource() instanceof Node);
    }

    /**
     * <p>
     * Tests BoundaryChangedEvent#getOldBound() for accuracy.
     * </p>
     * <p>
     * It verifies BoundaryChangedEvent#getOldBound() is correct when use BoundaryChangedEvent(Node,Rectangle,Rectangle)
     * to construct the instance.
     * </p>
     */
    public void testGetOldBoundary1() {
        event = new BoundaryChangedEvent(node, oldBound, newBound);
        assertSame("Failed to get the oldBound correctly.", oldBound, event.getOldBoundary());
    }

    /**
     * <p>
     * Tests BoundaryChangedEvent#getNewBound() for accuracy.
     * </p>
     * <p>
     * It verifies BoundaryChangedEvent#getNewBound() is correct when use BoundaryChangedEvent(Node,Rectangle,Rectangle)
     * to construct the instance.
     * </p>
     */
    public void testGetNewBoundary1() {
        event = new BoundaryChangedEvent(node, oldBound, newBound);
        assertSame("Failed to get the newBound correctly.", newBound, event.getNewBoundary());
    }

    /**
     * <p>
     * Tests BoundaryChangedEvent#getMessage() for accuracy.
     * </p>
     * <p>
     * It verifies BoundaryChangedEvent#getMessage() is correct when use BoundaryChangedEvent(Node,Rectangle,Rectangle)
     * to construct the instance.
     * </p>
     */
    public void testGetMessage1() {
        event = new BoundaryChangedEvent(node, oldBound, newBound);
        assertNull("Failed to get the message correctly.", event.getMessage());
    }

    /**
     * <p>
     * Tests BoundaryChangedEvent#getSource() for accuracy.
     * </p>
     * <p>
     * It verifies BoundaryChangedEvent#getSource() is correct when use
     * BoundaryChangedEvent(Node,Rectangle,Rectangle,String) to construct the instance.
     * </p>
     */
    public void testGetSource2() {
        event = new BoundaryChangedEvent(node, oldBound, newBound, message);
        assertSame("Failed to get the source correctly.", node, event.getSource());
        assertTrue("Failed to get the source correctly.", event.getSource() instanceof Node);
    }

    /**
     * <p>
     * Tests BoundaryChangedEvent#getOldBound() for accuracy.
     * </p>
     * <p>
     * It verifies BoundaryChangedEvent#getOldBound() is correct when use
     * BoundaryChangedEvent(Node,Rectangle,Rectangle,String) to construct the instance.
     * </p>
     */
    public void testGetOldBoundary2() {
        event = new BoundaryChangedEvent(node, oldBound, newBound, message);
        assertSame("Failed to get the oldBound correctly.", oldBound, event.getOldBoundary());
    }

    /**
     * <p>
     * Tests BoundaryChangedEvent#getNewBound() for accuracy.
     * </p>
     * <p>
     * It verifies BoundaryChangedEvent#getNewBound() is correct when use
     * BoundaryChangedEvent(Node,Rectangle,Rectangle,String) to construct the instance.
     * </p>
     */
    public void testGetNewBoundary2() {
        event = new BoundaryChangedEvent(node, oldBound, newBound, message);
        assertSame("Failed to get the newBound correctly.", newBound, event.getNewBoundary());
    }

    /**
     * <p>
     * Tests BoundaryChangedEvent#getMessage() for accuracy.
     * </p>
     * <p>
     * It verifies BoundaryChangedEvent#getMessage() is correct when use
     * BoundaryChangedEvent(Node,Rectangle,Rectangle,String) to construct the instance.
     * </p>
     */
    public void testGetMessage2() {
        event = new BoundaryChangedEvent(node, oldBound, newBound, message);
        assertEquals("Failed to get the message correctly.", message, event.getMessage());
    }
}
