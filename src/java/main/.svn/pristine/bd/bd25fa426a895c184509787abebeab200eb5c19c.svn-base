/*
 * Copyright (C) 2007 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.umltool.deploy.actions.undoable;

import com.topcoder.uml.actions.general.UndoableAbstractAction;
import com.topcoder.uml.model.core.ModelElement;
import com.topcoder.uml.model.core.Namespace;
import com.topcoder.umltool.deploy.DeployHelper;

/**
 * <p>
 * This class is a subclass of UndoableAbstractAction. This action will change the namespace property of a model
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
public class ChangeNamespaceAction extends UndoableAbstractAction {
    /**
     * <p>
     * Represents the model element to change the namespace. This variable is set in the constructor, is immutable (the
     * reference) and never be null. This variable is referenced in the redoAction undoAction and executeAction methods.
     * </p>
     */
    private final ModelElement element;

    /**
     * <p>
     * Represents the old namespace of the model element before this action performed. This variable is set in the
     * constructor, is immutable (the reference) and never be null, possible empty. This variable is referenced in the
     * undoAction method.
     * </p>
     */
    private final Namespace oldNamespace;

    /**
     * <p>
     * Represents the new namespace of the model element after this action performed. This variable is set in the
     * constructor, is immutable (the reference )and never be null, possible empty. This variable is referenced in the
     * redoAction and executeAction methods.
     * </p>
     */
    private final Namespace newNamespace;

    /**
     * <p>
     * Creates an instance of the ChangeNamespaceAction.
     * </p>
     * @param element
     *            the non null model element to change the namespace
     * @param namespace
     *            the new namespace of the model element
     * @throws IllegalArgumentException
     *             if any non null argument is null
     */
    public ChangeNamespaceAction(ModelElement element, Namespace namespace) {
        super("Change namespace to " + namespace);
        DeployHelper.checkNotNull(element, "element");
        DeployHelper.checkNotNull(namespace, "namespace");
        this.element = element;
        oldNamespace = element.getNamespace();
        newNamespace = namespace;
    }

    /**
     * <p>
     * Undo the change entity namespace action.
     * </p>
     */
    public void undoAction() {
        changeNamespace(newNamespace, oldNamespace);
    }

    /**
     * <p>
     * Redo the change entity namespace action.
     * </p>
     */
    public void redoAction() {
        changeNamespace(oldNamespace, newNamespace);
    }

    /**
     * <p>
     * Execute the change entity namespace action.
     * </p>
     */
    public void executeAction() {
        changeNamespace(oldNamespace, newNamespace);
    }

    /**
     * Change element's namaspace.
     * @param oldNs
     *            the old namespace
     * @param newNs
     *            the new namespace
     */
    private void changeNamespace(Namespace oldNs, Namespace newNs) {
        if (oldNs != null) {
            oldNs.removeOwnedElement(element);
        }
        if ((newNs != null)&& !newNs.containsOwnedElement(element)) {
            newNs.addOwnedElement(element);
        }
        element.setNamespace(newNs);
    }
}
