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
import com.topcoder.gui.diagramviewer.uml.activityelements.BaseNode;
import com.topcoder.gui.diagramviewer.uml.activityelements.EllipseConnector;
import com.topcoder.gui.diagramviewer.uml.activityelements.InitialNode;

/**
 * Accuracy tests for the class: EllipseConnector.
 * 
 * @author kinfkong
 * @version 1.0
 */
public class EllipseConnectorAccuracyTest extends AccuracyBase {
    
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
    private EllipseConnector connector;
    
    /**
     * Sets up the test environment.
     */
    protected void setUp() {

        graphNode = createGraphNode(
            "InitialNode", 
            new Point(100, 100), 
            new Dimension(10, 10), 
            "00FF00");
        
        properties = createProperties();

        Point position = new Point(SelectionCorner.DEFAULT_RADIUS * 2, SelectionCorner.DEFAULT_RADIUS * 2);
        node = new InitialNode(
            graphNode, 
            properties, 
            position, 
            new Rectangle(5, 5, 75, 75));
        
        connector = (EllipseConnector) node.getConnector();
    }

    /**
     * Tests the constrcutor EllipseConnector().
     */
    public void testEllipseConnector() {

        assertNotNull("The instance cannot be created.", new EllipseConnector());
    }


    /**
     * Tests the method: getConnectionPoint.
     * 
     */
    public void testGetConnectionPoint() {
        // Get the position of GraphNode
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

        // (x,y) is the right down corner of the graph node's round shape
        x += 5 * 2;
        y += 5 * 2;

        Point point = connector.getConnectionPoint(new Point((int) Math.round(x), (int) Math.round(y)));

        x -= 5;
        y -= 5;
        x += Math.sqrt(2) / 2 * 5;
        y += Math.sqrt(2) / 2 * 5;

        Point desiredPoint = new Point((int) Math.round(x), (int) Math.round(y));
        assertTrue(point.distance(desiredPoint) < 1e-4);

    }
}