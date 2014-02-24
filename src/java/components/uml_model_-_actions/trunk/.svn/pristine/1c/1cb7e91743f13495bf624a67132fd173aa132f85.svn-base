/*
 * Copyright (C) 2006 TopCoder Inc., All Rights Reserved.
 *
 * TCS UML_Model_-_Actions Version 1.0 Accuracytests.
 *
 * @ CallOperationActionImplAccuracyTests.java
 */
package com.topcoder.uml.model.actions.accuracytests;

import com.topcoder.uml.model.actions.messagingactions.CallOperationAction;
import com.topcoder.uml.model.actions.messagingactions.CallOperationActionImpl;
import com.topcoder.uml.model.actions.messagingactions.ExplicitInvocationActionAbstractImpl;
import com.topcoder.uml.model.core.Operation;
import com.topcoder.uml.model.core.OperationImpl;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;


/**
 * <p>
 * The <code>CallOperationActionImpl</code>'s Accuracy Tests.
 * This accuracy tests addresses the functionality provided
 * by the <code>CallOperationActionImpl</code> class.
 * </p>
 *
 * @author zmg
 * @version 1.0
 */
public class CallOperationActionImplAccuracyTests extends TestCase {
    /**
     * <p>
     * The instance of <code>CallOperationActionImpl</code> used for tests.
     * </p>
     */
    private CallOperationActionImpl test = null;

    /**
     * <p>
     * The instance of <code>Operation</code> used for tests.
     * </p>
     */
    private Operation operation = null;

    /**
     * <p>
     * Test suite of <code>CallOperationActionImplAccuracyTests</code>.
     * </p>
     *
     * @return Test suite of <code>CallOperationActionImplAccuracyTests</code>.
     */
    public static Test suite() {
        return new TestSuite(CallOperationActionImplAccuracyTests.class);
    }

    /**
     * <p>
     * Initialization for all tests here, creats a new instance of <code>Operation</code>
     * and <code>CallOperationActionImpl</code>.
     * </p>
     */
    protected void setUp() {
        test = new CallOperationActionImpl();
        operation = new OperationImpl();
    }

    /**
     * <p>
     * Accuracy Test of the <code>CallOperationActionImplAccuracyTests()</code> constructor.
     * </p>
     */
    public void testConstructor() {
        // creat a new instance.
        assertNotNull("Constructor should work well.",
            new CallOperationActionImpl());

        // get the original value of operation to check the constructor
        assertNull("The procedure expected to be null", test.getOperation());

        // get the original value of asynchronous to check the constructor
        assertFalse("The asynchronous expected to be false.",
            test.isAsynchronous());
    }

    /**
     * <p>
     * Accuracy Test of the <code>setAsynchronous(boolean)</code> method
     * and <code>isAsynchronous()</code> method.
     * </p>
     */
    public void testAsynchronous_Operation() {
        // get the original value of asynchronous.
        assertFalse("The asynchronous expected to be true.",
            test.isAsynchronous());

        // set the asynchronous to true.
        test.setAsynchronous(true);

        // get the asynchronous to check it is true now
        assertTrue("The asynchronous expected to be true.",
            test.isAsynchronous());

        // set the asynchronous to false.
        test.setAsynchronous(false);

        // get the asynchronous to check it is false now
        assertFalse("The asynchronous expected to be false.",
            test.isAsynchronous());
    }

    /**
     * <p>
     * Accuracy Test of the <code>setOperation(Operation)</code> method
     * and <code>getOperation()</code> method.
     * </p>
     */
    public void testOperation_Operation() {
        // get the original value of operation.
        assertNull("The operation expected to be null.", test.getOperation());

        // set the operation.
        test.setOperation(operation);

        // get the operation to check it's value.
        assertSame("The two operation expected to be same", operation,
            test.getOperation());
    }

    /**
     * <p>
     * Accuracy Test of the <code>CallOperationActionImpl</code> class.
     * It tests the class inheritance and class interface.
     * </p>
     */
    public void testRelationship() {
        // test class inheritance.
        assertTrue("This class should extend from ExplicitInvocationActionAbstractImpl",
            test instanceof ExplicitInvocationActionAbstractImpl);

        // test class interface.
        assertTrue("This class should implement CallOperationAction interface",
            test instanceof CallOperationAction);
    }
}
