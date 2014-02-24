/*
 * Copyright (C) 2006 TopCoder Inc., All Rights Reserved.
 *
 * TCS UML Model - Collaborations Version 1.0
 *
 * @ CollaborationImplTest.java
 */
package com.topcoder.uml.model.collaborations.collaborationinteractions;

import java.util.ArrayList;
import java.util.Collection;

import com.sun.org.apache.xml.internal.utils.NameSpace;
import com.topcoder.uml.model.collaborations.collaborationinstances.CollaborationInstanceSet;
import com.topcoder.uml.model.collaborations.collaborationinstances.CollaborationInstanceSetImpl;
import com.topcoder.uml.model.core.Classifier;
import com.topcoder.uml.model.core.MockClassifier;
import com.topcoder.uml.model.core.MockModelElement;
import com.topcoder.uml.model.core.MockOperation;
import com.topcoder.uml.model.core.ModelElement;
import com.topcoder.uml.model.core.Operation;

import junit.framework.TestCase;

/**
 * <p>Tests for CollaborationImpl class.</p>
 *
 * @author yinzi
 * @version 1.0
 */
public class CollaborationImplTest extends TestCase {
    /**
     * <p>MessageImpl used for testing. It is instantiated in SetUp.</p>
     */
    private CollaborationImpl collaborationImpl;

    /**
     * <p>Sets up test environment, creates object used for test.</p>
     */
    public void setUp() {
        collaborationImpl = new CollaborationImpl();
    }

    /**
     * <p>Tears down test environment, disposes object used for test.</p>
     */
    public void tearDown() {
        collaborationImpl = null;
    }

    /**
     * <p>Tests inheritance of <c>CollaborationImpl</c>.</p>
     * <p><c>CollaborationImpl</c> should inherit from <c>Collaboration</c>.</p>
     */
    public void testCollaborationImplAccuracyInheritCollaboration() {
        assertEquals("MessageImpl should inherit from Message.",
                true, collaborationImpl instanceof Collaboration);
    }

    /**
     * <p>Tests accuracy of <c>CollaborationImpl</c>.</p>
     * <p>Value should be set correctly.</p>
     */
    public void testCollaborationImplAccuracy() {
        assertEquals("Value should be gotten correctly.",
                0, collaborationImpl.countOwnedElements());
        assertEquals("Value should be gotten correctly.",
                0, collaborationImpl.countCollaborationInstanceSets());
        assertEquals("Value should be gotten correctly.",
                null, collaborationImpl.getRepresentedClassifier());
        assertEquals("Value should be gotten correctly.",
                null, collaborationImpl.getRepresentedOperation());
    }

    /**
     * <p>Tests <c>addCollaborationInstanceSet(CollaborationInstanceSet)</c> method with null parameter.</p>
     * <p>IllegalArgumentException should be thrown.</p>
     */
    public void testAddCollaborationInstanceSet_Null() {
        try {
            collaborationImpl.addCollaborationInstanceSet((CollaborationInstanceSet) null);
            fail("IllegalArgumentException expected");
        } catch (IllegalArgumentException e) {
            // ok
        }
    }

    /**
     * <p>Tests accuracy of <c>addCollaborationInstanceSet(CollaborationInstanceSet)</c>.</p>
     * <p>Value should be set correctly.</p>
     */
    public void testAddCollaborationInstanceSet_Accuracy() {
        CollaborationInstanceSet testObj = new CollaborationInstanceSetImpl();
        assertEquals("Value should be gotten correctly.",
                false, collaborationImpl.containsCollaborationInstanceSet(testObj));
        collaborationImpl.addCollaborationInstanceSet(testObj);
        assertEquals("Value should be gotten correctly.",
                true, collaborationImpl.containsCollaborationInstanceSet(testObj));
    }

    /**
     * <p>Tests <c>addCollaborationInstanceSet(Collection)</c> method with null parameter.</p>
     * <p>IllegalArgumentException should be thrown.</p>
     */
    public void testAddCollaborationInstanceSets_Null() {
        try {
            collaborationImpl.addCollaborationInstanceSets((Collection<CollaborationInstanceSet>) null);
            fail("IllegalArgumentException expected");
        } catch (IllegalArgumentException e) {
            // ok
        }
    }

    /**
     * <p>Tests <c>addCollaborationInstanceSet(Collection)</c> method with collection contans
     * null parameter.</p>
     * <p>IllegalArgumentException should be thrown.</p>
     */
    public void testAddCollaborationInstanceSets_ContainsNull() {
        try {
            Collection<CollaborationInstanceSet> collection = new ArrayList<CollaborationInstanceSet>();
            collection.add(new CollaborationInstanceSetImpl());
            collection.add(null);
            collaborationImpl.addCollaborationInstanceSets(collection);
            fail("IllegalArgumentException expected");
        } catch (IllegalArgumentException e) {
            // ok
        }
    }

    /**
     * <p>Tests accuracy of <c>addCollaborationInstanceSet(Collection)</c>.</p>
     * <p>Value should be set correctly.</p>
     */
    public void testAddCollaborationInstanceSets_Accuracy() {
        Collection<CollaborationInstanceSet> collection = new ArrayList<CollaborationInstanceSet>();
        CollaborationInstanceSet testObj1 = new CollaborationInstanceSetImpl();
        collection.add(testObj1);
        CollaborationInstanceSet testObj2 = new CollaborationInstanceSetImpl();
        collection.add(testObj2);

        assertEquals("Value should be gotten correctly.",
                false, collaborationImpl.containsCollaborationInstanceSet(testObj1));
        assertEquals("Value should be gotten correctly.",
                false, collaborationImpl.containsCollaborationInstanceSet(testObj2));
        collaborationImpl.addCollaborationInstanceSets(collection);
        assertEquals("Value should be gotten correctly.",
                true, collaborationImpl.containsCollaborationInstanceSet(testObj1));
        assertEquals("Value should be gotten correctly.",
                true, collaborationImpl.containsCollaborationInstanceSet(testObj2));
    }

    /**
     * <p>Tests <c>removeCollaborationInstanceSet(CollaborationInstanceSet)</c> method with null parameter.</p>
     * <p>IllegalArgumentException should be thrown.</p>
     */
    public void testRemoveCollaborationInstanceSet_Null() {
        try {
            collaborationImpl.removeCollaborationInstanceSet((CollaborationInstanceSet) null);
            fail("IllegalArgumentException expected");
        } catch (IllegalArgumentException e) {
            // ok
        }
    }

    /**
     * <p>Tests accuracy of <c>removeCollaborationInstanceSet(CollaborationInstanceSet)</c>.</p>
     * <p>Value should be set correctly.</p>
     */
    public void testRemoveCollaborationInstanceSet_Accuracy1() {
        CollaborationInstanceSet testObj = new CollaborationInstanceSetImpl();
        collaborationImpl.addCollaborationInstanceSet(testObj);
        collaborationImpl.addCollaborationInstanceSet(testObj);

        assertEquals("Value should be gotten correctly.",
                true, collaborationImpl.removeCollaborationInstanceSet(testObj));
        assertEquals("Value should be gotten correctly.",
                true, collaborationImpl.containsCollaborationInstanceSet(testObj));
        assertEquals("Value should be gotten correctly.",
                true, collaborationImpl.removeCollaborationInstanceSet(testObj));
        assertEquals("Value should be gotten correctly.",
                false, collaborationImpl.containsCollaborationInstanceSet(testObj));
        assertEquals("Value should be gotten correctly.",
                false, collaborationImpl.removeCollaborationInstanceSet(testObj));
    }

    /**
     * <p>Tests accuracy of <c>removeCollaborationInstanceSet(CollaborationInstanceSet)</c>.</p>
     * <p>Value should be set correctly.</p>
     */
    public void testRemoveCollaborationInstanceSet_Accuracy2() {
        CollaborationInstanceSet testObj = new CollaborationInstanceSetImpl();
        collaborationImpl.addCollaborationInstanceSet(testObj);

        assertEquals("Value should be gotten correctly.",
                true, collaborationImpl.removeCollaborationInstanceSet(testObj));
        assertEquals("Value should be gotten correctly.",
                false, collaborationImpl.containsCollaborationInstanceSet(testObj));
        assertEquals("Value should be gotten correctly.",
                false, collaborationImpl.removeCollaborationInstanceSet(testObj));
        assertEquals("Value should be gotten correctly.",
                false, collaborationImpl.containsCollaborationInstanceSet(testObj));
    }

    /**
     * <p>Tests <c>removeCollaborationInstanceSets(Collection)</c> method with null parameter.</p>
     * <p>IllegalArgumentException should be thrown.</p>
     */
    public void testRemoveCollaborationInstanceSets_Null() {
        try {
            collaborationImpl.removeCollaborationInstanceSets((Collection<CollaborationInstanceSet>) null);
            fail("IllegalArgumentException expected");
        } catch (IllegalArgumentException e) {
            // ok
        }
    }

    /**
     * <p>Tests <c>removeCollaborationInstanceSets(Collection)</c> method with collection contains null parameter.</p>
     * <p>IllegalArgumentException should be thrown.</p>
     */
    public void testRemoveCollaborationInstanceSets_ConainsNull() {
        try {
            Collection<CollaborationInstanceSet> collection = new ArrayList<CollaborationInstanceSet>();
            collection.add(new CollaborationInstanceSetImpl());
            collection.add(null);
            collaborationImpl.removeCollaborationInstanceSets(collection);
            fail("IllegalArgumentException expected");
        } catch (IllegalArgumentException e) {
            // ok
        }
    }

    /**
     * <p>Tests accuracy of <c>removeCollaborationInstanceSets(CollaborationInstanceSet)</c>.</p>
     * <p>Value should be set correctly.</p>
     */
    public void testRemoveCollaborationInstanceSets_Accuracy1() {
        CollaborationInstanceSet testObj1 = new CollaborationInstanceSetImpl();
        CollaborationInstanceSet testObj2 = new CollaborationInstanceSetImpl();
        collaborationImpl.addCollaborationInstanceSet(testObj1);
        collaborationImpl.addCollaborationInstanceSet(testObj2);
        collaborationImpl.addCollaborationInstanceSet(testObj1);

        Collection<CollaborationInstanceSet> collection = new ArrayList<CollaborationInstanceSet>();
        collection.add(testObj1);
        collection.add(testObj2);

        assertEquals("Value should be gotten correctly.",
                true, collaborationImpl.containsCollaborationInstanceSet(testObj1));
        assertEquals("Value should be gotten correctly.",
                true, collaborationImpl.containsCollaborationInstanceSet(testObj2));
        assertEquals("Value should be gotten correctly.",
                true, collaborationImpl.removeCollaborationInstanceSets(collection));
        assertEquals("Value should be gotten correctly.",
                true, collaborationImpl.containsCollaborationInstanceSet(testObj1));
        assertEquals("Value should be gotten correctly.",
                false, collaborationImpl.containsCollaborationInstanceSet(testObj2));
    }

    /**
     * <p>Tests accuracy of <c>removeCollaborationInstanceSets(CollaborationInstanceSet)</c>.</p>
     * <p>Value should be set correctly.</p>
     */
    public void testRemoveCollaborationInstanceSets_Accuracy2() {
        CollaborationInstanceSet testObj1 = new CollaborationInstanceSetImpl();
        CollaborationInstanceSet testObj2 = new CollaborationInstanceSetImpl();
        CollaborationInstanceSet testObj3 = new CollaborationInstanceSetImpl();
        collaborationImpl.addCollaborationInstanceSet(testObj1);
        collaborationImpl.addCollaborationInstanceSet(testObj2);
        collaborationImpl.addCollaborationInstanceSet(testObj1);

        Collection<CollaborationInstanceSet> collection = new ArrayList<CollaborationInstanceSet>();
        collection.add(testObj3);

        assertEquals("Value should be gotten correctly.",
                true, collaborationImpl.containsCollaborationInstanceSet(testObj1));
        assertEquals("Value should be gotten correctly.",
                true, collaborationImpl.containsCollaborationInstanceSet(testObj2));
        assertEquals("Value should be gotten correctly.",
                false, collaborationImpl.removeCollaborationInstanceSets(collection));
        assertEquals("Value should be gotten correctly.",
                true, collaborationImpl.containsCollaborationInstanceSet(testObj1));
        assertEquals("Value should be gotten correctly.",
                true, collaborationImpl.containsCollaborationInstanceSet(testObj2));
    }

    /**
     * <p>Tests accuracy of <c>clearCollaborationInstanceSets()</c>.</p>
     * <p>Value should be set correctly.</p>
     */
    public void testClearCollaborationInstanceSets_Accuracy() {
        CollaborationInstanceSet testObj1 = new CollaborationInstanceSetImpl();
        CollaborationInstanceSet testObj2 = new CollaborationInstanceSetImpl();
        collaborationImpl.addCollaborationInstanceSet(testObj1);
        collaborationImpl.addCollaborationInstanceSet(testObj2);
        assertEquals("Value should be gotten correctly.",
                2, collaborationImpl.countCollaborationInstanceSets());
        collaborationImpl.clearCollaborationInstanceSets();
        assertEquals("Value should be gotten correctly.",
                0, collaborationImpl.countCollaborationInstanceSets());
    }

    /**
     * <p>Tests accuracy of <c>getCollaborationInstanceSets()</c>.</p>
     * <p>Value should be set correctly.</p>
     */
    public void testGetCollaborationInstanceSets_Accuracy() {
        CollaborationInstanceSet testObj1 = new CollaborationInstanceSetImpl();
        CollaborationInstanceSet testObj2 = new CollaborationInstanceSetImpl();
        CollaborationInstanceSet testObj3 = new CollaborationInstanceSetImpl();
        collaborationImpl.addCollaborationInstanceSet(testObj1);
        collaborationImpl.addCollaborationInstanceSet(testObj2);
        collaborationImpl.addCollaborationInstanceSet(testObj2);
        Collection<CollaborationInstanceSet> collection = collaborationImpl.getCollaborationInstanceSets();
        assertEquals("Value should be gotten correctly.",
                true, collection.contains(testObj1));
        assertEquals("Value should be gotten correctly.",
                true, collection.contains(testObj2));
        assertEquals("Value should be gotten correctly.",
                false, collection.contains(testObj3));
    }

    /**
     * <p>Tests <c>containsCollaborationInstanceSet(CollaborationInstanceSet)</c> method with null parameter.</p>
     * <p>IllegalArgumentException should be thrown.</p>
     */
    public void testContainsCollaborationInstanceSet_Null() {
        try {
            collaborationImpl.containsCollaborationInstanceSet((CollaborationInstanceSet) null);
            fail("IllegalArgumentException expected");
        } catch (IllegalArgumentException e) {
            // ok
        }
    }

    /**
     * <p>Tests accuracy of <c>containsCollaborationInstanceSet(CollaborationInstanceSet)</c>.</p>
     * <p>Value should be set correctly.</p>
     */
    public void testContainsCollaborationInstanceSet_Accuracy() {
        CollaborationInstanceSet testObj = new CollaborationInstanceSetImpl();
        assertEquals("Value should be gotten correctly.",
                false, collaborationImpl.containsCollaborationInstanceSet(testObj));
        collaborationImpl.addCollaborationInstanceSet(testObj);
        assertEquals("Value should be gotten correctly.",
                true, collaborationImpl.containsCollaborationInstanceSet(testObj));
    }

    /**
     * <p>Tests accuracy of <c>countCollaborationInstanceSets()</c>.</p>
     * <p>Value should be set correctly.</p>
     */
    public void testCountCollaborationInstanceSets_Accuracy() {
        assertEquals("Value should be gotten correctly.",
                0, collaborationImpl.countCollaborationInstanceSets());
        CollaborationInstanceSet testObj = new CollaborationInstanceSetImpl();
        collaborationImpl.addCollaborationInstanceSet(testObj);
        assertEquals("Value should be gotten correctly.",
                1, collaborationImpl.countCollaborationInstanceSets());
        collaborationImpl.addCollaborationInstanceSet(testObj);
        collaborationImpl.addCollaborationInstanceSet(testObj);
        assertEquals("Value should be gotten correctly.",
                3, collaborationImpl.countCollaborationInstanceSets());
    }

    /**
     * <p>Tests accuracy of <c>getRepresentedClassifier</c> method.</p>
     * <p>Value should be gotten correctly.</p>
     */
    public void testGetRepresentedClassifierAccuracy() {
        assertEquals("Value should be gotten correctly.", null, collaborationImpl.getRepresentedClassifier());
        Classifier testObj = new MockClassifier();
        collaborationImpl.setRepresentedClassifier(testObj);
        assertEquals("Value should be gotten correctly.", testObj, collaborationImpl.getRepresentedClassifier());
    }

    /**
     * <p>Tests accuracy of <c>setRepresentedClassifier</c> method.</p>
     * <p>Value should be set correctly.</p>
     */
    public void testSetRepresentedClassifierAccuracy() {
        assertEquals("Value should be gotten correctly.", null, collaborationImpl.getRepresentedClassifier());
        Classifier testObj = new MockClassifier();
        collaborationImpl.setRepresentedClassifier(testObj);
        assertEquals("Value should be gotten correctly.", testObj, collaborationImpl.getRepresentedClassifier());
    }

    /**
     * <p>Tests accuracy of <c>getRepresentedOperation</c> method.</p>
     * <p>Value should be gotten correctly.</p>
     */
    public void testGetRepresentedOperationAccuracy() {
        assertEquals("Value should be gotten correctly.", null, collaborationImpl.getRepresentedOperation());
        Operation testObj = new MockOperation();
        collaborationImpl.setRepresentedOperation(testObj);
        assertEquals("Value should be gotten correctly.", testObj, collaborationImpl.getRepresentedOperation());
    }

    /**
     * <p>Tests accuracy of <c>setRepresentedOperation</c> method.</p>
     * <p>Value should be set correctly.</p>
     */
    public void testSetRepresentedOperationAccuracy() {
        assertEquals("Value should be gotten correctly.", null, collaborationImpl.getRepresentedOperation());
        Operation testObj = new MockOperation();
        collaborationImpl.setRepresentedOperation(testObj);
        assertEquals("Value should be gotten correctly.", testObj, collaborationImpl.getRepresentedOperation());
    }

    /**
     * <p>Tests <c>addOwnedElement(OwnedElement)</c> method with null parameter.</p>
     * <p>IllegalArgumentException should be thrown.</p>
     */
    public void testAddOwnedElement_Null() {
        try {
            collaborationImpl.addOwnedElement((ModelElement) null);
            fail("IllegalArgumentException expected");
        } catch (IllegalArgumentException e) {
            // ok
        }
    }

    /**
     * <p>Tests accuracy of <c>addOwnedElement(OwnedElement)</c>.</p>
     * <p>Value should be set correctly.</p>
     */
    public void testAddOwnedElement_Accuracy() {
        ModelElement testObj = new MockModelElement();
        assertEquals("Value should be gotten correctly.",
                false, collaborationImpl.containsOwnedElement(testObj));
        collaborationImpl.addOwnedElement(testObj);
        assertEquals("Value should be gotten correctly.",
                true, collaborationImpl.containsOwnedElement(testObj));
    }

    /**
     * <p>Tests <c>removeOwnedElement(OwnedElement)</c> method with null parameter.</p>
     * <p>IllegalArgumentException should be thrown.</p>
     */
    public void testRemoveOwnedElement_Null() {
        try {
            collaborationImpl.removeOwnedElement((ModelElement) null);
            fail("IllegalArgumentException expected");
        } catch (IllegalArgumentException e) {
            // ok
        }
    }

    /**
     * <p>Tests accuracy of <c>removeOwnedElement(OwnedElement)</c>.</p>
     * <p>Value should be set correctly.</p>
     */
    public void testRemoveOwnedElement_Accuracy1() {
        ModelElement testObj = new MockModelElement();
        collaborationImpl.addOwnedElement(testObj);
        collaborationImpl.addOwnedElement(testObj);

        assertEquals("Value should be gotten correctly.",
                true, collaborationImpl.removeOwnedElement(testObj));
        assertEquals("Value should be gotten correctly.",
                true, collaborationImpl.containsOwnedElement(testObj));
        assertEquals("Value should be gotten correctly.",
                true, collaborationImpl.removeOwnedElement(testObj));
        assertEquals("Value should be gotten correctly.",
                false, collaborationImpl.containsOwnedElement(testObj));
    }

    /**
     * <p>Tests accuracy of <c>removeOwnedElement(OwnedElement)</c>.</p>
     * <p>Value should be set correctly.</p>
     */
    public void testRemoveOwnedElement_Accuracy2() {
        ModelElement testObj = new MockModelElement();
        collaborationImpl.addOwnedElement(testObj);

        assertEquals("Value should be gotten correctly.",
                true, collaborationImpl.removeOwnedElement(testObj));
        assertEquals("Value should be gotten correctly.",
                false, collaborationImpl.containsOwnedElement(testObj));
        assertEquals("Value should be gotten correctly.",
                false, collaborationImpl.removeOwnedElement(testObj));
        assertEquals("Value should be gotten correctly.",
                false, collaborationImpl.containsOwnedElement(testObj));
    }

    /**
     * <p>Tests accuracy of <c>clearOwnedElements()</c>.</p>
     * <p>Value should be set correctly.</p>
     */
    public void testClearOwnedElements_Accuracy() {
        ModelElement testObj1 = new MockModelElement();
        ModelElement testObj2 = new MockModelElement();
        collaborationImpl.addOwnedElement(testObj1);
        collaborationImpl.addOwnedElement(testObj2);
        assertEquals("Value should be gotten correctly.",
                2, collaborationImpl.countOwnedElements());
        collaborationImpl.clearOwnedElements();
        assertEquals("Value should be gotten correctly.",
                0, collaborationImpl.countOwnedElements());
    }

    /**
     * <p>Tests accuracy of <c>getOwnedElements()</c>.</p>
     * <p>Value should be set correctly.</p>
     */
    public void testGetOwnedElements_Accuracy() {
        ModelElement testObj1 = new MockModelElement();
        ModelElement testObj2 = new MockModelElement();
        ModelElement testObj3 = new MockModelElement();
        collaborationImpl.addOwnedElement(testObj1);
        collaborationImpl.addOwnedElement(testObj2);
        collaborationImpl.addOwnedElement(testObj2);
        Collection<ModelElement> collection = collaborationImpl.getOwnedElements();
        assertEquals("Value should be gotten correctly.",
                true, collection.contains(testObj1));
        assertEquals("Value should be gotten correctly.",
                true, collection.contains(testObj2));
        assertEquals("Value should be gotten correctly.",
                false, collection.contains(testObj3));
    }

    /**
     * <p>Tests <c>containsOwnedElement(OwnedElement)</c> method with null parameter.</p>
     * <p>IllegalArgumentException should be thrown.</p>
     */
    public void testContainsOwnedElement_Null() {
        try {
            collaborationImpl.containsOwnedElement((ModelElement) null);
            fail("IllegalArgumentException expected");
        } catch (IllegalArgumentException e) {
            // ok
        }
    }

    /**
     * <p>Tests accuracy of <c>containsOwnedElement(OwnedElement)</c>.</p>
     * <p>Value should be set correctly.</p>
     */
    public void testContainsOwnedElement_Accuracy() {
        ModelElement testObj = new MockModelElement();
        assertEquals("Value should be gotten correctly.",
                false, collaborationImpl.containsOwnedElement(testObj));
        collaborationImpl.addOwnedElement(testObj);
        assertEquals("Value should be gotten correctly.",
                true, collaborationImpl.containsOwnedElement(testObj));
    }

    /**
     * <p>Tests accuracy of <c>countOwnedElements()</c>.</p>
     * <p>Value should be set correctly.</p>
     */
    public void testCountOwnedElements_Accuracy() {
        assertEquals("Value should be gotten correctly.",
                0, collaborationImpl.countOwnedElements());
        ModelElement testObj = new MockModelElement();
        collaborationImpl.addOwnedElement(testObj);
        assertEquals("Value should be gotten correctly.",
                1, collaborationImpl.countOwnedElements());
        collaborationImpl.addOwnedElement(testObj);
        collaborationImpl.addOwnedElement(testObj);
        assertEquals("Value should be gotten correctly.",
                3, collaborationImpl.countOwnedElements());
    }

}
