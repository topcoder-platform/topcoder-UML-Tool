/*
 * Copyright (C) 2007 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.gui.diagramviewer.uml.sequenceelements.lifeline;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.event.MouseEvent;
import java.util.EnumMap;

import javax.swing.JFrame;
import javax.swing.JPopupMenu;

import com.topcoder.diagraminterchange.GraphNode;
import com.topcoder.gui.diagramviewer.DiagramState;
import com.topcoder.gui.diagramviewer.DiagramViewer;
import com.topcoder.gui.diagramviewer.uml.sequenceelements.RenderScheme;
import com.topcoder.gui.diagramviewer.uml.sequenceelements.TestHelper;
import com.topcoder.gui.diagramviewer.uml.sequenceelements.accuracytests.AccuracyTestImagePrinter;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

/**
 * <p>
 * Unit TestCases for LifelineSegment class.
 * </p>
 *
 * @author TCSDEVELOPER
 * @version 1.1
 * @since 1.1
 */

public class LifelineSegmentTest extends TestCase {

    /**
     * <p>
     * The default rectangle bounds argument to construct the LifelineSegment instance.
     * </p>
     */
    private static Rectangle DEFAULT_BOUNDS = new Rectangle(100, 100, 30, 90);

    /**
     * <p>
     * The default position argument to construct the LifelineSegment instance.
     * </p>
     */
    private static Point DEFAULT_POSITION = new Point(0, 0);

    /**
     * <p>
     * LifelineSegment instance for tesing.
     * </p>
     *
     * <p>
     * Note:It is constructed in the setUp method and before TestHelper.loadXMLConfig().
     * </p>
     *
     * <p>
     * The member instance variables in the lifeline is loaded using the default value.
     * </p>
     */
    private LifelineSegment lifeLineSeg;

    /**
     * <p>
     * Returns the test suite of this class.
     * </p>
     *
     * @return the test suite of this class.
     */
    public static Test suite() {
        return new TestSuite(LifelineSegmentTest.class);
    }

    /**
     * <p>
     * Sets up test environment.
     * </p>
     *
     * @throws Exception to JUnit
     *
     */
    protected void setUp() throws Exception {

        GraphNode graphnode = new GraphNode();

        EnumMap<LifelineSegmentPropertyType, String> properties = TestUtil.createLifelineSegmentSomeProperties();
        lifeLineSeg = new LifelineSegment(graphnode, DEFAULT_POSITION, DEFAULT_BOUNDS, properties);

        TestHelper.loadXMLConfig(TestHelper.CONFIG_FILE);
        super.setUp();
    }

    /**
     * <p>
     * Tears down test environment.
     * </p>
     *
     * @throws Exception to JUnit
     *
     */
    protected void tearDown() throws Exception {

        TestHelper.clearConfig();
        super.tearDown();
    }

    /**
     * <p>
     * Test the ctor LifelineSegment(GraphNode graphNode,Point position,Rectangle bound,
     * EnumMap< LifelineSegmentPropertyType,String > propertyNameMapping) for failure.
     * </p>
     *
     * <p>
     * It tests when GraphNode argument is null and expects the IllegalArgumentException.
     * </p>
     *
     */
    public void testCtor_NullGraphNode() {

        EnumMap<LifelineSegmentPropertyType, String> properties = TestUtil.createLifelineSegmentProperties();
        try {
            new LifelineSegment(null, DEFAULT_POSITION, DEFAULT_BOUNDS, properties);
            fail("IllegalArgumentException expected");
        } catch (IllegalArgumentException e) {
            // good
        }
    }

    /**
     * <p>
     * Test the ctor LifelineSegment(GraphNode graphNode,Point position,Rectangle bound,
     * EnumMap< LifelineSegmentPropertyType,String > propertyNameMapping) for failure.
     * </p>
     *
     * <p>
     * It tests when the Point argument is null and expects the IllegalArgumentException.
     * </p>
     *
     */
    public void testCtor_NullPoint() {

        GraphNode graphnode = new GraphNode();
        EnumMap<LifelineSegmentPropertyType, String> properties = TestUtil.createLifelineSegmentProperties();
        try {
            new LifelineSegment(graphnode, null, DEFAULT_BOUNDS, properties);
            fail("IllegalArgumentException expected");
        } catch (IllegalArgumentException e) {
            // good
        }
    }

    /**
     *
     * <p>
     * Test the ctor LifelineSegment(GraphNode graphNode,Point position,Rectangle bound,
     * EnumMap < LifelineSegmentPropertyType,String > propertyNameMapping) for failure.
     * </p>
     *
     * <p>
     * It tests when the bound argument is empty and expects the IllegalArgumentException.
     * </p>
     *
     */
    public void testCtor_NullBound() {

        GraphNode graphnode = new GraphNode();
        EnumMap<LifelineSegmentPropertyType, String> properties = TestUtil.createLifelineSegmentProperties();
        try {
            new LifelineSegment(graphnode, DEFAULT_POSITION, null, properties);
            fail("IllegalArgumentException expected");
        } catch (IllegalArgumentException e) {
            // good
        }
    }

    /**
     * <p>
     * Test the ctor LifelineSegment(GraphNode graphNode,Point position,Rectangle bound,
     * EnumMap< LifelineSegmentPropertyType,String > propertyNameMapping) for failure.
     * </p>
     *
     * <p>
     * It tests when propertNameMapping argument is null and expects the IllegalArgumentException.
     * </p>
     *
     */
    public void testCtor_NullPropertyMap() {

        GraphNode graphnode = new GraphNode();
        try {
            new LifelineSegment(graphnode, DEFAULT_POSITION, DEFAULT_BOUNDS, null);
            fail("IllegalArgumentException expected");
        } catch (IllegalArgumentException e) {
            // good
        }
    }

    /**
     * <p>
     * Test the ctor LifelineSegment(GraphNode graphNode,Point position,Rectangle bound,
     * EnumMap< LifelineSegmentPropertyType,String > propertyNameMapping) for failure.
     * </p>
     *
     * <p>
     * It tests when propertNameMapping argument is empty and expects the IllegalArgumentException.
     * </p>
     *
     */
    public void testCtor_EmptyPropertyMap() {

        GraphNode graphnode = new GraphNode();
        EnumMap<LifelineSegmentPropertyType, String> emptyproperty = new EnumMap<LifelineSegmentPropertyType, String>(
                LifelineSegmentPropertyType.class);

        try {
            new LifelineSegment(graphnode, DEFAULT_POSITION, DEFAULT_BOUNDS, emptyproperty);
            fail("IllegalArgumentException expected");
        } catch (IllegalArgumentException e) {
            // good
        }
    }

    /**
     * <p>
     * Test the ctor LifelineSegment(GraphNode graphNode,Point position,Rectangle bound,
     * EnumMap< LifelineSegmentPropertyType,String > propertyNameMapping) for failure.
     * </p>
     *
     * <p>
     * It tests when propertNameMapping argument is invalid and expects the
     * IllegalArgumentException.
     * </p>
     *
     */
    public void testCtor_InvalidPropertyMap() {

        GraphNode graphnode = new GraphNode();
        EnumMap<LifelineSegmentPropertyType, String> invalidproperty = TestUtil
                .createInvalidLifelineSegmentProperties();

        try {
            new LifelineSegment(graphnode, DEFAULT_POSITION, DEFAULT_BOUNDS, invalidproperty);
            fail("IllegalArgumentException expected");
        } catch (IllegalArgumentException e) {
            // good
        }
    }

    /**
     * <p>
     * Test the ctor LifelineSegment(GraphNode graphNode,Point position,Rectangle bound,
     * EnumMap< LifelineSegmentPropertyType,String > propertyNameMapping) for accuracy.
     * </p>
     *
     * <p>
     * This method tests the case when the member instance are loaded from the GraphNode instance.
     * </p>
     *
     */
    public void testCtor_FromGraphNode() {

        GraphNode graphnode = TestUtil.createGraphNodeWithProperties();
        EnumMap<LifelineSegmentPropertyType, String> properties = TestUtil.createLifelineSegmentProperties();

        try {
            LifelineSegment lifelineseg = new LifelineSegment(graphnode, DEFAULT_POSITION, DEFAULT_BOUNDS, properties);

            assertEquals("Fail to load the fillcolor", new Color(16, 16, 16), lifelineseg.getFillColor());
            assertEquals("Fail to load the shadowcolor", new Color(32, 32, 32), lifelineseg.getShadowColor());
            assertEquals("Fail to load the strokecolor", new Color(112, 112, 112), lifelineseg.getStrokeColor());
            assertEquals("Fail to load the height", 16, lifelineseg.getHeight());
            assertEquals("Fail to load the width", 8, lifelineseg.getWidth());
            assertEquals("Fail to load the renderscheme", RenderScheme.SimpleScheme, lifelineseg.getRenderScheme());
            assertEquals("Fail to load the shadowlength", 4, lifelineseg.getShadowLength());
        } catch (IllegalArgumentException e) {
            fail("Should not throw IllegalArgumentException");
        }
    }

    /**
     * <p>
     * Test the ctor LifelineSegment(GraphNode graphNode,Point position,Rectangle bound,
     * EnumMap< LifelineSegmentPropertyType,String > propertyNameMapping) for accuracy.
     * </p>
     *
     * <p>
     * This method tests the case when the member instance are loaded using the ConfigManager.
     * </p>
     *
     */
    public void testCtor_FromConfigManager() {

        GraphNode graphNode = new GraphNode();
        EnumMap<LifelineSegmentPropertyType, String> properties = TestUtil.createLifelineSegmentProperties();

        try {
            LifelineSegment lifelineseg = new LifelineSegment(graphNode, DEFAULT_POSITION, DEFAULT_BOUNDS, properties);

            assertEquals("Fail to load the fillcolor", Color.GREEN, lifelineseg.getFillColor());
            assertEquals("Fail to load the shadowcolor", Color.GRAY, lifelineseg.getShadowColor());
            assertEquals("Fail to load the strokecolor", Color.BLACK, lifelineseg.getStrokeColor());
            assertEquals("Fail to load the height", 16, lifelineseg.getHeight());
            assertEquals("Fail to load the width", 6, lifelineseg.getWidth());
            assertEquals("Fail to load the renderscheme", RenderScheme.SimpleScheme, lifelineseg.getRenderScheme());
            assertEquals("Fail to load the shadowlength", 6, lifelineseg.getShadowLength());
        } catch (IllegalArgumentException e) {
            fail("Should not throw IllegalArgumentException");
        }
    }


    /**
     * <p>
     * Test the ctor LifelineSegment(GraphNode graphNode,Point position,Rectangle bound,
     * EnumMap< LifelineSegmentPropertyType,String > propertyNameMapping) for accuracy.
     * </p>
     *
     * <p>
     * This method tests the case when the int value loaded is negative,it will be set to default value.
     * </p>
     *
     * @throws Exception to JUnit
     *
     */
    public void testCtor_NegativeValue() throws Exception {

        TestHelper.clearConfig();
        TestHelper.loadXMLConfig(TestHelper.CONFIG_NEGATIVE_FILE);

        GraphNode graphNode = new GraphNode();
        EnumMap<LifelineSegmentPropertyType, String> properties = TestUtil.createLifelineSegmentProperties();

        try {
            LifelineSegment lifelineseg = new LifelineSegment(graphNode, DEFAULT_POSITION, DEFAULT_BOUNDS, properties);

            assertEquals("Fail to load the fillcolor", Color.GREEN, lifelineseg.getFillColor());
            assertEquals("Fail to load the shadowcolor", Color.GRAY, lifelineseg.getShadowColor());
            assertEquals("Fail to load the strokecolor", Color.BLACK, lifelineseg.getStrokeColor());
            assertEquals("Fail to load the height", 15, lifelineseg.getHeight());
            assertEquals("Fail to load the width", 5, lifelineseg.getWidth());
            assertEquals("Fail to load the width", 5, lifelineseg.getWidth());
            assertEquals("Fail to load the renderscheme", RenderScheme.SimpleScheme, lifelineseg.getRenderScheme());
            assertEquals("Fail to load the shadowlength", 5, lifelineseg.getShadowLength());
        } catch (IllegalArgumentException e) {
            fail("Should not throw IllegalArgumentException");
        }
    }


    /**
     * <p>
     * Test the ctor LifelineSegment(GraphNode graphNode,Point position,Rectangle bound,
     * EnumMap< LifelineSegmentPropertyType,String > propertyNameMapping) for accuracy.
     * </p>
     *
     * <p>
     * This method tests the case when the member instance are loaded using the default value.
     * </p>
     *
     */
    public void testCtor_FromDefault() {

        assertNotNull("The LifelineSegment instance should not be null", lifeLineSeg);

        assertEquals("Fail to load the fillcolor", Color.WHITE, lifeLineSeg.getFillColor());
        assertEquals("Fail to load the shadowcolor", Color.BLACK, lifeLineSeg.getShadowColor());
        assertEquals("Fail to load the strokecolor", Color.BLACK, lifeLineSeg.getStrokeColor());
        assertEquals("Fail to load the height", 15, lifeLineSeg.getHeight());
        assertEquals("Fail to load the width", 5, lifeLineSeg.getWidth());
        assertEquals("Fail to load the renderscheme", RenderScheme.TopCoderScheme, lifeLineSeg.getRenderScheme());
        assertEquals("Fail to load the shadowlength", 5, lifeLineSeg.getShadowLength());
    }

    /**
     * <p>
     * Test the method paintComponent for failure.
     * </p>
     *
     * <p>
     * It tests when the value argument is null,and expects the IllegalArgumentException.
     * </p>
     */
    public void testPaintComponent_Null() {
        try {
            lifeLineSeg.paintComponent(null);
            fail("Should throw IllegalArgumentException");
        } catch (IllegalArgumentException e) {
            // good
        }
    }

    /**
     * <p>
     * Tests paintComponent method for accuracy.
     * </p>
     *
     * @throws Exception to JUnit
     */
    public void testPaintComponentGraphics() throws Exception {

        GraphNode graphNode = new GraphNode();
        EnumMap<LifelineSegmentPropertyType, String> properties = TestUtil.createLifelineSegmentProperties();

        LifelineSegment lifelineseg = new LifelineSegment(graphNode, DEFAULT_POSITION, DEFAULT_BOUNDS, properties);

        // Set the ShadowColor and ShadowLength
        lifelineseg.setShadowColor(Color.GRAY);
        lifelineseg.setShadowLength(4);

        // Set the RenderScheme
        lifelineseg.setRenderScheme(RenderScheme.TopCoderScheme);

        // Set the Strock Color
        lifelineseg.setStrokeColor(Color.BLACK);

        // Set the fill Color
        lifelineseg.setFillColor(Color.YELLOW);

        AccuracyTestImagePrinter printer = new AccuracyTestImagePrinter(
                "test_files/accuracy_tests/Lifeline_Segment.jpg");
        lifelineseg.paintComponent(printer.initImage());
        printer.print();
    }

    /**
     * <p>
     * Tests paintComponent method for accuracy.
     * </p>
     *
     * <p>
     * It tests drawing the LifelineSegment when it is selected
     * </p>
     * @throws Exception to JUnit
     */
    public void testPaintComponentGraphicsSelected() throws Exception {

        GraphNode graphNode = new GraphNode();
        EnumMap<LifelineSegmentPropertyType, String> properties = TestUtil.createLifelineSegmentProperties();

        LifelineSegment lifelineseg = new LifelineSegment(graphNode, DEFAULT_POSITION, DEFAULT_BOUNDS, properties);

        DiagramViewer viewer = TestUtil.createDV();
        viewer.add(lifelineseg);
        viewer.addSelectedElement(lifelineseg);

        // Set the ShadowColor and ShadowLength
        lifelineseg.setShadowColor(Color.GRAY);
        lifelineseg.setShadowLength(4);

        // Set the RenderScheme
        lifelineseg.setRenderScheme(RenderScheme.TopCoderScheme);

        // Set the Strock Color
        lifelineseg.setStrokeColor(Color.BLACK);

        // Set the fill Color
        lifelineseg.setFillColor(Color.YELLOW);

        AccuracyTestImagePrinter printer = new AccuracyTestImagePrinter(
                "test_files/accuracy_tests/Lifeline_Segment_Selected.jpg");
        lifelineseg.paintComponent(printer.initImage());
        printer.print();
    }

    /**
     * <p>
     * Test the getter method getPropertyNameMappingElement for accuracy.
     * </p>
     *
     */
    public void testGetPropertyNameMappingElement_Accuracy() {

        String value = lifeLineSeg.getPropertyNameMappingElement(LifelineSegmentPropertyType.FILL_COLOR);
        assertEquals("Fail to get the mapping element correctly", "fillcolor", value);

        value = lifeLineSeg.getPropertyNameMappingElement(LifelineSegmentPropertyType.RENDER_SCHEME);
        assertTrue("Fail to get the mapping element correctly", null == value);
    }

    /**
     * <p>
     * Test the setter method setPropertyNameMappingElement for failure.
     * </p>
     *
     * <p>
     * It tests when the key argument is null,and expects the IllegalArgumentException.
     * </p>
     */
    public void testSetPropertyNameMappingElement_NullKey() {

        try {
            lifeLineSeg.setPropertyNameMappingElement(null, "length");
            fail("Should throw IllegalArgumentException");
        } catch (IllegalArgumentException e) {
            // good
        }
    }

    /**
     * <p>
     * Test the setter method setPropertyNameMappingElement for failure.
     * </p>
     *
     * <p>
     * It tests when the value argument is null,and expects the IllegalArgumentException.
     * </p>
     */
    public void testSetPropertyNameMappingElement_NullValue() {

        try {
            lifeLineSeg.setPropertyNameMappingElement(LifelineSegmentPropertyType.WIDTH, null);
            fail("Should throw IllegalArgumentException");
        } catch (IllegalArgumentException e) {
            // good
        }
    }

    /**
     * <p>
     * Test the setter method setPropertyNameMappingElement for failure.
     * </p>
     *
     * <p>
     * It tests when the value argument is empty,and expects the IllegalArgumentException.
     * </p>
     */
    public void testSetPropertyNameMappingElement_EmptyValue() {

        try {
            lifeLineSeg.setPropertyNameMappingElement(LifelineSegmentPropertyType.WIDTH, "");
            fail("Should throw IllegalArgumentException");
        } catch (IllegalArgumentException e) {
            // good
        }
    }

    /**
     * <p>
     * Test the setter method setPropertyNameMappingElement for accuracy.
     * </p>
     *
     */
    public void testSetPropertyNameMappingElement_Accuracy() {

        // insert
        lifeLineSeg.setPropertyNameMappingElement(LifelineSegmentPropertyType.HEIGHT, "height");
        String value = lifeLineSeg.getPropertyNameMappingElement(LifelineSegmentPropertyType.HEIGHT);
        assertEquals("Fail to set the name mapping element correctly", "height", value);

        // replace
        lifeLineSeg.setPropertyNameMappingElement(LifelineSegmentPropertyType.WIDTH, "SegWidth");
        value = lifeLineSeg.getPropertyNameMappingElement(LifelineSegmentPropertyType.WIDTH);
        assertEquals("Fail to set the name mapping element correctly", "SegWidth", value);
    }

    /**
     * <p>
     * Test the method getBounds.
     * </p>
     */
    public void testGetBounds() {
        Rectangle rect = lifeLineSeg.getBounds();
        assertNotNull("Fail to call the method getBounds", rect);
    }

    /**
     * <p>
     * Test the method processMouseEvent for failure.
     * </p>
     *
     * <p>
     * It tests when the value argument is null,and expects the IllegalArgumentException.
     * </p>
     */
    public void testProcessMouseEvent_Null() {
        try {
            lifeLineSeg.processMouseEvent(null);
            fail("Should throw IllegalArgumentException");
        } catch (IllegalArgumentException e) {
            // good
        }
    }

    /**
     * <p>
     * Test the setter method setFillColor for failure.
     * </p>
     *
     * <p>
     * It tests when the argument is null,and expects the IllegalArgumentException.
     * </p>
     */
    public void testSetFillColor_Null() {

        try {
            lifeLineSeg.setFillColor(null);
            fail("Should throw IllegalArgumentException");
        } catch (IllegalArgumentException e) {
            // good
        }
    }

    /**
     * <p>
     * Test the setter method setFillColor for accuracy.
     * </p>
     *
     */
    public void testSetFillColor_Accuracy() {

        lifeLineSeg.setFillColor(new Color(0, 0, 100));
        assertEquals("Fail to set the fillcolor correctly", new Color(0, 0, 100), lifeLineSeg.getFillColor());
    }

    /**
     * <p>
     * Test the getter method getStrokeColor for accuracy.
     * </p>
     *
     */
    public void testGetStrokeColor() {

        lifeLineSeg.setStrokeColor(new Color(18, 18, 18));
        assertEquals("Fail to get the strokecolor correctly", new Color(18, 18, 18), lifeLineSeg.getStrokeColor());
    }

    /**
     * <p>
     * Test the setter method setShadowLength for failure.
     * </p>
     *
     * <p>
     * It tests when the argument is negative,and expects the IllegalArgumentException.
     * </p>
     */
    public void testSetShadowLength_Fail() {

        try {
            lifeLineSeg.setShadowLength(-1);
            fail("Should throw IllegalArgumentException");
        } catch (IllegalArgumentException e) {
            // good
        }
    }

    /**
     * <p>
     * Test the getter method getShadowLength for accuracy.
     * </p>
     *
     */
    public void testGetShadowLength() {

        lifeLineSeg.setShadowLength(0);
        assertEquals("Fail to set the shadowLength correctly.", 0, lifeLineSeg.getShadowLength());
        lifeLineSeg.setShadowLength(9);
        assertEquals("Fail to set the shadowLength correctly.", 9, lifeLineSeg.getShadowLength());
    }

    /**
     * <p>
     * Test the setter method setShadowLength for accuracy.
     * </p>
     *
     */
    public void testSetShadowLength_Accuracy() {

        lifeLineSeg.setShadowLength(0);
        assertEquals("Fail to set the shadowLength correctly.", 0, lifeLineSeg.getShadowLength());
        lifeLineSeg.setShadowLength(8);
        assertEquals("Fail to set the shadowLength correctly.", 8, lifeLineSeg.getShadowLength());
    }

    /**
     * <p>
     * Test the setter method setStrokeColor for failure.
     * </p>
     *
     * <p>
     * It tests when the argument is null,and expects the IllegalArgumentException.
     * </p>
     */
    public void testSetStrokeColor_Null() {

        try {
            lifeLineSeg.setStrokeColor(null);
            fail("Should throw IllegalArgumentException");
        } catch (IllegalArgumentException e) {
            // good
        }
    }

    /**
     * <p>
     * Test the setter method setStrokeColor for accuracy.
     * </p>
     *
     */
    public void testSetStrokeColor_Accuracy() {

        lifeLineSeg.setStrokeColor(new Color(128, 128, 128));
        assertEquals("Fail to set the strokecolor correctly.", new Color(128, 128, 128), lifeLineSeg.getStrokeColor());
    }

    /**
     * <p>
     * Test the getter method getShadowColor for accuracy.
     * </p>
     *
     */
    public void testGetShadowColor() {

        lifeLineSeg.setShadowColor(new Color(12, 12, 12));
        assertEquals("Fail to get the shadowcolor correctly", new Color(12, 12, 12), lifeLineSeg.getShadowColor());
    }

    /**
     * <p>
     * Test the getter method getRenderScheme for accuracy.
     * </p>
     *
     */
    public void testGetRenderScheme() {

        lifeLineSeg.setRenderScheme(RenderScheme.TopCoderScheme);
        assertEquals("Fail to get the renderScheme correctly", RenderScheme.TopCoderScheme, lifeLineSeg
                .getRenderScheme());
    }

    /**
     * <p>
     * Test the getter method getFillColor for accuracy.
     * </p>
     *
     */
    public void testGetFillColor() {

        lifeLineSeg.setFillColor(new Color(12, 12, 12));
        assertEquals("Fail to get the fillColor correctly", new Color(12, 12, 12), lifeLineSeg.getFillColor());
    }

    /**
     * <p>
     * Test the setter method setShadowColor for failure.
     * </p>
     *
     * <p>
     * It tests when the argument is null,and expects the IllegalArgumentException.
     * </p>
     */
    public void testSetShadowColor_Null() {

        try {
            lifeLineSeg.setShadowColor(null);
            fail("Should throw IllegalArgumentException");
        } catch (IllegalArgumentException e) {
            // good
        }
    }

    /**
     * <p>
     * Test the setter method setShadowColor for accuracy.
     * </p>
     *
     */
    public void testSetShadowColor_Accuracy() {

        lifeLineSeg.setShadowColor(new Color(0, 0, 0));
        assertEquals("Fail to set the shadowcolor correctly", new Color(0, 0, 0), lifeLineSeg.getShadowColor());
    }

    /**
     * <p>
     * Test the setter method setRenderScheme for failure.
     * </p>
     *
     * <p>
     * It tests when the argument is null,and expects the IllegalArgumentException.
     * </p>
     */
    public void testSetRenderScheme_Null() {

        try {
            lifeLineSeg.setRenderScheme(null);
            fail("Should throw IllegalArgumentException");
        } catch (IllegalArgumentException e) {
            // good
        }
    }

    /**
     * <p>
     * Test the setter method setRenderScheme for accuracy.
     * </p>
     *
     */
    public void testSetRenderScheme_Accuracy() {

        lifeLineSeg.setRenderScheme(RenderScheme.SimpleScheme);
        assertEquals("Fail to set the renderScheme correctly.", RenderScheme.SimpleScheme, lifeLineSeg
                .getRenderScheme());
    }

    /**
     * <p>
     * Test the getter method getPopup for accuracy.
     * </p>
     *
     */
    public void testGetPopup() {

        JPopupMenu popup = new JPopupMenu();
        lifeLineSeg.setPopup(popup);
        assertSame("getPopup fails to get correctly", popup, lifeLineSeg.getPopup());

    }

    /**
     * <p>
     * Test the setter method setPopup for failure.
     * </p>
     *
     * <p>
     * It tests when the argument is null,and expects the IllegalArgumentException.
     * </p>
     */
    public void testSetPopup_Null() {
        try {
            lifeLineSeg.setPopup(null);
            fail("Should throw IllegalArgumentException");
        } catch (IllegalArgumentException e) {
            // good
        }
    }

    /**
     * <p>
     * Test the setter method setPopup for accuracy.
     * </p>
     *
     */
    public void testSetPopup_Accuracy() {

        JPopupMenu popup = new JPopupMenu();
        lifeLineSeg.setPopup(popup);
        assertSame("setPopup fails to set correctly", popup, lifeLineSeg.getPopup());
    }

    /**
     * Tests contains method for accuracy.
     *
     */
    public void testContains() {

        lifeLineSeg.setSelectionBound(new Rectangle(0, 0, 50, 50));
        boolean result = lifeLineSeg.contains(new Point(10, 10));
        assertTrue("the contains method fail to work correctly.", result);

        result = lifeLineSeg.contains(new Point(80, 80));
        assertTrue("the contains method fail to work correctly.", !result);

        // test for the child component
        EnumMap<LifelineSegmentPropertyType, String> properties = TestUtil.createLifelineSegmentSomeProperties();
        LifelineSegment subLifeLineSeg = new LifelineSegment(new GraphNode(), DEFAULT_POSITION, DEFAULT_BOUNDS,
                properties);
        subLifeLineSeg.setSelectionBound(new Rectangle(70, 70, 20, 20));
        lifeLineSeg.add(subLifeLineSeg);

        assertTrue("the contains method fail to work correctly.", lifeLineSeg.contains(new Point(80, 80)));
        assertTrue("the contains method fail to work correctly.", !(lifeLineSeg.contains(new Point(120, 80))));
    }

    /**
     * <p>
     * Test the method consumeEvent for failure.
     * </p>
     *
     * <p>
     * It tests when the argument is null,and expects the IllegalArgumentException.
     * </p>
     */
    public void testConsumEvent_Null() {

        try {
            lifeLineSeg.consumeEvent(null);
            fail("Should throw IllegalArgumentException");
        } catch (IllegalArgumentException e) {
            // good
        }
    }

    /**
     * <p>
     * Test the method consumeEvent for accuracy.
     * </p>
     *
     * @throws Exception to JUnit
     *
     */
    public void testConsumEvent() throws Exception {

        // Create a LifelineSegement
        EnumMap<LifelineSegmentPropertyType, String> properties = new EnumMap<LifelineSegmentPropertyType, String>(
                LifelineSegmentPropertyType.class);
        properties.put(LifelineSegmentPropertyType.FILL_COLOR, "fillcolor");
        LifelineSegment lifelineseg = new LifelineSegment(new GraphNode(), new Point(0, 0), new Rectangle(100, 200, 20,
                80), properties);

        // Create a DiagramViewer
        DiagramViewer viewer = TestUtil.createDV();
        viewer.setNewElementType(LifelineSegment.class);
        viewer.setState(DiagramState.ADD_ELEMENT_BY_CLICK);

        // Add the Popup
        JPopupMenu popup = new JPopupMenu();
        popup.add("test");
        lifelineseg.setPopup(popup);
        viewer.add(lifelineseg);
        MouseEvent event = new MouseEvent(lifelineseg, MouseEvent.MOUSE_CLICKED, 0, 0, 0, 0, 1, false,
                MouseEvent.BUTTON3);

        // test without popup
        boolean consumed = lifelineseg.consumeEvent(event);
        assertTrue("the consumeEvent failed to work correctly.", !consumed);

        // test with popup
        consumed = lifelineseg.consumeEvent(event);
        popup.setVisible(false);
        lifelineseg.remove(popup);
        assertTrue("the consumeEvent failed to work correctly.", !consumed);

        // not right click event
        event = new MouseEvent(lifelineseg, MouseEvent.MOUSE_CLICKED, 0, 0, 0, 0, 2, false, MouseEvent.BUTTON1);
        consumed = lifelineseg.consumeEvent(event);
        assertTrue("the consumeEvent failed to work correctly.", !consumed);

        // DiagramViewer not in the adding state
        viewer.setState(DiagramState.SELECT_ELEMENT);
        event = new MouseEvent(lifelineseg, MouseEvent.MOUSE_CLICKED, 0, 0, 0, 0, 1, false, MouseEvent.BUTTON3);
        consumed = lifelineseg.consumeEvent(event);
        assertTrue("the consumeEvent failed to work correctly.", !consumed);

        // no container
        viewer.remove(lifelineseg);
        event = new MouseEvent(lifelineseg, MouseEvent.MOUSE_CLICKED, 0, 0, 0, 0, 1, false, MouseEvent.BUTTON3);
        consumed = lifelineseg.consumeEvent(event);
        assertTrue("the consumeEvent failed to work correctly.", !consumed);
    }

    /**
     * <p>
     * The entry of the demo program.
     * </p>
     *
     * <p>
     * This demo prgram create a DiagramViewer and add a LifelineSegment to the DiagramViewer. Since
     * the LifelineSegment's process on LeftClick MouseEvent need to work with the parent
     * DiagramViewer, a DiagramViewer instance is needed.
     * </p>
     *
     * <p>
     * Dependencies on creating a DiagramViewer: memory_usage 2.0, simple_cache, object_factory
     * 2.0.1,zoom_panel 1.0,MockForTest.jar
     * </p>
     *
     * @param args the arguments
     * @throws Exception to JUnit
     */
    public static void main(String[] args) throws Exception {

        TestHelper.loadXMLConfig(TestHelper.CONFIG_FILE);

        // Create a LifelineSegement
        EnumMap<LifelineSegmentPropertyType, String> properties = new EnumMap<LifelineSegmentPropertyType, String>(
                LifelineSegmentPropertyType.class);
        properties.put(LifelineSegmentPropertyType.FILL_COLOR, "fillcolor");
        LifelineSegment lifelineseg = new LifelineSegment(new GraphNode(), new Point(0, 0), new Rectangle(100, 200, 20,
                80), properties);

        // Create a DiagramViewer
        DiagramViewer viewer = TestUtil.createDV();

        // Add the Popup
        JPopupMenu popup = new JPopupMenu();
        popup.add("test");
        lifelineseg.setPopup(popup);

        // Create a viewer and add it to the Frame
        JFrame frame = new JFrame();
        frame.add(viewer);
        // Add the lifeline to the viewer
        viewer.add(lifelineseg);

        frame.setSize(new Dimension(500, 500));
        frame.setVisible(true);
        TestHelper.clearConfig();
    }
}
