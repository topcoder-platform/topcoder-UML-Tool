/*
 * Copyright (C) 2006 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.uml.actions.model.usecase;

import com.topcoder.uml.model.usecases.Extend;

import java.awt.datatransfer.Clipboard;


/**
 * <p>
 * This class extends from CutAction and used for cutting (copy + remove) Extend instance from model or namespace to
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
public class CutExtendAction extends CutAction {
    /**
     * <p>
     * Represent human readable description of action.
     * </p>
     */
    private static final String PRESENTATION_NAME = "Cut Extend";

    /**
     * <p>
     * Constructor which provides configuration for current action.
     * </p>
     *
     * @param extend Extend instance, should not be null.
     *
     * @throws IllegalArgumentException when parameter is null
     */
    public CutExtendAction(Extend extend) {
        super(extend, new ExtendUtil(), null);
    }

    /**
     * <p>
     * Constructor which provides configuration for current action.
     * </p>
     *
     * @param extend Extend instance, should not be null.
     * @param clipboard Clipboard instance, should not be null.
     *
     * @throws IllegalArgumentException when any parameter is null.
     */
    public CutExtendAction(Extend extend, Clipboard clipboard) {
        super(extend, new ExtendUtil(), clipboard);
        Helper.checkNull("clipboard", clipboard);
    }

    /**
     * <p>
     * Return presentationName attribute - human readable description of action.
     * </p>
     *
     * @return "Cut Extend" - the presentationName attribute.
     */
    public String getPresentationName() {
        return PRESENTATION_NAME;
    }
}
