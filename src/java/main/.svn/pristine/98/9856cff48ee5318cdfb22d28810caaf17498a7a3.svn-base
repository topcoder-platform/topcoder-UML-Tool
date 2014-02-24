/*
 * Copyright (C) 2007 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.umltool.deploy.actions.undoable;

import com.topcoder.gui.diagramviewer.uml.classedges.AbstractionEdge;
import com.topcoder.uml.actions.model.classifiers.RemoveAbstractionAction;
import com.topcoder.uml.model.core.dependencies.Abstraction;
import com.topcoder.umltool.deploy.DeployHelper;
import com.topcoder.umltool.deploy.MainFrame;

/**
 * <p>
 * This action is used for remove Abstraction Edge from the diagram view.
 * </p>
 * @author TCSDEVELOPER
 * @version 1.0
 */
public class RemoveAbstractionEdgeAction extends RemoveEdgeAction {

    /**
     * <p>
     * Presentation name of this action.
     * </p>
     */
    private static final String PRESENTATION_NAME = "Remove AbstractionEdge";

    /**
     * <p>
     * Creates an instance of RemoveAbstractionEdgeAction.
     * </p>
     * @param mainFrame
     *            main frame window
     * @param edge
     *            edge to remove
     */
    public RemoveAbstractionEdgeAction(MainFrame mainFrame, AbstractionEdge edge) {
        this(mainFrame, edge, true);
    }

    /**
     * <p>
     * Creates an instance of RemoveAbstractionEdgeAction.
     * </p>
     * @param mainFrame
     *            main frame window
     * @param edge
     *            edge to remove
     * @param isComplete
     *            whether it is delete complete or only delete representation
     */
    public RemoveAbstractionEdgeAction(MainFrame mainFrame, AbstractionEdge edge, boolean isComplete) {
        super(PRESENTATION_NAME, mainFrame, edge, isComplete ? createRemoveAbstractionAction(edge) : null);
    }

    /**
     * <p>
     * Creates an instance of RemoveAbstractionAction.
     * </p>
     * @param edge
     *            edge to remove
     * @return an an instance of RemoveAbstractionAction
     */
    private static RemoveAbstractionAction createRemoveAbstractionAction(AbstractionEdge edge) {
        Abstraction abstraction = (Abstraction) DeployHelper.getElement(edge.getGraphEdge());
        return new RemoveAbstractionAction(abstraction);
    }
}
