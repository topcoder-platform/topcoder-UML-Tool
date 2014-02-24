/*
 * Copyright (C) 2006 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.uml.actions.model.sequence;

import java.awt.datatransfer.Transferable;

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
 * This Junit Test suite contains the accuracy and failure test cases for {@link PasteObjectAction} class. The
 * accuracy test cases gives all valid inputs to the methods/constructors and checks for inconsistencies The
 * failure test cases gives all invalid inputs to the methods/constructors and checks for expected exceptions
 * </p>
 *
 * @author evilisneo
 * @version 1.0
 */
public class PasteObjectActionUnitTest extends TestCase {

    /**
     * PasteObjectAction instance to be used for the testing.
     */
    private PasteObjectAction pasteObjectAction = null;

    /**
     * Object instance to be used for the testing.
     */
    private Object object = null;

    /**
     * Collaboration instance to be used for the testing.
     */
    private Collaboration collaboration = null;

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
        collaboration = new CollaborationImpl();
        pasteObjectAction = new PasteObjectAction(new CollaborationTransfer(object), collaboration);
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
        pasteObjectAction = null;
        object = null;
        collaboration = null;
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
        return new TestSuite(PasteObjectActionUnitTest.class);
    }

    /**
     * <p>
     * Accuracy test for {@link PasteObjectAction#PasteObjectAction(Transferable, Collaboration)} constructor.
     * </p>
     * <p>
     * Creates an instance and checks its instantiation and the variable initialization.
     * </p>
     *
     * @throws Exception
     *             throw exception to JUnit.
     */
    public void test_accuracy_PasteObjectAction() throws Exception {
        // check for null
        assertNotNull("PasteObjectAction creation failed", pasteObjectAction);
        // check for the variable initialization.
        assertEquals("PasteObjectAction creation failed", object, pasteObjectAction.getObject());
        assertEquals("PasteObjectAction creation failed", collaboration, object.getNamespace());
    }

    /**
     * <p>
     * Failure test for {@link PasteObjectAction#PasteObjectAction(Transferable, Collaboration)} constructor.
     * </p>
     * <p>
     * For the following inputs:
     * </p>
     *
     * <pre>
     *   Input
     *        Transferable transferable : Valid Value
     *        Collaboration collaboration : Valid Value
     * </pre>
     *
     * <p>
     * The data flavor given does not correspond to transferable.
     * </p>
     * <p>
     * Expected {@link SequenceConfigurationException}.
     * </p>
     *
     * @throws Exception
     *             throw exception to JUnit.
     */
    public void test_failure_PasteObjectAction() throws Exception {
        try {
            new PasteObjectAction(new CollaborationTransfer(TestHelper.getAsynchronousMessage()), collaboration);
            fail("SequenceConfigurationException Expected.");
        } catch (SequenceConfigurationException e) {
            // As expected
        }
    }

    /**
     * <p>
     * Failure test for {@link PasteObjectAction#PasteObjectAction(Transferable, Collaboration)} constructor.
     * </p>
     * <p>
     * For the following inputs:
     * </p>
     *
     * <pre>
     *   Input
     *        Transferable transferable : null value
     *        Collaboration collaboration : Valid value
     * </pre>
     *
     * <p>
     * Expected {@link IllegalArgumentException}.
     * </p>
     *
     * @throws Exception
     *             throw exception to JUnit.
     */
    public void test_failure_PasteObjectAction1() throws Exception {
        try {
            new PasteObjectAction(null, collaboration);
            fail("IllegalArgumentException Expected.");
        } catch (IllegalArgumentException e) {
            // as expected
        }
    }

    /**
     * <p>
     * Failure test for {@link PasteObjectAction#PasteObjectAction(Transferable, Collaboration)} constructor.
     * </p>
     * <p>
     * For the following inputs:
     * </p>
     *
     * <pre>
     *   Input
     *        Transferable transferable : Valid value
     *        Collaboration collaboration : null value
     * </pre>
     *
     * <p>
     * Expected {@link IllegalArgumentException}.
     * </p>
     *
     * @throws Exception
     *             throw exception to JUnit.
     */
    public void test_failure_PasteObjectAction2() throws Exception {
        try {
            new PasteObjectAction(new CollaborationTransfer(object), null);
            fail("IllegalArgumentException Expected.");
        } catch (IllegalArgumentException e) {
            // Check for the expected error message
            assertEquals("The Exception message for IllegalArgumentException is wrong", e.getMessage(),
                "collaboration in PasteObjectAction#PasteObjectAction should not be null.");
        }
    }

    /**
     * <p>
     * Accuracy test for {@link PasteObjectAction#execute()} method.
     * </p>
     * <p>
     * Checks if the object is pasted to the namespace.
     * </p>
     *
     * @throws Exception
     *             throw exception to JUnit.
     */
    public void test_accuracy_execute() throws Exception {
        pasteObjectAction.execute();
        assertTrue("execute failed", pasteObjectAction.getObjectUtil().checkObjectNamespace(object));
    }

    /**
     * <p>
     * Failure test for {@link PasteObjectAction#execute()} method.
     * </p>
     * <p>
     * For the following inputs:
     * </p>
     * <p>
     * If the object is already pasted to the namespace.
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
            pasteObjectAction.execute();
            pasteObjectAction.execute();
            fail("ActionExecutionException Expected.");
        } catch (ActionExecutionException e) {
            // As expected
        }
    }

    /**
     * <p>
     * Accuracy test for {@link PasteObjectAction#redo()} method.
     * </p>
     * <p>
     * Call redo and check whether the object is pasted to the namespace and canRedo returns false.
     * </p>
     *
     * @throws Exception
     *             throw exception to JUnit.
     */
    public void test_accuracy_redo() throws Exception {
        pasteObjectAction.execute();
        pasteObjectAction.undo();
        pasteObjectAction.redo();
        assertTrue("redo failed", pasteObjectAction.getObjectUtil().checkObjectNamespace(object));
        assertFalse("redo failed", pasteObjectAction.canRedo());
    }

    /**
     * <p>
     * Accuracy test for {@link PasteObjectAction#redo()} method.
     * </p>
     * <p>
     * Calls redo before undo to check whether a warning message is written.
     * </p>
     *
     * @throws Exception
     *             throw exception to JUnit.
     */
    public void test_accuracy_redo1() throws Exception {
        pasteObjectAction.execute();
        pasteObjectAction.redo();
    }

    /**
     * <p>
     * Accuracy test for {@link PasteObjectAction#undo()} method.
     * </p>
     * <p>
     * Call undo and check whether the object is removed from the namespace and canUndo returns false.
     * </p>
     *
     * @throws Exception
     *             throw exception to JUnit.
     */
    public void test_accuracy_undo() throws Exception {
        pasteObjectAction.execute();
        pasteObjectAction.undo();
        assertTrue("Undo failed", !pasteObjectAction.getObjectUtil().checkObjectNamespace(object));
        assertFalse("Undo failed", pasteObjectAction.canUndo());
    }

    /**
     * <p>
     * Accuracy test for {@link PasteObjectAction#undo()} method.
     * </p>
     * <p>
     * Calling undo twice to check whether a warning message is written.
     * </p>
     *
     * @throws Exception
     *             throw exception to JUnit.
     */
    public void test_accuracy_undo1() throws Exception {
        pasteObjectAction.undo();
        pasteObjectAction.undo();
    }

    /**
     * <p>
     * Accuracy test for {@link PasteObjectAction#getPresentationName()} method.
     * </p>
     * <p>
     * Checks the presentation name.
     * </p>
     *
     * @throws Exception
     *             throw exception to JUnit.
     */
    public void test_accuracy_getPresentationName() throws Exception {
        assertEquals("getPresentationName failed", pasteObjectAction.getPresentationName(), "Paste Object");
    }

}
