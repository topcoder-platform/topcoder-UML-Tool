/*
 * Copyright (C) 2007 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.uml.actions.diagram.failuretests;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

import com.topcoder.diagraminterchange.Diagram;
import com.topcoder.diagraminterchange.Point;
import com.topcoder.uml.actions.diagram.ScrollDiagramViewAction;

/**
 * <p>
 * This Junit Test suite contains failure test cases for {@link ScrollDiagramViewAction} class.
 * </p>
 *
 * @author stylecheck
 * @version 1.0
 */
public class ScrollDiagramViewActionFailureTest extends TestCase {
    /**
     * <p>
     * Aggregates all tests in this class.
     * </p>
     *
     * @return Test suite aggregating all tests.
     */
    public static Test suite() {
        return new TestSuite(ScrollDiagramViewActionFailureTest.class);
    }

    /**
     * <p>
     * Tests the  {@link ScrollDiagramViewAction#ScrollDiagramViewAction(Diagram, Point)} constructor with  diagram as null value.
     * </p>
     * <p>
     * {@link IllegalArgumentException} Expected.
     * </p>
     *
     * @throws Exception
     *             Any exception to JUnit.
     */
    public void testFailureScrollDiagramViewAction() throws Exception {
        try {
            new ScrollDiagramViewAction(null, new Point());
            fail("IllegalArgumentException is expected for the given input.");
        } catch (IllegalArgumentException e) {
            // as expected.
        }
    }

    /**
     * <p>
     * Tests the  {@link ScrollDiagramViewAction#ScrollDiagramViewAction(Diagram, Point)} constructor with  newViewport as null value.
     * </p>
     * <p>
     * {@link IllegalArgumentException} Expected.
     * </p>
     *
     * @throws Exception
     *             Any exception to JUnit.
     */
    public void testFailureScrollDiagramViewAction1() throws Exception {
        try {
            new ScrollDiagramViewAction(new Diagram(), null);
            fail("IllegalArgumentException is expected for the given input.");
        } catch (IllegalArgumentException e) {
            // as expected.
        }
    }
}
