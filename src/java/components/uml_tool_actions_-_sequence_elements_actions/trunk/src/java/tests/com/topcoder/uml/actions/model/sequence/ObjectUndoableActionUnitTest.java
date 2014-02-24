/*
 * Copyright (C) 2006 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.uml.actions.model.sequence;

import java.awt.datatransfer.Transferable;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

import com.topcoder.uml.model.commonbehavior.instances.Object;

/**
 * <p>
 * This Junit Test suite contains the accuracy and failure test cases for <code>ObjectUndoableAction</code> class.
 * The accuracy test cases gives all valid inputs to the methods/constructors and checks for inconsistencies
 * The failure test cases gives all invalid inputs to the methods/constructors and checks for expected
 * exceptions
 * </p>
 *
 * @author evilisneo
 * @version 1.0
 */
public class ObjectUndoableActionUnitTest extends TestCase {

    /**
     * ObjectUndoableAction instance to be used for the testing.
     */
    private ObjectUndoableAction objectUndoableAction = null;

    /**
     * <p>
     * Sets up the environment for the TestCase.
     * </p>
     *
     * @throws Exception
     *             throw exception to JUnit.
     */
    protected void setUp() throws Exception {
        TestHelper.loadConfig();
        objectUndoableAction = new MockObjectUndoableAction(TestHelper.OBJECT);
    }

    /**
     * <p>
     * Tears down the environment after the TestCase.
     * </p>
     *
     * @throws Exception
     *             throw exception to JUnit.
     */
    protected void tearDown() throws Exception {
        TestHelper.releaseConfig();
        objectUndoableAction = null;
    }

    /**
     * <p>
     * Aggregates all tests in this class.
     * </p>
     *
     * @return Test suite aggregating all tests.
     */
    public static Test suite() {
        return new TestSuite(ObjectUndoableActionUnitTest.class);
    }

    /**
     * <p>
     * Accuracy test for {@link ObjectUndoableAction#ObjectUndoableAction(Object)} constructor.
     * </p>
     * <p>
     * Creates an instance and checks its instantiation and the variable initialization.
     * </p>
     *
     * @throws Exception
     *             throw exception to JUnit.
     */
    public void test_accuracy_ObjectUndoableAction() throws Exception {
        // check for null
        assertNotNull("ObjectUndoableAction creation failed", objectUndoableAction);
        // check for the variable initialization.
        assertEquals("ObjectUndoableAction creation failed", TestHelper.OBJECT, objectUndoableAction.getObject());
    }

    /**
     * <p>
     * Failure test for {@link ObjectUndoableAction#ObjectUndoableAction(Object)} constructor.
     * </p>
     * <p>
     * For the following inputs:
     * </p>
     *
     * <pre>
     *   Input
     *        Object object : null value
     * </pre>
     *
     * <p>
     * Expected {@link IllegalArgumentException}.
     * </p>
     *
     * @throws Exception
     *             throw exception to JUnit.
     */
    public void test_failure_ObjectUndoableAction() throws Exception {
        try {
            new MockObjectUndoableAction((Object) null);
            fail("IllegalArgumentException Expected.");
        } catch (IllegalArgumentException e) {
            // Check for the expected error message
            assertEquals("The Exception message for IllegalArgumentException is wrong", e.getMessage(),
                "object in ObjectUndoableAction#ObjectUndoableAction should not be null.");
        }
    }

    /**
     * <p>
     * Accuracy test for {@link ObjectUndoableAction#ObjectUndoableAction(Transferable)} constructor.
     * </p>
     * <p>
     * Creates an instance and checks its instantiation and the variable initialization.
     * </p>
     *
     * @throws Exception
     *             throw exception to JUnit.
     */
    public void test_accuracy_ObjectUndoableAction1() throws Exception {
        ObjectUndoableAction objectUndoableAction1 = new MockObjectUndoableAction(new CollaborationTransfer(
            TestHelper.OBJECT));
        // check for null
        assertNotNull("ObjectUndoableAction creation failed", objectUndoableAction1);
        // check for the variable initialization.
        assertEquals("ObjectUndoableAction creation failed", TestHelper.OBJECT, objectUndoableAction1.getObject());
    }

    /**
     * <p>
     * Failure test for {@link ObjectUndoableAction#ObjectUndoableAction(Transferable)} constructor.
     * </p>
     * <p>
     * For the following inputs:
     * </p>
     *
     * <pre>
     *   Input
     *        Transferable transferable : null value
     * </pre>
     *
     * <p>
     * Expected {@link IllegalArgumentException}.
     * </p>
     *
     * @throws Exception
     *             throw exception to JUnit.
     */
    public void test_failure_ObjectUndoableAction1() throws Exception {
        try {
            new MockObjectUndoableAction((Transferable) null);
            fail("IllegalArgumentException Expected.");
        } catch (IllegalArgumentException e) {
            // Check for the expected error message
            assertEquals("The Exception message for IllegalArgumentException is wrong", e.getMessage(),
                "transferable in ObjectUndoableAction#ObjectUndoableAction should not be null.");
        }
    }

    /**
     * <p>
     * Failure test for {@link ObjectUndoableAction#ObjectUndoableAction(Transferable)} constructor.
     * </p>
     * <p>
     * For the following inputs:
     * </p>
     *
     * <pre>
     *   Input
     *        Transferable transferable : Valid Value
     * </pre>
     *
     * <p>
     * Creating the transferable with a different object and passing.
     * </p>
     * <p>
     * Expected {@link SequenceConfigurationException}.
     * </p>
     *
     * @throws Exception
     *             throw exception to JUnit.
     */
    public void test_failure_ObjectUndoableAction2() throws Exception {
        try {
            new MockObjectUndoableAction(new CollaborationTransfer(TestHelper.getAsynchronousMessage()));
            fail("SequenceConfigurationException Expected.");
        } catch (SequenceConfigurationException e) {
            // As expected
        }
    }

    /**
     * <p>
     * Accuracy test for {@link ObjectUndoableAction#getObjectUtil()} method.
     * </p>
     * <p>
     * Checks whether the object util is not null.
     * </p>
     *
     * @throws Exception
     *             throw exception to JUnit.
     */
    public void test_accuracy_getObjectUtil() throws Exception {
        assertNotNull("getObjectUtil failed", objectUndoableAction.getObjectUtil());
    }

    /**
     * <p>
     * Accuracy test for {@link ObjectUndoableAction#getLog()} method.
     * </p>
     * <p>
     * Checks whether the log is not null.
     * </p>
     *
     * @throws Exception
     *             throw exception to JUnit.
     */
    public void test_accuracy_getLog() throws Exception {
        assertNotNull("getLog failed", objectUndoableAction.getLog());
    }
}
