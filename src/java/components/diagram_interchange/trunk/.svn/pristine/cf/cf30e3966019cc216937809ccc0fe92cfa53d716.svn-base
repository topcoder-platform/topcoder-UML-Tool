/*
 * Copyright (C) 2006 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.diagraminterchange;

import junit.framework.TestCase;

/**
 * <p>
 * Unit tests for class Image.
 * </p>
 *
 * @author TCSDEVELOPER
 * @version 1.0
 */
public class ImageTest extends TestCase {

    /**
     * An instance of Image for testing.
     */
    private Image instance;

    /**
     * Sets up the environment. Creates an instance of Image.
     */
    protected void setUp() {
        instance = new Image();
    }

    /**
     * Tests the constructor. All the fields should be initiated properly.
     */
    public void testImageCtor() {
        assertNotNull("fail to construct the instance", instance);

        assertNull("null expected", instance.getUri());
        assertNull("null expected", instance.getMimeType());
    }

    /**
     * Tests method getUri. The correspond field should be returned properly.
     */
    public void testGetUri() {
        String[] strings = TestHelper.getRandomStrings();

        for (String item : strings) {
            instance.setUri(item);
            assertEquals("incorrect string", item, instance.getUri());
        }
    }

    /**
     * Tests method setUri. The correspond field should be updated properly.
     */
    public void testSetUri() {
        String[] strings = TestHelper.getRandomStrings();

        for (String item : strings) {
            instance.setUri(item);
            assertEquals("incorrect string", item, instance.getUri());
        }
    }

    /**
     * Tests method setUri with null value. Null value should be allowed.
     */
    public void testSetUriNull() {
        instance.setUri(null);
        assertNull("null value should be allowed", instance.getUri());
    }

    /**
     * Tests method setUri with empty value. Empty value should be allowed.
     */
    public void testSetUriEmpty() {
        instance.setUri(TestHelper.EMPTY_STRING);
        assertEquals("empty value should be allowed", TestHelper.EMPTY_STRING, instance.getUri());
    }

    /**
     * Tests method getMimeType. The correspond field should be returned properly.
     */
    public void testGetMimeType() {
        String[] strings = TestHelper.getRandomStrings();

        for (String item : strings) {
            instance.setMimeType(item);
            assertEquals("incorrect string", item, instance.getMimeType());
        }
    }

    /**
     * Tests method setMimeType. The correspond field should be updated properly.
     */
    public void testSetMimeType() {
        String[] strings = TestHelper.getRandomStrings();

        for (String item : strings) {
            instance.setMimeType(item);
            assertEquals("incorrect string", item, instance.getMimeType());
        }
    }

    /**
     * Tests method setMimeType with null value. Null value should be allowed.
     */
    public void testSetMimeTypeNull() {
        instance.setMimeType(null);
        assertNull("null value should be allowed", instance.getMimeType());
    }

    /**
     * Tests method setMimeType with empty value. Empty value should be allowed.
     */
    public void testSetMimeTypeEmpty() {
        instance.setMimeType(TestHelper.EMPTY_STRING);
        assertEquals("empty value should be allowed", TestHelper.EMPTY_STRING, instance.getMimeType());
    }
}