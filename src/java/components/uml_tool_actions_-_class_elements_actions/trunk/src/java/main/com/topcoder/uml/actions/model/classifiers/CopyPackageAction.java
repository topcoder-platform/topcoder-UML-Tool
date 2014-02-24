/*
 * Copyright (C) 2006 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.uml.actions.model.classifiers;

import java.awt.datatransfer.Clipboard;

/**
 * <p>
 * This class extends from CopyAction and used for copying Package instance to
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
public class CopyPackageAction extends CopyAction {

    /**
     * <p>
     * Constructor which provides configuration for current action.
     * </p>
     *
     * @param packageElement
     *            Package instance, null impossible
     * @throws IllegalArgumentException
     *             when packageElement is null
     */
    public CopyPackageAction(com.topcoder.uml.model.modelmanagement.Package packageElement) {
        super(packageElement, new PackageUtil(), null);
    }

    /**
     * <p>
     * Constructor which provides configuration for current action.
     * </p>
     *
     * @param packageElement
     *            Package instance, null impossible
     * @param clipboard
     *            Clipboard instance, null possible
     * @throws IllegalArgumentException
     *             when packageElement is null
     */
    public CopyPackageAction(com.topcoder.uml.model.modelmanagement.Package packageElement, Clipboard clipboard) {
        super(packageElement, new PackageUtil(), clipboard);
    }
}