/*
 * Copyright (C) 2008 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.gui.configurationmanager.componentgenerators;

import com.topcoder.gui.configurationmanager.PropertyDefinition;
import com.topcoder.gui.configurationmanager.PropertyType;

import junit.framework.TestCase;

import javax.swing.JCheckBox;

/**
 * This is unit test for CheckBoxPropertyComponentGenerator class.
 *
 * @author TCSDEVELOPER
 * @version 1.0
 */
public class CheckBoxPropertyComponentGeneratorTest extends TestCase {
    /**
     * Represents CheckBoxPropertyComponentGenerator instance for test.
     */
    private CheckBoxPropertyComponentGenerator generator;

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
        pd.setPropertyType(PropertyType.CHECK_BOX);
        pd.setPropertyValue("true");
        generator = new CheckBoxPropertyComponentGenerator();
    }

    /**
     * Test method for
     * {@link CheckBoxPropertyComponentGenerator#CheckBoxPropertyComponentGenerator()}
     * . No exception is expected.
     */
    public void testCheckBoxPropertyComponentGenerator() {
        new CheckBoxPropertyComponentGenerator();
    }

    /**
     * Test method for
     * {@link CheckBoxPropertyComponentGenerator#generateComponent(PropertyDefinition)}
     * .
     *
     * When the generated CheckBox is selected/unselected, the associated
     * property value should be automatically updated too.
     */
    public void testGenerateComponent() {
        pd.setPropertyValue("true");
        JCheckBox checkBox = generator.generateComponent(pd);
        assertEquals("CheckBox should be selected.",
            Boolean.parseBoolean(pd.getPropertyValue()), checkBox.isSelected());
        assertTrue("CheckBox should be selected.", checkBox.isSelected());

        pd.setPropertyValue("false");
        checkBox = generator.generateComponent(pd);
        assertEquals("CheckBox should be unselected.", Boolean.parseBoolean(pd.getPropertyValue()), checkBox
                .isSelected());
        assertFalse("CheckBox should be unselected.", checkBox.isSelected());

        checkBox.setSelected(false);
        assertEquals("Fail to update PropertyValue.", Boolean.toString(false), pd.getPropertyValue());

        checkBox.setSelected(true);
        assertEquals("Fail to update PropertyValue.", Boolean.toString(true), pd.getPropertyValue());
    }

    /**
     * Test method for
     * {@link CheckBoxPropertyComponentGenerator#generateComponent(PropertyDefinition)}
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
     * {@link CheckBoxPropertyComponentGenerator#generateComponent(PropertyDefinition)}
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
     * {@link CheckBoxPropertyComponentGenerator#getPropertyType()}.
     */
    public void testGetPropertyType() {
        assertSame("getPropertyType is incorrect.", PropertyType.CHECK_BOX, generator.getPropertyType());
    }
}
