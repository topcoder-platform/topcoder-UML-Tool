/*
 * Copyright (C) 2007 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.uml.actions.diagram.failuretests;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

import com.topcoder.diagraminterchange.Diagram;
import com.topcoder.uml.actions.diagram.ChangeDiagramTitleAction;

/**
 * <p>
 * This Junit Test suite contains failure test cases for {@link ChangeDiagramTitleAction} class.
 * </p>
 * 
 * @author stylecheck
 * @version 1.0
 */
public class ChangeDiagramTitleActionFailureTest extends TestCase {

    /**
     * <p>
     * Aggregates all tests in this class.
     * </p>
     * 
     * @return Test suite aggregating all tests.
     */
    public static Test suite() {
        return new TestSuite(ChangeDiagramTitleActionFailureTest.class);
    }

    /**
     * <p>
     * Tests the {@link ChangeDiagramTitleAction#ChangeDiagramTitleAction(Diagram, String)} constructor with
     * diagram as null value.
     * </p>
     * <p>
     * {@link IllegalArgumentException} Expected.
     * </p>
     * 
     * @throws Exception
     *             Any exception to JUnit.
     */
    public void testFailureChangeDiagramTitleAction() throws Exception {
        try {
            new ChangeDiagramTitleAction(null, "test");
            fail("IllegalArgumentException is expected for the given input.");
        } catch (IllegalArgumentException e) {
            // as expected.
        }
    }
}
