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
 * of action. All logic represent into its super class. Also it provide checking
 * if given Class instance is exception.
 * </p>
 * <p>
 * Thread-safety: Class is not thread safety because it extends from mutable
 * class.
 * </p>
 *
 * @author tushak, TCSDEVELOPER
 * @version 1.0
 */
public class AddExceptionAction extends AddAction {

    /**
     * <p>
     * Represent human readable description of action.
     * </p>
     */
    private static final String PRESENTATION_NAME = "Add Exception";

    /**
     * <p>
     * Constructor which provides configuration for current action.
     * </p>
     *
     * @param exception
     *            Class instance, null impossible
     * @param manager
     *            UMLModelManager instance, null impossible
     * @throws IllegalArgumentException
     *             when exception or manager is null
     * @throws InvalidDataContentException
     *             if given class is not exception
     */
    public AddExceptionAction(com.topcoder.uml.model.core.classifiers.Class exception, UMLModelManager manager)
            throws InvalidDataContentException {
        super(exception, new ExceptionUtil(), manager, manager == null ? null : manager.getModel());

        ExceptionUtil util = (ExceptionUtil) getClassToolUtil();

        if (!util.isException(exception)) {
            throw new InvalidDataContentException("Given class is not exception.");
        }
    }

    /**
     * <p>
     * Constructor which provides configuration for current action.
     * </p>
     *
     * @param exception
     *            Class instance, null impossible
     * @param manager
     *            UMLModelManager instance, null impossible
     * @param namespace
     *            Namespace namespace, null impossible
     * @throws IllegalArgumentException
     *             when exception, manager or namespace is null
     * @throws InvalidDataContentException
     *             if given class is not exception
     */
    public AddExceptionAction(com.topcoder.uml.model.core.classifiers.Class exception, UMLModelManager manager,
            Namespace namespace) throws InvalidDataContentException {
        super(exception, new ExceptionUtil(), manager, namespace);

        ExceptionUtil util = (ExceptionUtil) getClassToolUtil();

        if (!util.isException(exception)) {
            throw new InvalidDataContentException("Given class is not exception.");
        }
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