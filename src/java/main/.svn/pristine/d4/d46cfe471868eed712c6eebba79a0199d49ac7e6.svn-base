/*
 * Copyright (C) 2007 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.umltool.deploy.actions.undoable;

import com.topcoder.gui.diagramviewer.uml.activityelements.ActionState;
import com.topcoder.umltool.deploy.DeployHelper;
import com.topcoder.umltool.deploy.MainFrame;

/**
 * <p>
 * This action is used for remove ActionState from the diagram view.
 * </p>
 * @author ly, FireIce, ylouis
 * @version 1.0
 */
public class RemoveActionStateAction extends RemoveNodeAction {

    /**
     * <p>
     * Presentation name of this action.
     * </p>
     */
    private static final String PRESENTATION_NAME = "Remove ActionState";

    /**
     * <p>
     * Creates an instance of RemoveActionStateAction.
     * </p>
     * @param mainFrame
     *            reference to main frame
     * @param node
     *            node to remove
     */
    public RemoveActionStateAction(MainFrame mainFrame, ActionState node) {
        this(mainFrame, node, true);
    }

    /**
     * <p>
     * Creates an instance of RemoveActionStateAction.
     * </p>
     * @param mainFrame
     *            reference to main frame
     * @param node
     *            node to remove *
     * @param isComplete
     *            whether it is delete complete or only delete representation
     */
    public RemoveActionStateAction(MainFrame mainFrame, ActionState node, boolean isComplete) {
        super(PRESENTATION_NAME, mainFrame, node, isComplete ? createRemoveActionStateAction(node) : null);
    }

    /**
     * <p>
     * Creates an instance of RemoveActionStateAction.
     * </p>
     * @param node
     *            node to remove
     * @return an an instance of RemoveActionStateAction
     */
    private static com.topcoder.uml.actions.model.activity.RemoveActionStateAction createRemoveActionStateAction(
            ActionState node) {
        com.topcoder.uml.model.activitygraphs.ActionState state = (com.topcoder.uml.model.activitygraphs.ActionState) DeployHelper
                .getElement(node.getGraphNode());
        return new com.topcoder.uml.actions.model.activity.RemoveActionStateAction(state);
    }
}
