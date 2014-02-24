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
import com.topcoder.gui.diagramviewer.uml.sequenceelements.accuracytests.AccuracyTestImagePrinter;

/**
 * This class aggregates accuracy tests for FilledArrowEdgeEnding class.
 *
 * @author ch_music
 * @version 1.0
 */
public class FilledArrowEdgeEndingAccuracyTests extends TestCase {

    /**
     * The FilledArrowEdgeEnding instance.
     */
    private FilledArrowEdgeEnding test;

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

        test = new FilledArrowEdgeEnding(0, new Point(100, 100), propertyNameMapping);
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
    public void testFilledArrowEdgeEnding1() {
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
    public void testFilledArrowEdgeEnding2() {
        test = new FilledArrowEdgeEnding(1.0, new Point(), propertyNameMapping);
        assertNotNull("Constructor fails to create instance.", test);
        assertEquals("Fails to retrieve configuration properly.", Color.WHITE, test.getFillColor());
        assertEquals("Fails to retrieve configuration properly.", Color.BLACK, test.getStrokeColor());
        assertEquals("Fails to retrieve configuration properly.", RenderScheme.TopCoderScheme, test
                .getRenderScheme());
        assertEquals("Fails to retrieve configuration properly.", 10, test.getArrowXLength());
        assertEquals("Fails to retrieve configuration properly.", 10, test.getArrowYLength());
    }

    /**
     * Tests paintComponent method for accuracy.
     *
     * @throws Exception to JUnit
     */
    public void testPaintComponentGraphics1() throws Exception {
        AccuracyTestImagePrinter printer = new AccuracyTestImagePrinter(
                "test_files/accuracy_tests/filled_arrow_edge_ending1.jpg");
        test.paintComponent(printer.initImage());
        printer.print();
    }

    /**
     * Tests paintComponent method for accuracy.
     *
     * @throws Exception to JUnit
     */
    public void testPaintComponentGraphics2() throws Exception {
        test.setAngle(Math.PI / 4);
        AccuracyTestImagePrinter printer = new AccuracyTestImagePrinter(
                "test_files/accuracy_tests/filled_arrow_edge_ending2.jpg");
        test.paintComponent(printer.initImage());
        printer.print();
    }

    /**
     * Tests paintComponent method for accuracy.
     *
     * @throws Exception to JUnit
     */
    public void testPaintComponentGraphics3() throws Exception {
        test.setAngle(Math.PI / 4 * 3);
        AccuracyTestImagePrinter printer = new AccuracyTestImagePrinter(
                "test_files/accuracy_tests/filled_arrow_edge_ending3.jpg");
        test.paintComponent(printer.initImage());
        printer.print();
    }
}
