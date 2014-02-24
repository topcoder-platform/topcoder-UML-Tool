/*
 * Copyright (C) 2007 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.umltool.deploy.actions.undoable;

import com.topcoder.gui.diagramviewer.uml.usecaseelements.UseCaseNode;
import com.topcoder.uml.actions.model.usecase.RemoveUseCaseAction;
import com.topcoder.uml.model.usecases.UseCase;
import com.topcoder.umltool.deploy.DeployHelper;
import com.topcoder.umltool.deploy.MainFrame;

/**
 * <p>
 * This action is used for remove UseCaseNode from the diagram view.
 * </p>
 * @author ly, FireIce, ylouis
 * @version 1.0
 */
public class RemoveUseCaseNodeAction extends RemoveNodeAction {

    /**
     * <p>
     * Presentation name of this action.
     * </p>
     */
    private static final String PRESENTATION_NAME = "Remove UseCaseNode";

    /**
     * <p>
     * Creates an instance of RemoveUseCaseNodeAction.
     * </p>
     * @param mainFrame
     *            reference to main frame
     * @param node
     *            node to remove
     */
    public RemoveUseCaseNodeAction(MainFrame mainFrame, UseCaseNode node) {
        this(mainFrame, node, true);
    }

    /**
     * <p>
     * Creates an instance of RemoveUseCaseNodeAction.
     * </p>
     * @param mainFrame
     *            reference to main frame
     * @param node
     *            node to remove
     * @param isComplete
     *            whether it is delete complete or only delete representation
     */
    public RemoveUseCaseNodeAction(MainFrame mainFrame, UseCaseNode node, boolean isComplete) {
        super(PRESENTATION_NAME, mainFrame, node, isComplete ? createRemoveUseCaseAction(node) : null);
    }

    /**
     * <p>
     * Creates an instance of RemoveUseCaseAction.
     * </p>
     * @param node
     *            node to remove
     * @return an an instance of RemoveUseCaseAction
     */
    private static RemoveUseCaseAction createRemoveUseCaseAction(UseCaseNode node) {
        UseCase usecase = (UseCase) DeployHelper.getElement(node.getGraphNode());
        return new RemoveUseCaseAction(usecase);
    }
}
