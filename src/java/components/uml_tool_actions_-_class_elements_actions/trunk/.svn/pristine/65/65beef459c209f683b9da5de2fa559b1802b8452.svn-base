/*
 * Copyright (C) 2006 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.uml.actions.model.classifiers;

import com.topcoder.uml.model.core.Namespace;
import com.topcoder.uml.model.core.classifiers.Enumeration;
import com.topcoder.uml.modelmanager.UMLModelManager;

/**
 * <p>
 * This class extends from AddAction and used for adding Enumeration instance to
 * model or namespace. Its methods provide only proper configuration and
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
public class AddEnumerationAction extends AddAction {

    /**
     * <p>
     * Represent human readable description of action.
     * </p>
     */
    private static final String PRESENTATION_NAME = "Add Enumeration";

    /**
     * <p>
     * Constructor which provides configuration for current action.
     * </p>
     *
     * @param enumeration
     *            Enumeration instance, null impossible
     * @param manager
     *            UMLModelManager instance, null impossible
     * @throws IllegalArgumentException
     *             when enumeration or manager is null
     */
    public AddEnumerationAction(Enumeration enumeration, UMLModelManager manager) {
        super(enumeration, new EnumerationUtil(), manager, manager == null ? null : manager.getModel());
    }

    /**
     * <p>
     * Constructor which provides configuration for current action.
     * </p>
     *
     * @param enumeration
     *            Enumeration instance, null impossible
     * @param manager
     *            UMLModelManager instance, null impossible
     * @param namespace
     *            Namespace instance, null impossible
     * @throws IllegalArgumentException
     *             when enumeration, manager or namespace is null
     */
    public AddEnumerationAction(Enumeration enumeration, UMLModelManager manager, Namespace namespace) {
        super(enumeration, new EnumerationUtil(), manager, namespace);
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