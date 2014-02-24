/*
 * Copyright (C) 2007 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.gui.diagramviewer.uml.classelements;

import java.awt.Dimension;
import java.awt.Point;
import java.util.Map;

import junit.framework.TestCase;

import com.topcoder.diagraminterchange.GraphNode;

/**
 * <p>
 * Test the functionality of <code>EnumerationConnector</code> class.
 * </p>
 * @author TCSDEVELOPER
 * @version 1.0
 */
public class EnumerationConnectorTest extends TestCase {

    /** The absolute position of the visual node. Used for testing only. */
    private static final Point POSITION = new Point(100, 150);

    /** The size of the visual node. Used for testing only. */
    private static final Dimension SIZE = new Dimension(80, 40);

    /** An instance of <code>EnumerationConnector</code> for testing. */
    private EnumerationConnector connector;

    /** Parent node of this <code>EnumerationConnector</code> for testing. */
    private EnumerationNode enumerationNode;

    /** Allowable distance error. */
    private int epsilon = 1;

    /**
     * <p>
     * Sets up the test environment. The test instance is created.
     * </p>
     * @throws Exception
     *             to junit
     */
    protected void setUp() throws Exception {
        super.setUp();

        GraphNode graphNode = TestUtil.createEnumerationGraphNode(POSITION, SIZE);
        graphNode.setContainer(new GraphNode());

        Map<String, String> properties = TestUtil.createProperties();

        enumerationNode = new EnumerationNode(graphNode, properties);

        connector = new EnumerationConnector(enumerationNode);
    }

    /**
     * Test method for 'EnumerationConnector(EnumerationNode)'. The instance should be created successfully.
     */
    public void testEnumerationConnector_Accuracy() {
        assertNotNull("Test method for 'EnumerationConnector(EnumerationNode)' failed.", connector);
    }

    /**
     * Test method for 'EnumerationConnector(EnumerationNode)'. The argument is null, IllegalArgumentException should be
     * thrown.
     */
    public void testEnumerationConnector_null() {
        try {
            new EnumerationConnector(null);
            fail("IllegalArgumentException should be thrown.");
        } catch (IllegalArgumentException iae) {
            // Success
        }
    }

    /**
     * Test method for 'getConnectionPoint(Point)'. The connection point should be got correctly.
     */
    public void testGetConnectionPoint_Accuracy_1() {
        Point wayPoint = enumerationNode.getSelectionBound().getLocation();
        wayPoint.x += enumerationNode.getLocation().x;
        wayPoint.y += enumerationNode.getLocation().y;
        Point desiredPoint = new Point(wayPoint);
        wayPoint.x -= 5;
        wayPoint.y -= 5;
        Point point = connector.getConnectionPoint(wayPoint);
        assertTrue("The connection point should be got correctly.", point.distance(desiredPoint) < epsilon);
    }

    /**
     * Test method for 'getConnectionPoint(Point)'. The connection point should be got correctly.
     */
    public void testGetConnectionPoint_Accuracy_2() {
        Point wayPoint = enumerationNode.getSelectionBound().getLocation();
        wayPoint.x += enumerationNode.getLocation().x + enumerationNode.getSelectionBound().width;
        wayPoint.y += enumerationNode.getLocation().y + enumerationNode.getSelectionBound().height;
        Point desiredPoint = new Point(wayPoint);
        wayPoint.x += 5;
        wayPoint.y += 5;
        Point point = connector.getConnectionPoint(wayPoint);
        assertTrue("The connection point should be got correctly.", point.distance(desiredPoint) < epsilon);
    }

    /**
     * Test method for 'getConnectionPoint(Point)'. The argument is null, IllegalArgumentException should be thrown.
     */
    public void testGetConnectionPoint_null() {
        try {
            connector.getConnectionPoint(null);
            fail("IllegalArgumentException should be thrown.");
        } catch (IllegalArgumentException iae) {
            // Success
        }
    }

    /**
     * <p>
     * Tears down the test environment.
     * </p>
     */
    protected void tearDown() throws Exception {
        super.tearDown();

        enumerationNode = null;

        connector = null;
    }
}
