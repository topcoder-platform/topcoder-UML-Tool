/*
 * Copyright (C) 2007 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.gui.diagramviewer.uml.classelements.event;

import java.awt.Dimension;
import java.awt.Point;

import junit.framework.TestCase;

import com.topcoder.diagraminterchange.GraphNode;
import com.topcoder.gui.diagramviewer.TextInputBox;
import com.topcoder.gui.diagramviewer.event.TextInputEvent;
import com.topcoder.gui.diagramviewer.uml.classelements.TestUtil;
import com.topcoder.gui.diagramviewer.uml.classelements.TextField;

/**
 * <p>
 * Test the functionality of <code>EditBoxListener</code> class.
 * </p>
 * @author TCSDEVELOPER
 * @version 1.0
 */
public class EditBoxListenerTest extends TestCase {

    /** The absolute position of the visual node. Used for testing only. */
    private static final Point POSITION = new Point(100, 150);

    /** The size of the visual node. Used for testing only. */
    private static final Dimension SIZE = new Dimension(80, 40);

    /** An instance of <code>EditBoxListener</code> for testing. */
    private EditBoxListener listener;

    /** <code>TextField</code> of this <code>EditBoxListener</code> for testing. */
    private TextField textField;

    /** <code>TextInputBox</code> for this <code>EditBoxListener</code>. */
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
        GraphNode graphNode = TestUtil.createClassGraphNode(POSITION, SIZE, false, false);
        textField = new TextField(graphNode);
        textField.setText(oldText);

        listener = new EditBoxListener(textField);

        box = new TextInputBox();
    }

    /**
     * Test method for 'EditBoxListener(TextField)'. The instance should be created successfully.
     */
    public void testEditBoxListener_Accuracy() {
        assertNotNull("Test method for 'EditBoxListener(TextField)' failed.", listener);
    }

    /**
     * Test method for 'EditBoxListener(TextField)'. The argument is null, IllegalArgumentException should be thrown.
     */
    public void testTextChangedEvent_null() {
        try {
            new EditBoxListener(null);
            fail("IllegalArgumentException should be thrown.");
        } catch (IllegalArgumentException iae) {
            // Success
        }
    }

    /**
     * Test method for 'textEntered(TextInputEvent)'. The argument is null, should be ignored.
     */
    public void testTextEntered_null() {
        listener.textEntered(null);
        assertEquals("Null event should be ignored.", textField.getText(), oldText);
    }

    /**
     * Test method for 'textEntered(TextInputEvent)'. Text should be changed correctly.
     */
    public void testTextEntered() {
        TextChangedListener textChangedListener = new TextChangedListener() {
            public void textChanged(TextChangedEvent event) {
                TextField compartment = (TextField) event.getSource();
                compartment.setText(event.getNewText());
            }
        };
        textField.addTextChangedListener(textChangedListener);
        box.addTextInputListener(listener);
        listener.textEntered(new TextInputEvent(box, newText));
        assertEquals("Text should be changed correctly.", textField.getText(), newText);
    }

    /**
     * Test method for 'textCancelled(TextInputEvent)'. The argument is null, should be ignored.
     */
    public void testTextCancelled_null() {
        listener.textEntered(null);
        assertEquals("Null event should be ignored.", textField.getText(), oldText);
    }

    /**
     * Test method for 'textCancelled(TextInputEvent)'. Text should not be changed.
     */
    public void testTextCancelled() {
        TextChangedListener textChangedListener = new TextChangedListener() {
            public void textChanged(TextChangedEvent event) {
                TextField compartment = (TextField) event.getSource();
                compartment.setText(event.getNewText());
            }
        };
        textField.addTextChangedListener(textChangedListener);
        box.addTextInputListener(listener);
        listener.textCancelled(new TextInputEvent(box, newText));
        assertEquals("Text should not be changed.", textField.getText(), oldText);
    }

    /**
     * <p>
     * Tears down the test environment.
     * </p>
     */
    protected void tearDown() throws Exception {
        super.tearDown();

        listener = null;

        textField = null;

        box = null;

        oldText = null;

        newText = null;
    }
}
