/*
 * Copyright (C) 2007 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.umltool.deploy.handlers;

import java.awt.Component;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JComponent;
import javax.swing.SwingUtilities;

import com.topcoder.diagraminterchange.GraphElement;
import com.topcoder.diagraminterchange.GraphNode;
import com.topcoder.diagraminterchange.Point;
import com.topcoder.gui.diagramviewer.DiagramView;
import com.topcoder.gui.diagramviewer.edges.Edge;
import com.topcoder.gui.diagramviewer.elements.Node;
import com.topcoder.gui.diagramviewer.elements.NodeContainer;
import com.topcoder.uml.actions.diagram.elements.AddDiagramElementAction;
import com.topcoder.uml.actions.general.ChangePositionAction;
import com.topcoder.uml.modelmanager.UMLModelManager;
import com.topcoder.umltool.deploy.DeployHelper;
import com.topcoder.umltool.deploy.MainFrame;
import com.topcoder.umltool.deploy.actions.undoable.RemoveDiagramElementAction;
import com.topcoder.umltool.deploy.actions.undoable.UpdateEdgeAction;
import com.topcoder.umltool.deploy.actions.undoable.UpdateNodeContainerAction;

/**
 * <p>
 * This handler will move a node when it is dragged and released.
 * </p>
 * <p>
 * Thread safety: This class are not required to be thread-safe. They could be used in a thread safe manner in this
 * component.
 * </p>
 * @author ly, FireIce, ylouis, TCSDEVELOPER
 * @version 1.0
 */
public class NodeMouseHandler extends MouseAdapter {
    /**
     * <p>
     * Main frame window.
     * </p>
     */
    private final MainFrame mainFrame;

    /**
     * <p>
     * Represents the old position for dragged graph node.
     * </p>
     */
    private java.awt.Point oldPosition;

    /**
     * <p>
     * Represents the old Z order for dragged node.
     * </p>
     */
    private int oldZOrder;

    /**
     * <p>
     * Creates an instance of <code>NodeMouseHandler</code>.
     * </p>
     * @param mainframe
     *            main frame window
     * @throws IllegalArgumentException
     *             if the argument is null
     */
    public NodeMouseHandler(MainFrame mainframe) {
        DeployHelper.checkNotNull(mainframe, "mainframe");
        this.mainFrame = mainframe;
    }

    /**
     * <p>
     * Handles the <b>MOUSE_PRESSED</b> event.
     * </p>
     * <p>
     * When mouse pressed on edge, calculate the index for a new way point.
     * </p>
     * @param e
     *            the mouse pressed event
     */
    public void mousePressed(MouseEvent e) {
        if (e == null) {
            return;
        }
        Node node = (Node) e.getSource();
        GraphNode graphNode = node.getGraphNode();
        oldPosition = DeployHelper.getAbsoluteGraphNodePosition(graphNode);
        oldZOrder = node.getParent().getComponentZOrder(node);
    }

    /**
     * <p>
     * Handles the <b>MOUSE_RELEASED</b> event.
     * </p>
     * <p>
     * When mouse is released, relocate all selected elements.
     * </p>
     * @param e
     *            the mouse pressed event
     */
    public void mouseReleased(MouseEvent e) {
        if (e == null || oldPosition == null) {
            return;
        }
        Node node = (Node) e.getSource();
        GraphNode graphNode = node.getGraphNode();
        GraphNode oldContainer = (GraphNode) graphNode.getContainer();

        DiagramView view = (DiagramView) node.getParent();

        java.awt.Point point = SwingUtilities.convertPoint(node, e.getPoint(), view);

        NodeContainer nodeContainer = getNewNodeContainer(view, point);

        GraphElement newContainer;
        if (nodeContainer != null) {
            newContainer = (GraphElement) nodeContainer.getGraphNode().getContaineds().get(1);
        } else {
            newContainer = view.getDiagram();
        }

        java.awt.Point newPositon = DeployHelper.getAbsoluteGraphNodePosition(graphNode);
        int xOff = (int) (newPositon.getX() - oldPosition.getX());
        int yOff = (int) (newPositon.getY() - oldPosition.getY());

        if (xOff == 0 && yOff == 0) {
            return;
        }

        UpdateNodeContainerAction compositeAction = new UpdateNodeContainerAction(node, "node moved");

        List<JComponent> draggedElements = DeployHelper.getFilteredSelectedElements(mainFrame, view);
        for (JComponent component : draggedElements) {
            if (component instanceof Node) {
                relocateNode((Node) component, newContainer, xOff, yOff, compositeAction);
            } else {
                relocateEdge((Edge) component, xOff, yOff, compositeAction);
            }
        }

        mainFrame.handleActionEvent(compositeAction, node, "Node moved");
        if (newContainer != oldContainer) {
            if (nodeContainer != null) {
                DeployHelper.updateZOrder(nodeContainer);
            }
            mainFrame.getDocumentTree().updateTree();
        } else {
            node.getParent().setComponentZOrder(node, oldZOrder);
            if (node instanceof NodeContainer) {
                DeployHelper.updateZOrder((NodeContainer) node);
            }
        }

        oldPosition = null;
    }

    /**
     * <p>
     * Relocates node according to given offset and new container.
     * </p>
     * @param node
     *            node to be relocate
     * @param newContainer
     *            new container to contain node
     * @param xOff
     *            x offset
     * @param yOff
     *            y offset
     * @param compositeAction
     *            composite action to execute moving actually
     */
    private void relocateNode(Node node, GraphElement newContainer, int xOff, int yOff,
            UpdateNodeContainerAction compositeAction) {
        GraphNode graphNode = node.getGraphNode();
        GraphElement oldContainer = graphNode.getContainer();

        Point newPositon = new Point();
        newPositon.setX(graphNode.getPosition().getX());
        newPositon.setY(graphNode.getPosition().getY());

        Point oldPos = new Point();
        oldPos.setX(newPositon.getX() - xOff);
        oldPos.setY(newPositon.getY() - yOff);

        List<Edge> containedEdges = null;
        if (node instanceof NodeContainer) {
            containedEdges = DeployHelper.getContainedEdges((NodeContainer) node);
        }

        if (node instanceof NodeContainer && containedEdges.size() != 0) {
            if (xOff != 0 || yOff != 0) {
                // Move the contained edges
                for (Edge edge : containedEdges) {
                    relocateEdge(edge, xOff, yOff, compositeAction);
                }
            }
        }

        if (newContainer == oldContainer) {
            // Still in same node container
            if (xOff != 0 || yOff != 0) {
                graphNode.setPosition(oldPos);
                ChangePositionAction action = new ChangePositionAction(graphNode, newPositon);
                compositeAction.put(action, node);
            }
        } else {
            // Move to another node container
            java.awt.Point location = DeployHelper.getAbsoluteGraphNodePosition(graphNode);
            java.awt.Point containerLocation = DeployHelper.getAbsoluteGraphNodePosition(newContainer);
            Point newPosition = new Point();
            newPosition.setX(location.x - containerLocation.x);
            newPosition.setY(location.y - containerLocation.y);
            graphNode.setPosition(oldPos);
            RemoveDiagramElementAction removeAction = new RemoveDiagramElementAction(oldContainer, graphNode);
            ChangePositionAction changePositionAction = new ChangePositionAction(graphNode, newPosition);
            AddDiagramElementAction addAction = new AddDiagramElementAction(newContainer, graphNode, UMLModelManager
                    .getInstance().getProjectConfigurationManager());
            compositeAction.put(removeAction, node);
            compositeAction.put(addAction, node);
            compositeAction.put(changePositionAction, node);
        }
    }

    /**
     * <p>
     * Moves edge according to given offset.
     * </p>
     * @param edge
     *            edge to be moved
     * @param xOff
     *            x offset
     * @param yOff
     *            y offset
     * @param compositeAction
     *            composite action to execute moving actually
     */
    private void relocateEdge(Edge edge, int xOff, int yOff, UpdateNodeContainerAction compositeAction) {
        List<Point> oldWayPoints = new ArrayList<Point>();
        List<Point> newWayPoints = edge.getGraphEdge().getWaypoints();
        for (Point wayPoint : newWayPoints) {
            Point newPoint = new Point();
            newPoint.setX(wayPoint.getX() - xOff);
            newPoint.setY(wayPoint.getY() - yOff);
            oldWayPoints.add(newPoint);
        }
        // Move back to the old position first
        UpdateEdgeAction moveEdgeAction = new UpdateEdgeAction(edge, newWayPoints, oldWayPoints);
        moveEdgeAction.executeAction();
        // Put the new action to event manager
        moveEdgeAction = new UpdateEdgeAction(edge, oldWayPoints, newWayPoints);
        compositeAction.put(moveEdgeAction, edge);
    }

    /**
     * <p>
     * Get the new node container at specified position for given node.
     * </p>
     * @param view
     *            the diagram view
     * @param position
     *            the new position to find node container
     * @return the found node container, null if not found
     */
    private NodeContainer getNewNodeContainer(DiagramView view, java.awt.Point position) {
        Component[] components = view.getComponents();
        for (Component component : components) {
            if (component instanceof NodeContainer) {
                Node node = (Node) component;
                if (view.getViewer().isElementSelected(node)
                        || DeployHelper.isContainedBySelectedContainer(mainFrame, node)) {
                    continue;
                }
                if (!component.contains(SwingUtilities.convertPoint(view, position, component))) {
                    continue;
                }
                return (NodeContainer) component;
            }
        }
        return null;
    }
}
