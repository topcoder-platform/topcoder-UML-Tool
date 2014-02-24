/*
 * Copyright (C) 2008 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.gui.configurationmanager.failuretests;

import com.topcoder.gui.configurationmanager.PropertyDefinition;
import com.topcoder.gui.configurationmanager.PropertyType;
import com.topcoder.gui.configurationmanager.componentgenerators.RadioButtonsPropertyComponentGenerator;

import junit.framework.TestSuite;
import junit.framework.Test;
import junit.framework.TestCase;

/**
 * <p>
 * Failure test cases for RadioButtonsPropertyComponentGenerator.
 * </p>
 *
 * @author victorsam
 * @version 1.0
 */
public class RadioButtonsPropertyComponentGeneratorFailureTests extends TestCase {

    /**
     * <p>
     * The RadioButtonsPropertyComponentGenerator instance for testing.
     * </p>
     */
    private RadioButtonsPropertyComponentGenerator instance;

    /**
     * <p>
     * Setup test environment.
     * </p>
     *
     */
    protected void setUp() {
        instance = new RadioButtonsPropertyComponentGenerator();
    }

    /**
     * <p>
     * Tears down test environment.
     * </p>
     *
     */
    protected void tearDown() {
        instance = null;
    }

    /**
     * <p>
     * Return all tests.
     * </p>
     *
     * @return all tests
     */
    public static Test suite() {
        return new TestSuite(RadioButtonsPropertyComponentGeneratorFailureTests.class);
    }

    /**
     * <p>
     * Tests RadioButtonsPropertyComponentGenerator#generateComponent(PropertyDefinition) for failure.
     * It tests the case that when propertyDefinition is null and expects IllegalArgumentException.
     * </p>
     */
    public void testGenerateComponent_NullPropertyDefinition() {
        try {
            instance.generateComponent(null);
            fail("IllegalArgumentException expected.");
        } catch (IllegalArgumentException iae) {
            //good
        }
    }

    /**
     * <p>
     * Tests RadioButtonsPropertyComponentGenerator#generateComponent(PropertyDefinition) for failure.
     * It tests the case that when the propertyDefinition.type is not equal to getPropertyType()
     * and expects IllegalArgumentException.
     * </p>
     */
    public void testGenerateComponent_NotExpectType() {
        PropertyDefinition property = new PropertyDefinition();
        property.setPropertyType(PropertyType.CHECK_BOX);
        try {
            instance.generateComponent(property);
            fail("IllegalArgumentException expected.");
        } catch (IllegalArgumentException iae) {
            //good
        }
    }

    /**
     * <p>
     * Tests RadioButtonsPropertyComponentGenerator#generateComponent(PropertyDefinition) for failure.
     * It tests the case that when value choices does not contain the expected property value
     * and expects IllegalArgumentException.
     * </p>
     */
    public void testGenerateComponent_NotExpectValue() {
        PropertyDefinition property = new PropertyDefinition();
        property.setPropertyType(PropertyType.RADIO_BUTTONS);
        property.setPropertyValue("propertyValue");
        try {
            instance.generateComponent(property);
            fail("IllegalArgumentException expected.");
        } catch (IllegalArgumentException iae) {
            //good
        }
    }

}