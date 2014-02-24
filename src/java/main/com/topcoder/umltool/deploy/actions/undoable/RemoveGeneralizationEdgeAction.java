/*
 * Copyright (C) 2007 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.umltool.deploy.actions.undoable;

import com.topcoder.gui.diagramviewer.uml.classedges.GeneralizationEdge;
import com.topcoder.uml.actions.model.classifiers.RemoveGeneralizationAction;
import com.topcoder.uml.model.core.relationships.Generalization;
import com.topcoder.umltool.deploy.DeployHelper;
import com.topcoder.umltool.deploy.MainFrame;

/**
 * <p>
 * This action is used for remove Generalization Edge from the diagram view.
 * </p>
 * @author TCSDEVELOPER
 * @version 1.0
 */
public class RemoveGeneralizationEdgeAction extends RemoveEdgeAction {

    /**
     * <p>
     * Presentation name of this action.
     * </p>
     */
    private static final String PRESENTATION_NAME = "Remove GeneralizationEdge";

    /**
     * <p>
     * Creates an instance of RemoveGeneralizationEdgeAction.
     * </p>
     * @param mainFrame
     *            main frame window
     * @param edge
     *            edge to remove
     */
    public RemoveGeneralizationEdgeAction(MainFrame mainFrame, GeneralizationEdge edge) {
        this(mainFrame, edge, true);
    }

    /**
     * <p>
     * Creates an instance of RemoveGeneralizationEdgeAction.
     * </p>
     * @param mainFrame
     *            main frame window
     * @param edge
     *            edge to remove
     * @param isComplete
     *            whether it is delete complete or only delete representation
     */
    public RemoveGeneralizationEdgeAction(MainFrame mainFrame, GeneralizationEdge edge, boolean isComplete) {
        super(PRESENTATION_NAME, mainFrame, edge, isComplete ? createRemoveGeneralizationAction(edge) : null);
    }

    /**
     * <p>
     * Creates an instance of RemoveGeneralizationAction.
     * </p>
     * @param edge
     *            edge to remove
     * @return an an instance of RemoveGeneralizationAction
     */
    private static RemoveGeneralizationAction createRemoveGeneralizationAction(GeneralizationEdge edge) {
        Generalization generalization = (Generalization) DeployHelper.getElement(edge.getGraphEdge());
        return new RemoveGeneralizationAction(generalization);
    }
}
