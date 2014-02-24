/*
 * Copyright (C) 2006 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.uml.projectconfiguration;

import com.topcoder.util.errorhandling.BaseException;

/**
 * <p>
 * This exception will be thrown by the ProjectConfigurationManager,
 * InitialElementFormatter and InitialDiagramElementFormatter implementations
 * when them encounters an exception trying to get configuration information
 * for the configuration files.
 * </p>
 *
 * <p>
 * It will be exposed to the caller of the format method of the formatter.
 * And it also will be exposed to the caller of the constructor,
 * getStandardStereotypes, applyInitialFormatting and getDefaultProjectLanguage
 * methods of ProjectConfigurationManager.
 * </p>
 *
 * <p>
 * Thread Safety : This class is immutable and so thread safety.
 * </p>
 *
 * @author kinzz, biotrail
 * @version 1.0
 */
public class ProjectConfigurationException extends BaseException {

    /**
     * <p>
     * Constructs the exception from the specified message.
     * </p>
     *
     * <p>
     * The message needs to be meaningful, so that the user will benefit from
     * meaningful messages.
     * </p>
     *
     * @param message A possibly null, possibly empty (trim'd) error message
     */
    public ProjectConfigurationException(String message) {
        super(message);
    }

    /**
     * <p>
     * Constructs the exception from the specified message and cause.
     * </p>
     *
     * <p>
     * The message needs to be meaningful, so that the user will benefit from
     * meaningful messages.
     * </p>
     *
     * <p>
     * The cause is the inner exception.
     * </p>
     *
     * @param message A possibly null, possibly empty (trim'd) error message
     * @param cause A possibly null cause exception
     */
    public ProjectConfigurationException(String message, Throwable cause) {
        super(message, cause);
    }
}
