/*
 * Copyright (C) 2007 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.umltool.deploy.actions.undoable;

import com.topcoder.gui.diagramviewer.uml.activityelements.ObjectFlowNode;
import com.topcoder.uml.actions.model.activity.RemoveObjectFlowStateAction;
import com.topcoder.uml.model.activitygraphs.ObjectFlowState;
import com.topcoder.umltool.deploy.DeployHelper;
import com.topcoder.umltool.deploy.MainFrame;

/**
 * <p>
 * This action is used for remove ObjectFlowNode from the diagram view.
 * </p>
 * @author ly, FireIce, ylouis
 * @version 1.0
 */
public class RemoveObjectFlowNodeAction extends RemoveNodeAction {

    /**
     * <p>
     * Presentation name of this action.
     * </p>
     */
    private static final String PRESENTATION_NAME = "Remove ObjectFlowNode";

    /**
     * <p>
     * Creates an instance of RemoveObjectFlowNodeAction.
     * </p>
     * @param mainFrame
     *            reference to main frame
     * @param node
     *            node to remove
     */
    public RemoveObjectFlowNodeAction(MainFrame mainFrame, ObjectFlowNode node) {
        this(mainFrame, node, true);
    }

    /**
     * <p>
     * Creates an instance of RemoveObjectFlowNodeAction.
     * </p>
     * @param mainFrame
     *            reference to main frame
     * @param node
     *            node to remove
     * @param isComplete
     *            whether it is delete complete or only delete representation
     */
    public RemoveObjectFlowNodeAction(MainFrame mainFrame, ObjectFlowNode node, boolean isComplete) {
        super(PRESENTATION_NAME, mainFrame, node, isComplete ? createRemoveObjectFlowStateAction(node) : null);
    }

    /**
     * <p>
     * Creates an instance of RemoveObjectFlowStateAction.
     * </p>
     * @param node
     *            node to remove
     * @return an an instance of RemoveObjectFlowStateAction
     */
    private static RemoveObjectFlowStateAction createRemoveObjectFlowStateAction(ObjectFlowNode node) {
        ObjectFlowState state = (ObjectFlowState) DeployHelper.getElement(node.getGraphNode());
        return new com.topcoder.uml.actions.model.activity.RemoveObjectFlowStateAction(state);
    }
}
