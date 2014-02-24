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
 * Unit test cases for EdgeAddEvent.
 * </p>
 *
 * @author TCSDEVELOPER
 * @version 1.0
 */
public class EdgeAddEventTests extends TestCase {
    /**
     * <p>
     * EdgeAddEvent instance for testing.
     * </p>
     */
    private EdgeAddEvent event;

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
        event = new EdgeAddEvent(source, location, true);
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
     * Tests EdgeAddEvent#EdgeAddEvent(SubsystemNodeContainer, Point, boolean) for accuracy.
     * </p>
     * <p>
     * It verifies the newly created EdgeAddEvent instance should not be null.
     * </p>
     */
    public void testCtor() {
        assertNotNull("Failed to create an EdgeAddEvent instance.", event);
    }

    /**
     * <p>
     * Tests EdgeAddEvent#EdgeAddEvent(SubsystemNodeContainer, Point, boolean) for failure.
     * </p>
     * <p>
     * It tests the case that when source is null and expects IllegalArgumentException.
     * </p>
     */
    public void testCtor_NullSource() {
        try {
            new EdgeAddEvent(null, location, true);
            fail("IllegalArgumentException expected.");
        } catch (IllegalArgumentException iae) {
            // the expected case
        }
    }

    /**
     * <p>
     * Tests EdgeAddEvent#EdgeAddEvent(SubsystemNodeContainer, Point, boolean) for failure.
     * </p>
     * <p>
     * It tests the case that when location is null and expects IllegalArgumentException.
     * </p>
     */
    public void testCtor_NullPoint() {
        try {
            new EdgeAddEvent(null, location, false);
            fail("IllegalArgumentException expected.");
        } catch (IllegalArgumentException iae) {
            // the expected case
        }
    }

    /**
     * <p>
     * Tests EdgeAddEvent#getSource() for accuracy.
     * </p>
     * <p>
     * It verifies EdgeAddEvent#getSource() is correct.
     * </p>
     */
    public void testGetSource() {
        assertSame("Failed to get the source correctly", source, event.getSource());
        assertTrue("Failed to get the source correctly", event.getSource() instanceof SubsystemNodeContainer);
    }

    /**
     * <p>
     * Tests EdgeAddEvent#getLocation() for accuracy.
     * </p>
     * <p>
     * It verifies EdgeAddEvent#getLocation() is correct.
     * </p>
     */
    public void testGetLocation() {
        assertSame("Failed to get the location correctly", location, event.getLocation());
    }

    /**
     * <p>
     * Tests EdgeAddEvent#isStart() for accuracy.
     * </p>
     * <p>
     * It verifies EdgeAddEvent#isStart() is correct.
     * </p>
     */
    public void testIsStart() {
        assertEquals("Failed to get isStart correctly.", true, event.isStart());
        event = new EdgeAddEvent(source, location, false);
        assertEquals("Failed to get isStart correctly.", false, event.isStart());
    }
}
