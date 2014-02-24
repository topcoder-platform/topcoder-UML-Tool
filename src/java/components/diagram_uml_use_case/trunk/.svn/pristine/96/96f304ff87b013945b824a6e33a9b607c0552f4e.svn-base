/*
 * Copyright (C) 2007 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.gui.diagramviewer.uml.usecaseelements;

import java.awt.Dimension;
import java.awt.Point;
import java.awt.datatransfer.Transferable;
import java.util.HashMap;
import java.util.Map;

import javax.swing.JComponent;
import javax.swing.TransferHandler;

import junit.framework.TestCase;

import com.topcoder.diagraminterchange.GraphNode;
import com.topcoder.diagraminterchange.Uml1SemanticModelBridge;
import com.topcoder.gui.diagramviewer.edges.Connector;
import com.topcoder.gui.diagramviewer.edges.WayPointEvent;
import com.topcoder.gui.diagramviewer.edges.WayPointListener;
import com.topcoder.gui.diagramviewer.elements.Node;
import com.topcoder.gui.diagramviewer.uml.usecaseelements.event.NodeAddEvent;
import com.topcoder.gui.diagramviewer.uml.usecaseelements.event.NodeAddListener;
import com.topcoder.gui.diagramviewer.uml.usecaseelements.event.TextChangeEvent;
import com.topcoder.gui.diagramviewer.uml.usecaseelements.event.TextChangeListener;
import com.topcoder.uml.model.usecases.Actor;
import com.topcoder.uml.model.usecases.IncludeImpl;

/**
 * <p>
 * This demo shows how to use the API to manipulate the Diagram Use Case.
 * </p>
 * <p>
 * This demo shows how to create an SubsystemNodeContainer, change its name. And also shows how to create an
 * IncludeEdge, and use connector to get the connection point.
 * </p>
 * <p>
 * Note, this demo only shows part usage of this component, and the un-revealed part is much similar to following part.
 * </p>
 *
 * @author TCSDEVELOPER
 * @version 1.0
 */
public class DemoTests extends TestCase {

    /**
     * <p>
     * Properties mapping used for testing.
     * </p>
     */
    private Map<String, String> properties = new HashMap<String, String>();

    /**
     * <p>
     * Sets up test environment.
     * </p>
     */
    protected void setUp() {
        // create custom properties mappings.
        properties.put("StrokeColor", "StrokeColor");
        properties.put("FillColor", "FillColor");
        properties.put("FontColor", "FontColor");
        properties.put("FontSize", "FontSize");
        properties.put("FontFamily", "FontFamily");
    }

    /**
     * <p>
     * Tears down test environment.
     * </p>
     */
    protected void tearDown() {
    }

    /**
     * <p>
     * Demo 1: Shows how to create SubsystemNodeContainer, and add Listener to it.
     * </p>
     *
     * @throws IllegalGraphElementException to junit
     */
    public void testDemo1() throws IllegalGraphElementException {
        // create Subsystem with properties mapping and transfer handler
        SubsystemNodeContainer subsystem = new SubsystemNodeContainer(TestHelper.createGraphNodeForSubsystem(),
                properties, new CustomTransferHandler());

        // register a listener to the subsystem container to add child
        subsystem.addNodeAddListener(new SubsystemChildAddListener());

        // register the text change listener to the name compartment.
        // the name can be changed, and node will be resized automatically
        subsystem.getNameCompartment().addTextChangeListener(new NameChangeListener());

    }

    /**
     * <p>
     * Demo 2: Shows how to create UseCaseNode, IncludeEdge, and use the Connector.
     * </p>
     *
     * @throws IllegalGraphElementException to junit
     */
    public void testDemo2() throws IllegalGraphElementException {
        // create a use case.
        UseCaseNode useCase = new UseCaseNode(TestHelper.createGraphNodeForUseCase(), properties);

        // create an include edge.
        IncludeEdge includeEdge = new IncludeEdge(TestHelper.createGraphEdgeForEdge(new IncludeImpl()));

        // set the connector
        includeEdge.setRightConnector(useCase.getConnector());

        // add the ending change listener.
        includeEdge.addWayPointDragListener(new IncludeEdgeEndingDragListener());

    }
}

/**
 * <p>
 * This class is a custom transfer handler class, which is used only for demo purpose.
 * </p>
 */
class CustomTransferHandler extends TransferHandler {
    /**
     * <p>
     * We can do some custom transfering in this method.
     * </p>
     *
     * @param comp the component to receive the transfer
     * @param t the data to import
     * @return true if the data was inserted into the component, false otherwise
     * @see TransferHandler#importData(JComponent, Transferable)
     */
    public boolean importData(JComponent comp, Transferable t) {
        // transfer 't' to this component,
        // maybe add a new element to diagram
        return true;
    }
}

/**
 * <p>
 * This class implements NodeAddListener, which is used only for demo purpose.
 * </p>
 * <p>
 * It will listen to the NodeAddListener, and add a node afterwards.
 * </p>
 */
class SubsystemChildAddListener implements NodeAddListener {
    /**
     * <p>
     * We will add a node in this method, after it is called.
     * </p>
     *
     * @see NodeAddListener#nodeAdd(NodeAddEvent)
     * @param e the instance of <code>NodeAddEvent</code>
     */
    public void nodeAdd(NodeAddEvent e) {
        // query the diagram viewer which kind of node should be added.
        Node element;
        try {
            element = new ActorNode(TestHelper.createGraphNodeForActor(), TestHelper.createProperties());
            // specify the location of the element
            element.setLocation(e.getLocation());

            // get the subsystem instance from event
            SubsystemNodeContainer subsystem = (SubsystemNodeContainer) e.getSource();

            // add the node to this subsystem.
            subsystem.addNode("BodyCompartment", element);

        } catch (IllegalGraphElementException e1) {
            e1.printStackTrace();
        }
    }
}

/**
 * <p>
 * This class implements TextChangeListener, which is used only for demo purpose.
 * </p>
 * <p>
 * It will listen to the TextChangeEvent. When it is called, it will change the name in semantic model, and resize the
 * SubsystemNodeContainer.
 * </p>
 */
class NameChangeListener implements TextChangeListener {

    /**
     * <p>
     * We will change the name in the semantic model, and resize the SubsystemNodeContainer in this method.
     * </p>
     *
     * @param e the instance of <code>TextChangeEvent</code>
     * @see TextChangeListener#textChange(TextChangeEvent)
     */
    public void textChange(TextChangeEvent e) {
        // retrieve the TextField, and subsystem node.
        TextField textField = (TextField) e.getSource();
        SubsystemNodeContainer subsystem = (SubsystemNodeContainer) textField.getParent();

        // get subsystem model element.
        GraphNode graphNode = subsystem.getGraphNode();
        Actor modelElement = (Actor) ((Uml1SemanticModelBridge) graphNode.getSemanticModel()).getElement();

        // actually change the name
        modelElement.setName(e.getNewText());

        // get preferred graphNode size
        Dimension newSize = textField.getPreferredSize();

        // change the size of graphNode according to new name
        graphNode.setSize(TestHelper.getDimension(newSize.getWidth(), newSize.getHeight()));

        // notify the size of graphNode is changed. the comment node will be updated accordingly.
        try {
            subsystem.notifyGraphNodeChange("name is changed");
        } catch (IllegalGraphElementException e1) {
            e1.printStackTrace();
        }
    }
}

/**
 * <p>
 * This class implements WayPointListener, which is used only for demo purpose.
 * </p>
 * <p>
 * <p>
 * It will use the connector to change the location of edge ending, when it receives WayPointEvent.
 * <p>
 */
class IncludeEdgeEndingDragListener implements WayPointListener {
    /**
     * <p>
     * We will use the connector to change the location of edge ending in this method.
     * </p>
     *
     * @param e the instance of <code>WayPointEvent</code>
     * @see WayPointListener#wayPointDragged(WayPointEvent)
     */
    public void wayPointDragged(WayPointEvent e) {
        // check whether the ending is dragged....

        // retrieve the edge
        IncludeEdge edge = (IncludeEdge) e.getSource();

        // get connector from comment node
        Connector connector = edge.getRightConnector();

        // get the actual connection point
        Point p = connector.getConnectionPoint(e.getNewPosition());

        // update the ending in diagram interchange.
        edge.getGraphEdge().removeWaypoint(0);
        edge.getGraphEdge().addWaypoint(TestHelper.getPoint(p.getX(), p.getY()));
    }
}
