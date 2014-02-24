/*
 * Copyright (C) 2007 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.uml.actions.auxiliary.comment.model;

import javax.swing.undo.CannotUndoException;

import com.topcoder.uml.actions.auxiliary.AbstractAuxiliaryUndoableAction;
import com.topcoder.uml.model.core.Namespace;
import com.topcoder.uml.model.core.auxiliaryelements.Comment;
import com.topcoder.uml.modelmanager.UMLModelManager;
import com.topcoder.uml.projectconfiguration.ProjectConfigurationException;
import com.topcoder.uml.projectconfiguration.ProjectConfigurationManager;
import com.topcoder.util.actionmanager.ActionExecutionException;

/**
 * <p>
 * This class extends the <code>AbstractAuxiliaryUndoableAction</code> abstract class,
 * and it is responsible for adding the comment into the <code>Model</code> or the provided
 * <code>Namespace</code>, it will also use the <code>ProjectConfigurationManager</code> retrieved from
 * <code>UMLModelManager</code> to apply initial formatting to the added element.
 * </p>
 * <p>
 * Thread-safe: This class is immutable, but as the internal state of its
 * variables could be changed externally, this class is not guaranteed to be
 * thread-safe.
 * </p>
 * @version 1.0
 * @author Standlove, TCSDEVELOPER
 */
public class AddCommentAction extends AbstractAuxiliaryUndoableAction {
    /**
     * <p>
     * Represents the presentation of this action.
     * </p>
     */
    private static final String NAME = "Add Comment Action";
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
     * Create a new <code>AddCommentAction</code> with comment to add,
     * and the UML model manager.
     * </p>
     * @param comment
     *            the Comment object to add to the model.
     * @param modelManager
     *            the UMLModelManager object to get necessary data
     * @throws IllegalArgumentException If any argument is null, or modelManager's model is null
     */
    public AddCommentAction(Comment comment, UMLModelManager modelManager) {
        super(NAME);
        if (comment == null) {
            throw new IllegalArgumentException("comment cannot be null!");
        }
        if (modelManager == null) {
            throw new IllegalArgumentException("modelManager cannot be null!");
        }
        if (modelManager.getModel() == null) {
            throw new IllegalArgumentException("model of the modelManager cannot be null!");
        }
        this.comment = comment;
        this.modelManager = modelManager;
        this.namespace = modelManager.getModel();
    }

    /**
     * <p>
     * Create a new <code>AddCommentAction</code> with comment to add,
     * the namespace to which the comment is added to, and the UML model manager.
     * </p>
     * @param comment
     *            the Comment object to add to the namespace
     * @param namespace
     *            the Namespace object to the comment is added to
     * @param modelManager
     *            the UMLModelManager object to get necessary data
     * @throws IllegalArgumentException if any argument is null.
     */
    public AddCommentAction(Comment comment, Namespace namespace, UMLModelManager modelManager) {
        super(NAME);
        if (comment == null) {
            throw new IllegalArgumentException("comment cannot be null!");
        }
        if (modelManager == null) {
            throw new IllegalArgumentException("modelManager cannot be null!");
        }
        if (namespace == null) {
            throw new IllegalArgumentException("namespace cannot be null!");
        }
        this.comment = comment;
        this.modelManager = modelManager;
        this.namespace = namespace;
    }

    /**
     * <p>
     * Execute the action, add the comment into the namespace.
     * </p>
     * @throws ActionExecutionException if fail to execute the action.
     */
    public void execute() throws ActionExecutionException {
        try {
            // Add the comment
            this.namespace.addOwnedElement(this.comment);
            this.comment.setNamespace(this.namespace);
            // Apply the initial formatting
            ProjectConfigurationManager pcManager = this.modelManager.getProjectConfigurationManager();
            if (modelManager.getProjectLanguage() == null) {
                throw new ActionExecutionException("The project language is null.");
            }
            if (modelManager.getProjectLanguage().trim().length() == 0) {
                throw new ActionExecutionException("The project language is empty.");
            }
            pcManager.applyInitialFormatting(modelManager.getProjectLanguage(), this.comment);
        } catch (IllegalStateException ise) {
            throw new ActionExecutionException("Error occurs while executing the action!", ise);
        } catch (ProjectConfigurationException e) {
            throw new ActionExecutionException("Error occurs while executing the action!", e);
        }
    }

    /**
     * <p>
     * Undo the add action, it will remove the comment from the namespace.
     * </p>
     * @throws CannotUndoException If <code>canUndo</code> returns <code>false</code>.
     */
    public void undo() {
       // Call super.undo()
        super.undo();
        // Remove the comment
        this.namespace.removeOwnedElement(this.comment);
        this.comment.setNamespace(null);
    }
}
