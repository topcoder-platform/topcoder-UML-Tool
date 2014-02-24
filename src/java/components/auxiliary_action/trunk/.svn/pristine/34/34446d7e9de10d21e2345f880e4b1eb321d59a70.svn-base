/*
 * Copyright (C) 2007 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.uml.actions.auxiliary.comment.model;

import java.awt.datatransfer.Clipboard;

import javax.swing.undo.CannotUndoException;

import com.topcoder.uml.actions.auxiliary.AbstractAuxiliaryUndoableAction;
import com.topcoder.uml.actions.auxiliary.AuxiliaryElementClipboardUtility;
import com.topcoder.uml.actions.auxiliary.AuxiliaryElementCloneException;
import com.topcoder.uml.model.core.Namespace;
import com.topcoder.uml.model.core.auxiliaryelements.Comment;
import com.topcoder.util.actionmanager.ActionExecutionException;

/**
 * <p>
 * This class extends the <code>AbstractAuxiliaryUndoableAction</code> abstract class, and it
 * is responsible for removing the comment from its contained <code>Namespace</code>, and
 * copying the comment to the clipboard.
 * </p>
 * <p>
 * Note that if the provided clipboard is null, system clipboard is used instead.
 * </p>
 * <p>
 * Thread-safe: This class is immutable, but as the internal state of its variables
 * could be changed externally, this class is not guaranteed to be thread-safe.
 * </p>
 * @version 1.0
 * @author Standlove, TCSDEVELOPER
 */
public class CutCommentAction extends AbstractAuxiliaryUndoableAction {
    /**
     * <p>
     * Represents the presentation of this action.
     * </p>
     */
    private static final String NAME = "Cut Comment Action";
    /**
     * <p>
     * Represents the <code>Comment</code> object to remove from it contained namespace and
     * copy to clipboard in execute method.
     * </p>
     * <p>
     * Initialized in constructor, and its reference is never changed afterwards. Must be non-null.
     * </p>
     */
    private final Comment comment;

    /**
     * <p>
     * Represents the <code>Namespace</code> object to remove the comment in execute method.
     * </p>
     * <p>
     * Initialized in constructor to comment.getNamespace(), and its reference
     * is never changed afterwards. Must be non-null.
     * </p>
     */
    private final Namespace namespace;

    /**
     * <p>
     * Represents the clipboard the comment is copied to in execute method.
     * </p>
     * <p>
     * Initialized in the constructor, and its reference is never changed
     * afterwards. Could be null if the node is copied to system clipboard.
     * </p>
     */
    private final Clipboard clipboard;

    /**
     * <p>
     * Create a new <code>CutCommentAction</code> with given comment
     * and clipboard.
     * </p>
     * @param comment
     *            the Comment object to cut.
     * @param clipboard
     *            the clipboard the comment is copied to
     * @throws IllegalArgumentException if the comment argument is null, or its namespace is null.
     */
    public CutCommentAction(Comment comment, Clipboard clipboard) {
        super(NAME);
        if (comment == null) {
            throw new IllegalArgumentException("comment cannot be null!");
        }
        if (comment.getNamespace() == null) {
            throw new IllegalArgumentException("namespace of the comment cannot be null!");
        }
        this.comment = comment;
        this.namespace = comment.getNamespace();
        this.clipboard = clipboard;
    }

    /**
     * <p>
     * Execute the action, copy the comment to clipboard and remove the comment from its contained
     * namespace.
     * </p>
     * @throws AuxiliaryElementCloneException If the clone operation fails.
     * @throws ActionExecutionException If error occurs while copying(e.g. fail to get the system-clipboard).
     */
    public void execute() throws AuxiliaryElementCloneException, ActionExecutionException {
        // Remove the comment from the namespace
        this.namespace.removeOwnedElement(this.comment);
        this.comment.setNamespace(null);
        // Copy the comment to the clipboard
        AuxiliaryElementClipboardUtility.copyComment(this.comment, this.clipboard);
    }

    /**
     * <p>
     * Undo the cut action, it will add the comment back to the namespace.
     * </p>
     * @throws CannotUndoException If <code>canUndo</code> returns <code>false</code>.
     */
    public void undo() {
        // Call super.undo()
        super.undo();
        // Add the comment back to the namespace
        this.namespace.addOwnedElement(this.comment);
        this.comment.setNamespace(this.namespace);
    }
}
