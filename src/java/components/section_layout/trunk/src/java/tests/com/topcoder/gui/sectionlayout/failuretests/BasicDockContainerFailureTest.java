/*
 * Copyright (C) 2008 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.gui.sectionlayout.failuretests;

import junit.framework.TestCase;

import com.topcoder.gui.sectionlayout.dock.dndimpl.BasicDockContainer;

/**
 * <p>
 * Failure test for <code>BasicDockContainer</code>.
 * </p>
 *
 * @author restarter
 * @version 1.0
 */
public class BasicDockContainerFailureTest extends TestCase {

    /**
     * <p>
     * The BasicDockContainer instance for testing.
     * </p>
     */
    private BasicDockContainer container = new BasicDockContainerImpl();

    /**
     * <p>
     * Test for the <code>addDockListener(Listener listener)</code>.
     * </p>
     *
     * <p>
     * the listener is null, IllegalArgumentException is expected.
     * </p>
     */
    public void testAddDockListener() {
        try {
            container.addDockListener(null);
            fail("the listener is null, IllegalArgumentException is expected.");
        } catch (IllegalArgumentException e) {
            // expected
        }
    }

    /**
     * <p>
     * Test for the <code>removeDockListener(Listener listener)</code>.
     * </p>
     *
     * <p>
     * the listener is null, IllegalArgumentException is expected.
     * </p>
     */
    public void testRemoveDockListener() {
        try {
            container.removeDockListener(null);
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
            container.fireDocked(null);
            fail("the event is null, IllegalArgumentException is expected.");
        } catch (IllegalArgumentException e) {
            // expected
        }
    }

    /**
     * <p>
     * Test for the <code>fireUnDocked(DockEvent event)</code>.
     * </p>
     *
     * <p>
     * the event is null, IllegalArgumentException is expected.
     * </p>
     */
    public void testFireUnDocked() {
        try {
            container.fireUndocked(null);
            fail("the event is null, IllegalArgumentException is expected.");
        } catch (IllegalArgumentException e) {
            // expected
        }
    }

}
