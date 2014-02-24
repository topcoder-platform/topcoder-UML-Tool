/*
 * Copyright (C) 2006 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.uml.actions.model.usecase;

import com.topcoder.uml.model.modelmanagement.Subsystem;


/**
 * <p>
 * This class extends from RemoveAction and used for removing Subsystem instance from model or namespace. Its methods
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
public class RemoveSubsystemAction extends RemoveAction {
    /**
     * <p>
     * Represent Subsystem instance for current action.
     * </p>
     */
    private static final String PRESENTATION_NAME = "Remove Subsystem";

    /**
     * <p>
     * Constructor which provides configuration for current action.
     * </p>
     *
     * @param subsystem Subsystem instance, should not be null.
     *
     * @throws IllegalArgumentException when parameter is null.
     */
    public RemoveSubsystemAction(Subsystem subsystem) {
        super(subsystem, new SubsystemUtil());
    }

    /**
     * <p>
     * Return presentationName attribute - human readable description of action.
     * </p>
     *
     * @return "Remove Subsystem" - the presentationName attribute.
     */
    public String getPresentationName() {
        return PRESENTATION_NAME;
    }
}
