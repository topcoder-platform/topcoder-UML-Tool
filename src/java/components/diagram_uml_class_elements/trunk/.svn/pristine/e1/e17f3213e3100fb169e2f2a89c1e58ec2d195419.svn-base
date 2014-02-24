/*
 * Copyright (C) 2007 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.gui.diagramviewer.uml.classelements.accuracytests;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.FontMetrics;

import javax.swing.JPanel;
import javax.swing.SwingUtilities;

import com.topcoder.diagraminterchange.GraphNode;
import com.topcoder.gui.diagramviewer.uml.classelements.TextField;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

/**
 * <p>
 * This is a test case for <code>TextField</code> class.
 * </p>
 * @author moonli
 * @version 1.0
 */
public class TextFieldTest extends TestCase {

    /**
     * <p>
     * Represents an instance of <code>GraphNode</code>.
     * </p>
     */
    private GraphNode graphNode;

    /**
     * <p>
     * Represents an instance of <code>TextField</code>.
     * </p>
     */
    private TextField textField;

    /**
     * <p>
     * Sets up test environment.
     * </p>
     * @throws Exception
     *             to JUnit
     */
    protected void setUp() throws Exception {
        JPanel parent = new JPanel();
        graphNode = new GraphNode();
        textField = new TextField(graphNode);
        parent.add(textField);
        // add an instance of TextChangeListener
        textField.addTextChangedListener(new MockTextChangedListener());
    }

    /**
     * <p>
     * Tears down test environment.
     * </p>
     * @throws Exception
     *             to JUnit
     */
    protected void tearDown() throws Exception {
        graphNode = null;
        textField = null;
    }

    /**
     * <p>
     * Aggregates all tests.
     * </p>
     * @return a test suite will be returned
     */
    public static Test suite() {
        return new TestSuite(TextFieldTest.class);
    }

    /**
     * <p>
     * Test for constructor.
     * </p>
     * <p>
     * Tests it for accuracy, non-null instance should be returned.
     * </p>
     * @throws Exception
     *             to JUnit
     */
    public void testCtorAccuracy() throws Exception {
        assertNotNull("'textField' should not be null.", textField);
        assertEquals("GraphNode mismatched.", graphNode, textField.getGraphNode());
    }

    /**
     * <p>
     * Test for <code>getText()</code> method.
     * </p>
     * <p>
     * Tests it for accuracy, first sets the text to 'text', so 'text' should be returned.
     * </p>
     * @throws Exception
     *             to JUnit
     */
    public void testGetTextAccuracy() throws Exception {
        textField.setText("text");
        assertEquals("Text mismatched.", "text", textField.getText());
    }

    /**
     * <p>
     * Test for <code>setFontColor(fontColor)</code> method.
     * </p>
     * <p>
     * Tests it for accuracy with Color.RED, Color.RED should be set.
     * </p>
     * @throws Exception
     *             to JUnit
     */
    public void testSetFontColorWithColorRED() throws Exception {
        textField.setFontColor(Color.RED);
        assertEquals("Color.RED should be returned.", Color.RED, textField.getFontColor());
    }

    /**
     * <p>
     * Test for <code>notifyTextChange(newText)</code> method.
     * </p>
     * <p>
     * All registered listeners should receive this event.
     * </p>
     * @throws Exception
     *             to JUnit
     */
    public void testNotifyTextChangeAccuracy() throws Exception {
        // set text of textField
        textField.setText("old text");

        // notifies all listeners about text change event
        textField.notifyTextChange("new text");
    }

    /**
     * <p>
     * Test for <code>getPreferredSize()</code> method.
     * </p>
     * <p>
     * Tests it for accuracy with empty text. demension(0,0) should be returned.
     * </p>
     * @throws Exception
     *             to JUnit
     */
    public void testGetPreferredSize() throws Exception {
        // set text of textField to empty string
        textField.setText("");

        assertEquals("Preferred size mismatched.", new Dimension(0, 0), textField
            .getPreferredSize());
    }

    /**
     * <p>
     * Test for <code>getPreferredSize()</code> method.
     * </p>
     * <p>
     * Tests it for accuracy, valid dimension should be returned.
     * </p>
     * @throws Exception
     *             to JUnit
     */
    public void testGetPreferredSizeAccuracy() throws Exception {
        // set text of textField to 'This is a text node!'
        String text = "This is a text node.";
        textField.setText(text);
        // gets font of the textField
        Font font = textField.getFont();
        FontMetrics metrics = textField.getFontMetrics(font);
        /*
         * BugFix: BUGID UML-8189
         * Description:
         * In measureSize, the preferred height is calculated as the sum of fontMetric's height and descent as
         * the preferred height.  This should only use fontMetric's height.
         * Solution:
         * Use fontMetric's height instead.
         */
        // old code
//        Dimension dim = new Dimension(SwingUtilities.computeStringWidth(metrics, text), metrics
//            .getHeight()
//            + metrics.getDescent());
        Dimension dim = new Dimension(SwingUtilities.computeStringWidth(metrics, text), metrics
                .getHeight());

        assertEquals("PreferredSize mismatched.", dim, textField.getPreferredSize());
    }

    /**
     * <p>
     * Test for <code>addTextChangeListener(textChangeListener)</code> method.
     * </p>
     * <p>
     * Tests it for accuracy with null argument.
     * </p>
     * @throws Exception
     *             to JUnit
     */
    public void testAddTextChangeListener() throws Exception {
        textField.addTextChangedListener(null);
    }

    /**
     * <p>
     * Test for <code>removeTextChangeListener(textChangeListener)</code> method.
     * </p>
     * <p>
     * Tests it for accuracy with null argument.
     * </p>
     * @throws Exception
     *             to JUnit
     */
    public void testRemoveTextChangeListener() throws Exception {
        textField.removeTextChangedListener(null);
    }
}
