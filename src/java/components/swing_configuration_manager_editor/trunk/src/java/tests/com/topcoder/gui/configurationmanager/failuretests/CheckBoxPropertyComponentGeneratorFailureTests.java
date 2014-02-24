/*
 * Copyright (C) 2008 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.gui.configurationmanager.failuretests;

import com.topcoder.gui.configurationmanager.PropertyDefinition;
import com.topcoder.gui.configurationmanager.PropertyType;
import com.topcoder.gui.configurationmanager.componentgenerators.CheckBoxPropertyComponentGenerator;

import junit.framework.TestSuite;
import junit.framework.Test;
import junit.framework.TestCase;

/**
 * <p>
 * Failure test cases for CheckBoxPropertyComponentGenerator.
 * </p>
 *
 * @author victorsam
 * @version 1.0
 */
public class CheckBoxPropertyComponentGeneratorFailureTests extends TestCase {
    /**
     * <p>
     * The CheckBoxPropertyComponentGenerator instance for testing.
     * </p>
     */
    private CheckBoxPropertyComponentGenerator instance;

    /**
     * <p>
     * Setup test environment.
     * </p>
     *
     */
    protected void setUp() {
        instance = new CheckBoxPropertyComponentGenerator();
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
        return new TestSuite(CheckBoxPropertyComponentGeneratorFailureTests.class);
    }

    /**
     * <p>
     * Tests CheckBoxPropertyComponentGenerator#generateComponent(PropertyDefinition) for failure.
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
     * Tests CheckBoxPropertyComponentGenerator#generateComponent(PropertyDefinition) for failure.
     * It tests the case that when the propertyDefinition.type is not equal to getPropertyType()
     * and expects IllegalArgumentException.
     * </p>
     */
    public void testGenerateComponent_NotExpectType() {
        PropertyDefinition property = new PropertyDefinition();
        property.setPropertyType(PropertyType.DROP_DOWN);
        try {
            instance.generateComponent(property);
            fail("IllegalArgumentException expected.");
        } catch (IllegalArgumentException iae) {
            //good
        }
    }

}