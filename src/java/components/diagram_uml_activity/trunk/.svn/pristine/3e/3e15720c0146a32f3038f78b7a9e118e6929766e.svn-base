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
import com.topcoder.gui.diagramviewer.elements.SelectionCorner;
import com.topcoder.gui.diagramviewer.uml.activityelements.ActionState;
import com.topcoder.gui.diagramviewer.uml.activityelements.BaseNode;

/**
 * Accuracy tests for the class: ActionState.
 * 
 * @author kinfkong
 * @version 1.0
 */
public class ActionStateAccuracyTest extends AccuracyBase {

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

        graphNode =
            createGraphNode("ActionState", new Point(100, 150), new Dimension(80, 40), "0000FF");

        properties = createProperties();

        node = new ActionState(graphNode, properties, new Point(5, 5), new Rectangle(5, 5, 75, 75));
    }

    /**
     * Tests the constructor: ActionState.
     * 
     */
    public void testActionState() {
        assertNotNull("The instance cannot be created.", node);
    }

    /**
     * Tests the method: Contains.
     * 
     */
    public void testContains_True() {
        Point location = node.getLocation();
        Point position = new Point(SelectionCorner.DEFAULT_RADIUS * 2, SelectionCorner.DEFAULT_RADIUS * 2);
        int x = position.x + (int) Math.round(graphNode.getSize().getWidth() / 2);
        int y = position.y + (int) Math.round(graphNode.getSize().getHeight() / 2);
        assertTrue("The given point should be contained.", node.contains(x, y));
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
     * The UI test for the class: ActionState.
     */
    public static void main(String[] args) {

        GraphNode graphNode =
            createGraphNode("ActionState", new Point(100, 100), new Dimension(145, 30), "00FF00");

        BaseNode node =
            new ActionState(graphNode, createProperties(), new Point(5, 5), new Rectangle(5, 5, 75, 75));

        JFrame.setDefaultLookAndFeelDecorated(true);

        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        frame.getContentPane().add(node);
        frame.setSize(new Dimension(500, 500));
        frame.setVisible(true);
    }
}