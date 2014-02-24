/*
 * Copyright (C) 2007 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.gui.diagramviewer.uml.activityelements.accuracytests;

import java.awt.Dimension;
import java.awt.Point;
import java.awt.Rectangle;
import java.util.Map;

import javax.swing.JFrame;

import com.topcoder.diagraminterchange.GraphNode;
import com.topcoder.gui.diagramviewer.uml.activityelements.BaseNode;
import com.topcoder.gui.diagramviewer.uml.activityelements.ObjectFlowNode;

/**
 * Accuracy tests for the class: ObjectFlowNode.
 * 
 * @author kinfkong
 * @version 1.0
 */
public class ObjectFlowNodeAccuracyTest extends AccuracyBase {

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
     * Sets up the test environment.
     */
    protected void setUp() {

        graphNode = createGraphNode(
            "ObjectFlowNode", 
            new Point(100, 100), 
            new Dimension(100, 40), 
            "00FF00");
        
        properties = createProperties();

        node = new ObjectFlowNode(
            graphNode, 
            properties, 
            new Point(5, 5), 
            new Rectangle(5, 5, 75, 75));
    }

    /**
     * Tests the constructor: ObjectFlowNode.
     * 
     */
    public void testObjectFlowNode() {
        assertNotNull("The instance cannot be created.", node);
    }

    /**
     * Tests the method: Contains.
     * 
     */
    public void testContains_True() {
        Point relative = node.getRelativePosition();
        assertTrue("This point should be within the shape.", node
                        .contains(relative.x + 10, relative.y + 10));
    }

    /**
     * Tests the method: Contains.
     */
    public void testContains_False() {
        assertFalse("This point should be out of the shape.", node.contains(60, 160));
    }

    /**
     * Tests the method: getPreferredGraphNodeSize().
     */
    public void testGetPreferredGraphNodeSize() {
        assertNotNull("The method does not work properly.", node.getPreferredGraphNodeSize());
    }

    /**
     * Tests the method: notifyGraphNodeChange.
     *
     */
    public void testNotifyGraphNodeChangeAccuracy() {

        com.topcoder.diagraminterchange.Dimension d = graphNode.getSize();
        d.setWidth(d.getWidth() + 10);
        graphNode.setSize(d);
        DummyBoundaryChangedListener listener = new DummyBoundaryChangedListener();
        node.addBoundaryChangedListener(listener);
        node.notifyGraphNodeChange("GraphNode's width increased.");
        int changed = listener.getNewBoundary().width - listener.getOldBoundary().width;
        assertEquals("The changed size of node should be equal to graphNode's.", changed, 10);
    }

    /**
     * The UI test for the class: ObjectFlowNode.
     */
    public static void main(String[] args) {

        GraphNode graphNode = createGraphNode(
            "ObjectFlowNode", 
            new Point(100, 100), 
            new Dimension(145, 30), 
            "00FF00");
       

        BaseNode node = new ObjectFlowNode(
            graphNode, 
            createProperties(), 
            new Point(5, 5), 
            new Rectangle(5, 5, 75, 75));

        JFrame.setDefaultLookAndFeelDecorated(true);

        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        frame.getContentPane().add(node);
        frame.setSize(new Dimension(500, 500));
        frame.setVisible(true);
    }
}