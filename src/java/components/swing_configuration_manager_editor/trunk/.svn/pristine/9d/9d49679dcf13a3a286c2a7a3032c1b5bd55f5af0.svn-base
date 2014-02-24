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
public class MultipleChoiceValidator implements PropertyValidator {
    /**
     * Validate the property.
     *
     * PropertyValue cannot be null.
     *
     * @throws IllegalArgumentException
     *             if the property is null
     * @throws InsufficientDataException
     *             if there is not sufficient data to perform the validation
     * @throws ValidationException
     *             if some errors occur
     * @param property
     *            the property to validate.
     * @return the result of validation.
     */
    public ValidationResult validateProperty(PropertyDefinition property) {
        if (property.getValueChoices() == null) {
            return new ValidationResult(false, "For multiple-choice, you must select one item.", property);
        } else {
            return new ValidationResult(true, "pass", property);
        }
    }
}
