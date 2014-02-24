/*
 * Copyright (C) 2007 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.umltool.deploy.actions.undoable;

import com.topcoder.gui.diagramviewer.uml.usecaseelements.SubsystemNodeContainer;
import com.topcoder.uml.actions.model.usecase.RemoveSubsystemAction;
import com.topcoder.uml.model.modelmanagement.Subsystem;
import com.topcoder.umltool.deploy.DeployHelper;
import com.topcoder.umltool.deploy.MainFrame;

/**
 * <p>
 * This action is used for remove SubsystemNodeContainer from the diagram view.
 * </p>
 * @author ly, FireIce, ylouis
 * @version 1.0
 */
public class RemoveSubsystemNodeContainerAction extends RemoveNodeContainerAction {

    /**
     * <p>
     * Presentation name of this action.
     * </p>
     */
    private static final String PRESENTATION_NAME = "Remove SubsystemNodeContainer";

    /**
     * <p>
     * Creates an instance of RemoveSubsystemNodeContainerAction.
     * </p>
     * @param mainFrame
     *            reference to main frame
     * @param node
     *            node to remove
     */
    public RemoveSubsystemNodeContainerAction(MainFrame mainFrame, SubsystemNodeContainer node) {
        this(mainFrame, node, true);
    }

    /**
     * <p>
     * Creates an instance of RemoveSubsystemNodeContainerAction.
     * </p>
     * @param mainFrame
     *            reference to main frame
     * @param node
     *            node to remove
     * @param isComplete
     *            whether it is delete complete or only delete representation
     */
    public RemoveSubsystemNodeContainerAction(MainFrame mainFrame, SubsystemNodeContainer node, boolean isComplete) {
        super(PRESENTATION_NAME, mainFrame, node, isComplete ? createRemoveSubsystemAction(node) : null, isComplete);
    }

    /**
     * <p>
     * Creates an instance of RemoveSubsystemAction.
     * </p>
     * @param edge
     *            edge to remove
     * @return an an instance of RemoveSubsystemAction
     */
    private static RemoveSubsystemAction createRemoveSubsystemAction(SubsystemNodeContainer node) {
        Subsystem subsystem = (Subsystem) DeployHelper.getElement(node.getGraphNode());
        return new RemoveSubsystemAction(subsystem);
    }
}
