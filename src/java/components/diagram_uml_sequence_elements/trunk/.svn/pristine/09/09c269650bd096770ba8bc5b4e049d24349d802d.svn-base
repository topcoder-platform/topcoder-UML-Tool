/*
 * Copyright (C) 2007 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.gui.diagramviewer.uml.sequenceelements;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Point;
import java.awt.Rectangle;
import java.util.Arrays;
import java.util.Collection;
import java.util.EnumMap;
import java.util.HashSet;

import javax.swing.JFrame;
import javax.swing.JPopupMenu;

import com.topcoder.diagraminterchange.GraphConnector;
import com.topcoder.diagraminterchange.GraphNode;
import com.topcoder.gui.diagramviewer.elements.SelectionCornerType;
import com.topcoder.uml.model.commonbehavior.instances.Object;
import com.topcoder.uml.model.commonbehavior.instances.ObjectImpl;

import junit.framework.TestCase;
import junit.framework.TestSuite;
import junit.framework.Test;

/**
 * <p>
 * Unit test cases for ObjectNode.
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
public class ObjectNodeTests extends TestCase {
    /**
     * <p>
     * Represent all the eight selection corner types.
     * </p>
     */
    private static final SelectionCornerType[] DEFAULT_SELECTION_CORNER_TYPE = new SelectionCornerType[] {
        SelectionCornerType.NORTH, SelectionCornerType.NORTHWEST, SelectionCornerType.WEST,
        SelectionCornerType.SOUTHWEST, SelectionCornerType.SOUTH, SelectionCornerType.SOUTHEAST,
        SelectionCornerType.EAST, SelectionCornerType.NORTHEAST};

    /**
     * <p>
     * Represent the default selection bound.
     * </p>
     */
    private static final Rectangle DEFAULT_BOUND = new Rectangle(0, 0, 200, 200);

    /**
     * <p>
     * Represent the default relative position.
     * </p>
     */
    private static final Point DEFAULT_RELATIVE_POSITION = new Point(5, 5);
    /**
     * <p>
     * ObjectNode instance for testing.
     * </p>
     */
    private ObjectNode objectNode;
    /**
     * <p>
     * Object instance for testing.
     * </p>
     */
    private Object object;
    /**
     * <p>
     * GraphConnector instance for testing.
     * </p>
     */
    private GraphConnector graphConnector;
    /**
     * <p>
     * GraphNode instance for testing.
     * </p>
     */
    private GraphNode graphNode;
    /**
     * <p>
     * Point instance for testing.
     * </p>
     */
    private Point position;
    /**
     * <p>
     * Rectangle instance for testing.
     * </p>
     */
    private Rectangle bound;
    /**
     * <p>
     * The corners collection for testing.
     * </p>
     */
    private Collection<SelectionCornerType> corners;
    /**
     * <p>
     * The propertyNameMapping map for testing.
     * </p>
     */
    private EnumMap<ObjectNodePropertyType, String> propertyNameMapping;

    /**
     * <p>
     * Sets up test environment.
     * </p>
     *
     * @throws Exception to JUnit
     */
    protected void setUp() throws Exception {
        TestHelper.loadXMLConfig(TestHelper.CONFIG_FILE);

        propertyNameMapping = new EnumMap<ObjectNodePropertyType, String>(ObjectNodePropertyType.class);
        propertyNameMapping.put(ObjectNodePropertyType.FILL_COLOR, "red");
        corners = TestHelper.createSelectionCorner();
        bound = new Rectangle();
        position = new Point();
        graphNode = TestHelper.createGraphNode();
        graphConnector = new GraphConnector();
        object = new ObjectImpl();
        object.setName("name");
        objectNode = new ObjectNode(object, graphConnector, graphNode, position, bound, corners, propertyNameMapping);
    }

    /**
     * <p>
     * Tears down test environment.
     * </p>
     *
     * @throws Exception to JUnit
     */
    protected void tearDown() throws Exception {
        TestHelper.clearConfig();
        objectNode = null;
        object = null;
        graphConnector = null;
        graphNode = null;
        position = null;
        bound = null;
        corners = null;
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
        return new TestSuite(ObjectNodeTests.class);
    }

    /**
     * <p>
     * This method tests the case when the configuration values are loaded from the GraphNode instance.
     * </p>
     *
     * <p>
     * It verifies all the properties are loaded correctly.
     * </p>
     */
    public void testGraphNodePropertyConfig() {
        objectNode = new ObjectNode(object, graphConnector, TestHelper.createGraphNode(), position, bound, corners,
            TestHelper.createObjectNodeProperties());

        assertEquals("Failed to load the stroke color.", new Color(85, 85, 85), objectNode.getStrokeColor());
        assertEquals("Failed to load the fill color.", new Color(85, 85, 85), objectNode.getFillColor());
        assertEquals("Failed to load the fill color 2.", new Color(85, 85, 85), objectNode.getFillColor2());
        assertEquals("Failed to load the shadow color.", new Color(85, 85, 85), objectNode.getShadowColor());
        assertEquals("Failed to load the font color.", new Color(85, 85, 85), objectNode.getFontColor());

        assertEquals("Failed to load the font family", "Dialog", objectNode.getFontFamily());
        assertEquals("Failed to load the font size", 13, objectNode.getFontSize());
        assertEquals("Failed to load the font style", 1, objectNode.getFontStyle());

        assertEquals("Failed to load the shadow length", 23, objectNode.getShadowLength());
        assertEquals("Failed to load the rounding radius", 13, objectNode.getRoundingRadius());

        assertEquals("Failed to load the render scheme", RenderScheme.TopCoderScheme, objectNode.getRenderScheme());
    }

    /**
     * <p>
     * This method tests the case when the configuration values are loaded from the namespace in Config Manager.
     * </p>
     *
     * <p>
     * It verifies all the properties are loaded correctly.
     * </p>
     */
    public void testNamespaceConfig() {
        objectNode = new ObjectNode(object, graphConnector, TestHelper.createGraphNode(), position, bound, corners,
            TestHelper.createInvalidObjectNodeProperties());

        assertEquals("Failed to load the stroke color.", Color.WHITE, objectNode.getStrokeColor());
        assertEquals("Failed to load the fill color.", Color.BLACK, objectNode.getFillColor());
        assertEquals("Failed to load the fill color 2.", Color.BLACK, objectNode.getFillColor2());
        assertEquals("Failed to load the shadow color.", Color.BLACK, objectNode.getShadowColor());
        assertEquals("Failed to load the font color.", Color.BLACK, objectNode.getFontColor());

        assertEquals("Failed to load the font family", "Times", objectNode.getFontFamily());
        assertEquals("Failed to load the font size", 15, objectNode.getFontSize());
        assertEquals("Failed to load the font style.", Font.ITALIC, objectNode.getFontStyle());

        assertEquals("Failed to load the shadow length", 15, objectNode.getShadowLength());
        assertEquals("Failed to load the rounding radius", 25, objectNode.getRoundingRadius());

        assertEquals("Failed to load the render scheme", RenderScheme.TopCoderScheme, objectNode.getRenderScheme());
    }

    /**
     * <p>
     * Tests ctor ObjectNode#ObjectNode(Object,GraphConnector,GraphNode,Point,
     * Rectangle,Collection,EnumMap) for accuracy.
     * </p>
     *
     * <p>
     * It verifies the newly created ObjectNode instance should not be null.
     * </p>
     */
    public void testCtor() {
        assertNotNull("Failed to create a new ObjectNode instance.", objectNode);
    }

    /**
     * <p>
     * Tests ctor ObjectNode#ObjectNode(Object,GraphConnector,GraphNode,Point,Rectangle,Collection,EnumMap) for failure.
     * </p>
     *
     * <p>
     * It tests the case that when object is null and expects IllegalArgumentException.
     * </p>
     */
    public void testCtor_NullObject() {
        try {
            new ObjectNode(null, graphConnector, graphNode, position, bound, corners, propertyNameMapping);
            fail("IllegalArgumentException expected.");
        } catch (IllegalArgumentException iae) {
            //good
        }
    }

    /**
     * <p>
     * Tests ctor ObjectNode#ObjectNode(Object,GraphConnector,GraphNode,Point,Rectangle,Collection,EnumMap) for failure.
     * </p>
     *
     * <p>
     * It tests the case that when graphConnector is null and expects IllegalArgumentException.
     * </p>
     */
    public void testCtor_NullGraphConnector() {
        try {
            new ObjectNode(object, null, graphNode, position, bound, corners, propertyNameMapping);
            fail("IllegalArgumentException expected.");
        } catch (IllegalArgumentException iae) {
            //good
        }
    }

    /**
     * <p>
     * Tests ctor ObjectNode#ObjectNode(Object,GraphConnector,GraphNode,Point,Rectangle,Collection,EnumMap) for failure.
     * </p>
     *
     * <p>
     * It tests the case that when graphNode is null and expects IllegalArgumentException.
     * </p>
     */
    public void testCtor_NullGraphNode() {
        try {
            new ObjectNode(object, graphConnector, null, position, bound, corners, propertyNameMapping);
            fail("IllegalArgumentException expected.");
        } catch (IllegalArgumentException iae) {
            //good
        }
    }

    /**
     * <p>
     * Tests ctor ObjectNode#ObjectNode(Object,GraphConnector,GraphNode,Point,Rectangle,Collection,EnumMap) for failure.
     * </p>
     *
     * <p>
     * It tests the case that when position is null and expects IllegalArgumentException.
     * </p>
     */
    public void testCtor_NullPosition() {
        try {
            new ObjectNode(object, graphConnector, graphNode, null, bound, corners, propertyNameMapping);
            fail("IllegalArgumentException expected.");
        } catch (IllegalArgumentException iae) {
            //good
        }
    }

    /**
     * <p>
     * Tests ctor ObjectNode#ObjectNode(Object,GraphConnector,GraphNode,Point,Rectangle,Collection,EnumMap) for failure.
     * </p>
     *
     * <p>
     * It tests the case that when bound is null and expects IllegalArgumentException.
     * </p>
     */
    public void testCtor_NullBound() {
        try {
            new ObjectNode(object, graphConnector, graphNode, position, null, corners, propertyNameMapping);
            fail("IllegalArgumentException expected.");
        } catch (IllegalArgumentException iae) {
            //good
        }
    }

    /**
     * <p>
     * Tests ctor ObjectNode#ObjectNode(Object,GraphConnector,GraphNode,Point,Rectangle,Collection,EnumMap) for failure.
     * </p>
     *
     * <p>
     * It tests the case that when corners is null and expects IllegalArgumentException.
     * </p>
     */
    public void testCtor_NullCorners() {
        try {
            new ObjectNode(object, graphConnector, graphNode, position, bound, null, propertyNameMapping);
            fail("IllegalArgumentException expected.");
        } catch (IllegalArgumentException iae) {
            //good
        }
    }

    /**
     * <p>
     * Tests ctor ObjectNode#ObjectNode(Object,GraphConnector,GraphNode,Point,Rectangle,Collection,EnumMap) for failure.
     * </p>
     *
     * <p>
     * It tests the case that when propertyNameMapping is null and expects IllegalArgumentException.
     * </p>
     */
    public void testCtor_NullPropertyNameMapping() {
        try {
            new ObjectNode(object, graphConnector, graphNode, position, bound, corners, null);
            fail("IllegalArgumentException expected.");
        } catch (IllegalArgumentException iae) {
            //good
        }
    }

    /**
     * <p>
     * Tests ctor ObjectNode#ObjectNode(Object,GraphConnector,GraphNode,Point,Rectangle,Collection,EnumMap) for failure.
     * </p>
     *
     * <p>
     * It tests the case that when propertyNameMapping is empty and expects IllegalArgumentException.
     * </p>
     */
    public void testCtor_EmptyPropertyNameMapping() {
        propertyNameMapping = new EnumMap<ObjectNodePropertyType, String>(ObjectNodePropertyType.class);
        try {
            new ObjectNode(object, graphConnector, graphNode, position, bound, corners, propertyNameMapping);
            fail("IllegalArgumentException expected.");
        } catch (IllegalArgumentException iae) {
            //good
        }
    }

    /**
     * <p>
     * Tests ObjectNode#setIsStereotypesVisible(boolean) for accuracy.
     * </p>
     *
     * <p>
     * It verifies ObjectNode#setIsStereotypesVisible(boolean) is correct.
     * </p>
     */
    public void testSetIsStereotypesVisible() {
        objectNode.setIsStereotypesVisible(false);
        assertFalse("Failed to set the stereotypes visible correctly.", objectNode.getIsStereotypesVisible());
    }

    /**
     * <p>
     * Tests ObjectNode#getIsStereotypesVisible() for accuracy.
     * </p>
     *
     * <p>
     * It verifies ObjectNode#getIsStereotypesVisible() is correct.
     * </p>
     */
    public void testGetIsStereotypesVisible() {
        assertTrue("Failed to get the stereotypes visible correctly.", objectNode.getIsStereotypesVisible());
    }

    /**
     * <p>
     * Tests ObjectNode#setIsNameVisible(boolean) for accuracy.
     * </p>
     *
     * <p>
     * It verifies ObjectNode#setIsNameVisible(boolean) is correct.
     * </p>
     */
    public void testSetIsNameVisible() {
        objectNode.setIsNameVisible(false);
        assertFalse("Failed to set the name visible correctly.", objectNode.getIsNameVisible());
    }

    /**
     * <p>
     * Tests ObjectNode#getIsNameVisible() for accuracy.
     * </p>
     *
     * <p>
     * It verifies ObjectNode#getIsNameVisible() is correct.
     * </p>
     */
    public void testGetIsNameVisible() {
        assertTrue("Failed to get the name visible correctly.", objectNode.getIsNameVisible());
    }

    /**
     * <p>
     * Tests ObjectNode#setStrokeColor(Color) for accuracy.
     * </p>
     *
     * <p>
     * It verifies ObjectNode#setStrokeColor(Color) is correct.
     * </p>
     */
    public void testSetStrokeColor() {
        objectNode.setStrokeColor(Color.RED);
        assertEquals("Failed to set the stroke color correctly.", Color.RED, objectNode.getStrokeColor());
    }

    /**
     * <p>
     * Tests ObjectNode#setStrokeColor(Color) for failure.
     * </p>
     *
     * <p>
     * It tests the case that when strokeColor is null and expects IllegalArgumentException.
     * </p>
     */
    public void testSetStrokeColor_NullStrokeColor() {
        try {
            objectNode.setStrokeColor(null);
            fail("IllegalArgumentException expected.");
        } catch (IllegalArgumentException iae) {
            //good
        }
    }

    /**
     * <p>
     * Tests ObjectNode#getStrokeColor() for accuracy.
     * </p>
     *
     * <p>
     * It verifies ObjectNode#getStrokeColor() is correct.
     * </p>
     */
    public void testGetStrokeColor() {
        objectNode.setStrokeColor(Color.RED);
        assertEquals("Failed to get the stroke color correctly.", Color.RED, objectNode.getStrokeColor());
    }

    /**
     * <p>
     * Tests ObjectNode#setFillColor(Color) for accuracy.
     * </p>
     *
     * <p>
     * It verifies ObjectNode#setFillColor(Color) is correct.
     * </p>
     */
    public void testSetFillColor() {
        objectNode.setFillColor(Color.RED);
        assertEquals("Failed to set the fill color correctly.", Color.RED, objectNode.getFillColor());
    }

    /**
     * <p>
     * Tests ObjectNode#setFillColor(Color) for failure.
     * </p>
     *
     * <p>
     * It tests the case that when fillColor is null and expects IllegalArgumentException.
     * </p>
     */
    public void testSetFillColor_NullFillColor() {
        try {
            objectNode.setFillColor(null);
            fail("IllegalArgumentException expected.");
        } catch (IllegalArgumentException iae) {
            //good
        }
    }

    /**
     * <p>
     * Tests ObjectNode#getFillColor() for accuracy.
     * </p>
     *
     * <p>
     * It verifies ObjectNode#getFillColor() is correct.
     * </p>
     */
    public void testGetFillColor() {
        objectNode.setFillColor(Color.RED);
        assertEquals("Failed to get the fill color correctly.", Color.RED, objectNode.getFillColor());
    }

    /**
     * <p>
     * Tests ObjectNode#setFillColor2(Color) for accuracy.
     * </p>
     *
     * <p>
     * It verifies ObjectNode#setFillColor2(Color) is correct.
     * </p>
     */
    public void testSetFillColor2() {
        objectNode.setFillColor2(Color.RED);
        assertEquals("Failed to set the fill color correctly.", Color.RED, objectNode.getFillColor2());
    }

    /**
     * <p>
     * Tests ObjectNode#setFillColor2(Color) for failure.
     * </p>
     *
     * <p>
     * It tests the case that when fillColor2 is null and expects IllegalArgumentException.
     * </p>
     */
    public void testSetFillColor2_NullFillColor2() {
        try {
            objectNode.setFillColor2(null);
            fail("IllegalArgumentException expected.");
        } catch (IllegalArgumentException iae) {
            //good
        }
    }

    /**
     * <p>
     * Tests ObjectNode#getFillColor2() for accuracy.
     * </p>
     *
     * <p>
     * It verifies ObjectNode#getFillColor2() is correct.
     * </p>
     */
    public void testGetFillColor2() {
        objectNode.setFillColor2(Color.RED);
        assertEquals("Failed to get the fill color correctly.", Color.RED, objectNode.getFillColor2());
    }

    /**
     * <p>
     * Tests ObjectNode#setShadowColor(Color) for accuracy.
     * </p>
     *
     * <p>
     * It verifies ObjectNode#setShadowColor(Color) is correct.
     * </p>
     */
    public void testSetShadowColor() {
        objectNode.setShadowColor(Color.RED);
        assertEquals("Failed to set the shadow color correctly.", Color.RED, objectNode.getShadowColor());
    }

    /**
     * <p>
     * Tests ObjectNode#setShadowColor(Color) for failure.
     * </p>
     *
     * <p>
     * It tests the case that when shadowColor is null and expects IllegalArgumentException.
     * </p>
     */
    public void testSetShadowColor_NullShadowColor() {
        try {
            objectNode.setShadowColor(null);
            fail("IllegalArgumentException expected.");
        } catch (IllegalArgumentException iae) {
            //good
        }
    }

    /**
     * <p>
     * Tests ObjectNode#setFontColor(Color) for accuracy.
     * </p>
     *
     * <p>
     * It verifies ObjectNode#setFontColor(Color) is correct.
     * </p>
     */
    public void testSetFontColor() {
        objectNode.setFontColor(Color.RED);
        assertEquals("Failed to set the font color correctly.", Color.RED, objectNode.getFontColor());
    }

    /**
     * <p>
     * Tests ObjectNode#setFontColor(Color) for failure.
     * </p>
     *
     * <p>
     * It tests the case that when fontColor is null and expects IllegalArgumentException.
     * </p>
     */
    public void testSetFontColor_NullFontColor() {
        try {
            objectNode.setFontColor(null);
            fail("IllegalArgumentException expected.");
        } catch (IllegalArgumentException iae) {
            //good
        }
    }

    /**
     * <p>
     * Tests ObjectNode#getFontColor() for accuracy.
     * </p>
     *
     * <p>
     * It verifies ObjectNode#getFontColor() is correct.
     * </p>
     */
    public void testGetFontColor() {
        objectNode.setFontColor(Color.RED);
        assertEquals("Failed to get the font color correctly.", Color.RED, objectNode.getFontColor());
    }

    /**
     * <p>
     * Tests ObjectNode#setFontStyle(int) for accuracy.
     * </p>
     *
     * <p>
     * It verifies ObjectNode#setFontStyle(int) is correct.
     * </p>
     */
    public void testSetFontStyle() {
        objectNode.setFontStyle(Font.PLAIN);
        assertEquals("Failed to set the font style correctly.", Font.PLAIN, objectNode.getFontStyle());
    }

    /**
     * <p>
     * Tests ObjectNode#getFontStyle() for accuracy.
     * </p>
     *
     * <p>
     * It verifies ObjectNode#getFontStyle() is correct.
     * </p>
     */
    public void testGetFontStyle() {
        objectNode.setFontStyle(Font.PLAIN);
        assertEquals("Failed to get the font style correctly.", Font.PLAIN, objectNode.getFontStyle());
    }

    /**
     * <p>
     * Tests ObjectNode#setRenderScheme(RenderScheme) for accuracy.
     * </p>
     *
     * <p>
     * It verifies ObjectNode#setRenderScheme(RenderScheme) is correct.
     * </p>
     */
    public void testSetRenderScheme() {
        objectNode.setRenderScheme(RenderScheme.SimpleScheme);
        assertEquals("Failed to set the RenderScheme type correctly.", RenderScheme.SimpleScheme,
            objectNode.getRenderScheme());
    }

    /**
     * <p>
     * Tests ObjectNode#setRenderScheme(RenderScheme) for failure.
     * </p>
     *
     * <p>
     * It tests the case that when renderScheme is null and expects IllegalArgumentException.
     * </p>
     */
    public void testSetRenderScheme_NullRenderScheme() {
        try {
            objectNode.setRenderScheme(null);
            fail("IllegalArgumentException expected.");
        } catch (IllegalArgumentException iae) {
            //good
        }
    }

    /**
     * <p>
     * Tests ObjectNode#getRenderScheme() for accuracy.
     * </p>
     *
     * <p>
     * It verifies ObjectNode#getRenderScheme() is correct.
     * </p>
     */
    public void testGetRenderScheme() {
        objectNode.setRenderScheme(RenderScheme.SimpleScheme);
        assertEquals("Failed to get the RenderScheme type correctly.", RenderScheme.SimpleScheme,
            objectNode.getRenderScheme());
    }

    /**
     * <p>
     * Tests ObjectNode#setPopup(JPopupMenu) for accuracy.
     * </p>
     *
     * <p>
     * It verifies ObjectNode#setPopup(JPopupMenu) is correct.
     * </p>
     */
    public void testSetPopup() {
        JPopupMenu popup = new JPopupMenu();
        objectNode.setPopup(popup);
        assertSame("Failed to set the menu correctly.", popup, objectNode.getPopup());
    }

    /**
     * <p>
     * Tests ObjectNode#setPopup(JPopupMenu) for failure.
     * </p>
     *
     * <p>
     * It tests the case that when popup is null and expects IllegalArgumentException.
     * </p>
     */
    public void testSetPopup_NullPopup() {
        try {
            objectNode.setPopup(null);
            fail("IllegalArgumentException expected.");
        } catch (IllegalArgumentException iae) {
            //good
        }
    }

    /**
     * <p>
     * Tests ObjectNode#consumeEvent(MouseEvent) for failure.
     * </p>
     *
     * <p>
     * It tests the case that when event is null and expects IllegalArgumentException.
     * </p>
     */
    public void testConsumeEvent_NullEvent() {
        try {
            objectNode.consumeEvent(null);
            fail("IllegalArgumentException expected.");
        } catch (IllegalArgumentException iae) {
            //good
        }
    }

    /**
     * <p>
     * Tests ObjectNode#setPropertyNameMappingElement(ObjectNodePropertyType,String) for accuracy.
     * </p>
     *
     * <p>
     * It verifies ObjectNode#setPropertyNameMappingElement(ObjectNodePropertyType,String) is correct.
     * </p>
     */
    public void testSetPropertyNameMappingElement() {
        objectNode.setPropertyNameMappingElement(ObjectNodePropertyType.FONT_SIZE, "8");
        assertEquals("Failed to set the property name mapping element correctly.", "8",
            objectNode.getPropertyNameMappingElement(ObjectNodePropertyType.FONT_SIZE));
    }

    /**
     * <p>
     * Tests ObjectNode#setPropertyNameMappingElement(ObjectNodePropertyType,String) for failure.
     * </p>
     *
     * <p>
     * It tests the case that when key is null and expects IllegalArgumentException.
     * </p>
     */
    public void testSetPropertyNameMappingElement_NullKey() {
        try {
            objectNode.setPropertyNameMappingElement(null, "8");
            fail("IllegalArgumentException expected.");
        } catch (IllegalArgumentException iae) {
            //good
        }
    }

    /**
     * <p>
     * Tests ObjectNode#setPropertyNameMappingElement(ObjectNodePropertyType,String) for failure.
     * </p>
     *
     * <p>
     * It tests the case that when value is null and expects IllegalArgumentException.
     * </p>
     */
    public void testSetPropertyNameMappingElement_NullValue() {
        try {
            objectNode.setPropertyNameMappingElement(ObjectNodePropertyType.FONT_SIZE, null);
            fail("IllegalArgumentException expected.");
        } catch (IllegalArgumentException iae) {
            //good
        }
    }

    /**
     * <p>
     * Tests ObjectNode#setPropertyNameMappingElement(ObjectNodePropertyType,String) for failure.
     * </p>
     *
     * <p>
     * It tests the case that when value is empty and expects IllegalArgumentException.
     * </p>
     */
    public void testSetPropertyNameMappingElement_EmptyValue() {
        try {
            objectNode.setPropertyNameMappingElement(ObjectNodePropertyType.FONT_SIZE, " ");
            fail("IllegalArgumentException expected.");
        } catch (IllegalArgumentException iae) {
            //good
        }
    }

    /**
     * <p>
     * Tests ObjectNode#getPropertyNameMappingElement(ObjectNodePropertyType) for accuracy.
     * </p>
     *
     * <p>
     * It verifies ObjectNode#getPropertyNameMappingElement(ObjectNodePropertyType) is correct.
     * </p>
     */
    public void testGetPropertyNameMappingElement() {
        objectNode.setPropertyNameMappingElement(ObjectNodePropertyType.FONT_SIZE, "8");
        assertEquals("Failed to get the property name mapping element correctly.", "8",
            objectNode.getPropertyNameMappingElement(ObjectNodePropertyType.FONT_SIZE));
    }

    /**
     * <p>
     * Tests ObjectNode#getPropertyNameMappingElement(ObjectNodePropertyType) for failure.
     * </p>
     *
     * <p>
     * It tests the case that when key is null and expects IllegalArgumentException.
     * </p>
     */
    public void testGetPropertyNameMappingElement_NullKey() {
        try {
            objectNode.getPropertyNameMappingElement(null);
            fail("IllegalArgumentException expected.");
        } catch (IllegalArgumentException iae) {
            //good
        }
    }

    /**
     * <p>
     * Tests ObjectNode#getGraphConnector() for accuracy.
     * </p>
     *
     * <p>
     * It verifies ObjectNode#getGraphConnector() is correct.
     * </p>
     */
    public void testGetGraphConnector() {
        assertSame("Failed to get the graph connector correctly.", graphConnector, objectNode.getGraphConnector());
    }

    /**
     * <p>
     * Tests ObjectNode#setRoundingRadius(int) for accuracy.
     * </p>
     *
     * <p>
     * It verifies ObjectNode#setRoundingRadius(int) is correct.
     * </p>
     */
    public void testSetRoundingRadius() {
        objectNode.setRoundingRadius(5);
        assertEquals("Failed to set the rounding radius correctly.", 5, objectNode.getRoundingRadius());
    }

    /**
     * <p>
     * Tests ObjectNode#setRoundingRadius(int) for failure.
     * </p>
     *
     * <p>
     * It tests the case when the radius is negative and expected IllegalArgumentException.
     * </p>
     */
    public void testSetRoundingRadius_NegativeRadius() {
        try {
            objectNode.setRoundingRadius(-5);
            fail("IllegalArgumentException expected.");
        } catch (IllegalArgumentException iae) {
            //good
        }
    }

    /**
     * <p>
     * Tests ObjectNode#getRoundingRadius() for accuracy.
     * </p>
     *
     * <p>
     * It verifies ObjectNode#getRoundingRadius() is correct.
     * </p>
     */
    public void testGetRoundingRadius() {
        objectNode.setRoundingRadius(5);
        assertEquals("Failed to get the rounding radius correctly.", 5, objectNode.getRoundingRadius());
    }

    /**
     * <p>
     * Tests ObjectNode#setShadowLength(int) for accuracy.
     * </p>
     *
     * <p>
     * It verifies ObjectNode#setShadowLength(int) is correct.
     * </p>
     */
    public void testSetShadowLength() {
        objectNode.setShadowLength(5);
        assertEquals("Failed to set the shadow length correctly.", 5, objectNode.getShadowLength());
    }

    /**
     * <p>
     * Tests ObjectNode#setShadowLength(int) for accuracy.
     * </p>
     *
     * <p>
     * It tests the case when the shadowLength is negative and expected IllegalArgumentException.
     * </p>
     */
    public void testSetShadowLength_NegativeShadowLength() {
        try {
            objectNode.setShadowLength(-5);
            fail("IllegalArgumentException expected.");
        } catch (IllegalArgumentException iae) {
            //good
        }
    }

    /**
     * <p>
     * Tests ObjectNode#getShadowLength() for accuracy.
     * </p>
     *
     * <p>
     * It verifies ObjectNode#getShadowLength() is correct.
     * </p>
     */
    public void testGetShadowLength() {
        objectNode.setShadowLength(5);
        assertEquals("Failed to get the shadow length correctly.", 5, objectNode.getShadowLength());
    }

    /**
     * <p>
     * Tests ObjectNode#addEditNameListener(EditNameListener) for accuracy.
     * </p>
     *
     * <p>
     * It verifies ObjectNode#addEditNameListener(EditNameListener) is correct.
     * </p>
     */
    public void testAddEditNameListener() {
        EditNameListener listener = new MockEditNameListener();
        objectNode.addEditNameListener(listener);

        assertEquals("Expected the length of listeners is one.", 1,
            objectNode.getListeners(EditNameListener.class).length);
        assertEquals("Failed to set the listener correctly.", listener,
            objectNode.getListeners(EditNameListener.class)[0]);
    }

    /**
     * <p>
     * Tests ObjectNode#addEditNameListener(EditNameListener) for accuracy.
     * </p>
     *
     * <p>
     * It tests the case that when listener is null and expects success.
     * </p>
     */
    public void testAddEditNameListener_NullListener() {
        objectNode.addEditNameListener(null);

        assertEquals("Failed to set the listener correctly.", 0,
            objectNode.getListeners(EditNameListener.class).length);
    }

    /**
     * <p>
     * Tests ObjectNode#addSetNameListener(SetNameListener) for accuracy.
     * </p>
     *
     * <p>
     * It verifies ObjectNode#addSetNameListener(SetNameListener) is correct.
     * </p>
     */
    public void testAddSetNameListener() {
        SetNameListener listener = new MockSetNameListener();
        objectNode.addSetNameListener(listener);

        assertEquals("Expected the length of listeners is one.", 1,
            objectNode.getListeners(SetNameListener.class).length);
        assertEquals("Failed to set the listener correctly.", listener,
            objectNode.getListeners(SetNameListener.class)[0]);
    }

    /**
     * <p>
     * Tests ObjectNode#addSetNameListener(SetNameListener) for accuracy.
     * </p>
     *
     * <p>
     * It tests the case that when listener is null and expects success.
     * </p>
     */
    public void testAddSetNameListener_NullListener() {
        objectNode.addSetNameListener(null);

        assertEquals("Failed to set the listener correctly.", 0, objectNode.getListeners(SetNameListener.class).length);
    }

    /**
     * <p>
     * Tests ObjectNode#addResizeListener(ResizeListener) for accuracy.
     * </p>
     *
     * <p>
     * It verifies ObjectNode#addResizeListener(ResizeListener) is correct.
     * </p>
     */
    public void testAddResizeListener() {
        ResizeListener listener = new MockResizeListener();
        objectNode.addResizeListener(listener);

        assertEquals("Expected the length of listeners is one.", 1,
            objectNode.getListeners(ResizeListener.class).length);
        assertEquals("Failed to set the listener correctly.", listener,
            objectNode.getListeners(ResizeListener.class)[0]);
    }

    /**
     * <p>
     * Tests ObjectNode#addResizeListener(ResizeListener) for accuracy.
     * </p>
     *
     * <p>
     * It tests the case that when listener is null and expects success.
     * </p>
     */
    public void testAddResizeListener_NullListener() {
        objectNode.addResizeListener(null);

        assertEquals("Failed to set the listener correctly.", 0, objectNode.getListeners(ResizeListener.class).length);
    }

    /**
     * <p>
     * Tests ObjectNode#fireEditName(EditNameEvent) for accuracy.
     * </p>
     *
     * <p>
     * It verifies ObjectNode#fireEditName(EditNameEvent) is correct.
     * </p>
     */
    public void testFireEditName() {
        MockEditNameListener listener = new MockEditNameListener();
        objectNode.addEditNameListener(listener);

        objectNode.fireEditName(new EditNameEvent(position, "name", objectNode));

        assertTrue("Failed to fire the listener correctly.", listener.getIsExecute());
    }

    /**
     * <p>
     * Tests ObjectNode#fireEditName(EditNameEvent) for accuracy.
     * </p>
     *
     * <p>
     * It tests the case that when event is null and expects success.
     * </p>
     */
    public void testFireEditName_NullEvent() {
        MockEditNameListener listener = new MockEditNameListener();
        objectNode.addEditNameListener(listener);

        objectNode.fireEditName(null);

        assertFalse("Failed to fire the listener correctly.", listener.getIsExecute());
    }

    /**
     * <p>
     * Tests ObjectNode#fireSetName(SetNameEvent) for accuracy.
     * </p>
     *
     * <p>
     * It verifies ObjectNode#fireSetName(SetNameEvent) is correct.
     * </p>
     */
    public void testFireSetName() {
        MockSetNameListener listener = new MockSetNameListener();
        objectNode.addSetNameListener(listener);

        objectNode.fireSetName(new SetNameEvent("oldName", "newName", objectNode));

        assertTrue("Failed to fire the listener correctly.", listener.getIsExecute());
    }

    /**
     * <p>
     * Tests ObjectNode#fireSetName(SetNameEvent) for accuracy.
     * </p>
     *
     * <p>
     * It tests the case that when event is null and expects success.
     * </p>
     */
    public void testFireSetName_NullEvent() {
        MockSetNameListener listener = new MockSetNameListener();
        objectNode.addSetNameListener(listener);

        objectNode.fireSetName(null);

        assertFalse("Failed to fire the listener correctly.", listener.getIsExecute());
    }

    /**
     * <p>
     * Tests ObjectNode#fireResize(ResizeEvent) for accuracy.
     * </p>
     *
     * <p>
     * It verifies ObjectNode#fireResize(ResizeEvent) is correct.
     * </p>
     */
    public void testFireResize() {
        MockResizeListener listener = new MockResizeListener();
        objectNode.addResizeListener(listener);

        objectNode.fireResize(new ResizeEvent(objectNode, "reason"));

        assertTrue("Failed to fire the listener correctly.", listener.getIsExecute());
    }

    /**
     * <p>
     * Tests ObjectNode#fireResize(ResizeEvent) for accuracy.
     * </p>
     *
     * <p>
     * It tests the case that when event is null and expects success.
     * </p>
     */
    public void testFireResize_NullEvent() {
        MockResizeListener listener = new MockResizeListener();
        objectNode.addResizeListener(listener);

        objectNode.fireResize(null);

        assertFalse("Failed to fire the listener correctly.", listener.getIsExecute());
    }

    /**
     * <p>
     * Tests ObjectNode#removeEditNameListener(EditNameListener) for accuracy.
     * </p>
     *
     * <p>
     * It verifies ObjectNode#removeEditNameListener(EditNameListener) is correct.
     * </p>
     */
    public void testRemoveEditNameListener() {
        EditNameListener listener = new MockEditNameListener();
        objectNode.addEditNameListener(listener);

        objectNode.removeEditNameListener(listener);

        assertEquals("Failed to remove the listener correctly.", 0,
            objectNode.getListeners(EditNameListener.class).length);
    }

    /**
     * <p>
     * Tests ObjectNode#removeEditNameListener(EditNameListener) for accuracy.
     * </p>
     *
     * <p>
     * It tests the case that when listener is null and expects success.
     * </p>
     */
    public void testRemoveEditNameListener_NullListener() {
        EditNameListener listener = new MockEditNameListener();
        objectNode.addEditNameListener(listener);

        objectNode.removeEditNameListener(null);

        assertEquals("Failed to remove the listener correctly.", 1,
            objectNode.getListeners(EditNameListener.class).length);
    }

    /**
     * <p>
     * Tests ObjectNode#removeSetNameListener(SetNameListener) for accuracy.
     * </p>
     *
     * <p>
     * It verifies ObjectNode#removeSetNameListener(SetNameListener) is correct.
     * </p>
     */
    public void testRemoveSetNameListener() {
        SetNameListener listener = new MockSetNameListener();
        objectNode.addSetNameListener(listener);

        objectNode.removeSetNameListener(listener);

        assertEquals("Failed to remove the listener correctly.", 0,
            objectNode.getListeners(SetNameListener.class).length);
    }

    /**
     * <p>
     * Tests ObjectNode#removeSetNameListener(SetNameListener) for accuracy.
     * </p>
     *
     * <p>
     * It tests the case that when listener is null and expects success.
     * </p>
     */
    public void testRemoveSetNameListener_NullListener() {
        SetNameListener listener = new MockSetNameListener();
        objectNode.addSetNameListener(listener);

        objectNode.removeSetNameListener(null);

        assertEquals("Failed to remove the listener correctly.", 1,
            objectNode.getListeners(SetNameListener.class).length);
    }

    /**
     * <p>
     * Tests ObjectNode#removeResizeListener(ResizeListener) for accuracy.
     * </p>
     *
     * <p>
     * It verifies ObjectNode#removeResizeListener(ResizeListener) is correct.
     * </p>
     */
    public void testRemoveResizeListener() {
        ResizeListener listener = new MockResizeListener();
        objectNode.addResizeListener(listener);

        objectNode.removeResizeListener(listener);

        assertEquals("Failed to remove the listener correctly.", 0,
            objectNode.getListeners(ResizeListener.class).length);
    }

    /**
     * <p>
     * Tests ObjectNode#removeResizeListener(ResizeListener) for accuracy.
     * </p>
     *
     * <p>
     * It tests the case that when listener is null and expects success.
     * </p>
     */
    public void testRemoveResizeListener_NullListener() {
        ResizeListener listener = new MockResizeListener();
        objectNode.addResizeListener(listener);

        objectNode.removeResizeListener(null);

        assertEquals("Failed to remove the listener correctly.", 1,
            objectNode.getListeners(ResizeListener.class).length);
    }

    /**
     * <p>
     * Tests ObjectNode#applyNewName(String,String) for accuracy.
     * </p>
     *
     * <p>
     * It verifies ObjectNode#applyNewName(String,String) is correct.
     * </p>
     */
    public void testApplyNewName() {
        objectNode.applyNewName("oldName", "newName");
        assertEquals("Failed to apply new name correctly.", "newName", objectNode.getName());
    }

    /**
     * <p>
     * Tests ObjectNode#applyNewName(String,String) for accuracy.
     * </p>
     *
     * <p>
     * It tests the case that when oldName is empty and expects success.
     * </p>
     */
    public void testApplyNewName_EmptyOldName() {
        objectNode.applyNewName(" ", "newName");
        assertEquals("Failed to apply new name correctly.", "newName", objectNode.getName());
    }

    /**
     * <p>
     * Tests ObjectNode#applyNewName(String,String) for failure.
     * </p>
     *
     * <p>
     * It tests the case that when newName is empty and expects IllegalArgumentException.
     * </p>
     */
    public void testApplyNewName_EmptyNewName() {
        objectNode.applyNewName("oldName", " ");
        assertEquals("Failed to apply new name correctly.", " ", objectNode.getName());
    }

    /**
     * <p>
     * Tests ObjectNode#applyNewName(String,String) for failure.
     * </p>
     *
     * <p>
     * It tests the case that when oldName is null and expects IllegalArgumentException.
     * </p>
     */
    public void testApplyNewName_NullOldName() {
        try {
            objectNode.applyNewName(null, "newName");
            fail("IllegalArgumentException expected.");
        } catch (IllegalArgumentException iae) {
            //good
        }
    }

    /**
     * <p>
     * Tests ObjectNode#applyNewName(String,String) for failure.
     * </p>
     *
     * <p>
     * It tests the case that when newName is null and expects IllegalArgumentException.
     * </p>
     */
    public void testApplyNewName_NullNewName() {
        try {
            objectNode.applyNewName("oldName", null);
            fail("IllegalArgumentException expected.");
        } catch (IllegalArgumentException iae) {
            //good
        }
    }

    /**
     * <p>
     * Tests ObjectNode#getObject() for accuracy.
     * </p>
     *
     * <p>
     * It verifies ObjectNode#getObject() is correct.
     * </p>
     */
    public void testGetObject() {
        assertSame("Failed to get the object correctly.", object, objectNode.getObject());
    }

    /**
     * <p>
     * Tests ObjectNode#getName() for accuracy.
     * </p>
     *
     * <p>
     * It verifies ObjectNode#getName() is correct.
     * </p>
     */
    public void testGetName() {
        assertEquals("Failed to get the name correctly.", "name", objectNode.getName());
    }

    /**
     * <p>
     * Tests ObjectNode#contains(int,int) for accuracy.
     * </p>
     *
     * <p>
     * It verifies ObjectNode#contains(int,int) is correct.
     * </p>
     */
    public void testContains() {
        objectNode.setRenderScheme(RenderScheme.SimpleScheme);
        assertTrue("Failed to return the value correctly.", objectNode.contains(2, 2));
    }

    /**
     * <p>
     * Tests ObjectNode#setName(String) for accuracy.
     * </p>
     *
     * <p>
     * It verifies ObjectNode#setName(String) is correct.
     * </p>
     */
    public void testSetName() {
        objectNode.setName("name");
        assertEquals("Failed to set the name correctly.", "name", objectNode.getName());
    }

    /**
     * <p>
     * Tests ObjectNode#setName(String) for accuracy.
     * </p>
     *
     * <p>
     * It tests the case that when name is empty and expects success.
     * </p>
     */
    public void testSetName_EmptyName() {
        objectNode.setName(" ");
        assertEquals("Failed to set the name correctly.", " ", objectNode.getName());
    }

    /**
     * <p>
     * Tests ObjectNode#setName(String) for failure.
     * </p>
     *
     * <p>
     * It tests the case that when name is null and expects IllegalArgumentException.
     * </p>
     */
    public void testSetName_NullName() {
        try {
            objectNode.setName(null);
            fail("IllegalArgumentException expected.");
        } catch (IllegalArgumentException iae) {
            //good
        }
    }

    /**
     * <p>
     * Tests ObjectNode#getSize() for accuracy.
     * </p>
     *
     * <p>
     * It verifies ObjectNode#getSize() is correct.
     * </p>
     */
    public void testGetSize() {
        Dimension dimension = new Dimension();
        objectNode.setSize(dimension);

        assertEquals("Failed to get the size correctly.", dimension, objectNode.getSize());
    }

    /**
     * <p>
     * Tests ObjectNode#setSize(Dimension) for accuracy.
     * </p>
     *
     * <p>
     * It verifies ObjectNode#setSize(Dimension) is correct.
     * </p>
     */
    public void testSetSize() {
        Dimension dimension = new Dimension();
        objectNode.setSize(dimension);

        assertEquals("Failed to set the size correctly.", dimension, objectNode.getSize());
    }

    /**
     * <p>
     * Tests ObjectNode#processMouseEvent(MouseEvent) for failure.
     * </p>
     *
     * <p>
     * It tests the case that when e is null and expects IllegalArgumentException.
     * </p>
     */
    public void testProcessMouseEvent_NullE() {
        try {
            objectNode.processMouseEvent(null);
            fail("IllegalArgumentException expected.");
        } catch (IllegalArgumentException iae) {
            //good
        }
    }

    /**
     * <p>
     * Tests ObjectNode#paintComponent(Graphics) for failure.
     * </p>
     *
     * <p>
     * It tests the case that when g is null and expects IllegalArgumentException.
     * </p>
     */
    public void testPaintComponent_NullG() {
        try {
            objectNode.paintComponent(null);
            fail("IllegalArgumentException expected.");
        } catch (IllegalArgumentException iae) {
            //good
        }
    }

    /**
     * <p>
     * Tests ObjectNode#getPosition() for accuracy.
     * </p>
     *
     * <p>
     * It verifies ObjectNode#getPosition() is correct.
     * </p>
     */
    public void testGetPosition() {
        objectNode.setPosition(position);

        assertEquals("Failed to get the position correctly.", position, objectNode.getPosition());
    }

    /**
     * <p>
     * Tests ObjectNode#setPosition(Point) for accuracy.
     * </p>
     *
     * <p>
     * It verifies ObjectNode#setPosition(Point) is correct.
     * </p>
     */
    public void testSetPosition() {
        objectNode.setPosition(position);

        assertEquals("Failed to set the position correctly.", position, objectNode.getPosition());
    }

    /**
     * <p>
     * Tests ObjectNode#setPosition(Point) for failure.
     * </p>
     *
     * <p>
     * It tests the case that when position is null and expects IllegalArgumentException.
     * </p>
     */
    public void testSetPosition_NullPosition() {
        try {
            objectNode.setPosition(null);
            fail("IllegalArgumentException expected.");
        } catch (IllegalArgumentException iae) {
            //good
        }
    }

    /**
     * <p>
     * Tests ObjectNode#getFontFamily() for accuracy.
     * </p>
     *
     * <p>
     * It verifies ObjectNode#getFontFamily() is correct.
     * </p>
     */
    public void testGetFontFamily() {
        objectNode.setFontFamily("family");
        assertEquals("Failed to get the font family correctly.", "family", objectNode.getFontFamily());
    }

    /**
     * <p>
     * Tests ObjectNode#getFontSize() for accuracy.
     * </p>
     *
     * <p>
     * It verifies ObjectNode#getFontSize() is correct.
     * </p>
     */
    public void testGetFontSize() {
        objectNode.setFontSize(8);
        assertEquals("Failed to get the font size correctly.", 8, objectNode.getFontSize());
    }

    /**
     * <p>
     * Tests ObjectNode#setFontFamily(String) for accuracy.
     * </p>
     *
     * <p>
     * It verifies ObjectNode#setFontFamily(String) is correct.
     * </p>
     */
    public void testSetFontFamily() {
        objectNode.setFontFamily("family");
        assertEquals("Failed to set the font family correctly.", "family", objectNode.getFontFamily());
    }

    /**
     * <p>
     * Tests ObjectNode#setFontFamily(String) for failure.
     * </p>
     *
     * <p>
     * It tests the case that when fontFamily is null and expects IllegalArgumentException.
     * </p>
     */
    public void testSetFontFamily_NullFontFamily() {
        try {
            objectNode.setFontFamily(null);
            fail("IllegalArgumentException expected.");
        } catch (IllegalArgumentException iae) {
            //good
        }
    }

    /**
     * <p>
     * Tests ObjectNode#setFontFamily(String) for failure.
     * </p>
     *
     * <p>
     * It tests the case that when fontFamily is empty and expects IllegalArgumentException.
     * </p>
     */
    public void testSetFontFamily_EmptyFontFamily() {
        try {
            objectNode.setFontFamily(" ");
            fail("IllegalArgumentException expected.");
        } catch (IllegalArgumentException iae) {
            //good
        }
    }

    /**
     * <p>
     * Tests ObjectNode#setFontSize(int) for accuracy.
     * </p>
     *
     * <p>
     * It verifies ObjectNode#setFontSize(int) is correct.
     * </p>
     */
    public void testSetFontSize() {
        objectNode.setFontSize(8);
        assertEquals("Failed to get the font size correctly.", 8, objectNode.getFontSize());

    }

    /**
     * <p>
     * Tests ObjectNode#setFontSize(int) for failure.
     * </p>
     *
     * <p>
     * It tests the case that when fontSize is negative and expects IllegalArgumentException.
     * </p>
     */
    public void testSetFontSize_NegativeSize() {
        try {
            objectNode.setFontSize(-8);
            fail("IllegalArgumentException expected.");
        } catch (IllegalArgumentException iae) {
            //good
        }
    }

    /**
     * <p>
     * Tests ObjectNode#getPopup() for accuracy.
     * </p>
     *
     * <p>
     * It verifies ObjectNode#getPopup() is correct.
     * </p>
     */
    public void testGetPopup() {
        JPopupMenu popup = new JPopupMenu();
        objectNode.setPopup(popup);
        assertSame("Failed to get the menu correctly.", popup, objectNode.getPopup());
    }

    /**
     * <p>
     * Tests ObjectNode#getShadowColor() for accuracy.
     * </p>
     *
     * <p>
     * It verifies ObjectNode#getShadowColor() is correct.
     * </p>
     */
    public void testGetShadowColor() {
        objectNode.setShadowColor(Color.RED);
        assertEquals("Failed to get the shadow color correctly.", Color.RED, objectNode.getShadowColor());
    }

    /**
     * <p>
     * Tests ObjectNode#notifyGraphNodeChange for accuracy.
     * </p>
     *
     */
    public void testNotifyGraphNodeChange() {

        objectNode = new ObjectNode(object, graphConnector, TestHelper.createGraphNode(), position, bound, corners,
                TestHelper.createObjectNodeProperties());

        GraphNode node = objectNode.getGraphNode();
        node.clearProperties();

        node.addProperty(TestHelper.createProperty("color", "#222222"));
        node.addProperty(TestHelper.createProperty("family", "Arial"));
        node.addProperty(TestHelper.createProperty("style", "2"));
        node.addProperty(TestHelper.createProperty("size", "14"));
        node.addProperty(TestHelper.createProperty("width", "210"));
        node.addProperty(TestHelper.createProperty("height", "220"));
        node.addProperty(TestHelper.createProperty("shadow", "22"));
        node.addProperty(TestHelper.createProperty("radius", "10"));
        node.addProperty(TestHelper.createProperty("scheme", "0"));

        objectNode.notifyGraphNodeChange(null);

        assertEquals("Failed to update the stroke color.", new Color(34, 34, 34), objectNode.getStrokeColor());
        assertEquals("Failed to update the fill color.", new Color(34, 34, 34), objectNode.getFillColor());
        assertEquals("Failed to update the fill color 2.", new Color(34, 34, 34), objectNode.getFillColor2());
        assertEquals("Failed to update the shadow color.", new Color(34, 34, 34), objectNode.getShadowColor());
        assertEquals("Failed to update the font color.", new Color(34, 34, 34), objectNode.getFontColor());

        assertEquals("Failed to update the font family", "Arial", objectNode.getFontFamily());
        assertEquals("Failed to update the font size", 14, objectNode.getFontSize());
        assertEquals("Failed to update the font style", 2, objectNode.getFontStyle());

        assertEquals("Failed to update the shadow length", 22, objectNode.getShadowLength());
        assertEquals("Failed to update the rounding radius", 10, objectNode.getRoundingRadius());

        int width = objectNode.getWidth();
        int height = objectNode.getHeight();
        assertEquals("Failed to update the width", 220, width);
        assertEquals("Failed to update the height", 230, height);

    }

    /**
     * <p>
     * The entry of the demo program.
     * </p>
     *
     * @param args the arguments
     */
    public static void main(String[] args) {
        ObjectNode node = new ObjectNode(new ObjectImpl(), new GraphConnector(), new GraphNode(),
            DEFAULT_RELATIVE_POSITION, DEFAULT_BOUND, Arrays.asList(DEFAULT_SELECTION_CORNER_TYPE),
            TestHelper.createObjectNodeProperties());
        node.setSize(new Dimension(300, 300));

        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().add(node);
        frame.setSize(new Dimension(500, 500));
        frame.setVisible(true);
    }
}