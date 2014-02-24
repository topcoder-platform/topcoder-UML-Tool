/*
 * Copyright (C) 2007 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.gui.diagramviewer.uml.auxiliaryelements;

import java.awt.Dimension;

import com.topcoder.diagraminterchange.Diagram;
import com.topcoder.diagraminterchange.Point;
import com.topcoder.diagraminterchange.Polyline;
import com.topcoder.gui.diagramviewer.DiagramView;
import com.topcoder.gui.diagramviewer.DiagramViewer;

import junit.framework.TestCase;
import junit.framework.TestSuite;
import junit.framework.Test;

import javax.swing.JFrame;


/**
 * <p>
 * Unit test cases for PolylineNode.
 * </p>
 *
 * @author TCSDEVELOPER
 * @version 1.0
 */
public class PolylineNodeTests extends TestCase {
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
        TestHelper.loadXMLConfig(TestHelper.CONFIG_FILE);
        mapping = new PropertyMapping(VALID_NAMESPACE);
        polyline = new Polyline();
        polyline.addWaypoint(TestHelper.createDiagramInterchangePoint(100, 100));
        polyline.addWaypoint(TestHelper.createDiagramInterchangePoint(200, 200));
        polyline.addWaypoint(TestHelper.createDiagramInterchangePoint(300, 400));
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
        polyline = null;
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
        return new TestSuite(PolylineNodeTests.class);
    }

    /**
     * <p>
     * Tests constructor PolylineNode#PolylineNode(Polyline polyline, PropertyMapping properties) for accuracy.
     * </p>
     *
     * <p>
     * Verify : the newly created PolylineNode instance should not be null.
     * </p>
     *
     * @throws Exception to JUnit
     */
    public void testConstructor() throws Exception {
        assertNotNull("Failed to create a new PolylineNode instance.", node);
        assertNotNull("The newly created BaseNode will have MouseListeners.", node.getMouseListeners());
    }

    /**
     * <p>
     * Tests constructor PolylineNode#PolylineNode(Polyline polyline, PropertyMapping properties) for failure.
     * </p>
     *
     * <p>
     * It tests the case that when polyline is null and expects IllegalArgumentException.
     * </p>
     *
     * @throws Exception to JUnit
     */
    public void testConstructor_NullPolyline() throws Exception {
        try {
            new PolylineNode(null, mapping);
            fail("IllegalArgumentException expected.");
        } catch (IllegalArgumentException iae) {
            // good
        }
    }

    /**
     * <p>
     * Tests constructor PolylineNode#PolylineNode(Polyline polyline, PropertyMapping properties) for failure.
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
            new PolylineNode(polyline, null);
            fail("IllegalArgumentException expected.");
        } catch (IllegalArgumentException iae) {
            // good
        }
    }

    /**
     * <p>
     * Tests PolylineNode#getPolyline() for accuracy.
     * </p>
     *
     * <p>
     * Verify : PolylineNode#getPolyline() is correct.
     * </p>
     *
     * @throws Exception to JUnit
     */
    public void testGetPolyline() throws Exception {
        assertNotNull("The return value of getPolyline should not be null.", node.getPolyline());
        assertEquals("The return value of getPolyline should equal with the parameter of constructor.",
                node.getPolyline(), polyline);
    }

    /**
     * <p>
     * Tests PolylineNode#contains(int x, int y) for accuracy.
     * </p>
     *
     * <p>
     * Verify : PolylineNode#contains(int x, int y) is correct.
     * </p>
     *
     * @throws Exception to JUnit
     */
    public void testContains() throws Exception {
        node.setBounds(1, 2, 3, 4);
        assertTrue("This node should contain point (2, 3).", node.contains(2, 3));
        assertFalse("This node should not contain point (7, 8).", node.contains(7, 8));
    }

    /**
     * <p>
     * Tests PolylineNode#paintComponent(Graphics g) for accuracy.
     * </p>
     *
     * <p>
     * Verify : PolylineNode#paintComponent(Graphics g) is correct.
     * </p>
     *
     * @throws Exception to JUnit
     */
    public void testPaintComponent() throws Exception {
        JFrame frame = new JFrame();
        frame.getContentPane().add(node);
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
     * Tests PolylineNode#notifyUpdate() for accuracy.
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
        frame.getContentPane().add(node);
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
     * Frame Demo.
     * </p>
     *
     * @throws Exception to JUnit
     */
    public void testFrame() throws Exception {
        JFrame frame = new JFrame();
        frame.setTitle("PolylineNode Frame Demo");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().add(viewer);
        viewer.add(view);
        view.add(node);
        frame.setSize(new Dimension(500, 500));
        frame.setVisible(true);

        // make the Frame visible for 2 second
        Thread.sleep(2000);

        frame.setVisible(false);
        frame.dispose();
        frame = null;
    }
}
