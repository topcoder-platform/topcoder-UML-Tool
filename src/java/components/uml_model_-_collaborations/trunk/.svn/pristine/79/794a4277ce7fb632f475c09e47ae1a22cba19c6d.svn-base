/*
 * Copyright (C) 2006 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.uml.model.collaborations.stresstests;

import java.util.ArrayList;
import java.util.Collection;

import junit.framework.TestCase;

import com.topcoder.uml.model.collaborations.collaborationinstances.CollaborationInstanceSet;
import com.topcoder.uml.model.collaborations.collaborationinstances.CollaborationInstanceSetImpl;
import com.topcoder.uml.model.collaborations.collaborationinteractions.Collaboration;
import com.topcoder.uml.model.collaborations.collaborationinteractions.CollaborationImpl;
import com.topcoder.uml.model.commonbehavior.instances.Instance;
import com.topcoder.uml.model.commonbehavior.links.Link;
import com.topcoder.uml.model.commonbehavior.links.MockLink;
import com.topcoder.uml.model.commonbehavior.instances.MockInstance;

/**
 * This class will test <code>CollaborationInstanceSetImpl</code> class under large scale situation.
 *
 * @author slion
 * @version 1.0
 */
public class StressTestCollaborationInstanceSetImpl extends TestCase {
    /**
     * Represents the scale of processing the operation.
     */
    private static final int TOTAL_ITERATION = 10000;

    /**
     * Represents the CollaborationInstanceSet instance for testing.
     */
    private CollaborationInstanceSet set = null;

    /**
     * Set up environment.
     * @throws Exception to JUnit.
     */
    protected void setUp() throws Exception {
        set = new CollaborationInstanceSetImpl();
    }

    /**
     * Tear down.
     * @throws Exception to JUnit.
     */
    protected void tearDown() throws Exception {
        set = null;
    }

    /**
     * Test for creating instances under large scale.
     * @throws Exception to JUnit.
     */
    public void testCtorLargeScale() throws Exception {
        long start = System.currentTimeMillis();
        for (int i = 0; i < TOTAL_ITERATION; i++) {
            assertNotNull("Fail to create CollaborationInstanceSetImpl instance.",
                    new CollaborationInstanceSetImpl());
        }
        System.out.println("Creating " + TOTAL_ITERATION + " CollaborationInstanceSetImpl instances"
                + " with the first constructor costs:" + (System.currentTimeMillis() - start) + " ms");
    }

    /**
     * Test for calling setCollaboration(xxx) method under large scale.
     * @throws Exception to JUnit.
     */
    public void testSetCollaborationLargeScale() throws Exception {
        long start = System.currentTimeMillis();
        Collaboration collaboration = new CollaborationImpl();
        for (int i = 0; i < TOTAL_ITERATION; i++) {
            set.setCollaboration(collaboration);
        }
        assertEquals(set.getCollaboration(), collaboration);
        System.out.println("Calling " + TOTAL_ITERATION + " times setCollaboration method"
                + " costs:" + (System.currentTimeMillis() - start) + " ms");
    }

    /**
     * Test for calling getCollaboration(xxx) method under large scale.
     * @throws Exception to JUnit.
     */
    public void testGetCollaborationLargeScale() throws Exception {
        long start = System.currentTimeMillis();
        Collaboration collaboration = new CollaborationImpl();
        set.setCollaboration(collaboration);
        for (int i = 0; i < TOTAL_ITERATION; i++) {
            assertEquals("Should not null.", collaboration, set.getCollaboration());
        }
        System.out.println("Calling " + TOTAL_ITERATION + " times getCollaboration method"
                + " costs:" + (System.currentTimeMillis() - start) + " ms");
    }

    /**
     * Test for calling addParticipatingInstance(xxx) method under large scale.
     * @throws Exception to JUnit.
     */
    public void testAddParticipatingInstanceLargeScale() throws Exception {
        long start = System.currentTimeMillis();
        Instance instance = new MockInstance();
        for (int i = 0; i < TOTAL_ITERATION; i++) {
            set.addParticipatingInstance(instance);
        }
        assertTrue(set.containsParticipatingInstance(instance));
        System.out.println("Calling " + TOTAL_ITERATION + " times addParticipatingInstance method"
                + " costs:" + (System.currentTimeMillis() - start) + " ms");
    }

    /**
     * Test for calling addParticipatingInstances(xxx) method under large scale.
     * @throws Exception to JUnit.
     */
    public void testAddParticipatingInstancesLargeScale() throws Exception {
        long start = System.currentTimeMillis();
        Instance instance = new MockInstance();
        Collection<Instance> collection = new ArrayList<Instance>();
        for (int i = 0; i < TOTAL_ITERATION/10; i++) {
            collection.add(instance);
        }

        for (int i = 0; i < TOTAL_ITERATION/2; i++) {
            set.addParticipatingInstances(collection);
        }
        assertTrue(set.containsParticipatingInstance(instance));
        System.out.println("Calling " + TOTAL_ITERATION + " times addParticipatingInstances method"
                + " costs:" + (System.currentTimeMillis() - start) + " ms");
    }

    /**
     * Test for calling removeParticipatingInstance(xxx) method under large scale.
     * @throws Exception to JUnit.
     */
    public void testRemoveParticipatingInstanceLargeScale() throws Exception {
        long start = System.currentTimeMillis();
        Instance instance = new MockInstance();

        for (int i = 0; i < TOTAL_ITERATION; i++) {
            set.addParticipatingInstance(instance);
        }

        for (int i = 0; i < TOTAL_ITERATION; i++) {
            set.removeParticipatingInstance(instance);
        }
        assertFalse(set.containsParticipatingInstance(instance));
        System.out.println("Calling " + TOTAL_ITERATION + " times removeParticipatingInstance method"
                + " costs:" + (System.currentTimeMillis() - start) + " ms");
    }

    /**
     * Test for calling removeParticipatingInstances(xxx) method under large scale.
     * @throws Exception to JUnit.
     */
    public void testRemoveParticipatingInstancesLargeScale() throws Exception {
        long start = System.currentTimeMillis();
        Instance instance = new MockInstance();

        Collection<Instance> collection = new ArrayList<Instance>();
        for (int i = 0; i < 10; i++) {
            collection.add(instance);
        }

        for (int i = 0; i < TOTAL_ITERATION/10; i++) {
            set.addParticipatingInstances(collection);
        }

        for (int i = 0; i < TOTAL_ITERATION/10; i++) {
            set.removeParticipatingInstances(collection);
        }
        assertFalse(set.containsParticipatingInstance(instance));
        System.out.println("Calling " + TOTAL_ITERATION + " times removeParticipatingInstances method"
                + " costs:" + (System.currentTimeMillis() - start) + " ms");
    }

    /**
     * Test for calling clearParticipatingInstances() method under large scale.
     * @throws Exception to JUnit.
     */
    public void testClearParticipatingInstancesLargeScale() throws Exception {
        long start = System.currentTimeMillis();
        Instance instance = new MockInstance();

        for (int i = 0; i < TOTAL_ITERATION; i++) {
            set.addParticipatingInstance(instance);
        }

        for (int i = 0; i < TOTAL_ITERATION; i++) {
            set.clearParticipatingInstances();
        }

        System.out.println("Calling " + TOTAL_ITERATION + " times clearParticipatingInstances method"
                + " costs:" + (System.currentTimeMillis() - start) + " ms");
    }

    /**
     * Test for calling getParticipatingInstances() method under large scale.
     * @throws Exception to JUnit.
     */
    public void testGetParticipatingInstancesLargeScale() throws Exception {
        long start = System.currentTimeMillis();
        Instance instance = new MockInstance();
        Collection<Instance> collection = new ArrayList<Instance>();
        for (int i = 0; i < TOTAL_ITERATION; i++) {
            collection.add(instance);
        }

        set.addParticipatingInstances(collection);
        for (int i = 0; i < TOTAL_ITERATION; i++) {
            assertEquals(collection, set.getParticipatingInstances());
        }

        System.out.println("Calling " + TOTAL_ITERATION + " times getParticipatingInstances method"
                + " costs:" + (System.currentTimeMillis() - start) + " ms");
    }

    /**
     * Test for calling containsParticipatingInstance() method under large scale.
     * @throws Exception to JUnit.
     */
    public void testcontainsParticipatingInstanceLargeScale() throws Exception {
        long start = System.currentTimeMillis();
        Instance instance = new MockInstance();
        set.addParticipatingInstance(instance);

        for (int i = 0; i < TOTAL_ITERATION; i++) {
            assertTrue(set.containsParticipatingInstance(instance));
        }

        System.out.println("Calling " + TOTAL_ITERATION + " times containsParticipatingInstance method"
                + " costs:" + (System.currentTimeMillis() - start) + " ms");
    }

    /**
     * Test for calling countParticipatingInstances() method under large scale.
     * @throws Exception to JUnit.
     */
    public void testCountParticipatingInstancesLargeScale() throws Exception {
        long start = System.currentTimeMillis();
        Instance instance = new MockInstance();
        set.addParticipatingInstance(instance);

        for (int i = 0; i < TOTAL_ITERATION; i++) {
            assertTrue(1 == set.countParticipatingInstances());
        }

        System.out.println("Calling " + TOTAL_ITERATION + " times countParticipatingInstances method"
                + " costs:" + (System.currentTimeMillis() - start) + " ms");
    }

    /**
     * Test for calling addParticipatingLink(xxx) method under large scale.
     * @throws Exception to JUnit.
     */
    public void testAddParticipatingLinkLargeScale() throws Exception {
        long start = System.currentTimeMillis();
        Link link = new MockLink();
        for (int i = 0; i < TOTAL_ITERATION; i++) {
            set.addParticipatingLink(link);
        }
        assertTrue(set.containsParticipatingLink(link));
        System.out.println("Calling " + TOTAL_ITERATION + " times addParticipatingLink method"
                + " costs:" + (System.currentTimeMillis() - start) + " ms");
    }

    /**
     * Test for calling addParticipatingLinks(xxx) method under large scale.
     * @throws Exception to JUnit.
     */
    public void testAddParticipatingLinksLargeScale() throws Exception {
        long start = System.currentTimeMillis();
        Link link = new MockLink();
        Collection<Link> collection = new ArrayList<Link>();
        for (int i = 0; i < TOTAL_ITERATION/10; i++) {
            collection.add(link);
        }

        for (int i = 0; i < TOTAL_ITERATION/2; i++) {
            set.addParticipatingLinks(collection);
        }
        assertTrue(set.containsParticipatingLink(link));
        System.out.println("Calling " + TOTAL_ITERATION + " times addParticipatingLinks method"
                + " costs:" + (System.currentTimeMillis() - start) + " ms");
    }

    /**
     * Test for calling removeParticipatingLink(xxx) method under large scale.
     * @throws Exception to JUnit.
     */
    public void testRemoveParticipatingLinkLargeScale() throws Exception {
        long start = System.currentTimeMillis();
        Link link = new MockLink();

        for (int i = 0; i < TOTAL_ITERATION; i++) {
            set.addParticipatingLink(link);
        }

        for (int i = 0; i < TOTAL_ITERATION; i++) {
            set.removeParticipatingLink(link);
        }
        assertFalse(set.containsParticipatingLink(link));
        System.out.println("Calling " + TOTAL_ITERATION + " times removeParticipatingLink method"
                + " costs:" + (System.currentTimeMillis() - start) + " ms");
    }

    /**
     * Test for calling removeParticipatingLinks(xxx) method under large scale.
     * @throws Exception to JUnit.
     */
    public void testRemoveParticipatingLinksLargeScale() throws Exception {
        long start = System.currentTimeMillis();
        Link link = new MockLink();

        Collection<Link> collection = new ArrayList<Link>();
        for (int i = 0; i < 10; i++) {
            collection.add(link);
        }

        for (int i = 0; i < TOTAL_ITERATION/10; i++) {
            set.addParticipatingLinks(collection);
        }

        for (int i = 0; i < TOTAL_ITERATION/10; i++) {
            set.removeParticipatingLinks(collection);
        }
        assertFalse(set.containsParticipatingLink(link));
        System.out.println("Calling " + TOTAL_ITERATION + " times removeParticipatingLinks method"
                + " costs:" + (System.currentTimeMillis() - start) + " ms");
    }

    /**
     * Test for calling clearParticipatingLinks() method under large scale.
     * @throws Exception to JUnit.
     */
    public void testClearParticipatingLinksLargeScale() throws Exception {
        long start = System.currentTimeMillis();
        Link link = new MockLink();

        for (int i = 0; i < TOTAL_ITERATION; i++) {
            set.addParticipatingLink(link);
        }

        for (int i = 0; i < TOTAL_ITERATION; i++) {
            set.clearParticipatingLinks();
        }

        System.out.println("Calling " + TOTAL_ITERATION + " times clearParticipatingLinks method"
                + " costs:" + (System.currentTimeMillis() - start) + " ms");
    }

    /**
     * Test for calling getParticipatingLinks() method under large scale.
     * @throws Exception to JUnit.
     */
    public void testGetParticipatingLinksLargeScale() throws Exception {
        long start = System.currentTimeMillis();
        Link link = new MockLink();
        Collection<Link> collection = new ArrayList<Link>();
        for (int i = 0; i < TOTAL_ITERATION; i++) {
            collection.add(link);
        }

        set.addParticipatingLinks(collection);
        for (int i = 0; i < TOTAL_ITERATION; i++) {
            assertEquals(collection, set.getParticipatingLinks());
        }

        System.out.println("Calling " + TOTAL_ITERATION + " times getParticipatingLinks method"
                + " costs:" + (System.currentTimeMillis() - start) + " ms");
    }

    /**
     * Test for calling containsParticipatingLink() method under large scale.
     * @throws Exception to JUnit.
     */
    public void testcontainsParticipatingLinkLargeScale() throws Exception {
        long start = System.currentTimeMillis();
        Link link = new MockLink();
        set.addParticipatingLink(link);

        for (int i = 0; i < TOTAL_ITERATION; i++) {
            assertTrue(set.containsParticipatingLink(link));
        }

        System.out.println("Calling " + TOTAL_ITERATION + " times containsParticipatingLink method"
                + " costs:" + (System.currentTimeMillis() - start) + " ms");
    }

    /**
     * Test for calling countParticipatingLinks() method under large scale.
     * @throws Exception to JUnit.
     */
    public void testCountParticipatingLinksLargeScale() throws Exception {
        long start = System.currentTimeMillis();
        Link link = new MockLink();
        set.addParticipatingLink(link);

        for (int i = 0; i < TOTAL_ITERATION; i++) {
            assertTrue(1 == set.countParticipatingLinks());
        }

        System.out.println("Calling " + TOTAL_ITERATION + " times countParticipatingLinks method"
                + " costs:" + (System.currentTimeMillis() - start) + " ms");
    }
}
