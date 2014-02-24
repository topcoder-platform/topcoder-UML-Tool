/*
 * Copyright (C) 2007 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.gui.diagramviewer.failuretests;

import com.topcoder.gui.diagramviewer.TextInputBox;

import junit.framework.TestCase;

/**
 * Failure tests for TextInputBox class.
 *
 * @author Yeung
 * @version 1.0
 */
public class TextInputBoxFailureTests extends TestCase {
    /**
     * This instance is used in the test.
     */
    private TextInputBox textInputBox;

    /**
     * Sets up the test environment.
     *
     * @throws Exception
     *             if any error occurred when set up
     */
    protected void setUp() throws Exception {
        textInputBox = new TextInputBox();
    }

    /**
     * Tests the method setText(String) with null text, expected IllegalArgumentException.
     *
     * @throws Exception
     *             if any error occurred when set up
     */
    public void testSetText_NullText() throws Exception {
        try {
            textInputBox.setText(null);
            fail("Expect IllegalArgumentException.");
        } catch (IllegalArgumentException iae) {
            // expect
        }
    }

    /**
     * Tests the method setText(String) with empty text, expected IllegalArgumentException.
     *
     * @throws Exception
     *             if any error occurred when set up
     */
    public void testSetText_EmptyText1() throws Exception {
        try {
            textInputBox.setText("");
            fail("Expect IllegalArgumentException.");
        } catch (IllegalArgumentException iae) {
            // expect
        }
    }

    /**
     * Tests the method setText(String) with empty text, expected IllegalArgumentException.
     *
     * @throws Exception
     *             if any error occurred when set up
     */
    public void testSetText_EmptyText2() throws Exception {
        try {
            textInputBox.setText(" \t \n ");
            fail("Expect IllegalArgumentException.");
        } catch (IllegalArgumentException iae) {
            // expect
        }
    }
}
