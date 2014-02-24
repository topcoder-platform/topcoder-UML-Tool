/*
 * Copyright (C) 2007 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.umltool.deploy.actions.undoable;

import com.topcoder.diagraminterchange.DiagramElement;
import com.topcoder.diagraminterchange.GraphElement;
import com.topcoder.uml.actions.diagram.elements.DiagramElementUndoableAction;
import com.topcoder.umltool.deploy.DeployHelper;
import com.topcoder.util.actionmanager.ActionExecutionException;

/**
 * <p>
 * This action is used to remove one DiagramElement from its container.
 * </p>
 * @author ly, FireIce, ylouis
 * @version 1.0
 */
public class RemoveDiagramElementAction extends DiagramElementUndoableAction {

    /**
     * <p>
     * Represents the child GraphElement to be removed from the parent GraphElement.
     * </p>
     * <p>
     * This variable will not be null and will not be changed.
     * </p>
     */
    private final DiagramElement child;

    /**
     * <p>
     * Creates an instance of RemoveDiagramElementAction.
     * </p>
     * @param parent
     *            the parent element
     * @param child
     *            child to be deleted
     * @throws IllegalArgumentException
     *             if any of the argument is null
     */
    public RemoveDiagramElementAction(GraphElement parent, DiagramElement child) {
        super(parent);

        DeployHelper.checkNotNull(parent, "parent");
        DeployHelper.checkNotNull(child, "child");

        this.child = child;
    }

    /**
     * <p>
     * Returns the child GraphElement to be added.
     * </p>
     * @return the child graph element
     */
    public DiagramElement getChild() {
        return this.child;
    }

    /**
     * <p>
     * Executes the remove Action, remove the child element from the parent element.
     * </p>
     * @throws ActionExecutionException
     *             if fail to execute action
     */
    public void execute() throws ActionExecutionException {
        performAction();
        this.executionSuccess();
    }

    /**
     * <p>
     * Redo the add action.
     * </p>
     * <p>
     * Execute the remove action, remove the child element from the parent element.
     * </p>
     */
    public void redo() {
        super.redo();

        performAction();
        this.redoSuccess();
    }

    /**
     * <p>
     * Undo the add action.
     * </p>
     */
    public void undo() {
        super.undo();
        this.getElement().addContained(child);
        child.setContainer(this.getElement());
        this.undoSuccess();
    }

    /**
     * <p>
     * Performs the remove action, remove the child element from the parent element.
     * </p>
     */
    private void performAction() {
        // remove the child element from the parent element
        this.getElement().removeContained(child);
    }
}
