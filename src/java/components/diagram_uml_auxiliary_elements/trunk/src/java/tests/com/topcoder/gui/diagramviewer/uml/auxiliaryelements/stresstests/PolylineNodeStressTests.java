/*
 * Copyright (C) 2007 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.gui.diagramviewer.uml.auxiliaryelements.stresstests;

import com.topcoder.diagraminterchange.Diagram;
import com.topcoder.diagraminterchange.Point;
import com.topcoder.diagraminterchange.Polyline;
import com.topcoder.gui.diagramviewer.DiagramView;
import com.topcoder.gui.diagramviewer.DiagramViewer;
import com.topcoder.gui.diagramviewer.uml.auxiliaryelements.PolylineNode;
import com.topcoder.gui.diagramviewer.uml.auxiliaryelements.PropertyMapping;

import junit.framework.TestCase;
import junit.framework.TestSuite;
import junit.framework.Test;

import javax.swing.JFrame;


/**
 * <p>
 * Stress test cases for PolylineNode.
 * </p>
 *
 * @author yinzi
 * @version 1.0
 */
public class PolylineNodeStressTests extends TestCase {
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
     * The PolylineNode instance for helping testing.
     * </p>
     */
    private PolylineNode node;

    /**
     * <p>
     * The Polyline instance for helping testing.
     * </p>
     */
    private Polyline polyline;

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
        polyline = new Polyline();
        polyline.addWaypoint(StressTestHelper.createDiagramInterchangePoint(100, 100));
        polyline.addWaypoint(StressTestHelper.createDiagramInterchangePoint(200, 200));
        polyline.addWaypoint(StressTestHelper.createDiagramInterchangePoint(300, 400));
        node = new PolylineNode(polyline, mapping);
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
        polyline = null;
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
        return new TestSuite(PolylineNodeStressTests.class);
    }

    /**
     * <p>
     * Stress tests PolylineNode#notifyUpdate() for accuracy.
     * </p>
     *
     * <p>
     * Verify : PolylineNode#notifyUpdate() is correct.
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
        System.out.println("Stress tests: " + "PolylineNode#notifyUpdate() in " + TIMES
            + " times takes " + (endTime - startTime) + "ms");
        // make the Frame visible for 1 second
        Thread.sleep(1000);

        frame.setVisible(false);
        frame.dispose();
        frame = null;
    }


}
