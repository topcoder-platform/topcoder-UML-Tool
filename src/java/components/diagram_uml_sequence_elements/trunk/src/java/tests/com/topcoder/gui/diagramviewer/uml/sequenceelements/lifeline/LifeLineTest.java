/*
 * Copyright (C) 2007 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.gui.diagramviewer.uml.sequenceelements.lifeline;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.event.MouseEvent;
import java.util.EnumMap;

import javax.swing.JFrame;
import javax.swing.JPopupMenu;

import com.topcoder.diagraminterchange.GraphEdge;
import com.topcoder.gui.diagramviewer.DiagramState;
import com.topcoder.gui.diagramviewer.DiagramViewer;
import com.topcoder.gui.diagramviewer.edges.EdgeEnding;
import com.topcoder.gui.diagramviewer.uml.sequenceelements.RenderScheme;
import com.topcoder.gui.diagramviewer.uml.sequenceelements.TestHelper;
import com.topcoder.gui.diagramviewer.uml.sequenceelements.accuracytests.AccuracyTestImagePrinter;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

/**
 * <p>
 * Unit TestCases for Lifeline class.
 * </p>
 *
 * @author TCSDEVELOPER
 * @version 1.1
 * @since 1.1
 */
public class LifeLineTest extends TestCase {

    /**
     * <p>
     * Lifeline instance for tesing.
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
    private Lifeline lifeline = null;


    /**
     * <p>
     * Sets up test environment.
     * </p>
     *
     * @throws Exception to JUnit
     */
    protected void setUp() throws Exception {

        // Construct the lifeline using the default value
        GraphEdge graphedge = TestUtil.createGraphEdge();
        EnumMap<LifelinePropertyType, String> properties = TestUtil.createLifelineWithSomeProperties();

        lifeline = new Lifeline(graphedge, properties);

        TestHelper.loadXMLConfig(TestHelper.CONFIG_FILE);
        super.setUp();
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
        super.tearDown();
    }

    /**
     * <p>
     * Returns the test suite of this class.
     * </p>
     *
     * @return the test suite of this class.
     */
    public static Test suite() {
        return new TestSuite(LifeLineTest.class);
    }

    /**
     * <p>
     * Test the ctor Lifeline(GraphEdge,EnumMap< LifelinePropertyType,String >) for failure.
     * </p>
     *
     * <p>
     * It tests when GraphEdge argument is null and expects the IllegalArgumentException.
     * </p>
     *
     */
    public void testCtor_NullGraphEdge() {

        EnumMap<LifelinePropertyType, String> properties = TestUtil.createLifelineProperties();
        try {
            new Lifeline(null, properties);
            fail("IllegalArgumentException expected");
        } catch (IllegalArgumentException e) {
            // good
        }
    }

    /**
     * <p>
     * Test the ctor Lifeline(GraphEdge,EnumMap< LifelinePropertyType,String >) for failure.
     * </p>
     *
     * <p>
     * It tests when EnumMap< LifelinePropertyType,String>  argument is null and expects the
     * IllegalArgumentException.
     * </p>
     *
     */
    public void testCtor_NullPropertyMap() {

        GraphEdge graphedge = TestUtil.createGraphEdge();
        try {
            new Lifeline(graphedge, null);
            fail("IllegalArgumentException expected");
        } catch (IllegalArgumentException e) {
            // good
        }
    }

    /**
     * <p>
     * Test the ctor Lifeline(GraphEdge,EnumMap< LifelinePropertyType,String >) for failure.
     * </p>
     *
     * <p>
     * It tests when EnumMap< LifelinePropertyType,String > argument is empty and expects the
     * IllegalArgumentException.
     * </p>
     *
     */
    public void testCtor_EmptyPropertyMap() {

        GraphEdge graphedge = TestUtil.createGraphEdge();

        EnumMap<LifelinePropertyType, String> propertyMap = new EnumMap<LifelinePropertyType, String>(
                LifelinePropertyType.class);

        try {
            new Lifeline(graphedge, propertyMap);
            fail("IllegalArgumentException expected");
        } catch (IllegalArgumentException e) {
            // good
        }
    }

    /**
     * <p>
     * Test the ctor Lifeline(GraphEdge,EnumMap< LifelinePropertyType,String >) for failure.
     * </p>
     *
     * <p>
     * It tests when EnumMap< LifelinePropertyType,String > argument is invalid and expects the
     * IllegalArgumentException.
     * </p>
     *
     */
    public void testCtor_InvalidPropertyMap() {

        GraphEdge graphedge = TestUtil.createGraphEdge();
        EnumMap<LifelinePropertyType, String> propertyMap = TestUtil.createInvalidLifelineProperties();

        try {
            new Lifeline(graphedge, propertyMap);
            fail("IllegalArgumentException expected");
        } catch (IllegalArgumentException e) {
            // good
        }
    }

    /**
     * <p>
     * Test the ctor Lifeline(GraphEdge,EnumMap< LifelinePropertyType,String >) for accuracy.
     * </p>
     *
     * <p>
     * This method tests the case when the member instance are loaded from the GraphEdge instance.
     * </p>
     *
     */
    public void testCtor_FromGraphEdge() {

        GraphEdge graphedge = TestUtil.createGraphEdgeWithProperties();
        EnumMap<LifelinePropertyType, String> properties = TestUtil.createLifelineProperties();

        try {

            Lifeline lifeline = new Lifeline(graphedge, properties);

            assertEquals("Fail to load the blanklength", 8, lifeline.getBlankLength());
            assertEquals("Fail to load the dashlength", 6, lifeline.getDashLength());
            assertEquals("Fail to load the lifelinelength", 90, lifeline.getLifelineLength());
            assertEquals("Fail to load the scheme", RenderScheme.SimpleScheme, lifeline.getRenderScheme());
            assertEquals("Fail to load the shadowcolor", new Color(48, 48, 48), lifeline.getShadowColor());
            assertEquals("Fail to load the shadowlength", 5, lifeline.getShadowLength());
            assertEquals("Fail to load the strokecolor", new Color(112, 112, 112), lifeline.getStrokeColor());
        } catch (IllegalArgumentException e) {
            fail("Should not throw IllegalArgumentException");
        }
    }

    /**
     * <p>
     * Test the ctor Lifeline(GraphEdge,EnumMap< LifelinePropertyType,String >) for accuracy.
     * </p>
     *
     * <p>
     * This method tests the case when the member instance are loaded using the ConfigManager.
     * </p>
     *
     */
    public void testCtor_FromConfigManager() {

        GraphEdge graphedge = TestUtil.createGraphEdge();
        EnumMap<LifelinePropertyType, String> properties = TestUtil.createLifelineProperties();

        try {
            Lifeline lifeline = new Lifeline(graphedge, properties);

            assertEquals("Fail to load the blanklength", 5, lifeline.getBlankLength());
            assertEquals("Fail to load the dashlength", 5, lifeline.getDashLength());
            assertEquals("Fail to load the lifelinelength", 120, lifeline.getLifelineLength());
            assertEquals("Fail to load the scheme", RenderScheme.SimpleScheme, lifeline.getRenderScheme());
            assertEquals("Fail to load the shadowcolor", Color.GRAY, lifeline.getShadowColor());
            assertEquals("Fail to load the shadowlength", 4, lifeline.getShadowLength());
            assertEquals("Fail to load the strokecolor", Color.GRAY, lifeline.getStrokeColor());
        } catch (IllegalArgumentException e) {
            fail("Should not throw IllegalArgumentException");
        }
    }


    /**
     * <p>
     * Test the ctor Lifeline(GraphEdge,EnumMap< LifelinePropertyType,String >) for accuracy.
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

        GraphEdge graphedge = TestUtil.createGraphEdge();
        EnumMap<LifelinePropertyType, String> properties = TestUtil.createLifelineProperties();

        try {
            Lifeline lifeline = new Lifeline(graphedge, properties);

            assertEquals("Fail to load the blanklength", 4, lifeline.getBlankLength());
            assertEquals("Fail to load the dashlength", 4, lifeline.getDashLength());
            assertEquals("Fail to load the lifelinelength", 100, lifeline.getLifelineLength());
            assertEquals("Fail to load the scheme", RenderScheme.SimpleScheme, lifeline.getRenderScheme());
            assertEquals("Fail to load the shadowcolor", Color.GRAY, lifeline.getShadowColor());
            assertEquals("Fail to load the shadowlength", 5, lifeline.getShadowLength());
            assertEquals("Fail to load the strokecolor", Color.GRAY, lifeline.getStrokeColor());
        } catch (IllegalArgumentException e) {
            fail("Should not throw IllegalArgumentException");
        }
    }


    /**
     * <p>
     * Test the ctor Lifeline(GraphEdge,EnumMap< LifelinePropertyType,String >) for accuracy.
     * </p>
     *
     * <p>
     * This method tests the case when the member instance are loaded using the default value.
     * </p>
     *
     */
    public void testCtor_FromDefault() {

        assertNotNull("The lifeline instance should not be null", lifeline);

        assertEquals("Fail to load the blanklength", 4, lifeline.getBlankLength());
        assertEquals("Fail to load the dashlength", 4, lifeline.getDashLength());
        assertEquals("Fail to load the lifelinelength", 100, lifeline.getLifelineLength());
        assertEquals("Fail to load the scheme", RenderScheme.TopCoderScheme, lifeline.getRenderScheme());
        assertEquals("Fail to load the shadowcolor", Color.BLACK, lifeline.getShadowColor());
        assertEquals("Fail to load the shadowlength", 5, lifeline.getShadowLength());
        assertEquals("Fail to load the strokecolor", Color.BLACK, lifeline.getStrokeColor());
    }

    /**
     * <p>
     * Test the getter method getDashLength for accuracy.
     * </p>
     *
     */
    public void testGetDashLength() {

        lifeline.setDashLength(12);
        assertEquals("Fail to get the dashLength correctly", 12, lifeline.getDashLength());
    }

    /**
     * <p>
     * Test the setter method setDashLength for failure.
     * </p>
     *
     * <p>
     * It tests when the argument is 0 or negative,and expects the IllegalArgumentException.
     * </p>
     */
    public void testSetDashLength_Fail() {

        try {
            lifeline.setDashLength(0);
            fail("Should throw IllegalArgumentException");
        } catch (IllegalArgumentException e) {
            // good
        }

        try {
            lifeline.setDashLength(-10);
            fail("Should throw IllegalArgumentException");
        } catch (IllegalArgumentException e) {
            // good
        }
    }

    /**
     * <p>
     * Test the setter method setDashLength for accuracy.
     * </p>
     *
     *
     */
    public void testSetDashLength_Accuracy() {

        lifeline.setLifelineLength(12);
        assertEquals("Fail to set the dashLength correctly.", 12, lifeline.getLifelineLength());

    }

    /**
     * <p>
     * Test the getter method getStrokeColor for accuracy.
     * </p>
     *
     */
    public void testGetStrokeColor() {

        lifeline.setStrokeColor(new Color(18, 18, 18));
        assertEquals("Fail to get the strokecolor correctly", new Color(18, 18, 18), lifeline.getStrokeColor());
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
            lifeline.setStrokeColor(null);
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

        lifeline.setStrokeColor(new Color(128, 128, 128));
        assertEquals("Fail to set the strokecolor correctly.", new Color(128, 128, 128), lifeline.getStrokeColor());
    }

    /**
     * <p>
     * Test the getter method getBlankLength for accuracy.
     * </p>
     *
     */
    public void testGetBlankLength() {

        lifeline.setBlankLength(9);
        assertEquals("Fail to get the blanklength correctly", 9, lifeline.getBlankLength());
    }

    /**
     * <p>
     * Test the setter method setBlankLength for failure.
     * </p>
     *
     * <p>
     * It tests when the argument is negative,and expects the IllegalArgumentException.
     * </p>
     */
    public void testSetBlankLength_Fail() {

        try {
            lifeline.setBlankLength(-1);
            fail("Should throw IllegalArgumentException");
        } catch (IllegalArgumentException e) {
            // good
        }
    }

    /**
     * <p>
     * Test the setter method setBlankLength for accuracy.
     * </p>
     *
     *
     */
    public void testSetBlankLength_Accuracy() {

        lifeline.setBlankLength(0);
        assertEquals("Fail to set the blanklength correctly.", 0, lifeline.getBlankLength());
        lifeline.setBlankLength(6);
        assertEquals("Fail to set the blanklength correctly.", 6, lifeline.getBlankLength());
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
            lifeline.setRenderScheme(null);
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

        lifeline.setRenderScheme(RenderScheme.SimpleScheme);
        assertEquals("Fail to set the renderScheme correctly.", RenderScheme.SimpleScheme, lifeline.getRenderScheme());
    }

    /**
     * <p>
     * Test the getter method getRenderScheme for accuracy.
     * </p>
     *
     */
    public void testGetRenderScheme() {

        lifeline.setRenderScheme(RenderScheme.TopCoderScheme);
        assertEquals("Fail to get the renderScheme correctly", RenderScheme.TopCoderScheme, lifeline.getRenderScheme());
    }

    /**
     * <p>
     * Test the setter method setLifelineLength for failure.
     * </p>
     *
     * <p>
     * It tests when the argument is 0 or negative,and expects the IllegalArgumentException.
     * </p>
     */
    public void testSetLifelineLength_Fail() {

        try {
            lifeline.setLifelineLength(0);
            fail("Should throw IllegalArgumentException");
        } catch (IllegalArgumentException e) {
            // good
        }

        try {
            lifeline.setLifelineLength(-1);
            fail("Should throw IllegalArgumentException");
        } catch (IllegalArgumentException e) {
            // good
        }
    }

    /**
     * <p>
     * Test the setter method setLifelineLength for accuracy.
     * </p>
     *
     */
    public void testSetLifelineLength_Accuracy() {

        lifeline.setLifelineLength(95);
        assertEquals("Fail to set the lifelineLength correctly.", 95, lifeline.getLifelineLength());
    }

    /**
     * <p>
     * Test the getter method getLifelineLength for accuracy.
     * </p>
     *
     */
    public void testGetLifelineLength() {

        lifeline.setLifelineLength(80);
        assertEquals("Fail to get the lifelineLength correctly", 80, lifeline.getLifelineLength());
    }

    /**
     * <p>
     * Test the getter method getShadowLength for accuracy.
     * </p>
     *
     */
    public void testGetShadowLength() {

        lifeline.setShadowLength(4);
        assertEquals("Fail to get the shadowLength correctly", 4, lifeline.getShadowLength());
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
            lifeline.setShadowLength(-1);
            fail("Should throw IllegalArgumentException");
        } catch (IllegalArgumentException e) {
            // good
        }
    }

    /**
     * <p>
     * Test the setter method setShadowLength for accuracy.
     * </p>
     *
     */
    public void testSetShadowLength_Accuracy() {

        lifeline.setShadowLength(0);
        assertEquals("Fail to set the shadowLength correctly.", 0, lifeline.getShadowLength());
        lifeline.setShadowLength(4);
        assertEquals("Fail to set the shadowLength correctly.", 4, lifeline.getShadowLength());
    }

    /**
     * <p>
     * Test the getter method getShadowColor for accuracy.
     * </p>
     *
     */
    public void testGetShadowColor() {

        lifeline.setShadowColor(new Color(12, 12, 12));
        assertEquals("Fail to get the shadowcolor correctly", new Color(12, 12, 12), lifeline.getShadowColor());
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
            lifeline.setShadowColor(null);
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

        lifeline.setShadowColor(new Color(0, 0, 0));
        assertEquals("Fail to set the shadowcolor correctly", new Color(0, 0, 0), lifeline.getShadowColor());
    }

    /**
     * <p>
     * Test the getter method getPropertyNameMappingElement for failure.
     * </p>
     *
     * <p>
     * It tests when the argument is null,and expects the IllegalArgumentException.
     * </p>
     *
     */
    public void testGetPropertyNameMappingElement_Null() {

        try {
            lifeline.getPropertyNameMappingElement(null);
            fail("Should throw IllegalArgumentException");
        } catch (IllegalArgumentException e) {
            // good
        }
    }

    /**
     * <p>
     * Test the getter method getPropertyNameMappingElement for accuracy.
     * </p>
     *
     */
    public void testGetPropertyNameMappingElement_Accuracy() {

        String value = lifeline.getPropertyNameMappingElement(LifelinePropertyType.SHADOW_LENGTH);
        assertEquals("Fail to get the mapping element correctly", "shadowlength", value);

        value = lifeline.getPropertyNameMappingElement(LifelinePropertyType.LIFELINE_LENGTH);
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
            lifeline.setPropertyNameMappingElement(null, "length");
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
            lifeline.setPropertyNameMappingElement(LifelinePropertyType.LIFELINE_LENGTH, null);
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
            lifeline.setPropertyNameMappingElement(LifelinePropertyType.LIFELINE_LENGTH, "");
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
        lifeline.setPropertyNameMappingElement(LifelinePropertyType.LIFELINE_LENGTH, "lifeline");
        String value = lifeline.getPropertyNameMappingElement(LifelinePropertyType.LIFELINE_LENGTH);
        assertEquals("Fail to set the name mapping element correctly", "lifeline", value);

        // replace
        lifeline.setPropertyNameMappingElement(LifelinePropertyType.LIFELINE_LENGTH, "linelength");
        value = lifeline.getPropertyNameMappingElement(LifelinePropertyType.LIFELINE_LENGTH);
        assertEquals("Fail to set the name mapping element correctly", "linelength", value);
    }

    /**
     * <p>
     * Test the method getBounds.
     * </p>
     */
    public void testGetBounds() {
        Rectangle rect = lifeline.getBounds();
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
            lifeline.processMouseEvent(null);
            fail("Should throw IllegalArgumentException");
        } catch (IllegalArgumentException e) {
            // good
        }
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
            lifeline.paintComponent(null);
            fail("Should throw IllegalArgumentException");
        } catch (IllegalArgumentException e) {
            // good
        }
    }

    /**
     * <p>
     * Test the getter method getPopup for accuracy.
     * </p>
     *
     */
    public void testGetPopup() {

        JPopupMenu popup = new JPopupMenu();
        lifeline.setPopup(popup);
        assertSame("getPopup fails to get correctly", popup, lifeline.getPopup());

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
            lifeline.setPopup(null);
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
        lifeline.setPopup(popup);
        assertSame("setPopup fails to set correctly", popup, lifeline.getPopup());
    }

    /**
     * Tests paintComponent method for accuracy.
     *
     * @throws Exception to JUnit
     */
    public void testPaintComponentGraphics() throws Exception {

        GraphEdge graphedge = TestUtil.createGraphEdge();
        EnumMap<LifelinePropertyType, String> properties = TestUtil.createLifelineWithSomeProperties();

        Lifeline lifeline = new Lifeline(graphedge, properties);

        // Set the ShadowColor and ShadowLength
        lifeline.setShadowColor(Color.GRAY);
        lifeline.setShadowLength(1);

        // Set the RenderScheme
        lifeline.setRenderScheme(RenderScheme.TopCoderScheme);

        // Set the Strock Color
        lifeline.setStrokeColor(Color.BLUE);

        // Set the left endpoints
        EdgeEnding leftending = lifeline.getLeftEnding();
        leftending.setEndingPoint(new Point(100, 100));

        // Set the right endpoints
        EdgeEnding rightending = lifeline.getRightEnding();
        rightending.setEndingPoint(new Point(100, 300));

        graphedge = TestUtil.createGraphEdge();
        properties = TestUtil.createLifelineWithSomeProperties();
        Lifeline lifeline2 = new Lifeline(graphedge, properties);

        // Set the ShadowColor and ShadowLength
        lifeline2.setShadowColor(Color.GRAY);
        lifeline2.setShadowLength(1);

        // Set the RenderScheme
        lifeline2.setRenderScheme(RenderScheme.TopCoderScheme);

        // Set the Strock Color
        lifeline2.setStrokeColor(Color.BLACK);

        // Set the left endpoints
        leftending = lifeline2.getLeftEnding();
        leftending.setEndingPoint(new Point(300, 100));

        // Set the right endpoints
        rightending = lifeline2.getRightEnding();
        rightending.setEndingPoint(new Point(300, 300));

        AccuracyTestImagePrinter printer = new AccuracyTestImagePrinter("test_files/accuracy_tests/Life_line.jpg");
        Graphics g = printer.initImage();
        lifeline.paintComponent(g);
        lifeline2.paintComponent(g);
        printer.print();
    }

    /**
     * Tests contains method for accuracy.
     *
     */
    public void testContains() {

        lifeline.setActiveWidth(50);
        boolean result = lifeline.contains(new Point(10, 10));
        assertTrue("the contains method fail to work correctly.", result);

        result = lifeline.contains(new Point(70, 10));
        assertTrue("the contains method fail to work correctly.", !result);
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
            lifeline.consumeEvent(null);
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

        // Create a Lifeline
        GraphEdge graphedge = TestUtil.createGraphEdge();
        EnumMap<LifelinePropertyType, String> properties = TestUtil.createLifelineWithSomeProperties();

        lifeline = new Lifeline(graphedge, properties);

        // Create a DiagramViewer
        DiagramViewer viewer = TestUtil.createDV();
        viewer.setNewElementType(LifelineSegment.class);
        viewer.setState(DiagramState.ADD_ELEMENT_BY_CLICK);

        // Add the Popup
        JPopupMenu popup = new JPopupMenu();
        popup.add("test");
        viewer.add(lifeline);
        MouseEvent event = new MouseEvent(lifeline, MouseEvent.MOUSE_CLICKED, 0, 0, 0, 0, 1, false, MouseEvent.BUTTON3);

        // test without popup
        boolean consumed = lifeline.consumeEvent(event);
        assertTrue("the consumeEvent failed to work correctly.", consumed);

        // test with popup
        lifeline.setPopup(popup);
        consumed = lifeline.consumeEvent(event);
        popup.setVisible(false);
        lifeline.remove(popup);
        assertTrue("the consumeEvent failed to work correctly.", consumed);

        // not right click event
        event = new MouseEvent(lifeline, MouseEvent.MOUSE_CLICKED, 0, 0, 0, 0, 2, false, MouseEvent.BUTTON1);
        consumed = lifeline.consumeEvent(event);
        assertTrue("the consumeEvent failed to work correctly.", !consumed);

        // DiagramViewer not in the adding state
        viewer.setState(DiagramState.SELECT_ELEMENT);
        event = new MouseEvent(lifeline, MouseEvent.MOUSE_CLICKED, 0, 0, 0, 0, 1, false, MouseEvent.BUTTON3);
        consumed = lifeline.consumeEvent(event);
        assertTrue("the consumeEvent failed to work correctly.", !consumed);

        // no container
        viewer.remove(lifeline);
        event = new MouseEvent(lifeline, MouseEvent.MOUSE_CLICKED, 0, 0, 0, 0, 1, false, MouseEvent.BUTTON3);
        consumed = lifeline.consumeEvent(event);
        assertTrue("the consumeEvent failed to work correctly.", !consumed);
    }

    /**
     * <p>
     * The entry of the demo program.
     * </p>
     *
     * @param args the arguments
     */
    public static void main(String[] args) {
        GraphEdge graphedge = TestUtil.createGraphEdge();
        EnumMap<LifelinePropertyType, String> properties = TestUtil.createLifelineWithSomeProperties();

        Lifeline lifeline = new Lifeline(graphedge, properties);

        // Set the ShadowColor and ShadowLength
        lifeline.setShadowColor(Color.GRAY);
        lifeline.setShadowLength(1);

        // Set the left endpoints
        EdgeEnding leftending = lifeline.getLeftEnding();
        leftending.setEndingPoint(new Point(100, 100));

        // Set the right endpoints
        EdgeEnding rightending = lifeline.getRightEnding();
        rightending.setEndingPoint(new Point(100, 300));

        // Add a popup,when right click on the lifeline, popup will be shown.
        JPopupMenu popup = new JPopupMenu();
        popup.add("test");
        lifeline.setPopup(popup);

        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().add(lifeline);
        frame.setSize(new Dimension(500, 500));
        frame.setVisible(true);

    }

}
