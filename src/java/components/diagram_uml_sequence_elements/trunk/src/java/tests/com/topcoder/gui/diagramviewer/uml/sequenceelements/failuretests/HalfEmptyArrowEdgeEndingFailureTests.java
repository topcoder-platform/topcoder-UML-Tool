/*
 * Copyright (C) 2007 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.gui.diagramviewer.uml.sequenceelements.failuretests;

import java.awt.Point;
import java.util.EnumMap;

import com.topcoder.gui.diagramviewer.uml.sequenceelements.edgeendings.ConfiguredEdgeEndingPropertyType;
import com.topcoder.gui.diagramviewer.uml.sequenceelements.edgeendings.HalfEmptyArrowEdgeEnding;

import junit.framework.TestCase;

/**
 * <p>
 * Failure test for <code>{@link HalfEmptyArrowEdgeEnding}</code> class.
 * </p>
 * @author FireIce
 * @version 1.0
 */
public class HalfEmptyArrowEdgeEndingFailureTests extends TestCase {

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
     * Failure test for {@link HalfEmptyArrowEdgeEnding#HalfEmptyArrowEdgeEnding(EnumMap)} constructor.
     * </p>
     */
    public void testHalfEmptyArrowEdgeEnding1_NullPropertyNameMapping() {
        propertyNameMapping = null;
        try {
            new HalfEmptyArrowEdgeEnding(propertyNameMapping);
            fail("expect throw IllegalArgumentException.");
        } catch (IllegalArgumentException e) {
            // expected
        }
    }

    /**
     * <p>
     * Failure test for {@link HalfEmptyArrowEdgeEnding#HalfEmptyArrowEdgeEnding(EnumMap)} constructor.
     * </p>
     */
    public void testHalfEmptyArrowEdgeEnding1_HalfEmptyPropertyNameMapping() {
        propertyNameMapping.clear();
        try {
            new HalfEmptyArrowEdgeEnding(propertyNameMapping);
            fail("expect throw IllegalArgumentException.");
        } catch (IllegalArgumentException e) {
            // expected
        }
    }

    /**
     * <p>
     * Failure test for {@link HalfEmptyArrowEdgeEnding#HalfEmptyArrowEdgeEnding(double, Point, EnumMap)} constructor.
     * </p>
     */
    public void testHalfEmptyArrowEdgeEnding2_NullEndingPoint() {
        endingPoint = null;
        try {
            new HalfEmptyArrowEdgeEnding(1, endingPoint, propertyNameMapping);
            fail("expect throw IllegalArgumentException.");
        } catch (IllegalArgumentException e) {
            // expected
        }
    }

    /**
     * <p>
     * Failure test for {@link HalfEmptyArrowEdgeEnding#HalfEmptyArrowEdgeEnding(double, Point, EnumMap)} constructor.
     * </p>
     */
    public void testHalfEmptyArrowEdgeEnding2_NullPropertyNameMapping() {
        propertyNameMapping = null;
        try {
            new HalfEmptyArrowEdgeEnding(1, endingPoint, propertyNameMapping);
            fail("expect throw IllegalArgumentException.");
        } catch (IllegalArgumentException e) {
            // expected
        }
    }

    /**
     * <p>
     * Failure test for {@link HalfEmptyArrowEdgeEnding#HalfEmptyArrowEdgeEnding(double, Point, EnumMap)} constructor.
     * </p>
     */
    public void testHalfEmptyArrowEdgeEnding2_HalfEmptyPropertyNameMapping() {
        propertyNameMapping.clear();

        try {
            new HalfEmptyArrowEdgeEnding(1, endingPoint, propertyNameMapping);
            fail("expect throw IllegalArgumentException.");
        } catch (IllegalArgumentException e) {
            // expected
        }
    }
}