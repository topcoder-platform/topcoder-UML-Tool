/*
 * Copyright (C) 2006 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.uml.model.core.relationships.failuretests;

import com.topcoder.uml.model.core.relationships.AssociationClassImpl;
import com.topcoder.uml.model.core.relationships.AssociationEndImpl;

import junit.framework.TestCase;

/**
 * Test case for <c>AssociationClassImpl</c>.
 *
 * @author idx
 * @version 1.0
 */
public class AssociationClassImplFailureTest extends TestCase {

    /**
     * <c>AssociationClassImpl</c> instance used for tests.
     */
    private AssociationClassImpl impl;

    /**
     * Initializes the <c>AssociationClassImpl</c> instance.
     */
    protected void setUp() {
        impl = new AssociationClassImpl();
    }

    /**
     * Disposes the <c>AssociationClassImpl</c> instance.
     */
    protected void tearDown() {
        impl = null;
    }

    /**
     * Test <c>AssociationClassImpl(Association)</c> when <c>association</c> is <c>null</c>,
     * <c>IllegalArgumentException</c> is expected.
     */
    public void testAssociationClassImplAssociationNullAssociation() {
        try {
            new AssociationClassImpl(null);
            fail("IllegalArgumentException is expected.");
        } catch (IllegalArgumentException iae) {
            // good
        }
    }

    /**
     * Test <c>addConnection(AssociationEnd)</c> when <c>connection</c> is <c>null</c>, <c>IllegalArgumentException</c>
     * is expected.
     */
    public void testAddConnectionAssociationEndNullConnection() {
        try {
            impl.addConnection(null);
            fail("IllegalArgumentException is expected.");
        } catch (IllegalArgumentException iae) {
            // good
        }
    }

    /**
     * Test <c>addConnection(int, AssociationEnd)</c> when <c>connection</c> is <c>null</c>,
     * <c>IllegalArgumentException</c> is expected.
     */
    public void testAddConnectionIntAssociationEndNullConnection() {
        try {
            impl.addConnection(0, null);
            fail("IllegalArgumentException is expected.");
        } catch (IllegalArgumentException iae) {
            // good
        }
    }

    /**
     * Test <c>addConnection(int, AssociationEnd)</c> when <c>index</c> is negative, <c>IndexOutOfBoundsException</c>
     * is expected.
     */
    public void testAddConnectionIntAssociationEndNegativeIndex() {
        try {
            impl.addConnection(-1, new AssociationEndImpl());
            fail("IndexOutOfBoundsException is expected.");
        } catch (IndexOutOfBoundsException ioobe) {
            // good
        }
    }

    /**
     * Test <c>addConnection(int, AssociationEnd)</c> when <c>index</c> is out of range,
     * <c>IndexOutOfBoundsException</c> is expected.
     */
    public void testAddConnectionIntAssociationEndIndexOutOfRange() {
        try {
            impl.addConnection(1, new AssociationEndImpl());
            fail("IndexOutOfBoundsException is expected.");
        } catch (IndexOutOfBoundsException ioobe) {
            // good
        }
    }

    /**
     * Test <c>setConnection(int, AssociationEnd)</c> when <c>connection</c> is <c>null</c>,
     * <c>IllegalArgumentException</c> is expected.
     */
    public void testSetConnectionNullConnection() {
        try {
            impl.addConnection(new AssociationEndImpl());
            impl.setConnection(0, null);
            fail("IllegalArgumentException is expected.");
        } catch (IllegalArgumentException iae) {
            // good
        }
    }

    /**
     * Test <c>setConnection(int, AssociationEnd)</c> when <c>index</c> is negative, <c>IndexOutOfBoundsException</c>
     * is expected.
     */
    public void testSetConnectionNegativeIndex() {
        try {
            impl.setConnection(-1, new AssociationEndImpl());
            fail("IndexOutOfBoundsException is expected.");
        } catch (IndexOutOfBoundsException ioobe) {
            // good
        }
    }

    /**
     * Test <c>setConnection(int, AssociationEnd)</c> when <c>index</c> is out of range,
     * <c>IndexOutOfBoundsException</c> is expected.
     */
    public void testSetConnectionIndexOutOfRange() {
        try {
            impl.setConnection(0, new AssociationEndImpl());
            fail("IndexOutOfBoundsException is expected.");
        } catch (IndexOutOfBoundsException ioobe) {
            // good
        }
    }

    /**
     * Test <c>removeConnection(int)</c> when <c>index</c> is negative, <c>IndexOutOfBoundsException</c>
     * is expected.
     */
    public void testRemoveConnectionIntNegativeIndex() {
        try {
            impl.removeConnection(-1);
            fail("IndexOutOfBoundsException is expected.");
        } catch (IndexOutOfBoundsException ioobe) {
            // good
        }
    }

    /**
     * Test <c>removeConnection(int)</c> when <c>index</c> is out of range, <c>IndexOutOfBoundsException</c>
     * is expected.
     */
    public void testRemoveConnectionIntIndexOutOfRange() {
        try {
            impl.removeConnection(0);
            fail("IndexOutOfBoundsException is expected.");
        } catch (IndexOutOfBoundsException ioobe) {
            // good
        }
    }

    /**
     * Test <c>removeConnection(AssociationEnd)</c> when <c>connection</c> is <c>null</c>,
     * <c>IllegalArgumentException</c> is expected.
     */
    public void testRemoveConnectionAssociationEndNullConnection() {
        try {
            impl.removeConnection(null);
            fail("IllegalArgumentException is expected.");
        } catch (IllegalArgumentException iae) {
            // good
        }
    }

    /**
     * Test <c>containsConnection(AssociationEnd)</c> when <c>connection</c> is <c>null</c>,
     * <c>IllegalArgumentException</c> is expected.
     */
    public void testContainsConnectionNullConnection() {
        try {
            impl.containsConnection(null);
            fail("IllegalArgumentException is expected.");
        } catch (IllegalArgumentException iae) {
            // good
        }
    }

    /**
     * Test <c>indexOfConnection(AssociationEnd)</c> when <c>connection</c> is <c>null</c>,
     * <c>IllegalArgumentException</c> is expected.
     */
    public void testIndexOfConnectionNullConnection() {
        try {
            impl.indexOfConnection(null);
            fail("IllegalArgumentException is expected.");
        } catch (IllegalArgumentException iae) {
            // good
        }
    }

}
