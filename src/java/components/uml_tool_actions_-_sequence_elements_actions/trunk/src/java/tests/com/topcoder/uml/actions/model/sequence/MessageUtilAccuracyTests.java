/*
 * Copyright (C) 2006 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.uml.actions.model.sequence;

import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.util.ArrayList;

import com.topcoder.uml.actions.model.sequence.accuracytests.AccuracyTestHelper;
import com.topcoder.uml.actions.model.sequence.accuracytests.BaseTestCase;
import com.topcoder.uml.model.collaborations.collaborationinstances.CollaborationInstanceSet;
import com.topcoder.uml.model.collaborations.collaborationinstances.CollaborationInstanceSetImpl;
import com.topcoder.uml.model.collaborations.collaborationinteractions.Collaboration;
import com.topcoder.uml.model.collaborations.collaborationinteractions.CollaborationImpl;
import com.topcoder.uml.model.commonbehavior.instances.Stimulus;
import com.topcoder.uml.model.commonbehavior.instances.StimulusImpl;
import com.topcoder.uml.model.commonbehavior.links.Link;
import com.topcoder.uml.model.commonbehavior.links.LinkImpl;
import com.topcoder.uml.model.core.ModelElement;
import com.topcoder.uml.model.core.extensionmechanisms.TaggedValue;
import com.topcoder.uml.model.core.extensionmechanisms.TaggedValueImpl;

/**
 * <p>
 * Accuracy test for <code>MessageUtil</code> class.
 * </p>
 * @author FireIce
 * @version 1.0
 */
public class MessageUtilAccuracyTests extends BaseTestCase {

    /**
     * <p>
     * Represents the <code>MessageUtil</code> instance used in tests.
     * </p>
     */
    private MessageUtil messageUtil = new MessageUtil();

    /**
     * <p>
     * Accuracy test for <code>{@link MessageUtil#addStimulusToCollaboration(Stimulus)}</code> method.
     * </p>
     */
    public void testAddStimulusToCollaborationAccuracy() {
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
        assertEquals("addStimulusToCollaboration failed", new ArrayList<ModelElement>(collaboration.getOwnedElements())
            .get(0), stimulus);
        // check whether the communication link is set to the participatory link.
        assertEquals("addStimulusToCollaboration failed", new ArrayList<ModelElement>(collaborationInstanceSet
            .getParticipatingLinks()).get(0), link);
        assertEquals("addStimulusToCollaboration failed", new ArrayList<ModelElement>(collaborationInstanceSet1
            .getParticipatingLinks()).get(0), link);
    }

    /**
     * <p>
     * Accuracy test for {@link MessageUtil#removeStimulusFromCollaboration(Stimulus)} method.
     * </p>
     * @throws Exception
     *             throw exception to JUnit.
     */
    public void testRemoveStimulusFromCollaborationAccuracy() throws Exception {
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
        assertEquals("removeStimulusFromCollaboration failed", new ArrayList<ModelElement>(collaborationInstanceSet
            .getParticipatingLinks()).size(), 0);
        assertEquals("removeStimulusFromCollaboration failed", new ArrayList<ModelElement>(collaborationInstanceSet1
            .getParticipatingLinks()).size(), 0);
    }

    /**
     * <p>
     * Accuracy test for {@link MessageUtil#addStimulusToClipboard(Stimulus, Clipboard)} method.
     * </p>
     * @throws Exception
     *             throw exception to JUnit.
     */
    public void testAddStimulusToClipboardAccuracy() throws Exception {
        messageUtil.addStimulusToClipboard(AccuracyTestHelper.createStimulusForAsynchronousMessage(), Toolkit
            .getDefaultToolkit().getSystemClipboard());
        assertTrue("execute failed", messageUtil.checkAsynchronousMessage((Stimulus) Toolkit.getDefaultToolkit()
            .getSystemClipboard().getContents(null).getTransferData(CollaborationTransfer.ASYNCHRONOUS_MESSAGE_FLAVOR)));
    }

    /**
     * <p>
     * Accuracy test for {@link MessageUtil#copyStimulus(Stimulus)} method.
     * </p>
     */
    public void testCopyStimulusAccuracy() {
        Stimulus stimulus = new StimulusImpl();
        stimulus.setName("Hello");
        stimulus.setSpecification(true);
        TaggedValue taggedValue = new TaggedValueImpl();
        taggedValue.setDataValue("Data");
        taggedValue.setName("TopCoder");
        stimulus.addTaggedValue(taggedValue);
        Stimulus copiedStimulus = messageUtil.copyStimulus(stimulus);
        assertNotSame("copyStimulus failed", copiedStimulus, stimulus);
        assertEquals(stimulus.getName(), copiedStimulus.getName());
        assertTrue(copiedStimulus.isSpecification());
        assertEquals(stimulus.getTaggedValues().size(), copiedStimulus.getTaggedValues().size());
        TaggedValue copiedTaggedValue = copiedStimulus.getTaggedValues().toArray(new TaggedValue[0])[0];
        assertNotSame(taggedValue, copiedTaggedValue);
        assertNotNull("data value not copied", copiedTaggedValue.getDataValue());
        assertEquals("data value not copied", taggedValue.getDataValue(), copiedTaggedValue.getDataValue());
        assertNotNull("name not copied", copiedTaggedValue.getName());
        assertEquals("name not copied", taggedValue.getName(), copiedTaggedValue.getName());
    }

    /**
     * <p>
     * Accuracy test for {@link MessageUtil#checkStimulusNamespace(Stimulus)} method.
     * </p>
     */
    public void testCheckStimulusNamespaceAccuracy() {
        Stimulus stimulus = new StimulusImpl();
        Collaboration collaboration = new CollaborationImpl();
        stimulus.setNamespace(collaboration);
        collaboration.addOwnedElement(stimulus);
        assertTrue("checkStimulusNamespace failed", messageUtil.checkStimulusNamespace(stimulus));

        stimulus = new StimulusImpl();
        stimulus.setNamespace(new CollaborationImpl());
        assertFalse("checkStimulusNamespace failed", messageUtil.checkStimulusNamespace(stimulus));
    }

    /**
     * <p>
     * Accuracy test for {@link MessageUtil#checkCreateMessage(Stimulus)} method.
     * </p>
     */
    public void testCheckCreateMessageAccuracy() {
        assertTrue("checkCreateMessage failed", messageUtil.checkCreateMessage(AccuracyTestHelper
            .createStimulusForCreateMessage()));
        assertFalse("checkCreateMessage failed", messageUtil.checkCreateMessage(AccuracyTestHelper
            .createStimulusForAsynchronousMessage()));
    }

    /**
     * <p>
     * Accuracy test for {@link MessageUtil#checkReturnMessage(Stimulus)} method.
     * </p>
     */
    public void testCheckReturnMessageAccuracy() {
        assertTrue("checkReturnMessage failed", messageUtil.checkReturnMessage(AccuracyTestHelper
            .createStimulusForReturnMessage()));
        assertFalse("checkReturnMessage failed", messageUtil.checkReturnMessage(AccuracyTestHelper
            .createStimulusForAsynchronousMessage()));
    }

    /**
     * <p>
     * Accuracy test for {@link MessageUtil#checkSendSignalMessage(Stimulus)} method.
     * </p>
     */
    public void testCheckSendSignalMessageAccuracy() {
        assertTrue("checkSendSignalMessage failed", messageUtil.checkSendSignalMessage(AccuracyTestHelper
            .createStimulusForSendSignalMessage()));
        assertFalse("checkSendSignalMessage failed", messageUtil.checkSendSignalMessage(AccuracyTestHelper
            .createStimulusForAsynchronousMessage()));
    }

    /**
     * <p>
     * Accuracy test for {@link MessageUtil#checkSynchronousMessage(Stimulus)} method.
     * </p>
     */
    public void testCheckSynchronousMessageAccuracy() {
        assertTrue("checkSynchronousMessage failed", messageUtil.checkSynchronousMessage(AccuracyTestHelper
            .createStimulusForSynchronousMessage()));
        assertFalse("checkSynchronousMessage failed", messageUtil.checkSynchronousMessage(AccuracyTestHelper
            .createStimulusForAsynchronousMessage()));
    }

    /**
     * <p>
     * Accuracy test for {@link MessageUtil#checkAsynchronousMessage(Stimulus)} method.
     * </p>
     */
    public void testCheckAsynchronousMessageAccuracy() {
        assertTrue("checkAsynchronousMessage failed", messageUtil.checkAsynchronousMessage(AccuracyTestHelper
            .createStimulusForAsynchronousMessage()));
        assertFalse("checkAsynchronousMessage failed", messageUtil.checkAsynchronousMessage(AccuracyTestHelper
            .createStimulusForSynchronousMessage()));
    }
}
