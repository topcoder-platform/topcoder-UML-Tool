/*
 * Copyright (C) 2006 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.uml.actions.general;

import com.topcoder.uml.model.core.ModelElement;
import com.topcoder.uml.model.datatypes.VisibilityKind;

/**
 * <p>
 * This class is a subclass of UndoableAbstractAction. This action will change the visibility of a
 * model element - ModelElement.visibility property.
 * </p>
 * <p>
 * This class will be created by the application directly. The application can call redo to redo the
 * action, undo to undo the action and execute to execute the action.
 * </p>
 * <p>
 * <b>Thread Safety</b>: This class is not thread safe by containing mutable state information.
 * </p>
 *
 * @author kinzz, rainday
 * @version 1.0
 */
public class ChangeEntityVisibilityAction extends UndoableAbstractAction {

    /**
     * <p>
     * Represents the model element to change the visibility. This variable is set in the
     * constructor, is immutable (the reference) and never be null. This variable is referenced in
     * the redoAction undoAction and executeAction methods.
     * </p>
     */
    private final ModelElement element;

    /**
     * <p>
     * Represents the old visibility of the model element before this action performed. This
     * variable is set in the constructor, is immutable (the reference). This variable is referenced
     * in the doAction method.
     * </p>
     */
    private final VisibilityKind oldVisibility;

    /**
     * <p>
     * Represents the new visibility of the model element before this action performed. This
     * variable is set in the constructor, is immutable (the reference). This variable is referenced
     * in the redoAction and executeAction methods.
     * </p>
     */
    private final VisibilityKind newVisibility;

    /**
     * <p>
     * Constructor of the change entity visibility action.
     * </p>
     *
     * @param element
     *        the non null model element to change the visibility
     * @param visibility
     *        the non null new visibility of the?model element
     * @throws IllegalArgumentException
     *         if any non null argument is null
     */
    public ChangeEntityVisibilityAction(ModelElement element, VisibilityKind visibility) {
        super("Change entity visibility to " + visibility);
        Helper.checkNotNull(element, "element");
        Helper.checkNotNull(visibility, "visibility");
        this.element = element;
        oldVisibility = element.getVisibility();
        newVisibility = visibility;
    }

    /**
     * <p>
     * Redo the change entity visibility action.
     * </p>
     */
    public void redoAction() {
        element.setVisibility(newVisibility);
    }

    /**
     * <p>
     * Undo the change entity visibility action.
     * </p>
     */
    public void undoAction() {
        element.setVisibility(oldVisibility);
    }

    /**
     * <p>
     * Execute the change entity visibility action.
     * </p>
     */
    public void executeAction() {
        element.setVisibility(newVisibility);
    }
}
