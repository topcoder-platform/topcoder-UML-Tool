/*
 * Copyright (C) 2007 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.umltool.deploy.actions.undoable;

import com.topcoder.gui.diagramviewer.uml.auxiliaryelements.CommentLinkEdge;
import com.topcoder.umltool.deploy.MainFrame;

/**
 * <p>
 * This action is used for remove CommentLink Edge from the diagram view.
 * </p>
 * @author ly, FireIce, ylouis
 * @version 1.0
 */
public class RemoveCommentLinkEdgeAction extends RemoveEdgeAction {

    /**
     * <p>
     * Presentation name of this action.
     * </p>
     */
    private static final String PRESENTATION_NAME = "Remove CommentLinkEdge";

    /**
     * <p>
     * Creates an instance of RemoveCommentLinkEdgeAction.
     * </p>
     * @param mainFrame
     *            main frame window
     * @param edge
     *            edge to remove
     */
    public RemoveCommentLinkEdgeAction(MainFrame mainFrame, CommentLinkEdge edge) {
        super(PRESENTATION_NAME, mainFrame, edge, null);
    }
}
