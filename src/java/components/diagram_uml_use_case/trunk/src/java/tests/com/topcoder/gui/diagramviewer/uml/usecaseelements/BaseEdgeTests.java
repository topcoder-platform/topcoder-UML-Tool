/*
 * Copyright (C) 2007 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.gui.diagramviewer.uml.usecaseelements;

import junit.framework.TestCase;

import com.topcoder.diagraminterchange.GraphEdge;
import com.topcoder.diagraminterchange.GraphNode;
import com.topcoder.uml.model.usecases.IncludeImpl;

/**
 * <p>
 * Unit test cases for BaseNode.
 * </p>
 *
 * @author TCSDEVELOPER
 * @version 1.0
 */
public class BaseEdgeTests extends TestCase {
    /**
     * <p>
     * BaseEdge instance for testing.
     * </p>
     */
    private BaseEdge baseEdge;

    /**
     * <p>
     * GraphEdge instance for testing.
     * </p>
     */
    private GraphEdge graphEdge;

    /**
     * <p>
     * Sets up test environment.
     * </p>
     */
    protected void setUp() {
        graphEdge = TestHelper.createGraphEdgeForEdge(new IncludeImpl());
        try {
            baseEdge = new MockBaseEdge(graphEdge, null);
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
        baseEdge = null;
    }

    /**
     * <p>
     * Tests {@link BaseEdge#BaseEdge(GraphEdge, String)} for accuracy.
     * </p>
     * <p>
     * It verifies the newly created BaseEdge instance is not null.
     * </p>
     */
    public void testCtor() {
        assertNotNull("Failed to created a BaseEdge instance.", baseEdge);
    }

    /**
     * <p>
     * Tests {@link BaseEdge#BaseEdge(GraphEdge, String)} for failure.
     * </p>
     * <p>
     * It tests the case that when graphEdge is null and expects IllegalArgumentException.
     * </p>
     */
    public void testCtor_NullGraphEdge() {
        try {
            new MockBaseEdge(null, "test");
            fail("IllegalArgumentException expected.");
        } catch (IllegalArgumentException iae) {
            // the expected case
        } catch (IllegalGraphElementException e) {
            fail("no IllegalGraphElementException will be thrown.");
        }
    }

    /**
     * <p>
     * Tests {@link BaseEdge#BaseEdge(GraphEdge, String)} for failure.
     * </p>
     * <p>
     * It tests the case that when Metaclass is empty and expects IllegalArgumentException.
     * </p>
     */
    public void testCtor_EmptyMetaclass() {
        try {
            new MockBaseEdge(TestHelper.createGraphEdgeForEdge(new IncludeImpl()), " ");
            fail("IllegalArgumentException expected.");
        } catch (IllegalArgumentException iae) {
            // the expected case
        } catch (IllegalGraphElementException e) {
            fail("no IllegalGraphElementException will be thrown.");
        }
    }

    /**
     * <p>
     * Tests {@link BaseEdge#BaseEdge(GraphEdge, String)} for failure.
     * </p>
     * <p>
     * It tests the case that when Metaclass is null and expects success.
     * </p>
     */
    public void testCtor_NullMetaclass() {
        try {
            new MockBaseEdge(TestHelper.createGraphEdgeForEdge(new IncludeImpl()), null);
            // no exception will be thrown
        } catch (IllegalGraphElementException e) {
            fail("no IllegalGraphElementException will be thrown.");
        }
    }

    /**
     * <p>
     * Tests {@link BaseEdge#BaseEdge(GraphEdge, String)} for failure.
     * </p>
     * <p>
     * It tests the case that when the passed graphEdge's structure is bad, and expects IllegalGraphElementException.
     * </p>
     *
     * @throws Exception to JUnit.
     */
    public void testCtor_BadGraphEdge() throws Exception {
        GraphEdge edge = new GraphEdge();

        com.topcoder.diagraminterchange.Point wp1 = new com.topcoder.diagraminterchange.Point();
        wp1.setX(1);
        wp1.setY(2);

        com.topcoder.diagraminterchange.Point wp2 = new com.topcoder.diagraminterchange.Point();
        wp2.setX(5);
        wp2.setY(10);

        edge.addWaypoint(wp1);
        edge.addWaypoint(wp2);

        edge.addContained(new GraphEdge());
        edge.addContained(new GraphEdge());

        try {
            new MockBaseEdge(edge, "test");
            fail("IllegalGraphElementException is expected.");
        } catch (IllegalGraphElementException e) {
            // Ok.
        }
    }

    /**
     * <p>
     * Tests {@link BaseEdge#getNameCompartment()} for accuracy.
     * </p>
     * <p>
     * It verifies BaseEdge#getNameCompartment() is correct.
     * </p>
     */
    public void testGetNameCompartment() {
        assertSame("Failed to get name compartment.", baseEdge.getNameCompartment().getGraphNode(), graphEdge
                .getContaineds().get(1));
    }

    /**
     * <p>
     * Tests {@link BaseEdge#getStereotypeCompartment()} for accuracy.
     * </p>
     * <p>
     * It verifies BaseEdge#getStereotypeCompartment() is correct.
     * </p>
     */
    public void testGetStereotypeCompartment() {
        assertSame("Failed to get name compartment.", baseEdge.getStereotypeCompartment().getGraphNode(), graphEdge
                .getContaineds().get(0));
    }

    /**
     * <p>
     * Tests {@link BaseEdge#consumeEvent(java.awt.event.MouseEvent)} for accuracy.
     * </p>
     * <p>
     * It verifies BaseEdge#consumeEvent(java.awt.event.MouseEvent) is correct.
     * </p>
     */
    public void testConsumeEvent() {
        assertFalse("consumeEvent behavior is abnormal.", baseEdge.consumeEvent(null));
    }

    /**
     * <p>
     * Tests {@link BaseEdge#notifyGraphEdgeChange()} for accuracy.
     * </p>
     * <p>
     * It verifies BaseEdge#notifyGraphEdgeChange() is correct.
     * </p>
     */
    public void testNotifyGraphEdgeChange() {
        try {
            baseEdge.notifyGraphEdgeChange();
        } catch (IllegalGraphElementException e) {
            fail("no exception will be thrown.");
        }
    }

    /**
     * <p>
     * Unit Test of the <code>notifyGraphEdgeChange()</code> method.
     * </p>
     *
     * @throws Exception to JUnit.
     */
    public void testNotifyGraphEdgeChange_Compartments() throws Exception {
        GraphNode nameNode = (GraphNode) graphEdge.getContaineds().get(1);
        GraphNode stereotypeNode = (GraphNode) graphEdge.getContaineds().get(0);

        // change the size and location name graphNode.
        nameNode.setPosition(TestHelper.getPoint(5.0, 9.0));
        nameNode.setSize(TestHelper.getDimension(4.5, 2.3));

        // change the size and location stereotype graphNode.
        stereotypeNode.setPosition(TestHelper.getPoint(20.0, 30.0));
        stereotypeNode.setSize(TestHelper.getDimension(3.4, 5.2));

        baseEdge.notifyGraphEdgeChange();
    }

    /**
     * <p>
     * Unit Test of the <code>notifyGraphEdgeChange()</code> method.
     * </p>
     *
     * @throws Exception to JUnit.
     */
    public void testNotifyGraphNodeChange_Name() throws Exception {
        baseEdge.notifyGraphEdgeChange();
        assertEquals("no name", baseEdge.getNameCompartment().getText());
    }

    /**
     * <p>
     * Unit Test of the <code>notifyGraphEdgeChange()</code> method.
     * </p>
     *
     * @throws Exception to JUnit.
     */
    public void testNotifyGraphNodeChange_Stereotype() throws Exception {
        baseEdge.notifyGraphEdgeChange();
        assertEquals("<<implicit>>", baseEdge.getStereotypeCompartment().getText());
    }
}
