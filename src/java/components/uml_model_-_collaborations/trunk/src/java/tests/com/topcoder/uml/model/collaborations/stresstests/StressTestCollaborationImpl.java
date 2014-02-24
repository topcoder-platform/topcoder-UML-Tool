/*
 * Copyright (C) 2006 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.uml.model.collaborations.stresstests;

import java.util.ArrayList;
import java.util.Collection;

import junit.framework.TestCase;

import com.topcoder.uml.model.collaborations.collaborationinstances.CollaborationInstanceSet;
import com.topcoder.uml.model.collaborations.collaborationinstances.CollaborationInstanceSetImpl;
import com.topcoder.uml.model.collaborations.collaborationinteractions.CollaborationImpl;
import com.topcoder.uml.model.core.Classifier;
import com.topcoder.uml.model.core.ModelElement;
import com.topcoder.uml.model.core.Operation;
import com.topcoder.uml.model.core.MockOperation;
import com.topcoder.uml.model.core.MockClassifier;
import com.topcoder.uml.model.core.MockModelElement;

/**
 * This class will test <code>CollaborationImpl</code> class under large scale situation.
 *
 * @author slion
 * @version 1.0
 */
public class StressTestCollaborationImpl extends TestCase {
    /**
     * Represents the scale of processing the operation.
     */
    private static final int TOTAL_ITERATION = 10000;

    /**
     * Represents the Collaboration instance for testing.
     */
    private CollaborationImpl collaboration = null;

    /**
     * Set up environment.
     * @throws Exception to JUnit.
     */
    protected void setUp() throws Exception {
        collaboration = new CollaborationImpl();
    }

    /**
     * Tear down.
     * @throws Exception to JUnit.
     */
    protected void tearDown() throws Exception {
        collaboration = null;
    }

    /**
     * Test for creating instances under large scale.
     * @throws Exception to JUnit.
     */
    public void testCtorLargeScale() throws Exception {
        long start = System.currentTimeMillis();
        for (int i = 0; i < TOTAL_ITERATION; i++) {
            assertNotNull("Fail to create CollaborationImpl instance.",
                    new CollaborationImpl());
        }
        System.out.println("Creating " + TOTAL_ITERATION + " CollaborationImpl instances"
                + " with the first constructor costs:" + (System.currentTimeMillis() - start) + " ms");
    }

    /**
     * Test for calling setRepresentedClassifier(xxx) method under large scale.
     * @throws Exception to JUnit.
     */
    public void testSetRepresentedClassifierLargeScale() throws Exception {
        long start = System.currentTimeMillis();
        Classifier classifier = new MockClassifier();
        for (int i = 0; i < TOTAL_ITERATION; i++) {
            collaboration.setRepresentedClassifier(classifier);
        }
        assertEquals(collaboration.getRepresentedClassifier(), classifier);
        System.out.println("Calling " + TOTAL_ITERATION + " times setRepresentedClassifier method"
                + " costs:" + (System.currentTimeMillis() - start) + " ms");
    }

    /**
     * Test for calling getRepresentedClassifier(xxx) method under large scale.
     * @throws Exception to JUnit.
     */
    public void testGetRepresentedClassifierLargeScale() throws Exception {
        long start = System.currentTimeMillis();
        Classifier classifier = new MockClassifier();
        collaboration.setRepresentedClassifier(classifier);
        for (int i = 0; i < TOTAL_ITERATION; i++) {
            assertEquals("Should not null.", classifier, collaboration.getRepresentedClassifier());
        }
        System.out.println("Calling " + TOTAL_ITERATION + " times getRepresentedClassifier method"
                + " costs:" + (System.currentTimeMillis() - start) + " ms");
    }

    /**
     * Test for calling setRepresentedOperation(xxx) method under large scale.
     * @throws Exception to JUnit.
     */
    public void testSetRepresentedOperationLargeScale() throws Exception {
        long start = System.currentTimeMillis();
        Operation operation = new MockOperation();
        for (int i = 0; i < TOTAL_ITERATION; i++) {
            collaboration.setRepresentedOperation(operation);
        }
        assertEquals(collaboration.getRepresentedOperation(), operation);
        System.out.println("Calling " + TOTAL_ITERATION + " times setRepresentedOperation method"
                + " costs:" + (System.currentTimeMillis() - start) + " ms");
    }

    /**
     * Test for calling getRepresentedOperation(xxx) method under large scale.
     * @throws Exception to JUnit.
     */
    public void testGetRepresentedOperationLargeScale() throws Exception {
        long start = System.currentTimeMillis();
        Operation operation = new MockOperation();
        collaboration.setRepresentedOperation(operation);
        for (int i = 0; i < TOTAL_ITERATION; i++) {
            assertEquals("Should not null.", operation, collaboration.getRepresentedOperation());
        }
        System.out.println("Calling " + TOTAL_ITERATION + " times getRepresentedOperation method"
                + " costs:" + (System.currentTimeMillis() - start) + " ms");
    }

    /**
     * Test for calling addCollaborationInstanceSet(xxx) method under large scale.
     * @throws Exception to JUnit.
     */
    public void testAddCollaborationInstanceSetLargeScale() throws Exception {
        long start = System.currentTimeMillis();
        CollaborationInstanceSet set = new CollaborationInstanceSetImpl();
        for (int i = 0; i < TOTAL_ITERATION; i++) {
            collaboration.addCollaborationInstanceSet(set);
        }
        assertTrue(collaboration.containsCollaborationInstanceSet(set));
        System.out.println("Calling " + TOTAL_ITERATION + " times addCollaborationInstanceSet method"
                + " costs:" + (System.currentTimeMillis() - start) + " ms");
    }

    /**
     * Test for calling addCollaborationInstanceSets(xxx) method under large scale.
     * @throws Exception to JUnit.
     */
    public void testAddCollaborationInstanceSetsLargeScale() throws Exception {
        long start = System.currentTimeMillis();
        CollaborationInstanceSet set = new CollaborationInstanceSetImpl();
        Collection<CollaborationInstanceSet> collection = new ArrayList<CollaborationInstanceSet>();
        for (int i = 0; i < TOTAL_ITERATION/10; i++) {
            collection.add(set);
        }

        for (int i = 0; i < TOTAL_ITERATION/2; i++) {
            collaboration.addCollaborationInstanceSets(collection);
        }
        assertTrue(collaboration.containsCollaborationInstanceSet(set));
        System.out.println("Calling " + TOTAL_ITERATION + " times addCollaborationInstanceSets method"
                + " costs:" + (System.currentTimeMillis() - start) + " ms");
    }

    /**
     * Test for calling removeCollaborationInstanceSet(xxx) method under large scale.
     * @throws Exception to JUnit.
     */
    public void testRemoveCollaborationInstanceSetLargeScale() throws Exception {
        long start = System.currentTimeMillis();
        CollaborationInstanceSet set = new CollaborationInstanceSetImpl();

        for (int i = 0; i < TOTAL_ITERATION; i++) {
            collaboration.addCollaborationInstanceSet(set);
        }

        for (int i = 0; i < TOTAL_ITERATION; i++) {
            collaboration.removeCollaborationInstanceSet(set);
        }
        assertFalse(collaboration.containsCollaborationInstanceSet(set));
        System.out.println("Calling " + TOTAL_ITERATION + " times removeCollaborationInstanceSet method"
                + " costs:" + (System.currentTimeMillis() - start) + " ms");
    }

    /**
     * Test for calling removeCollaborationInstanceSets(xxx) method under large scale.
     * @throws Exception to JUnit.
     */
    public void testRemoveCollaborationInstanceSetsLargeScale() throws Exception {
        long start = System.currentTimeMillis();
        CollaborationInstanceSet set = new CollaborationInstanceSetImpl();

        Collection<CollaborationInstanceSet> collection = new ArrayList<CollaborationInstanceSet>();
        for (int i = 0; i < 10; i++) {
            collection.add(set);
        }

        for (int i = 0; i < TOTAL_ITERATION/10; i++) {
            collaboration.addCollaborationInstanceSets(collection);
        }

        for (int i = 0; i < TOTAL_ITERATION/10; i++) {
            collaboration.removeCollaborationInstanceSets(collection);
        }
        assertFalse(collaboration.containsCollaborationInstanceSet(set));
        System.out.println("Calling " + TOTAL_ITERATION + " times removeCollaborationInstanceSets method"
                + " costs:" + (System.currentTimeMillis() - start) + " ms");
    }

    /**
     * Test for calling clearCollaborationInstanceSets() method under large scale.
     * @throws Exception to JUnit.
     */
    public void testClearCollaborationInstanceSetsLargeScale() throws Exception {
        long start = System.currentTimeMillis();
        CollaborationInstanceSet set = new CollaborationInstanceSetImpl();

        for (int i = 0; i < TOTAL_ITERATION; i++) {
            collaboration.addCollaborationInstanceSet(set);
        }

        for (int i = 0; i < TOTAL_ITERATION; i++) {
            collaboration.clearCollaborationInstanceSets();
        }

        System.out.println("Calling " + TOTAL_ITERATION + " times clearParticipatingInstances method"
                + " costs:" + (System.currentTimeMillis() - start) + " ms");
    }

    /**
     * Test for calling getCollaborationInstanceSets() method under large scale.
     * @throws Exception to JUnit.
     */
    public void testGetCollaborationInstanceSetsLargeScale() throws Exception {
        long start = System.currentTimeMillis();
        CollaborationInstanceSet set = new CollaborationInstanceSetImpl();
        Collection<CollaborationInstanceSet> collection = new ArrayList<CollaborationInstanceSet>();
        for (int i = 0; i < TOTAL_ITERATION; i++) {
            collection.add(set);
        }

        collaboration.addCollaborationInstanceSets(collection);
        for (int i = 0; i < TOTAL_ITERATION; i++) {
            assertEquals(collection, collaboration.getCollaborationInstanceSets());
        }

        System.out.println("Calling " + TOTAL_ITERATION + " times getCollaborationInstanceSets method"
                + " costs:" + (System.currentTimeMillis() - start) + " ms");
    }

    /**
     * Test for calling containsCollaborationInstanceSet() method under large scale.
     * @throws Exception to JUnit.
     */
    public void testContainsCollaborationInstanceSetLargeScale() throws Exception {
        long start = System.currentTimeMillis();
        CollaborationInstanceSet set = new CollaborationInstanceSetImpl();
        collaboration.addCollaborationInstanceSet(set);

        for (int i = 0; i < TOTAL_ITERATION; i++) {
            assertTrue(collaboration.containsCollaborationInstanceSet(set));
        }

        System.out.println("Calling " + TOTAL_ITERATION + " times containsCollaborationInstanceSet method"
                + " costs:" + (System.currentTimeMillis() - start) + " ms");
    }

    /**
     * Test for calling countCollaborationInstanceSets() method under large scale.
     * @throws Exception to JUnit.
     */
    public void testCountCollaborationInstanceSetsLargeScale() throws Exception {
        long start = System.currentTimeMillis();
        CollaborationInstanceSet set = new CollaborationInstanceSetImpl();
        collaboration.addCollaborationInstanceSet(set);

        for (int i = 0; i < TOTAL_ITERATION; i++) {
            assertTrue(1 == collaboration.countCollaborationInstanceSets());
        }

        System.out.println("Calling " + TOTAL_ITERATION + " times countCollaborationCollaborationSets method"
                + " costs:" + (System.currentTimeMillis() - start) + " ms");
    }

    /**
     * Test for calling addOwnedElement(xxx) method under large scale.
     * @throws Exception to JUnit.
     */
    public void testAddOwnedElementLargeScale() throws Exception {
        long start = System.currentTimeMillis();
        ModelElement element = new MockModelElement();
        for (int i = 0; i < TOTAL_ITERATION; i++) {
            collaboration.addOwnedElement(element);
        }
        assertTrue(collaboration.containsOwnedElement(element));
        System.out.println("Calling " + TOTAL_ITERATION + " times addOwnedElement method"
                + " costs:" + (System.currentTimeMillis() - start) + " ms");
    }

    /**
     * Test for calling removeOwnedElement(xxx) method under large scale.
     * @throws Exception to JUnit.
     */
    public void testRemoveOwnedModelElementLargeScale() throws Exception {
        long start = System.currentTimeMillis();
        ModelElement element = new MockModelElement();

        for (int i = 0; i < TOTAL_ITERATION; i++) {
            collaboration.addOwnedElement(element);
        }

        for (int i = 0; i < TOTAL_ITERATION; i++) {
            collaboration.removeOwnedElement(element);
        }
        assertFalse(collaboration.containsOwnedElement(element));
        System.out.println("Calling " + TOTAL_ITERATION + " times removeOwnedElement method"
                + " costs:" + (System.currentTimeMillis() - start) + " ms");
    }

    /**
     * Test for calling clearOwnedElements() method under large scale.
     * @throws Exception to JUnit.
     */
    public void testClearOwnedElementsLargeScale() throws Exception {
        long start = System.currentTimeMillis();
        ModelElement element = new MockModelElement();

        for (int i = 0; i < TOTAL_ITERATION; i++) {
            collaboration.addOwnedElement(element);
        }

        for (int i = 0; i < TOTAL_ITERATION; i++) {
            collaboration.clearOwnedElements();
        }

        assertFalse(collaboration.containsOwnedElement(element));
        System.out.println("Calling " + TOTAL_ITERATION + " times clearOwnedElements method"
                + " costs:" + (System.currentTimeMillis() - start) + " ms");
    }

    /**
     * Test for calling getOwnedElements() method under large scale.
     * @throws Exception to JUnit.
     */
    public void testGetOwnedElementsLargeScale() throws Exception {
        long start = System.currentTimeMillis();
        ModelElement element = new MockModelElement();

        for (int i = 0; i < TOTAL_ITERATION; i++) {
            collaboration.addOwnedElement(element);
        }

        for (int i = 0; i < TOTAL_ITERATION; i++) {
            assertTrue(TOTAL_ITERATION == collaboration.getOwnedElements().size());
        }

        System.out.println("Calling " + TOTAL_ITERATION + " times getOwnedElements method"
                + " costs:" + (System.currentTimeMillis() - start) + " ms");
    }

    /**
     * Test for calling containsOwnedElement(xxx) method under large scale.
     * @throws Exception to JUnit.
     */
    public void testcontainsOwnedElementLargeScale() throws Exception {
        long start = System.currentTimeMillis();
        ModelElement element = new MockModelElement();
        collaboration.addOwnedElement(element);

        for (int i = 0; i < TOTAL_ITERATION; i++) {
            assertTrue(collaboration.containsOwnedElement(element));
        }

        System.out.println("Calling " + TOTAL_ITERATION + " times containsOwnedElement method"
                + " costs:" + (System.currentTimeMillis() - start) + " ms");
    }

    /**
     * Test for calling countOwnedElements() method under large scale.
     * @throws Exception to JUnit.
     */
    public void testCountOwnedElementsLargeScale() throws Exception {
        long start = System.currentTimeMillis();
        ModelElement element = new MockModelElement();
        collaboration.addOwnedElement(element);

        for (int i = 0; i < TOTAL_ITERATION; i++) {
            assertTrue(1 == collaboration.countOwnedElements());
        }

        System.out.println("Calling " + TOTAL_ITERATION + " times countOwnedElements method"
                + " costs:" + (System.currentTimeMillis() - start) + " ms");
    }
}
