/*
 * Copyright (C) 2008 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.gui.configurationmanager.failuretests;

import com.topcoder.gui.configurationmanager.PropertyDefinition;
import com.topcoder.gui.configurationmanager.ValidationResult;

import junit.framework.TestSuite;
import junit.framework.Test;
import junit.framework.TestCase;

/**
 * <p>
 * Failure test cases for ValidationResult.
 * </p>
 *
 * @author victorsam
 * @version 1.0
 */
public class ValidationResultFailureTests extends TestCase {

    /**
     * <p>
     * The PropertyDefinition instance for testing.
     * </p>
     */
    private PropertyDefinition property;

    /**
     * <p>
     * Setup test environment.
     * </p>
     *
     */
    protected void setUp() {
        property = new PropertyDefinition();
    }

    /**
     * <p>
     * Tears down test environment.
     * </p>
     *
     */
    protected void tearDown() {
        property = null;
    }

    /**
     * <p>
     * Return all tests.
     * </p>
     *
     * @return all tests
     */
    public static Test suite() {
        return new TestSuite(ValidationResultFailureTests.class);
    }

    /**
     * <p>
     * Tests ctor ValidationResult#ValidationResult(boolean,String,PropertyDefinition) for failure.
     * It tests the case that when description is null and expects IllegalArgumentException.
     * </p>
     */
    public void testCtor_NullDescription() {
        try {
            new ValidationResult(false, null, property);
            fail("IllegalArgumentException expected.");
        } catch (IllegalArgumentException iae) {
            //good
        }
    }

    /**
     * <p>
     * Tests ctor ValidationResult#ValidationResult(boolean,String,PropertyDefinition) for failure.
     * It tests the case that when description is empty and expects IllegalArgumentException.
     * </p>
     */
    public void testCtor_EmptyDescription() {
        try {
            new ValidationResult(false, " ", property);
            fail("IllegalArgumentException expected.");
        } catch (IllegalArgumentException iae) {
            //good
        }
    }

    /**
     * <p>
     * Tests ctor ValidationResult#ValidationResult(boolean,String,PropertyDefinition) for failure.
     * It tests the case that when property is null and expects IllegalArgumentException.
     * </p>
     */
    public void testCtor_NullProperty() {
        try {
            new ValidationResult(true, "description", null);
            fail("IllegalArgumentException expected.");
        } catch (IllegalArgumentException iae) {
            //good
        }
    }

}