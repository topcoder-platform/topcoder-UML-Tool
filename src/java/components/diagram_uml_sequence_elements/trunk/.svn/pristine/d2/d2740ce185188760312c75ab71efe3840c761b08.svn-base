/*
 * Copyright (C) 2007 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.gui.diagramviewer.uml.sequenceelements;

import java.awt.Color;
import java.awt.Font;
import java.util.EnumMap;

import javax.swing.JPopupMenu;

import com.topcoder.diagraminterchange.Diagram;
import com.topcoder.diagraminterchange.GraphEdge;
import com.topcoder.diagraminterchange.GraphNode;
import com.topcoder.gui.diagramviewer.edges.EdgeEnding;
import com.topcoder.gui.diagramviewer.edges.LineStyle;
import com.topcoder.gui.diagramviewer.uml.sequenceelements.edgeendings.ConfiguredEdgeEndingPropertyType;
import com.topcoder.gui.diagramviewer.uml.sequenceelements.edgeendings.EmptyArrowEdgeEnding;
import com.topcoder.uml.model.commonbehavior.links.Link;
import com.topcoder.uml.model.commonbehavior.links.LinkImpl;

import junit.framework.TestCase;
import junit.framework.TestSuite;
import junit.framework.Test;

/**
 * <p>
 * Unit test cases for SequenceEdge.
 * </p>
 *
 * <p>
 * Change for v1.1: add corresponding test case on the new methods.
 * </p>
 *
 * @author TCSDEVELOPER
 * @author TCSDEVELOPER
 *
 * @version 1.1
 * @since 1.0
 */
public class SequenceEdgeTests extends TestCase {
    /**
     * <p>
     * SequenceEdge instance for testing.
     * </p>
     */
    private SequenceEdge edge;

    /**
     * <p>
     * Link instance for testing.
     * </p>
     */
    private Link link;

    /**
     * <p>
     * GraphEdge instance for helping testing.
     * </p>
     */
    private GraphEdge graphEdge;

    /**
     * <p>
     * LineStyle instance for testing.
     * </p>
     */
    private LineStyle lineStyle;

    /**
     * <p>
     * The leftEnding instance for testing.
     * </p>
     */
    private EdgeEnding leftEnding;

    /**
     * <p>
     * The rightEnding instance for testing.
     * </p>
     */
    private EdgeEnding rightEnding;

    /**
     * <p>
     * The propertyNameMapping map for testing.
     * </p>
     */
    private EnumMap<SequenceEdgePropertyType, String> propertyNameMapping;

    /**
     * <p>
     * Sets up test environment.
     * </p>
     *
     */
    protected void setUp() {
        // set up the diagram instance
        Diagram diagram = new Diagram();
        graphEdge = TestHelper.createGraphEdge();
        graphEdge.addWaypoint(TestHelper.createDiagramInterchangePoint(100, 100));
        graphEdge.addWaypoint(TestHelper.createDiagramInterchangePoint(200, 200));
        graphEdge.addWaypoint(TestHelper.createDiagramInterchangePoint(300, 400));
        diagram.addContained(graphEdge);

        graphEdge.addContained(new GraphNode());
        graphEdge.addContained(new GraphNode());

        propertyNameMapping = new EnumMap<SequenceEdgePropertyType, String>(SequenceEdgePropertyType.class);
        propertyNameMapping.put(SequenceEdgePropertyType.FILL_COLOR, "red");

        EnumMap<ConfiguredEdgeEndingPropertyType, String> mapping = new EnumMap<
            ConfiguredEdgeEndingPropertyType, String>(ConfiguredEdgeEndingPropertyType.class);
        mapping.put(ConfiguredEdgeEndingPropertyType.ARROW_X_LENGTH, "value");

        rightEnding = new EmptyArrowEdgeEnding(mapping);
        leftEnding = new EmptyArrowEdgeEnding(mapping);
        lineStyle = new LineStyle(2, 2);
        link = new LinkImpl();

        edge = new MockSequenceEdge(link, graphEdge, lineStyle, leftEnding, rightEnding, propertyNameMapping);
    }

    /**
     * <p>
     * Tears down test environment.
     * </p>
     *
     */
    protected void tearDown() {
        edge = null;
        link = null;
        graphEdge = null;
        lineStyle = null;
        leftEnding = null;
        rightEnding = null;
        propertyNameMapping = null;
    }

    /**
     * <p>
     * Returns all tests.
     * </p>
     *
     * @return all tests
     */
    public static Test suite() {
        return new TestSuite(SequenceEdgeTests.class);
    }

    /**
     * <p>
     * Tests ctor SequenceEdge#SequenceEdge(Link,GraphEdge,LineStyle,EdgeEnding,EdgeEnding,EnumMap) for accuracy.
     * </p>
     *
     * <p>
     * It verifies the newly created SequenceEdge instance should not be null.
     * </p>
     */
    public void testCtor() {
        assertNotNull("Failed to create a new SequenceEdge instance.", edge);
    }

    /**
     * <p>
     * Tests ctor SequenceEdge#SequenceEdge(Link,GraphEdge,LineStyle,EdgeEnding,EdgeEnding,EnumMap) for failure.
     * </p>
     *
     * <p>
     * It tests the case that when link is null and expects IllegalArgumentException.
     * </p>
     */
    public void testCtor_NullLink() {
        try {
            new MockSequenceEdge(null, graphEdge, lineStyle, leftEnding, rightEnding, propertyNameMapping);
            fail("IllegalArgumentException expected.");
        } catch (IllegalArgumentException iae) {
            //good
        }
    }

    /**
     * <p>
     * Tests ctor SequenceEdge#SequenceEdge(Link,GraphEdge,LineStyle,EdgeEnding,EdgeEnding,EnumMap) for failure.
     * </p>
     *
     * <p>
     * It tests the case that when graphEdge is null and expects IllegalArgumentException.
     * </p>
     */
    public void testCtor_NullGraphEdge() {
        try {
            new MockSequenceEdge(link, null, lineStyle, leftEnding, rightEnding, propertyNameMapping);
            fail("IllegalArgumentException expected.");
        } catch (IllegalArgumentException iae) {
            //good
        }
    }

    /**
     * <p>
     * Tests ctor SequenceEdge#SequenceEdge(Link,GraphEdge,LineStyle,EdgeEnding,EdgeEnding,EnumMap) for failure.
     * </p>
     *
     * <p>
     * It tests the case that when lineStyle is null and expects IllegalArgumentException.
     * </p>
     */
    public void testCtor_NullLineStyle() {
        try {
            new MockSequenceEdge(link, graphEdge, null, leftEnding, rightEnding, propertyNameMapping);
            fail("IllegalArgumentException expected.");
        } catch (IllegalArgumentException iae) {
            //good
        }
    }

    /**
     * <p>
     * Tests ctor SequenceEdge#SequenceEdge(Link,GraphEdge,LineStyle,EdgeEnding,EdgeEnding,EnumMap) for failure.
     * </p>
     *
     * <p>
     * It tests the case that when leftEnding is null and expects IllegalArgumentException.
     * </p>
     */
    public void testCtor_NullLeftEnding() {
        try {
            new MockSequenceEdge(link, graphEdge, lineStyle, null, rightEnding, propertyNameMapping);
            fail("IllegalArgumentException expected.");
        } catch (IllegalArgumentException iae) {
            //good
        }
    }

    /**
     * <p>
     * Tests ctor SequenceEdge#SequenceEdge(Link,GraphEdge,LineStyle,EdgeEnding,EdgeEnding,EnumMap) for failure.
     * </p>
     *
     * <p>
     * It tests the case that when rightEnding is null and expects IllegalArgumentException.
     * </p>
     */
    public void testCtor_NullRightEnding() {
        try {
            new MockSequenceEdge(link, graphEdge, lineStyle, leftEnding, null, propertyNameMapping);
            fail("IllegalArgumentException expected.");
        } catch (IllegalArgumentException iae) {
            //good
        }
    }

    /**
     * <p>
     * Tests ctor SequenceEdge#SequenceEdge(Link,GraphEdge,LineStyle,EdgeEnding,EdgeEnding,EnumMap) for failure.
     * </p>
     *
     * <p>
     * It tests the case that when propertyNameMapping is null and expects IllegalArgumentException.
     * </p>
     */
    public void testCtor_NullPropertyNameMapping() {
        try {
            new MockSequenceEdge(link, graphEdge, lineStyle, leftEnding, rightEnding, null);
            fail("IllegalArgumentException expected.");
        } catch (IllegalArgumentException iae) {
            //good
        }
    }

    /**
     * <p>
     * Tests ctor SequenceEdge#SequenceEdge(Link,GraphEdge,LineStyle,EdgeEnding,EdgeEnding,EnumMap) for failure.
     * </p>
     *
     * <p>
     * It tests the case that when propertyNameMapping is empty and expects IllegalArgumentException.
     * </p>
     */
    public void testCtor_EmptyPropertyNameMapping() {
        propertyNameMapping = new EnumMap<SequenceEdgePropertyType, String>(SequenceEdgePropertyType.class);
        try {
            new MockSequenceEdge(link, graphEdge, lineStyle, leftEnding, rightEnding, propertyNameMapping);
            fail("IllegalArgumentException expected.");
        } catch (IllegalArgumentException iae) {
            //good
        }
    }

    /**
     * <p>
     * Tests SequenceEdge#getLink() for accuracy.
     * </p>
     *
     * <p>
     * It verifies SequenceEdge#getLink() is correct.
     * </p>
     */
    public void testGetLink() {
        assertSame("Failed to get the link correctly.", link, edge.getLink());
    }

    /**
     * <p>
     * Tests SequenceEdge#setIsStereotypesVisible(boolean) for accuracy.
     * </p>
     *
     * <p>
     * It verifies SequenceEdge#setIsStereotypesVisible(boolean) is correct.
     * </p>
     */
    public void testSetIsStereotypesVisible() {
        edge.setIsStereotypesVisible(false);
        assertFalse("Failed to set the visible correctly.", edge.getIsStereotypesVisible());
    }

    /**
     * <p>
     * Tests SequenceEdge#getIsStereotypesVisible() for accuracy.
     * </p>
     *
     * <p>
     * It verifies SequenceEdge#getIsStereotypesVisible() is correct.
     * </p>
     */
    public void testGetIsStereotypesVisible() {
        edge.setIsStereotypesVisible(false);
        assertFalse("Failed to get the visible correctly.", edge.getIsStereotypesVisible());
    }

    /**
     * <p>
     * Tests SequenceEdge#setIsNameVisible(boolean) for accuracy.
     * </p>
     *
     * <p>
     * It verifies SequenceEdge#setIsNameVisible(boolean) is correct.
     * </p>
     */
    public void testSetIsNameVisible() {
        edge.setIsNameVisible(false);
        assertFalse("Failed to set the visible correctly.", edge.getIsNameVisible());
    }

    /**
     * <p>
     * Tests SequenceEdge#getIsNameVisible() for accuracy.
     * </p>
     *
     * <p>
     * It verifies SequenceEdge#getIsNameVisible() is correct.
     * </p>
     */
    public void testGetIsNameVisible() {
        edge.setIsNameVisible(false);
        assertFalse("Failed to get the visible correctly.", edge.getIsNameVisible());
    }

    /**
     * <p>
     * Tests SequenceEdge#setStrokeColor(Color) for accuracy.
     * </p>
     *
     * <p>
     * It verifies SequenceEdge#setStrokeColor(Color) is correct.
     * </p>
     */
    public void testSetStrokeColor() {
        edge.setStrokeColor(Color.RED);
        assertEquals("Failed to set the color correctly.", Color.RED, edge.getStrokeColor());
    }

    /**
     * <p>
     * Tests SequenceEdge#setStrokeColor(Color) for failure.
     * </p>
     *
     * <p>
     * It tests the case that when strokeColor is null and expects IllegalArgumentException.
     * </p>
     */
    public void testSetStrokeColor_NullStrokeColor() {
        try {
            edge.setStrokeColor(null);
            fail("IllegalArgumentException expected.");
        } catch (IllegalArgumentException iae) {
            //good
        }
    }

    /**
     * <p>
     * Tests SequenceEdge#getStrokeColor() for accuracy.
     * </p>
     *
     * <p>
     * It verifies SequenceEdge#getStrokeColor() is correct.
     * </p>
     */
    public void testGetStrokeColor() {
        edge.setStrokeColor(Color.RED);
        assertEquals("Failed to get the color correctly.", Color.RED, edge.getStrokeColor());
    }

    /**
     * <p>
     * Tests SequenceEdge#setFillColor(Color) for accuracy.
     * </p>
     *
     * <p>
     * It verifies SequenceEdge#setFillColor(Color) is correct.
     * </p>
     */
    public void testSetFillColor() {
        edge.setFillColor(Color.RED);
        assertEquals("Failed to set the color correctly.", Color.RED, edge.getFillColor());
    }

    /**
     * <p>
     * Tests SequenceEdge#setFillColor(Color) for failure.
     * </p>
     *
     * <p>
     * It tests the case that when fillColor is null and expects IllegalArgumentException.
     * </p>
     */
    public void testSetFillColor_NullFillColor() {
        try {
            edge.setFillColor(null);
            fail("IllegalArgumentException expected.");
        } catch (IllegalArgumentException iae) {
            //good
        }
    }

    /**
     * <p>
     * Tests SequenceEdge#getFillColor() for accuracy.
     * </p>
     *
     * <p>
     * It verifies SequenceEdge#getFillColor() is correct.
     * </p>
     */
    public void testGetFillColor() {
        edge.setFillColor(Color.RED);
        assertEquals("Failed to get the color correctly.", Color.RED, edge.getFillColor());
    }

    /**
     * <p>
     * Tests SequenceEdge#setFillColor2(Color) for accuracy.
     * </p>
     *
     * <p>
     * It verifies SequenceEdge#setFillColor2(Color) is correct.
     * </p>
     */
    public void testSetFillColor2() {
        edge.setFillColor2(Color.RED);
        assertEquals("Failed to set the color correctly.", Color.RED, edge.getFillColor2());
    }

    /**
     * <p>
     * Tests SequenceEdge#setFillColor2(Color) for failure.
     * </p>
     *
     * <p>
     * It tests the case that when fillColor2 is null and expects IllegalArgumentException.
     * </p>
     */
    public void testSetFillColor2_NullFillColor2() {
        try {
            edge.setFillColor2(null);
            fail("IllegalArgumentException expected.");
        } catch (IllegalArgumentException iae) {
            //good
        }
    }

    /**
     * <p>
     * Tests SequenceEdge#getFillColor2() for accuracy.
     * </p>
     *
     * <p>
     * It verifies SequenceEdge#getFillColor2() is correct.
     * </p>
     */
    public void testGetFillColor2() {
        edge.setFillColor2(Color.RED);
        assertEquals("Failed to get the color correctly.", Color.RED, edge.getFillColor2());
    }

    /**
     * <p>
     * Tests SequenceEdge#setShadowColor(Color) for accuracy.
     * </p>
     *
     * <p>
     * It verifies SequenceEdge#setShadowColor(Color) is correct.
     * </p>
     */
    public void testSetShadowColor() {
        edge.setShadowColor(Color.RED);
        assertEquals("Failed to set the color correctly.", Color.RED, edge.getShadowColor());
    }

    /**
     * <p>
     * Tests SequenceEdge#setShadowColor(Color) for failure.
     * </p>
     *
     * <p>
     * It tests the case that when shadowColor is null and expects IllegalArgumentException.
     * </p>
     */
    public void testSetShadowColor_NullShadowColor() {
        try {
            edge.setShadowColor(null);
            fail("IllegalArgumentException expected.");
        } catch (IllegalArgumentException iae) {
            //good
        }
    }

    /**
     * <p>
     * Tests SequenceEdge#setFontColor(Color) for accuracy.
     * </p>
     *
     * <p>
     * It verifies SequenceEdge#setFontColor(Color) is correct.
     * </p>
     */
    public void testSetFontColor() {
        edge.setFontColor(Color.RED);
        assertEquals("Failed to set the color correctly.", Color.RED, edge.getFontColor());
    }

    /**
     * <p>
     * Tests SequenceEdge#setFontColor(Color) for failure.
     * </p>
     *
     * <p>
     * It tests the case that when fontColor is null and expects IllegalArgumentException.
     * </p>
     */
    public void testSetFontColor_NullFontColor() {
        try {
            edge.setFontColor(null);
            fail("IllegalArgumentException expected.");
        } catch (IllegalArgumentException iae) {
            //good
        }
    }

    /**
     * <p>
     * Tests SequenceEdge#getFontColor() for accuracy.
     * </p>
     *
     * <p>
     * It verifies SequenceEdge#getFontColor() is correct.
     * </p>
     */
    public void testGetFontColor() {
        edge.setFontColor(Color.RED);
        assertEquals("Failed to get the color correctly.", Color.RED, edge.getFontColor());
    }

    /**
     * <p>
     * Tests SequenceEdge#setTextBoxStrokeColor(Color) for accuracy.
     * </p>
     *
     * <p>
     * It verifies SequenceEdge#setTextBoxStrokeColor(Color) is correct.
     * </p>
     */
    public void testSetTextBoxStrokeColor() {
        edge.setTextBoxStrokeColor(Color.RED);
        assertEquals("Failed to set the color correctly.", Color.RED, edge.getTextBoxStrokeColor());
    }

    /**
     * <p>
     * Tests SequenceEdge#setTextBoxStrokeColor(Color) for failure.
     * </p>
     *
     * <p>
     * It tests the case that when textBoxStrokeColor is null and expects IllegalArgumentException.
     * </p>
     */
    public void testSetTextBoxStrokeColor_NullTextBoxStrokeColor() {
        try {
            edge.setTextBoxStrokeColor(null);
            fail("IllegalArgumentException expected.");
        } catch (IllegalArgumentException iae) {
            //good
        }
    }

    /**
     * <p>
     * Tests SequenceEdge#getTextBoxStrokeColor() for accuracy.
     * </p>
     *
     * <p>
     * It verifies SequenceEdge#getTextBoxStrokeColor() is correct.
     * </p>
     */
    public void testGetTextBoxStrokeColor() {
        edge.setTextBoxStrokeColor(Color.RED);
        assertEquals("Failed to get the color correctly.", Color.RED, edge.getTextBoxStrokeColor());
    }

    /**
     * <p>
     * Tests SequenceEdge#setTextBoxFillColor(Color) for accuracy.
     * </p>
     *
     * <p>
     * It verifies SequenceEdge#setTextBoxFillColor(Color) is correct.
     * </p>
     */
    public void testSetTextBoxFillColor() {
        edge.setTextBoxFillColor(Color.RED);
        assertEquals("Failed to set the color correctly.", Color.RED, edge.getTextBoxFillColor());
    }

    /**
     * <p>
     * Tests SequenceEdge#setTextBoxFillColor(Color) for failure.
     * </p>
     *
     * <p>
     * It tests the case that when textBoxFillColor is null and expects IllegalArgumentException.
     * </p>
     */
    public void testSetTextBoxFillColor_NullTextBoxFillColor() {
        try {
            edge.setTextBoxFillColor(null);
            fail("IllegalArgumentException expected.");
        } catch (IllegalArgumentException iae) {
            //good
        }
    }

    /**
     * <p>
     * Tests SequenceEdge#getTextBoxFillColor() for accuracy.
     * </p>
     *
     * <p>
     * It verifies SequenceEdge#getTextBoxFillColor() is correct.
     * </p>
     */
    public void testGetTextBoxFillColor() {
        edge.setTextBoxFillColor(Color.RED);
        assertEquals("Failed to get the color correctly.", Color.RED, edge.getTextBoxFillColor());
    }

    /**
     * <p>
     * Tests SequenceEdge#setTextBoxFillColor2(Color) for accuracy.
     * </p>
     *
     * <p>
     * It verifies SequenceEdge#setTextBoxFillColor2(Color) is correct.
     * </p>
     */
    public void testSetTextBoxFillColor2() {
        edge.setTextBoxFillColor2(Color.RED);
        assertEquals("Failed to set the color correctly.", Color.RED, edge.getTextBoxFillColor2());
    }

    /**
     * <p>
     * Tests SequenceEdge#setTextBoxFillColor2(Color) for failure.
     * </p>
     *
     * <p>
     * It tests the case that when textBoxFillColor2 is null and expects IllegalArgumentException.
     * </p>
     */
    public void testSetTextBoxFillColor2_NullTextBoxFillColor2() {
        try {
            edge.setTextBoxFillColor2(null);
            fail("IllegalArgumentException expected.");
        } catch (IllegalArgumentException iae) {
            //good
        }
    }

    /**
     * <p>
     * Tests SequenceEdge#getTextBoxFillColor2() for accuracy.
     * </p>
     *
     * <p>
     * It verifies SequenceEdge#getTextBoxFillColor2() is correct.
     * </p>
     */
    public void testGetTextBoxFillColor2() {
        edge.setTextBoxFillColor2(Color.RED);
        assertEquals("Failed to get the color correctly.", Color.RED, edge.getTextBoxFillColor2());
    }

    /**
     * <p>
     * Tests SequenceEdge#setFontStyle(int) for accuracy.
     * </p>
     *
     * <p>
     * It verifies SequenceEdge#setFontStyle(int) is correct.
     * </p>
     */
    public void testSetFontStyle() {
        edge.setFontStyle(Font.PLAIN);
        assertEquals("Failed to set the font style correctly.", Font.PLAIN, edge.getFontStyle());
    }

    /**
     * <p>
     * Tests SequenceEdge#getFontStyle() for accuracy.
     * </p>
     *
     * <p>
     * It verifies SequenceEdge#getFontStyle() is correct.
     * </p>
     */
    public void testGetFontStyle() {
        edge.setFontStyle(Font.PLAIN);
        assertEquals("Failed to get the font style correctly.", Font.PLAIN, edge.getFontStyle());
    }

    /**
     * <p>
     * Tests SequenceEdge#setDashLength(int) for accuracy.
     * </p>
     *
     * <p>
     * It verifies SequenceEdge#setDashLength(int) is correct.
     * </p>
     */
    public void testSetDashLength() {
        edge.setDashLength(5);
        assertEquals("Failed to set the dash length correctly.", 5, edge.getDashLength());
    }

    /**
     * <p>
     * Tests SequenceEdge#setDashLength(int) for failure.
     * </p>
     *
     * <p>
     * It tests the case that when dashLength is negative and expects IllegalArgumentException.
     * </p>
     */
    public void testSetDashLength_NegativeDashLength() {
        try {
            edge.setDashLength(-5);
            fail("IllegalArgumentException expected.");
        } catch (IllegalArgumentException iae) {
            //good
        }
    }

    /**
     * <p>
     * Tests SequenceEdge#getDashLength() for accuracy.
     * </p>
     *
     * <p>
     * It verifies SequenceEdge#getDashLength() is correct.
     * </p>
     */
    public void testGetDashLength() {
        edge.setDashLength(5);
        assertEquals("Failed to get the dash length correctly.", 5, edge.getDashLength());
    }

    /**
     * <p>
     * Tests SequenceEdge#setBlankLength(int) for accuracy.
     * </p>
     *
     * <p>
     * It verifies SequenceEdge#setBlankLength(int) is correct.
     * </p>
     */
    public void testSetBlankLength() {
        edge.setBlankLength(5);
        assertEquals("Failed to set the blank length correctly.", 5, edge.getBlankLength());
    }

    /**
     * <p>
     * Tests SequenceEdge#setBlankLength(int) for failure.
     * </p>
     *
     * <p>
     * It tests the case that when blankLength is negative and expects IllegalArgumentException.
     * </p>
     */
    public void testSetBlankLength_NegativeBlankLength() {
        try {
            edge.setBlankLength(-5);
            fail("IllegalArgumentException expected.");
        } catch (IllegalArgumentException iae) {
            //good
        }
    }

    /**
     * <p>
     * Tests SequenceEdge#getBlankLength() for accuracy.
     * </p>
     *
     * <p>
     * It verifies SequenceEdge#getBlankLength() is correct.
     * </p>
     */
    public void testGetBlankLength() {
        edge.setBlankLength(5);
        assertEquals("Failed to get the blank length correctly.", 5, edge.getBlankLength());
    }

    /**
     * <p>
     * Tests SequenceEdge#setRenderScheme(RenderScheme) for accuracy.
     * </p>
     *
     * <p>
     * It verifies SequenceEdge#setRenderScheme(RenderScheme) is correct.
     * </p>
     */
    public void testSetRenderScheme() {
        edge.setRenderScheme(RenderScheme.SimpleScheme);
        assertEquals("Failed to set the render scheme correctly.", RenderScheme.SimpleScheme, edge.getRenderScheme());
    }

    /**
     * <p>
     * Tests SequenceEdge#setRenderScheme(RenderScheme) for failure.
     * </p>
     *
     * <p>
     * It tests the case that when renderScheme is null and expects IllegalArgumentException.
     * </p>
     */
    public void testSetRenderScheme_NullRenderScheme() {
        try {
            edge.setRenderScheme(null);
            fail("IllegalArgumentException expected.");
        } catch (IllegalArgumentException iae) {
            //good
        }
    }

    /**
     * <p>
     * Tests SequenceEdge#getRenderScheme() for accuracy.
     * </p>
     *
     * <p>
     * It verifies SequenceEdge#getRenderScheme() is correct.
     * </p>
     */
    public void testGetRenderScheme() {
        edge.setRenderScheme(RenderScheme.SimpleScheme);
        assertEquals("Failed to get the render scheme correctly.", RenderScheme.SimpleScheme, edge.getRenderScheme());
    }

    /**
     * <p>
     * Tests SequenceEdge#setPopup(JPopupMenu) for accuracy.
     * </p>
     *
     * <p>
     * It verifies SequenceEdge#setPopup(JPopupMenu) is correct.
     * </p>
     */
    public void testSetPopup() {
        JPopupMenu popup = new JPopupMenu();
        edge.setPopup(popup);
        assertSame("Failed to set the menu correctly.", popup, edge.getPopup());
    }

    /**
     * <p>
     * Tests SequenceEdge#setPopup(JPopupMenu) for failure.
     * </p>
     *
     * <p>
     * It tests the case that when popup is null and expects IllegalArgumentException.
     * </p>
     */
    public void testSetPopup_NullPopup() {
        try {
            edge.setPopup(null);
            fail("IllegalArgumentException expected.");
        } catch (IllegalArgumentException iae) {
            //good
        }
    }

    /**
     * <p>
     * Tests SequenceEdge#consumeEvent(MouseEvent) for failure.
     * </p>
     *
     * <p>
     * It tests the case that when event is null and expects IllegalArgumentException.
     * </p>
     */
    public void testConsumeEvent_NullEvent() {
        try {
            edge.consumeEvent(null);
            fail("IllegalArgumentException expected.");
        } catch (IllegalArgumentException iae) {
            //good
        }
    }

    /**
     * <p>
     * Tests SequenceEdge#setPropertyNameMappingElement(SequenceEdgePropertyType,String) for accuracy.
     * </p>
     *
     * <p>
     * It verifies SequenceEdge#setPropertyNameMappingElement(SequenceEdgePropertyType,String) is correct.
     * </p>
     */
    public void testSetPropertyNameMappingElement() {
        edge.setPropertyNameMappingElement(SequenceEdgePropertyType.BLANK_LENGTH, "8");
        assertEquals("Failed to set mapping correctly.", "8",
            edge.getPropertyNameMappingElement(SequenceEdgePropertyType.BLANK_LENGTH));
    }

    /**
     * <p>
     * Tests SequenceEdge#setPropertyNameMappingElement(SequenceEdgePropertyType,String) for failure.
     * </p>
     *
     * <p>
     * It tests the case that when key is null and expects IllegalArgumentException.
     * </p>
     */
    public void testSetPropertyNameMappingElement_NullKey() {
        try {
            edge.setPropertyNameMappingElement(null, "8");
            fail("IllegalArgumentException expected.");
        } catch (IllegalArgumentException iae) {
            //good
        }
    }

    /**
     * <p>
     * Tests SequenceEdge#setPropertyNameMappingElement(SequenceEdgePropertyType,String) for failure.
     * </p>
     *
     * <p>
     * It tests the case that when value is null and expects IllegalArgumentException.
     * </p>
     */
    public void testSetPropertyNameMappingElement_NullValue() {
        try {
            edge.setPropertyNameMappingElement(SequenceEdgePropertyType.BLANK_LENGTH, null);
            fail("IllegalArgumentException expected.");
        } catch (IllegalArgumentException iae) {
            //good
        }
    }

    /**
     * <p>
     * Tests SequenceEdge#setPropertyNameMappingElement(SequenceEdgePropertyType,String) for failure.
     * </p>
     *
     * <p>
     * It tests the case that when value is empty and expects IllegalArgumentException.
     * </p>
     */
    public void testSetPropertyNameMappingElement_EmptyValue() {
        try {
            edge.setPropertyNameMappingElement(SequenceEdgePropertyType.BLANK_LENGTH, " ");
            fail("IllegalArgumentException expected.");
        } catch (IllegalArgumentException iae) {
            //good
        }
    }

    /**
     * <p>
     * Tests SequenceEdge#getPropertyNameMappingElement(SequenceEdgePropertyType) for accuracy.
     * </p>
     *
     * <p>
     * It verifies SequenceEdge#getPropertyNameMappingElement(SequenceEdgePropertyType) is correct.
     * </p>
     */
    public void testGetPropertyNameMappingElement() {
        edge.setPropertyNameMappingElement(SequenceEdgePropertyType.BLANK_LENGTH, "8");
        assertEquals("Failed to get mapping correctly.", "8",
            edge.getPropertyNameMappingElement(SequenceEdgePropertyType.BLANK_LENGTH));
    }

    /**
     * <p>
     * Tests SequenceEdge#getPropertyNameMappingElement(SequenceEdgePropertyType) for failure.
     * </p>
     *
     * <p>
     * It tests the case that when key is null and expects IllegalArgumentException.
     * </p>
     */
    public void testGetPropertyNameMappingElement_NullKey() {
        try {
            edge.getPropertyNameMappingElement(null);
            fail("IllegalArgumentException expected.");
        } catch (IllegalArgumentException iae) {
            //good
        }
    }

    /**
     * <p>
     * Tests SequenceEdge#getName() for accuracy.
     * </p>
     *
     * <p>
     * It verifies SequenceEdge#getName() is correct.
     * </p>
     */
    public void testGetName() {
        edge.setName("name");
        assertEquals("Failed to get the name correctly.", "name", edge.getName());
    }

    /**
     * <p>
     * Tests SequenceEdge#setName(String) for accuracy.
     * </p>
     *
     * <p>
     * It verifies SequenceEdge#setName(String) is correct.
     * </p>
     */
    public void testSetName() {
        edge.setName("name");
        assertEquals("Failed to set the name correctly.", "name", edge.getName());
    }

    /**
     * <p>
     * Tests SequenceEdge#setName(String) for accuracy.
     * </p>
     *
     * <p>
     * It tests the case that when name is empty and expects success.
     * </p>
     */
    public void testSetName_EmptyName() {
        edge.setName(" ");
        assertEquals("Failed to set the name correctly.", " ", edge.getName());
    }

    /**
     * <p>
     * Tests SequenceEdge#setName(String) for failure.
     * </p>
     *
     * <p>
     * It tests the case that when name is null and expects IllegalArgumentException.
     * </p>
     */
    public void testSetName_NullName() {
        try {
            edge.setName(null);
            fail("IllegalArgumentException expected.");
        } catch (IllegalArgumentException iae) {
            //good
        }
    }

    /**
     * <p>
     * Tests SequenceEdge#processMouseEvent(MouseEvent) for failure.
     * </p>
     *
     * <p>
     * It tests the case that when e is null and expects IllegalArgumentException.
     * </p>
     */
    public void testProcessMouseEvent_NullE() {
        try {
            edge.processMouseEvent(null);
            fail("IllegalArgumentException expected.");
        } catch (IllegalArgumentException iae) {
            //good
        }
    }

    /**
     * <p>
     * Tests SequenceEdge#getFontFamily() for accuracy.
     * </p>
     *
     * <p>
     * It verifies SequenceEdge#getFontFamily() is correct.
     * </p>
     */
    public void testGetFontFamily() {
        edge.setFontFamily("family");
        assertEquals("Failed to get the font family correctly.", "family", edge.getFontFamily());
    }

    /**
     * <p>
     * Tests SequenceEdge#getFontSize() for accuracy.
     * </p>
     *
     * <p>
     * It verifies SequenceEdge#getFontSize() is correct.
     * </p>
     */
    public void testGetFontSize() {
        edge.setFontSize(8);
        assertEquals("Failed to get the font size correctly.", 8, edge.getFontSize());
    }

    /**
     * <p>
     * Tests SequenceEdge#setFontFamily(String) for accuracy.
     * </p>
     *
     * <p>
     * It verifies SequenceEdge#setFontFamily(String) is correct.
     * </p>
     */
    public void testSetFontFamily() {
        edge.setFontFamily("family");
        assertEquals("Failed to set the font family correctly.", "family", edge.getFontFamily());
    }

    /**
     * <p>
     * Tests SequenceEdge#setFontFamily(String) for failure.
     * </p>
     *
     * <p>
     * It tests the case that when fontFamily is null and expects IllegalArgumentException.
     * </p>
     */
    public void testSetFontFamily_NullFontFamily() {
        try {
            edge.setFontFamily(null);
            fail("IllegalArgumentException expected.");
        } catch (IllegalArgumentException iae) {
            //good
        }
    }

    /**
     * <p>
     * Tests SequenceEdge#setFontFamily(String) for failure.
     * </p>
     *
     * <p>
     * It tests the case that when fontFamily is empty and expects IllegalArgumentException.
     * </p>
     */
    public void testSetFontFamily_EmptyFontFamily() {
        try {
            edge.setFontFamily(" ");
            fail("IllegalArgumentException expected.");
        } catch (IllegalArgumentException iae) {
            //good
        }
    }

    /**
     * <p>
     * Tests SequenceEdge#setFontSize(int) for accuracy.
     * </p>
     *
     * <p>
     * It verifies SequenceEdge#setFontSize(int) is correct.
     * </p>
     */
    public void testSetFontSize() {
        edge.setFontSize(8);
        assertEquals("Failed to set the font size correctly.", 8, edge.getFontSize());
    }

    /**
     * <p>
     * Tests SequenceEdge#setFontSize(int) for failure.
     * </p>
     *
     * <p>
     * It tests the case that when fontSize is negative and expects IllegalArgumentException.
     * </p>
     */
    public void testSetFontSize_NegativeSize() {
        try {
            edge.setFontSize(-8);
            fail("IllegalArgumentException expected.");
        } catch (IllegalArgumentException iae) {
            //good
        }
    }

    /**
     * <p>
     * Tests SequenceEdge#getPopup() for accuracy.
     * </p>
     *
     * <p>
     * It verifies SequenceEdge#getPopup() is correct.
     * </p>
     */
    public void testGetPopup() {
        JPopupMenu popup = new JPopupMenu();
        edge.setPopup(popup);
        assertSame("Failed to get the menu correctly.", popup, edge.getPopup());
    }

    /**
     * <p>
     * Tests SequenceEdge#getShadowColor() for accuracy.
     * </p>
     *
     * <p>
     * It verifies SequenceEdge#getShadowColor() is correct.
     * </p>
     */
    public void testGetShadowColor() {
        edge.setShadowColor(Color.RED);
        assertEquals("Failed to get the color correctly.", Color.RED, edge.getShadowColor());
    }

    /**
     * <p>
     * Test SequenceEdge#testNotifyGraphEdgeChange.
     * </p>
     *
     */
    public void testNotifyGraphEdgeChange() {

        // set up the diagram instance
        Diagram diagram = new Diagram();
        graphEdge = TestHelper.createGraphEdge();
        graphEdge.addWaypoint(TestHelper.createDiagramInterchangePoint(100, 100));
        graphEdge.addWaypoint(TestHelper.createDiagramInterchangePoint(200, 200));
        graphEdge.addWaypoint(TestHelper.createDiagramInterchangePoint(300, 400));
        diagram.addContained(graphEdge);

        EnumMap<ConfiguredEdgeEndingPropertyType, String> mapping = new EnumMap<
            ConfiguredEdgeEndingPropertyType, String>(ConfiguredEdgeEndingPropertyType.class);
        mapping.put(ConfiguredEdgeEndingPropertyType.ARROW_X_LENGTH, "value");
        rightEnding = new EmptyArrowEdgeEnding(mapping);
        leftEnding = new EmptyArrowEdgeEnding(mapping);
        lineStyle = new LineStyle(2, 2);
        link = new LinkImpl();

        edge = new MockSequenceEdge(link, graphEdge, lineStyle, leftEnding, rightEnding,
                TestHelper.createSequenceEdgeProperties());

        TestHelper.fillGraphEdgeProperties(graphEdge);
        edge.notifyGraphEdgeChange();

        assertEquals("Failed to update the stroke color.", new Color(85, 85, 85), edge.getStrokeColor());
        assertEquals("Failed to update the fill color.", new Color(85, 85, 85), edge.getFillColor());
        assertEquals("Failed to update the fill color 2.", new Color(85, 85, 85), edge.getFillColor2());
        assertEquals("Failed to update the shadow color.", new Color(85, 85, 85), edge.getShadowColor());
        assertEquals("Failed to update the font color.", new Color(85, 85, 85), edge.getFontColor());

        assertEquals("Failed to update the font family", "Dialog", edge.getFontFamily());
        assertEquals("Failed to update the font size", 13, edge.getFontSize());
        assertEquals("Failed to update the font style", 1, edge.getFontStyle());

        assertEquals("Failed to update the dash length", 15, edge.getDashLength());
        assertEquals("Failed to update the blank length", 15, edge.getBlankLength());

        //Test that the nameCompartment were updated correctly.
        graphEdge.addContained(new GraphNode());
        graphEdge.addContained(new GraphNode());
        edge.notifyGraphEdgeChange();
        edge.getNameCompartment().setText("old");
        edge.notifyGraphEdgeChange();
        assertEquals("Failed to update the nameCompartment", "", edge.getNameCompartment().getText());
    }

    /**
     * Test method for 'getNameCompartment()', name compartment should be got correctly.
     */
    public void testGetNameCompartment() {
        assertNotNull("Test method for 'getNameCompartment()' failed.", edge.getNameCompartment());
    }

    /**
     * Test method for 'getStereotypeCompartment()', stereotype compartment should be got correctly.
     */
    public void testGetStereotypeCompartment() {
        assertNotNull("Test method for 'getStereotypeCompartment()' failed.", edge.getStereotypeCompartment());
    }
}