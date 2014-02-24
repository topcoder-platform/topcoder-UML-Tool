/*
 * Copyright (C) 2007 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.gui.diagramviewer.uml.activityelements.accuracytests;

import java.awt.Dimension;
import java.awt.Point;
import java.awt.Rectangle;
import java.util.Map;

import com.topcoder.diagraminterchange.GraphElement;
import com.topcoder.diagraminterchange.GraphNode;
import com.topcoder.gui.diagramviewer.elements.SelectionCorner;
import com.topcoder.gui.diagramviewer.uml.activityelements.ActionState;
import com.topcoder.gui.diagramviewer.uml.activityelements.BaseNode;
import com.topcoder.gui.diagramviewer.uml.activityelements.RectangleConnector;

/**
 * Accuracy tests for the class: EllipseConnector.
 * 
 * @author kinfkong
 * @version 1.0
 */
public class RectangleConnectorAccuracyTest extends AccuracyBase {
    
    /**
     * Represents the base node for accuracy tests.
     */
    private BaseNode node;

    /**
     * Represents the graph node.
     */
    private GraphNode graphNode;

    /**
     * Represents the properties.
     */
    private Map<String, String> properties;
    
    /**
     * Represents the connector.
     */
    private RectangleConnector connector;
    
    /**
     * Sets up the test environment.
     */
    protected void setUp() {

        graphNode = createGraphNode(
            "ActionState", 
            new Point(100, 100), 
            new Dimension(50, 20), 
            "00FF00");
        
        properties = createProperties();
        Point position = new Point(SelectionCorner.DEFAULT_RADIUS * 2, SelectionCorner.DEFAULT_RADIUS * 2);
        node = new ActionState(
            graphNode, 
            properties, 
            position, 
            new Rectangle(5, 5, 75, 75));
        
        
        connector = (RectangleConnector) node.getConnector();
    }

    /**
     * Tests the constrcutor RectangleConnector().
     */
    public void testRectangleConnector() {
        assertNotNull("The instance cannot be created.", new RectangleConnector());
    }


    /**
     * Tests the method: getConnectionPoint.
     * 
     */
    public void testGetConnectionPoint() {

        double x = 0;
        double y = 0;
        for (GraphElement element = node.getGraphNode(); element.getContainer() != null; element = element
                .getContainer()) {
            if (element.getPosition() == null) {
                fail("Graph structure of node should be correct.");
            }
            x += element.getPosition().getX();
            y += element.getPosition().getY();
        }

        // (x,y) is the right down corner of the graph node's rectangle
        x += node.getGraphNode ().getSize().getWidth();
        y += node.getGraphNode ().getSize().getHeight();

        Point point = connector.getConnectionPoint(new Point((int) Math.round(x + 10), (int) Math.round(y + 10)));
        Point desiredPoint = new Point((int) Math.round(x), (int) Math.round(y));
        assertTrue(point.distance(desiredPoint) < 1e-4);
    }
}