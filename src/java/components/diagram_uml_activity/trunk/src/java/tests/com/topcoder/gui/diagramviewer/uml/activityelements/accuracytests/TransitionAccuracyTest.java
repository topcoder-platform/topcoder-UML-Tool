/*
 * Copyright (C) 2007 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.gui.diagramviewer.uml.activityelements.accuracytests;

import java.awt.Dimension;
import java.awt.Point;
import java.awt.Rectangle;

import javax.swing.JFrame;

import com.topcoder.diagraminterchange.GraphEdge;
import com.topcoder.diagraminterchange.GraphNode;
import com.topcoder.diagraminterchange.Uml1SemanticModelBridge;
import com.topcoder.gui.diagramviewer.uml.activityelements.BaseNode;
import com.topcoder.gui.diagramviewer.uml.activityelements.ObjectFlowNode;
import com.topcoder.gui.diagramviewer.uml.activityelements.Transition;
import com.topcoder.uml.model.core.ModelElement;

/**
 * Accuracy tests for the class: Transition.
 * 
 * @author kinfkong
 *
 */
public class TransitionAccuracyTest extends AccuracyBase {

    /**
     * Represents the relative position.
     */
    private static final Point RELATIVE_POSITION = new Point(5, 5);

    /**
     * Represents the transition edge.
     */
    private Transition edge;

    /**
     * Represents the graph edge.
     */
    private GraphEdge graphEdge;
    
    /**
     * Sets up the test environment.
     */
    protected void setUp() {

        graphEdge = createValidGraphEdge(RELATIVE_POSITION);

        edge = new Transition(graphEdge);
    }

    /**
     * Tests the constructor: Transition.
     *
     */
    public void testTransition() {

        assertNotNull("The instance cannot be created.", edge);
    }
    
    /**
     * Tests the method: getNameCompartment.
     *
     */
    public void testGetNameCompartment() {

        assertEquals("The method does not work properly.",
                        edge.getNameCompartment().getText(),  "TransitionNameCompartment");
    }

    /**
     * Represents the getStereotypeCompartment.
     *
     */
    public void testGetStereotypeCompartment() {

        assertEquals("The method does not work properly.", edge.getNameCompartment()
                        .getText(), "TransitionStereotypeCompartment");
    }

    /**
     * Tests the method: getDescriptionCompartment.
     *
     */
    public void testGetDescriptionCompartment() {

        assertEquals("The method does not work properly", edge
                        .getNameCompartment().getText(), "TransitionDescriptionCompartment");
    }

    /**
     * Tests the method: noftifyGraphEdgeChange.
     *
     */
    public void testNotifyGraphEdgeChange() {

        ModelElement element = (ModelElement) ((Uml1SemanticModelBridge) edge.getGraphEdge().getSemanticModel())
                        .getElement();

        element.setName("NewTransitionNameCompartment");

        edge.notifyGraphEdgeChange();

        assertEquals("The method does not work properly.", edge.getNameCompartment()
                        .getText(), "NewTransitionNameCompartment");
    }


    /**
     * The UI test for the class: Transition.
     * 
     * @param args the args for main
     */
    public static void main(String[] args) {

        // create the node
        GraphNode graphNode = createGraphNode("ObjectFlowNode", new Point(150, 150), new Dimension(20,
                        20), "FFFF00");
        BaseNode node = new ObjectFlowNode(graphNode, createProperties(), RELATIVE_POSITION, new Rectangle(
                        5, 5, 25, 25));

        GraphEdge graphEdge = createValidGraphEdge(RELATIVE_POSITION);
        Point point = node.getConnector().getConnectionPoint(new Point(0, 0));

        com.topcoder.diagraminterchange.Point pointTC = new com.topcoder.diagraminterchange.Point();
        pointTC.setX(point.getX());
        pointTC.setY(point.getY());

        com.topcoder.diagraminterchange.Point pointTwoTC = new com.topcoder.diagraminterchange.Point();
        pointTwoTC.setX(10);
        pointTwoTC.setY(10);

        graphEdge.addWaypoint(pointTC);
        graphEdge.addWaypoint(pointTwoTC);

        Transition edge = new Transition(graphEdge);

        // make sure we have nice window decorations.
        JFrame.setDefaultLookAndFeelDecorated(true);

        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // add the node to the context pane
        frame.getContentPane().add(node);
        frame.getContentPane().add(edge);
        frame.setSize(new Dimension(500, 500));
        frame.setVisible(true);
    }
}