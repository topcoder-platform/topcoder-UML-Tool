/*
 * Copyright (C) 2008 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.gui.configurationmanager;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Map.Entry;

/**
 * this class represents the total result of validation of many properties using
 * the custom validators: it contains also the validationResult for each
 * property definition.
 * 
 * Thread safety: it's thread safe, its' immutable.
 * 
 * @author TCSDESIGNER, TCSDEVELOPER
 * @version 1.0
 */
public class ValidationResultSet {
    /**
     * Represents the validation Results for the properties definitions.
     * 
     * The keys are the properties definition, the values are the list of
     * validation result set associated.
     * 
     * Usually this list will have 2 validators: 1 for the type and one for the
     * name (or it can also have only 1 of these validators).
     * 
     * Initial Value: defined in constructor
     * 
     * Accessed In: getter method
     * 
     * Modified In: none
     * 
     * Utilized In: none
     * 
     * Valid Values: can't be null, can't be empty, can't have the null key ,
     * the inner list can't be empty, the value of the map can't be null, the
     * values of the lists can't contain null values.
     */
    private final Map<PropertyDefinition, List<ValidationResult>> validationResults;

    /**
     * Construct the instance from the result. Use a shallow copy.
     * 
     * @throws IllegalArgumentException
     *             If validationResults is null, has the null key ,
     *             the value of the map is null, the
     *             values of the lists contains null values.
     * @param validationResults
     *            the validation Results for the properties definitions
     */
    public ValidationResultSet(Map<PropertyDefinition, List<ValidationResult>> validationResults) {
        if (validationResults == null) {
            throw new IllegalArgumentException("validationResults cannot be null.");
        }

        for (Entry<PropertyDefinition, List<ValidationResult>> entry : validationResults.entrySet()) {
            if (entry.getKey() == null) {
                // null key.
                throw new IllegalArgumentException("validationResults cannot contain null key.");
            }
            List<ValidationResult> value = entry.getValue();

            if (value == null) {
                // null value.
                throw new IllegalArgumentException("validationResults cannot contain null value.");
            }
            if (value.contains(null)) {
                throw new IllegalArgumentException("validationResults value cannot contain null value.");
            }
        }

        this.validationResults = new HashMap<PropertyDefinition, List<ValidationResult>>(validationResults);
    }

    /**
     * Return true if all validation result sets of all properties definitions
     * are succeed, false otherwise.
     * 
     * @return true if all validation result sets of all properties definitions
     *         are succeed, false otherwise.
     */
    public boolean isSuccess() {
        Set<Entry<PropertyDefinition, List<ValidationResult>>> entrySet = validationResults.entrySet();

        for (Entry<PropertyDefinition, List<ValidationResult>> entry : entrySet) {
            List<ValidationResult> value = entry.getValue();

            for (ValidationResult result : value) {
                if (!result.isSuccess()) {
                    return false;
                }
            }
        }

        return true;
    }

    /**
     * Return true if all validation result sets of the property definition
     * definition are succeed, false otherwise.
     * 
     * @throws IllegalArgumentException
     *             if the argument is null
     * @param property
     *            the property definition
     * @return true if all validation result sets of the property definition
     *         definition are succeed, false otherwise.
     */
    public boolean isSuccess(PropertyDefinition property) {
        if (property == null) {
            throw new IllegalArgumentException("property cannot be null.");
        }
        List<ValidationResult> value = validationResults.get(property);

        for (ValidationResult result : value) {
            if (!result.isSuccess()) {
                return false;
            }
        }

        return true;
    }

    /**
     * Return the validationResults. use a shallow copy for both map and inner
     * lists.
     * 
     * @return the validationResults
     */
    public Map<PropertyDefinition, List<ValidationResult>> getValidationResults() {
        return new HashMap<PropertyDefinition, List<ValidationResult>>(validationResults);
    }

    /**
     * Return the validationResults for the property definition. Use a shallow
     * copy
     * 
     * @throws IllegalArgumentException
     *             if the argument is null
     * @param property
     *            the property definition
     * @return the validationResults for the property definition
     */
    public List<ValidationResult> getValidationResults(PropertyDefinition property) {
        if (property == null) {
            throw new IllegalArgumentException("property cannot be null.");
        }
        return new ArrayList<ValidationResult>(validationResults.get(property));
    }
}
