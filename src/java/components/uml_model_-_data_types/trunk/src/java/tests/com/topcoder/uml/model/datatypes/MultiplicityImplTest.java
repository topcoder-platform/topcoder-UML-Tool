/*
 * Copyright (C) 2006 TopCoder Inc., All Rights Reserved.
 */

package com.topcoder.uml.model.datatypes;

import java.util.ArrayList;
import java.util.Collection;

import junit.framework.TestCase;

/**
 * <p>
 * Unit test for <code>MultiplicityImpl</code>.
 * </p>
 *
 * @author Achilles_2005
 * @version 1.0
 */
public class MultiplicityImplTest extends TestCase {

    /**
     * <p>
     * Private instance used for test.
     * </p>
     */
    private MultiplicityImpl multiplicityImpl = null;

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
        multiplicityImpl = new MultiplicityImpl();
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
        multiplicityImpl = null;
        super.tearDown();
    }

    /**
     * <p>
     * Tests inheritance of <code>MultiplicityImpl</code>.
     * </p>
     * <p>
     * <code>MultiplicityImpl</code> should implements <code>Multiplicity</code>.
     * </p>
     */
    public void testMultiplicityImplAccuracyInheritMultiplicity() {
        assertTrue("MultiplicityImpl should implements Multiplicity", MultiplicityImpl.class
            .getInterfaces()[0].equals(Multiplicity.class));
    }

    /**
     * <p>
     * Tests accuracy of <code>MultiplicityImpl()</code>.
     * </p>
     */
    public void testMultiplicityImplAccuracy() {
        assertNotNull("Value should not be null.", multiplicityImpl);
    }

    /**
     * <p>
     * Tests failure of <code>addRange(MultiplicityRange)</code>.
     * </p>
     * <p>
     * Tests situation when range is null.
     * </p>
     * <p>
     * <code>IllegalArgumentException</code> expected.
     * </p>
     */
    public void testAddRangeFailureNull() {
        try {
            multiplicityImpl.addRange(null);
            fail("IllegalArgumentException should be thrown since value is invalid.");
        } catch (IllegalArgumentException e) {
            // expected
        }
    }

    /**
     * <p>
     * Tests failure of <code>addRange(MultiplicityRange)</code>.
     * </p>
     * <p>
     * Tests situation when range is valid.
     * </p>
     * <p>
     * Normal process.
     * </p>
     */
    public void testAddRangeAccuracy() {
        try {
            // add range
            MultiplicityRange range = new MultiplicityRangeImpl();
            multiplicityImpl.addRange(range);

            // validation
            Collection<MultiplicityRange> ranges = multiplicityImpl.getRanges();
            assertNotNull("Value should be added correctly.", ranges);
            assertEquals("Value should be added correctly.", 1, ranges.size());
            assertTrue("Value should be added correctly.", ranges.contains(range));
        } catch (IllegalArgumentException e) {
            fail("IllegalArgumentException should not be thrown since value is valid.");
        }
    }

    /**
     * <p>
     * Tests failure of <code>addRange(MultiplicityRange)</code>.
     * </p>
     * <p>
     * Tests situation when range is valid.
     * </p>
     * <p>
     * Duplicate range is acceptable. Normal process.
     * </p>
     */
    public void testAddRangeAccuracyDuplicate() {
        try {
            // add range
            MultiplicityRange range = new MultiplicityRangeImpl();
            multiplicityImpl.addRange(range);
            multiplicityImpl.addRange(range);

            // validation
            Collection<MultiplicityRange> ranges = multiplicityImpl.getRanges();
            assertNotNull("Value should be added correctly.", ranges);
            assertEquals("Value should be added correctly.", 2, ranges.size());
            // check ranges
            for (MultiplicityRange rangeObj : ranges) {
                assertSame("Value should be added correctly.", rangeObj, range);
            }
        } catch (IllegalArgumentException e) {
            fail("IllegalArgumentException should not be thrown since value is valid.");
        }
    }

    /**
     * <p>
     * Tests failure of <code>addRanges(Collection&lt;MultiplicityRange&gt;)</code>.
     * </p>
     * <p>
     * Tests situation when collection is null.
     * </p>
     * <p>
     * <code>IllegalArgumentException</code> expected.
     * </p>
     */
    public void testAddRangesFailureNull() {
        try {
            // null collection
            Collection<MultiplicityRange> ranges = null;
            // add
            multiplicityImpl.addRanges(ranges);
            fail("IllegalArgumentException should be thrown since value is invalid.");
        } catch (IllegalArgumentException e) {
            // expected
        }
    }

    /**
     * <p>
     * Tests failure of <code>addRanges(Collection&lt;MultiplicityRange&gt;)</code>.
     * </p>
     * <p>
     * Tests situation when collection contains null elements.
     * </p>
     * <p>
     * <code>IllegalArgumentException</code> expected.
     * </p>
     */
    public void testAddRangesFailureCollectionWithNullElements() {
        try {
            // collection with null elements
            Collection<MultiplicityRange> ranges = new ArrayList<MultiplicityRange>();
            ranges.add(null);
            // add
            multiplicityImpl.addRanges(ranges);
            fail("IllegalArgumentException should be thrown since value is invalid.");
        } catch (IllegalArgumentException e) {
            // expected
        }
    }

    /**
     * <p>
     * Tests accuracy of <code>addRanges(Collection&lt;MultiplicityRange&gt;)</code>.
     * </p>
     * <p>
     * Tests situation when collection is empty.
     * </p>
     * <p>
     * Empty collection is acceptable. Normal process.
     * </p>
     */
    public void testAddRangesAccuracyEmpty() {
        try {
            // empty collection
            Collection<MultiplicityRange> ranges = new ArrayList<MultiplicityRange>();
            // add
            multiplicityImpl.addRanges(ranges);
            // validation
            Collection<MultiplicityRange> retRanges = multiplicityImpl.getRanges();
            assertNotNull("Value should be added correctly.", retRanges);
            assertTrue("Value should be added correctly.", retRanges.isEmpty());
        } catch (IllegalArgumentException e) {
            fail("IllegalArgumentException should be not thrown since value is valid.");
        }
    }

    /**
     * <p>
     * Tests accuracy of <code>addRanges(Collection&lt;MultiplicityRange&gt;)</code>.
     * </p>
     * <p>
     * Tests situation when collection is valid.
     * </p>
     * <p>
     * Normal process.
     * </p>
     */
    public void testAddRangesAccuracyValue() {
        try {
            // valid collection
            Collection<MultiplicityRange> ranges = new ArrayList<MultiplicityRange>();
            ranges.add(new MultiplicityRangeImpl());
            // add
            multiplicityImpl.addRanges(ranges);
            // validation
            Collection<MultiplicityRange> retRanges = multiplicityImpl.getRanges();
            assertNotNull("Value should be added correctly.", retRanges);
            assertEquals("Value should be added correctly.", ranges.size(), retRanges.size());
            // the collections contains the same elements
            assertTrue("Value should be added correctly.", retRanges.containsAll(ranges));
            assertTrue("Value should be added correctly.", ranges.containsAll(retRanges));
        } catch (IllegalArgumentException e) {
            fail("IllegalArgumentException should be not thrown since value is valid.");
        }
    }

    /**
     * <p>
     * Tests failure of <code>removeRange(MultiplicityRange)</code>.
     * </p>
     * <p>
     * Tests situation when range is null.
     * </p>
     * <p>
     * <code>IllegalArgumentException</code> expected.
     * </p>
     */
    public void testRemoveRangeFailureNull() {
        try {
            multiplicityImpl.removeRange(null);
            fail("IllegalArgumentException should be thrown since value is invalid.");
        } catch (IllegalArgumentException e) {
            // expected
        }
    }

    /**
     * <p>
     * Tests failure of <code>removeRange(MultiplicityRange)</code>.
     * </p>
     * <p>
     * Tests situation when range does not exist.
     * </p>
     * <p>
     * Normal process.
     * </p>
     */
    public void testRemoveRangeAccuracyRangeNotExist() {
        try {
            MultiplicityRange range = new MultiplicityRangeImpl();
            boolean changed = multiplicityImpl.removeRange(range);
            // validation
            assertFalse("Value should be removed correctly.", changed);
        } catch (IllegalArgumentException e) {
            fail("IllegalArgumentException should be thrown since value is invalid.");
        }
    }

    /**
     * <p>
     * Tests failure of <code>removeRange(MultiplicityRange)</code>.
     * </p>
     * <p>
     * Tests situation when range exists.
     * </p>
     * <p>
     * Normal process.
     * </p>
     */
    public void testRemoveRangeAccuracyRangeExist() {
        try {
            MultiplicityRange range = new MultiplicityRangeImpl();
            // first add it
            multiplicityImpl.addRange(range);
            // then remove it
            boolean changed = multiplicityImpl.removeRange(range);
            // validation
            assertTrue("Value should be removed correctly.", changed);
            // validate
            Collection<MultiplicityRange> ranges = multiplicityImpl.getRanges();
            assertNotNull("Value should be removed correctly.", ranges);
            assertTrue("Value should be removed correctly.", ranges.isEmpty());
        } catch (IllegalArgumentException e) {
            fail("IllegalArgumentException should be thrown since value is invalid.");
        }
    }

    /**
     * <p>
     * Tests failure of <code>removeRange(MultiplicityRange)</code>.
     * </p>
     * <p>
     * Tests situation when duplicate range exists.
     * </p>
     * <p>
     * Normal process.
     * </p>
     */
    public void testRemoveRangeAccuracyDuplicateRange() {
        try {
            MultiplicityRange range = new MultiplicityRangeImpl();
            // first add it
            multiplicityImpl.addRange(range);
            multiplicityImpl.addRange(range);
            // then remove it
            boolean changed = multiplicityImpl.removeRange(range);
            // validation
            assertTrue("Value should be removed correctly.", changed);
            // validate
            Collection<MultiplicityRange> ranges = multiplicityImpl.getRanges();
            assertNotNull("Value should be removed correctly.", ranges);
            assertEquals("Value should be removed correctly.", 1, ranges.size());
            assertTrue("Value should be removed correctly.", ranges.contains(range));
        } catch (IllegalArgumentException e) {
            fail("IllegalArgumentException should be thrown since value is invalid.");
        }
    }

    /**
     * <p>
     * Tests failure of <code>removeRanges(Collection&lt;MultiplicityRange&gt;)</code>.
     * </p>
     * <p>
     * Tests situation when collection is null.
     * </p>
     * <p>
     * <code>IllegalArgumentException</code> expected.
     * </p>
     */
    public void testRemoveRangesFailureNull() {
        try {
            // null collection
            Collection<MultiplicityRange> ranges = null;
            // remove
            multiplicityImpl.removeRanges(ranges);
            fail("IllegalArgumentException should be thrown since value is invalid.");
        } catch (IllegalArgumentException e) {
            // expected
        }
    }

    /**
     * <p>
     * Tests failure of <code>removeRanges(Collection&lt;MultiplicityRange&gt;)</code>.
     * </p>
     * <p>
     * Tests situation when collection contains null elements.
     * </p>
     * <p>
     * <code>IllegalArgumentException</code> expected.
     * </p>
     */
    public void testRemoveRangesFailureCollectionWithNullElements() {
        try {
            // collection with null elements
            Collection<MultiplicityRange> ranges = new ArrayList<MultiplicityRange>();
            ranges.add(null);
            // remove
            multiplicityImpl.removeRanges(ranges);
            fail("IllegalArgumentException should be thrown since value is invalid.");
        } catch (IllegalArgumentException e) {
            // expected
        }
    }

    /**
     * <p>
     * Tests accuracy of <code>removeRanges(Collection&lt;MultiplicityRange&gt;)</code>.
     * </p>
     * <p>
     * Tests situation when collection is empty.
     * </p>
     * <p>
     * Empty collection is acceptable. Normal process.
     * </p>
     */
    public void testRemoveRangesAccuracyEmpty() {
        try {
            // empty collection
            Collection<MultiplicityRange> ranges = new ArrayList<MultiplicityRange>();
            // remove
            boolean changed = multiplicityImpl.removeRanges(ranges);
            // validation
            assertFalse("Value should be removed correctly.", changed);

            Collection<MultiplicityRange> retRanges = multiplicityImpl.getRanges();
            assertNotNull("Value should be removed correctly.", retRanges);
            assertTrue("Value should be removed correctly.", retRanges.isEmpty());
        } catch (IllegalArgumentException e) {
            fail("IllegalArgumentException should be not thrown since value is valid.");
        }
    }

    /**
     * <p>
     * Tests accuracy of <code>removeRanges(Collection&lt;MultiplicityRange&gt;)</code>.
     * </p>
     * <p>
     * Tests situation when collection is valid.
     * </p>
     * <p>
     * Normal process.
     * </p>
     */
    public void testRemoveRangesAccuracyValue() {
        try {
            // valid ranges
            MultiplicityRange range1 = new MultiplicityRangeImpl();
            MultiplicityRange range2 = new MultiplicityRangeImpl();
            MultiplicityRange range3 = new MultiplicityRangeImpl();
            // ranges to add
            Collection<MultiplicityRange> ranges = new ArrayList<MultiplicityRange>();
            ranges.add(range1);
            ranges.add(range3);
            // add to multiplicity
            multiplicityImpl.addRange(range1);
            multiplicityImpl.addRange(range2);
            // remove
            multiplicityImpl.removeRanges(ranges);
            // validation
            Collection<MultiplicityRange> retRanges = multiplicityImpl.getRanges();
            assertNotNull("Value should be added correctly.", retRanges);
            // all elements should be removed correctly
            for (MultiplicityRange range : ranges) {
                assertFalse("Value should be added correctly.", retRanges.contains(range));
            }
        } catch (IllegalArgumentException e) {
            fail("IllegalArgumentException should be not thrown since value is valid.");
        }
    }

    /**
     * <p>
     * Tests accuracy of <code>removeRanges(Collection&lt;MultiplicityRange&gt;)</code>.
     * </p>
     * <p>
     * Tests situation when duplicate ranges exist in collection.
     * </p>
     * <p>
     * Normal process.
     * </p>
     */
    public void testRemoveRangesAccuracyDuplicateRange() {
        try {
            // valid ranges
            MultiplicityRange range1 = new MultiplicityRangeImpl();
            MultiplicityRange range2 = new MultiplicityRangeImpl();
            MultiplicityRange range3 = new MultiplicityRangeImpl();
            // ranges to add
            Collection<MultiplicityRange> ranges = new ArrayList<MultiplicityRange>();
            ranges.add(range1);
            ranges.add(range3);
            // add to multiplicity
            multiplicityImpl.addRange(range1);
            multiplicityImpl.addRange(range1);
            multiplicityImpl.addRange(range2);

            // remove {1, 3} from {1, 1, 2} and we expect the result collection {1, 2}
            multiplicityImpl.removeRanges(ranges);

            // validation
            Collection<MultiplicityRange> retRanges = multiplicityImpl.getRanges();
            assertNotNull("Value should be added correctly.", retRanges);
            // check retRanges equal to {1, 2}
            assertEquals("Value should be added correctly.", 2, retRanges.size());
            assertTrue("Value should be added correctly.", retRanges.contains(range1));
            assertTrue("Value should be added correctly.", retRanges.contains(range2));
        } catch (IllegalArgumentException e) {
            fail("IllegalArgumentException should be not thrown since value is valid.");
        }
    }

    /**
     * <p>
     * Tests accuracy of <code>clearRanges()</code>.
     * </p>
     * <p>
     * Tests situation when some ranges are added.
     * </p>
     * <p>
     * Normal process.
     * </p>
     */
    public void testClearRangesAccuracy() {
        // add ranges to multiplicityImpl
        multiplicityImpl.addRange(new MultiplicityRangeImpl());
        multiplicityImpl.addRange(new MultiplicityRangeImpl());
        // value should be added correctly
        Collection<MultiplicityRange> rangesBeforeClear = multiplicityImpl.getRanges();
        assertNotNull("Value should not be null.", rangesBeforeClear);
        assertFalse("Value should not be empty.", rangesBeforeClear.isEmpty());
        // clear
        multiplicityImpl.clearRanges();
        // value should be cleared correctly
        Collection<MultiplicityRange> rangesAfterClear = multiplicityImpl.getRanges();
        assertNotNull("Value should be cleared correctly.", rangesAfterClear);
        assertTrue("Value should be cleared correctly.", rangesAfterClear.isEmpty());
    }

    /**
     * <p>
     * Tests accuracy of <code>getRanges()</code>.
     * </p>
     * <p>
     * Tests situation when no ranges are added.
     * </p>
     * <p>
     * Empty collection expected. Normal process.
     * </p>
     */
    public void testGetRangesAccuracyEmpty() {
        Collection<MultiplicityRange> ranges = multiplicityImpl.getRanges();
        assertNotNull("Value should be gotten correctly.", ranges);
        assertTrue("Value should be gotten correctly.", ranges.isEmpty());
    }

    /**
     * <p>
     * Tests accuracy of <code>getRanges()</code>.
     * </p>
     * <p>
     * Tests situation when some ranges are added.
     * </p>
     * <p>
     * Non empty collection expected. Normal process.
     * </p>
     */
    public void testGetRangesAccuracyNonEmpty() {
        // valid collection
        Collection<MultiplicityRange> ranges = new ArrayList<MultiplicityRange>();
        ranges.add(new MultiplicityRangeImpl());
        // add
        multiplicityImpl.addRanges(ranges);
        // validation
        Collection<MultiplicityRange> retRanges = multiplicityImpl.getRanges();
        assertNotNull("Value should be gotten correctly.", retRanges);
        assertEquals("Value should be gotten correctly.", ranges.size(), retRanges.size());
        // the collections contains the same elements
        assertTrue("Value should be gotten correctly.", retRanges.containsAll(ranges));
        assertTrue("Value should be gotten correctly.", ranges.containsAll(retRanges));
    }

    /**
     * <p>
     * Tests accuracy of <code>getRanges()</code>.
     * </p>
     * <p>
     * Tests situation when some ranges are added.
     * </p>
     * <p>
     * Normal process.
     * </p>
     */
    public void testGetRangesAccuracyShallowCopy() {
        MultiplicityRange range = new MultiplicityRangeImpl();
        // add
        multiplicityImpl.addRange(range);
        // validation
        Collection<MultiplicityRange> retRanges = multiplicityImpl.getRanges();
        assertNotNull("Value should be gotten correctly.", retRanges);
        assertEquals("Value should be gotten correctly.", 1, retRanges.size());
        // check shallow copy
        assertTrue("Value should be gotten correctly.", retRanges.contains(range));
    }

    /**
     * <p>
     * Tests failure of <code>containsRange(MultiplicityRange)</code>.
     * </p>
     * <p>
     * Tests situation when range is null.
     * </p>
     * <p>
     * <code>IllegalArgumentException</code> expected.
     * </p>
     */
    public void testContainsRangeFailureNull() {
        try {
            multiplicityImpl.containsRange(null);
            fail("IllegalArgumentException should be thrown since value is invalid.");
        } catch (IllegalArgumentException e) {
            // expected
        }
    }

    /**
     * <p>
     * Tests accuracy of <code>containsRange(MultiplicityRange)</code>.
     * </p>
     * <p>
     * Tests situation when range does not exist.
     * </p>
     * <p>
     * Normal process.
     * </p>
     */
    public void testContainsRangeAccuracyNonExist() {
        try {
            // add a range
            MultiplicityRange range = new MultiplicityRangeImpl();
            multiplicityImpl.addRange(range);
            // check
            boolean isContain = multiplicityImpl.containsRange(new MultiplicityRangeImpl());
            assertFalse("Value should be returned correctly.", isContain);

        } catch (IllegalArgumentException e) {
            fail("IllegalArgumentException should be thrown since value is invalid.");
        }
    }

    /**
     * <p>
     * Tests accuracy of <code>containsRange(MultiplicityRange)</code>.
     * </p>
     * <p>
     * Tests situation when range exists.
     * </p>
     * <p>
     * Normal process.
     * </p>
     */
    public void testContainsRangeAccuracyExist() {
        try {
            // add a range
            MultiplicityRange range = new MultiplicityRangeImpl();
            multiplicityImpl.addRange(range);
            // check
            boolean isContain = multiplicityImpl.containsRange(range);
            assertTrue("Value should be returned correctly.", isContain);

        } catch (IllegalArgumentException e) {
            fail("IllegalArgumentException should be thrown since value is invalid.");
        }
    }

    /**
     * <p>
     * Tests accuracy of <code>countRanges()</code>.
     * </p>
     * <p>
     * Tests situation when no range exists.
     * </p>
     * <p>
     * Normal process.
     * </p>
     */
    public void testCountRangesAccuracyEmpty() {
        assertEquals("Value should be returned correctly.", 0, multiplicityImpl.countRanges());
    }

    /**
     * <p>
     * Tests accuracy of <code>countRanges()</code>.
     * </p>
     * <p>
     * Tests situation when some ranges are added.
     * </p>
     * <p>
     * Normal process.
     * </p>
     */
    public void testCountRangesAccuracyNonEmpty() {
        MultiplicityRange range1 = new MultiplicityRangeImpl();
        MultiplicityRange range2 = new MultiplicityRangeImpl();
        multiplicityImpl.addRange(range1);
        multiplicityImpl.addRange(range2);
        assertEquals("Value should be returned correctly.", 2, multiplicityImpl.countRanges());
    }

    /**
     * <p>
     * Tests accuracy of <code>countRanges()</code>.
     * </p>
     * <p>
     * Tests situation when duplicate ranges are added.
     * </p>
     * <p>
     * Normal process.
     * </p>
     */
    public void testCountRangesAccuracyDuplicateRange() {
        MultiplicityRange range1 = new MultiplicityRangeImpl();
        multiplicityImpl.addRange(range1);
        multiplicityImpl.addRange(range1);
        assertEquals("Value should be returned correctly.", 2, multiplicityImpl.countRanges());
    }

}
