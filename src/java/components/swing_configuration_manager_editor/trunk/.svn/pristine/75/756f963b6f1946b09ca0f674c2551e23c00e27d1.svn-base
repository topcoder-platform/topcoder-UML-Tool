/*
 * Copyright (C) 2008 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.gui.configurationmanager;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import junit.framework.TestCase;

/**
 * This is unit test for ValidationResultSet class.
 *
 * @author TCSDEVELOPER
 * @version 1.0
 */
public class ValidationResultSetTest extends TestCase {
    /**
     * Represents ValidationResultSet instance for test.
     */
    private ValidationResultSet instance;
    /**
     * Represents validation results for test.
     */
    private Map<PropertyDefinition, List<ValidationResult>> results;
    /**
     * Represents PropertyDefinition for test.
     */
    private PropertyDefinition pd1;
    /**
     * Represents ValidationResult for test.
     */
    private ValidationResult result1;
    /**
     * Represents PropertyDefinition for test.
     */
    private PropertyDefinition pd2;
    /**
     * Represents ValidationResult for test.
     */
    private ValidationResult result2;

    /**
     * Setup test environment.
     *
     * @throws Exception
     *             Exception to JUnit.
     */
    protected void setUp() throws Exception {
        super.setUp();
        results = new HashMap<PropertyDefinition, List<ValidationResult>>();
        pd1 = new PropertyDefinition();
        pd1.setPromptText("pt1");
        pd1.setPropertyName("pn1");
        pd1.setPropertyType(PropertyType.CHECK_BOX);
        pd1.setPropertyValue("pv1");

        pd2 = new PropertyDefinition();
        pd2.setPromptText("pt2");
        pd2.setPropertyName("pn2");
        pd2.setPropertyType(PropertyType.CHECK_BOX);
        pd2.setPropertyValue("pv2");

        result1 = new ValidationResult(true, null, pd1);
        result2 = new ValidationResult(false, "fail", pd1);

        results.put(pd1, new ArrayList<ValidationResult>(Arrays.asList(result1)));
        instance = new ValidationResultSet(results);
    }

    /**
     * Tests constructor.
     */
    public void testValidationResultSet() {
        instance = new ValidationResultSet(results);
    }

    /**
     * Tests constructor.
     */
    public void testValidationResultSet_NullKey() {
        results.put(null, new ArrayList<ValidationResult>(Arrays.asList(result1)));
        try {
            new ValidationResultSet(results);
            fail("IllegalArgumentException is expected.");
        } catch (IllegalArgumentException e) {
        }
    }

    /**
     * Tests constructor.
     */
    public void testValidationResultSet_NullValue() {
        results.clear();
        results.put(pd1, null);
        try {
            new ValidationResultSet(results);
            fail("IllegalArgumentException is expected.");
        } catch (IllegalArgumentException e) {
        }
    }

    /**
     * Tests constructor.
     */
    public void testValidationResultSet_ValueWithNullElement() {
        results.clear();
        ArrayList<ValidationResult> value = new ArrayList<ValidationResult>();
        value.add(null);
        results.put(pd1, value);
        try {
            new ValidationResultSet(results);
            fail("IllegalArgumentException is expected.");
        } catch (IllegalArgumentException e) {
        }
    }

    /**
     * Tests constructor.
     */
    public void testValidationResultSet_NullResults() {
        try {
            new ValidationResultSet(null);
            fail("IllegalArgumentException is expected.");
        } catch (IllegalArgumentException e) {
        }
    }

    /**
     * Tests isSuccess() method.
     */
    public void testIsSuccess1() {
        assertTrue("isSuccess is incorrect.", instance.isSuccess());
    }

    /**
     * Tests isSuccess() method.
     */
    public void testIsSuccess2() {
        results.put(pd2, new ArrayList<ValidationResult>(Arrays.asList(result2)));
        instance = new ValidationResultSet(results);
        assertFalse("isSuccess is incorrect.", instance.isSuccess());
    }

    /**
     * Tests isSuccess(PropertyDefinition) method. .
     */
    public void testIsSuccessPropertyDefinition() {
        results.put(pd2, new ArrayList<ValidationResult>(Arrays.asList(result2)));
        instance = new ValidationResultSet(results);
        assertTrue("isSuccess is incorrect.", instance.isSuccess(pd1));
        assertFalse("isSuccess is incorrect.", instance.isSuccess(pd2));
    }

    /**
     * Tests isSuccess(PropertyDefinition) method. .
     */
    public void testIsSuccessPropertyDefinition_NullParameter() {
        try {
            instance.isSuccess(null);
            fail("IllegalArgumentException is expected.");
        } catch (IllegalArgumentException e) {
        }
    }

    /**
     * Tests getValidationResults() methods. .
     */
    public void testGetValidationResults() {
        assertEquals("getValidationResults is incorrect.", 1, instance.getValidationResults().size());
    }

    /**
     * Tests testGetValidationResults(PropertyDefinition) method. .
     */
    public void testGetValidationResultsPropertyDefinition() {
        assertEquals("getValidationResults is incorrect.", 1, instance.getValidationResults(pd1).size());
    }
}
