/*
 * Copyright (C) 2008 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.gui.configurationmanager.accuracytests;

import com.topcoder.gui.configurationmanager.PropertyDefinition;
import com.topcoder.gui.configurationmanager.PropertyType;
import com.topcoder.gui.configurationmanager.ValidationResult;

import junit.framework.TestCase;

/**
 * <p>
 * This class contains a set of tests for {@link ValidationResult} class.
 * Class getters tests inside the constructor test cases.
 * </p>
 *
 * @author uhmateush
 * @version 1.0
 */
public class ValidationResultTests extends TestCase {

    /**
     * <p>
     * Represents an empty string for tests.
     * </p>
     */
    private static final String EMPTY_STRING = " ";

    /**
     * <p>
     * Represents a description string for tests.
     * </p>
     */
    private static final String DESCRIPTION = "descr";

    /**
     * <p>
     * Represents an instance of <code>ValidationResult</code> for tests.
     * </p>
     */
    private ValidationResult instance;

    /**
     * <p>
     * Represents an instance of <code>PropertyDefinition</code> for tests.
     * </p>
     */
    private PropertyDefinition definition;

    /**
     * <p>
     * Initializes test environment.
     * </p>
     *
     * @throws Exception exception to jUnit.
     */
    protected void setUp() throws Exception {
        definition = new PropertyDefinition();
        definition.setPromptText("text");
        definition.setPropertyName("name");
        definition.setPropertyType(PropertyType.CHECK_BOX);
        definition.setPropertyValue("value");

        instance = new ValidationResult(true, DESCRIPTION, definition);
    }

    /**
     * <p>
     * Tests class constructor.
     * </p>
     */
    public void testConstructor0() {
        assertTrue("Parameter success should be set to true.", instance.isSuccess());
        assertEquals(DESCRIPTION, instance.getDescription());
        assertSame(definition, instance.getProperty());
    }

    /**
     * <p>
     * Tests class constructor. Parameter description is null.
     * </p>
     */
    public void testConstructor1() {
        instance = new ValidationResult(true, null, definition);
        assertTrue("Parameter success should be set to true.", instance.isSuccess());
        assertEquals(null, instance.getDescription());
        assertSame(definition, instance.getProperty());
    }

    /**
     * <p>
     * Tests class constructor. Parameter description is empty string.
     * </p>
     */
    public void testConstructor2() {
        instance = new ValidationResult(true, EMPTY_STRING, definition);
        assertTrue("Parameter success should be set to true.", instance.isSuccess());
        assertEquals(EMPTY_STRING, instance.getDescription());
        assertSame(definition, instance.getProperty());
    }

    /**
     * <p>
     * Tests class constructor. Parameter success is false.
     * </p>
     */
    public void testConstructor3() {
        instance = new ValidationResult(false, DESCRIPTION, definition);
        assertFalse("Parameter success should be set to false.", instance.isSuccess());
        assertEquals(DESCRIPTION, instance.getDescription());
        assertSame(definition, instance.getProperty());
    }
}