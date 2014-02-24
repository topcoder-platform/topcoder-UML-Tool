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
 * Unit test cases for NothingEdgeEnding.
 * </p>
 *
 * @author TCSDEVELOPER
 * @version 1.1
 * @since 1.0
 */
public class NothingEdgeEndingTests extends TestCase {
    /**
     * <p>
     * NothingEdgeEnding instance for testing.
     * </p>
     */
    private NothingEdgeEnding ending;

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

        ending = new NothingEdgeEnding(propertyNameMapping);
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
        return new TestSuite(NothingEdgeEndingTests.class);
    }

    /**
     * <p>
     * Tests ctor NothingEdgeEnding#NothingEdgeEnding(double,Point,EnumMap) for accuracy.
     * </p>
     *
     * <p>
     * It verifies the newly created NothingEdgeEnding instance should not be null.
     * </p>
     */
    public void testCtor1() {
        assertNotNull("Failed to create a new NothingEdgeEnding instance.", new NothingEdgeEnding(3.0, endingPoint,
            propertyNameMapping));
    }

    /**
     * <p>
     * Tests ctor NothingEdgeEnding#NothingEdgeEnding(double,Point,EnumMap) for failure.
     * </p>
     *
     * <p>
     * It tests the case that when endingPoint is null and expects IllegalArgumentException.
     * </p>
     */
    public void testCtor1_NullEndingPoint() {
        try {
            new NothingEdgeEnding(3.0, null, propertyNameMapping);
            fail("IllegalArgumentException expected.");
        } catch (IllegalArgumentException iae) {
            //good
        }
    }

    /**
     * <p>
     * Tests ctor NothingEdgeEnding#NothingEdgeEnding(double,Point,EnumMap) for failure.
     * </p>
     *
     * <p>
     * It tests the case that when propertyNameMapping is null and expects IllegalArgumentException.
     * </p>
     */
    public void testCtor1_NullPropertyNameMapping() {
        try {
            new NothingEdgeEnding(3.0, endingPoint, null);
            fail("IllegalArgumentException expected.");
        } catch (IllegalArgumentException iae) {
            //good
        }
    }

    /**
     * <p>
     * Tests ctor NothingEdgeEnding#NothingEdgeEnding(double,Point,EnumMap) for failure.
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
            new NothingEdgeEnding(3.0, endingPoint, propertyNameMapping);
            fail("IllegalArgumentException expected.");
        } catch (IllegalArgumentException iae) {
            //good
        }
    }

    /**
     * <p>
     * Tests ctor NothingEdgeEnding#NothingEdgeEnding(EnumMap) for accuracy.
     * </p>
     *
     * <p>
     * It verifies the newly created NothingEdgeEnding instance should not be null.
     * </p>
     */
    public void testCtor2() {
        assertNotNull("Failed to create a new NothingEdgeEnding instance.", ending);
    }

    /**
     * <p>
     * Tests ctor NothingEdgeEnding#NothingEdgeEnding(EnumMap) for failure.
     * </p>
     *
     * <p>
     * It tests the case that when propertyNameMapping is null and expects IllegalArgumentException.
     * </p>
     */
    public void testCtor2_NullPropertyNameMapping() {
        try {
            new NothingEdgeEnding(null);
            fail("IllegalArgumentException expected.");
        } catch (IllegalArgumentException iae) {
            //good
        }
    }

    /**
     * <p>
     * Tests ctor NothingEdgeEnding#NothingEdgeEnding(EnumMap) for failure.
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
            new NothingEdgeEnding(propertyNameMapping);
            fail("IllegalArgumentException expected.");
        } catch (IllegalArgumentException iae) {
            //good
        }
    }

    /**
     * <p>
     * Tests NothingEdgeEnding#paintComponent(Graphics) for failure.
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