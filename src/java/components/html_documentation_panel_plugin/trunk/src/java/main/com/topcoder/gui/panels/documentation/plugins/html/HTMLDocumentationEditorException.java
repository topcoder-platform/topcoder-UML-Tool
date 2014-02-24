/*
 * Copyright (C) 2008 TopCoder Inc., All Rights Reserved.
 *
 * HTMLDocumentatioEditorException.java
 */
package com.topcoder.gui.panels.documentation.plugins.html;

import com.topcoder.util.errorhandling.BaseCriticalException;
import com.topcoder.util.errorhandling.ExceptionData;


/**
 * <p>
 * Exception thrown when the classes can not read the configuration properties, or the properties violate the
 * conditions upon them.
 * </p>
 * <p>
 * <strong>Thread safety:</strong>
 * This class is not thread safe since the parent class is not thread safe.
 * </p>
 *
 * @author morehappiness, TCSDEVELOPER
 * @version 1.0
 */
@SuppressWarnings("serial")
public class HTMLDocumentationEditorException extends BaseCriticalException {
    /**
     * <p>
     * Creates a new instance of this exception with the given message.
     * </p>
     * @param message the detailed error message of this exception
     */
    public HTMLDocumentationEditorException(String message) {
        super(message);
    }

    /**
     * <p>
     *Creates a new instance of this exception with the given message and cause.
     * </p>
     *
     * @param message the detailed error message of this exception
     * @param cause the inner cause of this exception
     */
    public HTMLDocumentationEditorException(String message, Throwable cause) {
        super(message, cause);
    }

    /**
     * <p>
     * Creates a new instance of this exception with the given message and data.
     * </p>
     *
     * @param message the detailed error message of this exception
     * @param data the data for this exception, if this is null, a new ExceptionData will be automatically used instead
     */
    public HTMLDocumentationEditorException(String message, ExceptionData data) {
        super(message, data);
    }

    /**
     * <p>
     * Creates a new instance of this exception with the given message, cause and data.
     * </p>
     *
     * @param message the detailed error message of this exception
     * @param cause the inner cause of this exception
     * @param data the data for this exception, if this is null, a new ExceptionData will be automatically used instead
     */
    public HTMLDocumentationEditorException(String message, Throwable cause, ExceptionData data) {
        super(message, cause, data);
    }
}
