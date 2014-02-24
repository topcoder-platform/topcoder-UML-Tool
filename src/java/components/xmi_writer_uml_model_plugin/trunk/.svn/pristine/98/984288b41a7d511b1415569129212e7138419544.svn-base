/*
 * Copyright (C) 2006 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.xmi.writer.transformers.model;

import java.lang.reflect.Method;

import com.topcoder.uml.xmi.writer.transformers.model.Implement1;
import com.topcoder.xmi.writer.transformers.model.NodeDescription;
import com.topcoder.xmi.writer.transformers.model.NodeValueRetrievalException;

import junit.framework.TestCase;
/**
 * <p>
 * Unit test of the class NodeDescription.
 * </p>
 *
 * @author TCSDEVELOPER
 * @version 1.0
 */
public class NodeDescriptionTests extends TestCase {
    /**
     * The NodeDescription instance for testing.
     */
    private NodeDescription nodeDescription = null;
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
        nodeDescription = new MockNodeDescription("name", method);
    }
    /**
     * The accuracy test of the constructor.
     *
     */
    public void test_constructor_accuracy() {
        assertNotNull("can not create the NodeDescription instance.", nodeDescription);
    }
    /***
     * The failure test of the constructor,
     * fail for the name is null,
     * IllegalArgumentException should be thrown.
     *
     */
    public void test_constructor_failure1() {
        try {
            new MockNodeDescription(null, method);
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
            new MockNodeDescription(" ", method);
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
            new MockNodeDescription("name", null);
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
            new MockNodeDescription("name", Implement1.class.getMethod("addChild", new Class[]{String.class}));
            fail("IllegalArgumentException should be thrown");
        } catch (IllegalArgumentException e) {
            //ok
        }
    }
    /**
     * The accuracy test of the method <code>getName</code>,
     * retrieved value should be same as set in constructor.
     *
     */
    public void test_getName_accuracy() {
        assertEquals("The name is not set or get properly.", "name", nodeDescription.getName());
    }
    /**
     * The accuracy test of the method <code>getMethod</code>,
     * retrieved method should be same as set in constructor.
     *
     */
    public void test_getMethod_accuracy() {
        assertTrue("The method is not set or get properly.", method == nodeDescription.getMethod());
    }
    /**
     * The failure test of the method <code>getValue</code>,
     * the element Object is not the expected type,
     * NodeValueRetrievalException should be thrown.
     *
     */
    public void test_getValue_failure1() {
        try {
            nodeDescription.getValue(new Object());
            fail("NodeValueRetrievalException should be thrown.");
        } catch (NodeValueRetrievalException e) {
            //ok
        }
    }
    /**
     * The failure test of the method <code>getValue</code>,
     * the element Object is not the expected type,
     * IllegalArgumentException should be thrown.
     *
     * @throws Exception to JUnit
     */
    public void test_getValue_failure2() throws Exception {
        try {
            nodeDescription.getValue(null);
            fail("IllegalArgumentException should be thrown.");
        } catch (IllegalArgumentException e) {
            //ok
        }
    }
    /**
     * The accuracy test of the method <code>getValue</code>.
     *
     * @throws Exception to JUnit
     */
    public void test_getValue_accuracy() throws Exception {
        assertEquals("The value should be retrieved successfully.",
                "namespace", nodeDescription.getValue(new Implement1()));
    }
}
