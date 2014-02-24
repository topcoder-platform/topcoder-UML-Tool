/*
 * Copyright (C) 2006 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.diagraminterchange;

import junit.framework.TestCase;

/**
 * <p>
 * Unit tests for class TextElement.
 * </p>
 *
 * @author TCSDEVELOPER
 * @version 1.0
 */
public class TextElementTest extends TestCase {

    /**
     * An instance of TextElement for testing.
     */
    private TextElement instance;

    /**
     * Sets up the environment. Creates an instance of TextElement.
     */
    protected void setUp() {
        instance = new TextElement();
    }

    /**
     * Tests the constructor. All the fields should be initiated properly.
     */
    public void testTextElementCtor() {
        assertNotNull("fail to construct the instance", instance);

        assertNull("null expected", instance.getText());
    }

    /**
     * Tests method getText. The correspond field should be returned properly.
     */
    public void testGetText() {
        String[] strings = TestHelper.getRandomStrings();

        for (String item : strings) {
            instance.setText(item);
            assertEquals("incorrect string", item, instance.getText());
        }
    }

    /**
     * Tests method setText. The correspond field should be updated properly.
     */
    public void testSetText() {
        String[] strings = TestHelper.getRandomStrings();

        for (String item : strings) {
            instance.setText(item);
            assertEquals("incorrect string", item, instance.getText());
        }
    }

    /**
     * Tests method setText with null value. Null value should be allowed.
     */
    public void testSetTextNull() {
        instance.setText(null);
        assertNull("null value should be allowed", instance.getText());
    }

    /**
     * Tests method setText with empty value. Empty value should be allowed.
     */
    public void testSetTextEmpty() {
        instance.setText(TestHelper.EMPTY_STRING);
        assertEquals("empty value should be allowed", TestHelper.EMPTY_STRING, instance.getText());
    }
}