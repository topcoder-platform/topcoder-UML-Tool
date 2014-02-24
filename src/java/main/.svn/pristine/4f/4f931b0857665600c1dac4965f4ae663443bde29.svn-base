/*
 * Copyright (C) 2007 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.umltool.deploy.actions.undoable;

import com.topcoder.uml.actions.general.UndoableAbstractAction;
import com.topcoder.uml.model.core.ModelElement;
import com.topcoder.uml.model.core.Operation;
import com.topcoder.uml.model.core.classifiers.Class;
import com.topcoder.uml.model.core.classifiers.Enumeration;
import com.topcoder.uml.model.core.classifiers.Interface;
import com.topcoder.uml.model.core.extensionmechanisms.Stereotype;
import com.topcoder.uml.model.modelmanagement.Model;
import com.topcoder.uml.model.modelmanagement.Package;
import com.topcoder.uml.model.modelmanagement.Subsystem;
import com.topcoder.uml.model.usecases.Actor;
import com.topcoder.uml.model.usecases.UseCase;
import com.topcoder.uml.modelmanager.UMLModelManager;
import com.topcoder.uml.projectconfiguration.ProjectConfigurationManager;
import com.topcoder.umltool.deploy.DeployHelper;

/**
 * <p>
 * This class is a subclass of UndoableAbstractAction. This action will change the abstract property of a model element.
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
public class ChangeAbstractAction extends UndoableAbstractAction {
    /**
     * <p>
     * Represents the model element to change the abstract. This variable is set in the constructor, is immutable (the
     * reference) and never be null. This variable is referenced in the redoAction undoAction and executeAction methods.
     * </p>
     */
    private final ModelElement element;

    /**
     * <p>
     * Represents the old abstract of the model element before this action performed. This variable is set in the
     * constructor, is immutable (the reference) and never be null, possible empty. This variable is referenced in the
     * undoAction method.
     * </p>
     */
    private final boolean oldIsAbstract;

    /**
     * <p>
     * Represents the new abstract of the model element after this action performed. This variable is set in the
     * constructor, is immutable (the reference )and never be null, possible empty. This variable is referenced in the
     * redoAction and executeAction methods.
     * </p>
     */
    private final boolean newIsAbstract;

    /**
     * <p>
     * Creates an instance of the ChangeAbstractAction.
     * </p>
     * @param element
     *            the non null model element to change the abstract
     * @param isAbstract
     *            the new abstract of the model element
     * @throws IllegalArgumentException
     *             if any non null argument is null
     */
    public ChangeAbstractAction(ModelElement element, boolean isAbstract) {
        super("Change abstract to " + isAbstract);
        DeployHelper.checkNotNull(element, "element");
        this.element = element;
        if (element instanceof Package) {
            oldIsAbstract = ((Package) element).isAbstract();
        } else if (element instanceof Interface) {
            oldIsAbstract = ((Interface) element).isAbstract();
        } else if (element instanceof Class) {
            oldIsAbstract = ((Class) element).isAbstract();
        } else if (element instanceof Enumeration) {
            oldIsAbstract = ((Enumeration) element).isAbstract();
        } else if (element instanceof Operation) {
            oldIsAbstract = ((Operation) element).isAbstract();
        } else if (element instanceof Actor) {
            oldIsAbstract = ((Actor) element).isAbstract();
        } else if (element instanceof UseCase) {
            oldIsAbstract = ((UseCase) element).isAbstract();
        } else if (element instanceof Subsystem) {
            oldIsAbstract = ((Subsystem) element).isAbstract();
        } else {
            oldIsAbstract = false;
        }
        newIsAbstract = isAbstract;
    }

    /**
     * <p>
     * Undo the change entity abstract action.
     * </p>
     */
    public void undoAction() {
        updateAbstract(oldIsAbstract);
    }

    /**
     * <p>
     * Redo the change entity abstract action.
     * </p>
     */
    public void redoAction() {
        updateAbstract(newIsAbstract);
    }

    /**
     * <p>
     * Execute the change entity abstract action.
     * </p>
     */
    public void executeAction() {
        updateAbstract(newIsAbstract);
    }

    /**
     * <p>
     * Changes entity's abstract property.
     * </p>
     * @param isAbstract
     *            the new value of abstract property
     */
    private void updateAbstract(boolean isAbstract) {
        if (element instanceof Package) {
            ((Package) element).setAbstract(isAbstract);
        } else if (element instanceof Interface) {
            ((Interface) element).setAbstract(isAbstract);
        } else if (element instanceof Class) {
            ((Class) element).setAbstract(isAbstract);
            updateClassStereotype(isAbstract);
        } else if (element instanceof Enumeration) {
            ((Enumeration) element).setAbstract(isAbstract);
        } else if (element instanceof Operation) {
            ((Operation) element).setAbstract(isAbstract);
        } else if (element instanceof Actor) {
            ((Actor) element).setAbstract(isAbstract);
        } else if (element instanceof UseCase) {
            ((UseCase) element).setAbstract(isAbstract);
        } else if (element instanceof Subsystem) {
            ((Subsystem) element).setAbstract(isAbstract);
        }
    }

    /**
     * <p>
     * Changes class's abstract stereotype.
     * </p>
     * @param isAbstract
     *            the new value of abstract property
     */
    private void updateClassStereotype(boolean isAbstract) {
        if (isAbstract) {
            for (Stereotype stereotype : element.getStereotypes()) {
                if (stereotype.getName().equals("abstract")) {
                    return;
                }
            }
            UMLModelManager umlModelManager = UMLModelManager.getInstance();

            Model model = umlModelManager.getModel();
            for (ModelElement modelElement : model.getOwnedElements()) {
                if (element instanceof Stereotype) {
                    Stereotype stereotype = (Stereotype) modelElement;
                    if (stereotype.getBaseClass().equals("Class") && stereotype.getName().equals("abstract")) {
                        element.addStereotype(stereotype);
                        return;
                    }
                }
            }

            try {
                ProjectConfigurationManager pcm = umlModelManager.getProjectConfigurationManager();
                for (Stereotype stereotype : pcm.getStandardStereotypes(umlModelManager.getProjectLanguage(), "Class")) {
                    if (stereotype.getName().equals("abstract")) {
                        element.addStereotype(stereotype);
                        model.addOwnedElement(stereotype);
                        return;
                    }
                }
            } catch (Exception e) {
                // ignore
            }

        } else {
            for (Stereotype stereotype : element.getStereotypes()) {
                if (stereotype.getName().equals("abstract")) {
                    element.removeStereotype(stereotype);
                    return;
                }
            }
        }
    }
}
