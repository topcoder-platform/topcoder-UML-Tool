/*
 * Copyright (C) 2006 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.uml.model.datatypes.accuracytests;

import junit.framework.TestCase;

import com.topcoder.uml.model.commonbehavior.procedure.Procedure;
import com.topcoder.uml.model.commonbehavior.procedure.ProcedureImpl;
import com.topcoder.uml.model.datatypes.expressions.Expression;
import com.topcoder.uml.model.datatypes.expressions.ExpressionImpl;

/**
 * Accuracy test fixture for <code>ExpressionImpl</code> class.
 *
 * @author Thinfox
 * @version 1.0
 */
public class ExpressionImplAccuracyTests extends TestCase {
    /**
     * The default <code>ExpressionImpl</code> instance on which to perform tests.
     */
    private ExpressionImpl expression = null;

    /**
     * Initializes the test instance.
     */
    public void setUp() {
        expression = new ExpressionImpl();
    }

    /**
     * Tests the default constructor.
     */
    public void testConstructor() {
        assertNotNull("The instance should not be null.", expression);
    }

    /**
     * Tests <code>ExpressionImpl</code> inherits from <code>Expression</code>.
     */
    public void testInheritExpression() {
        assertTrue("ExpressionImpl should inherit from Expression.",
            expression instanceof Expression);
    }

    /**
     * Tests <code>getLanguage</code> method.
     */
    public void testGetLanguage() {
        String language = "java";
        expression.setLanguage(language);
        assertEquals("Value should be retrieved correctly.", language, expression.getLanguage());
    }

    /**
     * Tests <code>setLanguage</code> method.
     */
    public void testSetLanguage() {
        String language = "java";
        expression.setLanguage(language);
        assertEquals("Value should be propagated correctly.", language, expression.getLanguage());
    }

    /**
     * Tests <code>getBody</code> method.
     */
    public void testGetBody() {
        String body = "test_body";
        expression.setBody(body);
        assertEquals("Value should be retrieved correctly.", body, expression.getBody());
    }

    /**
     * Tests <code>setBody</code> method.
     */
    public void testSetBody() {
        String body = "test_body";
        expression.setBody(body);
        assertEquals("Value should be propagated correctly.", body, expression.getBody());
    }

    /**
     * Tests <code>getProcedure</code> method.
     */
    public void testGetProcedure() {
        Procedure obj = new ProcedureImpl();
        expression.setProcedure(obj);
        assertEquals("Value should be retrieved correctly.", obj, expression.getProcedure());
    }

    /**
     * Tests <code>setProcedure</code> method.
     */
    public void testSetProcedure() {
        Procedure obj = new ProcedureImpl();
        expression.setProcedure(obj);
        assertEquals("Value should be retrieved correctly.", obj, expression.getProcedure());
    }
}
