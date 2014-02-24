/*
 * Copyright (C) 2006 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.uml.actions.model.classifiers;

import java.awt.datatransfer.Clipboard;

/**
 * <p>
 * This class extends from CopyAction and used for copying Class instance to
 * clipboard. Its methods provide only proper configuration and presentation of
 * action. All logic represent into its super class. Also it provide checking if
 * given Class instance is exception.
 * </p>
 * <p>
 * Thread-safety: Class is not thread safety because it extends from mutable
 * class.
 * </p>
 *
 * @author tushak, TCSDEVELOPER
 * @version 1.0
 */
public class CopyExceptionAction extends CopyAction {

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
    public CopyExceptionAction(com.topcoder.uml.model.core.classifiers.Class exception)
            throws InvalidDataContentException {
        super(exception, new ExceptionUtil(), null);

        ExceptionUtil util = new ExceptionUtil();

        if (!util.isException(exception)) {
            throw new InvalidDataContentException("Given class is not exception");
        }
    }

    /**
     * <p>
     * Constructor which provides configuration for current action.
     * </p>
     *
     * @param exception
     *            Class instance, null impossible
     * @param clipboard
     *            Clipboard instance, null possible
     * @throws IllegalArgumentException
     *             when exception is null
     * @throws InvalidDataConteneException
     *             if given class is not exception
     */
    public CopyExceptionAction(com.topcoder.uml.model.core.classifiers.Class exception, Clipboard clipboard)
            throws InvalidDataContentException {
        super(exception, new ExceptionUtil(), clipboard);

        ExceptionUtil util = new ExceptionUtil();

        if (!util.isException(exception)) {
            throw new InvalidDataContentException("Given class is not exception");
        }
    }
}
