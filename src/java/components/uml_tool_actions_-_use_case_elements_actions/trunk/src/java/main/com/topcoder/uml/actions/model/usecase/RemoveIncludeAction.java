/*
 * Copyright (C) 2006 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.uml.actions.model.usecase;

import com.topcoder.uml.model.usecases.Include;


/**
 * <p>
 * This class extends from RemoveAction and used for removing Include instance from model or namespace. Its methods
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
public class RemoveIncludeAction extends RemoveAction {
    /**
     * <p>
     * Represent human readable description of action.
     * </p>
     */
    private static final String PRESENTATION_NAME = "Remove Include";

    /**
     * <p>
     * Constructor which provides configuration for current action.
     * </p>
     *
     * @param include Include instance, should not be null.
     *
     * @throws IllegalArgumentException when parameter is null.
     */
    public RemoveIncludeAction(Include include) {
        super(include, new IncludeUtil());
    }

    /**
     * <p>
     * Return presentationName attribute - human readable description of action.
     * </p>
     *
     * @return "Remove Include" - the presentationName attribute.
     */
    public String getPresentationName() {
        return PRESENTATION_NAME;
    }
}
