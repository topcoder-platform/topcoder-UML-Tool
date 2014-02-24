/*
 * Copyright (C) 2007 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.uml.actions.diagram;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

import com.topcoder.diagraminterchange.Diagram;
import com.topcoder.uml.actions.diagram.failuretests.FailureTestHelper;
import com.topcoder.uml.actions.diagram.failuretests.MockRemoveDiagramAction;

/**
 * <p>
 * This Junit Test suite contains failure test cases for {@link RemoveDiagramAction} class.
 * </p>
 *
 * @author stylecheck
 * @version 1.0
 */
public class RemoveDiagramActionFailureTest extends TestCase {
    /**
     * <p>
     * Sets up the environment.
     * </p>
     *
     * @throws Exception
     *             throw exception to JUnit.
     */
    protected void setUp() throws Exception {
       FailureTestHelper.setUp();
    }

    /**
     * <p>
     * Tears down the environment.
     * </p>
     *
     * @throws Exception
     *             throw exception to JUnit.
     */
    protected void tearDown() throws Exception {
        FailureTestHelper.tearDown();
    }

    /**
     * <p>
     * Aggregates all tests in this class.
     * </p>
     *
     * @return Test suite aggregating all tests.
     */
    public static Test suite() {
        return new TestSuite(RemoveDiagramActionFailureTest.class);
    }

    /**
     * <p>
     * Tests the  {@link RemoveDiagramAction#RemoveDiagramAction(Diagram)} constructor with  diagram as null value.
     * </p>
     * <p>
     * {@link IllegalArgumentException} Expected.
     * </p>
     *
     * @throws Exception
     *             Any exception to JUnit.
     */
    public void testFailureRemoveDiagramAction() throws Exception {
        try {
            new MockRemoveDiagramAction(null);
            fail("IllegalArgumentException is expected for the given input.");
        } catch (IllegalArgumentException e) {
            // as expected.
        }
    }
}
