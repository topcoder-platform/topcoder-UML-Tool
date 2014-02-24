/*
 * Copyright (C) 2007 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.gui.diagramviewer.uml.usecaseelements;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;

import junit.framework.TestCase;

import com.topcoder.diagraminterchange.GraphNode;
import com.topcoder.gui.diagramviewer.edges.AnchorType;
import com.topcoder.gui.diagramviewer.uml.usecaseelements.event.MockTextChangeListener;
import com.topcoder.gui.diagramviewer.uml.usecaseelements.event.TextChangeEvent;
import com.topcoder.gui.diagramviewer.uml.usecaseelements.event.TextChangeListener;

/**
 * <p>
 * Unit test cases for TextField.
 * </p>
 *
 * @author TCSDEVELOPER
 * @version 1.0
 */
public class TextFieldTests extends TestCase {
    /**
     * <p>
     * TextField instance for testing.
     * </p>
     */
    private TextField textField;

    /**
     * <p>
     * GraphNode instance for testing.
     * </p>
     */
    private GraphNode graphNode;

    /**
     * <p>
     * Sets up test environment.
     * </p>
     */
    protected void setUp() {
        graphNode = new GraphNode();
        textField = new TextField(graphNode);
    }

    /**
     * <p>
     * Tears down test environment.
     * </p>
     */
    protected void tearDown() {
        textField = null;
    }

    /**
     * <p>
     * Tests {@link TextField#TextField(GraphNode)} for accuracy.
     * </p>
     * <p>
     * It verifies the newly created TextField instance is not null.
     * </p>
     */
    public void testCtor() {
        assertNotNull("Failed to create the TextField instance.", textField);
    }

    /**
     * <p>
     * Tests {@link TextField#TextField(GraphNode, com.topcoder.gui.diagramviewer.edges.AnchorType)} for accuracy.
     * </p>
     * <p>
     * It verifies the newly created TextField instance is not null.
     * </p>
     */
    public void testCtor1() {
        assertNotNull("Failed to create the TextField instance.", new TextField(graphNode, AnchorType.Line));
    }

    /**
     * <p>
     * Tests TextField#getGraphNode() for accuracy.
     * </p>
     * <p>
     * It verifies TextField#getGraphNode() is correct.
     * </p>
     */
    public void testGetGraphNode() {
        assertEquals("Failed to get the graphNode correctly.", graphNode, textField.getGraphNode());
    }

    /**
     * <p>
     * Tests TextField#getText(String) for accuracy.
     * </p>
     * <p>
     * It verifies TextField#getText(String) is correct.
     * </p>
     */
    public void testGetText() {
        textField.setText("test string");
        assertEquals("Failed to get the text correctly.", "test string", textField.getText());
    }

    /**
     * <p>
     * Tests TextField#setText(String) for accuracy.
     * </p>
     * <p>
     * It verifies TextField#setText(String) is correct.
     * </p>
     */
    public void testSetText() {
        textField.setText("test string");
        assertEquals("Failed to set the text correctly.", "test string", textField.getText());
    }

    /**
     * <p>
     * Tests TextField#setText(String) for accuracy.
     * </p>
     * <p>
     * It tests the case when text is null and expects it will be converted to empty string.
     * </p>
     */
    public void testSetText_NullText() {
        textField.setText(null);
        assertEquals("Failed to set the text correctly.", "", textField.getText());
    }

    /**
     * <p>
     * Tests TextField#getFontColor(Color) for accuracy.
     * </p>
     * <p>
     * It verifies TextField#getFontColor(Color) is correct.
     * </p>
     */
    public void testGetFontColor() {
        textField.setFontColor(Color.RED);
        assertEquals("Failed to get the font color correctly.", Color.RED, textField.getFontColor());
    }

    /**
     * <p>
     * Tests TextField#setFontColor(Color) for accuracy.
     * </p>
     * <p>
     * It verifies TextField#setFontColor(Color) is correct.
     * </p>
     */
    public void testSetFontColor() {
        textField.setFontColor(Color.RED);
        assertEquals("Failed to set the font color correctly.", Color.RED, textField.getFontColor());
    }

    /**
     * <p>
     * Tests TextField#setFontColor(Color) for accuracy.
     * </p>
     * <p>
     * It tests the case when color is null and expects it will use default color(Black).
     * </p>
     */
    public void testSetFontColor_NullColor() {
        textField.setFontColor(null);
        assertEquals("Failed to set the font color correctly.", Color.BLACK, textField.getFontColor());
    }

    /**
     * <p>
     * Tests TextField#notifyTextChange(String) for accuracy.
     * </p>
     * <p>
     * It verifies TextField#notifyTextChange(String) is correct.
     * </p>
     */
    public void testNotifyTextChange() {
        MockTextChangeListener listener = new MockTextChangeListener();

        textField.setText("old text");
        textField.addTextChangeListener(listener);
        textField.notifyTextChange("new text");

        assertTrue("Failed to notify text change correctly.", listener.getIsExecute());
        assertSame("Failed to notify text change correctly.", textField, listener.getTextChangeEvent().getSource());
        assertEquals("Failed to notify text change correctly.", "old text", listener.getTextChangeEvent().getOldText());
        assertEquals("Failed to notify text change correctly.", "new text", listener.getTextChangeEvent().getNewText());
    }

    /**
     * <p>
     * Tests TextField#getPreferredSize() for accuracy.
     * </p>
     * <p>
     * It verifies TextField#getPreferredSize() is correct.
     * </p>
     */
    public void testGetPreferredSize1() {
        JFrame frame = new JFrame();
        frame.add(textField);
        textField.setText("test string");
        String text = textField.getText();
        assertEquals("Failed to get preferred size correctly.", textField.measureSize(text), textField
                .getPreferredSize());
    }

    /**
     * <p>
     * Tests TextField#getPreferredSize() for accuracy.
     * </p>
     * <p>
     * It verifies TextField#getPreferredSize() is correct.
     * </p>
     */
    public void testGetPreferredSize2() {
        JFrame frame = new JFrame();
        frame.add(textField);
        textField.setText("");
        String text = textField.getText();
        assertEquals("Failed to get preferred size correctly.", textField.measureSize(text), textField
                .getPreferredSize());
    }

    /**
     * <p>
     * Tests TextField#measureSize(String) for accuracy.
     * </p>
     * <p>
     * It verifies TextField#measureSize(String) is correct.
     * </p>
     */
    public void testMeasureSize1() {
        JFrame frame = new JFrame();
        String text = "test string";
        frame.add(textField);

        Font font = textField.getParent().getFont();
        FontMetrics fm = textField.getFontMetrics(font);

        int width = SwingUtilities.computeStringWidth(fm, text);
        int height = fm.getHeight();

        assertEquals("Failed to measure size correctly.", new Dimension(width, height), textField.measureSize(text));
    }

    /**
     * <p>
     * Tests TextField#measureSize(String) for accuracy.
     * </p>
     * <p>
     * It verifies TextField#measureSize(String) is correct.
     * </p>
     */
    public void testMeasureSize2() {
        JFrame frame = new JFrame();
        String text = "";
        frame.add(textField);

        assertEquals("Failed to measure size correctly.", new Dimension(0, 0), textField.measureSize(text));
    }

    /**
     * <p>
     * Tests TextField#paintComponent(Graphics) for accuracy.
     * </p>
     * <p>
     * It provides the graphics, and ensures no exception will be thrown.
     * </p>
     */
    public void testPaintComponent() {
        JFrame frame = new JFrame();
        frame.setVisible(true);
        Graphics g = frame.getGraphics();
        textField.paintComponent(g);
        frame.setVisible(false);
    }

    /**
     * <p>
     * Tests TextField#paintComponent(Graphics) for accuracy.
     * </p>
     * <p>
     * It tests the case that when g is null and expects the methods ignores it.
     * </p>
     */
    public void testPaintComponent_NullG() {
        textField.paintComponents(null);
    }

    /**
     * <p>
     * Tests TextField#addTextChangeListener(TextChangeListener) for accuracy.
     * </p>
     * <p>
     * It verifies TextField#addTextChangeListener(TextChangeListener) is correct.
     * </p>
     */
    public void testAddTextChangeListener() {
        TextChangeListener listener = new MockTextChangeListener();
        textField.addTextChangeListener(listener);

        assertEquals("Expected the length of listeners is one.", 1,
                textField.getListeners(TextChangeListener.class).length);
        assertEquals("Failed to set the listener correctly.", listener, textField
                .getListeners(TextChangeListener.class)[0]);
    }

    /**
     * <p>
     * Tests TextField#addTextChangeListener(TextChangeListener) for accuracy.
     * </p>
     * <p>
     * It tests the case that when listener is null and expects success.
     * </p>
     */
    public void testAddTextChangeListener_NullListener() {
        textField.addTextChangeListener(null);

        assertEquals("Failed to set the listener correctly.", 0,
                textField.getListeners(TextChangeListener.class).length);
    }

    /**
     * <p>
     * Tests TextField#removeTextChangeListener(TextChangeListener) for accuracy.
     * </p>
     * <p>
     * It verifies TextField#removeTextChangeListener(TextChangeListener) is correct.
     * </p>
     */
    public void testRemoveTextChangeListener() {
        TextChangeListener listener = new MockTextChangeListener();
        textField.addTextChangeListener(listener);

        textField.removeTextChangeListener(listener);

        assertEquals("Failed to remove the listener correctly.", 0,
                textField.getListeners(TextChangeListener.class).length);
    }

    /**
     * <p>
     * Tests TextField#removeTextChangeListener(TextChangeListener) for accuracy.
     * </p>
     * <p>
     * It tests the case that when listener is null and expects success.
     * </p>
     */
    public void testRemoveTextChangeListener_NullListener() {
        TextChangeListener listener = new MockTextChangeListener();
        textField.addTextChangeListener(listener);

        textField.removeTextChangeListener(null);

        assertEquals("Failed to remove the listener correctly.", 1,
                textField.getListeners(TextChangeListener.class).length);
    }

    /**
     * <p>
     * Tests TextField#fireTextChange(TextChangeEvent) for accuracy.
     * </p>
     * <p>
     * It verifies TextField#fireTextChange(TextChangeEvent) is correct.
     * </p>
     */
    public void testFireTextChange() {
        MockTextChangeListener listener = new MockTextChangeListener();
        TextChangeEvent event = new TextChangeEvent(textField, "old text", "new text");

        textField.addTextChangeListener(listener);

        textField.fireTextChange(event);

        assertTrue("Failed to fire the listener correctly.", listener.getIsExecute());
        assertEquals("Failed to fire the listener correctly.", event, listener.getTextChangeEvent());
    }

    /**
     * <p>
     * Tests TextField#fireTextChange(TextChangeEvent) for accuracy.
     * </p>
     * <p>
     * It tests the case that when listener is null and expects success.
     * </p>
     */
    public void testFireTextChange_NullEvent() {
        MockTextChangeListener listener = new MockTextChangeListener();
        textField.addTextChangeListener(listener);

        textField.fireTextChange(null);

        assertFalse("Failed to fire the listener correctly.", listener.getIsExecute());
    }

    /**
     * <p>
     * The entry of the demo program.
     * </p>
     *
     * @param args the arguments
     */
    public static void main(String[] args) {
        TextField text = new TextField(new GraphNode());
        Font font = new Font("Arial", Font.PLAIN, 12);
        text.setVisible(true);
        text.setFont(font);
        text.setText("ooo, This is my test case");
        text.setFontColor(Color.red);

        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().add(text);
        frame.setSize(new Dimension(500, 500));
        frame.setVisible(true);
    }
}
