/*
 * Copyright (C) 2007 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.umltool.deploy.actions.undoable;

import com.topcoder.gui.diagramviewer.DiagramView;
import com.topcoder.gui.diagramviewer.elements.Node;
import com.topcoder.gui.diagramviewer.elements.NodeContainer;
import com.topcoder.uml.actions.diagram.elements.AddDiagramElementAction;
import com.topcoder.umltool.deploy.DeployHelper;
import com.topcoder.umltool.deploy.MainFrame;
import com.topcoder.util.actionmanager.ActionExecutionException;
import com.topcoder.util.actionmanager.UndoableAction;

/**
 * <p>
 * This is the base class of all nodes' add action.
 * </p>
 * @author ly, FireIce, ylouis
 * @version 1.0
 */
public abstract class AddNodeAction extends GenerateNodeAction {

    /**
     * <p>
     * Represents the main frame window.
     * </p>
     */
    private MainFrame mainFrame;

    /**
     * <p>
     * Represents the diagram view where this node should be added.
     * </p>
     */
    private DiagramView diagramView;

    /**
     * <p>
     * Represents the node created.
     * </p>
     */
    private Node node;

    /**
     * <p>
     * Represents the NodeContainer which the new created node should add to.
     * </p>
     */
    private NodeContainer nodeContainer;

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
     * Creates an instance of <code>AddNodeAction</code>.
     * </p>
     * @param presentationName
     *            the non null, non empty string representing the presentation name
     * @param mainFrame
     *            main frame window
     * @param view
     *            diagram view which should contain the new node
     */
    public AddNodeAction(String presentationName, MainFrame mainFrame, DiagramView view) {
        this(presentationName, mainFrame, view, null);
    }

    /**
     * <p>
     * Creates an instance of <code>AddNodeAction</code>.
     * </p>
     * @param presentationName
     *            the non null, non empty string representing the presentation name
     * @param mainFrame
     *            main frame window
     * @param view
     *            diagram view which should contain the new node
     * @param nodeContainer
     *            the NodeContainer which the new node should add to
     */
    public AddNodeAction(String presentationName, MainFrame mainFrame, DiagramView view, NodeContainer nodeContainer) {
        super(presentationName);
        this.mainFrame = mainFrame;
        this.diagramView = view;
        this.nodeContainer = nodeContainer;
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
     * Gets the node container.
     * </p>
     * @return the node container
     */
    protected NodeContainer getNodeContainer() {
        return nodeContainer;
    }

    /**
     * <p>
     * Gets the node added.
     * </p>
     * @return the created Node instance
     */
    public Node getNode() {
        return node;
    }

    /**
     * <p>
     * Sets the node.
     * </p>
     * @param node
     *            node to set
     * @throws IllegalArgumentException
     *             if the argument is null
     */
    protected void setNode(Node node) {
        DeployHelper.checkNotNull(node, "node");
        this.node = node;
    }

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
     * Creates the model element for new node.
     * </p>
     */
    protected abstract void createModelElement();

    /**
     * <p>
     * Creates the graph node for new node.
     * </p>
     */
    protected abstract void createGraphNode();

    /**
     * <p>
     * Creates a new node.
     * </p>
     */
    protected abstract void createNode();

    /**
     * <p>
     * The method actually execute this auction.
     * </p>
     * @throws ActionExecutionException
     *             if any exception prevents this method from completing successfully
     */
    public void executeAction() throws ActionExecutionException {
        if (addModelElementAction != null) {
            addModelElementAction.execute();
        }
        if (addDiagramElementAction != null) {
            addDiagramElementAction.execute();
        }
        DeployHelper.nodeNotifyChange(node, "Node added to diagram", mainFrame);
        diagramView.add(node);
        if (nodeContainer != null) {
            nodeContainer.addNode(DeployHelper.BODY_COMPARTMENT, node);
            DeployHelper.updateZOrder(nodeContainer);
        }
        node.setComponentPopupMenu(mainFrame.getPopupMenu());
    }

    /**
     * <p>
     * The method actually undo the edit that was made. If any exception prevents redo/undo methods from completing
     * successfully, it should be log with logError.
     * </p>
     */
    public void undoAction() {
        mainFrame.getDocumentTree().updateTree();
        if (nodeContainer != null) {
            nodeContainer.removeNode(DeployHelper.BODY_COMPARTMENT, node);
        }
        diagramView.remove(node);
        if (addDiagramElementAction != null) {
            addDiagramElementAction.undo();
        }
        if (addModelElementAction != null) {
            addModelElementAction.undo();
        }
        mainFrame.updateDiagramView();
        mainFrame.getDocumentTree().updateTree();
    }

    /**
     * <p>
     * The method actually redo the edit. If any exception prevents redo/undo methods from completing successfully, it
     * should be log with logError.
     * </p>
     */
    public void redoAction() {
        if (addModelElementAction != null) {
            addModelElementAction.redo();
        }
        if (addDiagramElementAction != null) {
            addDiagramElementAction.redo();
        }
        diagramView.add(node);
        if (nodeContainer != null) {
            nodeContainer.addNode(DeployHelper.BODY_COMPARTMENT, node);
            DeployHelper.updateZOrder(nodeContainer);
        }
        mainFrame.updateDiagramView();
        mainFrame.getDocumentTree().updateTree();
    }

}
