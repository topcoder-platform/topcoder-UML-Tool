/*
 * Copyright (C) 2007 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.gui.diagramviewer.uml.sequenceelements.edgeendings;

import java.awt.Point;
import java.util.EnumMap;

import junit.framework.TestCase;
import junit.framework.TestSuite;
import junit.framework.Test;

/**
 * <p>
 * Unit test cases for EmptyArrowEdgeEnding.
 * </p>
 *
 * @author TCSDEVELOPER
 * @version 1.1
 * @since 1.0
 */
public class EmptyArrowEdgeEndingTests extends TestCase {
    /**
     * <p>
     * EmptyArrowEdgeEnding instance for testing.
     * </p>
     */
    private EmptyArrowEdgeEnding ending;

    /**
     * <p>
     * The propertyNameMapping enum map for testing.
     * </p>
     */
    private EnumMap<ConfiguredEdgeEndingPropertyType, String> propertyNameMapping;

    /**
     * <p>
     * Point instance for testing.
     * </p>
     */
    private Point endingPoint;

    /**
     * <p>
     * Sets up test environment.
     * </p>
     *
     */
    protected void setUp() {
        endingPoint = new Point();
        propertyNameMapping = new EnumMap<ConfiguredEdgeEndingPropertyType, String>(
            ConfiguredEdgeEndingPropertyType.class);
        propertyNameMapping.put(ConfiguredEdgeEndingPropertyType.ARROW_X_LENGTH, "value");

        ending = new EmptyArrowEdgeEnding(propertyNameMapping);
    }

    /**
     * <p>
     * Tears down test environment.
     * </p>
     *
     */
    protected void tearDown() {
        ending = null;
        propertyNameMapping = null;
        endingPoint = null;
    }

    /**
     * <p>
     * Returns all tests.
     * </p>
     *
     * @return all tests
     */
    public static Test suite() {
        return new TestSuite(EmptyArrowEdgeEndingTests.class);
    }

    /**
     * <p>
     * Tests ctor EmptyArrowEdgeEnding#EmptyArrowEdgeEnding(double,Point,EnumMap) for accuracy.
     * </p>
     *
     * <p>
     * It verifies the newly created EmptyArrowEdgeEnding instance should not be null.
     * </p>
     */
    public void testCtor1() {
        assertNotNull("Failed to create a new EmptyArrowEdgeEnding instance.", new EmptyArrowEdgeEnding(3.0,
            endingPoint, propertyNameMapping));
    }

    /**
     * <p>
     * Tests ctor EmptyArrowEdgeEnding#EmptyArrowEdgeEnding(double,Point,EnumMap) for failure.
     * </p>
     *
     * <p>
     * It tests the case that when endingPoint is null and expects IllegalArgumentException.
     * </p>
     */
    public void testCtor1_NullEndingPoint() {
        try {
            new EmptyArrowEdgeEnding(3.0, null, propertyNameMapping);
            fail("IllegalArgumentException expected.");
        } catch (IllegalArgumentException iae) {
            //good
        }
    }

    /**
     * <p>
     * Tests ctor EmptyArrowEdgeEnding#EmptyArrowEdgeEnding(double,Point,EnumMap) for failure.
     * </p>
     *
     * <p>
     * It tests the case that when propertyNameMapping is null and expects IllegalArgumentException.
     * </p>
     */
    public void testCtor1_NullPropertyNameMapping() {
        try {
            new EmptyArrowEdgeEnding(3.0, endingPoint, null);
            fail("IllegalArgumentException expected.");
        } catch (IllegalArgumentException iae) {
            //good
        }
    }

    /**
     * <p>
     * Tests ctor EmptyArrowEdgeEnding#EmptyArrowEdgeEnding(double,Point,EnumMap) for failure.
     * </p>
     *
     * <p>
     * It tests the case that when propertyNameMapping is empty and expects IllegalArgumentException.
     * </p>
     */
    public void testCtor1_EmptyPropertyNameMapping() {
        propertyNameMapping = new EnumMap<ConfiguredEdgeEndingPropertyType, String>(
            ConfiguredEdgeEndingPropertyType.class);
        try {
            new EmptyArrowEdgeEnding(3.0, endingPoint, propertyNameMapping);
            fail("IllegalArgumentException expected.");
        } catch (IllegalArgumentException iae) {
            //good
        }
    }

    /**
     * <p>
     * Tests ctor EmptyArrowEdgeEnding#EmptyArrowEdgeEnding(EnumMap) for accuracy.
     * </p>
     *
     * <p>
     * It verifies the newly created EmptyArrowEdgeEnding instance should not be null.
     * </p>
     */
    public void testCtor2() {
        assertNotNull("Failed to create a new EmptyArrowEdgeEnding instance.", ending);
    }

    /**
     * <p>
     * Tests ctor EmptyArrowEdgeEnding#EmptyArrowEdgeEnding(EnumMap) for failure.
     * </p>
     *
     * <p>
     * It tests the case that when propertyNameMapping is null and expects IllegalArgumentException.
     * </p>
     */
    public void testCtor2_NullPropertyNameMapping() {
        try {
            new EmptyArrowEdgeEnding(null);
            fail("IllegalArgumentException expected.");
        } catch (IllegalArgumentException iae) {
            //good
        }
    }

    /**
     * <p>
     * Tests ctor EmptyArrowEdgeEnding#EmptyArrowEdgeEnding(EnumMap) for failure.
     * </p>
     *
     * <p>
     * It tests the case that when propertyNameMapping is empty and expects IllegalArgumentException.
     * </p>
     */
    public void testCtor2_EmptyPropertyNameMapping() {
        propertyNameMapping = new EnumMap<ConfiguredEdgeEndingPropertyType, String>(
            ConfiguredEdgeEndingPropertyType.class);
        try {
            new EmptyArrowEdgeEnding(propertyNameMapping);
            fail("IllegalArgumentException expected.");
        } catch (IllegalArgumentException iae) {
            //good
        }
    }

    /**
     * <p>
     * Tests EmptyArrowEdgeEnding#paintComponent(Graphics) for failure.
     * </p>
     *
     * <p>
     * It tests the case that when g is null and expects IllegalArgumentException.
     * </p>
     */
    public void testPaintComponent_NullG() {
        try {
            ending.paintComponent(null);
            fail("IllegalArgumentException expected.");
        } catch (IllegalArgumentException iae) {
            //good
        }
    }

}