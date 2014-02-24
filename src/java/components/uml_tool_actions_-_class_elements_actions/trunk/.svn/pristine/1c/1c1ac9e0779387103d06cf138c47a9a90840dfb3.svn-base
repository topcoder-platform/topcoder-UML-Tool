/*
 * Copyright (C) 2006 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.uml.actions.model.classifiers;

import java.awt.datatransfer.Clipboard;

import com.topcoder.uml.model.core.classifiers.Enumeration;

/**
 * <p>
 * This class extends from CopyAction and used for copying Enumeration instance
 * to clipboard. Its methods provide only proper configuration and presentation
 * of action. All logic represent into its super class.
 * </p>
 * <p>
 * Thread-safety: Class is not thread safety because it extends from mutable
 * class.
 * </p>
 *
 * @author tushak, TCSDEVELOPER
 * @version 1.0
 */
public class CopyEnumerationAction extends CopyAction {

    /**
     * <p>
     * Constructor which provides configuration for current action.
     * </p>
     *
     * @param enumeration
     *            Enumeration instance, null impossible
     * @throws IllegalArgumentException
     *             when enumeration is null
     */
    public CopyEnumerationAction(Enumeration enumeration) {
        super(enumeration, new EnumerationUtil(), null);
    }

    /**
     * <p>
     * Constructor which provides configuration for current action.
     * </p>
     *
     * @param enumeration
     *            Enumeration instance, null impossible
     * @param clipboard
     *            Clipboard instance, null possible
     * @throws IllegalArgumentException
     *             when enumeration is null
     */
    public CopyEnumerationAction(Enumeration enumeration, Clipboard clipboard) {
        super(enumeration, new EnumerationUtil(), clipboard);
    }
}