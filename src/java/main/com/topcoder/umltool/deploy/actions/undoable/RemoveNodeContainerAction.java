/*
 * Copyright (C) 2007 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.umltool.deploy.actions.undoable;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import javax.swing.JComponent;

import com.topcoder.gui.diagramviewer.elements.Node;
import com.topcoder.gui.diagramviewer.elements.NodeContainer;
import com.topcoder.uml.model.core.ModelElement;
import com.topcoder.uml.model.core.Namespace;
import com.topcoder.umltool.deploy.DeployHelper;
import com.topcoder.umltool.deploy.MainFrame;
import com.topcoder.util.actionmanager.ActionExecutionException;
import com.topcoder.util.actionmanager.UndoableAction;

/**
 * <p>
 * This action is used for remove a NodeContainer from the diagram view.
 * </p>
 * @author ly, FireIce, ylouis
 * @version 1.0
 */
public class RemoveNodeContainerAction extends RemoveNodeAction {
    /**
     * <p>
     * Actions to remove the contained nodes.
     * </p>
     */
    private List<RemoveNodeAction> removeNodeActionList;

    /**
     * <p>
     * Creates an instance of RemoveNodeContainerAction.
     * </p>
     * @param presentationName
     *            the non null, non empty string representing the presentation name
     * @param mainFrame
     *            reference to main frame
     * @param node
     *            node to remove
     * @param removeModelElementAction
     *            action to remove model element
     * @param isComplete
     *            whether it is delete complete or only delete representation
     */
    public RemoveNodeContainerAction(String presentationName, MainFrame mainFrame, NodeContainer node,
        UndoableAction removeModelElementAction, boolean isComplete) {
        super(presentationName, mainFrame, node, removeModelElementAction);
        createRemoveNodeActions(isComplete);
    }

    /**
     * <p>
     * Creates the actions for removing contained nodes.
     * </p> *
     * @param isComplete
     *            whether it is delete complete or only delete representation
     */
    void createRemoveNodeActions(boolean isComplete) {
        removeNodeActionList = new ArrayList<RemoveNodeAction>();
        NodeContainer nodeContainer = (NodeContainer) getNode();
        Set<Node> set = DeployHelper.getNodes(nodeContainer);
        for (Node node : set) {
            removeNodeActionList.add(DeployHelper.createRemoveNodeAction(node, getMainFrame(), isComplete));
        }

        // Remove contained model elements
        if (isComplete) {
            Namespace owner = (Namespace) DeployHelper.getElement(nodeContainer);
            MainFrame mainFrame = getMainFrame();
            for (ModelElement element : owner.getOwnedElements()) {
                List<JComponent> components = DeployHelper.getComponent(element, mainFrame);
                for (JComponent component : components) {
                    if (component instanceof Node) {
                        if (!nodeContainer.getNodes().contains(component)) {
                            removeNodeActionList.add(DeployHelper.createRemoveNodeAction((Node) component, mainFrame,
                                    isComplete));
                        }
                    }
                }
            }
        }
    }

    /**
     * <p>
     * The method actually execute this auction.
     * </p>
     * @throws ActionExecutionException
     *             if any exception prevents this method from completing successfully
     */
    public void executeAction() throws ActionExecutionException {
        for (RemoveNodeAction action : removeNodeActionList) {
            action.executeAction();
        }
        super.executeAction();
    }

    /**
     * <p>
     * The method actually undo the edit that was made. If any exception prevents redo/undo methods from completing
     * successfully, it should be log with logError.
     * </p>
     */
    public void undoAction() {
        super.undoAction();

        for (int i = removeNodeActionList.size() - 1; i >= 0; i--) {
            removeNodeActionList.get(i).undoAction();
        }

        DeployHelper.updateZOrder((NodeContainer) getNode());
    }

    /**
     * <p>
     * The method actually redo the edit. If any exception prevents redo/undo methods from completing successfully, it
     * should be log with logError.
     * </p>
     */
    public void redoAction() {
        for (RemoveNodeAction action : removeNodeActionList) {
            action.redoAction();
        }
        super.redoAction();
    }
}
