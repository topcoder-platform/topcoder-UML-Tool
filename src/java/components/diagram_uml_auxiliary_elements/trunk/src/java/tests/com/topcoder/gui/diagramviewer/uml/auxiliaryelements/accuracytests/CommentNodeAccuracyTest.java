/*
 * Copyright (C) 2007 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.gui.diagramviewer.uml.auxiliaryelements.accuracytests;

import java.awt.Dimension;
import java.awt.Polygon;
import java.awt.Rectangle;

import javax.swing.JFrame;

import junit.framework.TestCase;

import com.topcoder.diagraminterchange.Diagram;
import com.topcoder.diagraminterchange.GraphNode;
import com.topcoder.diagraminterchange.Point;
import com.topcoder.diagraminterchange.Uml1SemanticModelBridge;
import com.topcoder.gui.diagramviewer.DiagramView;
import com.topcoder.gui.diagramviewer.DiagramViewer;
import com.topcoder.gui.diagramviewer.edges.Connector;
import com.topcoder.gui.diagramviewer.uml.auxiliaryelements.CommentNode;
import com.topcoder.gui.diagramviewer.uml.auxiliaryelements.PropertyMapping;
import com.topcoder.uml.model.core.auxiliaryelements.Comment;
import com.topcoder.uml.model.core.auxiliaryelements.CommentImpl;

/**
 * <p>
 * Unit test cases for CommentNode.
 * </p>
 *
 * @author Achilles_2005
 * @version 1.0
 */
public class CommentNodeAccuracyTest extends TestCase {

    /**
     * <p>
     * Private instance used for test.
     * </p>
     */
    private CommentNode commentNode;

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
     * Sets up test environment.
     * </p>
     *
     * @throws Exception
     *             exception to JUnit.
     */
    protected void setUp() throws Exception {
        super.setUp();
        // load config
        ConfigHelper.loadXMLConfigrationFile(ConfigHelper.ACC_CONFIG_FILE);
        // property mapping
        PropertyMapping propertyMapping = new PropertyMapping(ConfigHelper.ACC_NAMESPACE);
        //
        GraphNode graphNode = new GraphNode();
        Uml1SemanticModelBridge usmb = new Uml1SemanticModelBridge();
        Comment comment = new CommentImpl();
        comment.setBody("Comment");
        usmb.setElement(comment);
        graphNode.setSemanticModel(usmb);
        Point position = new Point();
        position.setX(100);
        position.setY(100);
        com.topcoder.diagraminterchange.Dimension size = new com.topcoder.diagraminterchange.Dimension();
        size.setHeight(200);
        size.setWidth(200);
        graphNode.setPosition(position);
        graphNode.setSize(size);
        commentNode = new CommentNode(graphNode, propertyMapping);
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
     * @throws Exception
     *             exception to JUnit.
     */
    protected void tearDown() throws Exception {
        ConfigHelper.clearConfigration();
        commentNode = null;
        viewer = null;
        view = null;
    }

    /**
     * <p>
     * Tests accuracy of <code>CommentNode(GraphNode, PropertyMapping)</code>.
     * </p>
     *
     * @throws Exception
     *             exception to JUnit.
     */
    public void testConstructorAccuracy() throws Exception {
        assertNotNull("instance should not be null.", commentNode);
        assertNotNull("instance should have MouseListeners.", commentNode.getMouseListeners());
        assertNotNull("Comment value should be setted.", commentNode.getComment());
        assertNotNull("Shape value should be setted.", commentNode.getShape());
        assertNotNull("Conector value should be setted.", commentNode.getConnector());
    }

    /**
     * <p>
     * Tests accuracy of <code>getComment()</code>.
     * </p>
     *
     * @throws Exception
     *             exception to JUnit.
     */
    public void testGetCommentAccuracy() throws Exception {
        assertTrue("The returned value should be instance of Comment.",
            commentNode.getComment() instanceof Comment);
    }

    /**
     * <p>
     * Tests accuracy of <code>getPreferredSize(String)</code>.
     * </p>
     *
     * @throws Exception
     *             exception to JUnit.
     */
    public void testGetPreferredSizeStringAccuracy() throws Exception {
        String text = "a";
        Dimension size = commentNode.getPreferredSize(text);
        assertTrue("preferred size should be getted correctly.", size.getHeight() > 20);
        assertTrue("preferred size should be getted correctly.", size.getWidth() > 20);
    }

    /**
     * <p>
     * Tests CommentNode#notifyUpdate() for accuracy.
     * </p>
     * <p>
     * Verify : CommentNode#notifyUpdate() is correct.
     * </p>
     *
     * @throws Exception
     *             exception to JUnit.
     */
    public void testNotifyUpdateAccuracy() throws Exception {
        Dimension oldSize = commentNode.getSize();
        assertEquals("height before notify should be 0.", 0.0, oldSize.getHeight());
        assertEquals("width before notify should be 0.", 0.0, oldSize.getWidth());

        commentNode.notifyUpdate();
        Dimension newSize = commentNode.getSize();
        assertEquals("size should be setted correctly.", 210.0, newSize.getHeight());
        assertEquals("size should be setted correctly.", 210.0, newSize.getWidth());

        commentNode.notifyUpdate();
        commentNode.notifyUpdate();
        commentNode.notifyUpdate();
        newSize = commentNode.getSize();
        assertEquals("size should be setted correctly.", 210.0, newSize.getHeight());
        assertEquals("size should be setted correctly.", 210.0, newSize.getWidth());
    }

    /**
     * <p>
     * Tests accuracy of <code>getText()</code>.
     * </p>
     *
     * @throws Exception
     *             exception to JUnit.
     */
    public void testGetTextAccuracy() throws Exception {
        assertEquals("value of text should be getted correctly", "Comment", commentNode.getText());
    }

    /**
     * <p>
     * Tests accuracy of <code>contains(int, int)</code>.
     * </p>
     *
     * @throws Exception
     *             exception to JUnit.
     */
    public void testContains() throws Exception {
        commentNode.notifyUpdate();
        assertTrue("commentNode should contain point (101, 101).", commentNode.contains(101, 101));
        assertFalse("commentNode should not contain point (1000, 1000).", commentNode.contains(1000, 1000));
    }

    /**
     * <p>
     * Tests accuracy of <code>getShape()</code>.
     * </p>
     *
     * @throws Exception
     *             exception to JUnit.
     */
    public void testGetShapeAccuracy() throws Exception {
        commentNode.notifyUpdate();
        Rectangle shape = ((Polygon) commentNode.getShape()).getBounds();
        assertEquals("shape should be getted correctly", 200.0, shape.getWidth());
        assertEquals("shape should be getted correctly", 200.0, shape.getHeight());
    }

    /**
     * <p>
     * Tests accuracy of <code>getConnector()</code>.
     * </p>
     *
     * @throws Exception
     *             exception to JUnit.
     */
    public void testGetConnectorAccuracy() throws Exception {
        assertTrue("returned value should be instance of Connector.",
            commentNode.getConnector() instanceof Connector);
    }

    /**
     * <p>
     * Tests accuracy of <code>paintComponent(Graphics)</code>.
     * </p>
     *
     * @throws Exception
     *             exception to JUnit.
     */
    public void testPaintComponentAccuracy() throws Exception {
        commentNode.notifyUpdate();
        JFrame frame = new JFrame();
//        frame.getContentPane().add(commentNode);
//        frame.pack();
//        frame.setSize(1000, 1000);
//        frame.setVisible(true);
//        Thread.sleep(1000);
//        frame.dispose();

        Dimension size = new Dimension(500, 500);
        commentNode.setSize(size);
        commentNode.notifyUpdate();
        frame.getContentPane().add(viewer);
        viewer.add(view);
        view.add(commentNode);
        frame.pack();
        frame.setSize(1000, 1000);
        frame.setVisible(true);
        Thread.sleep(1000);
        frame.dispose();

//        size = new Dimension(10, 10);
//        commentNode.setSize(size);
//        commentNode.setPreferredSize(size);
//        commentNode.notifyUpdate();
//        frame.getContentPane().add(commentNode);
//        frame.pack();
//        frame.setSize(1000, 1000);
//        frame.setVisible(true);
//        Thread.sleep(1000);
//        frame.dispose();
    }
}
