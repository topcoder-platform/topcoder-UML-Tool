/*
 * Copyright (C) 2006 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.diagraminterchange;

import java.util.Collection;

import junit.framework.TestCase;

/**
 * <p>
 * Unit tests for class Diagram.
 * </p>
 *
 * @author TCSDEVELOPER
 * @version 1.0
 */
public class DiagramTest extends TestCase {

    /**
     * An instance of DiagramLink for testing.
     */
    private DiagramLink diagramLink1;

    /**
     * An instance of DiagramLink for testing.
     */
    private DiagramLink diagramLink2;

    /**
     * An instance of Diagram for testing.
     */
    private Diagram instance;

    /**
     * Sets up the environment. Creates an instance of Diagram.
     */
    protected void setUp() {
        diagramLink1 = new DiagramLink();
        diagramLink2 = new DiagramLink();

        instance = new Diagram();
    }

    /**
     * Tests the constructor. All the fields should be initiated properly.
     */
    public void testDiagramCtor() {
        assertNotNull("fail to construct the instance", instance);

        assertNull("null expected", instance.getName());
        assertTrue("zero expected", TestHelper.DEFAULT_DOUBLE == instance.getZoom());
        assertNull("null expected", instance.getViewport());
        assertNull("null expected", instance.getOwner());

        assertEquals("empty expected", 0, instance.countDiagramLinks());
    }

    /**
     * Tests method getName. The correspond field should be returned properly.
     */
    public void testGetName() {
        String[] strings = TestHelper.getRandomStrings();

        for (String item : strings) {
            instance.setName(item);
            assertEquals("incorrect string", item, instance.getName());
        }
    }

    /**
     * Tests method setName. The correspond field should be updated properly.
     */
    public void testSetName() {
        String[] strings = TestHelper.getRandomStrings();

        for (String item : strings) {
            instance.setName(item);
            assertEquals("incorrect string", item, instance.getName());
        }
    }

    /**
     * Tests method setName with null value. Null value should be allowed.
     */
    public void testSetNameNull() {
        instance.setName(null);
        assertNull("null value should be allowed", instance.getName());
    }

    /**
     * Tests method setName with empty value. Empty value should be allowed.
     */
    public void testSetNameEmpty() {
        instance.setName(TestHelper.EMPTY_STRING);
        assertEquals("empty value should be allowed", TestHelper.EMPTY_STRING, instance.getName());
    }

    /**
     * Tests method getZoom. The correspond field should be returned properly.
     */
    public void testGetZoom() {
        double[] doubles = TestHelper.getRandomDoubles();

        for (double item : doubles) {
            instance.setZoom(item);
            assertTrue("incorrect double value", item == instance.getZoom());
        }
    }

    /**
     * Tests method setZoom. The correspond field should be updated properly.
     */
    public void testSetZoom() {
        double[] doubles = TestHelper.getRandomDoubles();

        for (double item : doubles) {
            instance.setZoom(item);
            assertTrue("incorrect double value", item == instance.getZoom());
        }
    }

    /**
     * Tests method getViewport. The correspond field should be returned properly.
     */
    public void testGetViewport() {
        Point point = new Point();
        instance.setViewport(point);
        assertEquals("incorrect Viewport", point, instance.getViewport());
    }

    /**
     * Tests method setViewport. The correspond field should be updated properly.
     */
    public void testSetViewport() {
        Point point = new Point();
        instance.setViewport(point);
        assertEquals("incorrect Viewport", point, instance.getViewport());
    }

    /**
     * Tests method setViewport with null value. Null value should be allowed.
     */
    public void testSetViewportNull() {
        instance.setViewport(null);
        assertNull("null value should be allowed", instance.getViewport());
    }

    /**
     * Tests method getOwner. The correspond field should be returned properly.
     */
    public void testGetOwner() {
        SemanticModelBridge bridge = new MockSemanticModelBridge();
        instance.setOwner(bridge);
        assertEquals("incorrect Owner", bridge, instance.getOwner());
    }

    /**
     * Tests method setOwner. The correspond field should be updated properly.
     */
    public void testSetOwner() {
        SemanticModelBridge bridge = new MockSemanticModelBridge();
        instance.setOwner(bridge);
        assertEquals("incorrect Owner", bridge, instance.getOwner());
    }

    /**
     * Tests method setOwner with null value. Null value should be allowed.
     */
    public void testSetOwnerNull() {
        instance.setOwner(null);
        assertNull("null value should be allowed", instance.getOwner());
    }

    /**
     * Tests method addDiagramLink. The elements should be contained in correct order.
     */
    public void testAddDiagramLink() {
        instance.addDiagramLink(diagramLink1);

        assertEquals("one element expected", 1, instance.countDiagramLinks());
        assertTrue("diagramLink 1 should be added", instance.containsDiagramLink(diagramLink1));

        instance.addDiagramLink(diagramLink2);

        assertEquals("two elements expected", 2, instance.countDiagramLinks());
        assertTrue("diagramLink 2 should be added", instance.containsDiagramLink(diagramLink2));
    }

    /**
     * Tests method addDiagramLink with null value. IllegalArgumentException should be thrown.
     */
    public void testAddDiagramLinkNull() {
        try {
            instance.addDiagramLink(null);
            fail("IllegalArgumentException should be thrown");
        } catch (IllegalArgumentException ex) {
            // pass
        }
    }

    /**
     * Tests method addDiagramLink with duplicate elements. Duplicate elements should be allowed.
     */
    public void testAddDiagramLinkDuplicate() {
        // append an element twice
        instance.addDiagramLink(diagramLink1);
        instance.addDiagramLink(diagramLink1);

        assertEquals("two elements expected", 2, instance.countDiagramLinks());
    }

    /**
     * Tests method removeDiagramLink. The elements should be removed properly.
     */
    public void testRemoveDiagramLink() {
        // the collection contains two elements
        instance.addDiagramLink(diagramLink1);
        instance.addDiagramLink(diagramLink2);

        // remove one element
        boolean removed = instance.removeDiagramLink(diagramLink1);

        assertTrue("the diagramLink 1 should be returned", removed);
        assertEquals("one element expected", 1, instance.countDiagramLinks());
        assertFalse("the diagramLink 1 should have been removed", instance.containsDiagramLink(diagramLink1));

        // remove another element
        removed = instance.removeDiagramLink(diagramLink2);

        assertTrue("the diagramLink 2 should be returned", removed);
        assertEquals("no element expected", 0, instance.countDiagramLinks());
        assertFalse("the diagramLink 2 should have been removed", instance.containsDiagramLink(diagramLink2));
    }

    /**
     * Tests method removeDiagramLink with nonexistent element. The method should return false.
     */
    public void testRemoveDiagramLinkNonexist() {
        assertFalse("false expected", instance.removeDiagramLink(diagramLink1));
    }

    /**
     * Tests method removeDiagramLink with null value. IllegalArgumentException should be thrown.
     */
    public void testRemoveDiagramLinkNull() {
        try {
            instance.removeDiagramLink(null);
            fail("IllegalArgumentException should be thrown");
        } catch (IllegalArgumentException ex) {
            // pass
        }
    }

    /**
     * Tests method removeDiagramLink with duplicate elements. Only the first occurrence should be removed.
     */
    public void testRemoveDiagramLinkDuplicate() {
        // the collection contains duplicate elements
        instance.addDiagramLink(diagramLink1);
        instance.addDiagramLink(diagramLink1);

        // remove the element
        instance.removeDiagramLink(diagramLink1);

        assertEquals("one element expected", 1, instance.countDiagramLinks());
    }

    /**
     * Tests method clearDiagramLinks. The elements should be removed properly.
     */
    public void testClearDiagramLinks() {
        // the collection contains two elements
        instance.addDiagramLink(diagramLink1);
        instance.addDiagramLink(diagramLink2);

        instance.clearDiagramLinks();

        assertEquals("no element expected", 0, instance.countDiagramLinks());
    }

    /**
     * Tests method getDiagramLinks. The method should return a copy of collection containing all the
     * elements.
     */
    public void testGetDiagramLinks() {
        // the collection contains two elements
        instance.addDiagramLink(diagramLink1);
        instance.addDiagramLink(diagramLink2);

        Collection<DiagramLink> collection = instance.getDiagramLinks();

        assertEquals("two elements expected", 2, collection.size());
        assertTrue("diagramLink 1 should be contained", collection.contains(diagramLink1));
        assertTrue("diagramLink 2 should be contained", collection.contains(diagramLink2));

        // remove all the elements in the instance
        instance.clearDiagramLinks();

        // the return collection doesn't change since it is just a copy
        assertEquals("two elements expected", 2, collection.size());
    }

    /**
     * Tests method containsDiagramLink. The method should return true for contained element.
     */
    public void testContainsDiagramLink() {
        // the collection contains one element
        instance.addDiagramLink(diagramLink1);

        assertTrue("true expected", instance.containsDiagramLink(diagramLink1));
    }

    /**
     * Tests method containsDiagramLink with nonexistent element. The method should return false.
     */
    public void testContainsDiagramLinkNonexist() {
        assertFalse("false expected", instance.containsDiagramLink(diagramLink1));
    }

    /**
     * Tests method containsDiagramLink with null value. IllegalArgumentException should be thrown.
     */
    public void testContainsDiagramLinkNull() {
        try {
            instance.containsDiagramLink(null);
            fail("IllegalArgumentException should be thrown");
        } catch (IllegalArgumentException ex) {
            // pass
        }
    }

    /**
     * Tests method countDiagramLinks. The method should return the size of elements.
     */
    public void testCountDiagramLinks() {
        assertEquals("no element expected", 0, instance.countDiagramLinks());

        // add a element
        instance.addDiagramLink(diagramLink1);

        assertEquals("one element expected", 1, instance.countDiagramLinks());

        // remove the element
        instance.removeDiagramLink(diagramLink1);

        assertEquals("no element expected", 0, instance.countDiagramLinks());
    }
}