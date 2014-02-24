/*
 * Copyright (C) 2007 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.umltool.deploy.actions.undoable;

import com.topcoder.gui.diagramviewer.uml.classedges.DependencyEdge;
import com.topcoder.uml.actions.model.classifiers.RemoveDependencyAction;
import com.topcoder.uml.model.core.dependencies.Dependency;
import com.topcoder.umltool.deploy.DeployHelper;
import com.topcoder.umltool.deploy.MainFrame;

/**
 * <p>
 * This action is used for remove Dependency Edge from the diagram view.
 * </p>
 * @author ly, FireIce, ylouis
 * @version 1.0
 */
public class RemoveDependencyEdgeAction extends RemoveEdgeAction {

    /**
     * <p>
     * Presentation name of this action.
     * </p>
     */
    private static final String PRESENTATION_NAME = "Remove DependencyEdge";

    /**
     * <p>
     * Creates an instance of RemoveDependencyEdgeAction.
     * </p>
     * @param mainFrame
     *            main frame window
     * @param edge
     *            edge to remove
     */
    public RemoveDependencyEdgeAction(MainFrame mainFrame, DependencyEdge edge) {
        this(mainFrame, edge, true);
    }

    /**
     * <p>
     * Creates an instance of RemoveDependencyEdgeAction.
     * </p>
     * @param mainFrame
     *            main frame window
     * @param edge
     *            edge to remove
     * @param isComplete
     *            whether it is delete complete or only delete representation
     */
    public RemoveDependencyEdgeAction(MainFrame mainFrame, DependencyEdge edge, boolean isComplete) {
        super(PRESENTATION_NAME, mainFrame, edge, isComplete ? createRemoveDependencyAction(edge) : null);
    }

    /**
     * <p>
     * Creates an instance of RemoveDependencyAction.
     * </p>
     * @param edge
     *            edge to remove
     * @return an an instance of RemoveDependencyAction
     */
    private static RemoveDependencyAction createRemoveDependencyAction(DependencyEdge edge) {
        Dependency dependency = (Dependency) DeployHelper.getElement(edge.getGraphEdge());
        return new RemoveDependencyAction(dependency);
    }
}
