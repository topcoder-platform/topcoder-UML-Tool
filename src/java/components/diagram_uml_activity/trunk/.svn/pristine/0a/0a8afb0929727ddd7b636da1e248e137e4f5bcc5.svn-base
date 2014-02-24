/*
 * Copyright (C) 2007 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.gui.diagramviewer.uml.activityelements.event;

import com.topcoder.diagraminterchange.GraphNode;
import com.topcoder.gui.diagramviewer.TextInputBox;
import com.topcoder.gui.diagramviewer.event.TextInputEvent;
import com.topcoder.gui.diagramviewer.uml.activityelements.TestUtil;
import com.topcoder.gui.diagramviewer.uml.activityelements.TextField;
import com.topcoder.uml.model.statemachines.PseudostateImpl;

import junit.framework.TestCase;

/**
 * <p>
 * Test the functionality of <code>TextInputListener</code> class.
 * </p>
 * @author TCSDEVELOPER
 * @version 1.0
 */
public class TextInputListenerTest extends TestCase {
    /** An instance of <code>TextInputListener</code> for testing. */
    private TextInputListener listener;

    /** <code>TextField</code> of this <code>TextInputListener</code> for testing. */
    private TextField textField;

    /** <code>TextInputBox</code> for this <code>TextInputListener</code> */
    private TextInputBox box;

    /** Old text for testing. */
    private String oldText = "old text";

    /** New text for testing. */
    private String newText = "new text";

    /**
     * <p>
     * Sets up the test environment. The test instance is created.
     * </p>
     * @throws Exception
     *             to junit
     */
    protected void setUp() throws Exception {
        super.setUp();
        GraphNode graphNode = TestUtil.createGraphNodeForActivityNode(new PseudostateImpl());
        textField = new TextField(graphNode);
        textField.setText(oldText);

        listener = new TextInputListener(textField);

        box = new TextInputBox();
    }

    /**
     * Test method for 'TextInputListener(TextField)'. The instance should be created successfully.
     */
    public void testTextInputListener_Accuracy() {
        assertNotNull("Test method for 'TextInputListener(TextField)' failed.", listener);
    }

    /**
     * Test method for 'TextInputListener(TextField)'. The argument is null, IllegalArgumentException should be thrown.
     */
    public void testTextChangedEvent_null() {
        try {
            new TextInputListener(null);
            fail("IllegalArgumentException should be thrown.");
        } catch (IllegalArgumentException iae) {
            // Success
        }
    }

    /**
     * Test method for 'textEntered(TextInputEvent)'. Text should be changed correctly.
     */
    public void testTextEntered() {
        TextChangedListener textChangedListener = new TextChangedListener() {
            public void textChanged(TextChangedEvent event) {
                TextField compartment = (TextField) event.getSource();
                compartment.setText(event.getNewValue());
            }
        };
        textField.addTextChangedListener(textChangedListener);
        box.addTextInputListener(listener);
        listener.textEntered(new TextInputEvent(box, newText));
        assertEquals("Text should be changed correctly.", textField.getText(), newText);
    }

    /**
     * Test method for 'textCancelled(TextInputEvent)'. Text should not be changed.
     */
    public void testTextCancelled() {
        TextChangedListener textChangedListener = new TextChangedListener() {
            public void textChanged(TextChangedEvent event) {
                TextField compartment = (TextField) event.getSource();
                compartment.setText(event.getNewValue());
            }
        };
        textField.addTextChangedListener(textChangedListener);
        box.addTextInputListener(listener);
        listener.textCancelled(new TextInputEvent(box, newText));
        assertEquals("Text should not be changed.", textField.getText(), oldText);
    }
}
