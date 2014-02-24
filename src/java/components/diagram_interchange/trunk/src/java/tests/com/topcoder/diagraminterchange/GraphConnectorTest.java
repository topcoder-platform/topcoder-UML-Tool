/*
 * Copyright (C) 2006 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.diagraminterchange;

import java.util.Collection;

import junit.framework.TestCase;

/**
 * <p>
 * Unit tests for class GraphConnector.
 * </p>
 *
 * @author TCSDEVELOPER
 * @version 1.0
 */
public class GraphConnectorTest extends TestCase {

    /**
     * An instance of GraphEdge for testing.
     */
    private GraphEdge graphEdge1;

    /**
     * An instance of GraphEdge for testing.
     */
    private GraphEdge graphEdge2;

    /**
     * An instance of GraphConnector for testing.
     */
    private GraphConnector instance;

    /**
     * Sets up the environment. Creates an instance of GraphConnector.
     */
    protected void setUp() {
        graphEdge1 = new GraphEdge();
        graphEdge2 = new GraphEdge();

        instance = new GraphConnector();
    }

    /**
     * Tests the constructor. All the fields should be initiated properly.
     */
    public void testGraphConnectorCtor() {
        assertNotNull("fail to construct the instance", instance);

        assertNull("null expected", instance.getPosition());
        assertNull("null expected", instance.getGraphElement());

        assertEquals("empty expected", 0, instance.countGraphEdges());
    }

    /**
     * Tests method getPosition. The correspond field should be returned properly.
     */
    public void testGetPosition() {
        Point point = new Point();
        instance.setPosition(point);
        assertEquals("incorrect Position", point, instance.getPosition());
    }

    /**
     * Tests method setPosition. The correspond field should be updated properly.
     */
    public void testSetPosition() {
        Point point = new Point();
        instance.setPosition(point);
        assertEquals("incorrect Position", point, instance.getPosition());
    }

    /**
     * Tests method setPosition with null value. Null value should be allowed.
     */
    public void testSetPositionNull() {
        instance.setPosition(null);
        assertNull("null value should be allowed", instance.getPosition());
    }

    /**
     * Tests method getGraphElement. The correspond field should be returned properly.
     */
    public void testGetGraphElement() {
        GraphElement graphElement = new MockGraphElement();
        instance.setGraphElement(graphElement);
        assertEquals("incorrect GraphElement", graphElement, instance.getGraphElement());
    }

    /**
     * Tests method setGraphElement. The correspond field should be updated properly.
     */
    public void testSetGraphElement() {
        GraphElement graphElement = new MockGraphElement();
        instance.setGraphElement(graphElement);
        assertEquals("incorrect GraphElement", graphElement, instance.getGraphElement());
    }

    /**
     * Tests method setGraphElement with null value. Null value should be allowed.
     */
    public void testSetGraphElementNull() {
        instance.setGraphElement(null);
        assertNull("null value should be allowed", instance.getGraphElement());
    }

    /**
     * Tests method addGraphEdge. The elements should be contained in correct order.
     */
    public void testAddGraphEdge() {
        instance.addGraphEdge(graphEdge1);

        assertEquals("one element expected", 1, instance.countGraphEdges());
        assertTrue("graphEdge 1 should be added", instance.containsGraphEdge(graphEdge1));

        instance.addGraphEdge(graphEdge2);

        assertEquals("two elements expected", 2, instance.countGraphEdges());
        assertTrue("graphEdge 2 should be added", instance.containsGraphEdge(graphEdge2));
    }

    /**
     * Tests method addGraphEdge with null value. IllegalArgumentException should be thrown.
     */
    public void testAddGraphEdgeNull() {
        try {
            instance.addGraphEdge(null);
            fail("IllegalArgumentException should be thrown");
        } catch (IllegalArgumentException ex) {
            // pass
        }
    }

    /**
     * Tests method addGraphEdge with duplicate elements. Duplicate elements should be allowed.
     */
    public void testAddGraphEdgeDuplicate() {
        // append an element twice
        instance.addGraphEdge(graphEdge1);
        instance.addGraphEdge(graphEdge1);

        assertEquals("two elements expected", 2, instance.countGraphEdges());
    }

    /**
     * Tests method removeGraphEdge. The elements should be removed properly.
     */
    public void testRemoveGraphEdge() {
        // the collection contains two elements
        instance.addGraphEdge(graphEdge1);
        instance.addGraphEdge(graphEdge2);

        // remove one element
        boolean removed = instance.removeGraphEdge(graphEdge1);

        assertTrue("the graphEdge 1 should be returned", removed);
        assertEquals("one element expected", 1, instance.countGraphEdges());
        assertFalse("the graphEdge 1 should have been removed", instance.containsGraphEdge(graphEdge1));

        // remove another element
        removed = instance.removeGraphEdge(graphEdge2);

        assertTrue("the graphEdge 2 should be returned", removed);
        assertEquals("no element expected", 0, instance.countGraphEdges());
        assertFalse("the graphEdge 2 should have been removed", instance.containsGraphEdge(graphEdge2));
    }

    /**
     * Tests method removeGraphEdge with nonexistent element. The method should return false.
     */
    public void testRemoveGraphEdgeNonexist() {
        assertFalse("false expected", instance.removeGraphEdge(graphEdge1));
    }

    /**
     * Tests method removeGraphEdge with null value. IllegalArgumentException should be thrown.
     */
    public void testRemoveGraphEdgeNull() {
        try {
            instance.removeGraphEdge(null);
            fail("IllegalArgumentException should be thrown");
        } catch (IllegalArgumentException ex) {
            // pass
        }
    }

    /**
     * Tests method removeGraphEdge with duplicate elements. Only the first occurrence should be removed.
     */
    public void testRemoveGraphEdgeDuplicate() {
        // the collection contains duplicate elements
        instance.addGraphEdge(graphEdge1);
        instance.addGraphEdge(graphEdge1);

        // remove the element
        instance.removeGraphEdge(graphEdge1);

        assertEquals("one element expected", 1, instance.countGraphEdges());
    }

    /**
     * Tests method clearGraphEdges. The elements should be removed properly.
     */
    public void testClearGraphEdges() {
        // the collection contains two elements
        instance.addGraphEdge(graphEdge1);
        instance.addGraphEdge(graphEdge2);

        instance.clearGraphEdges();

        assertEquals("no element expected", 0, instance.countGraphEdges());
    }

    /**
     * Tests method getGraphEdges. The method should return a copy of collection containing all the elements.
     */
    public void testGetGraphEdges() {
        // the collection contains two elements
        instance.addGraphEdge(graphEdge1);
        instance.addGraphEdge(graphEdge2);

        Collection<GraphEdge> collection = instance.getGraphEdges();

        assertEquals("two elements expected", 2, collection.size());
        assertTrue("graphEdge 1 should be contained", collection.contains(graphEdge1));
        assertTrue("graphEdge 2 should be contained", collection.contains(graphEdge2));

        // remove all the elements in the instance
        instance.clearGraphEdges();

        // the return collection doesn't change since it is just a copy
        assertEquals("two elements expected", 2, collection.size());
    }

    /**
     * Tests method containsGraphEdge. The method should return true for contained element.
     */
    public void testContainsGraphEdge() {
        // the collection contains one element
        instance.addGraphEdge(graphEdge1);

        assertTrue("true expected", instance.containsGraphEdge(graphEdge1));
    }

    /**
     * Tests method containsGraphEdge with nonexistent element. The method should return false.
     */
    public void testContainsGraphEdgeNonexist() {
        assertFalse("false expected", instance.containsGraphEdge(graphEdge1));
    }

    /**
     * Tests method containsGraphEdge with null value. IllegalArgumentException should be thrown.
     */
    public void testContainsGraphEdgeNull() {
        try {
            instance.containsGraphEdge(null);
            fail("IllegalArgumentException should be thrown");
        } catch (IllegalArgumentException ex) {
            // pass
        }
    }

    /**
     * Tests method countGraphEdges. The method should return the size of elements.
     */
    public void testCountGraphEdges() {
        assertEquals("no element expected", 0, instance.countGraphEdges());

        // add a element
        instance.addGraphEdge(graphEdge1);

        assertEquals("one element expected", 1, instance.countGraphEdges());

        // remove the element
        instance.removeGraphEdge(graphEdge1);

        assertEquals("no element expected", 0, instance.countGraphEdges());
    }
}