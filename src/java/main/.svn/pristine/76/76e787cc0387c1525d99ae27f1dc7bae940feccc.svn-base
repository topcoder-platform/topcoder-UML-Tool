/*
 * Copyright (C) 2007 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.umltool.deploy.actions.undoable;

import com.topcoder.gui.diagramviewer.uml.activityelements.DecisionNode;
import com.topcoder.uml.model.statemachines.Pseudostate;
import com.topcoder.umltool.deploy.DeployHelper;
import com.topcoder.umltool.deploy.MainFrame;

/**
 * <p>
 * This action is used for remove DecisionNode from the diagram view.
 * </p>
 * @author ly, FireIce, ylouis
 * @version 1.0
 */
public class RemoveDecisionNodeAction extends RemoveNodeAction {

    /**
     * <p>
     * Presentation name of this action.
     * </p>
     */
    private static final String PRESENTATION_NAME = "Remove DecisionNode";

    /**
     * <p>
     * Creates an instance of RemoveDecisionNodeAction.
     * </p>
     * @param mainFrame
     *            reference to main frame
     * @param node
     *            node to remove
     */
    public RemoveDecisionNodeAction(MainFrame mainFrame, DecisionNode node) {
        this(mainFrame, node, true);
    }

    /**
     * <p>
     * Creates an instance of RemoveDecisionNodeAction.
     * </p>
     * @param mainFrame
     *            reference to main frame
     * @param node
     *            node to remove *
     * @param isComplete
     *            whether it is delete complete or only delete representation
     */
    public RemoveDecisionNodeAction(MainFrame mainFrame, DecisionNode node, boolean isComplete) {
        super(PRESENTATION_NAME, mainFrame, node, isComplete ? createRemoveDecisionNodeAction(node) : null);
    }

    /**
     * <p>
     * Creates an instance of RemoveDecisionNodeAction.
     * </p>
     * @param node
     *            node to remove
     * @return an an instance of RemoveDecisionNodeAction
     */
    private static com.topcoder.uml.actions.model.activity.RemoveDecisionNodeAction createRemoveDecisionNodeAction(
            DecisionNode node) {
        Pseudostate state = (Pseudostate) DeployHelper.getElement(node.getGraphNode());
        return new com.topcoder.uml.actions.model.activity.RemoveDecisionNodeAction(state);
    }
}
