/*
 * Copyright (C) 2007 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.gui.diagramviewer.uml.auxiliaryelements.stresstests;

import javax.swing.JFrame;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

import com.topcoder.diagraminterchange.Diagram;
import com.topcoder.diagraminterchange.GraphNode;
import com.topcoder.diagraminterchange.Point;
import com.topcoder.diagraminterchange.Uml1SemanticModelBridge;
import com.topcoder.gui.diagramviewer.DiagramView;
import com.topcoder.gui.diagramviewer.DiagramViewer;
import com.topcoder.gui.diagramviewer.uml.auxiliaryelements.CommentNode;
import com.topcoder.gui.diagramviewer.uml.auxiliaryelements.PropertyMapping;
import com.topcoder.uml.model.core.auxiliaryelements.Comment;
import com.topcoder.uml.model.core.auxiliaryelements.CommentImpl;


/**
 * <p>
 * Stress test cases for CommentNode.
 * </p>
 *
 * @author yinzi
 * @version 1.0
 */
public class CommentNodeStressTests extends TestCase {
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
        StressTestHelper.loadXMLConfig(StressTestHelper.CONFIG_FILE);
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
        StressTestHelper.clearConfig();
        mapping = null;
        graphNode = null;
        dimension = null;
        comment = null;
        usmb = null;
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
        return new TestSuite(CommentNodeStressTests.class);
    }

    /**
     * <p>
     * Stress tests CommentNode#getPreferredSize(String text) for accuracy.
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
        long startTime = System.currentTimeMillis();
        for (int i = 0; i < TIMES; i++) {
            node.getPreferredSize(text);
        }
        long endTime = System.currentTimeMillis();
        System.out.println("Stress tests: " + "CommentNode#getPreferredSize(String text) in " + TIMES
                + " times takes " + (endTime - startTime) + "ms");
    }

    /**
     * <p>
     * Stress tests CommentNode#notifyUpdate() for accuracy.
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
        frame.getContentPane().add(viewer);
        frame.pack();
        frame.setVisible(true);
        long startTime = System.currentTimeMillis();
        for (int i = 0; i < TIMES; i++) {
            node.notifyUpdate();
        }
        long endTime = System.currentTimeMillis();
        System.out.println("Stress tests: " + "CommentNode#notifyUpdate() in " + TIMES
                + " times takes " + (endTime - startTime) + "ms");
        // make the Frame visible for 1 second
        Thread.sleep(1000);

        frame.setVisible(false);
        frame.dispose();
        frame = null;
    }
}
