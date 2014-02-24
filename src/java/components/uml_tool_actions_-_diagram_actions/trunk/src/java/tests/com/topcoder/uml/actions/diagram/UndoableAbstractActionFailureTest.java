/*
 * Copyright (C) 2007 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.uml.actions.diagram;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

import com.topcoder.uml.actions.diagram.failuretests.FailureTestHelper;
import com.topcoder.util.log.Level;

/**
 * <p>
 * This Junit Test suite contains failure test cases for {@link UndoableAbstractAction} class.
 * </p>
 * 
 * @author stylecheck
 * @version 1.0
 */
public class UndoableAbstractActionFailureTest extends TestCase {

    /**
     * UndoableAbstractAction for testing.
     */
    private UndoableAbstractAction undoableAbstractAction = null;

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
        undoableAbstractAction = new MockUndoableAbstractAction("Action");
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
        undoableAbstractAction = null;
    }

    /**
     * <p>
     * Aggregates all tests in this class.
     * </p>
     * 
     * @return Test suite aggregating all tests.
     */
    public static Test suite() {
        return new TestSuite(UndoableAbstractActionFailureTest.class);
    }

    /**
     * <p>
     * Tests the {@link UndoableAbstractAction#UndoableAbstractAction(String)} constructor with
     * presentationName as null value.
     * </p>
     * <p>
     * {@link IllegalArgumentException} Expected.
     * </p>
     * 
     * @throws Exception
     *             Any exception to JUnit.
     */
    public void testFailureUndoableAbstractAction() throws Exception {
        try {
            new MockUndoableAbstractAction(null);
            fail("IllegalArgumentException is expected for the given input.");
        } catch (IllegalArgumentException e) {
            // as expected.
        }
    }

    /**
     * <p>
     * Tests the {@link UndoableAbstractAction#UndoableAbstractAction(String)} constructor with
     * presentationName as Empty string.
     * </p>
     * <p>
     * {@link IllegalArgumentException} Expected.
     * </p>
     * 
     * @throws Exception
     *             Any exception to JUnit.
     */
    public void testFailureUndoableAbstractAction1() throws Exception {
        try {
            new MockUndoableAbstractAction("");
            fail("IllegalArgumentException is expected for the given input.");
        } catch (IllegalArgumentException e) {
            // as expected.
        }
    }

    /**
     * <p>
     * Tests the {@link UndoableAbstractAction#UndoableAbstractAction(String)} constructor with
     * presentationName as Empty string with only spaces.
     * </p>
     * <p>
     * {@link IllegalArgumentException} Expected.
     * </p>
     * 
     * @throws Exception
     *             Any exception to JUnit.
     */
    public void testFailureUndoableAbstractAction2() throws Exception {
        try {
            new MockUndoableAbstractAction("  ");
            fail("IllegalArgumentException is expected for the given input.");
        } catch (IllegalArgumentException e) {
            // as expected.
        }
    }

    /**
     * <p>
     * Tests the {@link UndoableAbstractAction#log(Level, String)} method with level as null value.
     * </p>
     * <p>
     * {@link IllegalArgumentException} Expected.
     * </p>
     * 
     * @throws Exception
     *             Any exception to JUnit.
     */
    public void testFailurelog() throws Exception {
        try {
             undoableAbstractAction.log(null, "test");
            fail("IllegalArgumentException is expected for the given input.");
        } catch (IllegalArgumentException e) {
            // as expected.
        }
    }
}
