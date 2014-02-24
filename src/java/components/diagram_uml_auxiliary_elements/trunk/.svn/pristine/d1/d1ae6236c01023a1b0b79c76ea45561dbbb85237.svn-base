/*
 * Copyright (C) 2007 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.gui.diagramviewer.uml.auxiliaryelements;

import com.topcoder.diagraminterchange.Diagram;
import com.topcoder.diagraminterchange.GraphNode;
import com.topcoder.diagraminterchange.SimpleSemanticModelElement;
import com.topcoder.diagraminterchange.TextElement;
import com.topcoder.gui.diagramviewer.DiagramView;
import com.topcoder.gui.diagramviewer.DiagramViewer;

import junit.framework.TestCase;
import junit.framework.TestSuite;
import junit.framework.Test;

import java.awt.Dimension;
import java.awt.FontMetrics;
import java.awt.Point;

import javax.swing.JFrame;


/**
 * <p>
 * Unit test cases for TextNode.
 * </p>
 *
 * @author TCSDEVELOPER
 * @version 1.0
 */
public class TextNodeTests extends TestCase {
    /**
     * <p>
     * Constant for text "FreeText".
     * </p>
     */
    private static final String FREE_TEXT = "FreeText";

    /**
     * <p>
     * Static final String for valid namespace.
     * </p>
     */
    private static final String VALID_NAMESPACE =
        "com.topcoder.gui.diagramviewer.uml.auxiliaryelements".intern();

    /**
     * <p>
     * The TextNode instance for helping testing.
     * </p>
     */
    private TextNode node;

    /**
     * <p>
     * The GraphNode instance for helping testing.
     * </p>
     */
    private GraphNode graphNode;

    /**
     * <p>
     * The SimpleSemanticModelElement instance for helping testing.
     * </p>
     */
    private SimpleSemanticModelElement ssme;

    /**
     * <p>
     * The TextElement instance for helping testing.
     * </p>
     */
    private TextElement textElement;

    /**
     * <p>
     * The PropertyMapping instance for helping testing.
     * </p>
     */
    private PropertyMapping mapping;

    /**
     * <p>
     * The DiagramViewer instance for helping testing.
     * </p>
     */
    private DiagramViewer viewer;

    /**
     * <p>
     * The DiagramView instance for helping testing.
     * </p>
     */
    private DiagramView view;

    /**
     * <p>
     * Setup test environment.
     * </p>
     *
     * @throws Exception to JUnit
     *
     */
    protected void setUp() throws Exception {
        TestHelper.loadXMLConfig(TestHelper.CONFIG_FILE);
        mapping = new PropertyMapping(VALID_NAMESPACE);
        graphNode = new GraphNode();
        ssme = new SimpleSemanticModelElement();
        ssme.setTypeInfo(FREE_TEXT);
        graphNode.setSemanticModel(ssme);
        graphNode.setPosition(new com.topcoder.diagraminterchange.Point());
        graphNode.setSize(new com.topcoder.diagraminterchange.Dimension());
        textElement = new TextElement();
        textElement.setText("oldText");
        graphNode.addContained(textElement);
        node = new FreeTextNode(graphNode, mapping);
        viewer = new DiagramViewer();
        Diagram diagram = new Diagram();
        com.topcoder.diagraminterchange.Dimension dimension =
            new com.topcoder.diagraminterchange.Dimension();
        dimension.setWidth(500.0);
        dimension.setHeight(500.0);
        com.topcoder.diagraminterchange.Point point =
            new com.topcoder.diagraminterchange.Point();
        point.setX(5);
        point.setY(5);
        diagram.setPosition(point);
        diagram.setSize(dimension);
        view = viewer.createDiagramView(diagram);
        view.add(node);
    }

    /**
     * <p>
     * Tears down test environment.
     * </p>
     *
     * @throws Exception to JUnit
     */
    protected void tearDown() throws Exception {
        TestHelper.clearConfig();
        mapping = null;
        graphNode = null;
        ssme = null;
        textElement = null;
        node = null;
        viewer = null;
        view = null;
    }

    /**
     * <p>
     * Return all tests.
     * </p>
     *
     * @return all tests
     */
    public static Test suite() {
        return new TestSuite(TextNodeTests.class);
    }

    /**
     * <p>
     * Tests constructor TextNode#TextNode(GraphNode graphNode, PropertyMapping properties) for accuracy.
     * </p>
     *
     * <p>
     * Verify : the newly created TextNode instance should not be null.
     * </p>
     *
     * @throws Exception to JUnit
     */
    public void testConstructor() throws Exception {
        assertNotNull("Failed to create a new TextNode instance.", node);
        assertNotNull("The newly created BaseNode will have MouseListeners.", node.getMouseListeners());
    }

    /**
     * <p>
     * Tests constructor TextNode#TextNode(GraphNode graphNode, PropertyMapping properties) for failure.
     * </p>
     *
     * <p>
     * It tests the case that when graphNode is null and expects IllegalArgumentException.
     * </p>
     *
     * @throws Exception to JUnit
     */
    public void testConstructor_NullGraphNode() throws Exception {
        try {
            new FreeTextNode(null, mapping);
            fail("IllegalArgumentException expected.");
        } catch (IllegalArgumentException iae) {
            // good
        }
    }

    /**
     * <p>
     * Tests constructor TextNode#TextNode(GraphNode graphNode, PropertyMapping properties) for failure.
     * </p>
     *
     * <p>
     * It tests the case that when properties is null and expects IllegalArgumentException.
     * </p>
     *
     * @throws Exception to JUnit
     */
    public void testConstructor_NullProperties() throws Exception {
        try {
            new FreeTextNode(graphNode, null);
            fail("IllegalArgumentException expected.");
        } catch (IllegalArgumentException iae) {
            // good
        }
    }

    /**
     * <p>
     * Tests constructor TextNode#TextNode(GraphNode graphNode, PropertyMapping properties) for failure.
     * </p>
     *
     * <p>
     * It tests the case that when graphNode is invalid and expects IllegalGraphNodeException.
     * </p>
     *
     * @throws Exception to JUnit
     */
    public void testConstructor_InvalidGraphNode() throws Exception {
        try {
            new FreeTextNode(new GraphNode(), mapping);
            fail("IllegalGraphNodeException expected.");
        } catch (IllegalGraphNodeException ige) {
            // good
        }
    }

    /**
     * <p>
     * Tests TextNode#isDisplayText() for accuracy.
     * </p>
     *
     * <p>
     * Verify : TextNode#isDisplayText() is correct.
     * </p>
     *
     * @throws Exception to JUnit
     */
    public void testIsDisplayText() throws Exception {
        assertTrue("The return value of isDisplayText should be true.", node.isDisplayText());
    }

    /**
     * <p>
     * Tests TextNode#setDisplayText(boolean displayText) for accuracy.
     * </p>
     *
     * <p>
     * Verify : TextNode#setDisplayText(boolean displayText) is correct.
     * </p>
     *
     * @throws Exception to JUnit
     */
    public void testSetDisplayText() throws Exception {
        node.setDisplayText(false);
        assertFalse("The return value of isDisplayText should be false.", node.isDisplayText());
    }

    /**
     * <p>
     * Tests TextNode#getPreferredSize() for accuracy.
     * </p>
     *
     * <p>
     * Verify : TextNode#getPreferredSize() is correct.
     * </p>
     *
     * @throws Exception to JUnit
     */
    public void testGetPreferredSize() throws Exception {
        assertNotNull("The return value of getPreferredSize should not be null.", node.getPreferredSize());
        assertTrue("The return value of getPreferredSize should be instance of Dimension.",
                node.getPreferredSize() instanceof Dimension);
    }

    /**
     * <p>
     * Tests TextNode#getMinimumSize() for accuracy.
     * </p>
     *
     * <p>
     * Verify : TextNode#getMinimumSize() is correct.
     * </p>
     *
     * @throws Exception to JUnit
     */
    public void testGetMinimumSize() throws Exception {
        assertNotNull("The return value of getMinimumSize should not be null.", node.getMinimumSize());
        assertTrue("The return value of getMinimumSize should be instance of Dimension.",
                node.getMinimumSize() instanceof Dimension);
    }

    /**
     * <p>
     * Tests TextNode#measureText(String text) for accuracy.
     * </p>
     *
     * <p>
     * Verify : TextNode#measureText(String text) is correct.
     * </p>
     *
     * @throws Exception to JUnit
     */
    public void testMeasureText() throws Exception {
        assertNotNull("The return value of measureText should not be null.", node.measureText(""));
        assertTrue("The return value of measureText should be instance of Dimension.",
                node.measureText("") instanceof Dimension);

        // The test text.
        String text = "text\ntexttext\ntext.";

        // Get the FontMetrics.
        FontMetrics fontMetrics = node.getFontMetrics(node.getFont());

        // Calculate the size of the text.
        int width = 0;
        String[] parts = text.split("\n");
        for (String part : parts) {
            int d = fontMetrics.stringWidth(part);
            if (d > width) {
                width = d;
            }
        }

        assertEquals("The measureText is wrong.", node.measureText(text).width, width);
        assertEquals("The measureText is wrong.", node.measureText(text).height,
                parts.length * fontMetrics.getHeight());
    }

    /**
     * <p>
     * Tests TextNode#paintText(Graphics g, Point offset) for accuracy.
     * </p>
     *
     * <p>
     * Verify : TextNode#paintText(Graphics g, Point offset) is correct.
     * </p>
     *
     * @throws Exception to JUnit
     */
    public void testPaintText() throws Exception {
        JFrame frame = new JFrame();
        frame.getContentPane().add(viewer);
        frame.pack();
        frame.setVisible(true);

        node.paintText(frame.getGraphics(), new Point());

        // make the Frame visible for 1 second
        Thread.sleep(1000);

        frame.setVisible(false);
        frame.dispose();
        frame = null;
    }

    /**
     * <p>
     * Tests TextNode#addTextChangeListener(TextChangeListener listener) for accuracy.
     * </p>
     *
     * <p>
     * Verify : the TextNode#addTextChangeListener(TextChangeListener listener) is correct.
     * </p>
     *
     * @throws Exception to JUnit
     */
    public void testAddTextChangeListener() throws Exception {
        node.addTextChangeListener(new MockTextChangeListener());
        assertEquals("After add, this node should have one TextChangeListener.",
                node.getListeners(TextChangeListener.class).length, 1);
    }

    /**
     * <p>
     * Tests TextNode#removeTextChangeListener(TextChangeListener listener) for accuracy.
     * </p>
     *
     * <p>
     * Verify : the TextNode#removeTextChangeListener(TextChangeListener listener) is correct.
     * </p>
     *
     * @throws Exception to JUnit
     */
    public void testRemoveTextChangeListener() throws Exception {
        TextChangeListener listener = new MockTextChangeListener();
        node.addTextChangeListener(listener);
        node.removeTextChangeListener(listener);
        assertEquals("After add and remove, this node should not have TextChangeListener.",
                node.getListeners(TextChangeListener.class).length, 0);
    }

    /**
     * <p>
     * Tests TextNode#fireTextChange(TextChangeEvent event) for accuracy.
     * </p>
     *
     * <p>
     * Verify : the TextNode#fireTextChange(TextChangeEvent event) is correct.
     * </p>
     *
     * @throws Exception to JUnit
     */
    public void testFireTextChange() throws Exception {
        MockTextChangeListener listener = new MockTextChangeListener();
        node.addTextChangeListener(listener);
        node.fireTextChange(new TextChangeEvent(node, "oldText", "newText"));
        assertTrue("The listener should be triggered.", listener.getChanged());
    }
}
