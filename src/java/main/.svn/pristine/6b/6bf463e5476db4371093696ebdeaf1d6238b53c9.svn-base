/*
 * Copyright (C) 2007 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.umltool.deploy.actions.undoable;

import com.topcoder.gui.diagramviewer.uml.activityelements.Transition;
import com.topcoder.umltool.deploy.DeployHelper;
import com.topcoder.umltool.deploy.MainFrame;

/**
 * <p>
 * This action is used for remove Transition from the diagram view.
 * </p>
 * @author ly, FireIce, ylouis
 * @version 1.0
 */
public class RemoveTransitionAction extends RemoveEdgeAction {

    /**
     * <p>
     * Presentation name of this action.
     * </p>
     */
    private static final String PRESENTATION_NAME = "Remove Transition";

    /**
     * <p>
     * Creates an instance of RemoveTransitionAction.
     * </p>
     * @param mainFrame
     *            main frame window
     * @param edge
     *            edge to remove
     */
    public RemoveTransitionAction(MainFrame mainFrame, Transition edge) {
        this(mainFrame, edge, true);
    }

    /**
     * <p>
     * Creates an instance of RemoveTransitionAction.
     * </p>
     * @param mainFrame
     *            main frame window
     * @param edge
     *            edge to remove
     * @param isComplete
     *            whether it is delete complete or only delete representation
     */
    public RemoveTransitionAction(MainFrame mainFrame, Transition edge, boolean isComplete) {
        super(PRESENTATION_NAME, mainFrame, edge, isComplete ? createRemoveTransitionAction(edge) : null);
    }

    /**
     * <p>
     * Creates an instance of RemoveTransitionAction.
     * </p>
     * @param edge
     *            edge to remove
     * @return an an instance of RemoveTransitionAction
     */
    private static com.topcoder.uml.actions.model.activity.RemoveTransitionAction createRemoveTransitionAction(
            Transition edge) {
        com.topcoder.uml.model.statemachines.Transition transition = (com.topcoder.uml.model.statemachines.Transition) DeployHelper
                .getElement(edge.getGraphEdge());
        return new com.topcoder.uml.actions.model.activity.RemoveTransitionAction(transition);
    }
}
