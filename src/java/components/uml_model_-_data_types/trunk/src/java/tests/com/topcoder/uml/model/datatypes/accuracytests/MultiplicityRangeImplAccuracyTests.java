/*
 * Copyright (C) 2006 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.uml.model.datatypes.accuracytests;

import junit.framework.TestCase;

import com.topcoder.uml.model.datatypes.Multiplicity;
import com.topcoder.uml.model.datatypes.MultiplicityImpl;
import com.topcoder.uml.model.datatypes.MultiplicityRange;
import com.topcoder.uml.model.datatypes.MultiplicityRangeImpl;

/**
 * Accuracy test fixture for <code>MultiplicityRangeImpl</code> class.
 *
 * @author Thinfox
 * @version 1.0
 */
public class MultiplicityRangeImplAccuracyTests extends TestCase {
    /**
     * The default <code>MultiplicityRangeImpl</code> instance on which to perform tests.
     */
    private MultiplicityRangeImpl range = null;

    /**
     * Initializes the test instance.
     */
    public void setUp() {
        range = new MultiplicityRangeImpl();
    }

    /**
     * Tests the default constructor.
     */
    public void testConstructor() {
        assertNotNull("The instance should not be null.", range);
    }

    /**
     * Tests <code>MultiplicityRangeImpl</code> inherits from <code>MultiplicityRange</code>.
     */
    public void testInheritMultiplicityRange() {
        assertTrue("MultiplicityRangeImpl should inherit from MultiplicityRange.",
            range instanceof MultiplicityRange);
    }

    /**
     * Tests <code>getLower</code>. method.
     */
    public void testGetLower() {
        int lower = 0;
        range.setLower(lower);
        assertEquals("Value should be retrieved correctly.", lower, range.getLower());
    }

    /**
     * Tests <code>setLower</code> method.
     */
    public void testSetLower() {
        int lower = 0;
        range.setLower(lower);
        assertEquals("Value should be propagated correctly.", lower, range.getLower());
    }

    /**
     * Tests <code>getUpper</code> method.
     */
    public void testGetUpper() {
        int upper = 0;
        range.setUpper(upper);
        assertEquals("Value should be retrieved correctly.", upper, range.getUpper());
    }

    /**
     * Tests <code>setUpper</code> method.
     */
    public void testSetUpper() {
        int upper = 0;
        range.setUpper(upper);
        assertEquals("Value should be propagated correctly.", upper, range.getUpper());
    }

    /**
     * Tests <code>getMultiplicity</code> method.
     */
    public void testGetMultiplicity() {
        Multiplicity obj = new MultiplicityImpl();
        range.setMultiplicity(obj);
        assertEquals("Value should be retrieved correctly.", obj, range.getMultiplicity());
    }

    /**
     * Tests <code>setMultiplicity</code> method.
     */
    public void testSetMultiplicity() {
        Multiplicity obj = new MultiplicityImpl();
        range.setMultiplicity(obj);
        assertEquals("Value should be propagated correctly.", obj, range.getMultiplicity());
    }
}
