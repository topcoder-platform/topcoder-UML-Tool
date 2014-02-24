/*
 * Copyright (C) 2007 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.umltool.deploy.actions.undoable;

import com.topcoder.uml.actions.general.UndoableAbstractAction;
import com.topcoder.uml.model.core.Attribute;
import com.topcoder.uml.model.core.Classifier;
import com.topcoder.uml.model.core.Feature;
import com.topcoder.uml.model.core.ModelElement;
import com.topcoder.uml.model.core.Operation;
import com.topcoder.uml.model.core.classifiers.Class;
import com.topcoder.uml.model.core.classifiers.Enumeration;
import com.topcoder.uml.model.core.classifiers.Interface;
import com.topcoder.uml.model.core.relationships.AssociationEnd;
import com.topcoder.uml.model.datatypes.ScopeKind;
import com.topcoder.umltool.deploy.DeployHelper;

/**
 * <p>
 * This class is a subclass of UndoableAbstractAction. This action will change the Static property of a model element.
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
public class ChangeStaticAction extends UndoableAbstractAction {
    /**
     * <p>
     * Represents the model element to change the Static. This variable is set in the constructor, is immutable (the
     * reference) and never be null. This variable is referenced in the redoAction undoAction and executeAction methods.
     * </p>
     */
    private final ModelElement element;

    /**
     * <p>
     * Represents the old Static of the model element before this action performed. This variable is set in the
     * constructor, is immutable (the reference) and never be null, possible empty. This variable is referenced in the
     * undoAction method.
     * </p>
     */
    private final boolean oldIsStatic;

    /**
     * <p>
     * Represents the new Static of the model element after this action performed. This variable is set in the
     * constructor, is immutable (the reference )and never be null, possible empty. This variable is referenced in the
     * redoAction and executeAction methods.
     * </p>
     */
    private final boolean newIsStatic;

    /**
     * <p>
     * Creates an instance of the ChangeStaticAction.
     * </p>
     * @param element
     *            the non null model element to change the Static
     * @param isStatic
     *            the new Static of the model element
     * @throws IllegalArgumentException
     *             if any non null argument is null
     */
    public ChangeStaticAction(ModelElement element, boolean isStatic) {
        super("Change Static to " + isStatic);
        DeployHelper.checkNotNull(element, "element");
        this.element = element;
        if (element instanceof Interface && isInClassifierNamespace(element)) {
            oldIsStatic = ((Interface) element).isRoot();
        } else if (element instanceof Class && isInClassifierNamespace(element)) {
            oldIsStatic = ((Class) element).isRoot();
        } else if (element instanceof Enumeration && isInClassifierNamespace(element)) {
            oldIsStatic = ((Enumeration) element).isRoot();
        } else if (element instanceof Operation) {
            oldIsStatic = ((Operation) element).isRoot();
        } else if (element instanceof Attribute) {
            oldIsStatic = ((Feature) element).getOwnerScope() == ScopeKind.CLASSIFIER;
        } else if (element instanceof AssociationEnd) {
            oldIsStatic = ((AssociationEnd) element).getTargetKind() == ScopeKind.CLASSIFIER;
        } else {
            // the Static modifier is not supported
            oldIsStatic = false;
        }
        newIsStatic = isStatic;
    }

    /**
     * <p>
     * Undo the change entity Static action.
     * </p>
     */
    public void undoAction() {
        updateStatic(oldIsStatic);
    }

    /**
     * <p>
     * Redo the change entity Static action.
     * </p>
     */
    public void redoAction() {
        updateStatic(newIsStatic);
    }

    /**
     * <p>
     * Execute the change entity Static action.
     * </p>
     */
    public void executeAction() {
        updateStatic(newIsStatic);
    }

    /**
     * <p>
     * Changes entity's Static property.
     * </p>
     * @param isStatic
     *            the new value of Static property
     */
    private void updateStatic(boolean isStatic) {
        if (element instanceof Interface && isInClassifierNamespace(element)) {
            ((Interface) element).setRoot(isStatic);
        } else if (element instanceof Class && isInClassifierNamespace(element)) {
            ((Class) element).setRoot(isStatic);
        } else if (element instanceof Enumeration && isInClassifierNamespace(element)) {
            ((Enumeration) element).setRoot(isStatic);
        } else if (element instanceof Feature) {
            if (isStatic) {
                ((Feature) element).setOwnerScope(ScopeKind.CLASSIFIER);
            } else {
                ((Feature) element).setOwnerScope(ScopeKind.INSTANCE);
            }
        } else if (element instanceof AssociationEnd) {
            if (isStatic) {
                ((AssociationEnd) element).setTargetKind(ScopeKind.CLASSIFIER);
            } else {
                ((AssociationEnd) element).setTargetKind(ScopeKind.INSTANCE);
            }
        }
    }

    /**
     * <p>
     * This method checks whether the given model element is in a <code>Classifier</code> <code>Namespace</code>.
     * </p>
     * @param element
     *            the model element to check
     * @return true if the given model element is in a <code>Classifier</code> <code>Namespace</code>, false
     *         otherwise
     */
    private boolean isInClassifierNamespace(ModelElement element) {
        return element.getNamespace() instanceof Classifier;
    }
}
