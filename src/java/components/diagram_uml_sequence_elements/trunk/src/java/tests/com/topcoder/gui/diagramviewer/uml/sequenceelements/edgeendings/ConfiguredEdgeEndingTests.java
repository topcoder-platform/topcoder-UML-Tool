/*
 * Copyright (C) 2007 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.gui.diagramviewer.uml.sequenceelements.edgeendings;

import java.awt.Color;
import java.awt.Point;
import java.util.EnumMap;

import com.topcoder.gui.diagramviewer.uml.sequenceelements.RenderScheme;

import junit.framework.TestCase;
import junit.framework.TestSuite;
import junit.framework.Test;

/**
 * <p>
 * Unit test cases for ConfiguredEdgeEnding.
 * </p>
 *
 * @author TCSDEVELOPER
 * @version 1.1
 * @since 1.0
 */
public class ConfiguredEdgeEndingTests extends TestCase {
    /**
     * <p>
     * ConfiguredEdgeEnding instance for testing.
     * </p>
     */
    private ConfiguredEdgeEnding ending;
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

        ending = new MockConfiguredEdgeEnding(propertyNameMapping);
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
        return new TestSuite(ConfiguredEdgeEndingTests.class);
    }

    /**
     * <p>
     * Tests ctor ConfiguredEdgeEnding#ConfiguredEdgeEnding(EnumMap) for accuracy.
     * </p>
     *
     * <p>
     * It verifies the newly created ConfiguredEdgeEnding instance should not be null.
     * </p>
     */
    public void testCtor1() {
        assertNotNull("Failed to create a new ConfiguredEdgeEnding instance.", ending);
    }

    /**
     * <p>
     * Tests ctor ConfiguredEdgeEnding#ConfiguredEdgeEnding(EnumMap) for failure.
     * </p>
     *
     * <p>
     * It tests the case that when propertyNameMapping is null and expects IllegalArgumentException.
     * </p>
     */
    public void testCtor1_NullPropertyNameMapping() {
        try {
            new MockConfiguredEdgeEnding(null);
            fail("IllegalArgumentException expected.");
        } catch (IllegalArgumentException iae) {
            //good
        }
    }

    /**
     * <p>
     * Tests ctor ConfiguredEdgeEnding#ConfiguredEdgeEnding(EnumMap) for failure.
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
            new MockConfiguredEdgeEnding(propertyNameMapping);
            fail("IllegalArgumentException expected.");
        } catch (IllegalArgumentException iae) {
            //good
        }
    }

    /**
     * <p>
     * Tests ctor ConfiguredEdgeEnding#ConfiguredEdgeEnding(double,Point,EnumMap) for accuracy.
     * </p>
     *
     * <p>
     * It verifies the newly created ConfiguredEdgeEnding instance should not be null.
     * </p>
     */
    public void testCtor2() {
        assertNotNull("Failed to create a new ConfiguredEdgeEnding instance.", new MockConfiguredEdgeEnding(3.0,
            endingPoint, propertyNameMapping));
    }

    /**
     * <p>
     * Tests ctor ConfiguredEdgeEnding#ConfiguredEdgeEnding(double,Point,EnumMap) for failure.
     * </p>
     *
     * <p>
     * It tests the case that when endingPoint is null and expects IllegalArgumentException.
     * </p>
     */
    public void testCtor2_NullEndingPoint() {
        try {
            new MockConfiguredEdgeEnding(2.0, null, propertyNameMapping);
            fail("IllegalArgumentException expected.");
        } catch (IllegalArgumentException iae) {
            //good
        }
    }

    /**
     * <p>
     * Tests ctor ConfiguredEdgeEnding#ConfiguredEdgeEnding(double,Point,EnumMap) for failure.
     * </p>
     *
     * <p>
     * It tests the case that when proreptyNameMapping is null and expects IllegalArgumentException.
     * </p>
     */
    public void testCtor2_NullProreptyNameMapping() {
        try {
            new MockConfiguredEdgeEnding(2.0, endingPoint, null);
            fail("IllegalArgumentException expected.");
        } catch (IllegalArgumentException iae) {
            //good
        }
    }

    /**
     * <p>
     * Tests ctor ConfiguredEdgeEnding#ConfiguredEdgeEnding(double,Point,EnumMap) for failure.
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
            new MockConfiguredEdgeEnding(2.0, endingPoint, propertyNameMapping);
            fail("IllegalArgumentException expected.");
        } catch (IllegalArgumentException iae) {
            //good
        }
    }

    /**
     * <p>
     * Tests ConfiguredEdgeEnding#setStrokeColor(Color) for accuracy.
     * </p>
     *
     * <p>
     * It verifies ConfiguredEdgeEnding#setStrokeColor(Color) is correct.
     * </p>
     */
    public void testSetStrokeColor() {
        ending.setStrokeColor(Color.RED);
        assertEquals("Failed to set the color correctly.", Color.RED, ending.getStrokeColor());
    }

    /**
     * <p>
     * Tests ConfiguredEdgeEnding#setStrokeColor(Color) for failure.
     * </p>
     *
     * <p>
     * It tests the case that when strokeColor is null and expects IllegalArgumentException.
     * </p>
     */
    public void testSetStrokeColor_NullStrokeColor() {
        try {
            ending.setStrokeColor(null);
            fail("IllegalArgumentException expected.");
        } catch (IllegalArgumentException iae) {
            //good
        }
    }

    /**
     * <p>
     * Tests ConfiguredEdgeEnding#getStrokeColor() for accuracy.
     * </p>
     *
     * <p>
     * It verifies ConfiguredEdgeEnding#getStrokeColor() is correct.
     * </p>
     */
    public void testGetStrokeColor() {
        ending.setStrokeColor(Color.RED);
        assertEquals("Failed to get the color correctly.", Color.RED, ending.getStrokeColor());
    }

    /**
     * <p>
     * Tests ConfiguredEdgeEnding#setFillColor(Color) for accuracy.
     * </p>
     *
     * <p>
     * It verifies ConfiguredEdgeEnding#setFillColor(Color) is correct.
     * </p>
     */
    public void testSetFillColor() {
        ending.setFillColor(Color.RED);
        assertEquals("Failed to set the color correctly.", Color.RED, ending.getFillColor());
    }

    /**
     * <p>
     * Tests ConfiguredEdgeEnding#setFillColor(Color) for failure.
     * </p>
     *
     * <p>
     * It tests the case that when fillColor is null and expects IllegalArgumentException.
     * </p>
     */
    public void testSetFillColor_NullFillColor() {
        try {
            ending.setFillColor(null);
            fail("IllegalArgumentException expected.");
        } catch (IllegalArgumentException iae) {
            //good
        }
    }

    /**
     * <p>
     * Tests ConfiguredEdgeEnding#getFillColor() for accuracy.
     * </p>
     *
     * <p>
     * It verifies ConfiguredEdgeEnding#getFillColor() is correct.
     * </p>
     */
    public void testGetFillColor() {
        ending.setFillColor(Color.RED);
        assertEquals("Failed to get the color correctly.", Color.RED, ending.getFillColor());
    }

    /**
     * <p>
     * Tests ConfiguredEdgeEnding#setRenderScheme(RenderScheme) for accuracy.
     * </p>
     *
     * <p>
     * It verifies ConfiguredEdgeEnding#setRenderScheme(RenderScheme) is correct.
     * </p>
     */
    public void testSetRenderScheme() {
        ending.setRenderScheme(RenderScheme.SimpleScheme);
        assertEquals("Failed to set the render scheme correctly.", RenderScheme.SimpleScheme, ending.getRenderScheme());
    }

    /**
     * <p>
     * Tests ConfiguredEdgeEnding#setRenderScheme(RenderScheme) for failure.
     * </p>
     *
     * <p>
     * It tests the case that when renderScheme is null and expects IllegalArgumentException.
     * </p>
     */
    public void testSetRenderScheme_NullRenderScheme() {
        try {
            ending.setRenderScheme(null);
            fail("IllegalArgumentException expected.");
        } catch (IllegalArgumentException iae) {
            //good
        }
    }

    /**
     * <p>
     * Tests ConfiguredEdgeEnding#getRenderScheme() for accuracy.
     * </p>
     *
     * <p>
     * It verifies ConfiguredEdgeEnding#getRenderScheme() is correct.
     * </p>
     */
    public void testGetRenderScheme() {
        ending.setRenderScheme(RenderScheme.SimpleScheme);
        assertEquals("Failed to get the render scheme correctly.", RenderScheme.SimpleScheme, ending.getRenderScheme());
    }

    /**
     * <p>
     * Tests ConfiguredEdgeEnding#setPropertyNameMappingElement(ConfiguredEdgeEndingPropertyType,String) for accuracy.
     * </p>
     *
     * <p>
     * It verifies ConfiguredEdgeEnding#setPropertyNameMappingElement
     * (ConfiguredEdgeEndingPropertyType,String) is correct.
     * </p>
     */
    public void testSetPropertyNameMappingElement() {
        ending.setPropertyNameMappingElement(ConfiguredEdgeEndingPropertyType.ARROW_X_LENGTH, "8");
        assertEquals("Failed to set mapping correctly.", "8",
            ending.getPropertyNameMappingElement(ConfiguredEdgeEndingPropertyType.ARROW_X_LENGTH));
    }

    /**
     * <p>
     * Tests ConfiguredEdgeEnding#setPropertyNameMappingElement(ConfiguredEdgeEndingPropertyType,String) for failure.
     * </p>
     *
     * <p>
     * It tests the case that when key is null and expects IllegalArgumentException.
     * </p>
     */
    public void testSetPropertyNameMappingElement_NullKey() {
        try {
            ending.setPropertyNameMappingElement(null, "8");
            fail("IllegalArgumentException expected.");
        } catch (IllegalArgumentException iae) {
            //good
        }
    }

    /**
     * <p>
     * Tests ConfiguredEdgeEnding#setPropertyNameMappingElement(ConfiguredEdgeEndingPropertyType,String) for failure.
     * </p>
     *
     * <p>
     * It tests the case that when value is null and expects IllegalArgumentException.
     * </p>
     */
    public void testSetPropertyNameMappingElement_NullValue() {
        try {
            ending.setPropertyNameMappingElement(ConfiguredEdgeEndingPropertyType.ARROW_X_LENGTH, null);
            fail("IllegalArgumentException expected.");
        } catch (IllegalArgumentException iae) {
            //good
        }
    }

    /**
     * <p>
     * Tests ConfiguredEdgeEnding#setPropertyNameMappingElement(ConfiguredEdgeEndingPropertyType,String) for failure.
     * </p>
     *
     * <p>
     * It tests the case that when value is empty and expects IllegalArgumentException.
     * </p>
     */
    public void testSetPropertyNameMappingElement_EmptyValue() {
        try {
            ending.setPropertyNameMappingElement(ConfiguredEdgeEndingPropertyType.ARROW_X_LENGTH, " ");
            fail("IllegalArgumentException expected.");
        } catch (IllegalArgumentException iae) {
            //good
        }
    }

    /**
     * <p>
     * Tests ConfiguredEdgeEnding#getPropertyNameMappingElement(ConfiguredEdgeEndingPropertyType) for accuracy.
     * </p>
     *
     * <p>
     * It verifies ConfiguredEdgeEnding#getPropertyNameMappingElement(ConfiguredEdgeEndingPropertyType) is correct.
     * </p>
     */
    public void testGetPropertyNameMappingElement() {
        ending.setPropertyNameMappingElement(ConfiguredEdgeEndingPropertyType.ARROW_X_LENGTH, "8");
        assertEquals("Failed to get mapping correctly.", "8",
            ending.getPropertyNameMappingElement(ConfiguredEdgeEndingPropertyType.ARROW_X_LENGTH));
    }

    /**
     * <p>
     * Tests ConfiguredEdgeEnding#getPropertyNameMappingElement(ConfiguredEdgeEndingPropertyType) for failure.
     * </p>
     *
     * <p>
     * It tests the case that when key is null and expects IllegalArgumentException.
     * </p>
     */
    public void testGetPropertyNameMappingElement_NullKey() {
        try {
            ending.getPropertyNameMappingElement(null);
            fail("IllegalArgumentException expected.");
        } catch (IllegalArgumentException iae) {
            //good
        }
    }

    /**
     * <p>
     * Tests ConfiguredEdgeEnding#setArrowXLength(int) for accuracy.
     * </p>
     *
     * <p>
     * It verifies ConfiguredEdgeEnding#setArrowXLength(int) is correct.
     * </p>
     */
    public void testSetArrowXLength() {
        ending.setArrowXLength(5);
        assertEquals("Failed to set the length correctly.", 5, ending.getArrowXLength());
    }

    /**
     * <p>
     * Tests ConfiguredEdgeEnding#setArrowXLength(int) for accuracy.
     * </p>
     *
     * <p>
     * It tests the case that when arrowXLength is not positive and expects IllegalArgumentException.
     * </p>
     */
    public void testSetArrowXLength_NotPositive() {
        try {
            ending.setArrowXLength(-5);
            fail("IllegalArgumentException expected.");
        } catch (IllegalArgumentException iae) {
            //good
        }
    }

    /**
     * <p>
     * Tests ConfiguredEdgeEnding#getArrowXLength() for accuracy.
     * </p>
     *
     * <p>
     * It verifies ConfiguredEdgeEnding#getArrowXLength() is correct.
     * </p>
     */
    public void testGetArrowXLength() {
        ending.setArrowXLength(5);
        assertEquals("Failed to get the length correctly.", 5, ending.getArrowXLength());
    }

    /**
     * <p>
     * Tests ConfiguredEdgeEnding#setArrowYLength(int) for accuracy.
     * </p>
     *
     * <p>
     * It verifies ConfiguredEdgeEnding#setArrowYLength(int) is correct.
     * </p>
     */
    public void testSetArrowYLength() {
        ending.setArrowYLength(5);
        assertEquals("Failed to set the length correctly.", 5, ending.getArrowYLength());
    }

    /**
     * <p>
     * Tests ConfiguredEdgeEnding#setArrowYLength(int) for accuracy.
     * </p>
     *
     * <p>
     * It tests the case that when arrowYLength is not positive and expects IllegalArgumentException.
     * </p>
     */
    public void testSetArrowYLength_NotPositive() {
        try {
            ending.setArrowYLength(-5);
            fail("IllegalArgumentException expected.");
        } catch (IllegalArgumentException iae) {
            //good
        }
    }

    /**
     * <p>
     * Tests ConfiguredEdgeEnding#getArrowYLength() for accuracy.
     * </p>
     *
     * <p>
     * It verifies ConfiguredEdgeEnding#getArrowYLength() is correct.
     * </p>
     */
    public void testGetArrowYLength() {
        ending.setArrowYLength(5);
        assertEquals("Failed to get the length correctly.", 5, ending.getArrowYLength());
    }

}