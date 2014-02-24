/*
 * Copyright (C) 2006 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.uml.model.actions.messagingactions;

import com.topcoder.uml.model.core.Operation;
import com.topcoder.uml.model.core.OperationImpl;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;


/**
 * <p>
 * This class tests the <code>CallOperationActionImpl</code> class.
 * It addresses the functionality provided by the<code>CallOperationActionImpl</code> class.
 * It tests the methods: CallOperationActionImpl(), isAsynchronous(), setAsynchronous(boolean)
 * getOperation(), setOperation(Operation).
 * </p>
 *
 * @author TCSDEVELOPER
 * @version 1.0
 */
public class CallOperationActionImplTest extends TestCase {
    /**
    * <p>
    * The instance of <code>CallOperationActionImpl</code> for test.
    * </p>
    */
    private CallOperationActionImpl test = null;

    /**
     * <p>
     * The instance of <code>Operation</code> for test.
     * </p>
     */
    private Operation operation = null;

    /**
     * <p>
     * Test suite of <code>CallOperationActionImplTest</code>.
     * </p>
     *
     * @return Test suite of <code>CallOperationActionImplTest</code>.
     */
    public static Test suite() {
        return new TestSuite(CallOperationActionImplTest.class);
    }

    /**
     * <p>
     * Initialization for all tests here.
     * </p>
     */
    protected void setUp() {
        test = new CallOperationActionImpl();
        operation = new OperationImpl();
    }

    /**
     * <p>
     * Basic test of <code>CallOperationActionImpl()</code> Constructor.
     * </p>
     */
    public void testCallOperationActionImplCtor_Basic() {
        for (int i = 0; i < 3; i++) {
            assertNotNull("Create failed.", test);
        }
    }

    /**
     * <p>
     * Basic test of <code>CallOperationActionImpl()</code> Constructor.
     * It creat the instance of <code>CallOperationActionImpl</code> for several times,
     * like a stress test.
     * </p>
     */
    public void testCallOperationActionImplCtor_Basic_Complex() {
        for (int i = 0; i < 3; i++) {
            assertNotNull("Create failed.", new SendSignalActionImpl());
        }
    }

    /**
     * <p>
     * Accuracy test of <code>CallOperationActionImpl()</code> Constructor.
     * We get the attribute : operation for test.
     * </p>
     */
    public void testCallOperationActionImplCtor_Detail() {
        assertNotNull("Create failed.", test);
        assertNull("The operation should be null.", test.getOperation());
    }

    /**
     * <p>
     * Basic test of <code>isAsynchronous()</code> method.
     * It gets the asynchronous for test.
     * </p>
     */
    public void testisAsynchronous_Basic() {
        assertFalse("The operation should be called synchronous.",
            test.isAsynchronous());
    }

    /**
     * <p>
     * Basic test of <code>isAsynchronous()</code> method.
     * It creates the instance of <code>CallOperationActionImpl</code> for several times,
     * then gets the asynchronous for test, like a stress test.
     * </p>
     */
    public void testisAsynchronous_Basic_Complex() {
        for (int i = 0; i < 3; i++) {
            CallOperationActionImpl action = new CallOperationActionImpl();
            assertFalse("The operation should be called synchronous.",
                action.isAsynchronous());
        }
    }

    /**
     * <p>
     * Accuracy test of <code>isAsynchronous()</code> method.
     * It sets the asynchronous and then gets it for test.
     * </p>
     */
    public void testisAsynchronous_Detail() {
        // set the asynchronous to true.
        test.setAsynchronous(true);
        assertTrue("The operation should be called asynchronous.",
            test.isAsynchronous());

        // set the asynchronous to false.
        test.setAsynchronous(false);
        assertFalse("The operation should be called synchronous.",
            test.isAsynchronous());
    }

    /**
     * <p>
     * Basic test of <code>setAsynchronous(boolean)</code> method.
     * It sets the asynchronous and then gets it for test.
     * </p>
     */
    public void testsetAsynchronous_Basic() {
        // set the asynchronous to true.
        test.setAsynchronous(true);
        assertTrue("The operation should be called asynchronous.",
            test.isAsynchronous());
    }

    /**
     * <p>
     * Basic test of <code>setAsynchronous(boolean)</code> method.
     * It sets the asynchronous and then gets it for several times.
     * </p>
     */
    public void testsetAsynchronous_Basic_Complex() {
        for (int i = 0; i < 3; i++) {
            // set the asynchronous to true.
            test.setAsynchronous(true);
            assertTrue("The operation should be called asynchronous.",
                test.isAsynchronous());

            // set the asynchronous to false.
            test.setAsynchronous(false);
            assertFalse("The operation should be called synchronous.",
                test.isAsynchronous());
        }
    }

    /**
     * <p>
     * Basic test of <code>setAsynchronous(boolean)</code> method.
     * It creates the instance of <code>CallOperationActionImpl</code> for several times,
     * then sets the asynchronous and gets it for test, like a stress test.
     * </p>
     */
    public void testsetAsynchronous_Basic_Times() {
        for (int i = 0; i < 3; i++) {
            CallOperationActionImpl action = new CallOperationActionImpl();
            assertFalse("The operation should be called synchronous.",
                action.isAsynchronous());

            // set the asynchronous to true.
            action.setAsynchronous(true);
            assertTrue("The operation should be called asynchronous.",
                action.isAsynchronous());
        }
    }

    /**
     * <p>
     * Basic test of <code>getOperation()</code> method.
     * </p>
     */
    public void testgetOperation_Basic() {
        assertNull("The operation should be null.", test.getOperation());
    }

    /**
     * <p>
     * Basic test of <code>getOperation()</code> method.
     * It creates the instance of <code>CallOperationActionImpl</code> for several times,
     * then gets the operation for test, like a stress test.
     * </p>
     */
    public void testgetOperation_Basic_Complex() {
        for (int i = 0; i < 3; i++) {
            CallOperationActionImpl action = new CallOperationActionImpl();
            assertNull("The operation should be null.", action.getOperation());
        }
    }

    /**
     * <p>
     * Accuracy test of <code>getOperation()</code> method.
     * It sets the operation and gets it for test
     * </p>
     */
    public void testgetOperation_Detail() {
        // set the operation.
        test.setOperation(operation);

        // equal value expected.
        assertEquals("The two procedures should be equal", operation,
            test.getOperation());
    }

    /**
     * <p>
     * Accuracy test of <code>getOperation()</code> method.
     * It creates the instance of <code>CallOperationActionImpl</code> for several times,
     * then sets the operation and gets it for test, like a stress test.
     * </p>
     */
    public void testgetOperation_Detail_Complex() {
        for (int i = 0; i < 3; i++) {
            CallOperationActionImpl action = new CallOperationActionImpl();
            // set the operation.
            action.setOperation(operation);

            // equal value expected.
            assertEquals("The two procedures should be equal", operation,
                action.getOperation());
        }
    }

    /**
     * <p>
     * Accuracy test of <code>CallOperationActionImpl</code> class, the class should be
     * a subclass of <code>ExplicitInvocationActionAbstractImpl</code>.
     * </p>
     */
    public void testClass_Inherit() {
        assertTrue("CallOperationActionImpl class should be a subclass of ExplicitInvocationActionAbstractImpl",
            test instanceof ExplicitInvocationActionAbstractImpl);
    }

    /**
     * <p>
     * Accuracy test of <code>CallOperationActionImpl</code> class, the class should
     * implement <code>CallOperationAction</code> interface.
     * </p>
     */
    public void testClass_Interface() {
        assertTrue("CallOperationActionImpl class should implement CallOperationAction interface",
            test instanceof CallOperationAction);
    }
}
