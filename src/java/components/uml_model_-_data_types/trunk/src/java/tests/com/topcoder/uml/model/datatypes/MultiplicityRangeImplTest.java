/*
 * Copyright (C) 2006 TopCoder Inc., All Rights Reserved.
 */

package com.topcoder.uml.model.datatypes;

import junit.framework.TestCase;

/**
 * <p>
 * Unit test for <code>MultiplicityRangeImpl</code>.
 * </p>
 *
 * @author Achilles_2005
 * @version 1.0
 */
public class MultiplicityRangeImplTest extends TestCase {

    /**
     * <p>
     * Private instance used for test.
     * </p>
     */
    private MultiplicityRangeImpl multiplicityRangeImpl = null;

    /**
     * <p>
     * Sets up test environment, creates object used for test.
     * </p>
     *
     * @throws Exception
     *             exception to JUnit
     */
    @Override
    protected void setUp() throws Exception {
        multiplicityRangeImpl = new MultiplicityRangeImpl();
        super.setUp();
    }

    /**
     * <p>
     * Tears down test environment, disposes object used for test.
     * </p>
     *
     * @throws Exception
     *             exception to JUnit
     */
    @Override
    protected void tearDown() throws Exception {
        multiplicityRangeImpl = null;
        super.tearDown();
    }

    /**
     * <p>
     * Tests inheritance of <code>MultiplicityRangeImpl</code>.
     * </p>
     * <p>
     * <code>MultiplicityRangeImpl</code> should inherit from <code>MultiplicityRange</code>.
     * </p>
     */
    public void testMulitiplicityInheritMultiplicityRange() {
        assertTrue("MultiplicityRangeImpl should inherit from MultiplicityRange",
            multiplicityRangeImpl instanceof MultiplicityRange);
    }

    /**
     * <p>
     * Tests accuracy of <code>MultiplicityRangeImpl()</code>.
     * </p>
     * <p>
     * Object created should not be null.
     * </p>
     * <p>
     * Normal process.
     * </p>
     */
    public void testMultiplicityRangeImplAccuracy() {
        assertNotNull("Object created should not be null.", multiplicityRangeImpl);
    }

    /**
     * <p>
     * Tests accuracy of <code>getLower()</code>.
     * </p>
     * <p>
     * Value should be gotten correctly.
     * </p>
     * <p>
     * Normal process
     * </p>
     */
    public void testGetLowerAccuracy() {
        int lower = 238;
        multiplicityRangeImpl.setLower(lower);
        assertEquals("Value should be gotten correctly.", lower, multiplicityRangeImpl.getLower());
    }

    /**
     * <p>
     * Tests failure of <code>setLower(int)</code>.
     * </p>
     * <p>
     * Tests situation when lower is negative.
     * </p>
     * <p>
     * <code>IllegalArgumentException</code> expected.
     * </p>
     */
    public void testSetLowerFailureNegative() {
        try {
            multiplicityRangeImpl.setLower(-1);
            fail("IllegalArgumentException should be thrown since value is invalid.");
        } catch (IllegalArgumentException e) {
            // expected
        }
    }

    /**
     * <p>
     * Tests failure of <code>setLower(int)</code>.
     * </p>
     * <p>
     * Tests situation when lower is zero.
     * </p>
     * <p>
     * Zero value is acceptable. Normal process.
     * </p>
     */
    public void testSetLowerAccuracyZero() {
        try {
            multiplicityRangeImpl.setLower(0);
        } catch (IllegalArgumentException e) {
            fail("IllegalArgumentException should not be thrown since value is valid.");
        }
    }

    /**
     * <p>
     * Tests failure of <code>setLower(int)</code>.
     * </p>
     * <p>
     * Tests situation when lower is positive.
     * </p>
     * <p>
     * Positive value is acceptable. Normal process.
     * </p>
     */
    public void testSetLowerAccuracyPositive() {
        try {
            multiplicityRangeImpl.setLower(2);
        } catch (IllegalArgumentException e) {
            fail("IllegalArgumentException should not be thrown since value is valid.");
        }
    }

    /**
     * <p>
     * Tests accuracy of <code>getUpper()</code>.
     * </p>
     * <p>
     * Value should be gotten correctly.
     * </p>
     * <p>
     * Normal process
     * </p>
     */
    public void testGetUpperAccuracy() {
        int upper = 238;
        multiplicityRangeImpl.setUpper(upper);
        assertEquals("Value should be gotten correctly.", upper, multiplicityRangeImpl.getUpper());
    }

    /**
     * <p>
     * Tests failure of <code>setUpper(int)</code>.
     * </p>
     * <p>
     * Tests situation when lower is negative.
     * </p>
     * <p>
     * <code>IllegalArgumentException</code> expected.
     * </p>
     */
    public void testSetUpperFailureNegative() {
        try {
            multiplicityRangeImpl.setUpper(-2);
            fail("IllegalArgumentException should be thrown since value is invalid.");
        } catch (IllegalArgumentException e) {
            // expected
        }
    }

    /**
     * <p>
     * Tests failure of <code>setUpper(int)</code>.
     * </p>
     * <p>
     * Tests situation when lower is zero.
     * </p>
     * <p>
     * Zero value is acceptable. Normal process.
     * </p>
     */
    public void testSetUpperAccuracyZero() {
        try {
            multiplicityRangeImpl.setUpper(0);
        } catch (IllegalArgumentException e) {
            fail("IllegalArgumentException should not be thrown since value is valid.");
        }
    }

    /**
     * <p>
     * Tests failure of <code>setUpper(int)</code>.
     * </p>
     * <p>
     * Tests situation when lower is positive.
     * </p>
     * <p>
     * Positive value is acceptable. Normal process.
     * </p>
     */
    public void testSetUpperAccuracyPositive() {
        try {
            multiplicityRangeImpl.setUpper(2);
        } catch (IllegalArgumentException e) {
            fail("IllegalArgumentException should not be thrown since value is valid.");
        }
    }

    /**
     * <p>
     * Tests accuracy of <code>setLower(int)</code> and <code>setUpper(int)</code>.
     * </p>
     * <p>
     * Tests situation when upper is less than lower.
     * </p>
     * <p>
     * The situation is acceptable. <code>IllegalArgumentException</code> is not expected.
     * </p>
     */
    public void testSetUpperSetLowerAccuracy() {
        try {
            multiplicityRangeImpl.setLower(100);
            multiplicityRangeImpl.setUpper(10);
        } catch (IllegalArgumentException e) {
            fail("IllegalArgumentException should not be thrown since value is valid.");
        }
    }

    /**
     * <p>
     * Tests accuracy of <code>getMultiplicityAccuracy()</code>.
     * </p>
     * <p>
     * Value should be gotten correctly.
     * </p>
     * <p>
     * Normal process.
     * </p>
     */
    public void testGetMultiplicity() {
        Multiplicity multiplicity = new MultiplicityImpl();
        multiplicityRangeImpl.setMultiplicity(multiplicity);
        assertEquals("Value should be gotten correctly.", multiplicity, multiplicityRangeImpl
            .getMultiplicity());
    }

    /**
     * <p>
     * Tests accuracy of <code>setMultiplicityAccuracy(Multiplicity)</code>.
     * </p>
     * <p>
     * Tests situation when multiplicity is null.
     * </p>
     * <p>
     * Null value is acceptable. Normal process.
     * </p>
     */
    public void testSetMultiplicityAccuracyNull() {
        try {
            Multiplicity multiplicity = null;
            multiplicityRangeImpl.setMultiplicity(multiplicity);
            assertNull(multiplicityRangeImpl.getMultiplicity());
        } catch (IllegalArgumentException e) {
            fail("IllegalArgumentException should not be thrown since value is valid.");
        }
    }

    /**
     * <p>
     * Tests accuracy of <code>setMultiplicityAccuracy(Multiplicity)</code>.
     * </p>
     * <p>
     * Tests situation when multiplicity is not null.
     * </p>
     * <p>
     * Null value is acceptable. Normal process.
     * </p>
     */
    public void testSetMultiplicityAccuracyValue() {
        try {
            Multiplicity multiplicity = new MultiplicityImpl();
            multiplicityRangeImpl.setMultiplicity(multiplicity);
            assertEquals("Value should be set correctly.", multiplicity, multiplicityRangeImpl
                .getMultiplicity());
        } catch (IllegalArgumentException e) {
            fail("IllegalArgumentException should not be thrown since value is valid.");
        }
    }

}
