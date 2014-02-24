/*
 * Copyright (C) 2007 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.gui.diagramviewer.uml.usecaseelements.accuracytests;

import java.awt.Point;
import java.util.HashMap;
import java.util.Map;

import junit.framework.TestCase;

import com.topcoder.gui.diagramviewer.uml.usecaseelements.UseCaseConnector;
import com.topcoder.gui.diagramviewer.uml.usecaseelements.UseCaseNode;

/**
 * Test UseCaseConnector.
 *
 * @author radium
 * @version 1.0
 */
public class UseCaseConnectorAccuracyTest extends TestCase {
    /**
     * Sample UseCaseConnector for testing.
     */
    private UseCaseConnector ucc;

    /**
     * Sample UseCaseNode for testing.
     */
    private UseCaseNode ucn;

    /**
     * Setup the environment for testing.
     */
    protected void setUp() throws Exception {
        Map hashMap = new HashMap<String, String>();
        hashMap.put("String", "String");
        ucn = new UseCaseNode(AccuracyTestHelper.createGraphNodeForUseCaseConnector(), hashMap);
        // This eclipse is just a circle.
        // Center at (0 , 0)
        // radius is 50.
        ucc = new UseCaseConnector(ucn);
    }

    /**
     * Test method for getConnectionPoint(Point).
     */
    public void testGetConnectionPoint() {
        Point point = new Point(50, 150);
        assertEquals("Should be equal.", new Point(50, 100), ucc.getConnectionPoint(point));
    }

    /**
     * Test method for getConnectionPoint(Point).
     */
    public void testGetConnectionPoint1() {
        Point point = new Point(50, -50);
        assertEquals("Should be equal.", new Point(50, 0), ucc.getConnectionPoint(point));
    }

    /**
     * Test method for getConnectionPoint(Point).
     */
    public void testGetConnectionPoint2() {
        Point point = new Point(150, 50);
        assertEquals("Should be equal.", new Point(100, 50), ucc.getConnectionPoint(point));
    }

    /**
     * Test method for getConnectionPoint(Point).
     */
    public void testGetConnectionPoint3() {
        Point point = new Point(-0, 50);
        assertEquals("Should be equal.", new Point(0, 50), ucc.getConnectionPoint(point));
    }

    /**
     * Test method for getConnectionPoint(Point).
     */
    public void testGetConnectionPoint4() {
        Point point = new Point(150, 150);
        assertEquals("Should be equal.", new Point((int) Math.round(50 / Math.sqrt(2)) + 50, (int) Math.round(50 / Math
            .sqrt(2)) + 50), ucc.getConnectionPoint(point));
    }

    /**
     * Test method for getConnectionPoint(Point).
     */
    public void testGetConnectionPoint5() {
        Point point = new Point(-50, -50);
        assertEquals("Should be equal.", new Point((int) Math.round(-50 / Math.sqrt(2)) + 50, (int) Math.round(-50
            / Math.sqrt(2)) + 50), ucc.getConnectionPoint(point));
    }

    /**
     * Test method for getConnectionPoint(Point).
     */
    public void testGetConnectionPoint6() {
        Point point = new Point(-50, 150);
        assertEquals("Should be equal.", new Point((int) Math.round(-50 / Math.sqrt(2)) + 50, (int) Math
            .round(50 / Math.sqrt(2)) + 50), ucc.getConnectionPoint(point));
    }

    /**
     * Test method for getConnectionPoint(Point).
     */
    public void testGetConnectionPoint7() {
        Point point = new Point(150, -50);
        assertEquals("Should be equal.", new Point((int) Math.round(50 / Math.sqrt(2)) + 50, (int) Math.round(-50
            / Math.sqrt(2)) + 50), ucc.getConnectionPoint(point));
    }
}
