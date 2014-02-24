/*
 * Copyright (C) 2006 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.uml.model.datatypes.accuracytests;

import junit.framework.TestCase;

import com.topcoder.uml.model.datatypes.expressions.ExpressionImpl;
import com.topcoder.uml.model.datatypes.expressions.TypeExpression;
import com.topcoder.uml.model.datatypes.expressions.TypeExpressionImpl;

/**
 * Accuracy test fixture for <code>TypeExpressionImpl</code> class.
 *
 * @author Thinfox
 * @version 1.0
 */
public class TypeExpressionImplAccuracyTests extends TestCase {
    /**
     * The default <code>TypeExpressionImpl</code> instance on which to perform tests.
     */
    private TypeExpressionImpl expression = null;

    /**
     * Initializes the test instance.
     */
    public void setUp() {
        expression = new TypeExpressionImpl();
    }

    /**
     * Tests the default constructor.
     */
    public void testConstructor() {
        assertNotNull("The instance should not be null.", expression);
    }

    /**
     * Tests <code>TypeExpressionImpl</code> inherits from <code>TypeExpression</code>.
     */
    public void testInheritTypeExpression() {
        assertTrue("TypeExpressionImpl should inherit from TypeExpression.",
            expression instanceof TypeExpression);
    }

    /**
     * Tests <code>TypeExpressionImpl</code> inherits from <code>ExpressionImpl</code>.
     */
    public void testInheritExpressionImpl() {
        assertTrue("TypeExpressionImpl should inherit from ExpressionImpl.",
            expression instanceof ExpressionImpl);
    }
}
