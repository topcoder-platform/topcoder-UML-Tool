/*
 * Copyright (C) 2007 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.gui.diagramviewer.uml.usecaseelements.accuracytests;

import java.awt.Color;

import junit.framework.TestCase;

import com.topcoder.diagraminterchange.GraphNode;
import com.topcoder.gui.diagramviewer.uml.usecaseelements.TextField;
import com.topcoder.gui.diagramviewer.uml.usecaseelements.event.TextChangeEvent;
import com.topcoder.gui.diagramviewer.uml.usecaseelements.event.TextChangeListener;

/**
 * Accuracy test for TextFieldAccuracy.
 *
 * @author radium
 * @version 1.0
 */
public class TextFieldAccuracyTest extends TestCase {
    /**
     * Mock class for testing.
     *
     * @author radium
     * @version 1.0
     */
    @SuppressWarnings("serial")
    private class MockTextField extends TextField {
        /**
         * Simple constructor.
         *
         * @param graphNode
         *            the graphNode.
         */
        public MockTextField(GraphNode graphNode) {
            super(graphNode);
        }

        /**
         * Simple implementation.
         */
        public void fireTextChange(TextChangeEvent event) {
            super.fireTextChange(event);
        }
    }

    /**
     * TextField for testing.
     */
    private MockTextField textField;

    /**
     * GraphNode for testing.
     */
    private GraphNode graphNode;

    /**
     * Setup the environment for testing.
     */
    protected void setUp() throws Exception {
        graphNode = new GraphNode();
        textField = new MockTextField(graphNode);
    }

    /**
     * Test method for getGraphNode().
     */
    public void testGetGraphNode() {
        assertEquals("Should be equal.", graphNode, textField.getGraphNode());
    }

    /**
     * Test method for setText() and getText().
     */
    public void testGetText() {
        String str = "hello world.";
        this.textField.setText(str);
        assertEquals("Should be equal.", str, this.textField.getText());

        // test null string.
        str = null;
        this.textField.setText(str);
        assertEquals("Should be equal.", "", this.textField.getText());
    }

    /**
     * Test method for getFontColor() and getFontColor().
     */
    public void testGetFontColor() {
        Color color = new Color(0, 1, 2);
        this.textField.setFontColor(color);
        assertEquals("Should be equal.", color, this.textField.getFontColor());
    }

    /**
     * Test method for notifyTextChange(String).
     */
    public void testNotifyTextChange() {
        this.textField.notifyTextChange("hello");
        // Should not change the text field actually.
        assertEquals("Should be equal.", "", this.textField.getText());
    }

    /**
     * Test method for addTextChangeListener(TextChangeListener).
     */
    public void testAddTextChangeListener() {
        MockTextChangeListener tcl = new MockTextChangeListener();
        this.textField.addTextChangeListener(tcl);
        assertEquals("Should be equal.", 1, this.textField.getListeners(TextChangeListener.class).length);
    }

    /**
     * Test method for removeTextChangeListener(TextChangeListener).
     */
    public void testRemoveTextChangeListener() {
        MockTextChangeListener tcl = new MockTextChangeListener();
        this.textField.addTextChangeListener(tcl);
        assertEquals("Should be equal.", 1, this.textField.getListeners(TextChangeListener.class).length);
        this.textField.removeTextChangeListener(tcl);
        assertEquals("Should be equal.", 0, this.textField.getListeners(TextChangeListener.class).length);
    }

    /**
     * Test method for fireTextChange(TextChangeEvent).
     */
    public void testFireTextChange() {
        MockTextChangeListener tcl = new MockTextChangeListener();
        this.textField.addTextChangeListener(tcl);
        this.textField.fireTextChange(new TextChangeEvent(textField, "oldName", "newName"));
        assertTrue("Should be true.", tcl.getIsExcute());
    }
}
