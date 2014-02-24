/*
 * Copyright (C) 2008 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.gui.configurationmanager.failuretests;

import java.util.HashSet;
import java.util.Set;

import com.topcoder.gui.configurationmanager.PropertyDefinition;

import junit.framework.TestSuite;
import junit.framework.Test;
import junit.framework.TestCase;

/**
 * <p>
 * Failure test cases for PropertyDefinition.
 * </p>
 *
 * @author victorsam
 * @version 1.0
 */
public class PropertyDefinitionFailureTests extends TestCase {

    /**
     * <p>
     * Return all tests.
     * </p>
     *
     * @return all tests
     */
    public static Test suite() {
        return new TestSuite(PropertyDefinitionFailureTests.class);
    }

    /**
     * <p>
     * Tests PropertyDefinition#setValueChoices(Set) for failure.
     * It tests the case that when valueChoices contains null element and expects IllegalArgumentException.
     * </p>
     */
    public void testSetValueChoices_NullInValueChoices() {
        PropertyDefinition instance = new PropertyDefinition();
        Set<String> valueChoices = new HashSet<String>();
        valueChoices.add(null);
        try {
            instance.setValueChoices(valueChoices);
            fail("IllegalArgumentException expected.");
        } catch (IllegalArgumentException iae) {
            //good
        }
    }

}