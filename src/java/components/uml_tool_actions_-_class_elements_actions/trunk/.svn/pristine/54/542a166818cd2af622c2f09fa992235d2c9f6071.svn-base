/*
 * Copyright (C) 2006 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.uml.actions.model.classifiers;

import java.awt.datatransfer.Clipboard;

import com.topcoder.uml.model.core.classifiers.Interface;

/**
 * <p>
 * This class extends from CopyAction and used for copying Interface instance to
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
public class CopyInterfaceAction extends CopyAction {

    /**
     * <p>
     * Constructor which provides configuration for current action.
     * </p>
     *
     * @param interfaceElement
     *            Interface instance, null impossible
     * @throws IllegalArgumentException
     *             when interfaceElement is null
     */
    public CopyInterfaceAction(Interface interfaceElement) {
        super(interfaceElement, new InterfaceUtil(), null);
    }

    /**
     * <p>
     * Constructor which provides configuration for current action.
     * </p>
     *
     * @param interfaceElement
     *            Interface instance, null impossible
     * @param clipboard
     *            Clipboard instance, null possible
     * @throws IllegalArgumentException
     *             when interfaceElement is null
     */
    public CopyInterfaceAction(Interface interfaceElement, Clipboard clipboard) {
        super(interfaceElement, new InterfaceUtil(), clipboard);
    }
}