/*
 * Copyright (C) 2007 TopCoder Inc., All Rights Reserved.
 */

package com.topcoder.umltool.xmiconverters.poseidon5.accuracytests;

import java.util.Collection;
import java.util.Iterator;

import junit.framework.TestCase;

import com.topcoder.uml.model.collaborations.collaborationinstances.CollaborationInstanceSet;
import com.topcoder.uml.model.collaborations.collaborationinteractions.Collaboration;
import com.topcoder.uml.model.commonbehavior.instances.Instance;

import com.topcoder.uml.model.commonbehavior.links.Link;
import com.topcoder.uml.model.core.ModelElement;

import com.topcoder.umltool.xmiconverters.poseidon5.model.Interaction;
import com.topcoder.umltool.xmiconverters.poseidon5.model.Lifeline;
import com.topcoder.umltool.xmiconverters.poseidon5.model.Message;
import com.topcoder.umltool.xmiconverters.poseidon5.model.impl.InteractionImpl;
import com.topcoder.umltool.xmiconverters.poseidon5.model.impl.LifelineImpl;
import com.topcoder.umltool.xmiconverters.poseidon5.model.impl.MessageImpl;


/**
 * Accuracy tests for <code>InteractionImpl</code>.</p>
 *
 * @author RachaelLCook
 * @version 1.0
 */
public class InteractionImplTests extends TestCase {
    /**
     * <p>Testing of InteractionImpl constructor.</p>
     * <p>Class InteractionImpl will be used in XMIReader, so it must implement ModelElement
     *    interface. Also messages and lifelines collections must be initially initialized and
     *    empty.</p>
     */
    public void test_Ctor() {
        Interaction intr = new InteractionImpl();
        assertTrue("Interaction doesn't implement ModelElement", intr instanceof ModelElement);

        assertNotNull("Messages collection wasn't initialized", intr.getMessages());
        assertEquals("Interaction initially contains messages", 0, intr.getMessages().size());
        assertNotNull("Lifelines collection wasn't initialized", intr.getLifelines());
        assertEquals("Interaction initially contains lifelines", 0, intr.getLifelines().size());
    }

    /**
     * Testing of addLifeline method.
     */
    public void test_addLifeline() {
        Interaction intr = new InteractionImpl();
        Lifeline lifeline1 = new LifelineImpl();
        intr.addLifeline(lifeline1);
        assertTrue("Lifeline 1 wasn't added", intr.getLifelines().contains(lifeline1));
        assertEquals("Some garbage after 1st adding", 1, intr.getLifelines().size());

        Lifeline lifeline2 = new LifelineImpl();
        intr.addLifeline(lifeline2);
        assertTrue("Lifeline 2 wasn't added", intr.getLifelines().contains(lifeline2));
        assertTrue("Lifeline 1 disappeared after second addition", intr.getLifelines().contains(lifeline1));
        assertEquals("Some garbage after 2nd adding", 2, intr.getLifelines().size());

        intr.addLifeline(lifeline1);
        assertEquals("Duplicate lifeline 1 wasn't added", 3, intr.getLifelines().size());
    }

    /**
     * Testing of removeLifeline method when there is only one lifeline in lifelines collection.
     */
    public void test_removeLifeline_Alone() {
        Interaction intr = new InteractionImpl();
        Lifeline lifeline = new LifelineImpl();
        intr.addLifeline(lifeline);
        intr.removeLifeline(lifeline);
        assertFalse("Lifeline wasn't removed", intr.getLifelines().contains(lifeline));
        assertEquals("Some garbage after 1st removing", 0, intr.getLifelines().size());
    }

    /**
     * Testing of removeLifeline method when there are many lifelines in lifelines collection.
     */
    public void test_removeLifeline_Many() {
        Interaction intr = new InteractionImpl();
        Lifeline lifeline1 = new LifelineImpl();
        Lifeline lifeline2 = new LifelineImpl();
        Lifeline lifeline3 = new LifelineImpl();
        intr.addLifeline(lifeline1);
        intr.addLifeline(lifeline2);

        intr.removeLifeline(lifeline3);
        assertEquals("Wrong size after unknown removing", 2, intr.getLifelines().size());
        assertTrue("Lifeline 1 accidentally removed as unknown", intr.getLifelines().contains(lifeline1));
        assertTrue("Lifeline 2 accidentally removed as unknown", intr.getLifelines().contains(lifeline2));

        intr.removeLifeline(lifeline1);
        assertFalse("Lifeline 1 wasn't removed", intr.getLifelines().contains(lifeline1));
        assertTrue("Lifeline 2 accidentally removed", intr.getLifelines().contains(lifeline2));
        assertEquals("Some garbage after 2nd removing", 1, intr.getLifelines().size());

        intr.removeLifeline(lifeline2);
        assertFalse("Lifeline 2 wasn't removed", intr.getLifelines().contains(lifeline2));
        assertEquals("Some garbage after 3rd removing", 0, intr.getLifelines().size());
    }

    /**
     * Testing of clearLifelines method.
     */
    public void test_clearLifelines() {
        Interaction intr = new InteractionImpl();
        intr.clearLifelines();
        assertEquals("Wrong size after clear empty", 0, intr.getLifelines().size());

        intr.addLifeline(new LifelineImpl());
        intr.clearLifelines();
        assertEquals("Wrong size after clear alone", 0, intr.getLifelines().size());

        intr.addLifeline(new LifelineImpl());
        intr.addLifeline(new LifelineImpl());
        intr.addLifeline(new LifelineImpl());
        intr.clearLifelines();
        assertEquals("Wrong size after clear many", 0, intr.getLifelines().size());
    }

    /**
     * Testing of addMessage method.
     */
    public void test_addMessage() {
        Interaction intr = new InteractionImpl();
        Message msg1 = new MessageImpl();
        intr.addMessage(msg1);
        assertTrue("Message 1 wasn't added", intr.getMessages().contains(msg1));
        assertEquals("Some garbage after 1st adding", 1, intr.getMessages().size());

        Message msg2 = new MessageImpl();
        intr.addMessage(msg2);
        assertTrue("Message 2 wasn't added", intr.getMessages().contains(msg2));
        assertTrue("Message 1 disappeared after second addition", intr.getMessages().contains(msg1));
        assertEquals("Some garbage after 2nd adding", 2, intr.getMessages().size());
    }

    /**
     * Testing of removeMessage method when there is only one message in messages collection.
     */
    public void test_removeMessage_Alone() {
        Interaction intr = new InteractionImpl();
        Message msg = new MessageImpl();
        intr.addMessage(msg);

        intr.removeMessage(msg);
        assertFalse("Message wasn't removed", intr.getMessages().contains(msg));
        assertEquals("Some garbage after 1st removing", 0, intr.getMessages().size());
    }

    /**
     * Testing of removeMessage method when there are many messages in messages collection.
     */
    public void test_removeMessage_Many() {
        Interaction intr = new InteractionImpl();
        Message msg1 = new MessageImpl();
        Message msg2 = new MessageImpl();
        Message msg3 = new MessageImpl();
        intr.addMessage(msg1);
        intr.addMessage(msg2);

        intr.removeMessage(msg3);
        assertEquals("Wrong size after unknown removing", 2, intr.getMessages().size());
        assertTrue("Message 1 accidentally removed as unknown", intr.getMessages().contains(msg1));
        assertTrue("Message 2 accidentally removed as unknown", intr.getMessages().contains(msg2));

        intr.removeMessage(msg1);
        assertFalse("Message 1 wasn't removed", intr.getMessages().contains(msg1));
        assertTrue("Message 2 accidentally removed", intr.getMessages().contains(msg2));
        assertEquals("Some garbage after 2nd removing", 1, intr.getMessages().size());

        intr.removeMessage(msg2);
        assertFalse("Message 2 wasn't removed", intr.getMessages().contains(msg2));
        assertEquals("Some garbage after 3rd removing", 0, intr.getMessages().size());
    }

    /**
     * Testing of clearMessages method.
     */
    public void test_clearMessages() {
        Interaction intr = new InteractionImpl();
        intr.clearMessages();
        assertEquals("Wrong size after clear empty", 0, intr.getMessages().size());

        intr.addMessage(new MessageImpl());
        intr.clearMessages();
        assertEquals("Wrong size after clear alone", 0, intr.getMessages().size());

        intr.addMessage(new MessageImpl());
        intr.addMessage(new MessageImpl());
        intr.addMessage(new MessageImpl());
        intr.clearMessages();
        assertEquals("Wrong size after clear many", 0, intr.getMessages().size());
    }

    /**
     * Get CollaborationInstanceSet instance from Collaboration instance with checking
     * that it exists there.
     *
     * @param collab   Collaboration instance to be surved
     * @return   CollaborationInstanceSet instance got from collaboration
     */
    private CollaborationInstanceSet getInstanceSet(Collaboration collab) {
        Collection<CollaborationInstanceSet> allInstSets = collab.getCollaborationInstanceSets();
        assertEquals("Wrong number of instance sets", 1, allInstSets.size());
        Iterator<CollaborationInstanceSet> iter = allInstSets.iterator();
        return iter.next();
    }

    /**
     * Testing of toTCUMLElement method when both collections in interaction are empty.
     */
    public void test_toTCUMLElement_Empty() {
        Interaction intr = new InteractionImpl();
        Collaboration collab = intr.toTCUMLElement();
        CollaborationInstanceSet cis = getInstanceSet(collab);
        assertNotNull("Instance set is null", cis);
        assertTrue("Wrong collaboration in instance set", cis.getCollaboration() == collab);
        assertEquals("Some owned elements were added", 0, collab.getOwnedElements().size());
        assertEquals("Some participating instances were added", 0, cis.getParticipatingInstances().size());
        assertEquals("Some participating links were added", 0, cis.getParticipatingLinks().size());

        assertTrue("Second convertion returned another collaboration", intr.toTCUMLElement() == collab);
    }

    /**
     * Testing of toTCUMLElement method when only lifelines collections is not empty.
     */
    public void test_toTCUMLElement_Lifelines() {
        Interaction intr = new InteractionImpl();
        Lifeline line1 = new LifelineImpl();
        Lifeline line2 = new LifelineImpl();
        intr.addLifeline(line1);
        intr.addLifeline(line2);

        Collaboration collab = intr.toTCUMLElement();
        CollaborationInstanceSet cis = getInstanceSet(collab);
        assertNotNull("Instance set is null", cis);
        Collection<ModelElement> allElems = collab.getOwnedElements();
        assertEquals("Wrong number of owned elements", 2, allElems.size());
        assertTrue("Object 1 wasn't added to owned", allElems.contains(line1.toTCUMLElement()));
        assertTrue("Object 2 wasn't added to owned", allElems.contains(line2.toTCUMLElement()));
        Collection<Instance> allInsts = cis.getParticipatingInstances();
        assertEquals("Wrong number of participating instances were added", 2, allInsts.size());
        assertTrue("Object 1 wasn't added to instances", allInsts.contains(line1.toTCUMLElement()));
        assertTrue("Object 2 wasn't added to instances", allInsts.contains(line2.toTCUMLElement()));
        assertEquals("Some participating links were added", 0, cis.getParticipatingLinks().size());
    }

    /**
     * Testing of toTCUMLElement method when only messages collections is not empty.
     */
    public void test_toTCUMLElement_Messages() {
        Interaction intr = new InteractionImpl();
        Message msg1 = new MessageImpl();
        Message msg2 = new MessageImpl();
        intr.addMessage(msg1);
        intr.addMessage(msg2);

        Collaboration collab = intr.toTCUMLElement();
        CollaborationInstanceSet cis = getInstanceSet(collab);
        assertNotNull("Instance set is null", cis);
        Collection<ModelElement> allElems = collab.getOwnedElements();
        assertEquals("Wrong number of owned elements", 2, allElems.size());
        assertTrue("Stimulus 1 wasn't added to owned", allElems.contains(msg1.toTCUMLStimulus()));
        assertTrue("Stimulus 2 wasn't added to owned", allElems.contains(msg2.toTCUMLStimulus()));
        Collection<Link> allLinks = cis.getParticipatingLinks();
        assertEquals("Wrong number of participating links were added", 2, allLinks.size());
        assertTrue("Link 1 wasn't added to instances", allLinks.contains(msg1.toTCUMLElement()));
        assertTrue("Link 2 wasn't added to instances", allLinks.contains(msg2.toTCUMLElement()));
        assertEquals("Some participating instances were added", 0, cis.getParticipatingInstances().size());
    }

    /**
     * Testing of toTCUMLElement method when both lifelines and messages collections are not empty.
     */
    public void test_toTCUMLElement_LifelinesAndMessages() {
        Interaction intr = new InteractionImpl();
        Lifeline line1 = new LifelineImpl();
        Lifeline line2 = new LifelineImpl();
        intr.addLifeline(line1);
        intr.addLifeline(line2);
        Message msg1 = new MessageImpl();
        Message msg2 = new MessageImpl();
        Message msg3 = new MessageImpl();
        intr.addMessage(msg1);
        intr.addMessage(msg2);
        intr.addMessage(msg3);

        Collaboration collab = intr.toTCUMLElement();
        CollaborationInstanceSet cis = getInstanceSet(collab);
        assertNotNull("Instance set is null", cis);
        Collection<ModelElement> allElems = collab.getOwnedElements();
        assertEquals("Wrong number of owned elements", 5, allElems.size());
        assertTrue("Object 1 wasn't added to owned", allElems.contains(line1.toTCUMLElement()));
        assertTrue("Object 2 wasn't added to owned", allElems.contains(line2.toTCUMLElement()));
        assertTrue("Stimulus 1 wasn't added to owned", allElems.contains(msg1.toTCUMLStimulus()));
        assertTrue("Stimulus 2 wasn't added to owned", allElems.contains(msg2.toTCUMLStimulus()));
        assertTrue("Stimulus 3 wasn't added to owned", allElems.contains(msg3.toTCUMLStimulus()));
        Collection<Instance> allInsts = cis.getParticipatingInstances();
        assertEquals("Wrong number of participating instances were added", 2, allInsts.size());
        assertTrue("Object 1 wasn't added to instances", allInsts.contains(line1.toTCUMLElement()));
        assertTrue("Object 2 wasn't added to instances", allInsts.contains(line2.toTCUMLElement()));
        Collection<Link> allLinks = cis.getParticipatingLinks();
        assertEquals("Wrong number of participating links were added", 3, allLinks.size());
        assertTrue("Link 1 wasn't added to instances", allLinks.contains(msg1.toTCUMLElement()));
        assertTrue("Link 2 wasn't added to instances", allLinks.contains(msg2.toTCUMLElement()));
        assertTrue("Link 3 wasn't added to instances", allLinks.contains(msg3.toTCUMLElement()));
    }
}
