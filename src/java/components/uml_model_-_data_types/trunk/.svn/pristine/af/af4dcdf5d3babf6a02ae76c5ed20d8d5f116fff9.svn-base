/*
 * Copyright (C) 2006 TopCoder Inc., All Rights Reserved.
 */

package com.topcoder.uml.model.datatypes.expressions;

import junit.framework.TestCase;

/**
 * <p>
 * Unit test for <code>TypeExpressionImpl</code>.
 * </p>
 *
 * @author Achilles_2005
 * @version 1.0
 */
public class TypeExpressionImplTest extends TestCase {

    /**
     * <p>
     * Tests accuracy of <code>TypeExpressionImpl</code>.
     * </p>
     * <p>
     * <code>TypeExpressionImpl</code> should inherit from <code>ExpressionImpl</code>.
     * </p>
     */
    public void testTypeExpressionImplAccuracyInheritExpressionImpl() {
        assertTrue("TypeExpressionImpl should inherit from ExpressionImpl",
            TypeExpressionImpl.class.getSuperclass().equals(ExpressionImpl.class));
    }

    /**
     * <p>
     * Tests accuracy of <code>TypeExpressionImpl</code>.
     * </p>
     * <p>
     * <code>TypeExpressionImpl</code> should inherit from <code>TypeExpression</code>.
     * </p>
     */
    public void testTypeExpressionImplAccuracyInheritTypeExpression() {
        assertTrue("TypeExpressionImpl should inherit from TypeExpression",
            TypeExpressionImpl.class.getInterfaces()[0].equals(TypeExpression.class));
    }

    /**
     * <p>
     * Tests accuracy of <code>TypeExpressionImpl</code>.
     * </p>
     * <p>
     * Object created should not be null.
     * </p>
     */
    public void testTypeExpressionImplAccuracy() {
        assertNotNull("Object created should not be null.", new TypeExpressionImpl());
    }

}
