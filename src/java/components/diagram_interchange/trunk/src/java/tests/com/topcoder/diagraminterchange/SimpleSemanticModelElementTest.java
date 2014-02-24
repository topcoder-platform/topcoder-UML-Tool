/*
 * Copyright (C) 2006 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.diagraminterchange;

import junit.framework.TestCase;

/**
 * <p>
 * Unit tests for class SimpleSemanticModelElement.
 * </p>
 *
 * @author TCSDEVELOPER
 * @version 1.0
 */
public class SimpleSemanticModelElementTest extends TestCase {

    /**
     * An instance of SimpleSemanticModelElement for testing.
     */
    private SimpleSemanticModelElement instance;

    /**
     * Sets up the environment. Creates an instance of SimpleSemanticModelElement.
     */
    protected void setUp() {
        instance = new SimpleSemanticModelElement();
    }

    /**
     * Tests the constructor. All the fields should be initiated properly.
     */
    public void testSimpleSemanticModelElementCtor() {
        assertNotNull("fail to construct the instance", instance);

        assertNull("null expected", instance.getTypeInfo());
    }

    /**
     * Tests method getTypeInfo. The correspond field should be returned properly.
     */
    public void testGetTypeInfo() {
        String[] strings = TestHelper.getRandomStrings();

        for (String item : strings) {
            instance.setTypeInfo(item);
            assertEquals("incorrect string", item, instance.getTypeInfo());
        }
    }

    /**
     * Tests method setTypeInfo. The correspond field should be updated properly.
     */
    public void testSetTypeInfo() {
        String[] strings = TestHelper.getRandomStrings();

        for (String item : strings) {
            instance.setTypeInfo(item);
            assertEquals("incorrect string", item, instance.getTypeInfo());
        }
    }

    /**
     * Tests method setTypeInfo with null value. Null value should be allowed.
     */
    public void testSetTypeInfoNull() {
        instance.setTypeInfo(null);
        assertNull("null value should be allowed", instance.getTypeInfo());
    }

    /**
     * Tests method setTypeInfo with empty value. Empty value should be allowed.
     */
    public void testSetTypeInfoEmpty() {
        instance.setTypeInfo(TestHelper.EMPTY_STRING);
        assertEquals("empty value should be allowed", TestHelper.EMPTY_STRING, instance.getTypeInfo());
    }
}