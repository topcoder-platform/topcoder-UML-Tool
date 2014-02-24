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
import com.topcoder.uml.modelmanager.UMLModelManager;

/**
 * <p>
 * This Junit Test suite contains the accuracy and failure test cases for {@link AddCreateMessageAction}
 * class. The accuracy test cases gives all valid inputs to the methods/constructors and checks for
 * inconsistencies The failure test cases gives all invalid inputs to the methods/constructors and checks for
 * expected exceptions
 * </p>
 *
 * @author evilisneo
 * @version 1.0
 */
public class AddCreateMessageActionUnitTest extends TestCase {

    /**
     * AddCreateMessageAction instance to be used for the testing.
     */
    private AddCreateMessageAction addCreateMessageAction = null;

    /**
     * Stimulus instance to be used for the testing.
     */
    private Stimulus createMessage = null;

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
        createMessage = TestHelper.getCreateMessage();
        collaboration = new CollaborationImpl();
        modelManager = new UMLModelManager();
        addCreateMessageAction = new AddCreateMessageAction(createMessage, collaboration, modelManager);
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
        addCreateMessageAction = null;
        modelManager = null;
        collaboration = null;
        createMessage = null;
    }

    /**
     * <p>
     * Aggregates all tests in this class.
     * </p>
     *
     * @return Test suite aggregating all tests.
     */
    public static Test suite() {
        return new TestSuite(AddCreateMessageActionUnitTest.class);
    }

    /**
     * <p>
     * Accuracy test for
     * {@link AddCreateMessageAction#AddCreateMessageAction(Stimulus, Collaboration, UMLModelManager)}
     * constructor.
     * </p>
     * <p>
     * Creates an instance and checks its instantiation and the variable initialization.
     * </p>
     *
     * @throws Exception
     *             throw exception to JUnit.
     */
    public void test_accuracy_AddCreateMessageAction() throws Exception {
        // check for null
        assertNotNull("AddCreateMessageAction creation failed", addCreateMessageAction);
        // check for the variable initialization.
        assertEquals("AddCreateMessageAction creation failed", createMessage, addCreateMessageAction.getStimulus());
        assertEquals("AddCreateMessageAction creation failed", collaboration, createMessage.getNamespace());

    }

    /**
     * <p>
     * Failure test for
     * {@link AddCreateMessageAction#AddCreateMessageAction(Stimulus, Collaboration, UMLModelManager)}
     * constructor.
     * </p>
     * <p>
     * For the following inputs:
     * </p>
     *
     * <pre>
     *       Input
     *            Stimulus stimulus : null value
     *            Collaboration collaboration : Valid value
     *            UMLModelManager manager : Valid value
     * </pre>
     *
     * <p>
     * Expected {@link IllegalArgumentException}.
     * </p>
     *
     * @throws Exception
     *             throw exception to JUnit.
     */
    public void test_failure_AddCreateMessageAction() throws Exception {
        try {
            new AddCreateMessageAction(null, collaboration, modelManager);
            fail("IllegalArgumentException Expected.");
        } catch (IllegalArgumentException e) {
            // as expected
        }
    }

    /**
     * <p>
     * Failure test for
     * {@link AddCreateMessageAction#AddCreateMessageAction(Stimulus, Collaboration, UMLModelManager)}
     * constructor.
     * </p>
     * <p>
     * For the following inputs:
     * </p>
     *
     * <pre>
     *       Input
     *            Stimulus stimulus : Valid value
     *            Collaboration collaboration : null value
     *            UMLModelManager manager : Valid value
     * </pre>
     *
     * <p>
     * Expected {@link IllegalArgumentException}.
     * </p>
     *
     * @throws Exception
     *             throw exception to JUnit.
     */
    public void test_failure_AddCreateMessageAction1() throws Exception {
        try {
            new AddCreateMessageAction(createMessage, null, modelManager);
            fail("IllegalArgumentException Expected.");
        } catch (IllegalArgumentException e) {
            // as expected
        }
    }

    /**
     * <p>
     * Failure test for
     * {@link AddCreateMessageAction#AddCreateMessageAction(Stimulus, Collaboration, UMLModelManager)}
     * constructor.
     * </p>
     * <p>
     * For the following inputs:
     * </p>
     *
     * <pre>
     *       Input
     *            Stimulus stimulus : Valid value
     *            Collaboration collaboration : Valid value
     *            UMLModelManager manager : null value
     * </pre>
     *
     * <p>
     * Expected {@link IllegalArgumentException}.
     * </p>
     *
     * @throws Exception
     *             throw exception to JUnit.
     */
    public void test_failure_AddCreateMessageAction2() throws Exception {
        try {
            new AddCreateMessageAction(createMessage, collaboration, null);
            fail("IllegalArgumentException Expected.");
        } catch (IllegalArgumentException e) {
            // as expected
        }
    }

    /**
     * <p>
     * Failure test for
     * {@link AddCreateMessageAction#AddCreateMessageAction(Stimulus, Collaboration, UMLModelManager)}
     * constructor.
     * </p>
     * <p>
     * For the following inputs:
     * </p>
     *
     * <pre>
     *       Input
     *            Stimulus stimulus : Valid Value
     *            Collaboration collaboration : Valid Value
     *            UMLModelManager manager : Valid Value
     * </pre>
     *
     * <p>
     * The stimulus is not of the correct type.
     * </p>
     * <p>
     * Expected {@link SequenceConfigurationException}.
     * </p>
     *
     * @throws Exception
     *             throw exception to JUnit.
     */
    public void test_failure_AddCreateMessageAction3() throws Exception {
        try {
            new AddCreateMessageAction(TestHelper.getReturnMessage(), collaboration, modelManager);
            fail("SequenceConfigurationException Expected.");
        } catch (SequenceConfigurationException e) {
            // As expected
        }
    }

    /**
     * <p>
     * Accuracy test for {@link AddCreateMessageAction#getPresentationName()} method.
     * </p>
     * <p>
     * checks whether the presentation name is correct.
     * </p>
     *
     * @throws Exception
     *             throw exception to JUnit.
     */
    public void test_accuracy_getPresentationName() throws Exception {
        assertEquals("getPresentationName failed", addCreateMessageAction.getPresentationName(),
            "Add Create Message");
    }
}
