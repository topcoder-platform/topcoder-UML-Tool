/*
 * Copyright (C) 2006 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.umltool.deploy.actions.undoable;

import com.topcoder.uml.actions.general.UndoableAbstractAction;
import com.topcoder.uml.model.core.Classifier;
import com.topcoder.uml.model.core.Operation;
import com.topcoder.uml.model.core.StructuralFeatureAbstractImpl;
import com.topcoder.umltool.deploy.DeployHelper;

/**
 * <p>
 * This class is a subclass of UndoableAbstractAction. This action will remove an operation from a classifier. The
 * operation is removed to the features list of the classifier.
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
 * @author ly
 * @version 1.0
 */
public class RemoveOperationAction extends UndoableAbstractAction {

    /**
     * <p>
     * Represents the classifier to remove attribute. This variable is set in the constructor, is immutable (the
     * reference) and never be null. This variable is referenced in the redoAction undoAction and executeAction
     * methods.
     * </p>
     */
    private final Classifier classifier;

    /**
     * <p>
     * Represents the operation to be remove from the classifier. This variable is set in the constructor, is
     * immutable (the reference) and never be null. This variable is referenced in the redoAction and executeAction
     * methods.
     * </p>
     */
    private final Operation operation;

    /**
     * <p>
     * Represents the old position of the operation.
     * </p>
     */
    private int position;

    /**
     * <p>
     * Constructor of the remove operation action.
     * </p>
     *
     * @param classifier
     *            the non null classifier to remove attribute
     * @param operation
     *            the non null operation to be remove from the classifier
     * @throws IllegalArgumentException
     *             if any non null argument is null
     */
    public RemoveOperationAction(Classifier classifier, Operation operation) {
        super("Remove Operation");
        DeployHelper.checkNotNull(classifier, "classifier");
        DeployHelper.checkNotNull(operation, "operation");
        this.classifier = classifier;
        this.operation = operation;
    }

    /**
     * <p>
     * Execute the remove operation action.
     * </p>
     */
    public void executeAction() {
        position = classifier.getFeatures().indexOf(operation);
        redoAction();
    }

    /**
     * <p>
     * Undo the remove operation action.
     * </p>
     */
    public void undoAction() {
        if (position != -1) {
            classifier.addFeature(position, operation);
        }
    }

    /**
     * <p>
     * Redo the remove operation action.
     * </p>
     */
    public void redoAction() {
        if (position != -1) {
            classifier.removeFeature(operation);
        }
    }
}
