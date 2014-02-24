/*
 * Copyright (C) 2007 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.uml.actions.auxiliary.comment.model;

import javax.swing.undo.CannotUndoException;

import com.topcoder.uml.actions.auxiliary.AbstractAuxiliaryUndoableAction;
import com.topcoder.uml.model.core.auxiliaryelements.Comment;
import com.topcoder.util.actionmanager.ActionExecutionException;

/**
 * <p>
 * This class extends <code>AbstractAuxiliaryUndoableAction</code> abstract class, it is used
 * to change the comment's body text to a new one.
 * </p>
 * <p>
 * Thread-safe: This class is immutable, but as the internal state of its comment variable could
 * be changed externally, this class is not guaranteed to be thread-safe.
 * </p>
 * @version 1.0
 * @author Standlove, TCSDEVELOPER
 */
public class ChangeCommentTextAction extends AbstractAuxiliaryUndoableAction {
    /**
     * <p>
     * Represents the presentation of this action.
     * </p>
     */
    private static final String NAME = "Change Comment Text Action";
    /**
     * <p>
     * Represents the <code>Comment</code> object whose body text to change in the execute
     * method.
     * </p>
     * <p>
     * Initialized in constructor, and its reference is never changed
     * afterwards. Must be non-null.
     * </p>
     */
    private final Comment comment;

    /**
     * <p>
     * Represents the old body text of the comment, used in undo method.
     * </p>
     * <p>
     * Initialized in constructor, and it is never changed afterwards. Could be
     * null or empty string.
     * </p>
     */
    private final String oldText;

    /**
     * <p>
     * Represents the new body text of the comment, used in execute method.
     * </p>
     * <p>
     * Initialized in constructor, and it is never changed afterwards. Could be
     * null or empty string.
     * </p>
     */
    private final String newText;

    /**
     * <p>
     * Create a new <code>ChangeCommentTextAction</code> with comment to change,
     * and the new text.
     * </p>
     * @param comment
     *            the Comment object whose body text to change
     * @param newText
     *            the new comment text.
     * @throws IllegalArgumentException if the comment argument is null.
     */
    public ChangeCommentTextAction(Comment comment, String newText) {
        super(NAME);
        if (comment == null) {
            throw new IllegalArgumentException("comment cannot be null!");
        }
        this.comment = comment;
        this.oldText = comment.getBody();
        this.newText = newText;
    }

    /**
     * <p>
     * Execute the action, change the comment's body text to the new one.
     * </p>
     * @throws ActionExecutionException If fail to execute the
     *          action. It is mainly used to wrap the underlying exceptions. It is never
     *          thrown in this method.
     */
    public void execute() throws ActionExecutionException {
        this.comment.setBody(this.newText);
    }

    /**
     * <p>
     * Undo the change comment text action, it will change the comment's body
     * text back.
     * </p>
     * @throws CannotUndoException If <code>canUndo</code> returns <code>false</code>.
     */
    public void undo() {
        // Call super.undo()
        super.undo();
        // reset the comment's body
        this.comment.setBody(this.oldText);
    }
}
