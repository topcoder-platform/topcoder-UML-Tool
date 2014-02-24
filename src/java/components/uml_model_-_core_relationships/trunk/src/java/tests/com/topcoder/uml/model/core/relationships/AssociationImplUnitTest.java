/*
 * Copyright (C) 2006 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.uml.model.core.relationships;

import java.util.List;
import junit.framework.TestCase;
import com.topcoder.uml.model.core.GeneralizableElementAbstractImpl;

/**
 * Unit test for AssociationImpl.
 *
 * @author fanse
 * @version 1.0
 */
public class AssociationImplUnitTest extends TestCase {
    /**
     * The AssociationImpl instance for test.
     */
    private AssociationImpl assoIml = null;

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
        assoIml = new AssociationImpl();
    }

    /**
     * Tear down the test instance.
     */
    public void tearDown() {
        assoIml = null;
    }

    /**
     * Test constructor accuracy. No exception will be thrown.
     */
    public void testConstructorAccuracy() {
        AssociationImpl ctorImpl = new AssociationImpl();

        assertNotNull("The ctorImpl should not be null.", ctorImpl);
        assertNotNull("assoEnd should be initialized.", ctorImpl.getConnections());
    }

    /**
     * Test inheritance of <c>AssociationImpl</c>.
     * <c>AssociationImpl</c> should inherit from <c>GeneralizableElementAbstractImpl</c>.
     */
    public void testAssociationImplAccuracyInheritGeneralizableElementAbstractImpl() {
        assertTrue("AssociationImpl should inherit from GeneralizableElementAbstractImpl.",
                ((Object) new AssociationImpl()) instanceof GeneralizableElementAbstractImpl);
    }

    /**
     * Test inheritance of <c>AssociationImpl</c>.
     * <c>AssociationImpl</c> should inherit from <c>Association</c>.
     */
    public void testAssociationImplAccuracyInheritAssociation() {
        assertTrue("AssociationImpl should inherit from Association.",
                ((Object) new AssociationImpl()) instanceof Association);
    }

    /**
     * Test addConnection with null. IllegalArgumentException should be thrown because of the invalid parameter.
     */
    public void testAddConnectionWithNull() {
        try {
            assoIml.addConnection(null);
            fail("IllegalArgumentException should be thrown because of the invalid parameter.");
        } catch (IllegalArgumentException e) {
            // expected.
        }
    }

    /**
     * Test addConnection accuracy. No exception should be thrown.
     */
    public void testAddConnectionAccuracy() {
        assoIml.addConnection(assoEnd1);

        assertTrue("Add assoEnd failed.", assoIml.containsConnection(assoEnd1));
    }

    /**
     * Test addConnection accuracy for allowing duplicates. No exception should be thrown.
     */
    public void testAddConnectionAccuracyDuplicates() {
        assoIml.addConnection(assoEnd1);
        assoIml.addConnection(assoEnd1);

        assertTrue("Add assoEnds failed.", assoIml.countConnections() == 2);
    }

    /**
     * Test addConnection at index with null.
     * IllegalArgumentException should be thrown because of the invalid parameter.
     */
    public void testAddConnectionAtIndexWithNull() {
        try {
            assoIml.addConnection(0, null);
            fail("IllegalArgumentException should be thrown because of the invalid parameter.");
        } catch (IllegalArgumentException e) {
            // expected.
        }
    }

    /**
     * Test addConnection at index with null.
     * IndexOutOfBoundsException should be thrown because of the invalid parameter.
     */
    public void testAddConnectionAtIndexWithNegative() {
        try {
            assoIml.addConnection(-1, assoEnd1);
            fail("IndexOutOfBoundsException should be thrown because of the invalid parameter.");
        } catch (IndexOutOfBoundsException e) {
            // expected.
        }
    }

    /**
     * Test addConnection at index with null.
     * IndexOutOfBoundsException should be thrown because of the invalid parameter.
     */
    public void testAddConnectionAtIndexWithUpperBounds() {
        try {
            assoIml.addConnection(1, assoEnd1);
            fail("IndexOutOfBoundsException should be thrown because of the invalid parameter.");
        } catch (IndexOutOfBoundsException e) {
            // expected.
        }
    }

    /**
     * Test addConnection at index accuracy.
     * No exception should be thrown.
     */
    public void testAddConnectionAtIndexAccuracy() {
        assoIml.addConnection(0, assoEnd1);

        assertTrue("Add assoEnds failed.", assoIml.containsConnection(assoEnd1));
    }


    /**
     * Test setConnection with null.
     * IllegalArgumentException should be thrown because of the invalid parameter.
     */
    public void testSetConnectionWithNull() {
        try {
            assoIml.setConnection(0, null);
            fail("IllegalArgumentException should be thrown because of the invalid parameter.");
        } catch (IllegalArgumentException e) {
            // expected.
        }
    }

    /**
     * Test setConnection with null.
     * IndexOutOfBoundsException should be thrown because of the invalid parameter.
     */
    public void testSetConnectionWithNegative() {
        try {
            assoIml.setConnection(-1, assoEnd1);
            fail("IndexOutOfBoundsException should be thrown because of the invalid parameter.");
        } catch (IndexOutOfBoundsException e) {
            // expected.
        }
    }

    /**
     * Test setConnection with null.
     * IndexOutOfBoundsException should be thrown because of the invalid parameter.
     */
    public void testSetConnectionWithUpperBounds() {
        try {
            assoIml.setConnection(0, assoEnd1);
            fail("IndexOutOfBoundsException should be thrown because of the invalid parameter.");
        } catch (IndexOutOfBoundsException e) {
            // expected.
        }
    }

    /**
     * Test setConnection accuracy.
     * No exception should be thrown.
     */
    public void testSetConnectionAtIndexAccuracy() {
        assoIml.addConnection(assoEnd1);
        assoIml.setConnection(0, assoEnd2);

        assertFalse("Set assoEnds failed.", assoIml.containsConnection(assoEnd1));
        assertTrue("Set assoEnds failed.", assoIml.containsConnection(assoEnd2));
    }

    /**
     * Test removeConnection with negative.
     * IndexOutOfBoundsException should be thrown.
     */
    public void testRemoveConnectionWithNegative() {
        try {
            assoIml.removeConnection(-1);
            fail("IndexOutOfBoundsException should be thrown because of the invalid parameter.");
        } catch (IndexOutOfBoundsException ex) {
            // expected.
        }
    }

    /**
     * Test removeConnection with upper bound.
     * IndexOutOfBoundsException should be thrown.
     */
    public void testRemoveConnectionWithUpperBound() {
        try {
            assoIml.removeConnection(0);
            fail("IndexOutOfBoundsException should be thrown because of the invalid parameter.");
        } catch (IndexOutOfBoundsException ex) {
            // expected.
        }
    }

    /**
     * Accuracy test removeConnection with index.
     * IndexOutOfBoundsException should be thrown.
     */
    public void testRemoveConnectionWithIndexAccuracy() {
        assoIml.addConnection(assoEnd1);
        assoIml.removeConnection(0);

        assertFalse("Remove connection failed.", assoIml.containsConnection(assoEnd1));
    }

    /**
     * Test removeConnection with null.
     * IllegalArgumentException should be thrown because of the invalid parameter.
     */
    public void testRemoveConnectionWithNull() {
        try {
            assoIml.removeConnection(null);
            fail("IllegalArgumentException should be thrown because of the invalid parameter.");
        } catch (IllegalArgumentException e) {
            // expected.
        }
    }

    /**
     * Test removeConnection accuracy. No exception should be thrown.
     */
    public void testRemoveConnectionAccuracy() {
        assoIml.addConnection(assoEnd1);
        assoIml.addConnection(assoEnd2);
        assoIml.removeConnection(assoEnd1);
        assertTrue("Remove assoEnd failed.", assoIml.countConnections() == 1);
        assertFalse("Remove assoEnd failed.", assoIml.containsConnection(assoEnd1));
    }

    /**
     * Test clearConnections accuracy. No exception should be thrown.
     */
    public void testClearConnectionsAccuracy() {
        assoIml.addConnection(assoEnd1);
        assoIml.addConnection(assoEnd2);
        assoIml.clearConnections();

        assertTrue("Clear assoEnds failed.", assoIml.countConnections() == 0);
    }

    /**
     * Test getConnections accuracy for contained assoEnd. No exception should be thrown.
     */
    public void testGetConnections1() {
        assoIml.addConnection(assoEnd1);
        assoIml.addConnection(assoEnd2);
        List<AssociationEnd> list = assoIml.getConnections();

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
            assoIml.containsConnection(null);
        } catch (IllegalArgumentException e) {
            // expected.
        }
    }

    /**
     * Test containConnection accuracy. No exception should be thrown.
     */
    public void testContainConnectionAccracy() {
        assoIml.addConnection(assoEnd1);

        assertTrue("containsConnection returns a wrong value.", assoIml.containsConnection(assoEnd1));
        assertFalse("containsConnection returns a wrong value.", assoIml.containsConnection(assoEnd2));
    }

    /**
     * Test countConnections accuracy. No exception should be thrown.
     */
    public void testCountConnectionsAccuracy() {
        assertTrue("Count assoEnds error.", assoIml.countConnections() == 0);
        assoIml.addConnection(assoEnd1);
        assoIml.addConnection(assoEnd2);
        assertTrue("Count assoEnds error.", assoIml.countConnections() == 2);
        assoIml.removeConnection(assoEnd1);
        assertTrue("Count assoEnds error.", assoIml.countConnections() == 1);
    }
}
