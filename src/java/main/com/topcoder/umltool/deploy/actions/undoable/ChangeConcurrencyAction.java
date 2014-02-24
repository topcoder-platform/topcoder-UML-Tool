/*
 * Copyright (C) 2007 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.umltool.deploy.actions.undoable;

import com.topcoder.uml.actions.general.UndoableAbstractAction;
import com.topcoder.uml.model.core.ModelElement;
import com.topcoder.uml.model.core.Operation;
import com.topcoder.uml.model.datatypes.CallConcurrencyKind;
import com.topcoder.umltool.deploy.DeployHelper;

/**
 * <p>
 * This class is a subclass of UndoableAbstractAction. This action will change the concurrency property of a model
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
public class ChangeConcurrencyAction extends UndoableAbstractAction {
    /**
     * <p>
     * Represents the model element to change the concurrency. This variable is set in the constructor, is immutable
     * (the reference) and never be null. This variable is referenced in the redoAction undoAction and executeAction
     * methods.
     * </p>
     */
    private final ModelElement element;

    /**
     * <p>
     * Represents the old concurrency of the model element before this action performed. This variable is set in the
     * constructor, is immutable (the reference) and never be null, possible empty. This variable is referenced in the
     * undoAction method.
     * </p>
     */
    private final CallConcurrencyKind oldConcurrency;

    /**
     * <p>
     * Represents the new concurrency of the model element after this action performed. This variable is set in the
     * constructor, is immutable (the reference )and never be null, possible empty. This variable is referenced in the
     * redoAction and executeAction methods.
     * </p>
     */
    private final CallConcurrencyKind newConcurrency;

    /**
     * <p>
     * Creates an instance of the ChangeConcurrencyAction.
     * </p>
     * @param element
     *            the non null model element to change the concurrency
     * @param concurrency
     *            the new concurrency of the model element
     * @throws IllegalArgumentException
     *             if any non null argument is null
     */
    public ChangeConcurrencyAction(ModelElement element, CallConcurrencyKind concurrency) {
        super("Change concurrency to " + concurrency);
        DeployHelper.checkNotNull(element, "element");
        DeployHelper.checkNotNull(concurrency, "concurrency");
        this.element = element;
        oldConcurrency = ((Operation) element).getConcurrency();
        newConcurrency = concurrency;
    }

    /**
     * <p>
     * Undo the change entity concurrency action.
     * </p>
     */
    public void undoAction() {
        updateConcurrency(oldConcurrency);
    }

    /**
     * <p>
     * Redo the change entity concurrency action.
     * </p>
     */
    public void redoAction() {
        updateConcurrency(newConcurrency);
    }

    /**
     * <p>
     * Execute the change entity concurrency action.
     * </p>
     */
    public void executeAction() {
        updateConcurrency(newConcurrency);
    }

    /**
     * <p>
     * Changes entity's concurrency property.
     * </p>
     * @param concurrency
     *            the new value of concurrency property
     */
    private void updateConcurrency(CallConcurrencyKind concurrency) {
        ((Operation) element).setConcurrency(concurrency);
    }
}
