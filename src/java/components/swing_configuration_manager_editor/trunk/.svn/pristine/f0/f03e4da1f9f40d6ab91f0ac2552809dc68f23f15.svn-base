/*
 * Copyright (C) 2008 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.gui.configurationmanager;

import junit.framework.TestCase;

/**
 * The unit test for the class {@link ValidationResult}.
 *
 * @author TCSDEVELOPER
 * @version 1.0
 */
public class ValidationResultTest extends TestCase {
    /**
     * Represents ValidationResult for test.
     */
    private ValidationResult instance;

    /**
     * Represents PropertyDefinition for test.
     */
    private PropertyDefinition pd;

    /**
     * Setup test environment.
     *
     * @throws Exception
     *             Exception to JUnit.
     */
    protected void setUp() throws Exception {
        super.setUp();
        pd = new PropertyDefinition();
        pd.setPromptText("pt1");
        pd.setPropertyName("pn1");
        pd.setPropertyType(PropertyType.CHECK_BOX);
        pd.setPropertyValue("pv1");

        instance = new ValidationResult(true, "desc", pd);
    }

    /**
     * Test constructor.
     */
    public void testClassMethods() {
        instance = new ValidationResult(true, "desc", pd);
        assertEquals(true, instance.isSuccess());
        assertEquals("desc", instance.getDescription());
        assertSame(pd, instance.getProperty());
    }

    /**
     * Test constructor.
     */
    public void testConstructor_TrueSuccess_NullDescription() {
        instance = new ValidationResult(true, null, pd);
        assertEquals(true, instance.isSuccess());
        assertNull(instance.getDescription());
        assertSame(pd, instance.getProperty());
    }

    /**
     * Test constructor.
     */
    public void testConstructor_TrueSuccess_EmptyDescription() {
        instance = new ValidationResult(true, " ", pd);
        assertEquals(true, instance.isSuccess());
        assertEquals(" ", instance.getDescription());
        assertSame(pd, instance.getProperty());
    }

    /**
     * Test constructor.
     */
    public void testConstructor_FailSuccess_NullDescription() {
        try {
            new ValidationResult(false, null, pd);
            fail("IllegalArgumentException is expected since the success is false and the description is null.");
        } catch (IllegalArgumentException e) {
            // success.
        }
    }

    /**
     * Test constructor.
     */
    public void testConstructor_FailSuccess_EmptyDescription() {
        try {
            new ValidationResult(false, " ", pd);
            fail("IllegalArgumentException is expected since the success is false and the description is empty.");
        } catch (IllegalArgumentException e) {
            // success.
        }
    }

    /**
     * Test constructor.
     */
    public void testConstructor_NullPropertyDefinition() {
        try {
            new ValidationResult(false, "desc", null);
            fail("IllegalArgumentException is expected since the property is null.");
        } catch (IllegalArgumentException e) {
            // success.
        }
    }
}
