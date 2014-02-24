/*
 * Copyright (C) 2006 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.diagraminterchange;

import junit.framework.TestCase;

/**
 * <p>
 * Unit tests for class Dimension.
 * </p>
 *
 * @author TCSDEVELOPER
 * @version 1.0
 */
public class DimensionTest extends TestCase {

    /**
     * An instance of Dimension for testing.
     */
    private Dimension instance;

    /**
     * Sets up the environment. Creates an instance of Dimension.
     */
    protected void setUp() {
        instance = new Dimension();
    }

    /**
     * Tests the constructor. All the fields should be initiated properly.
     */
    public void testDimensionCtor() {
        assertNotNull("fail to construct the instance", instance);

        assertTrue("zero expected", TestHelper.DEFAULT_DOUBLE == instance.getWidth());
        assertTrue("zero expected", TestHelper.DEFAULT_DOUBLE == instance.getHeight());
    }

    /**
     * Tests method getWidth. The correspond field should be returned properly.
     */
    public void testGetWidth() {
        double[] doubles = TestHelper.getRandomDoubles();

        for (double item : doubles) {
            instance.setWidth(item);
            assertTrue("incorrect double value", item == instance.getWidth());
        }
    }

    /**
     * Tests method setWidth. The correspond field should be updated properly.
     */
    public void testSetWidth() {
        double[] doubles = TestHelper.getRandomDoubles();

        for (double item : doubles) {
            instance.setWidth(item);
            assertTrue("incorrect double value", item == instance.getWidth());
        }
    }

    /**
     * Tests method getHeight. The correspond field should be returned properly.
     */
    public void testGetHeight() {
        double[] doubles = TestHelper.getRandomDoubles();

        for (double item : doubles) {
            instance.setHeight(item);
            assertTrue("incorrect double value", item == instance.getHeight());
        }
    }

    /**
     * Tests method setHeight. The correspond field should be updated properly.
     */
    public void testSetHeight() {
        double[] doubles = TestHelper.getRandomDoubles();

        for (double item : doubles) {
            instance.setHeight(item);
            assertTrue("incorrect double value", item == instance.getHeight());
        }
    }
}