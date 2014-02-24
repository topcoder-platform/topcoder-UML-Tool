/*
 * Copyright (C) 2007 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.gui.diagramviewer.uml.usecaseelements.event;

import java.awt.Point;

import junit.framework.TestCase;

import com.topcoder.gui.diagramviewer.uml.usecaseelements.SubsystemNodeContainer;
import com.topcoder.gui.diagramviewer.uml.usecaseelements.TestHelper;

/**
 * <p>
 * Unit test cases for NodeAddEvent.
 * </p>
 *
 * @author TCSDEVELOPER
 * @version 1.0
 */
public class NodeAddEventTests extends TestCase {
    /**
     * <p>
     * NodeAddEvent instance for testing.
     * </p>
     */
    private NodeAddEvent event;

    /**
     * <p>
     * SubsystemNodeContainer instance for testing.
     * </p>
     */
    private SubsystemNodeContainer source;

    /**
     * <p>
     * Point instance for testing.
     * </p>
     */
    private Point location;

    /**
     * <p>
     * Sets up test environment.
     * </p>
     */
    protected void setUp() {
        location = new Point();
        source = TestHelper.createSubsystemNodeContainer();
        event = new NodeAddEvent(source, location);
    }

    /**
     * <p>
     * Tears down test environment.
     * </p>
     */
    protected void tearDown() {
        location = null;
        source = null;
        event = null;
    }

    /**
     * <p>
     * Tests NodeAddEvent#NodeAddEvent(SubsystemNodeContainer, Point) for accuracy.
     * </p>
     * <p>
     * It verifies he newly created NodeAddEvent instance should not be null.
     * </p>
     */
    public void testCtor() {
        assertNotNull("Failed to create a NodeAddEvent instance.", event);
    }

    /**
     * <p>
     * Tests NodeAddEvent#NodeAddEvent(SubsystemNodeContainer, Point) for failure.
     * </p>
     * <p>
     * It tests the case that when source is null and expects IllegalArgumentException.
     * </p>
     */
    public void testCtor_NullSource() {
        try {
            new NodeAddEvent(null, location);
            fail("IllegalArgumentException expected.");
        } catch (IllegalArgumentException iae) {
            // the expected case
        }
    }

    /**
     * <p>
     * Tests NodeAddEvent#NodeAddEvent(SubsystemNodeContainer, Point) for failure.
     * </p>
     * <p>
     * It tests the case that when location is null and expects IllegalArgumentException.
     * </p>
     */
    public void testCtor_NullPoint() {
        try {
            new NodeAddEvent(source, null);
            fail("IllegalArgumentException expected.");
        } catch (IllegalArgumentException iae) {
            // the expected case
        }
    }

    /**
     * <p>
     * Tests NodeAddEvent#getSource() for accuracy.
     * </p>
     * <p>
     * It verifies NodeAddEvent#getSource() is correct.
     * </p>
     */
    public void testGetSource() {
        assertSame("Failed to get the source correctly", source, event.getSource());
        assertTrue("Failed to get the source correctly", event.getSource() instanceof SubsystemNodeContainer);
    }

    /**
     * <p>
     * Tests NodeAddEvent#getLocation() for accuracy.
     * </p>
     * <p>
     * It verifies NodeAddEvent#getLocation() is correct.
     * </p>
     */
    public void testGetLocation() {
        assertSame("Failed to get the location correctly", location, event.getLocation());
    }
}
