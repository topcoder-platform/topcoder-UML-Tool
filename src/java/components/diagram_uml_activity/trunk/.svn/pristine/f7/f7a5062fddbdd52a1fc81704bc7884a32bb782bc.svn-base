/*
 * Copyright (C) 2007 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.gui.diagramviewer.uml.activityelements.failuretests;

import com.topcoder.diagraminterchange.GraphEdge;
import com.topcoder.diagraminterchange.GraphNode;
import com.topcoder.gui.diagramviewer.uml.activityelements.IllegalGraphElementException;
import com.topcoder.gui.diagramviewer.uml.activityelements.Transition;

import junit.framework.TestCase;

/**
 * <p>
 * Failure test for <code>{@link Transition}</code> class.
 * </p>
 * @author FireIce
 * @version 1.0
 */
public class TransitionFailureTests extends TestCase {

    /**
     * <p>
     * Represents the graph edge.
     * </p>
     */
    private GraphEdge graphEdge;

    /**
     * <p>
     * Setup the testing environment.
     * </p>
     * @throws Exception
     *             pass any unexpected exception to JUnit.
     */
    @Override
    protected void setUp() throws Exception {
        super.setUp();

        graphEdge = FailureTestHelper.createGraphEdgeForTransition();
    }

    /**
     * <p>
     * Failure test for <code>{@link Transition#Transition(GraphEdge)}</code> constructor.
     * </p>
     */
    public void testTransitionNullGraphEdge() {
        try {
            new Transition(null);
            fail("expect throw IllegalArgumentException.");
        } catch (IllegalArgumentException e) {
            // expected
        }
    }

    /**
     * <p>
     * Failure test for <code>{@link Transition#Transition(GraphEdge)}</code> constructor.
     * </p>
     */
    public void testTransitionInvalidGraphEdgeStructure1() {
        graphEdge.clearContaineds();
        try {
            new Transition(graphEdge);
            fail("expect throw IllegalGraphElementException.");
        } catch (IllegalGraphElementException e) {
            // expected
        }
    }

    /**
     * <p>
     * Failure test for <code>{@link Transition#Transition(GraphEdge)}</code> constructor.
     * </p>
     */
    public void testTransitionInvalidGraphEdgeStructure2() {
        graphEdge.addContained(new GraphNode());
        try {
            new Transition(graphEdge);
            fail("expect throw IllegalGraphElementException.");
        } catch (IllegalGraphElementException e) {
            // expected
        }
    }

    /**
     * <p>
     * Failure test for <code>{@link Transition#Transition(GraphEdge)}</code> constructor.
     * </p>
     */
    public void testTransitionInvalidGraphEdgeStructure3() {
        graphEdge.addContained(new GraphEdge());
        try {
            new Transition(graphEdge);
            fail("expect throw IllegalGraphElementException.");
        } catch (IllegalGraphElementException e) {
            // expected
        }
    }
}
