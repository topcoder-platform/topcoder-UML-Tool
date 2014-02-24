/*
 * Copyright (C) 2006 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.uml.actions.model.sequence;

import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.util.ArrayList;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

import com.topcoder.uml.model.collaborations.collaborationinstances.CollaborationInstanceSet;
import com.topcoder.uml.model.collaborations.collaborationinstances.CollaborationInstanceSetImpl;
import com.topcoder.uml.model.collaborations.collaborationinteractions.Collaboration;
import com.topcoder.uml.model.collaborations.collaborationinteractions.CollaborationImpl;
import com.topcoder.uml.model.commonbehavior.instances.Stimulus;
import com.topcoder.uml.model.commonbehavior.instances.StimulusImpl;
import com.topcoder.uml.model.commonbehavior.links.Link;
import com.topcoder.uml.model.commonbehavior.links.LinkImpl;
import com.topcoder.uml.model.core.ModelElement;

/**
 * <p>
 * This Junit Test suite contains the accuracy and failure test cases for {@link MessageUtil} class. The
 * accuracy test cases gives all valid inputs to the methods/constructors and checks for inconsistencies The
 * failure test cases gives all invalid inputs to the methods/constructors and checks for expected exceptions
 * </p>
 *
 * @author evilisneo
 * @version 1.0
 */
public class MessageUtilUnitTest extends TestCase {

    /**
     * MessageUtil instance to be used for the testing.
     */
    private MessageUtil messageUtil = null;

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
        messageUtil = new MessageUtil();
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
        messageUtil = null;
        Thread.sleep(50);
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
        return new TestSuite(MessageUtilUnitTest.class);
    }

    /**
     * <p>
     * Accuracy test for {@link MessageUtil#MessageUtil()} constructor.
     * </p>
     * <p>
     * Creates an instance and checks its instantiation and the variable initialization.
     * </p>
     *
     * @throws Exception
     *             throw exception to JUnit.
     */
    public void test_accuracy_MessageUtil() throws Exception {
        // check for null
        assertNotNull("MessageUtil creation failed", messageUtil);
    }

    /**
     * <p>
     * Accuracy test for {@link MessageUtil#addStimulusToCollaboration(Stimulus)} method.
     * </p>
     * <p>
     * Checks whether all the required details of stimulus are added to the collaboration.
     * </p>
     *
     * @throws Exception
     *             throw exception to JUnit.
     */
    public void test_accuracy_addStimulusToCollaboration() throws Exception {
        Stimulus stimulus = new StimulusImpl();
        Collaboration collaboration = new CollaborationImpl();
        stimulus.setNamespace(collaboration);
        Link link = new LinkImpl();
        stimulus.setCommunicationLink(link);
        CollaborationInstanceSet collaborationInstanceSet = new CollaborationInstanceSetImpl();
        CollaborationInstanceSet collaborationInstanceSet1 = new CollaborationInstanceSetImpl();
        collaboration.addCollaborationInstanceSet(collaborationInstanceSet);
        collaboration.addCollaborationInstanceSet(collaborationInstanceSet1);
        messageUtil.addStimulusToCollaboration(stimulus);
        // check whether the stimulus is added to the owned element of namespace
        assertEquals("addStimulusToCollaboration failed", new ArrayList<ModelElement>(collaboration
            .getOwnedElements()).get(0), stimulus);
        // check whether the communication link is set to the participatory link.
        assertEquals("addStimulusToCollaboration failed", new ArrayList<ModelElement>(collaborationInstanceSet
            .getParticipatingLinks()).get(0), link);
        assertEquals("addStimulusToCollaboration failed", new ArrayList<ModelElement>(collaborationInstanceSet1
            .getParticipatingLinks()).get(0), link);
    }

    /**
     * <p>
     * Failure test for {@link MessageUtil#addStimulusToCollaboration(Stimulus)} method.
     * </p>
     * <p>
     * For the following inputs:
     * </p>
     *
     * <pre>
     *       Input
     *            Stimulus stimulus : null value
     * </pre>
     *
     * <p>
     * Expected {@link IllegalArgumentException}.
     * </p>
     *
     * @throws Exception
     *             throw exception to JUnit.
     */
    public void test_failure_addStimulusToCollaboration() throws Exception {
        try {
            messageUtil.addStimulusToCollaboration(null);
            fail("IllegalArgumentException Expected.");
        } catch (IllegalArgumentException e) {
            // Check for the expected error message
            assertEquals("The Exception message for IllegalArgumentException is wrong", e.getMessage(),
                "stimulus in MessageUtil#addStimulusToCollaboration should not be null.");
        }
    }

    /**
     * <p>
     * Accuracy test for {@link MessageUtil#removeStimulusFromCollaboration(Stimulus)} method.
     * </p>
     * <p>
     * Checks whether all the required details are removed from the stimulus and collaboration.
     * </p>
     *
     * @throws Exception
     *             throw exception to JUnit.
     */
    public void test_accuracy_removeStimulusFromCollaboration() throws Exception {
        Stimulus stimulus = new StimulusImpl();
        Collaboration collaboration = new CollaborationImpl();
        stimulus.setNamespace(collaboration);
        Link link = new LinkImpl();
        stimulus.setCommunicationLink(link);
        CollaborationInstanceSet collaborationInstanceSet = new CollaborationInstanceSetImpl();
        CollaborationInstanceSet collaborationInstanceSet1 = new CollaborationInstanceSetImpl();
        collaboration.addCollaborationInstanceSet(collaborationInstanceSet);
        collaboration.addCollaborationInstanceSet(collaborationInstanceSet1);
        collaboration.addOwnedElement(stimulus);
        collaborationInstanceSet.addParticipatingLink(link);
        collaborationInstanceSet1.addParticipatingLink(link);
        messageUtil.removeStimulusFromCollaboration(stimulus);
        // check whether the stimulus is removed from the owned element of namespace
        assertEquals("removeStimulusFromCollaboration failed", new ArrayList<ModelElement>(collaboration
            .getOwnedElements()).size(), 0);
        // check whether the communication link is removed from the participatory link.
        assertEquals("removeStimulusFromCollaboration failed", new ArrayList<ModelElement>(
            collaborationInstanceSet.getParticipatingLinks()).size(), 0);
        assertEquals("removeStimulusFromCollaboration failed", new ArrayList<ModelElement>(
            collaborationInstanceSet1.getParticipatingLinks()).size(), 0);
    }

    /**
     * <p>
     * Failure test for {@link MessageUtil#removeStimulusFromCollaboration(Stimulus)} method.
     * </p>
     * <p>
     * For the following inputs:
     * </p>
     *
     * <pre>
     *       Input
     *            Stimulus stimulus : null value
     * </pre>
     *
     * <p>
     * Expected {@link IllegalArgumentException}.
     * </p>
     *
     * @throws Exception
     *             throw exception to JUnit.
     */
    public void test_failure_removeStimulusFromCollaboration() throws Exception {
        try {
            messageUtil.removeStimulusFromCollaboration(null);
            fail("IllegalArgumentException Expected.");
        } catch (IllegalArgumentException e) {
            // Check for the expected error message
            assertEquals("The Exception message for IllegalArgumentException is wrong", e.getMessage(),
                "stimulus in MessageUtil#removeStimulusFromCollaboration should not be null.");
        }
    }

    /**
     * <p>
     * Accuracy test for {@link MessageUtil#addStimulusToClipboard(Stimulus, Clipboard)} method.
     * </p>
     * <p>
     * Checks whether the added content is correct.
     * </p>
     *
     * @throws Exception
     *             throw exception to JUnit.
     */
    public void test_accuracy_addStimulusToClipboard() throws Exception {
        messageUtil.addStimulusToClipboard(TestHelper.getAsynchronousMessage(), Toolkit.getDefaultToolkit()
            .getSystemClipboard());
        assertTrue("execute failed", messageUtil.checkAsynchronousMessage((Stimulus) Toolkit.getDefaultToolkit()
            .getSystemClipboard().getContents(null).getTransferData(
                CollaborationTransfer.ASYNCHRONOUS_MESSAGE_FLAVOR)));
    }

    /**
     * <p>
     * Failure test for {@link MessageUtil#addStimulusToClipboard(Stimulus, Clipboard)} method.
     * </p>
     * <p>
     * For the following inputs:
     * </p>
     *
     * <pre>
     *       Input
     *            Stimulus stimulus : null value
     *            Clipboard clipboard : Valid value
     * </pre>
     *
     * <p>
     * Expected {@link IllegalArgumentException}.
     * </p>
     *
     * @throws Exception
     *             throw exception to JUnit.
     */
    public void test_failure_addStimulusToClipboard() throws Exception {
        try {
            messageUtil.addStimulusToClipboard(null, Toolkit.getDefaultToolkit().getSystemClipboard());
            fail("IllegalArgumentException Expected.");
        } catch (IllegalArgumentException e) {
            // Check for the expected error message
            assertEquals("The Exception message for IllegalArgumentException is wrong", e.getMessage(),
                "stimulus in MessageUtil#addStimulusToClipboard should not be null.");
        }
    }

    /**
     * <p>
     * Failure test for {@link MessageUtil#addStimulusToClipboard(Stimulus, Clipboard)} method.
     * </p>
     * <p>
     * For the following inputs:
     * </p>
     *
     * <pre>
     *       Input
     *            Stimulus stimulus : Valid value
     *            Clipboard clipboard : null value
     * </pre>
     *
     * <p>
     * Expected {@link IllegalArgumentException}.
     * </p>
     *
     * @throws Exception
     *             throw exception to JUnit.
     */
    public void test_failure_addStimulusToClipboard1() throws Exception {
        try {
            messageUtil.addStimulusToClipboard(TestHelper.getAsynchronousMessage(), null);
            fail("IllegalArgumentException Expected.");
        } catch (IllegalArgumentException e) {
            // Check for the expected error message
            assertEquals("The Exception message for IllegalArgumentException is wrong", e.getMessage(),
                "clipboard in MessageUtil#addStimulusToClipboard should not be null.");
        }
    }

    /**
     * <p>
     * Accuracy test for {@link MessageUtil#copyStimulus(Stimulus)} method.
     * </p>
     * <p>
     * Checks whether new instance of the stimulus is returned and all the required attributes of the stimulus
     * are properly set.
     * </p>
     *
     * @throws Exception
     *             throw exception to JUnit.
     */
    public void test_accuracy_copyStimulus() throws Exception {
        Stimulus stimulus = new StimulusImpl();
        // FIXME complete this
        assertNotSame("copyStimulus failed", messageUtil.copyStimulus(stimulus), stimulus);
    }

    /**
     * <p>
     * Failure test for {@link MessageUtil#copyStimulus(Stimulus)} method.
     * </p>
     * <p>
     * For the following inputs:
     * </p>
     *
     * <pre>
     *       Input
     *            Stimulus stimulus : null value
     * </pre>
     *
     * <p>
     * Expected {@link IllegalArgumentException}.
     * </p>
     *
     * @throws Exception
     *             throw exception to JUnit.
     */
    public void test_failure_copyStimulus() throws Exception {
        try {
            messageUtil.copyStimulus(null);
            fail("IllegalArgumentException Expected.");
        } catch (IllegalArgumentException e) {
            // Check for the expected error message
            assertEquals("The Exception message for IllegalArgumentException is wrong", e.getMessage(),
                "stimulus in MessageUtil#copyStimulus should not be null.");
        }
    }

    /**
     * <p>
     * Accuracy test for {@link MessageUtil#checkStimulusNamespace(Stimulus)} method.
     * </p>
     * <p>
     * Checks whether true is returned if the namespace contains the stimulus.
     * </p>
     *
     * @throws Exception
     *             throw exception to JUnit.
     */
    public void test_accuracy_checkStimulusNamespace() throws Exception {
        Stimulus stimulus = new StimulusImpl();
        Collaboration collaboration = new CollaborationImpl();
        stimulus.setNamespace(collaboration);
        collaboration.addOwnedElement(stimulus);
        assertTrue("checkStimulusNamespace failed", messageUtil.checkStimulusNamespace(stimulus));
    }

    /**
     * <p>
     * Accuracy test for {@link MessageUtil#checkStimulusNamespace(Stimulus)} method.
     * </p>
     * <p>
     * Checks whether false is returned if the namespace does not contain the stimulus.
     * </p>
     *
     * @throws Exception
     *             throw exception to JUnit.
     */
    public void test_accuracy_checkStimulusNamespace1() throws Exception {
        Stimulus stimulus = new StimulusImpl();
        stimulus.setNamespace(new CollaborationImpl());
        assertFalse("checkStimulusNamespace failed", messageUtil.checkStimulusNamespace(stimulus));
    }

    /**
     * <p>
     * Failure test for {@link MessageUtil#checkStimulusNamespace(Stimulus)} method.
     * </p>
     * <p>
     * For the following inputs:
     * </p>
     *
     * <pre>
     *       Input
     *            Stimulus stimulus : null value
     * </pre>
     *
     * <p>
     * Expected {@link IllegalArgumentException}.
     * </p>
     *
     * @throws Exception
     *             throw exception to JUnit.
     */
    public void test_failure_checkStimulusNamespace() throws Exception {
        try {
            messageUtil.checkStimulusNamespace(null);
            fail("IllegalArgumentException Expected.");
        } catch (IllegalArgumentException e) {
            // Check for the expected error message
            assertEquals("The Exception message for IllegalArgumentException is wrong", e.getMessage(),
                "stimulus in MessageUtil#checkStimulusNamespace should not be null.");
        }
    }

    /**
     * <p>
     * Accuracy test for {@link MessageUtil#checkCreateMessage(Stimulus)} method.
     * </p>
     * <p>
     * Checks whether true is returned for the correct message type.
     * </p>
     *
     * @throws Exception
     *             throw exception to JUnit.
     */
    public void test_accuracy_checkCreateMessage() throws Exception {
        assertTrue("checkCreateMessage failed", messageUtil.checkCreateMessage(TestHelper.getCreateMessage()));
    }

    /**
     * <p>
     * Accuracy test for {@link MessageUtil#checkCreateMessage(Stimulus)} method.
     * </p>
     * <p>
     * Checks whether false is returned for incorrect message type.
     * </p>
     *
     * @throws Exception
     *             throw exception to JUnit.
     */
    public void test_accuracy_checkCreateMessage1() throws Exception {
        assertFalse("checkCreateMessage failed", messageUtil.checkCreateMessage(TestHelper
            .getAsynchronousMessage()));
    }

    /**
     * <p>
     * Failure test for {@link MessageUtil#checkCreateMessage(Stimulus)} method.
     * </p>
     * <p>
     * For the following inputs:
     * </p>
     *
     * <pre>
     *       Input
     *            Stimulus stimulus : null value
     * </pre>
     *
     * <p>
     * Expected {@link IllegalArgumentException}.
     * </p>
     *
     * @throws Exception
     *             throw exception to JUnit.
     */
    public void test_failure_checkCreateMessage() throws Exception {
        try {
            messageUtil.checkCreateMessage(null);
            fail("IllegalArgumentException Expected.");
        } catch (IllegalArgumentException e) {
            // Check for the expected error message
            assertEquals("The Exception message for IllegalArgumentException is wrong", e.getMessage(),
                "stimulus in MessageUtil#checkCreateMessage should not be null.");
        }
    }

    /**
     * <p>
     * Accuracy test for {@link MessageUtil#checkSynchronousMessage(Stimulus)} method.
     * </p>
     * <p>
     * Checks whether true is returned for the correct message type.
     * </p>
     *
     * @throws Exception
     *             throw exception to JUnit.
     */
    public void test_accuracy_checkSynchronousMessage() throws Exception {
        assertTrue("checkSynchronousMessage failed", messageUtil.checkSynchronousMessage(TestHelper
            .getSynchronousMessage()));
    }

    /**
     * <p>
     * Accuracy test for {@link MessageUtil#checkSynchronousMessage(Stimulus)} method.
     * </p>
     * <p>
     * Checks whether false is returned for incorrect message type.
     * </p>
     *
     * @throws Exception
     *             throw exception to JUnit.
     */
    public void test_accuracy_checkSynchronousMessage1() throws Exception {
        assertFalse("checkSynchronousMessage failed", messageUtil.checkSynchronousMessage(TestHelper
            .getAsynchronousMessage()));
    }

    /**
     * <p>
     * Failure test for {@link MessageUtil#checkSynchronousMessage(Stimulus)} method.
     * </p>
     * <p>
     * For the following inputs:
     * </p>
     *
     * <pre>
     *       Input
     *            Stimulus stimulus : null value
     * </pre>
     *
     * <p>
     * Expected {@link IllegalArgumentException}.
     * </p>
     *
     * @throws Exception
     *             throw exception to JUnit.
     */
    public void test_failure_checkSynchronousMessage() throws Exception {
        try {
            messageUtil.checkSynchronousMessage(null);
            fail("IllegalArgumentException Expected.");
        } catch (IllegalArgumentException e) {
            // Check for the expected error message
            assertEquals("The Exception message for IllegalArgumentException is wrong", e.getMessage(),
                "stimulus in MessageUtil#checkSynchronousMessage should not be null.");
        }
    }

    /**
     * <p>
     * Accuracy test for {@link MessageUtil#checkAsynchronousMessage(Stimulus)} method.
     * </p>
     * <p>
     * Checks whether true is returned for the correct message type.
     * </p>
     *
     * @throws Exception
     *             throw exception to JUnit.
     */
    public void test_accuracy_checkAsynchronousMessage() throws Exception {
        assertTrue("checkAsynchronousMessage failed", messageUtil.checkAsynchronousMessage(TestHelper
            .getAsynchronousMessage()));
    }

    /**
     * <p>
     * Accuracy test for {@link MessageUtil#checkAsynchronousMessage(Stimulus)} method.
     * </p>
     * <p>
     * Checks whether false is returned for incorrect message type.
     * </p>
     *
     * @throws Exception
     *             throw exception to JUnit.
     */
    public void test_accuracy_checkAsynchronousMessage1() throws Exception {
        assertFalse("checkAsynchronousMessage failed", messageUtil.checkAsynchronousMessage(TestHelper
            .getSendSignalMessage()));
    }

    /**
     * <p>
     * Failure test for {@link MessageUtil#checkAsynchronousMessage(Stimulus)} method.
     * </p>
     * <p>
     * For the following inputs:
     * </p>
     *
     * <pre>
     *       Input
     *            Stimulus stimulus : null value
     * </pre>
     *
     * <p>
     * Expected {@link IllegalArgumentException}.
     * </p>
     *
     * @throws Exception
     *             throw exception to JUnit.
     */
    public void test_failure_checkAsynchronousMessage() throws Exception {
        try {
            messageUtil.checkAsynchronousMessage(null);
            fail("IllegalArgumentException Expected.");
        } catch (IllegalArgumentException e) {
            // Check for the expected error message
            assertEquals("The Exception message for IllegalArgumentException is wrong", e.getMessage(),
                "stimulus in MessageUtil#checkAsynchronousMessage should not be null.");
        }
    }

    /**
     * <p>
     * Accuracy test for {@link MessageUtil#checkSendSignalMessage(Stimulus)} method.
     * </p>
     * <p>
     * Checks whether true is returned for the correct message type.
     * </p>
     *
     * @throws Exception
     *             throw exception to JUnit.
     */
    public void test_accuracy_checkSendSignalMessage() throws Exception {
        assertTrue("checkSendSignalMessage failed", messageUtil.checkSendSignalMessage(TestHelper
            .getSendSignalMessage()));
    }

    /**
     * <p>
     * Accuracy test for {@link MessageUtil#checkSendSignalMessage(Stimulus)} method.
     * </p>
     * <p>
     * Checks whether false is returned for incorrect message type.
     * </p>
     *
     * @throws Exception
     *             throw exception to JUnit.
     */
    public void test_accuracy_checkSendSignalMessage1() throws Exception {
        assertFalse("checkSendSignalMessage failed", messageUtil.checkSendSignalMessage(TestHelper
            .getReturnMessage()));
    }

    /**
     * <p>
     * Failure test for {@link MessageUtil#checkSendSignalMessage(Stimulus)} method.
     * </p>
     * <p>
     * For the following inputs:
     * </p>
     *
     * <pre>
     *       Input
     *            Stimulus stimulus : null value
     * </pre>
     *
     * <p>
     * Expected {@link IllegalArgumentException}.
     * </p>
     *
     * @throws Exception
     *             throw exception to JUnit.
     */
    public void test_failure_checkSendSignalMessage() throws Exception {
        try {
            messageUtil.checkSendSignalMessage(null);
            fail("IllegalArgumentException Expected.");
        } catch (IllegalArgumentException e) {
            // Check for the expected error message
            assertEquals("The Exception message for IllegalArgumentException is wrong", e.getMessage(),
                "stimulus in MessageUtil#checkSendSignalMessage should not be null.");
        }
    }

    /**
     * <p>
     * Accuracy test for {@link MessageUtil#checkReturnMessage(Stimulus)} method.
     * </p>
     * <p>
     * Checks whether false is returned for incorrect message type.
     * </p>
     *
     * @throws Exception
     *             throw exception to JUnit.
     */
    public void test_accuracy_checkReturnMessage() throws Exception {
        assertFalse("checkReturnMessage failed", messageUtil.checkReturnMessage(TestHelper.getCreateMessage()));
    }

    /**
     * <p>
     * Failure test for {@link MessageUtil#checkReturnMessage(Stimulus)} method.
     * </p>
     * <p>
     * For the following inputs:
     * </p>
     *
     * <pre>
     *       Input
     *            Stimulus stimulus : null value
     * </pre>
     *
     * <p>
     * Expected {@link IllegalArgumentException}.
     * </p>
     *
     * @throws Exception
     *             throw exception to JUnit.
     */
    public void test_failure_checkReturnMessage() throws Exception {
        try {
            messageUtil.checkReturnMessage(null);
            fail("IllegalArgumentException Expected.");
        } catch (IllegalArgumentException e) {
            // Check for the expected error message
            assertEquals("The Exception message for IllegalArgumentException is wrong", e.getMessage(),
                "stimulus in MessageUtil#checkReturnMessage should not be null.");
        }
    }
}
