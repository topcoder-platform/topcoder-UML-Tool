/*
 * Copyright (C) 2007 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.gui.diagramviewer.uml.classelements;

import java.awt.event.MouseEvent;
import java.util.Map;

import com.topcoder.diagraminterchange.GraphNode;
import com.topcoder.gui.diagramviewer.edges.Edge;
import com.topcoder.gui.diagramviewer.elements.Node;
import com.topcoder.gui.diagramviewer.uml.classelements.event.EdgeAddEvent;
import com.topcoder.uml.model.core.ModelElement;
import com.topcoder.uml.model.core.classifiers.Interface;
import com.topcoder.uml.model.core.dependencies.Abstraction;
import com.topcoder.uml.model.core.relationships.Generalization;

/**
 * <p>
 * This class represents an Interface node in UML diagram. It is an extension of BaseNode, which defines the most
 * features for a node. This class only provides some specific methods to support the unique shape of interface, to
 * support the mouse events processing, and also to support the unique structure of interface GraphNode.
 * </p>
 * <p>
 * This class is not thread safe, because the BaseNode class is not thread safe.
 * </p>
 * @author MiG-29, TCSDEVELOPER
 * @version 1.0
 */
public class InterfaceNode extends ClassNode {

    /**
     * <p>
     * Creates an <code>InterfaceNode</code> instance.
     * </p>
     * @param graphNode
     *            the graphNode representing this InterfaceNode
     * @param properties
     *            the properties name mapping
     * @throws IllegalArgumentException
     *             if graphNode or properties is null, or properties contains null
     * @throws IllegalGraphElementException
     *             if the structure of graphNode is invalid
     */
    public InterfaceNode(GraphNode graphNode, Map<String, String> properties) {
        super(graphNode, properties);
    }

    /**
     * <p>
     * Reloads diagram interchange information from contained graphNode.
     * </p>
     * @param message
     *            telling how graphNode is changed (could be null)
     * @throws IllegalGraphElementException
     *             if the structure of graphNode is invalid
     */
    public void notifyGraphNodeChange(String message) {
        super.notifyGraphNodeChange(message);
    }

    /**
     * <p>
     * Consumes the event when the diagram viewer is in the status of adding new element. The concrete edge type
     * checking is implemented here.
     * </p>
     * @param event
     *            the mouse event
     * @return a flag indicating whether the event is consumed
     */
    protected boolean consumeEvent(MouseEvent event) {
        if (event == null || event.getSource() == null) {
            return false;
        }
        if (event.getSource() instanceof Node) {
            return false;
        }
        if (event.getSource() instanceof Edge) {
            Edge edge = (Edge) event.getSource();
            ModelElement element = Util.getElement(edge.getGraphEdge());
            if (event.getID() == MouseEvent.MOUSE_PRESSED && !(element instanceof Abstraction)) {
                // This edge is not an Abstraction edge
                EdgeAddEvent edgeAddEvent = new EdgeAddEvent(this, event.getPoint(), true);
                fireEdgeAdd(edgeAddEvent);
                return true;
            } else if (event.getID() == MouseEvent.MOUSE_RELEASED) {
                boolean isStart = true;
                if (!(element instanceof Generalization)) {
                    isStart = false;
                } else {
                    Generalization generalization = (Generalization) element;
                    if (generalization.getChild() instanceof Interface) {
                        isStart = false;
                    }
                }
                if (!isStart) {
                    // This edge is not a Generalization edge, or it is a Generalization edge and its other end is
                    // Interface
                    EdgeAddEvent edgeAddEvent = new EdgeAddEvent(this, event.getPoint(), isStart);
                    fireEdgeAdd(edgeAddEvent);
                    return true;
                }
            }
        }
        return false;
    }
}
