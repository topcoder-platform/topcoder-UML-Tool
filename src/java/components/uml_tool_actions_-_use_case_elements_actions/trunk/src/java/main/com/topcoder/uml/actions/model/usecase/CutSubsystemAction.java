/*
 * Copyright (C) 2006 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.uml.actions.model.usecase;

import com.topcoder.uml.model.modelmanagement.Subsystem;

import java.awt.datatransfer.Clipboard;


/**
 * <p>
 * This class extends from CutAction and used for cutting (copy + remove) Subsystem instance from model or namespace to
 * clipboard. Its methods provide only proper configuration and presentation of action. All logic represent into its
 * super class.
 * </p>
 *
 * <p>
 * Class is not thread safety because it extends from mutable class.
 * </p>
 *
 * @author tushak, TCSDEVELOPER
 * @version 1.0
 */
public class CutSubsystemAction extends CutAction {
    /**
     * <p>
     * Represent human readable description of action.
     * </p>
     */
    private static final String PRESENTATION_NAME = "Cut Subsystem";

    /**
     * <p>
     * Constructor which provides configuration for current action.  And also use parameter manager to initialize
     * SubsystemUtil.
     * </p>
     *
     * @param subsystem Subsystem instance, should not be null.
     *
     * @throws IllegalArgumentException when parameter is null.
     */
    public CutSubsystemAction(Subsystem subsystem) {
        super(subsystem, new SubsystemUtil(), null);
    }

    /**
     * <p>
     * Constructor which provides configuration for current action.  And also use parameter manager to initialize
     * SubsystemUtil.
     * </p>
     *
     * @param subsystem Subsystem instance, should not be null.
     * @param clipboard Clipboard instance, should not be null.
     *
     * @throws IllegalArgumentException when any parameter is null
     */
    public CutSubsystemAction(Subsystem subsystem, Clipboard clipboard) {
        super(subsystem, new SubsystemUtil(), clipboard);
        Helper.checkNull("clipboard", clipboard);
    }

    /**
     * <p>
     * Return presentationName attribute - human readable description of action.
     * </p>
     *
     * @return "Cut Subsystem" - the presentationName attribute.
     */
    public String getPresentationName() {
        return PRESENTATION_NAME;
    }
}
