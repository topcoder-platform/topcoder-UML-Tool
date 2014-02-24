/*
 * Copyright (C) 2008 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.gui.configurationmanager.accuracytests.componentgenerators;

import java.awt.Component;
import java.util.HashSet;
import java.util.Set;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import junit.framework.TestCase;
import com.topcoder.gui.configurationmanager.PropertyDefinition;
import com.topcoder.gui.configurationmanager.PropertyType;
import com.topcoder.gui.configurationmanager.componentgenerators.RadioButtonsPropertyComponentGenerator;

/**
 * <p>
 * This class contains a set of tests for {@link RadioButtonsPropertyComponentGenerator} class.
 * </p>
 *
 * @author uhmateush
 * @version 1.0
 */
public class RadioButtonsPropertyComponentGeneratorTests extends TestCase {

    /**
     * <p>
     * Represents a test values for ComboBox generation.
     * </p>
     */
    private static final String[] values = {"value0", "value1", "value2"};

    /**
     * <p>
     * Represents an instance of <code>PropertyDefinition</code> for tests.
     * </p>
     */
    private PropertyDefinition definition;

    /**
     * Represents an instance of <code>RadioButtonsPropertyComponentGenerator</code> class for tests.
     */
    private RadioButtonsPropertyComponentGenerator generator;

    /**
     * <p>
     * Initializes test environment.
     * </p>
     *
     * @throws Exception exception to jUnit.
     */
    protected void setUp() throws Exception {
        definition = new PropertyDefinition();
        definition.setPromptText("text0");
        definition.setPropertyName("name0");
        definition.setPropertyType(PropertyType.RADIO_BUTTONS);
        definition.setPropertyValue(values[1]);

        Set<String> choices = new HashSet<String>();
        for (String s : values) {
            choices.add(s);
        }

        definition.setValueChoices(choices);

        generator = new RadioButtonsPropertyComponentGenerator();
    }

    /**
     * <p>
     * Tests class constructor and <code>getPropertyType()</code> method.
     * Method should return {@link PropertyType#RADIO_BUTTONS} value.
     * </p>
     */
    public void testGetPropertyType() {
        assertEquals("Method getPropertyType() works incorrect. PropertyType.RADIO_BUTTONS value should be returned.",
            PropertyType.RADIO_BUTTONS, generator.getPropertyType());
    }

    /**
     * <p>
     * Tests {@link RadioButtonsPropertyComponentGenerator#generateComponent(PropertyDefinition)} method.
     * </p>
     */
    public void testGenerateComponent() {
        definition.setPropertyValue(values[1]);
        JPanel radioButtonsPanel = generator.generateComponent(definition);

        assertTrue("The component count should be equals to definition value choices count.",
                definition.getValueChoices().size() == radioButtonsPanel.getComponentCount());

        int i = 0;
        for (Component component : radioButtonsPanel.getComponents()) {
            JRadioButton rbtn = (JRadioButton) component;
            String value = (String) definition.getValueChoices().toArray()[i++];
            assertEquals("Text is incorrect.", value, rbtn.getText());
            assertEquals("Attribute isSelected set to incorrect value.",
                rbtn.getText().equals(definition.getPropertyValue()), rbtn.isSelected());
        }
    }
}