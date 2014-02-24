/*
 * Copyright (C) 2008 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.gui.configurationmanager.componentgenerators;

import java.util.Arrays;
import java.util.HashSet;

import com.topcoder.gui.configurationmanager.PropertyDefinition;
import com.topcoder.gui.configurationmanager.PropertyType;

import junit.framework.TestCase;

import javax.swing.JPanel;
import javax.swing.JRadioButton;

/**
 * This is unit test for RadioButtonsPropertyComponentGenerator class.
 *
 * @author TCSDEVELOPER
 * @version 1.0
 */
public class RadioButtonsPropertyComponentGeneratorTest extends TestCase {
    /**
     * Represents RadioButtonsPropertyComponentGenerator instance for test.
     */
    private RadioButtonsPropertyComponentGenerator generator;

    /**
     * Represents PropertyDefinition instance for test.
     */
    private PropertyDefinition pd;

    /**
     * Setup test environment.
     *
     * @throws Exception
     *             Exception to JUnit.
     */
    protected void setUp() throws Exception {
        pd = new PropertyDefinition();
        pd.setPromptText("PT");
        pd.setPropertyName("pn");
        pd.setPropertyType(PropertyType.RADIO_BUTTONS);
        pd.setPropertyValue("1");
        pd.setValueChoices(new HashSet<String>(Arrays.asList("true", "false", "1", "2", "3", "4")));

        generator = new RadioButtonsPropertyComponentGenerator();
    }

    /**
     * Test method for
     * {@link RadioButtonsPropertyComponentGenerator#RadioButtonsPropertyComponentGenerator()}
     * . No exception is expected.
     */
    public void testRadioButtonsPropertyComponentGenerator() {
        new RadioButtonsPropertyComponentGenerator();
    }

    /**
     * Test method for
     * {@link RadioButtonsPropertyComponentGenerator#generateComponent(PropertyDefinition)}
     * .
     */
    public void testGenerateComponent() {
        pd.setPropertyValue("true");
        JPanel radioButtonsPanel = generator.generateComponent(pd);
        assertEquals(pd.getValueChoices().size(), radioButtonsPanel.getComponentCount());

        for (int i = 0; i < radioButtonsPanel.getComponentCount(); ++i) {
            JRadioButton jb = (JRadioButton) radioButtonsPanel.getComponent(i);
            assertEquals("Text is incorrect.", pd.getValueChoices().toArray()[i], jb.getText());
            assertEquals("isSelected is incorrect.", jb.getText().equals(pd.getPropertyValue()), jb.isSelected());
        }
    }

    /**
     * Test method for
     * {@link RadioButtonsPropertyComponentGenerator#generateComponent(PropertyDefinition)}
     * .
     *
     * Send null PropertyDefinition, IAE is expected.
     */
    public void testGenerateComponent_NullPropertyDefinition() {
        try {
            generator.generateComponent(null);
            fail("IllegalArgumentException is expected since null propertyDefinition is sent.");
        } catch (IllegalArgumentException e) {
            // success.
        }
    }

    /**
     * Test method for
     * {@link RadioButtonsPropertyComponentGenerator#generateComponent(PropertyDefinition)}
     * .
     *
     * Send unmatched PropertyDefinition, IAE is expected.
     */
    public void testGenerateComponent_UnmatchedPropertyDefinitionType() {
        pd.setPropertyType(PropertyType.DROP_DOWN);

        try {
            generator.generateComponent(pd);
            fail("IllegalArgumentException is expected since unmatched property type is sent.");
        } catch (IllegalArgumentException e) {
            // success.
        }
    }

    /**
     * Test method for
     * {@link RadioButtonsPropertyComponentGenerator#generateComponent(PropertyDefinition)}
     * .
     *
     * Send unmatched PropertyDefinition, IAE is expected.
     */
    public void testGenerateComponent_UnlistedPropertyValue() {
        pd.setPropertyValue("unexist");

        try {
            generator.generateComponent(pd);
            fail("IllegalArgumentException is expected since unlisted property value is sent.");
        } catch (IllegalArgumentException e) {
            // success.
        }
    }

    /**
     * Test method for
     * {@link RadioButtonsPropertyComponentGenerator#getPropertyType()}.
     */
    public void testGetPropertyType() {
        assertSame("getPropertyType is incorrect.", PropertyType.RADIO_BUTTONS, generator.getPropertyType());
    }
}
