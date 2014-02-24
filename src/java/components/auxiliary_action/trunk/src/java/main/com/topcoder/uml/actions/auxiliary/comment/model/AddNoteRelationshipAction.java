/*
 * Copyright (C) 2007 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.uml.actions.auxiliary.comment.model;

import javax.swing.undo.CannotUndoException;

import com.topcoder.uml.actions.auxiliary.AbstractAuxiliaryUndoableAction;
import com.topcoder.uml.model.core.ModelElement;
import com.topcoder.uml.model.core.auxiliaryelements.Comment;
import com.topcoder.uml.modelmanager.UMLModelManager;
import com.topcoder.uml.projectconfiguration.ProjectConfigurationException;
import com.topcoder.uml.projectconfiguration.ProjectConfigurationManager;
import com.topcoder.util.actionmanager.ActionExecutionException;

/**
 * <p>
 * This class extends the <code>AbstractAuxiliaryUndoableAction</code> abstract class, and it
 * is responsible for adding the comment into the provided <code>ModelElement</code>'s
 * comments attribute, it will also use the <code>ProjectConfigurationManager</code>
 * retrieved from <code>UMLModelManager</code> to apply initial formatting to the added
 * element.
 * </p>
 * <p>
 * Thread-safe: This class is immutable, but as the internal state of
 * its variables could be changed externally, this class is not guaranteed to be
 * thread-safe.
 * </p>
 * @version 1.0
 * @author Standlove, TCSDEVELOPER
 */
public class AddNoteRelationshipAction extends AbstractAuxiliaryUndoableAction {
    /**
     * <p>
     * Represents the presentation of this action.
     * </p>
     */
    private static final String NAME = "Add Note Relationship Action";
    /**
     * <p>
     * Represents the <code>Comment</code> object to add to the <code>ModelElement</code>'s
     * comments attribute in execute method.
     * </p>
     * <p>
     * Initialized in constructor, and its reference is never changed afterwards.
     * Must be non-null.
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
     * Create a new <code>AddNoteRelationshipAction</code> with comment to add,
     * the parent node, and the UML model manager.
     * </p>
     * @param comment
     *            the Comment object to add to the ModelElement's comments
     *            attribute
     * @param parent
     *            the ModelElement object the comment is add to
     * @param modelManager
     *            the UMLModelManager object to get necessary data
     * @throws IllegalArgumentException if any argument is null.
     */
    public AddNoteRelationshipAction(Comment comment, ModelElement parent, UMLModelManager modelManager) {
        super(NAME);
        if (comment == null) {
            throw new IllegalArgumentException("comment cannot be null!");
        }
        if (parent == null) {
            throw new IllegalArgumentException("parent cannot be null!");
        }
        if (modelManager == null) {
            throw new IllegalArgumentException("modelManager cannot be null!");
        }
        this.comment = comment;
        this.parent = parent;
        this.modelManager = modelManager;
    }

    /**
     * <p>
     * Execute the action, add the comment into the <code>ModelElement</code>'s comments list.
     * </p>
     * @throws ActionExecutionException if fail to execute the action.
     */
    public void execute() throws ActionExecutionException {
        try {
            // Add the comment
            this.parent.addComment(this.comment);
            this.comment.addAnnotatedElement(this.parent);
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
     * Undo the add action, it will remove the comment from the modelElement.
     * </p>
     * <p>
     * Note that exceptions except <code>CannotRedoException</code> will be logged.
     * </p>
     * @throws CannotUndoException If <code>canUndo</code> returns <code>false</code>.
     */
    public void undo() {
        // Call super.undo()
        super.undo();
        // Remove the comment
        this.parent.removeComment(this.comment);
        this.comment.removeAnnotatedElement(this.parent);
    }
}
