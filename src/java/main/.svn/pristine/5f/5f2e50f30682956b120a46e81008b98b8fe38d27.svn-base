/*
 * Copyright (C) 2007 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.umltool.deploy.actions.undoable;

import com.topcoder.gui.diagramviewer.uml.activityelements.MergeNode;
import com.topcoder.uml.model.statemachines.Pseudostate;
import com.topcoder.umltool.deploy.DeployHelper;
import com.topcoder.umltool.deploy.MainFrame;

/**
 * <p>
 * This action is used for remove MergeNode from the diagram view.
 * </p>
 * @author ly, FireIce, ylouis
 * @version 1.0
 */
public class RemoveMergeNodeAction extends RemoveNodeAction {

    /**
     * <p>
     * Presentation name of this action.
     * </p>
     */
    private static final String PRESENTATION_NAME = "Remove MergeNode";

    /**
     * <p>
     * Creates an instance of RemoveMergeNodeAction.
     * </p>
     * @param mainFrame
     *            reference to main frame
     * @param node
     *            node to remove
     */
    public RemoveMergeNodeAction(MainFrame mainFrame, MergeNode node) {
        this(mainFrame, node, true);
    }

    /**
     * <p>
     * Creates an instance of RemoveMergeNodeAction.
     * </p>
     * @param mainFrame
     *            reference to main frame
     * @param node
     *            node to remove
     * @param isComplete
     *            whether it is delete complete or only delete representation
     */
    public RemoveMergeNodeAction(MainFrame mainFrame, MergeNode node, boolean isComplete) {
        super(PRESENTATION_NAME, mainFrame, node, isComplete ? createRemoveMergeNodeAction(node) : null);
    }

    /**
     * <p>
     * Creates an instance of RemoveMergeNodeAction.
     * </p>
     * @param node
     *            node to remove
     * @return an an instance of RemoveMergeNodeAction
     */
    private static com.topcoder.uml.actions.model.activity.RemoveMergeNodeAction createRemoveMergeNodeAction(
            MergeNode node) {
        Pseudostate state = (Pseudostate) DeployHelper.getElement(node.getGraphNode());
        return new com.topcoder.uml.actions.model.activity.RemoveMergeNodeAction(state);
    }
}
