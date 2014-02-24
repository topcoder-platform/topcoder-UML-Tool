/*
 * Copyright (C) 2007 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.gui.diagramviewer.uml.usecaseelements.accuracytests;

import java.awt.event.MouseEvent;

import junit.framework.TestCase;

import com.topcoder.diagraminterchange.GraphEdge;
import com.topcoder.diagraminterchange.GraphNode;
import com.topcoder.diagraminterchange.Point;
import com.topcoder.gui.diagramviewer.uml.usecaseelements.BaseEdge;
import com.topcoder.gui.diagramviewer.uml.usecaseelements.IllegalGraphElementException;

/**
 * Test BaseEdge class.
 *
 * @author radium
 * @version 1.0
 */
public class BaseEdgeAccuracyTest extends TestCase {
    /**
     * Mock BaseEdge class for testing.
     *
     * @author radium
     * @version 1.0
     */
    @SuppressWarnings("serial")
    private class MockBaseEdge extends BaseEdge {

        protected MockBaseEdge(GraphEdge graphEdge, String keywordMetaclass) throws IllegalGraphElementException {
            super(graphEdge, keywordMetaclass);
        }

        public boolean consumeEvent(MouseEvent e) {
            return super.consumeEvent(e);
        }
    }

    /**
     * <p>
     * BaseEdge for testing.
     * </p>
     */
    private MockBaseEdge baseEdge;

    /**
     * <p>
     * GraphEdge for testing.
     * </p>
     */
    private GraphEdge graphEdge;

    /**
     * Setup the environment for testing.
     */
    protected void setUp() throws Exception {
        graphEdge = AccuracyTestHelper.createGraphEdgeForEdge();
        try {
            baseEdge = new MockBaseEdge(graphEdge, null);
        } catch (IllegalGraphElementException e) {
            // never reach here.
        }
    }

    /**
     * Test method for getNameCompartment().
     */
    public void testGetNameCompartment() {
        assertSame("Should be equal.", baseEdge.getNameCompartment().getGraphNode(), graphEdge.getContaineds()
            .get(1));
    }

    /**
     * Test method for getStereotypeCompartment().
     */
    public void testGetStereotypeCompartment() {
        assertSame("Should be equal.", baseEdge.getStereotypeCompartment().getGraphNode(), graphEdge
            .getContaineds().get(0));
    }

    /**
     * Test method for consumeEvent(MouseEvent).
     */
    public void testConsumeEventMouseEvent() {
        assertFalse("Should be false.", baseEdge.consumeEvent(new MouseEvent(baseEdge, 0, 0, 0, 0, 0, 0, false)));
    }

    /**
     * Test method for notifyGraphEdgeChange().
     *
     * @throws IllegalGraphElementException
     */
    public void testNotifyGraphEdgeChange() throws IllegalGraphElementException {
        GraphNode nameNode = (GraphNode) graphEdge.getContaineds().get(1);
        GraphNode stereotypeNode = (GraphNode) graphEdge.getContaineds().get(0);

        // Set the new position.
        Point newNamePoint = new Point();
        newNamePoint.setX(100.0);
        newNamePoint.setY(200.0);
        nameNode.setPosition(newNamePoint);

        // Set the new position.
        Point newStereotypePoint = new Point();
        newStereotypePoint.setX(100.0);
        newStereotypePoint.setY(200.0);
        stereotypeNode.setPosition(newStereotypePoint);

        baseEdge.notifyGraphEdgeChange();
    }

}
