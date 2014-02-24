/*
 * Copyright (C) 2006 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.uml.model.commonbehavior.accuracytests;

import java.util.ArrayList;
import java.util.Collection;

import com.topcoder.uml.model.commonbehavior.instances.InstanceAbstractImpl;
import com.topcoder.uml.model.commonbehavior.instances.Stimulus;
import com.topcoder.uml.model.commonbehavior.instances.StimulusImpl;
import com.topcoder.uml.model.commonbehavior.links.Link;
import com.topcoder.uml.model.commonbehavior.links.LinkEnd;
import com.topcoder.uml.model.commonbehavior.links.LinkEndImpl;
import com.topcoder.uml.model.commonbehavior.links.LinkImpl;
import com.topcoder.uml.model.core.Classifier;
import com.topcoder.uml.model.core.ClassifierAbstractImpl;

import junit.framework.TestCase;

/**
 * AccuracyTest for InstanceAbstractImpl class.
 *
 * @author iamajia
 * @version 1.0
 */
public class InstanceAbstractImplAccuracyTest extends TestCase {
    /**
     * This instance is used in the test.
     */
    private InstanceAbstractImpl instance = new InstanceAbstractImpl() {
    };

    /**
     * This instance is used in the test.
     */
    private Link ownedLink1 = new LinkImpl();

    /**
     * This instance is used in the test.
     */
    private Link ownedLink2 = new LinkImpl();

    /**
     * This instance is used in the test.
     */
    private Collection<Link> ownedLinks = new ArrayList<Link>();

    /**
     * This instance is used in the test.
     */
    private LinkEnd linkEnd1 = new LinkEndImpl();

    /**
     * This instance is used in the test.
     */
    private LinkEnd linkEnd2 = new LinkEndImpl();

    /**
     * This instance is used in the test.
     */
    private Collection<LinkEnd> linkEnds = new ArrayList<LinkEnd>();

    /**
     * This instance is used in the test.
     */
    private Stimulus sendStimulus1 = new StimulusImpl();

    /**
     * This instance is used in the test.
     */
    private Stimulus sendStimulus2 = new StimulusImpl();

    /**
     * This instance is used in the test.
     */
    private Collection<Stimulus> sendStimuli = new ArrayList<Stimulus>();

    /**
     * This instance is used in the test.
     */
    private Stimulus receiveStimulus1 = new StimulusImpl();

    /**
     * This instance is used in the test.
     */
    private Stimulus receiveStimulus2 = new StimulusImpl();

    /**
     * This instance is used in the test.
     */
    private Collection<Stimulus> receiveStimuli = new ArrayList<Stimulus>();

    /**
     * Accuracy test of <code>InstanceAbstractImpl()</code> constructor.
     *
     * @throws Exception
     *             to junit.
     */
    public void testInstanceAbstractImplAccuracy() throws Exception {
        assertNotNull("instance should not be null.", instance);
    }

    /**
     * Accuracy test of <code>getClassifier()</code> and
     * <code>setClassifier(Classifier classifier)</code> method.
     *
     * @throws Exception
     *             to junit.
     */
    public void testGetSetClassifierAccuracy() throws Exception {
        Classifier classifier = new ClassifierAbstractImpl() {
        };
        instance.setClassifier(classifier);
        assertEquals("classifier is incorrect.", classifier, instance.getClassifier());
        instance.setClassifier(null);
        assertNull("classifier should be null.", instance.getClassifier());
    }

    /**
     * Accuracy test of <code>addOwnedLink(OwnedLink ownedLink)</code> method.
     *
     * @throws Exception
     *             to junit.
     */
    public void testAddOwnedLinkAccuracy() throws Exception {
        instance.addOwnedLink(ownedLink1);
        assertEquals("count should 1.", 1, instance.countOwnedLinks());
    }

    /**
     * Accuracy test of
     * <code>addOwnedLinks(Collection&lt;Link&gt; ownedLinks)</code> method.
     *
     * @throws Exception
     *             to junit.
     */
    public void testAddOwnedLinksAccuracy() throws Exception {
        ownedLinks.add(ownedLink1);
        ownedLinks.add(ownedLink2);
        instance.addOwnedLinks(ownedLinks);
        assertEquals("ownedLinks is incorrect.", ownedLinks, instance.getOwnedLinks());
    }

    /**
     * Accuracy test of <code>removeOwnedLink(Link ownedLink)</code> method.
     *
     * @throws Exception
     *             to junit.
     */
    public void testRemoveOwnedLinkAccuracy() throws Exception {
        instance.addOwnedLink(ownedLink1);
        assertTrue("result is incorrect.", instance.removeOwnedLink(ownedLink1));
        assertFalse("result is incorrect.", instance.removeOwnedLink(ownedLink1));
    }

    /**
     * Accuracy test of
     * <code>removeOwnedLinks(Collection&lt;Link&gt; ownedLinks)</code> method.
     *
     * @throws Exception
     *             to junit.
     */
    public void testRemoveOwnedLinksAccuracy() throws Exception {
        instance.addOwnedLink(ownedLink1);
        instance.addOwnedLink(ownedLink1);
        instance.addOwnedLink(ownedLink2);
        ownedLinks.add(ownedLink1);
        ownedLinks.add(ownedLink2);
        instance.removeOwnedLinks(ownedLinks);
        assertEquals("result is incorrect.", 1, instance.countOwnedLinks());
    }

    /**
     * Accuracy test of <code>clearOwnedLinks()</code> method.
     *
     * @throws Exception
     *             to junit.
     */
    public void testClearOwnedLinksAccuracy() throws Exception {
        instance.addOwnedLink(ownedLink1);
        instance.clearOwnedLinks();
        assertEquals("count should 0.", 0, instance.countOwnedLinks());
    }

    /**
     * Accuracy test of <code>getOwnedLinks()</code> method.
     *
     * @throws Exception
     *             to junit.
     */
    public void testGetOwnedLinksAccuracy() throws Exception {
        Collection<Link> expectOwnedLinks = new ArrayList<Link>();
        expectOwnedLinks.add(ownedLink1);
        expectOwnedLinks.add(ownedLink2);
        instance.addOwnedLinks(expectOwnedLinks);
        assertEquals("ownedLinks is incorrect.", expectOwnedLinks, instance.getOwnedLinks());
        instance.getOwnedLinks().clear();
        assertEquals("ownedLinks is incorrect.", expectOwnedLinks, instance.getOwnedLinks());
    }

    /**
     * Accuracy test of <code>containsOwnedLink(Link ownedLink)</code> method.
     *
     * @throws Exception
     *             to junit.
     */
    public void testContainsOwnedLinkAccuracy() throws Exception {
        instance.addOwnedLink(ownedLink1);
        assertTrue("it should be true.", instance.containsOwnedLink(ownedLink1));
    }

    /**
     * Accuracy test of <code>countOwnedLinks()</code> method.
     *
     * @throws Exception
     *             to junit.
     */
    public void testCountOwnedLinksAccuracy() throws Exception {
        instance.addOwnedLink(ownedLink1);
        assertEquals("count should 1.", 1, instance.countOwnedLinks());
    }

    /**
     * Accuracy test of <code>addLinkEnd(LinkEnd linkEnd)</code> method.
     *
     * @throws Exception
     *             to junit.
     */
    public void testAddLinkEndAccuracy() throws Exception {
        instance.addLinkEnd(linkEnd1);
        assertEquals("count should 1.", 1, instance.countLinkEnds());
    }

    /**
     * Accuracy test of <code>addLinkEnds(Collection&lt;LinkEnd&gt; linkEnds)</code>
     * method.
     *
     * @throws Exception
     *             to junit.
     */
    public void testAddLinkEndsAccuracy() throws Exception {
        linkEnds.add(linkEnd1);
        linkEnds.add(linkEnd2);
        instance.addLinkEnds(linkEnds);
        assertEquals("linkEnds is incorrect.", linkEnds, instance.getLinkEnds());
    }

    /**
     * Accuracy test of <code>removeLinkEnd(LinkEnd linkEnd)</code> method.
     *
     * @throws Exception
     *             to junit.
     */
    public void testRemoveLinkEndAccuracy() throws Exception {
        instance.addLinkEnd(linkEnd1);
        assertTrue("result is incorrect.", instance.removeLinkEnd(linkEnd1));
        assertFalse("result is incorrect.", instance.removeLinkEnd(linkEnd1));
    }

    /**
     * Accuracy test of
     * <code>removeLinkEnds(Collection&lt;LinkEnd&gt; linkEnds)</code> method.
     *
     * @throws Exception
     *             to junit.
     */
    public void testRemoveLinkEndsAccuracy() throws Exception {
        instance.addLinkEnd(linkEnd1);
        instance.addLinkEnd(linkEnd1);
        instance.addLinkEnd(linkEnd2);
        linkEnds.add(linkEnd1);
        linkEnds.add(linkEnd2);
        instance.removeLinkEnds(linkEnds);
        assertEquals("result is incorrect.", 1, instance.countLinkEnds());
    }

    /**
     * Accuracy test of <code>clearLinkEnds()</code> method.
     *
     * @throws Exception
     *             to junit.
     */
    public void testClearLinkEndsAccuracy() throws Exception {
        instance.addLinkEnd(linkEnd1);
        instance.clearLinkEnds();
        assertEquals("count should 0.", 0, instance.countLinkEnds());
    }

    /**
     * Accuracy test of <code>getLinkEnds()</code> method.
     *
     * @throws Exception
     *             to junit.
     */
    public void testGetLinkEndsAccuracy() throws Exception {
        Collection<LinkEnd> expectLinkEnds = new ArrayList<LinkEnd>();
        expectLinkEnds.add(linkEnd1);
        expectLinkEnds.add(linkEnd2);
        instance.addLinkEnds(expectLinkEnds);
        assertEquals("linkEnds is incorrect.", expectLinkEnds, instance.getLinkEnds());
        instance.getLinkEnds().clear();
        assertEquals("linkEnds is incorrect.", expectLinkEnds, instance.getLinkEnds());
    }

    /**
     * Accuracy test of <code>containsLinkEnd(LinkEnd linkEnd)</code> method.
     *
     * @throws Exception
     *             to junit.
     */
    public void testContainsLinkEndAccuracy() throws Exception {
        instance.addLinkEnd(linkEnd1);
        assertTrue("it should be true.", instance.containsLinkEnd(linkEnd1));
    }

    /**
     * Accuracy test of <code>countLinkEnds()</code> method.
     *
     * @throws Exception
     *             to junit.
     */
    public void testCountLinkEndsAccuracy() throws Exception {
        instance.addLinkEnd(linkEnd1);
        assertEquals("count should 1.", 1, instance.countLinkEnds());
    }

    /**
     * Accuracy test of <code>addSendStimulus(Stimulus sendStimulus)</code>
     * method.
     *
     * @throws Exception
     *             to junit.
     */
    public void testAddSendStimulusAccuracy() throws Exception {
        instance.addSendStimulus(sendStimulus1);
        assertEquals("count should 1.", 1, instance.countSendStimuli());
    }

    /**
     * Accuracy test of
     * <code>addSendStimuli(Collection&lt;Stimulus&gt; sendStimuli)</code> method.
     *
     * @throws Exception
     *             to junit.
     */
    public void testAddSendStimuliAccuracy() throws Exception {
        sendStimuli.add(sendStimulus1);
        sendStimuli.add(sendStimulus2);
        instance.addSendStimuli(sendStimuli);
        assertEquals("sendStimuli is incorrect.", sendStimuli, instance.getSendStimuli());
    }

    /**
     * Accuracy test of <code>removeSendStimulus(Stimulus sendStimulus)</code>
     * method.
     *
     * @throws Exception
     *             to junit.
     */
    public void testRemoveSendStimulusAccuracy() throws Exception {
        instance.addSendStimulus(sendStimulus1);
        assertTrue("result is incorrect.", instance.removeSendStimulus(sendStimulus1));
        assertFalse("result is incorrect.", instance.removeSendStimulus(sendStimulus1));
    }

    /**
     * Accuracy test of
     * <code>removeSendStimuli(Collection&lt;SendStimulus&gt; sendStimuli)</code>
     * method.
     *
     * @throws Exception
     *             to junit.
     */
    public void testRemoveSendStimuliAccuracy() throws Exception {
        instance.addSendStimulus(sendStimulus1);
        instance.addSendStimulus(sendStimulus1);
        instance.addSendStimulus(sendStimulus2);
        sendStimuli.add(sendStimulus1);
        sendStimuli.add(sendStimulus2);
        instance.removeSendStimuli(sendStimuli);
        assertEquals("result is incorrect.", 1, instance.countSendStimuli());
    }

    /**
     * Accuracy test of <code>clearSendStimuli()</code> method.
     *
     * @throws Exception
     *             to junit.
     */
    public void testClearSendStimuliAccuracy() throws Exception {
        instance.addSendStimulus(sendStimulus1);
        instance.clearSendStimuli();
        assertEquals("count should 0.", 0, instance.countSendStimuli());
    }

    /**
     * Accuracy test of <code>getSendStimuli()</code> method.
     *
     * @throws Exception
     *             to junit.
     */
    public void testGetSendStimuliAccuracy() throws Exception {
        Collection<Stimulus> expectSendStimuli = new ArrayList<Stimulus>();
        expectSendStimuli.add(sendStimulus1);
        expectSendStimuli.add(sendStimulus2);
        instance.addSendStimuli(expectSendStimuli);
        assertEquals("sendStimuli is incorrect.", expectSendStimuli, instance.getSendStimuli());
        instance.getSendStimuli().clear();
        assertEquals("sendStimuli is incorrect.", expectSendStimuli, instance.getSendStimuli());
    }

    /**
     * Accuracy test of <code>containsSendStimulus(Stimulus sendStimulus)</code>
     * method.
     *
     * @throws Exception
     *             to junit.
     */
    public void testContainsSendStimulusAccuracy() throws Exception {
        instance.addSendStimulus(sendStimulus1);
        assertTrue("it should be true.", instance.containsSendStimulus(sendStimulus1));
    }

    /**
     * Accuracy test of <code>countSendStimuli()</code> method.
     *
     * @throws Exception
     *             to junit.
     */
    public void testCountSendStimuliAccuracy() throws Exception {
        instance.addSendStimulus(sendStimulus1);
        assertEquals("count should 1.", 1, instance.countSendStimuli());
    }

    /**
     * Accuracy test of
     * <code>addReceiveStimulus(Stimulus receiveStimulus)</code> method.
     *
     * @throws Exception
     *             to junit.
     */
    public void testAddReceiveStimulusAccuracy() throws Exception {
        instance.addReceiveStimulus(receiveStimulus1);
        assertEquals("count should 1.", 1, instance.countReceiveStimuli());
    }

    /**
     * Accuracy test of
     * <code>addReceiveStimuli(Collection&lt;Stimulus&gt; receiveStimuli)</code>
     * method.
     *
     * @throws Exception
     *             to junit.
     */
    public void testAddReceiveStimuliAccuracy() throws Exception {
        receiveStimuli.add(receiveStimulus1);
        receiveStimuli.add(receiveStimulus2);
        instance.addReceiveStimuli(receiveStimuli);
        assertEquals("receiveStimuli is incorrect.", receiveStimuli, instance.getReceiveStimuli());
    }

    /**
     * Accuracy test of
     * <code>removeReceiveStimulus(Stimulus receiveStimulus)</code> method.
     *
     * @throws Exception
     *             to junit.
     */
    public void testRemoveReceiveStimulusAccuracy() throws Exception {
        instance.addReceiveStimulus(receiveStimulus1);
        assertTrue("result is incorrect.", instance.removeReceiveStimulus(receiveStimulus1));
        assertFalse("result is incorrect.", instance.removeReceiveStimulus(receiveStimulus1));
    }

    /**
     * Accuracy test of
     * <code>removeReceiveStimuli(Collection&lt;ReceiveStimulus&gt; receiveStimuli)</code>
     * method.
     *
     * @throws Exception
     *             to junit.
     */
    public void testRemoveReceiveStimuliAccuracy() throws Exception {
        instance.addReceiveStimulus(receiveStimulus1);
        instance.addReceiveStimulus(receiveStimulus1);
        instance.addReceiveStimulus(receiveStimulus2);
        receiveStimuli.add(receiveStimulus1);
        receiveStimuli.add(receiveStimulus2);
        instance.removeReceiveStimuli(receiveStimuli);
        assertEquals("result is incorrect.", 1, instance.countReceiveStimuli());
    }

    /**
     * Accuracy test of <code>clearReceiveStimuli()</code> method.
     *
     * @throws Exception
     *             to junit.
     */
    public void testClearReceiveStimuliAccuracy() throws Exception {
        instance.addReceiveStimulus(receiveStimulus1);
        instance.clearReceiveStimuli();
        assertEquals("count should 0.", 0, instance.countReceiveStimuli());
    }

    /**
     * Accuracy test of <code>getReceiveStimuli()</code> method.
     *
     * @throws Exception
     *             to junit.
     */
    public void testGetReceiveStimuliAccuracy() throws Exception {
        Collection<Stimulus> expectReceiveStimuli = new ArrayList<Stimulus>();
        expectReceiveStimuli.add(receiveStimulus1);
        expectReceiveStimuli.add(receiveStimulus2);
        instance.addReceiveStimuli(expectReceiveStimuli);
        assertEquals("receiveStimuli is incorrect.", expectReceiveStimuli, instance.getReceiveStimuli());
        instance.getReceiveStimuli().clear();
        assertEquals("receiveStimuli is incorrect.", expectReceiveStimuli, instance.getReceiveStimuli());
    }

    /**
     * Accuracy test of
     * <code>containsReceiveStimulus(Stimulus receiveStimulus)</code> method.
     *
     * @throws Exception
     *             to junit.
     */
    public void testContainsReceiveStimulusAccuracy() throws Exception {
        instance.addReceiveStimulus(receiveStimulus1);
        assertTrue("it should be true.", instance.containsReceiveStimulus(receiveStimulus1));
    }

    /**
     * Accuracy test of <code>countReceiveStimuli()</code> method.
     *
     * @throws Exception
     *             to junit.
     */
    public void testCountReceiveStimuliAccuracy() throws Exception {
        instance.addReceiveStimulus(receiveStimulus1);
        assertEquals("count should 1.", 1, instance.countReceiveStimuli());
    }
}
