/*
 * Copyright (C) 2006 TopCoder Inc., All Rights Reserved.
 */

package com.topcoder.uml.model.datatypes;

import java.util.ArrayList;
import java.util.Collection;

import junit.framework.TestCase;

/**
 * <p>
 * Unit test for <code>Helper</code>.
 * </p>
 *
 * @author Achilles_2005
 * @version 1.0
 */
public class HelperTest extends TestCase {

    /**
     * <p>
     * Tests failure of <code>CheckNotNull(Object, String)</code>.
     * </p>
     * <p>
     * Tests situation when the object to check is null.
     * </p>
     * <p>
     * <code>IllegalArgumentException</code> expected.
     * </p>
     */
    public void testCheckNotNullFailureNull() {
        try {
            Helper.checkNotNull(null, "nullObject");
            fail("IllegalArgumentException should be thrown since value is invalid.");
        } catch (IllegalArgumentException e) {
            // expected
        }
    }

    /**
     * <p>
     * Tests accuracy of <code>CheckNotNull(Object, String)</code>.
     * </p>
     * <p>
     * Tests situation when the object to check is not null.
     * </p>
     * <p>
     * Normal process.
     * </p>
     */
    public void testCheckNotNullAccuracyNonNull() {
        try {
            Helper.checkNotNull(new Object(), "nullObject");
        } catch (IllegalArgumentException e) {
            fail("IllegalArgumentException should not be thrown since value is valid.");
        }
    }

    /**
     * <p>
     * Tests failure of <code>checkCollection(Collection, String)</code>.
     * </p>
     * <p>
     * Tests situation when collection is null.
     * </p>
     * <p>
     * <code>IllegalArumentException</code> exptected.
     * </p>
     */
    public void testCheckCollectionFailureNull() {
        try {
            Helper.checkCollection(null, "nullCollection");
            fail("IllegalArgumentException should be thrown since value is invalid.");
        } catch (IllegalArgumentException e) {
            // exptected
        }
    }

    /**
     * <p>
     * Tests failure of <code>checkCollection(Collection, String)</code>.
     * </p>
     * <p>
     * Tests situation when collection contains null elements.
     * </p>
     * <p>
     * <code>IllegalArumentException</code> exptected.
     * </p>
     */
    public void testCheckCollectionFailureNullElements() {
        try {
            // collection that contains null element
            Collection<Object> collection = new ArrayList<Object>();
            collection.add(null);

            Helper.checkCollection(collection, "collectionWithNullElements");
            fail("IllegalArgumentException should be thrown since value is invalid.");
        } catch (IllegalArgumentException e) {
            // exptected
        }
    }

    /**
     * <p>
     * Tests failure of <code>checkCollection(Collection, String)</code>.
     * </p>
     * <p>
     * Tests situation when collection is empty.
     * </p>
     * <p>
     * Empty collection should be acceptable. Normal process.
     * </p>
     */
    public void testCheckCollectionAccuracyEmpty() {
        try {
            // empty collection
            Collection<Object> collection = new ArrayList<Object>();

            Helper.checkCollection(collection, "emptyCollection");
        } catch (IllegalArgumentException e) {
            fail("IllegalArgumentException should not be thrown since value is valid.");
        }
    }

    /**
     * <p>
     * Tests failure of <code>checkCollection(Collection, String)</code>.
     * </p>
     * <p>
     * Tests situation when collection is valid.
     * </p>
     * <p>
     * Normal process.
     * </p>
     */
    public void testCheckCollectionAccuracyValue() {
        try {
            // valid collection
            Collection<Object> collection = new ArrayList<Object>();
            collection.add(new Object());

            Helper.checkCollection(collection, "collection");
        } catch (IllegalArgumentException e) {
            fail("IllegalArgumentException should not be thrown since value is valid.");
        }
    }

    /**
     * <p>
     * Tests failure of <code>checkNotNegative(int, String)</code>.
     * </p>
     * <p>
     * Tests situation when the integer is negative.
     * </p>
     * <p>
     * <code>IllegalArumentException</code> exptected.
     * </p>
     */
    public void testCheckNotNegativeFailureNegative() {
        try {
            Helper.checkNotNegative(-1, "negative");
            fail("IllegalArgumentException should be thrown since value is invalid.");
        } catch (IllegalArgumentException e) {
            // expected
        }
    }

    /**
     * <p>
     * Tests failure of <code>checkNotNegative(int, String)</code>.
     * </p>
     * <p>
     * Tests situation when the integer is zero.
     * </p>
     * <p>
     * Zero is acceptable. Normal process.
     * </p>
     */
    public void testCheckNotNegativeAccuracyZero() {
        try {
            Helper.checkNotNegative(0, "zero");
        } catch (IllegalArgumentException e) {
            fail("IllegalArgumentException should not be thrown since value is valid.");
        }
    }

    /**
     * <p>
     * Tests failure of <code>checkNotNegative(int, String)</code>.
     * </p>
     * <p>
     * Tests situation when the integer is positive.
     * </p>
     * <p>
     * Normal process.
     * </p>
     */
    public void testCheckNotNegativeAccuracyPositive() {
        try {
            Helper.checkNotNegative(1, "zero");
        } catch (IllegalArgumentException e) {
            fail("IllegalArgumentException should not be thrown since value is valid.");
        }
    }

}
