/*
 * Copyright (C) 2006 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.uml.model.commonbehavior.accuracytests;

import com.topcoder.uml.model.commonbehavior.instances.Instance;
import com.topcoder.uml.model.commonbehavior.instances.InstanceAbstractImpl;
import com.topcoder.uml.model.commonbehavior.instances.StimulusImpl;
import com.topcoder.uml.model.commonbehavior.links.Link;
import com.topcoder.uml.model.commonbehavior.links.LinkImpl;
import com.topcoder.uml.model.commonbehavior.procedure.Procedure;
import com.topcoder.uml.model.commonbehavior.procedure.ProcedureImpl;

import junit.framework.TestCase;

/**
 * AccuracyTest for StimulusImpl class.
 *
 * @author iamajia
 * @version 1.0
 */
public class StimulusImplAccuracyTest extends TestCase {
    /**
     * This instance is used in the test.
     */
    private StimulusImpl stimulus = new StimulusImpl();

    /**
     * Accuracy test of <code>StimulusImpl()</code> constructor.
     *
     * @throws Exception
     *             to junit.
     */
    public void testStimulusImplAccuracy() throws Exception {
        assertNotNull("stimulus should not be null.", stimulus);
        assertNull("initial value should be null.", stimulus.getSender());
        assertNull("initial value should be null.", stimulus.getReceiver());
        assertNull("initial value should be null.", stimulus.getCommunicationLink());
        assertNull("initial value should be null.", stimulus.getDispatchAction());
    }

    /**
     * Accuracy test of <code>getSender()</code> and
     * <code>setSender(Instance sender)</code> method.
     *
     * @throws Exception
     *             to junit.
     */
    public void testGetSetSenderAccuracy() throws Exception {
        Instance sender = new InstanceAbstractImpl() {
        };
        stimulus.setSender(sender);
        assertEquals("sender is incorrect.", sender, stimulus.getSender());
        stimulus.setSender(null);
        assertNull("sender should be null.", stimulus.getSender());
    }

    /**
     * Accuracy test of <code>getReceiver()</code> and
     * <code>setReceiver(Instance receiver)</code> method.
     *
     * @throws Exception
     *             to junit.
     */
    public void testGetSetReceiverAccuracy() throws Exception {
        Instance receiver = new InstanceAbstractImpl() {
        };
        stimulus.setReceiver(receiver);
        assertEquals("receiver is incorrect.", receiver, stimulus.getReceiver());
        stimulus.setReceiver(null);
        assertNull("receiver should be null.", stimulus.getReceiver());
    }

    /**
     * Accuracy test of <code>getCommunicationLink()</code> and
     * <code>setCommunicationLink(Link communicationLink)</code> method.
     *
     * @throws Exception
     *             to junit.
     */
    public void testGetSetCommunicationLinkAccuracy() throws Exception {
        Link communicationLink = new LinkImpl();
        stimulus.setCommunicationLink(communicationLink);
        assertEquals("communicationLink is incorrect.", communicationLink, stimulus.getCommunicationLink());
        stimulus.setCommunicationLink(null);
        assertNull("communicationLink should be null.", stimulus.getCommunicationLink());
    }

    /**
     * Accuracy test of <code>getDispatchAction()</code> and
     * <code>setDispatchAction(Procedure dispatchAction)</code> method.
     *
     * @throws Exception
     *             to junit.
     */
    public void testGetDispatchActionAccuracy() throws Exception {
        Procedure dispatchAction = new ProcedureImpl();
        stimulus.setDispatchAction(dispatchAction);
        assertEquals("dispatchAction is incorrect.", dispatchAction, stimulus.getDispatchAction());
        stimulus.setDispatchAction(null);
        assertNull("dispatchAction should be null.", stimulus.getDispatchAction());
    }
}
