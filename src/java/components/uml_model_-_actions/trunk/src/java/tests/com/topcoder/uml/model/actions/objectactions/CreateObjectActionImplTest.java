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
 * This class tests the <code>CreateObjectActionImpl</code> class.
 * It addresses the functionality provided by the<code>CreateObjectActionImpl</code> class.
 * It tests the methods: CreateObjectActionImpl().
 * </p>
 *
 * @author TCSDEVELOPER
 * @version 1.0
 */
public class CreateObjectActionImplTest extends TestCase {
   /**
     * <p>
     * The instance of <code>CreateObjectActionImpl</code> for test.
     * </p>
     */
    private CreateObjectActionImpl test = null;

    /**
     * <p>
     * Test suite of <code>CreateObjectActionImplTest</code>.
     * </p>
     *
     * @return Test suite of <code>CreateObjectActionImplTest</code>.
     */
    public static Test suite() {
        return new TestSuite(CreateObjectActionImplTest.class);
    }

    /**
     * <p>
     * Initialization for all tests here.
     * </p>
     */
    protected void setUp() {
        test = new CreateObjectActionImpl();
    }
    /**
     * <p>
     * Basic test of <code>CreateObjectActionImpl()</code> Constructor.
     * </p>
     */
    public void testCreateObjectActionImplCtor_Basic() {
        for (int i = 0; i < 3; i++) {
            assertNotNull("Create failed.", test);
        }
    }

    /**
     * <p>
     * Basic test of <code>CreateObjectActionImpl()</code> Constructor.
     * It creates the instance of <code>CreateObjectActionImpl</code> for several times,
     * like a stress test.
     * </p>
     */
    public void testCreateObjectActionImplCtor_Basic_Complex() {
        for (int i = 0; i < 3; i++) {
            assertNotNull("Create failed.", new CreateObjectActionImpl());
        }
    }

    /**
     * <p>
     * Accuracy test of <code>CreateObjectActionImpl</code> class, the class should be
     * a subclass of <code>PrimitiveActionAbstractImpl</code>.
     * </p>
     */
    public void testClass_Inherit() {
        assertTrue("CreateObjectActionImpl class should be a subclass of PrimitiveActionAbstractImpl",
            test instanceof PrimitiveActionAbstractImpl);
    }

    /**
     * <p>
     * Accuracy test of <code>CreateObjectActionImpl</code> class, the class should
     * implement <code>CreateObjectAction</code> interface.
     * </p>
     */
    public void testClass_Interface() {
        assertTrue("CreateObjectActionImpl class should implement CreateObjectAction interface",
            test instanceof CreateObjectAction);
    }
}