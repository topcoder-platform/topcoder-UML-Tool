/*
 * Copyright (C) 2007 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.umltool.deploy.actions.undoable;

import java.awt.Component;

import com.topcoder.diagraminterchange.GraphEdge;
import com.topcoder.diagraminterchange.GraphNode;
import com.topcoder.gui.diagramviewer.DiagramView;
import com.topcoder.gui.diagramviewer.DiagramViewer;
import com.topcoder.gui.diagramviewer.edges.Edge;
import com.topcoder.uml.actions.general.UndoableAbstractAction;
import com.topcoder.umltool.deploy.DeployHelper;
import com.topcoder.umltool.deploy.MainFrame;
import com.topcoder.util.actionmanager.ActionExecutionException;
import com.topcoder.util.actionmanager.UndoableAction;

/**
 * <p>
 * This action is used for add sequence edges to the diagram view.
 * </p>
 * <p>
 * AddMessageAction and AddDiagramElementAction are used.
 * </p>
 * @author ly, FireIce, ylouis
 * @version 1.0
 */
public abstract class RemoveEdgeAction extends UndoableAbstractAction {

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
     * Start node of the adding sequence edge.
     * </p>
     */
    private GraphNode startGraphNode;

    /**
     * <p>
     * End node of the adding sequence edge.
     * </p>
     */
    private GraphNode endGraphNode;

    /**
     * <p>
     * Graph edges for created edges.
     * </p>
     */
    private GraphEdge graphEdge;

    /**
     * <p>
     * Created edge.
     * </p>
     */
    private Edge edge;

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
    private RemoveDiagramElementAction removeDiagramElementAction;

    /**
     * <p>
     * Initialize references in constructor and create object, graph node, ObjectNode.
     * </p>
     * @param presentationName
     *            the non null, non empty string representing the presentation name
     * @param mainFrame
     *            main frame window
     * @param edge
     *            edge to remove
     * @param removeModelElementAction
     *            action to remove model element
     */
    public RemoveEdgeAction(String presentationName, MainFrame mainFrame, Edge edge,
        UndoableAction removeModelElementAction) {
        super(presentationName);

        this.mainFrame = mainFrame;
        this.diagramView = (DiagramView) edge.getParent();
        this.edge = edge;
        this.removeModelElementAction = removeModelElementAction;

        graphEdge = edge.getGraphEdge();

        startGraphNode = (GraphNode) graphEdge.getAnchors().get(0).getGraphElement();
        endGraphNode = (GraphNode) graphEdge.getAnchors().get(1).getGraphElement();

        removeDiagramElementAction = new RemoveDiagramElementAction(diagramView.getDiagram(), graphEdge);
    }

    /**
     * <p>
     * Gets the create edge of the out direction.
     * </p>
     * @return the created sequence edge.
     */
    public Edge getEdge() {
        return edge;
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
     * Performs the removing action of sequence edge.
     * </p>
     */
    private void performAction() {
        mainFrame.getDocumentTree().updateTree();
        diagramView.remove(edge);

        // disconnect graph nodes and graph edges
        DeployHelper.removeEdgeBetweenNodes(graphEdge, startGraphNode, endGraphNode);

        mainFrame.updateDiagramView();

        // select diagram after edge is deleted
        DiagramViewer viewer = diagramView.getViewer();
        DeployHelper.clearSelected(viewer);
        viewer.addSelectedElement(diagramView);
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
            if (component == edge) {
                return true;
            }
        }
        return false;
    }

    /**
     * <p>
     * The method execute this auction.
     * </p>
     * @throws ActionExecutionException
     *             if any exception prevents this method from completing successfully
     */
    public void executeAction() throws ActionExecutionException {
        isNeedPerform = getIsNeedPerform();
        if (isNeedPerform == false) {
            return;
        }
        executeRemove();
    }

    /**
     * <p>
     * Removes the edge.
     * </p>
     * @throws ActionExecutionException
     *             if any exception prevents this method from completing successfully
     */
    protected void executeRemove() throws ActionExecutionException {
        if (removeModelElementAction != null) {
            removeModelElementAction.execute();
        }
        removeDiagramElementAction.execute();
        performAction();
    }

    /**
     * <p>
     * The method undo the edit that was made. If any exception prevents redo/undo methods from completing successfully,
     * it should be log with logError.
     * </p>
     */
    public void undoAction() {
        if (isNeedPerform == false) {
            return;
        }

        undoRemove();
    }

    /**
     * <p>
     * Undo the remove.
     * </p>
     */
    protected void undoRemove() {
        removeDiagramElementAction.undo();
        if (removeModelElementAction != null) {
            removeModelElementAction.undo();
        }

        // add back to diagram view
        diagramView.add(edge);
        diagramView.setComponentZOrder(edge, 0);

        // connect graph nodes and graph edges
        DeployHelper.connectEdgeWithNodes(graphEdge, startGraphNode, endGraphNode);

        mainFrame.updateDiagramView();
        mainFrame.getDocumentTree().updateTree();

        // select the edge
        DiagramViewer viewer = diagramView.getViewer();
        DeployHelper.clearSelected(viewer);
        viewer.addSelectedElement(edge);
        edge.notifySelected();

        DeployHelper.notifySelectionChanged(mainFrame, diagramView);
        edge.requestFocus(true);
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

        redoRemove();
    }

    /**
     * <p>
     * Redo the remove.
     * </p>
     */
    protected void redoRemove() {
        if (removeModelElementAction != null) {
            removeModelElementAction.redo();
        }
        removeDiagramElementAction.redo();
        performAction();
    }
}
