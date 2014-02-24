/*
 * Copyright (C) 2006 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.uml.model.datatypes.accuracytests;

import junit.framework.TestCase;

import com.topcoder.uml.model.datatypes.expressions.ExpressionImpl;
import com.topcoder.uml.model.datatypes.expressions.MappingExpression;
import com.topcoder.uml.model.datatypes.expressions.MappingExpressionImpl;

/**
 * Accuracy test fixture for <code>MappingExpressionImpl</code> class.
 *
 * @author Thinfox
 * @version 1.0
 */
public class MappingExpressionImplAccuracyTests extends TestCase {
    /**
     * The default <code>MappingExpressionImpl</code> instance on which to perform tests.
     */
    private MappingExpressionImpl expression = null;

    /**
     * Initializes the test instance.
     */
    public void setUp() {
        expression = new MappingExpressionImpl();
    }

    /**
     * Tests the default constructor.
     */
    public void testConstructor() {
        assertNotNull("The instance should not be null.", expression);
    }

    /**
     * Tests <code>MappingExpressionImpl</code> inherits from <code>MappingExpression</code>.
     */
    public void testInheritMappingExpression() {
        assertTrue("MappingExpressionImpl should inherit from MappingExpression.",
            expression instanceof MappingExpression);
    }

    /**
     * Tests <code>MappingExpressionImpl</code> inherits from <code>ExpressionImpl</code>.
     */
    public void testInheritExpressionImpl() {
        assertTrue("MappingExpressionImpl should inherit from ExpressionImpl.",
            expression instanceof ExpressionImpl);
    }
}
