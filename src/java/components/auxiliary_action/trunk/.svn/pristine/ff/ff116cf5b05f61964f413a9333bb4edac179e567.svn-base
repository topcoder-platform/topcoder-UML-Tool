/*
 * Copyright (C) 2007 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.uml.actions.auxiliary.comment.diagram;

import java.awt.datatransfer.Clipboard;

import com.topcoder.diagraminterchange.GraphNode;
import com.topcoder.uml.actions.auxiliary.AuxiliaryElementClipboardUtility;
import com.topcoder.uml.actions.auxiliary.AuxiliaryElementCloneException;
import com.topcoder.util.actionmanager.ActionExecutionException;
import com.topcoder.util.actionmanager.TransientAction;

/**
 * <p>
 * This class implements the <code>TransientAction</code> interface, and it is responsible
 * for copying the comment graph node to the clipboard.
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
public class CopyCommentGraphNodeAction implements TransientAction {

    /**
     * <p>
     * Represents the comment graph node to copy to clipboard in execute method.
     * </p>
     * <p>
     * Initialized in constructor, and its reference is never changed
     * afterwards. Must be non-null.
     * </p>
     */
    private final GraphNode commentGraphNode;

    /**
     * <p>
     * Represents the clipboard to copy the comment graph node in execute
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
     * Create a new <code>CopyCommentGraphNodeAction</code> with given commentGraphNode
     * and clipboard.
     * </p>
     * @param commentGraphNode
     *            the comment graph node.
     * @param clipboard
     *            the clipboard to copy the data.
     * @throws IllegalArgumentException if the commentGraphNode
     *          argument is null, or the commentGraphNode doesn't contains a
     *          semanticModel attribute (Uml1SemanticModelBridge object), which in turn
     *          should contain a Comment object as its element attribute.
     */
    public CopyCommentGraphNodeAction(GraphNode commentGraphNode, Clipboard clipboard) {
        // Validate the commentGraphNode
        Helper.validateGraphNodeForComment(commentGraphNode);
        this.commentGraphNode = commentGraphNode;
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
        AuxiliaryElementClipboardUtility.copyCommentGraphNode(this.commentGraphNode, this.clipboard);
    }
}
