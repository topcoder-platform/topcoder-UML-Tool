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

import javax.swing.JPopupMenu;

import junit.framework.TestCase;

import com.topcoder.diagraminterchange.GraphConnector;
import com.topcoder.diagraminterchange.GraphNode;
import com.topcoder.gui.diagramviewer.elements.SelectionCornerType;
import com.topcoder.gui.diagramviewer.uml.sequenceelements.ObjectNode;
import com.topcoder.gui.diagramviewer.uml.sequenceelements.ObjectNodePropertyType;
import com.topcoder.gui.diagramviewer.uml.sequenceelements.accuracytests.AccuracyTestHelper;
import com.topcoder.gui.diagramviewer.uml.sequenceelements.accuracytests.AccuracyTestImagePrinter;
import com.topcoder.uml.model.commonbehavior.instances.Object;
import com.topcoder.uml.model.commonbehavior.instances.ObjectImpl;

/**
 * This class aggregates accuracy tests for ObjectNode class.
 *
 * @author ch_music
 * @version 1.0
 */
public class ObjectNodeAccuracyTests extends TestCase {

    /**
     * <p>
     * The ObjectNode instance.
     * </p>
     */
    private ObjectNode test;

    /**
     * <p>
     * The Object instance.
     * </p>
     */
    private Object object;

    /**
     * <p>
     * The GraphConnector instance.
     * </p>
     */
    private GraphConnector graphConnector;

    /**
     * <p>
     * The GraphNode instance.
     * </p>
     */
    private GraphNode graphNode;

    /**
     * <p>
     * The Point instance.
     * </p>
     */
    private Point position;

    /**
     * <p>
     * The Rectangle instance.
     * </p>
     */
    private Rectangle bound;

    /**
     * <p>
     * The corners collection.
     * </p>
     */
    private Collection<SelectionCornerType> corners;

    /**
     * <p>
     * The property name map.
     * </p>
     */
    private EnumMap<ObjectNodePropertyType, String> propertyNameMapping;

    /**
     * <p>
     * Sets up testing environment.
     * </p>
     *
     * @throws Exception to JUnit
     */
    protected void setUp() throws Exception {
        AccuracyTestHelper.loadConfig("com.topcoder.gui.diagramviewer.uml.sequenceelements.objectnode",
                AccuracyTestHelper.CONFIGPATH);

        object = new ObjectImpl();
        object.setName("object");
        graphConnector = new GraphConnector();
        graphNode = new GraphNode();

        com.topcoder.diagraminterchange.Point pos = new com.topcoder.diagraminterchange.Point();
        pos.setX(100);
        pos.setY(100);
        graphNode.setPosition(pos);
        com.topcoder.diagraminterchange.Dimension size = new com.topcoder.diagraminterchange.Dimension();
        size.setWidth(100);
        size.setHeight(50);
        graphNode.setSize(size);

        position = new Point(100, 100);
        bound = new Rectangle();
        corners = AccuracyTestHelper.createSelectionCorner();
        propertyNameMapping = new EnumMap<ObjectNodePropertyType, String>(ObjectNodePropertyType.class);
        propertyNameMapping.put(ObjectNodePropertyType.FILL_COLOR, "blue");

        test = new ObjectNode(object, graphConnector, graphNode, position, bound, corners, propertyNameMapping);
    }

    /**
     * <p>
     * Tears down testing environment.
     * </p>
     *
     * @throws Exception to JUnit
     */
    protected void tearDown() throws Exception {
        AccuracyTestHelper.tearConfig();
    }

    /**
     * Tests constructor for accuracy.
     */
    public void testObjectNode() {
        assertNotNull("Constructor fails to create instance.", test);

        assertEquals("Failed to load the stroke color.", Color.BLACK, test.getStrokeColor());
        assertEquals("Failed to load the fill color.", Color.WHITE, test.getFillColor());
        assertEquals("Failed to load the fill color 2.", Color.YELLOW, test.getFillColor2());
        assertEquals("Failed to load the shadow color.", Color.GRAY, test.getShadowColor());
        assertEquals("Failed to load the font color.", Color.BLACK, test.getFontColor());
        assertEquals("Failed to load the font family", "Times", test.getFontFamily());
        assertEquals("Failed to load the font size", 15, test.getFontSize());
        assertEquals("Failed to load the font style", Font.PLAIN, test.getFontStyle());
        assertEquals("Failed to load the shadow length", 10, test.getShadowLength());
        assertEquals("Failed to load the rounding radius", 15, test.getRoundingRadius());
        assertEquals("Failed to load the render scheme", RenderScheme.TopCoderScheme, test.getRenderScheme());
    }

    /**
     * Tests setName method for accuracy.
     */
    public void testSetName() {
        test.setName("test_name");
        assertEquals("setName fails to set correctly.", "test_name", test.getName());
    }

    /**
     * Tests getName method for accuracy.
     */
    public void testGetName() {
        test.setName("test_name");
        assertEquals("getName fails to return correct value.", "test_name", test.getName());
    }

    /**
     * Tests getObject method for accuracy.
     */
    public void testGetObject() {
        assertEquals("getObject returns wrong instance.", object, test.getObject());
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
     * Tests getGraphConnector method for accuracy.
     */
    public void testGetGraphConnector() {
        assertEquals("getGraphConnector returns wrong instance.", graphConnector, test.getGraphConnector());
    }

    /**
     * Tests setSize method for accuracy.
     */
    public void testSetSize() {
        test.setSize(new Dimension(20, 10));
        assertEquals("setSize fails to set size correctly.", 20, (int) test.getSize().getWidth());
        assertEquals("setSize fails to set size correctly.", 10, (int) test.getSize().getHeight());
    }

    /**
     * Tests getSize method for accuracy.
     */
    public void testGetSize() {
        test.setSize(new Dimension(20, 10));
        assertEquals("getSize fails to return correct value.", 20, (int) test.getSize().getWidth());
        assertEquals("getSize fails to return correct value.", 10, (int) test.getSize().getHeight());
    }

    /**
     * Tests setPosition method for accuracy.
     */
    public void testSetPosition() {
        test.setPosition(position);
        assertEquals("setPosition fails to set to correct value.", position, test.getPosition());
    }

    /**
     * Tests getPosition method for accuracy.
     */
    public void testGetPosition() {
        test.setPosition(position);
        assertEquals("getPosition fails to return correct value.", position, test.getPosition());
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
     * Tests setRoundingRadius method for accuracy.
     */
    public void testSetRoundingRadius() {
        test.setRoundingRadius(2);
        assertEquals("setRoundingRadius fails to set correctly.", 2, test.getRoundingRadius());
    }

    /**
     * Tests getRoundingRadius method for accuracy.
     */
    public void testGetRoundingRadius() {
        test.setRoundingRadius(2);
        assertEquals("getRoundingRadius fails to return correct value.", 2, test.getRoundingRadius());
    }

    /**
     * Tests setShadowLength method for accuracy.
     */
    public void testSetShadowLength() {
        test.setShadowLength(3);
        assertEquals("setShadowLength fails to set correctly.", 3, test.getShadowLength());
    }

    /**
     * Tests getShadowLength method for accuracy.
     */
    public void testGetShadowLength() {
        test.setShadowLength(3);
        assertEquals("getShadowLength fails to return correct value.", 3, test.getShadowLength());
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
     * Tests addEditNameListener for accuracy.
     */
    public void testAddEditNameListener() {
        MockListener l = new MockListener();
        test.addEditNameListener(l);
        test.fireEditName(new EditNameEvent(new Point(1, 0), "name", AccuracyTestHelper.createObjectNode()));
        assertTrue("addEditNameListener fails to add.", l.wasExecuted());
    }

    /**
     * Tests addSetNameListener for accuracy.
     */
    public void testAddSetNameListener() {
        MockListener l = new MockListener();
        test.addSetNameListener(l);
        test.fireSetName(new SetNameEvent("old", "new", AccuracyTestHelper.createObjectNode()));
        assertTrue("addSetNameListener fails to add.", l.wasExecuted());
    }

    /**
     * Tests addResizeListener for accuracy.
     */
    public void testAddResizeListener() {
        MockListener l = new MockListener();
        test.addResizeListener(l);
        test.fireResize(new ResizeEvent(AccuracyTestHelper.createObjectNode(), "reason"));
        assertTrue("addResizeListener fails to add.", l.wasExecuted());
    }

    /**
     * Tests fireEditNameListener for accuracy.
     */
    public void testFireEditNameListener() {
        MockListener l = new MockListener();
        test.addEditNameListener(l);
        test.fireEditName(new EditNameEvent(new Point(1, 0), "name", AccuracyTestHelper.createObjectNode()));
        assertTrue("fireEditNameListener fails to fire listeners.", l.wasExecuted());
    }

    /**
     * Tests fireSetNameListener for accuracy.
     */
    public void testFireSetNameListener() {
        MockListener l = new MockListener();
        test.addSetNameListener(l);
        test.fireSetName(new SetNameEvent("old", "new", AccuracyTestHelper.createObjectNode()));
        assertTrue("fireSetNameListener fails to fire listeners.", l.wasExecuted());
    }

    /**
     * Tests fireResizeListener for accuracy.
     */
    public void testFireResizeListener() {
        MockListener l = new MockListener();
        test.addResizeListener(l);
        test.fireResize(new ResizeEvent(AccuracyTestHelper.createObjectNode(), "reason"));
        assertTrue("fireResizeListener fails to fire listeners.", l.wasExecuted());
    }

    /**
     * Tests removeEditNameListener for accuracy.
     */
    public void testRemoveEditNameListener() {
        MockListener l = new MockListener();
        test.addEditNameListener(l);
        test.removeEditNameListener(l);
        test.fireEditName(new EditNameEvent(new Point(1, 0), "name", AccuracyTestHelper.createObjectNode()));
        assertFalse("removeEditNameListener fails to remove.", l.wasExecuted());
    }

    /**
     * Tests removeSetNameListener for accuracy.
     */
    public void testRemoveSetNameListener() {
        MockListener l = new MockListener();
        test.addSetNameListener(l);
        test.removeSetNameListener(l);
        test.fireSetName(new SetNameEvent("old", "new", AccuracyTestHelper.createObjectNode()));
        assertFalse("removeSetNameListener fails to remove.", l.wasExecuted());
    }

    /**
     * Tests removeResizeListener for accuracy.
     */
    public void testRemoveResizeListener() {
        MockListener l = new MockListener();
        test.addResizeListener(l);
        test.removeResizeListener(l);
        test.fireResize(new ResizeEvent(AccuracyTestHelper.createObjectNode(), "reason"));
        assertFalse("removeResizeListener fails to remove.", l.wasExecuted());
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

    public void testApplyNewName() {
        MockListener listener1 = new MockListener();
        MockListener listener2 = new MockListener();
        test.addSetNameListener(listener1);
        test.addResizeListener(listener2);
        test.applyNewName("old", "new");
        assertTrue("applyNewName fails to fire set name listener.", listener1.wasExecuted());
        assertTrue("applyNewName fails to fire resize listener.", listener2.wasExecuted());
    }

    /**
     * Tests paintGraphics method for accuracy.
     *
     * @throws Exception to JUnit
     */
    public void testPaintComponentGraphics() throws Exception {
        SelectionCornerType[] selectionCornerType = new SelectionCornerType[] {SelectionCornerType.NORTH,
                SelectionCornerType.NORTHWEST, SelectionCornerType.WEST, SelectionCornerType.SOUTHWEST,
                SelectionCornerType.SOUTH, SelectionCornerType.SOUTHEAST, SelectionCornerType.EAST,
                SelectionCornerType.NORTHEAST};
        GraphNode newGraphNode = new GraphNode();

        com.topcoder.diagraminterchange.Point pos = new com.topcoder.diagraminterchange.Point();
        pos.setX(100);
        pos.setY(100);
        newGraphNode.setPosition(pos);
        com.topcoder.diagraminterchange.Dimension size = new com.topcoder.diagraminterchange.Dimension();
        size.setWidth(100);
        size.setHeight(50);
        newGraphNode.setSize(size);

        test = new ObjectNode(new ObjectImpl(), new GraphConnector(), newGraphNode, new Point(100, 100),
                new Rectangle(100, 100, 200, 100), Arrays.asList(selectionCornerType), AccuracyTestHelper
                        .createObjectNodeProperties());
        test.setSize(new Dimension(200, 100));
        AccuracyTestImagePrinter printer = new AccuracyTestImagePrinter(
                "test_files/accuracy_tests/object_node.jpg");
        test.paintComponent(printer.initImage());
        printer.print();
    }

    /**
     * Tests setPropertyNameMappingElement method for accuracy.
     */
    public void testSetPropertyNameMappingElement() {
        test.setPropertyNameMappingElement(ObjectNodePropertyType.FILL_COLOR, "test");
        assertEquals("setPropertyNameMappingElement fails to set correctly.", "test", test
                .getPropertyNameMappingElement(ObjectNodePropertyType.FILL_COLOR));
    }

    /**
     * Tests getPropertyNameMappingElement method for accuracy.
     */
    public void testGetPropertyNameMappingElement() {
        test.setPropertyNameMappingElement(ObjectNodePropertyType.FILL_COLOR, "test");
        assertEquals("getPropertyNameMappingElement fails to return correct value.", "test", test
                .getPropertyNameMappingElement(ObjectNodePropertyType.FILL_COLOR));
    }

    /**
     * Mock implementation of EditNameListener, ResizeListener, and SetNameListener.
     *
     * @author ch_music
     * @version 1.0
     */
    public class MockListener implements EditNameListener, ResizeListener, SetNameListener {

        /**
         * Denotes whether the listener has been executed.
         */
        private boolean wasExecuted = false;

        /**
         * <p>
         * Constructs this listener with the given event.
         * </p>
         *
         * @param event The instance of the EditNameEvent class.
         */
        public void nameEditStarted(EditNameEvent event) {
            wasExecuted = true;
        }

        /**
         * <p>
         * Constructs this listener with the given event.
         * </p>
         *
         * @param event The instance of the ResizeEvent class.
         */
        public void resizeNeeded(ResizeEvent event) {
            wasExecuted = true;
        }

        /**
         * <p>
         * Constructs this listener with the given event.
         * </p>
         *
         * @param event The instance of the SetNameEvent class.
         */
        public void namePrepared(SetNameEvent event) {
            wasExecuted = true;
        }

        /**
         * <p>
         * Returns the state of the isExecute.
         * </p>
         *
         * @return the state of the isExecute.
         */
        public boolean wasExecuted() {
            return wasExecuted;
        }
    }
}
