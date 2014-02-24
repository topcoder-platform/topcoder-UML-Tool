/*
 * Copyright (C) 2006 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.uml.model.actions.messagingactions;

import com.topcoder.uml.model.actions.PrimitiveActionAbstractImpl;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;
/**
 * <p>
 * This class tests the <code>ExplicitInvocationActionAbstractImpl</code> class.
 * It addresses the functionality provided by the<code>ExplicitInvocationActionAbstractImpl</code> class.
 * It tests the methods: ExplicitInvocationActionAbstractImpl().
 * </p>
 *
 * @author TCSDEVELOPER
 * @version 1.0
 */
public class ExplicitInvocationActionAbstractImplTest extends TestCase {
   /**
     * <p>
     * The instance of <code>ExplicitInvocationActionAbstractImpl</code> for test.
     * </p>
     */
    private ExplicitInvocationActionAbstractImpl test = null;

    /**
     * <p>
     * Test suite of <code>ExplicitInvocationActionAbstractImplTest</code>.
     * </p>
     *
     * @return Test suite of <code>ExplicitInvocationActionAbstractImplTest</code>.
     */
    public static Test suite() {
        return new TestSuite(ExplicitInvocationActionAbstractImplTest.class);
    }

    /**
     * <p>
     * Initialization for all tests here.
     * </p>
     *
     * <p>
     * <strong>Note</strong>: Because the <code>ExplicitInvocationActionAbstractImpl</code> class
     * is abstract, we use <code>MockExplicitInvocationActionAbstractImpl</code> instead.
     * </p>
     */
    protected void setUp() {
        test = new MockExplicitInvocationActionAbstractImpl();
    }
    /**
     * <p>
     * Basic test of <code>ExplicitInvocationActionAbstractImpl()</code> Constructor.
     * </p>
     *
     * <p>
     * <strong>Note</strong>: Because the <code>ExplicitInvocationActionAbstractImpl</code> class
     * is abstract, we use <code>MockExplicitInvocationActionAbstractImpl</code> instead.
     * </p>
     */
    public void testExplicitInvocationActionAbstractImplCtor_Basic() {
        for (int i = 0; i < 3; i++) {
            assertNotNull("Create failed.", test);
        }
    }

    /**
     * <p>
     * Basic test of <code>ExplicitInvocationActionAbstractImpl()</code> Constructor.
     * It creates the instance of <code>MockExplicitInvocationActionAbstractImpl</code> for several times,
     * like a stress test.
     * </p>
     *
     * <p>
     * <strong>Note</strong>: Because the <code>ExplicitInvocationActionAbstractImpl</code> class
     * is abstract, we use <code>MockExplicitInvocationActionAbstractImpl</code> instead.
     * </p>
     */
    public void testExplicitInvocationActionAbstractImplCtor_Basic_Complex() {
        for (int i = 0; i < 3; i++) {
            assertNotNull("Create failed.", new MockExplicitInvocationActionAbstractImpl());
        }
    }

    /**
     * <p>
     * Accuracy test of <code>ExplicitInvocationActionAbstractImpl</code> class, the class should be
     * a subclass of <code>PrimitiveActionAbstractImpl</code>.
     * </p>
     *
     * <p>
     * <strong>Note</strong>: Because the <code>ExplicitInvocationActionAbstractImpl</code> class
     * is abstract, we use <code>MockExplicitInvocationActionAbstractImpl</code> instead.
     * </p>
     */
    public void testClass_Inherit() {
        assertTrue("ExplicitInvocationActionAbstractImpl class should be a subclass of PrimitiveActionAbstractImpl",
            test instanceof PrimitiveActionAbstractImpl);
    }

    /**
     * <p>
     * Accuracy test of <code>ExplicitInvocationActionAbstractImpl</code> class, the class should
     * implement <code>ExplicitInvocationAction</code> interface.
     * </p>
     *
     * <p>
     * <strong>Note</strong>: Because the <code>ExplicitInvocationActionAbstractImpl</code> class
     * is abstract, we use <code>MockExplicitInvocationActionAbstractImpl</code> instead.
     * </p>
     */
    public void testClass_Interface() {
        assertTrue("ExplicitInvocationActionAbstractImpl class should implement ExplicitInvocationAction interface",
            test instanceof ExplicitInvocationAction);
    }
}