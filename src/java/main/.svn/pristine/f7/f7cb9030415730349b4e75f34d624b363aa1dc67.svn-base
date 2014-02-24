/*
 * Copyright (C) 2007 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.umltool.deploy.actions.undoable;

import java.awt.geom.Rectangle2D;
import java.util.Set;

import com.topcoder.diagraminterchange.Diagram;
import com.topcoder.diagraminterchange.Dimension;
import com.topcoder.diagraminterchange.GraphNode;
import com.topcoder.diagraminterchange.Point;
import com.topcoder.gui.diagramviewer.DiagramView;
import com.topcoder.gui.diagramviewer.elements.Node;
import com.topcoder.gui.diagramviewer.elements.NodeContainer;
import com.topcoder.uml.actions.general.ChangePositionAction;
import com.topcoder.uml.actions.general.ChangeSizeAction;
import com.topcoder.umltool.deploy.DeployHelper;
import com.topcoder.util.actionmanager.ActionExecutionException;

/**
 * <p>
 * This action extends from <code>UpdateDiagramAction</code>. It is used to update the node container's location and
 * size, and also the diagram size if necessary after actions of a Node are executed. It is an UndoableAction.
 * </p>
 * @author ly, FireIce, ylouis
 * @version 1.0
 */
public class UpdateNodeContainerAction extends UpdateDiagramAction {

    /**
     * <p>
     * Represents the node which causes this action.
     * </p>
     */
    private Node node;

    /**
     * <p>
     * This action is used to create a Node, then this will cause the node container and diagram updated.
     * </p>
     */
    private GenerateNodeAction generateNodeAction;

    /**
     * <p>
     * Creates an instance of <code>UpdateNodeContainerAction</code>.
     * </p>
     * @param node
     *            the node which causes this action
     * @param presentationName
     *            the non null, non empty string representing the presentation name
     */
    public UpdateNodeContainerAction(Node node, String presentationName) {
        this(null, (DiagramView) node.getParent(), presentationName);
        this.node = node;
    }

    /**
     * <p>
     * Creates an instance of <code>UpdateNodeContainerAction</code>.
     * </p>
     * @param action
     *            the node generated action which causes this action
     * @param view
     *            the diagram view where the action happens
     * @param presentationName
     *            the non null, non empty string representing the presentation name
     */
    public UpdateNodeContainerAction(GenerateNodeAction action, DiagramView view, String presentationName) {
        super(view, presentationName);
        this.generateNodeAction = action;
    }

    /**
     * <p>
     * Indicates whether this action do nothing.
     * </p>
     * @return true if this action have nothing to do
     */
    public boolean isEmpty() {
        if (generateNodeAction != null) {
            return false;
        }
        return super.isEmpty();
    }

    /**
     * <p>
     * The method actually execute this auction.
     * </p>
     * @throws ActionExecutionException
     *             if any exception prevents this method from completing successfully
     */
    public void executeAction() throws ActionExecutionException {
        super.executeFrom(0);
        if (generateNodeAction != null) {
            put(generateNodeAction, getView());
            super.executeFrom(countActions() - 1);
            node = generateNodeAction.getNode();
        }
        updateNodeContainers();
        super.updateDiagram();
    }

    /**
     * <p>
     * Calculates a preferred rectangle bound to contain all contained nodes.
     * </p>
     * @param container
     *            a NodeContainer whose contained nodes are used to calculate the bound
     * @return a preferred bound
     */
    private Rectangle2D.Double getPreferredBound(NodeContainer container) {
        double x1 = Double.MAX_VALUE;
        double y1 = Double.MAX_VALUE;
        double x2 = Double.MIN_VALUE;
        double y2 = Double.MIN_VALUE;
        Set<Node> set = DeployHelper.getNodes(container);
        for (Node node : set) {
            GraphNode graphNode = node.getGraphNode();
            x1 = Math.min(x1, graphNode.getPosition().getX());
            y1 = Math.min(y1, graphNode.getPosition().getY());
            x2 = Math.max(x2, graphNode.getPosition().getX() + graphNode.getSize().getWidth());
            y2 = Math.max(y2, graphNode.getPosition().getY() + graphNode.getSize().getHeight());
        }
        if (x1 == Double.MAX_VALUE) {
            return null;
        }
        GraphNode graphNode = container.getGraphNode();
        com.topcoder.diagraminterchange.Point position = graphNode.getPosition();
        Dimension size = graphNode.getSize();
        double xOff = 0;
        double yOff = 0;
        double wOff = 0;
        double hOff = 0;
        if (x1 < gap) {
            xOff = gap - x1;
        }
        if (y1 < gap) {
            yOff = gap - y1;
        }
        if (x2 + gap > size.getWidth()) {
            wOff = x2 + gap - size.getWidth();
        }
        if (y2 + gap > size.getHeight()) {
            hOff = y2 + gap - size.getHeight();
        }
        Rectangle2D.Double rectangle = new Rectangle2D.Double();
        rectangle.x = position.getX() - xOff;
        rectangle.y = position.getY() - yOff;
        rectangle.width = size.getWidth() + xOff + wOff;
        rectangle.height = size.getHeight() + yOff + hOff;
        return rectangle;
    }

    /**
     * <p>
     * Updates node container's position and size, and put the actions into the action list.
     * </p>
     * @throws ActionExecutionException
     *             if fail to execute any action
     */
    private void updateNodeContainers() throws ActionExecutionException {
        GraphNode graphNode = node.getGraphNode();
        GraphNode container = (GraphNode) graphNode.getContainer();
        DiagramView view = (DiagramView) node.getParent();
        while (container != null && container.indexOfContained(graphNode) != -1) {
            if (container instanceof Diagram) {
                break;
            }
            container = (GraphNode) container.getContainer();

            NodeContainer nodeContainer = (NodeContainer) DeployHelper.getComponent(container, view);
            Rectangle2D.Double rectangle = getPreferredBound(nodeContainer);
            com.topcoder.diagraminterchange.Point newPosition = new com.topcoder.diagraminterchange.Point();
            newPosition.setX(rectangle.x);
            newPosition.setY(rectangle.y);
            com.topcoder.diagraminterchange.Point oldPosition = container.getPosition();
            int index = countActions();
            if (newPosition.getX() != oldPosition.getX() || newPosition.getY() != oldPosition.getY()) {
                ChangePositionAction changePositionAction = new ChangePositionAction(container, newPosition);
                put(changePositionAction, nodeContainer);
            }
            Dimension newSize = new Dimension();
            newSize.setWidth(rectangle.width);
            newSize.setHeight(rectangle.height);
            Dimension oldSize = container.getSize();
            if (newSize.getWidth() != oldSize.getWidth() || newSize.getHeight() != oldSize.getHeight()) {
                ChangeSizeAction changeSizeAction = new ChangeSizeAction(container, newSize);
                put(changeSizeAction, nodeContainer);
            }
            if (newPosition.getX() != oldPosition.getX() || newPosition.getY() != oldPosition.getY()) {
                double xOff = newPosition.getX() - container.getPosition().getX();
                double yOff = newPosition.getY() - container.getPosition().getY();
                Set<Node> set = DeployHelper.getNodes(nodeContainer);
                for (Node contained : set) {
                    Point pos = contained.getGraphNode().getPosition();
                    Point newPos = new Point();
                    newPos.setX(pos.getX() - xOff);
                    newPos.setY(pos.getY() - yOff);
                    ChangePositionAction action = new ChangePositionAction(contained.getGraphNode(), newPos);
                    put(action, contained);
                }
            }
            // Execute all actions for this node container
            executeFrom(index);

            graphNode = container;
            container = (GraphNode) container.getContainer();
        }
    }

}
