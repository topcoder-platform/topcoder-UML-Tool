/*
 * Copyright (C) 2007 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.uml.actions.auxiliary.comment.model;

import javax.swing.undo.CannotUndoException;

import com.topcoder.uml.actions.auxiliary.AbstractAuxiliaryUndoableAction;
import com.topcoder.uml.model.core.ModelElement;
import com.topcoder.uml.model.core.auxiliaryelements.Comment;
import com.topcoder.util.actionmanager.ActionExecutionException;

/**
 * <p>
 * This class extends the <code>AbstractAuxiliaryUndoableAction</code> abstract class,
 * and it is responsible for pasting the comment into the into the provided
 * <code>ModelElement</code>'s comments attribute.
 * </p>
 * <p>
 * Thread-safe: This class is immutable, but as the internal state of its variables could
 * be changed externally, this class is not guaranteed to be thread-safe.
 * </p>
 * @version 1.0
 * @author Standlove, TCSDEVELOPER
 */
public class PasteNoteRelationshipAction extends AbstractAuxiliaryUndoableAction {
    /**
     * <p>
     * Represents the presentation of this action.
     * </p>
     */
    private static final String NAME = "Paste Note Relationship Action";
    /**
     * <p>
     * Represents the <code>Comment</code> object to add to the <code>ModelElement</code>'s comments
     * attribute in execute method.
     * </p>
     * <p>
     * Initialized in constructor, and its
     * reference is never changed afterwards. Must be non-null.
     * </p>
     */
    private final Comment comment;

    /**
     * <p>
     * Represents the <code>ModelElement</code> object the comment is add to in execute
     * method.
     * </p>
     * <p>
     * Initialized in constructor, and its reference is never changed
     * afterwards. Must be non-null.
     * </p>
     */
    private final ModelElement parent;

    /**
     * <p>
     * Create a new <code>PasteNoteRelationshipAction</code> with given content
     * and the parent.
     * </p>
     * @param content
     *            the Comment object to add to the ModelElement's comments
     *            attribute
     * @param parent
     *            the ModelElement object the comment is add to
     * @throws IllegalArgumentException if any argument is null, or
     *          the content object is not of Comment type.
     */
    public PasteNoteRelationshipAction(Object content, ModelElement parent) {
        super(NAME);
        if (content == null) {
            throw new IllegalArgumentException("content cannot be null!");
        }
        if (!(content instanceof Comment)) {
            throw new IllegalArgumentException("content should be instance of Comment!");
        }
        if (parent == null) {
            throw new IllegalArgumentException("parent cannot be null!");
        }
        this.comment = (Comment) content;
        this.parent = parent;
    }

    /**
     * <p>
     * Execute the action, add the comment into the <code>ModelElement</code>'s comments list.
     * </p>
     * @throws ActionExecutionException if fail to execute the action, it will never be thrown
     *          in this method.
     */
    public void execute() throws ActionExecutionException {
        this.parent.addComment(this.comment);
        this.comment.addAnnotatedElement(this.parent);
    }

    /**
     * <p>
     * Undo the paste action, it will remove the comment from the modelElement.
     * </p>
     * @throws CannotUndoException If <code>canUndo</code> returns <code>false</code>.
     */
    public void undo() {
        // Call super.undo()
        super.undo();
        // Remove the comment, Note that here no exception will be thrown,
        // so we don't need to log exception
        this.parent.removeComment(this.comment);
        this.comment.removeAnnotatedElement(this.parent);
    }
}
