/*
 * Copyright (C) 2008 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.gui.sectionlayout.failuretests;

import junit.framework.TestCase;

import com.topcoder.gui.sectionlayout.dock.DockEvent;

/**
 * <p>
 * Failure test for <code>DockEvent</code>.
 * </p>
 *
 * @author restarter
 * @version 1.0
 */
public class DockEventFailureTest extends TestCase {

    /**
     * <p>
     * Test for the constructor.
     * </p>
     *
     * <p>
     * the dock is null, IllegalArgumentException is expected.
     * </p>
     */
    public void testDockEventA() {
        try {
            new DockEvent(null, new DockContainerImpl(), null, 0);
            fail("the dock is null, IllegalArgumentException is expected.");
        } catch (IllegalArgumentException e) {
            // expected
        }
    }

    /**
     * <p>
     * Test for the constructor.
     * </p>
     *
     * <p>
     * the container is null, IllegalArgumentException is expected.
     * </p>
     */
    public void testDockEventB() {
        try {
            new DockEvent(new DockImpl(), null, null, 0);
            fail("the container is null, IllegalArgumentException is expected.");
        } catch (IllegalArgumentException e) {
            // expected
        }
    }

}
