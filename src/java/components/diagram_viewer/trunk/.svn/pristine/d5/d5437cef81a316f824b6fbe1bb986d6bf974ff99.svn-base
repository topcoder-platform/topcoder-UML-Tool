/*
 * Copyright (C) 2007 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.gui.diagramviewer.failuretests.event;

import com.topcoder.gui.diagramviewer.TextInputBox;
import com.topcoder.gui.diagramviewer.event.TextInputEvent;

import junit.framework.TestCase;

/**
 * Failure tests for TextInputEvent class.
 *
 * @author Yeung
 * @version 1.0
 */
public class TextInputEventFailureTests extends TestCase {
    /**
     * Tests the constructor TextInputEvent(TextInputBox, String) with null source, expected IllegalArgumentException.
     *
     * @throws Exception
     *             if any error occurred when set up
     */
    public void testCtor_NullSource() throws Exception {
        try {
            new TextInputEvent(null, "test");
            fail("Expect IllegalArgumentException.");
        } catch (IllegalArgumentException iae) {
            // expect
        }
    }

    /**
     * Tests the constructor TextInputEvent(TextInputBox, String) with null text, expected IllegalArgumentException.
     *
     * @throws Exception
     *             if any error occurred when set up
     */
    public void testCtor_NullText() throws Exception {
        try {
            new TextInputEvent(new TextInputBox(), null);
            fail("Expect IllegalArgumentException.");
        } catch (IllegalArgumentException iae) {
            // expect
        }
    }
}
