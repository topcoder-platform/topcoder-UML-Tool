/*
 * Copyright (C) 2007 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.uml.actions.auxiliary;

import java.awt.datatransfer.Clipboard;

import javax.swing.undo.CannotUndoException;

import com.topcoder.diagraminterchange.GraphElement;
import com.topcoder.util.actionmanager.ActionExecutionException;

/**
 * <p>
 * This abstract class extends the <code>{@link AbstractAuxiliaryUndoableAction}</code>
 * abstract class, and it is used as the base class for all actions that are responsible
 * for copying the child graph element to the clipboard and removing the child
 * graph element from its parent graph node.
 * </p>
 * <p>
 * Subclasses need to override the <code>copyToClipboard</code> method to copy
 * the node to clipboard.
 * </p>
 * <p>
 * Thread-safety: As the internal state of its variables (node and parent) can be changed,
 * so it is not thread-safe.
 * </p>
 * @version 1.0
 * @author Standlove, TCSDEVELOPER
 */
public abstract class AbstractCutGraphElementAction extends AbstractAuxiliaryUndoableAction {

    /**
     * <p>
     * Represents the child graph element to cut from its parent graph node
     * in execute method.
     * </p>
     */
    private final GraphElement node;

    /**
     * <p>
     * Represents the parent graph node the child graph element to cut from
     * in execute method.
     * </p>
     */
    private final GraphElement parent;

    /**
     * <p>
     * Represents the clipboard the child graph element is copied to in execute
     * method. Note that it could be null if the node is copied to system
     * clipboard.
     * </p>
     */
    private final Clipboard clipboard;

    /**
     * <p>
     * Create a new <code>AbstractCutGraphElementAction</code> with given
     * presentation name, the child graph element to cut, and the clipboard
     * to which the child graph element is copied to.
     * </p>
     * @param name
     *            the presentation name of the action
     * @param node
     *            the child graph element to remove from its parent graph node
     * @param clipboard
     *            the clipboard the child graph element is copied to
     * @throws IllegalArgumentException If any argument except clipboard is null, or
     *      name is empty string, or node's container is null.
     */
    protected AbstractCutGraphElementAction(String name, GraphElement node, Clipboard clipboard) {
        super(name);
        if (node == null) {
            throw new IllegalArgumentException("node cannot be null!");
        }
        if (node.getContainer() == null) {
            throw new IllegalArgumentException("parent of the node cannot be null!");
        }
        this.node = node;
        this.parent = node.getContainer();
        this.clipboard = clipboard;
    }

    /**
     * <p>
     * Execute the action, remove the child graph element from its parent graph node.
     * </p>
     * @throws ActionExecutionException If fail to execute the action.
     */
    public void execute() throws ActionExecutionException {
        // copy the node to clipboard
        this.copyToClipboard(this.node, this.clipboard);
        // remove it from its parent
        this.parent.removeContained(this.node);
        this.node.setContainer(null);
    }

    /**
     * <p>
     * Undo the cut action, it will add the child graph element back to its
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
        // add the node back to its parent
        this.parent.addContained(this.node);
        this.node.setContainer(this.parent);
    }

    /**
     * <p>
     * Abstract method for subclasses to override, this method should copy the
     * given graph element to the given clipboard, if the given clipboard is
     * null, use system clipboard instead.
     * </p>
     *
     * @param node
     *            the graph element to copy to clipboard.
     * @param clipboard
     *            the clipboard to copy the graph element to.
     * @throws IllegalArgumentException
     *             If the node is null.
     * @throws ActionExecutionException
     *             If fail to copy the graph element to the clipboard.
     */
    protected abstract void copyToClipboard(GraphElement node, Clipboard clipboard) throws ActionExecutionException;
}
