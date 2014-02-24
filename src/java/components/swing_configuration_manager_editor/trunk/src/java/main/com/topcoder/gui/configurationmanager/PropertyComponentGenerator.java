/*
 * Copyright (C) 2008 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.gui.configurationmanager;

import javax.swing.JComponent;

/**
 * this interface defined the contract to generate the jcomponent based on the
 * type. The JComponent will be tied to the propertyDefinition: when the
 * component will change its state, the property value will change (for example
 * in a text field, when the user changes the text, the property definition must
 * reflect this change). It is used inside the {ConfigurationManagerEditorPanel.
 *
 * Thread safety: the implementations are required to be thread safe
 *
 * @author TCSDESIGNER, TCSDEVELOPER
 * @version 1.0
 */
public interface PropertyComponentGenerator {
    /**
     * Generate the component from the property definition. The component will
     * be tied (using the listener) to the propertyDefinition.value.
     *
     * @throws IllegalArgumentException
     *             if the propertyDefinition is null or if the
     *             propertyDefinition.type is not equal to getPropertyType()
     * @param propertyDefinition
     *            the property used to generate the component
     * @return the component tied to the property definition
     */
    public JComponent generateComponent(PropertyDefinition propertyDefinition);

    /**
     * Return the property type.
     *
     * @return the property type
     */
    public PropertyType getPropertyType();
}
