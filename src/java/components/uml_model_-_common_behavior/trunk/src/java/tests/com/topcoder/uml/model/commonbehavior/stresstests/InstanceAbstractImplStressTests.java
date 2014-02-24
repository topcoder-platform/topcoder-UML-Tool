/*
 * Copyright (C) 2006 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.uml.model.commonbehavior.stresstests;

import junit.framework.TestCase;

import com.topcoder.uml.model.commonbehavior.instances.InstanceAbstractImpl;
import com.topcoder.uml.model.commonbehavior.instances.ObjectImpl;
import com.topcoder.uml.model.commonbehavior.instances.Stimulus;
import com.topcoder.uml.model.commonbehavior.instances.StimulusImpl;
import com.topcoder.uml.model.commonbehavior.links.Link;
import com.topcoder.uml.model.commonbehavior.links.LinkEnd;
import com.topcoder.uml.model.commonbehavior.links.LinkEndImpl;
import com.topcoder.uml.model.commonbehavior.links.LinkImpl;

/**
 * This is the stress tests for <code>InstanceAbstractImpl</code> class.
 *
 * @author KKD
 * @version 1.0
 */
public class InstanceAbstractImplStressTests extends TestCase {
    /**
     * <p>
     * An instance of <code>InstanceAbstractImpl</code> which is tested.
     * </p>
     */
    private InstanceAbstractImpl target = null;

    /**
     * <p>
     * setUp() routine. Creates test InstanceAbstractImpl instance using
     * <code>ObjectImpl()</code>.
     * </p>
     */
    protected void setUp() {
        target = new ObjectImpl();
    }

    /**
     * <p>
     * Stress test. Tests the <code>addOwnedLink(Link)</code> for proper
     * behavior.
     * </p>
     *
     * <pre>
     *     -------------------------aim-------------------------------
     *     test that this method works at extreme load.
     *     -------------------------input-----------------------------
     *     1000 Link is added
     *     -------------------------output----------------------------
     *     1000 Link added correctly.
     * </pre>
     *
     * @throws Exception
     *             to JUnit
     */
    public void testAddOwnedLink_1_stress() throws Exception {
        final int load = 1000;
        Link link = new LinkImpl();
        System.out
                .println("----- Start testing InstanceAbstractImpl#addOwnedLink(Link) -----");
        long start = System.currentTimeMillis();
        for (int i = 0; i < load - 1; i++) {
            target.addOwnedLink(new LinkImpl());
        }
        target.addOwnedLink(link);
        long end = System.currentTimeMillis();
        System.out.println("----- Add " + load + " Link to Instance taking "
                + (end - start) + " ms -----");
        assertTrue("Link should be added correctly.", target
                .containsOwnedLink(link));
        assertEquals(load + " should be added.", load, target.countOwnedLinks());
    }

    /**
     * <p>
     * Stress test. Tests the <code>addLinkEnd(LinkEnd)</code> for proper
     * behavior.
     * </p>
     *
     * <pre>
     *     ---------------aim-----------------------------------------
     *     test that this method works at extreme load.
     *     --------------input----------------------------------------
     *     1000 LinkEnd is added
     *     --------------output---------------------------------------
     *     1000 LinkEnd added correctly.
     * </pre>
     *
     * @throws Exception
     *             to JUnit
     */
    public void testAddLinkEnd_1_stress() throws Exception {
        final int load = 1000;
        LinkEnd linkEnd = new LinkEndImpl();
        System.out
                .println("----- Start testing InstanceAbstractImpl#addLinkEnd(LinkEnd) -----");
        long start = System.currentTimeMillis();
        for (int i = 0; i < load - 1; i++) {
            target.addLinkEnd(new LinkEndImpl());
        }
        target.addLinkEnd(linkEnd);
        long end = System.currentTimeMillis();
        System.out.println("----- Add " + load + " LinkEnd to Instance taking "
                + (end - start) + " ms -----");
        assertTrue("LinkEnd should be added correctly.", target
                .containsLinkEnd(linkEnd));
        assertEquals(load + " should be added.", load, target.countLinkEnds());
    }

    /**
     * <p>
     * Stress test. Tests the <code>addSendStimulus(Stimulus)</code> for
     * proper behavior.
     * </p>
     *
     * <pre>
     *     ---------------aim-----------------------------------------
     *     test that this method works at extreme load.
     *     --------------input----------------------------------------
     *     1000 SendStimuli is added
     *     --------------output---------------------------------------
     *     1000 SendStimuli added correctly.
     * </pre>
     *
     * @throws Exception
     *             to JUnit
     */
    public void testAddSendStimulus_1_stress() throws Exception {
        final int load = 1000;
        Stimulus sendStimulus = new StimulusImpl();
        System.out
                .println("----- Start testing InstanceAbstractImpl#addSendStimulus(Stimulus) -----");
        long start = System.currentTimeMillis();
        for (int i = 0; i < load - 1; i++) {
            target.addSendStimulus(new StimulusImpl());
        }
        target.addSendStimulus(sendStimulus);
        long end = System.currentTimeMillis();
        System.out.println("----- Add " + load
                + " SendStimuli to Instance taking " + (end - start)
                + " ms -----");
        assertTrue("SendStimulus should be added correctly.", target
                .containsSendStimulus(sendStimulus));
        assertEquals(load + " should be added.", load, target
                .countSendStimuli());
    }

    /**
     * <p>
     * Stress test. Tests the <code>addReceiveStimulus(Stimulus)</code> for
     * proper behavior.
     * </p>
     *
     * <pre>
     *     ---------------aim-----------------------------------------
     *     test that this method works at extreme load.
     *     --------------input----------------------------------------
     *     1000 ReceiveStimuli is added
     *     --------------output---------------------------------------
     *     1000 ReceiveStimuli added correctly.
     * </pre>
     *
     * @throws Exception
     *             to JUnit
     */
    public void testAddReceiveStimulus_1_stress() throws Exception {
        final int load = 1000;
        Stimulus receiveStimulus = new StimulusImpl();
        System.out
                .println("----- Start testing InstanceAbstractImpl#addReceiveStimulus(Stimulus) -----");
        long start = System.currentTimeMillis();
        for (int i = 0; i < load - 1; i++) {
            target.addReceiveStimulus(new StimulusImpl());
        }
        target.addReceiveStimulus(receiveStimulus);
        long end = System.currentTimeMillis();
        System.out.println("----- Add " + load
                + " ReceiveStimuli to Instance taking " + (end - start)
                + " ms -----");
        assertTrue("ReceiveStimulus should be added correctly.", target
                .containsReceiveStimulus(receiveStimulus));
        assertEquals(load + " should be added.", load, target
                .countReceiveStimuli());
    }
}
