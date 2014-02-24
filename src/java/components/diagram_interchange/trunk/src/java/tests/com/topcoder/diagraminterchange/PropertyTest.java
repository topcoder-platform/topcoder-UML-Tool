/*
 * Copyright (C) 2006 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.diagraminterchange;

import junit.framework.TestCase;

/**
 * <p>
 * Unit tests for class Property.
 * </p>
 *
 * @author TCSDEVELOPER
 * @version 1.0
 */
public class PropertyTest extends TestCase {

    /**
     * An instance of Property for testing.
     */
    private Property instance;

    /**
     * Sets up the environment. Creates an instance of Property.
     */
    protected void setUp() {
        instance = new Property();
    }

    /**
     * Tests the constructor. All the fields should be initiated properly.
     */
    public void testPropertyCtor() {
        assertNotNull("fail to construct the instance", instance);

        assertNull("null expected", instance.getKey());
        assertNull("null expected", instance.getValue());
    }

    /**
     * Tests method getKey. The correspond field should be returned properly.
     */
    public void testGetKey() {
        String[] strings = TestHelper.getRandomStrings();

        for (String item : strings) {
            instance.setKey(item);
            assertEquals("incorrect string", item, instance.getKey());
        }
    }

    /**
     * Tests method setKey. The correspond field should be updated properly.
     */
    public void testSetKey() {
        String[] strings = TestHelper.getRandomStrings();

        for (String item : strings) {
            instance.setKey(item);
            assertEquals("incorrect string", item, instance.getKey());
        }
    }

    /**
     * Tests method setKey with null value. Null value should be allowed.
     */
    public void testSetKeyNull() {
        instance.setKey(null);
        assertNull("null value should be allowed", instance.getKey());
    }

    /**
     * Tests method setKey with empty value. Empty value should be allowed.
     */
    public void testSetKeyEmpty() {
        instance.setKey(TestHelper.EMPTY_STRING);
        assertEquals("empty value should be allowed", TestHelper.EMPTY_STRING, instance.getKey());
    }

    /**
     * Tests method getValue. The correspond field should be returned properly.
     */
    public void testGetValue() {
        String[] strings = TestHelper.getRandomStrings();

        for (String item : strings) {
            instance.setValue(item);
            assertEquals("incorrect string", item, instance.getValue());
        }
    }

    /**
     * Tests method setValue. The correspond field should be updated properly.
     */
    public void testSetValue() {
        String[] strings = TestHelper.getRandomStrings();

        for (String item : strings) {
            instance.setValue(item);
            assertEquals("incorrect string", item, instance.getValue());
        }
    }

    /**
     * Tests method setValue with null value. Null value should be allowed.
     */
    public void testSetValueNull() {
        instance.setValue(null);
        assertNull("null value should be allowed", instance.getValue());
    }

    /**
     * Tests method setValue with empty value. Empty value should be allowed.
     */
    public void testSetValueEmpty() {
        instance.setValue(TestHelper.EMPTY_STRING);
        assertEquals("empty value should be allowed", TestHelper.EMPTY_STRING, instance.getValue());
    }
}