/*
 * Copyright (C) 2006 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.uml.model.core.accuracytests;

import java.util.Collection;

import com.topcoder.uml.model.core.ModelElement;
import com.topcoder.uml.model.core.NamespaceAbstractImpl;

import junit.framework.TestCase;

/**
 * <p>
 * Accuracy tests for <code>NamespaceAbstractImpl</code>.
 * </p>
 *
 * @author littlebull
 * @version 1.0
 */
public class NamespaceAbstractImplAccuracyTests extends TestCase {

    /** Represents the mocked <code>NamespaceAbstractImpl</code> instance used for testing. */
    private NamespaceAbstractImpl namespace;

    /** Represents the <code>ModelElement</code> instance used for testing. */
    private ModelElement element;

    /**
     * Set up the test environment.
     */
    protected void setUp() {
        //creates the mocked NamespaceAbstractImpl instance
        namespace = new MockNamespaceImpl();
        //creates the ModelElement instance
        element = new MockModelElementImpl();
    }

    /**
     * Accuracy test of method <code>countOwnedElements()</code>.
     */
    public void testCountOwnedElements_Accuracy() {
        //initial value is empty ArrayList
        assertEquals(0, namespace.countOwnedElements());
    }

    /**
     * Accuracy test of method <code>addOwnedElement(ModelElement)</code>.
     */
    public void testAddOwnedElement_Accuracy() {
        //add an ModelElement
        namespace.addOwnedElement(element);
        assertEquals(1, namespace.countOwnedElements());
        //add the same ModelElement
        namespace.addOwnedElement(element);
        assertEquals(2, namespace.countOwnedElements());
    }

    /**
     * Accuracy test of method <code>containsOwnedElement(ModelElement)</code>.
     */
    public void testCntainsOwnedElement_Accuracy() {
        assertFalse(namespace.containsOwnedElement(element));
        namespace.addOwnedElement(element);
        assertTrue(namespace.containsOwnedElement(element));
    }

    /**
     * Accuracy test of method <code>getOwnedElements()</code>.
     */
    public void testGetOwnedElements_Accuracy() {
        //add an ModelElement
        namespace.addOwnedElement(element);
        //get all the ModelElement
        Collection<ModelElement> ownedElements = namespace.getOwnedElements();
        assertEquals(1, ownedElements.size());
        assertTrue(ownedElements.contains(element));
        //add a new ModelElment to the returned Collection
        ownedElements.add(element);
        assertEquals("The inner Collection should be unchanged.", 1, namespace.countOwnedElements());
    }

    /**
     * Accuracy test of method <code>removeOwnedElement(ModelElement)</code>.
     */
    public void testRemoveOwnedElement_Accuracy() {
        assertFalse(namespace.removeOwnedElement(element));
        namespace.addOwnedElement(element);
        assertTrue(namespace.removeOwnedElement(element));
    }

    /**
     * Accuracy test of method <code>clearOwnedElements()</code>.
     */
    public void testClearOwnedElements_Accuracy() {
        for (int i = 0; i < 10; i++) {
            namespace.addOwnedElement(element);
        }
        namespace.clearOwnedElements();
        assertEquals(0, namespace.countOwnedElements());
    }
}
