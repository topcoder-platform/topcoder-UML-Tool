/*
 * Copyright (C) 2006 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.diagraminterchange;

import java.util.Collection;
import java.util.List;

import junit.framework.TestCase;

/**
 * <p>
 * Unit tests for class GraphElement. Since GraphElement is an abstract class, A mock concrete class is
 * provided to extend it for testing.
 * </p>
 *
 * @author TCSDEVELOPER
 * @version 1.0
 */
public class GraphElementTest extends TestCase {

    /**
     * An instance of DiagramLink for testing.
     */
    private DiagramLink diagramLink1;

    /**
     * An instance of DiagramLink for testing.
     */
    private DiagramLink diagramLink2;

    /**
     * An instance of DiagramElement for testing.
     */
    private DiagramElement diagramElement1;

    /**
     * An instance of DiagramElement for testing.
     */
    private DiagramElement diagramElement2;

    /**
     * An instance of GraphConnector for testing.
     */
    private GraphConnector anchorage1;

    /**
     * An instance of GraphConnector for testing.
     */
    private GraphConnector anchorage2;

    /**
     * An instance of GraphElement for testing.
     */
    private GraphElement instance;

    /**
     * Sets up the environment. Creates an instance of GraphElement.
     */
    protected void setUp() {
        diagramLink1 = new DiagramLink();
        diagramLink2 = new DiagramLink();
        diagramElement1 = new MockDiagramElement();
        diagramElement2 = new MockDiagramElement();
        anchorage1 = new GraphConnector();
        anchorage2 = new GraphConnector();

        instance = new MockGraphElement();
    }

    /**
     * Tests the constructor. All the fields should be initiated properly.
     */
    public void testGraphElementCtor() {
        assertNotNull("fail to construct the instance", instance);

        assertNull("null expected", instance.getPosition());
        assertNull("null expected", instance.getSemanticModel());

        assertEquals("empty expected", 0, instance.countContaineds());
        assertEquals("empty expected", 0, instance.countAnchorages());
        assertEquals("empty expected", 0, instance.countLinks());
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
     * Tests method getSemanticModel. The correspond field should be returned properly.
     */
    public void testGetSemanticModel() {
        SemanticModelBridge bridge = new MockSemanticModelBridge();
        instance.setSemanticModel(bridge);
        assertEquals("incorrect SemanticModel", bridge, instance.getSemanticModel());
    }

    /**
     * Tests method setSemanticModel. The correspond field should be updated properly.
     */
    public void testSetSemanticModel() {
        SemanticModelBridge bridge = new MockSemanticModelBridge();
        instance.setSemanticModel(bridge);
        assertEquals("incorrect SemanticModel", bridge, instance.getSemanticModel());
    }

    /**
     * Tests method setSemanticModel with null value. Null value should be allowed.
     */
    public void testSetSemanticModelNull() {
        instance.setSemanticModel(null);
        assertNull("null value should be allowed", instance.getSemanticModel());
    }

    /**
     * Tests method addLink. The elements should be contained in correct order.
     */
    public void testAddLink() {
        instance.addLink(diagramLink1);

        assertEquals("one element expected", 1, instance.countLinks());
        assertTrue("diagramLink 1 should be added", instance.containsLink(diagramLink1));

        instance.addLink(diagramLink2);

        assertEquals("two elements expected", 2, instance.countLinks());
        assertTrue("diagramLink 2 should be added", instance.containsLink(diagramLink2));
    }

    /**
     * Tests method addLink with null value. IllegalArgumentException should be thrown.
     */
    public void testAddLinkNull() {
        try {
            instance.addLink(null);
            fail("IllegalArgumentException should be thrown");
        } catch (IllegalArgumentException ex) {
            // pass
        }
    }

    /**
     * Tests method addLink with duplicate elements. Duplicate elements should be allowed.
     */
    public void testAddLinkDuplicate() {
        // append an element twice
        instance.addLink(diagramLink1);
        instance.addLink(diagramLink1);

        assertEquals("two elements expected", 2, instance.countLinks());
    }

    /**
     * Tests method removeLink. The elements should be removed properly.
     */
    public void testRemoveLink() {
        // the collection contains two elements
        instance.addLink(diagramLink1);
        instance.addLink(diagramLink2);

        // remove one element
        boolean removed = instance.removeLink(diagramLink1);

        assertTrue("the diagramLink 1 should be returned", removed);
        assertEquals("one element expected", 1, instance.countLinks());
        assertFalse("the diagramLink 1 should have been removed", instance.containsLink(diagramLink1));

        // remove another element
        removed = instance.removeLink(diagramLink2);

        assertTrue("the diagramLink 2 should be returned", removed);
        assertEquals("no element expected", 0, instance.countLinks());
        assertFalse("the diagramLink 2 should have been removed", instance.containsLink(diagramLink2));
    }

    /**
     * Tests method removeLink with nonexistent element. The method should return false.
     */
    public void testRemoveLinkNonexist() {
        assertFalse("false expected", instance.removeLink(diagramLink1));
    }

    /**
     * Tests method removeLink with null value. IllegalArgumentException should be thrown.
     */
    public void testRemoveLinkNull() {
        try {
            instance.removeLink(null);
            fail("IllegalArgumentException should be thrown");
        } catch (IllegalArgumentException ex) {
            // pass
        }
    }

    /**
     * Tests method removeLink with duplicate elements. Only the first occurrence should be removed.
     */
    public void testRemoveLinkDuplicate() {
        // the collection contains duplicate elements
        instance.addLink(diagramLink1);
        instance.addLink(diagramLink1);

        // remove the element
        instance.removeLink(diagramLink1);

        assertEquals("one element expected", 1, instance.countLinks());
    }

    /**
     * Tests method clearLinks. The elements should be removed properly.
     */
    public void testClearLinks() {
        // the collection contains two elements
        instance.addLink(diagramLink1);
        instance.addLink(diagramLink2);

        instance.clearLinks();

        assertEquals("no element expected", 0, instance.countLinks());
    }

    /**
     * Tests method getLinks. The method should return a copy of collection containing all the elements.
     */
    public void testGetLinks() {
        // the collection contains two elements
        instance.addLink(diagramLink1);
        instance.addLink(diagramLink2);

        Collection<DiagramLink> collection = instance.getLinks();

        assertEquals("two elements expected", 2, collection.size());
        assertTrue("diagramLink 1 should be contained", collection.contains(diagramLink1));
        assertTrue("diagramLink 2 should be contained", collection.contains(diagramLink2));

        // remove all the elements in the instance
        instance.clearLinks();

        // the return collection doesn't change since it is just a copy
        assertEquals("two elements expected", 2, collection.size());
    }

    /**
     * Tests method containsLink. The method should return true for contained element.
     */
    public void testContainsLink() {
        // the collection contains one element
        instance.addLink(diagramLink1);

        assertTrue("true expected", instance.containsLink(diagramLink1));
    }

    /**
     * Tests method containsLink with nonexistent element. The method should return false.
     */
    public void testContainsLinkNonexist() {
        assertFalse("false expected", instance.containsLink(diagramLink1));
    }

    /**
     * Tests method containsLink with null value. IllegalArgumentException should be thrown.
     */
    public void testContainsLinkNull() {
        try {
            instance.containsLink(null);
            fail("IllegalArgumentException should be thrown");
        } catch (IllegalArgumentException ex) {
            // pass
        }
    }

    /**
     * Tests method countLinks. The method should return the size of elements.
     */
    public void testCountLinks() {
        assertEquals("no element expected", 0, instance.countLinks());

        // add a element
        instance.addLink(diagramLink1);

        assertEquals("one element expected", 1, instance.countLinks());

        // remove the element
        instance.removeLink(diagramLink1);

        assertEquals("no element expected", 0, instance.countLinks());
    }

    /**
     * Tests method addContained(DiagramElement). The elements should be contained in correct order.
     */
    public void testAddContained() {
        instance.addContained(diagramElement1);

        assertEquals("one element expected", 1, instance.countContaineds());
        assertEquals("the index of diagramElement 1 should be 0", 0, instance
            .indexOfContained(diagramElement1));

        instance.addContained(diagramElement2);

        assertEquals("two elements expected", 2, instance.countContaineds());
        assertEquals("the index of diagramElement 2 should be 1", 1, instance
            .indexOfContained(diagramElement2));
    }

    /**
     * Tests method addContained(DiagramElement) with null value. IllegalArgumentException should be thrown.
     */
    public void testAddContainedNull() {
        try {
            instance.addContained(null);
            fail("IllegalArgumentException should be thrown");
        } catch (IllegalArgumentException ex) {
            // pass
        }
    }

    /**
     * Tests method addContained(DiagramElement) with duplicate elements. Duplicate elements should be
     * allowed.
     */
    public void testAddContainedDuplicate() {
        // append an element twice
        instance.addContained(diagramElement1);
        instance.addContained(diagramElement1);

        assertEquals("two elements expected", 2, instance.countContaineds());
    }

    /**
     * Tests method addContained(int, DiagramElement) with elements to be inserted at the tail of list. The
     * elements should be contained in correct order.
     */
    public void testAddContainedIndexAppend() {
        // add two elements at the tail
        instance.addContained(0, diagramElement1);
        instance.addContained(1, diagramElement2);

        assertEquals("two elements expected", 2, instance.countContaineds());
        assertEquals("the index of diagramElement 1 should be 0", 0, instance
            .indexOfContained(diagramElement1));
        assertEquals("the index of diagramElement 2 should be 1", 1, instance
            .indexOfContained(diagramElement2));
    }

    /**
     * Tests method addContained(int, DiagramElement) with elements to be inserted at the head of list. The
     * elements should be contained in correct order.
     */
    public void testAddContainedIndexInsert() {
        // add two elements at the head
        instance.addContained(0, diagramElement1);
        instance.addContained(0, diagramElement2);

        assertEquals("two elements expected", 2, instance.countContaineds());
        assertEquals("the index of diagramElement 1 should be 1", 1, instance
            .indexOfContained(diagramElement1));
        assertEquals("the index of diagramElement 2 should be 0", 0, instance
            .indexOfContained(diagramElement2));
    }

    /**
     * Tests method addContained(int, DiagramElement) with null value. IllegalArgumentException should be
     * thrown.
     */
    public void testAddContainedIndexNull() {
        try {
            instance.addContained(0, null);
            fail("IllegalArgumentException should be thrown");
        } catch (IllegalArgumentException ex) {
            // pass
        }
    }

    /**
     * Tests method addContained(int, DiagramElement) with duplicate elements. Duplicate elements should be
     * allowed.
     */
    public void testAddContainedIndexDuplicate() {
        // insert an element twice
        instance.addContained(0, diagramElement1);
        instance.addContained(0, diagramElement1);

        assertEquals("two elements expected", 2, instance.countContaineds());
    }

    /**
     * Tests method addContained(int, DiagramElement) with negative index. IllegalArgumentException should be
     * thrown.
     */
    public void testAddContainedIndexNegative() {
        try {
            instance.addContained(-1, diagramElement1);
            fail("IllegalArgumentException should be thrown");
        } catch (IllegalArgumentException ex) {
            // pass
        }
    }

    /**
     * Tests method addContained(int, DiagramElement) with index larger than size. IllegalArgumentException
     * should be thrown.
     */
    public void testAddContainedIndexLarger() {
        try {
            instance.addContained(1, diagramElement1);
            fail("IllegalArgumentException should be thrown");
        } catch (IllegalArgumentException ex) {
            // pass
        }
    }

    /**
     * Tests method setContained. The element should be updated properly.
     */
    public void testSetContained() {
        // the list contains one element
        instance.addContained(diagramElement1);

        assertEquals("one element expected", 1, instance.countContaineds());
        assertEquals("the index of diagramElement 1 should be 0", 0, instance
            .indexOfContained(diagramElement1));

        instance.setContained(0, diagramElement2);

        assertEquals("one element expected", 1, instance.countContaineds());
        assertEquals("the index of diagramElement 2 should be 0", 0, instance
            .indexOfContained(diagramElement2));
    }

    /**
     * Tests method setContained with null value. IllegalArgumentException should be thrown.
     */
    public void testSetContainedNull() {
        // the list contains one element
        instance.addContained(diagramElement1);

        try {
            instance.setContained(0, null);
            fail("IllegalArgumentException should be thrown");
        } catch (IllegalArgumentException ex) {
            // pass
        }
    }

    /**
     * Tests method setContained with duplicate elements. Duplicate elements should be allowed.
     */
    public void testSetContainedDuplicate() {
        // the list contains two elements
        instance.addContained(diagramElement1);
        instance.addContained(diagramElement2);

        // replace the second element with the first one
        instance.setContained(1, diagramElement1);

        assertEquals("two elements expected", 2, instance.countContaineds());
        assertFalse("the diagramElement 2 should have been replaced", instance
            .containsContained(diagramElement2));
    }

    /**
     * Tests method setContained with negative index. IllegalArgumentException should be thrown.
     */
    public void testSetContainedNegative() {
        try {
            instance.setContained(-1, diagramElement1);
            fail("IllegalArgumentException should be thrown");
        } catch (IllegalArgumentException ex) {
            // pass
        }
    }

    /**
     * Tests method setContained with index larger than size-1. IllegalArgumentException should be thrown.
     */
    public void testSetContainedLarger() {
        // the list contains one element
        instance.addContained(diagramElement1);

        try {
            instance.setContained(1, diagramElement1);
            fail("IllegalArgumentException should be thrown");
        } catch (IllegalArgumentException ex) {
            // pass
        }
    }

    /**
     * Tests method removeContained(int). The element should be removed properly.
     */
    public void testRemoveContainedIndex() {
        // the list contains two elements
        instance.addContained(diagramElement1);
        instance.addContained(diagramElement2);

        // remove the first one
        DiagramElement removed = instance.removeContained(0);

        assertEquals("the diagramElement 1 should be returned", removed, diagramElement1);
        assertEquals("one element expected", 1, instance.countContaineds());
        assertFalse("the diagramElement 1 should have been removed", instance
            .containsContained(diagramElement1));
        assertEquals("the index of diagramElement 2 should be 0", 0, instance
            .indexOfContained(diagramElement2));
    }

    /**
     * Tests method removeContained(int) with negative index. IllegalArgumentException should be thrown.
     */
    public void testRemoveContainedIndexNegative() {
        try {
            instance.removeContained(-1);
            fail("IllegalArgumentException should be thrown");
        } catch (IllegalArgumentException ex) {
            // pass
        }
    }

    /**
     * Tests method removeContained(int) with index larger than size-1. IllegalArgumentException should be
     * thrown.
     */
    public void testRemoveContainedIndexLarger() {
        try {
            instance.removeContained(0);
            fail("IllegalArgumentException should be thrown");
        } catch (IllegalArgumentException ex) {
            // pass
        }
    }

    /**
     * Tests method removeContained(DiagramElement). The elements should be removed properly.
     */
    public void testRemoveContained() {
        // the list contains two elements
        instance.addContained(diagramElement1);
        instance.addContained(diagramElement2);

        // remove one element
        boolean removed = instance.removeContained(diagramElement1);

        assertTrue("the diagramElement 1 should be returned", removed);
        assertEquals("one element expected", 1, instance.countContaineds());
        assertFalse("the diagramElement 1 should have been removed", instance
            .containsContained(diagramElement1));
        assertEquals("the index of diagramElement 2 should be 0", 0, instance
            .indexOfContained(diagramElement2));

        // remove another element
        removed = instance.removeContained(diagramElement2);

        assertTrue("the diagramElement 2 should be returned", removed);
        assertEquals("no element expected", 0, instance.countContaineds());
        assertFalse("the diagramElement 2 should have been removed", instance
            .containsContained(diagramElement2));
    }

    /**
     * Tests method removeContained(DiagramElement) with nonexistent element. The method should return false.
     */
    public void testRemoveContainedNonexist() {
        assertFalse("false expected", instance.removeContained(diagramElement1));
    }

    /**
     * Tests method removeContained(DiagramElement) with null value. IllegalArgumentException should be
     * thrown.
     */
    public void testRemoveContainedNull() {
        try {
            instance.removeContained(null);
            fail("IllegalArgumentException should be thrown");
        } catch (IllegalArgumentException ex) {
            // pass
        }
    }

    /**
     * Tests method removeContained(DiagramElement) with duplicate elements. Only the first occurrence should
     * be removed.
     */
    public void testRemoveContainedDuplicate() {
        // the list contains duplicate elements
        instance.addContained(diagramElement1);
        instance.addContained(diagramElement2);
        instance.addContained(diagramElement1);

        // remove the element
        instance.removeContained(diagramElement1);

        assertEquals("two elements expected", 2, instance.countContaineds());
        assertEquals("the index of diagramElement 1 should be 1", 1, instance
            .indexOfContained(diagramElement1));
    }

    /**
     * Tests method clearContaineds. The elements should be removed properly.
     */
    public void testClearContaineds() {
        // the list contains two elements
        instance.addContained(diagramElement1);
        instance.addContained(diagramElement2);

        instance.clearContaineds();

        assertEquals("no element expected", 0, instance.countContaineds());
    }

    /**
     * Tests method getContaineds. The method should return a copy of list containing all the elements.
     */
    public void testGetContaineds() {
        // the list contains two elements
        instance.addContained(diagramElement1);
        instance.addContained(diagramElement2);

        List<DiagramElement> list = instance.getContaineds();

        assertEquals("two elements expected", 2, list.size());
        assertEquals("the index of diagramElement 1 should be 0", 0, list.indexOf(diagramElement1));
        assertEquals("the index of diagramElement 2 should be 1", 1, list.indexOf(diagramElement2));

        // remove all the elements in the instance
        instance.clearContaineds();

        // the return list doesn't change since it is just a copy
        assertEquals("two elements expected", 2, list.size());
    }

    /**
     * Tests method containsContained. The method should return true for contained element.
     */
    public void testContainsContained() {
        // the list contains one element
        instance.addContained(diagramElement1);

        assertTrue("true expected", instance.containsContained(diagramElement1));
    }

    /**
     * Tests method containsContained with nonexistent element. The method should return false.
     */
    public void testContainsContainedNonexist() {
        assertFalse("false expected", instance.containsContained(diagramElement1));
    }

    /**
     * Tests method containsContained with null value. IllegalArgumentException should be thrown.
     */
    public void testContainsContainedNull() {
        try {
            instance.containsContained(null);
            fail("IllegalArgumentException should be thrown");
        } catch (IllegalArgumentException ex) {
            // pass
        }
    }

    /**
     * Tests method indexOfContained. The index should be correct for each element.
     */
    public void testIndexOfContained() {
        // the list contains two elements
        instance.addContained(diagramElement1);
        instance.addContained(diagramElement2);

        assertEquals("the index of diagramElement 1 should be 0", 0, instance
            .indexOfContained(diagramElement1));
        assertEquals("the index of diagramElement 2 should be 1", 1, instance
            .indexOfContained(diagramElement2));
    }

    /**
     * Tests method indexOfContained with nonexistent element. The method should return -1.
     */
    public void testIndexOfContainedNonexist() {
        assertEquals("-1 expected", -1, instance.indexOfContained(diagramElement1));
    }

    /**
     * Tests method indexOfContained with null value. IllegalArgumentException should be thrown.
     */
    public void testIndexOfContainedNull() {
        try {
            instance.indexOfContained(null);
            fail("IllegalArgumentException should be thrown");
        } catch (IllegalArgumentException ex) {
            // pass
        }
    }

    /**
     * Tests method indexOfContained with duplicate elements. The method should return the index of the first
     * occurrence.
     */
    public void testIndexOfContainedDuplicate() {
        // the list contains duplicate elements
        instance.addContained(diagramElement1);
        instance.addContained(diagramElement1);

        assertEquals("the index of diagramElement 1 should be 0", 0, instance
            .indexOfContained(diagramElement1));
    }

    /**
     * Tests method countContaineds. The method should return the size of elements.
     */
    public void testCountContaineds() {
        assertEquals("no element expected", 0, instance.countContaineds());

        // add a element
        instance.addContained(diagramElement1);

        assertEquals("one element expected", 1, instance.countContaineds());

        // remove the element
        instance.removeContained(diagramElement1);

        assertEquals("no element expected", 0, instance.countContaineds());
    }

    /**
     * Tests method addAnchorage(GraphConnector). The elements should be contained in correct order.
     */
    public void testAddAnchorage() {
        instance.addAnchorage(anchorage1);

        assertEquals("one element expected", 1, instance.countAnchorages());
        assertEquals("the index of anchorage 1 should be 0", 0, instance.indexOfAnchorage(anchorage1));

        instance.addAnchorage(anchorage2);

        assertEquals("two elements expected", 2, instance.countAnchorages());
        assertEquals("the index of anchorage 2 should be 1", 1, instance.indexOfAnchorage(anchorage2));
    }

    /**
     * Tests method addAnchorage(GraphConnector) with null value. IllegalArgumentException should be thrown.
     */
    public void testAddAnchorageNull() {
        try {
            instance.addAnchorage(null);
            fail("IllegalArgumentException should be thrown");
        } catch (IllegalArgumentException ex) {
            // pass
        }
    }

    /**
     * Tests method addAnchorage(GraphConnector) with duplicate elements. Duplicate elements should be
     * allowed.
     */
    public void testAddAnchorageDuplicate() {
        // append an element twice
        instance.addAnchorage(anchorage1);
        instance.addAnchorage(anchorage1);

        assertEquals("two elements expected", 2, instance.countAnchorages());
    }

    /**
     * Tests method addAnchorage(int, GraphConnector) with elements to be inserted at the tail of list. The
     * elements should be contained in correct order.
     */
    public void testAddAnchorageIndexAppend() {
        // add two elements at the tail
        instance.addAnchorage(0, anchorage1);
        instance.addAnchorage(1, anchorage2);

        assertEquals("two elements expected", 2, instance.countAnchorages());
        assertEquals("the index of anchorage 1 should be 0", 0, instance.indexOfAnchorage(anchorage1));
        assertEquals("the index of anchorage 2 should be 1", 1, instance.indexOfAnchorage(anchorage2));
    }

    /**
     * Tests method addAnchorage(int, GraphConnector) with elements to be inserted at the head of list. The
     * elements should be contained in correct order.
     */
    public void testAddAnchorageIndexInsert() {
        // add two elements at the head
        instance.addAnchorage(0, anchorage1);
        instance.addAnchorage(0, anchorage2);

        assertEquals("two elements expected", 2, instance.countAnchorages());
        assertEquals("the index of anchorage 1 should be 1", 1, instance.indexOfAnchorage(anchorage1));
        assertEquals("the index of anchorage 2 should be 0", 0, instance.indexOfAnchorage(anchorage2));
    }

    /**
     * Tests method addAnchorage(int, GraphConnector) with null value. IllegalArgumentException should be
     * thrown.
     */
    public void testAddAnchorageIndexNull() {
        try {
            instance.addAnchorage(0, null);
            fail("IllegalArgumentException should be thrown");
        } catch (IllegalArgumentException ex) {
            // pass
        }
    }

    /**
     * Tests method addAnchorage(int, GraphConnector) with duplicate elements. Duplicate elements should be
     * allowed.
     */
    public void testAddAnchorageIndexDuplicate() {
        // insert an element twice
        instance.addAnchorage(0, anchorage1);
        instance.addAnchorage(0, anchorage1);

        assertEquals("two elements expected", 2, instance.countAnchorages());
    }

    /**
     * Tests method addAnchorage(int, GraphConnector) with negative index. IllegalArgumentException should be
     * thrown.
     */
    public void testAddAnchorageIndexNegative() {
        try {
            instance.addAnchorage(-1, anchorage1);
            fail("IllegalArgumentException should be thrown");
        } catch (IllegalArgumentException ex) {
            // pass
        }
    }

    /**
     * Tests method addAnchorage(int, GraphConnector) with index larger than size. IllegalArgumentException
     * should be thrown.
     */
    public void testAddAnchorageIndexLarger() {
        try {
            instance.addAnchorage(1, anchorage1);
            fail("IllegalArgumentException should be thrown");
        } catch (IllegalArgumentException ex) {
            // pass
        }
    }

    /**
     * Tests method setAnchorage. The element should be updated properly.
     */
    public void testSetAnchorage() {
        // the list contains one element
        instance.addAnchorage(anchorage1);

        assertEquals("one element expected", 1, instance.countAnchorages());
        assertEquals("the index of anchorage 1 should be 0", 0, instance.indexOfAnchorage(anchorage1));

        instance.setAnchorage(0, anchorage2);

        assertEquals("one element expected", 1, instance.countAnchorages());
        assertEquals("the index of anchorage 2 should be 0", 0, instance.indexOfAnchorage(anchorage2));
    }

    /**
     * Tests method setAnchorage with null value. IllegalArgumentException should be thrown.
     */
    public void testSetAnchorageNull() {
        // the list contains one element
        instance.addAnchorage(anchorage1);

        try {
            instance.setAnchorage(0, null);
            fail("IllegalArgumentException should be thrown");
        } catch (IllegalArgumentException ex) {
            // pass
        }
    }

    /**
     * Tests method setAnchorage with duplicate elements. Duplicate elements should be allowed.
     */
    public void testSetAnchorageDuplicate() {
        // the list contains two elements
        instance.addAnchorage(anchorage1);
        instance.addAnchorage(anchorage2);

        // replace the second element with the first one
        instance.setAnchorage(1, anchorage1);

        assertEquals("two elements expected", 2, instance.countAnchorages());
        assertFalse("the anchorage 2 should have been replaced", instance.containsAnchorage(anchorage2));
    }

    /**
     * Tests method setAnchorage with negative index. IllegalArgumentException should be thrown.
     */
    public void testSetAnchorageNegative() {
        try {
            instance.setAnchorage(-1, anchorage1);
            fail("IllegalArgumentException should be thrown");
        } catch (IllegalArgumentException ex) {
            // pass
        }
    }

    /**
     * Tests method setAnchorage with index larger than size-1. IllegalArgumentException should be thrown.
     */
    public void testSetAnchorageLarger() {
        // the list contains one element
        instance.addAnchorage(anchorage1);

        try {
            instance.setAnchorage(1, anchorage1);
            fail("IllegalArgumentException should be thrown");
        } catch (IllegalArgumentException ex) {
            // pass
        }
    }

    /**
     * Tests method removeAnchorage(int). The element should be removed properly.
     */
    public void testRemoveAnchorageIndex() {
        // the list contains two elements
        instance.addAnchorage(anchorage1);
        instance.addAnchorage(anchorage2);

        // remove the first one
        GraphConnector removed = instance.removeAnchorage(0);

        assertEquals("the anchorage 1 should be returned", removed, anchorage1);
        assertEquals("one element expected", 1, instance.countAnchorages());
        assertFalse("the anchorage 1 should have been removed", instance.containsAnchorage(anchorage1));
        assertEquals("the index of anchorage 2 should be 0", 0, instance.indexOfAnchorage(anchorage2));
    }

    /**
     * Tests method removeAnchorage(int) with negative index. IllegalArgumentException should be thrown.
     */
    public void testRemoveAnchorageIndexNegative() {
        try {
            instance.removeAnchorage(-1);
            fail("IllegalArgumentException should be thrown");
        } catch (IllegalArgumentException ex) {
            // pass
        }
    }

    /**
     * Tests method removeAnchorage(int) with index larger than size-1. IllegalArgumentException should be
     * thrown.
     */
    public void testRemoveAnchorageIndexLarger() {
        try {
            instance.removeAnchorage(0);
            fail("IllegalArgumentException should be thrown");
        } catch (IllegalArgumentException ex) {
            // pass
        }
    }

    /**
     * Tests method removeAnchorage(GraphConnector). The elements should be removed properly.
     */
    public void testRemoveAnchorage() {
        // the list contains two elements
        instance.addAnchorage(anchorage1);
        instance.addAnchorage(anchorage2);

        // remove one element
        boolean removed = instance.removeAnchorage(anchorage1);

        assertTrue("the anchorage 1 should be returned", removed);
        assertEquals("one element expected", 1, instance.countAnchorages());
        assertFalse("the anchorage 1 should have been removed", instance.containsAnchorage(anchorage1));
        assertEquals("the index of anchorage 2 should be 0", 0, instance.indexOfAnchorage(anchorage2));

        // remove another element
        removed = instance.removeAnchorage(anchorage2);

        assertTrue("the anchorage 2 should be returned", removed);
        assertEquals("no element expected", 0, instance.countAnchorages());
        assertFalse("the anchorage 2 should have been removed", instance.containsAnchorage(anchorage2));
    }

    /**
     * Tests method removeAnchorage(GraphConnector) with nonexistent element. The method should return false.
     */
    public void testRemoveAnchorageNonexist() {
        assertFalse("false expected", instance.removeAnchorage(anchorage1));
    }

    /**
     * Tests method removeAnchorage(GraphConnector) with null value. IllegalArgumentException should be
     * thrown.
     */
    public void testRemoveAnchorageNull() {
        try {
            instance.removeAnchorage(null);
            fail("IllegalArgumentException should be thrown");
        } catch (IllegalArgumentException ex) {
            // pass
        }
    }

    /**
     * Tests method removeAnchorage(GraphConnector) with duplicate elements. Only the first occurrence should
     * be removed.
     */
    public void testRemoveAnchorageDuplicate() {
        // the list contains duplicate elements
        instance.addAnchorage(anchorage1);
        instance.addAnchorage(anchorage2);
        instance.addAnchorage(anchorage1);

        // remove the element
        instance.removeAnchorage(anchorage1);

        assertEquals("two elements expected", 2, instance.countAnchorages());
        assertEquals("the index of anchorage 1 should be 1", 1, instance.indexOfAnchorage(anchorage1));
    }

    /**
     * Tests method clearAnchorages. The elements should be removed properly.
     */
    public void testClearAnchorages() {
        // the list contains two elements
        instance.addAnchorage(anchorage1);
        instance.addAnchorage(anchorage2);

        instance.clearAnchorages();

        assertEquals("no element expected", 0, instance.countAnchorages());
    }

    /**
     * Tests method getAnchorages. The method should return a copy of list containing all the elements.
     */
    public void testGetAnchorages() {
        // the list contains two elements
        instance.addAnchorage(anchorage1);
        instance.addAnchorage(anchorage2);

        List<GraphConnector> list = instance.getAnchorages();

        assertEquals("two elements expected", 2, list.size());
        assertEquals("the index of anchorage 1 should be 0", 0, list.indexOf(anchorage1));
        assertEquals("the index of anchorage 2 should be 1", 1, list.indexOf(anchorage2));

        // remove all the elements in the instance
        instance.clearAnchorages();

        // the return list doesn't change since it is just a copy
        assertEquals("two elements expected", 2, list.size());
    }

    /**
     * Tests method containsAnchorage. The method should return true for contained element.
     */
    public void testContainsAnchorage() {
        // the list contains one element
        instance.addAnchorage(anchorage1);

        assertTrue("true expected", instance.containsAnchorage(anchorage1));
    }

    /**
     * Tests method containsAnchorage with nonexistent element. The method should return false.
     */
    public void testContainsAnchorageNonexist() {
        assertFalse("false expected", instance.containsAnchorage(anchorage1));
    }

    /**
     * Tests method containsAnchorage with null value. IllegalArgumentException should be thrown.
     */
    public void testContainsAnchorageNull() {
        try {
            instance.containsAnchorage(null);
            fail("IllegalArgumentException should be thrown");
        } catch (IllegalArgumentException ex) {
            // pass
        }
    }

    /**
     * Tests method indexOfAnchorage. The index should be correct for each element.
     */
    public void testIndexOfAnchorage() {
        // the list contains two elements
        instance.addAnchorage(anchorage1);
        instance.addAnchorage(anchorage2);

        assertEquals("the index of anchorage 1 should be 0", 0, instance.indexOfAnchorage(anchorage1));
        assertEquals("the index of anchorage 2 should be 1", 1, instance.indexOfAnchorage(anchorage2));
    }

    /**
     * Tests method indexOfAnchorage with nonexistent element. The method should return -1.
     */
    public void testIndexOfAnchorageNonexist() {
        assertEquals("-1 expected", -1, instance.indexOfAnchorage(anchorage1));
    }

    /**
     * Tests method indexOfAnchorage with null value. IllegalArgumentException should be thrown.
     */
    public void testIndexOfAnchorageNull() {
        try {
            instance.indexOfAnchorage(null);
            fail("IllegalArgumentException should be thrown");
        } catch (IllegalArgumentException ex) {
            // pass
        }
    }

    /**
     * Tests method indexOfAnchorage with duplicate elements. The method should return the index of the first
     * occurrence.
     */
    public void testIndexOfAnchorageDuplicate() {
        // the list contains duplicate elements
        instance.addAnchorage(anchorage1);
        instance.addAnchorage(anchorage1);

        assertEquals("the index of anchorage 1 should be 0", 0, instance.indexOfAnchorage(anchorage1));
    }

    /**
     * Tests method countAnchorages. The method should return the size of elements.
     */
    public void testCountAnchorages() {
        assertEquals("no element expected", 0, instance.countAnchorages());

        // add a element
        instance.addAnchorage(anchorage1);

        assertEquals("one element expected", 1, instance.countAnchorages());

        // remove the element
        instance.removeAnchorage(anchorage1);

        assertEquals("no element expected", 0, instance.countAnchorages());
    }
}

/**
 * <p>
 * A mock concrete class extends GraphElement for testing.
 * </p>
 *
 * @author TCSDEVELOPER
 * @version 1.0
 */
final class MockGraphElement extends GraphElement {
    // empty
}