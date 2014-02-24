/*
 * Copyright (C) 2007 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.gui.diagramviewer.failuretests.event;

import com.topcoder.gui.diagramviewer.event.ScrollTrigger;

import junit.framework.TestCase;

/**
 * Failure tests for ScrollTrigger class.
 *
 * @author Yeung
 * @version 1.0
 */
public class ScrollTriggerFailureTests extends TestCase {
    /**
     * This instance is used in the test.
     */
    private ScrollTrigger trigger;

    /**
     * Sets up the test environment.
     *
     * @throws Exception
     *             if any error occurred when set up
     */
    protected void setUp() throws Exception {
        trigger = new ScrollTrigger();
    }

    /**
     * Tests the method adjustmentValueChanged(AdjustmentEvent) with null event, expected IllegalArgumentException.
     *
     * @throws Exception
     *             if any error occurred when set up
     */
    public void testAdjustmentValueChanged_NullEvent() throws Exception {
        try {
            trigger.adjustmentValueChanged(null);
            fail("Expect IllegalArgumentException.");
        } catch (IllegalArgumentException iae) {
            // expect
        }
    }
}