/*
 * Copyright (C) 2007 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.uml.actions.diagram;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

import com.topcoder.uml.actions.diagram.failuretests.FailureTestHelper;
import com.topcoder.uml.actions.diagram.failuretests.MockElement;
import com.topcoder.uml.model.core.Element;
import com.topcoder.uml.model.core.classifiers.ClassImpl;
import com.topcoder.util.actionmanager.ActionExecutionException;

/**
 * <p>
 * This Junit Test suite contains failure test cases for {@link CreateActivityDiagramAction} class.
 * </p>
 * 
 * @author stylecheck
 * @version 1.0
 */
public class CreateActivityDiagramActionFailureTest extends TestCase {

    /**
     * CreateActivityDiagramAction for testing.
     */
    private CreateActivityDiagramAction createActivityDiagramAction = null;

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
        createActivityDiagramAction = new CreateActivityDiagramAction(new ClassImpl(), "Create");
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
        createActivityDiagramAction = null;
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
        return new TestSuite(CreateActivityDiagramActionFailureTest.class);
    }

    /**
     * <p>
     * Tests the {@link CreateActivityDiagramAction#CreateActivityDiagramAction(Element, String)}
     * constructor with owner as non Model Element.
     * </p>
     * <p>
     * {@link IllegalArgumentException} Expected.
     * </p>
     * 
     * @throws Exception
     *             Any exception to JUnit.
     */
    public void testFailureCreateActivityDiagramAction() throws Exception {
        try {
            new CreateActivityDiagramAction(new MockElement(), "test");
            fail("IllegalArgumentException is expected for the given input.");
        } catch (IllegalArgumentException e) {
            // as expected.
        }
    }

    /**
     * <p>
     * Tests the {@link CreateActivityDiagramAction#executeAction()} method.
     * </p>
     * <p>
     * Calling the execute twice.
     * </p>
     * <p>
     * {@link ActionExecutionException} Expected.
     * </p>
     * 
     * @throws Exception
     *             Any exception to JUnit.
     */
    public void testFailureexecuteAction() throws Exception {
        try {
            createActivityDiagramAction.executeAction();
            createActivityDiagramAction.executeAction();
            fail("ActionExecutionException Expected.");
        } catch (ActionExecutionException e) {
            // As expected.
        }
    }
}
