/*
 * Copyright (C) 2007 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.umltool.deploy.actions.undoable;

import com.topcoder.gui.diagramviewer.uml.usecaseelements.ExtendEdge;
import com.topcoder.uml.actions.model.usecase.RemoveExtendAction;
import com.topcoder.uml.model.usecases.Extend;
import com.topcoder.umltool.deploy.DeployHelper;
import com.topcoder.umltool.deploy.MainFrame;

/**
 * <p>
 * This action is used for remove Extend Edge from the diagram view.
 * </p>
 * @author ly, FireIce, ylouis
 * @version 1.0
 */
public class RemoveExtendEdgeAction extends RemoveEdgeAction {

    /**
     * <p>
     * Presentation name of this action.
     * </p>
     */
    private static final String PRESENTATION_NAME = "Remove ExtendEdge";

    /**
     * <p>
     * Creates an instance of RemoveExtendEdgeAction.
     * </p>
     * @param mainFrame
     *            main frame window
     * @param edge
     *            edge to remove
     */
    public RemoveExtendEdgeAction(MainFrame mainFrame, ExtendEdge edge) {
        this(mainFrame, edge, true);
    }

    /**
     * <p>
     * Creates an instance of RemoveExtendEdgeAction.
     * </p>
     * @param mainFrame
     *            main frame window
     * @param edge
     *            edge to remove
     * @param isComplete
     *            whether it is delete complete or only delete representation
     */
    public RemoveExtendEdgeAction(MainFrame mainFrame, ExtendEdge edge, boolean isComplete) {
        super(PRESENTATION_NAME, mainFrame, edge, isComplete ? createRemoveExtendAction(edge) : null);
    }

    /**
     * <p>
     * Creates an instance of RemoveExtendAction.
     * </p>
     * @param edge
     *            edge to remove
     * @return an an instance of RemoveExtendAction
     */
    private static RemoveExtendAction createRemoveExtendAction(ExtendEdge edge) {
        Extend extend = (Extend) DeployHelper.getElement(edge.getGraphEdge());
        return new RemoveExtendAction(extend);
    }
}
