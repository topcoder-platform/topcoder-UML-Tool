/*
 * Copyright (C) 2008 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.gui.configurationmanager;

import java.util.HashSet;
import java.util.Set;

/**
 * Represents the property definition. This class defines a property with the
 * name in the configuration manager (this is like an attribute in
 * ConfigurationManager). The value will be loaded from Configuration Manager in
 * the editor panel.
 *
 * Thread safety: it's not thread safe, it's mutable
 *
 * @author TCSDESIGNER, TCSDEVELOPER
 * @version 1.0
 */
public class PropertyDefinition {
    /**
     * Represents the property Name.
     *
     * Initial Value: null, means that is not set
     *
     * Accessed In: getter method
     *
     * Modified In: setter method
     *
     * Utilized In: none
     *
     * Valid Values: all values
     */
    private String propertyName;

    /**
     * Represents the prompt Text, used in the JLabel in the editor panel.
     *
     * Initial Value: null, means that is not set
     *
     * Accessed In: getter method
     *
     * Modified In: setter method
     *
     * Utilized In: none
     *
     * Valid Values: all values
     */
    private String promptText;

    /**
     * Represents the propertyType.
     *
     * Initial Value: null, means that is not set
     *
     * Accessed In: getter method
     *
     * Modified In: setter method
     *
     * Utilized In: none
     *
     * Valid Values: all values
     */
    private PropertyType propertyType;

    /**
     * Represents the property Value.
     *
     * Initial Value: null, means that is not set
     *
     * Accessed In: getter method
     *
     * Modified In: setter method
     *
     * Utilized In: none
     *
     * Valid Values: all values
     */
    private String propertyValue;

    /**
     * Represents the value Choices. it is used in the radio buttons and drop
     * down components: they represent the possible choices.
     *
     * Initial Value: null, means that is not set.
     *
     * Accessed In: getter method
     *
     * Modified In: setter method
     *
     * Utilized In: none
     *
     * Valid Values: can be null, can be empty, can't contain null values
     */
    private Set<String> valueChoices;

    /**
     * this is the default constructor. It does nothing.
     */
    public PropertyDefinition() {
    }

    /**
     * Return the propertyName.
     *
     * @return the propertyName
     */
    public String getPropertyName() {
        return propertyName;
    }

    /**
     * Set the propertyName.
     *
     * @param propertyName
     *            the propertyName to set.
     */
    public void setPropertyName(String propertyName) {
        this.propertyName = propertyName;
    }

    /**
     * Return the promptText.
     *
     * @return the promptText.
     */
    public String getPromptText() {
        return promptText;
    }

    /**
     * Set the promptText.
     *
     * @param promptText
     *            the promptText to set.
     */
    public void setPromptText(String promptText) {
        this.promptText = promptText;
    }

    /**
     * Return the propertyType.
     *
     * @return the propertyType.
     */
    public PropertyType getPropertyType() {
        return propertyType;
    }

    /**
     * Set the propertyType.
     *
     * @param propertyType
     *            the propertyType to set.
     */
    public void setPropertyType(PropertyType propertyType) {
        this.propertyType = propertyType;
    }

    /**
     * Return the propertyValue.
     *
     * @return the propertyValue.
     */
    public String getPropertyValue() {
        return propertyValue;
    }

    /**
     * Set the propertyValue.
     *
     * @param propertyValue
     *            the propertyValue to set.
     */
    public void setPropertyValue(String propertyValue) {
        this.propertyValue = propertyValue;
    }

    /**
     * Return the valueChoices. use a shallow copy.
     *
     * @return the valueChoices.
     */
    public Set<String> getValueChoices() {
        return valueChoices == null ? null : new HashSet<String>(valueChoices);
    }

    /**
     * Set the valueChoices. use a shallow copy
     *
     * @throws IllegalArgumentException
     *             if it contains the null value
     * @param valueChoices
     *            The valueChoices to set, can be empty or null.
     */
    public void setValueChoices(Set<String> valueChoices) {
        if (valueChoices == null) {
            this.valueChoices = null;
        } else {
            if (valueChoices.contains(null)) {
                throw new IllegalArgumentException("valueChoices cannot contain null value.");
            }
            this.valueChoices = new HashSet<String>(valueChoices);
        }
    }
}
