/*
 * Copyright (C) 2007 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.gui.diagramviewer.accuracytests;

import com.topcoder.gui.diagramviewer.event.TextInputEvent;
import com.topcoder.gui.diagramviewer.event.TextInputListener;
import com.topcoder.gui.diagramviewer.TextInputBox;

import junit.framework.TestCase;

/**
 * <p>
 * Accuracy test cases for TextInputBox.
 * </p>
 *
 * @author tianniu
 * @version 1.0
 */

public class TextInputBoxAccuracyTests extends TestCase {

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
        box.setNewLineAccepted(true);
        assertTrue("Fail to set newLineAccpted.", box.isNewLineAccepted());
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
        TextInputListener listener = new TextInputListenerImpl();
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
        TextInputListener listener = new TextInputListenerImpl();
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
            box.addTextInputListener(new TextInputListenerImpl());
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
            box.addTextInputListener(new TextInputListenerImpl());
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
        box.setText("Test");
        box.clearText();
        assertEquals("Fail to clear text.", box.getText(), "");
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
        box.setText("AccuracyTest");
        assertEquals("Fail to get text.", box.getText(), "AccuracyTest");
    }

    /**
     * <p>
     * This is the Accuracy test for Method: setText().
     * </p>
     *
     * @throws Exception when error occurs
     */
    public void testSetText() throws Exception {
        box.setText("AccuracyTest");
        assertEquals("Fail to set text.", box.getText(), "AccuracyTest");
    }

    /**
     * <p>
     * This class is an implement for the interface <c>TextInputListener</c>.
     * </p>
     *
     * @author tianniu.
     */
    final class TextInputListenerImpl implements TextInputListener {
        /**
         * <p>
         * Invoked when the text is entered into the TextInputBox. The event tells
         * the text entered in the TextInputBox.
         * </p>
         *
         * @param event the text input event
         */
        public void textEntered(TextInputEvent event) {
        }

        /**
         * <p>
         * Invoked when the text in the TextInputBox is cancelled. The event tells
         * the text in the TextInputBox.
         * </p>
         *
         * @param event the text input event
         */
        public void textCancelled(TextInputEvent event) {
        }
    }
}
