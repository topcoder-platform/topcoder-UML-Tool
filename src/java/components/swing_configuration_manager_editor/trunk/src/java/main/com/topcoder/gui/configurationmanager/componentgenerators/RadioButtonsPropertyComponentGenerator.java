/*
 * Copyright (C) 2008 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.gui.configurationmanager.componentgenerators;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashSet;
import java.util.Set;

import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.JPanel;
import javax.swing.JRadioButton;

import com.topcoder.gui.configurationmanager.PropertyComponentGenerator;
import com.topcoder.gui.configurationmanager.PropertyDefinition;
import com.topcoder.gui.configurationmanager.PropertyType;

/**
 * This generator will generate a JPanel. this JPanel contains the radio buttons
 * grouped using a ButtonGroup. When the user will click on the radio, the
 * property value will be modified with the value of the radio. This class is
 * used to generate a control to display/modify the value of propertyDefinition
 * that is passed through generateComponent method.
 * 
 * Thread safety: it's stateless, then it's thread safe
 * 
 * @author TCSDESIGNER, TCSDEVELOPER
 * @version 1.0
 */
public class RadioButtonsPropertyComponentGenerator implements PropertyComponentGenerator {
    /**
     * Default constructor. It does nothing.
     */
    public RadioButtonsPropertyComponentGenerator() {
    }

    /**
     * Generate the component from the property definition. The component will
     * be tied (using the listener) to the propertyDefinition.value. This
     * generator will generate a JPanel. this JPanel contains the radio buttons
     * grouped using a ButtonGroup. When the user will click on the radio, the
     * property value will be modified with the value of the radio.
     * 
     * @throws IllegalArgumentException
     *             if the propertyDefinition is null or if the
     *             propertyDefinition.type is not equal to
     *             PropertyType.RADIO_BUTTONS.
     * @param propertyDefinition
     *            the property used to generate the component
     * @return the component tied to the property definition
     */
    public JPanel generateComponent(final PropertyDefinition propertyDefinition) {
        // Check propertyDefinition is not null.
        if (propertyDefinition == null) {
            throw new IllegalArgumentException("Parameter propertyDefinition cannot be null.");
        }
        // Check propertyDefinition.type equals to PropertyType.RADIO_BUTTONS
        if (!propertyDefinition.getPropertyType().equals(PropertyType.RADIO_BUTTONS)) {
            throw new IllegalArgumentException(
                    "propertyDefinition.propertyType should be PropertyType.FREE_TEXT. But it is "
                            + propertyDefinition.getPropertyType());
        }

        // get the value choices
        Set<String> valueChoices = propertyDefinition.getValueChoices() == null ? new HashSet<String>()
                : propertyDefinition.getValueChoices();
        String propertyValue = propertyDefinition.getPropertyValue();
        if (propertyValue != null && !valueChoices.contains(propertyValue)) {
            throw new IllegalArgumentException("Property " + propertyDefinition.getPropertyName()
                    + ". Value choices does not contain property value: " + propertyValue);
        }

        // create the panel which contains the radio buttons
        JPanel radioButtonsPanel = new JPanel();
        // set the layout
        radioButtonsPanel.setLayout(new BoxLayout(radioButtonsPanel, BoxLayout.PAGE_AXIS));

        // create the group of buttons
        ButtonGroup buttonGroup = new ButtonGroup();

        // create a button for each value choice
        for (final String choice : valueChoices) {
            JRadioButton radioButton = new JRadioButton(choice);

            // if the property value is equal to the choice value then the
            // button will be selected
            if (choice.equals(propertyValue)) {
                radioButton.setSelected(true);
            }

            // add the action listener
            radioButton.addActionListener(new ActionListener() {
                /**
                 * if the radio button is selected then the property definition
                 * will have the value of the radio button.
                 * 
                 * @param e
                 *            event.
                 */
                public void actionPerformed(ActionEvent e) {
                    propertyDefinition.setPropertyValue(choice);
                }
            });

            buttonGroup.add(radioButton);
            radioButtonsPanel.add(radioButton);
        }

        return radioButtonsPanel;
    }

    /**
     * Return the property type. Return the PropertyType#RADIO_BUTTONS.
     * 
     * @return the property type
     */
    public PropertyType getPropertyType() {
        return PropertyType.RADIO_BUTTONS;
    }
}
