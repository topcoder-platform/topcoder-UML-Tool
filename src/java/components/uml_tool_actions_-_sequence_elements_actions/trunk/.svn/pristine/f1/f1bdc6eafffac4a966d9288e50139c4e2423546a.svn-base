/*
 * Copyright (C) 2006 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.uml.actions.model.sequence;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

import com.topcoder.uml.model.collaborations.collaborationinteractions.Collaboration;
import com.topcoder.uml.model.collaborations.collaborationinteractions.CollaborationImpl;
import com.topcoder.uml.model.commonbehavior.instances.Object;
import com.topcoder.uml.model.commonbehavior.instances.ObjectImpl;
import com.topcoder.util.actionmanager.ActionExecutionException;

/**
 * <p>
 * This Junit Test suite contains the accuracy and failure test cases for {@link RemoveObjectAction} class.
 * The accuracy test cases gives all valid inputs to the methods/constructors and checks for inconsistencies
 * The failure test cases gives all invalid inputs to the methods/constructors and checks for expected
 * exceptions
 * </p>
 *
 * @author evilisneo
 * @version 1.0
 */
public class RemoveObjectActionUnitTest extends TestCase {

    /**
     * Object instance to be used for the testing.
     */
    private Object object = null;

    /**
     * RemoveObjectAction instance to be used for the testing.
     */
    private RemoveObjectAction removeObjectAction = null;

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
        object = new ObjectImpl();
        Collaboration collaboration = new CollaborationImpl();
        collaboration.addOwnedElement(object);
        object.setNamespace(collaboration);
        removeObjectAction = new RemoveObjectAction(object);
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
        removeObjectAction = null;
        object = null;
        TestHelper.releaseConfig();
    }

    /**
     * <p>
     * Aggregates all tests in this class.
     * </p>
     *
     * @return Test suite aggregating all tests.
     */
    public static Test suite() {
        return new TestSuite(RemoveObjectActionUnitTest.class);
    }

    /**
     * <p>
     * Accuracy test for {@link RemoveObjectAction#RemoveObjectAction(Object)} constructor.
     * </p>
     * <p>
     * Creates an instance and checks its instantiation and the variable initialization.
     * </p>
     *
     * @throws Exception
     *             throw exception to JUnit.
     */
    public void test_accuracy_RemoveObjectAction() throws Exception {
        // check for null
        assertNotNull("RemoveObjectAction creation failed", removeObjectAction);
        // check for the variable initialization.
        assertEquals("RemoveObjectAction creation failed", object, removeObjectAction.getObject());
    }

    /**
     * <p>
     * Failure test for {@link RemoveObjectAction#RemoveObjectAction(Object)} constructor.
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
    public void test_failure_RemoveObjectAction() throws Exception {
        try {
            new RemoveObjectAction(null);
            fail("IllegalArgumentException Expected.");
        } catch (IllegalArgumentException e) {
            // as expected
        }
    }

    /**
     * <p>
     * Accuracy test for {@link RemoveObjectAction#execute()} method.
     * </p>
     * <p>
     * Checks whether the object is removed from the namespace.
     * </p>
     *
     * @throws Exception
     *             throw exception to JUnit.
     */
    public void test_accuracy_execute() throws Exception {
        removeObjectAction.execute();
        assertTrue("execute failed", !removeObjectAction.getObjectUtil().checkObjectNamespace(object));
    }

    /**
     * <p>
     * Failure test for {@link RemoveObjectAction#execute()} method.
     * </p>
     * <p>
     * For the following inputs:
     * </p>
     * <p>
     * Calling the execute twice.
     * </p>
     * <p>
     * Expected {@link ActionExecutionException}.
     * </p>
     *
     * @throws Exception
     *             throw exception to JUnit.
     */
    public void test_failure_execute() throws Exception {
        try {
            removeObjectAction.execute();
            removeObjectAction.execute();
            fail("ActionExecutionException Expected.");
        } catch (ActionExecutionException e) {
            // As expected
        }
    }

    /**
     * <p>
     * Accuracy test for {@link RemoveObjectAction#redo()} method.
     * </p>
     * <p>
     * Call redo and check whether the object is removed from the namespace and canRedo returns false.
     * </p>
     *
     * @throws Exception
     *             throw exception to JUnit.
     */
    public void test_accuracy_redo() throws Exception {
        removeObjectAction.execute();
        removeObjectAction.undo();
        removeObjectAction.redo();
        assertTrue("redo failed", !removeObjectAction.getObjectUtil().checkObjectNamespace(object));
        assertFalse("redo failed", removeObjectAction.canRedo());
    }

    /**
     * <p>
     * Accuracy test for {@link RemoveObjectAction#redo()} method.
     * </p>
     * <p>
     * Calls redo before undo to check whether a warning message is written.
     * </p>
     *
     * @throws Exception
     *             throw exception to JUnit.
     */
    public void test_accuracy_redo1() throws Exception {
        removeObjectAction.execute();
        removeObjectAction.redo();
    }

    /**
     * <p>
     * Accuracy test for {@link RemoveObjectAction#undo()} method.
     * </p>
     * <p>
     * Call undo and check whether the object is removed from the namespace and canUndo returns false.
     * </p>
     *
     * @throws Exception
     *             throw exception to JUnit.
     */
    public void test_accuracy_undo() throws Exception {
        removeObjectAction.execute();
        removeObjectAction.undo();
        assertTrue("Undo failed", removeObjectAction.getObjectUtil().checkObjectNamespace(object));
        assertFalse("Undo failed", removeObjectAction.canUndo());
    }

    /**
     * <p>
     * Accuracy test for {@link RemoveObjectAction#undo()} method.
     * </p>
     * <p>
     * Calling undo twice to check whether a warning message is written.
     * </p>
     *
     * @throws Exception
     *             throw exception to JUnit.
     */
    public void test_accuracy_undo1() throws Exception {
        removeObjectAction.undo();
        removeObjectAction.undo();
    }

    /**
     * <p>
     * Accuracy test for {@link RemoveObjectAction#getPresentationName()} method.
     * </p>
     * <p>
     * Checks the presentation name.
     * </p>
     *
     * @throws Exception
     *             throw exception to JUnit.
     */
    public void test_accuracy_getPresentationName() throws Exception {
        assertEquals("getPresentationName failed", removeObjectAction.getPresentationName(), "Remove Object");
    }
}
