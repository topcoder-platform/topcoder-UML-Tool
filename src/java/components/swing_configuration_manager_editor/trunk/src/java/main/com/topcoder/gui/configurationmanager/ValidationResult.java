/*
 * Copyright (C) 2008 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.gui.configurationmanager;

/**
 * represent the validation result of a property validation: it contains the
 * information of the fail or success.
 *
 * Thread safety: it's thread safe, its' immutable.
 *
 * @author TCSDESIGNER, TCSDEVELOPER
 * @version 1.0
 */
public class ValidationResult {
    /**
     * Represents the success flag, which indicated if the validation is failed
     * or not Initial Value: defined in constructor Accessed In: getter method
     * Modified In: none Utilized In: none Valid Values: all values.
     */
    private final boolean success;

    /**
     * Represents the description of result. If (success) then description is a
     * description of the success; else the description will describes why the
     * validation is failed Initial Value: defined in constructor Accessed In:
     * getter method Modified In: none Utilized In: none Valid Values: can be
     * null or empty if the success is true, else must be not null and not
     * empty. A description of the fail must be present.
     */
    private final String description;

    /**
     * Represents the property definition related to this validation. Initial
     * Value: defined in constructor Accessed In: getter method Modified In:
     * none Utilized In: none Valid Values: can't be null
     */
    private final PropertyDefinition property;

    /**
     * Construct the instance from its values. Set the values.
     *
     * @throws IllegalArgumentException
     *             if the success is false and the description is null or empty,
     *             if the property is null.
     * @param property
     *            the property definition related to this validation
     * @param description
     *            if success is fail, can be null or empty
     * @param success
     *            the success flag, which indicated if the validation is failed
     *            or not
     */
    public ValidationResult(boolean success, String description, PropertyDefinition property) {
        if (!success) {
            if (description == null) {
                throw new IllegalArgumentException("When success is false, description cannot be null.");
            }
            if (description.trim().equals("")) {
                throw new IllegalArgumentException("When success is false, description cannot be empty.");
            }
        }
        if (property == null) {
            throw new IllegalArgumentException("property cannot be null.");
        }

        this.property = property;
        this.description = description;
        this.success = success;
    }

    /**
     * Return the success.
     *
     * @return the success
     */
    public boolean isSuccess() {
        return success;
    }

    /**
     * Return the description.
     *
     * @return the description
     */
    public String getDescription() {
        return description;
    }

    /**
     * Return the property.
     *
     * @return the property
     */
    public PropertyDefinition getProperty() {
        return property;
    }
}
