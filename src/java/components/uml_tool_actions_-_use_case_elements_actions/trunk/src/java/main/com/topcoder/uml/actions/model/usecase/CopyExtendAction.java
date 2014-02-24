/*
 * Copyright (C) 2006 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.uml.actions.model.usecase;

import com.topcoder.uml.model.usecases.Extend;

import java.awt.datatransfer.Clipboard;


/**
 * <p>
 * This class extends from CopyAction and used for copying Extend instance to clipboard. Its methods provide only
 * proper configuration and presentation of action. All logic  represent into its super class.
 * </p>
 *
 * <p>
 * Class is not thread safety because it extends from mutable class.
 * </p>
 *
 * @author tushak, TCSDEVELOPER
 * @version 1.0
 */
public class CopyExtendAction extends CopyAction {
    /**
     * <p>
     * Constructor which provides configuration for current action.
     * </p>
     *
     * @param extend Extend instance, should not be null.
     *
     * @throws IllegalArgumentException when parameter is null.
     */
    public CopyExtendAction(Extend extend) {
        super(extend, new ExtendUtil(), null);
    }

    /**
     * <p>
     * Constructor which provides configuration for current action.
     * </p>
     *
     * @param extend Extend instance, null impossible
     * @param clipboard Clipboard instance, null impossible
     *
     * @throws IllegalArgumentException when any parameter is null
     */
    public CopyExtendAction(Extend extend, Clipboard clipboard) {
        super(extend, new ExtendUtil(), clipboard);
        Helper.checkNull("clipboard", clipboard);
    }
}
