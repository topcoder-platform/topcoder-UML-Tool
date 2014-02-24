/*
 * Copyright (C) 2006 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.diagraminterchange;

import junit.framework.TestCase;

/**
 * <p>
 * Unit tests for class Ellipse.
 * </p>
 *
 * @author TCSDEVELOPER
 * @version 1.0
 */
public class EllipseTest extends TestCase {

    /**
     * An instance of Ellipse for testing.
     */
    private Ellipse instance;

    /**
     * Sets up the environment. Creates an instance of Ellipse.
     */
    protected void setUp() {
        instance = new Ellipse();
    }

    /**
     * Tests the constructor. All the fields should be initiated properly.
     */
    public void testEllipseCtor() {
        assertNotNull("fail to construct the instance", instance);

        assertNull("null expected", instance.getCenter());
        assertTrue("zero expected", TestHelper.DEFAULT_DOUBLE == instance.getRadiusX());
        assertTrue("zero expected", TestHelper.DEFAULT_DOUBLE == instance.getRadiusY());
        assertTrue("zero expected", TestHelper.DEFAULT_DOUBLE == instance.getRotation());
        assertTrue("zero expected", TestHelper.DEFAULT_DOUBLE == instance.getStartAngle());
        assertTrue("zero expected", TestHelper.DEFAULT_DOUBLE == instance.getEndAngle());
    }

    /**
     * Tests method getCenter. The correspond field should be returned properly.
     */
    public void testGetCenter() {
        Point point = new Point();
        instance.setCenter(point);
        assertEquals("incorrect Center", point, instance.getCenter());
    }

    /**
     * Tests method setCenter. The correspond field should be updated properly.
     */
    public void testSetCenter() {
        Point point = new Point();
        instance.setCenter(point);
        assertEquals("incorrect Center", point, instance.getCenter());
    }

    /**
     * Tests method setCenter with null value. Null value should be allowed.
     */
    public void testSetCenterNull() {
        instance.setCenter(null);
        assertNull("null value should be allowed", instance.getCenter());
    }

    /**
     * Tests method getRadiusX. The correspond field should be returned properly.
     */
    public void testGetRadiusX() {
        double[] doubles = TestHelper.getRandomDoubles();

        for (double item : doubles) {
            instance.setRadiusX(item);
            assertTrue("incorrect double value", item == instance.getRadiusX());
        }
    }

    /**
     * Tests method setRadiusX. The correspond field should be updated properly.
     */
    public void testSetRadiusX() {
        double[] doubles = TestHelper.getRandomDoubles();

        for (double item : doubles) {
            instance.setRadiusX(item);
            assertTrue("incorrect double value", item == instance.getRadiusX());
        }
    }

    /**
     * Tests method getRadiusY. The correspond field should be returned properly.
     */
    public void testGetRadiusY() {
        double[] doubles = TestHelper.getRandomDoubles();

        for (double item : doubles) {
            instance.setRadiusY(item);
            assertTrue("incorrect double value", item == instance.getRadiusY());
        }
    }

    /**
     * Tests method setRadiusY. The correspond field should be updated properly.
     */
    public void testSetRadiusY() {
        double[] doubles = TestHelper.getRandomDoubles();

        for (double item : doubles) {
            instance.setRadiusY(item);
            assertTrue("incorrect double value", item == instance.getRadiusY());
        }
    }

    /**
     * Tests method getRotation. The correspond field should be returned properly.
     */
    public void testGetRotation() {
        double[] doubles = TestHelper.getRandomDoubles();

        for (double item : doubles) {
            instance.setRotation(item);
            assertTrue("incorrect double value", item == instance.getRotation());
        }
    }

    /**
     * Tests method setRotation. The correspond field should be updated properly.
     */
    public void testSetRotation() {
        double[] doubles = TestHelper.getRandomDoubles();

        for (double item : doubles) {
            instance.setRotation(item);
            assertTrue("incorrect double value", item == instance.getRotation());
        }
    }

    /**
     * Tests method getStartAngle. The correspond field should be returned properly.
     */
    public void testGetStartAngle() {
        double[] doubles = TestHelper.getRandomDoubles();

        for (double item : doubles) {
            instance.setStartAngle(item);
            assertTrue("incorrect double value", item == instance.getStartAngle());
        }
    }

    /**
     * Tests method setStartAngle. The correspond field should be updated properly.
     */
    public void testSetStartAngle() {
        double[] doubles = TestHelper.getRandomDoubles();

        for (double item : doubles) {
            instance.setStartAngle(item);
            assertTrue("incorrect double value", item == instance.getStartAngle());
        }
    }

    /**
     * Tests method getEndAngle. The correspond field should be returned properly.
     */
    public void testGetEndAngle() {
        double[] doubles = TestHelper.getRandomDoubles();

        for (double item : doubles) {
            instance.setEndAngle(item);
            assertTrue("incorrect double value", item == instance.getEndAngle());
        }
    }

    /**
     * Tests method setEndAngle. The correspond field should be updated properly.
     */
    public void testSetEndAngle() {
        double[] doubles = TestHelper.getRandomDoubles();

        for (double item : doubles) {
            instance.setEndAngle(item);
            assertTrue("incorrect double value", item == instance.getEndAngle());
        }
    }
}