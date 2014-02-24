/*
 * Copyright (C) 2008 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.gui.configurationmanager;

import java.util.Arrays;
import java.util.HashSet;

import junit.framework.TestCase;

/**
 * This is unit test for PropertyDefinition class.
 *
 * @author TCSDEVELOPER
 * @version 1.0
 */
public class PropertyDefinitionTest extends TestCase {
    /**
     * Represents PropertyDefinition instance for test.
     */
    private PropertyDefinition instance = new PropertyDefinition();

    /**
     * Test method for
     * {@link com.topcoder.gui.configurationmanager.PropertyDefinition#PropertyDefinition()}
     * .
     */
    public void testPropertyDefinition() {
        instance = new PropertyDefinition();
        assertNull("propertyName is not correctly initialized.", instance.getPropertyName());
        assertNull("propertyValue is not correctly initialized.", instance.getPropertyValue());
        assertNull("promptText is not correctly initialized.", instance.getPromptText());
        assertNull("valueChoices is not correctly initialized.", instance.getValueChoices());
        assertNull("propertyType is not correctly initialized.", instance.getPropertyType());
    }

    /**
     * Tests getter and setter for propertyName field.
     */
    public void testPropertyName_SetNull() {
        instance.setPropertyName(null);
        assertNull("propertyName is not correctly set.", instance.getPropertyName());
    }

    /**
     * Tests getter and setter for propertyName field.
     */
    public void testPropertyName_SetEmpty() {
        instance.setPropertyName("");
        assertEquals("propertyName is not correctly set.", "", instance.getPropertyName());
    }

    /**
     * Tests getter and setter for propertyName field.
     */
    public void testPropertyName() {
        instance.setPropertyName("abc");
        assertEquals("propertyName is not correctly set.", "abc", instance.getPropertyName());
    }

    /**
     * Tests getter and setter for promptText field.
     */
    public void testPromptTextSetNull() {
        instance.setPromptText(null);
        assertNull("propertyName is not correctly set.", instance.getPromptText());
    }

    /**
     * Tests getter and setter for promptText field.
     */
    public void testPromptText_SetEmpty() {
        instance.setPromptText("");
        assertEquals("promptText is not correctly set.", "", instance.getPromptText());
    }

    /**
     * Tests getter and setter for promptText field.
     */
    public void testPromptText() {
        instance.setPromptText("abc");
        assertEquals("promptText is not correctly set.", "abc", instance.getPromptText());
    }

    /**
     * Tests getter and setter for propertyType field.
     */
    public void testPropertyTypeSetNull() {
        instance.setPropertyType(null);
        assertNull("propertyType is not correctly set.", instance.getPropertyType());
    }

    /**
     * Tests getter and setter for promptText field.
     */
    public void testPropertyType() {
        instance.setPropertyType(PropertyType.CHECK_BOX);
        assertEquals("propertyType is not correctly set.", PropertyType.CHECK_BOX, instance.getPropertyType());

        instance.setPropertyType(PropertyType.DROP_DOWN);
        assertEquals("propertyType is not correctly set.", PropertyType.DROP_DOWN, instance.getPropertyType());

        instance.setPropertyType(PropertyType.FREE_TEXT);
        assertEquals("propertyType is not correctly set.", PropertyType.FREE_TEXT, instance.getPropertyType());

        instance.setPropertyType(PropertyType.RADIO_BUTTONS);
        assertEquals("propertyType is not correctly set.", PropertyType.RADIO_BUTTONS, instance.getPropertyType());
    }

    /**
     * Tests getter and setter for propertyValue field.
     */
    public void testPropertyValueSetNull() {
        instance.setPropertyValue(null);
        assertNull("propertyName is not correctly set.", instance.getPropertyValue());
    }

    /**
     * Tests getter and setter for propertyValue field.
     */
    public void testPropertyValue_SetEmpty() {
        instance.setPropertyValue("");
        assertEquals("propertyValue is not correctly set.", "", instance.getPropertyValue());
    }

    /**
     * Tests getter and setter for propertyValue field.
     */
    public void testPropertyValue() {
        instance.setPropertyValue("abc");
        assertEquals("propertyValue is not correctly set.", "abc", instance.getPropertyValue());
    }

    /**
     * Tests getter and setter for valueChoices field.
     */
    public void testValueChoices_Null() {
        instance.setValueChoices(null);
        assertNull("valueChoices is not correctly set.", instance.getValueChoices());
    }

    /**
     * Tests getter and setter for valueChoices field.
     */
    public void testValueChoices_EmptySet() {
        instance.setValueChoices(new HashSet<String>());
        assertEquals("valueChoices is not correctly set.", 0, instance.getValueChoices().size());
    }

    /**
     * Tests getter and setter for valueChoices field.
     */
    public void testValueChoices() {
        instance.setValueChoices(new HashSet<String>(Arrays.asList("1", "2", "3")));
        assertEquals("valueChoices is not correctly set.", 3, instance.getValueChoices().size());
        assertTrue("valueChoices is not correctly set.", instance.getValueChoices().contains("1"));
        assertTrue("valueChoices is not correctly set.", instance.getValueChoices().contains("2"));
        assertTrue("valueChoices is not correctly set.", instance.getValueChoices().contains("3"));
    }

    /**
     * Tests getter and setter for valueChoices field.
     *
     * IllegalArgumentException is expected since valueChoices contains null
     * value.
     */
    public void testValueChoices_NullValue() {
        try {
            instance.setValueChoices(new HashSet<String>(Arrays.asList("1", null, "3")));
            fail("IAE is expected since null value is given");
        } catch (IllegalArgumentException e) {
        }
    }
}
