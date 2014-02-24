/*
 * Copyright (C) 2008 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.gui.configurationmanager.componentgenerators;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashSet;
import java.util.Set;

import javax.swing.JComboBox;

import com.topcoder.gui.configurationmanager.PropertyComponentGenerator;
import com.topcoder.gui.configurationmanager.PropertyDefinition;
import com.topcoder.gui.configurationmanager.PropertyType;

/**
 * This generator will generate a JComboBox related to the property definition.
 * When the user will select the item of ComboBox, the property's value will be
 * modified with the value of the item.
 *
 * Thread safety: it's stateless, then it's thread safe
 *
 * @author TCSDESIGNER, TCSDEVELOPER
 * @version 1.0
 */
public class DropDownPropertyComponentGenerator implements PropertyComponentGenerator {
    /**
     * Default constructor. It does nothing.
     */
    public DropDownPropertyComponentGenerator() {
    }

    /**
     * Generate the component from the property definition. The component will
     * be tied (using the listener) to the propertyDefinition.value. This
     * generator will generate a {@link JComboBox} related to the property
     * definition. When the user will select the item of combobox, the
     * property's value will be modified with the value of the selected item.
     *
     * @throws IllegalArgumentException
     *             if the propertyDefinition is null or if the
     *             propertyDefinition.type is not equal to getPropertyType().
     *             If valueChoices does not contain propertyValue.
     * @param propertyDefinition
     *            the property used to generate the component
     * @return the component tied to the property definition
     */
    public JComboBox generateComponent(final PropertyDefinition propertyDefinition) {
        if (propertyDefinition == null) {
            throw new IllegalArgumentException("Parameter propertyDefinition cannot be null.");
        }

        if (!propertyDefinition.getPropertyType().equals(PropertyType.DROP_DOWN)) {
            throw new IllegalArgumentException(
                    "propertyDefinition.propertyType should be PropertyType.DROP_DOWN. But it is "
                            + propertyDefinition.getPropertyType());
        }
        // get the value choices
        Set<String> valueChoices = propertyDefinition.getValueChoices() == null ? new HashSet<String>()
                : propertyDefinition.getValueChoices();
        String propertyValue = propertyDefinition.getPropertyValue();
        if (propertyValue != null && !valueChoices.contains(propertyValue)) {
            throw new IllegalArgumentException("value choices does not contain property value:" + propertyValue);
        }

        String[] items = valueChoices.toArray(new String[valueChoices.size()]);

        // construct the ComboBox with the choices
        final JComboBox comboBox = new JComboBox(items);
        // must be not edit-able
        comboBox.setEditable(false);
        // set the property value as selected
        comboBox.setSelectedItem(propertyValue);

        // add the listener
        comboBox.addActionListener(new ActionListener() {
            /**
             * change the property definition with the selected item.
             *
             * @param e event.
             */
            public void actionPerformed(ActionEvent e) {
                String selectedItem = (String) comboBox.getSelectedItem();
                propertyDefinition.setPropertyValue(selectedItem);
            }
        });

        return comboBox;
    }

    /**
     * Return the property type. Return the PropertyType#DROP_DOWN.
     *
     * @return the property type
     */
    public PropertyType getPropertyType() {
        return PropertyType.DROP_DOWN;

    }
}
