/*
 * Copyright (C) 2008 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.gui.configurationmanager.componentgenerators;

import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.JCheckBox;

import com.topcoder.gui.configurationmanager.PropertyComponentGenerator;
import com.topcoder.gui.configurationmanager.PropertyDefinition;
import com.topcoder.gui.configurationmanager.PropertyType;

/**
 * This generator will generate a JCheckBox related to the property definition.
 * When the user will check or uncheck the CheckBox, the property's value will
 * be"true" or "false".
 * 
 * Thread safety: it's stateless, then it's thread safe
 * 
 * @author TCSDESIGNER, TCSDEVELOPER
 * @version 1.0
 */
public class CheckBoxPropertyComponentGenerator implements PropertyComponentGenerator {
    /**
     * Default constructor. It does nothing.
     */
    public CheckBoxPropertyComponentGenerator() {
    }

    /**
     * Generate the component from the property definition. The component will
     * be tied (using the listener) to the propertyDefinition.value. This
     * generator will generate a JCheckBox related to the property definition.
     * When the user will check or uncheck the checkbox, the property's value
     * will be "true" or "false".
     * 
     * @throws IllegalArgumentException
     *             if the propertyDefinition is null or if the
     *             propertyDefinition.type is not equal to getPropertyType()
     * @param propertyDefinition
     *            the property used to generate the component
     * @return the component tied to the property definition
     */
    public JCheckBox generateComponent(final PropertyDefinition propertyDefinition) {
        if (propertyDefinition == null) {
            throw new IllegalArgumentException("Parameter propertyDefinition cannot be null.");
        }
        if (!PropertyType.CHECK_BOX.equals(propertyDefinition.getPropertyType())) {
            throw new IllegalArgumentException(
                    "propertyDefinition.propertyType should be PropertyType.CHECK_BOX. But it is "
                            + propertyDefinition.getPropertyType());
        }

        // create the check box
        final JCheckBox checkBox = new JCheckBox();

        String propertyValue = propertyDefinition.getPropertyValue();
        if (!"true".equalsIgnoreCase(propertyValue) && !"false".equalsIgnoreCase(propertyValue)) {
            throw new IllegalArgumentException("For [" + propertyDefinition.getPropertyName() + "], [" + propertyValue
                    + "] cannot be parsed to boolean.");
        }

        // set the property value of property to CheckBox
        checkBox.setSelected(Boolean.parseBoolean(propertyValue));

        // add the listener to CheckBox
        checkBox.addItemListener(new ItemListener() {
            /**
             * if the CheckBox is selected then the property definition will be
             * "true" else will be "false".
             * 
             * @param e
             *            event.
             */
            public void itemStateChanged(ItemEvent e) {
                if (e.getStateChange() == ItemEvent.SELECTED) {
                    propertyDefinition.setPropertyValue(Boolean.toString(true));
                } else if (e.getStateChange() == ItemEvent.DESELECTED) {
                    propertyDefinition.setPropertyValue(Boolean.toString(false));
                }
            }
        });

        return checkBox;
    }

    /**
     * Return the property type. Return the PropertyType#CHECK_BOX.
     * 
     * @return the property type
     */
    public PropertyType getPropertyType() {
        return PropertyType.CHECK_BOX;
    }
}
