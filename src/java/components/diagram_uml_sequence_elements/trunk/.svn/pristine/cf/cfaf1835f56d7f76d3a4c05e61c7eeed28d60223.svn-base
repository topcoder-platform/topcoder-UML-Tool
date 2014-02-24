/*
 * Copyright (C) 2007 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.gui.diagramviewer.uml.sequenceelements;

import java.awt.Color;

import junit.framework.TestCase;

/**
 * <p>
 * Test the functionality of <code>TextField</code> class.
 * </p>
 * @author TCSDEVELOPER
 * @version 1.0
 */
public class TextFieldTest extends TestCase {

    /**
     *An instance of <code>TextField</code> for testing.
     */
    private TextField textField;

    /**
     *A string for testing.
     */
    private String text = "text";

    /**
     *Font color for testing.
     */
    private Color fontColor;

    /**
     *Text changed listener for <code>TextField</code>.
     */
    private MockedTextChangedListener listener;

    /**
     * <p>
     * Sets up the test environment. The test instance is created.
     * </p>
     * @throws Exception to junit
     */
    protected void setUp() throws Exception {

        SequenceEdge edge = TestHelper.createCorrectSequeceEdge();

        textField = edge.getStereotypeCompartment();
        textField.setText(text);
        fontColor = Color.BLACK;
        textField.setFontColor(fontColor);

        listener = new MockedTextChangedListener();
    }

    /**
     * Test method for 'TextField(GraphNode)'. The instance should be created successfully.
     */
    public void testTextField_Accuracy() {
        assertNotNull("Test method for 'TextField(GraphNode)' failed.", textField);
    }

    /**
     * Test method for 'TextField(GraphNode)'. The argument is null, IllegalArgumentException should be thrown.
     */
    public void testTextField_null() {
        try {
            new TextField(null);
            fail("IllegalArgumentException should be thrown.");
        } catch (IllegalArgumentException iae) {
            // Success
        }
    }

    /**
     * Test method for 'getText()', text should be got correctly.
     */
    public void testGetText() {
        assertEquals("Text should be got correctly.", textField.getText(), text);
    }

    /**
     * Test method for 'setText(String)', text should be set correctly.
     */
    public void testSetTextString() {
        String newText = "newText";
        textField.setText(newText);
        assertEquals("Text should be set correctly.", textField.getText(), newText);
    }

    /**
     * Test method for 'setText(String)', given null, IllegalArgumentException should be thrown.
     */
    public void testSetTextString_null() {
        try {
            textField.setText(null);
            fail("IllegalArgumentException should be thrown.");
        } catch (IllegalArgumentException iae) {
            // Success
        }
    }

    /**
     * Test method for 'getFontColor()', font color should be got correctly.
     */
    public void testGetFontColor() {
        assertEquals("Font color should be got correctly.", textField.getFontColor(), fontColor);
    }

    /**
     * Test method for 'setFontColor(Color)', font color should be set correctly.
     */
    public void testSetFontColor() {
        Color color = Color.CYAN;
        textField.setFontColor(color);
        assertEquals("Font color should be set correctly.", textField.getFontColor(), color);
    }

    /**
     * Test method for 'setFontColor(Color)', null is given, font color should be set as black.
     */
    public void testSetFontColor_null() {
        textField.setFontColor(null);
        assertEquals("Font color should be set correctly.", textField.getFontColor(), Color.BLACK);
    }

    /**
     * Test method for 'notifyTextChange(String)', text should change accordingly.
     */
    public void testNotifyTextChange() {
        textField.addTextChangedListener(listener);
        String newText = "testNotifyTextChange";
        textField.notifyTextChange(newText);
        assertEquals("text should change accordingly.", textField.getText(), newText);
    }

    /**
     * Test method for 'notifyTextChange(String)', given null, text should change to empty string.
     */
    public void testNotifyTextChange_null() {
        textField.addTextChangedListener(listener);
        textField.notifyTextChange(null);
        assertEquals("text should change accordingly.", textField.getText(), "");
    }

    /**
     * Test method for 'getPreferredSize()', preferred size should be got correctly.
     */
    public void testGetPreferredSize() {
        assertNotNull("The preferred size should be got correctly.", textField.getPreferredSize());
    }

    /**
     * Test method for 'addTextChangedListener(TextChangedListener)', listener should be added correctly.
     */
    public void testAddTextChangedListener() {
        textField.removeTextChangedListener(listener);
        TextChangedListener[] oldListeners = textField.getListeners(TextChangedListener.class);
        textField.addTextChangedListener(listener);
        TextChangedListener[] newListeners = textField.getListeners(TextChangedListener.class);
        assertEquals("Listener should be added correctly.", oldListeners.length + 1, newListeners.length);
        assertEquals("Listener should be added correctly.", newListeners[newListeners.length - 1], listener);
    }

    /**
     * Test method for 'RemoveTextChangedListener(TextChangedListener)', listener should be removed correctly.
     */
    public void testRemoveTextChangedListener() {
        textField.addTextChangedListener(listener);
        TextChangedListener[] oldListeners = textField.getListeners(TextChangedListener.class);
        textField.removeTextChangedListener(listener);
        TextChangedListener[] newListeners = textField.getListeners(TextChangedListener.class);
        assertEquals("Listener should be removed correctly.", oldListeners.length - 1, newListeners.length);
    }

}
