/*
 * Copyright (C) 2006 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.umltool.deploy.actions.undoable;

import com.topcoder.uml.actions.general.Helper;
import com.topcoder.uml.actions.general.UndoableAbstractAction;
import com.topcoder.uml.model.core.Attribute;
import com.topcoder.uml.model.core.Classifier;
import com.topcoder.uml.model.core.StructuralFeatureAbstractImpl;

/**
 * <p>
 * This class is a subclass of UndoableAbstractAction. This action will remove an attribute from a classifier. The
 * attribute is removed to the features list of the classifier.
 * </p>
 * <p>
 * This class will be created by the application directly. The application can call redo to redo the action, undo to
 * undo the action and execute to execute the action. If any exception prevents redo/undo methods from completing
 * successfully, it should be log with logError.
 * </p>
 * <p>
 * <b>Thread Safety</b>: This class is not thread safe by containing mutable state information.
 * </p>
 * @author ly
 * @version 1.0
 */
public class RemoveAttributeAction extends UndoableAbstractAction {

    /**
     * <p>
     * Represents the classifier to remove attribute. This variable is set in the constructor, is immutable (the
     * reference) and never be null. This variable is referenced in the redoAction undoAction and executeAction methods.
     * </p>
     */
    private final Classifier classifier;

    /**
     * <p>
     * Represents the attribute to be remove from the classifier. This variable is set in the constructor, is immutable
     * (the reference) and never be null. This variable is referenced in the redoAction and executeAction methods.
     * </p>
     */
    private final Attribute attribute;

    /**
     * <p>
     * Represents the old position of the attribute.
     * </p>
     */
    private int position;

    /**
     * <p>
     * Constructor of the remove attribute action.
     * </p>
     * @param classifier
     *            the non null classifier to remove attribute
     * @param attribute
     *            the non null attribute to be remove from the classifier
     * @throws IllegalArgumentException
     *             if any non null argument is null
     */
    public RemoveAttributeAction(Classifier classifier, Attribute attribute) {
        super("Remove Attribute");
        Helper.checkNotNull(classifier, "classifier");
        Helper.checkNotNull(attribute, "attribute");
        this.classifier = classifier;
        this.attribute = attribute;
    }

    /**
     * <p>
     * Execute the remove attribute action.
     * </p>
     */
    public void executeAction() {
        position = classifier.getFeatures().indexOf(attribute);
        redoAction();
    }

    /**
     * <p>
     * Undo the remove attribute action.
     * </p>
     */
    public void undoAction() {
        if (position != -1) {
            classifier.addFeature(position, attribute);
            StructuralFeatureAbstractImpl.setType(attribute, classifier);
        }
    }

    /**
     * <p>
     * Redo the remove attribute action.
     * </p>
     */
    public void redoAction() {
        if (position != -1) {
            classifier.removeFeature(attribute);
            StructuralFeatureAbstractImpl.setType(attribute, null);
        }
    }
}
