/*
 * Copyright (C) 2008 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.gui.configurationmanager.validators;

import com.topcoder.gui.configurationmanager.PropertyDefinition;
import com.topcoder.gui.configurationmanager.PropertyValidator;
import com.topcoder.gui.configurationmanager.ValidationResult;

/**
 * This is the mock validator that validates directory path is not empty. This
 * is only used for test.
 *
 * @author TCSDEVELOPER
 * @version 1.0
 */
public class DirectoryValidator implements PropertyValidator {
    /**
     * Validate the property.
     *
     * PropertyValue cannot be empty.
     *
     * @throws IllegalArgumentException
     *             if the property is null
     * @throws InsufficientDataException
     *             if there is not sufficient data to perform the validation
     * @throws ValidationException
     *             if some errors occur
     * @param property
     *            the property to validate
     * @return the result of validation
     */
    public ValidationResult validateProperty(PropertyDefinition property) {
        if (property.getPropertyValue().equals("")) {
            return new ValidationResult(false, "directory path cannot be empty.", property);
        } else {
            return new ValidationResult(true, "pass", property);
        }
    }
}
