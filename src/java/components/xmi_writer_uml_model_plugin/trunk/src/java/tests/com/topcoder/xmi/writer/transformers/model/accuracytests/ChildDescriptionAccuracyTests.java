/*
 * Copyright (C) 2006 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.xmi.writer.transformers.model.accuracytests;

import java.lang.reflect.Method;

import com.topcoder.xmi.writer.transformers.model.ChildDescription;

import junit.framework.TestCase;

/**
 * <p>
 * Accuracy test case for <c>ChildDescription</c>.
 * </p>
 * 
 * @author catcher
 * @version 1.0
 */
public class ChildDescriptionAccuracyTests extends TestCase {

    /**
     * Represent the name used for test.
     */
    private String testName = "testName";

    /**
     * Represent the name used for test.
     */
    private Method testMethod;

    /**
     * Represent the instance of <c>ChildDescription</c> used for test
     */
    private ChildDescription description;

    /**
     * <p>
     * Set up test environment.
     * </p>
     * 
     * @throws Exception
     *         if any error occurs when set up
     */
    protected void setUp() throws Exception {
        testMethod = String.class.getMethod("length", new Class[] {});
        description = new ChildDescription(testName, testMethod, false);
    }

    /**
     * <p>
     * Accuracy test for the constructor <code>AttributeDescription</code>. The instance of
     * <code>ReflectedXMIDescription</code> should be created successfully.
     * </p>
     */
    public void testConstructorAccuracy() {
        description = new ChildDescription(testName, testMethod, true);
        assertNotNull("instance of ReflectedXMIDescription should be created", description);
        assertEquals(testName, description.getName());
        assertEquals(testMethod, description.getMethod());
        assertTrue(description.isReference());
    }

    /**
     * Accuracy test of method <code>isReference()</code>.
     */
    public void testIsReference_Accuracy() {
        // the isReference flag is set to false in setUp() method
        assertFalse(description.isReference());

        // create a ChildDescription with isReference flag set to true
        description = new ChildDescription(testName, testMethod, true);
        assertTrue(description.isReference());
    }

}
