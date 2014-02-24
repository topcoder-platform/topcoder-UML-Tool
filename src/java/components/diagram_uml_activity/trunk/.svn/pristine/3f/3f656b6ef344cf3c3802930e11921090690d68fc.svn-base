/*
 * Copyright (C) 2007 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.gui.diagramviewer.uml.activityelements.accuracytests;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Point;
import java.awt.Rectangle;
import java.util.Map;

import com.topcoder.diagraminterchange.GraphNode;
import com.topcoder.diagraminterchange.Property;
import com.topcoder.diagraminterchange.Uml1SemanticModelBridge;
import com.topcoder.gui.diagramviewer.uml.activityelements.BaseNode;
import com.topcoder.gui.diagramviewer.uml.activityelements.ObjectFlowNode;
import com.topcoder.gui.diagramviewer.uml.activityelements.RectangleConnector;
import com.topcoder.gui.diagramviewer.uml.activityelements.event.BoundaryChangedEvent;
import com.topcoder.gui.diagramviewer.uml.activityelements.event.BoundaryChangedListener;

/**
 * Accuracy tests for the class: BaseNode.
 * 
 * @author kinfkong
 * @version 1.0
 */
public class BaseNodeAccuracyTest extends AccuracyBase {

    /**
     * Represents the base node.
     */
    private BaseNode node;

    /**
     * Represents he graph node.
     */
    private GraphNode graphNode;

    /**
     * Represents the properties.
     */
    private Map<String, String> properties;

    /**
     * Sets up the test environment.
     */
    protected void setUp() {
        graphNode = createGraphNode(
            "ObjectFlowNode", 
            new Point(100, 100), 
            new Dimension(100, 150), 
            "00FF00");
        
        properties = createProperties();

        node = new ObjectFlowNode(
            graphNode, 
            properties, 
            new Point(5, 5), 
            new Rectangle(5, 5, 75, 75));
    }

    /**
     * Tests the method: addBoundaryChangeListener(BoundaryChangedListener listener).
     *
     */
    public void testAddBoundaryChangedListener() {

        BoundaryChangedListener listener = new DummyBoundaryChangedListener();

        // add the listener
        node.addBoundaryChangedListener(listener);
        
        // get the listener
        BoundaryChangedListener[] listeners = node.getListeners(
            BoundaryChangedListener.class);

        assertTrue("The method does not work properly",
                        containsListener(listeners, DummyBoundaryChangedListener.class));
    }

    /**
     * Tests method: removeBoundaryChangeListener(BoundaryChangedListener listener).
     */
    public void testRemoveBoundaryChangedListener() {

        // create the listener
        BoundaryChangedListener listener = new DummyBoundaryChangedListener();

        // add BoundaryChangedListener
        node.addBoundaryChangedListener(listener);
        
        // remove it
        node.removeBoundaryChangedListener(listener);

        BoundaryChangedListener[] listeners = node.getListeners(BoundaryChangedListener.class);

        assertFalse("The method does not work properly.",
                        containsListener(listeners, DummyBoundaryChangedListener.class));
    }

    /**
     * Tests the method: fireBoundaryChanged.
     * 
     */
    public void testFireBoundaryChanged() {

        // the original rec
        Rectangle rec = new Rectangle(1, 2, 3, 4);

        BoundaryChangedListener listener = new DummyBoundaryChangedListener();
        node.addBoundaryChangedListener(listener);

        BoundaryChangedEvent testEvent = new BoundaryChangedEvent(
            node, "", rec, new Rectangle(4, 3, 2, 1));

        node.fireBoundaryChanged(testEvent);

        assertTrue("The method does not work properly.", ((DummyBoundaryChangedListener) 
            listener).getOldBoundary().equals(rec));
    }

    /**
     * Tests the method: getConnector.
     */
    public void testGetConnector() {
        assertTrue("The method does not work properly.", node.getConnector() instanceof RectangleConnector);
    }

    /**
     * Tests the method: notifyNameCompartmentVisibilityChange.
     */
    public void testNotifyNameCompartmentVisibilityChange() {

        int oldWidth = node.getSelectionBound().width;

        ((Uml1SemanticModelBridge) node.getGraphNode().getSemanticModel()).setElement(changeName(node
                        .getGraphNode(), "NewName"));

        
        node.notifyNameCompartmentVisibilityChange();
        assertTrue("The method does not work properly.", (node.getSelectionBound().width <= oldWidth));
    }


    /**
     * Tests the method: notifyStereotypeCompartmentVisiblilityChange.
     */
    public void testNotifyStereotypeCompartmentVisibilityChange() {
        // retrieve the width
        int width0 = node.getSelectionBound().width;

        addStereotype(graphNode, "AnotherStereotype");

        node.notifyGraphNodeChange("Stereotype for tests");

        assertTrue("The method does not work properly.",
                        (node.getSelectionBound().width >= width0));
    }

    /**
     * Tests the method: notifyPropertiesChange.
     */
    public void testNotifyPropertiesChange() {

        // asign the color
        String color = "FFFF00";

        // set the properties
        for (Property property : node.getGraphNode().getProperties()) {

            if (property.getKey().equals("FILL_COLOR")) {
                property.setValue(color);
            }
        }
        
        // notify it
        node.notifyPropertiesChange();

        assertTrue("The method does not work properly.", node.getFillColor().equals(Color.YELLOW));
    }

    /**
     * Tests the method: getNameCompartment.
     */
    public void testGetNameCompartment() {  
        assertTrue("The method does not work properly.", node.getNameCompartment()
                        .getText().trim().equals("NameCompartment"));
        
        
    }

    /**
     * Tests the method: getStereotypeCompartment.
     */
    public void testGetStereotypeCompartment() {
        assertTrue("The method does not work properly.", node
                        .getStereotypeCompartment().getText().trim().equals("<< StereotypeCompartment >>"));
    }

    /**
     * Tests the method: getStrokeColor.
     */
    public void testGetStrokeColor() {

        assertTrue("The color is wrong.", node.getStrokeColor().equals(Color.BLACK));
    }

    /**
     * Tests the method: getFillColor.
     * 
     */
    public void testGetFillColor() {
        assertTrue("The color is wrong.", node.getFillColor().equals(Color.WHITE));
    }

    /**
     * Tests the method: getFontColor.
     */
    public void testGetFontColor() {
        assertTrue("The color is wrong.", node.getFontColor().equals(Color.BLACK));
    }

    /**
     * Checks if the listener class is within the array.
     * 
     * @param listeners the listeners
     * @param listener the expected class
     * 
     * @return true if contains, false otherwise
     */
    private boolean containsListener(
        BoundaryChangedListener[] listeners, 
        Class listener) {
        for (int i = 0; i < listeners.length; i++) {

            if (listener.isInstance(listeners[i])) {
                return true;
            }
        }
        return false;
    }
}