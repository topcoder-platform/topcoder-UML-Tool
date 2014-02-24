/*
 * Copyright (C) 2007 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.gui.diagramviewer;

import com.topcoder.util.errorhandling.BaseException;

/**
 * <p>
 * This exception is used to indicate error occurs when instantiating some
 * classes in this package. For example if an UnkownNamespaceException is thrown
 * when using ConfigManager in DiagramViewer#ctor, it will be wrapped to such an
 * exception and thrown.
 * </p>
 * <p>
 * It may be thrown in ctor of DiagramViewer, CloseTabAction and ZoomAction.
 * </p>
 * <p>
 * Thread safety: This class is immutable, and thread-safe.
 * </p>
 *
 * @author kakarotto, TCSDEVELOPER
 * @version 1.0
 */
public class ConfigurationException extends BaseException {

    /**
     * <p>
     * Constructs the exception with error message.
     * </p>
     *
     * @param msg the error message
     */
    public ConfigurationException(String msg) {
        super(msg);
    }

    /**
     * <p>
     * Constructs the exception with error message and Throwable cause.
     * </p>
     *
     * @param msg the error message
     * @param cause the inner cause of this exception
     */
    public ConfigurationException(String msg, Throwable cause) {
        super(msg, cause);
    }
}
