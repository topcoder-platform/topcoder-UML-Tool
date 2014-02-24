/*
 * Copyright (C) 2007 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.gui.diagramviewer.uml.usecaseelements.accuracytests;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Rectangle;
import java.util.HashMap;
import java.util.Map;

import junit.framework.TestCase;

import com.topcoder.diagraminterchange.GraphNode;
import com.topcoder.diagraminterchange.Property;
import com.topcoder.gui.diagramviewer.uml.usecaseelements.BaseNode;
import com.topcoder.gui.diagramviewer.uml.usecaseelements.IllegalGraphElementException;
import com.topcoder.gui.diagramviewer.uml.usecaseelements.TextField;
import com.topcoder.gui.diagramviewer.uml.usecaseelements.event.BoundaryChangedEvent;
import com.topcoder.gui.diagramviewer.uml.usecaseelements.event.BoundaryChangedListener;
import com.topcoder.gui.diagramviewer.uml.usecaseelements.event.MockBoundaryChangedListener;

/**
 * Test cases for BaseNode.
 * 
 * @author radium
 * @version 1.0
 */
public class BaseNodeAccuracyTest extends TestCase {
    /**
     * MockClass for BaseNode.
     * 
     * @author radium
     * @version 1.0
     */
    @SuppressWarnings("serial")
    private class MockBaseNode extends BaseNode {

        protected MockBaseNode(GraphNode graphNode, Map<String, String> properties,
            com.topcoder.gui.diagramviewer.uml.usecaseelements.TextField name,
            com.topcoder.gui.diagramviewer.uml.usecaseelements.TextField stereotype,
            com.topcoder.gui.diagramviewer.uml.usecaseelements.TextField namespace) {
            super(graphNode, properties, name, stereotype, namespace);
            // TODO Auto-generated constructor stub
        }

        @Override
        public void notifyGraphNodeChange(String message) throws IllegalGraphElementException {
            // TODO Auto-generated method stub

        }

        @Override
        public Dimension getPreferredGraphNodeSize() {
            // TODO Auto-generated method stub
            return null;
        }

        public void fireBoundaryChange(BoundaryChangedEvent event) {
            super.fireBoundaryChange(event);
        }

    }

    /**
     * <p>
     * BaseNode instance for testing.
     * </p>
     */
    private MockBaseNode baseNode;

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
     * Set up test environment.
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

        graphNode.addProperty(this.createProperty("StrokeColor", "000000"));
        graphNode.addProperty(this.createProperty("FillColor", "001000"));
        graphNode.addProperty(this.createProperty("FontColor", "002000"));

        baseNode = new MockBaseNode(graphNode, properties, name, stereotype, namespace);

    }

    /**
     * Create the property for graphNode.
     * 
     * @param key
     *            the key
     * @param value
     *            the value
     * @return the property.
     */
    private Property createProperty(String key, String value) {
        Property res = new Property();
        res.setKey(key);
        res.setValue(value);
        return res;
    }

    /**
     * Test method for BaseNode.getStrokeColor().
     */
    public void testGetStrokeColor() {
        assertEquals("Should be equal.", new Color(0, 0, 0), baseNode.getStrokeColor());
    }

    /**
     * Test method for BaseNode.getFillColor().
     */
    public void testGetFillColor() {
        assertEquals("Should be equal.", new Color(0, 16, 0), baseNode.getFillColor());
    }

    /**
     * Test method for BaseNode.getFontColor().
     */
    public void testGetFontColor() {
        assertEquals("Should be equal.", new Color(0, 32, 0), baseNode.getFontColor());
    }

    /**
     * Test method for getNameCompartment().
     */
    public void testGetNameCompartment() {
        assertEquals("Should be equal.", this.name, baseNode.getNameCompartment());
    }

    /**
     * Test method for getStereotypeCompartment().
     */
    public void testGetStereotypeCompartment() {
        assertEquals("Should be equal.", this.stereotype, baseNode.getStereotypeCompartment());
    }

    /**
     * Test method for getNamespaceCompartment().
     */
    public void testGetNamespaceCompartment() {
        assertEquals("Should be equal.", this.namespace, baseNode.getNamespaceCompartment());
    }

    /**
     * Test method for notifyPropertiesChange().
     */
    public void testNotifyPropertiesChange() {
        graphNode = new GraphNode();
        baseNode = new MockBaseNode(graphNode, properties, name, stereotype, namespace);
        graphNode.addProperty(this.createProperty("StrokeColor", "001000"));
        graphNode.addProperty(this.createProperty("FillColor", "002000"));
        graphNode.addProperty(this.createProperty("FontColor", "003000"));

        baseNode.notifyPropertiesChange();
        // The color should be reset after notifyPropertiesChange().
        assertEquals("Should be equal.", new Color(0, 16, 0), baseNode.getStrokeColor());
        assertEquals("Should be equal.", new Color(0, 32, 0), baseNode.getFillColor());
        assertEquals("Should be equal.", new Color(0, 48, 0), baseNode.getFontColor());
    }

    /**
     * Test method for addBoundaryChangeListener(BoundaryChangedListener).
     */
    public void testAddBoundaryChangeListener() {
        for (int i = 0; i < 3; i++) {
            baseNode.addBoundaryChangeListener(new MockBoundaryChangedListener());
        }
        assertEquals("Should be equal.", 3, baseNode.getListeners(BoundaryChangedListener.class).length);
    }

    /**
     * Test method for removeBoundaryChangeListener(BoundaryChangedListener).
     */
    public void testRemoveBoundaryChangeListener() {
        for (int i = 0; i < 3; i++) {
            BoundaryChangedListener bcl = new MockBoundaryChangedListener();
            baseNode.addBoundaryChangeListener(bcl);
            baseNode.removeBoundaryChangeListener(bcl);
        }
        assertEquals("Should be equal.", 0, baseNode.getListeners(BoundaryChangedListener.class).length);
    }

    /**
     * Test method for fireBoundaryChangeEvent.
     */
    public void testFireBoundaryChangeEvent() {
        MockBoundaryChangeListenerAccuracy bcl = new MockBoundaryChangeListenerAccuracy();
        baseNode.addBoundaryChangeListener(bcl);
        baseNode.fireBoundaryChange(new BoundaryChangedEvent(baseNode, new Rectangle(), new Rectangle()));
        assertTrue("Should be true.", bcl.getIsExecute());
    }
}
