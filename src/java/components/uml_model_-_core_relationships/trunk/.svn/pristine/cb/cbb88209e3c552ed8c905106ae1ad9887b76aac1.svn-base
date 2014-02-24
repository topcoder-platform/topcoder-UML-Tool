/*
 * Copyright (C) 2006 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.uml.model.core.relationships.failuretests;

import com.topcoder.uml.model.core.Attribute;
import com.topcoder.uml.model.core.relationships.AssociationEndImpl;
import com.topcoder.uml.model.core.AttributeImpl;

import junit.framework.TestCase;

/**
 * Test case for <c>AssociationEndImpl</c>.
 *
 * @author idx
 * @version 1.0
 */
public class AssociationEndImplFailureTest extends TestCase {

    /**
     * <c>AssociationEndImpl</c> instance used for tests.
     */
    private AssociationEndImpl impl;

    /**
     * Initializes the <c>AssociationEndImpl</c> instance.
     */
    protected void setUp() {
        impl = new AssociationEndImpl();
    }

    /**
     * Disposes the <c>AssociationEndImpl</c> instance.
     */
    protected void tearDown() {
        impl = null;
    }

    /**
     * Test <c>addQualifier(Attribute)</c> when <c>qualifier</c> is <c>null</c>, <c>IllegalArgumentException</c> is
     * expected.
     */
    public void testAddQualifierAttributeNullQualifier() {
        try {
            impl.addQualifier(null);
            fail("IllegalArgumentException is expected.");
        } catch (IllegalArgumentException iae) {
            // good
        }
    }

    /**
     * Test <c>addQualifier(int, Attribute)</c> when <c>qualifier</c> is <c>null</c>, <c>IllegalArgumentException</c>
     * is expected.
     */
    public void testAddQualifierIntAttributeNullQualifier() {
        try {
            impl.addQualifier(0, null);
            fail("IllegalArgumentException is expected.");
        } catch (IllegalArgumentException iae) {
            // good
        }
    }

    /**
     * Test <c>addQualifier(int, Attribute)</c> when <c>index</c> is negative, <c>IndexOutOfBoundsException</c> is
     * expected.
     */
    public void testAddQualifierIntAttributeNegativeIndex() {
        try {
            impl.addQualifier(-1, new AttributeFailureImpl());
            fail("IndexOutOfBoundsException is expected.");
        } catch (IndexOutOfBoundsException ioobe) {
            // good
        }
    }

    /**
     * Test <c>addQualifier(int, Attribute)</c> when <c>index</c> is out of range, <c>IndexOutOfBoundsException</c>
     * is expected.
     */
    public void testAddQualifierIntAttributeIndexOutOfRange() {
        try {
            impl.addQualifier(1, new AttributeFailureImpl());
            fail("IndexOutOfBoundsException is expected.");
        } catch (IndexOutOfBoundsException ioobe) {
            // good
        }
    }

    /**
     * Test <c>setQualifier(int, Attribute)</c> when <c>qualifier</c> is <c>null</c>, <c>IllegalArgumentException</c>
     * is expected.
     */
    public void testSetQualifierNullQualifier() {
        try {
            impl.addQualifier(new AttributeFailureImpl());
            impl.setQualifier(0, null);
            fail("IllegalArgumentException is expected.");
        } catch (IllegalArgumentException iae) {
            // good
        }
    }

    /**
     * Test <c>setQualifier(int, Attribute)</c> when <c>index</c> is negative, <c>IndexOutOfBoundsException</c> is
     * expected.
     */
    public void testSetQualifierNegativeIndex() {
        try {
            impl.setQualifier(-1, new AttributeFailureImpl());
            fail("IndexOutOfBoundsException is expected.");
        } catch (IndexOutOfBoundsException ioore) {
            // good
        }
    }

    /**
     * Test <c>setQualifier(int, Attribute)</c> when <c>index</c> is out of range, <c>IndexOutOfBoundsException</c>
     * is expected.
     */
    public void testSetQualifierIndexOutOfRange() {
        try {
            impl.setQualifier(0, new AttributeFailureImpl());
            fail("IndexOutOfBoundsException is expected.");
        } catch (IndexOutOfBoundsException ioore) {
            // good
        }
    }

    /**
     * Test <c>removeQualifier(int)</c> when <c>index</c> is negative, <c>IndexOutOfBoundsException</c> is expected.
     */
    public void testRemoveQualifierIntNegativeIndex() {
        try {
            impl.removeQualifier(-1);
            fail("IndexOutOfBoundsException is expected.");
        } catch (IndexOutOfBoundsException ioore) {
            // good
        }
    }

    /**
     * Test <c>removeQualifier(int)</c> when <c>index</c> is out of range, <c>IndexOutOfBoundsException</c> is
     * expected.
     */
    public void testRemoveQualifierIntIndexOutOfRange() {
        try {
            impl.removeQualifier(0);
            fail("IndexOutOfBoundsException is expected.");
        } catch (IndexOutOfBoundsException ioore) {
            // good
        }
    }

    /**
     * Test <c>removeQualifier(Attribute)</c> when <c>Qualifier</c> is <c>null</c>, <c>IllegalArgumentException</c>
     * is expected.
     */
    public void testRemoveQualifierAttributeNullQualifier() {
        try {
            impl.removeQualifier(null);
            fail("IllegalArgumentException is expected.");
        } catch (IllegalArgumentException iae) {
            // good
        }
    }

    /**
     * Test <c>containsQualifier(Attribute)</c> when <c>Qualifier</c> is <c>null</c>, <c>IllegalArgumentException</c>
     * is expected.
     */
    public void testContainsQualifierNullQualifier() {
        try {
            impl.containsQualifier(null);
            fail("IllegalArgumentException is expected.");
        } catch (IllegalArgumentException iae) {
            // good
        }
    }

    /**
     * Test <c>indexOfQualifier(Attribute)</c> when <c>Qualifier</c> is <c>null</c>, <c>IllegalArgumentException</c>
     * is expected.
     */
    public void testIndexOfQualifierNullQualifier() {
        try {
            impl.indexOfQualifier(null);
            fail("IllegalArgumentException is expected.");
        } catch (IllegalArgumentException iae) {
            // good
        }
    }

    /**
     * Test <c>addSpecification(Classifier)</c> when <c>specification</c> is <c>null</c>,
     * <c>IllegalArgumentException</c> is expected.
     */
    public void testAddSpecificationNullSpecification() {
        try {
            impl.addSpecification(null);
            fail("IllegalArgumentException is expected.");
        } catch (IllegalArgumentException iae) {
            // good
        }
    }

    /**
     * Test <c>removeSpecification(Classifier)</c> when <c>specification</c> is <c>null</c>,
     * <c>IllegalArgumentException</c> is expected.
     */
    public void testRemoveSpecificationNullSpecification() {
        try {
            impl.removeSpecification(null);
            fail("IllegalArgumentException is expected.");
        } catch (IllegalArgumentException iae) {
            // good
        }
    }

    /**
     * Test <c>containsSpecification(Classifier)</c> when <c>specification</c> is <c>null</c>,
     * <c>IllegalArgumentException</c> is expected.
     */
    public void testContainsSpecificationNullSpecification() {
        try {
            impl.containsSpecification(null);
            fail("IllegalArgumentException is expected.");
        } catch (IllegalArgumentException iae) {
            // good
        }
    }

}

final class AttributeFailureImpl extends AttributeImpl implements Attribute {
    /**
     * Creates a new instance of <c>AttributeFailureImpl</c>.
     */
    public AttributeFailureImpl() {
    }
}