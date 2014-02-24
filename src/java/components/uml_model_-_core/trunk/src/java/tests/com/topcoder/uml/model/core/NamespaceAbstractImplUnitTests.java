/*
 * Copyright (C) 2006 TopCoder Inc., All Rights Reserved.
 */

package com.topcoder.uml.model.core;

import junit.framework.TestCase;
import java.util.ArrayList;
import java.util.Collection;

/**
 * <p>
 * Unit test for <code>NamespaceAbstractImpl</code> class.
 * </p>
 *
 * @author vividmxx
 * @version 1.0
 */
public class NamespaceAbstractImplUnitTests extends TestCase {
    /**
     * This class extends <code>NamespaceAbstractImpl</code>. It is only used in unit test.
     */
    private class NamespaceImpl extends NamespaceAbstractImpl {
        /**
         * <p>
         * The default constructor.
         * <p>
         */
        public NamespaceImpl() {
        }
    }

    /**
     * This class extends <code>ModelElementAbstractImpl</code>. It is only used in unit test.
     */
    private class ModelElementImpl extends ModelElementAbstractImpl {
        /**
         * <p>
         * The default constructor.
         * <p>
         */
        public ModelElementImpl() {
        }
    }

    /**
     * <p>
     * Represents the <code>NamespaceAbstractImpl</code> instance used for tests.
     * </p>
     */
    private NamespaceAbstractImpl testNamespaceAbstractImpl;

    /**
     * <p>
     * Set up the test environment.
     * </p>
     */
    protected void setUp() {
        testNamespaceAbstractImpl = new NamespaceImpl();
    }

    /**
     * <p>
     * Accuracy test the NamespaceAbstractImpl constructor.
     * </p>
     */
    public void testNamespaceAbstractImplConstructor() {
        assertNotNull("Create NamespaceAbstractImpl object incorrectly.", new NamespaceImpl());
    }

    /**
     * <p>
     * Accuracy test the method of <code>addOwnedElement(ModelElement)</code>.
     * </p>
     */
    public void testAddOwnedElement() {
        ModelElement ownedElement = new ModelElementImpl();
        testNamespaceAbstractImpl.addOwnedElement(ownedElement);
        assertTrue("Add ownedElement incorrectly.", testNamespaceAbstractImpl.removeOwnedElement(ownedElement));
    }

    /**
     * <p>
     * Test the method of <code>addOwnedElement(ModelElement)</code> with null ownedElement. Should throw
     * IllegalArgumentException.
     * </p>
     */
    public void testAddOwnedElementNullModelElement() {
        try {
            testNamespaceAbstractImpl.addOwnedElement(null);
            fail("IllegalArgumentException should be thrown.");
        } catch (IllegalArgumentException e) {
            // success
        }
    }

    /**
     * <p>
     * Accuracy test the method of <code>removeOwnedElement(ModelElement)</code>.
     * </p>
     */
    public void testRemoveOwnedElement() {
        ModelElement ownedElement = new ModelElementImpl();
        testNamespaceAbstractImpl.addOwnedElement(ownedElement);
        assertTrue("Remove ownedElement incorrectly.", testNamespaceAbstractImpl.removeOwnedElement(ownedElement));
    }

    /**
     * <p>
     * Test the method of <code>removeOwnedElement(ModelElement)</code> with null ownedElement. Should throw
     * IllegalArgumentException.
     * </p>
     */
    public void testRemoveOwnedElementNullModelElement() {
        try {
            testNamespaceAbstractImpl.removeOwnedElement(null);
            fail("IllegalArgumentException should be thrown.");
        } catch (IllegalArgumentException e) {
            // success
        }
    }

    /**
     * <p>
     * Accuracy test the method of <code>clearOwnedElements()</code>.
     * <p>
     */
    public void testClearOwnedElements() {
        testNamespaceAbstractImpl.clearOwnedElements();
        assertEquals("The count of ownedElement should be 0.", 0, testNamespaceAbstractImpl.countOwnedElements());
    }

    /**
     * <p>
     * Accuracy test the method of <code>getOwnedElements()</code>.
     * </p>
     */
    public void testGetOwnedElements() {
        testNamespaceAbstractImpl.clearOwnedElements();
        Collection<ModelElement> ownedElements = new ArrayList<ModelElement>();
        for (int i = 0; i < 3; ++i) {
            ModelElement ownedElement = new ModelElementImpl();
            ownedElements.add(ownedElement);
            testNamespaceAbstractImpl.addOwnedElement(ownedElement);
        }
        assertEquals("Get ownedElements incorrectly.", ownedElements, testNamespaceAbstractImpl.getOwnedElements());
    }

    /**
     * <p>
     * Accuracy test the method of <code>containsOwnedElement(ModelElement)</code>.
     * </p>
     */
    public void testContainsOwnedElement() {
        ModelElement ownedElement = new ModelElementImpl();
        testNamespaceAbstractImpl.addOwnedElement(ownedElement);
        assertTrue("Contains ownedElement incorrectly.", testNamespaceAbstractImpl.containsOwnedElement(ownedElement));

        assertFalse("Contains OwnedElement incorrectly.", testNamespaceAbstractImpl
                .containsOwnedElement(new ModelElementImpl()));
    }

    /**
     * <p>
     * Test the method of <code>containsOwnedElement(ModelElement)</code> with null model element. Should throw
     * IllegalArgumentException.
     * </p>
     */
    public void testContainsOwnedElementNullOwnedElement() {
        try {
            testNamespaceAbstractImpl.containsOwnedElement(null);
            fail("IllegalArgumentException should be thrown.");
        } catch (IllegalArgumentException e) {
            // success
        }
    }

    /**
     * <p>
     * Accuracy test the method of <code>countOwnedElements()</code>.
     * </p>
     */
    public void testCountOwnedElements() {
        testNamespaceAbstractImpl.clearOwnedElements();
        assertEquals("The count of ownedElements should be 0.", 0, testNamespaceAbstractImpl.countOwnedElements());

        testNamespaceAbstractImpl.addOwnedElement(new ModelElementImpl());
        assertEquals("The count of ownedElements should be 1.", 1, testNamespaceAbstractImpl.countOwnedElements());
    }
}
