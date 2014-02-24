/*
 * Copyright (C) 2007 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.uml.actions.auxiliary.comment.diagram;

import java.awt.datatransfer.Clipboard;

import com.topcoder.diagraminterchange.GraphEdge;
import com.topcoder.uml.actions.auxiliary.AuxiliaryElementClipboardUtility;
import com.topcoder.uml.actions.auxiliary.AuxiliaryElementCloneException;
import com.topcoder.util.actionmanager.ActionExecutionException;
import com.topcoder.util.actionmanager.TransientAction;

/**
 * <p>
 * This class implements the <code>TransientAction</code> interface, and it is responsible
 * for copying the comment graph edge to the clipboard.
 * </p>
 * <p>
 * Note that if the provided clipboard is null, system clipboard is used instead.
 * </p>
 * <p>
 * Thread-safety: The internal state of its variables (freeTextGraphNode) could be
 * changed externally, so it is not guaranteed to be thread-safe.
 * </p>
 * @version 1.0
 * @author Standlove, TCSDEVELOPER
 */
public class CopyCommentRelationshipGraphEdgeAction implements TransientAction {

    /**
     * <p>
     * Represents the comment graph edge to copy to clipboard in execute method.
     * </p>
     * <p>
     * Initialized in constructor, and its reference is never changed
     * afterwards. Must be non-null.
     * </p>
     */
    private final GraphEdge commentGraphEdge;

    /**
     * <p>
     * Represents the clipboard to copy the comment graph edge in execute
     * method.
     * </p>
     * <p>
     * Initialized in constructor, and its reference is never changed
     * afterwards. Could be null if system-clipboard is used instead.
     * </p>
     */
    private final Clipboard clipboard;

    /**
     * <p>
     * Create a new <code>CopyCommentRelationshipGraphEdgeAction</code> with given commentGraphNode
     * and clipboard.
     * </p>
     * @param commentGraphEdge
     *            the comment graph edge
     * @param clipboard
     *            the clipboard to copy the data.
     * @throws IllegalArgumentException if the commentGraphEdge
     *          argument is null, or the commentGraphEdge doesn't contains a
     *          semanticModel attribute (SimpleSemanticModelElement object) with its
     *          typeInfo attribute equal to "CommentLink"
     */
    public CopyCommentRelationshipGraphEdgeAction(GraphEdge commentGraphEdge, Clipboard clipboard) {
        // Validate the commentGraphEdge
        Helper.validateGraphEdgeForCommentRelationship(commentGraphEdge);
        this.commentGraphEdge = commentGraphEdge;
        this.clipboard = clipboard;
    }

    /**
     * <p>
     * Execute the action, copy the comment graph node to the clipboard.
     * </p>
     * @throws AuxiliaryElementCloneException If the clone operation fails.
     * @throws ActionExecutionException If error occurs while copying(e.g. fail to get the system-clipboard).
     */
    public void execute() throws AuxiliaryElementCloneException, ActionExecutionException {
        AuxiliaryElementClipboardUtility.copyCommentRelationshipGraphEdge(this.commentGraphEdge, this.clipboard);
    }
}
