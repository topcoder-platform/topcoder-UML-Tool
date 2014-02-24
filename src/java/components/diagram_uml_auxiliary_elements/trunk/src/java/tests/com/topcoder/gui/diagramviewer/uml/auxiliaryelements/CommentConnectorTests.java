/*
 * Copyright (C) 2007 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.gui.diagramviewer.uml.auxiliaryelements;

import com.topcoder.diagraminterchange.Diagram;
import com.topcoder.diagraminterchange.Dimension;
import com.topcoder.diagraminterchange.GraphNode;
import com.topcoder.diagraminterchange.Uml1SemanticModelBridge;
import com.topcoder.gui.diagramviewer.DiagramView;
import com.topcoder.gui.diagramviewer.DiagramViewer;
import com.topcoder.uml.model.core.auxiliaryelements.CommentImpl;

import junit.framework.TestCase;
import junit.framework.TestSuite;
import junit.framework.Test;

import java.awt.Point;
import java.awt.Polygon;


/**
 * <p>
 * Unit test cases for CommentConnector.
 * </p>
 *
 * @author TCSDEVELOPER
 * @version 1.0
 */
public class CommentConnectorTests extends TestCase {
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
     * The PropertyMapping instance for helping testing.
     * </p>
     */
    private PropertyMapping mapping;

    /**
     * <p>
     * The CommentConnector instance for helping testing.
     * </p>
     */
    private CommentConnector connector;

    /**
     * <p>
     * The com.topcoder.diagraminterchange.Point instance for helping testing.
     * </p>
     */
    private com.topcoder.diagraminterchange.Point point;

    /**
     * <p>
     * The com.topcoder.diagraminterchange.Dimension instance for helping testing.
     * </p>
     */
    private com.topcoder.diagraminterchange.Dimension dimension;

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
        usmb.setElement(new CommentImpl());
        graphNode.setSemanticModel(usmb);
        point = new com.topcoder.diagraminterchange.Point();
        point.setX(0);
        point.setY(0);
        graphNode.setPosition(point);
        dimension = new com.topcoder.diagraminterchange.Dimension();
        dimension.setWidth(20);
        dimension.setHeight(10);
        graphNode.setSize(dimension);
        node = new CommentNode(graphNode, mapping);
        connector = new CommentConnector(node);
        viewer = new DiagramViewer();
        Diagram diagram = new Diagram();
        Dimension dimension = new Dimension();
        dimension.setWidth(500.0);
        dimension.setHeight(500.0);
        com.topcoder.diagraminterchange.Point point =
            new com.topcoder.diagraminterchange.Point();
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
        usmb = null;
        point = null;
        dimension = null;
        node = null;
        connector = null;
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
        return new TestSuite(CommentConnectorTests.class);
    }

    /**
     * <p>
     * Tests constructor CommentConnector#CommentConnector(CommentNode commentNode) for accuracy.
     * </p>
     *
     * <p>
     * Verify : the newly created CommentConnector instance should not be null.
     * </p>
     *
     * @throws Exception to JUnit
     */
    public void testConstructor() throws Exception {
        assertNotNull("Failed to create a new CommentConnector instance.", connector);
    }

    /**
     * <p>
     * Tests constructor CommentConnector#CommentConnector(CommentNode commentNode) for failure.
     * </p>
     *
     * <p>
     * It tests the case that when commentNode is null and expects IllegalArgumentException.
     * </p>
     *
     * @throws Exception to JUnit
     */
    public void testConstructor_NullCommentNode() throws Exception {
        try {
            new CommentConnector(null);
            fail("IllegalArgumentException expected.");
        } catch (IllegalArgumentException iae) {
            // good
        }
    }

    /**
     * <p>
     * Tests CommentConnector#getConnectionPoint(Point wayPoint) for accuracy.
     * </p>
     *
     * <p>
     * Verify : the CommentConnector#getConnectionPoint(Point wayPoint) is correct.
     * </p>
     *
     * @throws Exception to JUnit
     */
    public void testGetConnectionPoint() throws Exception {
        viewer.add(view);
        view.add(node);
        assertTrue("The CommentConnector#getConnectionPoint's return value should be a Point.",
                connector.getConnectionPoint(new Point()) instanceof Point);
        assertTrue("The shape of commentNode should be a polygon.", node.getShape() instanceof Polygon);

        // The wayPoint.
        Point wayPoint = new Point(30, 7);

        assertEquals("The connection point of waypoint should be (20, 7).",
                AuxiliaryElementsHelper.determineConnectionPoint(wayPoint, (Polygon) node.getShape()).x, 20);
        assertEquals("The connection point of waypoint should be (20, 7).",
                AuxiliaryElementsHelper.determineConnectionPoint(wayPoint, (Polygon) node.getShape()).y, 10);
    }
}
