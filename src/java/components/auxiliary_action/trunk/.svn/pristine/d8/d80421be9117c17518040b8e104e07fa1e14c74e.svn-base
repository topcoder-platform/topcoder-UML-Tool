/*
 * Copyright (C) 2007 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.uml.actions.auxiliary.comment.model;

import javax.swing.undo.CannotUndoException;

import com.topcoder.uml.actions.auxiliary.AbstractAuxiliaryUndoableAction;
import com.topcoder.uml.model.core.Namespace;
import com.topcoder.uml.model.core.auxiliaryelements.Comment;
import com.topcoder.uml.modelmanager.UMLModelManager;
import com.topcoder.util.actionmanager.ActionExecutionException;

/**
 * <p>
 * This class extends the <code>AbstractAuxiliaryUndoableAction</code> abstract class, and it
 * is responsible for pasting the comment into the <code>Model</code> or the provided
 * <code>Namespace</code>.
 * </p>
 * <p>
 * Thread-safe: This class is immutable, but as the internal state of
 * its variables could be changed externally, this class is not guaranteed to be
 * thread-safe.
 * </p>
 * @version 1.0
 * @author Standlove, TCSDEVELOPER
 */
public class PasteCommentAction extends AbstractAuxiliaryUndoableAction {
    /**
     * <p>
     * Represents the presentation of this action.
     * </p>
     */
    private static final String NAME = "Paste Comment Action";

    /**
     * <p>
     * Represents the <code>Comment</code> object to add to the model or namespace in execute
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
     * Represents the <code>Namespace</code> object to the comment is added to in execute
     * method.
     * </p>
     * <p>
     * Initialized in constructor, and its reference is never changed
     * afterwards. Must be non-null.
     * </p>
     */
    private final Namespace namespace;

    /**
     * <p>
     * Represents the <code>UMLModelManager</code> object to get necessary data in ctor &
     * execute method.
     * </p>
     * <p>
     * Initialized in constructor, and its reference is never
     * changed afterwards. Must be non-null.
     * </p>
     */
    private final UMLModelManager modelManager;

    /**
     * <p>
     * Create a new <code>PasteCommentAction</code> with given content
     * and UML model manager.
     * </p>
     * @param content
     *            the Comment object to add to the model.
     * @param modelManager
     *            the UMLModelManager object to get necessary data
     * @throws IllegalArgumentException if any argument is null, or
     *          the content is not a Comment object, or modelManager's model is null,
     *          or namespace of the modelManager's model is null.
     */
    public PasteCommentAction(Object content, UMLModelManager modelManager) {
        super(NAME);
        if (!(content instanceof Comment)) {
            throw new IllegalArgumentException("content should be instance of Comment!");
        }
        if (modelManager == null) {
            throw new IllegalArgumentException("modelManager cannot be null!");
        }
        if (modelManager.getModel() == null) {
            throw new IllegalArgumentException("model of modelManager cannot be null!");
        }
        this.comment = (Comment) content;
        this.namespace = modelManager.getModel();
        this.modelManager = modelManager;
    }

    /**
     * <p>
     * Create a new <code>PasteCommentAction</code> with given content,
     * namespace, and UML model manager.
     * </p>
     * @param content
     *            the Comment object to add to the model.
     * @param namespace
     *            the Namespace object to the comment is added to
     * @param modelManager
     *            the UMLModelManager object to get necessary data
     * @throws IllegalArgumentException if any argument is null, or
     *          the content is not a Comment object.
     */
    public PasteCommentAction(Object content, Namespace namespace, UMLModelManager modelManager) {
        super(NAME);
        if (content == null) {
            throw new IllegalArgumentException("content cannot be null!");
        }
        if (!(content instanceof Comment)) {
            throw new IllegalArgumentException("content should be instance of Comment!");
        }
        if (modelManager == null) {
            throw new IllegalArgumentException("modelManager cannot be null!");
        }
        if (namespace == null) {
            throw new IllegalArgumentException("namespace cannot be null!");
        }
        this.comment = (Comment) content;
        this.namespace = namespace;
        this.modelManager = modelManager;
    }

    /**
     * <p>
     * Execute the action, add the comment into the namespace.
     * </p>
     * @throws ActionExecutionException if fail to execute the action, it will never be thrown
     *          in this method.
     */
    public void execute() throws ActionExecutionException {
        // Add the comment
        this.namespace.addOwnedElement(this.comment);
        this.comment.setNamespace(this.namespace);
    }

    /**
     * <p>
     * Undo the paste action, it will remove the comment from the namespace.
     * </p>
     * @throws CannotUndoException If <code>canUndo</code> returns <code>false</code>.
     */
    public void undo() {
        // Call super.undo()
        super.undo();
        // Remove the comment, Note that here no exception will be thrown,
        // so we don't need to log exception
        this.namespace.removeOwnedElement(this.comment);
        this.comment.setNamespace(null);
    }
}
