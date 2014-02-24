/*
 * Copyright (C) 2007 TopCoder Inc., All Rights Reserved.
 */

package com.topcoder.umltool.xmiconverters.poseidon5.accuracytests;

import junit.framework.TestCase;

import com.topcoder.uml.model.actions.Action;
import com.topcoder.uml.model.actions.messagingactions.CallOperationAction;
import com.topcoder.uml.model.commonbehavior.instances.Stimulus;
import com.topcoder.uml.model.commonbehavior.links.Link;
import com.topcoder.uml.model.commonbehavior.procedure.Procedure;
import com.topcoder.uml.model.core.ModelElement;
import com.topcoder.uml.model.core.extensionmechanisms.Stereotype;
import com.topcoder.uml.model.core.extensionmechanisms.StereotypeImpl;
import com.topcoder.umltool.xmiconverters.poseidon5.model.EventOccurrence;
import com.topcoder.umltool.xmiconverters.poseidon5.model.ExecutionOccurrence;
import com.topcoder.umltool.xmiconverters.poseidon5.model.Message;
import com.topcoder.umltool.xmiconverters.poseidon5.model.impl.EventOccurrenceImpl;
import com.topcoder.umltool.xmiconverters.poseidon5.model.impl.ExecutionOccurrenceImpl;
import com.topcoder.umltool.xmiconverters.poseidon5.model.impl.MessageImpl;


/**
 * <p>Accuracy tests for the <code>MessageImpl</code> class.</p>
 *
 * @author RachaelLCook
 * @version 1.0
 */

public class MessageImplTests extends TestCase {
    /**
     * 'synchCall' value of the 'messageSort' property of Message.
     */
    private static final String MESSAGE_SORT_SYNCH_CALL = "synchCall";

    /**
     * 'asynchCall' value of the 'messageSort' property of Message.
     */
    private static final String MESSAGE_SORT_ASYNCH_CALL = "asynchCall";

    /**
     * Message name used in tests.
     */
    private static final String TEST_MESSAGE_NAME = "test_message";

    /**
     * <p>Testing of MessageImpl constructor.</p>
     * <p>Class MessageImpl will be used in XMIReader, so it must implement ModelElement
     *    interface. Also 'messageSort', 'receiveEvent' and 'sendEvent' properties must be
     *    null initially after creating.</p>
     */
    public void test_Ctor() {
        MessageImpl msg = new MessageImpl();
        assertTrue("ModelElement interface is not implemented", msg instanceof ModelElement);
        // Initial properties values
        assertNull("'messageSort' property is not null initially", msg.getMessageSort());
        assertNull("'receiveEvent' property is not null initially", msg.getReceiveEvent());
        assertNull("'sendEvent' property is not null initially", msg.getSendEvent());
    }

    /**
     * Testing of setReceiveEvent method.
     */
    public void test_setReceiveEvent() {
        Message msg = new MessageImpl();

        EventOccurrence eo1 = new EventOccurrenceImpl();
        msg.setReceiveEvent(eo1);
        assertTrue("setReceiveEvent failed to set the value", msg.getReceiveEvent() == eo1);
        EventOccurrence eo2 = new EventOccurrenceImpl();
        msg.setReceiveEvent(eo2);
        assertTrue("setReceiveEvent failed to change the value", msg.getReceiveEvent() == eo2);
    }

    /**
     * Testing of setSendEvent method.
     */
    public void test_setSendEvent() {
        Message msg = new MessageImpl();

        EventOccurrence eo1 = new EventOccurrenceImpl();
        msg.setSendEvent(eo1);
        assertTrue("setSendEvent failed to set the value", msg.getSendEvent() == eo1);
        EventOccurrence eo2 = new EventOccurrenceImpl();
        msg.setSendEvent(eo2);
        assertTrue("setSendEvent failed to change the value", msg.getSendEvent() == eo2);
    }

    /**
     * Testing of setMessageSort method.
     */
    public void test_setMessageSort() {
        Message msg = new MessageImpl();

        msg.setMessageSort(MESSAGE_SORT_SYNCH_CALL);
        assertEquals("setMessageSort failed to set the synch value", MESSAGE_SORT_SYNCH_CALL, msg.getMessageSort());
        msg.setMessageSort(MESSAGE_SORT_ASYNCH_CALL);
        assertEquals("setMessageSort failed to set the asynch value", MESSAGE_SORT_ASYNCH_CALL, msg.getMessageSort());
    }

    /**
     * Testing of toTCUMLElement method.
     */
    public void test_toTCUMLElement() {
        Message msg = new MessageImpl();
        Link lnk = msg.toTCUMLElement();
        assertEquals("Link has wrong number of connections linkEnd", 1, lnk.getConnections().size());
        assertTrue("LinkEnd doesn't connects to link", lnk.getConnections().get(0).getLink() == lnk);
        assertNull("Name is not null in not initialized message", lnk.getName());
        assertEquals("Link has wrong number of stimuli", 1, lnk.getStimuli().size());
        assertTrue("Link has wrong stimulus", lnk.getStimuli().contains(msg.toTCUMLStimulus()));
        assertEquals("Link for uninitialized message has stereotypes", 0, lnk.getStereotypes().size());
        assertTrue("Second convertion returned another link", msg.toTCUMLElement() == lnk);

        msg = new MessageImpl();
        msg.setName(TEST_MESSAGE_NAME);
        lnk = msg.toTCUMLElement();
        assertEquals("Wrong name in converted link", TEST_MESSAGE_NAME, lnk.getName());

        Stereotype st1 = new StereotypeImpl();
        Stereotype st2 = new StereotypeImpl();
        msg = new MessageImpl();
        msg.addStereotype(st1);
        msg.addStereotype(st2);
        lnk = msg.toTCUMLElement();
        assertEquals("Link contains wrong number of stereotypes", 2, lnk.getStereotypes().size());
        assertTrue("Link doesn't contain stereotype 1", lnk.getStereotypes().contains(st1));
        assertTrue("Link doesn't contain stereotype 2", lnk.getStereotypes().contains(st2));
    }

    /**
     * Testing of toTCUMLStimulus method for messages with 'messageSort' property set to 'asynchCall'.
     */
    public void test_toTCUMLStimulus_Asynch() {
        Message msg = new MessageImpl();
        msg.setMessageSort(MESSAGE_SORT_ASYNCH_CALL);
        Stimulus stm = msg.toTCUMLStimulus();
        assertTrue("Stimulus doesn't have correct link", msg.toTCUMLElement() == stm.getCommunicationLink());
        Procedure proc = stm.getDispatchAction();
        assertNotNull("Stimulus doesn't have dispatch action set", proc);
        Action act = proc.getAction();
        assertNotNull("Procedure in stimulus doesn't have action set", act);
        assertTrue("Procedure in stimulus has wrong action set", act instanceof CallOperationAction);
        assertTrue("Action in stimulus is not asynchronous", ((CallOperationAction) act).isAsynchronous());

        assertTrue("Second convertion returned another stimulus", msg.toTCUMLStimulus() == stm);
    }

    /**
     * Testing of toTCUMLStimulus method for messages with 'messageSort' property set to 'synchCall'
     * and with 'receiveEvent' property not set or set to EventOccurrence with not set 'startExec'
     * property.
     */
    public void test_toTCUMLStimulus_SynchNullStart() {
        Message msg = new MessageImpl();
        msg.setMessageSort(MESSAGE_SORT_SYNCH_CALL);
        Stimulus stm = msg.toTCUMLStimulus();
        Procedure proc = stm.getDispatchAction();
        assertNotNull("Stimulus doesn't have dispatch action set with null 'receiveEvent'", proc);
        Action act = proc.getAction();
        assertNull("Procedure in stimulus has action set with null 'receiveEvent'", act);

        msg = new MessageImpl();
        EventOccurrence evo = new EventOccurrenceImpl();
        msg.setReceiveEvent(evo);
        stm = msg.toTCUMLStimulus();
        proc = stm.getDispatchAction();
        assertNotNull("Stimulus doesn't have dispatch action set with null 'startExec'", proc);
        act = proc.getAction();
        assertNull("Procedure in stimulus has action set with null 'startExec'", act);
    }

    /**
     * Testing of toTCUMLStimulus method for messages with 'messageSort' property set to 'synchCall'
     * and with 'receiveEvent' property set to EventOccurrence with not null 'startExec' property.
     */
    public void test_toTCUMLStimulus_SynchNotNullStart() {
        Message msg = new MessageImpl();
        msg.setMessageSort(MESSAGE_SORT_SYNCH_CALL);
        EventOccurrence evo = new EventOccurrenceImpl();
        ExecutionOccurrence exo = new ExecutionOccurrenceImpl();
        evo.setStartExec(exo);
        msg.setReceiveEvent(evo);
        Stimulus stm = msg.toTCUMLStimulus();
        Procedure proc = stm.getDispatchAction();
        assertNotNull("Stimulus doesn't have dispatch action set", proc);
        Action act = proc.getAction();
        assertNotNull("Procedure in stimulus doesn't have action set", act);
        assertTrue("Procedure in stimulus has wrong action set", act instanceof CallOperationAction);
        assertFalse("Action in stimulus is synchronous", ((CallOperationAction) act).isAsynchronous());
    }
}
