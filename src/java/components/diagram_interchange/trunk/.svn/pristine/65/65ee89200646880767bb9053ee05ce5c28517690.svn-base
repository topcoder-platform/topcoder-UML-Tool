/*
 * Copyright (C) 2006 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.diagraminterchange;

import java.util.List;

import junit.framework.TestCase;

/**
 * <p>
 * Unit tests for class GraphEdge.
 * </p>
 *
 * @author TCSDEVELOPER
 * @version 1.0
 */
public class GraphEdgeTest extends TestCase {

    /**
     * An index number out of the size limit (>2).
     */
    private static final int TOO_BIG_INDEX = 3;

    /**
     * An instance of Point for testing.
     */
    private Point waypoint1;

    /**
     * An instance of Point for testing.
     */
    private Point waypoint2;

    /**
     * An instance of GraphConnector for testing.
     */
    private GraphConnector anchor1;

    /**
     * An instance of GraphConnector for testing.
     */
    private GraphConnector anchor2;

    /**
     * An instance of GraphEdge for testing.
     */
    private GraphEdge instance;

    /**
     * Sets up the environment. Creates an instance of GraphEdge.
     */
    protected void setUp() {
        waypoint1 = new Point();
        waypoint2 = new Point();
        anchor1 = new GraphConnector();
        anchor2 = new GraphConnector();

        instance = new GraphEdge();
    }

    /**
     * Tests the constructor. All the fields should be initiated properly.
     */
    public void testGraphEdgeCtor() {
        assertNotNull("fail to construct the instance", instance);

        assertEquals("empty expected", 0, instance.countWaypoints());
        assertEquals("empty expected", 0, instance.countAnchors());
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

    /**
     * Tests method addAnchor(GraphConnector). The elements should be contained in correct order.
     */
    public void testAddAnchor() {
        instance.addAnchor(anchor1);

        assertEquals("one element expected", 1, instance.countAnchors());
        assertEquals("the index of anchor 1 should be 0", 0, instance.indexOfAnchor(anchor1));

        instance.addAnchor(anchor2);

        assertEquals("two elements expected", 2, instance.countAnchors());
        assertEquals("the index of anchor 2 should be 1", 1, instance.indexOfAnchor(anchor2));
    }

    /**
     * Tests method addAnchor(GraphConnector) with null value. IllegalArgumentException should be thrown.
     */
    public void testAddAnchorNull() {
        try {
            instance.addAnchor(null);
            fail("IllegalArgumentException should be thrown");
        } catch (IllegalArgumentException ex) {
            // pass
        }
    }

    /**
     * Tests method addAnchor(GraphConnector) with duplicate elements. Duplicate elements should be allowed.
     */
    public void testAddAnchorDuplicate() {
        // append an element twice
        instance.addAnchor(anchor1);
        instance.addAnchor(anchor1);

        assertEquals("two elements expected", 2, instance.countAnchors());
    }

    /**
     * Tests method addAnchor(GraphConnector) when there were already two elements. IllegalStateException
     * should be thrown.
     */
    public void testAddAnchorSizeLimit() {
        // the list contains two elements
        instance.addAnchor(anchor1);
        instance.addAnchor(anchor2);

        try {
            instance.addAnchor(new GraphConnector());
            fail("IllegalStateException should be thrown");
        } catch (IllegalStateException ex) {
            // pass
        }
    }

    /**
     * Tests method addAnchor(GraphConnector) with null value when there were already two elements.
     * IllegalStateException should be thrown.
     */
    public void testAddAnchorNullSizeLimit() {
        // the list contains two elements
        instance.addAnchor(anchor1);
        instance.addAnchor(anchor2);

        try {
            instance.addAnchor(null);
            fail("IllegalStateException should be thrown");
        } catch (IllegalStateException ex) {
            // pass
        }
    }

    /**
     * Tests method addAnchor(int, GraphConnector) with elements to be inserted at the tail of list. The
     * elements should be contained in correct order.
     */
    public void testAddAnchorIndexAppend() {
        // add two elements at the tail
        instance.addAnchor(0, anchor1);
        instance.addAnchor(1, anchor2);

        assertEquals("two elements expected", 2, instance.countAnchors());
        assertEquals("the index of anchor 1 should be 0", 0, instance.indexOfAnchor(anchor1));
        assertEquals("the index of anchor 2 should be 1", 1, instance.indexOfAnchor(anchor2));
    }

    /**
     * Tests method addAnchor(int, GraphConnector) with elements to be inserted at the head of list. The
     * elements should be contained in correct order.
     */
    public void testAddAnchorIndexInsert() {
        // add two elements at the head
        instance.addAnchor(0, anchor1);
        instance.addAnchor(0, anchor2);

        assertEquals("two elements expected", 2, instance.countAnchors());
        assertEquals("the index of anchor 1 should be 1", 1, instance.indexOfAnchor(anchor1));
        assertEquals("the index of anchor 2 should be 0", 0, instance.indexOfAnchor(anchor2));
    }

    /**
     * Tests method addAnchor(int, GraphConnector) with null value. IllegalArgumentException should be thrown.
     */
    public void testAddAnchorIndexNull() {
        try {
            instance.addAnchor(0, null);
            fail("IllegalArgumentException should be thrown");
        } catch (IllegalArgumentException ex) {
            // pass
        }
    }

    /**
     * Tests method addAnchor(int, GraphConnector) with duplicate elements. Duplicate elements should be
     * allowed.
     */
    public void testAddAnchorIndexDuplicate() {
        // insert an element twice
        instance.addAnchor(0, anchor1);
        instance.addAnchor(0, anchor1);

        assertEquals("two elements expected", 2, instance.countAnchors());
    }

    /**
     * Tests method addAnchor(int, GraphConnector) with negative index. IllegalArgumentException should be
     * thrown.
     */
    public void testAddAnchorIndexNegative() {
        try {
            instance.addAnchor(-1, anchor1);
            fail("IllegalArgumentException should be thrown");
        } catch (IllegalArgumentException ex) {
            // pass
        }
    }

    /**
     * Tests method addAnchor(int, GraphConnector) with index larger than size. IllegalArgumentException
     * should be thrown.
     */
    public void testAddAnchorIndexLarger() {
        try {
            instance.addAnchor(1, anchor1);
            fail("IllegalArgumentException should be thrown");
        } catch (IllegalArgumentException ex) {
            // pass
        }
    }

    /**
     * Tests method addAnchor(int, GraphConnector) when there were already two elements. IllegalStateException
     * should be thrown.
     */
    public void testAddAnchorIndexSizeLimit() {
        // the list contains two elements
        instance.addAnchor(anchor1);
        instance.addAnchor(anchor2);

        try {
            instance.addAnchor(0, new GraphConnector());
            fail("IllegalStateException should be thrown");
        } catch (IllegalStateException ex) {
            // pass
        }
    }

    /**
     * Tests method addAnchor(int, GraphConnector) with index out of range when there were already two
     * elements. Since the size is checked first, IllegalStateException should be thrown.
     */
    public void testAddAnchorIndexOutOfRangeSizeLimit() {
        // the list contains two elements
        instance.addAnchor(anchor1);
        instance.addAnchor(anchor2);

        try {
            instance.addAnchor(TOO_BIG_INDEX, new GraphConnector());
            fail("IllegalStateException should be thrown");
        } catch (IllegalStateException ex) {
            // pass
        }
    }

    /**
     * Tests method addAnchor(int, GraphConnector) with null value when there were already two elements. Since
     * the size is checked first, IllegalStateException should be thrown.
     */
    public void testAddAnchorIndexNullSizeLimit() {
        // the list contains two elements
        instance.addAnchor(anchor1);
        instance.addAnchor(anchor2);

        try {
            instance.addAnchor(0, null);
            fail("IllegalStateException should be thrown");
        } catch (IllegalStateException ex) {
            // pass
        }
    }

    /**
     * Tests method setAnchor. The element should be updated properly.
     */
    public void testSetAnchor() {
        // the list contains one element
        instance.addAnchor(anchor1);

        assertEquals("one element expected", 1, instance.countAnchors());
        assertEquals("the index of anchor 1 should be 0", 0, instance.indexOfAnchor(anchor1));

        instance.setAnchor(0, anchor2);

        assertEquals("one element expected", 1, instance.countAnchors());
        assertEquals("the index of anchor 2 should be 0", 0, instance.indexOfAnchor(anchor2));
    }

    /**
     * Tests method setAnchor with null value. IllegalArgumentException should be thrown.
     */
    public void testSetAnchorNull() {
        // the list contains one element
        instance.addAnchor(anchor1);

        try {
            instance.setAnchor(0, null);
            fail("IllegalArgumentException should be thrown");
        } catch (IllegalArgumentException ex) {
            // pass
        }
    }

    /**
     * Tests method setAnchor with duplicate elements. Duplicate elements should be allowed.
     */
    public void testSetAnchorDuplicate() {
        // the list contains two elements
        instance.addAnchor(anchor1);
        instance.addAnchor(anchor2);

        // replace the second element with the first one
        instance.setAnchor(1, anchor1);

        assertEquals("two elements expected", 2, instance.countAnchors());
        assertFalse("the anchor 2 should have been replaced", instance.containsAnchor(anchor2));
    }

    /**
     * Tests method setAnchor with negative index. IllegalArgumentException should be thrown.
     */
    public void testSetAnchorNegative() {
        try {
            instance.setAnchor(-1, anchor1);
            fail("IllegalArgumentException should be thrown");
        } catch (IllegalArgumentException ex) {
            // pass
        }
    }

    /**
     * Tests method setAnchor with index larger than size-1. IllegalArgumentException should be thrown.
     */
    public void testSetAnchorLarger() {
        // the list contains one element
        instance.addAnchor(anchor1);

        try {
            instance.setAnchor(1, anchor1);
            fail("IllegalArgumentException should be thrown");
        } catch (IllegalArgumentException ex) {
            // pass
        }
    }

    /**
     * Tests method removeAnchor(int). The element should be removed properly.
     */
    public void testRemoveAnchorIndex() {
        // the list contains two elements
        instance.addAnchor(anchor1);
        instance.addAnchor(anchor2);

        // remove the first one
        GraphConnector removed = instance.removeAnchor(0);

        assertEquals("the anchor 1 should be returned", removed, anchor1);
        assertEquals("one element expected", 1, instance.countAnchors());
        assertFalse("the anchor 1 should have been removed", instance.containsAnchor(anchor1));
        assertEquals("the index of anchor 2 should be 0", 0, instance.indexOfAnchor(anchor2));
    }

    /**
     * Tests method removeAnchor(int) with negative index. IllegalArgumentException should be thrown.
     */
    public void testRemoveAnchorIndexNegative() {
        try {
            instance.removeAnchor(-1);
            fail("IllegalArgumentException should be thrown");
        } catch (IllegalArgumentException ex) {
            // pass
        }
    }

    /**
     * Tests method removeAnchor(int) with index larger than size-1. IllegalArgumentException should be
     * thrown.
     */
    public void testRemoveAnchorIndexLarger() {
        try {
            instance.removeAnchor(0);
            fail("IllegalArgumentException should be thrown");
        } catch (IllegalArgumentException ex) {
            // pass
        }
    }

    /**
     * Tests method removeAnchor(GraphConnector). The elements should be removed properly.
     */
    public void testRemoveAnchor() {
        // the list contains two elements
        instance.addAnchor(anchor1);
        instance.addAnchor(anchor2);

        // remove one element
        boolean removed = instance.removeAnchor(anchor1);

        assertTrue("the anchor 1 should be returned", removed);
        assertEquals("one element expected", 1, instance.countAnchors());
        assertFalse("the anchor 1 should have been removed", instance.containsAnchor(anchor1));
        assertEquals("the index of anchor 2 should be 0", 0, instance.indexOfAnchor(anchor2));

        // remove another element
        removed = instance.removeAnchor(anchor2);

        assertTrue("the anchor 2 should be returned", removed);
        assertEquals("no element expected", 0, instance.countAnchors());
        assertFalse("the anchor 2 should have been removed", instance.containsAnchor(anchor2));
    }

    /**
     * Tests method removeAnchor(GraphConnector) with nonexistent element. The method should return false.
     */
    public void testRemoveAnchorNonexist() {
        assertFalse("false expected", instance.removeAnchor(anchor1));
    }

    /**
     * Tests method removeAnchor(GraphConnector) with null value. IllegalArgumentException should be thrown.
     */
    public void testRemoveAnchorNull() {
        try {
            instance.removeAnchor(null);
            fail("IllegalArgumentException should be thrown");
        } catch (IllegalArgumentException ex) {
            // pass
        }
    }

    /**
     * Tests method removeAnchor(GraphConnector) with duplicate elements. Only the first occurrence should be removed.
     */
    public void testRemoveAnchorDuplicate() {
        // the list contains duplicate elements
        instance.addAnchor(anchor1);
        instance.addAnchor(anchor1);

        // remove the element
        instance.removeAnchor(anchor1);

        assertEquals("one element expected", 1, instance.countAnchors());
        assertEquals("the index of anchor 1 should be 0", 0, instance.indexOfAnchor(anchor1));
    }

    /**
     * Tests method clearAnchors. The elements should be removed properly.
     */
    public void testClearAnchors() {
        // the list contains two elements
        instance.addAnchor(anchor1);
        instance.addAnchor(anchor2);

        instance.clearAnchors();

        assertEquals("no element expected", 0, instance.countAnchors());
    }

    /**
     * Tests method getAnchors. The method should return a copy of list containing all the elements.
     */
    public void testGetAnchors() {
        // the list contains two elements
        instance.addAnchor(anchor1);
        instance.addAnchor(anchor2);

        List<GraphConnector> list = instance.getAnchors();

        assertEquals("two elements expected", 2, list.size());
        assertEquals("the index of anchor 1 should be 0", 0, list.indexOf(anchor1));
        assertEquals("the index of anchor 2 should be 1", 1, list.indexOf(anchor2));

        // remove all the elements in the instance
        instance.clearAnchors();

        // the return list doesn't change since it is just a copy
        assertEquals("two elements expected", 2, list.size());
    }

    /**
     * Tests method containsAnchor. The method should return true for contained element.
     */
    public void testContainsAnchor() {
        // the list contains one element
        instance.addAnchor(anchor1);

        assertTrue("true expected", instance.containsAnchor(anchor1));
    }

    /**
     * Tests method containsAnchor with nonexistent element. The method should return false.
     */
    public void testContainsAnchorNonexist() {
        assertFalse("false expected", instance.containsAnchor(anchor1));
    }

    /**
     * Tests method containsAnchor with null value. IllegalArgumentException should be thrown.
     */
    public void testContainsAnchorNull() {
        try {
            instance.containsAnchor(null);
            fail("IllegalArgumentException should be thrown");
        } catch (IllegalArgumentException ex) {
            // pass
        }
    }

    /**
     * Tests method indexOfAnchor. The index should be correct for each element.
     */
    public void testIndexOfAnchor() {
        // the list contains two elements
        instance.addAnchor(anchor1);
        instance.addAnchor(anchor2);

        assertEquals("the index of anchor 1 should be 0", 0, instance.indexOfAnchor(anchor1));
        assertEquals("the index of anchor 2 should be 1", 1, instance.indexOfAnchor(anchor2));
    }

    /**
     * Tests method indexOfAnchor with nonexistent element. The method should return -1.
     */
    public void testIndexOfAnchorNonexist() {
        assertEquals("-1 expected", -1, instance.indexOfAnchor(anchor1));
    }

    /**
     * Tests method indexOfAnchor with null value. IllegalArgumentException should be thrown.
     */
    public void testIndexOfAnchorNull() {
        try {
            instance.indexOfAnchor(null);
            fail("IllegalArgumentException should be thrown");
        } catch (IllegalArgumentException ex) {
            // pass
        }
    }

    /**
     * Tests method indexOfAnchor with duplicate elements. The method should return the index of the first
     * occurrence.
     */
    public void testIndexOfAnchorDuplicate() {
        // the list contains duplicate elements
        instance.addAnchor(anchor1);
        instance.addAnchor(anchor1);

        assertEquals("the index of anchor 1 should be 0", 0, instance.indexOfAnchor(anchor1));
    }

    /**
     * Tests method countAnchors. The method should return the size of elements.
     */
    public void testCountAnchors() {
        assertEquals("no element expected", 0, instance.countAnchors());

        // add a element
        instance.addAnchor(anchor1);

        assertEquals("one element expected", 1, instance.countAnchors());

        // remove the element
        instance.removeAnchor(anchor1);

        assertEquals("no element expected", 0, instance.countAnchors());
    }
}