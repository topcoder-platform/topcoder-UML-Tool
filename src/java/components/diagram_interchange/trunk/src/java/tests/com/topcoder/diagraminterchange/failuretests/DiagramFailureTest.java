/*
 * Copyright (C) 2006 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.diagraminterchange.failuretests;

import com.topcoder.diagraminterchange.Diagram;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

/**
 * Failure test for Diagram class.
 *
 * @author iamajia
 * @version 1.0
 */
public class DiagramFailureTest extends TestCase {
    /**
     * Represents a {@link Diagram} instance that is used in the test.
     */
    private Diagram diagram = new Diagram();
    /**
     * Aggregates all tests in this class.
     *
     * @return Test suite aggregating all tests.
     */
    public static Test suite() {
        return new TestSuite(DiagramFailureTest.class);
    }

    /**
     * Failure test of <code>addDiagramLink(DiagramLink diagramLink)</code> method.
     *
     * <p>
     * diagramLink is null.
     * </p>
     *
     * <p>
     * Expect IllegalArgumentException.
     * </p>
     *
     * @throws Exception
     *             throw exception to JUnit.
     */
    public void testAddDiagramLinkFailureNullDiagramLink() throws Exception {
        try {
            diagram.addDiagramLink(null);
            fail("Expect IllegalArgumentException.");
        } catch (IllegalArgumentException e) {
            // expect
        }
    }

    /**
     * Failure test of <code>removeDiagramLink(DiagramLink diagramLink)</code> method.
     *
     * <p>
     * diagramLink is null.
     * </p>
     *
     * <p>
     * Expect IllegalArgumentException.
     * </p>
     *
     * @throws Exception
     *             throw exception to JUnit.
     */
    public void testRemoveDiagramLinkFailureNullDiagramLink() throws Exception {
        try {
            diagram.removeDiagramLink(null);
            fail("Expect IllegalArgumentException.");
        } catch (IllegalArgumentException e) {
            // expect
        }
    }

    /**
     * Failure test of <code>containsDiagramLink(DiagramLink diagramLink)</code> method.
     *
     * <p>
     * DiagramLink is null.
     * </p>
     *
     * <p>
     * Expect IllegalArgumentException.
     * </p>
     *
     * @throws Exception
     *             throw exception to JUnit.
     */
    public void testContainsDiagramLinkFailureNullDiagramLink() throws Exception {
        try {
            diagram.containsAnchorage(null);
            fail("Expect IllegalArgumentException.");
        } catch (IllegalArgumentException e) {
            // expect
        }
    }
}
