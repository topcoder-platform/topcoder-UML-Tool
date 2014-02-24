/*
 * Copyright (C) 2007 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.gui.diagramviewer.uml.usecaseelements.accuracytests;

import java.awt.Point;
import java.util.HashMap;
import java.util.Map;

import junit.framework.TestCase;

import com.topcoder.diagraminterchange.GraphNode;
import com.topcoder.gui.diagramviewer.uml.usecaseelements.ActorConnector;
import com.topcoder.gui.diagramviewer.uml.usecaseelements.ActorNode;

/**
 * Test the ActorConnector class.
 * 
 * @author radium
 * @version 1.0
 */
public class ActorConnectorAccuracyTest extends TestCase {
    /**
     * Sample ActorConnector for testing.
     */
    private ActorConnector ac;

    /**
     * Sample GraphNode for testing.
     */
    private GraphNode graphNode;

    /**
     * Sample ActorNode for testing.
     */
    private ActorNode actorNode;

    /**
     * Setup the environment for testing.
     */
    protected void setUp() throws Exception {
        graphNode = AccuracyTestHelper.createGraphNodeForActorConnector();
        Map hashMap = new HashMap<String, String>();
        hashMap.put("String", "String");
        actorNode = new ActorNode(graphNode, hashMap);
        // For simplify the testing algorithm, we just set all the compartments
        // invisible.
        actorNode.getNameCompartment().setVisible(false);
        actorNode.getNamespaceCompartment().setVisible(false);
        actorNode.getStereotypeCompartment().setVisible(false);
        ac = new ActorConnector(actorNode);
    }

    /**
     * Test method for getConnectionPoint(Point).
     */
    public void testGetConnectionPoint() {
        Point point = new Point(-1000, -1000);
        assertEquals("Should be equal.", new Point(0, 0), ac.getConnectionPoint(point));
    }

    /**
     * Test method for getConnectionPoint(Point).
     */
    public void testGetConnectionPoint1() {
        Point point = new Point(-1000, 50);
        assertEquals("Should be equal.", new Point(0, 50), ac.getConnectionPoint(point));
    }

    /**
     * Test method for getConnectionPoint(Point).
     */
    public void testGetConnectionPoint2() {
        Point point = new Point(2000, 50);
        assertEquals("Should be equal.", new Point(100, 50), ac.getConnectionPoint(point));
    }

    /**
     * Test method for getConnectionPoint(Point).
     */
    public void testGetConnectionPoint3() {
        Point point = new Point(2000, 2000);
        assertEquals("Should be equal.", new Point(100, 100), ac.getConnectionPoint(point));
    }

    /**
     * Test method for getConnectionPoint(Point).
     */
    public void testGetConnectionPoint4() {
        Point point = new Point(40, 2000);
        assertEquals("Should be equal.", new Point(40, 100), ac.getConnectionPoint(point));
    }

    /**
     * Test method for getConnectionPoint(Point).
     */
    public void testGetConnectionPoint5() {
        Point point = new Point(40, -2000);
        assertEquals("Should be equal.", new Point(40, 0), ac.getConnectionPoint(point));
    }

    /**
     * Test method for getConnectionPoint(Point).
     */
    public void testGetConnectionPoint6() {
        Point point = new Point(2000, 60);
        assertEquals("Should be equal.", new Point(100, 60), ac.getConnectionPoint(point));
    }

    /**
     * Test method for getConnectionPoint(Point).
     */
    public void testGetConnectionPoint7() {
        Point point = new Point(-1000, 1000);
        assertEquals("Should be equal.", new Point(0, 100), ac.getConnectionPoint(point));
    }

    /**
     * Test method for getConnectionPoint(Point).
     */
    public void testGetConnectionPoint8() {
        Point point = new Point(1000, -1000);
        assertEquals("Should be equal.", new Point(100, 0), ac.getConnectionPoint(point));
    }
}
