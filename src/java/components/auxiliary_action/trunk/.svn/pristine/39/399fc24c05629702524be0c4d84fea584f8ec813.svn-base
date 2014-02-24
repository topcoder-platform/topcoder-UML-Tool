/*
 * Copyright (C) 2007 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.uml.actions.auxiliary.comment.model;

import java.awt.datatransfer.Clipboard;
import java.util.ArrayList;
import java.util.Collection;

import javax.swing.undo.CannotUndoException;

import com.topcoder.uml.actions.auxiliary.AbstractAuxiliaryUndoableAction;
import com.topcoder.uml.actions.auxiliary.AuxiliaryElementClipboardUtility;
import com.topcoder.uml.actions.auxiliary.AuxiliaryElementCloneException;
import com.topcoder.uml.model.core.ModelElement;
import com.topcoder.uml.model.core.auxiliaryelements.Comment;
import com.topcoder.util.actionmanager.ActionExecutionException;

/**
 * <p>
 * This class extends the <code>AbstractAuxiliaryUndoableAction</code> abstract class, and it
 * is responsible for removing the comment from the comments list of its
 * annotated <code>ModelElement</code> objects, and copy the comment object to the clipboard.
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
public class CutNoteRelationshipAction extends AbstractAuxiliaryUndoableAction {
    /**
     * <p>
     * Represents the presentation of this action.
     * </p>
     */
    private static final String NAME = "Cut Note Relationship Action";
    /**
     * <p>
     * Represents the <code>Comment</code> object to remove from all annotated <code>ModelElements</code>'
     * comments attributes, and to cut to clipboard in execute method.
     * </p>
     * <p>
     * Initialized in constructor, and its reference is never changed
     * afterwards. Must be non-null.
     * </p>
     */
    private final Comment comment;

    /**
     * <p>
     * Represents a collection of <code>ModelElement</code> objects which contain the comment
     * in their comments attributes.
     * </p>
     * <p>
     * Initialized to an empty <code>ArrayList&lt;ModelElement&gt;</code>
     * object when it is declared, and it is populated in constructor, its
     * reference is never changed afterwards. Must be non-null, and non-empty.
     * Each element in this list should be non-null.
     * </p>
     */
    private final Collection<ModelElement> parents = new ArrayList<ModelElement>();

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
     * Create a new <code>CutNoteRelationshipAction</code> with given comment
     * and clipboard.
     * </p>
     * @param comment
     *            the Comment object to cut
     * @param clipboard
     *            the clipboard the comment is copied to
     * @throws IllegalArgumentException if the comment argument is null, or the comment has no annotated elements.
     */
    public CutNoteRelationshipAction(Comment comment, Clipboard clipboard) {
        super(NAME);
        if (comment == null) {
            throw new IllegalArgumentException("comment cannot be null!");
        }
        if (comment.getAnnotatedElements().isEmpty()) {
            throw new IllegalArgumentException("The comment has no annotated elements!");
        }
        this.comment = comment;
        this.clipboard = clipboard;
        this.parents.addAll(comment.getAnnotatedElements());
    }

    /**
     * <p>
     * Execute the action, copy the comment to clipboard and remove the comment from all its
     * annotated elements.
     * </p>
     * @throws AuxiliaryElementCloneException If the clone operation fails.
     * @throws ActionExecutionException If error occurs while copying(e.g. fail to get the system-clipboard).
     */
    public void execute() throws AuxiliaryElementCloneException, ActionExecutionException {
        // Copy the comment to the clipboard
        AuxiliaryElementClipboardUtility.copyNoteRelationship(this.comment, this.clipboard);
        // Remove the comment from its parents
        for (ModelElement me : this.parents) {
            me.removeComment(this.comment);
            this.comment.removeAnnotatedElement(me);
        }
    }

    /**
     * <p>
     * Undo the cut action, it will add the comment back to all its annotated
     * elements.
     * </p>
     * @throws CannotUndoException If <code>canUndo</code> returns <code>false</code>.
     */
    public void undo() {
        // Call super.undo()
        super.undo();
        // Add the comment back to all its annotated elements
        for (ModelElement me : this.parents) {
            me.addComment(this.comment);
            this.comment.addAnnotatedElement(me);
        }
    }
}
