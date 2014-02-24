/*
 * Copyright (C) 2006 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.uml.model.datatypes.accuracytests;

import junit.framework.TestCase;

import com.topcoder.uml.model.datatypes.expressions.ExpressionImpl;
import com.topcoder.uml.model.datatypes.expressions.ProcedureExpression;
import com.topcoder.uml.model.datatypes.expressions.ProcedureExpressionImpl;

/**
 * Accuracy test fixture for <code>ProcedureExpressionImpl</code> class.
 *
 * @author Thinfox
 * @version 1.0
 */
public class ProcedureExpressionImplAccuracyTests extends TestCase {
    /**
     * The default <code>ProcedureExpressionImpl</code> instance on which to perform tests.
     */
    private ProcedureExpressionImpl expression = null;

    /**
     * Initializes the test instance.
     */
    public void setUp() {
        expression = new ProcedureExpressionImpl();
    }

    /**
     * Tests the default constructor.
     */
    public void testConstructor() {
        assertNotNull("The instance should not be null.", expression);
    }

    /**
     * Tests <code>ProcedureExpressionImpl</code> inherits from <code>ProcedureExpression</code>.
     */
    public void testInheritProcedureExpression() {
        assertTrue("ProcedureExpressionImpl should inherit from ProcedureExpression.",
            expression instanceof ProcedureExpression);
    }

    /**
     * Tests <code>ProcedureExpressionImpl</code> inherits from <code>ExpressionImpl</code>.
     */
    public void testInheritExpressionImpl() {
        assertTrue("ProcedureExpressionImpl should inherit from ExpressionImpl.",
            expression instanceof ExpressionImpl);
    }
}
