/*
 * Copyright (C) 2006 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.uml.actions.project;

import com.topcoder.uml.model.modelmanagement.Model;
import com.topcoder.uml.modelmanager.UMLModelManager;
import com.topcoder.util.actionmanager.Action;

/**
 * <p>
 * <code>CreateNewProjectAction</code> creates a new project. It empties the <code>Model</code> if one is
 * present, the list of <code>ActivityGraphs</code> and the list of Diagrams from the
 * <code>UMLModelManager</code>. And it will also set the project language.
 * </p>
 * <p>
 * <b>Thread-safety: </b>This class is immutable, but it would change it internal state of the
 * <code>UMLModelManager</code> object, so it is not thread-safe.
 * </p>
 *
 * @author standlove, TCSDEVELOPER
 * @version 1.0
 */
public class CreateNewProjectAction implements Action {

    /**
     * <p>
     * Represents the language of the newly created project used to set to model in execute method.
     * Initialized in the constructor, and never changed afterwards. It must be non-null, non-empty string.
     * </p>
     */
    private final String projectLanguage;

    /**
     * <p>
     * Represents the <code>UMLModelManager</code> object processed by this action in execute method, its
     * internal state would be changed after execution. Initialized in the constructor, and this reference is
     * never changed afterwards. It must be non-null.
     * </p>
     */
    private final UMLModelManager manager;

    /**
     * <p>
     * Constructor with the project language and <code>UMLModelManager</code> object.
     * </p>
     *
     * @param projectLanguage
     *            the language of the newly created project used to set to model
     * @param modelManager
     *            the UMLModelManager object processed by this action
     * @throws IllegalArgumentException
     *             if the modelManager is <code>null</code>. if the projectLanguage is <code>null</code>
     *             or trimmed to empty
     */
    public CreateNewProjectAction(String projectLanguage, UMLModelManager modelManager) {
        // check if modelManager is null
        Helper.checkObjectNotNull(modelManager, "modelManager in CreateNewProjectAction#CreateNewProjectAction");
        // check if the projectLanguage string is null or empty
        Helper.checkStringNotNullOrEmpty(projectLanguage,
            "projectLanguage in CreateNewProjectAction#CreateNewProjectAction");
        this.projectLanguage = projectLanguage;
        this.manager = modelManager;
    }

    /**
     * <p>
     * Creates a new project. It will empty the Model, the list of <code>ActivityGraphs</code> and the list
     * of <code>Diagrams</code> from the <code>UMLModelManager</code>. And it will also set the project
     * language.
     * </p>
     */
    public void execute() {
        // get the model
        Model model = manager.getModel();
        // if a model is already present in the manager
        if (model != null) {
            // clear all model properties
            model.clearElementImports();
            model.clearBehaviors();
            model.clearClientDependencies();
            model.clearComments();
            model.clearDefaultParameters();
            model.clearGeneralizations();
            model.clearOwnedElements();
            model.clearReferenceTags();
            model.clearSpecializations();
            model.clearStereotypes();
            model.clearSupplierDependencies();
            model.clearTaggedValues();
            model.clearTemplateArguments();
            model.clearTemplateParameters();
        }
        // clear all the graphs
        manager.clearActivityGraphs();
        // clear the diagrams
        manager.clearDiagrams();
        // set the project language
        manager.setProjectLanguage(projectLanguage);
    }
}
