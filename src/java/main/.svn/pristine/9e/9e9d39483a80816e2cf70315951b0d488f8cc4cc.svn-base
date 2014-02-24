/*
 * Copyright (C) 2007 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.umltool.deploy.actions.undoable;

import com.topcoder.uml.actions.general.UndoableAbstractAction;
import com.topcoder.uml.model.actions.messagingactions.CallOperationAction;
import com.topcoder.uml.model.commonbehavior.instances.Stimulus;
import com.topcoder.uml.model.commonbehavior.procedure.Procedure;
import com.topcoder.uml.model.core.ModelElement;
import com.topcoder.umltool.deploy.DeployHelper;

/**
 * <p>
 * This class is a subclass of UndoableAbstractAction. This action will change the asynchronous property of a model
 * element.
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
public class ChangeAsynchronousAction extends UndoableAbstractAction {
    /**
     * <p>
     * Represents the model element to change the asynchronous. This variable is set in the constructor, is immutable
     * (the reference) and never be null. This variable is referenced in the redoAction undoAction and executeAction
     * methods.
     * </p>
     */
    private final ModelElement element;

    /**
     * <p>
     * Represents the old asynchronous of the model element before this action performed. This variable is set in the
     * constructor, is immutable (the reference) and never be null, possible empty. This variable is referenced in the
     * undoAction method.
     * </p>
     */
    private final boolean oldIsAsynchronous;

    /**
     * <p>
     * Represents the new asynchronous of the model element after this action performed. This variable is set in the
     * constructor, is immutable (the reference )and never be null, possible empty. This variable is referenced in the
     * redoAction and executeAction methods.
     * </p>
     */
    private final boolean newIsAsynchronous;

    /**
     * <p>
     * Creates an instance of the ChangeAsynchronousAction.
     * </p>
     * @param element
     *            the non null model element to change the asynchronous
     * @param isAsynchronous
     *            the new asynchronous of the model element
     * @throws IllegalArgumentException
     *             if any non null argument is null
     */
    public ChangeAsynchronousAction(ModelElement element, boolean isAsynchronous) {
        super("Change asynchronous to " + isAsynchronous);
        DeployHelper.checkNotNull(element, "element");
        this.element = element;
        if (element instanceof Stimulus) {
            Procedure procedure = ((Stimulus) element).getDispatchAction();
            if (procedure != null && procedure.getAction() instanceof CallOperationAction) {
                oldIsAsynchronous = ((CallOperationAction) procedure.getAction()).isAsynchronous();
            } else {
                oldIsAsynchronous = false;
            }
        } else {
            oldIsAsynchronous = false;
        }
        newIsAsynchronous = isAsynchronous;
    }

    /**
     * <p>
     * Undo the change entity asynchronous action.
     * </p>
     */
    public void undoAction() {
        updateAsynchronous(oldIsAsynchronous);
    }

    /**
     * <p>
     * Redo the change entity asynchronous action.
     * </p>
     */
    public void redoAction() {
        updateAsynchronous(newIsAsynchronous);
    }

    /**
     * <p>
     * Execute the change entity asynchronous action.
     * </p>
     */
    public void executeAction() {
        updateAsynchronous(newIsAsynchronous);
    }

    /**
     * <p>
     * Changes entity's asynchronous property.
     * </p>
     * @param isAsynchronous
     *            the new value of asynchronous property
     */
    private void updateAsynchronous(boolean isAsynchronous) {
        if (element instanceof Stimulus) {
            Procedure procedure = ((Stimulus) element).getDispatchAction();
            if (procedure != null && procedure.getAction() instanceof CallOperationAction) {
                ((CallOperationAction) procedure.getAction()).setAsynchronous(isAsynchronous);
            }
        }
    }
}
