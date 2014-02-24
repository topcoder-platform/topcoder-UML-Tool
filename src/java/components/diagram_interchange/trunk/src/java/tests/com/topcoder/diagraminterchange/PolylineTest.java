/*
 * Copyright (C) 2006 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.diagraminterchange;

import java.util.List;

import junit.framework.TestCase;

/**
 * <p>
 * Unit tests for class Polyline.
 * </p>
 *
 * @author TCSDEVELOPER
 * @version 1.0
 */
public class PolylineTest extends TestCase {

    /**
     * An instance of Point for testing.
     */
    private Point waypoint1;

    /**
     * An instance of Point for testing.
     */
    private Point waypoint2;

    /**
     * An instance of Polyline for testing.
     */
    private Polyline instance;

    /**
     * Sets up the environment. Creates an instance of Polyline.
     */
    protected void setUp() {
        waypoint1 = new Point();
        waypoint2 = new Point();

        instance = new Polyline();
    }

    /**
     * Tests the constructor. All the fields should be initiated properly.
     */
    public void testPolylineCtor() {
        assertNotNull("fail to construct the instance", instance);

        assertFalse("false expected", instance.isClosed());

        assertEquals("empty expected", 0, instance.countWaypoints());
    }

    /**
     * Tests method isClosed. The correspond field should be returned properly.
     */
    public void testIsClosed() {
        instance.setClosed(true);
        assertTrue("true expected", instance.isClosed());

        instance.setClosed(false);
        assertFalse("false expected", instance.isClosed());
    }

    /**
     * Tests method setClosed. The correspond field should be updated properly.
     */
    public void testSetClosed() {
        instance.setClosed(true);
        assertTrue("true expected", instance.isClosed());

        instance.setClosed(false);
        assertFalse("false expected", instance.isClosed());
    }

    /**
     * Tests method addWaypoint(Point). The elements should be contained in correct order.
     */
    public void testAddWaypoint() {
        instance.addWaypoint(waypoint1);

        assertEquals("one element expected", 1, instance.countWaypoints());
        assertEquals("the index of waypoint 1 should be 0", 0, instance.indexOfWaypoint(waypoint1));

        instance.addWaypoint(waypoint2);

        assertEquals("two elements expected", 2, instance.countWaypoints());
        assertEquals("the index of waypoint 2 should be 1", 1, instance.indexOfWaypoint(waypoint2));
    }

    /**
     * Tests method addWaypoint(Point) with null value. IllegalArgumentException should be thrown.
     */
    public void testAddWaypointNull() {
        try {
            instance.addWaypoint(null);
            fail("IllegalArgumentException should be thrown");
        } catch (IllegalArgumentException ex) {
            // pass
        }
    }

    /**
     * Tests method addWaypoint(Point) with duplicate elements. Duplicate elements should be allowed.
     */
    public void testAddWaypointDuplicate() {
        // append an element twice
        instance.addWaypoint(waypoint1);
        instance.addWaypoint(waypoint1);

        assertEquals("two elements expected", 2, instance.countWaypoints());
    }

    /**
     * Tests method addWaypoint(int, Point) with elements to be inserted at the tail of list. The elements
     * should be contained in correct order.
     */
    public void testAddWaypointIndexAppend() {
        // add two elements at the tail
        instance.addWaypoint(0, waypoint1);
        instance.addWaypoint(1, waypoint2);

        assertEquals("two elements expected", 2, instance.countWaypoints());
        assertEquals("the index of waypoint 1 should be 0", 0, instance.indexOfWaypoint(waypoint1));
        assertEquals("the index of waypoint 2 should be 1", 1, instance.indexOfWaypoint(waypoint2));
    }

    /**
     * Tests method addWaypoint(int, Point) with elements to be inserted at the head of list. The elements
     * should be contained in correct order.
     */
    public void testAddWaypointIndexInsert() {
        // add two elements at the head
        instance.addWaypoint(0, waypoint1);
        instance.addWaypoint(0, waypoint2);

        assertEquals("two elements expected", 2, instance.countWaypoints());
        assertEquals("the index of waypoint 1 should be 1", 1, instance.indexOfWaypoint(waypoint1));
        assertEquals("the index of waypoint 2 should be 0", 0, instance.indexOfWaypoint(waypoint2));
    }

    /**
     * Tests method addWaypoint(int, Point) with null value. IllegalArgumentException should be thrown.
     */
    public void testAddWaypointIndexNull() {
        try {
            instance.addWaypoint(0, null);
            fail("IllegalArgumentException should be thrown");
        } catch (IllegalArgumentException ex) {
            // pass
        }
    }

    /**
     * Tests method addWaypoint(int, Point) with duplicate elements. Duplicate elements should be allowed.
     */
    public void testAddWaypointIndexDuplicate() {
        // insert an element twice
        instance.addWaypoint(0, waypoint1);
        instance.addWaypoint(0, waypoint1);

        assertEquals("two elements expected", 2, instance.countWaypoints());
    }

    /**
     * Tests method addWaypoint(int, Point) with negative index. IllegalArgumentException should be thrown.
     */
    public void testAddWaypointIndexNegative() {
        try {
            instance.addWaypoint(-1, waypoint1);
            fail("IllegalArgumentException should be thrown");
        } catch (IllegalArgumentException ex) {
            // pass
        }
    }

    /**
     * Tests method addWaypoint(int, Point) with index larger than size. IllegalArgumentException should be
     * thrown.
     */
    public void testAddWaypointIndexLarger() {
        try {
            instance.addWaypoint(1, waypoint1);
            fail("IllegalArgumentException should be thrown");
        } catch (IllegalArgumentException ex) {
            // pass
        }
    }

    /**
     * Tests method setWaypoint. The element should be updated properly.
     */
    public void testSetWaypoint() {
        // the list contains one element
        instance.addWaypoint(waypoint1);

        assertEquals("one element expected", 1, instance.countWaypoints());
        assertEquals("the index of waypoint 1 should be 0", 0, instance.indexOfWaypoint(waypoint1));

        instance.setWaypoint(0, waypoint2);

        assertEquals("one element expected", 1, instance.countWaypoints());
        assertEquals("the index of waypoint 2 should be 0", 0, instance.indexOfWaypoint(waypoint2));
    }

    /**
     * Tests method setWaypoint with null value. IllegalArgumentException should be thrown.
     */
    public void testSetWaypointNull() {
        // the list contains one element
        instance.addWaypoint(waypoint1);

        try {
            instance.setWaypoint(0, null);
            fail("IllegalArgumentException should be thrown");
        } catch (IllegalArgumentException ex) {
            // pass
        }
    }

    /**
     * Tests method setWaypoint with duplicate elements. Duplicate elements should be allowed.
     */
    public void testSetWaypointDuplicate() {
        // the list contains two elements
        instance.addWaypoint(waypoint1);
        instance.addWaypoint(waypoint2);

        // replace the second element with the first one
        instance.setWaypoint(1, waypoint1);

        assertEquals("two elements expected", 2, instance.countWaypoints());
        assertFalse("the waypoint 2 should have been replaced", instance.containsWaypoint(waypoint2));
    }

    /**
     * Tests method setWaypoint with negative index. IllegalArgumentException should be thrown.
     */
    public void testSetWaypointNegative() {
        try {
            instance.setWaypoint(-1, waypoint1);
            fail("IllegalArgumentException should be thrown");
        } catch (IllegalArgumentException ex) {
            // pass
        }
    }

    /**
     * Tests method setWaypoint with index larger than size-1. IllegalArgumentException should be thrown.
     */
    public void testSetWaypointLarger() {
        // the list contains one element
        instance.addWaypoint(waypoint1);

        try {
            instance.setWaypoint(1, waypoint1);
            fail("IllegalArgumentException should be thrown");
        } catch (IllegalArgumentException ex) {
            // pass
        }
    }

    /**
     * Tests method removeWaypoint(int). The element should be removed properly.
     */
    public void testRemoveWaypointIndex() {
        // the list contains two elements
        instance.addWaypoint(waypoint1);
        instance.addWaypoint(waypoint2);

        // remove the first one
        Point removed = instance.removeWaypoint(0);

        assertEquals("the waypoint 1 should be returned", removed, waypoint1);
        assertEquals("one element expected", 1, instance.countWaypoints());
        assertFalse("the waypoint 1 should have been removed", instance.containsWaypoint(waypoint1));
        assertEquals("the index of waypoint 2 should be 0", 0, instance.indexOfWaypoint(waypoint2));
    }

    /**
     * Tests method removeWaypoint(int) with negative index. IllegalArgumentException should be thrown.
     */
    public void testRemoveWaypointIndexNegative() {
        try {
            instance.removeWaypoint(-1);
            fail("IllegalArgumentException should be thrown");
        } catch (IllegalArgumentException ex) {
            // pass
        }
    }

    /**
     * Tests method removeWaypoint(int) with index larger than size-1. IllegalArgumentException should be
     * thrown.
     */
    public void testRemoveWaypointIndexLarger() {
        try {
            instance.removeWaypoint(0);
            fail("IllegalArgumentException should be thrown");
        } catch (IllegalArgumentException ex) {
            // pass
        }
    }

    /**
     * Tests method removeWaypoint(Point). The elements should be removed properly.
     */
    public void testRemoveWaypoint() {
        // the list contains two elements
        instance.addWaypoint(waypoint1);
        instance.addWaypoint(waypoint2);

        // remove one element
        boolean removed = instance.removeWaypoint(waypoint1);

        assertTrue("the waypoint 1 should be returned", removed);
        assertEquals("one element expected", 1, instance.countWaypoints());
        assertFalse("the waypoint 1 should have been removed", instance.containsWaypoint(waypoint1));
        assertEquals("the index of waypoint 2 should be 0", 0, instance.indexOfWaypoint(waypoint2));

        // remove another element
        removed = instance.removeWaypoint(waypoint2);

        assertTrue("the waypoint 2 should be returned", removed);
        assertEquals("no element expected", 0, instance.countWaypoints());
        assertFalse("the waypoint 2 should have been removed", instance.containsWaypoint(waypoint2));
    }

    /**
     * Tests method removeWaypoint(Point) with nonexistent element. The method should return false.
     */
    public void testRemoveWaypointNonexist() {
        assertFalse("false expected", instance.removeWaypoint(waypoint1));
    }

    /**
     * Tests method removeWaypoint(Point) with null value. IllegalArgumentException should be thrown.
     */
    public void testRemoveWaypointNull() {
        try {
            instance.removeWaypoint(null);
            fail("IllegalArgumentException should be thrown");
        } catch (IllegalArgumentException ex) {
            // pass
        }
    }

    /**
     * Tests method removeWaypoint(Point) with duplicate elements. Only the first occurrence should be
     * removed.
     */
    public void testRemoveWaypointDuplicate() {
        // the list contains duplicate elements
        instance.addWaypoint(waypoint1);
        instance.addWaypoint(waypoint2);
        instance.addWaypoint(waypoint1);

        // remove the element
        instance.removeWaypoint(waypoint1);

        assertEquals("two elements expected", 2, instance.countWaypoints());
        assertEquals("the index of waypoint 1 should be 1", 1, instance.indexOfWaypoint(waypoint1));
    }

    /**
     * Tests method clearWaypoints. The elements should be removed properly.
     */
    public void testClearWaypoints() {
        // the list contains two elements
        instance.addWaypoint(waypoint1);
        instance.addWaypoint(waypoint2);

        instance.clearWaypoints();

        assertEquals("no element expected", 0, instance.countWaypoints());
    }

    /**
     * Tests method getWaypoints. The method should return a copy of list containing all the elements.
     */
    public void testGetWaypoints() {
        // the list contains two elements
        instance.addWaypoint(waypoint1);
        instance.addWaypoint(waypoint2);

        List<Point> list = instance.getWaypoints();

        assertEquals("two elements expected", 2, list.size());
        assertEquals("the index of waypoint 1 should be 0", 0, list.indexOf(waypoint1));
        assertEquals("the index of waypoint 2 should be 1", 1, list.indexOf(waypoint2));

        // remove all the elements in the instance
        instance.clearWaypoints();

        // the return list doesn't change since it is just a copy
        assertEquals("two elements expected", 2, list.size());
    }

    /**
     * Tests method containsWaypoint. The method should return true for contained element.
     */
    public void testContainsWaypoint() {
        // the list contains one element
        instance.addWaypoint(waypoint1);

        assertTrue("true expected", instance.containsWaypoint(waypoint1));
    }

    /**
     * Tests method containsWaypoint with nonexistent element. The method should return false.
     */
    public void testContainsWaypointNonexist() {
        assertFalse("false expected", instance.containsWaypoint(waypoint1));
    }

    /**
     * Tests method containsWaypoint with null value. IllegalArgumentException should be thrown.
     */
    public void testContainsWaypointNull() {
        try {
            instance.containsWaypoint(null);
            fail("IllegalArgumentException should be thrown");
        } catch (IllegalArgumentException ex) {
            // pass
        }
    }

    /**
     * Tests method indexOfWaypoint. The index should be correct for each element.
     */
    public void testIndexOfWaypoint() {
        // the list contains two elements
        instance.addWaypoint(waypoint1);
        instance.addWaypoint(waypoint2);

        assertEquals("the index of waypoint 1 should be 0", 0, instance.indexOfWaypoint(waypoint1));
        assertEquals("the index of waypoint 2 should be 1", 1, instance.indexOfWaypoint(waypoint2));
    }

    /**
     * Tests method indexOfWaypoint with nonexistent element. The method should return -1.
     */
    public void testIndexOfWaypointNonexist() {
        assertEquals("-1 expected", -1, instance.indexOfWaypoint(waypoint1));
    }

    /**
     * Tests method indexOfWaypoint with null value. IllegalArgumentException should be thrown.
     */
    public void testIndexOfWaypointNull() {
        try {
            instance.indexOfWaypoint(null);
            fail("IllegalArgumentException should be thrown");
        } catch (IllegalArgumentException ex) {
            // pass
        }
    }

    /**
     * Tests method indexOfWaypoint with duplicate elements. The method should return the index of the first
     * occurrence.
     */
    public void testIndexOfWaypointDuplicate() {
        // the list contains duplicate elements
        instance.addWaypoint(waypoint1);
        instance.addWaypoint(waypoint1);

        assertEquals("the index of waypoint 1 should be 0", 0, instance.indexOfWaypoint(waypoint1));
    }

    /**
     * Tests method countWaypoints. The method should return the size of elements.
     */
    public void testCountWaypoints() {
        assertEquals("no element expected", 0, instance.countWaypoints());

        // add a element
        instance.addWaypoint(waypoint1);

        assertEquals("one element expected", 1, instance.countWaypoints());

        // remove the element
        instance.removeWaypoint(waypoint1);

        assertEquals("no element expected", 0, instance.countWaypoints());
    }
}