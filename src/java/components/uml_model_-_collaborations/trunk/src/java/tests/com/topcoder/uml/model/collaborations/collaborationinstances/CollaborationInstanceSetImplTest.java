/*
 * Copyright (C) 2006 TopCoder Inc., All Rights Reserved.
 *
 * TCS UML Model - Collaborations Version 1.0
 *
 * @ CollaborationInstanceSetImplTest.java
 */
package com.topcoder.uml.model.collaborations.collaborationinstances;

import java.util.ArrayList;
import java.util.Collection;

import com.topcoder.uml.model.collaborations.collaborationinteractions.Collaboration;
import com.topcoder.uml.model.collaborations.collaborationinteractions.CollaborationImpl;
import com.topcoder.uml.model.commonbehavior.instances.Instance;
import com.topcoder.uml.model.commonbehavior.instances.MockInstance;
import com.topcoder.uml.model.commonbehavior.links.Link;
import com.topcoder.uml.model.commonbehavior.links.MockLink;

import junit.framework.TestCase;

/**
 * <p>Tests for CollaborationInstanceSetImpl class.</p>
 *
 * @author yinzi
 * @version 1.0
 */
public class CollaborationInstanceSetImplTest extends TestCase {
    /**
     * <p>MessageImpl used for testing. It is instantiated in SetUp.</p>
     */
    private CollaborationInstanceSetImpl collaborationInstanceSetImpl;

    /**
     * <p>Sets up test environment, creates object used for test.</p>
     */
    public void setUp() {
        collaborationInstanceSetImpl = new CollaborationInstanceSetImpl();
    }

    /**
     * <p>Tears down test environment, disposes object used for test.</p>
     */
    public void tearDown() {
        collaborationInstanceSetImpl = null;
    }

    /**
     * <p>Tests inheritance of <c>CollaborationInstanceSetImpl</c>.</p>
     * <p><c>CollaborationInstanceSetImpl</c> should inherit from <c>CollaborationInstanceSet</c>.</p>
     */
    public void testCollaborationInstanceSetImplAccuracyInheritCollaborationInstanceSet() {
        assertEquals("MessageImpl should inherit from Message.",
                true, collaborationInstanceSetImpl instanceof CollaborationInstanceSet);
    }

    /**
     * <p>Tests accuracy of <c>CollaborationInstanceSetImpl</c>.</p>
     * <p>Value should be set correctly.</p>
     */
    public void testCollaborationInstanceSetImplAccuracy() {
        assertEquals("Value should be gotten correctly.",
                null, collaborationInstanceSetImpl.getCollaboration());
        assertEquals("Value should be gotten correctly.",
                0, collaborationInstanceSetImpl.countParticipatingInstances());
        assertEquals("Value should be gotten correctly.",
                0, collaborationInstanceSetImpl.countParticipatingLinks());
    }

    /**
     * <p>Tests accuracy of <c>getCollaboration</c> method.</p>
     * <p>Value should be gotten correctly.</p>
     */
    public void testGetConformingStimulusAccuracy() {
        assertEquals("Value should be gotten correctly.", null, collaborationInstanceSetImpl.getCollaboration());
        Collaboration testObj = new CollaborationImpl();
        collaborationInstanceSetImpl.setCollaboration(testObj);
        assertEquals("Value should be gotten correctly.", testObj, collaborationInstanceSetImpl.getCollaboration());
    }

    /**
     * <p>Tests accuracy of <c>setCollaboration</c> method.</p>
     * <p>Value should be set correctly.</p>
     */
    public void testSetConformingStimulusAccuracy() {
        assertEquals("Value should be gotten correctly.", null, collaborationInstanceSetImpl.getCollaboration());
        Collaboration testObj = new CollaborationImpl();
        collaborationInstanceSetImpl.setCollaboration(testObj);
        assertEquals("Value should be gotten correctly.", testObj, collaborationInstanceSetImpl.getCollaboration());
    }

    /**
     * <p>Tests <c>addParticipatingInstance(Instance)</c> method with null parameter.</p>
     * <p>IllegalArgumentException should be thrown.</p>
     */
    public void testAddParticipatingInstance_Null() {
        try {
            collaborationInstanceSetImpl.addParticipatingInstance((Instance) null);
            fail("IllegalArgumentException expected");
        } catch (IllegalArgumentException e) {
            // ok
        }
    }

    /**
     * <p>Tests accuracy of <c>addParticipatingInstance(Instance)</c>.</p>
     * <p>Value should be set correctly.</p>
     */
    public void testAddParticipatingInstance_Accuracy() {
        Instance testObj = new MockInstance();
        assertEquals("Value should be gotten correctly.",
                false, collaborationInstanceSetImpl.containsParticipatingInstance(testObj));
        collaborationInstanceSetImpl.addParticipatingInstance(testObj);
        assertEquals("Value should be gotten correctly.",
                true, collaborationInstanceSetImpl.containsParticipatingInstance(testObj));
    }

    /**
     * <p>Tests <c>addParticipatingInstance(Collection)</c> method with null parameter.</p>
     * <p>IllegalArgumentException should be thrown.</p>
     */
    public void testAddParticipatingInstances_Null() {
        try {
            collaborationInstanceSetImpl.addParticipatingInstances((Collection<Instance>) null);
            fail("IllegalArgumentException expected");
        } catch (IllegalArgumentException e) {
            // ok
        }
    }

    /**
     * <p>Tests <c>addParticipatingInstance(Collection)</c> method with collection contans
     * null parameter.</p>
     * <p>IllegalArgumentException should be thrown.</p>
     */
    public void testAddParticipatingInstances_ContainsNull() {
        try {
            Collection<Instance> collection = new ArrayList<Instance>();
            collection.add(new MockInstance());
            collection.add(null);
            collaborationInstanceSetImpl.addParticipatingInstances(collection);
            fail("IllegalArgumentException expected");
        } catch (IllegalArgumentException e) {
            // ok
        }
    }

    /**
     * <p>Tests accuracy of <c>addParticipatingInstance(Collection)</c>.</p>
     * <p>Value should be set correctly.</p>
     */
    public void testAddParticipatingInstances_Accuracy() {
        Collection<Instance> collection = new ArrayList<Instance>();
        Instance testObj1 = new MockInstance();
        collection.add(testObj1);
        Instance testObj2 = new MockInstance();
        collection.add(testObj2);

        assertEquals("Value should be gotten correctly.",
                false, collaborationInstanceSetImpl.containsParticipatingInstance(testObj1));
        assertEquals("Value should be gotten correctly.",
                false, collaborationInstanceSetImpl.containsParticipatingInstance(testObj2));
        collaborationInstanceSetImpl.addParticipatingInstances(collection);
        assertEquals("Value should be gotten correctly.",
                true, collaborationInstanceSetImpl.containsParticipatingInstance(testObj1));
        assertEquals("Value should be gotten correctly.",
                true, collaborationInstanceSetImpl.containsParticipatingInstance(testObj2));
    }

    /**
     * <p>Tests <c>removeParticipatingInstance(Instance)</c> method with null parameter.</p>
     * <p>IllegalArgumentException should be thrown.</p>
     */
    public void testRemoveParticipatingInstance_Null() {
        try {
            collaborationInstanceSetImpl.removeParticipatingInstance((Instance) null);
            fail("IllegalArgumentException expected");
        } catch (IllegalArgumentException e) {
            // ok
        }
    }

    /**
     * <p>Tests accuracy of <c>removeParticipatingInstance(Instance)</c>.</p>
     * <p>Value should be set correctly.</p>
     */
    public void testRemoveParticipatingInstance_Accuracy1() {
        Instance testObj = new MockInstance();
        collaborationInstanceSetImpl.addParticipatingInstance(testObj);
        collaborationInstanceSetImpl.addParticipatingInstance(testObj);

        assertEquals("Value should be gotten correctly.",
                true, collaborationInstanceSetImpl.removeParticipatingInstance(testObj));
        assertEquals("Value should be gotten correctly.",
                true, collaborationInstanceSetImpl.containsParticipatingInstance(testObj));
        assertEquals("Value should be gotten correctly.",
                true, collaborationInstanceSetImpl.removeParticipatingInstance(testObj));
        assertEquals("Value should be gotten correctly.",
                false, collaborationInstanceSetImpl.containsParticipatingInstance(testObj));
        assertEquals("Value should be gotten correctly.",
                false, collaborationInstanceSetImpl.removeParticipatingInstance(testObj));
    }

    /**
     * <p>Tests accuracy of <c>removeParticipatingInstance(Instance)</c>.</p>
     * <p>Value should be set correctly.</p>
     */
    public void testRemoveParticipatingInstance_Accuracy2() {
        Instance testObj = new MockInstance();
        collaborationInstanceSetImpl.addParticipatingInstance(testObj);

        assertEquals("Value should be gotten correctly.",
                true, collaborationInstanceSetImpl.removeParticipatingInstance(testObj));
        assertEquals("Value should be gotten correctly.",
                false, collaborationInstanceSetImpl.containsParticipatingInstance(testObj));
        assertEquals("Value should be gotten correctly.",
                false, collaborationInstanceSetImpl.removeParticipatingInstance(testObj));
        assertEquals("Value should be gotten correctly.",
                false, collaborationInstanceSetImpl.containsParticipatingInstance(testObj));
    }

    /**
     * <p>Tests <c>removeParticipatingInstances(Collection)</c> method with null parameter.</p>
     * <p>IllegalArgumentException should be thrown.</p>
     */
    public void testRemoveParticipatingInstances_Null() {
        try {
            collaborationInstanceSetImpl.removeParticipatingInstances((Collection<Instance>) null);
            fail("IllegalArgumentException expected");
        } catch (IllegalArgumentException e) {
            // ok
        }
    }

    /**
     * <p>Tests <c>removeParticipatingInstances(Collection)</c> method with collection contains null parameter.</p>
     * <p>IllegalArgumentException should be thrown.</p>
     */
    public void testRemoveParticipatingInstances_ConainsNull() {
        try {
            Collection<Instance> collection = new ArrayList<Instance>();
            collection.add(new MockInstance());
            collection.add(null);
            collaborationInstanceSetImpl.removeParticipatingInstances(collection);
            fail("IllegalArgumentException expected");
        } catch (IllegalArgumentException e) {
            // ok
        }
    }

    /**
     * <p>Tests accuracy of <c>removeParticipatingInstances(Instance)</c>.</p>
     * <p>Value should be set correctly.</p>
     */
    public void testRemoveParticipatingInstances_Accuracy1() {
        Instance testObj1 = new MockInstance();
        Instance testObj2 = new MockInstance();
        collaborationInstanceSetImpl.addParticipatingInstance(testObj1);
        collaborationInstanceSetImpl.addParticipatingInstance(testObj2);
        collaborationInstanceSetImpl.addParticipatingInstance(testObj1);

        Collection<Instance> collection = new ArrayList<Instance>();
        collection.add(testObj1);
        collection.add(testObj2);
        assertEquals("Value should be gotten correctly.",
                true, collaborationInstanceSetImpl.containsParticipatingInstance(testObj1));
        assertEquals("Value should be gotten correctly.",
                true, collaborationInstanceSetImpl.containsParticipatingInstance(testObj2));
        assertEquals("Value should be gotten correctly.",
                true, collaborationInstanceSetImpl.removeParticipatingInstances(collection));

        assertEquals("Value should be gotten correctly.",
                true, collaborationInstanceSetImpl.containsParticipatingInstance(testObj1));
        assertEquals("Value should be gotten correctly.",
                false, collaborationInstanceSetImpl.containsParticipatingInstance(testObj2));
    }

    /**
     * <p>Tests accuracy of <c>removeParticipatingInstances(Instance)</c>.</p>
     * <p>Value should be set correctly.</p>
     */
    public void testRemoveParticipatingInstances_Accuracy2() {
        Instance testObj1 = new MockInstance();
        Instance testObj2 = new MockInstance();
        collaborationInstanceSetImpl.addParticipatingInstance(testObj1);
        collaborationInstanceSetImpl.addParticipatingInstance(testObj2);

        Collection<Instance> collection = new ArrayList<Instance>();
        collection.add(testObj1);
        collection.add(testObj2);
        assertEquals("Value should be gotten correctly.",
                true, collaborationInstanceSetImpl.containsParticipatingInstance(testObj1));
        assertEquals("Value should be gotten correctly.",
                true, collaborationInstanceSetImpl.containsParticipatingInstance(testObj2));
        assertEquals("Value should be gotten correctly.",
                true, collaborationInstanceSetImpl.removeParticipatingInstances(collection));

        assertEquals("Value should be gotten correctly.",
                false, collaborationInstanceSetImpl.containsParticipatingInstance(testObj1));
        assertEquals("Value should be gotten correctly.",
                false, collaborationInstanceSetImpl.containsParticipatingInstance(testObj2));
        assertEquals("Value should be gotten correctly.",
                false, collaborationInstanceSetImpl.removeParticipatingInstances(collection));

    }

    /**
     * <p>Tests accuracy of <c>clearParticipatingInstances()</c>.</p>
     * <p>Value should be set correctly.</p>
     */
    public void testClearParticipatingInstances_Accuracy() {
        Instance testObj1 = new MockInstance();
        Instance testObj2 = new MockInstance();
        collaborationInstanceSetImpl.addParticipatingInstance(testObj1);
        collaborationInstanceSetImpl.addParticipatingInstance(testObj2);
        assertEquals("Value should be gotten correctly.",
                2, collaborationInstanceSetImpl.countParticipatingInstances());
        collaborationInstanceSetImpl.clearParticipatingInstances();
        assertEquals("Value should be gotten correctly.",
                0, collaborationInstanceSetImpl.countParticipatingInstances());
    }

    /**
     * <p>Tests accuracy of <c>getParticipatingInstances()</c>.</p>
     * <p>Value should be set correctly.</p>
     */
    public void testGetParticipatingInstances_Accuracy() {
        Instance testObj1 = new MockInstance();
        Instance testObj2 = new MockInstance();
        Instance testObj3 = new MockInstance();
        collaborationInstanceSetImpl.addParticipatingInstance(testObj1);
        collaborationInstanceSetImpl.addParticipatingInstance(testObj2);
        collaborationInstanceSetImpl.addParticipatingInstance(testObj2);
        Collection<Instance> collection = collaborationInstanceSetImpl.getParticipatingInstances();
        assertEquals("Value should be gotten correctly.",
                true, collection.contains(testObj1));
        assertEquals("Value should be gotten correctly.",
                true, collection.contains(testObj2));
        assertEquals("Value should be gotten correctly.",
                false, collection.contains(testObj3));
    }

    /**
     * <p>Tests <c>containsParticipatingInstance(Instance)</c> method with null parameter.</p>
     * <p>IllegalArgumentException should be thrown.</p>
     */
    public void testContainsParticipatingInstance_Null() {
        try {
            collaborationInstanceSetImpl.containsParticipatingInstance((Instance) null);
            fail("IllegalArgumentException expected");
        } catch (IllegalArgumentException e) {
            // ok
        }
    }

    /**
     * <p>Tests accuracy of <c>containsParticipatingInstance(Instance)</c>.</p>
     * <p>Value should be set correctly.</p>
     */
    public void testContainsParticipatingInstance_Accuracy() {
        Instance testObj = new MockInstance();
        assertEquals("Value should be gotten correctly.",
                false, collaborationInstanceSetImpl.containsParticipatingInstance(testObj));
        collaborationInstanceSetImpl.addParticipatingInstance(testObj);
        assertEquals("Value should be gotten correctly.",
                true, collaborationInstanceSetImpl.containsParticipatingInstance(testObj));
    }

    /**
     * <p>Tests accuracy of <c>countParticipatingInstances()</c>.</p>
     * <p>Value should be set correctly.</p>
     */
    public void testcountParticipatingInstances_Accuracy() {
        assertEquals("Value should be gotten correctly.",
                0, collaborationInstanceSetImpl.countParticipatingInstances());
        Instance testObj = new MockInstance();
        collaborationInstanceSetImpl.addParticipatingInstance(testObj);
        assertEquals("Value should be gotten correctly.",
                1, collaborationInstanceSetImpl.countParticipatingInstances());
        collaborationInstanceSetImpl.addParticipatingInstance(testObj);
        collaborationInstanceSetImpl.addParticipatingInstance(testObj);
        assertEquals("Value should be gotten correctly.",
                3, collaborationInstanceSetImpl.countParticipatingInstances());
    }

    /**
     * <p>Tests <c>addParticipatingLink(Link)</c> method with null parameter.</p>
     * <p>IllegalArgumentException should be thrown.</p>
     */
    public void testAddParticipatingLink_Null() {
        try {
            collaborationInstanceSetImpl.addParticipatingLink((Link) null);
            fail("IllegalArgumentException expected");
        } catch (IllegalArgumentException e) {
            // ok
        }
    }

    /**
     * <p>Tests accuracy of <c>addParticipatingLink(Link)</c>.</p>
     * <p>Value should be set correctly.</p>
     */
    public void testAddParticipatingLink_Accuracy() {
        Link testObj = new MockLink();
        assertEquals("Value should be gotten correctly.",
                false, collaborationInstanceSetImpl.containsParticipatingLink(testObj));
        collaborationInstanceSetImpl.addParticipatingLink(testObj);
        assertEquals("Value should be gotten correctly.",
                true, collaborationInstanceSetImpl.containsParticipatingLink(testObj));
    }

    /**
     * <p>Tests <c>addParticipatingLink(Collection)</c> method with null parameter.</p>
     * <p>IllegalArgumentException should be thrown.</p>
     */
    public void testAddParticipatingLinks_Null() {
        try {
            collaborationInstanceSetImpl.addParticipatingLinks((Collection<Link>) null);
            fail("IllegalArgumentException expected");
        } catch (IllegalArgumentException e) {
            // ok
        }
    }

    /**
     * <p>Tests <c>addParticipatingLink(Collection)</c> method with collection contans
     * null parameter.</p>
     * <p>IllegalArgumentException should be thrown.</p>
     */
    public void testAddParticipatingLinks_ContainsNull() {
        try {
            Collection<Link> collection = new ArrayList<Link>();
            collection.add(new MockLink());
            collection.add(null);
            collaborationInstanceSetImpl.addParticipatingLinks(collection);
            fail("IllegalArgumentException expected");
        } catch (IllegalArgumentException e) {
            // ok
        }
    }

    /**
     * <p>Tests accuracy of <c>addParticipatingLink(Collection)</c>.</p>
     * <p>Value should be set correctly.</p>
     */
    public void testAddParticipatingLinks_Accuracy() {
        Collection<Link> collection = new ArrayList<Link>();
        Link testObj1 = new MockLink();
        collection.add(testObj1);
        Link testObj2 = new MockLink();
        collection.add(testObj2);

        assertEquals("Value should be gotten correctly.",
                false, collaborationInstanceSetImpl.containsParticipatingLink(testObj1));
        assertEquals("Value should be gotten correctly.",
                false, collaborationInstanceSetImpl.containsParticipatingLink(testObj2));
        collaborationInstanceSetImpl.addParticipatingLinks(collection);
        assertEquals("Value should be gotten correctly.",
                true, collaborationInstanceSetImpl.containsParticipatingLink(testObj1));
        assertEquals("Value should be gotten correctly.",
                true, collaborationInstanceSetImpl.containsParticipatingLink(testObj2));
    }

    /**
     * <p>Tests <c>removeParticipatingLink(Link)</c> method with null parameter.</p>
     * <p>IllegalArgumentException should be thrown.</p>
     */
    public void testRemoveParticipatingLink_Null() {
        try {
            collaborationInstanceSetImpl.removeParticipatingLink((Link) null);
            fail("IllegalArgumentException expected");
        } catch (IllegalArgumentException e) {
            // ok
        }
    }

    /**
     * <p>Tests accuracy of <c>removeParticipatingLink(Link)</c>.</p>
     * <p>Value should be set correctly.</p>
     */
    public void testRemoveParticipatingLink_Accuracy1() {
        Link testObj = new MockLink();
        collaborationInstanceSetImpl.addParticipatingLink(testObj);
        collaborationInstanceSetImpl.addParticipatingLink(testObj);

        assertEquals("Value should be gotten correctly.",
                true, collaborationInstanceSetImpl.removeParticipatingLink(testObj));
        assertEquals("Value should be gotten correctly.",
                true, collaborationInstanceSetImpl.containsParticipatingLink(testObj));
        assertEquals("Value should be gotten correctly.",
                true, collaborationInstanceSetImpl.removeParticipatingLink(testObj));
        assertEquals("Value should be gotten correctly.",
                false, collaborationInstanceSetImpl.containsParticipatingLink(testObj));
    }

    /**
     * <p>Tests accuracy of <c>removeParticipatingLink(Link)</c>.</p>
     * <p>Value should be set correctly.</p>
     */
    public void testRemoveParticipatingLink_Accuracy2() {
        Link testObj = new MockLink();
        collaborationInstanceSetImpl.addParticipatingLink(testObj);

        assertEquals("Value should be gotten correctly.",
                true, collaborationInstanceSetImpl.removeParticipatingLink(testObj));
        assertEquals("Value should be gotten correctly.",
                false, collaborationInstanceSetImpl.containsParticipatingLink(testObj));
        assertEquals("Value should be gotten correctly.",
                false, collaborationInstanceSetImpl.removeParticipatingLink(testObj));
        assertEquals("Value should be gotten correctly.",
                false, collaborationInstanceSetImpl.containsParticipatingLink(testObj));
    }

    /**
     * <p>Tests <c>removeParticipatingLinks(Collection)</c> method with null parameter.</p>
     * <p>IllegalArgumentException should be thrown.</p>
     */
    public void testRemoveParticipatingLinks_Null() {
        try {
            collaborationInstanceSetImpl.removeParticipatingLinks((Collection<Link>) null);
            fail("IllegalArgumentException expected");
        } catch (IllegalArgumentException e) {
            // ok
        }
    }

    /**
     * <p>Tests <c>removeParticipatingLinks(Collection)</c> method with collection contains null parameter.</p>
     * <p>IllegalArgumentException should be thrown.</p>
     */
    public void testRemoveParticipatingLinks_ConainsNull() {
        try {
            Collection<Link> collection = new ArrayList<Link>();
            collection.add(new MockLink());
            collection.add(null);
            collaborationInstanceSetImpl.removeParticipatingLinks(collection);
            fail("IllegalArgumentException expected");
        } catch (IllegalArgumentException e) {
            // ok
        }
    }

    /**
     * <p>Tests accuracy of <c>removeParticipatingLinks(Link)</c>.</p>
     * <p>Value should be set correctly.</p>
     */
    public void testRemoveParticipatingLinks_Accuracy1() {
        Link testObj1 = new MockLink();
        Link testObj2 = new MockLink();
        collaborationInstanceSetImpl.addParticipatingLink(testObj1);
        collaborationInstanceSetImpl.addParticipatingLink(testObj2);
        collaborationInstanceSetImpl.addParticipatingLink(testObj1);

        Collection<Link> collection = new ArrayList<Link>();
        collection.add(testObj1);
        collection.add(testObj2);
        assertEquals("Value should be gotten correctly.",
                true, collaborationInstanceSetImpl.containsParticipatingLink(testObj1));
        assertEquals("Value should be gotten correctly.",
                true, collaborationInstanceSetImpl.containsParticipatingLink(testObj2));
        assertEquals("Value should be gotten correctly.",
                true, collaborationInstanceSetImpl.removeParticipatingLinks(collection));
        assertEquals("Value should be gotten correctly.",
                true, collaborationInstanceSetImpl.containsParticipatingLink(testObj1));
        assertEquals("Value should be gotten correctly.",
                false, collaborationInstanceSetImpl.containsParticipatingLink(testObj2));
        assertEquals("Value should be gotten correctly.",
                true, collaborationInstanceSetImpl.removeParticipatingLinks(collection));
        assertEquals("Value should be gotten correctly.",
                false, collaborationInstanceSetImpl.containsParticipatingLink(testObj1));
        assertEquals("Value should be gotten correctly.",
                false, collaborationInstanceSetImpl.containsParticipatingLink(testObj2));
    }
    /**
     * <p>Tests accuracy of <c>removeParticipatingLinks(Link)</c>.</p>
     * <p>Value should be set correctly.</p>
     */
    public void testRemoveParticipatingLinks_Accuracy2() {
        Link testObj1 = new MockLink();
        Link testObj2 = new MockLink();
        collaborationInstanceSetImpl.addParticipatingLink(testObj1);
        collaborationInstanceSetImpl.addParticipatingLink(testObj2);

        Collection<Link> collection = new ArrayList<Link>();
        collection.add(testObj1);
        collection.add(testObj2);
        assertEquals("Value should be gotten correctly.",
                true, collaborationInstanceSetImpl.containsParticipatingLink(testObj1));
        assertEquals("Value should be gotten correctly.",
                true, collaborationInstanceSetImpl.containsParticipatingLink(testObj2));
        assertEquals("Value should be gotten correctly.",
                true, collaborationInstanceSetImpl.removeParticipatingLinks(collection));
        assertEquals("Value should be gotten correctly.",
                false, collaborationInstanceSetImpl.containsParticipatingLink(testObj1));
        assertEquals("Value should be gotten correctly.",
                false, collaborationInstanceSetImpl.containsParticipatingLink(testObj2));
        assertEquals("Value should be gotten correctly.",
                false, collaborationInstanceSetImpl.removeParticipatingLinks(collection));
    }

    /**
     * <p>Tests accuracy of <c>clearParticipatingLinks()</c>.</p>
     * <p>Value should be set correctly.</p>
     */
    public void testClearParticipatingLinks_Accuracy() {
        Link testObj1 = new MockLink();
        Link testObj2 = new MockLink();
        collaborationInstanceSetImpl.addParticipatingLink(testObj1);
        collaborationInstanceSetImpl.addParticipatingLink(testObj2);
        assertEquals("Value should be gotten correctly.",
                2, collaborationInstanceSetImpl.countParticipatingLinks());
        collaborationInstanceSetImpl.clearParticipatingLinks();
        assertEquals("Value should be gotten correctly.",
                0, collaborationInstanceSetImpl.countParticipatingLinks());
    }

    /**
     * <p>Tests accuracy of <c>getParticipatingLinks()</c>.</p>
     * <p>Value should be set correctly.</p>
     */
    public void testGetParticipatingLinks_Accuracy() {
        Link testObj1 = new MockLink();
        Link testObj2 = new MockLink();
        Link testObj3 = new MockLink();
        collaborationInstanceSetImpl.addParticipatingLink(testObj1);
        collaborationInstanceSetImpl.addParticipatingLink(testObj2);
        collaborationInstanceSetImpl.addParticipatingLink(testObj2);
        Collection<Link> collection = collaborationInstanceSetImpl.getParticipatingLinks();
        assertEquals("Value should be gotten correctly.",
                true, collection.contains(testObj1));
        assertEquals("Value should be gotten correctly.",
                true, collection.contains(testObj2));
        assertEquals("Value should be gotten correctly.",
                false, collection.contains(testObj3));
    }

    /**
     * <p>Tests <c>containsParticipatingLink(Link)</c> method with null parameter.</p>
     * <p>IllegalArgumentException should be thrown.</p>
     */
    public void testContainsParticipatingLink_Null() {
        try {
            collaborationInstanceSetImpl.containsParticipatingLink((Link) null);
            fail("IllegalArgumentException expected");
        } catch (IllegalArgumentException e) {
            // ok
        }
    }

    /**
     * <p>Tests accuracy of <c>containsParticipatingLink(Link)</c>.</p>
     * <p>Value should be set correctly.</p>
     */
    public void testContainsParticipatingLink_Accuracy() {
        Link testObj = new MockLink();
        assertEquals("Value should be gotten correctly.",
                false, collaborationInstanceSetImpl.containsParticipatingLink(testObj));
        collaborationInstanceSetImpl.addParticipatingLink(testObj);
        assertEquals("Value should be gotten correctly.",
                true, collaborationInstanceSetImpl.containsParticipatingLink(testObj));
    }

    /**
     * <p>Tests accuracy of <c>countParticipatingLinks()</c>.</p>
     * <p>Value should be set correctly.</p>
     */
    public void testcountParticipatingLinks_Accuracy() {
        assertEquals("Value should be gotten correctly.",
                0, collaborationInstanceSetImpl.countParticipatingLinks());
        Link testObj = new MockLink();
        collaborationInstanceSetImpl.addParticipatingLink(testObj);
        assertEquals("Value should be gotten correctly.",
                1, collaborationInstanceSetImpl.countParticipatingLinks());
        collaborationInstanceSetImpl.addParticipatingLink(testObj);
        collaborationInstanceSetImpl.addParticipatingLink(testObj);
        assertEquals("Value should be gotten correctly.",
                3, collaborationInstanceSetImpl.countParticipatingLinks());
    }

}
