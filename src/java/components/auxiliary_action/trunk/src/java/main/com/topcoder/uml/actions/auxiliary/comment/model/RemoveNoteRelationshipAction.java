/*
 * Copyright (C) 2007 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.uml.actions.auxiliary.comment.model;

import java.util.ArrayList;
import java.util.Collection;

import javax.swing.undo.CannotUndoException;

import com.topcoder.uml.actions.auxiliary.AbstractAuxiliaryUndoableAction;
import com.topcoder.uml.model.core.ModelElement;
import com.topcoder.uml.model.core.auxiliaryelements.Comment;
import com.topcoder.util.actionmanager.ActionExecutionException;

/**
 * <p>
 * This class extends the <code>AbstractAuxiliaryUndoableAction</code> abstract class,
 * and it is responsible for removing the <code>Comment</code> from the comments list of all its
 * annotated <code>ModelElement</code> objects.
 * </p>
 * <p>
 * Thread-safe: This class is immutable, but as the internal state of its variables could be changed
 * externally, this class is not guaranteed to be thread-safe.
 * </p>
 * @version 1.0
 * @author Standlove, TCSDEVELOPER
 */
public class RemoveNoteRelationshipAction extends AbstractAuxiliaryUndoableAction {
    /**
     * <p>
     * Represents the presentation of this action.
     * </p>
     */
    private static final String NAME = "Remove Note Relationship Action";
    /**
     * <p>
     * Represents the <code>Comment</code> object to remove from all annotated
     * <code>ModelElement</code>s' comments attributes in execute method.
     * </p>
     * <p>
     * Initialized in constructor, and
     * its reference is never changed afterwards. Must be non-null.
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
     * Create a new <code>RemoveNoteRelationshipAction</code> with given comment.
     * </p>
     * @param comment
     *            the Comment object to remove
     * @throws IllegalArgumentException if the argument is null, or
     *          the comment has no annotated elements.
     */
    public RemoveNoteRelationshipAction(Comment comment) {
        super(NAME);
        if (comment == null) {
            throw new IllegalArgumentException("comment cannot be null!");
        }
        if (comment.getAnnotatedElements().isEmpty()) {
            throw new IllegalArgumentException("There's no annotated elements for this comment!");
        }
        this.comment = comment;
        this.parents.addAll(comment.getAnnotatedElements());
    }

    /**
     * <p>
     * Execute the action, remove the comment from all its annotated <code>ModelElement</code> object.
     * </p>
     * @throws ActionExecutionException if fail to execute the action, it will never be thrown
     *          in this method.
     */
    public void execute() throws ActionExecutionException {
        // Remove the comment from its parents
        for (ModelElement me : this.parents) {
            me.removeComment(this.comment);
            this.comment.removeAnnotatedElement(me);
        }
    }

    /**
     * <p>
     * Undo the remove action, it will add the comment back to all its annotated
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
