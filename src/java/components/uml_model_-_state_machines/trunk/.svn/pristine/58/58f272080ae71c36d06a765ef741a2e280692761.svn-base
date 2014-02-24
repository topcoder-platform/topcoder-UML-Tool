/*
 * Copyright (C) 2006 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.uml.model.statemachines;

import com.topcoder.uml.model.datatypes.expressions.BooleanExpression;
import com.topcoder.uml.model.datatypes.expressions.BooleanExpressionImpl;

import junit.framework.TestCase;

/**
 * <p>
 * Unit test case for <c>GuardImpl</c>.
 * </p>
 *
 * @author catcher
 * @version 1.0
 */
public class GuardImplUnitTests extends TestCase {

    /**
     * Represent the instance of <c>GuardImpl</c> used for test.
     */
    private GuardImpl guardImpl;

    /**
     * Represent the instance of <c>BooleanExpression</c> used for test.
     */
    private BooleanExpression testExpression = new BooleanExpressionImpl();

    /**
     * Represent the instance of <c>Transition</c> used for test.
     */
    private Transition testTransition = new TransitionImpl();


    /**
     * <p>
     * Set up test environment.
     * </p>
     *
     * @throws Exception
     *             if any error occurs when set up
     */
    protected void setUp() throws Exception {
        guardImpl = new GuardImpl();
    }

    /**
     * <p>
     * Accuracy test for the constructor <code>GuardImpl()</code>. The instance of <code>GuardImpl</code> should be
     * created successfully.
     * </p>
     */
    public void testConstructorAccuracy() {
        assertNotNull("instance of GuardImpl should be created", new GuardImpl());
    }

    /**
     * <p>
     * Accuracy test for the constructor <code>GuardImpl(BooleanExpression expression, Transition transition)</code>
     * with null expression The instance of <code>GuardImpl</code> should be created successfully.
     * </p>
     */
    public void testConstructorAccuracy2() {
        assertNotNull("instance of GuardImpl should be created", new GuardImpl(null, testTransition));
    }

    /**
     * <p>
     * Accuracy test for the constructor <code>GuardImpl(BooleanExpression expression, Transition transition)</code>
     * with null transition The instance of <code>GuardImpl</code> should be created successfully.
     * </p>
     */
    public void testConstructorAccuracy3() {
        assertNotNull("instance of GuardImpl should be created", new GuardImpl(testExpression, null));
    }

    /**
     * <p>
     * Accuracy test for the constructor <code>GuardImpl(BooleanExpression expression, Transition transition)</code>
     * with null transition The instance of <code>GuardImpl</code> should be created successfully.
     * </p>
     */
    public void testConstructorAccuracy4() {
        assertNotNull("instance of GuardImpl should be created", new GuardImpl(testExpression, testTransition));
    }

    /**
     * <p>
     * Accuracy test for the method <code>setExpression(BooleanExpression expression)</code> with null, the
     * <c>booleanExpression</c> field should be set correctly.
     * </p>
     */
    public void testSetExpressionAccuracyWithNull() {
        try {
            guardImpl.setExpression(null);
            assertNull("The booleanExpression field should be set correctly", guardImpl.getExpression());
        } catch (Exception e) {
            fail(e.getMessage());
        }
    }

    /**
     * <p>
     * Accuracy test for the method <code>setExpression(BooleanExpression expression)</code>, the
     * <c>booleanExpression</c> field should be set correctly.
     * </p>
     */
    public void testSetExpressionAccuracy() {
        try {
            guardImpl.setExpression(testExpression);
            assertEquals("The booleanExpression field should be set correctly", testExpression, guardImpl
                    .getExpression());
        } catch (Exception e) {
            fail(e.getMessage());
        }
    }

    /**
     * <p>
     * Accuracy test for the method <code>getExpression</code>, the <c>booleanExpression</c> field should be
     * returned correctly.
     * </p>
     */
    public void testGetExpressionAccuracy() {
        try {
            guardImpl.setExpression(testExpression);
            assertEquals("The booleanExpression field should be returned correctly", testExpression, guardImpl
                    .getExpression());
        } catch (Exception e) {
            fail(e.getMessage());
        }
    }

    /**
     * <p>
     * Accuracy test for the method <code>setTransition</code> with null, the
     * <c>transition</c> field should be set correctly.
     * </p>
     */
    public void testSetTransitionAccuracyWithNull() {
        try {
            guardImpl.setTransition(null);
            assertNull("The transition field should be set correctly", guardImpl.getTransition());
        } catch (Exception e) {
            fail(e.getMessage());
        }
    }

    /**
     * <p>
     * Accuracy test for the method <code>setTransition</code>, the
     * <c>transition</c> field should be set correctly.
     * </p>
     */
    public void testSetTransitionAccuracy() {
        try {
            guardImpl.setTransition(testTransition);
            assertEquals("The transition field should be set correctly", testTransition, guardImpl
                    .getTransition());
        } catch (Exception e) {
            fail(e.getMessage());
        }
    }

    /**
     * <p>
     * Accuracy test for the method <code>getTransition</code>, the <c>transition</c> field should be
     * returned correctly.
     * </p>
     */
    public void testGetTransitionAccuracy() {
        try {
            guardImpl.setTransition(testTransition);
            assertEquals("The transition field should be returned correctly", testTransition, guardImpl
                    .getTransition());
        } catch (Exception e) {
            fail(e.getMessage());
        }
    }

}

