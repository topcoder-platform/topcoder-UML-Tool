/*
 * Copyright (C) 2007 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.umltool.deploy.actions.undoable;

import com.topcoder.gui.diagramviewer.uml.activityelements.FlowFinalNode;
import com.topcoder.uml.model.statemachines.FinalState;
import com.topcoder.umltool.deploy.DeployHelper;
import com.topcoder.umltool.deploy.MainFrame;

/**
 * <p>
 * This action is used for remove FlowFinalNode from the diagram view.
 * </p>
 * @author ly, FireIce, ylouis
 * @version 1.0
 */
public class RemoveFlowFinalNodeAction extends RemoveNodeAction {

    /**
     * <p>
     * Presentation name of this action.
     * </p>
     */
    private static final String PRESENTATION_NAME = "Remove FlowFinalNode";

    /**
     * <p>
     * Creates an instance of RemoveFlowFinalNodeAction.
     * </p>
     * @param mainFrame
     *            reference to main frame
     * @param node
     *            node to remove
     */
    public RemoveFlowFinalNodeAction(MainFrame mainFrame, FlowFinalNode node) {
        this(mainFrame, node, true);
    }

    /**
     * <p>
     * Creates an instance of RemoveFlowFinalNodeAction.
     * </p>
     * @param mainFrame
     *            reference to main frame
     * @param node
     *            node to remove
     * @param isComplete
     *            whether it is delete complete or only delete representation
     */
    public RemoveFlowFinalNodeAction(MainFrame mainFrame, FlowFinalNode node, boolean isComplete) {
        super(PRESENTATION_NAME, mainFrame, node, isComplete ? createRemoveFlowFinalNodeAction(node) : null);
    }

    /**
     * <p>
     * Creates an instance of RemoveFlowFinalNodeAction.
     * </p>
     * @param node
     *            node to remove
     * @return an an instance of RemoveFlowFinalNodeAction
     */
    private static com.topcoder.uml.actions.model.activity.RemoveFlowFinalNodeAction createRemoveFlowFinalNodeAction(
            FlowFinalNode node) {
        FinalState state = (FinalState) DeployHelper.getElement(node.getGraphNode());
        return new com.topcoder.uml.actions.model.activity.RemoveFlowFinalNodeAction(state);
    }
}
