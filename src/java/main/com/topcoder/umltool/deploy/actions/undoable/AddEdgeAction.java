/*
 * Copyright (C) 2007 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.umltool.deploy.actions.undoable;

import com.topcoder.gui.diagramviewer.DiagramView;
import com.topcoder.gui.diagramviewer.edges.Edge;
import com.topcoder.gui.diagramviewer.elements.Node;
import com.topcoder.uml.actions.diagram.elements.AddDiagramElementAction;
import com.topcoder.umltool.deploy.DeployHelper;
import com.topcoder.umltool.deploy.MainFrame;
import com.topcoder.util.actionmanager.ActionExecutionException;
import com.topcoder.util.actionmanager.UndoableAction;

/**
 * <p>
 * This is the base class of all edges' add action.
 * </p>
 * @author ly, FireIce, ylouis, TCSDEVELOPER
 * @version 1.0
 */
public abstract class AddEdgeAction extends GenerateNodeAction {
    /**
     * <p>
     * Represents the main frame window.
     * </p>
     */
    private MainFrame mainFrame;

    /**
     * <p>
     * Represents the diagram view where this edge should be added.
     * </p>
     */
    private DiagramView diagramView;

    /**
     * <p>
     * Start node of this edge.
     * </p>
     */
    private Node startNode;

    /**
     * <p>
     * Target node of this edge.
     * </p>
     */
    private Node targetNode;

    /**
     * <p>
     * Represents the edge created.
     * </p>
     */
    private Edge edge;

    /**
     * <p>
     * This action is used to create the target node if it is not null.
     * </p>
     */
    private AddNodeAction addNodeAction;

    /**
     * <p>
     * This action is used to add the model element to uml model manager.
     * </p>
     */
    private UndoableAction addModelElementAction;

    /**
     * <p>
     * This action is used to add the graph node to diagram.
     * </p>
     */
    private AddDiagramElementAction addDiagramElementAction;

    /**
     * <p>
     * Creates an instance of <code>AddGeneralizationEdgeAction</code>.
     * </p>
     * @param presentationName
     *            the non null, non empty string representing the presentation name
     * @param mainFrame
     *            main frame window
     * @param view
     *            diagram view which should contain the new edge
     * @param startNode
     *            start node of the added edge
     * @param targetNode
     *            target node of the added edge
     */
    public AddEdgeAction(String presentationName, MainFrame mainFrame, DiagramView view, Node startNode, Node targetNode) {
        super(presentationName);
        this.mainFrame = mainFrame;
        this.diagramView = view;
        this.startNode = startNode;
        this.targetNode = targetNode;
    }

    /**
     * <p>
     * Creates an instance of <code>AddDependencyEdgeAction</code>.
     * </p>
     * @param presentationName
     *            the non null, non empty string representing the presentation name
     * @param mainFrame
     *            main frame window
     * @param view
     *            diagram view which should contain the new edge
     * @param startNode
     *            start node of the added edge
     * @param addNodeAction
     *            action to create the target node
     */
    public AddEdgeAction(String presentationName, MainFrame mainFrame, DiagramView view, Node startNode,
        AddNodeAction addNodeAction) {
        this(presentationName, mainFrame, view, startNode, (Node) null);
        this.addNodeAction = addNodeAction;
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
     * Gets the diagram view.
     * </p>
     * @return the diagram view
     */
    protected DiagramView getDiagramView() {
        return diagramView;
    }

    /**
     * <p>
     * Gets the start node.
     * </p>
     * @return the start node
     */
    public Node getStartNode() {
        return startNode;
    }

    /**
     * <p>
     * Gets the target node.
     * </p>
     * @return the target node
     */
    public Node getTargetNode() {
        return targetNode;
    }

    /**
     * <p>
     * Gets the generated node.
     * </p>
     * @return the generated node
     */
    public Node getNode() {
        if (addNodeAction != null) {
            return targetNode;
        }
        return null;
    }

    /**
     * <p>
     * Gets the new created edge.
     * </p>
     * @return the new created edge
     */
    public Edge getEdge() {
        return edge;
    }

    /**
     * <p>
     * Sets the edge.
     * </p>
     * @param edge
     *            edge to set
     * @throws IllegalArgumentException
     *             if the argument is null
     */
    protected void setEdge(Edge edge) {
        DeployHelper.checkNotNull(edge, "edge");
        this.edge = edge;
    }

    /**
     * <p>
     * Creates the model element for new edge.
     * </p>
     */
    protected abstract void createModelElement();

    /**
     * <p>
     * Creates the graph edge for new edge.
     * </p>
     */
    protected abstract void createGraphEdge();

    /**
     * <p>
     * Creates a new edge.
     * </p>
     */
    protected abstract void createEdge();

    /**
     * <p>
     * Sets the action to add model element.
     * </p>
     * @param addModelElementAction
     *            action to add model element
     * @throws IllegalArgumentException
     *             if the argument is null
     */
    protected void setAddModelElementAction(UndoableAction addModelElementAction) {
        DeployHelper.checkNotNull(addModelElementAction, "addModelElementAction");
        this.addModelElementAction = addModelElementAction;
    }

    /**
     * <p>
     * Sets the action to add diagram element.
     * </p>
     * @param addDiagramElementAction
     *            action to add diagram element
     * @throws IllegalArgumentException
     *             if the argument is null
     */
    protected void setAddDiagramElementAction(AddDiagramElementAction addDiagramElementAction) {
        DeployHelper.checkNotNull(addDiagramElementAction, "addDiagramElementAction");
        this.addDiagramElementAction = addDiagramElementAction;
    }

    /**
     * <p>
     * The method actually execute this auction.
     * </p>
     * @throws ActionExecutionException
     *             if any exception prevents this method from completing successfully
     */
    public void executeAction() throws ActionExecutionException {
        try {
            if (addNodeAction != null) {
                addNodeAction.execute();
                targetNode = addNodeAction.getNode();
            }
            createModelElement();
            createGraphEdge();
            createEdge();
            if (addModelElementAction != null) {
                addModelElementAction.execute();
            }
            addDiagramElementAction.execute();
        } catch (ActionExecutionException e) {
            DeployHelper.handleException(mainFrame, e, "Adding Edge failed.");
        }
        diagramView.add(edge);
        diagramView.setComponentZOrder(edge, 0);
    }

    /**
     * <p>
     * The method actually undo the edit that was made. If any exception prevents redo/undo methods from completing
     * successfully, it should be log with logError.
     * </p>
     */
    public void undoAction() {
        mainFrame.getDocumentTree().updateTree();
        diagramView.remove(edge);
        addDiagramElementAction.undo();
        if (addModelElementAction != null) {
            addModelElementAction.undo();
        }
        DeployHelper.removeEdgeBetweenNodes(edge.getGraphEdge(), startNode.getGraphNode(), targetNode.getGraphNode());
        if (addNodeAction != null) {
            addNodeAction.undo();
        }
        mainFrame.updateDiagramView();
    }

    /**
     * <p>
     * The method actually redo the edit. If any exception prevents redo/undo methods from completing successfully, it
     * should be log with logError.
     * </p>
     */
    public void redoAction() {
        if (addNodeAction != null) {
            addNodeAction.redo();
        }
        DeployHelper.connectEdgeWithNodes(edge.getGraphEdge(), startNode.getGraphNode(), targetNode.getGraphNode());
        if (addModelElementAction != null) {
            addModelElementAction.redo();
        }
        addDiagramElementAction.redo();
        diagramView.add(edge);
        diagramView.setComponentZOrder(edge, 0);
        mainFrame.updateDiagramView();
        mainFrame.getDocumentTree().updateTree();
    }
}
