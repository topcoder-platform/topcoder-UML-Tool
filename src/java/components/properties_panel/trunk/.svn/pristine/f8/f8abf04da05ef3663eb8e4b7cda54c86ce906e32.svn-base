/*
 * Copyright (C) 2007-2008 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.gui.panels.properties.propertypanel;

import com.topcoder.uml.model.core.extensionmechanisms.Stereotype;
import com.topcoder.uml.model.core.extensionmechanisms.StereotypeImpl;

import junit.framework.TestCase;
import junit.framework.TestSuite;
import junit.framework.Test;

/**
 * <p>
 * Unit test cases for StereotypeItem.
 * </p>
 *
 * @author TCSDEVELOPER
 * @version 1.0
 */
public class StereotypeItemTests extends TestCase {
    /**
     * <p>
     * The StereotypeItem instance for testing.
     * </p>
     */
    private StereotypeItem item;

    /**
     * <p>
     * The Stereotype instance for testing.
     * </p>
     */
    private Stereotype stereotype;

    /**
     * <p>
     * Sets up test environment.
     * </p>
     *
     */
    protected void setUp() {
        stereotype = new StereotypeImpl();
        stereotype.setName("type");
        item = new StereotypeItem(stereotype);
    }

    /**
     * <p>
     * Tears down test environment.
     * </p>
     *
     */
    protected void tearDown() {
        item = null;
        stereotype = null;
    }

    /**
     * <p>
     * Returns all tests.
     * </p>
     *
     * @return all tests
     */
    public static Test suite() {
        return new TestSuite(StereotypeItemTests.class);
    }

    /**
     * <p>
     * Tests StereotypeItem#StereotypeItem(Stereotype) for accuracy.
     * </p>
     *
     * <p>
     * It verifies the newly created StereotypeItem instance should not be null.
     * </p>
     */
    public void testCtor() {
        assertNotNull("Failed to create a new StereotypeItem instance.", item);
    }

    /**
     * <p>
     * Tests ctor StereotypeItem#StereotypeItem(Stereotype) for failure.
     * </p>
     *
     * <p>
     * It tests the case that when stereotype is null and expects IllegalArgumentException.
     * </p>
     */
    public void testCtor_NullStereotype() {
        try {
            new StereotypeItem(null);
            fail("IllegalArgumentException expected.");
        } catch (IllegalArgumentException iae) {
            //good
        }
    }

    /**
     * <p>
     * Tests StereotypeItem#toString() for accuracy.
     * </p>
     *
     * <p>
     * It verifies StereotypeItem#toString() is correct.
     * </p>
     */
    public void testToString() {
        assertEquals("Failed to get the value correctly.", "type", item.toString());
    }

    /**
     * <p>
     * Tests StereotypeItem#getStereotype() for accuracy.
     * </p>
     *
     * <p>
     * It verifies StereotypeItem#getStereotype() is correct.
     * </p>
     */
    public void testGetStereotype() {
        assertSame("Failed to get the stereotype correctly.", this.stereotype, item.getStereotype());
    }

}