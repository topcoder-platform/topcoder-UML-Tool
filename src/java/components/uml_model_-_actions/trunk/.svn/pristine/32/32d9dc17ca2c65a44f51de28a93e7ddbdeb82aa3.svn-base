/*
 * Copyright (C) 2006 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.uml.model.actions.objectactions;

import com.topcoder.uml.model.actions.PrimitiveActionAbstractImpl;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;
/**
 * <p>
 * This class tests the <code>DestroyObjectActionImpl</code> class.
 * It addresses the functionality provided by the<code>DestroyObjectActionImpl</code> class.
 * It tests the methods: DestroyObjectActionImpl().
 * </p>
 *
 * @author TCSDEVELOPER
 * @version 1.0
 */
public class DestroyObjectActionImplTest extends TestCase {
   /**
     * <p>
     * The instance of <code>DestroyObjectActionImpl</code> for test.
     * </p>
     */
    private DestroyObjectActionImpl test = null;

    /**
     * <p>
     * Test suite of <code>DestroyObjectActionImplTest</code>.
     * </p>
     *
     * @return Test suite of <code>DestroyObjectActionImplTest</code>.
     */
    public static Test suite() {
        return new TestSuite(DestroyObjectActionImplTest.class);
    }

    /**
     * <p>
     * Initialization for all tests here.
     * </p>
     */
    protected void setUp() {
        test = new DestroyObjectActionImpl();
    }
    /**
     * <p>
     * Basic test of <code>DestroyObjectActionImpl()</code> Constructor.
     * </p>
     */
    public void testDestroyObjectActionImplCtor_Basic() {
        for (int i = 0; i < 3; i++) {
            assertNotNull("Create failed.", test);
        }
    }

    /**
     * <p>
     * Basic test of <code>DestroyObjectActionImpl()</code> Constructor.
     * It creates the instance of <code>DestroyObjectActionImpl</code> for several times,
     * like a stress test.
     * </p>
     */
    public void testDestroyObjectActionImplCtor_Basic_Complex() {
        for (int i = 0; i < 3; i++) {
            assertNotNull("Create failed.", new DestroyObjectActionImpl());
        }
    }

    /**
     * <p>
     * Accuracy test of <code>DestroyObjectActionImpl</code> class, the class should be
     * a subclass of <code>PrimitiveActionAbstractImpl</code>.
     * </p>
     */
    public void testClass_Inherit() {
        assertTrue("DestroyObjectActionImpl class should be a subclass of PrimitiveActionAbstractImpl",
            test instanceof PrimitiveActionAbstractImpl);
    }

    /**
     * <p>
     * Accuracy test of <code>DestroyObjectActionImpl</code> class, the class should
     * implement <code>DestroyObjectAction</code> interface.
     * </p>
     */
    public void testClass_Interface() {
        assertTrue("DestroyObjectActionImpl class should implement DestroyObjectAction interface",
            test instanceof DestroyObjectAction);
    }
}