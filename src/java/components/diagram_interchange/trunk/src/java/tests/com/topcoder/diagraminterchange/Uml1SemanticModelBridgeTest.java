/*
 * Copyright (C) 2006 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.diagraminterchange;

import com.topcoder.uml.model.core.Element;

import junit.framework.TestCase;

/**
 * <p>
 * Unit tests for class Uml1SemanticModelBridge.
 * </p>
 *
 * @author TCSDEVELOPER
 * @version 1.0
 */
public class Uml1SemanticModelBridgeTest extends TestCase {

    /**
     * An instance of Uml1SemanticModelBridge for testing.
     */
    private Uml1SemanticModelBridge instance;

    /**
     * Sets up the environment. Creates an instance of Uml1SemanticModelBridge.
     */
    protected void setUp() {
        instance = new Uml1SemanticModelBridge();
    }

    /**
     * Tests the constructor. All the fields should be initiated properly.
     */
    public void testUml1SemanticModelBridgeCtor() {
        assertNotNull("fail to construct the instance", instance);

        assertNull("null expected", instance.getElement());
    }

    /**
     * Tests method getElement. The correspond field should be returned properly.
     */
    public void testGetElement() {
        Element element = new MockElement();
        instance.setElement(element);
        assertEquals("incorrect Element", element, instance.getElement());
    }

    /**
     * Tests method setElement. The correspond field should be updated properly.
     */
    public void testSetElement() {
        Element element = new MockElement();
        instance.setElement(element);
        assertEquals("incorrect Element", element, instance.getElement());
    }

    /**
     * Tests method setElement with null value. Null value should be allowed.
     */
    public void testSetElementNull() {
        instance.setElement(null);
        assertNull("null value should be allowed", instance.getElement());
    }
}