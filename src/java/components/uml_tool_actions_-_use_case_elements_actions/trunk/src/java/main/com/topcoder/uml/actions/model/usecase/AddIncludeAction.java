/*
 * Copyright (C) 2006 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.uml.actions.model.usecase;

import com.topcoder.uml.model.usecases.Include;
import com.topcoder.uml.modelmanager.UMLModelManager;


/**
 * <p>
 * This class extends from AddAction and used for adding Include instance to model or namespace. Its methods provide
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
public class AddIncludeAction extends AddAction {
    /**
     * <p>
     * Represent human readable description of action.
     * </p>
     */
    private static final String PRESENTATION_NAME = "Add Include";

    /**
     * <p>
     * Constructor which provides configuration for current action. It also response for setting correct namespace.
     * </p>
     *
     * @param include Include instance, should not be null.
     * @param manager UMLModelManager instance, should not be null.
     *
     * @throws IllegalArgumentException when some parameter is null
     */
    public AddIncludeAction(Include include, UMLModelManager manager) {
        super(include, new IncludeUtil(), manager, (manager == null) ? null : manager.getModel());
    }

    /**
     * <p>
     * Return presentationName attribute - human readable description of action.
     * </p>
     *
     * @return "Add Include" - the presentationName attribute
     */
    public String getPresentationName() {
        return PRESENTATION_NAME;
    }
}
