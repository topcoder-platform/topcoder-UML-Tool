/*
 * Copyright (C) 2006 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.diagraminterchange;

import junit.framework.TestCase;

/**
 * <p>
 * Unit tests for class Reference.
 * </p>
 *
 * @author TCSDEVELOPER
 * @version 1.0
 */
public class ReferenceTest extends TestCase {

    /**
     * An instance of Reference for testing.
     */
    private Reference instance;

    /**
     * Sets up the environment. Creates an instance of Reference.
     */
    protected void setUp() {
        instance = new Reference();
    }

    /**
     * Tests the constructor. All the fields should be initiated properly.
     */
    public void testReferenceCtor() {
        assertNotNull("fail to construct the instance", instance);

        assertFalse("false expected", instance.isIndividualRepresentation());
        assertNull("null expected", instance.getReferenced());
    }

    /**
     * Tests method isIndividualRepresentation. The correspond field should be returned properly.
     */
    public void testIsIndividualRepresentation() {
        instance.setIndividualRepresentation(true);
        assertTrue("true expected", instance.isIndividualRepresentation());

        instance.setIndividualRepresentation(false);
        assertFalse("false expected", instance.isIndividualRepresentation());
    }

    /**
     * Tests method setIndividualRepresentation. The correspond field should be updated properly.
     */
    public void testSetIndividualRepresentation() {
        instance.setIndividualRepresentation(true);
        assertTrue("true expected", instance.isIndividualRepresentation());

        instance.setIndividualRepresentation(false);
        assertFalse("false expected", instance.isIndividualRepresentation());
    }

    /**
     * Tests method getReferenced. The correspond field should be returned properly.
     */
    public void testGetReferenced() {
        DiagramElement diagramElement = new MockDiagramElement();
        instance.setReferenced(diagramElement);
        assertEquals("incorrect Referenced", diagramElement, instance.getReferenced());
    }

    /**
     * Tests method setReferenced. The correspond field should be updated properly.
     */
    public void testSetReferenced() {
        DiagramElement diagramElement = new MockDiagramElement();
        instance.setReferenced(diagramElement);
        assertEquals("incorrect Referenced", diagramElement, instance.getReferenced());
    }

    /**
     * Tests method setReferenced with null value. Null value should be allowed.
     */
    public void testSetReferencedNull() {
        instance.setReferenced(null);
        assertNull("null value should be allowed", instance.getReferenced());
    }
}