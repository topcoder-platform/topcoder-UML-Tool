/*
 * Copyright (C) 2007 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.umltool.xmiconverters.poseidon5.accuracytests;

import com.topcoder.umltool.xmiconverters.poseidon5.activity.impl.AbstractZUMLOpaqueExpression;
import com.topcoder.umltool.xmiconverters.poseidon5.activity.impl.ZUMLOpaqueExpressionImpl;

import junit.framework.TestCase;


/**
 * The accuracy tests for the class AbstractZUMLOpaqueExpression.
 * @author KLW
 * @version 1.0
 */
public class AbstractZUMLOpaqueExpressionAccuracyTests extends TestCase {
    /**
     * the instance AbstractZUMLOpaqueExpression for testing.
     */
    private AbstractZUMLOpaqueExpression instance;

    /**
     * set up the test environment.
     */
    protected void setUp() {
        instance = new ZUMLOpaqueExpressionImpl();
    }

    /**
     * tear down the test environment.
     */
    protected void tearDown() {
        instance = null;
    }

    /**
     * the accuracy test for the constructor.
     *
     */
    public void testCtor() {
        assertNotNull("The instance should not be null.", instance);
        assertTrue(instance.getBody().equals(""));
        assertTrue(instance.getLanguage().equals(""));
    }

    /**
     * the accuracy test for the getter and setter for the body.
     *
     */
    public void testBody() {
        assertTrue(instance.getBody().equals(""));
        instance.setBody("body");
        assertEquals("body", instance.getBody());
    }

    /**
     * the accuracy test for the getter and setter for the language.
     *
     */
    public void testLanguage() {
        assertTrue(instance.getLanguage().equals(""));
        instance.setLanguage("language");
        assertEquals("language", instance.getLanguage());
    }
}
