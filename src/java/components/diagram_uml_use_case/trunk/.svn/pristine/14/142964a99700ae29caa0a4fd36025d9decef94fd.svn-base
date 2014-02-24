/*
 * Copyright (C) 2007 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.gui.diagramviewer.uml.usecaseelements;

import java.awt.Color;
import java.awt.Rectangle;
import java.util.HashMap;
import java.util.Map;

import junit.framework.TestCase;

import com.topcoder.diagraminterchange.GraphNode;
import com.topcoder.gui.diagramviewer.edges.Connector;
import com.topcoder.gui.diagramviewer.edges.connectors.RectangleConnector;
import com.topcoder.gui.diagramviewer.uml.usecaseelements.event.BoundaryChangedEvent;
import com.topcoder.gui.diagramviewer.uml.usecaseelements.event.BoundaryChangedListener;
import com.topcoder.gui.diagramviewer.uml.usecaseelements.event.MockBoundaryChangedListener;

/**
 * <p>
 * Unit test cases for BaseNode.
 * </p>
 *
 * @author TCSDEVELOPER
 * @version 1.0
 */
public class BaseNodeTests extends TestCase {
    /**
     * <p>
     * BaseNode instance for testing.
     * </p>
     */
    private BaseNode baseNode;

    /**
     * <p>
     * GraphNode instance used for testing.
     * </p>
     */
    private GraphNode graphNode;

    /**
     * <p>
     * Map instance used for testing.
     * </p>
     */
    private Map<String, String> properties;

    /**
     * <p>
     * TextField instance for testing.
     * </p>
     */
    private TextField name;

    /**
     * <p>
     * TextField instance for testing.
     * </p>
     */
    private TextField stereotype;

    /**
     * <p>
     * TextField instance for testing.
     * </p>
     */
    private TextField namespace;

    /**
     * <p>
     * Sets up test environment.
     * </p>
     */
    protected void setUp() {
        graphNode = new GraphNode();
        properties = new HashMap<String, String>();
        properties.put("StrokeColor", "StrokeColor");
        properties.put("FillColor", "FillColor");
        properties.put("FontColor", "FontColor");
        properties.put("FontSize", "FontSize");
        properties.put("FontFamily", "FontFamily");
        name = new TextField(new GraphNode());
        stereotype = new TextField(new GraphNode());
        namespace = new TextField(new GraphNode());
        baseNode = new MockBaseNode(graphNode, properties, name, stereotype, namespace);
    }

    /**
     * <p>
     * Tears down test environment.
     * </p>
     */
    protected void tearDown() {
        baseNode = null;
    }

    /**
     * <p>
     * Tests BaseNode#BaseNode(GraphNode, Map, TextField, TextField, TextField) for accuracy.
     * </p>
     * <p>
     * It verifies the newly created BaseNode is not null.
     * </p>
     */
    public void testCtor() {
        assertNotNull("Failed to create a BaseNode instance.", baseNode);
    }

    /**
     * <p>
     * Tests BaseNode#BaseNode(GraphNode, Map, TextField, TextField, TextField) for failure.
     * </p>
     * <p>
     * It tests the case that when graphNode is null and expects IllegalArgumentException.
     * </p>
     */
    public void testCtor_NullGraphNode() {
        try {
            new MockBaseNode(null, new HashMap<String, String>(), name, stereotype, namespace);
            fail("IllegalArgumentException expected.");
        } catch (IllegalArgumentException iae) {
            // the expected case
        }
    }

    /**
     * <p>
     * Tests BaseNode#BaseNode(GraphNode, Map, TextField, TextField, TextField) for failure.
     * </p>
     * <p>
     * It tests the case that when Map is null and expects IllegalArgumentException.
     * </p>
     */
    public void testCtor_NullProperteies() {
        try {
            new MockBaseNode(new GraphNode(), null, name, stereotype, namespace);
            fail("IllegalArgumentException expected.");
        } catch (IllegalArgumentException iae) {
            // the expected case
        }
    }

    /**
     * <p>
     * Tests BaseNode#BaseNode(GraphNode, Map, TextField, TextField, TextField) for failure.
     * </p>
     * <p>
     * It tests the case that when Map contains null value and expects IllegalArgumentException.
     * </p>
     */
    public void testCtor_ProperteiesContainsNull() {
        Map<String, String> prop = new HashMap<String, String>();
        prop.put(null, null);
        try {
            new MockBaseNode(new GraphNode(), prop, name, stereotype, namespace);
            fail("IllegalArgumentException expected.");
        } catch (IllegalArgumentException iae) {
            // the expected case
        }
    }

    /**
     * <p>
     * Tests BaseNode#BaseNode(GraphNode, Map, TextField, TextField, TextField) for failure.
     * </p>
     * <p>
     * It tests the case that when Map contains empty string and expects IllegalArgumentException.
     * </p>
     */
    public void testCtor_ProperteiesContainsEmpty() {
        Map<String, String> prop = new HashMap<String, String>();
        prop.put(" ", "");
        try {
            new MockBaseNode(new GraphNode(), prop, name, stereotype, namespace);
            fail("IllegalArgumentException expected.");
        } catch (IllegalArgumentException iae) {
            // the expected case
        }
    }

    /**
     * <p>
     * Tests BaseNode#BaseNode(GraphNode, Map, TextField, TextField, TextField) for failure.
     * </p>
     * <p>
     * It tests the case that when name is null and expects IllegalArgumentException.
     * </p>
     */
    public void testCtor_NullName() {
        try {
            new MockBaseNode(new GraphNode(), new HashMap<String, String>(), null, stereotype, namespace);
            fail("IllegalArgumentException expected.");
        } catch (IllegalArgumentException iae) {
            // the expected case
        }
    }

    /**
     * <p>
     * Tests BaseNode#BaseNode(GraphNode, Map, TextField, TextField, TextField) for failure.
     * </p>
     * <p>
     * It tests the case that when stereotype is null and expects IllegalArgumentException.
     * </p>
     */
    public void testCtor_NullStereotype() {
        try {
            new MockBaseNode(new GraphNode(), new HashMap<String, String>(), name, null, namespace);
            fail("IllegalArgumentException expected.");
        } catch (IllegalArgumentException iae) {
            // the expected case
        }
    }

    /**
     * <p>
     * Tests BaseNode#BaseNode(GraphNode, Map, TextField, TextField, TextField) for failure.
     * </p>
     * <p>
     * It tests the case that when namespace is null and expects IllegalArgumentException.
     * </p>
     */
    public void testCtor_NullNamespace() {
        try {
            new MockBaseNode(new GraphNode(), new HashMap<String, String>(), name, stereotype, null);
            fail("IllegalArgumentException expected.");
        } catch (IllegalArgumentException iae) {
            // the expected case
        }
    }

    /**
     * <p>
     * Tests {@link BaseNode#getStrokeColor()} for accuracy.
     * </p>
     * <p>
     * It verifies the default color will use, when the passed graphNode contains no color information.
     * </p>
     */
    public void testGetStrokeColor() {
        assertEquals("Failed to get the color correctly.", Color.BLACK, baseNode.getStrokeColor());
    }

    /**
     * <p>
     * Tests {@link BaseNode#getFillColor()} for accuracy.
     * </p>
     * <p>
     * It verifies the default color will use, when the passed graphNode contains no color information.
     * </p>
     */
    public void testGetFillColor() {
        assertEquals("Failed to get the color correctly.", Color.BLACK, baseNode.getFillColor());
    }

    /**
     * <p>
     * Tests {@link BaseNode#getFontColor()} for accuracy.
     * </p>
     * <p>
     * It verifies the default color will use, when the passed graphNode contains no color information.
     * </p>
     */
    public void testGetFontColor() {
        assertEquals("Failed to get the color correctly.", Color.BLACK, baseNode.getFontColor());
    }

    /**
     * <p>
     * Tests {@link BaseNode#getFont()} for accuracy.
     * </p>
     * <p>
     * It verifies the default font size will use, when the passed graphNode doesn't contain such information.
     * </p>
     */
    public void testGetFontSize() {
        assertEquals("Failed to get the font size correctly.", 10, baseNode.getFont().getSize());
    }

    /**
     * <p>
     * Tests {@link BaseNode#getFont()} for accuracy.
     * </p>
     * <p>
     * It verifies the default font family will use, when the passed graphNode doesn't contain such information.
     * </p>
     */
    public void testGetFontFamily() {
        assertEquals("Failed to get the font size correctly.", "Arial", baseNode.getFont().getFamily());
    }

    /**
     * <p>
     * Tests {@link BaseNode#getStrokeColor()} for accuracy.
     * </p>
     * <p>
     * It verifies the color properly retrieved from the passed graphNode.
     * </p>
     */
    public void testGetStrokeColor_FromGraphNode() {
        baseNode = new MockBaseNode(TestHelper.createGraphNode(), properties, name, stereotype, namespace);
        assertEquals("Failed to get the color correctly.", Color.GREEN, baseNode.getStrokeColor());
    }

    /**
     * <p>
     * Tests {@link BaseNode#getFillColor()} for accuracy.
     * </p>
     * <p>
     * It verifies the color properly retrieved from the passed graphNode.
     * </p>
     */
    public void testGetFillColor_FromGraphNode() {
        baseNode = new MockBaseNode(TestHelper.createGraphNode(), properties, name, stereotype, namespace);
        assertEquals("Failed to get the color correctly.", new Color(85, 85, 85), baseNode.getFillColor());
    }

    /**
     * <p>
     * Tests {@link BaseNode#getFontColor()} for accuracy.
     * </p>
     * <p>
     * It verifies the color properly retrieved from the passed graphNode.
     * </p>
     */
    public void testGetFontColor_FromGraphNode() {
        baseNode = new MockBaseNode(TestHelper.createGraphNode(), properties, name, stereotype, namespace);
        assertEquals("Failed to get the color correctly.", Color.RED, baseNode.getFontColor());
    }

    /**
     * <p>
     * Tests {@link BaseNode#getFont()} for accuracy.
     * </p>
     * <p>
     * It verifies the font size properly retrieved from the passed graphNode.
     * </p>
     */
    public void testGetFontSize_FromGraphNode() {
        baseNode = new MockBaseNode(TestHelper.createGraphNode(), properties, name, stereotype, namespace);
        assertEquals("Failed to get the font size correctly.", 12, baseNode.getFont().getSize());
    }

    /**
     * <p>
     * Tests {@link BaseNode#getFont()} for accuracy.
     * </p>
     * <p>
     * It verifies the font family properly retrieved from the passed graphNode.
     * </p>
     */
    public void testGetFontFamily_FromGraphNode() {
        baseNode = new MockBaseNode(TestHelper.createGraphNode(), properties, name, stereotype, namespace);
        assertEquals("Failed to get the font size correctly.", "Arial", baseNode.getFont().getFamily());
    }

    /**
     * <p>
     * Tests {@link BaseNode#getConnector()} for accuracy.
     * </p>
     * <p>
     * It verifies BaseNode#getConnector() is correct.
     * </p>
     */
    public void testGetConnector() {
        MockBaseNode node = new MockBaseNode(graphNode, properties, name, stereotype, namespace);
        Connector connector = new RectangleConnector(new Rectangle());
        node.setConnector(connector);
        assertSame("Failed to get the connector.", connector, node.getConnector());
    }

    /**
     * <p>
     * Tests {@link BaseNode#setConnector(Connector)} for accuracy.
     * </p>
     * <p>
     * It verifies BaseNode#setConnector(Connector) is correct.
     * </p>
     */
    public void testSetConnector() {
        MockBaseNode node = new MockBaseNode(graphNode, properties, name, stereotype, namespace);
        Connector connector = new RectangleConnector(new Rectangle());
        node.setConnector(connector);
        assertSame("Failed to set the connector.", connector, node.getConnector());
    }

    /**
     * <p>
     * Tests {@link BaseNode#setConnector(Connector)} for failure.
     * </p>
     * <p>
     * It tests the case that when connector is null and expects IllegalArgumentException.
     * </p>
     */
    public void testSetConnector_NullConnector() {
        try {
            MockBaseNode node = new MockBaseNode(graphNode, properties, name, stereotype, namespace);
            node.setConnector(null);
            fail("IllegalArgumentException expected.");
        } catch (IllegalArgumentException iae) {
            // the expected case
        }
    }

    /**
     * <p>
     * Tests {@link BaseNode#getNameCompartment()} for accuracy.
     * </p>
     * <p>
     * It verifies {@link BaseNode#getNameCompartment()} is correct.
     * </p>
     */
    public void testGetNameCompartment() {
        assertSame("Failed to get name compartment.", name, baseNode.getNameCompartment());
    }

    /**
     * <p>
     * Tests {@link BaseNode#getStereotypeCompartment()} for accuracy.
     * </p>
     * <p>
     * It verifies {@link BaseNode#getStereotypeCompartment()} is correct.
     * </p>
     */
    public void testGetStereotypeCompartment() {
        assertSame("Failed to get stereotype compartment.", stereotype, baseNode.getStereotypeCompartment());
    }

    /**
     * <p>
     * Tests {@link BaseNode#getNamespaceCompartment()} for accuracy.
     * </p>
     * <p>
     * It verifies {@link BaseNode#getNamespaceCompartment()} is correct.
     * </p>
     */
    public void testGetNamespaceCompartment() {
        assertEquals("Failed to get namespace compartment.", namespace, baseNode.getNamespaceCompartment());
    }

    /**
     * <p>
     * Tests {@link BaseNode#notifyPropertiesChange()} for accuracy.
     * </p>
     * <p>
     * It changes the properties in graphNode, notify the base node, and verifies it works correctly.
     * </p>
     */
    public void testNotifyPropertiesChange_FillColor() {
        graphNode.addProperty(TestHelper.createProperty("FillColor", "0000FF"));
        baseNode.notifyPropertiesChange();
        assertEquals("notifyPropertiesChange is fail.", new Color(0, 0, 255), baseNode.getFillColor());
    }

    /**
     * <p>
     * Tests {@link BaseNode#notifyPropertiesChange()} for accuracy.
     * </p>
     * <p>
     * It changes the properties in graphNode, notify the base node, and verifies it works correctly.
     * </p>
     */
    public void testNotifyPropertiesChange_StrokeColor() {
        graphNode.addProperty(TestHelper.createProperty("StrokeColor", "00FF00"));
        baseNode.notifyPropertiesChange();
        assertEquals("notifyPropertiesChange is fail.", new Color(0, 255, 0), baseNode.getStrokeColor());
    }

    /**
     * <p>
     * Tests {@link BaseNode#notifyPropertiesChange()} for accuracy.
     * </p>
     * <p>
     * It changes the properties in graphNode, and notify the base node, and verifies it works correctly.
     * </p>
     */
    public void testNotifyPropertiesChange_FontColor() {
        graphNode.addProperty(TestHelper.createProperty("FontColor", "FF0000"));
        baseNode.notifyPropertiesChange();
        assertEquals("notifyPropertiesChange is fail.", new Color(255, 0, 0), baseNode.getFontColor());
    }

    /**
     * <p>
     * Tests {@link BaseNode#notifyPropertiesChange()} for accuracy.
     * </p>
     * <p>
     * It changes the properties in graphNode, and notify the base node, and verifies it works correctly.
     * </p>
     */
    public void testNotifyPropertiesChange_FontSize() {
        graphNode.addProperty(TestHelper.createProperty("FontSize", "14"));
        baseNode.notifyPropertiesChange();
        assertEquals("notifyPropertiesChange is fail.", 14, baseNode.getFont().getSize());
    }

    /**
     * <p>
     * Tests {@link BaseNode#notifyPropertiesChange()} for accuracy.
     * </p>
     * <p>
     * It changes the properties in graphNode, and notify the base node, and verifies it works correctly.
     * </p>
     */
    public void testNotifyPropertiesChange_FontFamily() {
        graphNode.addProperty(TestHelper.createProperty("FontFamily", "Arial"));
        baseNode.notifyPropertiesChange();
        assertEquals("notifyPropertiesChange is fail.", "Arial", baseNode.getFont().getFamily());
    }

    /**
     * <p>
     * Tests BaseNode#consumeEvent(MouseEvent) for accuracy.
     * </p>
     * <p>
     * It verifies BaseNode#consumeEvent(MouseEvent) always return false;
     * </p>
     */
    public void testConsumeEvent() {
        assertFalse("consumeEvent behavior is wrong.", baseNode.consumeEvent(null));
    }

    /**
     * <p>
     * Tests BaseNode#addBoundaryChangeListener(BoundaryChangedListener) for accuracy.
     * </p>
     * <p>
     * It verifies BaseNode#addBoundaryChangeListener(BoundaryChangedListener) is correct.
     * </p>
     */
    public void testAddBoundaryChangeListener() {
        BoundaryChangedListener listener = new MockBoundaryChangedListener();
        baseNode.addBoundaryChangeListener(listener);

        assertEquals("Expected the length of listeners is one.", 1, baseNode
                .getListeners(BoundaryChangedListener.class).length);
        assertEquals("Failed to set the listener correctly.", listener, baseNode
                .getListeners(BoundaryChangedListener.class)[0]);
    }

    /**
     * <p>
     * Tests BaseNode#addBoundaryChangeListener(BoundaryChangedListener) for accuracy.
     * </p>
     * <p>
     * It tests the case that when listener is null and expects success.
     * </p>
     */
    public void testAddBoundaryChangedListener_NullListener() {
        baseNode.addBoundaryChangeListener(null);

        assertEquals("Failed to set the listener correctly.", 0,
                baseNode.getListeners(BoundaryChangedListener.class).length);
    }

    /**
     * <p>
     * Tests BaseNode#removeBoundaryChangeListener(BoundaryChangedListener) for accuracy.
     * </p>
     * <p>
     * It verifies BaseNode#removeBoundaryChangeListener(BoundaryChangedListener) is correct.
     * </p>
     */
    public void testRemoveBoundaryChangedListener() {
        BoundaryChangedListener listener = new MockBoundaryChangedListener();
        baseNode.addBoundaryChangeListener(listener);

        baseNode.removeBoundaryChangeListener(listener);

        assertEquals("Failed to remove the listener correctly.", 0, baseNode
                .getListeners(BoundaryChangedListener.class).length);
    }

    /**
     * <p>
     * Tests BaseNode#removeBoundaryChangeListener(BoundaryChangedListener) for accuracy.
     * </p>
     * <p>
     * It tests the case that when listener is null and expects success.
     * </p>
     */
    public void testRemoveBoundaryChangedListener_NullListener() {
        BoundaryChangedListener listener = new MockBoundaryChangedListener();
        baseNode.addBoundaryChangeListener(listener);

        baseNode.removeBoundaryChangeListener(null);

        assertEquals("Failed to remove the listener correctly.", 1, baseNode
                .getListeners(BoundaryChangedListener.class).length);
    }

    /**
     * <p>
     * Tests BaseNode#fireBoundaryChange(BoundaryChangedEvent) for accuracy.
     * </p>
     * <p>
     * It verifies BaseNode#fireBoundaryChange(BoundaryChangedEvent) is correct.
     * </p>
     */
    public void testFireBoundaryChange() {
        MockBoundaryChangedListener listener = new MockBoundaryChangedListener();
        BoundaryChangedEvent event = new BoundaryChangedEvent(baseNode, new Rectangle(), new Rectangle());

        baseNode.addBoundaryChangeListener(listener);

        baseNode.fireBoundaryChange(event);

        assertTrue("Failed to fire the listener correctly.", listener.getIsExecute());
        assertEquals("Failed to fire the listener correctly.", event, listener.getBoundaryChangedEvent());
    }

    /**
     * <p>
     * Tests BaseNode#fireBoundaryChange(BoundaryChangedEvent) for accuracy.
     * </p>
     * <p>
     * It tests the case that when listener is null and expects success.
     * </p>
     */
    public void testFireBoundaryChange_NullEvent() {
        MockBoundaryChangedListener listener = new MockBoundaryChangedListener();
        baseNode.addBoundaryChangeListener(listener);

        baseNode.fireBoundaryChange(null);

        assertFalse("Failed to fire the listener correctly.", listener.getIsExecute());
    }

    /**
     * <p>
     * Tests BaseNode#notifyNamespaceVisibilityChange() for accuracy.
     * </p>
     * <p>
     * It verifies BaseNode#notifyNamespaceVisibilityChange() is correct.
     * </p>
     *
     * @throws Exception the exception propagated in this method
     */
    public void testNotifyNamespaceVisibilityChange() throws Exception {
        baseNode.notifyNamespaceVisibilityChange();
        assertTrue("Failed to notify namespace visibility change", ((MockBaseNode) baseNode).getIsGraphNodeChanged());
    }

    /**
     * <p>
     * Tests BaseNode#notifyStereotypeVisibilityChange() for accuracy.
     * </p>
     * <p>
     * It verifies BaseNode#notifyStereotypeVisibilityChange() is correct.
     * </p>
     *
     * @throws Exception the exception propagated in this method
     */
    public void testNotifyStereotypeVisibilityChange() throws Exception {
        baseNode.notifyStereotypeVisibilityChange();
        assertTrue("Failed to notify stereotype visibility change", ((MockBaseNode) baseNode).getIsGraphNodeChanged());
    }
}
