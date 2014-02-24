/*
 * Copyright (C) 2006 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.uml.model.datatypes.accuracytests;

import junit.framework.TestCase;

import com.topcoder.uml.model.datatypes.expressions.ExpressionImpl;
import com.topcoder.uml.model.datatypes.expressions.BooleanExpression;
import com.topcoder.uml.model.datatypes.expressions.BooleanExpressionImpl;

/**
 * Accuracy test fixture for <code>BooleanExpressionImpl</code> class.
 *
 * @author Thinfox
 * @version 1.0
 */
public class BooleanExpressionImplAccuracyTests extends TestCase {
    /**
     * The default <code>BooleanExpressionImpl</code> instance on which to perform tests.
     */
    private BooleanExpressionImpl expression = null;

    /**
     * Initializes the test instance.
     */
    public void setUp() {
        expression = new BooleanExpressionImpl();
    }

    /**
     * Tests the default constructor.
     */
    public void testConstructor() {
        assertNotNull("The instance should not be null.", expression);
    }

    /**
     * Tests <code>BooleanExpressionImpl</code> inherits from <code>BooleanExpression</code>.
     */
    public void testInheritBooleanExpression() {
        assertTrue("BooleanExpressionImpl should inherit from BooleanExpression.",
            expression instanceof BooleanExpression);
    }

    /**
     * Tests <code>BooleanExpressionImpl</code> inherits from <code>ExpressionImpl</code>.
     */
    public void testInheritExpressionImpl() {
        assertTrue("BooleanExpressionImpl should inherit from ExpressionImpl.",
            expression instanceof ExpressionImpl);
    }
}
