/*
 * Copyright (C) 2007 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.gui.diagramviewer.uml.sequenceelements.failuretests;

import java.awt.Point;
import java.util.EnumMap;

import com.topcoder.gui.diagramviewer.uml.sequenceelements.edgeendings.ConfiguredEdgeEndingPropertyType;
import com.topcoder.gui.diagramviewer.uml.sequenceelements.edgeendings.FilledArrowEdgeEnding;

import junit.framework.TestCase;

/**
 * <p>
 * Failure test for <code>{@link FilledArrowEdgeEnding}</code> class.
 * </p>
 * @author FireIce
 * @version 1.0
 */
public class FilledArrowEdgeEndingFailureTests extends TestCase {

    /**
     * <p>
     * Represents the property name mapping.
     * </p>
     */
    private EnumMap<ConfiguredEdgeEndingPropertyType, String> propertyNameMapping;

    /**
     * <p>
     * Represents the ending point.
     * </p>
     */
    private Point endingPoint;

    /**
     * <p>
     * Setup the testing environment.
     * </p>
     * @throws Exception
     *             pass any unexpected exception to JUnit.
     */
    @Override
    protected void setUp() throws Exception {
        super.setUp();
        endingPoint = new Point();
        propertyNameMapping = new EnumMap<ConfiguredEdgeEndingPropertyType, String>(
            ConfiguredEdgeEndingPropertyType.class);
        propertyNameMapping.put(ConfiguredEdgeEndingPropertyType.FILL_COLOR, "red");
    }

    /**
     * <p>
     * Failure test for {@link FilledArrowEdgeEnding#FilledArrowEdgeEnding(EnumMap)} constructor.
     * </p>
     */
    public void testFilledArrowEdgeEnding1_NullPropertyNameMapping() {
        propertyNameMapping = null;
        try {
            new FilledArrowEdgeEnding(propertyNameMapping);
            fail("expect throw IllegalArgumentException.");
        } catch (IllegalArgumentException e) {
            // expected
        }
    }

    /**
     * <p>
     * Failure test for {@link FilledArrowEdgeEnding#FilledArrowEdgeEnding(EnumMap)} constructor.
     * </p>
     */
    public void testFilledArrowEdgeEnding1_EmptyPropertyNameMapping() {
        propertyNameMapping.clear();
        try {
            new FilledArrowEdgeEnding(propertyNameMapping);
            fail("expect throw IllegalArgumentException.");
        } catch (IllegalArgumentException e) {
            // expected
        }
    }

    /**
     * <p>
     * Failure test for {@link FilledArrowEdgeEnding#FilledArrowEdgeEnding(double, Point, EnumMap)} constructor.
     * </p>
     */
    public void testFilledArrowEdgeEnding2_NullEndingPoint() {
        endingPoint = null;
        try {
            new FilledArrowEdgeEnding(1, endingPoint, propertyNameMapping);
            fail("expect throw IllegalArgumentException.");
        } catch (IllegalArgumentException e) {
            // expected
        }
    }

    /**
     * <p>
     * Failure test for {@link FilledArrowEdgeEnding#FilledArrowEdgeEnding(double, Point, EnumMap)} constructor.
     * </p>
     */
    public void testFilledArrowEdgeEnding2_NullPropertyNameMapping() {
        propertyNameMapping = null;
        try {
            new FilledArrowEdgeEnding(1, endingPoint, propertyNameMapping);
            fail("expect throw IllegalArgumentException.");
        } catch (IllegalArgumentException e) {
            // expected
        }
    }

    /**
     * <p>
     * Failure test for {@link FilledArrowEdgeEnding#FilledArrowEdgeEnding(double, Point, EnumMap)} constructor.
     * </p>
     */
    public void testFilledArrowEdgeEnding2_EmptyPropertyNameMapping() {
        propertyNameMapping.clear();

        try {
            new FilledArrowEdgeEnding(1, endingPoint, propertyNameMapping);
            fail("expect throw IllegalArgumentException.");
        } catch (IllegalArgumentException e) {
            // expected
        }
    }
}