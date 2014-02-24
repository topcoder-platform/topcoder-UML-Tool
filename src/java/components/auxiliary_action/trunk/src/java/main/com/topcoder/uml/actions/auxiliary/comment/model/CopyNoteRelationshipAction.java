/*
 * Copyright (C) 2007 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.uml.actions.auxiliary.comment.model;

import java.awt.datatransfer.Clipboard;

import com.topcoder.uml.actions.auxiliary.AuxiliaryElementClipboardUtility;
import com.topcoder.uml.actions.auxiliary.AuxiliaryElementCloneException;
import com.topcoder.uml.model.core.auxiliaryelements.Comment;
import com.topcoder.util.actionmanager.ActionExecutionException;
import com.topcoder.util.actionmanager.TransientAction;

/**
 * <p>
 * This class implements the <code>TransientAction</code> interface, and it is responsible
 * for copying the note relationship to the clipboard.
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
public class CopyNoteRelationshipAction implements TransientAction {

    /**
     * <p>
     * Represents the <code>Comment</code> object to copy to clipboard in execute method.
     * </p>
     * <p>
     * Initialized in constructor, and its reference is never changed
     * afterwards. Must be non-null.
     * </p>
     */
    private final Comment comment;

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
     * Create a new <code>CopyNoteRelationshipAction</code> with given comment
     * and clipboard.
     * </p>
     * <exception> throws IllegalArgumentException if the comment argument is
     * null </exception>
     *
     *
     * @param comment
     *            the Comment object to copy to clipboard
     * @param clipboard
     *            the clipboard the comment is copied to
     * @throws IllegalArgumentException if the comment argument is null.
     */
    public CopyNoteRelationshipAction(Comment comment, Clipboard clipboard) {
        if (comment == null) {
            throw new IllegalArgumentException("comment cannot be null!");
        }
        this.comment = comment;
        this.clipboard = clipboard;
    }

    /**
     * <p>
     * Execute the action, copy the comment to clipboard.
     * </p>
     * @throws AuxiliaryElementCloneException If the clone operation fails.
     * @throws ActionExecutionException If error occurs while copying(e.g. fail to get the system-clipboard).
     */
    public void execute() throws AuxiliaryElementCloneException, ActionExecutionException {
        AuxiliaryElementClipboardUtility.copyNoteRelationship(this.comment, this.clipboard);
    }
}
