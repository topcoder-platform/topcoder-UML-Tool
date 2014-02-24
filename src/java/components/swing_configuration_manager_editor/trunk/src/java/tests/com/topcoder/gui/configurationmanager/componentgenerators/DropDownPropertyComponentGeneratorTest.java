/*
 * Copyright (C) 2008 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.gui.configurationmanager.componentgenerators;

import java.util.Arrays;
import java.util.HashSet;

import javax.swing.JComboBox;

import com.topcoder.gui.configurationmanager.PropertyDefinition;
import com.topcoder.gui.configurationmanager.PropertyType;

import junit.framework.TestCase;

/**
 * This is unit test for DropDownPropertyComponentGenerator class.
 *
 * @author TCSDEVELOPER
 * @version 1.0
 */
public class DropDownPropertyComponentGeneratorTest extends TestCase {
    /**
     * Represents DropDownPropertyComponentGenerator instance for test.
     */
    private DropDownPropertyComponentGenerator generator;

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
        pd.setPropertyType(PropertyType.DROP_DOWN);
        pd.setPropertyValue("pv");

        pd.setValueChoices(new HashSet<String>(Arrays.asList(new String[] { "pv", "true", "false" })));
        generator = new DropDownPropertyComponentGenerator();
    }

    /**
     * Tests constructor. . No exception is expected.
     */
    public void testDropDownPropertyComponentGenerator() {
        new DropDownPropertyComponentGenerator();
    }

    /**
     * Test method for
     * {@link DropDownPropertyComponentGenerator#generateComponent(PropertyDefinition)}
     * .
     *
     * When the generated DropDown is selected/unselected, the associated
     * property value should be automatically updated too.
     */
    public void testGenerateComponent() {
        JComboBox dropDown = generator.generateComponent(pd);
        assertEquals(pd.getPropertyValue(), dropDown.getSelectedItem());

        pd.setPropertyValue("true");
        dropDown = generator.generateComponent(pd);
        assertEquals(pd.getPropertyValue(), dropDown.getSelectedItem());
        assertEquals("true", dropDown.getSelectedItem());

        pd.setPropertyValue("false");
        dropDown = generator.generateComponent(pd);
        assertEquals(pd.getPropertyValue(), dropDown.getSelectedItem());
        assertEquals("false", dropDown.getSelectedItem());

        dropDown.setSelectedItem("false");
        assertEquals("false", pd.getPropertyValue());

        dropDown.setSelectedItem("true");
        assertEquals("true", pd.getPropertyValue());
    }

    /**
     * Test method for
     * {@link DropDownPropertyComponentGenerator#generateComponent(PropertyDefinition)}
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
     * {@link DropDownPropertyComponentGenerator#generateComponent(PropertyDefinition)}
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
     * {@link DropDownPropertyComponentGenerator#generateComponent(PropertyDefinition)}
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
     * {@link DropDownPropertyComponentGenerator#getPropertyType()}.
     */
    public void testGetPropertyType() {
        assertSame(PropertyType.DROP_DOWN, generator.getPropertyType());
    }
}
