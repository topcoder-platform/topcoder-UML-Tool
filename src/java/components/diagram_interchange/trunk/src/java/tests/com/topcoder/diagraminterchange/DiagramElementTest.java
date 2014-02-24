/*
 * Copyright (C) 2006 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.diagraminterchange;

import java.util.Collection;

import junit.framework.TestCase;

/**
 * <p>
 * Unit tests for class DiagramElement. Since DiagramElement is an abstract class, A mock concrete class is
 * provided to extend it for testing.
 * </p>
 *
 * @author TCSDEVELOPER
 * @version 1.0
 */
public class DiagramElementTest extends TestCase {

    /**
     * An instance of Property for testing.
     */
    private Property property1;

    /**
     * An instance of Property for testing.
     */
    private Property property2;

    /**
     * An instance of Reference for testing.
     */
    private Reference reference1;

    /**
     * An instance of Reference for testing.
     */
    private Reference reference2;

    /**
     * An instance of DiagramElement for testing.
     */
    private DiagramElement instance;

    /**
     * Sets up the environment. Creates an instance of DiagramElement.
     */
    protected void setUp() {
        property1 = new Property();
        property2 = new Property();
        reference1 = new Reference();
        reference2 = new Reference();

        instance = new MockDiagramElement();
    }

    /**
     * Tests the constructor. All the fields should be initiated properly.
     */
    public void testDiagramElementCtor() {
        assertNotNull("fail to construct the instance", instance);

        assertTrue("true expected", instance.isVisible());
        assertNull("null expected", instance.getContainer());

        assertEquals("empty expected", 0, instance.countProperties());
        assertEquals("empty expected", 0, instance.countReferences());
    }

    /**
     * Tests method isVisible. The correspond field should be returned properly.
     */
    public void testIsVisible() {
        instance.setVisible(true);
        assertTrue("true expected", instance.isVisible());

        instance.setVisible(false);
        assertFalse("false expected", instance.isVisible());
    }

    /**
     * Tests method setVisible. The correspond field should be updated properly.
     */
    public void testSetVisible() {
        instance.setVisible(true);
        assertTrue("true expected", instance.isVisible());

        instance.setVisible(false);
        assertFalse("false expected", instance.isVisible());
    }

    /**
     * Tests method getContainer. The correspond field should be returned properly.
     */
    public void testGetContainer() {
        GraphElement container = new MockGraphElement();
        instance.setContainer(container);
        assertEquals("incorrect Container", container, instance.getContainer());
    }

    /**
     * Tests method setContainer. The correspond field should be updated properly.
     */
    public void testSetContainer() {
        GraphElement container = new MockGraphElement();
        instance.setContainer(container);
        assertEquals("incorrect Container", container, instance.getContainer());
    }

    /**
     * Tests method setContainer with null value. Null value should be allowed.
     */
    public void testSetContainerNull() {
        instance.setContainer(null);
        assertNull("null value should be allowed", instance.getContainer());
    }

    /**
     * Tests method addProperty. The elements should be contained in correct order.
     */
    public void testAddProperty() {
        instance.addProperty(property1);

        assertEquals("one element expected", 1, instance.countProperties());
        assertTrue("property 1 should be added", instance.containsProperty(property1));

        instance.addProperty(property2);

        assertEquals("two elements expected", 2, instance.countProperties());
        assertTrue("property 2 should be added", instance.containsProperty(property2));
    }

    /**
     * Tests method addProperty with null value. IllegalArgumentException should be thrown.
     */
    public void testAddPropertyNull() {
        try {
            instance.addProperty(null);
            fail("IllegalArgumentException should be thrown");
        } catch (IllegalArgumentException ex) {
            // pass
        }
    }

    /**
     * Tests method addProperty with duplicate elements. Duplicate elements should be allowed.
     */
    public void testAddPropertyDuplicate() {
        // append an element twice
        instance.addProperty(property1);
        instance.addProperty(property1);

        assertEquals("two elements expected", 2, instance.countProperties());
    }

    /**
     * Tests method removeProperty. The elements should be removed properly.
     */
    public void testRemoveProperty() {
        // the collection contains two elements
        instance.addProperty(property1);
        instance.addProperty(property2);

        // remove one element
        boolean removed = instance.removeProperty(property1);

        assertTrue("the property 1 should be returned", removed);
        assertEquals("one element expected", 1, instance.countProperties());
        assertFalse("the property 1 should have been removed", instance.containsProperty(property1));

        // remove another element
        removed = instance.removeProperty(property2);

        assertTrue("the property 2 should be returned", removed);
        assertEquals("no element expected", 0, instance.countProperties());
        assertFalse("the property 2 should have been removed", instance.containsProperty(property2));
    }

    /**
     * Tests method removeProperty with nonexistent element. The method should return false.
     */
    public void testRemovePropertyNonexist() {
        assertFalse("false expected", instance.removeProperty(property1));
    }

    /**
     * Tests method removeProperty with null value. IllegalArgumentException should be thrown.
     */
    public void testRemovePropertyNull() {
        try {
            instance.removeProperty(null);
            fail("IllegalArgumentException should be thrown");
        } catch (IllegalArgumentException ex) {
            // pass
        }
    }

    /**
     * Tests method removeProperty with duplicate elements. Only the first occurrence should be removed.
     */
    public void testRemovePropertyDuplicate() {
        // the collection contains duplicate elements
        instance.addProperty(property1);
        instance.addProperty(property1);

        // remove the element
        instance.removeProperty(property1);

        assertEquals("one element expected", 1, instance.countProperties());
    }

    /**
     * Tests method clearProperties. The elements should be removed properly.
     */
    public void testClearProperties() {
        // the collection contains two elements
        instance.addProperty(property1);
        instance.addProperty(property2);

        instance.clearProperties();

        assertEquals("no element expected", 0, instance.countProperties());
    }

    /**
     * Tests method getProperties. The method should return a copy of collection containing all the elements.
     */
    public void testGetProperties() {
        // the collection contains two elements
        instance.addProperty(property1);
        instance.addProperty(property2);

        Collection<Property> collection = instance.getProperties();

        assertEquals("two elements expected", 2, collection.size());
        assertTrue("property 1 should be contained", collection.contains(property1));
        assertTrue("property 2 should be contained", collection.contains(property2));

        // remove all the elements in the instance
        instance.clearProperties();

        // the return collection doesn't change since it is just a copy
        assertEquals("two elements expected", 2, collection.size());
    }

    /**
     * Tests method containsProperty. The method should return true for contained element.
     */
    public void testContainsProperty() {
        // the collection contains one element
        instance.addProperty(property1);

        assertTrue("true expected", instance.containsProperty(property1));
    }

    /**
     * Tests method containsProperty with nonexistent element. The method should return false.
     */
    public void testContainsPropertyNonexist() {
        assertFalse("false expected", instance.containsProperty(property1));
    }

    /**
     * Tests method containsProperty with null value. IllegalArgumentException should be thrown.
     */
    public void testContainsPropertyNull() {
        try {
            instance.containsProperty(null);
            fail("IllegalArgumentException should be thrown");
        } catch (IllegalArgumentException ex) {
            // pass
        }
    }

    /**
     * Tests method countProperties. The method should return the size of elements.
     */
    public void testCountProperties() {
        assertEquals("no element expected", 0, instance.countProperties());

        // add a element
        instance.addProperty(property1);

        assertEquals("one element expected", 1, instance.countProperties());

        // remove the element
        instance.removeProperty(property1);

        assertEquals("no element expected", 0, instance.countProperties());
    }

    /**
     * Tests method addReference. The elements should be contained in correct order.
     */
    public void testAddReference() {
        instance.addReference(reference1);

        assertEquals("one element expected", 1, instance.countReferences());
        assertTrue("reference 1 should be added", instance.containsReference(reference1));

        instance.addReference(reference2);

        assertEquals("two elements expected", 2, instance.countReferences());
        assertTrue("reference 2 should be added", instance.containsReference(reference2));
    }

    /**
     * Tests method addReference with null value. IllegalArgumentException should be thrown.
     */
    public void testAddReferenceNull() {
        try {
            instance.addReference(null);
            fail("IllegalArgumentException should be thrown");
        } catch (IllegalArgumentException ex) {
            // pass
        }
    }

    /**
     * Tests method addReference with duplicate elements. Duplicate elements should be allowed.
     */
    public void testAddReferenceDuplicate() {
        // append an element twice
        instance.addReference(reference1);
        instance.addReference(reference1);

        assertEquals("two elements expected", 2, instance.countReferences());
    }

    /**
     * Tests method removeReference. The elements should be removed properly.
     */
    public void testRemoveReference() {
        // the collection contains two elements
        instance.addReference(reference1);
        instance.addReference(reference2);

        // remove one element
        boolean removed = instance.removeReference(reference1);

        assertTrue("the reference 1 should be returned", removed);
        assertEquals("one element expected", 1, instance.countReferences());
        assertFalse("the reference 1 should have been removed", instance.containsReference(reference1));

        // remove another element
        removed = instance.removeReference(reference2);

        assertTrue("the reference 2 should be returned", removed);
        assertEquals("no element expected", 0, instance.countReferences());
        assertFalse("the reference 2 should have been removed", instance.containsReference(reference2));
    }

    /**
     * Tests method removeReference with nonexistent element. The method should return false.
     */
    public void testRemoveReferenceNonexist() {
        assertFalse("false expected", instance.removeReference(reference1));
    }

    /**
     * Tests method removeReference with null value. IllegalArgumentException should be thrown.
     */
    public void testRemoveReferenceNull() {
        try {
            instance.removeReference(null);
            fail("IllegalArgumentException should be thrown");
        } catch (IllegalArgumentException ex) {
            // pass
        }
    }

    /**
     * Tests method removeReference with duplicate elements. Only the first occurrence should be removed.
     */
    public void testRemoveReferenceDuplicate() {
        // the collection contains duplicate elements
        instance.addReference(reference1);
        instance.addReference(reference1);

        // remove the element
        instance.removeReference(reference1);

        assertEquals("one element expected", 1, instance.countReferences());
    }

    /**
     * Tests method clearReferences. The elements should be removed properly.
     */
    public void testClearReferences() {
        // the collection contains two elements
        instance.addReference(reference1);
        instance.addReference(reference2);

        instance.clearReferences();

        assertEquals("no element expected", 0, instance.countReferences());
    }

    /**
     * Tests method getReferences. The method should return a copy of collection containing all the elements.
     */
    public void testGetReferences() {
        // the collection contains two elements
        instance.addReference(reference1);
        instance.addReference(reference2);

        Collection<Reference> collection = instance.getReferences();

        assertEquals("two elements expected", 2, collection.size());
        assertTrue("reference 1 should be contained", collection.contains(reference1));
        assertTrue("reference 2 should be contained", collection.contains(reference2));

        // remove all the elements in the instance
        instance.clearReferences();

        // the return collection doesn't change since it is just a copy
        assertEquals("two elements expected", 2, collection.size());
    }

    /**
     * Tests method containsReference. The method should return true for contained element.
     */
    public void testContainsReference() {
        // the collection contains one element
        instance.addReference(reference1);

        assertTrue("true expected", instance.containsReference(reference1));
    }

    /**
     * Tests method containsReference with nonexistent element. The method should return false.
     */
    public void testContainsReferenceNonexist() {
        assertFalse("false expected", instance.containsReference(reference1));
    }

    /**
     * Tests method containsReference with null value. IllegalArgumentException should be thrown.
     */
    public void testContainsReferenceNull() {
        try {
            instance.containsReference(null);
            fail("IllegalArgumentException should be thrown");
        } catch (IllegalArgumentException ex) {
            // pass
        }
    }

    /**
     * Tests method countReferences. The method should return the size of elements.
     */
    public void testCountReferences() {
        assertEquals("no element expected", 0, instance.countReferences());

        // add a element
        instance.addReference(reference1);

        assertEquals("one element expected", 1, instance.countReferences());

        // remove the element
        instance.removeReference(reference1);

        assertEquals("no element expected", 0, instance.countReferences());
    }
}

/**
 * <p>
 * A mock concrete class extends DiagramElement for testing.
 * </p>
 *
 * @author TCSDEVELOPER
 * @version 1.0
 */
final class MockDiagramElement extends DiagramElement {
    // empty
}