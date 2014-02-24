/*
 * Copyright (C) 2006 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.uml.model.commonbehavior.failuretests;

import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedList;

import com.topcoder.uml.model.commonbehavior.instances.InstanceAbstractImpl;
import com.topcoder.uml.model.commonbehavior.instances.Stimulus;
import com.topcoder.uml.model.commonbehavior.instances.StimulusImpl;
import com.topcoder.uml.model.commonbehavior.links.Link;
import com.topcoder.uml.model.commonbehavior.links.LinkEnd;
import com.topcoder.uml.model.commonbehavior.links.LinkEndImpl;
import com.topcoder.uml.model.commonbehavior.links.LinkImpl;

import junit.framework.TestCase;

/**
 * Failure tests for <code>InstanceAbstractImpl</code>.
 *
 * @author mayi
 * @version 1.0
 */
public class InstanceAbstractImplFailureTests extends TestCase {
    /**
     * A <code>InstanceAbstractImpl</code> instance to test.
     */
    private InstanceAbstractImpl instance = null;

    /**
     * Create the <code>instance</code> instance to test.
     */
    protected void setUp() throws Exception {
        instance = new InstanceAbstractImpl() {
        };
    }

    /**
     * Test <code>addOwnedLink</code> with a null param.
     * <p>
     * IllegalArgumentException is expected.
     * </p>
     */
    public void testAddOwnedLink_Null() {
        try {
            instance.addOwnedLink((Link) null);
            fail("IllegalArgumentException is expected.");
        } catch (IllegalArgumentException e) {
            // ok
        }
    }

    /**
     * Test <code>addOwnedLinks</code> with a null param.
     * <p>
     * IllegalArgumentException is expected.
     * </p>
     */
    public void testAddOwnedLinks_Null() {
        try {
            instance.addOwnedLinks((Collection<Link>) null);
            fail("IllegalArgumentException is expected.");
        } catch (IllegalArgumentException e) {
            // ok
        }
    }

    /**
     * Test <code>addOwnedLinks</code> with a collection which contains a null element.
     * <p>
     * IllegalArgumentException is expected.
     * </p>
     */
    public void testAddOwnedLinks_NullElement() {
        Collection<Link> links = new LinkedList<Link>();
        links.add(new LinkImpl());
        links.add(null);

        try {
            instance.addOwnedLinks(links);
            fail("IllegalArgumentException is expected.");
        } catch (IllegalArgumentException e) {
            assertEquals("ownedLinks collection shouldn't be changed.",
                    0, instance.countOwnedLinks());
        }
    }

    /**
     * Test <code>removeOwnedLink</code> with a null param.
     * <p>
     * IllegalArgumentException is expected.
     * </p>
     */
    public void testRemoveOwnedLink_Null() {
        try {
            instance.removeOwnedLink((Link) null);
            fail("IllegalArgumentException is expected.");
        } catch (IllegalArgumentException e) {
            // ok
        }
    }

    /**
     * Test <code>removeOwnedLinks</code> with a null param.
     * <p>
     * IllegalArgumentException is expected.
     * </p>
     */
    public void testRemoveOwnedLinks_Null() {
        try {
            instance.removeOwnedLinks((Collection<Link>) null);
            fail("IllegalArgumentException is expected.");
        } catch (IllegalArgumentException e) {
            // ok
        }
    }

    /**
     * Test <code>removeOwnedLinks</code> with a collection which contains a null element.
     * <p>
     * IllegalArgumentException is expected.
     * </p>
     */
    public void testRemoveOwnedLinks_NullElement() {
        Link link = new LinkImpl();
        instance.addOwnedLink(link);

        Collection<Link> links = new LinkedList<Link>();
        links.add(link);
        links.add(null);

        try {
            instance.removeOwnedLinks(links);
            fail("IllegalArgumentException is expected.");
        } catch (IllegalArgumentException e) {
            assertEquals("ownedLinks collection shouldn't be changed.",
                    1, instance.countOwnedLinks());
        }
    }

    /**
     * Test <code>containsOwnedLink</code> with a null param.
     * <p>
     * IllegalArgumentException is expected.
     * </p>
     */
    public void testContainsOwnedLink_Null() {
        try {
            instance.containsOwnedLink((Link) null);
            fail("IllegalArgumentException is expected.");
        } catch (IllegalArgumentException e) {
            // ok
        }
    }



    /**
     * Test <code>addLinkEnd</code> with a null param.
     * <p>
     * IllegalArgumentException is expected.
     * </p>
     */
    public void testAddLinkEnd_Null() {
        try {
            instance.addLinkEnd((LinkEnd) null);
            fail("IllegalArgumentException is expected.");
        } catch (IllegalArgumentException e) {
            // ok
        }
    }

    /**
     * Test <code>addLinkEnds</code> with a null param.
     * <p>
     * IllegalArgumentException is expected.
     * </p>
     */
    public void testAddLinkEnds_Null() {
        try {
            instance.addLinkEnds((Collection<LinkEnd>) null);
            fail("IllegalArgumentException is expected.");
        } catch (IllegalArgumentException e) {
            // ok
        }
    }

    /**
     * Test <code>addLinkEnds</code> with a collection which contains a null element.
     * <p>
     * IllegalArgumentException is expected.
     * </p>
     */
    public void testAddLinkEnds_NullElement() {
        Collection<LinkEnd> ends = new LinkedList<LinkEnd>();
        ends.add(new LinkEndImpl());
        ends.add(null);

        try {
            instance.addLinkEnds(ends);
            fail("IllegalArgumentException is expected.");
        } catch (IllegalArgumentException e) {
            assertEquals("linkEnds collection shouldn't be changed.",
                    0, instance.countLinkEnds());
        }
    }

    /**
     * Test <code>removeLinkEnd</code> with a null param.
     * <p>
     * IllegalArgumentException is expected.
     * </p>
     */
    public void testRemoveLinkEnd_Null() {
        try {
            instance.removeLinkEnd((LinkEnd) null);
            fail("IllegalArgumentException is expected.");
        } catch (IllegalArgumentException e) {
            // ok
        }
    }

    /**
     * Test <code>removeLinkEnds</code> with a null param.
     * <p>
     * IllegalArgumentException is expected.
     * </p>
     */
    public void testRemoveLinkEnds_Null() {
        try {
            instance.removeLinkEnds((Collection<LinkEnd>) null);
            fail("IllegalArgumentException is expected.");
        } catch (IllegalArgumentException e) {
            // ok
        }
    }

    /**
     * Test <code>removeLinkEnds</code> with a collection which contains a null element.
     * <p>
     * IllegalArgumentException is expected.
     * </p>
     */
    public void testRemoveLinkEnds_NullElement() {
        LinkEnd linkEnd = new LinkEndImpl();
        instance.addLinkEnd(linkEnd);

        Collection<LinkEnd> ends = new LinkedList<LinkEnd>();
        ends.add(linkEnd);
        ends.add(null);

        try {
            instance.removeLinkEnds(ends);
            fail("IllegalArgumentException is expected.");
        } catch (IllegalArgumentException e) {
            assertEquals("linkEnds collection shouldn't be changed.",
                    1, instance.countLinkEnds());
        }
    }

    /**
     * Test <code>containsLinkEnd</code> with a null param.
     * <p>
     * IllegalArgumentException is expected.
     * </p>
     */
    public void testContainsLinkEnd_Null() {
        try {
            instance.containsLinkEnd((LinkEnd) null);
            fail("IllegalArgumentException is expected.");
        } catch (IllegalArgumentException e) {
            // ok
        }
    }



    /**
     * Test <code>addSendStimulus</code> with a null param.
     * <p>
     * IllegalArgumentException is expected.
     * </p>
     */
    public void testAddSendStimulus_Null() {
        try {
            instance.addSendStimulus((Stimulus) null);
            fail("IllegalArgumentException is expected.");
        } catch (IllegalArgumentException e) {
            // ok
        }
    }

    /**
     * Test <code>addSendStimuli</code> with a null param.
     * <p>
     * IllegalArgumentException is expected.
     * </p>
     */
    public void testAddSendStimuli_Null() {
        try {
            instance.addSendStimuli((Collection<Stimulus>) null);
            fail("IllegalArgumentException is expected.");
        } catch (IllegalArgumentException e) {
            // ok
        }
    }

    /**
     * Test <code>addSendStimuli</code> with a collection which contains a null element.
     * <p>
     * IllegalArgumentException is expected.
     * </p>
     */
    public void testAddSendStimuli_NullElement() {
        Collection<Stimulus> stimuli = new ArrayList<Stimulus>();
        stimuli.add(new StimulusImpl());
        stimuli.add(null);

        try {
            instance.addSendStimuli(stimuli);
            fail("IllegalArgumentException is expected.");
        } catch (IllegalArgumentException e) {
            assertEquals("sendStimuli collection shouldn't be changed.",
                    0, instance.countSendStimuli());
        }
    }

    /**
     * Test <code>removeSendStimulus</code> with a null param.
     * <p>
     * IllegalArgumentException is expected.
     * </p>
     */
    public void testRemoveSendStimulus_Null() {
        try {
            instance.removeSendStimulus((Stimulus) null);
            fail("IllegalArgumentException is expected.");
        } catch (IllegalArgumentException e) {
            // ok
        }
    }

    /**
     * Test <code>removeSendStimuli</code> with a null param.
     * <p>
     * IllegalArgumentException is expected.
     * </p>
     */
    public void testRemoveSendStimuli_Null() {
        try {
            instance.removeSendStimuli((Collection<Stimulus>) null);
            fail("IllegalArgumentException is expected.");
        } catch (IllegalArgumentException e) {
            // ok
        }
    }

    /**
     * Test <code>removeSendStimuli</code> with a collection which contains a null element.
     * <p>
     * IllegalArgumentException is expected.
     * </p>
     */
    public void testRemoveSendStimuli_NullElement() {
        Stimulus stimulus = new StimulusImpl();
        instance.addSendStimulus(stimulus);

        Collection<Stimulus> stimuli = new ArrayList<Stimulus>();
        stimuli.add(stimulus);
        stimuli.add(null);

        try {
            instance.removeSendStimuli(stimuli);
            fail("IllegalArgumentException is expected.");
        } catch (IllegalArgumentException e) {
            assertEquals("sendStimuli collection shouldn't be changed.",
                    1, instance.countSendStimuli());
        }
    }

    /**
     * Test <code>containsSendStimuli</code> with a null param.
     * <p>
     * IllegalArgumentException is expected.
     * </p>
     */
    public void testContainsSendStimuli_Null() {
        try {
            instance.containsSendStimulus((Stimulus) null);
            fail("IllegalArgumentException is expected.");
        } catch (IllegalArgumentException e) {
            // ok
        }
    }

    /**
     * Test <code>addReceiveStimulus</code> with a null param.
     * <p>
     * IllegalArgumentException is expected.
     * </p>
     */
    public void testAddReceiveStimulus_Null() {
        try {
            instance.addReceiveStimulus((Stimulus) null);
            fail("IllegalArgumentException is expected.");
        } catch (IllegalArgumentException e) {
            // ok
        }
    }

    /**
     * Test <code>addReceiveStimuli</code> with a null param.
     * <p>
     * IllegalArgumentException is expected.
     * </p>
     */
    public void testAddReceiveStimuli_Null() {
        try {
            instance.addReceiveStimuli((Collection<Stimulus>) null);
            fail("IllegalArgumentException is expected.");
        } catch (IllegalArgumentException e) {
            // ok
        }
    }

    /**
     * Test <code>addReceiveStimuli</code> with a collection which contains a null element.
     * <p>
     * IllegalArgumentException is expected.
     * </p>
     */
    public void testAddReceiveStimuli_NullElement() {
        Collection<Stimulus> stimuli = new ArrayList<Stimulus>();
        stimuli.add(new StimulusImpl());
        stimuli.add(null);

        try {
            instance.addReceiveStimuli(stimuli);
            fail("IllegalArgumentException is expected.");
        } catch (IllegalArgumentException e) {
            assertEquals("receiveStimuli collection shouldn't be changed.",
                    0, instance.countReceiveStimuli());
        }
    }

    /**
     * Test <code>removeReceiveStimulus</code> with a null param.
     * <p>
     * IllegalArgumentException is expected.
     * </p>
     */
    public void testRemoveReceiveStimulus_Null() {
        try {
            instance.removeReceiveStimulus((Stimulus) null);
            fail("IllegalArgumentException is expected.");
        } catch (IllegalArgumentException e) {
            // ok
        }
    }

    /**
     * Test <code>removeReceiveStimuli</code> with a null param.
     * <p>
     * IllegalArgumentException is expected.
     * </p>
     */
    public void testRemoveReceiveStimuli_Null() {
        try {
            instance.removeReceiveStimuli((Collection<Stimulus>) null);
            fail("IllegalArgumentException is expected.");
        } catch (IllegalArgumentException e) {
            // ok
        }
    }

    /**
     * Test <code>removeReceiveStimuli</code> with a collection which contains a null element.
     * <p>
     * IllegalArgumentException is expected.
     * </p>
     */
    public void testRemoveReceiveStimuli_NullElement() {
        Stimulus stimulus = new StimulusImpl();
        instance.addReceiveStimulus(stimulus);

        Collection<Stimulus> stimuli = new ArrayList<Stimulus>();
        stimuli.add(stimulus);
        stimuli.add(null);

        try {
            instance.removeReceiveStimuli(stimuli);
            fail("IllegalArgumentException is expected.");
        } catch (IllegalArgumentException e) {
            assertEquals("receiveStimuli collection shouldn't be changed.",
                    1, instance.countReceiveStimuli());
        }
    }

    /**
     * Test <code>containsReceiveStimuli</code> with a null param.
     * <p>
     * IllegalArgumentException is expected.
     * </p>
     */
    public void testContainsReceiveStimuli_Null() {
        try {
            instance.containsReceiveStimulus((Stimulus) null);
            fail("IllegalArgumentException is expected.");
        } catch (IllegalArgumentException e) {
            // ok
        }
    }
}
