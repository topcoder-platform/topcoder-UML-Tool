/*
 * Copyright (C) 2007 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.gui.diagramviewer.uml.auxiliaryelements.accuracytests;

import java.awt.Rectangle;

import javax.swing.JFrame;

import junit.framework.TestCase;

import com.topcoder.diagraminterchange.Diagram;
import com.topcoder.diagraminterchange.Dimension;
import com.topcoder.diagraminterchange.Point;
import com.topcoder.diagraminterchange.Polyline;
import com.topcoder.gui.diagramviewer.DiagramView;
import com.topcoder.gui.diagramviewer.DiagramViewer;
import com.topcoder.gui.diagramviewer.uml.auxiliaryelements.PolylineNode;
import com.topcoder.gui.diagramviewer.uml.auxiliaryelements.PropertyMapping;

/**
 * <p>
 * Accuracy test of <code>PolylineNode</code>.
 * </p>
 *
 * @author Achilles_2005
 * @version 1.0
 */
public class PolylineNodeAccuracyTest extends TestCase {

    /**
     * <p>
     * Private instance used for test.
     * </p>
     */
    private PolylineNode polylineNode;

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
        ConfigHelper.loadXMLConfigrationFile(ConfigHelper.ACC_CONFIG_FILE);
        Polyline polyline = new Polyline();
        com.topcoder.diagraminterchange.Point pt = new com.topcoder.diagraminterchange.Point();
        pt.setX(10);
        pt.setY(10);
        polyline.addWaypoint(pt);
        pt = new com.topcoder.diagraminterchange.Point();
        pt.setX(20);
        pt.setY(20);
        polyline.addWaypoint(pt);
        pt = new com.topcoder.diagraminterchange.Point();
        pt.setX(20);
        pt.setY(10);
        polyline.addWaypoint(pt);
        polylineNode = new PolylineNode(polyline, new PropertyMapping(ConfigHelper.ACC_NAMESPACE));
        viewer = new DiagramViewer();
        Diagram diagram = new Diagram();
        Dimension dimension = new Dimension();
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
        polylineNode = null;
        viewer = null;
        view = null;
    }

    /**
     * <p>
     * Tests accuracy of costructor.
     * </p>
     *
     * @throws Exception
     *             exception to JUnit.
     */
    public void testConstructorAccuracy() throws Exception {
        assertNotNull("constructed instance should not be null.", polylineNode);
        assertNotNull("polyline should not be null.", polylineNode.getPolyline());
    }

    /**
     * <p>
     * Tests accuracy of <code>getPolyline()</code>.
     * </p>
     *
     * @throws Exception
     *             exception to JUnit.
     */
    public void testGetPolylineAccuracy() throws Exception {
        assertEquals("the getted polyline should have 3 way points.", 3, polylineNode.getPolyline()
            .countWaypoints());
    }

    /**
     * <p>
     * Tests accuracy of <code>contains(int, int)</code>.
     * </p>
     *
     * @throws Exception
     *             exception to JUnit.
     */
    public void testContainsIntIntAccuracy() throws Exception {
        polylineNode.setBounds(100, 100, 100, 100);
        assertTrue("correct value should be returned.", polylineNode.contains(0, 0));
        assertTrue("correct value should be returned.", polylineNode.contains(99, 99));
        assertFalse("correct value should be returned.", polylineNode.contains(100, 100));
    }

    /**
     * <p>
     * Tests accuracy of <code>notifyUpdate()</code>.
     * </p>
     *
     * @throws Exception
     *             exception to JUnit.
     */
    public void testNotifyUpdateAccuracy() throws Exception {
        polylineNode.notifyUpdate();
        Rectangle bound = polylineNode.getBounds();
        assertEquals("bound should be resetted correctly.", 10.0 - 5.0, bound.getMinX());
        assertEquals("bound should be resetted correctly.", 10.0 - 5.0, bound.getMinY());
        assertEquals("bound should be resetted correctly.", 20.0 + 5.0, bound.getMaxX());
        assertEquals("bound should be resetted correctly.", 20.0 + 5.0, bound.getMaxY());
    }

    /**
     * <p>
     * Tests PolylineNode#paintComponent(Graphics g) for accuracy.
     * </p>
     * <p>
     * Verify : PolylineNode#paintComponent(Graphics g) is correct.
     * </p>
     *
     * @throws Exception
     *             exception to JUnit.
     */
    public void testPaintComponent() throws Exception {
        Polyline polyline = new Polyline();
        com.topcoder.diagraminterchange.Point pt = new com.topcoder.diagraminterchange.Point();
        pt.setX(10);
        pt.setY(10);
        polyline.addWaypoint(pt);
        pt = new com.topcoder.diagraminterchange.Point();
        pt.setX(20);
        pt.setY(20);
        polyline.addWaypoint(pt);
        pt = new com.topcoder.diagraminterchange.Point();
        pt.setX(20);
        pt.setY(10);
        polyline.addWaypoint(pt);
        polylineNode = new PolylineNode(polyline, new PropertyMapping(ConfigHelper.ACC_NAMESPACE));

        JFrame frame = new JFrame();
        polylineNode.notifyUpdate();
        frame.getContentPane().add(viewer);
        viewer.add(view);
        view.add(polylineNode);
        frame.pack();
        frame.setSize(300, 300);
        frame.setVisible(true);
        Thread.sleep(1000);
        frame.setVisible(false);
        frame.dispose();

        pt = new com.topcoder.diagraminterchange.Point();
        pt.setX(100);
        pt.setY(200);
        polyline.addWaypoint(pt);
        polylineNode = new PolylineNode(polyline, new PropertyMapping(ConfigHelper.ACC_NAMESPACE));
        polylineNode.notifyUpdate();
        frame.getContentPane().add(polylineNode);
        frame.pack();
        frame.setSize(300, 300);
        frame.setVisible(true);
        Thread.sleep(1000);
        frame.setVisible(false);
        frame.dispose();
    }
}
