/*
 * Copyright (C) 2008 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.gui.configurationmanager.accuracytests;

import junit.framework.TestCase;
import com.topcoder.gui.configurationmanager.PropertyDefinition;
import com.topcoder.gui.configurationmanager.PropertyType;

import java.util.HashSet;
import java.util.Arrays;
import java.util.Set;

/**
 * <p>
 * This class contains a set of tests for {@link PropertyDefinition} class.
 * </p>
 *
 * @author uhmateush
 * @version 1.0
 */
public class PropertyDefinitionTests extends TestCase {

    /**
     * <p>
     * Represents an empty string for tests.
     * </p>
     */
    private static final String EMPTY_STRING = " ";

    /**
     * <p>
     * Represents a test string for tests.
     * </p>
     */
    private static final String TEST_STRING = "test";

    /**
     * <p>
     * Represents an instance of <code>PropertyDefinition</code> for tests.
     * </p>
     */
    private PropertyDefinition instance = new PropertyDefinition();

    /**
     * <p>
     * Tests class constructor. All fields should be set to null.
     * </p>
     */
    public void testPropertyDefinition() {
        instance = new PropertyDefinition();
        assertNull("Field propertyName sould be initialized to null.", instance.getPropertyName());
        assertNull("Field propertyValue sould be initialized to null.", instance.getPropertyValue());
        assertNull("Field promptText sould be initialized to null.", instance.getPromptText());
        assertNull("Field valueChoices sould be initialized to null.", instance.getValueChoices());
        assertNull("Field propertyType sould be initialized to null.", instance.getPropertyType());
    }

    /**
     * <p>
     * Tests getter and setter for propertyName field.
     * Field propertyName should be set to null.
     * </p>
     */
    public void testPropertyName0() {
        instance.setPropertyName(null);
        assertNull("Field propertyName should be set to null.", instance.getPropertyName());
    }

    /**
     * <p>
     * Tests getter and setter for propertyName field.
     * Field propertyName should be set to empty string.
     * </p>
     */
    public void testPropertyName1() {
        instance.setPropertyName(EMPTY_STRING);
        assertEquals("Field propertyName should be set to empty string", EMPTY_STRING, instance.getPropertyName());
    }

    /**
     * <p>
     * Tests getter and setter for propertyName field.
     * Field propertyName should be set to test string.
     * </p>
     */
    public void testPropertyName2() {
        instance.setPropertyName(TEST_STRING);
        assertEquals("Returned propertyName should be equal to set.", TEST_STRING, instance.getPropertyName());
    }

    /**
     * <p>
     * Tests getter and setter for promptText field.
     * Field propertyName should be set to null.
     * </p>
     */
    public void testPromptText0() {
        instance.setPromptText(null);
        assertNull("Field promptText should be set to null.", instance.getPromptText());
    }

    /**
     * <p>
     * Tests getter and setter for promptText field.
     * Field propertyName should be set to empty string.
     * </p>
     */
    public void testPromptText1() {
        instance.setPromptText(EMPTY_STRING);
        assertEquals("Field promptText should be set to empty string", EMPTY_STRING, instance.getPromptText());
    }

    /**
     * <p>
     * Tests getter and setter for promptText field.
     * Field propertyName should be set to test string.
     * </p>
     */
    public void testPromptText2() {
        instance.setPromptText(TEST_STRING);
        assertEquals("Returned promptText should be equal to set.", TEST_STRING, instance.getPromptText());
    }

    /**
     * <p>
     * Tests getter and setter for propertyType field.
     * Field propertyName should be set to empty string.
     * </p>
     */
    public void testPropertyType0() {
        instance.setPropertyType(null);
        assertNull("Field propertyType should be set to null.", instance.getPropertyType());
    }

    /**
     * <p>
     * Tests getter and setter for promptText field.
     * Field propertyName should be set to test values.
     * </p>
     */
    public void testPropertyType1() {
        instance.setPropertyType(PropertyType.CHECK_BOX);
        assertEquals("Returned propertyType should be equal to set.", PropertyType.CHECK_BOX, instance.getPropertyType());

        instance.setPropertyType(PropertyType.DROP_DOWN);
        assertEquals("Returned propertyType should be equal to set.", PropertyType.DROP_DOWN, instance.getPropertyType());

        instance.setPropertyType(PropertyType.FREE_TEXT);
        assertEquals("Returned propertyType should be equal to set.", PropertyType.FREE_TEXT, instance.getPropertyType());

        instance.setPropertyType(PropertyType.RADIO_BUTTONS);
        assertEquals("Returned propertyType should be equal to set.", PropertyType.RADIO_BUTTONS, instance.getPropertyType());
    }

    /**
     * <p>
     * Tests getter and setter for propertyValue field.
     * Field propertyValue should be set to null.
     * </p>
     */
    public void testPropertyValue0() {
        instance.setPropertyValue(null);
        assertNull("Field propertyValue should be set to null.", instance.getPropertyValue());
    }

    /**
     * <p>
     * Tests getter and setter for propertyValue field.
     * Field propertyValue should be set to empty string.
     * </p>
     */
    public void testPropertyValue1() {
        instance.setPropertyValue(EMPTY_STRING);
        assertEquals("Field propertyValue should be set to empty string", EMPTY_STRING, instance.getPropertyValue());
    }

    /**
     * <p>
     * Tests getter and setter for propertyValue field.
     * Field propertyValue should be set to test string.
     * </p>
     */
    public void testPropertyValue2() {
        instance.setPropertyValue(TEST_STRING);
        assertEquals("Returned propertyValue should be equal to set.", TEST_STRING, instance.getPropertyValue());
    }

    /**
     * <p>
     * Tests getter and setter for valueChoices field.
     * Field valueChoices should be set to null.
     * </p>
     */
    public void testValueChoices0() {
        instance.setValueChoices(null);
        assertNull("Field propertyValue should be set to null.", instance.getValueChoices());
    }

    /**
     * <p>
     * Tests getter and setter for valueChoices field.
     * Field valueChoices should be set empty set.
     * </p>
     */
    public void testValueChoices1() {
        instance.setValueChoices(new HashSet<String>());
        assertEquals("Field valueChoices is not correctly set.", 0, instance.getValueChoices().size());
    }

    /**
     * <p>
     * Tests getter and setter for valueChoices field.
     * Field valueChoices should be set to test set.
     * </p>
     */
    public void testValueChoices() {
        Set<String> testSet = new HashSet<String>(Arrays.asList("a", "b", "c"));
        instance.setValueChoices(testSet);
        assertEquals("Field valueChoices should be set to test set.", testSet.size(), instance.getValueChoices().size());
        assertTrue("Field valueChoices should be set to test set.", instance.getValueChoices().contains("a"));
        assertTrue("Field valueChoices should be set to test set.", instance.getValueChoices().contains("b"));
        assertTrue("Field valueChoices should be set to test set.", instance.getValueChoices().contains("c"));
    }
}