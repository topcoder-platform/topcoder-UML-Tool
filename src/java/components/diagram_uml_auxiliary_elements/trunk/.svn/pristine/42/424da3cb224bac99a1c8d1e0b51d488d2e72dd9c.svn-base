/*
 * Copyright (C) 2007 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.gui.diagramviewer.uml.auxiliaryelements;

import com.topcoder.diagraminterchange.GraphNode;
import com.topcoder.diagraminterchange.Point;
import com.topcoder.diagraminterchange.Property;
import com.topcoder.diagraminterchange.Uml1SemanticModelBridge;
import com.topcoder.diagraminterchange.Diagram;
import com.topcoder.gui.diagramviewer.DiagramView;
import com.topcoder.gui.diagramviewer.DiagramViewer;
import com.topcoder.gui.diagramviewer.edges.Connector;
import com.topcoder.uml.model.core.auxiliaryelements.CommentImpl;
import com.topcoder.uml.model.core.auxiliaryelements.Comment;

import junit.framework.TestCase;
import junit.framework.TestSuite;
import junit.framework.Test;

import java.awt.Dimension;
import java.awt.Polygon;
import javax.swing.JFrame;


/**
 * <p>
 * Unit test cases for CommentNode.
 * </p>
 *
 * @author TCSDEVELOPER
 * @version 1.0
 */
public class CommentNodeTests extends TestCase {
    /**
     * <p>
     * Static final String for valid namespace.
     * </p>
     */
    private static final String VALID_NAMESPACE =
        "com.topcoder.gui.diagramviewer.uml.auxiliaryelements".intern();

    /**
     * <p>
     * The CommentNode instance for helping testing.
     * </p>
     */
    private CommentNode node;

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
     * The Uml1SemanticModelBridge instance for helping testing.
     * </p>
     */
    private Uml1SemanticModelBridge usmb;

    /**
     * <p>
     * The Comment instance for helping testing.
     * </p>
     */
    private Comment comment;

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
        usmb = new Uml1SemanticModelBridge();
        comment = new CommentImpl();
        comment.setBody("CommentNode\ntest");
        usmb.setElement(comment);
        graphNode.setSemanticModel(usmb);
        graphNode.setPosition(new com.topcoder.diagraminterchange.Point());
        dimension = new com.topcoder.diagraminterchange.Dimension();
        dimension.setWidth(300);
        dimension.setHeight(100);
        graphNode.setSize(dimension);
        node = new CommentNode(graphNode, mapping);
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
        dimension = null;
        comment = null;
        usmb = null;
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
        return new TestSuite(CommentNodeTests.class);
    }

    /**
     * <p>
     * Tests constructor CommentNode#CommentNode(GraphNode graphNode, PropertyMapping properties) for accuracy.
     * </p>
     *
     * <p>
     * Verify : the newly created CommentNode instance should not be null.
     * </p>
     *
     * @throws Exception to JUnit
     */
    public void testConstructor() throws Exception {
        assertNotNull("Failed to create a new CommentNode instance.", node);
        assertNotNull("The newly created BaseNode will have MouseListeners.", node.getMouseListeners());
    }

    /**
     * <p>
     * Tests constructor CommentNode#CommentNode(GraphNode graphNode, PropertyMapping properties) for failure.
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
            new CommentNode(null, mapping);
            fail("IllegalArgumentException expected.");
        } catch (IllegalArgumentException iae) {
            // good
        }
    }

    /**
     * <p>
     * Tests constructor CommentNode#CommentNode(GraphNode graphNode, PropertyMapping properties) for failure.
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
            new CommentNode(graphNode, null);
            fail("IllegalArgumentException expected.");
        } catch (IllegalArgumentException iae) {
            // good
        }
    }

    /**
     * <p>
     * Tests constructor CommentNode#CommentNode(GraphNode graphNode, PropertyMapping properties) for failure.
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
            new CommentNode(new GraphNode(), mapping);
            fail("IllegalGraphNodeException expected.");
        } catch (IllegalGraphNodeException ige) {
            // good
        }
    }

    /**
     * <p>
     * Tests CommentNode#getComment() for accuracy.
     * </p>
     *
     * <p>
     * Verify : CommentNode#getComment() is correct.
     * </p>
     *
     * @throws Exception to JUnit
     */
    public void testGetComment() throws Exception {
        assertNotNull("The return value of getComment should not be null.", node.getComment());
        assertTrue("The return value of getComment should be instance of Comment.",
                node.getComment() instanceof Comment);
    }

    /**
     * <p>
     * Tests CommentNode#getPreferredSize(String text) for accuracy.
     * </p>
     *
     * <p>
     * Verify : CommentNode#getPreferredSize(String text) is correct.
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
     * Tests CommentNode#notifyUpdate() for accuracy.
     * </p>
     *
     * <p>
     * Verify : CommentNode#notifyUpdate() is correct.
     * </p>
     *
     * @throws Exception to JUnit
     */
    public void testNotifyUpdate() throws Exception {
        JFrame frame = new JFrame();
        view.add(node);
        viewer.add(view);
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
     * Tests CommentNode#getText() for accuracy.
     * </p>
     *
     * <p>
     * Verify : CommentNode#getText() is correct.
     * </p>
     *
     * @throws Exception to JUnit
     */
    public void testGetText() throws Exception {
        assertNotNull("The return value of getText should not be null.", node.getText());
        assertEquals("The return value of getText should equal with the text of the textElement.",
                node.getText(), node.getComment().getBody());
    }

    /**
     * <p>
     * Tests CommentNode#contains(int x, int y) for accuracy.
     * </p>
     *
     * <p>
     * Verify : CommentNode#contains(int x, int y) is correct.
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

        assertTrue("This node should contain point (5, 5).", node.contains(5, 5));
        assertFalse("This node should not contain point (2, 30).", node.contains(2, 30));
    }

    /**
     * <p>
     * Tests CommentNode#getShape() for accuracy.
     * </p>
     *
     * <p>
     * Verify : CommentNode#getShape() is correct.
     * </p>
     *
     * @throws Exception to JUnit
     */
    public void testGetShape() throws Exception {
        assertNotNull("The return value of getShape should not be null.", node.getShape());
        assertTrue("The return value of getShape should be a instance of polygon.",
                node.getShape() instanceof Polygon);
    }

    /**
     * <p>
     * Tests CommentNode#getConnector() for accuracy.
     * </p>
     *
     * <p>
     * Verify : CommentNode#getConnector() is correct.
     * </p>
     *
     * @throws Exception to JUnit
     */
    public void testGetConnector() throws Exception {
        assertNotNull("The return value of getConnector should not be null.", node.getConnector());
        assertTrue("The return value of getConnector should be instance of Connector.",
                node.getConnector() instanceof Connector);
    }

    /**
     * <p>
     * Tests CommentNode#paintComponent(Graphics g) for accuracy.
     * </p>
     *
     * <p>
     * Verify : CommentNode#paintComponent(Graphics g) is correct.
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
        property.setValue("0x000000");
        graphNode.addProperty(property);
        property = new Property();
        property.setKey(mapping.getPropertyKey(PropertyMapping.FILL_COLOR));
        property.setValue("0xFFFF00");
        graphNode.addProperty(property);
        property = new Property();
        property.setKey(mapping.getPropertyKey(PropertyMapping.STROKE_COLOR));
        property.setValue("0xFF0000");
        graphNode.addProperty(property);

        graphNode.setSemanticModel(usmb);

        node = new CommentNode(graphNode, mapping);

        JFrame frame = new JFrame();
        frame.setTitle("CommentNode Frame Demo");
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

        frame.setVisible(false);
        frame.dispose();
        frame = null;
    }
}
