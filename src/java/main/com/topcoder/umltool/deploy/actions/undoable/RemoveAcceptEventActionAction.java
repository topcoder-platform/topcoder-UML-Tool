/*
 * Copyright (C) 2007 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.umltool.deploy.actions.undoable;

import com.topcoder.gui.diagramviewer.uml.activityelements.AcceptEventAction;
import com.topcoder.uml.model.statemachines.SimpleState;
import com.topcoder.umltool.deploy.DeployHelper;
import com.topcoder.umltool.deploy.MainFrame;

/**
 * <p>
 * This action is used for remove AcceptEventAction from the diagram view.
 * </p>
 * @author ly, FireIce, ylouis
 * @version 1.0
 */
public class RemoveAcceptEventActionAction extends RemoveNodeAction {

    /**
     * <p>
     * Presentation name of this action.
     * </p>
     */
    private static final String PRESENTATION_NAME = "Remove AcceptEventAction";

    /**
     * <p>
     * Creates an instance of RemoveAcceptEventActionAction.
     * </p>
     * @param mainFrame
     *            reference to main frame
     * @param node
     *            node to remove
     */
    public RemoveAcceptEventActionAction(MainFrame mainFrame, AcceptEventAction node) {
        this(mainFrame, node, true);
    }

    /**
     * <p>
     * Creates an instance of RemoveAcceptEventActionAction.
     * </p>
     * @param mainFrame
     *            reference to main frame
     * @param node
     *            node to remove
     * @param isRemoveComplete
     *            true if remove complete, false if only remove representation
     */
    public RemoveAcceptEventActionAction(MainFrame mainFrame, AcceptEventAction node, boolean isRemoveComplete) {
        super(PRESENTATION_NAME, mainFrame, node, isRemoveComplete ? createRemoveAcceptEventActionAction(node) : null);
    }

    /**
     * <p>
     * Creates an instance of RemoveAcceptEventActionAction.
     * </p>
     * @param node
     *            node to remove
     * @return an an instance of RemoveAcceptEventActionAction
     */
    private static com.topcoder.uml.actions.model.activity.RemoveAcceptEventActionAction createRemoveAcceptEventActionAction(
            AcceptEventAction node) {
        SimpleState state = (SimpleState) DeployHelper.getElement(node.getGraphNode());
        return new com.topcoder.uml.actions.model.activity.RemoveAcceptEventActionAction(state);
    }
}
