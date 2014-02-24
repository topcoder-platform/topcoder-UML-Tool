/*
 * Copyright (C) 2007 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.uml.actions.auxiliary;

import javax.swing.undo.CannotUndoException;

import com.topcoder.diagraminterchange.GraphElement;
import com.topcoder.diagraminterchange.GraphNode;
import com.topcoder.uml.modelmanager.UMLModelManager;
import com.topcoder.uml.projectconfiguration.ProjectConfigurationException;
import com.topcoder.uml.projectconfiguration.ProjectConfigurationManager;
import com.topcoder.util.actionmanager.ActionExecutionException;

/**
 * <p>
 * This abstract class extends the <code>{@link AbstractAuxiliaryUndoableAction}</code>
 * abstract class, and it is used as the base-class for all actions that are responsible
 * for adding graph element into another graph node.
 * </p>
 * <p>
 * Thread-safety: As the internal state of its variables (child and parent) can be changed,
 * so it is not thread-safe.
 * </p>
 * @version 1.0
 * @author Standlove, TCSDEVELOPER
 */
public abstract class AbstractAddGraphElementAction extends AbstractAuxiliaryUndoableAction {

    /**
     * <p>
     * Represents the child graph element to add to the parent graph node in
     * <code>execute</code> method.
     * </p>
     */
    private final GraphElement child;

    /**
     * <p>
     * Represents the parent graph node the child graph element to add to in
     * <code>execute</code> method.
     * </p>
     *
     */
    private final GraphNode parent;

    /**
     * <p>
     * Represents the <code>UMLModelManager</code> object to apply initial formatting
     * in the <code>execute</code> method.
     * </p>
     *
     */
    private final UMLModelManager modelManager;

    /**
     * <p>
     * Create a new <code>AbstractAddGraphElementAction</code> with the given presentation
     * name, the child graph element to add, the parent graph node and the UML model manager.
     * </p>
     * @param name
     *            the presentation name of the action
     * @param child
     *            the child graph element to add to the parent graph node
     * @param parent
     *            the parent graph node the child graph element to add to
     * @param modelManager
     *            the UMLModelManager object to apply initial formatting.
     * @throws IllegalArgumentException If any argument is null, or name is empty string.
     */
    protected AbstractAddGraphElementAction(String name, GraphElement child, GraphNode parent,
            UMLModelManager modelManager) {
        super(name);
        if (child == null) {
            throw new IllegalArgumentException("child cannot be null!");
        }
        if (parent == null) {
            throw new IllegalArgumentException("parent cannot be null!");
        }
        if (modelManager == null) {
            throw new IllegalArgumentException("modelManager cannot be null!");
        }
        this.child = child;
        this.parent = parent;
        this.modelManager = modelManager;
    }

    /**
     * <p>
     * Execute the action, add the child graph element into the parent graph node.
     * </p>
     * @throws ActionExecutionException If fail to execute the action.
     *         It is mainly used to wrap the underlying exceptions.
     */
    public void execute() throws ActionExecutionException {
        try {
            // add the child graph element
            this.parent.addContained(this.child);
            this.child.setContainer(this.parent);
            // apply initial formatting for the child
            ProjectConfigurationManager pcManager = this.modelManager.getProjectConfigurationManager();
            if (modelManager.getProjectLanguage() == null) {
                throw new ActionExecutionException("The project language is null.");
            }
            if (modelManager.getProjectLanguage().trim().length() == 0) {
                throw new ActionExecutionException("The project language is empty.");
            }
            pcManager.applyInitialFormatting(modelManager.getProjectLanguage(), this.child);
        } catch (IllegalStateException ise) {
            throw new ActionExecutionException("Error occurs while executing the action!", ise);
        } catch (ProjectConfigurationException e) {
            throw new ActionExecutionException("Error occurs while executing the action!", e);
        }
    }

    /**
     * <p>
     * Undo the add action, it will remove the child graph element from its
     * parent graph node.
     * </p>
     * <p>
     * Note that exceptions except <code>CannotRedoException</code> will be logged.
     * </p>
     * @throws CannotUndoException If <code>canUndo</code> returns <code>false</code>.
     */
    public void undo() {
        // call super.undo()
        super.undo();
        // remove the child from the parent
        this.parent.removeContained(this.child);
        this.child.setContainer(null);
    }
}
