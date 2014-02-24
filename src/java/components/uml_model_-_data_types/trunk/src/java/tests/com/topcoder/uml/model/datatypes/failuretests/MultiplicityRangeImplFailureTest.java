/*
 * Copyright (c) 2006, TopCoder, Inc. All rights reserved.
 */
package com.topcoder.uml.model.datatypes.failuretests;

import com.topcoder.uml.model.datatypes.MultiplicityRangeImpl;

import junit.framework.TestCase;

/**
 * Failure test for {@link MultiplicityRangeImpl}.
 * 
 * @author maone
 * @version 1.0
 */
public class MultiplicityRangeImplFailureTest extends TestCase {
    /**
     * A <code>MultiplicityRangeImpl</code> instance to test against.
     */
    private MultiplicityRangeImpl range = null;

    /**
     * Set up test cases.
     * <p>
     * Create <code>range</code> instance to test.
     * </p>
     */
    protected void setUp() {
        range = new MultiplicityRangeImpl();
    }

    /**
     * Test <code>setLower(int)</code> with negative value.
     * <p>
     * IllegalArgumentException should be thrown.
     * </p>
     */
    public void testSetLower_Negative() {
        range.setLower(100);

        try {
            range.setLower(-1);
            fail("Should throw IllegalArgumentException for negative value.");
        } catch (IllegalArgumentException e) {
            assertEquals("The lower value shouldn't be changed.",
                    100, range.getLower());
        }
    }

    /**
     * Test <code>setUpper(int)</code> with negative value.
     * <p>
     * IllegalArgumentException should be thrown.
     * </p>
     */
    public void testSetUpper_Negative() {
        range.setUpper(0);

        try {
            range.setUpper(-2);
            fail("Should throw IllegalArgumentException for negative value.");
        } catch (IllegalArgumentException e) {
            assertEquals("The upper value shouldn't be changed.",
                    0, range.getLower());
        }
    }
}
