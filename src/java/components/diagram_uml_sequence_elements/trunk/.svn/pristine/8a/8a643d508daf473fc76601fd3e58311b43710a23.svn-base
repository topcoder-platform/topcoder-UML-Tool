/*
 * Copyright (C) 2007 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.gui.diagramviewer.uml.sequenceelements;

import java.awt.Color;
import java.awt.Font;
import java.util.EnumMap;

import javax.swing.JPopupMenu;

import junit.framework.TestCase;

import com.topcoder.diagraminterchange.Diagram;
import com.topcoder.diagraminterchange.GraphEdge;
import com.topcoder.gui.diagramviewer.edges.EdgeEnding;
import com.topcoder.gui.diagramviewer.edges.LineStyle;
import com.topcoder.gui.diagramviewer.uml.sequenceelements.accuracytests.AccuracyTestHelper;
import com.topcoder.gui.diagramviewer.uml.sequenceelements.edgeendings.ConfiguredEdgeEndingPropertyType;
import com.topcoder.gui.diagramviewer.uml.sequenceelements.edgeendings.EmptyArrowEdgeEnding;
import com.topcoder.uml.model.commonbehavior.links.Link;
import com.topcoder.uml.model.commonbehavior.links.LinkImpl;

/**
 * This class aggregates accuracy tests for SequenceEdge class.
 *
 * @author ch_music
 * @version 1.0
 */
public class SequenceEdgeAccuracyTests extends TestCase {
    /**
     * <p>
     * The SequenceEdge instance for testing purposes.
     * </p>
     */
    private SequenceEdge test;

    /**
     * <p>
     * The Link instance.
     * </p>
     */
    private Link link;

    /**
     * The GraphEdge instance.
     */
    private GraphEdge graphEdge;

    /**
     * The LineStyle instance.
     */
    private LineStyle lineStyle;

    /**
     * The leftEnding instance.
     */
    private EdgeEnding leftEnding;

    /**
     * The rightEnding instance.
     */
    private EdgeEnding rightEnding;

    /**
     * The propertyNameMapping map.
     */
    private EnumMap<SequenceEdgePropertyType, String> propertyNameMapping;

    /**
     * Sets up testing environment.
     *
     * @throws Exception to JUnit
     */
    public void setUp() throws Exception {
        AccuracyTestHelper.loadConfig("com.topcoder.gui.diagramviewer.uml.sequenceelements.sequenceedge",
                AccuracyTestHelper.CONFIGPATH);

        link = new LinkImpl();

        graphEdge = AccuracyTestHelper.createGraphEdge();
        graphEdge.addWaypoint(AccuracyTestHelper.createDIPoint(100, 100));
        graphEdge.addWaypoint(AccuracyTestHelper.createDIPoint(200, 200));
        graphEdge.addWaypoint(AccuracyTestHelper.createDIPoint(300, 400));

        Diagram diagram = new Diagram();
        diagram.addContained(graphEdge);

        lineStyle = new LineStyle(1, 1);

        EnumMap<ConfiguredEdgeEndingPropertyType, String> mapping = new EnumMap<ConfiguredEdgeEndingPropertyType, String>(
                ConfiguredEdgeEndingPropertyType.class);
        mapping.put(ConfiguredEdgeEndingPropertyType.ARROW_X_LENGTH, "15");
        leftEnding = new EmptyArrowEdgeEnding(mapping);
        rightEnding = new EmptyArrowEdgeEnding(mapping);

        propertyNameMapping = new EnumMap<SequenceEdgePropertyType, String>(SequenceEdgePropertyType.class);
        propertyNameMapping.put(SequenceEdgePropertyType.FILL_COLOR, "red");

        test = new MockSequenceEdge(link, graphEdge, lineStyle, leftEnding, rightEnding, propertyNameMapping);
    }

    /**
     * Tears down test environment.
     *
     * @throws Exception to JUnit
     */
    protected void tearDown() throws Exception {
        AccuracyTestHelper.tearConfig();
    }

    /**
     * Tests constructor for accuracy.
     */
    public void testSequenceEdge() {
        assertNotNull("Constructor fails to create instance.", test);

        assertEquals("Fails to load from configuration.", Color.BLACK, test.getStrokeColor());
        assertEquals("Fails to load from configuration.", Color.YELLOW, test.getFillColor());
        assertEquals("Fails to load from configuration.", Color.BLUE, test.getFillColor2());
        assertEquals("Fails to load from configuration.", Color.GRAY, test.getShadowColor());
        assertEquals("Fails to load from configuration.", Color.LIGHT_GRAY, test.getFontColor());
        assertEquals("Fails to load from configuration.", Color.BLACK, test.getTextBoxStrokeColor());
        assertEquals("Fails to load from configuration.", Color.WHITE, test.getTextBoxFillColor());
        assertEquals("Fails to load from configuration.", Color.YELLOW, test.getTextBoxFillColor2());
        assertEquals("Fails to load from configuration.", "Times", test.getFontFamily());
        assertEquals("Fails to load from configuration.", Font.ITALIC, test.getFontStyle());
        assertEquals("Fails to load from configuration.", 8, test.getFontSize());
        assertEquals("Fails to load from configuration.", RenderScheme.TopCoderScheme, test.getRenderScheme());
        assertEquals("Fails to load from configuration.", 2, test.getDashLength());
        assertEquals("Fails to load from configuration.", 3, test.getBlankLength());
    }

    /**
     * Tests setName method for accuracy.
     */
    public void testSetName() {
        test.setName("test_name");
        assertEquals("setName fails to set name correctly.", "test_name", test.getName());
    }

    /**
     * Tests getName method for accuracy.
     */
    public void testGetName() {
        test.setName("test_name");
        assertEquals("getName fails to return name correctly.", "test_name", test.getName());
    }

    /**
     * Tests getLink method for accuracy.
     */
    public void testGetLink() {
        assertEquals("getLink fails to return correct instance.", link, test.getLink());
    }

    /**
     * Tests setIsStereotypesVisible method for accuracy.
     */
    public void testSetIsStereotypesVisible1() {
        test.setIsStereotypesVisible(true);
        assertTrue("setIsStereotypesVisible fails to set correctly.", test.getIsStereotypesVisible());
    }

    /**
     * Tests setIsStereotypesVisible method for accuracy.
     */
    public void testSetIsStereotypesVisible2() {
        test.setIsStereotypesVisible(false);
        assertFalse("setIsStereotypesVisible fails to set correctly.", test.getIsStereotypesVisible());
    }

    /**
     * Tests getIsStereotypesVisible method for accuracy.
     */
    public void testGetIsStereotypesVisible1() {
        test.setIsStereotypesVisible(true);
        assertTrue("getIsStereotypesVisible fails to return correct value.", test.getIsStereotypesVisible());
    }

    /**
     * Tests getIsStereotypesVisible method for accuracy.
     */
    public void testGetIsStereotypesVisible2() {
        test.setIsStereotypesVisible(false);
        assertFalse("getIsStereotypesVisible fails to return correct value.", test.getIsStereotypesVisible());
    }

    /**
     * Tests setIsNameVisible method for accuracy.
     */
    public void testSetIsNameVisible1() {
        test.setIsNameVisible(true);
        assertTrue("setIsNameVisible fails to set correctly.", test.getIsNameVisible());
    }

    /**
     * Tests setIsNameVisible method for accuracy.
     */
    public void testSetIsNameVisible2() {
        test.setIsNameVisible(false);
        assertFalse("setIsNameVisible fails to set correctly.", test.getIsNameVisible());
    }

    /**
     * Tests getIsNameVisible method for accuracy.
     */
    public void testGetIsNameVisible1() {
        test.setIsNameVisible(true);
        assertTrue("getIsNameVisible fails to return correct value.", test.getIsNameVisible());
    }

    /**
     * Tests getIsNameVisible method for accuracy.
     */
    public void testGetIsNameVisible2() {
        test.setIsNameVisible(false);
        assertFalse("getIsNameVisible fails to return correct value.", test.getIsNameVisible());
    }

    /**
     * Tests setStrokeColor method for accuracy.
     */
    public void testSetStrokeColor() {
        test.setStrokeColor(Color.YELLOW);
        assertEquals("setStrokeColor fails to set correctly.", Color.YELLOW, test.getStrokeColor());
    }

    /**
     * Tests getStrokeColor method for accuracy.
     */
    public void testGetStrokeColor() {
        test.setStrokeColor(Color.YELLOW);
        assertEquals("getStrokeColor fails to return correct value.", Color.YELLOW, test.getStrokeColor());
    }

    /**
     * Tests setFillColor method for accuracy.
     */
    public void testSetFillColor() {
        test.setFillColor(Color.YELLOW);
        assertEquals("setFillColor fails to set correctly.", Color.YELLOW, test.getFillColor());
    }

    /**
     * Tests getFillColor method for accuracy.
     */
    public void testGetFillColor() {
        test.setFillColor(Color.YELLOW);
        assertEquals("getFillColor fails to return correct value.", Color.YELLOW, test.getFillColor());
    }

    /**
     * Tests setFillColor2 method for accuracy.
     */
    public void testSetFillColor2() {
        test.setFillColor2(Color.YELLOW);
        assertEquals("setFillColor2 fails to set correctly.", Color.YELLOW, test.getFillColor2());
    }

    /**
     * Tests getFillColor2 method for accuracy.
     */
    public void testGetFillColor2() {
        test.setFillColor2(Color.YELLOW);
        assertEquals("getFillColor2 fails to return correct value.", Color.YELLOW, test.getFillColor2());
    }

    /**
     * Tests setShadowColor method for accuracy.
     */
    public void testSetShadowColor() {
        test.setShadowColor(Color.YELLOW);
        assertEquals("setShadowColor fails to set correctly.", Color.YELLOW, test.getShadowColor());
    }

    /**
     * Tests getShadowColor method for accuracy.
     */
    public void testGetShadowColor() {
        test.setShadowColor(Color.YELLOW);
        assertEquals("getShadowColor fails to return correct value.", Color.YELLOW, test.getShadowColor());
    }

    /**
     * Tests setFontColor method for accuracy.
     */
    public void testSetFontColor() {
        test.setFontColor(Color.YELLOW);
        assertEquals("setFontColor fails to set correctly.", Color.YELLOW, test.getFontColor());
    }

    /**
     * Tests getFontColor method for accuracy.
     */
    public void testGetFontColor() {
        test.setFontColor(Color.YELLOW);
        assertEquals("getFontColor fails to return correct value.", Color.YELLOW, test.getFontColor());
    }

    /**
     * Tests setTextBoxStrokeColor method for accuracy.
     */
    public void testSetTextBoxStrokeColor() {
        test.setTextBoxStrokeColor(Color.YELLOW);
        assertEquals("setTextBoxStrokeColor fails to set correctly.", Color.YELLOW, test.getTextBoxStrokeColor());
    }

    /**
     * Tests getTextBoxStrokeColor method for accuracy.
     */
    public void testGetTextBoxStrokeColor() {
        test.setTextBoxStrokeColor(Color.YELLOW);
        assertEquals("getTextBoxStrokeColor fails to return correct value.", Color.YELLOW, test.getTextBoxStrokeColor());
    }

    /**
     * Tests setTextBoxFillColor method for accuracy.
     */
    public void testSetTextBoxFillColor() {
        test.setTextBoxFillColor(Color.YELLOW);
        assertEquals("setTextBoxFillColor fails to set correctly.", Color.YELLOW, test.getTextBoxFillColor());
    }

    /**
     * Tests getTextBoxFillColor method for accuracy.
     */
    public void testGetTextBoxFillColor() {
        test.setTextBoxFillColor(Color.YELLOW);
        assertEquals("getTextBoxFillColor fails to return correct value.", Color.YELLOW, test.getTextBoxFillColor());
    }

    /**
     * Tests setTextBoxFillColor2 method for accuracy.
     */
    public void testSetTextBoxFillColor2() {
        test.setTextBoxFillColor2(Color.YELLOW);
        assertEquals("setTextBoxFillColor2 fails to set correctly.", Color.YELLOW, test.getTextBoxFillColor2());
    }

    /**
     * Tests getTextBoxFillColor2 method for accuracy.
     */
    public void testGetTextBoxFillColor2() {
        test.setTextBoxFillColor2(Color.YELLOW);
        assertEquals("getTextBoxFillColor2 fails to return correct value.", Color.YELLOW, test.getTextBoxFillColor2());
    }

    /**
     * Tests setFontFamily method for accuracy.
     */
    public void testSetFontFamily() {
        test.setFontFamily("family");
        assertEquals("setFontFamily fails to set correctly.", "family", test.getFontFamily());
    }

    /**
     * Tests getFontFamily method for accuracy.
     */
    public void testGetFontFamily() {
        test.setFontFamily("family");
        assertEquals("getFontFamily fails to return correct value.", "family", test.getFontFamily());
    }

    /**
     * Tests setFontStyle method for accuracy.
     */
    public void testSetFontStyle() {
        test.setFontStyle(Font.PLAIN);
        assertEquals("setFontStyle fails to set correctly.", Font.PLAIN, test.getFontStyle());
    }

    /**
     * Tests getFontStyle method for accuracy.
     */
    public void testGetFontStyle() {
        test.setFontStyle(Font.PLAIN);
        assertEquals("getFontStyle fails to return correct value.", Font.PLAIN, test.getFontStyle());
    }

    /**
     * Tests setFontSize method for accuracy.
     */
    public void testSetFontSize() {
        test.setFontSize(11);
        assertEquals("setFontSize sets to wrong value.", 11, test.getFontSize());
    }

    /**
     * Tests getFontSize method for accuracy.
     */
    public void testGetFontSize() {
        test.setFontSize(11);
        assertEquals("getFontSize fails to return correct value.", 11, test.getFontSize());
    }

    /**
     * Tests setFontSize method for accuracy.
     */
    public void testSetDashLength() {
        test.setFontSize(2);
        assertEquals("setFontSize sets to wrong value.", 2, test.getFontSize());
    }

    /**
     * Tests getDashLength method for accuracy.
     */
    public void testGetDashLength() {
        test.setDashLength(2);
        assertEquals("getDashLength fails to return correct value.", 2, test.getDashLength());
    }

    /**
     * Tests setBlankLength method for accuracy.
     */
    public void testSetBlankLength() {
        test.setBlankLength(2);
        assertEquals("setBlankLength sets to wrong value.", 2, test.getBlankLength());
    }

    /**
     * Tests getBlankLength method for accuracy.
     */
    public void testGetBlankLength() {
        test.setBlankLength(2);
        assertEquals("getBlankLength fails to return correct value.", 2, test.getBlankLength());
    }

    /**
     * Tests setRenderScheme method for accuracy.
     */
    public void testSetRenderScheme() {
        test.setRenderScheme(RenderScheme.TopCoderScheme);
        assertEquals("setRenderScheme fails to set correctly.", RenderScheme.TopCoderScheme, test
                .getRenderScheme());
    }

    /**
     * Tests getRenderScheme method for accuracy.
     */
    public void testGetRenderScheme() {
        test.setRenderScheme(RenderScheme.TopCoderScheme);
        assertEquals("getRenderScheme fails to return correct value.", RenderScheme.TopCoderScheme, test
                .getRenderScheme());
    }

    /**
     * Tests setPopup method for accuracy.
     */
    public void testSetPopup() {
        JPopupMenu popup = new JPopupMenu();
        test.setPopup(popup);
        assertSame("setPopup fails to set correctly.", popup, test.getPopup());
    }

    /**
     * Tests getPopup method for accuracy.
     */
    public void testGetPopup() {
        JPopupMenu popup = new JPopupMenu();
        test.setPopup(popup);
        assertSame("getPopup fails to return correctly.", popup, test.getPopup());
    }

    /**
     * Tests setPropertyNameMappingElement method for accuracy.
     */
    public void testSetPropertyNameMappingElement() {
        test.setPropertyNameMappingElement(SequenceEdgePropertyType.FILL_COLOR, "test");
        assertEquals("setPropertyNameMappingElement fails to set correctly.", "test", test
                .getPropertyNameMappingElement(SequenceEdgePropertyType.FILL_COLOR));
    }

    /**
     * Tests getPropertyNameMappingElement method for accuracy.
     */
    public void testGetPropertyNameMappingElement() {
        test.setPropertyNameMappingElement(SequenceEdgePropertyType.FILL_COLOR, "test");
        assertEquals("getPropertyNameMappingElement fails to return correct value.", "test", test
                .getPropertyNameMappingElement(SequenceEdgePropertyType.FILL_COLOR));
    }

    /**
     * <p>
     * Mock implementation of SequenceEdge abstract class.
     * </p>
     *
     * @author ch_music
     * @version 1.0
     */
    public class MockSequenceEdge extends SequenceEdge {

        /**
         * Creates a new instance.
         *
         * @param link the instance of the Link
         * @param graphEdge the instance of the GraphEdge class
         * @param lineStyle the instance of the LineStyle class representing the line to draw for the edge
         * @param leftEnding the instance of the EdgeEnding representing the left ending element for the edge
         * @param rightEnding the instance of the EdgeEnding representing the right ending element for the edge
         * @param propertyNameMapping The predefined Map with information about property names configuration. The
         *            properties are from DiagramElement parent class.
         * @throws IllegalArgumentException if any argument is null, or if propertyNameMapping is empty
         */
        public MockSequenceEdge(Link link, GraphEdge graphEdge, LineStyle lineStyle, EdgeEnding leftEnding,
                EdgeEnding rightEnding, EnumMap<SequenceEdgePropertyType, String> propertyNameMapping) {
            super(link, graphEdge, lineStyle, leftEnding, rightEnding, propertyNameMapping);
        }
    }
}
