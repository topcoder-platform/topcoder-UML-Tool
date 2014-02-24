/*
 * Copyright (C) 2007 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.umltool.deploy.actions.undoable;

import com.topcoder.gui.diagramviewer.uml.classedges.AssociationEdge;
import com.topcoder.uml.actions.model.classifiers.RemoveAssociationAction;
import com.topcoder.uml.model.core.relationships.Association;
import com.topcoder.umltool.deploy.DeployHelper;
import com.topcoder.umltool.deploy.MainFrame;

/**
 * <p>
 * This action is used for remove Association Edge from the diagram view.
 * </p>
 * @author ly, FireIce, ylouis
 * @version 1.0
 */
public class RemoveAssociationEdgeAction extends RemoveEdgeAction {

    /**
     * <p>
     * Presentation name of this action.
     * </p>
     */
    private static final String PRESENTATION_NAME = "Remove AssociationEdge";

    /**
     * <p>
     * Creates an instance of RemoveAssociationEdgeAction.
     * </p>
     * @param mainFrame
     *            main frame window
     * @param edge
     *            edge to remove
     */
    public RemoveAssociationEdgeAction(MainFrame mainFrame, AssociationEdge edge) {
        this(mainFrame, edge, true);
    }

    /**
     * <p>
     * Creates an instance of RemoveAssociationEdgeAction.
     * </p>
     * @param mainFrame
     *            main frame window
     * @param edge
     *            edge to remove
     * @param isComplete
     *            whether it is delete complete or only delete representation
     */
    public RemoveAssociationEdgeAction(MainFrame mainFrame, AssociationEdge edge, boolean isComplete) {
        super(PRESENTATION_NAME, mainFrame, edge, isComplete ? createRemoveAssociationAction(edge) : null);
    }

    /**
     * <p>
     * Creates an instance of RemoveAssociationAction.
     * </p>
     * @param edge
     *            edge to remove
     * @return an an instance of RemoveAssociationAction
     */
    private static RemoveAssociationAction createRemoveAssociationAction(AssociationEdge edge) {
        Association association = (Association) DeployHelper.getElement(edge.getGraphEdge());
        return new RemoveAssociationAction(association);
    }
}
