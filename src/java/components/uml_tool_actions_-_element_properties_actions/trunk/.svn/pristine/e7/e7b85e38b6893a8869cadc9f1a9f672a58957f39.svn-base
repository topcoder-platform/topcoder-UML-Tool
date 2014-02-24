/*
 * Copyright (C) 2006 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.uml.actions.model.classifiers.feature;

import java.util.Iterator;

import com.topcoder.uml.actions.general.Helper;
import com.topcoder.uml.actions.general.UndoableAbstractAction;
import com.topcoder.uml.model.core.Classifier;
import com.topcoder.uml.model.core.Feature;
import com.topcoder.uml.model.core.Operation;
import com.topcoder.util.actionmanager.ActionExecutionException;

/**
 * <p>
 * This class is a subclass of UndoableAbstractAction. This action will update the position of the
 * operation among the other operations of the classifier.
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
public class UpdateOperationOrderAction extends UndoableAbstractAction {

    /**
     * <p>
     * Represents the new position of the operation which is the new index of the operation in the
     * features list. It should &gt;=0 and &lt;number of the operations. This variable is set in the
     * constructor, is immutable. This variable is referenced in the redoAction and executeAction
     * methods.
     * </p>
     */
    private final int newPosition;

    /**
     * <p>
     * Represents the old position of the attribute which is the old index of the operation in the
     * features list. It should &gt;=0 and &lt;number of the operations. This variable is set in the
     * constructor, is immutable. This variable is referenced in the redoAction and executeAction
     * methods.
     * </p>
     */
    private final int oldPosition;

    /**
     * <p>
     * Represents the classifier to update operation order. This variable is set in the constructor,
     * is immutable (the reference) and never be null. This variable is referenced in the redoAction
     * undoAction and executeAction methods.
     * </p>
     */
    private final Classifier classifier;

    /**
     * <p>
     * Constructor of the add attribute action.
     * </p>
     *
     * @param classifier
     *        the non null classifier to update operation order
     * @param operation
     *        the non null operation to update the order
     * @param position
     *        the new position of the operation
     * @throws IllegalArgumentException
     *         if any non null argument is null or the position is < 0 or >=number of the
     *         operations.
     */
    public UpdateOperationOrderAction(Classifier classifier, Operation operation, int position) {
        super("Update operation order");
        Helper.checkNotNull(classifier, "classifier");
        Helper.checkNotNull(operation, "operation");
        this.classifier = classifier;
        Iterator<Feature> iter = classifier.getFeatures().iterator();
        // findPosition represents the index of the *operation* in the list.
        int operationIndex = -1, featureIndex = -1, findOldPosition = -1, findNewPosition = -1;
        Feature feature = null;
        while (iter.hasNext()) {
            feature = iter.next();
            featureIndex++;
            if (Operation.class.isAssignableFrom(feature.getClass())) {
                operationIndex++;
                if (findOldPosition == -1 && feature == operation) {
                    findOldPosition = featureIndex;
                }
                if (operationIndex == position) {
                    findNewPosition = featureIndex;
                }
            }
        }

        if (findNewPosition == -1) {
            throw new IllegalArgumentException("The position passed should be in range of [0, operations.num).");
        }

        if (findOldPosition == -1) {
            // can't find the operation, do nothing in the redoAction, executeAction and undoAction.
            oldPosition = -1;
            newPosition = -1;
        } else {
            oldPosition = findOldPosition;
            newPosition = findNewPosition;
        }
    }

    /**
     * <p>
     * Redo the update operation order action.
     * </p>
     */
    public void redoAction() {
        if (oldPosition != -1 && newPosition != -1) {
            Feature element = classifier.removeFeature(oldPosition);
            classifier.addFeature(newPosition, element);
        }
    }

    /**
     * <p>
     * Execute the update operation order action.
     * </p>
     *
     * @throws ActionExecutionException
     *         if any exception prevents this method from completing successfully
     */
    public void executeAction() throws ActionExecutionException {
        try {
            redoAction();
        } catch (Exception e) {
            throw new ActionExecutionException("Execute UpdateOperationOrderAction incorrectly.");
        }
    }

    /**
     * <p>
     * Undo the update operation order action.
     * </p>
     */
    public void undoAction() {
        if (oldPosition != -1 && newPosition != -1) {
            Feature element = classifier.removeFeature(newPosition);
            classifier.addFeature(oldPosition, element);
        }
    }
}
