/*
 * Copyright (C) 2007 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.umltool.deploy.actions.undoable;

import com.topcoder.gui.diagramviewer.uml.sequenceelements.ObjectNode;
import com.topcoder.uml.actions.model.sequence.RemoveObjectAction;
import com.topcoder.umltool.deploy.DeployHelper;
import com.topcoder.umltool.deploy.MainFrame;

/**
 * <p>
 * This action is used for remove object node from the diagram view.
 * </p>
 * <p>
 * RemoveObjectAction and RemoveDiagramElementAction are used.
 * </p>
 * @author ly, FireIce, ylouis
 * @version 1.0
 */
public class RemoveObjectNodeAction extends RemoveNodeAction {
    /**
     * <p>
     * Presentation name of this action.
     * </p>
     */
    private static final String PRESENTATION_NAME = "Remove Object Node";

    /**
     * <p>
     * Creates an instance of RemoveObjectNodeAction and creates required actions.
     * </p>
     * @param mainFrame
     *            reference to main frame
     * @param objectNode
     *            object node to remove
     */
    public RemoveObjectNodeAction(MainFrame mainFrame, ObjectNode objectNode) {
        this(mainFrame, objectNode, true);
    }

    /**
     * <p>
     * Creates an instance of RemoveObjectNodeAction and creates required actions.
     * </p>
     * @param mainFrame
     *            reference to main frame
     * @param objectNode
     *            object node to remove
     * @param isComplete
     *            whether it is delete complete or only delete representation
     */
    public RemoveObjectNodeAction(MainFrame mainFrame, ObjectNode objectNode, boolean isComplete) {
        super(PRESENTATION_NAME, mainFrame, objectNode, isComplete ? createRemoveObjectAction(objectNode) : null);
    }

    /**
     * <p>
     * Creates an instance of RemoveObjectAction.
     * </p>
     * @param objectNode
     *            node to remove
     * @return an an instance of RemoveObjectAction
     * @throws IllegalArgumentException
     *             if objectNode is null
     */
    private static RemoveObjectAction createRemoveObjectAction(ObjectNode objectNode) {
        DeployHelper.checkNotNull(objectNode, "objectNode");
        return new RemoveObjectAction(objectNode.getObject());
    }

}
