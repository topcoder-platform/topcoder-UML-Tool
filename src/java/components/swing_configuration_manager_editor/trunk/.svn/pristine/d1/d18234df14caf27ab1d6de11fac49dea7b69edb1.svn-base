/*
 * Copyright (C) 2008 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.gui.configurationmanager.componentgenerators;

import javax.swing.JTextField;

import com.topcoder.gui.configurationmanager.PropertyDefinition;
import com.topcoder.gui.configurationmanager.PropertyType;

import junit.framework.TestCase;

/**
 * This is unit test for DropDownPropertyComponentGenerator class.
 *
 * @author TCSDEVELOPER
 * @version 1.0
 */
public class FreeTextPropertyComponentGeneratorTest extends TestCase {
    /**
     * Represents FreeTextPropertyComponentGenerator instance for test.
     */
    private FreeTextPropertyComponentGenerator generator;

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
        pd.setPropertyType(PropertyType.FREE_TEXT);
        pd.setPropertyValue("pv");

        generator = new FreeTextPropertyComponentGenerator();
    }

    /**
     * Test method for
     * {@link FreeTextPropertyComponentGenerator#FreeTextPropertyComponentGenerator()}
     * . No exception is expected.
     */
    public void testFreeTextPropertyComponentGenerator() {
        new FreeTextPropertyComponentGenerator();
    }

    /**
     * Test method for
     * {@link FreeTextPropertyComponentGenerator#generateComponent(PropertyDefinition)}
     * .
     *
     * When the generated FreeText is selected/unselected, the associated
     * property value should be automatically updated too.
     */
    public void testGenerateComponent() {
        JTextField textField = generator.generateComponent(pd);
        assertEquals(pd.getPropertyValue(), textField.getText());

        pd.setPropertyValue("true");
        textField = generator.generateComponent(pd);
        assertEquals("PropertyValue is incorrect", pd.getPropertyValue(), textField.getText());
        assertEquals("Text is incorrect.", "true", textField.getText());

        pd.setPropertyValue("false");
        textField = generator.generateComponent(pd);
        assertEquals("PropertyValue is incorrect", pd.getPropertyValue(), textField.getText());
        assertEquals("Text is incorrect.", "false", textField.getText());

        textField.setText("true");
        assertEquals("PropertyValue is incorrect", "true", pd.getPropertyValue());

        textField.setText("false");
        assertEquals("PropertyValue is incorrect", "false", pd.getPropertyValue());

        textField.setText("1");
        assertEquals("PropertyValue is incorrect", "1", pd.getPropertyValue());

        textField.setText("2");
        assertEquals("PropertyValue is incorrect", "2", pd.getPropertyValue());
    }

    /**
     * Test method for
     * {@link FreeTextPropertyComponentGenerator#generateComponent(PropertyDefinition)}
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
     * {@link FreeTextPropertyComponentGenerator#generateComponent(PropertyDefinition)}
     * .
     *
     * Send unmatched PropertyDefinition, IAE is expected.
     */
    public void testGenerateComponent_UnmatchedPropertyDefinitionType() {
        pd.setPropertyType(PropertyType.CHECK_BOX);

        try {
            generator.generateComponent(pd);
            fail("IllegalArgumentException is expected since unmatched property type is sent.");
        } catch (IllegalArgumentException e) {
            // success.
        }
    }

    /**
     * Test method for
     * {@link FreeTextPropertyComponentGenerator#getPropertyType()}.
     */
    public void testGetPropertyType() {
        assertSame(PropertyType.FREE_TEXT, generator.getPropertyType());
    }
}
