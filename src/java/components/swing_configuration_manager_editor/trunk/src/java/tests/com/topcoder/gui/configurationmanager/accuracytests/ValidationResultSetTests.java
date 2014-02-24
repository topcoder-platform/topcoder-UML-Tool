/*
 * Copyright (C) 2008 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.gui.configurationmanager.accuracytests;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import junit.framework.TestCase;

import com.topcoder.gui.configurationmanager.PropertyDefinition;
import com.topcoder.gui.configurationmanager.PropertyType;
import com.topcoder.gui.configurationmanager.ValidationResult;
import com.topcoder.gui.configurationmanager.ValidationResultSet;

/**
 * <p>
 * This class contains a set of tests for {@link ValidationResultSet} class.
 * </p>
 *
 * @author uhmateush
 * @version 1.0
 */
public class ValidationResultSetTests extends TestCase {

    /**
     * <p>
     * Represents a description string for tests.
     * </p>
     */
    private static final String DESCRIPTION = "descr";

    /**
     * <p>
     * Represents an instance of <code>ValidationResultSet</code> for tests.
     * All results succeed.
     * </p>
     */
    private ValidationResultSet successInstance;

    /**
     * <p>
     * Represents an instance of <code>ValidationResultSet</code> for tests.
     * All results fail.
     * </p>
     */
    private ValidationResultSet failInstance;

    /**
     * <p>
     * Represents an instance of <code>PropertyDefinition</code> for tests.
     * </p>
     */
    private PropertyDefinition definition;

    /**
     * <p>
     * Represents validation results for tests.
     * </p>
     */
    private Map<PropertyDefinition, List<ValidationResult>> results;

    /**
     * <p>
     * Initializes test environment.
     * </p>
     *
     * @throws Exception exception to jUnit.
     */
    protected void setUp() throws Exception {
        definition = new PropertyDefinition();
        definition.setPromptText("text0");
        definition.setPropertyName("name0");
        definition.setPropertyType(PropertyType.CHECK_BOX);
        definition.setPropertyValue("value0");

        PropertyDefinition definition1 = new PropertyDefinition();
        definition1.setPromptText("text1");
        definition1.setPropertyName("name1");
        definition1.setPropertyType(PropertyType.FREE_TEXT);
        definition1.setPropertyValue("value1");
        
        results = new HashMap<PropertyDefinition, List<ValidationResult>>();
        results.put(definition,
            Arrays.asList(new ValidationResult[] {getSuccessfulResult(definition), getSuccessfulResult(definition1)}));
        results.put(definition1,
            Arrays.asList(new ValidationResult[] {getSuccessfulResult(definition), getSuccessfulResult(definition1)}));

        Map<PropertyDefinition, List<ValidationResult>> failResults = new HashMap<PropertyDefinition, List<ValidationResult>>();
        failResults.put(definition1,
            Arrays.asList(new ValidationResult[] {getSuccessfulResult(definition), getSuccessfulResult(definition1)}));
        failResults.put(definition,
            Arrays.asList(new ValidationResult[] {getSuccessfulResult(definition1), getFailResult(definition)}));

        successInstance = new ValidationResultSet(results);
        failInstance = new ValidationResultSet(failResults);
    }

    /**
     * <p>
     * Returns successful validation result.
     * </p>
     *
     * @param definition a definition to create a <code>ValidationResult</code> class.
     * @return successful validation result.
     */
    private ValidationResult getSuccessfulResult(PropertyDefinition definition) {
        return new ValidationResult(true, null, definition);
    }

    /**
     * <p>
     * Returns fail validation result.
     * </p>
     *
     * @param definition a definition to create a <code>ValidationResult</code> class.
     * @return fail validation result.
     */
    private ValidationResult getFailResult(PropertyDefinition definition) {
        return new ValidationResult(false, DESCRIPTION, definition);
    }

    /**
     * <p>
     * Tests class constructor.
     * Method <code>getValidationResults()</code> should return a shallow copy of the results map.
     * Method <code>getValidationResults(PropertyDefinition)</code>
     * should return a shallow copy of the results map.
     * </p>
     */
    public void testValidationResultSet() {
        successInstance = new ValidationResultSet(results);
        assertNotSame("Method getValidationResults() should return shallow copy of the validation results map.",
            results, successInstance.getValidationResults());
        assertNotSame("Method getValidationResults(PropertyDefinition) should return shallow copy of the validation "
            + "results list.", results.get(definition), successInstance.getValidationResults(definition));
    }

    /**
     * <p>
     * Tests <code>isSuccess()</code> method.
     * True value should be returned.
     * </p>
     */
    public void testIsSuccess0() {
        assertTrue("Method isSuccess is incorrect.", successInstance.isSuccess());
    }

    /**
     * <p>
     * Tests <code>isSuccess()</code> method.
     * False value should be returned.
     * </p>
     */
    public void testIsSuccess1() {
        assertFalse("Method isSuccess is incorrect.", failInstance.isSuccess());
    }

    /**
     * <p>
     * Tests <code>isSuccess(PropertyDefinition)</code> method.
     * True value should be returned.
     * </p>
     */
    public void testIsSuccess2() {
        assertTrue("Method isSuccess is incorrect.", successInstance.isSuccess(definition));
    }

    /**
     * <p>
     * Tests <code>isSuccess(PropertyDefinition)</code> method.
     * False value should be returned.
     * </p>
     */
    public void testIsSuccess3() {
        assertFalse("Method isSuccess is incorrect.", failInstance.isSuccess(definition));
    }
}