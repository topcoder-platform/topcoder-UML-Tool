/*
 * Copyright (C) 2007 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.gui.diagramviewer.uml.activityelements.accuracytests;

import java.awt.Dimension;
import java.awt.Point;
import java.awt.Rectangle;
import java.util.Map;

import com.topcoder.diagraminterchange.GraphNode;
import com.topcoder.gui.diagramviewer.uml.activityelements.AcceptEventAction;
import com.topcoder.gui.diagramviewer.uml.activityelements.BaseNode;
import com.topcoder.gui.diagramviewer.uml.activityelements.event.BoundaryChangedEvent;

/**
 * Accuracy tests for the class: BoundaryChangedEvent.
 * 
 * @author kinfkong
 * @version 1.0
 */
public class BoundaryChangedEventAccuracyTest extends AccuracyBase {

    /**
     * Represents the base node.
     */
    private BaseNode node;
    
    /**
     * Represents the graph node.
     */
    private GraphNode graphNode;

    /**
     * Represents the boundary changed event.
     */
    private BoundaryChangedEvent event;

    /**
     * Represents the properties.
     */
    private Map<String, String> properties;
    
    /**
     * Sets up the test environment.
     */
    protected void setUp() {

        graphNode = createGraphNode(
            "AcceptEventAction", 
            new Point(100, 100), 
            new Dimension(145, 30), 
            "00FF00");
        
        properties = createProperties();

        node = new AcceptEventAction(
            graphNode, 
            properties, 
            new Point(5, 5), 
            new Rectangle(5, 5, 75, 75));

        // create the event
        event = new BoundaryChangedEvent(node, "", node.getBounds(), node.getBounds());
    }

    /**
     * Tests the constructor: BoundaryChangedEvent.
     */
    public void testBoundaryChangedEvent() {
        assertNotNull("The instance cannot be created.", event);
    }

    /**
     * Tests the method: getNewBoundary.
     */
    public void testGetNewBoundary() {
        assertEquals("The method does not work properly.", event.getNewBoundary(), node.getBounds());
    }

    /**
     * Tests the method: getOldBoundary.
     */
    public void testGetOldBoundary() {
        assertEquals("The method does not work properly.", 
            event.getOldBoundary(), node.getBounds());
    }
}