/*
 * Copyright (C) 2006 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.uml.model.actions;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;
/**
 * <p>
 * This class tests the <code>PrimitiveActionAbstractImpl</code> class.
 * It addresses the functionality provided by the<code>PrimitiveActionAbstractImpl</code> class.
 * It tests the methods: PrimitiveActionAbstractImpl().
 * </p>
 *
 * @author TCSDEVELOPER
 * @version 1.0
 */
public class PrimitiveActionAbstractImplTest extends TestCase {
    /**
     * <p>
     * The instance of <code>PrimitiveActionAbstractImpl</code> for test.
     * </p>
     */
    private PrimitiveActionAbstractImpl test = null;

    /**
     * <p>
     * Test suite of <code>PrimitiveActionAbstractImplTest</code>.
     * </p>
     *
     * @return Test suite of <code>PrimitiveActionAbstractImplTest</code>.
     */
    public static Test suite() {
        return new TestSuite(PrimitiveActionAbstractImplTest.class);
    }

    /**
     * <p>
     * Initialization for all tests here.
     * </p>
     *
     * <p>
     * <strong>Note</strong>: Because the <code>PrimitiveActionAbstractImpl</code> class is abstract, we use
     * <code>MockPrimitiveActionAbstractImpl</code> instead.
     * </p>
     */
    protected void setUp() {
        test = new MockPrimitiveActionAbstractImpl();
    }

    /**
     * <p>
     * Basic test of <code>PrimitiveActionAbstractImpl()</code> Constructor.
     * </p>
     *
     * <p>
     * <strong>Note</strong>: Because the <code>PrimitiveActionAbstractImpl</code> class is abstract, we use
     * <code>MockPrimitiveActionAbstractImpl</code> instead.
     * </p>
     *
     * @see #MockPrimitiveActionAbstractImpl()
     */
    public void testPrimitiveActionAbstractImplCtor_Basic() {
        for (int i = 0; i < 3; i++) {
            assertNotNull("Create failed.", test);
        }
    }

    /**
     * <p>
     * Basic test of <code>PrimitiveActionAbstractImpl()</code> Constructor.
     * It creates the instance of <code>MockPrimitiveActionAbstractImpl</code> for several times,
     * like a stress test.
     * </p>
     *
     * <p>
     * <strong>Note</strong>: Because the <code>PrimitiveActionAbstractImpl</code> class is abstract, we use
     * <code>MockPrimitiveActionAbstractImpl</code> instead.
     * </p>
     *
     * @see #MockPrimitiveActionAbstractImpl()
     */
    public void testPrimitiveActionAbstractImplCtor_Basic_Complex() {
        for (int i = 0; i < 3; i++) {
            assertNotNull("Create failed.", new MockActionAbstractImpl());
        }
    }

    /**
     * <p>
     * Accuracy test of <code>PrimitiveActionAbstractImpl</code> class, the class should be
     * a subclass of <code>ActionAbstractImpl</code>.
     * </p>
     *
     * <p>
     * <strong>Note</strong>: Because the <code>PrimitiveActionAbstractImpl</code> class is abstract, we use
     * <code>MockPrimitiveActionAbstractImpl</code> instead.
     * </p>
     */
    public void testClass_Inherit() {
        assertTrue("PrimitiveActionAbstractImpl class should be a subclass of ActionAbstractImpl",
            test instanceof ActionAbstractImpl);
    }

    /**
     * <p>
     * Accuracy test of <code>PrimitiveActionAbstractImpl</code> class, the class should
     * implement <code>PrimitiveAction</code> interface.
     * </p>
     *
     * <p>
     * <strong>Note</strong>: Because the <code>PrimitiveActionAbstractImpl</code> class is abstract, we use
     * <code>MockPrimitiveActionAbstractImpl</code> instead.
     * </p>
     */
    public void testClass_Interface() {
        assertTrue("PrimitiveActionAbstractImpl class should implement PrimitiveAction interface",
            test instanceof PrimitiveAction);
    }
}