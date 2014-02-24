/*
 * Copyright (C) 2007 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.gui.diagramviewer;

import junit.framework.TestCase;

import com.topcoder.gui.diagramviewer.event.TextInputEvent;

/**
 * <p>
 * Unit test cases for TextInputEvent.
 * </p>
 *
 * @author TCSDEVELOPER
 * @version 1.0
 */
public class TextInputEventUnitTests extends TestCase {

    /**
     * <p>
     * TextInputBox instance for testing.
     * </p>
     */
    private TextInputBox box = new TextInputBox();

    /**
     * <p>
     * text for testing.
     * </p>
     */
    private String text = "text";

    /**
     * TextInputEvent instance for testing.
     */
    private TextInputEvent tie;

    /**
     * Sets up the testing environment.
     *
     * @throws Exception when error occurs
     */
    protected void setUp() throws Exception {
        tie = new TextInputEvent(box, text);
    }

    /**
     * <p>
     * This is the accuracy test for constructor:TextInputEvent(TextInputBox
     * source, String text). <br>
     * Target: test the creation. <br>
     * </p>
     *
     * @throws Exception when error occurs
     */
    public void testCtor() throws Exception {
        assertNotNull("Failed to create TextInputEvent instance.", tie);
        tie = new TextInputEvent(box, "");
        assertNotNull("Failed to create TextInputEvent instance.", tie);
        tie = new TextInputEvent(box, "         ");
        assertNotNull("Failed to create TextInputEvent instance.", tie);
        assertEquals("Failed to create TextInputEvent instance.", (TextInputBox) tie.getSource(), this.box);
    }

    /**
     * <p>
     * This is the failure test for constructor: assertNotNull("Failed to create
     * TextInputEvent instance.", tie);.<br>
     * Failure condition: if any arg is null. <br>
     * Expected: IllegalArgumentException. <br>
     * </p>
     *
     * @throws Exception when error occurs
     */
    public void testCtorWithNullValue() throws Exception {
        try {
            new TextInputEvent(null, text);
            fail("IllegalArgumentException is1 excepted.");
        } catch (IllegalArgumentException e) {
            // pass.
        }

        try {
            new TextInputEvent(box, null);
            fail("IllegalArgumentException is2 excepted.");
        } catch (IllegalArgumentException e) {
            // pass.
        }

        try {
            new TextInputEvent(null, null);
            fail("IllegalArgumentException is3 excepted.");
        } catch (IllegalArgumentException e) {
            // pass.
        }
    }

    /**
     * <p>
     * This is the accuracy test for Method:getText(). <br>
     * Target: test the creation. <br>
     * </p>
     *
     * @throws Exception when error occurs
     */
    public void testGetTextAccuracy() throws Exception {
        assertEquals("Failed to call Method: getText.", this.text, this.tie.getText());
    }

}
