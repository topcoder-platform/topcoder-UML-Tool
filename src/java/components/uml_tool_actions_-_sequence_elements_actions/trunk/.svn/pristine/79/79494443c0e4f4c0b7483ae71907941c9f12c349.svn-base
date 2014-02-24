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
import com.topcoder.uml.model.commonbehavior.instances.Stimulus;

/**
 * <p>
 * This Junit Test suite contains the accuracy and failure test cases for {@link PasteSendSignalMessageAction}
 * class. The accuracy test cases gives all valid inputs to the methods/constructors and checks for
 * inconsistencies The failure test cases gives all invalid inputs to the methods/constructors and checks for
 * expected exceptions
 * </p>
 *
 * @author evilisneo
 * @version 1.0
 */
public class PasteSendSignalMessageActionUnitTest extends TestCase {

    /**
     * Stimulus instance to be used for the testing.
     */
    private Stimulus stimulus = null;

    /**
     * Collaboration instance to be used for the testing.
     */
    private Collaboration collaboration = null;

    /**
     * PasteSendSignalMessageAction instance to be used for the testing.
     */
    private PasteSendSignalMessageAction pasteSendSignalMessageAction = null;

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
        stimulus = TestHelper.getSendSignalMessage();
        collaboration = new CollaborationImpl();
        pasteSendSignalMessageAction = new PasteSendSignalMessageAction(new CollaborationTransfer(stimulus),
            collaboration);
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
        pasteSendSignalMessageAction = null;
        stimulus = null;
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
        return new TestSuite(PasteSendSignalMessageActionUnitTest.class);
    }

    /**
     * <p>
     * Accuracy test for
     * {@link PasteSendSignalMessageAction#PasteSendSignalMessageAction(Transferable, Collaboration)}
     * constructor.
     * </p>
     * <p>
     * Creates an instance and checks its instantiation and the variable initialization.
     * </p>
     *
     * @throws Exception
     *             throw exception to JUnit.
     */
    public void test_accuracy_PasteSendSignalMessageAction() throws Exception {
        // check for null
        assertNotNull("PasteSendSignalMessageAction creation failed", pasteSendSignalMessageAction);
        // check for the variable initialization.
        assertEquals("PasteSendSignalMessageAction creation failed", stimulus, pasteSendSignalMessageAction
            .getStimulus());
        assertEquals("PasteSendSignalMessageAction creation failed", collaboration, stimulus.getNamespace());
    }

    /**
     * <p>
     * Failure test for
     * {@link PasteSendSignalMessageAction#PasteSendSignalMessageAction(Transferable, Collaboration)}
     * constructor.
     * </p>
     * <p>
     * For the following inputs:
     * </p>
     *
     * <pre>
     *  Input
     *   Transferable transferable : null value
     *   Collaboration collaboration : Valid value
     * </pre>
     *
     * <p>
     * Expected {@link IllegalArgumentException}.
     * </p>
     *
     * @throws Exception
     *             throw exception to JUnit.
     */
    public void test_failure_PasteSendSignalMessageAction() throws Exception {
        try {
            new PasteSendSignalMessageAction(null, collaboration);
            fail("IllegalArgumentException Expected.");
        } catch (IllegalArgumentException e) {
            // as expected
        }
    }

    /**
     * <p>
     * Failure test for
     * {@link PasteSendSignalMessageAction#PasteSendSignalMessageAction(Transferable, Collaboration)}
     * constructor.
     * </p>
     * <p>
     * For the following inputs:
     * </p>
     *
     * <pre>
     *   Input
     *    Transferable transferable : Valid value
     *    Collaboration collaboration : null value
     * </pre>
     *
     * <p>
     * Expected {@link IllegalArgumentException}.
     * </p>
     *
     * @throws Exception
     *             throw exception to JUnit.
     */
    public void test_failure_PasteSendSignalMessageAction1() throws Exception {
        try {
            new PasteSendSignalMessageAction(new CollaborationTransfer(stimulus), null);
            fail("IllegalArgumentException Expected.");
        } catch (IllegalArgumentException e) {
            // as expected
        }
    }

    /**
     * <p>
     * Failure test for
     * {@link PasteSendSignalMessageAction#PasteSendSignalMessageAction(Transferable, Collaboration)}
     * constructor.
     * </p>
     * <p>
     * For the following inputs:
     * </p>
     *
     * <pre>
     *  Input
     *   Transferable transferable : Valid Value
     *   Collaboration collaboration : Valid Value
     * </pre>
     *
     * <p>
     * Transferable does not contain the expected message type.
     * </p>
     * <p>
     * Expected {@link SequenceConfigurationException}.
     * </p>
     *
     * @throws Exception
     *             throw exception to JUnit.
     */
    public void test_failure_PasteSendSignalMessageAction2() throws Exception {
        try {
            new PasteSendSignalMessageAction(new CollaborationTransfer(TestHelper.getCreateMessage()),
                collaboration);
            fail("SequenceConfigurationException Expected.");
        } catch (SequenceConfigurationException e) {
            // As expected
        }
    }

    /**
     * <p>
     * Accuracy test for {@link PasteSendSignalMessageAction#getPresentationName()} method.
     * </p>
     * <p>
     * Checks the presentation name.
     * </p>
     *
     * @throws Exception
     *             throw exception to JUnit.
     */
    public void test_accuracy_getPresentationName() throws Exception {
        assertEquals("getPresentationName failed", pasteSendSignalMessageAction.getPresentationName(),
            "Paste Send Signal Message");
    }
}
