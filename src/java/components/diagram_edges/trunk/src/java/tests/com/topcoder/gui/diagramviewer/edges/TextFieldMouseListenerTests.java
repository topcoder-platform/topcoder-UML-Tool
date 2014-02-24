/*
 * Copyright (C) 2007 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.gui.diagramviewer.edges;

import java.awt.Point;
import java.awt.event.MouseEvent;

import javax.swing.JButton;

import com.topcoder.diagraminterchange.GraphNode;
import junit.framework.TestCase;
import junit.framework.TestSuite;
import junit.framework.Test;

/**
 * <p>
 * Unit test cases for TextFieldMouseListener.
 * </p>
 *
 * @author TCSDEVELOPER
 * @version 1.0
 */
public class TextFieldMouseListenerTests extends TestCase {
    /**
     * <p>
     * TextFieldMouseListener instance for testing.
     * </p>
     */
    private TextFieldMouseListener listener;

    /**
     * <p>
     * TextField instance for helping testing.
     * </p>
     */
    private TextField textField;

    /**
     * <p>
     * Setup test environment.
     * </p>
     *
     */
    protected void setUp() {
        listener = new TextFieldMouseListener();
        textField = new TextField(new GraphNode(), "HelloWorld", AnchorType.Line);
    }

    /**
     * <p>
     * Tears down test environment.
     * </p>
     *
     */
    protected void tearDown() {
        listener = null;
        textField = null;
    }

    /**
     * <p>
     * Return all tests.
     * </p>
     *
     * @return all tests
     */
    public static Test suite() {
        return new TestSuite(TextFieldMouseListenerTests.class);
    }

    /**
     * <p>
     * Tests TextFieldMouseListener#mouseDragged(MouseEvent) for accuracy.
     * </p>
     *
     * <p>
     * Verify : TextFieldMouseListener#mouseDragged(MouseEvent) is correct.
     * </p>
     */
    public void testMouseDragged() {
        textField.setLocation(100, 100);
        MouseEvent pressEvent = new MouseEvent(textField, MouseEvent.MOUSE_PRESSED, System.currentTimeMillis(),
            MouseEvent.BUTTON1_MASK, 5, 15, 1, false);
        MouseEvent draggedEvent = new MouseEvent(textField, MouseEvent.MOUSE_DRAGGED, System.currentTimeMillis(),
            MouseEvent.BUTTON1_MASK, 25, 35, 1, false);

        listener.mousePressed(pressEvent);
        listener.mouseDragged(draggedEvent);

        assertEquals("The location of the text field should be updated.", new Point(120, 120), textField.getLocation());
    }

    /**
     * <p>
     * Tests TextFieldMouseListener#mouseDragged(MouseEvent) for accuracy.
     * </p>
     *
     * <p>
     * It tests the case that when e is null and expects no exception.
     * </p>
     */
    public void testMouseDragged_NullE() {
        listener.mouseDragged(null);
    }

    /**
     * <p>
     * Tests TextFieldMouseListener#mouseDragged(MouseEvent) for accuracy.
     * </p>
     *
     * <p>
     * It tests the case that when the source of the event is not of TextField type and expects no exception.
     * </p>
     */
    public void testMouseDragged_NonTextFieldSource() {
        MouseEvent draggedEvent = new MouseEvent(new JButton(), MouseEvent.MOUSE_DRAGGED, System.currentTimeMillis(),
            MouseEvent.BUTTON1_MASK, 25, 35, 1, false);

        listener.mouseDragged(draggedEvent);
    }

    /**
     * <p>
     * Tests TextFieldMouseListener#mousePressed(MouseEvent) for accuracy.
     * </p>
     *
     * <p>
     * Verify : TextFieldMouseListener#mousePressed(MouseEvent) is correct.
     * </p>
     */
    public void testMousePressed() {
        MouseEvent event = new MouseEvent(textField, MouseEvent.MOUSE_PRESSED, System.currentTimeMillis(),
            MouseEvent.BUTTON1_MASK, 5, 15, 1, false);

        listener.mousePressed(event);

        assertTrue("The text field should be selected.", textField.isSelected());
    }

    /**
     * <p>
     * Tests TextFieldMouseListener#mousePressed(MouseEvent) for accuracy.
     * </p>
     *
     * <p>
     * It tests the case that when e is null and expects no exception.
     * </p>
     */
    public void testMousePressed_NullE() {
        listener.mousePressed(null);
    }

    /**
     * <p>
     * Tests TextFieldMouseListener#mousePressed(MouseEvent) for accuracy.
     * </p>
     *
     * <p>
     * It tests the case that when e is null and expects no exception.
     * </p>
     */
    public void testMousePressed_NonTextFieldSource() {
        MouseEvent event = new MouseEvent(new JButton(), MouseEvent.MOUSE_PRESSED, System.currentTimeMillis(),
            MouseEvent.BUTTON1_MASK, 5, 15, 1, false);

        listener.mousePressed(event);
    }
}