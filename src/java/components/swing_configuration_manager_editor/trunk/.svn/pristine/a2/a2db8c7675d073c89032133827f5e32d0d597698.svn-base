/*
 * Copyright (C) 2008 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.gui.configurationmanager;

/**
 * It's the validator used to to validate the properties when the properties are
 * saved or simply when the properties are validated. Used in the editor panel,
 * there are no implementations.
 * 
 * Thread safety: the thread safety is required
 * 
 * @author TCSDESIGNER, TCSDEVELOPER
 * @version 1.0
 */
public interface PropertyValidator {
    /**
     * Validate the property. It will will validate the property's value. Return
     * the result of validation.
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
    public ValidationResult validateProperty(PropertyDefinition property) throws InsufficientDataException;
}
