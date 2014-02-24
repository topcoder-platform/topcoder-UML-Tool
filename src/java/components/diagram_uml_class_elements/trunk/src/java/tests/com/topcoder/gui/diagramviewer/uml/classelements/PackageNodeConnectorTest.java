/*
 * Copyright (C) 2007 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.gui.diagramviewer.uml.classelements;

import java.awt.Dimension;
import java.awt.Point;
import java.util.Map;

import javax.swing.TransferHandler;

import junit.framework.TestCase;

import com.topcoder.diagraminterchange.GraphNode;

/**
 * <p>
 * Test the functionality of <code>PackageNodeConnector</code> class.
 * </p>
 * @author TCSDEVELOPER
 * @version 1.0
 */
public class PackageNodeConnectorTest extends TestCase {

    /** The absolute position of the visual node. Used for testing only. */
    private static final Point POSITION = new Point(100, 80);

    /** The size of the visual node. Used for testing only. */
    private static final Dimension SIZE = new Dimension(80, 80);

    /** Allowable distance error. */
    private static final int EPSILON = 1;

    /** An instance of <code>PackageNodeConnector</code> for testing. */
    private PackageNodeConnector connector;

    /** Parent node of this <code>PackageNodeConnector</code> for testing. */
    private PackageNode packageNode;

    /**
     * <p>
     * Sets up the test environment. The test instance is created.
     * </p>
     * @throws Exception
     *             to junit
     */
    protected void setUp() throws Exception {
        super.setUp();

        GraphNode graphNode = TestUtil.createPackageGraphNode(POSITION, SIZE);
        graphNode.setContainer(new GraphNode());

        Map<String, String> properties = TestUtil.createProperties();

        packageNode = new PackageNode(graphNode, properties, new TransferHandler(null));

        GraphNode classGraphNode = TestUtil.createClassGraphNode(new Point(120, 180), SIZE, false, false);
        ClassNode classNode = new ClassNode(classGraphNode, properties);
        packageNode.addNode(classNode);
        packageNode.notifyGraphNodeChange("ClassNode added.");

        connector = new PackageNodeConnector(packageNode);
    }

    /**
     * Test method for 'PackageNodeConnector(PackageNode)'. The instance should be created successfully.
     */
    public void testPackageNodeConnector_Accuracy() {
        assertNotNull("Test method for 'PackageNodeConnector(PackageNode)' failed.", connector);
    }

    /**
     * Test method for 'PackageNodeConnector(PackageNode)'. The argument is null, IllegalArgumentException should be
     * thrown.
     */
    public void testPackageNodeConnector_null() {
        try {
            new PackageNodeConnector(null);
            fail("IllegalArgumentException should be thrown.");
        } catch (IllegalArgumentException iae) {
            // Success
        }
    }

    /**
     * Test method for 'getConnectionPoint(Point)'. The connection point should be got correctly.
     */
    public void testGetConnectionPoint_Accuracy_1() {
        Point wayPoint = packageNode.getSelectionBound().getLocation();
        wayPoint.x += packageNode.getLocation().x;
        wayPoint.y += packageNode.getLocation().y;
        Point desiredPoint = new Point(wayPoint);
        wayPoint.x -= 5;
        wayPoint.y -= 5;
        Point point = connector.getConnectionPoint(wayPoint);
        assertTrue("The connection point should be got correctly.", point.distance(desiredPoint) < EPSILON);
    }

    /**
     * Test method for 'getConnectionPoint(Point)'. The connection point should be got correctly.
     */
    public void testGetConnectionPoint_Accuracy_2() {
        Point wayPoint = packageNode.getSelectionBound().getLocation();
        wayPoint.x += packageNode.getLocation().x + packageNode.getSelectionBound().width;
        wayPoint.y += packageNode.getLocation().y + packageNode.getSelectionBound().height;
        Point desiredPoint = new Point(wayPoint);
        wayPoint.x += 5;
        wayPoint.y += 5;
        Point point = connector.getConnectionPoint(wayPoint);
        assertTrue("The connection point should be got correctly.", point.distance(desiredPoint) < EPSILON);
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

        packageNode = null;

        connector = null;
    }
}
