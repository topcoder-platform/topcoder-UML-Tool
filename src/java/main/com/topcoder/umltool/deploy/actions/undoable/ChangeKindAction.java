/*
 * Copyright (C) 2007 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.umltool.deploy.actions.undoable;

import com.topcoder.uml.actions.general.UndoableAbstractAction;
import com.topcoder.uml.model.core.ModelElement;
import com.topcoder.uml.model.core.Parameter;
import com.topcoder.uml.model.datatypes.ParameterDirectionKind;
import com.topcoder.umltool.deploy.DeployHelper;

/**
 * <p>
 * This class is a subclass of UndoableAbstractAction. This action will change the kind property of a model element.
 * </p>
 * <p>
 * This class will be created by the application directly. The application can call redo to redo the action, undo to
 * undo the action and execute to execute the action.
 * </p>
 * <p>
 * <b>Thread Safety</b>: This class is not thread safe by containing mutable state information.
 * </p>
 * @author ly, FireIce, ylouis
 * @version 1.0
 */
public class ChangeKindAction extends UndoableAbstractAction {
    /**
     * <p>
     * Represents the model element to change the kind. This variable is set in the constructor, is immutable (the
     * reference) and never be null. This variable is referenced in the redoAction undoAction and executeAction methods.
     * </p>
     */
    private final ModelElement element;

    /**
     * <p>
     * Represents the old kind of the model element before this action performed. This variable is set in the
     * constructor, is immutable (the reference) and never be null, possible empty. This variable is referenced in the
     * undoAction method.
     * </p>
     */
    private final ParameterDirectionKind oldKind;

    /**
     * <p>
     * Represents the new kind of the model element after this action performed. This variable is set in the
     * constructor, is immutable (the reference )and never be null, possible empty. This variable is referenced in the
     * redoAction and executeAction methods.
     * </p>
     */
    private final ParameterDirectionKind newKind;

    /**
     * <p>
     * Creates an instance of the ChangeKindAction.
     * </p>
     * @param element
     *            the non null model element to change the kind
     * @param kind
     *            the new kind of the model element
     * @throws IllegalArgumentException
     *             if any non null argument is null
     */
    public ChangeKindAction(ModelElement element, ParameterDirectionKind kind) {
        super("Change kind to " + kind);
        DeployHelper.checkNotNull(element, "element");
        DeployHelper.checkNotNull(kind, "kind");
        this.element = element;
        oldKind = ((Parameter) element).getKind();
        newKind = kind;
    }

    /**
     * <p>
     * Undo the change entity kind action.
     * </p>
     */
    public void undoAction() {
        updateKind(oldKind);
    }

    /**
     * <p>
     * Redo the change entity kind action.
     * </p>
     */
    public void redoAction() {
        updateKind(newKind);
    }

    /**
     * <p>
     * Execute the change entity kind action.
     * </p>
     */
    public void executeAction() {
        updateKind(newKind);
    }

    /**
     * <p>
     * Changes entity's kind property.
     * </p>
     * @param kind
     *            the new value of kind property
     */
    private void updateKind(ParameterDirectionKind kind) {
        ((Parameter) element).setKind(kind);
    }
}
