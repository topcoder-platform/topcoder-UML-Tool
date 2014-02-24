/*
 * Copyright (C) 2006 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.uml.actions.model.classifiers;

import java.util.Collection;

import com.topcoder.uml.model.core.extensionmechanisms.Stereotype;

/**
 * <p>
 * This class extends from ClassUtil. It just contain one own method to check if
 * Class instance has "exception" stereotype.
 * </p>
 * <p>
 * Thread-safety: Class is thread safety because it is immutable.
 * </p>
 *
 * @author tushak, TCSDEVELOPER
 * @version 1.0
 */
class ExceptionUtil extends ClassUtil {

    /**
     * <p>
     * Default empty constructor.
     * </p>
     */
    public ExceptionUtil() {
    }

    /**
     * <p>
     * Validate if given Class instance has "exception" stereotype.
     * </p>
     *
     * @param exception
     *            Class instance, null impossible
     * @return true if class has "exception" stereotype, otherwise false
     * @throws IllegalArgumentException
     *             when exception is null
     */
    public boolean isException(com.topcoder.uml.model.core.classifiers.Class exception) {
        if (exception == null) {
            throw new IllegalArgumentException("Param exception should not be null.");
        }

        Collection<Stereotype> stereotypes = exception.getStereotypes();
        for (Stereotype stereotype : stereotypes) {
            // Bugfix: UML-12688
            // old code
//            if (stereotype.getBaseClass().equalsIgnoreCase("exception")) {
            if (stereotype.getName().equalsIgnoreCase("exception")) {
                return true;
            }
        }

        return false;
    }
}