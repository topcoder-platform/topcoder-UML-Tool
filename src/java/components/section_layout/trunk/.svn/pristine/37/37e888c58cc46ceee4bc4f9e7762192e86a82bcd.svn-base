/*
 * Copyright (C) 2008 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.gui.sectionlayout.failuretests;

import java.awt.Point;

import junit.framework.TestCase;

import com.topcoder.gui.sectionlayout.dock.dndimpl.DefaultDock;

/**
 * <p>
 * Failure test for <code>DefaultDock</code>.
 * </p>
 *
 * @author restarter
 * @version 1.0
 */
public class DefaultDockFailureTest extends TestCase {

    /**
     * <p>
     * The DefaultDock instance for testing.
     * </p>
     */
    private DefaultDock dock;

    /**
     * <p>
     * Set up the testing environment.
     * </p>
     */
    protected void setUp() {
        dock = new DefaultDock(new DockableImpl());
    }

    /**
     * <p>
     * Tear down the testing environment.
     * </p>
     */
    protected void tearDown() {
        // empty
    }

    /**
     * <p>
     * Test for the constructor.
     * </p>
     *
     * <p>
     * the dockable is null, IllegalArgumentException is expected.
     * </p>
     */
    public void testDefaultDock() {
        try {
            new DefaultDock(null);
            fail("the dockable is null, IllegalArgumentException is expected.");
        } catch (IllegalArgumentException e) {
            // expected
        }
    }

    /**
     * <p>
     * Test for the <code>floatTo(Point location)</code>.
     * </p>
     *
     * <p>
     * the location is null, IllegalArgumentException is expected.
     * </p>
     */
    public void testFloatToNull() {
        try {
            dock.floatTo(null);
            fail("the location is null, IllegalArgumentException is expected.");
        } catch (IllegalArgumentException e) {
            // expected
        }
    }

    /**
     * <p>
     * Test for the <code>floatTo(Point location)</code>.
     * </p>
     *
     * <p>
     * the location is with x = -1, IllegalArgumentException is expected.
     * </p>
     */
    public void testFloatToNegX() {
        try {
            dock.floatTo(new Point(-1, 1));
            fail("the location is with x = -1, IllegalArgumentException is expected.");
        } catch (IllegalArgumentException e) {
            // expected
        }
    }

    /**
     * <p>
     * Test for the <code>floatTo(Point location)</code>.
     * </p>
     *
     * <p>
     * the location is with y = -1, IllegalArgumentException is expected.
     * </p>
     */
    public void testFloatToNegY() {
        try {
            dock.floatTo(new Point(1, -1));
            fail("the location is with y = -1, IllegalArgumentException is expected.");
        } catch (IllegalArgumentException e) {
            // expected
        }
    }

    /**
     * <p>
     * Test for the <code>addDockListener(DockListener listener)</code>.
     * </p>
     *
     * <p>
     * the listener is null, IllegalArgumentException is expected.
     * </p>
     */
    public void testAddDockListener() {
        try {
            dock.addDockListener(null);
            fail("the listener is null, IllegalArgumentException is expected.");
        } catch (IllegalArgumentException e) {
            // expected
        }
    }

    /**
     * <p>
     * Test for the <code>addDockListener(DockListener listener)</code>.
     * </p>
     *
     * <p>
     * the listener is null, IllegalArgumentException is expected.
     * </p>
     */
    public void testRemoveDockListener() {
        try {
            dock.removeDockListener(null);
            fail("the listener is null, IllegalArgumentException is expected.");
        } catch (IllegalArgumentException e) {
            // expected
        }
    }

    /**
     * <p>
     * Test for the <code>fireDocked(DockEvent event)</code>.
     * </p>
     *
     * <p>
     * the event is null, IllegalArgumentException is expected.
     * </p>
     */
    public void testFireDocked() {
        try {
            dock.fireDocked(null);
            fail("the listener is null, IllegalArgumentException is expected.");
        } catch (IllegalArgumentException e) {
            // expected
        }
    }

    /**
     * <p>
     * Test for the <code>fireUndocked(DockEvent event)</code>.
     * </p>
     *
     * <p>
     * the event is null, IllegalArgumentException is expected.
     * </p>
     */
    public void testFireUndocked() {
        try {
            dock.fireUndocked(null);
            fail("the listener is null, IllegalArgumentException is expected.");
        } catch (IllegalArgumentException e) {
            // expected
        }
    }
}
