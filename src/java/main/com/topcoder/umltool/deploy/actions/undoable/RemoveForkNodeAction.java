/*
 * Copyright (C) 2007 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.umltool.deploy.actions.undoable;

import com.topcoder.gui.diagramviewer.uml.activityelements.ForkNode;
import com.topcoder.uml.model.statemachines.Pseudostate;
import com.topcoder.umltool.deploy.DeployHelper;
import com.topcoder.umltool.deploy.MainFrame;

/**
 * <p>
 * This action is used for remove ForkNode from the diagram view.
 * </p>
 * @author ly, FireIce, ylouis
 * @version 1.0
 */
public class RemoveForkNodeAction extends RemoveNodeAction {

    /**
     * <p>
     * Presentation name of this action.
     * </p>
     */
    private static final String PRESENTATION_NAME = "Remove ForkNode";

    /**
     * <p>
     * Creates an instance of RemoveForkNodeAction.
     * </p>
     * @param mainFrame
     *            reference to main frame
     * @param node
     *            node to remove
     */
    public RemoveForkNodeAction(MainFrame mainFrame, ForkNode node) {
        this(mainFrame, node, true);
    }

    /**
     * <p>
     * Creates an instance of RemoveForkNodeAction.
     * </p>
     * @param mainFrame
     *            reference to main frame
     * @param node
     *            node to remove *
     * @param isComplete
     *            whether it is delete complete or only delete representation
     */
    public RemoveForkNodeAction(MainFrame mainFrame, ForkNode node, boolean isComplete) {
        super(PRESENTATION_NAME, mainFrame, node, isComplete ? createRemoveForkNodeAction(node) : null);
    }

    /**
     * <p>
     * Creates an instance of RemoveForkNodeAction.
     * </p>
     * @param node
     *            node to remove
     * @return an an instance of RemoveForkNodeAction
     */
    private static com.topcoder.uml.actions.model.activity.RemoveForkNodeAction createRemoveForkNodeAction(ForkNode node) {
        Pseudostate state = (Pseudostate) DeployHelper.getElement(node.getGraphNode());
        return new com.topcoder.uml.actions.model.activity.RemoveForkNodeAction(state);
    }
}
