/*
 * Copyright (C) 2006 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.uml.actions.model.classifiers;

import com.topcoder.uml.model.core.Namespace;
import com.topcoder.uml.modelmanager.UMLModelManager;

/**
 * <p>
 * This class extends from AddAction and used for adding Class instance to model
 * or namespace. Its methods provide only proper configuration and presentation
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
public class AddClassAction extends AddAction {

    /**
     * <p>
     * Represent human readable description of action.
     * </p>
     */
    private static final String PRESENTATION_NAME = "Add Class";

    /**
     * <p>
     * Constructor which provides configuration for current action.
     * </p>
     *
     * @param classElement
     *            Class instance, null impossible
     * @param manager
     *            UMLModelManager instance, null impossible
     * @throws IllegalArgumentException
     *             when classElement or manager is null
     */
    public AddClassAction(com.topcoder.uml.model.core.classifiers.Class classElement, UMLModelManager manager) {
        super(classElement, new ClassUtil(), manager, manager == null ? null : manager.getModel());
    }

    /**
     * <p>
     * Constructor which provides configuration for current action.
     * </p>
     *
     * @param classElement
     *            Class instance, null impossible
     * @param manager
     *            UMLModelManager instance, null impossible
     * @param namespace
     *            Namespace instance, null impossible
     * @throws IllegalArgumentException
     *             when classElement, classElement or namespace is null
     */
    public AddClassAction(com.topcoder.uml.model.core.classifiers.Class classElement, UMLModelManager manager,
            Namespace namespace) {
        super(classElement, new ClassUtil(), manager, namespace);
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