/*
 * Copyright (c) 2006, TopCoder, Inc. All rights reserved.
 */
package com.topcoder.uml.model.datatypes.failuretests;

import java.util.ArrayList;
import java.util.Collection;

import com.topcoder.uml.model.datatypes.MultiplicityImpl;
import com.topcoder.uml.model.datatypes.MultiplicityRange;
import com.topcoder.uml.model.datatypes.MultiplicityRangeImpl;

import junit.framework.TestCase;

/**
 * Failure test for {@link MultiplicityImpl}.
 * 
 * @author maone
 * @version 1.0
 */
public class MultiplicityImplFailureTest extends TestCase {
    
    /**
     * A <code>MultiplicityImpl</code> instance to test against.
     */
    private MultiplicityImpl multiplicity = null;
    
    /**
     * The only <code>MultiplicityRange</code> instance contained in <code>multiplicity</code>
     * instance.
     */
    private MultiplicityRange range = null;

    /**
     * Set up test case.
     * <p>
     * Initialize the <code>multiplicity</code> instance to test.
     * </p>
     */
    protected void setUp() {
        multiplicity = new MultiplicityImpl();
        
        range = new MultiplicityRangeImpl();
        multiplicity.addRange(range);
    }
    
    /**
     * Test <code>addRange(MultiplicityRange)</code> with null range parameter.
     * <p>
     * IllegalArgumentException should be thrown.
     * </p>
     */
    public void testAddRange_NullRange() {
        try {
            multiplicity.addRange((MultiplicityRange) null);
            fail("Should throw IllegalArgumentException for null range.");
        } catch (IllegalArgumentException e) {
            // pass
        }
    }

    /**
     * Test <code>addRanges(Collection)</code> with null ranges collection.
     * <p>
     * IllegalArgumentException should be thrown.
     * </p>
     */
    public void testAddRanges_NullCollection() {
        try {
            multiplicity.addRanges((Collection<MultiplicityRange>) null);
            fail("Should throw IllegalArgumentException for null collection.");
        } catch (IllegalArgumentException e) {
            // pass
        }
    }

    /**
     * Test <code>addRanges(Collection)</code> with a ranges collection which contains
     * null element.
     * <p>
     * IllegalArgumentException should be thrown.
     * </p>
     */
    public void testAddRanges_NullElement() {
        Collection<MultiplicityRange> ranges = new ArrayList<MultiplicityRange>();
        ranges.add(new MultiplicityRangeImpl());
        ranges.add(null);
        
        try {
            multiplicity.addRanges(ranges);
            fail("Should throw IllegalArgumentException for null element in collection.");
        } catch (IllegalArgumentException e) {
            assertEquals("No range should be added.",
                    1, multiplicity.countRanges());
        }
    }

    /**
     * Test <code>removeRange(MultiplicityRange)</code> with null range parameter.
     * <p>
     * IllegalArgumentException should be thrown.
     * </p>
     */
    public void testRemoveRange_NullRange() {
        try {
            multiplicity.removeRange((MultiplicityRange) null);
            fail("Should throw IllegalArgumentException for null range.");
        } catch (IllegalArgumentException e) {
            // pass
        }
    }

    /**
     * Test <code>removeRanges(Collection)</code> with null ranges collection.
     * <p>
     * IllegalArgumentException should be thrown.
     * </p>
     */
    public void testRemoveRanges_NullCollection() {
        try {
            multiplicity.removeRanges((Collection<MultiplicityRange>) null);
            fail("Should throw IllegalArgumentException for null collection.");
        } catch (IllegalArgumentException e) {
            // pass
        }
    }

    /**
     * Test <code>removeRanges(Collection)</code> with a ranges collection which contains
     * null element.
     * <p>
     * IllegalArgumentException should be thrown.
     * </p>
     */
    public void testRemoveRanges_NullElement() {
        Collection<MultiplicityRange> ranges = new ArrayList<MultiplicityRange>();
        ranges.add(range);
        ranges.add(null);
        
        try {
            multiplicity.removeRanges(ranges);
            fail("Should throw IllegalArgumentException for null element in collection.");
        } catch (IllegalArgumentException e) {
            assertEquals("No range should be added.",
                    1, multiplicity.countRanges());
        }
    }

    
    /**
     * Test <code>containsRange(MultiplicityRange)</code> with null range parameter.
     * <p>
     * IllegalArgumentException should be thrown.
     * </p>
     */
    public void testContainsRange_NullRange() {
        try {
            multiplicity.containsRange((MultiplicityRange) null);
            fail("Should throw IllegalArgumentException for null range.");
        } catch (IllegalArgumentException e) {
            // pass
        }
    }
}
