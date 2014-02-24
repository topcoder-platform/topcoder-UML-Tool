/*
 * Copyright (C) 2007 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.swing.imageexporter;

import com.topcoder.util.errorhandling.BaseException;


/**
 * <p>This is the general exception of this component. It is thrown if any error occurs during the exporting
 * process.</p>
 * <p>Thread-Safety: This class is immutable and thread safe.</p>
 *
 * @author fabrizyo, TCSDEVELOPER
 * @version 1.0
 */
public class ImageExporterException extends BaseException {
    /**
     * <p>Creates a new <code>ImageExporterException</code> with given error message.</p>
     * @param message the error message of this exception
     */
    public ImageExporterException(String message) {
        super(message);
    }

    /**
     * <p>Creates a new <code>ImageExporterException</code> with given error message and inner cause.</p>
     * @param message the error message of this exception
     * @param cause the inner cause of this exception
     */
    public ImageExporterException(String message, Throwable cause) {
        super(message, cause);
    }
}
