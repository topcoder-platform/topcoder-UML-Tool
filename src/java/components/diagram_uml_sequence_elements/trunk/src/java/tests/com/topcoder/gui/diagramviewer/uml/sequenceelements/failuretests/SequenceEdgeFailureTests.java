/*
 * Copyright (C) 2007 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.gui.diagramviewer.uml.sequenceelements.failuretests;

import java.util.EnumMap;

import com.topcoder.diagraminterchange.GraphEdge;
import com.topcoder.diagraminterchange.Point;
import com.topcoder.gui.diagramviewer.edges.EdgeEnding;
import com.topcoder.gui.diagramviewer.edges.LineStyle;
import com.topcoder.gui.diagramviewer.uml.sequenceelements.SequenceEdge;
import com.topcoder.gui.diagramviewer.uml.sequenceelements.SequenceEdgePropertyType;
import com.topcoder.uml.model.commonbehavior.links.Link;
import com.topcoder.uml.model.commonbehavior.links.LinkImpl;

import junit.framework.TestCase;

/**
 * <p>
 * Failure test for <code>{@link SequenceEdge}</code> class.
 * </p>
 * @author FireIce
 * @version 1.0
 */
public class SequenceEdgeFailureTests extends TestCase {
    /**
     * <p>
     * Represents the Link used in testing.
     * </p>
     */
    private Link link;

    /**
     * <p>
     * Represents the GraphEdge used in testing.
     * </p>
     */
    private GraphEdge graphEdge;

    /**
     * <p>
     * Represents the LinkStyle used in testing.
     * </p>
     */
    private LineStyle lineStyle;

    /**
     * <p>
     * Represents the left ending edge.
     * </p>
     */
    private EdgeEnding leftEnding;

    /**
     * <p>
     * Represents the right ending edge.
     * </p>
     */
    private EdgeEnding rightEnding;

    /**
     * <p>
     * Represents the property name mapping.
     * </p>
     */
    private EnumMap<SequenceEdgePropertyType, String> propertyNameMapping;

    /**
     * <p>
     * Represents the <code>{@link SequenceEdge}</code> instance.
     * </p>
     */
    private SequenceEdge sequenceEdge;

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

        link = new LinkImpl();

        graphEdge = FailureTestHelper.createGraphEdge();
        graphEdge.addWaypoint(new Point());
        graphEdge.addWaypoint(new Point());

        lineStyle = new LineStyle(2, 2);

        leftEnding = new MockEdgeEnding();
        rightEnding = new MockEdgeEnding();
        propertyNameMapping = new EnumMap<SequenceEdgePropertyType, String>(SequenceEdgePropertyType.class);
        propertyNameMapping.put(SequenceEdgePropertyType.FILL_COLOR, "red");

        sequenceEdge = new FailureSequenceEdge(link, graphEdge, lineStyle, leftEnding, rightEnding, propertyNameMapping);
    }

    /**
     * <p>
     * Assert the constructor of <code>{@link SequenceEdge}</code>.
     * </p>
     */
    private void assertSequenceEdgeCtor() {
        try {
            new FailureSequenceEdge(link, graphEdge, lineStyle, leftEnding, rightEnding, propertyNameMapping);
            fail("expect throw IllegalArgumentException");
        } catch (IllegalArgumentException e) {
            // expected
        }
    }

    /**
     * <p>
     * Failure test for <code>{@link SequenceEdge}</code> constructor.
     * </p>
     */
    public void testSequenceEdge_NullLink() {
        link = null;

        assertSequenceEdgeCtor();
    }

    /**
     * <p>
     * Failure test for <code>{@link SequenceEdge}</code> constructor.
     * </p>
     */
    public void testSequenceEdge_NullGraphEdge() {
        graphEdge = null;

        assertSequenceEdgeCtor();
    }

    /**
     * <p>
     * Failure test for <code>{@link SequenceEdge}</code> constructor.
     * </p>
     */
    public void testSequenceEdge_NullLineStyle() {
        lineStyle = null;

        assertSequenceEdgeCtor();
    }

    /**
     * <p>
     * Failure test for <code>{@link SequenceEdge}</code> constructor.
     * </p>
     */
    public void testSequenceEdge_NullLeftEnding() {
        leftEnding = null;

        assertSequenceEdgeCtor();
    }

    /**
     * <p>
     * Failure test for <code>{@link SequenceEdge}</code> constructor.
     * </p>
     */
    public void testSequenceEdge_NullRightEnding() {
        rightEnding = null;

        assertSequenceEdgeCtor();
    }

    /**
     * <p>
     * Failure test for <code>{@link SequenceEdge}</code> constructor.
     * </p>
     */
    public void testSequenceEdge_NullPropertyNameMapping() {
        propertyNameMapping = null;

        assertSequenceEdgeCtor();
    }

    /**
     * <p>
     * Failure test for <code>{@link SequenceEdge}</code> constructor.
     * </p>
     */
    public void testSequenceEdge_EmptyPropertyNameMapping() {
        propertyNameMapping.clear();

        assertSequenceEdgeCtor();
    }

    /**
     * <p>
     * Failure test for <code>{@link SequenceEdge#setName(String)}</code> method.
     * </p>
     */
    public void testSetName_NullName() {
        try {
            sequenceEdge.setName(null);
            fail("expect throw IllegalArgumentException.");
        } catch (IllegalArgumentException e) {
            // expected
        }
    }

    /**
     * <p>
     * Failure test for <code>{@link SequenceEdge#setStrokeColor(java.awt.Color)}</code> method.
     * </p>
     */
    public void testSetStrokeColor_NullColor() {
        try {
            sequenceEdge.setStrokeColor(null);
            fail("expect throw IllegalArgumentException.");
        } catch (IllegalArgumentException e) {
            // expected
        }
    }

    /**
     * <p>
     * Failure test for <code>{@link SequenceEdge#setFillColor(java.awt.Color)}</code> method.
     * </p>
     */
    public void testSetFillColor_NullColor() {
        try {
            sequenceEdge.setFillColor(null);
            fail("expect throw IllegalArgumentException.");
        } catch (IllegalArgumentException e) {
            // expected
        }
    }

    /**
     * <p>
     * Failure test for <code>{@link SequenceEdge#setFillColor2(java.awt.Color)}</code> method.
     * </p>
     */
    public void testSetFillColor2_NullColor() {
        try {
            sequenceEdge.setFillColor2(null);
            fail("expect throw IllegalArgumentException.");
        } catch (IllegalArgumentException e) {
            // expected
        }
    }

    /**
     * <p>
     * Failure test for <code>{@link SequenceEdge#setShadowColor(java.awt.Color)}</code> method.
     * </p>
     */
    public void testSetShadowColor_NullColor() {
        try {
            sequenceEdge.setShadowColor(null);
            fail("expect throw IllegalArgumentException.");
        } catch (IllegalArgumentException e) {
            // expected
        }
    }

    /**
     * <p>
     * Failure test for <code>{@link SequenceEdge#setFontColor(java.awt.Color)}</code> method.
     * </p>
     */
    public void testSetFontColor_NullColor() {
        try {
            sequenceEdge.setFontColor(null);
            fail("expect throw IllegalArgumentException.");
        } catch (IllegalArgumentException e) {
            // expected
        }
    }

    /**
     * <p>
     * Failure test for <code>{@link SequenceEdge#setTextBoxStrokeColor(java.awt.Color)}</code> method.
     * </p>
     */
    public void testSetTextBoxStrokeColor_NullColor() {
        try {
            sequenceEdge.setTextBoxStrokeColor(null);
            fail("expect throw IllegalArgumentException.");
        } catch (IllegalArgumentException e) {
            // expected
        }
    }

    /**
     * <p>
     * Failure test for <code>{@link SequenceEdge#setTextBoxFillColor(java.awt.Color)}</code> method.
     * </p>
     */
    public void testSetTextBoxFillColor_NullColor() {
        try {
            sequenceEdge.setTextBoxFillColor(null);
            fail("expect throw IllegalArgumentException.");
        } catch (IllegalArgumentException e) {
            // expected
        }
    }

    /**
     * <p>
     * Failure test for <code>{@link SequenceEdge#setTextBoxFillColor2(java.awt.Color)}</code> method.
     * </p>
     */
    public void testSetTextBoxFillColor2_NullColor() {
        try {
            sequenceEdge.setTextBoxFillColor2(null);
            fail("expect throw IllegalArgumentException.");
        } catch (IllegalArgumentException e) {
            // expected
        }
    }

    /**
     * <p>
     * Failure test for <code>{@link SequenceEdge#setFontFamily(String)}</code> method.
     * </p>
     */
    public void testSetFontFamily_NullFontFamily() {
        try {
            sequenceEdge.setFontFamily(null);
            fail("expect throw IllegalArgumentException.");
        } catch (IllegalArgumentException e) {
            // expected
        }
    }

    /**
     * <p>
     * Failure test for <code>{@link SequenceEdge#setFontFamily(String)}</code> method.
     * </p>
     */
    public void testSetFontFamily_EmptyFontFamily() {
        try {
            sequenceEdge.setFontFamily("");
            fail("expect throw IllegalArgumentException.");
        } catch (IllegalArgumentException e) {
            // expected
        }
    }

    /**
     * <p>
     * Failure test for <code>{@link SequenceEdge#setFontFamily(String)}</code> method.
     * </p>
     */
    public void testSetFontFamily_TrimmedEmptyFontFamily() {
        try {
            sequenceEdge.setFontFamily("  ");
            fail("expect throw IllegalArgumentException.");
        } catch (IllegalArgumentException e) {
            // expected
        }
    }

    /**
     * <p>
     * Failure test for <code>{@link SequenceEdge#setDashLength(int)}</code> method.
     * </p>
     */
    public void testSetDashLength_NegativeLength() {
        try {
            sequenceEdge.setDashLength(-1);
            fail("expect throw IllegalArgumentException.");
        } catch (IllegalArgumentException e) {
            // expected
        }
    }

    /**
     * <p>
     * Failure test for <code>{@link SequenceEdge#setBlankLength(int)}</code> method.
     * </p>
     */
    public void testSetBlankLength_NegativeLength() {
        try {
            sequenceEdge.setBlankLength(-1);
            fail("expect throw IllegalArgumentException.");
        } catch (IllegalArgumentException e) {
            // expected
        }
    }

    /**
     * <p>
     * Failure test for <code>{@link SequenceEdge#setPopup(javax.swing.JPopupMenu)}</code> method.
     * </p>
     */
    public void testSetPopup_nullPopup() {
        try {
            sequenceEdge.setPopup(null);
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
            sequenceEdge.setPropertyNameMappingElement(null, "Value");
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
            sequenceEdge.setPropertyNameMappingElement(SequenceEdgePropertyType.FILL_COLOR, null);
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
            sequenceEdge.setPropertyNameMappingElement(SequenceEdgePropertyType.FILL_COLOR, "");
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
            sequenceEdge.setPropertyNameMappingElement(SequenceEdgePropertyType.FILL_COLOR, "");
            fail("expect throw IllegalArgumentException.");
        } catch (IllegalArgumentException e) {
            // expected
        }
    }

}