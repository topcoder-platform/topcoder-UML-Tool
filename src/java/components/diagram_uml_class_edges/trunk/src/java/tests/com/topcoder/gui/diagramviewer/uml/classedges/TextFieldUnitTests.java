/*
 * Copyright (C) 2007 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.gui.diagramviewer.uml.classedges;

import com.topcoder.diagraminterchange.GraphNode;
import com.topcoder.gui.diagramviewer.edges.AnchorType;
import com.topcoder.gui.diagramviewer.uml.classedges.event.TextChangeEvent;
import com.topcoder.gui.diagramviewer.uml.classedges.event.TextChangeListener;
import com.topcoder.gui.diagramviewer.uml.classedges.event.MockTextChangeListener;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;

import junit.framework.TestCase;
import junit.framework.TestSuite;
import junit.framework.Test;

/**
 * <p>
 * Unit test cases for <code>TextField</code>.
 * </p>
 *
 * @author littlebull
 * @version 1.0
 */
public class TextFieldUnitTests extends TestCase {

    /** TextField instance for testing. */
    private TextField textField;

    /** GraphNode instance for testing. */
    private GraphNode node;

    /**
     * <p>
     * Setup test environment.
     * </p>
     */
    protected void setUp() {
        node = new GraphNode();
        textField = new TextField(node);
    }

    /**
     * <p>
     * Tears down test environment.
     * </p>
     *
     */
    protected void tearDown() {
        node = null;
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
        return new TestSuite(TextFieldUnitTests.class);
    }

    /**
     * <p>
     * Failure test of constructor <code>TextField(GraphNode)</code>.
     * With null <code>graphNode</code>.
     * Should throw IAE.
     * </p>
     */
    public void testCtor_Failure_NullGraphNode_1() {
        GraphNode graphNode = null;

        try {
            new TextField(graphNode);
            fail("Should throw IAE.");
        } catch (IllegalArgumentException e) {
            //pass
        }
    }

    /**
     * <p>
     * Accuracy test of constructor <code>TextField(GraphNode)</code>.
     * Should create the instance successfully.
     * </p>
     */
    public void testCtor_Accuracy_1() {
        assertNotNull("Should create the instance successfully.", textField);
    }

    /**
     * <p>
     * Failure test of constructor <code>TextField(GraphNode, AnchorType)</code>.
     * With null <code>graphNode</code>.
     * Should throw IAE.
     * </p>
     */
    public void testCtor_Failure_NullGraphNode_2() {
        GraphNode graphNode = null;

        try {
            new TextField(graphNode, AnchorType.Line);
            fail("Should throw IAE.");
        } catch (IllegalArgumentException e) {
            //pass
        }
    }

    /**
     * <p>
     * Failure test of constructor <code>TextField(GraphNode, AnchorType)</code>.
     * With null <code>anchorType</code>.
     * Should throw IAE.
     * </p>
     */
    public void testCtor_Failure_NullAnchorType() {
        try {
            new TextField(node, null);
            fail("Should throw IAE.");
        } catch (IllegalArgumentException e) {
            //pass
        }
    }

    /**
     * <p>
     * Accuracy test of constructor <code>TextField(GraphNode, AnchorType)</code>.
     * Should create the instance successfully.
     * </p>
     */
    public void testCtor_Accuracy_2() {
        textField = new TextField(node, AnchorType.Line);
        assertNotNull("Should create the instance successfully.", textField);
    }

    /**
     * <p>
     * Accuracy test of method <code>getText()</code>.
     * Should return the proper text.
     * </p>
     */
    public void testGetText() {
        assertEquals("Should return the proper text.", "", textField.getText());
    }

    /**
     * <p>
     * Accuracy test of method <code>setText(String)</code>.
     * With null <code>text</code>.
     * Should set the text to empty string.
     * </p>
     */
    public void testSetText_NullText() {
        textField.setText(null);
        assertEquals("Should set the text to empty string.", "", textField.getText());
    }

    /**
     * <p>
     * Accuracy test of method <code>setText(String)</code>.
     * With not null <code>text</code>.
     * Should set the text.
     * </p>
     */
    public void testSetText_NotNullText() {
        String someText = "some text";
        textField.setText(someText);
        assertEquals("Should set the text.", someText, textField.getText());
    }

    /**
     * <p>
     * Accuracy test of method <code>getFontColor()</code>.
     * Should return the proper font color.
     * </p>
     */
    public void testGetFontColor() {
        assertEquals("Should return the proper font color.", Color.BLACK, textField.getFontColor());
    }

    /**
     * <p>
     * Accuracy test of method <code>setFontColor(Color)</code>.
     * With null <code>color</code>.
     * Should set the font color to Color.BLACK.
     * </p>
     */
    public void testSetFontColor_NullColor() {
        textField.setFontColor(null);
        assertEquals("Should set the font color to Color.BLACK.", Color.BLACK, textField.getFontColor());
    }

    /**
     * <p>
     * Accuracy test of method <code>setFontColor(Color)</code>.
     * With not null <code>color</code>.
     * Should set the font color.
     * </p>
     */
    public void testSetFontColor_NotNullColor() {
        Color someColor = Color.white;
        textField.setFontColor(someColor);
        assertEquals("Should set the font color.", someColor, textField.getFontColor());
    }

    /**
     * <p>
     * Accuracy test of method <code>addTextChangeListener(TextChangeListener)</code>.
     * Should add the listener.
     * </p>
     */
    public void testAddTextChangeListener() {
        assertEquals(0, textField.getListeners(TextChangeListener.class).length);
        textField.addTextChangeListener(new MockTextChangeListener());
        assertEquals(1, textField.getListeners(TextChangeListener.class).length);
    }

    /**
     * <p>
     * Accuracy test of method <code>removeTextChangeListener(TextChangeListener)</code>.
     * Should remove the listener.
     * </p>
     */
    public void testRemoveTextChangeListener() {
        TextChangeListener listener = new MockTextChangeListener();
        textField.addTextChangeListener(listener);
        assertEquals(1, textField.getListeners(TextChangeListener.class).length);
        textField.removeTextChangeListener(listener);
        assertEquals(0, textField.getListeners(TextChangeListener.class).length);
    }

    /**
     * <p>
     * Accuracy test of method <code>fireTextChange(TextChangeEvent)</code>.
     * With null <code>event</code>
     * Should return directly.
     * </p>
     */
    public void testFireTextChange_NullEvent() {
        textField.fireTextChange(null);
        //return directly
    }

    /**
     * <p>
     * Accuracy test of method <code>fireTextChange(TextChangeEvent)</code>.
     * With not null <code>event</code>
     * Should fire text change properly.
     * </p>
     */
    public void testFireTextChange_NotNullEvent() {
        MockTextChangeListener listener = new MockTextChangeListener();
        textField.addTextChangeListener(listener);
        String oldText = "old text";
        String newText = "new text";
        TextChangeEvent event = new TextChangeEvent(textField, oldText, newText);
        textField.fireTextChange(event);

        assertTrue("Failed to fire text change correctly.", listener.getIsExecute());
        assertSame("Failed to fire text change correctly.", textField, listener.getTextChangeEvent().getSource());
        assertEquals("Failed to fire text change correctly.", oldText, listener.getTextChangeEvent().getOldText());
        assertEquals("Failed to fire text change correctly.", newText, listener.getTextChangeEvent().getNewText());
    }

    /**
     * <p>
     * Failure test of method <code>notifyTextChange(String)</code>.
     * With null <code>newText</code>
     * Should throw IAE.
     * </p>
     */
    public void testNotifyTextChange_NullNewText() {
        try {
            textField.notifyTextChange(null);
        } catch (IllegalArgumentException e) {
            //pass
        }
    }

    /**
     * <p>
     * Accuracy test of method <code>notifyTextChange(String)</code>.
     * With not null <code>newText</code>
     * Should notify text change properly.
     * </p>
     */
    public void testNotifyTextChange_NotNullNewText() {
        MockTextChangeListener listener = new MockTextChangeListener();
        textField.addTextChangeListener(listener);
        String oldText = "old text";
        textField.setText(oldText);
        String newText = "new text";
        textField.notifyTextChange(newText);

        assertTrue("Failed to fire text change correctly.", listener.getIsExecute());
        assertSame("Failed to fire text change correctly.", textField, listener.getTextChangeEvent().getSource());
        assertEquals("Failed to fire text change correctly.", oldText, listener.getTextChangeEvent().getOldText());
        assertEquals("Failed to fire text change correctly.", newText, listener.getTextChangeEvent().getNewText());
    }

    /**
     * <p>
     * Failure test of method <code>measureSize(String)</code>.
     * With null <code>text</code>
     * Should throw IAE.
     * </p>
     */
    public void testMeasureSize_NullText() {
        try {
            textField.measureSize(null);
        } catch (IllegalArgumentException e) {
            //pass
        }
    }

    /**
     * <p>
     * Accuracy test of method <code>measureSize(String)</code>.
     * With not null <code>text</code>
     * Should return the proper dimension.
     * </p>
     */
    public void testMeasureSize_NotNullText() {
        JFrame frame = new JFrame();
        frame.add(textField);
        Font font = textField.getParent().getFont();
        FontMetrics fm = textField.getFontMetrics(font);
        String text = "some text";
        int width = SwingUtilities.computeStringWidth(fm, text);
        int height = fm.getHeight();

        assertEquals("Failed to measure size correctly.", new Dimension(width, height), textField.measureSize(text));
    }

    /**
     * <p>
     * Accuracy test of method <code>getPreferredSize()</code>.
     * Should return the proper dimension.
     * </p>
     */
    public void testGetPreferredSize() {
        JFrame frame = new JFrame();
        frame.add(textField);
        String text = "some text";
        textField.setText(text);

        assertEquals("Failed to get the preferred size.", textField.measureSize(text), textField.getPreferredSize());
    }

    /**
     * <p>
     * Accuracy test of method <code>paintComponent(Graphics)</code>.
     * With null <code>g</code>.
     * Should return directly.
     * </p>
     */
    public void testPaintComponent_NullGraphics() {
        textField.paintComponent(null);
        //return directly
    }

    /**
     * <p>
     * Accuracy test of method <code>paintComponent(Graphics)</code>.
     * With not null <code>g</code>.
     * Should paint the component.
     * </p>
     */
    public void testPaintComponent_NotNullGraphics() {
        JFrame frame = new JFrame();
        frame.setVisible(true);
        Graphics g = frame.getGraphics();

        frame.add(textField);
        textField.paintComponent(g);
        frame.setVisible(false);
    }

    /**
     * <p>
     * The entry of the demo program.
     * </p>
     *
     * @param args the arguments
     */
    public static void main(String[] args) {
        // set up the text field instance
        TextField textField = new TextField(new GraphNode());
        textField.setText("Drag me, I'll follow with U ;)");
        Font font = new Font("Arial", Font.PLAIN, 12);
        textField.setFont(font);
        textField.setFontColor(Color.RED);

        // set up the JFrame instance and show it
        JFrame frame = new JFrame();
        frame.setTitle("[Demo]TextField");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        frame.add(textField);

        frame.setSize(new Dimension(500, 500));
        frame.setVisible(true);
    }
}
