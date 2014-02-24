/*
 * Copyright (C) 2006 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.xmi.writer.transformers.model;

import java.lang.reflect.Method;

import com.topcoder.uml.xmi.writer.transformers.model.Implement1;
import com.topcoder.xmi.writer.transformers.model.AttributeDescription;
import com.topcoder.xmi.writer.transformers.model.NodeDescription;

import junit.framework.TestCase;
/**
 * <p>
 * Unit test cases for AttributeDescription.
 * </p>
 *
 * @author TCSDEVELOPER
 * @version 1.0
 */
public class AttributeDescriptionTests extends TestCase {
    /**
     * The AttributeDescription instance for testing.
     */
    private AttributeDescription nodeDescription = null;
    /**
     * The method instance for test.
     */
    private Method method = null;
    /**
     * The setUp of the unit test.
     *
     * @throws Exception to JUnit
     */
    protected void setUp() throws Exception {
        method = Implement1.class.getMethod("getNamespace", new Class[]{});
        nodeDescription = new AttributeDescription("name", method);
    }
    /**
     * The accuracy test of the constructor.
     *
     */
    public void test_constructor_accuracy() {
        assertNotNull("can not create the AttributeDescription instance.", nodeDescription);
    }
    /***
     * The failure test of the constructor,
     * fail for the name is null,
     * IllegalArgumentException should be thrown.
     *
     */
    public void test_constructor_failure1() {
        try {
            new AttributeDescription(null, method);
            fail("IllegalArgumentException should be thrown");
        } catch (IllegalArgumentException e) {
            //ok
        }
    }
    /***
     * The failure test of the constructor,
     * fail for the name is an empty String,
     * IllegalArgumentException should be thrown.
     *
     */
    public void test_constructor_failure2() {
        try {
            new AttributeDescription(" ", method);
            fail("IllegalArgumentException should be thrown");
        } catch (IllegalArgumentException e) {
            //ok
        }
    }
    /***
     * The failure test of the constructor,
     * fail for the method contains parameter,
     * IllegalArgumentException should be thrown.
     *
     * @throws Exception to JUnit
     */
    public void test_constructor_failure3() throws Exception {
        try {
            new AttributeDescription("name", Implement1.class.getMethod("addChild", new Class[]{String.class}));
            fail("IllegalArgumentException should be thrown");
        } catch (IllegalArgumentException e) {
            //ok
        }
    }
    /***
     * The failure test of the constructor,
     * fail for the method is null,
     * IllegalArgumentException should be thrown.
     *
     */
    public void test_constructor_failure4() {
        try {
            new AttributeDescription("name", null);
            fail("IllegalArgumentException should be thrown");
        } catch (IllegalArgumentException e) {
            //ok
        }
    }
    /**
     * Inheritance test.
     */
    public void test_Inheritance() {
        assertTrue("The AttributeDescription should be instance of NodeDescription.",
                nodeDescription instanceof NodeDescription);
    }
}
