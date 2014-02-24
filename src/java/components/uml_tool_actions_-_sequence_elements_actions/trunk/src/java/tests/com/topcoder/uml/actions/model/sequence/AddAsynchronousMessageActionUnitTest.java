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
 * This Junit Test suite contains the accuracy and failure test cases for {@link AddAsynchronousMessageAction}
 * class. The accuracy test cases gives all valid inputs to the methods/constructors and checks for
 * inconsistencies The failure test cases gives all invalid inputs to the methods/constructors and checks for
 * expected exceptions
 * </p>
 *
 * @author evilisneo
 * @version 1.0
 */
public class AddAsynchronousMessageActionUnitTest extends TestCase {

    /**
     * AddAsynchronousMessageAction instance to be used for the testing.
     */
    private AddAsynchronousMessageAction addAsynchronousMessageAction = null;

    /**
     * Stimulus instance to be used for the testing.
     */
    private Stimulus asynchronousMessage = null;

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
        asynchronousMessage = TestHelper.getAsynchronousMessage();
        collaboration = new CollaborationImpl();
        modelManager = new UMLModelManager();
        addAsynchronousMessageAction = new AddAsynchronousMessageAction(asynchronousMessage, collaboration,
            modelManager);
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
        collaboration = null;
        modelManager = null;
        addAsynchronousMessageAction = null;
        asynchronousMessage = null;
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
        return new TestSuite(AddAsynchronousMessageActionUnitTest.class);
    }

    /**
     * <p>
     * Accuracy test for
     * {@link AddAsynchronousMessageAction#AddAsynchronousMessageAction(Stimulus, Collaboration, UMLModelManager)}
     * constructor.
     * </p>
     * <p>
     * Creates an instance and checks its instantiation and the variable initialization.
     * </p>
     *
     * @throws Exception
     *             throw exception to JUnit.
     */
    public void test_accuracy_AddAsynchronousMessageAction() throws Exception {
        // check for null
        assertNotNull("AddAsynchronousMessageAction creation failed", addAsynchronousMessageAction);
        // check for the variable initialization.
        assertEquals("AddAsynchronousMessageAction creation failed", asynchronousMessage,
            addAsynchronousMessageAction.getStimulus());
        assertEquals("AddAsynchronousMessageAction creation failed", collaboration, asynchronousMessage
            .getNamespace());

    }

    /**
     * <p>
     * Failure test for
     * {@link AddAsynchronousMessageAction#AddAsynchronousMessageAction(Stimulus, Collaboration, UMLModelManager)}
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
    public void test_failure_AddAsynchronousMessageAction() throws Exception {
        try {
            new AddAsynchronousMessageAction(null, collaboration, modelManager);
            fail("IllegalArgumentException Expected.");
        } catch (IllegalArgumentException e) {
            // as expected
        }
    }

    /**
     * <p>
     * Failure test for
     * {@link AddAsynchronousMessageAction#AddAsynchronousMessageAction(Stimulus, Collaboration, UMLModelManager)}
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
    public void test_failure_AddAsynchronousMessageAction1() throws Exception {
        try {
            new AddAsynchronousMessageAction(asynchronousMessage, null, modelManager);
            fail("IllegalArgumentException Expected.");
        } catch (IllegalArgumentException e) {
            // as expected
        }
    }

    /**
     * <p>
     * Failure test for
     * {@link AddAsynchronousMessageAction#AddAsynchronousMessageAction(Stimulus, Collaboration, UMLModelManager)}
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
    public void test_failure_AddAsynchronousMessageAction2() throws Exception {
        try {
            new AddAsynchronousMessageAction(asynchronousMessage, collaboration, null);
            fail("IllegalArgumentException Expected.");
        } catch (IllegalArgumentException e) {
            // as expected
        }
    }

    /**
     * <p>
     * Failure test for
     * {@link AddAsynchronousMessageAction#AddAsynchronousMessageAction(Stimulus, Collaboration, UMLModelManager)}
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
    public void test_failure_AddAsynchronousMessageAction3() throws Exception {
        try {
            new AddAsynchronousMessageAction(TestHelper.getCreateMessage(), collaboration, modelManager);
            fail("SequenceConfigurationException Expected.");
        } catch (SequenceConfigurationException e) {
            // As expected
        }
    }

    /**
     * <p>
     * Accuracy test for {@link AddAsynchronousMessageAction#getPresentationName()} method.
     * </p>
     * <p>
     * checks whether the presentation name is correct.
     * </p>
     *
     * @throws Exception
     *             throw exception to JUnit.
     */
    public void test_accuracy_getPresentationName() throws Exception {
        assertEquals("getPresentationName failed", addAsynchronousMessageAction.getPresentationName(),
            "Add Asynchronous Message");
    }
}
