/*
 * Copyright (C) 2007 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.uml.actions.auxiliary.comment.diagram;

import java.awt.datatransfer.Clipboard;

import com.topcoder.diagraminterchange.GraphElement;
import com.topcoder.diagraminterchange.GraphNode;
import com.topcoder.uml.actions.auxiliary.AbstractCutGraphElementAction;
import com.topcoder.uml.actions.auxiliary.AuxiliaryElementClipboardUtility;
import com.topcoder.uml.actions.auxiliary.AuxiliaryElementCloneException;
import com.topcoder.util.actionmanager.ActionExecutionException;

/**
 * <p>
 * This class extends the <code>AbstractCutGraphElementAction</code> abstract class, and it
 * is responsible for removing the comment graph node from its contained diagram
 * graph node, and copying it to the clipboard.
 * </p>
 * <p>
 * Note that if the provided clipboard is null, system clipboard is used instead.
 * </p>
 * <p>
 * Thread-safety: This class is stateless, but as its base class is not thread-safe,
 * it is not thread-safe too.
 * </p>
 * @version 1.0
 * @author Standlove, TCSDEVELOPER
 */
public class CutCommentGraphNodeAction extends AbstractCutGraphElementAction {
    /**
     * <p>
     * Represents the presentation of this action.
     * </p>
     */
    private static final String NAME = "Cut Comment GraphNode";
    /**
     * <p>
     * Create a new <code>AddCommentGraphNodeAction</code> with the given comment graph node to cut,
     * and the clipboard.
     * </p>
     * @param commentGraphNode
     *            the comment graph node.
     * @param clipboard
     *            the clipboard to copy the data.
     * @throws IllegalArgumentException if the commentGraphNode
     *          argument is null, or its container is null, or the commentGraphNode doesn't contains a
     *          semanticModel attribute (Uml1SemanticModelBridge object), which in turn
     *          should contain a Comment object as its element attribute.
     */
    public CutCommentGraphNodeAction(GraphNode commentGraphNode, Clipboard clipboard) {
        super(NAME, commentGraphNode, clipboard);
        // Validate the commentGraphNode
        Helper.validateGraphNodeForComment(commentGraphNode);
    }

    /**
     * <p>
     * Execute the action, copy the comment graph node to the clipboard.
     * </p>
     * @param node
     *            the comment graph node to copy.
     * @param clipboard
     *            the clipboard to copy the data.
     * @throws IllegalArgumentException if the node argument is null.
     * @throws AuxiliaryElementCloneException If the clone operation fails.
     * @throws ActionExecutionException If error occurs while copying(e.g. fail to get the system-clipboard).
     */
    protected void copyToClipboard(GraphElement node, Clipboard clipboard)
        throws AuxiliaryElementCloneException, ActionExecutionException {
        AuxiliaryElementClipboardUtility.copyCommentGraphNode((GraphNode) node, clipboard);
    }
}
