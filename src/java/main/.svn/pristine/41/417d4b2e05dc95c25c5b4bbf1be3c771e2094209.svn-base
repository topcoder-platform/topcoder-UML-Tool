/*
 * Copyright (C) 2007 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.umltool.deploy.actions.undoable;

import com.topcoder.gui.diagramviewer.uml.usecaseelements.IncludeEdge;
import com.topcoder.uml.actions.model.usecase.RemoveIncludeAction;
import com.topcoder.uml.model.usecases.Include;
import com.topcoder.umltool.deploy.DeployHelper;
import com.topcoder.umltool.deploy.MainFrame;

/**
 * <p>
 * This action is used for remove Include Edge from the diagram view.
 * </p>
 * @author TCSDEVELOPER
 * @version 1.0
 */
public class RemoveIncludeEdgeAction extends RemoveEdgeAction {

    /**
     * <p>
     * Presentation name of this action.
     * </p>
     */
    private static final String PRESENTATION_NAME = "Remove IncludeEdge";

    /**
     * <p>
     * Creates an instance of RemoveIncludeEdgeAction.
     * </p>
     * @param mainFrame
     *            main frame window
     * @param edge
     *            edge to remove
     */
    public RemoveIncludeEdgeAction(MainFrame mainFrame, IncludeEdge edge) {
        this(mainFrame, edge, true);
    }

    /**
     * <p>
     * Creates an instance of RemoveIncludeEdgeAction.
     * </p>
     * @param mainFrame
     *            main frame window
     * @param edge
     *            edge to remove
     * @param isComplete
     *            whether it is delete complete or only delete representation
     */
    public RemoveIncludeEdgeAction(MainFrame mainFrame, IncludeEdge edge, boolean isComplete) {
        super(PRESENTATION_NAME, mainFrame, edge, isComplete ? createRemoveIncludeAction(edge) : null);
    }

    /**
     * <p>
     * Creates an instance of RemoveIncludeAction.
     * </p>
     * @param edge
     *            edge to remove
     * @return an an instance of RemoveIncludeAction
     */
    private static RemoveIncludeAction createRemoveIncludeAction(IncludeEdge edge) {
        Include include = (Include) DeployHelper.getElement(edge.getGraphEdge());
        return new RemoveIncludeAction(include);
    }
}
