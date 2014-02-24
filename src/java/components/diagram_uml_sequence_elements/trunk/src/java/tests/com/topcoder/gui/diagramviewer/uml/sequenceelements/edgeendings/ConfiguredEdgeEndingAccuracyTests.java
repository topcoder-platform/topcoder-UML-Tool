/*
 * Copyright (C) 2007 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.gui.diagramviewer.uml.sequenceelements.edgeendings;

import java.awt.Color;
import java.awt.Point;
import java.util.EnumMap;

import junit.framework.TestCase;

import com.topcoder.gui.diagramviewer.uml.sequenceelements.RenderScheme;
import com.topcoder.gui.diagramviewer.uml.sequenceelements.accuracytests.AccuracyTestHelper;

/**
 * This class aggregates accuracy tests for ConfiguredEdgeEnding.
 *
 * @author ch_music
 * @version 1.0
 */
public class ConfiguredEdgeEndingAccuracyTests extends TestCase {

    /**
     * The ConfiguredEdgeEnding instance.
     */
    private ConfiguredEdgeEnding test;

    /**
     * <p>
     * The propertyNameMapping enum map.
     * </p>
     */
    private EnumMap<ConfiguredEdgeEndingPropertyType, String> propertyNameMapping;

    /**
     * Sets up testing environment.
     *
     * @throws Exception to JUnit
     */
    public void setUp() throws Exception {
        AccuracyTestHelper.loadConfig(
                "com.topcoder.gui.diagramviewer.uml.sequenceelements.edgeendings.configurededgeending",
                AccuracyTestHelper.CONFIGPATH);

        propertyNameMapping = new EnumMap<ConfiguredEdgeEndingPropertyType, String>(
                ConfiguredEdgeEndingPropertyType.class);
        propertyNameMapping.put(ConfiguredEdgeEndingPropertyType.ARROW_X_LENGTH, "5");
        propertyNameMapping.put(ConfiguredEdgeEndingPropertyType.ARROW_Y_LENGTH, "5");

        test = new AccuracyTestMockConfiguredEdgeEnding(propertyNameMapping);
    }

    /**
     * Tears down testing environment.
     *
     * @throws Exception to JUnit
     */
    public void tearDown() throws Exception {
        AccuracyTestHelper.tearConfig();
    }

    /**
     * Tests constructor for accuracy.
     */
    public void testConfiguredEdgeEnding1() {
        assertNotNull("Constructor fails to create instance.", test);
        assertEquals("Fails to retrieve configuration properly.", Color.WHITE, test.getFillColor());
        assertEquals("Fails to retrieve configuration properly.", Color.BLACK, test.getStrokeColor());
        assertEquals("Fails to retrieve configuration properly.", RenderScheme.TopCoderScheme, test
                .getRenderScheme());
        assertEquals("Fails to retrieve configuration properly.", 10, test.getArrowXLength());
        assertEquals("Fails to retrieve configuration properly.", 10, test.getArrowYLength());
    }

    /**
     * Tests constructor for accuracy.
     */
    public void testConfiguredEdgeEnding2() {
        test = new AccuracyTestMockConfiguredEdgeEnding(1.0, new Point(), propertyNameMapping);
        assertNotNull("Constructor fails to create instance.", test);
        assertEquals("Fails to retrieve configuration properly.", Color.WHITE, test.getFillColor());
        assertEquals("Fails to retrieve configuration properly.", Color.BLACK, test.getStrokeColor());
        assertEquals("Fails to retrieve configuration properly.", RenderScheme.TopCoderScheme, test
                .getRenderScheme());
        assertEquals("Fails to retrieve configuration properly.", 10, test.getArrowXLength());
        assertEquals("Fails to retrieve configuration properly.", 10, test.getArrowYLength());
    }

    /**
     * Tests setArrowXLength for accuracy.
     */
    public void testSetArrowXLength() {
        test.setArrowXLength(10);
        assertEquals("setArrowXLength fails to set correctly.", 10, test.getArrowXLength());
    }

    /**
     * Tests getArrowXLength for accuracy.
     */
    public void testGetArrowXLength() {
        test.setArrowXLength(10);
        assertEquals("getArrowXLength fails to return correct value.", 10, test.getArrowXLength());
    }

    /**
     * Tests setArrowYLength for accuracy.
     */
    public void testSetArrowYLength() {
        test.setArrowYLength(10);
        assertEquals("setArrowYLength fails to set correctly.", 10, test.getArrowYLength());
    }

    /**
     * Tests getArrowYLength for accuracy.
     */
    public void testGetArrowYLength() {
        test.setArrowYLength(10);
        assertEquals("getArrowYLength fails to return correct value.", 10, test.getArrowYLength());
    }

    /**
     * Tests setRenderScheme for accuracy.
     */
    public void testSetRenderScheme() {
        test.setRenderScheme(RenderScheme.TopCoderScheme);
        assertEquals("setRenderScheme fails to set correctly.", RenderScheme.TopCoderScheme, test
                .getRenderScheme());
    }

    /**
     * Tests getRenderScheme for accuracy.
     */
    public void testGetRenderScheme() {
        test.setRenderScheme(RenderScheme.TopCoderScheme);
        assertEquals("getRenderScheme fails to return correct value.", RenderScheme.TopCoderScheme, test
                .getRenderScheme());
    }

    /**
     * Tests setStrokeColor for accuracy.
     */
    public void testSetStrokeColor() {
        test.setStrokeColor(Color.YELLOW);
        assertEquals("setStrokeColor fails to set correctly.", Color.YELLOW, test.getStrokeColor());
    }

    /**
     * Tests getStrokeColor for accuracy.
     */
    public void testGetStrokeColor() {
        test.setStrokeColor(Color.YELLOW);
        assertEquals("getStrokeColor fails to return correct value.", Color.YELLOW, test.getStrokeColor());
    }

    /**
     * Tests setFillColor for accuracy.
     */
    public void testSetFillColor() {
        test.setFillColor(Color.YELLOW);
        assertEquals("setFillColor fails to set correctly.", Color.YELLOW, test.getFillColor());
    }

    /**
     * Tests getFillColor for accuracy.
     */
    public void testGetFillColor() {
        test.setFillColor(Color.YELLOW);
        assertEquals("getFillColor fails to return correct value.", Color.YELLOW, test.getFillColor());
    }

    /**
     * Tests setPropertyNameMappingElement for accuracy.
     */
    public void testSetPropertyNameMappingElement() {
        test.setPropertyNameMappingElement(ConfiguredEdgeEndingPropertyType.ARROW_X_LENGTH, "100");
        assertEquals("setPropertyNameMappingElement fails to set correctly.", "100", test
                .getPropertyNameMappingElement(ConfiguredEdgeEndingPropertyType.ARROW_X_LENGTH));
    }

    /**
     * Tests getPropertyNameMappingElement for accuracy.
     */
    public void testGetPropertyNameMappingElement() {
        test.setPropertyNameMappingElement(ConfiguredEdgeEndingPropertyType.ARROW_X_LENGTH, "100");
        assertEquals("setPropertyNameMappingElement fails to return correct value.", "100", test
                .getPropertyNameMappingElement(ConfiguredEdgeEndingPropertyType.ARROW_X_LENGTH));
    }
}
