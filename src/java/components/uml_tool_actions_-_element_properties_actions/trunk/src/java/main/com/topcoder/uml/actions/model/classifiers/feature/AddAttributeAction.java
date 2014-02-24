/*
 * Copyright (C) 2006 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.uml.actions.model.classifiers.feature;

import com.topcoder.uml.actions.general.Helper;
import com.topcoder.uml.actions.general.UndoableAbstractAction;
import com.topcoder.uml.model.core.Attribute;
import com.topcoder.uml.model.core.Classifier;

/**
 * <p>
 * This class is a subclass of UndoableAbstractAction. This action will add an attribute to a classifier. The attribute
 * is added to the features list of the classifier.
 * </p>
 * <p>
 * This class will be created by the application directly. The application can call redo to redo the action, undo to
 * undo the action and execute to execute the action. If any exception prevents redo/undo methods from completing
 * successfully, it should be log with logError.
 * </p>
 * <p>
 * <b>Thread Safety</b>: This class is not thread safe by containing mutable state information.
 * </p>
 * @author kinzz, rainday
 * @version 1.0
 */
public class AddAttributeAction extends UndoableAbstractAction {

    /**
     * <p>
     * Represents the classifier to add attribute. This variable is set in the constructor, is immutable (the reference)
     * and never be null. This variable is referenced in the redoAction undoAction and executeAction methods.
     * </p>
     */
    private final Classifier classifier;

    /**
     * <p>
     * Represents the attribute to be add to the classifier. This variable is set in the constructor, is immutable (the
     * reference) and never be null. This variable is referenced in the redoAction and executeAction methods.
     * </p>
     */
    private final Attribute attribute;

    /**
     * <p>
     * Constructor of the add attribute action.
     * </p>
     * @param classifier
     *            the non null classifier to add attribute
     * @param attribute
     *            the non null attribute to be add to the classifier
     * @throws IllegalArgumentException
     *             if any non null argument is null
     */
    public AddAttributeAction(Classifier classifier, Attribute attribute) {
        super("Add Attribute");
        Helper.checkNotNull(classifier, "classifier");
        Helper.checkNotNull(attribute, "attribute");
        this.classifier = classifier;
        this.attribute = attribute;
    }

    /**
     * <p>
     * Execute the add attribute action.
     * </p>
     */
    public void executeAction() {
        classifier.addFeature(attribute);
    }

    /**
     * <p>
     * Undo the add attribute action.
     * </p>
     */
    public void undoAction() {
        classifier.removeFeature(attribute);
    }

    /**
     * <p>
     * Redo the add attribute action.
     * </p>
     */
    public void redoAction() {
        classifier.addFeature(attribute);
    }
}
