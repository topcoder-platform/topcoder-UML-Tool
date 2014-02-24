/*
 * Copyright (C) 2006 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.uml.actions.model.usecase;

import com.topcoder.uml.model.core.Namespace;
import com.topcoder.uml.model.usecases.UseCase;
import com.topcoder.uml.modelmanager.UMLModelManager;


/**
 * <p>
 * This class extends from AddAction and used for adding UseCase instance to model or namespace. Its methods provide
 * only proper configuration and presentation of action. All logic represent into its super class.
 * </p>
 *
 * <p>
 * Class is not thread safety because it extends from mutable class.
 * </p>
 *
 * @author tushak, TCSDEVELOPER
 * @version 1.0
 */
public class AddUseCaseAction extends AddAction {
    /**
     * <p>
     * Represent Namespace instance for current action.
     * </p>
     */
    private static final String PRESENTATION_NAME = "Add Use Case";

    /**
     * <p>
     * Constructor which provides configuration for current action. It also response for setting correct namespace.
     * </p>
     *
     * @param useCase UseCase instance, should not be null.
     * @param manager Instance of UMLModelManager for current application
     *
     * @throws IllegalArgumentException when any parameter is null
     */
    public AddUseCaseAction(UseCase useCase, UMLModelManager manager) {
        super(useCase, new UseCaseUtil(), manager, (manager == null) ? null : manager.getModel());
    }

    /**
     * <p>
     * Constructor which provides configuration for current action. It also response for setting correct namespace.
     * </p>
     *
     * @param useCase UseCase instance, should not be null.
     * @param manager Instance of UMLModelManager for current application
     * @param namespace Namespace instance, should not be null.
     *
     * @throws IllegalArgumentException when any parameter is null
     */
    public AddUseCaseAction(UseCase useCase, UMLModelManager manager, Namespace namespace) {
        super(useCase, new UseCaseUtil(), manager, namespace);
    }

    /**
     * <p>
     * Return presentationName attribute - human readable description of action.
     * </p>
     *
     * @return "Add Use Case" - the presentationName attribute
     */
    public String getPresentationName() {
        return PRESENTATION_NAME;
    }
}
