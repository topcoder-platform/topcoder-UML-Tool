/*
 * Copyright (C) 2006 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.uml.model.core.relationships;

import com.topcoder.uml.model.core.classifiers.ClassImpl;

import junit.framework.TestCase;

import java.util.List;


/**
 * Unit test for AssociationClassImpl.
 *
 * @author fanse
 * @version 1.0
 */
public class AssociationClassImplUnitTest extends TestCase {
    /**
     * The AssociationClassImpl instance for test.
     */
    private AssociationClassImpl assoClassIml = null;

    /**
     * The Association instance for test.
     */
    private AssociationEnd assoEnd1 = new AssociationEndImpl();

    /**
     * The Association instance for test.
     */
    private AssociationEnd assoEnd2 = new AssociationEndImpl();

    /**
     * Create the test instance.
     */
    public void setUp() {
        assoClassIml = new AssociationClassImpl();
    }

    /**
     * Tear down the test instance.
     */
    public void tearDown() {
        assoClassIml = null;
    }

    /**
     * Test constructor accuracy. No exception will be thrown.
     */
    public void testConstructorAccuracy() {
        AssociationClassImpl ctorImpl = new AssociationClassImpl();

        assertNotNull("The multiplicityImpl should not be null.", ctorImpl);
        assertNotNull("association should be initialized.",
            ctorImpl.getConnections());
    }

    /**
     * Test constructor with null. IllegalArgumentException will be thrown.
     */
    public void testConstructorWithNull() {
        try {
            new AssociationClassImpl(null);
        } catch (IllegalArgumentException ex) {
            // expected.
        }
    }

    /**
     * Test constructor with valid simple type. IllegalArgumentException will be thrown.
     */
    public void testConstructorWithValidTypr() {
        AssociationClassImpl old = new AssociationClassImpl();
        AssociationClassImpl ctorImpl = new AssociationClassImpl(old);

        assertNotNull("The ctorImpl should not be null.", ctorImpl);
        assertNotNull("association should be initialized.",
            ctorImpl.getConnections());
    }

    /**
     * Test inheritance of <c>AssociationClassImpl</c>. <c>AssociationClassImpl</c> should inherit from <c>ClassImpl</c>.
     */
    public void testAssociationClassImplAccuracyInheritClassImpl() {
        assertTrue("AssociationClassImpl should inherit from ClassImpl.",
            ((Object) new AssociationClassImpl()) instanceof ClassImpl);
    }

    /**
     * Test inheritance of <c>AssociationClassImpl</c>. <c>AssociationClassImpl</c> should inherit from
     * <c>AssociationClass</c>.
     */
    public void testAssociationClassImplAccuracyInheritAssociationClass() {
        assertTrue("AssociationClassImpl should inherit from AssociationClass.",
            ((Object) new AssociationClassImpl()) instanceof AssociationClass);
    }

    /**
     * Test addConnection with null. IllegalArgumentException should be thrown because of the invalid parameter.
     */
    public void testAddConnectionWithNull() {
        try {
            assoClassIml.addConnection(null);
            fail(
                "IllegalArgumentException should be thrown because of the invalid parameter.");
        } catch (IllegalArgumentException e) {
            // expected.
        }
    }

    /**
     * Test addConnection accuracy. No exception should be thrown.
     */
    public void testAddConnectionAccuracy() {
        assoClassIml.addConnection(assoEnd1);

        assertTrue("Add assoEnd failed.",
            assoClassIml.containsConnection(assoEnd1));
    }

    /**
     * Test addConnection accuracy for allowing duplicates. No exception should be thrown.
     */
    public void testAddConnectionAccuracyDuplicates() {
        assoClassIml.addConnection(assoEnd1);
        assoClassIml.addConnection(assoEnd1);

        assertTrue("Add assoEnds failed.", assoClassIml.countConnections() == 2);
    }

    /**
     * Test addConnection at index with null. IllegalArgumentException should be thrown because of the invalid
     * parameter.
     */
    public void testAddConnectionAtIndexWithNull() {
        try {
            assoClassIml.addConnection(0, null);
            fail(
                "IllegalArgumentException should be thrown because of the invalid parameter.");
        } catch (IllegalArgumentException e) {
            // expected.
        }
    }

    /**
     * Test addConnection at index with null. IndexOutOfBoundsException should be thrown because of the invalid
     * parameter.
     */
    public void testAddConnectionAtIndexWithNegative() {
        try {
            assoClassIml.addConnection(-1, assoEnd1);
            fail(
                "IndexOutOfBoundsException should be thrown because of the invalid parameter.");
        } catch (IndexOutOfBoundsException e) {
            // expected.
        }
    }

    /**
     * Test addConnection at index with null. IndexOutOfBoundsException should be thrown because of the invalid
     * parameter.
     */
    public void testAddConnectionAtIndexWithUpperBounds() {
        try {
            assoClassIml.addConnection(1, assoEnd1);
            fail(
                "IndexOutOfBoundsException should be thrown because of the invalid parameter.");
        } catch (IndexOutOfBoundsException e) {
            // expected.
        }
    }

    /**
     * Test addConnection at index accuracy. No exception should be thrown.
     */
    public void testAddConnectionAtIndexAccuracy() {
        assoClassIml.addConnection(0, assoEnd1);

        assertTrue("Add assoEnds failed.",
            assoClassIml.containsConnection(assoEnd1));
    }

    /**
     * Test setConnection with null. IllegalArgumentException should be thrown because of the invalid parameter.
     */
    public void testSetConnectionWithNull() {
        try {
            assoClassIml.setConnection(0, null);
            fail(
                "IllegalArgumentException should be thrown because of the invalid parameter.");
        } catch (IllegalArgumentException e) {
            // expected.
        }
    }

    /**
     * Test setConnection with null. IndexOutOfBoundsException should be thrown because of the invalid parameter.
     */
    public void testSetConnectionWithNegative() {
        try {
            assoClassIml.setConnection(-1, assoEnd1);
            fail(
                "IndexOutOfBoundsException should be thrown because of the invalid parameter.");
        } catch (IndexOutOfBoundsException e) {
            // expected.
        }
    }

    /**
     * Test setConnection with null. IndexOutOfBoundsException should be thrown because of the invalid parameter.
     */
    public void testSetConnectionWithUpperBounds() {
        try {
            assoClassIml.setConnection(0, assoEnd1);
            fail(
                "IndexOutOfBoundsException should be thrown because of the invalid parameter.");
        } catch (IndexOutOfBoundsException e) {
            // expected.
        }
    }

    /**
     * Test setConnection accuracy. No exception should be thrown.
     */
    public void testSetConnectionAtIndexAccuracy() {
        assoClassIml.addConnection(assoEnd1);
        assoClassIml.setConnection(0, assoEnd2);

        assertFalse("Set assoEnds failed.",
            assoClassIml.containsConnection(assoEnd1));
        assertTrue("Set assoEnds failed.",
            assoClassIml.containsConnection(assoEnd2));
    }

    /**
     * Test removeConnection with negative. IndexOutOfBoundsException should be thrown.
     */
    public void testRemoveConnectionWithNegative() {
        try {
            assoClassIml.removeConnection(-1);
            fail(
                "IndexOutOfBoundsException should be thrown because of the invalid parameter.");
        } catch (IndexOutOfBoundsException ex) {
            // expected.
        }
    }

    /**
     * Test removeConnection with upper bound. IndexOutOfBoundsException should be thrown.
     */
    public void testRemoveConnectionWithUpperBound() {
        try {
            assoClassIml.removeConnection(0);
            fail(
                "IndexOutOfBoundsException should be thrown because of the invalid parameter.");
        } catch (IndexOutOfBoundsException ex) {
            // expected.
        }
    }

    /**
     * Test removeConnection with index accuracy. IndexOutOfBoundsException should be thrown.
     */
    public void testRemoveConnectionWithIndexAccuracy() {
        assoClassIml.addConnection(assoEnd1);
        assoClassIml.removeConnection(0);

        assertFalse("Remove connection failed.",
            assoClassIml.containsConnection(assoEnd1));
    }

    /**
     * Test removeConnection with null. IllegalArgumentException should be thrown because of the invalid parameter.
     */
    public void testRemoveConnectionWithNull() {
        try {
            assoClassIml.removeConnection(null);
            fail(
                "IllegalArgumentException should be thrown because of the invalid parameter.");
        } catch (IllegalArgumentException e) {
            // expected.
        }
    }

    /**
     * Test removeConnection accuracy. No exception should be thrown.
     */
    public void testRemoveConnectionAccuracy() {
        assoClassIml.addConnection(assoEnd1);
        assoClassIml.addConnection(assoEnd2);
        assoClassIml.removeConnection(assoEnd1);
        assertTrue("Remove assoEnd failed, remained assoEnds should be 1.",
            assoClassIml.countConnections() == 1);
        assertFalse("Remove assoEnd failed.",
            assoClassIml.containsConnection(assoEnd1));
    }

    /**
     * Test clearConnections accuracy. No exception should be thrown.
     */
    public void testClearConnectionsAccuracy() {
        assoClassIml.addConnection(assoEnd1);
        assoClassIml.addConnection(assoEnd2);
        assoClassIml.clearConnections();

        assertTrue("Clear assoEnds failed.",
            assoClassIml.countConnections() == 0);
    }

    /**
     * Test getConnections accuracy for contained assoEnd. No exception should be thrown.
     */
    public void testGetConnections1() {
        assoClassIml.addConnection(assoEnd1);
        assoClassIml.addConnection(assoEnd2);

        List<AssociationEnd> list = assoClassIml.getConnections();

        assertNotNull("Get assoEnds failed.", list);
        assertTrue("Get wrong assoEnds.", list.size() == 2);
        assertTrue("Get wrong assoEnds.", list.contains(assoEnd1));
        assertTrue("Get wrong assoEnds.", list.contains(assoEnd2));
    }

    /**
     * Test containConnection with null. IllegalArgumentException should be thrown because of the invalid parameter.
     */
    public void testContainConnectionWithNull() {
        try {
            assoClassIml.containsConnection(null);
        } catch (IllegalArgumentException e) {
            // expected.
        }
    }

    /**
     * Test containConnection accuracy. No exception should be thrown.
     */
    public void testContainConnectionAccracy() {
        assoClassIml.addConnection(assoEnd1);

        assertTrue("containsConnection returns a wrong value.",
            assoClassIml.containsConnection(assoEnd1));
        assertFalse("containsConnection returns a wrong value.",
            assoClassIml.containsConnection(assoEnd2));
    }

    /**
     * Test countConnections accuracy. No exception should be thrown.
     */
    public void testCountConnectionsAccuracy() {
        assertTrue("Count assoEnds error.", assoClassIml.countConnections() == 0);
        assoClassIml.addConnection(assoEnd1);
        assoClassIml.addConnection(assoEnd2);
        assertTrue("Count assoEnds error.", assoClassIml.countConnections() == 2);
        assoClassIml.removeConnection(assoEnd1);
        assertTrue("Count assoEnds error.", assoClassIml.countConnections() == 1);
    }
}
