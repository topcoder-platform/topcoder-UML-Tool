/*
 * Copyright (C) 2006 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.uml.actions.model.classifiers;

import java.awt.datatransfer.Clipboard;

/**
 * <p>
 * This class extends from CopyAction and used for copying Class instance to
 * clipboard. Its methods provide only proper configuration and presentation of
 * action. All logic represent into its super class.
 * </p>
 * <p>
 * Thread-safety: Class is not thread safety because it extends from mutable
 * class.
 * </p>
 *
 * @author tushak, TCSDEVELOPER
 * @version 1.0
 */
public class CopyClassAction extends CopyAction {

    /**
     * <p>
     * Constructor which provides configuration for current action.
     * </p>
     *
     * @param classElement
     *            Class instance, null impossible
     * @throws IllegalArgumentException
     *             when classElement is null
     */
    public CopyClassAction(com.topcoder.uml.model.core.classifiers.Class classElement) {
        super(classElement, new ClassUtil(), null);
    }

    /**
     * <p>
     * Constructor which provides configuration for current action.
     * </p>
     *
     * @param classElement
     *            Class instance, null impossible
     * @param clipboard
     *            Clipboard instance, null possible
     * @throws IllegalArgumentException
     *             when classElement is null
     */
    public CopyClassAction(com.topcoder.uml.model.core.classifiers.Class classElement, Clipboard clipboard) {
        super(classElement, new ClassUtil(), clipboard);
    }
}