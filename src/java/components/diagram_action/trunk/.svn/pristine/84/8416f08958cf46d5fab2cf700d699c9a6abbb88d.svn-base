/*
 * Copyright (C) 2007 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.uml.actions.diagram.failuretests;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

import com.topcoder.diagraminterchange.Diagram;
import com.topcoder.diagraminterchange.Uml1SemanticModelBridge;
import com.topcoder.uml.actions.diagram.RemoveActivityDiagramAction;

/**
 * <p>
 * This Junit Test suite contains failure test cases for {@link RemoveActivityDiagramAction} class.
 * </p>
 * 
 * @author stylecheck
 * @version 1.0
 */
public class RemoveActivityDiagramActionFailureTest extends TestCase {

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
        return new TestSuite(RemoveActivityDiagramActionFailureTest.class);
    }

    /**
     * <p>
     * Tests the {@link RemoveActivityDiagramAction#RemoveActivityDiagramAction(Diagram)} constructor with
     * diagram as null value.
     * </p>
     * <p>
     * {@link IllegalArgumentException} Expected.
     * </p>
     * 
     * @throws Exception
     *             Any exception to JUnit.
     */
    public void testFailureRemoveActivityDiagramAction() throws Exception {
        try {
            new RemoveActivityDiagramAction(null);
            fail("IllegalArgumentException is expected for the given input.");
        } catch (IllegalArgumentException e) {
            // as expected.
        }
    }

    /**
     * <p>
     * Tests the {@link RemoveActivityDiagramAction#RemoveActivityDiagramAction(Diagram)} constructor with
     * diagram owner as null value.
     * </p>
     * <p>
     * {@link IllegalArgumentException} Expected.
     * </p>
     * 
     * @throws Exception
     *             Any exception to JUnit.
     */
    public void testFailureRemoveActivityDiagramAction1() throws Exception {
        try {
            new RemoveActivityDiagramAction(new Diagram());
            fail("IllegalArgumentException is expected for the given input.");
        } catch (IllegalArgumentException e) {
            // as expected.
        }
    }

    /**
     * <p>
     * Tests the {@link RemoveActivityDiagramAction#RemoveActivityDiagramAction(Diagram)} constructor with
     * diagram owners element as null value.
     * </p>
     * <p>
     * {@link IllegalArgumentException} Expected.
     * </p>
     * 
     * @throws Exception
     *             Any exception to JUnit.
     */
    public void testFailureRemoveActivityDiagramAction2() throws Exception {
        try {
            Diagram diagram = new Diagram();
            diagram.setOwner(new Uml1SemanticModelBridge());
            new RemoveActivityDiagramAction(diagram);
            fail("IllegalArgumentException is expected for the given input.");
        } catch (IllegalArgumentException e) {
            // as expected.
        }
    }
}
