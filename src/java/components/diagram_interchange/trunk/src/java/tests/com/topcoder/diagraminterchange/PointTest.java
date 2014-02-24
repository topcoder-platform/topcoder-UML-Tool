/*
 * Copyright (C) 2006 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.diagraminterchange;

import junit.framework.TestCase;

/**
 * <p>
 * Unit tests for class Point.
 * </p>
 *
 * @author TCSDEVELOPER
 * @version 1.0
 */
public class PointTest extends TestCase {

    /**
     * An instance of Point for testing.
     */
    private Point instance;

    /**
     * Sets up the environment. Creates an instance of Point.
     */
    protected void setUp() {
        instance = new Point();
    }

    /**
     * Tests the constructor. All the fields should be initiated properly.
     */
    public void testPointCtor() {
        assertNotNull("fail to construct the instance", instance);

        assertTrue("zero expected", TestHelper.DEFAULT_DOUBLE == instance.getX());
        assertTrue("zero expected", TestHelper.DEFAULT_DOUBLE == instance.getY());
    }

    /**
     * Tests method getX. The correspond field should be returned properly.
     */
    public void testGetX() {
        double[] doubles = TestHelper.getRandomDoubles();

        for (double item : doubles) {
            instance.setX(item);
            assertTrue("incorrect double value", item == instance.getX());
        }
    }

    /**
     * Tests method setX. The correspond field should be updated properly.
     */
    public void testSetX() {
        double[] doubles = TestHelper.getRandomDoubles();

        for (double item : doubles) {
            instance.setX(item);
            assertTrue("incorrect double value", item == instance.getX());
        }
    }

    /**
     * Tests method getY. The correspond field should be returned properly.
     */
    public void testGetY() {
        double[] doubles = TestHelper.getRandomDoubles();

        for (double item : doubles) {
            instance.setY(item);
            assertTrue("incorrect double value", item == instance.getY());
        }
    }

    /**
     * Tests method setY. The correspond field should be updated properly.
     */
    public void testSetY() {
        double[] doubles = TestHelper.getRandomDoubles();

        for (double item : doubles) {
            instance.setY(item);
            assertTrue("incorrect double value", item == instance.getY());
        }
    }
}