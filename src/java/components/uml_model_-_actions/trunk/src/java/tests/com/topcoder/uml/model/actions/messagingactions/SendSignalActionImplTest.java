/*
 * Copyright (C) 2006 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.uml.model.actions.messagingactions;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;
/**
 * <p>
 * This class tests the <code>SendSignalActionImpl</code> class.
 * It addresses the functionality provided by the<code>SendSignalActionImpl</code> class.
 * It tests the methods: SendSignalActionImpl().
 * </p>
 *
 * @author TCSDEVELOPER
 * @version 1.0
 */
public class SendSignalActionImplTest extends TestCase {
   /**
     * <p>
     * The instance of <code>SendSignalActionImpl</code> for test.
     * </p>
     */
    private SendSignalActionImpl test = null;

    /**
     * <p>
     * Test suite of <code>SendSignalActionImplTest</code>.
     * </p>
     *
     * @return Test suite of <code>SendSignalActionImplTest</code>.
     */
    public static Test suite() {
        return new TestSuite(SendSignalActionImplTest.class);
    }

    /**
     * <p>
     * Initialization for all tests here.
     * </p>
     */
    protected void setUp() {
        test = new SendSignalActionImpl();
    }
    /**
     * <p>
     * Basic test of <code>SendSignalActionImpl()</code> Constructor.
     * </p>
     */
    public void testSendSignalActionImplCtor_Basic() {
        for (int i = 0; i < 3; i++) {
            assertNotNull("Create failed.", test);
        }
    }

    /**
     * <p>
     * Basic test of <code>SendSignalActionImpl()</code> Constructor.
     * It creates the instance of <code>SendSignalActionImpl</code> for several times,
     * like a stress test.
     * </p>
     */
    public void testSendSignalActionImplCtor_Basic1() {
        for (int i = 0; i < 3; i++) {
            assertNotNull("Create failed.", new SendSignalActionImpl());
        }
    }

    /**
     * <p>
     * Accuracy test of <code>SendSignalActionImpl</code> class, the class should be
     * a subclass of <code>ExplicitInvocationActionAbstractImpl</code>.
     * </p>
     */
    public void testClass_Inherit() {
        assertTrue("SendSignalActionImpl class should be a subclass of ExplicitInvocationActionAbstractImpl",
            test instanceof ExplicitInvocationActionAbstractImpl);
    }

    /**
     * <p>
     * Accuracy test of <code>SendSignalActionImpl</code> class, the class should
     * implement <code>SendSignalAction</code> interface.
     * </p>
     */
    public void testClass_Interface() {
        assertTrue("SendSignalActionImpl class should implement SendSignalAction interface",
            test instanceof SendSignalAction);
    }
}