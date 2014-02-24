/*
 * Copyright (C) 2007 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.umltool.xmiconverters.poseidon5.activity.impl;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;


/**
 * <p>
 * Unit tests for <code>AbstractZUMLOpaqueExpression</code> class.
 * </p>
 *
 * @author zhengjuyu
 * @version 1.0
 */
public class AbstractZUMLOpaqueExpressionUnitTest extends TestCase {
    /**
     * <p>The AbstractZUMLOpaqueExpression instance for test.</p>
     */
    private AbstractZUMLOpaqueExpression expression;

    /**
     * <p>Set up the environment.</p>
     */
    protected void setUp() {
        expression = new MockZUMLOpaqueExpression();
    }

    /**
     * <p>Returns the test suite of this class.</p>
     *
     * @return the test suite of this class.
     */
    public static Test suite() {
        return new TestSuite(AbstractZUMLOpaqueExpressionUnitTest.class);
    }

    /**
     * <p>
     * Accuracy test for constructor <code>AbstractZUMLOpaqueExpression()</code>.
     * </p>
     *
     * <p>
     * Verify that the body and language are initialized as empty string.
     * </p>
     */
    public void testCtor() {
        assertNotNull("Unable to create MockZUMLOpaqueExpression instance.",
            expression);

        assertEquals("The body should be initialized as empty string.", "",
            expression.getBody());
        assertEquals("The language should be initialized as empty string.", "",
            expression.getLanguage());
    }

    /**
     * <p>
     * Accuracy test for <code>getBody()</code>.
     * </p>
     * <p>
     * Verify that the body is returned successfully.
     * </p>
     */
    public void testGetBody() {
        assertEquals("The body should be initialized as empty string.", "",
            expression.getBody());

        expression.setBody("body");
        assertEquals("The body should match.", "body", expression.getBody());
    }

    /**
     * <p>
     * Accuracy test for <code>setBody(String)</code>.
     * </p>
     * <p>
     * Verify that the body is set successfully.
     * </p>
     */
    public void testSetBody() {
        expression.setBody("body");
        assertEquals("The body should match.", "body", expression.getBody());
    }

    /**
     * <p>
     * Failure test for <code>setBody(String)</code>.
     * </p>
     * <p>
     * Failure cause: If the body to set is null, IllegalArgumentException is expected.
     * </p>
     */
    public void testSetBody_Failure() {
        try {
            expression.setBody(null);

            fail("IllegalArgumentException is expected.");
        } catch (IllegalArgumentException e) {
            //success
        }
    }

    /**
     * <p>
     * Accuracy test for <code>getLanguage()</code>.
     * </p>
     *
     * <p>
     * Verify that the language is returned successfully.
     * </p>
     */
    public void testGetLanguage() {
        assertEquals("The language should be initialized as empty string.", "",
            expression.getLanguage());

        expression.setLanguage("language");
        assertEquals("The language should match.", "language",
            expression.getLanguage());
    }

    /**
     * <p>
     * Accuracy test for <code>setLanguage(String)</code>.
     * </p>
     *
     * <p>
     * Verify that the language is set successfully.
     * </p>
     */
    public void testSetLanguage() {
        expression.setLanguage("language");
        assertEquals("The language should match.", "language",
            expression.getLanguage());
    }

    /**
     * <p>
     * Failure test for <code>setLanguage(String)</code>.
     * </p>
     *
     * <p>
     * Failure cause: If the language to set is null, IllegalArgumentException is expected.
     * </p>
     */
    public void testSetLanguage_Failure1() {
        try {
            expression.setLanguage(null);
            fail("IllegalArgumentException is expected.");
        } catch (IllegalArgumentException e) {
            //success
        }
    }

    /**
     * <p>
     * Failure test for <code>setLanguage(String)</code>.
     * </p>
     *
     * <p>
     * Failure cause: If the language to set is empty, IllegalArgumentException is expected.
     * </p>
     */
    public void testSetLanguage_Failure2() {
        try {
            expression.setLanguage("   ");
            fail("IllegalArgumentException is expected.");
        } catch (IllegalArgumentException e) {
            //success
        }
    }
}
