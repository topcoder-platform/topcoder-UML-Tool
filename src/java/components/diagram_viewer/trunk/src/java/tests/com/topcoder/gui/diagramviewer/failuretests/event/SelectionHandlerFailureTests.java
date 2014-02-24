/*
 * Copyright (C) 2007 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.gui.diagramviewer.failuretests.event;

import com.topcoder.gui.diagramviewer.event.SelectionHandler;

import junit.framework.TestCase;

/**
 * Failure tests for SelectionHandler class.
 *
 * @author Yeung
 * @version 1.0
 */
public class SelectionHandlerFailureTests extends TestCase {
    /**
     * This instance is used in the test.
     */
    private SelectionHandler handler;

    /**
     * Sets up the test environment.
     *
     * @throws Exception
     *             if any error occurred when set up
     */
    protected void setUp() throws Exception {
        handler = new SelectionHandler();
    }

    /**
     * Tests the method selectionRectangleChanged(SelectionEvent) with null event, expected IllegalArgumentException.
     *
     * @throws Exception
     *             if any error occurred when set up
     */
    public void testSelectionRectangleChanged_NullEvent() throws Exception {
        try {
            handler.selectionRectangleChanged(null);
            fail("Expect IllegalArgumentException.");
        } catch (IllegalArgumentException iae) {
            // expect
        }
    }
}