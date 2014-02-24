/*
 * Copyright (C) 2006 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.uml.model.statemachines.accuracytests;

import com.topcoder.uml.model.datatypes.expressions.BooleanExpression;
import com.topcoder.uml.model.datatypes.expressions.BooleanExpressionImpl;
import com.topcoder.uml.model.statemachines.Guard;
import com.topcoder.uml.model.statemachines.GuardImpl;
import com.topcoder.uml.model.statemachines.Transition;
import com.topcoder.uml.model.statemachines.TransitionImpl;

import junit.framework.TestCase;
/**
 * The accuracy test of the class <code>GuardImpl</code>.
 *
 * @author hfx
 * @version 1.0
 */
public class GuardImplAccuracyTests extends TestCase {
    /**
     * The GuardImpl instance.
     */
    private GuardImpl guardImpl = null;
    /**
     * The setup, create the instance for testing.
     */
    protected void setUp() {
        guardImpl = new GuardImpl();
    }
    /**
     * The accuracy test of the constructor.
     *
     */
    public void test_ctor_accuracy1() {
        assertNotNull("can not create the GuardImpl.", guardImpl);
    }
    /**
     * The accuracy test of the constructor.
     *
     */
    public void test_ctor_accuracy2() {
        BooleanExpression booleanExpression = new BooleanExpressionImpl();
        Transition transition = new TransitionImpl();
        assertNotNull("can not create the GuardImpl.", new GuardImpl(booleanExpression, transition));
    }
    /**
     * Tests inheritance.
     *
     */
    public void testInherit() {
        assertTrue("GuardImpl should inherit from Guard.", guardImpl instanceof Guard);
    }
}
