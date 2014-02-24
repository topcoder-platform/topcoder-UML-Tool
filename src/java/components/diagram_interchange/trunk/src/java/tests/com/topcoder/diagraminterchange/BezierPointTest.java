/*
 * Copyright (C) 2006 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.diagraminterchange;

import java.util.List;

import junit.framework.TestCase;

/**
 * <p>
 * Unit tests for class BezierPoint.
 * </p>
 *
 * @author TCSDEVELOPER
 * @version 1.0
 */
public class BezierPointTest extends TestCase {

    /**
     * An index number out of the size limit (>2).
     */
    private static final int TOO_BIG_INDEX = 3;

    /**
     * An instance of Point for testing.
     */
    private Point point1;

    /**
     * An instance of Point for testing.
     */
    private Point point2;

    /**
     * An instance of BezierPoint for testing.
     */
    private BezierPoint instance;

    /**
     * Sets up the environment. Creates an instance of BezierPoint.
     */
    protected void setUp() {
        point1 = new Point();
        point2 = new Point();

        instance = new BezierPoint();
    }

    /**
     * Tests the constructor. All the fields should be initiated properly.
     */
    public void testBezierPointCtor() {
        assertNotNull("fail to construct the instance", instance);

        assertEquals("empty expected", 0, instance.countControls());
    }

    /**
     * Tests method addControl(Point). The elements should be contained in correct order.
     */
    public void testAddControl() {
        instance.addControl(point1);

        assertEquals("one element expected", 1, instance.countControls());
        assertEquals("the index of point 1 should be 0", 0, instance.indexOfControl(point1));

        instance.addControl(point2);

        assertEquals("two elements expected", 2, instance.countControls());
        assertEquals("the index of point 2 should be 1", 1, instance.indexOfControl(point2));
    }

    /**
     * Tests method addControl(Point) with null value. IllegalArgumentException should be thrown.
     */
    public void testAddControlNull() {
        try {
            instance.addControl(null);
            fail("IllegalArgumentException should be thrown");
        } catch (IllegalArgumentException ex) {
            // pass
        }
    }

    /**
     * Tests method addControl(Point) with duplicate elements. Duplicate elements should be allowed.
     */
    public void testAddControlDuplicate() {
        // append an element twice
        instance.addControl(point1);
        instance.addControl(point1);

        assertEquals("two elements expected", 2, instance.countControls());
    }

    /**
     * Tests method addControl(Point) when there were already two elements. IllegalStateException should be
     * thrown.
     */
    public void testAddControlSizeLimit() {
        // the list contains two elements
        instance.addControl(point1);
        instance.addControl(point2);

        try {
            instance.addControl(new Point());
            fail("IllegalStateException should be thrown");
        } catch (IllegalStateException ex) {
            // pass
        }
    }

    /**
     * Tests method addControl(Point) with null value when there were already two elements.
     * IllegalStateException should be thrown.
     */
    public void testAddControlNullSizeLimit() {
        // the list contains two elements
        instance.addControl(point1);
        instance.addControl(point2);

        try {
            instance.addControl(null);
            fail("IllegalStateException should be thrown");
        } catch (IllegalStateException ex) {
            // pass
        }
    }

    /**
     * Tests method addControl(int, Point) with elements to be inserted at the tail of list. The elements
     * should be contained in correct order.
     */
    public void testAddControlIndexAppend() {
        // add two elements at the tail
        instance.addControl(0, point1);
        instance.addControl(1, point2);

        assertEquals("two elements expected", 2, instance.countControls());
        assertEquals("the index of point 1 should be 0", 0, instance.indexOfControl(point1));
        assertEquals("the index of point 2 should be 1", 1, instance.indexOfControl(point2));
    }

    /**
     * Tests method addControl(int, Point) with elements to be inserted at the head of list. The elements
     * should be contained in correct order.
     */
    public void testAddControlIndexInsert() {
        // add two elements at the head
        instance.addControl(0, point1);
        instance.addControl(0, point2);

        assertEquals("two elements expected", 2, instance.countControls());
        assertEquals("the index of point 1 should be 1", 1, instance.indexOfControl(point1));
        assertEquals("the index of point 2 should be 0", 0, instance.indexOfControl(point2));
    }

    /**
     * Tests method addControl(int, Point) with null value. IllegalArgumentException should be thrown.
     */
    public void testAddControlIndexNull() {
        try {
            instance.addControl(0, null);
            fail("IllegalArgumentException should be thrown");
        } catch (IllegalArgumentException ex) {
            // pass
        }
    }

    /**
     * Tests method addControl(int, Point) with duplicate elements. Duplicate elements should be allowed.
     */
    public void testAddControlIndexDuplicate() {
        // insert an element twice
        instance.addControl(0, point1);
        instance.addControl(0, point1);

        assertEquals("two elements expected", 2, instance.countControls());
    }

    /**
     * Tests method addControl(int, Point) with negative index. IllegalArgumentException should be thrown.
     */
    public void testAddControlIndexNegative() {
        try {
            instance.addControl(-1, point1);
            fail("IllegalArgumentException should be thrown");
        } catch (IllegalArgumentException ex) {
            // pass
        }
    }

    /**
     * Tests method addControl(int, Point) with index larger than size. IllegalArgumentException should be
     * thrown.
     */
    public void testAddControlIndexLarger() {
        try {
            instance.addControl(1, point1);
            fail("IllegalArgumentException should be thrown");
        } catch (IllegalArgumentException ex) {
            // pass
        }
    }

    /**
     * Tests method addControl(int, Point) when there were already two elements. IllegalStateException should
     * be thrown.
     */
    public void testAddControlIndexSizeLimit() {
        // the list contains two elements
        instance.addControl(point1);
        instance.addControl(point2);

        try {
            instance.addControl(0, new Point());
            fail("IllegalStateException should be thrown");
        } catch (IllegalStateException ex) {
            // pass
        }
    }

    /**
     * Tests method addControl(int, Point) with index out of range when there were already two elements. Since
     * the size is checked first, IllegalStateException should be thrown.
     */
    public void testAddControlIndexOutOfRangeSizeLimit() {
        // the list contains two elements
        instance.addControl(point1);
        instance.addControl(point2);

        try {
            instance.addControl(TOO_BIG_INDEX, new Point());
            fail("IllegalStateException should be thrown");
        } catch (IllegalStateException ex) {
            // pass
        }
    }

    /**
     * Tests method addControl(int, Point) with null value when there were already two elements. Since the
     * size is checked first, IllegalStateException should be thrown.
     */
    public void testAddControlIndexNullSizeLimit() {
        // the list contains two elements
        instance.addControl(point1);
        instance.addControl(point2);

        try {
            instance.addControl(0, null);
            fail("IllegalStateException should be thrown");
        } catch (IllegalStateException ex) {
            // pass
        }
    }

    /**
     * Tests method setControl. The element should be updated properly.
     */
    public void testSetControl() {
        // the list contains one element
        instance.addControl(point1);

        assertEquals("one element expected", 1, instance.countControls());
        assertEquals("the index of point 1 should be 0", 0, instance.indexOfControl(point1));

        instance.setControl(0, point2);

        assertEquals("one element expected", 1, instance.countControls());
        assertEquals("the index of point 2 should be 0", 0, instance.indexOfControl(point2));
    }

    /**
     * Tests method setControl with null value. IllegalArgumentException should be thrown.
     */
    public void testSetControlNull() {
        // the list contains one element
        instance.addControl(point1);

        try {
            instance.setControl(0, null);
            fail("IllegalArgumentException should be thrown");
        } catch (IllegalArgumentException ex) {
            // pass
        }
    }

    /**
     * Tests method setControl with duplicate elements. Duplicate elements should be allowed.
     */
    public void testSetControlDuplicate() {
        // the list contains two elements
        instance.addControl(point1);
        instance.addControl(point2);

        // replace the second element with the first one
        instance.setControl(1, point1);

        assertEquals("two elements expected", 2, instance.countControls());
        assertFalse("the point 2 should have been replaced", instance.containsControl(point2));
    }

    /**
     * Tests method setControl with negative index. IllegalArgumentException should be thrown.
     */
    public void testSetControlNegative() {
        try {
            instance.setControl(-1, point1);
            fail("IllegalArgumentException should be thrown");
        } catch (IllegalArgumentException ex) {
            // pass
        }
    }

    /**
     * Tests method setControl with index larger than size-1. IllegalArgumentException should be thrown.
     */
    public void testSetControlLarger() {
        // the list contains one element
        instance.addControl(point1);

        try {
            instance.setControl(1, point1);
            fail("IllegalArgumentException should be thrown");
        } catch (IllegalArgumentException ex) {
            // pass
        }
    }

    /**
     * Tests method removeControl(int). The element should be removed properly.
     */
    public void testRemoveControlIndex() {
        // the list contains two elements
        instance.addControl(point1);
        instance.addControl(point2);

        // remove the first one
        Point removed = instance.removeControl(0);

        assertEquals("the point 1 should be returned", removed, point1);
        assertEquals("one element expected", 1, instance.countControls());
        assertFalse("the point 1 should have been removed", instance.containsControl(point1));
        assertEquals("the index of point 2 should be 0", 0, instance.indexOfControl(point2));
    }

    /**
     * Tests method removeControl(int) with negative index. IllegalArgumentException should be thrown.
     */
    public void testRemoveControlIndexNegative() {
        try {
            instance.removeControl(-1);
            fail("IllegalArgumentException should be thrown");
        } catch (IllegalArgumentException ex) {
            // pass
        }
    }

    /**
     * Tests method removeControl(int) with index larger than size-1. IllegalArgumentException should be
     * thrown.
     */
    public void testRemoveControlIndexLarger() {
        try {
            instance.removeControl(0);
            fail("IllegalArgumentException should be thrown");
        } catch (IllegalArgumentException ex) {
            // pass
        }
    }

    /**
     * Tests method removeControl(Point). The elements should be removed properly.
     */
    public void testRemoveControl() {
        // the list contains two elements
        instance.addControl(point1);
        instance.addControl(point2);

        // remove one element
        boolean removed = instance.removeControl(point1);

        assertTrue("the point 1 should be returned", removed);
        assertEquals("one element expected", 1, instance.countControls());
        assertFalse("the point 1 should have been removed", instance.containsControl(point1));
        assertEquals("the index of point 2 should be 0", 0, instance.indexOfControl(point2));

        // remove another element
        removed = instance.removeControl(point2);

        assertTrue("the point 2 should be returned", removed);
        assertEquals("no element expected", 0, instance.countControls());
        assertFalse("the point 2 should have been removed", instance.containsControl(point2));
    }

    /**
     * Tests method removeControl(Point) with nonexistent element. The method should return false.
     */
    public void testRemoveControlNonexist() {
        assertFalse("false expected", instance.removeControl(point1));
    }

    /**
     * Tests method removeControl(Point) with null value. IllegalArgumentException should be thrown.
     */
    public void testRemoveControlNull() {
        try {
            instance.removeControl(null);
            fail("IllegalArgumentException should be thrown");
        } catch (IllegalArgumentException ex) {
            // pass
        }
    }

    /**
     * Tests method removeControl(Point) with duplicate elements. Only the first occurrence should be removed.
     */
    public void testRemoveControlDuplicate() {
        // the list contains duplicate elements
        instance.addControl(point1);
        instance.addControl(point1);

        // remove the element
        instance.removeControl(point1);

        assertEquals("one element expected", 1, instance.countControls());
        assertEquals("the index of point 1 should be 0", 0, instance.indexOfControl(point1));
    }

    /**
     * Tests method clearControls. The elements should be removed properly.
     */
    public void testClearControls() {
        // the list contains two elements
        instance.addControl(point1);
        instance.addControl(point2);

        instance.clearControls();

        assertEquals("no element expected", 0, instance.countControls());
    }

    /**
     * Tests method getControls. The method should return a copy of list containing all the elements.
     */
    public void testGetControls() {
        // the list contains two elements
        instance.addControl(point1);
        instance.addControl(point2);

        List<Point> list = instance.getControls();

        assertEquals("two elements expected", 2, list.size());
        assertEquals("the index of point 1 should be 0", 0, list.indexOf(point1));
        assertEquals("the index of point 2 should be 1", 1, list.indexOf(point2));

        // remove all the elements in the instance
        instance.clearControls();

        // the return list doesn't change since it is just a copy
        assertEquals("two elements expected", 2, list.size());
    }

    /**
     * Tests method containsControl. The method should return true for contained element.
     */
    public void testContainsControl() {
        // the list contains one element
        instance.addControl(point1);

        assertTrue("true expected", instance.containsControl(point1));
    }

    /**
     * Tests method containsControl with nonexistent element. The method should return false.
     */
    public void testContainsControlNonexist() {
        assertFalse("false expected", instance.containsControl(point1));
    }

    /**
     * Tests method containsControl with null value. IllegalArgumentException should be thrown.
     */
    public void testContainsControlNull() {
        try {
            instance.containsControl(null);
            fail("IllegalArgumentException should be thrown");
        } catch (IllegalArgumentException ex) {
            // pass
        }
    }

    /**
     * Tests method indexOfControl. The index should be correct for each element.
     */
    public void testIndexOfControl() {
        // the list contains two elements
        instance.addControl(point1);
        instance.addControl(point2);

        assertEquals("the index of point 1 should be 0", 0, instance.indexOfControl(point1));
        assertEquals("the index of point 2 should be 1", 1, instance.indexOfControl(point2));
    }

    /**
     * Tests method indexOfControl with nonexistent element. The method should return -1.
     */
    public void testIndexOfControlNonexist() {
        assertEquals("-1 expected", -1, instance.indexOfControl(point1));
    }

    /**
     * Tests method indexOfControl with null value. IllegalArgumentException should be thrown.
     */
    public void testIndexOfControlNull() {
        try {
            instance.indexOfControl(null);
            fail("IllegalArgumentException should be thrown");
        } catch (IllegalArgumentException ex) {
            // pass
        }
    }

    /**
     * Tests method indexOfControl with duplicate elements. The method should return the index of the first
     * occurrence.
     */
    public void testIndexOfControlDuplicate() {
        // the list contains duplicate elements
        instance.addControl(point1);
        instance.addControl(point1);

        assertEquals("the index of point 1 should be 0", 0, instance.indexOfControl(point1));
    }

    /**
     * Tests method countControls. The method should return the size of elements.
     */
    public void testCountControls() {
        assertEquals("no element expected", 0, instance.countControls());

        // add a element
        instance.addControl(point1);

        assertEquals("one element expected", 1, instance.countControls());

        // remove the element
        instance.removeControl(point1);

        assertEquals("no element expected", 0, instance.countControls());
    }
}