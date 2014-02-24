/*
 * Copyright (C) 2006 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.uml.actions.model.usecase;

import com.topcoder.uml.model.usecases.Extend;
import com.topcoder.uml.modelmanager.UMLModelManager;


/**
 * <p>
 * This class extends from AddAction and used for adding Extend instance to model or namespace.  Its methods provide
 * only proper configuration and presentation of action.  All logic represent into its super class.
 * </p>
 *
 * <p>
 * Class is not thread safety because it extends from mutable class.
 * </p>
 *
 * @author tushak, TCSDEVELOPER
 * @version 1.0
 */
public class AddExtendAction extends AddAction {
    /**
     * <p>
     * Represent human readable description of action.
     * </p>
     */
    private static final String PRESENTATION_NAME = "Add Extend";

    /**
     * <p>
     * Constructor which provides configuration for current action. It also response for setting correct namespace.
     * </p>
     *
     * @param extend Extend instance should not be null.
     * @param manager UMLModelManager instance should not be null.
     *
     * @throws IllegalArgumentException when any parameter is null
     */
    public AddExtendAction(Extend extend, UMLModelManager manager) {
        super(extend, new ExtendUtil(), manager, (manager == null) ? null : manager.getModel());
    }

    /**
     * <p>
     * Return presentationName attribute - human readable description of action.
     * </p>
     *
     * @return "Add Extend" - presentationName attribute
     */
    public String getPresentationName() {
        return PRESENTATION_NAME;
    }
}
