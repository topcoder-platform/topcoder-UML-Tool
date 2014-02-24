/*
 * Copyright (C) 2007 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.umltool.deploy.actions.undoable;

import com.topcoder.gui.diagramviewer.uml.activityelements.JoinNode;
import com.topcoder.uml.model.statemachines.Pseudostate;
import com.topcoder.umltool.deploy.DeployHelper;
import com.topcoder.umltool.deploy.MainFrame;

/**
 * <p>
 * This action is used for remove JoinNode from the diagram view.
 * </p>
 * @author ly, FireIce, ylouis
 * @version 1.0
 */
public class RemoveJoinNodeAction extends RemoveNodeAction {

    /**
     * <p>
     * Presentation name of this action.
     * </p>
     */
    private static final String PRESENTATION_NAME = "Remove JoinNode";

    /**
     * <p>
     * Creates an instance of RemoveJoinNodeAction.
     * </p>
     * @param mainFrame
     *            reference to main frame
     * @param node
     *            node to remove
     */
    public RemoveJoinNodeAction(MainFrame mainFrame, JoinNode node) {
        this(mainFrame, node, true);
    }

    /**
     * <p>
     * Creates an instance of RemoveJoinNodeAction.
     * </p>
     * @param mainFrame
     *            reference to main frame
     * @param node
     *            node to remove *
     * @param isComplete
     *            whether it is delete complete or only delete representation
     */
    public RemoveJoinNodeAction(MainFrame mainFrame, JoinNode node, boolean isComplete) {
        super(PRESENTATION_NAME, mainFrame, node, isComplete ? createRemoveJoinNodeAction(node) : null);
    }

    /**
     * <p>
     * Creates an instance of RemoveJoinNodeAction.
     * </p>
     * @param node
     *            node to remove
     * @return an an instance of RemoveJoinNodeAction
     */
    private static com.topcoder.uml.actions.model.activity.RemoveJoinNodeAction createRemoveJoinNodeAction(JoinNode node) {
        Pseudostate state = (Pseudostate) DeployHelper.getElement(node.getGraphNode());
        return new com.topcoder.uml.actions.model.activity.RemoveJoinNodeAction(state);
    }
}
