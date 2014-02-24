/*
 * Copyright (C) 2006 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.uml.model.commonbehavior.failuretests;

import java.util.ArrayList;
import java.util.Collection;

import com.topcoder.uml.model.commonbehavior.instances.Stimulus;
import com.topcoder.uml.model.commonbehavior.instances.StimulusImpl;
import com.topcoder.uml.model.commonbehavior.links.LinkEnd;
import com.topcoder.uml.model.commonbehavior.links.LinkEndImpl;
import com.topcoder.uml.model.commonbehavior.links.LinkImpl;

import junit.framework.TestCase;

/**
 * Failure tests for <code>LinkImpl</code>.
 *
 * @author mayi
 * @version 1.0
 */
public class LinkImplFailureTests extends TestCase {

    /**
     * A <code>LinkImpl</code> to test.
     */
    private LinkImpl link = null;

    /**
     * Create the <code>link</code> instance to test.
     */
    protected void setUp() throws Exception {
        super.setUp();

        link = new LinkImpl();
    }

    /**
     * Test <code>AddConnection(LinkEnd)</code> with null param.
     * <p>
     * IllegalArgumentException is expected.
     * </p>
     */
    public void testAddConnectionLinkEnd_Null() {
        try {
            link.addConnection((LinkEnd) null);
            fail("IllegalArgumentException is expected.");
        } catch (IllegalArgumentException e) {
            // ok
        }
    }

    /**
     * Test <code>AddConnection(int, LinkEnd)</code> with null param.
     * <p>
     * IllegalArgumentException is expected.
     * </p>
     */
    public void testAddConnectionIntLinkEnd_Null() {
        try {
            link.addConnection(0, (LinkEnd) null);
            fail("IllegalArgumentException is expected.");
        } catch (IllegalArgumentException e) {
            // ok
        }
    }

    /**
     * Test <code>AddConnection(int, LinkEnd)</code> with negative index.
     * <p>
     * IndexOutOfBoundsException is expected.
     * </p>
     */
    public void testAddConnectionIntLinkEnd_SmallIndex() {
        link.addConnection(new LinkEndImpl());

        try {
            link.addConnection(-1, new LinkEndImpl());
            fail("IndexOutOfBoundsException is expected.");
        } catch (IndexOutOfBoundsException e) {
            // ok
        }
    }

    /**
     * Test <code>AddConnection(int, LinkEnd)</code> with too big index.
     * <p>
     * IndexOutOfBoundsException is expected.
     * </p>
     */
    public void testAddConnectionIntLinkEnd_BigIndex() {
        link.addConnection(new LinkEndImpl());

        try {
            link.addConnection(2, new LinkEndImpl());
            fail("IndexOutOfBoundsException is expected.");
        } catch (IndexOutOfBoundsException e) {
            // ok
        }
    }

    /**
     * Test <code>addConnections(Collection)</code> with null param.
     * <p>
     * IllegalArgumentException is expected.
     * </p>
     */
    public void testAddConnectionsCollection_Null() {
        try {
            link.addConnections((Collection<LinkEnd>) null);
            fail("IllegalArgumentException is expected.");
        } catch (IllegalArgumentException e) {
            // ok
        }
    }

    /**
     * Test <code>addConnections(Collection)</code> with a collection which
     * contains null element.
     * <p>
     * IllegalArgumentException is expected.
     * </p>
     */
    public void testAddConnectionsCollection_NullElement() {
        Collection<LinkEnd> ends = new ArrayList<LinkEnd>();
        ends.add(new LinkEndImpl());
        ends.add(null);

        try {
            link.addConnections(ends);
            fail("IllegalArgumentException is expected.");
        } catch (IllegalArgumentException e) {
            assertEquals("connections collection shouldn't be changed.",
                    0, link.countConnections());
        }
    }

    /**
     * Test <code>addConnections(int, Collection)</code> with null param.
     * <p>
     * IllegalArgumentException is expected.
     * </p>
     */
    public void testAddConnectionsIntCollection_Null() {
        try {
            link.addConnections(0, (Collection<LinkEnd>) null);
            fail("IllegalArgumentException is expected.");
        } catch (IllegalArgumentException e) {
            // ok
        }
    }

    /**
     * Test <code>addConnections(int, Collection)</code> with a collection which
     * contains null element.
     * <p>
     * IllegalArgumentException is expected.
     * </p>
     */
    public void testAddConnectionsIntCollection_NullElement() {
        Collection<LinkEnd> ends = new ArrayList<LinkEnd>();
        ends.add(new LinkEndImpl());
        ends.add(null);

        try {
            link.addConnections(0, ends);
            fail("IllegalArgumentException is expected.");
        } catch (IllegalArgumentException e) {
            assertEquals("connections collection shouldn't be changed.",
                    0, link.countConnections());
        }
    }

    /**
     * Test <code>addConnections(int, Collection)</code> with a negative index.
     * <p>
     * IndexOutOfBoundsException is expected.
     * </p>
     */
    public void testAddConnectionsIntCollection_SmallIndex() {
        Collection<LinkEnd> ends = new ArrayList<LinkEnd>();
        ends.add(new LinkEndImpl());

        try {
            link.addConnections(-2, ends);
            fail("IndexOutOfBoundsException is expected.");
        } catch (IndexOutOfBoundsException e) {
            // ok
        }
    }

    /**
     * Test <code>addConnections(int, Collection)</code> with a too big index.
     * <p>
     * IndexOutOfBoundsException is expected.
     * </p>
     */
    public void testAddConnectionsIntCollection_BigIndex() {
        Collection<LinkEnd> ends = new ArrayList<LinkEnd>();
        ends.add(new LinkEndImpl());

        try {
            link.addConnections(1, ends);
            fail("IndexOutOfBoundsException is expected.");
        } catch (IndexOutOfBoundsException e) {
            // ok
        }
    }

    /**
     * Test <code>setConnection(int, LinkEnd)</code> with null param.
     * <p>
     * IllegalArgumentException is expected.
     * </p>
     */
    public void testSetConnectionIntLinkEnd_Null() {
        link.addConnection(new LinkEndImpl());

        try {
            link.setConnection(0, (LinkEnd) null);
            fail("IllegalArgumentException is expected.");
        } catch (IllegalArgumentException e) {
            // ok
        }
    }

    /**
     * Test <code>setConnection(int, LinkEnd)</code> with a negative index.
     * <p>
     * IndexOutOfBoundsException is expected.
     * </p>
     */
    public void testSetConnectionIntLinkEnd_SmallIndex() {
        link.addConnection(new LinkEndImpl());
        link.addConnection(new LinkEndImpl());

        try {
            link.setConnection(-1, new LinkEndImpl());
            fail("IndexOutOfBoundsException is expected.");
        } catch (IndexOutOfBoundsException e) {
            // ok
        }
    }

    /**
     * Test <code>setConnection(int, LinkEnd)</code> with a too big index.
     * <p>
     * IndexOutOfBoundsException is expected.
     * </p>
     */
    public void testSetConnectionIntLinkEnd_BigIndex() {
        link.addConnection(new LinkEndImpl());
        link.addConnection(new LinkEndImpl());

        try {
            link.setConnection(2, new LinkEndImpl());
            fail("IndexOutOfBoundsException is expected.");
        } catch (IndexOutOfBoundsException e) {
            // ok
        }
    }


    /**
     * Test <code>removeConnection(int)</code> with a negative index.
     * <p>
     * IndexOutOfBoundsException is expected.
     * </p>
     */
    public void testRemoveConnectionInt_SmallIndex() {
        link.addConnection(new LinkEndImpl());
        link.addConnection(new LinkEndImpl());

        try {
            link.removeConnection(-1);
            fail("IndexOutOfBoundsException is expected.");
        } catch (IndexOutOfBoundsException e) {
            // ok
        }
    }

    /**
     * Test <code>removeConnection(int)</code> with a too big index.
     * <p>
     * IndexOutOfBoundsException is expected.
     * </p>
     */
    public void testRemoveConnectionInt_BigIndex() {
        link.addConnection(new LinkEndImpl());
        link.addConnection(new LinkEndImpl());

        try {
            link.removeConnection(2);
            fail("IndexOutOfBoundsException is expected.");
        } catch (IndexOutOfBoundsException e) {
            // ok
        }
    }

    /**
     * Test <code>removeConnection(LinkEnd)</code> with null param.
     * <p>
     * IllegalArgumentException is expected.
     * </p>
     */
    public void testRemoveConnectionLinkEnd_Null() {
        link.addConnection(new LinkEndImpl());

        try {
            link.removeConnection((LinkEnd) null);
            fail("IllegalArgumentException is expected.");
        } catch (IllegalArgumentException e) {
            // ok
        }
    }

    /**
     * Test <code>removeConnections(Collection)</code> with null param.
     * <p>
     * IllegalArgumentException is expected.
     * </p>
     */
    public void testRemoveConnections_Null() {
        try {
            link.removeConnections((Collection<LinkEnd>) null);
            fail("IllegalArgumentException is expected.");
        } catch (IllegalArgumentException e) {
            // ok
        }
    }

    /**
     * Test <code>removeConnections(Collection)</code> with a collection which
     * contains null element.
     * <p>
     * IllegalArgumentException is expected.
     * </p>
     */
    public void testRemoveConnections_NullElement() {
        LinkEnd linkEnd = new LinkEndImpl();
        link.addConnection(linkEnd);

        Collection<LinkEnd> ends = new ArrayList<LinkEnd>();
        ends.add(linkEnd);
        ends.add(null);

        try {
            link.removeConnections(ends);
            fail("IllegalArgumentException is expected.");
        } catch (IllegalArgumentException e) {
            assertEquals("connections collection shouldn't be changed.",
                    1, link.countConnections());
        }
    }

    /**
     * Test <code>containsConnection(LinkEnd)</code> with null param.
     * <p>
     * IllegalArgumentException is expected.
     * </p>
     */
    public void testContainsConnection_Null() {
        link.addConnection(new LinkEndImpl());

        try {
            link.containsConnection((LinkEnd) null);
            fail("IllegalArgumentException is expected.");
        } catch (IllegalArgumentException e) {
            // ok
        }
    }

    /**
     * Test <code>indexOfConnection(LinkEnd)</code> with null param.
     * <p>
     * IllegalArgumentException is expected.
     * </p>
     */
    public void testIndexOfConnection_Null() {
        link.addConnection(new LinkEndImpl());

        try {
            link.indexOfConnection((LinkEnd) null);
            fail("IllegalArgumentException is expected.");
        } catch (IllegalArgumentException e) {
            // ok
        }
    }



    /**
     * Test <code>addStimulus</code> with a null param.
     * <p>
     * IllegalArgumentException is expected.
     * </p>
     */
    public void testAddStimulus_Null() {
        try {
            link.addStimulus((Stimulus) null);
            fail("IllegalArgumentException is expected.");
        } catch (IllegalArgumentException e) {
            // ok
        }
    }

    /**
     * Test <code>addStimuli</code> with a null param.
     * <p>
     * IllegalArgumentException is expected.
     * </p>
     */
    public void testAddStimuli_Null() {
        try {
            link.addStimuli((Collection<Stimulus>) null);
            fail("IllegalArgumentException is expected.");
        } catch (IllegalArgumentException e) {
            // ok
        }
    }

    /**
     * Test <code>addStimuli</code> with a collection which contains a null element.
     * <p>
     * IllegalArgumentException is expected.
     * </p>
     */
    public void testAddStimuli_NullElement() {
        Collection<Stimulus> stimuli = new ArrayList<Stimulus>();
        stimuli.add(new StimulusImpl());
        stimuli.add(null);

        try {
            link.addStimuli(stimuli);
            fail("IllegalArgumentException is expected.");
        } catch (IllegalArgumentException e) {
            assertEquals("stimuli collection shouldn't be changed.",
                    0, link.countStimuli());
        }
    }

    /**
     * Test <code>removeStimulus</code> with a null param.
     * <p>
     * IllegalArgumentException is expected.
     * </p>
     */
    public void testRemoveStimulus_Null() {
        try {
            link.removeStimulus((Stimulus) null);
            fail("IllegalArgumentException is expected.");
        } catch (IllegalArgumentException e) {
            // ok
        }
    }

    /**
     * Test <code>removeStimuli</code> with a null param.
     * <p>
     * IllegalArgumentException is expected.
     * </p>
     */
    public void testRemoveStimuli_Null() {
        try {
            link.removeStimuli((Collection<Stimulus>) null);
            fail("IllegalArgumentException is expected.");
        } catch (IllegalArgumentException e) {
            // ok
        }
    }

    /**
     * Test <code>removeStimuli</code> with a collection which contains a null element.
     * <p>
     * IllegalArgumentException is expected.
     * </p>
     */
    public void testRemoveStimuli_NullElement() {
        Stimulus stimulus = new StimulusImpl();
        link.addStimulus(stimulus);

        Collection<Stimulus> stimuli = new ArrayList<Stimulus>();
        stimuli.add(stimulus);
        stimuli.add(null);

        try {
            link.removeStimuli(stimuli);
            fail("IllegalArgumentException is expected.");
        } catch (IllegalArgumentException e) {
            assertEquals("stimuli collection shouldn't be changed.",
                    1, link.countStimuli());
        }
    }

    /**
     * Test <code>containsStimuli</code> with a null param.
     * <p>
     * IllegalArgumentException is expected.
     * </p>
     */
    public void testContainsStimuli_Null() {
        try {
            link.containsStimulus((Stimulus) null);
            fail("IllegalArgumentException is expected.");
        } catch (IllegalArgumentException e) {
            // ok
        }
    }

}
