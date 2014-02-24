/*
 * Copyright (C) 2007 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.gui.diagramviewer.uml.auxiliaryelements;

import com.topcoder.diagraminterchange.Diagram;
import com.topcoder.diagraminterchange.GraphNode;
import com.topcoder.diagraminterchange.Point;
import com.topcoder.diagraminterchange.Property;
import com.topcoder.diagraminterchange.SimpleSemanticModelElement;
import com.topcoder.diagraminterchange.TextElement;
import com.topcoder.gui.diagramviewer.DiagramView;
import com.topcoder.gui.diagramviewer.DiagramViewer;

import junit.framework.TestCase;
import junit.framework.TestSuite;
import junit.framework.Test;

import java.awt.Dimension;

import javax.swing.JFrame;


/**
 * <p>
 * Unit test cases for FreeTextNode.
 * </p>
 *
 * @author TCSDEVELOPER
 * @version 1.0
 */
public class FreeTextNodeTests extends TestCase {
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
     * The FreeTextNode instance for helping testing.
     * </p>
     */
    private FreeTextNode node;

    /**
     * <p>
     * The com.topcoder.diagraminterchange.Dimension instance for helping testing.
     * </p>
     */
    private com.topcoder.diagraminterchange.Dimension dimension;

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
        textElement = new TextElement();
        textElement.setText("FreeTextNode\ntest");
        graphNode.addContained(textElement);
        graphNode.setPosition(new com.topcoder.diagraminterchange.Point());
        dimension = new com.topcoder.diagraminterchange.Dimension();
        dimension.setWidth(300);
        dimension.setHeight(100);
        graphNode.setSize(dimension);
        node = new FreeTextNode(graphNode, mapping);
        viewer = new DiagramViewer();
        Diagram diagram = new Diagram();
        com.topcoder.diagraminterchange.Dimension dimension =
            new com.topcoder.diagraminterchange.Dimension();
        dimension.setWidth(500.0);
        dimension.setHeight(500.0);
        Point point = new Point();
        point.setX(5);
        point.setY(5);
        diagram.setPosition(point);
        diagram.setSize(dimension);
        view = viewer.createDiagramView(diagram);
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
        textElement = null;
        ssme = null;
        dimension = null;
        node = null;
    }

    /**
     * <p>
     * Return all tests.
     * </p>
     *
     * @return all tests
     */
    public static Test suite() {
        return new TestSuite(FreeTextNodeTests.class);
    }

    /**
     * <p>
     * Tests constructor FreeTextNode#FreeTextNode(GraphNode graphNode, PropertyMapping properties) for accuracy.
     * </p>
     *
     * <p>
     * Verify : the newly created FreeTextNode instance should not be null.
     * </p>
     *
     * @throws Exception to JUnit
     */
    public void testConstructor() throws Exception {
        assertNotNull("Failed to create a new FreeTextNode instance.", node);
        assertNotNull("The newly created BaseNode will have MouseListeners.", node.getMouseListeners());
    }

    /**
     * <p>
     * Tests constructor FreeTextNode#FreeTextNode(GraphNode graphNode, PropertyMapping properties) for failure.
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
     * Tests constructor FreeTextNode#FreeTextNode(GraphNode graphNode, PropertyMapping properties) for failure.
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
     * Tests constructor FreeTextNode#FreeTextNode(GraphNode graphNode, PropertyMapping properties) for failure.
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
     * Tests FreeTextNode#getTextElement() for accuracy.
     * </p>
     *
     * <p>
     * Verify : FreeTextNode#getTextElement() is correct.
     * </p>
     *
     * @throws Exception to JUnit
     */
    public void testGetTextElement() throws Exception {
        assertNotNull("The return value of getTextElement should not be null.", node.getTextElement());
        assertTrue("The return value of getTextElement should be instance of TextElement.",
                node.getTextElement() instanceof TextElement);
    }

    /**
     * <p>
     * Tests FreeTextNode#getPreferredSize(String text) for accuracy.
     * </p>
     *
     * <p>
     * Verify : FreeTextNode#getPreferredSize(String text) is correct.
     * </p>
     *
     * @throws Exception to JUnit
     */
    public void testGetPreferredSize() throws Exception {
        String text = "text";
        assertNotNull("The return value of getPreferredSize should not be null.", node.getPreferredSize(text));
        assertTrue("The return value of getPreferredSize should be instance of Dimension.",
                node.getPreferredSize(text) instanceof Dimension);
    }

    /**
     * <p>
     * Tests FreeTextNode#getPreferredSize(String text) for failure.
     * </p>
     *
     * <p>
     * It tests the case that when text is null and expects IllegalArgumentException.
     * </p>
     *
     * @throws Exception to JUnit
     */
    public void testGetPreferredSize_NullText() throws Exception {
        try {
            node.getPreferredSize(null);
            fail("IllegalArgumentException expected.");
        } catch (IllegalArgumentException iae) {
            // good
        }
    }

    /**
     * <p>
     * Tests FreeTextNode#notifyUpdate() for accuracy.
     * </p>
     *
     * <p>
     * Verify : FreeTextNode#notifyUpdate() is correct.
     * </p>
     *
     * @throws Exception to JUnit
     */
    public void testNotifyUpdate() throws Exception {
        JFrame frame = new JFrame();
        frame.getContentPane().add(viewer);
        frame.pack();
        frame.setVisible(true);

        node.notifyUpdate();

        // make the Frame visible for 1 second
        Thread.sleep(1000);

        frame.setVisible(false);
        frame.dispose();
        frame = null;
    }

    /**
     * <p>
     * Tests FreeTextNode#getText() for accuracy.
     * </p>
     *
     * <p>
     * Verify : FreeTextNode#getText() is correct.
     * </p>
     *
     * @throws Exception to JUnit
     */
    public void testGetText() throws Exception {
        assertNotNull("The return value of getText should not be null.", node.getText());
        assertEquals("The return value of getText should equal with the text of the textElement.",
                node.getText(), node.getTextElement().getText());
    }

    /**
     * <p>
     * Tests FreeTextNode#contains(int x, int y) for accuracy.
     * </p>
     *
     * <p>
     * Verify : FreeTextNode#contains(int x, int y) is correct.
     * </p>
     *
     * @throws Exception to JUnit
     */
    public void testContains() throws Exception {
        dimension.setWidth(3);
        dimension.setHeight(4);
        graphNode.setSize(dimension);
        Point point = new Point();
        point.setX(1);
        point.setY(2);
        graphNode.setPosition(point);
        node.notifyUpdate();

        assertTrue("This node should contain point (2, 3).", node.contains(2, 3));
        assertTrue("This node should contain point (2, 30).", node.contains(2, 30));
    }

    /**
     * <p>
     * Tests FreeTextNode#paintComponent(Graphics g) for accuracy.
     * </p>
     *
     * <p>
     * Verify : FreeTextNode#paintComponent(Graphics g) is correct.
     * </p>
     *
     * @throws Exception to JUnit
     */
    public void testPaintComponent() throws Exception {
        JFrame frame = new JFrame();
        frame.getContentPane().add(viewer);
        frame.pack();
        frame.setVisible(true);

        // make the Frame visible for 1 second
        Thread.sleep(1000);

        frame.setVisible(false);
        frame.dispose();
        frame = null;
    }

    /**
     * <p>
     * Frame Demo.
     * </p>
     *
     * @throws Exception to JUnit
     */
    public void testFrame() throws Exception {
        Property property = new Property();
        property.setKey(mapping.getPropertyKey(PropertyMapping.FONT_COLOR));
        property.setValue("0xff0000");
        graphNode.addProperty(property);
        property = new Property();
        property.setKey(mapping.getPropertyKey(PropertyMapping.FILL_COLOR));
        property.setValue("0xffffff");
        graphNode.addProperty(property);
        property = new Property();
        property.setKey(mapping.getPropertyKey(PropertyMapping.STROKE_COLOR));
        property.setValue("0x0000ff");
        graphNode.addProperty(property);

        graphNode.setSemanticModel(ssme);

        node = new FreeTextNode(graphNode, mapping);

        JFrame frame = new JFrame();
        frame.setTitle("FreeTextNode Frame Demo");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().add(viewer);
        viewer.add(view);
        view.add(node);
        frame.setSize(new Dimension(500, 500));
        frame.setVisible(true);

        node.setLocation(100, 100);
        node.notifyUpdate();
        node.paintComponent(frame.getGraphics());

        // make the Frame visible for 2 second
        Thread.sleep(2000);

        node.setLocation(200, 200);
        node.notifyUpdate();
        node.paintComponent(frame.getGraphics());

        // make the Frame visible for 2 second
        Thread.sleep(2000);

        frame.setVisible(false);
        frame.dispose();
        frame = null;
    }
}
