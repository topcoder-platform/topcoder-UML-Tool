/*
 * Copyright (C) 2006 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.uml.actions.general;

import com.topcoder.diagraminterchange.GraphElement;
import com.topcoder.diagraminterchange.Point;

/**
 * <p>
 * This class is a subclass of UndoableAbstractAction. This action is for changing the position of a
 * graph element.
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
public class ChangePositionAction extends UndoableAbstractAction {

    /**
     * <p>
     * Represents the graph element to change the position. This variable is set in the constructor,
     * is immutable (the reference) and never be null. This variable is referenced in the redoAction
     * undoAction and executeAction methods.
     * </p>
     */
    private final GraphElement element;

    /**
     * <p>
     * Represents the old position of the graph element before this action performed. This variable
     * is set in the constructor, is immutable (the reference). This variable is referenced in the
     * undoAction method.
     * </p>
     */
    private final Point oldPosition;

    /**
     * <p>
     * Represents the new position of the graph element after this action performed. This variable
     * is set in the constructor, is immutable (the reference). This variable is referenced in the
     * redoAction and executeAction methods.
     * </p>
     */
    private final Point newPosition;

    /**
     * <p>
     * Constructor of the change position action.
     * </p>
     *
     * @param element
     *        the non null graph element to change the position
     * @param position
     *        the non null new position of the graph element
     * @throws IllegalArgumentException
     *         if any non null argument is null
     */
    public ChangePositionAction(GraphElement element, Point position) {
        super("Change position to " + position);
        Helper.checkNotNull(element, "element");
        Helper.checkNotNull(position, "position");
        this.element = element;
        oldPosition = element.getPosition();
        newPosition = position;
    }

    /**
     * <p>
     * Execute the change position action.
     * </p>
     */
    public void executeAction() {
        element.setPosition(newPosition);
    }

    /**
     * <p>
     * Undo the change position action.
     * </p>
     */
    public void undoAction() {
        element.setPosition(oldPosition);
    }

    /**
     * <p>
     * Redo the change position action.
     * </p>
     */
    public void redoAction() {
        element.setPosition(newPosition);
    }
}
