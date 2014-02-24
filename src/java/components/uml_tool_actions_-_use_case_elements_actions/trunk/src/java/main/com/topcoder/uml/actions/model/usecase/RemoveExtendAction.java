/*
 * Copyright (C) 2006 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.uml.actions.model.usecase;

import com.topcoder.uml.model.usecases.Extend;


/**
 * <p>
 * This class extends from RemoveAction and used for removing Extend instance from model or namespace. Its methods
 * provide only proper configuration and presentation of action. All logic represent into its super class.
 * </p>
 *
 * <p>
 * Class is not thread safety because it extends from mutable class.
 * </p>
 *
 * @author tushak, TCSDEVELOPER
 * @version 1.0
 */
public class RemoveExtendAction extends RemoveAction {
    /**
     * <p>
     * Represent human readable description of action.
     * </p>
     */
    private static final String PRESENTATION_NAME = "Remove Extend";

    /**
     * <p>
     * Constructor which provides configuration for current action.
     * </p>
     *
     * @param extend Extend instance, should not be null.
     *
     * @throws IllegalArgumentException when parameter is null.
     */
    public RemoveExtendAction(Extend extend) {
        super(extend, new ExtendUtil());
    }

    /**
     * <p>
     * Return presentationName attribute - human readable description of action.
     * </p>
     *
     * @return "Remove Extend" - the presentationName attribute.
     */
    public String getPresentationName() {
        return PRESENTATION_NAME;
    }
}
