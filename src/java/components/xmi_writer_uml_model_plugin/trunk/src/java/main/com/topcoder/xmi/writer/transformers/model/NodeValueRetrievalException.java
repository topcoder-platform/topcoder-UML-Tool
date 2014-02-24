/*
 * Copyright (C) 2006 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.xmi.writer.transformers.model;

import com.topcoder.xmi.writer.XMITransformException;


/**
 * This exception is used to indicate any error while retriving node value.
 * <p>
 * This exception can be thrown from {@link NodeDescription#getValue(Object)} method.
 * It will be used to wrap method invoking exception.
 * </p>
 *
 * This class is immutable, thus it is thread-safe.
 *
 * @author maone, TCSDEVELOPER
 * @version 1.0
 */
public class NodeValueRetrievalException extends XMITransformException {
    /**
     * <p>Constructor with error message.</p>
     *
     * @param message the error message.
     */
    public NodeValueRetrievalException(String message) {
        super(message);
    }

    /**
     * <p>Constructor with the error message and inner cause.</p>
     *
     * @param message the error message.
     * @param cause the inner cause.
     */
    public NodeValueRetrievalException(String message, Throwable cause) {
        super(message, cause);
    }
}
