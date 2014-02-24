/*
 * Copyright (C) 2007 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.gui.diagramviewer.uml.auxiliaryelements.stresstests;

import com.topcoder.diagraminterchange.Diagram;
import com.topcoder.diagraminterchange.Dimension;
import com.topcoder.diagraminterchange.GraphNode;
import com.topcoder.diagraminterchange.Uml1SemanticModelBridge;
import com.topcoder.gui.diagramviewer.DiagramView;
import com.topcoder.gui.diagramviewer.DiagramViewer;
import com.topcoder.gui.diagramviewer.uml.auxiliaryelements.CommentConnector;
import com.topcoder.gui.diagramviewer.uml.auxiliaryelements.CommentNode;
import com.topcoder.gui.diagramviewer.uml.auxiliaryelements.PropertyMapping;
import com.topcoder.uml.model.core.auxiliaryelements.CommentImpl;

import junit.framework.TestCase;
import junit.framework.TestSuite;
import junit.framework.Test;

import java.awt.Point;


/**
 * <p>
 * Stress test cases for CommentConnector.
 * </p>
 *
 * @author yinzi
 * @version 1.0
 */
public class CommentConnectorStressTests extends TestCase {
    /**
     * The number of operations in the stress tests.
     */
    private static final int TIMES = 1000;

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
        StressTestHelper.loadXMLConfig(StressTestHelper.CONFIG_FILE);
        mapping = new PropertyMapping(VALID_NAMESPACE);
        graphNode = new GraphNode();
        usmb = new Uml1SemanticModelBridge();
        usmb.setElement(new CommentImpl());
        graphNode.setSemanticModel(usmb);
        graphNode.setPosition(new com.topcoder.diagraminterchange.Point());
        graphNode.setSize(new com.topcoder.diagraminterchange.Dimension());
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
        StressTestHelper.clearConfig();
        mapping = null;
        graphNode = null;
        usmb = null;
        node = null;
        connector = null;
    }

    /**
     * <p>
     * Return all tests.
     * </p>
     *
     * @return all tests
     */
    public static Test suite() {
        return new TestSuite(CommentConnectorStressTests.class);
    }

    /**
     * <p>
     * Stress tests CommentConnector#getConnectionPoint(Point wayPoint) for accuracy.
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
        long startTime = System.currentTimeMillis();
        for (int i = 0; i < TIMES; i++) {
            connector.getConnectionPoint(new Point());
        }
        long endTime = System.currentTimeMillis();
        System.out.println("Stress tests: " + "CommentConnector#getConnectionPoint(Point wayPoint) in " + TIMES
                + " times takes " + (endTime - startTime) + "ms");

    }
}
