/*
 * Copyright (C) 2007 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.gui.diagramviewer;

import com.topcoder.gui.diagramviewer.event.TextInputListener;

import junit.framework.TestCase;

/**
 * <p>
 * Unit test cases for TextInputBox.
 * </p>
 *
 * @author TCSDEVELOPER
 * @version 1.0
 */

public class TextInputBoxUnitTests extends TestCase {

    /**
     * TextInputBox instance for testing.
     */
    private TextInputBox box;

    /**
     * Sets up the testing environment.
     *
     * @throws Exception when error occurs
     */
    protected void setUp() throws Exception {
        box = new TextInputBox();
    }

    /**
     * <p>
     * This is the accuracy test for constructor: TextInputBox(). <br>
     * Target: test the creation. <br>
     * </p>
     *
     * @throws Exception when error occurs
     */
    public void testCtor() throws Exception {
        assertNotNull("Failed to create TextInputBox instance.", box);
    }

    /**
     * <p>
     * This is the Accuracy test for Method: setNewLineAccepted(boolean
     * newLineAccepted).
     * </p>
     *
     * @throws Exception when error occurs
     */
    public void testSetNewLineAccepted() throws Exception {
        box.setNewLineAccepted(true);
        assertTrue("Fail to set newLineAccpted.", box.isNewLineAccepted());
        box.setNewLineAccepted(false);
        assertFalse("Fail to set newLineAccpted.", box.isNewLineAccepted());
    }

    /**
     * <p>
     * This is the Accuracy test for Method: isNewLineAccepted(boolean
     * newLineAccepted).
     * </p>
     *
     * @throws Exception when error occurs
     */
    public void testIsNewLineAccepted() throws Exception {
        assertFalse("Fail to set newLineAccpted.", box.isNewLineAccepted());
    }

    /**
     * <p>
     * This is the Accuracy test for Method:
     * addTextInputListener(TextInputListener listener).
     * </p>
     *
     * @throws Exception when error occurs
     */
    public void testAddTextInputListener() throws Exception {
        TextInputListener listener = new MockTextInputHander();
        box.addTextInputListener(listener);
        box.addTextInputListener(null);
        assertEquals("Fail to call method: addTextInputListener(TextInputListener listener).", box
                .getListeners(TextInputListener.class)[0], listener);
        assertEquals("Fail to call method: addTextInputListener(TextInputListener listener).", box
                .getListeners(TextInputListener.class).length, 1);
    }

    /**
     * <p>
     * This is the Accuracy test for Method:
     * removeTextInputListener(TextInputListener listener).
     * </p>
     *
     * @throws Exception when error occurs
     */
    public void testRemoveTextInputListener() throws Exception {
        TextInputListener listener = new MockTextInputHander();
        box.addTextInputListener(listener);
        box.addTextInputListener(null);
        assertEquals("Fail to call method: addTextInputListener(TextInputListener listener).", box
                .getListeners(TextInputListener.class)[0], listener);
        assertEquals("Fail to call method: addTextInputListener(TextInputListener listener).", box
                .getListeners(TextInputListener.class).length, 1);
        box.removeTextInputListener(listener);
        assertEquals("Fail to call method: addTextInputListener(TextInputListener listener).", box
                .getListeners(TextInputListener.class).length, 0);
        box.removeTextInputListener(listener);
        box.removeTextInputListener(null);
    }

    /**
     * <p>
     * This is the Accuracy test for Method: fireTextEntered().
     * </p>
     *
     * @throws Exception when error occurs
     */
    public void testFireTextEntered() throws Exception {
        for (int i = 0; i < 10; i++) {
            box.addTextInputListener(new MockTextInputHander());
        }
        box.fireTextEntered();
    }

    /**
     * <p>
     * This is the Accuracy test for Method: fireTextCancelled().
     * </p>
     *
     * @throws Exception when error occurs
     */
    public void testFireTextCancelled() throws Exception {
        for (int i = 0; i < 10; i++) {
            box.addTextInputListener(new MockTextInputHander());
        }
        box.fireTextCancelled();
    }

    /**
     * <p>
     * This is the Accuracy test for Method: clearText().
     * </p>
     *
     * @throws Exception when error occurs
     */
    public void testClearText() throws Exception {
        box.clearText();
        assertTrue("Fail to clear text.", box.getText().trim().length() == 0);
    }

    /**
     * <p>
     * This is the Accuracy test for Method: getText().
     * </p>
     *
     * @throws Exception when error occurs
     */
    public void testGetText() throws Exception {
        assertEquals("Fail to get text.", box.getText().length(), 0);
        box.setText("Test");
        assertEquals("Fail to get text.", box.getText(), "Test");
        box.setText("Test+6545121548425");
        assertEquals("Fail to get text.", box.getText(), "Test+6545121548425");
    }

    /**
     * <p>
     * This is the Accuracy test for Method: setText().
     * </p>
     *
     * @throws Exception when error occurs
     */
    public void testSetText() throws Exception {
        box.clearText();
        box.setText("Test");
        assertEquals("Fail to set text.", box.getText(), "Test");
        box.setText("Test+6545121548425");
        assertEquals("Fail to set text.", box.getText(), "Test+6545121548425");
    }

    /**
     * <p>
     * This is failure test for Method: setText().<br>
     * Failure condition: the text is null. <br>
     * Expected: IlleagalArgumentException. <br>
     * </p>
     *
     * @throws Exception when error occurs
     */
    public void testSetTextWithNullValue() throws Exception {
        try {
            box.setText(null);
            fail("IlleagalArgumentException is excepted.");
        } catch (IllegalArgumentException e) {
            // pass.
        }
    }

    /**
     * <p>
     * This is failure test for Method: setText().<br>
     * Failure condition: the text is empty. <br>
     * Expected: IlleagalArgumentException. <br>
     * </p>
     *
     * @throws Exception when error occurs
     */
    public void testSetTextWithEmptyText() throws Exception {
        try {
            box.setText("");
            fail("IlleagalArgumentException is excepted.");
        } catch (IllegalArgumentException e) {
            // pass.
        }

        try {
            box.setText("                ");
            fail("IlleagalArgumentException is excepted.");
        } catch (IllegalArgumentException e) {
            // pass.
        }

    }

}
