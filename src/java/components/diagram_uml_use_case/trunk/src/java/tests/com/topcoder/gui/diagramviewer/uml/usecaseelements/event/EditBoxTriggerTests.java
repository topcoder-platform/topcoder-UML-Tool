/*
 * Copyright (C) 2007 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.gui.diagramviewer.uml.usecaseelements.event;

import java.awt.event.MouseEvent;

import junit.framework.TestCase;

import com.topcoder.diagraminterchange.GraphNode;
import com.topcoder.gui.diagramviewer.uml.usecaseelements.TextField;

/**
 * <p>
 * Unit test cases for EditBoxTrigger.
 * </p>
 *
 * @author TCSDEVELOPER
 * @version 1.0
 */
public class EditBoxTriggerTests extends TestCase {
    /**
     * <p>
     * EditBoxTrigger instance for testing.
     * </p>
     */
    private EditBoxTrigger trigger;

    /**
     * <p>
     * Sets up test environment.
     * </p>
     */
    protected void setUp() {
        trigger = new EditBoxTrigger(new TextField(new GraphNode()));
    }

    /**
     * <p>
     * Tears down test environment.
     * </p>
     */
    protected void tearDown() {
        trigger = null;
    }

    /**
     * <p>
     * Tests EditBoxTrigger#EditBoxTrigger(TextField) for accuracy.
     * </p>
     * <p>
     * It verifies the newly created EditBoxTrigger instance should not be null.
     * </p>
     */
    public void testCtor() {
        assertNotNull("Failed to create an EditBoxTrigger instance.", trigger);
    }

    /**
     * <p>
     * Tests EditBoxTrigger#EditBoxTrigger(TextField) for failure.
     * </p>
     * <p>
     * It tests the case that when TextField is null and expects IllegalArgumentException.
     * </p>
     */
    public void testCtor_NullTextField() {
        try {
            new EditBoxTrigger(null);
            fail("IllegalArgumentException expected.");
        } catch (IllegalArgumentException iae) {
            // the expected case
        }
    }

    /**
     * <p>
     * Tests EditBoxTrigger#mouseClicked(MouseEvent) for accuracy.
     * </p>
     * <p>
     * It verifies EditBoxTrigger#mouseClicked(MouseEvent) is correct.
     * </p>
     */
    public void testMouseClicked() {
        TextField textField = new TextField(new GraphNode());
        trigger = new EditBoxTrigger(textField);
        MouseEvent e = new MouseEvent(textField, 0, 0, 0, 0, 0, 2, false, MouseEvent.BUTTON1);

        // Construct a text change listener and register it to the textField
        MockTextChangeListener listener = new MockTextChangeListener();
        textField.addTextChangeListener(listener);

        textField.setText("test");

        trigger.mouseClicked(e);
    }

    /**
     * <p>
     * Tests EditBoxTrigger#mouseClicked(MouseEvent) for accuracy.
     * </p>
     * <p>
     * It tests the case that when simulate double right click and expects success.
     * </p>
     */
    public void testMouseClicked1() {
        TextField textField = new TextField(new GraphNode());
        trigger = new EditBoxTrigger(textField);
        MouseEvent e = new MouseEvent(textField, 0, 0, 0, 0, 0, 2, false, MouseEvent.BUTTON2);

        // Construct a text change listener and register it to the textField
        MockTextChangeListener listener = new MockTextChangeListener();
        textField.addTextChangeListener(listener);

        textField.setText("test");

        trigger.mouseClicked(e);

        assertFalse("mouseClicked behavior is wrong.", listener.getIsExecute());
    }

    /**
     * <p>
     * Tests EditBoxTrigger#mouseClicked(MouseEvent) for accuracy.
     * </p>
     * <p>
     * It tests the case that when simulate double right click and expects success.
     * </p>
     */
    public void testMouseClicked2() {
        TextField textField = new TextField(new GraphNode());
        trigger = new EditBoxTrigger(textField);
        MouseEvent e = new MouseEvent(textField, 0, 0, 0, 0, 0, 1, false, MouseEvent.BUTTON1);

        // Construct a text change listener and register it to the textField
        MockTextChangeListener listener = new MockTextChangeListener();
        textField.addTextChangeListener(listener);

        textField.setText("test");

        trigger.mouseClicked(e);

        assertFalse("mouseClicked behavior is wrong.", listener.getIsExecute());
    }

    /**
     * <p>
     * Tests EditBoxTrigger#mouseClicked(MouseEvent) for accuracy.
     * </p>
     * <p>
     * It tests the case that when e is null and expects success.
     * </p>
     */
    public void testMouseClicked_NullE() {
        trigger.mouseClicked(null);
        // no exception will be thrown
    }
}
