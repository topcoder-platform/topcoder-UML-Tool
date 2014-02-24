/*
 * Copyright (C) 2007 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.gui.diagramviewer.uml.classedges.failuretests;

import java.awt.Graphics;

import javax.swing.JList;

import com.topcoder.diagraminterchange.GraphNode;
import com.topcoder.gui.diagramviewer.edges.AnchorType;
import com.topcoder.gui.diagramviewer.uml.classedges.TextField;
import com.topcoder.gui.diagramviewer.uml.classedges.event.TextChangeEvent;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;


/**
 * Failure test case of <code>TextField</code> class.
 * This class tests <code>TextField</code> for proper behavior. It covers
 * TextField(GraphNode), TextField(GraphNode, AnchorType), getText(), setText(String), getFontColor(),
 * setFontColor(Color), addTextChangeListener(TextChangeListener), removeTextChangeListener(TextChangeListener),
 * fireTextChange(TextChangeEvent), notifyTextChange(String), measureSize(String), getPreferredSize(),
 * paintComponent(Graphics).
 *
 * @author still
 * @version 1.0
 */
public class TextFieldFailureTest extends TestCase {
    /** MockTextField instance used in this failure test. */
    private MockTextField textField;
    /**
     * Test suite of TextField.
     *
     * @return Test suite of TextField.
     */
    public static Test suite() {
        return new TestSuite(TextFieldFailureTest.class);
    }

    /**
     * Initialization for all tests here.
     */
    protected void setUp() {
        // set up for test
        textField = new MockTextField(new GraphNode());
        JList list = new JList();
        list.add(textField);
    }


    /**
     * <p>
     * Test of TextField(GraphNode) for IllegalArgumentException.
     * </p>
     * IllegalArgumentException must be thrown when encountering null GraphNode.
     */
    public void testTextFieldForException() {
        try {
            new TextField(null);
            // should not be here
            fail("IllegalArgumentException expected.");
        } catch (IllegalArgumentException e) {
            // should be here
        }
    }

    /**
     * <p>
     * Test of TextField(GraphNode, AnchorType) for IllegalArgumentException.
     * </p>
     * IllegalArgumentException must be thrown when encountering null GraphNode.
     */
    public void testTextFieldForException1() {
        try {
            new TextField(null, AnchorType.RightEnding);
            // should not be here
            fail("IllegalArgumentException expected.");
        } catch (IllegalArgumentException e) {
            // should be here
        }
    }

    /**
     * <p>
     * Test of TextField(GraphNode, AnchorType) for IllegalArgumentException.
     * </p>
     * IllegalArgumentException must be thrown when encountering null anchorType.
     */
    public void testTextFieldForException2() {
        try {
            new TextField(new GraphNode(), null);
            // should not be here
            fail("IllegalArgumentException expected.");
        } catch (IllegalArgumentException e) {
            // should be here
        }
    }

    /**
     * <p>
     * Test of notifyTextChange(String) for ignoring null message.
     * </p>
     *
     * No exception should be thrown when encountering null message.
     */
    public void testNotifyTextChangeForNullText() {
        try {
            // should not throw any exception
            textField.notifyTextChange(null);
        } catch (Exception e) {
            // should be here
            fail("No exception expected.");
        }
    }

    /**
     * <p>
     * Test of notifyTextChange(String) for ignoring empty message.
     * </p>
     *
     * No exception should be thrown when encountering empty message.
     */
    public void testNotifyTextChangeForEmptyText() {
        try {
            // should not throw any exception
            textField.notifyTextChange("");
        } catch (Exception e) {
            // should be here
            fail("No exception expected.");
        }
    }
    /**
     * <p>
     * Test of setText(String) for ignoring null text.
     * </p>
     *
     * No exception should be thrown when encountering null text.
     */
    public void testSetTextForNullText() {
        try {
            // should not throw any exception
            textField.setText(null);
        } catch (Exception e) {
            // should be here
            fail("No exception expected.");
        }
    }
    /**
     * <p>
     * Test of setText(String) for ignoring empty text.
     * </p>
     *
     * No exception should be thrown when encountering empty text.
     */
    public void testSetTextForEmptyText() {
        try {
            // should not throw any exception
            textField.setText("");
        } catch (Exception e) {
            // should be here
            fail("No exception expected.");
        }
    }

    /**
     * <p>
     * Test of measureSize(String) for IllegalArgumentException.
     * </p>
     * IllegalArgumentException must be thrown when encountering null measured text.
     */
    public void testMeasureSizeForException() {
        try {
            textField.measureSize(null);
            // should not be here
            fail("IllegalArgumentException expected.");
        } catch (IllegalArgumentException e) {
            // should be here
        }
    }
    /**
     * <p>
     * Test of measureSize(String) for ignoring empty text.
     * </p>
     *
     * No exception should be thrown when encountering empty text.
     */
    public void testMeasureSizeForEmptyText() {
        try {
            // should not throw any exception
            textField.measureSize("");
        } catch (Exception e) {
            // should be here
            fail("No exception expected.");
        }
    }

    /**
     * <p>
     * Test of paintComponent(Graphics) for ignoring null Graphics.
     * </p>
     *
     * No exception should be thrown when encountering null Graphics.
     */
    public void testPaintComponentForIgnoreNullGraphics() {
        try {
            // should not throw any exception
            textField.paintComponent(null);
        } catch (Exception e) {
            // should be here
            fail("No exception expected.");
        }
    }

    /**
     * <p>
     * Test of testFireTextChange(TextChangeEvent) for ignoring null event.
     * </p>
     *
     * No exception should be thrown when encountering null event.
     */
    public void testFireTextChangeForIgnoreNullTextChangeEvent() {
        try {
            // should not throw any exception
            textField.fireTextChange(null);
        } catch (Exception e) {
            // should be here
            fail("No exception expected.");
        }
    }

    /**
     * <p>
     * Test of removeTextChangeListener(TextChangeListener) for ignoring null listener.
     * </p>
     *
     * No exception should be thrown when encountering null listener.
     */
    public void testRemoveTextChangeListenerForIgnoreNullTextChangeListener() {
        try {
            // should not throw any exception
            textField.removeTextChangeListener(null);
        } catch (Exception e) {
            // should be here
            fail("No exception expected.");
        }
    }

    /**
     * <p>
     * Test of addTextChangeListener(TextChangeListener) for ignoring null listener.
     * </p>
     *
     * No exception should be thrown when encountering null listener.
     */
    public void testAddTextChangeListenerForIgnoreNullTextChangeListener() {
        try {
            // should not throw any exception
            textField.addTextChangeListener(null);
        } catch (Exception e) {
            // should be here
            fail("No exception expected.");
        }
    }

    /**
     * <p>
     * Test of setFontColor(Color) for ignoring null color.
     * </p>
     *
     * No exception should be thrown when encountering null color.
     */
    public void testSetFontColorForNullColor() {
        try {
            // should not throw any exception
            textField.setFontColor(null);
        } catch (Exception e) {
            // should be here
            fail("No exception expected.");
        }
    }

    /**
     * Mock TextField class for testing TextField's protected methods.
     *
     * @author still
     * @version 1.0
     */
    private class MockTextField extends TextField {
        /**
         * MockTextField constructor.
         *
         * @param graphNode the graph node
         */
        public MockTextField(GraphNode graphNode) {
            super(graphNode);
        }
        /**
         * <p>
         * Paint component.
         * </p>
         *
         * @param g
         *            the graphics to paint on (null will be ignored)
         */
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
        }
        /**
         * <p>
         * Notifies all listeners registered interest for <code>TextChangeEvent</code>.
         * </p>
         *
         * @param event
         *            the TextChangeEvent (ignore null)
         */
        protected void fireTextChange(TextChangeEvent event) {
            super.fireTextChange(event);
        }
    }
}
