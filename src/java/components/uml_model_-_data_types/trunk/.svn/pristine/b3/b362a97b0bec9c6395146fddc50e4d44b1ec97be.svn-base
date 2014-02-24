/*
 * Copyright (C) 2006 TopCoder Inc., All Rights Reserved.
 */

package com.topcoder.uml.model.datatypes.expressions;

import junit.framework.TestCase;

/**
 * <p>
 * Unit test for <code>BooleanExpressionImpl</code>.
 * </p>
 *
 * @author Achilles_2005
 * @version 1.0
 */
public class BooleanExpressionImplTest extends TestCase {

    /**
     * <p>
     * Tests accuracy of <code>BooleanExpressionImpl</code>.
     * </p>
     * <p>
     * <code>BooleanExpressionImpl</code> should inherit from <code>ExpressionImpl</code>.
     * </p>
     */
    public void testBooleanExpressionImplAccuracyInheritExpressionImpl() {
        assertTrue("BooleanExpressionImpl should inherit from ExpressionImpl",
            BooleanExpressionImpl.class.getSuperclass().equals(ExpressionImpl.class));
    }

    /**
     * <p>
     * Tests accuracy of <code>BooleanExpressionImpl</code>.
     * </p>
     * <p>
     * <code>BooleanExpressionImpl</code> should inherit from <code>BooleanExpression</code>.
     * </p>
     */
    public void testBooleanExpressionImplAccuracyInheritBooleanExpression() {
        assertTrue("BooleanExpressionImpl should inherit from BooleanExpression",
            BooleanExpressionImpl.class.getInterfaces()[0].equals(BooleanExpression.class));
    }

    /**
     * <p>
     * Tests accuracy of <code>BooleanExpressionImpl</code>.
     * </p>
     * <p>
     * Object created should not be null.
     * </p>
     */
    public void testBooleanExpressionImplAccuracy() {
        assertNotNull("Object created should not be null.", new BooleanExpressionImpl());
    }

}
