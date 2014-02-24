/*
 * Copyright (C) 2006 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.xmi.writer.transformers.model;

import java.lang.reflect.Method;

import com.topcoder.uml.xmi.writer.transformers.model.Implement1;
import com.topcoder.xmi.writer.transformers.model.ChildDescription;
import com.topcoder.xmi.writer.transformers.model.NodeDescription;

import junit.framework.TestCase;
/**
 * <p>
 * Unit test cases for ChildDescription.
 * </p>
 *
 * @author TCSDEVELOPER
 * @version 1.0
 */
public class ChildDescriptionTests extends TestCase {
    /**
     * The ChildDescription instance for testing.
     */
    private ChildDescription nodeDescription = null;
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
        nodeDescription = new ChildDescription("name", method, false);
    }
    /**
     * The accuracy test of the constructor.
     *
     */
    public void test_constructor_accuracy() {
        assertNotNull("can not create the ChildDescription instance.", nodeDescription);
    }
    /***
     * The failure test of the constructor,
     * fail for the name is null,
     * IllegalArgumentException should be thrown.
     *
     */
    public void test_constructor_failure1() {
        try {
            new ChildDescription(null, method, false);
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
            new ChildDescription(" ", method, false);
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
    public void test_constructor_failure3() {
        try {
            new ChildDescription("name", null, false);
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
    public void test_constructor_failure4() throws Exception {
        try {
            new ChildDescription("name", Implement1.class.getMethod("addChild", new Class[]{String.class}), false);
            fail("IllegalArgumentException should be thrown");
        } catch (IllegalArgumentException e) {
            //ok
        }
    }
    /**
     * The accuracy test of the method <code>isReference</code>.
     *
     */
    public void test_isReference_accuracy() {
        assertFalse("The reference property is not properly set or get.", nodeDescription.isReference());
    }
    /**
     * Inheritance test.
     */
    public void test_Inheritance() {
        assertTrue("The ChildDescription should be instance of NodeDescription.",
                nodeDescription instanceof NodeDescription);
    }
}
