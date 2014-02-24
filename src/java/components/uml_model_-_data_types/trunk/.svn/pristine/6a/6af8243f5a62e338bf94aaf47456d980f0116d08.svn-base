/*
 * Copyright (C) 2006 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.uml.model.datatypes.accuracytests;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Hashtable;

import junit.framework.TestCase;

import com.topcoder.uml.model.datatypes.Multiplicity;
import com.topcoder.uml.model.datatypes.MultiplicityImpl;
import com.topcoder.uml.model.datatypes.MultiplicityRange;
import com.topcoder.uml.model.datatypes.MultiplicityRangeImpl;

/**
 * Accuracy test fixture for <code>MultiplicityImpl</code> class.
 *
 * @author Thinfox
 * @version 1.0
 */
public class MultiplicityImplAccuracyTests extends TestCase {
    /**
     * The default <code>MultiplicityImpl</code> instance on which to perform tests.
     */
    private MultiplicityImpl multiplicity = null;

    /**
     * The MultiplicityRange instance for test.
     */
    private MultiplicityRange range1 = null;

    /**
     * The MultiplicityRange instance for test.
     */
    private MultiplicityRange range2 = null;

    /**
     * The MultiplicityRange instance for test.
     */
    private Collection<MultiplicityRange> ranges = null;

    /**
     * Initializes the test instance.
     */
    public void setUp() {
        multiplicity = new MultiplicityImpl();

        range1 = new MultiplicityRangeImpl();
        range2 = new MultiplicityRangeImpl();

        ranges = new ArrayList<MultiplicityRange>();
        ranges.add(range1);
        ranges.add(range1);
        ranges.add(range2);
    }

    /**
     * Tests the default constructor.
     */
    public void testConstructor() {
        assertNotNull("The multiplicity should not be null.", multiplicity);
        assertTrue("ranges should be initialized as empty.", multiplicity.getRanges().isEmpty());
    }

    /**
     * Tests <c>MultiplicityImpl</c> inherits from <c>Multiplicity</c>.
     */
    public void testInheritMultiplicity() {
        assertTrue("MultiplicityImpl should inherit from Multiplicity.",
            multiplicity instanceof Multiplicity);
    }

    /**
     * Tests <code>addRange</code> method.
     */
    public void testAddRange() {
        multiplicity.addRange(range1);
        assertEquals("Failed to add range.", 1, multiplicity.countRanges());
        assertTrue("Should contain range1.", multiplicity.containsRange(range1));

        multiplicity.addRange(range2);
        assertEquals("Incorrect count of ranges.", 2, multiplicity.countRanges());
        assertTrue("Should contain range2.", multiplicity.containsRange(range2));

        multiplicity.addRange(range1);
        assertEquals("Incorrect count of ranges.", 3, multiplicity.countRanges());
    }

    /**
     * Tests <code>addRanges</code> method.
     */
    public void testAddRanges() {
        multiplicity.addRange(range2);

        multiplicity.addRanges(ranges);
        assertEquals("Incorrect count of ranges.", 4, multiplicity.countRanges());
        assertTrue("Should contain range1.", multiplicity.containsRange(range1));

        multiplicity.addRanges(ranges);
        assertEquals("Incorrect count of ranges.", 7, multiplicity.countRanges());
    }

    /**
     * Tests <code>addRanges</code> method with a collection that does not support null elements.
     */
    public void testAddRangesNullElementsUnsupported() {
        Hashtable<MultiplicityRange, Object> table = new Hashtable<MultiplicityRange, Object>();
        table.put(range1, new Object());
        table.put(range2, new Object());
        ranges = table.keySet();

        multiplicity.addRange(range2);

        multiplicity.addRanges(ranges);
        assertEquals("Incorrect count of ranges.", 3, multiplicity.countRanges());
        assertTrue("Should contain range1.", multiplicity.containsRange(range1));

        multiplicity.addRanges(ranges);
        assertEquals("Incorrect count of ranges.", 5, multiplicity.countRanges());
    }

    /**
     * Tests <code>addRanges</code> method with an empty collection.
     */
    public void testAddRangesEmpty() {
        multiplicity.addRanges(new HashSet<MultiplicityRange>());
        assertEquals("Incorrect count of ranges.", 0, multiplicity.countRanges());
    }

    /**
     * Tests <code>removeRanges</code> method.
     */
    public void testRemoveRanges() {
        multiplicity.addRange(range1);
        multiplicity.addRange(range2);
        multiplicity.addRange(range1);
        multiplicity.addRange(range2);

        assertTrue("Remove ranges should return true.", multiplicity.removeRanges(ranges));

        assertEquals("Incorrect count of ranges.", 1, multiplicity.countRanges());
        assertFalse("Should not contain range1.", multiplicity.containsRange(range1));
        assertTrue("Should contain range2.", multiplicity.containsRange(range2));

        assertTrue("Remove ranges should return true.", multiplicity.removeRanges(ranges));
        assertEquals("Incorrect count of ranges.", 0, multiplicity.countRanges());

        assertFalse("Remove ranges should return false.", multiplicity.removeRanges(ranges));
        assertEquals("Incorrect count of ranges.", 0, multiplicity.countRanges());
    }

    /**
     * Tests <code>removeRanges</code> method with an empty collection.
     */
    public void testRemoveRangesEmpty() {
        assertFalse("Remove ranges should return false.", multiplicity
            .removeRanges(new HashSet<MultiplicityRange>()));
    }

    /**
     * Tests <code>removeRanges</code> method with a collection that does not support null
     * elements.
     */
    public void testRemoveRangesNullElementsUnsupported() {
        Hashtable<MultiplicityRange, Object> table = new Hashtable<MultiplicityRange, Object>();
        table.put(range1, new Object());
        table.put(range2, new Object());
        ranges = table.keySet();

        multiplicity.addRange(range1);
        multiplicity.addRange(range2);
        multiplicity.addRange(range2);

        assertTrue("Remove ranges should return true.", multiplicity.removeRanges(ranges));

        assertEquals("Incorrect count of ranges.", 1, multiplicity.countRanges());
        assertFalse("Should not contain range1.", multiplicity.containsRange(range1));
        assertTrue("Should contain range2.", multiplicity.containsRange(range2));

        assertTrue("Remove ranges should return true.", multiplicity.removeRanges(ranges));
        assertEquals("Incorrect count of ranges.", 0, multiplicity.countRanges());

        assertFalse("Remove ranges should return false.", multiplicity.removeRanges(ranges));
        assertEquals("Incorrect count of ranges.", 0, multiplicity.countRanges());
    }

    /**
     * Tests <code>clearRanges</code> method.
     */
    public void testClearRanges() {
        multiplicity.addRange(range1);
        multiplicity.addRange(range2);
        multiplicity.clearRanges();

        assertEquals("Incorrect count of ranges.", 0, multiplicity.countRanges());
    }

    /**
     * Tests <code>getRanges</code> method.
     */
    public void testGetRanges() {
        multiplicity.addRange(range1);
        multiplicity.addRange(range2);
        multiplicity.addRange(range1);

        Collection<MultiplicityRange> result = multiplicity.getRanges();
        assertEquals("Incorrect count of ranges.", 3, result.size());

        for (MultiplicityRange range : ranges) {
            assertTrue("Ranges should be retrieved correctly.", result.remove(range));
        }

        assertEquals("A shallow copy should be created.", 3, multiplicity.countRanges());
    }

    /**
     * Tests <code>containsRange</code> method.
     */
    public void testContainRange() {
        multiplicity.addRange(range1);

        assertTrue("Should contain range1.", multiplicity.containsRange(range1));
        assertFalse("Should not contain range2.", multiplicity.containsRange(range2));
    }

    /**
     * Tests <code>countRanges</code> method.
     */
    public void testCountRanges() {
        assertEquals("Incorrect count of ranges.", 0, multiplicity.countRanges());

        multiplicity.addRange(range1);
        assertEquals("Incorrect count of ranges.", 1, multiplicity.countRanges());

        multiplicity.addRange(range2);
        assertEquals("Incorrect count of ranges.", 2, multiplicity.countRanges());

        multiplicity.addRange(range1);
        assertEquals("Incorrect count of ranges.", 3, multiplicity.countRanges());
    }
}
