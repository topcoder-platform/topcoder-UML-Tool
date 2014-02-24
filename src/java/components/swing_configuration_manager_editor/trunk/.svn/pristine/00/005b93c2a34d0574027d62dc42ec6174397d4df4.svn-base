/*
 * Copyright (C) 2008 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.gui.configurationmanager.failuretests;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.topcoder.gui.configurationmanager.PropertyDefinition;
import com.topcoder.gui.configurationmanager.ValidationResult;
import com.topcoder.gui.configurationmanager.ValidationResultSet;

import junit.framework.TestSuite;
import junit.framework.Test;
import junit.framework.TestCase;

/**
 * <p>
 * Failure test cases for ValidationResultSet.
 * </p>
 *
 * @author victorsam
 * @version 1.0
 */
public class ValidationResultSetFailureTests extends TestCase {
    /**
     * <p>
     * The ValidationResultSet instance for testing.
     * </p>
     */
    private ValidationResultSet instance;

    /**
     * <p>
     * The PropertyDefinition instance for testing.
     * </p>
     */
    private PropertyDefinition property;

    /**
     * <p>
     * The ValidationResult instance for testing.
     * </p>
     */
    private ValidationResult result;

    /**
     * <p>
     * The ValidationResult list for testing.
     * </p>
     */
    private List<ValidationResult> results;

    /**
     * <p>
     * The validationResults map for testing.
     * </p>
     */
    private Map<PropertyDefinition, List<ValidationResult>> validationResults;

    /**
     * <p>
     * Setup test environment.
     * </p>
     *
     */
    protected void setUp() {
        property = new PropertyDefinition();
        result = new ValidationResult(true, "description", property);
        results = new ArrayList<ValidationResult>();
        results.add(result);
        validationResults = new HashMap<PropertyDefinition, List<ValidationResult>>();
        validationResults.put(property, results);

        instance = new ValidationResultSet(validationResults);
    }

    /**
     * <p>
     * Tears down test environment.
     * </p>
     *
     */
    protected void tearDown() {
        instance = null;
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
        return new TestSuite(ValidationResultSetFailureTests.class);
    }

    /**
     * <p>
     * Tests ctor ValidationResultSet#ValidationResultSet(Map) for failure.
     * It tests the case that when validationResults is null and expects IllegalArgumentException.
     * </p>
     */
    public void testCtor_NullValidationResults() {
        try {
            new ValidationResultSet(null);
            fail("IllegalArgumentException expected.");
        } catch (IllegalArgumentException iae) {
            //good
        }
    }

    /**
     * <p>
     * Tests ctor ValidationResultSet#ValidationResultSet(Map) for failure.
     * It tests the case that when validationResults is null key and expects IllegalArgumentException.
     * </p>
     */
    public void testCtor_NullKeyValidationResults() {
        validationResults.put(null, results);
        try {
            new ValidationResultSet(validationResults);
            fail("IllegalArgumentException expected.");
        } catch (IllegalArgumentException iae) {
            //good
        }
    }

    /**
     * <p>
     * Tests ctor ValidationResultSet#ValidationResultSet(Map) for failure.
     * It tests the case that when the inner list is null and expects IllegalArgumentException.
     * </p>
     */
    public void testCtor_NullListValidationResults() {
        validationResults.put(property, null);
        try {
            new ValidationResultSet(validationResults);
            fail("IllegalArgumentException expected.");
        } catch (IllegalArgumentException iae) {
            //good
        }
    }

    /**
     * <p>
     * Tests ctor ValidationResultSet#ValidationResultSet(Map) for failure.
     * It tests the case that when the inner list contains null and expects IllegalArgumentException.
     * </p>
     */
    public void testCtor_NullInListValidationResults() {
        results.add(null);
        try {
            new ValidationResultSet(validationResults);
            fail("IllegalArgumentException expected.");
        } catch (IllegalArgumentException iae) {
            //good
        }
    }

    /**
     * <p>
     * Tests ValidationResultSet#isSuccess(PropertyDefinition) for failure.
     * It tests the case that when property is null and expects IllegalArgumentException.
     * </p>
     */
    public void testIsSuccess_NullProperty() {
        try {
            instance.isSuccess(null);
            fail("IllegalArgumentException expected.");
        } catch (IllegalArgumentException iae) {
            //good
        }
    }

    /**
     * <p>
     * Tests ValidationResultSet#getValidationResults(PropertyDefinition) for failure.
     * It tests the case that when property is null and expects IllegalArgumentException.
     * </p>
     */
    public void testGetValidationResults_NullProperty() {
        try {
            instance.getValidationResults(null);
            fail("IllegalArgumentException expected.");
        } catch (IllegalArgumentException iae) {
            //good
        }
    }

}