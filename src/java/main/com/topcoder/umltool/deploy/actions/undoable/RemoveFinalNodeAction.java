/*
 * Copyright (C) 2007 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.umltool.deploy.actions.undoable;

import com.topcoder.gui.diagramviewer.uml.activityelements.FinalNode;
import com.topcoder.uml.model.statemachines.FinalState;
import com.topcoder.umltool.deploy.DeployHelper;
import com.topcoder.umltool.deploy.MainFrame;

/**
 * <p>
 * This action is used for remove FinalNode from the diagram view.
 * </p>
 * @author ly, FireIce, ylouis
 * @version 1.0
 */
public class RemoveFinalNodeAction extends RemoveNodeAction {

    /**
     * <p>
     * Presentation name of this action.
     * </p>
     */
    private static final String PRESENTATION_NAME = "Remove FinalNode";

    /**
     * <p>
     * Creates an instance of RemoveFinalNodeAction.
     * </p>
     * @param mainFrame
     *            reference to main frame
     * @param node
     *            node to remove
     */
    public RemoveFinalNodeAction(MainFrame mainFrame, FinalNode node) {
        this(mainFrame, node, true);
    }

    /**
     * <p>
     * Creates an instance of RemoveFinalNodeAction.
     * </p>
     * @param mainFrame
     *            reference to main frame
     * @param node
     *            node to remove
     * @param isComplete
     *            whether it is delete complete or only delete representation
     */
    public RemoveFinalNodeAction(MainFrame mainFrame, FinalNode node, boolean isComplete) {
        super(PRESENTATION_NAME, mainFrame, node, isComplete ? createRemoveFinalNodeAction(node) : null);
    }

    /**
     * <p>
     * Creates an instance of RemoveFinalNodeAction.
     * </p>
     * @param node
     *            node to remove
     * @return an an instance of RemoveFinalNodeAction
     */
    private static com.topcoder.uml.actions.model.activity.RemoveFinalNodeAction createRemoveFinalNodeAction(
            FinalNode node) {
        FinalState state = (FinalState) DeployHelper.getElement(node.getGraphNode());
        return new com.topcoder.uml.actions.model.activity.RemoveFinalNodeAction(state);
    }
}
