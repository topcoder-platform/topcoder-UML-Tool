/*
 * Copyright (C) 2006 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.gui.toolbars.elements;

import com.topcoder.util.errorhandling.BaseException;

/**
 * <p>
 * This exception is thrown by the constructor of the SectionPanel class while loading configuration file.
 * </p>
 * <p>
 * It primarily indicates that there was problem when initializing the instance of SectionPanel.
 * </p>
 * <p>
 * It is thrown when there is any problem in the configuration, such as namespace is not found, image file is not
 * exist.
 * </p>
 * <p>
 * The <code>SectionPanelConfigurationException</code> does not define any mutable attributes and inherits from
 * the <code>BaseException</code> class which is thread-safe. Hence this class is also thread-safe.
 * </p>
 *
 * @author wang_liang, enefem21
 * @version 1.0
 */
public class SectionPanelConfigurationException extends BaseException {

    /**
     * The serial version UID.
     */
    private static final long serialVersionUID = 5634820614596451832L;

    /**
     * Constructs exception with error message.
     *
     * @param message
     *            the message describing the exception
     */
    public SectionPanelConfigurationException(String message) {
        super(message);
    }

    /**
     * Constructs exception with error message and cause Throwable.
     *
     * @param message
     *            the message describing the exception
     * @param cause
     *            The cause of the exception
     */
    public SectionPanelConfigurationException(String message, Throwable cause) {
        super(message, cause);
    }
}
