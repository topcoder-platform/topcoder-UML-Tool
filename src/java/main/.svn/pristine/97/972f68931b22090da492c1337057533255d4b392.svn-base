/*
 * Copyright (C) 2007 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.umltool.deploy.actions.undoable;

import com.topcoder.uml.actions.general.UndoableAbstractAction;
import com.topcoder.uml.model.core.Classifier;
import com.topcoder.uml.model.core.ModelElement;
import com.topcoder.uml.model.core.classifiers.Class;
import com.topcoder.uml.model.core.classifiers.Enumeration;
import com.topcoder.uml.model.core.classifiers.Interface;
import com.topcoder.uml.model.modelmanagement.Package;
import com.topcoder.uml.model.modelmanagement.Subsystem;
import com.topcoder.uml.model.usecases.Actor;
import com.topcoder.uml.model.usecases.UseCase;
import com.topcoder.umltool.deploy.DeployHelper;

/**
 * <p>
 * This class is a subclass of UndoableAbstractAction. This action will change the root property of a model element.
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
public class ChangeRootAction extends UndoableAbstractAction {
    /**
     * <p>
     * Represents the model element to change the root. This variable is set in the constructor, is immutable (the
     * reference) and never be null. This variable is referenced in the redoAction undoAction and executeAction methods.
     * </p>
     */
    private final ModelElement element;

    /**
     * <p>
     * Represents the old root of the model element before this action performed. This variable is set in the
     * constructor, is immutable (the reference) and never be null, possible empty. This variable is referenced in the
     * undoAction method.
     * </p>
     */
    private final boolean oldIsRoot;

    /**
     * <p>
     * Represents the new root of the model element after this action performed. This variable is set in the
     * constructor, is immutable (the reference )and never be null, possible empty. This variable is referenced in the
     * redoAction and executeAction methods.
     * </p>
     */
    private final boolean newIsRoot;

    /**
     * <p>
     * Creates an instance of the ChangeRootAction.
     * </p>
     * @param element
     *            the non null model element to change the root
     * @param isRoot
     *            the new root of the model element
     * @throws IllegalArgumentException
     *             if any non null argument is null
     */
    public ChangeRootAction(ModelElement element, boolean isRoot) {
        super("Change root to " + isRoot);
        DeployHelper.checkNotNull(element, "element");
        this.element = element;
        if (element instanceof Package && !isInClassifierNamespace(element)) {
            oldIsRoot = ((Package) element).isRoot();
        } else if (element instanceof Interface && !isInClassifierNamespace(element)) {
            oldIsRoot = ((Interface) element).isRoot();
        } else if (element instanceof Class && !isInClassifierNamespace(element)) {
            oldIsRoot = ((Class) element).isRoot();
        } else if (element instanceof Enumeration && !isInClassifierNamespace(element)) {
            oldIsRoot = ((Enumeration) element).isRoot();
        } else if (element instanceof Actor) {
            oldIsRoot = ((Actor) element).isRoot();
        } else if (element instanceof UseCase) {
            oldIsRoot = ((UseCase) element).isRoot();
        } else if (element instanceof Subsystem) {
            oldIsRoot = ((Subsystem) element).isRoot();
        } else {
            // the root modifier is not supported
            oldIsRoot = false;
        }
        newIsRoot = isRoot;
    }

    /**
     * <p>
     * Undo the change entity root action.
     * </p>
     */
    public void undoAction() {
        updateRoot(oldIsRoot);
    }

    /**
     * <p>
     * Redo the change entity root action.
     * </p>
     */
    public void redoAction() {
        updateRoot(newIsRoot);
    }

    /**
     * <p>
     * Execute the change entity root action.
     * </p>
     */
    public void executeAction() {
        updateRoot(newIsRoot);
    }

    /**
     * <p>
     * Changes entity's root property.
     * </p>
     * @param isRoot
     *            the new value of root property
     */
    private void updateRoot(boolean isRoot) {
        if (element instanceof Package && !isInClassifierNamespace(element)) {
            ((Package) element).setRoot(isRoot);
        } else if (element instanceof Interface && !isInClassifierNamespace(element)) {
            ((Interface) element).setRoot(isRoot);
        } else if (element instanceof Class && !isInClassifierNamespace(element)) {
            ((Class) element).setRoot(isRoot);
        } else if (element instanceof Enumeration && !isInClassifierNamespace(element)) {
            ((Enumeration) element).setRoot(isRoot);
        } else if (element instanceof Actor) {
            ((Actor) element).setRoot(isRoot);
        } else if (element instanceof UseCase) {
            ((UseCase) element).setRoot(isRoot);
        } else if (element instanceof Subsystem) {
            ((Subsystem) element).setRoot(isRoot);
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
