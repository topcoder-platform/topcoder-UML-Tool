/*
 * Copyright (C) 2006 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.uml.actions.model.custom;

import com.topcoder.uml.model.core.Classifier;
import com.topcoder.uml.actions.general.Helper;
import com.topcoder.uml.actions.general.UndoableAbstractAction;

/**
 * <p>
 * This class is a subclass of UndoableAbstractAction. This action will mark a class static - the
 * GeneralizableElement.isLeaf property.
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
public class MarkClassifierFinalAction extends UndoableAbstractAction {

    /**
     * <p>
     * Represents the classifier to change the isLeaf attribute. This variable is set in the
     * constructor, is immutable (the reference) and never be null. This variable is referenced in
     * the doAction and undoAction method.
     * </p>
     */
    private final Classifier classifier;

    /**
     * <p>
     * Represents the new isLeaf attribute of the classifier. This variable is set in the
     * constructor, is immutable. This variable is referenced in the redoAction and execute methods.
     * </p>
     */
    private final boolean newIsLeaf;

    /**
     * <p>
     * Represents the old isLeaf attribute of the classifier before this action performed. This
     * variable is set in the constructor, is immutable. This variable is referenced in the
     * undoAction method.
     * </p>
     */
    private final boolean oldIsLeaf;

    /**
     * <p>
     * Constructor of the mark classifier final action.
     * </p>
     *
     * @param classifier
     *        the non null classifier to change the isLeaf attribute
     * @param isLeaf
     *        the new isLeaf attribute of the classifier
     * @throws IllegalArgumentException
     *         if classifier is null
     */
    public MarkClassifierFinalAction(Classifier classifier, boolean isLeaf) {
        super("Mark classifier final action to " + isLeaf);
        Helper.checkNotNull(classifier, "classifier");
        this.classifier = classifier;
        oldIsLeaf = classifier.isLeaf();
        newIsLeaf = isLeaf;
    }

    /**
     * <p>
     * Redo the mark classifier final action.
     * </p>
     */
    public void redoAction() {
        classifier.setLeaf(newIsLeaf);
    }

    /**
     * <p>
     * Execute the mark classifier final action.
     * </p>
     */
    public void executeAction() {
        classifier.setLeaf(newIsLeaf);
    }

    /**
     * <p>
     * Undo the mark classifier final action.
     * </p>
     */
    public void undoAction() {
        classifier.setLeaf(oldIsLeaf);
    }
}
