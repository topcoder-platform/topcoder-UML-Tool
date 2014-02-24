/*
 * Copyright (C) 2006 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.uml.actions.general;

import com.topcoder.diagraminterchange.Dimension;
import com.topcoder.diagraminterchange.GraphNode;

/**
 * <p>
 * This class is a subclass of UndoableAbstractAction. This action is for changing the size of a
 * graph node.
 * </p>
 * <p>
 * This class will be created by the application directly. The application can call redo to redo the
 * action, undo to undo the action and execute to execute the action. If any exception prevents
 * redo/undo methods from completing successfully, it should be log with logError.
 * </p>
 * <p>
 * <b>Thread Safety</b>: This class is not thread safe by containing mutable state information.
 * </p>
 *
 * @author kinzz, rainday
 * @version 1.0
 */
public class ChangeSizeAction extends UndoableAbstractAction {

    /**
     * <p>
     * Represents the graph node to be changing the size. This variable is set in the constructor,
     * is immutable (the reference) and never be null. This variable is referenced in the redoAction
     * undoAction and executeAction methods.
     * </p>
     */
    private final GraphNode node;

    /**
     * <p>
     * Represents the old size of the graph node before this action performed. This variable is set
     * in the constructor, is immutable (the reference). This variable is referenced in the
     * undoAction method.
     * </p>
     */
    private final Dimension oldSize;

    /**
     * <p>
     * Represents the new size of the graph node after this action performed. This variable is set
     * in the constructor, is immutable (the reference). This variable is referenced in the
     * redoAction and executeAction methods.
     * </p>
     */
    private final Dimension newSize;

    /**
     * <p>
     * Constructor of the change size action.
     * </p>
     *
     * @param node
     *        the non null graph node to be changing the size
     * @param size
     *        the non null new size of the graph node
     * @throws IllegalArgumentException
     *         if any non null argument is null
     */
    public ChangeSizeAction(GraphNode node, Dimension size) {
        super("Change size to " + size);
        Helper.checkNotNull(node, "node");
        Helper.checkNotNull(size, "size");
        this.node = node;
        oldSize = node.getSize();
        newSize = size;
    }

    /**
     * <p>
     * Execute the change size action.
     * </p>
     */
    public void executeAction() {
        node.setSize(newSize);
    }

    /**
     * <p>
     * Undo the change size action.
     * </p>
     */
    public void undoAction() {
        node.setSize(oldSize);
    }

    /**
     * <p>
     * Redo the change size action.
     * </p>
     */
    public void redoAction() {
        node.setSize(newSize);
    }
}
