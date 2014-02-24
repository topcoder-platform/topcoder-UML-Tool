/*
 * Copyright (C) 2006 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.uml.model.collaborations.failuretests.collaborationinteractions;

import java.util.ArrayList;
import java.util.Collection;

import com.topcoder.uml.model.collaborations.collaborationinstances.CollaborationInstanceSet;
import com.topcoder.uml.model.collaborations.collaborationinteractions.CollaborationImpl;
import com.topcoder.uml.model.core.ModelElement;

import junit.framework.TestCase;

/**
 * <p>
 * Failure test for CollaborationImpl class.
 * </p>
 *
 * @author TCSDEVELOPER
 * @version 1.0
 */
public class CollaborationImplFailureTest extends TestCase {
    /**
     * Represents the instance to test.
     */
    private CollaborationImpl tester;

    /**
     * Create instance to test.
     *
     * @throws Exception to Junit.
     */
    protected void setUp() throws Exception {
        super.setUp();

        tester = new CollaborationImpl();
    }

    /**
     * <p>
     * Test addCollaborationInstanceSet(CollaborationInstanceSet collaborationInstanceSet),
     * when collaborationInstanceSet is null, IllegalArgumentException is expected.
     * </p>
     */
    public void testAddCollaborationInstanceSet_CollaborationInstanceSetIsNull() {
        try {
            tester.addCollaborationInstanceSet(null);
            fail("when collaborationInstanceSet is null, IllegalArgumentException is expected.");
        } catch (IllegalArgumentException e) {
            // ok
        }
    }

    /**
     * <p>
     * Test addCollaborationInstanceSets(Collection<CollaborationInstanceSet> collaborationInstanceSets),
     * when collaborationInstanceSets is null, IllegalArgumentException is expected.
     * </p>
     */
    public void testAddCollaborationInstanceSets_CollaborationInstanceSetsIsNull() {
        try {
            tester.addCollaborationInstanceSets(null);
            fail("when collaborationInstanceSets is null, IllegalArgumentException is expected.");
        } catch (IllegalArgumentException e) {
            // ok
        }
    }

    /**
     * <p>
     * Test addCollaborationInstanceSets(Collection<CollaborationInstanceSet> collaborationInstanceSets),
     * when collaborationInstanceSets contains null, IllegalArgumentException is expected.
     * </p>
     */
    public void testAddCollaborationInstanceSets_CollaborationInstanceSetsContainsNull() {
        Collection<CollaborationInstanceSet> list = new ArrayList<CollaborationInstanceSet>();
        list.add(null);
        try {
            tester.addCollaborationInstanceSets(list);
            fail("when collaborationInstanceSets contains null, IllegalArgumentException is expected.");
        } catch (IllegalArgumentException e) {
            // ok
        }
    }

    /**
     * <p>
     * Test removeCollaborationInstanceSet(CollaborationInstanceSet collaborationInstanceSet),
     * when collaborationInstanceSet is null, IllegalArgumentException is expected.
     * </p>
     */
    public void testRemoveCollaborationInstanceSet_collaborationInstanceSetIsNull() {
        try {
            tester.removeCollaborationInstanceSet(null);
            fail("when collaborationInstanceSet is null, IllegalArgumentException is expected.");
        } catch (IllegalArgumentException e) {
            // ok
        }
    }

    /**
     * <p>
     * Test removeCollaborationInstanceSets(Collection<CollaborationInstanceSet> collaborationInstanceSets),
     * when collaborationInstanceSets is null, IllegalArgumentException is expected.
     * </p>
     */
    public void testRemoveCollaborationInstanceSets_CollaborationInstanceSetsIsNull() {
        try {
            tester.removeCollaborationInstanceSets(null);
            fail("when collaborationInstanceSets is null, IllegalArgumentException is expected.");
        } catch (IllegalArgumentException e) {
            // ok
        }
    }

    /**
     * <p>
     * Test removeCollaborationInstanceSets(Collection<CollaborationInstanceSet> collaborationInstanceSets),
     * when collaborationInstanceSets contains null, IllegalArgumentException is expected.
     * </p>
     */
    public void testRemoveCollaborationInstanceSets_CollaborationInstanceSetsContainsNull() {
        Collection<CollaborationInstanceSet> list = new ArrayList<CollaborationInstanceSet>();
        list.add(null);
        try {
            tester.removeCollaborationInstanceSets(list);
            fail("when collaborationInstanceSets contains null, IllegalArgumentException is expected.");
        } catch (IllegalArgumentException e) {
            // ok
        }
    }

    /**
     * <p>
     * Test containsCollaborationInstanceSet(CollaborationInstanceSet collaborationInstanceSet),
     * when collaborationInstanceSet is null, IllegalArgumentException is expected.
     * </p>
     */
    public void testContainsCollaborationInstanceSet_CollaborationInstanceSetIsNull() {
        try {
            tester.containsCollaborationInstanceSet(null);
            fail("when collaborationInstanceSet is null, IllegalArgumentException is expected.");
        } catch (IllegalArgumentException e) {
            // ok
        }
    }

    /**
     * <p>
     * Test addOwnedElement(ModelElement ownedElement),
     * when ownedElement is null, IllegalArgumentException is expected.
     * </p>
     */
    public void testAddOwnedElement_OwnedElementIsNull() {
        try {
            tester.addOwnedElement(null);
            fail("when ownedElement is null, IllegalArgumentException is expected.");
        } catch (IllegalArgumentException e) {
            // ok
        }
    }

    /**
     * <p>
     * Test removeOwnedElement(ModelElement ownedElement),
     * when ownedElement is null, IllegalArgumentException is expected.
     * </p>
     */
    public void testRemoveOwnedElement_OwnedElementIsNull() {
        try {
            tester.removeOwnedElement(null);
            fail("when ownedElement is null, IllegalArgumentException is expected.");
        } catch (IllegalArgumentException e) {
            // ok
        }
    }

    /**
     * <p>
     * Test containsOwnedElement(ModelElement ownedElement),
     * when ownedElement is null, IllegalArgumentException is expected.
     * </p>
     */
    public void testContainsOwnedElement_OwnedElementIsNull() {
        try {
            tester.containsOwnedElement(null);
            fail("when ownedElement is null, IllegalArgumentException is expected.");
        } catch (IllegalArgumentException e) {
            // ok
        }
    }
}
