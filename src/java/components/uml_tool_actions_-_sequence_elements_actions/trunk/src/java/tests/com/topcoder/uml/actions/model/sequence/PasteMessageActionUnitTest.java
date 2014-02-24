/*
 * Copyright (C) 2006 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.uml.actions.model.sequence;

import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.Transferable;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

import com.topcoder.uml.model.collaborations.collaborationinteractions.Collaboration;
import com.topcoder.uml.model.collaborations.collaborationinteractions.CollaborationImpl;
import com.topcoder.uml.model.commonbehavior.instances.Stimulus;
import com.topcoder.util.actionmanager.ActionExecutionException;

/**
 * <p>
 * This Junit Test suite contains the accuracy and failure test cases for {@link PasteMessageAction} class.
 * The accuracy test cases gives all valid inputs to the methods/constructors and checks for inconsistencies
 * The failure test cases gives all invalid inputs to the methods/constructors and checks for expected
 * exceptions
 * </p>
 *
 * @author evilisneo
 * @version 1.0
 */
public class PasteMessageActionUnitTest extends TestCase {

    /**
     * PasteMessageAction instance to be used for the testing.
     */
    private PasteMessageAction pasteMessageAction = null;

    /**
     * Stimulus instance to be used for the testing.
     */
    private Stimulus stimulus = null;

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
        stimulus = TestHelper.getAsynchronousMessage();
        collaboration = new CollaborationImpl();
        pasteMessageAction = new MockPasteMessageAction(new CollaborationTransfer(stimulus), collaboration,
            CollaborationTransfer.ASYNCHRONOUS_MESSAGE_FLAVOR);
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
        pasteMessageAction = null;
        stimulus = null;
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
        return new TestSuite(PasteMessageActionUnitTest.class);
    }

    /**
     * <p>
     * Accuracy test for
     * {@link PasteMessageAction#PasteMessageAction(Transferable, Collaboration, DataFlavor)} constructor.
     * </p>
     * <p>
     * Creates an instance and checks its instantiation and the variable initialization.
     * </p>
     *
     * @throws Exception
     *             throw exception to JUnit.
     */
    public void test_accuracy_PasteMessageAction() throws Exception {
        // check for null
        assertNotNull("PasteMessageAction creation failed", pasteMessageAction);
        // check for the variable initialization.
        assertEquals("PasteMessageAction creation failed", stimulus, pasteMessageAction.getStimulus());
        assertEquals("PasteMessageAction creation failed", collaboration, stimulus.getNamespace());
    }

    /**
     * <p>
     * Failure test for {@link PasteMessageAction#PasteMessageAction(Transferable, Collaboration, DataFlavor)}
     * constructor.
     * </p>
     * <p>
     * For the following inputs:
     * </p>
     *
     * <pre>
     *   Input
     *        Transferable transferable : Valid Value
     *        Collaboration collaboration : Valid Value
     *        DataFlavor dataFlavor : Valid Value
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
    public void test_failure_PasteMessageAction() throws Exception {
        try {
            new MockPasteMessageAction(new CollaborationTransfer(stimulus), collaboration,
                CollaborationTransfer.CREATE_MESSAGE_FLAVOR);
            fail("SequenceConfigurationException Expected.");
        } catch (SequenceConfigurationException e) {
            // As expected
        }
    }

    /**
     * <p>
     * Failure test for {@link PasteMessageAction#PasteMessageAction(Transferable, Collaboration, DataFlavor)}
     * constructor.
     * </p>
     * <p>
     * For the following inputs:
     * </p>
     *
     * <pre>
     *   Input
     *        Transferable transferable : null value
     *        Collaboration collaboration : Valid value
     *        DataFlavor dataFlavor : Valid value
     * </pre>
     *
     * <p>
     * Expected {@link IllegalArgumentException}.
     * </p>
     *
     * @throws Exception
     *             throw exception to JUnit.
     */
    public void test_failure_PasteMessageAction1() throws Exception {
        try {
            new MockPasteMessageAction(null, collaboration, CollaborationTransfer.ASYNCHRONOUS_MESSAGE_FLAVOR);
            fail("IllegalArgumentException Expected.");
        } catch (IllegalArgumentException e) {
            // as expected
        }
    }

    /**
     * <p>
     * Failure test for {@link PasteMessageAction#PasteMessageAction(Transferable, Collaboration, DataFlavor)}
     * constructor.
     * </p>
     * <p>
     * For the following inputs:
     * </p>
     *
     * <pre>
     *   Input
     *        Transferable transferable : Valid value
     *        Collaboration collaboration : null value
     *        DataFlavor dataFlavor : Valid value
     * </pre>
     *
     * <p>
     * Expected {@link IllegalArgumentException}.
     * </p>
     *
     * @throws Exception
     *             throw exception to JUnit.
     */
    public void test_failure_PasteMessageAction2() throws Exception {
        try {
            new MockPasteMessageAction(new CollaborationTransfer(stimulus), null,
                CollaborationTransfer.ASYNCHRONOUS_MESSAGE_FLAVOR);
            fail("IllegalArgumentException Expected.");
        } catch (IllegalArgumentException e) {
            // Check for the expected error message
            assertEquals("The Exception message for IllegalArgumentException is wrong", e.getMessage(),
                "collaboration in PasteMessageAction#PasteMessageAction should not be null.");
        }
    }

    /**
     * <p>
     * Failure test for {@link PasteMessageAction#PasteMessageAction(Transferable, Collaboration, DataFlavor)}
     * constructor.
     * </p>
     * <p>
     * For the following inputs:
     * </p>
     *
     * <pre>
     *   Input
     *        Transferable transferable : Valid value
     *        Collaboration collaboration : Valid value
     *        DataFlavor dataFlavor : null value
     * </pre>
     *
     * <p>
     * Expected {@link IllegalArgumentException}.
     * </p>
     *
     * @throws Exception
     *             throw exception to JUnit.
     */
    public void test_failure_PasteMessageAction3() throws Exception {
        try {
            new MockPasteMessageAction(new CollaborationTransfer(stimulus), collaboration, null);
            fail("IllegalArgumentException Expected.");
        } catch (IllegalArgumentException e) {
            // as expected
        }
    }

    /**
     * <p>
     * Accuracy test for {@link PasteMessageAction#execute()} method.
     * </p>
     * <p>
     * Checks if the message is pasted to the namespace.
     * </p>
     *
     * @throws Exception
     *             throw exception to JUnit.
     */
    public void test_accuracy_execute() throws Exception {
        pasteMessageAction.execute();
        assertTrue("execute failed", pasteMessageAction.getMessageUtil().checkStimulusNamespace(stimulus));
    }

    /**
     * <p>
     * Failure test for {@link PasteMessageAction#execute()} method.
     * </p>
     * <p>
     * For the following inputs:
     * </p>
     * <p>
     * If the message is already pasted to the namespace.
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
            pasteMessageAction.execute();
            pasteMessageAction.execute();
            fail("ActionExecutionException Expected.");
        } catch (ActionExecutionException e) {
            // As expected
        }
    }

    /**
     * <p>
     * Accuracy test for {@link PasteMessageAction#redo()} method.
     * </p>
     * <p>
     * Call redo and check whether the message is pasted to the namespace and canRedo returns false.
     * </p>
     *
     * @throws Exception
     *             throw exception to JUnit.
     */
    public void test_accuracy_redo() throws Exception {
        pasteMessageAction.execute();
        pasteMessageAction.undo();
        pasteMessageAction.redo();
        assertTrue("redo failed", pasteMessageAction.getMessageUtil().checkStimulusNamespace(stimulus));
        assertFalse("redo failed", pasteMessageAction.canRedo());
    }

    /**
     * <p>
     * Accuracy test for {@link PasteMessageAction#redo()} method.
     * </p>
     * <p>
     * Calls redo before undo to check whether a warning message is written.
     * </p>
     *
     * @throws Exception
     *             throw exception to JUnit.
     */
    public void test_accuracy_redo1() throws Exception {
        pasteMessageAction.execute();
        pasteMessageAction.redo();
    }

    /**
     * <p>
     * Accuracy test for {@link PasteMessageAction#undo()} method.
     * </p>
     * <p>
     * Call undo and check whether the message is removed from the namespace and canUndo returns false.
     * </p>
     *
     * @throws Exception
     *             throw exception to JUnit.
     */
    public void test_accuracy_undo() throws Exception {
        pasteMessageAction.execute();
        pasteMessageAction.undo();
        assertTrue("Undo failed", !pasteMessageAction.getMessageUtil().checkStimulusNamespace(stimulus));
        assertFalse("Undo failed", pasteMessageAction.canUndo());
    }

    /**
     * <p>
     * Accuracy test for {@link PasteMessageAction#undo()} method.
     * </p>
     * <p>
     * Calling undo twice to check whether a warning message is written.
     * </p>
     *
     * @throws Exception
     *             throw exception to JUnit.
     */
    public void test_accuracy_undo1() throws Exception {
        pasteMessageAction.undo();
        pasteMessageAction.undo();
    }
}
