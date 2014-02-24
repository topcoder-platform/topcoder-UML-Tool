/*
 * Copyright (C) 2006 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.uml.actions.general;

import com.topcoder.diagraminterchange.DiagramElement;
import com.topcoder.diagraminterchange.GraphElement;
import com.topcoder.uml.actions.general.operationtypes.ChangeZOrderOperationType;
import com.topcoder.util.actionmanager.ActionExecutionException;

/**
 * <p>
 * This class is a subclass of UndoableAbstractAction. This action changes the order of the elements
 * in the same namespace. It changes the order of the contained graph elements of a namespace.
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
public class ChangeZOrderAction extends UndoableAbstractAction {

    /**
     * <p>
     * Represents the container of the given element. This variable is set in the constructor, is
     * immutable (the reference) and never be null. This variable is referenced in the redoAction
     * undoAction and executeAction methods.
     * </p>
     */
    private final GraphElement container;

    /**
     * <p>
     * Represents the old z-order of the graph element before this action performed. This variable
     * is set in the constructor, is immutable (the reference). This variable is referenced in the
     * undoAction method.
     * </p>
     */
    private final int oldZOrder;

    /**
     * <p>
     * Represents the new z-order of the graph element after this action performed. This variable is
     * set in the constructor, is immutable (the reference). This variable is referenced in the
     * redoAction and executeAction methods.
     * </p>
     */
    private final int newZOrder;

    /**
     * <p>
     * Constructor of the change z-order action, save the element,
     * get the new Z-order according to the operationType.
     * </p>
     *
     * @param element
     *        the non null graph element to change the z-order
     * @param operationType
     *        the non null operation type of the z-order change action
     * @throws IllegalArgumentException
     *         if any non null argument is null
     */
    public ChangeZOrderAction(DiagramElement element, ChangeZOrderOperationType operationType) {
        super("Change ZOrder by " + operationType);
        Helper.checkNotNull(element, "element");
        Helper.checkNotNull(operationType, "operationType");
        GraphElement node = element.getContainer();
        Helper.checkNotNull(node, "element's container");
        container = element.getContainer();
        Helper.checkNotNull(container, "element's container");
        // if the oldZorder is -1, we will do nothing in the redoAction, undoAction or
        // executeAction.
        oldZOrder = container.indexOfContained(element);

        if (operationType == ChangeZOrderOperationType.BACKWARD) {
            newZOrder = Math.min(oldZOrder + 1, container.countContaineds() - 1);
        } else if (operationType == ChangeZOrderOperationType.FORWARD) {
            if (oldZOrder >= 1) {
                newZOrder = oldZOrder - 1;
            } else {
                newZOrder = 0;
            }
        } else if (operationType == ChangeZOrderOperationType.TOBACK) {
            newZOrder = container.countContaineds() - 1;
        } else {
            newZOrder = 0;
        }
    }

    /**
     * <p>
     * Redo the change z-order action.
     * </p>
     */
    public void redoAction() {
        if (oldZOrder != newZOrder && oldZOrder != -1) {
            DiagramElement element = container.removeContained(oldZOrder);
            container.addContained(newZOrder, element);
        }
    }

    /**
     * <p>
     * Undo the change z-order action.
     * </p>
     */
    public void undoAction() {
        if (oldZOrder != newZOrder && oldZOrder != -1) {
            DiagramElement element = container.removeContained(newZOrder);
            container.addContained(oldZOrder, element);
        }
    }

    /**
     * <p>
     * Execute the change z-order action.
     * </p>
     *
     * @throws ActionExecutionException
     *         if any exception prevents this method from completing successfully
     */
    public void executeAction() throws ActionExecutionException {
        try {
            redoAction();
        } catch (Exception e) {
            throw new ActionExecutionException("Execute ChangeZOrderAction incorrectly.");
        }
    }
}
