/*
 * Copyright (C) 2008 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.gui.sectionlayout.failuretests;

import junit.framework.TestCase;

import com.topcoder.gui.sectionlayout.dock.dndimpl.DockableWrapper;
/**
 * <p>
 * Failure test for <code>DockableWrapper</code>.
 * </p>
 *
 * @author restarter
 * @version 1.0
 */
public class DockableWrapperFailureTest extends TestCase {

    /**
     * <p>
     * Test for the constructor.
     * </p>
     *
     * <p>
     * the dock is null, IllegalArgumentException is expected.
     * </p>
     */
    public void testDockableWrapperA() {
        try {
            new DockableWrapper(null);
            fail("the component is null, IllegalArgumentException is expected.");
        } catch (IllegalArgumentException e) {
            // expected
        }
    }
}
