/*
 * Copyright (C) 2007 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.umltool.deploy.actions.undoable;

import com.topcoder.gui.diagramviewer.uml.usecaseelements.ActorNode;
import com.topcoder.uml.actions.model.usecase.RemoveActorAction;
import com.topcoder.uml.model.usecases.Actor;
import com.topcoder.umltool.deploy.DeployHelper;
import com.topcoder.umltool.deploy.MainFrame;

/**
 * <p>
 * This action is used for remove ActorNode from the diagram view.
 * </p>
 * @author ly, FireIce, ylouis
 * @version 1.0
 */
public class RemoveActorNodeAction extends RemoveNodeAction {

    /**
     * <p>
     * Presentation name of this action.
     * </p>
     */
    private static final String PRESENTATION_NAME = "Remove ActorNode";

    /**
     * <p>
     * Creates an instance of RemoveActorNodeAction.
     * </p>
     * @param mainFrame
     *            reference to main frame
     * @param node
     *            node to remove
     */
    public RemoveActorNodeAction(MainFrame mainFrame, ActorNode node) {
        this(mainFrame, node, true);
    }

    /**
     * <p>
     * Creates an instance of RemoveActorNodeAction.
     * </p>
     * @param mainFrame
     *            reference to main frame
     * @param node
     *            node to remove
     * @param isComplete
     *            whether it is delete complete or only delete representation
     */
    public RemoveActorNodeAction(MainFrame mainFrame, ActorNode node, boolean isComplete) {
        super(PRESENTATION_NAME, mainFrame, node, isComplete ? createRemoveActorAction(node) : null);
    }

    /**
     * <p>
     * Creates an instance of RemoveActorAction.
     * </p>
     * @param node
     *            node to remove
     * @return an an instance of RemoveActorAction
     */
    private static RemoveActorAction createRemoveActorAction(ActorNode node) {
        Actor actor = (Actor) DeployHelper.getElement(node.getGraphNode());
        return new RemoveActorAction(actor);
    }
}
