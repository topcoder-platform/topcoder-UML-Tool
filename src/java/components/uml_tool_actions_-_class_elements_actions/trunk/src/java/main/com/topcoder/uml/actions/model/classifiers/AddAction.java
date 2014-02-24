/*
 * Copyright (C) 2006 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.uml.actions.model.classifiers;

import com.topcoder.uml.model.core.ModelElement;
import com.topcoder.uml.model.core.Namespace;
import com.topcoder.uml.modelmanager.UMLModelManager;
import com.topcoder.uml.projectconfiguration.ProjectConfigurationException;
import com.topcoder.uml.projectconfiguration.ProjectConfigurationManager;
import com.topcoder.util.actionmanager.ActionExecutionException;
import com.topcoder.util.log.Level;

/**
 * <p>
 * This abstract class extends from ClassUndoableAction. It implements all logic
 * of add action for all elements in component. It contains three methods:
 * execute(), redo(), undo(). Also this class is responsible for applying
 * initial formatting of elements.
 * </p>
 * <p>
 * Thread-safety: Class is not thread safety because it extends from mutable
 * class.
 * </p>
 *
 * @author tushak, TCSDEVELOPER
 * @version 1.0
 */
abstract class AddAction extends ClassUndoableAction {

    /**
     * <p>
     * Represent UMLModelManager reference for current add action class. It used
     * for applying initial formatting.
     * </p>
     */
    private final UMLModelManager manager;

    /**
     * <p>
     * Represent Namespace instance for currnt action. It used for setting this
     * namespace into execute() method
     * </p>
     */
    private final Namespace namespace;

    /**
     * <p>
     * Constructor which provide configuration for add action.
     * </p>
     *
     * @param modelElement
     *            ModelElement instance, null impossible
     * @param classToolUtil
     *            ClassToolUtil instance, null impossible
     * @param manager
     *            UMLModelManager instance, null impossible
     * @param namespace
     *            Namespace instance, null impossible
     * @throws IllegalArgumentException
     *             when some parameter is null
     */
    protected AddAction(ModelElement modelElement, ClassToolUtil classToolUtil, UMLModelManager manager,
            Namespace namespace) {
        super(modelElement, classToolUtil);

        if (manager == null) {
            throw new IllegalArgumentException("Param manager should not be null.");
        }
        if (namespace == null) {
            throw new IllegalArgumentException("Param namespace should not be null.");
        }

        this.manager = manager;
        this.namespace = namespace;
    }

    /**
     * <p>
     * This method provide adding current instance of ModelElement to namespace.
     * </p>
     *
     * @throws ActionExecutionException
     *             when impossible execute action
     */
    public void execute() throws ActionExecutionException {
        ProjectConfigurationManager config = manager.getProjectConfigurationManager();

        try {
            config.applyInitialFormatting(manager.getProjectLanguage(), getModelElement());
        } catch (ProjectConfigurationException pce) {
            throw new ActionExecutionException("Impossible provide execute add action.", pce);
        }

        getClassToolUtil().addElementToModel(getModelElement(), namespace);
    }

    /**
     * <p>
     * This is method which is used by ActionManager for implementing redo
     * functionality.
     * </p>
     */
    public void redo() {
        if (canRedo()) {
            getClassToolUtil().addElementToModel(getModelElement(), namespace);
            super.redo();
        } else {
            getLog().log(Level.WARN, "Impossible provide redo add action.");
        }
    }

    /**
     * <p>
     * This is method which is used by ActionManager for implementing undo
     * functionality.
     * </p>
     */
    public void undo() {
        if (canUndo()) {
            if (!getClassToolUtil().removeElementFromModel(getModelElement())) {
                getLog().log(Level.WARN, "Given element doesn't exist in the namespace.");
            }
            super.undo();
        } else {
            getLog().log(Level.WARN, "Impossible provide undo add action.");
        }
    }
}