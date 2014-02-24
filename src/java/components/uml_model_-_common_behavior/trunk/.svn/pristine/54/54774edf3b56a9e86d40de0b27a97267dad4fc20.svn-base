/*
 * Copyright (C) 2006 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.uml.model.commonbehavior.accuracytests;

import java.util.ArrayList;
import java.util.Collection;

import com.topcoder.uml.model.commonbehavior.instances.Instance;
import com.topcoder.uml.model.commonbehavior.instances.InstanceAbstractImpl;
import com.topcoder.uml.model.commonbehavior.instances.Stimulus;
import com.topcoder.uml.model.commonbehavior.instances.StimulusImpl;
import com.topcoder.uml.model.commonbehavior.links.LinkEnd;
import com.topcoder.uml.model.commonbehavior.links.LinkEndImpl;
import com.topcoder.uml.model.commonbehavior.links.LinkImpl;

import junit.framework.TestCase;

/**
 * AccuracyTest for LinkImpl class.
 *
 * @author iamajia
 * @version 1.0
 */
public class LinkImplAccuracyTest extends TestCase {
    /**
     * This instance is used in the test.
     */
    private LinkImpl link = new LinkImpl();

    /**
     * This instance is used in the test.
     */
    private Stimulus stimulus1 = new StimulusImpl();

    /**
     * This instance is used in the test.
     */
    private Stimulus stimulus2 = new StimulusImpl();

    /**
     * This instance is used in the test.
     */
    private LinkEnd connection1 = new LinkEndImpl();

    /**
     * This instance is used in the test.
     */
    private LinkEnd connection2 = new LinkEndImpl();

    /**
     * This instance is used in the test.
     */
    private Collection<LinkEnd> connections = new ArrayList<LinkEnd>();

    /**
     * This instance is used in the test.
     */
    private Collection<Stimulus> stimuli = new ArrayList<Stimulus>();

    /**
     * Accuracy test of <code>LinkImpl()</code> constructor.
     *
     * @throws Exception
     *             to junit.
     */
    public void testLinkImplAccuracy() throws Exception {
        assertNotNull("link should not be null.", link);
        assertNull("initial value should be null.", link.getOwner());
    }

    /**
     * Accuracy test of <code>getOwner()</code> and
     * <code>setOwner(Instance owner)</code> method.
     *
     * @throws Exception
     *             to junit.
     */
    public void testGetOwnerAccuracy() throws Exception {
        Instance owner = new InstanceAbstractImpl() {
        };
        link.setOwner(owner);
        assertEquals("owner is incorrect.", owner, link.getOwner());
        link.setOwner(null);
        assertNull("owner should be null.", link.getOwner());
    }

    /**
     * Accuracy test of <code>addConnection(LinkEnd connection)</code>.
     */
    public void testAddConnection1Accuracy() {
        link.addConnection(connection1);
        assertEquals("index should be 0.", 0, link.indexOfConnection(connection1));
    }

    /**
     * Accuracy test of
     * <code>addConnection(int index, AssociationEnd connection)</code>.
     */
    public void testAddConnection2Accuracy() {
        link.addConnection(0, connection1);
        assertEquals("index should 0.", 0, link.indexOfConnection(connection1));
    }

    /**
     * Accuracy test of
     * <code>addConnections(Collection&lt;LinkEnd&gt; connections)</code> method.
     *
     * @throws Exception
     *             to junit.
     */
    public void testAddConnections1Accuracy() throws Exception {
        connections.add(connection1);
        connections.add(connection2);
        link.addConnections(connections);
        assertEquals("count should be 2.", 2, link.countConnections());
    }

    /**
     * Accuracy test of
     * <code>addConnections(int index, Collection&lt;LinkEnd&gt; connections)</code>
     * method.
     *
     * @throws Exception
     *             to junit.
     */
    public void testAddConnections2Accuracy() throws Exception {
        connections.add(connection2);
        link.addConnection(connection1);
        link.addConnections(0, connections);
        assertEquals("index should be 0.", 0, link.indexOfConnection(connection2));
    }

    /**
     * Accuracy test of
     * <code>setConnection(int index, LinkEnd connection)</code>.
     */
    public void testSetConnectionAccuracy() {
        link.addConnection(connection1);
        connection1 = new LinkEndImpl();
        link.setConnection(0, connection1);

        assertEquals("connection in index 0 have not been updated.", 0, link.indexOfConnection(connection1));
    }

    /**
     * Accuracy test of <code>removeConnection(int index)</code>.
     */
    public void testRemoveConnection1Accuracy() {
        link.addConnection(connection1);
        assertEquals("it should return connection.", connection1, link.removeConnection(0));
        assertEquals("connection should be removed.", -1, link.indexOfConnection(connection1));
    }

    /**
     * Accuracy test of <code>removeConnection(LinkEnd connection)</code>
     * method.
     *
     * @throws Exception
     *             to junit.
     */
    public void testRemoveConnectionAccuracy2() throws Exception {
        link.addConnection(connection1);
        assertTrue("result is incorrect.", link.removeConnection(connection1));
        assertFalse("result is incorrect.", link.removeConnection(connection1));
    }

    /**
     * Accuracy test of
     * <code>removeConnections(Collection&lt;LinkEnd&gt; connections)</code>
     * method.
     *
     * @throws Exception
     *             to junit.
     */
    public void testRemoveConnectionsAccuracy() throws Exception {
        link.addConnection(connection1);
        link.addConnection(connection1);
        link.addConnection(connection2);

        connections.add(connection1);
        connections.add(connection2);
        link.removeConnections(connections);

        assertEquals("result is incorrect.", 1, link.countConnections());
    }

    /**
     * Accuracy test of <code>clearConnections()</code>.
     */
    public void testClearConnectionsAccuracy() {
        link.addConnection(connection1);
        link.clearConnections();
        assertEquals("connections count should be 0.", 0, link.countConnections());
    }

    /**
     * Accuracy test of <code>getConnections()</code>.
     */
    public void testGetConnectionsAccuracy() {
        link.addConnection(connection1);
        link.addConnection(connection1);
        ArrayList<LinkEnd> expectConnections = new ArrayList<LinkEnd>();
        expectConnections.add(connection1);
        expectConnections.add(connection1);
        assertEquals("connections is incorrect.", expectConnections, link.getConnections());
    }

    /**
     * Accuracy test of <code>containsConnection(LinkEnd connection)</code>.
     */
    public void testContainsConnectionAccuracy() {
        link.addConnection(connection1);
        assertTrue("it should be true.", link.containsConnection(connection1));
    }

    /**
     * Accuracy test of <code>indexOfConnection(LinkEnd connection)</code>.
     */
    public void testIndexOfConnectionAccuracy() {
        link.addConnection(connection1);
        link.addConnection(connection1);
        connection1 = new LinkEndImpl();
        link.addConnection(connection1);

        assertEquals("index should be 2.", 2, link.indexOfConnection(connection1));
    }

    /**
     * Accuracy test of <code>countConnections()</code>.
     */
    public void testCountConnectionsAccuracy() {
        link.addConnection(connection1);
        link.addConnection(connection1);
        assertEquals("count should be 2.", 2, link.countConnections());
    }

    /**
     * Accuracy test of <code>addStimulus(Stimulus stimulus)</code> method.
     *
     * @throws Exception
     *             to junit.
     */
    public void testAddStimulusAccuracy() throws Exception {
        link.addStimulus(stimulus1);
        assertEquals("count should 1.", 1, link.countStimuli());
    }

    /**
     * Accuracy test of <code>addStimuli(Collection&lt;Stimulus&gt; stimuli)</code>
     * method.
     *
     * @throws Exception
     *             to junit.
     */
    public void testAddStimuliAccuracy() throws Exception {
        stimuli.add(stimulus1);
        stimuli.add(stimulus2);
        link.addStimuli(stimuli);
        assertEquals("stimuli is incorrect.", stimuli, link.getStimuli());
    }

    /**
     * Accuracy test of <code>removeStimulus(Stimulus stimulus)</code> method.
     *
     * @throws Exception
     *             to junit.
     */
    public void testRemoveStimulusAccuracy() throws Exception {
        link.addStimulus(stimulus1);
        assertTrue("result is incorrect.", link.removeStimulus(stimulus1));
        assertFalse("result is incorrect.", link.removeStimulus(stimulus1));
    }

    /**
     * Accuracy test of <code>removeStimuli(Collection&lt;Stimulus&gt; stimuli)</code>
     * method.
     *
     * @throws Exception
     *             to junit.
     */
    public void testRemoveStimuliAccuracy() throws Exception {
        link.addStimulus(stimulus1);
        link.addStimulus(stimulus1);
        link.addStimulus(stimulus2);
        stimuli.add(stimulus1);
        stimuli.add(stimulus2);
        link.removeStimuli(stimuli);
        assertEquals("result is incorrect.", 1, link.countStimuli());
    }

    /**
     * Accuracy test of <code>clearStimuli()</code> method.
     *
     * @throws Exception
     *             to junit.
     */
    public void testClearStimuliAccuracy() throws Exception {
        link.addStimulus(stimulus1);
        link.clearStimuli();
        assertEquals("count should 0.", 0, link.countStimuli());
    }

    /**
     * Accuracy test of <code>getStimuli()</code> method.
     *
     * @throws Exception
     *             to junit.
     */
    public void testGetStimuliAccuracy() throws Exception {
        Collection<Stimulus> expectStimuli = new ArrayList<Stimulus>();
        expectStimuli.add(stimulus1);
        expectStimuli.add(stimulus2);
        link.addStimuli(expectStimuli);
        assertEquals("stimuli is incorrect.", expectStimuli, link.getStimuli());
        link.getStimuli().clear();
        assertEquals("stimuli is incorrect.", expectStimuli, link.getStimuli());
    }

    /**
     * Accuracy test of <code>containsStimulus(Stimulus stimulus)</code>
     * method.
     *
     * @throws Exception
     *             to junit.
     */
    public void testContainsStimulusAccuracy() throws Exception {
        link.addStimulus(stimulus1);
        assertTrue("it should be true.", link.containsStimulus(stimulus1));
    }

    /**
     * Accuracy test of <code>countStimuli()</code> method.
     *
     * @throws Exception
     *             to junit.
     */
    public void testCountStimuliAccuracy() throws Exception {
        link.addStimulus(stimulus1);
        assertEquals("count should 1.", 1, link.countStimuli());
    }
}
