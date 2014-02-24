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
 * Test the functionality of <code>ClassConnector</code> class.
 * </p>
 * @author TCSDEVELOPER
 * @version 1.0
 */
public class ClassConnectorTest extends TestCase {

    /** The absolute position of the visual node. Used for testing only. */
    private static final Point POSITION = new Point(100, 150);

    /** The size of the visual node. Used for testing only. */
    private static final Dimension SIZE = new Dimension(80, 40);

    /** An instance of <code>ClassConnector</code> for testing. */
    private ClassConnector connector;

    /** Parent node of this <code>ClassConnector</code> for testing. */
    private ClassNode classNode;

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

        GraphNode graphNode = TestUtil.createClassGraphNode(POSITION, SIZE, false, false);
        graphNode.setContainer(new GraphNode());

        Map<String, String> properties = TestUtil.createProperties();

        classNode = new ClassNode(graphNode, properties);

        connector = new ClassConnector(classNode);
    }

    /**
     * Test method for 'ClassConnector(ClassNode)'. The instance should be created successfully.
     */
    public void testClassConnector_Accuracy() {
        assertNotNull("Test method for 'ClassConnector(ClassNode)' failed.", connector);
    }

    /**
     * Test method for 'ClassConnector(ClassNode)'. The argument is null, IllegalArgumentException should be thrown.
     */
    public void testClassConnector_null() {
        try {
            new ClassConnector(null);
            fail("IllegalArgumentException should be thrown.");
        } catch (IllegalArgumentException iae) {
            // Success
        }
    }

    /**
     * Test method for 'getConnectionPoint(Point)'. The connection point should be got correctly.
     */
    public void testGetConnectionPoint_Accuracy_1() {
        Point wayPoint = classNode.getSelectionBound().getLocation();
        wayPoint.x += classNode.getLocation().x;
        wayPoint.y += classNode.getLocation().y;
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
        Point wayPoint = classNode.getSelectionBound().getLocation();
        wayPoint.x += classNode.getLocation().x + classNode.getSelectionBound().width;
        wayPoint.y += classNode.getLocation().y + classNode.getSelectionBound().height;
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

        classNode = null;

        connector = null;
    }
}
