/*
 * Copyright (C) 2008 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.gui.configurationmanager.accuracytests;

import com.topcoder.gui.configurationmanager.PropertyDefinition;
import com.topcoder.gui.configurationmanager.PropertyValidator;
import com.topcoder.gui.configurationmanager.ValidationResult;

/**
 * <p>
 * This is a mock implementation of the <code>PropertyValidator</code> interface.
 * </p>
 *
 * @author uhmateush
 * @version 1.0
 */
class MockTypeValidator implements PropertyValidator {

    /**
     * <p>
     * Validates a giving <code>PropertyDefinition</code>.
     * </p>
     *
     * @param property a property to validate.
     * @return successful result if property contains a value choices, fail otherwise.
     */
    public ValidationResult validateProperty(PropertyDefinition property) {
        if (property.getValueChoices() == null) {
            return new ValidationResult(false, "A list of values should be specified.", property);
        } else {
            return new ValidationResult(true, null, property);
        }
    }
}