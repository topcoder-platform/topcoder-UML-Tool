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
 * Unit test cases for ActorConnector.
 * </p>
 *
 * @author TCSDEVELOPER
 * @version 1.0
 */
public class ActorConnectorTests extends TestCase {

    /**
     * <p>
     * ActorConnector instance for testing.
     * </p>
     */
    private ActorConnector actorConnector;

    /**
     * <p>
     * ActorNode instance for testing.
     * </p>
     */
    private ActorNode actorNode;

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
            graphNode = TestHelper.createGraphNodeForActor();
            actorNode = new ActorNode(graphNode, new HashMap<String, String>());
            actorConnector = new ActorConnector(actorNode);
        } catch (IllegalGraphElementException e) {
            fail("no IllegalGraphElementException will be thrown.");
        }
    }

    /**
     * <p>
     * Tears down test environment.
     * </p>
     */
    protected void tearDown() {
        graphNode = null;
        actorNode = null;
        actorConnector = null;
    }

    /**
     * <p>
     * Tests {@link ActorConnector#ActorConnector(ActorNode)} for accuracy.
     * </p>
     * <p>
     * It verifies the newly created instance is not null.
     * </p>
     */
    public void testCtor() {
        assertNotNull("Failed to create an ActorConnector instance.", actorConnector);
    }

    /**
     * <p>
     * Tests {@link ActorConnector#ActorConnector(ActorNode)} for failure.
     * </p>
     * <p>
     * It tests the case that when parent is null and expects IllegalArgumentException.
     * </p>
     */
    public void testCtor_NullParent() {
        try {
            new ActorConnector(null);
            fail("IllegalArgumentException expected.");
        } catch (IllegalArgumentException iae) {
            // the expected case
        }
    }

    /**
     * <p>
     * Tests {@link ActorConnector#getConnectionPoint(Point)} for accuracy.
     * </p>
     * <p>
     * It verifies ActorConnector#getConnectionPoint(Point) is correct.
     * </p>
     */
    public void testGetConnectionPoint1() {
        assertEquals("Failed to get connection point correctly.", new Point(200, 300), actorConnector
                .getConnectionPoint(new Point(300, 300)));
    }

    /**
     * <p>
     * Tests {@link ActorConnector#getConnectionPoint(Point)} for accuracy.
     * </p>
     * <p>
     * It verifies ActorConnector#getConnectionPoint(Point) is correct.
     * </p>
     *
     * @throws IllegalGraphElementException to JUnit
     */
    public void testGetConnectionPoint2() throws IllegalGraphElementException {
        actorNode.notifyGraphNodeChange("change");
        assertEquals("Failed to get connection point correctly.", new Point(20, 0),
                actorConnector.getConnectionPoint(new Point(20, 20)));
    }

    /**
     * <p>
     * Tests {@link ActorConnector#getConnectionPoint(Point)} for accuracy.
     * </p>
     * <p>
     * It verifies ActorConnector#getConnectionPoint(Point) is correct.
     * </p>
     *
     * @throws IllegalGraphElementException to JUnit
     */
    public void testGetConnectionPoint3() throws IllegalGraphElementException {
        GraphNode nameNode = (GraphNode) graphNode.getContaineds().get(1);
        GraphNode stereotypeNode = (GraphNode) graphNode.getContaineds().get(0);
        GraphNode namespaceNode = (GraphNode) graphNode.getContaineds().get(2);
        // hides all compartments
        nameNode.setVisible(false);
        stereotypeNode.setVisible(false);
        namespaceNode.setVisible(false);

        actorNode.notifyGraphNodeChange("change");
        assertEquals("Failed to get connection point correctly.", new Point(20, 0),
                actorConnector.getConnectionPoint(new Point(20, 20)));
    }

    /**
     * <p>
     * Tests {@link ActorConnector#getConnectionPoint(Point)} for accuracy.
     * </p>
     * <p>
     * It verifies ActorConnector#getConnectionPoint(Point) is correct.
     * </p>
     *
     * @throws IllegalGraphElementException to JUnit
     */
    public void testGetConnectionPoint4() throws IllegalGraphElementException {
        actorNode.notifyGraphNodeChange("change");
        assertEquals("Failed to get connection point correctly.", new Point(200, 300),
                actorConnector.getConnectionPoint(new Point(300, 300)));
    }

    /**
     * <p>
     * Tests {@link ActorConnector#getConnectionPoint(Point)} for accuracy.
     * </p>
     * <p>
     * It verifies ActorConnector#getConnectionPoint(Point) is correct.
     * </p>
     *
     * @throws IllegalGraphElementException to JUnit
     */
    public void testGetConnectionPoint5() throws IllegalGraphElementException {
        GraphNode nameNode = (GraphNode) graphNode.getContaineds().get(1);
        GraphNode stereotypeNode = (GraphNode) graphNode.getContaineds().get(0);
        GraphNode namespaceNode = (GraphNode) graphNode.getContaineds().get(2);
        // hides all compartments
        nameNode.setVisible(false);
        stereotypeNode.setVisible(false);
        namespaceNode.setVisible(false);

        actorNode.notifyGraphNodeChange("change");
        assertEquals("Failed to get connection point correctly.", new Point(200, 300),
                actorConnector.getConnectionPoint(new Point(300, 300)));
    }

    /**
     * <p>
     * Tests {@link ActorConnector#getConnectionPoint(Point)} for failure.
     * </p>
     * <p>
     * It tests the case that when wayPoint is null and expects IllegalArgumentException.
     * </p>
     */
    public void testGetConnectionPoint_NullWayPoint() {
        try {
            actorConnector.getConnectionPoint(null);
            fail("IllegalArgumentException expected.");
        } catch (IllegalArgumentException iae) {
            // the expected case
        }
    }
}
