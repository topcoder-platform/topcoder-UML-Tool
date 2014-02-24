/*
 * Copyright (C) 2007 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.umltool.deploy.actions.undoable;

import com.topcoder.gui.diagramviewer.uml.auxiliaryelements.CommentNode;
import com.topcoder.uml.actions.auxiliary.comment.model.RemoveCommentAction;
import com.topcoder.uml.model.core.auxiliaryelements.Comment;
import com.topcoder.umltool.deploy.DeployHelper;
import com.topcoder.umltool.deploy.MainFrame;

/**
 * <p>
 * This action is used for remove CommentNode from the diagram view.
 * </p>
 * @author ly, FireIce, ylouis
 * @version 1.0
 */
public class RemoveCommentNodeAction extends RemoveNodeAction {

    /**
     * <p>
     * Presentation name of this action.
     * </p>
     */
    private static final String PRESENTATION_NAME = "Remove CommentNode";

    /**
     * <p>
     * Creates an instance of RemoveCommentNodeAction.
     * </p>
     * @param mainFrame
     *            reference to main frame
     * @param node
     *            node to remove
     */
    public RemoveCommentNodeAction(MainFrame mainFrame, CommentNode node) {
        this(mainFrame, node, true);
    }

    /**
     * <p>
     * Creates an instance of RemoveCommentNodeAction.
     * </p>
     * @param mainFrame
     *            reference to main frame
     * @param node
     *            node to remove
     * @param isComplete
     *            whether it is delete complete or only delete representation
     */
    public RemoveCommentNodeAction(MainFrame mainFrame, CommentNode node, boolean isComplete) {
        super(PRESENTATION_NAME, mainFrame, node, isComplete ? createRemoveCommentAction(node) : null);
    }

    /**
     * <p>
     * Creates an instance of RemoveCommentAction.
     * </p>
     * @param node
     *            node to remove
     * @return an an instance of RemoveCommentAction
     */
    private static RemoveCommentAction createRemoveCommentAction(CommentNode node) {
        Comment comment = (Comment) DeployHelper.getElement(node.getGraphNode());
        return new RemoveCommentAction(comment);
    }
}
