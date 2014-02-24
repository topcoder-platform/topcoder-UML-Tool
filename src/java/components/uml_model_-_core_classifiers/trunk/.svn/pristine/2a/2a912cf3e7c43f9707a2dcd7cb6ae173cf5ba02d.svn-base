/*
 * Copyright (C) 2006 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.uml.model.core.classifiers;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

import java.util.ArrayList;
import java.util.Collection;


/**
 * <p>
 * Unit test for the <code>Helper</code> class.
 * </p>
 *
 * @author TCSDEVELOPER
 * @version 1.0
 */
public class HelperTest extends TestCase {
    /**
     * <p>
     * Aggregates all tests in this class.
     * </p>
     *
     * @return test suite aggregating all tests.
     */
    public static Test suite() {
        TestSuite suite = new TestSuite(HelperTest.class);

        return suite;
    }

    /**
     * <p>
     * Tests failure of method <code>validateNotNull(Object, String)</code>.
     * Value which is null should lead to exception.
     * IllegalArgumentException is expected.
     * </p>
     */
    public void testValidateNotNullFailure() {
        try {
            Helper.validateNotNull(null, "a");
            fail("IllegalArgumentException should have been thrown.");
        } catch (IllegalArgumentException iae) {
            // ok to land here
        }
    }

    /**
     * <p>
     * Tests accuracy of method <code>validateNotNull(Object, String)</code>.
     * Value not null should be ok.
     * </p>
     */
    public void testValidateNotNullAccuracy() {
        Helper.validateNotNull("a", "a");
    }

    /**
     * <p>
     * Tests failure of method <code>validateCollectionNotNullNotContainNull(Collection, String)</code>.
     * Value which is null should lead to exception.
     * IllegalArgumentException is expected.
     * </p>
     */
    public void testValidateCollectionNotNullNotContainNullFailureNull() {
        try {
            Helper.validateCollectionNotNullNotContainNull(null, "a");
            fail("IllegalArgumentException should have been thrown.");
        } catch (IllegalArgumentException iae) {
            // ok to land here
        }
    }

    /**
     * <p>
     * Tests failure of method <code>validateCollectionNotNullNotContainNull(Collection, String)</code>.
     * Value which contains null should lead to exception.
     * IllegalArgumentException is expected.
     * </p>
     */
    public void testValidateCollectionNotNullNotContainNullFailureEmpty1() {
        try {
            Collection<Object> collection = new ArrayList<Object>();
            collection.add(null);
            Helper.validateCollectionNotNullNotContainNull(collection, "a");
            fail("IllegalArgumentException should have been thrown.");
        } catch (IllegalArgumentException iae) {
            // ok to land here
        }
    }

    /**
     * <p>
     * Tests accuracy of method <code>validateCollectionNotNullNotContainNull(Collection, String)</code>.
     * Value not null not containing null should be ok.
     * </p>
     */
    public void testValidateCollectionNotNullNotContainNullAccuracy1() {
        Helper.validateCollectionNotNullNotContainNull(new ArrayList<Object>(), "a");
    }

    /**
     * <p>
     * Tests accuracy of method <code>validateCollectionNotNullNotContainNull(Collection, String)</code>.
     * Value not null not containing null should be ok.
     * </p>
     */
    public void testValidateCollectionNotNullNotContainNullAccuracy2() {
        Collection<Object> collection = new ArrayList<Object>();
        collection.add("a");
        Helper.validateCollectionNotNullNotContainNull(collection, "a");
    }

    /**
     * <p>
     * Tests accuracy of method <code>removeAllFromCollection(Collection, Collection)</code>.
     * Return value should be correct.
     * Collection after removing should be correct.
     * </p>
     */
    public void testRemoveAllFromCollectionAccuracy1() {
        // create collection
        Collection<Object> collection = new ArrayList<Object>();
        String value1 = "a";
        String value2 = "b";
        collection.add(value1);
        collection.add(value2);

        // create collection with elements to remove
        Collection<Object> toRemove = new ArrayList<Object>();
        toRemove.add(value1);

        // check result
        boolean returnValue = Helper.removeAllFromCollection(collection, toRemove);
        assertTrue("Return value should be correct.", returnValue);
        assertEquals("Collection after removing should be correct.", 1, collection.size());
        assertSame("Collection after removing should be correct.", value2, collection.toArray()[0]);
    }

    /**
     * <p>
     * Tests accuracy of method <code>removeAllFromCollection(Collection, Collection)</code>.
     * Return value should be correct.
     * Collection after removing should be correct.
     * </p>
     */
    public void testRemoveAllFromCollectionAccuracy2() {
        // create collection
        Collection<Object> collection = new ArrayList<Object>();
        String value1 = "a";
        String value2 = "b";
        collection.add(value1);
        collection.add(value2);
        collection.add(value1);
        collection.add(value2);

        // create collection with elements to remove
        Collection<Object> toRemove = new ArrayList<Object>();
        toRemove.add(value1);

        // check result
        boolean returnValue = Helper.removeAllFromCollection(collection, toRemove);
        assertTrue("Return value should be correct.", returnValue);
        assertEquals("Collection after removing should be correct.", 3, collection.size());
        assertSame("Collection after removing should be correct.", value2, collection.toArray()[0]);
        assertSame("Collection after removing should be correct.", value1, collection.toArray()[1]);
        assertSame("Collection after removing should be correct.", value2, collection.toArray()[2]);
    }

    /**
     * <p>
     * Tests accuracy of method <code>removeAllFromCollection(Collection, Collection)</code>.
     * Return value should be correct.
     * Collection after removing should be correct.
     * </p>
     */
    public void testRemoveAllFromCollectionAccuracy3() {
        // create collection
        Collection<Object> collection = new ArrayList<Object>();
        String value1 = "a";
        String value2 = "b";
        collection.add(value1);
        collection.add(value2);
        collection.add(value1);
        collection.add(value2);

        // create collection with elements to remove
        Collection<Object> toRemove = new ArrayList<Object>();
        toRemove.add(value1);
        toRemove.add(value2);

        // check result
        boolean returnValue = Helper.removeAllFromCollection(collection, toRemove);
        assertTrue("Return value should be correct.", returnValue);
        assertEquals("Collection after removing should be correct.", 2, collection.size());
        assertSame("Collection after removing should be correct.", value1, collection.toArray()[0]);
        assertSame("Collection after removing should be correct.", value2, collection.toArray()[1]);
    }

    /**
     * <p>
     * Tests accuracy of method <code>removeAllFromCollection(Collection, Collection)</code>.
     * Return value should be correct.
     * Collection after removing should be correct.
     * </p>
     */
    public void testRemoveAllFromCollectionAccuracy4() {
        // create collection
        Collection<Object> collection = new ArrayList<Object>();
        String value1 = "a";
        String value2 = "b";
        collection.add(value1);
        collection.add(value2);

        // create collection with elements to remove
        Collection<Object> toRemove = new ArrayList<Object>();

        // check result
        boolean returnValue = Helper.removeAllFromCollection(collection, toRemove);
        assertFalse("Return value should be correct.", returnValue);
        assertEquals("Collection after removing should be correct.", 2, collection.size());
        assertSame("Collection after removing should be correct.", value1, collection.toArray()[0]);
        assertSame("Collection after removing should be correct.", value2, collection.toArray()[1]);
    }

    /**
     * <p>
     * Tests accuracy of method <code>removeAllFromCollection(Collection, Collection)</code>.
     * Return value should be correct.
     * Collection after removing should be correct.
     * </p>
     */
    public void testRemoveAllFromCollectionAccuracy5() {
        // create collection
        Collection<Object> collection = new ArrayList<Object>();
        String value1 = "a";
        String value2 = "b";
        collection.add(value1);
        collection.add(value2);
        collection.add(value1);

        // create collection with elements to remove
        Collection<Object> toRemove = new ArrayList<Object>();
        toRemove.add(value2);
        toRemove.add(value1);
        toRemove.add(value2);

        // check result
        boolean returnValue = Helper.removeAllFromCollection(collection, toRemove);
        assertTrue("Return value should be correct.", returnValue);
        assertEquals("Collection after removing should be correct.", 1, collection.size());
        assertSame("Collection after removing should be correct.", value1, collection.toArray()[0]);
    }

    /**
     * <p>
     * Tests failure of method <code>validateIndexRange(int, int, String)</code>.
     * Value which is not in the range should lead to exception.
     * IndexOutOfBoundsException is expected.
     * </p>
     */
    public void testValidateIndexRangeFailure() {
        try {
            Helper.validateIndexRange(-1, 1, "a");
            fail("IndexOutOfBoundsException should have been thrown.");
        } catch (IndexOutOfBoundsException iae) {
            // ok to land here
        }
    }

    /**
     * <p>
     * Tests failure of method <code>validateIndexRange(int, int, String)</code>.
     * Value which is not in the range should lead to exception.
     * IndexOutOfBoundsException is expected.
     * </p>
     */
    public void testValidateIndexRangeFailure2() {
        try {
            Helper.validateIndexRange(2, 1, "a");
            fail("IndexOutOfBoundsException should have been thrown.");
        } catch (IndexOutOfBoundsException iae) {
            // ok to land here
        }
    }

    /**
     * <p>
     * Tests accuracy of method <code>validateIndexRange(int, int, String)</code>.
     * Value which is in the range should be ok.
     * </p>
     */
    public void testValidateIndexRangeAccuracy() {
        Helper.validateIndexRange(0, 1, "a");
    }

    /**
     * <p>
     * Tests accuracy of method <code>validateIndexRange(int, int, String)</code>.
     * Value which is in the range should be ok.
     * </p>
     */
    public void testValidateIndexRangeAccuracy2() {
        Helper.validateIndexRange(1, 1, "a");
    }
}
