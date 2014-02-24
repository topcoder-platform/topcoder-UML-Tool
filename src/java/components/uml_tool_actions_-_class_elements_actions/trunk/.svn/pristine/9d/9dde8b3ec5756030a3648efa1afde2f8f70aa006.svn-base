/*
 * Copyright (C) 2006 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.uml.actions.model.classifiers;

/**
 * <p>
 * This class extends from RemoveAction and used for removing Package instance
 * from model or namespace. Its methods provide only proper configuration and
 * presentation of action. All logic represent into its super class.
 * </p>
 * <p>
 * Thread-safety: Class is not thread safety because it extends from mutable
 * class.
 * </p>
 *
 * @author tushak, TCSDEVELOPER
 * @version 1.0
 */
public class RemovePackageAction extends RemoveAction {

    /**
     * <p>
     * Represent human readable description of action.
     * </p>
     */
    private static final String PRESENTATION_NAME = "Remove Package";

    /**
     * <p>
     * Constructor which provides configuration for current action.
     * </p>
     *
     * @param packageElement
     *            Package instance, null impossible
     * @throws IllegalArgumentException
     *             when some parameter is null
     */
    public RemovePackageAction(com.topcoder.uml.model.modelmanagement.Package packageElement) {
        super(packageElement, new PackageUtil());
    }

    /**
     * <p>
     * Return PRESENTATION_NAME attribute - human readable description of
     * action.
     * </p>
     *
     * @return PRESENTATION_NAME attribute
     */
    public String getPresentationName() {
        return PRESENTATION_NAME;
    }
}