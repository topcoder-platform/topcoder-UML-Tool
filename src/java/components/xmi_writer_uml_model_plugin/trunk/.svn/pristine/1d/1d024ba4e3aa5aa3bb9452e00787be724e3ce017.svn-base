/*
 * Copyright (C) 2006 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.xmi.writer.transformers.model.accuracytests;

import java.lang.reflect.Method;

import com.topcoder.xmi.writer.transformers.model.AttributeDescription;

import junit.framework.TestCase;

/**
 * <p>
 * Accuracy test case for <c>AttributeDescription</c>.
 * </p>
 * 
 * @author catcher
 * @version 1.0
 */
public class AttributeDescriptionAccuracyTests extends TestCase {

    /**
     * Represent the name used for test.
     */
    private String testName = "testName";

    /**
     * Represent the name used for test.
     */
    private Method testMethod;

    /**
     * Represent the instance of <c>AttributeDescription</c> used for test
     */
    private AttributeDescription description;

    /**
     * Set up test environment.
     * 
     * @throws Exception
     *         to JUnit
     */
    protected void setUp() throws Exception {
        testMethod = String.class.getMethod("length", new Class[] {});
    }

    /**
     * <p>
     * Accuracy test for the constructor <code>AttributeDescription</code>. The instance of
     * <code>ReflectedXMIDescription</code> should be created successfully.
     * </p>
     */
    public void testConstructorAccuracy() {
        description = new AttributeDescription(testName, testMethod);
        assertNotNull("instance of ReflectedXMIDescription should be created", description);
        assertEquals(testName, description.getName());
        assertEquals(testMethod, description.getMethod());
    }

}
