/*
 * Copyright (C) 2007 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.umltool.deploy.actions.undoable;

import java.awt.Component;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.topcoder.diagraminterchange.DiagramElement;
import com.topcoder.diagraminterchange.GraphElement;
import com.topcoder.diagraminterchange.GraphNode;
import com.topcoder.gui.diagramviewer.DiagramView;
import com.topcoder.gui.diagramviewer.DiagramViewer;
import com.topcoder.gui.diagramviewer.edges.Edge;
import com.topcoder.gui.diagramviewer.elements.Node;
import com.topcoder.gui.diagramviewer.elements.NodeContainer;
import com.topcoder.gui.diagramviewer.uml.auxiliaryelements.PolylineNode;
import com.topcoder.uml.actions.general.UndoableAbstractAction;
import com.topcoder.umltool.deploy.DeployHelper;
import com.topcoder.umltool.deploy.MainFrame;
import com.topcoder.util.actionmanager.ActionExecutionException;
import com.topcoder.util.actionmanager.UndoableAction;

/**
 * <p>
 * This action is used for remove node from the diagram view.
 * </p>
 * <p>
 * RemoveObjectAction and RemoveDiagramElementAction are used.
 * </p>
 * @author ly, FireIce, ylouis
 * @version 1.0
 */
public abstract class RemoveNodeAction extends UndoableAbstractAction {
    /**
     * <p>
     * Reference to main frame.
     * </p>
     */
    private MainFrame mainFrame;

    /**
     * <p>
     * Reference to diagram view.
     * </p>
     */
    private DiagramView diagramView;

    /**
     * <p>
     * Node to remove.
     * </p>
     */
    private Node node;

    /**
     * <p>
     * Represents whether removing operation should be performed here.
     * </p>
     */
    private boolean isNeedPerform;

    /**
     * <p>
     * Action to remove model element.
     * </p>
     */
    private UndoableAction removeModelElementAction;

    /**
     * <p>
     * Action to remove the graph edge to the diagram.
     * </p>
     */
    private UndoableAction removeDiagramElementAction;

    /**
     * <p>
     * Actions to remove the connected edges.
     * </p>
     */
    private List<RemoveEdgeAction> removeEdgeActionList;

    /**
     * <p>
     * Initialize references in constructor and create actions.
     * </p>
     * @param presentationName
     *            the non null, non empty string representing the presentation name
     * @param mainFrame
     *            reference to main frame
     * @param node
     *            node to remove
     * @param removeModelElementAction
     *            action to remove model element of this node
     * @throws IllegalArgumentException
     *             if mainFrame or node is null
     */
    public RemoveNodeAction(String presentationName, MainFrame mainFrame, Node node,
        UndoableAction removeModelElementAction) {
        super(presentationName);

        DeployHelper.checkNotNull(mainFrame, "mainFrame");
        DeployHelper.checkNotNull(node, "node");

        this.mainFrame = mainFrame;
        this.node = node;
        this.diagramView = (DiagramView) node.getParent();
        this.removeModelElementAction = removeModelElementAction;

        createRemoveEdgeActions(removeModelElementAction != null);

        DiagramElement diagramElement = getDiagramElement(node);
        GraphElement container = diagramElement.getContainer();
        if (container != null && container.containsContained(diagramElement)) {
            removeDiagramElementAction = new RemoveDiagramElementAction(diagramElement.getContainer(), diagramElement);
        }
    }

    /**
     * <p>
     * Gets the corresponding diagram element for given node. Specially for PolylineNode.
     * </p>
     * @param node
     *            node to get diagram element
     * @return diagram element for given node
     */
    private DiagramElement getDiagramElement(Node node) {
        if (node instanceof PolylineNode) {
            PolylineNode polylineNode = (PolylineNode) node;
            return polylineNode.getPolyline();
        }
        return node.getGraphNode();
    }

    /**
     * <p>
     * Gets the node to be removed.
     * </p>
     * @return the node to be removed
     */
    protected Node getNode() {
        return node;
    }

    /**
     * <p>
     * Gets the main frame.
     * </p>
     * @return the main frame
     */
    protected MainFrame getMainFrame() {
        return mainFrame;
    }

    /**
     * <p>
     * Creates the actions for remove connected edges.
     * </p>
     * @param isComplete
     *            whether it is delete complete or only delete representation
     */
    private void createRemoveEdgeActions(boolean isComplete) {
        removeEdgeActionList = new ArrayList<RemoveEdgeAction>();
        Map<Edge, Integer> edgeIndexMap = DeployHelper.getConnectedEdges(node);
        for (Edge edge : edgeIndexMap.keySet()) {
            RemoveEdgeAction removeEdgeAction = DeployHelper.createRemoveEdgeAction(mainFrame, edge, isComplete);
            removeEdgeActionList.add(removeEdgeAction);
        }
    }

    /**
     * <p>
     * Performs the removing action of node.
     * </p>
     */
    private void performAction() {
        GraphNode graphNode = node.getGraphNode();
        GraphNode container = (GraphNode) graphNode.getContainer();

        NodeContainer nodeContainer = (NodeContainer) DeployHelper.getComponent(container, mainFrame);

        DiagramViewer viewer = diagramView.getViewer();
        if (nodeContainer != null) {
            DeployHelper.selectNode(viewer, nodeContainer);
        } else {
            DeployHelper.clearSelected(viewer);
            viewer.addSelectedElement(diagramView);
        }
        mainFrame.getDocumentTree().updateTree();
        diagramView.remove(node);
        mainFrame.updateDiagramView();

        DeployHelper.notifySelectionChanged(mainFrame, diagramView);
    }

    /**
     * <p>
     * This sequence edge maybe removed by group remove operation. Check whether it is needed to perform the removing
     * operation.
     * </p>
     * @return true if need remove, false if already removed.
     */
    private boolean getIsNeedPerform() {
        Component[] components = diagramView.getComponents();
        for (Component component : components) {
            if (component == node) {
                return true;
            }
        }
        return false;
    }

    /**
     * <p>
     * The method actually execute this auction.
     * </p>
     * @throws ActionExecutionException
     *             if any exception prevents this method from completing successfully
     */
    public void executeAction() throws ActionExecutionException {
        isNeedPerform = getIsNeedPerform();
        if (isNeedPerform == false) {
            return;
        }
        for (RemoveEdgeAction action : removeEdgeActionList) {
            action.executeAction();
        }
        try {
            if (removeModelElementAction != null) {
                removeModelElementAction.execute();
            }
            if (removeDiagramElementAction != null) {
                removeDiagramElementAction.execute();
                DeployHelper.removeNodeFromContainer(node, mainFrame);
            }
        } catch (ActionExecutionException e) {
            DeployHelper.handleException(mainFrame, e, "Removing node failed");
        }
        performAction();
    }

    /**
     * <p>
     * The method actually undo the edit that was made. If any exception prevents redo/undo methods from completing
     * successfully, it should be log with logError.
     * </p>
     */
    public void undoAction() {
        if (isNeedPerform == false) {
            return;
        }
        diagramView.add(node);

        if (removeDiagramElementAction != null) {
            removeDiagramElementAction.undo();
            DeployHelper.addNodeToContainer(node, mainFrame);
        }
        if (removeModelElementAction != null) {
            removeModelElementAction.undo();
        }

        for (int i = removeEdgeActionList.size() - 1; i >= 0; i--) {
            removeEdgeActionList.get(i).undoAction();
        }

        mainFrame.updateDiagramView();

        DeployHelper.selectNode(diagramView.getViewer(), node);

        mainFrame.getDocumentTree().updateTree();
        DeployHelper.notifySelectionChanged(mainFrame, diagramView);
        node.requestFocus(true);
    }

    /**
     * <p>
     * The method actually redo the edit. If any exception prevents redo/undo methods from completing successfully, it
     * should be log with logError.
     * </p>
     */
    public void redoAction() {
        if (isNeedPerform == false) {
            return;
        }
        for (RemoveEdgeAction action : removeEdgeActionList) {
            action.redoAction();
        }
        if (removeModelElementAction != null) {
            removeModelElementAction.redo();
        }
        if (removeDiagramElementAction != null) {
            removeDiagramElementAction.redo();
            DeployHelper.removeNodeFromContainer(node, mainFrame);
        }
        performAction();
    }
}
