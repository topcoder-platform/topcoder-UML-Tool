/*
 * Copyright (C) 2007 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.umltool.xmiconverters.poseidon5.model.impl;

import com.topcoder.uml.model.collaborations.collaborationinteractions.Collaboration;
import com.topcoder.uml.model.core.AttributeImpl;

import com.topcoder.umltool.xmiconverters.poseidon5.model.Interaction;
import com.topcoder.umltool.xmiconverters.poseidon5.model.Lifeline;
import com.topcoder.umltool.xmiconverters.poseidon5.model.Message;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;


/**
 * <p>
 * Unit tests for <code>InteractionImpl</code> class.
 * </p>
 *
 * @author zhengjuyu
 * @version 1.0
 */
public class InteractionImplUnitTest extends TestCase {
    /**
     * <p>Returns the test suite of this class.</p>
     *
     * @return the test suite of this class.
     */
    public static Test suite() {
        return new TestSuite(InteractionImplUnitTest.class);
    }

    /**
     * <p>
     * Accuracy test for <code>InteractionImpl()</code>.
     * </p>
     */
    public void testCtor() {
        Interaction interaction = new InteractionImpl();
        assertNotNull("Unable to create InteractionImpl instance.", interaction);
    }

    /**
     * <p>
     * Accuracy test for <code>toTCUMLElement()</code>.
     * Verify that whether the Collaboration is transformed, and whether the Message
     * and Lifeline are transformed and added to the Collaboration's ownedElements.
     * </p>
     */
    public void testTCUMLElement1() {
        Interaction interaction = new InteractionImpl();

        Lifeline line = new LifelineImpl();
        line.setRepresents(new AttributeImpl());
        interaction.addLifeline(line);

        Message msg = new MessageImpl();
        msg.setReceiveEvent(new EventOccurrenceImpl());
        interaction.addMessage(msg);

        Collaboration collaboration = interaction.toTCUMLElement();
        assertNotNull("Unable to transform to Collaboration.", collaboration);

        assertEquals("There should be a collaboration instance set.", 1,
            collaboration.getCollaborationInstanceSets().size());
        assertEquals("There should 2 ownedelements.", 2,
            collaboration.getOwnedElements().size());
    }

    /**
     * <p>
     * Accuracy test for <code>toTCUMLElement()</code>.
     * Verify that toTCUMLElement() should always return the same instance.
     * </p>
     */
    public void testTCUMLElement2() {
        Interaction interaction = new InteractionImpl();

        Lifeline line = new LifelineImpl();
        line.setRepresents(new AttributeImpl());
        interaction.addLifeline(line);

        Message msg = new MessageImpl();
        msg.setReceiveEvent(new EventOccurrenceImpl());
        interaction.addMessage(msg);

        assertEquals("The toTCUMLElement should always return the same instance.",
            interaction.toTCUMLElement(), interaction.toTCUMLElement());
    }

    /**
     * <p>
     * Accuracy test for <code>clearLifelines()</code>.
     * </p>
     */
    public void testClearLifelines() {
        Interaction interaction = new InteractionImpl();

        interaction.addLifeline(new LifelineImpl());
        interaction.addLifeline(new LifelineImpl());

        assertEquals("The Lifelines has 2 elements now.", 2,
            interaction.getLifelines().size());

        interaction.clearLifelines();
        assertEquals("The Lifeline should be cleared.", 0,
            interaction.getLifelines().size());

        //It should process successfully
        interaction.clearLifelines();
    }

    /**
     * <p>
     * Accuracy test for <code>addLifeline(Lifeline)</code>.
     * </p>
     */
    public void testAddLifeline() {
        Interaction interaction = new InteractionImpl();

        assertTrue("The Lifelines should be empty as default.",
            interaction.getLifelines().isEmpty());

        interaction.addLifeline(new LifelineImpl());
        assertEquals("The Lifeline's size is 1.", 1,
            interaction.getLifelines().size());

        interaction.addLifeline(new LifelineImpl());
        assertEquals("The Lifeline's size is 2.", 2,
            interaction.getLifelines().size());

        Lifeline line = new LifelineImpl();

        //duplicate line is allowed
        interaction.addLifeline(line);
        interaction.addLifeline(line);

        assertEquals("The Lifelines should have 4 elements.", 4,
            interaction.getLifelines().size());
    }

    /**
     * <p>
     * Failure test for <code>addLifeline(Lifeline)</code>.
     * </p>
     *
     * <p>
     * Failure cause: If the lifeline is null, IllegalArgumentException is expected.
     * </p>
     */
    public void testAddLifeline_Failure() {
        try {
            Interaction interaction = new InteractionImpl();
            interaction.addLifeline(null);

            fail("IllegalArgumentException is expected.");
        } catch (IllegalArgumentException e) {
            //success
        }
    }

    /**
     * <p>
     * Accuracy test for <code>removeLifeline(Lifeline)</code>.
     * </p>
     */
    public void testRemoveLifeline() {
        Interaction interaction = new InteractionImpl();

        //It should process successfully
        interaction.removeLifeline(new LifelineImpl());

        Lifeline line = new LifelineImpl();
        interaction.addLifeline(line);
        interaction.addLifeline(new LifelineImpl());

        assertEquals("The Lifelines should have 2 elements.", 2,
            interaction.getLifelines().size());

        interaction.removeLifeline(line);
        assertEquals("The lifeline should be removed.", 1,
            interaction.getLifelines().size());

        //The lifeline to be removed doesn't exist.
        interaction.removeLifeline(new LifelineImpl());
        assertEquals("The lifeline should not be removed.", 1,
            interaction.getLifelines().size());
    }

    /**
     * <p>
     * Failure test for <code>removeLifeline(Lifeline)</code>.
     * </p>
     *
     * <p>
     * Failure cause: If the lifeline is null, IllegalArgumentException is expected.
     * </p>
     */
    public void testRemoveLifeline_Failure() {
        try {
            Interaction interaction = new InteractionImpl();
            interaction.removeLifeline(null);

            fail("IllegalArgumentException is expected.");
        } catch (IllegalArgumentException e) {
            //success
        }
    }

    /**
     * <p>
     * Accuracy test for <code>getLifelines()</code>.
     * </p>
     */
    public void testGetLifelines() {
        Interaction interaction = new InteractionImpl();

        assertEquals("The default lifelines is empty.", 0,
            interaction.getLifelines().size());

        interaction.addLifeline(new LifelineImpl());
        assertEquals("The Lifeline's size is 1.", 1,
            interaction.getLifelines().size());

        //It's a shadow copy, so the original should not be changed.
        interaction.getLifelines().clear();
        assertEquals("The Lifeline's size is 1.", 1,
            interaction.getLifelines().size());
    }

    /**
     * <p>
     * Accuracy test for <code>clearMessages()</code>.
     * </p>
     */
    public void testClearMessages() {
        Interaction interaction = new InteractionImpl();

        interaction.addMessage(new MessageImpl());
        interaction.addMessage(new MessageImpl());

        assertEquals("The Messages has 2 elements now.", 2,
            interaction.getMessages().size());

        interaction.clearMessages();
        assertEquals("The Message should be cleared.", 0,
            interaction.getMessages().size());

        //It should process successfully
        interaction.clearMessages();
    }

    /**
     * <p>
     * Accuracy test for <code>addMessage(Message)</code>.
     * </p>
     */
    public void testAddMessage() {
        Interaction interaction = new InteractionImpl();

        assertTrue("The Messages should be empty as default.",
            interaction.getMessages().isEmpty());

        interaction.addMessage(new MessageImpl());
        assertEquals("The Message's size is 1.", 1,
            interaction.getMessages().size());

        interaction.addMessage(new MessageImpl());
        assertEquals("The Message's size is 2.", 2,
            interaction.getMessages().size());

        Message msg = new MessageImpl();

        //duplicate message is allowed
        interaction.addMessage(msg);
        interaction.addMessage(msg);

        assertEquals("The Messages should have 4 elements.", 4,
            interaction.getMessages().size());
    }

    /**
     * <p>
     * Failure test for <code>addMessage(Message)</code>.
     * </p>
     *
     * <p>
     * Failure cause: If the message is null, IllegalArgumentException is expected.
     * </p>
     */
    public void testAddMessage_Failure() {
        try {
            Interaction interaction = new InteractionImpl();
            interaction.addMessage(null);

            fail("IllegalArgumentException is expected.");
        } catch (IllegalArgumentException e) {
            //success
        }
    }

    /**
     * <p>
     * Accuracy test for <code>removeMessage(Message)</code>.
     * </p>
     */
    public void testRemoveMessage() {
        Interaction interaction = new InteractionImpl();

        //It should process successfully
        interaction.removeMessage(new MessageImpl());

        Message msg = new MessageImpl();
        interaction.addMessage(msg);
        interaction.addMessage(new MessageImpl());

        assertEquals("The Messages should have 2 elements.", 2,
            interaction.getMessages().size());

        interaction.removeMessage(msg);
        assertEquals("The message should be removed.", 1,
            interaction.getMessages().size());

        //The message to be removed doesn't exist.
        interaction.removeMessage(new MessageImpl());
        assertEquals("The message should not be removed.", 1,
            interaction.getMessages().size());
    }

    /**
     * <p>
     * Failure test for <code>removeMessage(Message)</code>.
     * </p>
     *
     * <p>
     * Failure cause: If the message is null, IllegalArgumentException is expected.
     * </p>
     */
    public void testRemoveMessage_Failure() {
        try {
            Interaction interaction = new InteractionImpl();
            interaction.removeMessage(null);

            fail("IllegalArgumentException is expected.");
        } catch (IllegalArgumentException e) {
            //success
        }
    }

    /**
     * <p>
     * Accuracy test for <code>getMessages()</code>.
     * </p>
     */
    public void testGetMessages() {
        Interaction interaction = new InteractionImpl();

        assertEquals("The default Messages is empty.", 0,
            interaction.getMessages().size());

        interaction.addMessage(new MessageImpl());
        assertEquals("The Message's size is 1.", 1,
            interaction.getMessages().size());

        //It's a shadow copy, so the original should not be changed.
        interaction.getMessages().clear();
        assertEquals("The Message's size is 1.", 1,
            interaction.getMessages().size());
    }
}
