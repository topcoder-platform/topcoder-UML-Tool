/*
 * Copyright (C) 2006 TopCoder Inc., All Rights Reserved.
 */

package com.topcoder.uml.model.datatypes.expressions;

import junit.framework.TestCase;

import com.topcoder.uml.model.commonbehavior.procedure.Procedure;
import com.topcoder.uml.model.commonbehavior.procedure.ProcedureImpl;

/**
 * <p>
 * Unit test for <code>ExpressionImpl</code>.
 * </p>
 *
 * @author Achilles_2005
 * @version 1.0
 */
public class ExpressionImplTest extends TestCase {

    /**
     * <p>
     * Private instance used for test.
     * </p>
     */
    private ExpressionImpl expressionImpl = null;

    /**
     * <p>
     * Sets up test environment, creates object used for test.
     * </p>
     *
     * @throws Exception
     *             exception to JUnit
     */
    @Override
    protected void setUp() throws Exception {
        expressionImpl = new ExpressionImpl();
        super.setUp();
    }

    /**
     * <p>
     * Tears down test environment, disposes object used for test.
     * </p>
     *
     * @throws Exception
     *             exception to JUnit
     */
    @Override
    protected void tearDown() throws Exception {
        expressionImpl = null;
        super.tearDown();
    }

    /**
     * <p>
     * Tests accuracy of <code>ExpressionImpl</code>.
     * </p>
     * <p>
     * <code>ExpressionImpl</code> should inherit from <code>Expression</code>.
     * </p>
     */
    public void testExpressionImplAccuracyInheritExpression() {
        assertTrue("ExpressionImpl should inherit from Expression", ExpressionImpl.class
            .getInterfaces()[0].equals(Expression.class));
    }

    /**
     * <p>
     * Tests accuracy of <code>ExpressionImpl</code>.
     * </p>
     * <p>
     * Object created should not be null.
     * </p>
     */
    public void testExpressionImplAccuracy() {
        assertNotNull("Object created should not be null.", new ExpressionImpl());
    }

    /**
     * <p>
     * Tests accuracy of <code>setLanguage()</code>.
     * </p>
     * <p>
     * Tests situation when value is null.
     * </p>
     * <p>
     * Null value is acceptable. Value should be set correctly.
     * </p>
     */
    public void testSetLanguageAccuracyNull() {
        try {
            String language = null;
            expressionImpl.setLanguage(language);
            assertEquals("Value should be set correctly.", language, expressionImpl.getLanguage());
        } catch (IllegalArgumentException e) {
            fail("IllegalArgumentException should not be thrown since value is valid.");
        }
    }

    /**
     * <p>
     * Tests accuracy of <code>setLanguage()</code>.
     * </p>
     * <p>
     * Tests situation when value is empty.
     * </p>
     * <p>
     * Empty value is acceptable. Value should be set correctly.
     * </p>
     */
    public void testSetLanguageAccuracyEmpty() {
        try {
            String language = "   ";
            expressionImpl.setLanguage(language);
            assertEquals("Value should be set correctly.", language, expressionImpl.getLanguage());
        } catch (IllegalArgumentException e) {
            fail("IllegalArgumentException should not be thrown since value is valid.");
        }
    }

    /**
     * <p>
     * Tests accuracy of <code>setLanguage()</code>.
     * </p>
     * <p>
     * Tests situation when value is valid.
     * </p>
     * <p>
     * Value should be set correctly.
     * </p>
     */
    public void testSetLanguageAccuracyValid() {
        try {
            String language = " java ";
            expressionImpl.setLanguage(language);
            assertEquals("Value should be set correctly.", language, expressionImpl.getLanguage());
        } catch (IllegalArgumentException e) {
            fail("IllegalArgumentException should not be thrown since value is valid.");
        }
    }

    /**
     * <p>
     * Tests accuracy of <code>getLanguage()</code>.
     * </p>
     * <p>
     * Tests situation when value is null.
     * </p>
     * <p>
     * Null value is acceptable. Value should be gotten correctly.
     * </p>
     */
    public void testGetLanguageAccuracyNull() {
        try {
            String language = null;
            expressionImpl.setLanguage(language);
            assertEquals("Value should be gotten correctly.", language, expressionImpl
                .getLanguage());
        } catch (IllegalArgumentException e) {
            fail("IllegalArgumentException should not be thrown since value is valid.");
        }
    }

    /**
     * <p>
     * Tests accuracy of <code>getLanguage()</code>.
     * </p>
     * <p>
     * Tests situation when value is empty.
     * </p>
     * <p>
     * Empty value is acceptable. Value should be gotten correctly.
     * </p>
     */
    public void testGetLanguageAccuracyEmpty() {
        try {
            String language = "   ";
            expressionImpl.setLanguage(language);
            assertEquals("Value should be set correctly.", language, expressionImpl.getLanguage());
        } catch (IllegalArgumentException e) {
            fail("IllegalArgumentException should not be thrown since value is valid.");
        }
    }

    /**
     * <p>
     * Tests accuracy of <code>getLanguage()</code>.
     * </p>
     * <p>
     * Tests situation when value is valid.
     * </p>
     * <p>
     * Value should be gotten correctly.
     * </p>
     */
    public void testGetLanguageAccuracyValid() {
        try {
            String language = " C++ ";
            expressionImpl.setLanguage(language);
            assertEquals("Value should be set correctly.", language, expressionImpl.getLanguage());
        } catch (IllegalArgumentException e) {
            fail("IllegalArgumentException should not be thrown since value is valid.");
        }
    }

    /**
     * <p>
     * Tests accuracy of <code>setBody()</code>.
     * </p>
     * <p>
     * Tests situation when value is null.
     * </p>
     * <p>
     * Null value is acceptable. Value should be set correctly.
     * </p>
     */
    public void testSetBodyAccuracyNull() {
        try {
            String body = null;
            expressionImpl.setBody(body);
            assertEquals("Value should be set correctly.", body, expressionImpl.getBody());
        } catch (IllegalArgumentException e) {
            fail("IllegalArgumentException should not be thrown since value is valid.");
        }
    }

    /**
     * <p>
     * Tests accuracy of <code>setBody()</code>.
     * </p>
     * <p>
     * Tests situation when value is empty.
     * </p>
     * <p>
     * Empty value is acceptable. Value should be set correctly.
     * </p>
     */
    public void testSetBodyAccuracyEmpty() {
        try {
            String body = "   ";
            expressionImpl.setBody(body);
            assertEquals("Value should be set correctly.", body, expressionImpl.getBody());
        } catch (IllegalArgumentException e) {
            fail("IllegalArgumentException should not be thrown since value is valid.");
        }
    }

    /**
     * <p>
     * Tests accuracy of <code>setBody()</code>.
     * </p>
     * <p>
     * Tests situation when value is valid.
     * </p>
     * <p>
     * Value should be set correctly.
     * </p>
     */
    public void testSetBodyAccuracyValid() {
        try {
            String body = " Good ";
            expressionImpl.setBody(body);
            assertEquals("Value should be set correctly.", body, expressionImpl.getBody());
        } catch (IllegalArgumentException e) {
            fail("IllegalArgumentException should not be thrown since value is valid.");
        }
    }

    /**
     * <p>
     * Tests accuracy of <code>getBody()</code>.
     * </p>
     * <p>
     * Tests situation when value is null.
     * </p>
     * <p>
     * Null value is acceptable. Value should be gotten correctly.
     * </p>
     */
    public void testGetBodyAccuracyNull() {
        try {
            String body = null;
            expressionImpl.setBody(body);
            assertEquals("Value should be gotten correctly.", body, expressionImpl.getBody());
        } catch (IllegalArgumentException e) {
            fail("IllegalArgumentException should not be thrown since value is valid.");
        }
    }

    /**
     * <p>
     * Tests accuracy of <code>getBody()</code>.
     * </p>
     * <p>
     * Tests situation when value is empty.
     * </p>
     * <p>
     * Empty value is acceptable. Value should be gotten correctly.
     * </p>
     */
    public void testGetBodyAccuracyEmpty() {
        try {
            String body = "   ";
            expressionImpl.setBody(body);
            assertEquals("Value should be set correctly.", body, expressionImpl.getBody());
        } catch (IllegalArgumentException e) {
            fail("IllegalArgumentException should not be thrown since value is valid.");
        }
    }

    /**
     * <p>
     * Tests accuracy of <code>getBody()</code>.
     * </p>
     * <p>
     * Tests situation when value is valid.
     * </p>
     * <p>
     * Value should be gotten correctly.
     * </p>
     */
    public void testGetBodyAccuracyValid() {
        try {
            String body = " Hello ";
            expressionImpl.setBody(body);
            assertEquals("Value should be set correctly.", body, expressionImpl.getBody());
        } catch (IllegalArgumentException e) {
            fail("IllegalArgumentException should not be thrown since value is valid.");
        }
    }

    /**
     * <p>
     * Tests accuracy of <code>getProcedure()</code>.
     * </p>
     * <p>
     * Tests situation when value is null.
     * </p>
     * <p>
     * Null value is acceptable. Value should be gotten correctly.
     * </p>
     */
    public void testGetProcedureAccuracyNull() {
        try {
            Procedure procedure = null;
            expressionImpl.setProcedure(procedure);
            assertEquals("Value should be gotten correctly.", procedure, expressionImpl
                .getProcedure());
        } catch (IllegalArgumentException e) {
            fail("IllegalArgumentException should not be thrown since value is valid.");
        }
    }

    /**
     * <p>
     * Tests accuracy of <code>getProcedure()</code>.
     * </p>
     * <p>
     * Tests situation when value is null.
     * </p>
     * <p>
     * Null value is acceptable. Value should be gotten correctly.
     * </p>
     */
    public void testGetProcedureAccuracy() {
        try {
            Procedure procedure = new ProcedureImpl();
            expressionImpl.setProcedure(procedure);
            assertEquals("Value should be gotten correctly.", procedure, expressionImpl
                .getProcedure());
        } catch (IllegalArgumentException e) {
            fail("IllegalArgumentException should not be thrown since value is valid.");
        }
    }

    /**
     * <p>
     * Tests accuracy of <code>setProcedure()</code>.
     * </p>
     * <p>
     * Tests situation when value is null.
     * </p>
     * <p>
     * Null value is acceptable. Value should be gotten correctly.
     * </p>
     */
    public void testSetProcedureAccuracyNull() {
        try {
            Procedure procedure = null;
            expressionImpl.setProcedure(procedure);
            assertEquals("Value should be gotten correctly.", procedure, expressionImpl
                .getProcedure());
        } catch (IllegalArgumentException e) {
            fail("IllegalArgumentException should not be thrown since value is valid.");
        }
    }

    /**
     * <p>
     * Tests accuracy of <code>setProcedure()</code>.
     * </p>
     * <p>
     * Tests situation when value is null.
     * </p>
     * <p>
     * Null value is acceptable. Value should be gotten correctly.
     * </p>
     */
    public void testSetProcedureAccuracy() {
        try {
            Procedure procedure = new ProcedureImpl();
            expressionImpl.setProcedure(procedure);
            assertEquals("Value should be gotten correctly.", procedure, expressionImpl
                .getProcedure());
        } catch (IllegalArgumentException e) {
            fail("IllegalArgumentException should not be thrown since value is valid.");
        }
    }

}
