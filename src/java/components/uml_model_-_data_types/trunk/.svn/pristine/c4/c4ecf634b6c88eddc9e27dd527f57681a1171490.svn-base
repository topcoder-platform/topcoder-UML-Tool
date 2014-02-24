/*
 * Copyright (C) 2006 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.uml.model.datatypes.stresstests;

import com.topcoder.uml.model.datatypes.Multiplicity;
import com.topcoder.uml.model.datatypes.MultiplicityImpl;
import com.topcoder.uml.model.datatypes.MultiplicityRange;
import com.topcoder.uml.model.datatypes.MultiplicityRangeImpl;

import junit.framework.TestCase;

import java.util.ArrayList;
import java.util.Collection;

/**
 * <p>
 * Stress tests for MultiplicityImpl.
 * </p>
 *
 * @author qiucx0161
 * @version 1.0
 */
public class MultiplicityImplStressTest extends TestCase {
    /** The number of times each method will be run. */
    private static final int RUN_TIMES = 1000;

    /**
     * The Multiplicity instance used for testing.
     */
    private Multiplicity mp;

    /**
     * the MultiplicityRange instance used for testing.
     */
    private MultiplicityRange range;

    /**
     * Initialization for all tests here.
     * @throws Exception to Junit.
     */
    protected void setUp() throws Exception {
        mp = new MultiplicityImpl();
        range = new MultiplicityRangeImpl();
    }

    /**
     * <p>Clear the test environment.</p>
     *
     * @throws Exception to JUnit
     */
    protected void tearDown() throws Exception {
    }

    /**
     * <p>Stress test for operations to range.</p>
     *
     */
    public void testRange() {
        Collection<MultiplicityRange> addedRanges = new ArrayList<MultiplicityRange>();

        // add the range.
        long start = System.currentTimeMillis();

        for (int i = 0; i < RUN_TIMES; i++) {
            MultiplicityRange ran = new MultiplicityRangeImpl();
            ran.setLower(i + 1);
            ran.setMultiplicity(mp);
            ran.setUpper(i + 1);
            mp.addRange(ran);
            addedRanges.add(ran);
        }

        mp.addRange(range);

        long end = System.currentTimeMillis();
        System.out.println("Adding " + RUN_TIMES + " range costs " +
            (end - start) + "ms");
        assertEquals("adding range is wrong.", RUN_TIMES + 1, mp.countRanges());

        // check the range via containsRange method.
        assertTrue(mp.containsRange(range));

        // remove the range.
        long start2 = System.currentTimeMillis();

        for (MultiplicityRange mr : addedRanges) {
            mp.removeRange(mr);
        }

        long end2 = System.currentTimeMillis();
        System.out.println("Removing " + RUN_TIMES + " range costs " +
            (end2 - start2) + "ms");

        assertEquals("removing range is wrong.", 1, mp.getRanges().size());
        assertTrue(mp.containsRange(range));

        // clear the ranges.
        mp.clearRanges();

        assertFalse(mp.containsRange(range));
        assertEquals("clearing range is wrong.", 0, mp.getRanges().size());
    }

    /**
     * <p>Stress test for operations to ranges.</p>
     *
     */
    public void testRanges() {
        Collection<MultiplicityRange> ranges = new ArrayList<MultiplicityRange>();

        for (int i = 0; i < RUN_TIMES; i++) {
            MultiplicityRange ran = new MultiplicityRangeImpl();
            ran.setLower(i + 1);
            ran.setMultiplicity(mp);
            ran.setUpper(i + 1);
            ranges.add(ran);
        }

        // add the ranges.
        long start = System.currentTimeMillis();
        mp.addRanges(ranges);

        long end = System.currentTimeMillis();
        System.out.println("Adding " + RUN_TIMES + " ranges costs " +
            (end - start) + "ms");

        assertEquals("adding ranges is wrong.", RUN_TIMES, mp.countRanges());

        // remove the ranges.
        long start2 = System.currentTimeMillis();
        mp.removeRanges(ranges);

        long end2 = System.currentTimeMillis();
        System.out.println("Removing " + RUN_TIMES + " ranges costs " +
            (end2 - start2) + "ms");

        assertEquals("removing ranges is wrong.", 0, mp.countRanges());
    }
}
