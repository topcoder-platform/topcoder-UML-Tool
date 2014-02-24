/*
 * Copyright (C) 2006 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.uml.actions.model.classifiers;

import java.awt.datatransfer.Clipboard;

import com.topcoder.uml.model.core.dependencies.Dependency;

/**
 * <p>
 * This class extends from CopyAction and used for copying Dependency instance
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
public class CopyDependencyAction extends CopyAction {

    /**
     * <p>
     * Constructor which provides configuration for current action.
     * </p>
     *
     * @param dependency
     *            Dependency instance, null impossible
     * @throws IllegalArgumentException
     *             when dependency is null
     */
    public CopyDependencyAction(Dependency dependency) {
        super(dependency, new DependencyUtil(), null);
    }

    /**
     * <p>
     * Constructor which provides configuration for current action.
     * </p>
     *
     * @param dependency
     *            Dependency instance, null impossible
     * @param clipboard
     *            Clipboard instance, null possible
     * @throws IllegalArgumentException
     *             when dependency is null
     */
    public CopyDependencyAction(Dependency dependency, Clipboard clipboard) {
        super(dependency, new DependencyUtil(), clipboard);
    }
}