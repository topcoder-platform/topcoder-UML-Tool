/*
 * Copyright (C) 2008 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.gui.configurationmanager.componentgenerators;

import javax.swing.JTextField;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

import com.topcoder.gui.configurationmanager.PropertyComponentGenerator;
import com.topcoder.gui.configurationmanager.PropertyDefinition;
import com.topcoder.gui.configurationmanager.PropertyType;

/**
 * This generator will generate a JTextField related to the property definition.
 * When the user will edit the text in the textFile, the propertyDefinition's
 * property value will be modified with this text.
 *
 * Thread safety: it's stateless, then it's thread safe.
 *
 * @author TCSDESIGNER, TCSDEVELOPER
 * @version 1.0
 */
public class FreeTextPropertyComponentGenerator implements PropertyComponentGenerator {
    /**
     * Default constructor. It does nothing.
     */
    public FreeTextPropertyComponentGenerator() {
    }

    /**
     * Generate the component from the property definition. The component will
     * be tied (using the listener) to the propertyDefinition.value. This
     * generator will generate a JTextField related to the property definition.
     * When the user will edit the text in the textFile, the
     * propertyDefinition's property value will be modified with this text.
     *
     * @throws IllegalArgumentException
     *             if the propertyDefinition is null or if the
     *             propertyDefinition.type is not equal to
     *             PropertyType.FREE_TEXT
     * @param propertyDefinition
     *            the property used to generate the component
     * @return the component tied to the property definition
     */
    public JTextField generateComponent(final PropertyDefinition propertyDefinition) {
        // Check propertyDefinition is not null.
        if (propertyDefinition == null) {
            throw new IllegalArgumentException("Parameter propertyDefinition cannot be null.");
        }
        // Check propertyDefinition.type equals to getPropertyType()
        if (!propertyDefinition.getPropertyType().equals(PropertyType.FREE_TEXT)) {
            throw new IllegalArgumentException("propertyDefinition.propertyType should be FREE_TEXT. But it is "
                    + propertyDefinition.getPropertyType());
        }

        // create the text field
        final JTextField textField = new JTextField(propertyDefinition.getPropertyValue());
        // add the listener
        textField.getDocument().addDocumentListener(new DocumentListener() {
            /**
             * change the property definition with the text.
             *
             * @param e event.
             */
            public void changedUpdate(DocumentEvent e) {
                propertyDefinition.setPropertyValue(textField.getText());
            }

            /**
             * change the property definition with the text.
             *
             * @param e event.
             */
            public void insertUpdate(DocumentEvent e) {
                propertyDefinition.setPropertyValue(textField.getText());

            }

            /**
             * change the property definition with the text.
             *
             * @param e event.
             */
            public void removeUpdate(DocumentEvent e) {
                propertyDefinition.setPropertyValue(textField.getText());
            }
        });

        return textField;
    }

    /**
     * Return the property type. Return the PropertyType#FREE_TEXT.
     *
     * @return the property type
     */
    public PropertyType getPropertyType() {
        return PropertyType.FREE_TEXT;
    }
}
