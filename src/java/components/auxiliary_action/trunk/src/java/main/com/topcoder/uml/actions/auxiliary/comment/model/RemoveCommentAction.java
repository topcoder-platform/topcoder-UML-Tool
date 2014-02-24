/*
 * Copyright (C) 2007 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.uml.actions.auxiliary.comment.model;

import javax.swing.undo.CannotUndoException;

import com.topcoder.uml.actions.auxiliary.AbstractAuxiliaryUndoableAction;
import com.topcoder.uml.model.core.Namespace;
import com.topcoder.uml.model.core.auxiliaryelements.Comment;
import com.topcoder.util.actionmanager.ActionExecutionException;

/**
 * <p>
 * This class extends the <code>AbstractAuxiliaryUndoableAction</code> abstract class,
 * and it is responsible for removing the <code>Comment</code> from its contained
 * <code>Namespace</code>.
 * </p>
 * <p>
 * Thread-safe: This class is immutable, but as the internal state of its
 * variables could be changed externally, this class is not guaranteed to be
 * thread-safe.
 * </p>
 * @version 1.0
 * @author Standlove, TCSDEVELOPER
 */
public class RemoveCommentAction extends AbstractAuxiliaryUndoableAction {
    /**
     * <p>
     * Represents the presentation of this action.
     * </p>
     */
    private static final String NAME = "Remove Comment Action";
    /**
     * <p>
     * Represents the <code>Comment</code> object to remove from it contained namespace in
     * execute method.
     * </p>
     * <p>
     * Initialized in constructor, and its reference is never
     * changed afterwards. Must be non-null.
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
     * Create a new <code>RemoveCommentAction</code> with given comment.
     * </p>
     * @param comment
     *            the Comment object to remove from it contained namespace
     * @throws IllegalArgumentException if comment is null or its namespace is null.
     */
    public RemoveCommentAction(Comment comment) {
        super(NAME);
        if (comment == null) {
            throw new IllegalArgumentException("comment cannot be null!");
        }
        if (comment.getNamespace() == null) {
            throw new IllegalArgumentException("namespace of the comment cannot be null!");
        }
        this.comment = comment;
        this.namespace = comment.getNamespace();
    }

    /**
     * <p>
     * Execute the action, remove the comment from its contained namespace.
     * </p>
     * @throws ActionExecutionException if fail to execute the action, it will never be thrown
     *          in this method.
     */
    public void execute() throws ActionExecutionException {
        this.namespace.removeOwnedElement(this.comment);
        this.comment.setNamespace(null);
    }

    /**
     * <p>
     * Undo the remove action, it will add the comment back to the namespace.
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
