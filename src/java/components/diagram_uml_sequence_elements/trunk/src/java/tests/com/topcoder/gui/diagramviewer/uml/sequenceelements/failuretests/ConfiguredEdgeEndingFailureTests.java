/*
 * Copyright (C) 2007 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.gui.diagramviewer.uml.sequenceelements.failuretests;

import java.awt.Point;
import java.util.EnumMap;

import com.topcoder.gui.diagramviewer.uml.sequenceelements.SequenceEdge;
import com.topcoder.gui.diagramviewer.uml.sequenceelements.SequenceEdgePropertyType;
import com.topcoder.gui.diagramviewer.uml.sequenceelements.edgeendings.ConfiguredEdgeEnding;
import com.topcoder.gui.diagramviewer.uml.sequenceelements.edgeendings.ConfiguredEdgeEndingPropertyType;

import junit.framework.TestCase;

/**
 * <p>
 * Failure test for <code>{@link ConfiguredEdgeEnding}</code> class.
 * </p>
 * @author FireIce
 * @version 1.0
 */
public class ConfiguredEdgeEndingFailureTests extends TestCase {

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
     * Represents the ConfiguredEdgeEnding instance.
     * </p>
     */
    private ConfiguredEdgeEnding configuredEdgeEnding;

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

        configuredEdgeEnding = new MockConfiguredEdgeEnding(propertyNameMapping);
    }

    /**
     * <p>
     * Failure test for {@link ConfiguredEdgeEnding} constructor.
     * </p>
     */
    public void testConfiguredEdgeEnding1_NullPropertyNameMapping() {
        propertyNameMapping = null;
        try {
            new MockConfiguredEdgeEnding(propertyNameMapping);
            fail("expect throw IllegalArgumentException.");
        } catch (IllegalArgumentException e) {
            // expected
        }
    }

    /**
     * <p>
     * Failure test for {@link ConfiguredEdgeEnding} constructor.
     * </p>
     */
    public void testConfiguredEdgeEnding1_EmptyPropertyNameMapping() {
        propertyNameMapping.clear();
        try {
            new MockConfiguredEdgeEnding(propertyNameMapping);
            fail("expect throw IllegalArgumentException.");
        } catch (IllegalArgumentException e) {
            // expected
        }
    }

    /**
     * <p>
     * Failure test for {@link ConfiguredEdgeEnding} constructor.
     * </p>
     */
    public void testConfiguredEdgeEnding2_NullEndingPoint() {
        endingPoint = null;
        try {
            new MockConfiguredEdgeEnding(1, endingPoint, propertyNameMapping);
            fail("expect throw IllegalArgumentException.");
        } catch (IllegalArgumentException e) {
            // expected
        }
    }

    /**
     * <p>
     * Failure test for {@link ConfiguredEdgeEnding} constructor.
     * </p>
     */
    public void testConfiguredEdgeEnding2_NullPropertyNameMapping() {
        propertyNameMapping = null;
        try {
            new MockConfiguredEdgeEnding(1, endingPoint, propertyNameMapping);
            fail("expect throw IllegalArgumentException.");
        } catch (IllegalArgumentException e) {
            // expected
        }
    }

    /**
     * <p>
     * Failure test for {@link ConfiguredEdgeEnding} constructor.
     * </p>
     */
    public void testConfiguredEdgeEnding2_EmptyPropertyNameMapping() {
        propertyNameMapping.clear();

        try {
            new MockConfiguredEdgeEnding(1, endingPoint, propertyNameMapping);
            fail("expect throw IllegalArgumentException.");
        } catch (IllegalArgumentException e) {
            // expected
        }
    }

    /**
     * <p>
     * Failure test for <code>{@link ConfiguredEdgeEnding#setArrowXLength(int)}</code> method.
     * </p>
     */
    public void testSetArrowXLength_zeroLength() {
        try {
            configuredEdgeEnding.setArrowXLength(0);
            fail("expect throw IllegalArgumentException.");
        } catch (IllegalArgumentException e) {
            // expected
        }
    }

    /**
     * <p>
     * Failure test for <code>{@link ConfiguredEdgeEnding#setArrowXLength(int)}</code> method.
     * </p>
     */
    public void testSetArrowXLength_NegativeLength() {
        try {
            configuredEdgeEnding.setArrowXLength(-1);
            fail("expect throw IllegalArgumentException.");
        } catch (IllegalArgumentException e) {
            // expected
        }
    }

    /**
     * <p>
     * Failure test for <code>{@link ConfiguredEdgeEnding#setArrowXLength(int)}</code> method.
     * </p>
     */
    public void testSetArrowYLength_zeroLength() {
        try {
            configuredEdgeEnding.setArrowXLength(0);
            fail("expect throw IllegalArgumentException.");
        } catch (IllegalArgumentException e) {
            // expected
        }
    }

    /**
     * <p>
     * Failure test for <code>{@link ConfiguredEdgeEnding#setArrowXLength(int)}</code> method.
     * </p>
     */
    public void testSetArrowYLength_NegativeLength() {
        try {
            configuredEdgeEnding.setArrowXLength(-1);
            fail("expect throw IllegalArgumentException.");
        } catch (IllegalArgumentException e) {
            // expected
        }
    }

    /**
     * <p>
     * Failure test for <code>{@link ConfiguredEdgeEnding#setStrokeColor(java.awt.Color)}</code> method.
     * </p>
     */
    public void testSetStrokeColor_nullColor() {
        try {
            configuredEdgeEnding.setStrokeColor(null);
            fail("expect throw IllegalArgumentException.");
        } catch (IllegalArgumentException e) {
            // expected
        }
    }

    /**
     * <p>
     * Failure test for <code>{@link ConfiguredEdgeEnding#setFillColor(java.awt.Color)}</code> method.
     * </p>
     */
    public void testSetFillColor_nullColor() {
        try {
            configuredEdgeEnding.setFillColor(null);
            fail("expect throw IllegalArgumentException.");
        } catch (IllegalArgumentException e) {
            // expected
        }
    }

    /**
     * <p>
     * Failure test for
     * <code>{@link SequenceEdge#setPropertyNameMappingElement(SequenceEdgePropertyType, String)}</code> method
     * </p>
     */
    public void testSetPropertyNameMappingElement_NullKey() {
        try {
            configuredEdgeEnding.setPropertyNameMappingElement(null, "Value");
            fail("expect throw IllegalArgumentException.");
        } catch (IllegalArgumentException e) {
            // expected
        }
    }

    /**
     * <p>
     * Failure test for
     * <code>{@link SequenceEdge#setPropertyNameMappingElement(SequenceEdgePropertyType, String)}</code> method
     * </p>
     */
    public void testSetPropertyNameMappingElement_NullValue() {
        try {
            configuredEdgeEnding.setPropertyNameMappingElement(ConfiguredEdgeEndingPropertyType.FILL_COLOR, null);
            fail("expect throw IllegalArgumentException.");
        } catch (IllegalArgumentException e) {
            // expected
        }
    }

    /**
     * <p>
     * Failure test for
     * <code>{@link SequenceEdge#setPropertyNameMappingElement(SequenceEdgePropertyType, String)}</code> method
     * </p>
     */
    public void testSetPropertyNameMappingElement_EmptyValue() {
        try {
            configuredEdgeEnding.setPropertyNameMappingElement(ConfiguredEdgeEndingPropertyType.FILL_COLOR, "");
            fail("expect throw IllegalArgumentException.");
        } catch (IllegalArgumentException e) {
            // expected
        }
    }

    /**
     * <p>
     * Failure test for
     * <code>{@link SequenceEdge#setPropertyNameMappingElement(SequenceEdgePropertyType, String)}</code> method
     * </p>
     */
    public void testSetPropertyNameMappingElement_TrimmedEmptyValue() {
        try {
            configuredEdgeEnding.setPropertyNameMappingElement(ConfiguredEdgeEndingPropertyType.FILL_COLOR, "");
            fail("expect throw IllegalArgumentException.");
        } catch (IllegalArgumentException e) {
            // expected
        }
    }
}