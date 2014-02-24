/*
 * Copyright (C) 2007 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.gui.diagramviewer.uml.usecaseelements;

import java.awt.Point;
import java.util.HashMap;

import junit.framework.TestCase;

import com.topcoder.diagraminterchange.GraphNode;

/**
 * <p>
 * Unit test cases for UseCaseConnector.
 * </p>
 *
 * @author TCSDEVELOPER
 * @version 1.0
 */
public class UseCaseConnectorTests extends TestCase {

    /**
     * <p>
     * UseCaseConnector instance for testing.
     * </p>
     */
    private UseCaseConnector useCaseConnector;

    /**
     * <p>
     * UseCaseNode instance for testing.
     * </p>
     */
    private UseCaseNode useCaseNode;

    /**
     * <p>
     * GraphNode instance for testing.
     * </p>
     */
    private GraphNode graphNode;

    /**
     * <p>
     * Sets up test environment.
     * </p>
     */
    protected void setUp() {
        try {
            graphNode = TestHelper.createGraphNodeForUseCase();
            useCaseNode = new UseCaseNode(graphNode, new HashMap<String, String>());
            useCaseConnector = new UseCaseConnector(useCaseNode);
        } catch (IllegalGraphElementException e) {
            fail("no exception will be thrown.");
        }
    }

    /**
     * <p>
     * Tears down test environment.
     * </p>
     */
    protected void tearDown() {
        graphNode = null;
        useCaseNode = null;
        useCaseConnector = null;
    }

    /**
     * <p>
     * Tests {@link UseCaseConnector#UseCaseConnector(UseCaseNode)} for accuracy.
     * </p>
     * <p>
     * It verifies the newly created instance is not null.
     * </p>
     */
    public void testCtor() {
        assertNotNull("Failed to create an UseCaseConnector instance.", useCaseConnector);
    }

    /**
     * <p>
     * Tests {@link UseCaseConnector#UseCaseConnector(UseCaseNode)} for failure.
     * </p>
     * <p>
     * It tests the case that when parent is null and expects IllegalArgumentException.
     * </p>
     */
    public void testCtor_NullParent() {
        try {
            new UseCaseConnector(null);
            fail("IllegalArgumentException expected.");
        } catch (IllegalArgumentException iae) {
            // the expected case
        }
    }

    /**
     * <p>
     * Tests {@link UseCaseConnector#getConnectionPoint(Point)} for accuracy.
     * </p>
     * <p>
     * It verifies UseCaseConnector#getConnectionPoint(Point) is correct.
     * </p>
     */
    public void testGetConnectionPointIn1() {
        assertEquals("Failed to get connection point correctly.", new Point(90, 50),
                useCaseConnector.getConnectionPoint(new Point(90, 50)));
    }

    /**
     * <p>
     * Tests {@link UseCaseConnector#getConnectionPoint(Point)} for accuracy.
     * </p>
     * <p>
     * It verifies UseCaseConnector#getConnectionPoint(Point) is correct.
     * </p>
     */
    public void testGetConnectionPointIn2() {
        assertEquals("Failed to get connection point correctly.", new Point(90, 1),
                useCaseConnector.getConnectionPoint(new Point(90, 1)));
    }

    /**
     * <p>
     * Tests {@link UseCaseConnector#getConnectionPoint(Point)} for accuracy.
     * </p>
     * <p>
     * It verifies UseCaseConnector#getConnectionPoint(Point) is correct.
     * </p>
     */
    public void testGetConnectionPointIn3() {
        assertEquals("Failed to get connection point correctly.", new Point(179, 50),
                useCaseConnector.getConnectionPoint(new Point(179, 50)));
    }

    /**
     * <p>
     * Tests {@link UseCaseConnector#getConnectionPoint(Point)} for accuracy.
     * </p>
     * <p>
     * It verifies UseCaseConnector#getConnectionPoint(Point) is correct.
     * </p>
     */
    public void testGetConnectionPointIn4() {
        assertEquals("Failed to get connection point correctly.", new Point(170, 30),
                useCaseConnector.getConnectionPoint(new Point(170, 30)));
    }

    /**
     * <p>
     * Tests {@link UseCaseConnector#getConnectionPoint(Point)} for accuracy.
     * </p>
     * <p>
     * It verifies UseCaseConnector#getConnectionPoint(Point) is correct.
     * It tests the case when wayPoint.x == centerX.
     * </p>
     */
    public void testGetConnectionPointOut1() {
        assertEquals("Failed to get connection point correctly.", new Point(90, 0),
                useCaseConnector.getConnectionPoint(new Point(90, -47)));
    }

    /**
     * <p>
     * Tests {@link UseCaseConnector#getConnectionPoint(Point)} for accuracy.
     * </p>
     * <p>
     * It verifies UseCaseConnector#getConnectionPoint(Point) is correct.
     * It tests the case when wayPoint.x == centerX.
     * </p>
     */
    public void testGetConnectionPointOut2() {
        assertEquals("Failed to get connection point correctly.", new Point(90, 100),
                useCaseConnector.getConnectionPoint(new Point(90, 253)));
    }

    /**
     * <p>
     * Tests {@link UseCaseConnector#getConnectionPoint(Point)} for accuracy.
     * </p>
     * <p>
     * It verifies UseCaseConnector#getConnectionPoint(Point) is correct.
     * It tests the case when wayPoint.y == centerY.
     * </p>
     */
    public void testGetConnectionPointOut3() {
        assertEquals("Failed to get connection point correctly.", new Point(0, 50),
                useCaseConnector.getConnectionPoint(new Point(-54, 50)));
    }

    /**
     * <p>
     * Tests {@link UseCaseConnector#getConnectionPoint(Point)} for accuracy.
     * </p>
     * <p>
     * It verifies UseCaseConnector#getConnectionPoint(Point) is correct.
     * It tests the case when wayPoint.y == centerY.
     * </p>
     */
    public void testGetConnectionPointOut4() {
        assertEquals("Failed to get connection point correctly.", new Point(180, 50),
                useCaseConnector.getConnectionPoint(new Point(198, 50)));
    }

    /**
     * <p>
     * Tests {@link UseCaseConnector#getConnectionPoint(Point)} for accuracy.
     * </p>
     * <p>
     * It verifies UseCaseConnector#getConnectionPoint(Point) is correct.
     * It tests the case when the point is at the top left of the ellipse.
     * </p>
     */
    public void testGetConnectionPointOut5() {
        assertEquals("Failed to get connection point correctly.", new Point(35, 11),
                useCaseConnector.getConnectionPoint(new Point(-50, -50)));
    }

    /**
     * <p>
     * Tests {@link UseCaseConnector#getConnectionPoint(Point)} for accuracy.
     * </p>
     * <p>
     * It verifies UseCaseConnector#getConnectionPoint(Point) is correct.
     * It tests the case when the point is at the bottom left of the ellipse.
     * </p>
     */
    public void testGetConnectionPointOut6() {
        assertEquals("Failed to get connection point correctly.", new Point(40, 92),
                useCaseConnector.getConnectionPoint(new Point(-30, 150)));
    }

    /**
     * <p>
     * Tests {@link UseCaseConnector#getConnectionPoint(Point)} for accuracy.
     * </p>
     * <p>
     * It verifies UseCaseConnector#getConnectionPoint(Point) is correct.
     * It tests the case when the point is at the top right of the ellipse.
     * </p>
     */
    public void testGetConnectionPointOut7() {
        assertEquals("Failed to get connection point correctly.", new Point(137, 7),
                useCaseConnector.getConnectionPoint(new Point(200, -50)));
    }

    /**
     * <p>
     * Tests {@link UseCaseConnector#getConnectionPoint(Point)} for accuracy.
     * </p>
     * <p>
     * It verifies UseCaseConnector#getConnectionPoint(Point) is correct.
     * It tests the case when the point is at the bottom right of the ellipse.
     * </p>
     */
    public void testGetConnectionPointOut8() {
        assertEquals("Failed to get connection point correctly.", new Point(137, 93),
                useCaseConnector.getConnectionPoint(new Point(200, 150)));
    }

    /**
     * <p>
     * Tests {@link UseCaseConnector#getConnectionPoint(Point)} for failure.
     * </p>
     * <p>
     * It tests the case that when wayPoint is null and expects IllegalArgumentException.
     * </p>
     */
    public void testGetConnectionPoint_NullWayPoint() {
        try {
            useCaseConnector.getConnectionPoint(null);
            fail("IllegalArgumentException expected.");
        } catch (IllegalArgumentException iae) {
            // the expected case
        }
    }
}
