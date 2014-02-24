/*
 * Copyright (C) 2007 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.umltool.deploy.actions.undoable;

import com.topcoder.gui.diagramviewer.uml.activityelements.SendSignalAction;
import com.topcoder.uml.model.statemachines.SimpleState;
import com.topcoder.umltool.deploy.DeployHelper;
import com.topcoder.umltool.deploy.MainFrame;

/**
 * <p>
 * This action is used for remove SendSignalAction from the diagram view.
 * </p>
 * @author ly, FireIce, ylouis
 * @version 1.0
 */
public class RemoveSendSignalActionAction extends RemoveNodeAction {

    /**
     * <p>
     * Presentation name of this action.
     * </p>
     */
    private static final String PRESENTATION_NAME = "Remove SendSignalAction";

    /**
     * <p>
     * Creates an instance of RemoveSendSignalActionAction.
     * </p>
     * @param mainFrame
     *            reference to main frame
     * @param node
     *            node to remove
     */
    public RemoveSendSignalActionAction(MainFrame mainFrame, SendSignalAction node) {
        this(mainFrame, node, true);
    }

    /**
     * <p>
     * Creates an instance of RemoveSendSignalActionAction.
     * </p>
     * @param mainFrame
     *            reference to main frame
     * @param node
     *            node to remove
     * @param isComplete
     *            whether it is delete complete or only delete representation
     */
    public RemoveSendSignalActionAction(MainFrame mainFrame, SendSignalAction node, boolean isComplete) {
        super(PRESENTATION_NAME, mainFrame, node, isComplete ? createRemoveSendSignalActionAction(node) : null);
    }

    /**
     * <p>
     * Creates an instance of RemoveSendSignalActionAction.
     * </p>
     * @param node
     *            node to remove
     * @return an an instance of RemoveSendSignalActionAction
     */
    private static com.topcoder.uml.actions.model.activity.RemoveSendSignalActionAction createRemoveSendSignalActionAction(
            SendSignalAction node) {
        SimpleState state = (SimpleState) DeployHelper.getElement(node.getGraphNode());
        return new com.topcoder.uml.actions.model.activity.RemoveSendSignalActionAction(state);
    }
}
