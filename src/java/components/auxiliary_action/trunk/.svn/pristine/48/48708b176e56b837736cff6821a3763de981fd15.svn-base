/*
 * Copyright (C) 2007 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.uml.actions.auxiliary;

import javax.swing.undo.CannotUndoException;

import com.topcoder.diagraminterchange.GraphElement;
import com.topcoder.diagraminterchange.GraphNode;
import com.topcoder.util.actionmanager.ActionExecutionException;

/**
 * <p>
 * This abstract class extends the <code>{@link AbstractAuxiliaryUndoableAction}</code>
 * abstract class to paste the child graph element into the parent graph node.
 * It is used as the base class for all paste graph element actions.
 * </p>
 * <p>
 * Thread-safety: As the internal state of its variables (child and parent) can be changed,
 * so it is not thread-safe.
 * </p>
 * @version 1.0
 * @author Standlove, TCSDEVELOPER
 */
public abstract class AbstractPasteGraphElementAction extends AbstractAuxiliaryUndoableAction {

    /**
     * <p>
     * Represents the child graph element to paste to the parent graph node in
     * <code>execute</code> method.
     * </p>
     */
    private final GraphElement child;

    /**
     * <p>
     * Represents the parent graph node the child graph element to paste to in
     * <code>execute</code> method.
     * </p>
     */
    private final GraphNode parent;

    /**
     * <p>
     * Create a new <code>AbstractPasteGraphElementAction</code> with the given
     * presentation name, the content to paste and the graph node to
     * which the content to paste to.
     * </p>
     * @param name
     *            the presentation name of the action.
     * @param content
     *            the child graph element to paste.
     * @param parent
     *            the parent graph node the child graph element to add to.
     * @throws IllegalArgumentException If any argument is null, or name is empty string,
     *              or the content is not of <code>GraphElement</code> type.
     */
    protected AbstractPasteGraphElementAction(String name, Object content, GraphNode parent) {
        super(name);
        if (content == null) {
            throw new IllegalArgumentException("content cannot be null!");
        }
        if (parent == null) {
            throw new IllegalArgumentException("parent cannot be null!");
        }
        if (!(content instanceof GraphElement)) {
            throw new IllegalArgumentException("content should be instance of GraphElement!");
        }
        this.child = (GraphElement) content;
        this.parent = parent;
    }

    /**
     * <p>
     * Execute the action, add the child graph element into the parent graph node.
     * </p>
     * @throws ActionExecutionException If fail to execute the action.
     */
    public void execute() throws ActionExecutionException {
        this.parent.addContained(this.child);
        this.child.setContainer(this.parent);
    }

    /**
     * <p>
     * Undo the paste action, it will remove the child graph element from its
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
        // remove the child from its parent
        this.parent.removeContained(this.child);
        this.child.setContainer(null);
    }
}
