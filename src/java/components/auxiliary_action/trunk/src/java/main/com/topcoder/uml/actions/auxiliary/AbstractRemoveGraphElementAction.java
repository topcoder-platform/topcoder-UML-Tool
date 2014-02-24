/*
 * Copyright (C) 2007 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.uml.actions.auxiliary;

import javax.swing.undo.CannotUndoException;

import com.topcoder.diagraminterchange.GraphElement;
import com.topcoder.util.actionmanager.ActionExecutionException;

/**
 * <p>
 * This abstract class extends the <code>{@link AbstractAuxiliaryUndoableAction}</code>
 * abstract class, and it is used as the base class for all actions that are responsible
 * for removing graph element from its parent graph node.
 * </p>
 * <p>
 * Thread-safety: As the internal state of its variables (node and parent) can be changed,
 * so it is not thread-safe.
 * </p>
 * @version 1.0
 * @author Standlove, TCSDEVELOPER
 */
public abstract class AbstractRemoveGraphElementAction extends AbstractAuxiliaryUndoableAction {
    /**
     * <p>
     * Represents the child graph element to remove from its parent graph node
     * in <code>execute</code> method.
     * </p>
     */
    private final GraphElement node;

    /**
     * <p>
     * Represents the parent graph node the child graph element to remove from
     * in <code>execute</code> method.
     * </p>
     */
    private final GraphElement parent;

    /**
     * <p>
     * Create a new <code>AbstractRemoveGraphElementAction</code> with given
     * presentation name and the graph element to remove.
     * </p>
     * @param name
     *            the presentation name of the undoable action.
     * @param node
     *            the child graph element to remove from its parent graph node.
     * @throws IllegalArgumentException If any argument is null, or name is empty string,
     *      or node's container is null.
     */
    protected AbstractRemoveGraphElementAction(String name, GraphElement node) {
        super(name);
        if (node == null) {
            throw new IllegalArgumentException("node cannot be null!");
        }
        if (node.getContainer() == null) {
            throw new IllegalArgumentException("container of the node cannot be null!");
        }
        this.node = node;
        this.parent = node.getContainer();
    }

    /**
     * <p>
     * Execute the action, remove the child graph element from its parent graph node.
     * </p>
     * @throws ActionExecutionException If fail to execute the action.
     */
    public void execute() throws ActionExecutionException {
        // remove the node from its parent
        this.parent.removeContained(this.node);
        this.node.setContainer(null);
    }

    /**
     * <p>
     * Undo the remove action, it will add the child graph element back to its parent graph node.
     * </p>
     * <p>
     * Note that exceptions except <code>CannotRedoException</code> will be logged.
     * </p>
     *
     * @throws CannotUndoException
     *             If <code>canUndo</code> returns <code>false</code>.
     */
    public void undo() {
        // call super.undo()
        super.undo();
        // add the node back to its parent
        this.parent.addContained(this.node);
        this.node.setContainer(this.parent);
    }
}
