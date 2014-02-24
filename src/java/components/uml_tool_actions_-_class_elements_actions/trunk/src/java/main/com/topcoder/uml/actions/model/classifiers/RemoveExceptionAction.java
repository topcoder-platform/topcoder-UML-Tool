/*
 * Copyright (C) 2006 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.uml.actions.model.classifiers;

/**
 * <p>
 * This class extends from RemoveAction and used for removing Class instance
 * from model or namespace. Its methods provide only proper configuration and
 * presentation of action. All logic represent into its super class. Also it
 * provide checking if given Class instance is exception.
 * </p>
 * <p>
 * Thread-safety: Class is not thread safety because it extends from mutable
 * class.
 * </p>
 *
 * @author tushak, TCSDEVELOPER
 * @version 1.0
 */
public class RemoveExceptionAction extends RemoveAction {

    /**
     * <p>
     * Represent human readable description of action.
     * </p>
     */
    private static final String PRESENTATION_NAME = "Remove Exception";

    /**
     * <p>
     * Constructor which provides configuration for current action.
     * </p>
     *
     * @param exception
     *            Class instance, null impossible
     * @throws IllegalArgumentException
     *             when exception is null
     * @throws InvalidDataConteneException
     *             if given class is not exception
     */
    public RemoveExceptionAction(com.topcoder.uml.model.core.classifiers.Class exception)
            throws InvalidDataContentException {
        super(exception, new ExceptionUtil());

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