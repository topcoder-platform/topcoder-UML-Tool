/*
 * Copyright (C) 2006 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.uml.actions.model.classifiers;

import java.awt.datatransfer.Clipboard;

/**
 * <p>
 * This c1ass extends from PackageAction and provide functionality to
 * cut(copy+remove) Package instance from model. Also it has ability to use redo
 * and undo of cutting.
 * </p>
 * <p>
 * Thread-safety: Class is not thread safety because it extends from mutable
 * class.
 * </p>
 *
 * @author tushak, TCSDEVELOPER
 * @version 1.0
 */
public class CutPackageAction extends CutAction {

    /**
     * <p>
     * Represent human readable description of action.
     * </p>
     */
    private static final String PRESENTATION_NAME = "Cut Package";

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
    public CutPackageAction(com.topcoder.uml.model.modelmanagement.Package packageElement) {
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
    public CutPackageAction(com.topcoder.uml.model.modelmanagement.Package packageElement, Clipboard clipboard) {
        super(packageElement, new PackageUtil(), clipboard);
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