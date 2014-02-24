/*
 * Copyright (C) 2006 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.uml.actions.model.sequence;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

import com.topcoder.uml.model.collaborations.collaborationinteractions.Collaboration;
import com.topcoder.uml.model.collaborations.collaborationinteractions.CollaborationImpl;
import com.topcoder.uml.model.commonbehavior.instances.Stimulus;
import com.topcoder.uml.model.commonbehavior.instances.StimulusImpl;
import com.topcoder.uml.modelmanager.UMLModelManager;
import com.topcoder.uml.projectconfiguration.ProjectConfigurationManager;
import com.topcoder.util.actionmanager.ActionExecutionException;

/**
 * <p>
 * This Junit Test suite contains the accuracy and failure test cases for {@link AddMessageAction} class. The
 * accuracy test cases gives all valid inputs to the methods/constructors and checks for inconsistencies The
 * failure test cases gives all invalid inputs to the methods/constructors and checks for expected exceptions
 * </p>
 *
 * @author evilisneo
 * @version 1.0
 */
public class AddMessageActionUnitTest extends TestCase {

    /**
     * AddMessageAction instance to be used for the testing.
     */
    private AddMessageAction addMessageAction = null;

    /**
     * Stimulus instance to be used for the testing.
     */
    private Stimulus stimulus = null;

    /**
     * Collaboration instance to be used for the testing.
     */
    private Collaboration collaboration = null;

    /**
     * UMLModelManager instance to be used for the testing.
     */
    private UMLModelManager modelManager = null;

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
        stimulus = new StimulusImpl();
        collaboration = new CollaborationImpl();
        modelManager = new UMLModelManager();
        addMessageAction = new MockAddMessageAction(stimulus, collaboration, modelManager);
        modelManager.setProjectConfigurationManager(new ProjectConfigurationManager(modelManager));
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
        addMessageAction = null;
        stimulus = null;
        modelManager = null;
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
        return new TestSuite(AddMessageActionUnitTest.class);
    }

    /**
     * <p>
     * Accuracy test for {@link AddMessageAction#AddMessageAction(Stimulus, Collaboration, UMLModelManager)}
     * constructor.
     * </p>
     * <p>
     * Creates an instance and checks its instantiation and the variable initialization.
     * </p>
     *
     * @throws Exception
     *             throw exception to JUnit.
     */
    public void test_accuracy_AddMessageAction() throws Exception {
        // check for null
        assertNotNull("AddMessageAction creation failed", addMessageAction);
        // check for the variable initialization.
        assertEquals("AddMessageAction creation failed", stimulus, addMessageAction.getStimulus());
        assertEquals("AddMessageAction creation failed", collaboration, stimulus.getNamespace());
    }

    /**
     * <p>
     * Failure test for {@link AddMessageAction#AddMessageAction(Stimulus, Collaboration, UMLModelManager)}
     * constructor.
     * </p>
     * <p>
     * For the following inputs:
     * </p>
     *
     * <pre>
     *         Input
     *              Stimulus stimulus : null value
     *              Collaboration collaboration : Valid value
     *              UMLModelManager manager : Valid value
     * </pre>
     *
     * <p>
     * Expected {@link IllegalArgumentException}.
     * </p>
     *
     * @throws Exception
     *             throw exception to JUnit.
     */
    public void test_failure_AddMessageAction() throws Exception {
        try {
            new MockAddMessageAction(null, collaboration, modelManager);
            fail("IllegalArgumentException Expected.");
        } catch (IllegalArgumentException e) {
            // as expected
        }
    }

    /**
     * <p>
     * Failure test for {@link AddMessageAction#AddMessageAction(Stimulus, Collaboration, UMLModelManager)}
     * constructor.
     * </p>
     * <p>
     * For the following inputs:
     * </p>
     *
     * <pre>
     *         Input
     *              Stimulus stimulus : Valid value
     *              Collaboration collaboration : null value
     *              UMLModelManager manager : Valid value
     * </pre>
     *
     * <p>
     * Expected {@link IllegalArgumentException}.
     * </p>
     *
     * @throws Exception
     *             throw exception to JUnit.
     */
    public void test_failure_AddMessageAction1() throws Exception {
        try {
            new MockAddMessageAction(stimulus, null, modelManager);
            fail("IllegalArgumentException Expected.");
        } catch (IllegalArgumentException e) {
            // Check for the expected error message
            assertEquals("The Exception message for IllegalArgumentException is wrong", e.getMessage(),
                "collaboration in AddMessageAction#AddMessageAction should not be null.");
        }
    }

    /**
     * <p>
     * Failure test for {@link AddMessageAction#AddMessageAction(Stimulus, Collaboration, UMLModelManager)}
     * constructor.
     * </p>
     * <p>
     * For the following inputs:
     * </p>
     *
     * <pre>
     *         Input
     *              Stimulus stimulus : Valid value
     *              Collaboration collaboration : Valid value
     *              UMLModelManager manager : null value
     * </pre>
     *
     * <p>
     * Expected {@link IllegalArgumentException}.
     * </p>
     *
     * @throws Exception
     *             throw exception to JUnit.
     */
    public void test_failure_AddMessageAction2() throws Exception {
        try {
            new MockAddMessageAction(stimulus, collaboration, null);
        } catch (IllegalArgumentException e) {
            // Check for the expected error message
            assertEquals("The Exception message for IllegalArgumentException is wrong", e.getMessage(),
                "manager in AddMessageAction#AddMessageAction should not be null.");
        }
    }

    /**
     * <p>
     * Accuracy test for {@link AddMessageAction#execute()} method.
     * </p>
     * <p>
     * Checks if the message is added to the namespace.
     * </p>
     *
     * @throws Exception
     *             throw exception to JUnit.
     */
    public void test_accuracy_execute() throws Exception {
        addMessageAction.execute();
        assertTrue("execute failed", addMessageAction.getMessageUtil().checkStimulusNamespace(stimulus));
    }

    /**
     * <p>
     * Failure test for {@link AddMessageAction#execute()} method.
     * </p>
     * <p>
     * For the following inputs:
     * </p>
     * <p>
     * If the message is already added to the namespace.
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
            addMessageAction.execute();
            addMessageAction.execute();
            fail("ActionExecutionException Expected.");
        } catch (ActionExecutionException e) {
            // As expected
        }
    }

    /**
     * <p>
     * Accuracy test for {@link AddMessageAction#redo()} method.
     * </p>
     * <p>
     * Call redo and check whether the message is added to the namespace and canRedo returns false.
     * </p>
     *
     * @throws Exception
     *             throw exception to JUnit.
     */
    public void test_accuracy_redo() throws Exception {
        addMessageAction.execute();
        addMessageAction.undo();
        addMessageAction.redo();
        assertTrue("redo failed", addMessageAction.getMessageUtil().checkStimulusNamespace(stimulus));
        assertFalse("redo failed", addMessageAction.canRedo());
    }

    /**
     * <p>
     * Accuracy test for {@link AddMessageAction#redo()} method.
     * </p>
     * <p>
     * Calls redo before undo to check whether a warning message is written.
     * </p>
     *
     * @throws Exception
     *             throw exception to JUnit.
     */
    public void test_accuracy_redo1() throws Exception {
        addMessageAction.execute();
        addMessageAction.redo();
    }

    /**
     * <p>
     * Accuracy test for {@link AddMessageAction#undo()} method.
     * </p>
     * <p>
     * Call undo and check whether the message is removed from the namespace and canUndo returns false.
     * </p>
     *
     * @throws Exception
     *             throw exception to JUnit.
     */
    public void test_accuracy_undo() throws Exception {
        addMessageAction.execute();
        addMessageAction.undo();
        assertTrue("Undo failed", !addMessageAction.getMessageUtil().checkStimulusNamespace(stimulus));
        assertFalse("Undo failed", addMessageAction.canUndo());
    }

    /**
     * <p>
     * Accuracy test for {@link AddMessageAction#undo()} method.
     * </p>
     * <p>
     * Calling undo twice to check whether a warning message is written.
     * </p>
     *
     * @throws Exception
     *             throw exception to JUnit.
     */
    public void test_accuracy_undo1() throws Exception {
        addMessageAction.undo();
        addMessageAction.undo();
    }
}
