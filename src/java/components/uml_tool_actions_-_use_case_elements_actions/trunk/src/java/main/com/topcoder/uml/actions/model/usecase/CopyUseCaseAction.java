/*
 * Copyright (C) 2006 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.uml.actions.model.usecase;

import com.topcoder.uml.model.usecases.UseCase;

import java.awt.datatransfer.Clipboard;


/**
 * <p>
 * This class extends from CopyAction and used for copying UseCase instance to clipboard. Its methods provide only
 * proper configuration and presentation of action.  All logic represent into its super class.
 * </p>
 *
 * <p>
 * Class is not thread safety because it extends from mutable class.
 * </p>
 *
 * @author tushak, TCSDEVELOPER
 * @version 1.0
 */
public class CopyUseCaseAction extends CopyAction {
    /**
     * <p>
     * Constructor which provides configuration for current action. And also use parameter manager to initialize
     * SubsystemUtil.
     * </p>
     *
     * @param useCase UseCase instance, should not be null.
     *
     * @throws IllegalArgumentException when parameter is null.
     */
    public CopyUseCaseAction(UseCase useCase) {
        super(useCase, new UseCaseUtil(), null);
    }

    /**
     * <p>
     * Constructor which provides configuration for current action. And also use parameter manager to initialize
     * SubsystemUtil.
     * </p>
     *
     * @param useCase UseCase instance, should not be null.
     * @param clipboard Clipboard instance, should not be null.
     *
     * @throws IllegalArgumentException when any parameter is null.
     */
    public CopyUseCaseAction(UseCase useCase, Clipboard clipboard) {
        super(useCase, new UseCaseUtil(), clipboard);
        Helper.checkNull("clipboard", clipboard);
    }
}
