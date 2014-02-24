/*
 * Copyright (C) 2007 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.gui.diagramviewer.uml.sequenceelements;

import com.topcoder.util.errorhandling.BaseException;

/**
 * <p>
 * This is a custom exception,which is thrown by EdgeLayoutStrategy to indicate that error occurs
 * during layout.
 * </p>
 * <p>
 * The message passed in the constructor should be something meaningful to help the user to find the
 * problem. In addition to the message, the actual exception (if any) is passed to the user.
 * </p>
 * Thread-Safety: This class is thread safe as its super class is also thread safe.
 *
 * @author gniuxiao, TCSDEVELOPER
 * @version 1.1
 *
 * @since 1.1
 */
public class EdgeLayoutException extends BaseException {
    /**
     * <p>
     * Create an instance with the specified error message.
     * </p>
     *
     * <p>
     * The message needs to be meaningful, so that the user will benefit from meaningful messages.
     * </p>
     *
     * @param msg the error message
     */
    public EdgeLayoutException(String msg) {
        super(msg);
    }

    /**
     * <p>
     * Create an instance with the specified error message and inner cause.
     * </p>
     *
     * <p>
     * The message needs to be meaningful, so that the user will benefit from meaningful messages.
     * </p>
     *
     * @param msg the error message
     * @param cause the inner cause
     */
    public EdgeLayoutException(String msg, Throwable cause) {
        super(msg, cause);
    }
}
