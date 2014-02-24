/*
 * Copyright (C) 2006 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.uml.actions.model.usecase;

import com.topcoder.uml.model.core.ModelElement;
import com.topcoder.uml.model.core.Namespace;
import com.topcoder.uml.modelmanager.UMLModelManager;
import com.topcoder.uml.projectconfiguration.ProjectConfigurationException;
import com.topcoder.uml.projectconfiguration.ProjectConfigurationManager;

import com.topcoder.util.actionmanager.ActionExecutionException;
import com.topcoder.util.log.Level;


/**
 * <p>
 * This abstract class extends from UsecaseUndoableAction. It implement all logic of add action for all elements in
 * component.  It contains three methods execute(), redo(), undo(). Also  this class is responsible for applying
 * initial formatting of elements.
 * </p>
 *
 * <p>
 * Class is not thread safety because it extends  from mutable class.
 * </p>
 *
 * @author tushak, TCSDEVELOPER
 * @version 1.0
 */
abstract class AddAction extends UsecaseUndoableAction {
    /**
     * <p>
     * Represent UMLModelManager reference for current add action class. It used for applying initial formatting.
     * </p>
     */
    private final UMLModelManager manager;

    /**
     * <p>
     * Represent Namespace instance for current action. It used for setting this namespace into execute() method.
     * </p>
     */
    private final Namespace namespace;

    /**
     * <p>
     * Constructor which provides configuration for add action.
     * </p>
     *
     * @param modelElement ModelElement instance should not be null.
     * @param usecaseToolUtil UsecaseToolUtil instance should not be null.
     * @param manager UMLModelManager instance should not be null.
     * @param namespace Namespace instance should not be null.
     *
     * @throws IllegalArgumentException when any parameter is null.
     */
    protected AddAction(ModelElement modelElement, UsecaseToolUtil usecaseToolUtil, UMLModelManager manager,
        Namespace namespace) {
        super(modelElement, usecaseToolUtil);
        Helper.checkNull("manager", manager);
        Helper.checkNull("namespace", namespace);
        this.manager = manager;
        this.namespace = namespace;
    }

    /**
     * <p>
     * Adding current instance of ModelElement to namespace.
     * </p>
     *
     * @throws ActionExecutionException when impossible to execute action.
     */
    public void execute() throws ActionExecutionException {
        try {
            //Getting instance of configuration manager
            ProjectConfigurationManager config = manager.getProjectConfigurationManager();

            config.applyInitialFormatting(manager.getProjectLanguage(), getModelElement());
        } catch (ProjectConfigurationException ex) {
            throw new ActionExecutionException("Unable to execute the action.", ex);
        } catch (IllegalStateException ise) {
            throw new ActionExecutionException("Unable to execute the action.", ise);
        }

        getUsecaseToolUtil().addElementToModel(getModelElement(), namespace);
    }

    /**
     * <p>
     * This is method which is used by ActionManager for implementing redo functionality.
     * </p>
     */
    public void redo() {
        if (canRedo()) {
            getUsecaseToolUtil().addElementToModel(getModelElement(), namespace);
            super.redo();
        } else {
            getLog().log(Level.WARN, "Impossible provide redo action.");
        }
    }

    /**
     * <p>
     * This is method which is used by ActionManager for implementing undo functionality.
     * </p>
     */
    public void undo() {
        if (canUndo()) {
            if (!getUsecaseToolUtil().removeElementFromModel(getModelElement())) {
                getLog().log(Level.WARN, "Given element doesn't exist in namespace.");
            }

            super.undo();
        } else {
            getLog().log(Level.WARN, "Impossible provide undo action.");
        }
    }
}
