/*
 * Copyright (C) 2007 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.gui.diagramviewer.uml.classedges.accuracytests;

import com.topcoder.diagraminterchange.GraphNode;

import com.topcoder.gui.diagramviewer.edges.AnchorType;
import com.topcoder.gui.diagramviewer.uml.classedges.TextField;
import com.topcoder.gui.diagramviewer.uml.classedges.event.MockTextChangeListener;
import com.topcoder.gui.diagramviewer.uml.classedges.event.TextChangeListener;

import junit.framework.TestCase;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.FontMetrics;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;


/**
 * <p>Test the accuracy of TextField class.</p>
 *
 * @author KLW
 * @version 1.0
 */
public class TextFieldAccuracyTests extends TestCase {
    /** TextField instance for testing. */
    private TextField textField;

    /** GraphNode instance for testing. */
    private GraphNode node;

    /**
     * <p>Setup test environment.</p>
     */
    protected void setUp() {
        node = new GraphNode();
        textField = new TextField(node);
    }

    /**
     * <p>Tears down test environment.</p>
     */
    protected void tearDown() {
        node = null;
        textField = null;
    }

    /**
     * <p>Accuracy test of constructor <code>TextField(GraphNode)</code>. Should create the
     * instance successfully.</p>
     */
    public void testCtor1() {
        assertNotNull("Should create the instance successfully.", textField);
    }

    /**
     * <p>Accuracy test of constructor <code>TextField(GraphNode, AnchorType)</code>.
     * Should create the instance successfully.</p>
     */
    public void testCtor2() {
        textField = new TextField(node, AnchorType.Line);
        assertNotNull("Should create the instance successfully.", textField);
    }

    /**
     * <p>Accuracy test of method <code>setFontColor(Color)</code>. With null
     * <code>color</code>. Should set the font color to Color.BLACK.</p>
     */
    public void testSetFontColor1() {
        textField.setFontColor(null);
        assertEquals("Should set the font color to Color.BLACK.", Color.BLACK,
            textField.getFontColor());
    }

    /**
     * <p>Accuracy test of method <code>setFontColor(Color)</code>. With not null
     * <code>color</code>. Should set the font color.</p>
     */
    public void testSetFontColor2() {
        Color someColor = Color.white;
        textField.setFontColor(someColor);
        assertEquals("Should set the font color.", someColor, textField.getFontColor());
    }

    /**
     * <p>Accuracy test of method <code>addTextChangeListener(TextChangeListener)</code>.
     * Should add the listener.</p>
     */
    public void testAddTextChangeListener() {
        assertEquals(0, textField.getListeners(TextChangeListener.class).length);
        textField.addTextChangeListener(new MockTextChangeListener());
        assertEquals(1, textField.getListeners(TextChangeListener.class).length);
    }

    /**
     * <p>Accuracy test of method
     * <code>removeTextChangeListener(TextChangeListener)</code>. Should remove the listener.</p>
     */
    public void testRemoveTextChangeListener() {
        TextChangeListener listener = new MockTextChangeListener();
        textField.addTextChangeListener(listener);
        assertEquals(1, textField.getListeners(TextChangeListener.class).length);
        textField.removeTextChangeListener(listener);
        assertEquals(0, textField.getListeners(TextChangeListener.class).length);
    }

    /**
     * <p>Accuracy test of method <code>measureSize(String)</code>. With not null
     * <code>text</code> Should return the proper dimension.</p>
     */
    public void testMeasureSize() {
        JFrame frame = new JFrame();
        frame.add(textField);

        Font font = textField.getParent().getFont();
        FontMetrics fm = textField.getFontMetrics(font);
        String text = "some text";
        int width = SwingUtilities.computeStringWidth(fm, text);
        int height = fm.getHeight();

        assertEquals("Failed to measure size correctly.", new Dimension(width, height),
            textField.measureSize(text));
    }

    /**
     * <p>Accuracy test of method <code>getPreferredSize()</code>. Should return the proper
     * dimension.</p>
     */
    public void testGetPreferredSize() {
        JFrame frame = new JFrame();
        frame.add(textField);

        String text = "some text";
        textField.setText(text);

        assertEquals("Failed to get the preferred size.", textField.measureSize(text),
            textField.getPreferredSize());
    }
}
