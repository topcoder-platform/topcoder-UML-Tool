/*
 * Copyright (C) 2006 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.uml.model.collaborations.failuretests.collaborationinstances;

import java.util.ArrayList;
import java.util.Collection;

import com.topcoder.uml.model.collaborations.collaborationinstances.CollaborationInstanceSetImpl;
import com.topcoder.uml.model.commonbehavior.instances.Instance;
import com.topcoder.uml.model.commonbehavior.links.Link;

import junit.framework.TestCase;

/**
 * <p>
 * Failure test for CollaborationImpl class.
 * </p>
 *
 * @author TCSDEVELOPER
 * @version 1.0
 */
public class CollaborationInstanceSetImplFailureTest extends TestCase {
    /**
     * Represents the instance to test.
     */
    private CollaborationInstanceSetImpl tester;

    /**
     * Create instance to test.
     *
     * @throws Exception to Junit.
     */
    protected void setUp() throws Exception {
        super.setUp();

        tester = new CollaborationInstanceSetImpl();
    }

    /**
     * Test addParticipatingInstance(Instance participatingInstance),
     * when participatingInstance is null, IAE is expected.
     */
    public void testAddCollaborationInstanceSet_participatingInstanceIsNull() {
        try {
            tester.addParticipatingInstance(null);
            fail("when participatingInstance is null, IAE is expected.");
        } catch (IllegalArgumentException e) {
            // ok
        }
    }

    /**
     * Test addParticipatingInstances(Collection<Instance> participatingInstances),
     * when participatingInstances is null, IAE is expected.
     */
    public void testAddParticipatingInstances_participatingInstancesIsNull() {
        try {
            tester.addParticipatingInstances(null);
            fail("when participatingInstances is null, IAE is expected.");
        } catch (IllegalArgumentException e) {
            // ok
        }
    }

    /**
     * Test addParticipatingInstances(Collection<Instance> participatingInstances),
     * when participatingInstances contains null, IAE is expected.
     */
    public void testAddParticipatingInstances_participatingInstancesContainsNull() {
        Collection<Instance> instances = new ArrayList<Instance>();
        instances.add(null);
        try {
            tester.addParticipatingInstances(instances);
            fail("when participatingInstances contains null, IAE is expected.");
        } catch (IllegalArgumentException e) {
            // ok
        }
    }

    /**
     * Test removeParticipatingInstance(Instance participatingInstance),
     * when participatingInstance is null, IAE is expected.
     */
    public void testRemoveParticipatingInstance_participatingInstanceIsNull() {
        try {
            tester.removeParticipatingInstance(null);
            fail("when participatingInstance is null, IAE is expected.");
        } catch (IllegalArgumentException e) {
            // ok
        }
    }

    /**
     * Test removeParticipatingInstances(Collection<Instance> participatingInstances),
     * when participatingInstances is null, IAE is expected.
     */
    public void testRemoveParticipatingInstances_participatingInstancesIsNull() {
        try {
            tester.addParticipatingInstances(null);
            fail("when participatingInstances is null, IAE is expected.");
        } catch (IllegalArgumentException e) {
            // ok
        }
    }

    /**
     * Test removeParticipatingInstances(Collection<Instance> participatingInstances),
     * when participatingInstances contains null, IAE is expected.
     */
    public void testRemoveParticipatingInstances_participatingInstancesContainsNull() {
        Collection<Instance> instances = new ArrayList<Instance>();
        instances.add(null);
        try {
            tester.removeParticipatingInstances(instances);
            fail("when participatingInstances contains null, IAE is expected.");
        } catch (IllegalArgumentException e) {
            // ok
        }
    }

    /**
     * Test containsParticipatingInstance(Instance participatingInstance),
     * when participatingInstance is null, IAE is expected.
     */
    public void testContainsParticipatingInstance_participatingInstancesIsNull() {
        try {
            tester.containsParticipatingInstance(null);
            fail("when participatingInstances is null, IAE is expected.");
        } catch (IllegalArgumentException e) {
            // ok
        }
    }

    /**
     * Test addParticipatingLink(Link participatingLink),
     * when participatingLink is null, IAE is expected.
     */
    public void testAddParticipatingLink_participatingLinkIsNull() {
        try {
            tester.addParticipatingLink(null);
            fail("when participatingLink is null, IAE is expected.");
        } catch (IllegalArgumentException e) {
            // ok
        }
    }

    /**
     * Test addParticipatingLinks(Collection<Link> participatingLinks),
     * when participatingLinks is null, IAE is expected.
     */
    public void testAddParticipatingLinks_participatingLinksIsNull() {
        try {
            tester.addParticipatingLinks(null);
            fail("when participatingLinks is null, IAE is expected.");
        } catch (IllegalArgumentException e) {
            // ok
        }
    }

    /**
     * Test addParticipatingLinks(Collection<Link> participatingLinks),
     * when participatingLinks contains null, IAE is expected.
     */
    public void testAddParticipatingLinks_participatingLinksContainsNull() {
        Collection<Link> links = new ArrayList<Link>();
        links.add(null);
        try {
            tester.addParticipatingLinks(links);
            fail("when participatingLinks contains null, IAE is expected.");
        } catch (IllegalArgumentException e) {
            // ok
        }
    }

    /**
     * Test removeParticipatingLink(Link participatingLink),
     * when participatingLink is null, IAE is expected.
     */
    public void testRemoveParticipatingLink_participatingLinkIsNull() {
        try {
            tester.removeParticipatingLink(null);
            fail("when participatingLink is null, IAE is expected.");
        } catch (IllegalArgumentException e) {
            // ok
        }
    }

    /**
     * Test removeParticipatingLinks(Collection<Link> participatingLinks),
     * when participatingLinks is null, IAE is expected.
     */
    public void testRemoveParticipatingLinks_participatingLinksIsNull() {
        try {
            tester.removeParticipatingLinks(null);
            fail("when participatingLinks is null, IAE is expected.");
        } catch (IllegalArgumentException e) {
            // ok
        }
    }

    /**
     * Test removeParticipatingLinks(Collection<Link> participatingLinks),
     * when participatingLinks contains null, IAE is expected.
     */
    public void testRemoveParticipatingLinks_participatingLinksContainsNull() {
        Collection<Link> links = new ArrayList<Link>();
        links.add(null);
        try {
            tester.removeParticipatingLinks(links);
            fail("when participatingLinks contains null, IAE is expected.");
        } catch (IllegalArgumentException e) {
            // ok
        }
    }

    /**
     * Test containsParticipatingLink(Link participatingLink),
     * when participatingLink is null, IAE is expected.
     */
    public void testContainsParticipatingLink_participatingLinkIsNull() {
        try {
            tester.containsParticipatingLink(null);
            fail("when participatingLink is null, IAE is expected.");
        } catch (IllegalArgumentException e) {
            // ok
        }
    }
}
