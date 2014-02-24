/*
 * Copyright (C) 2007-2008 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.gui.panels.style;

/**
 * <p>
 * Exception thrown when some configuration issues arise.
 * </p>
 *
 * <p>
 * Thread safety: This class is immutable and so is thread safe.
 * </p>
 *
 * @author enefem21, TCSDEVELOPER
 * @version 1.0
 */
public class StylePanelConfigurationException extends StylePanelException {
    /**
     * <p>
     * Constructs a new StylePanelConfigurationException with the given message.
     * </p>
     *
     * <p>
     * The message needs to be meaningful, so that the user will benefit from meaningful messages.
     * </p>
     *
     *
     * @param message the message describing the exception
     */
    public StylePanelConfigurationException(String message) {
        super(message);
    }

    /**
     * <p>
     * Constructs a new StylePanelConfigurationException with the given message and cause.
     * </p>
     *
     * <p>
     * The message needs to be meaningful, so that the user will benefit from meaningful messages.
     * </p>
     *
     * <p>
     * The cause is the inner exception.
     * </p>
     *
     * @param message the message describing the exception
     * @param cause the cause of the exception
     */
    public StylePanelConfigurationException(String message, Throwable cause) {
        super(message, cause);
    }
}
