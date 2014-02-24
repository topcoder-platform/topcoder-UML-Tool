/*
 * Copyright (C) 2007 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.uml.actions.diagram.failuretests;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

import com.topcoder.diagraminterchange.Diagram;
import com.topcoder.uml.actions.diagram.AdjustDiagramZoomLevelAction;

/**
 * <p>
 * This Junit Test suite contains failure test cases for {@link AdjustDiagramZoomLevelAction} class.
 * </p>
 * 
 * @author stylecheck
 * @version 1.0
 */
public class AdjustDiagramZoomLevelActionFailureTest extends TestCase {

    /**
     * <p>
     * Aggregates all tests in this class.
     * </p>
     * 
     * @return Test suite aggregating all tests.
     */
    public static Test suite() {
        return new TestSuite(AdjustDiagramZoomLevelActionFailureTest.class);
    }

    /**
     * <p>
     * Tests the {@link AdjustDiagramZoomLevelAction#AdjustDiagramZoomLevelAction(Diagram, Double)}
     * constructor with diagram as null value.
     * </p>
     * <p>
     * {@link IllegalArgumentException} Expected.
     * </p>
     * 
     * @throws Exception
     *             Any exception to JUnit.
     */
    public void testFailureAdjustDiagramZoomLevelAction() throws Exception {
        try {
            new AdjustDiagramZoomLevelAction(null, 0.0);
            fail("IllegalArgumentException is expected for the given input.");
        } catch (IllegalArgumentException e) {
            // as expected.
        }
    }

    /**
     * <p>
     * Tests the {@link AdjustDiagramZoomLevelAction#AdjustDiagramZoomLevelAction(Diagram, Double)}
     * constructor with newZoomLevel as null value.
     * </p>
     * <p>
     * {@link IllegalArgumentException} Expected.
     * </p>
     * 
     * @throws Exception
     *             Any exception to JUnit.
     */
    public void testFailureAdjustDiagramZoomLevelAction1() throws Exception {
        try {
            new AdjustDiagramZoomLevelAction(new Diagram(), null);
            fail("IllegalArgumentException is expected for the given input.");
        } catch (IllegalArgumentException e) {
            // as expected.
        }
    }

    /**
     * <p>
     * Tests the {@link AdjustDiagramZoomLevelAction#AdjustDiagramZoomLevelAction(Diagram, Double)}
     * constructor with newZoomLevel as negative value.
     * </p>
     * <p>
     * {@link IllegalArgumentException} Expected.
     * </p>
     * 
     * @throws Exception
     *             Any exception to JUnit.
     */
    public void testFailureAdjustDiagramZoomLevelAction2() throws Exception {
        try {
            new AdjustDiagramZoomLevelAction(new Diagram(), -1.0);
            fail("IllegalArgumentException is expected for the given input.");
        } catch (IllegalArgumentException e) {
            // as expected.
        }
    }
}
