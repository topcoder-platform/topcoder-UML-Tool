/*
 * Copyright (C) 2006 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.uml.actions.model.usecase;

import com.topcoder.uml.model.usecases.Include;

import java.awt.datatransfer.Clipboard;


/**
 * <p>
 * This class extends from CopyAction and used for copying Include instance to clipboard. Its methods provide only
 * proper configuration and presentation of action. All logic represent into its super class.
 * </p>
 *
 * <p>
 * Class is not thread safety because it extends from mutable class.
 * </p>
 *
 * @author tushak, TCSDEVELOPER
 * @version 1.0
 */
public class CopyIncludeAction extends CopyAction {
    /**
     * <p>
     * Constructor which provides configuration for current action.
     * </p>
     *
     * @param include Include instance, should not be null.
     *
     * @throws IllegalArgumentException when parameter is null.
     */
    public CopyIncludeAction(Include include) {
        super(include, new IncludeUtil(), null);
    }

    /**
     * <p>
     * Constructor which provides configuration for current action.
     * </p>
     *
     * @param include Include instance, should not be null.
     * @param clipboard UMLModelManager instance, should not be null.
     *
     * @throws IllegalArgumentException when any parameter is null.
     */
    public CopyIncludeAction(Include include, Clipboard clipboard) {
        super(include, new IncludeUtil(), clipboard);
        Helper.checkNull("clipboard", clipboard);
    }
}
