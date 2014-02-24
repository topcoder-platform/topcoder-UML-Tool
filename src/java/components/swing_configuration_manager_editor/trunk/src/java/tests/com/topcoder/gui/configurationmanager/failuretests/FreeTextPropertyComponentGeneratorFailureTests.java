/*
 * Copyright (C) 2008 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.gui.configurationmanager.failuretests;

import com.topcoder.gui.configurationmanager.PropertyDefinition;
import com.topcoder.gui.configurationmanager.PropertyType;
import com.topcoder.gui.configurationmanager.componentgenerators.FreeTextPropertyComponentGenerator;

import junit.framework.TestSuite;
import junit.framework.Test;
import junit.framework.TestCase;

/**
 * <p>
 * Failure test cases for FreeTextPropertyComponentGenerator.
 * </p>
 *
 * @author victorsam
 * @version 1.0
 */
public class FreeTextPropertyComponentGeneratorFailureTests extends TestCase {
    /**
     * <p>
     * The FreeTextPropertyComponentGenerator instance for testing.
     * </p>
     */
    private FreeTextPropertyComponentGenerator instance;

    /**
     * <p>
     * Setup test environment.
     * </p>
     *
     */
    protected void setUp() {
        instance = new FreeTextPropertyComponentGenerator();
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
        return new TestSuite(FreeTextPropertyComponentGeneratorFailureTests.class);
    }

    /**
     * <p>
     * Tests FreeTextPropertyComponentGenerator#generateComponent(PropertyDefinition) for failure.
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
     * Tests FreeTextPropertyComponentGenerator#generateComponent(PropertyDefinition) for failure.
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

}