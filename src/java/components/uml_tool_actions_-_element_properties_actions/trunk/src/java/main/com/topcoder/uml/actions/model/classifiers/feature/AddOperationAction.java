/*
 * Copyright (C) 2006 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.uml.actions.model.classifiers.feature;

import com.topcoder.uml.actions.general.Helper;
import com.topcoder.uml.actions.general.UndoableAbstractAction;
import com.topcoder.uml.model.core.Classifier;
import com.topcoder.uml.model.core.Operation;

/**
 * <p>
 * This class is a subclass of UndoableAbstractAction. This action will add an operation to a classifier. The
 * operation is added to the features list of the classifier.
 * </p>
 * <p>
 * This class will be created by the application directly. The application can call redo to redo the action, undo
 * to undo the action and execute to execute the action. If any exception prevents redo/undo methods from
 * completing successfully, it should be log with logError.
 * </p>
 * <p>
 * <b>Thread Safety</b>: This class is not thread safe by containing mutable state information.
 * </p>
 *
 * @author kinzz, rainday
 * @version 1.0
 */
public class AddOperationAction extends UndoableAbstractAction {

    /**
     * <p>
     * Represents the operation to be add to the classifier. This variable is set in the constructor, is immutable
     * (the reference) and never be null. This variable is referenced in the redoAction and executeAction methods.
     * </p>
     */
    private final Operation operation;

    /**
     * <p>
     * Represents the classifier to add operation. This variable is set in the constructor, is immutable (the
     * reference) and never be null. This variable is referenced in the redoAction undoAction and executeAction
     * methods.
     * </p>
     */
    private final Classifier classifier;

    /**
     * <p>
     * Constructor of the add operation action.
     * </p>
     *
     * @param classifier
     *            the non null classifier to add operation
     * @param operation
     *            the non null operation to be add to the classifier
     * @throws IllegalArgumentException
     *             if any non null argument is null
     */
    public AddOperationAction(Classifier classifier, Operation operation) {
        super("Add operation");
        Helper.checkNotNull(classifier, "classifier");
        Helper.checkNotNull(operation, "operation");
        this.classifier = classifier;
        this.operation = operation;
    }

    /**
     * <p>
     * Undo the add operation action.
     * </p>
     */
    public void undoAction() {
        classifier.removeFeature(operation);
    }

    /**
     * <p>
     * Execute the add operation action.
     * </p>
     */
    public void executeAction() {
        classifier.addFeature(operation);
    }

    /**
     * <p>
     * Redo the add operation action.
     * </p>
     */
    public void redoAction() {
        executeAction();
    }
}
