/*
 * Copyright (C) 2006 TopCoder Inc., All Rights Reserved.
 *
 * TCS UML_Model_-_Actions Version 1.0 Accuracytests.
 *
 * @ ExplicitInvocationActionAbstractImplAccuracyTests.java
 */
package com.topcoder.uml.model.actions.accuracytests;

import com.topcoder.uml.model.actions.PrimitiveActionAbstractImpl;
import com.topcoder.uml.model.actions.messagingactions.ExplicitInvocationAction;
import com.topcoder.uml.model.actions.messagingactions.ExplicitInvocationActionAbstractImpl;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;


/**
 * <p>
 * The <code>ExplicitInvocationActionAbstractImpl</code>'s Accuracy Tests.
 * This accuracy tests addresses the functionality provided
 * by the <code>ExplicitInvocationActionAbstractImpl</code> class.
 * </p>
 *
 * @author zmg
 * @version 1.0
 */
public class ExplicitInvocationActionAbstractImplAccuracyTests extends TestCase {
    /**
     * <p>
     * Test suite of <code>ExplicitInvocationActionAbstractImplAccuracyTests</code>.
     * </p>
     *
     * @return Test suite of <code>ExplicitInvocationActionAbstractImplAccuracyTests</code>.
     */
    public static Test suite() {
        return new TestSuite(ExplicitInvocationActionAbstractImplAccuracyTests.class);
    }

    /**
     * <p>
     * Accuracy Test of the <code>ExplicitInvocationActionAbstractImpl()</code> constructor.
     * </p>
     */
    public void testConstructor() {
        // creat a new instance to check the constructor.
        assertNotNull("Constructor should work well.",
            new MockExplicitInvocationActionImpl());
    }

    /**
     * <p>
     * Accuracy Test of the <code>ActionAbstractImpl</code> class.
     * It tests the class inheritance and class interface.
     * </p>
     */
    public void testRelationship() {
        ExplicitInvocationActionAbstractImpl action = new MockExplicitInvocationActionImpl();

        // test class inheritance.
        assertTrue("This class should extend from PrimitiveActionAbstractImpl",
            action instanceof PrimitiveActionAbstractImpl);

        // test class interface.
        assertTrue("This class should implement ExplicitInvocationAction interface",
            action instanceof ExplicitInvocationAction);
    }

    /**
     * <p>
     * A inner class which extends the <code>ExplicitInvocationActionAbstractImpl</code> class, used for
     * accuracy test only.
     * </p>
     */
    class MockExplicitInvocationActionImpl
        extends ExplicitInvocationActionAbstractImpl {
        // use default constructor.
    }
}
