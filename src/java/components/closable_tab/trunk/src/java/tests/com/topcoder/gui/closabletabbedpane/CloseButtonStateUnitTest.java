/*
 * Copyright (C) 2008 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.gui.closabletabbedpane;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

/**
 * <p>
 * UnitTest for CloseButtonState class.
 * </p>
 * @author TCSDEVELOPER
 * @version 1.0
 */
public class CloseButtonStateUnitTest extends TestCase {
    /**
     * <p>
     * Aggregates all tests in this class.
     * </p>
     * @return Test suite aggregating all tests.
     */
    public static Test suite() {
        return new TestSuite(CloseButtonStateUnitTest.class);
    }

    /**
     * Simple check if any pair of enums are the same.
     */
    public void testEnum() {
        // Simple check if any pair of enums are the same.
        assertTrue("enum incorrect", CloseButtonState.ACTIVE_TAB_HOVERED != CloseButtonState.ACTIVE_TAB_NOT_HOVERED);
        assertTrue("enum incorrect", CloseButtonState.ACTIVE_TAB_HOVERED != CloseButtonState.INACTIVE_TAB_HOVERED);
        assertTrue("enum incorrect",
            CloseButtonState.ACTIVE_TAB_HOVERED != CloseButtonState.INACTIVE_TAB_NOT_HOVERED);
        assertTrue("enum incorrect",
            CloseButtonState.ACTIVE_TAB_NOT_HOVERED != CloseButtonState.INACTIVE_TAB_HOVERED);
        assertTrue("enum incorrect",
            CloseButtonState.ACTIVE_TAB_NOT_HOVERED != CloseButtonState.INACTIVE_TAB_NOT_HOVERED);
        assertTrue("enum incorrect",
            CloseButtonState.INACTIVE_TAB_HOVERED != CloseButtonState.INACTIVE_TAB_NOT_HOVERED);
    }
}
