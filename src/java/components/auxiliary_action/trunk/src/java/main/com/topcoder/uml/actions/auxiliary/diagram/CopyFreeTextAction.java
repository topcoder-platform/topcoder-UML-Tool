/*
 * Copyright (C) 2007 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.uml.actions.auxiliary.diagram;

import java.awt.datatransfer.Clipboard;

import com.topcoder.diagraminterchange.GraphNode;
import com.topcoder.uml.actions.auxiliary.AuxiliaryElementClipboardUtility;
import com.topcoder.uml.actions.auxiliary.AuxiliaryElementCloneException;
import com.topcoder.util.actionmanager.ActionExecutionException;
import com.topcoder.util.actionmanager.TransientAction;

/**
 * <p>
 * This class implements the <code>TransientAction</code> interface, and it is
 * responsible for copying the free text graph node to the clipboard.
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
public class CopyFreeTextAction implements TransientAction {
    /**
     * <p>
     * Represents the free text graph node to copy to clipboard in execute
     * method.
     * </p>
     * <p>
     * It is initialized in constructor, and its reference is never changed
     * afterwards. Must be non-null.
     * </p>
     */
    private final GraphNode freeTextGraphNode;

    /**
     * <p>
     * Represents the clipboard to copy the free text graph node in execute
     * method.
     * </p>
     * <p>
     * It is initialized in constructor, and its reference is never changed
     * afterwards. Could be null if system-clipboard is used instead.
     * </p>
     */
    private final Clipboard clipboard;

    /**
     * <p>
     * Create a new <code>CopyFreeTextAction</code> with given freeTextGraphNode
     * and clipboard.
     * </p>
     * @param freeTextGraphNode
     *            free text graph node.
     * @param clipboard
     *            the clipboard to copy.
     * @throws IllegalArgumentException if the freeTextGraphNode argument is null,
     *      or the freeTextGraphNode doesn't contain a semanticModel attribute
     *      (SimpleSemanticModelElement object) with typeInfo attribute equal to "FreeText",
     *      or it doesn't contain a TextElement object in its contained attribute.
     */
    public CopyFreeTextAction(GraphNode freeTextGraphNode, Clipboard clipboard) {
        // Validate the freeTextGraphNode
        Helper.validateGraphNodeForFreeTextAction(freeTextGraphNode);

        this.freeTextGraphNode = freeTextGraphNode;
        this.clipboard = clipboard;
    }

    /**
     * <p>
     * Execute the action, copy the free text graph node to the clipboard.
     * </p>
     * @throws AuxiliaryElementCloneException If the clone operation fails.
     * @throws ActionExecutionException If error occurs while copying(e.g. fail to get the system-clipboard).
     */
    public void execute() throws AuxiliaryElementCloneException, ActionExecutionException {
        AuxiliaryElementClipboardUtility.copyFreeTextGraphNode(this.freeTextGraphNode, this.clipboard);
    }
}
