/*
 * Copyright (C) 2006 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.gui.panels.documentation;

import com.topcoder.util.errorhandling.BaseException;


/**
 * <p>
 * Exception thrown when any documentation cannot load required information
 * from configuration. This can either be if required documentation is missing
 * or invalid, or if the configuration itself cannot be read.
 * </p>
 *
 * @author sql_lall, liuliquan
 * @version 1.0
 */
public class DocumentationPanelConfigurationException extends BaseException {
    /**
     * <p>
     * Serial Version UID.
     * </p>
     */
    private static final long serialVersionUID = 4543646485262868737L;

    /**
     * <p>
     * Constructs a new exception object, taking a message as the why it was thrown.
     * </p>
     *
     * @param message the message to associate with this exception. It is required.
     *
     * @throws IllegalArgumentException if message is null or empty after trimmed.
     */
    public DocumentationPanelConfigurationException(String message) {
        // leaves the check to super class
        super(message);
    }

    /**
     * <p>
     * Constructs a new exception object, taking a message as the why it was thrown,
     * as well as an initial cause.
     * </p>
     *
     * @param message the message to associate with this exception. It is required.
     * @param cause the underlying exception. It is required.
     *
     * @throws IllegalArgumentException if either argument is null or if message is
     *         empty after trimmed.
     */
    public DocumentationPanelConfigurationException(String message, Throwable cause) {
        // leaves the checks to super class
        super(message, cause);
    }
}
