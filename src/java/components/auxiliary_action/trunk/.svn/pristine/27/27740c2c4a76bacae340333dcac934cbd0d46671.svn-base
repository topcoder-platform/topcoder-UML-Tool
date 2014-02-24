/*
 * Copyright (C) 2007 TopCoder Inc., All Rights Reserved.
 *
 * CutCommentRelationshipGraphEdgeActionImpl.java
 */
package com.topcoder.uml.actions.auxiliary.failuretests.impls;

import com.topcoder.uml.actions.auxiliary.comment.diagram.CutCommentRelationshipGraphEdgeAction;
import com.topcoder.diagraminterchange.GraphEdge;
import com.topcoder.diagraminterchange.GraphElement;
import com.topcoder.util.actionmanager.ActionExecutionException;

import java.awt.datatransfer.Clipboard;

/**
 * <p>
 *  Extends AbstractRemoveGraphElementAction so that to access method copyToClipboard.
 * </p>
 *
 * @author wiedzmin
 * @version 1.0
 */
public class CutCommentRelationshipGraphEdgeActionImpl extends CutCommentRelationshipGraphEdgeAction {

    /**
     * <p>
     * Constructs CutCommentRelationshipGraphEdgeAction.
     * </p>
     *
     * @param commentGraphEdge the comment graph edge
     * @param clipboard        the clipboard to copy the data.
     * @throws IllegalArgumentException if the commentGraphEdge argument is null, or
     *                                  the commentGraphEdge doesn't contains a semanticModel attribute
     *                                  (SimpleSemanticModelElement object) with its typeInfo attribute
     *                                  equal to &quot;CommentLink&quot;.
     */
    public CutCommentRelationshipGraphEdgeActionImpl(GraphEdge commentGraphEdge, Clipboard clipboard) {
        super(commentGraphEdge, clipboard);
    }

    /**
     * <p>
     * Copy the comment graph node to the clipboard.
     * </p>
     *
     * @param node      the comment graph edge
     * @param clipboard the clipboard to copy the data.
     * @throws IllegalArgumentException if the node argument is null.
     * @throws com.topcoder.util.actionmanager.ActionExecutionException if the copy to clipboard operation fails.
     */
    public void copyToClipboard(GraphElement node, Clipboard clipboard) throws ActionExecutionException {
        super.copyToClipboard(node, clipboard);
    }
}
