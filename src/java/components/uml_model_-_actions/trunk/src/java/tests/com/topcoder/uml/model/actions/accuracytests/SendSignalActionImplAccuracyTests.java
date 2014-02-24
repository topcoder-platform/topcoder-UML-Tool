/*
 * Copyright (C) 2006 TopCoder Inc., All Rights Reserved.
 *
 * TCS UML_Model_-_Actions Version 1.0 Accuracytests.
 *
 * @ SendSignalActionImplAccuracyTests.java
 */
package com.topcoder.uml.model.actions.accuracytests;

import com.topcoder.uml.model.actions.messagingactions.ExplicitInvocationActionAbstractImpl;
import com.topcoder.uml.model.actions.messagingactions.SendSignalAction;
import com.topcoder.uml.model.actions.messagingactions.SendSignalActionImpl;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;


/**
 * <p>
 * The <code>SendSignalActionImpl</code>'s Accuracy Tests.
 * This accuracy tests addresses the functionality provided
 * by the <code>SendSignalActionImpl</code> class.
 * </p>
 *
 * @author zmg
 * @version 1.0
 */
public class SendSignalActionImplAccuracyTests extends TestCase {
    /**
     * <p>
     * Test suite of <code>SendSignalActionImplAccuracyTests</code>.
     * </p>
     *
     * @return Test suite of <code>SendSignalActionImplAccuracyTests</code>.
     */
    public static Test suite() {
        return new TestSuite(SendSignalActionImplAccuracyTests.class);
    }

    /**
     * <p>
     * Accuracy Test of the <code>SendSignalActionImpl()</code> constructor.
     * </p>
     */
    public void testConstructor() {
        // creat a new instance to check the constructor.
        assertNotNull("Constructor should work well.",
            new SendSignalActionImpl());
    }

    /**
     * <p>
     * Accuracy Test of the <code>SendSignalActionImpl</code> class.
     * It tests the class inheritance and class interface.
     * </p>
     */
    public void testRelationship() {
        SendSignalActionImpl action = new SendSignalActionImpl();

        // test class inheritance.
        assertTrue("This class should extend from ExplicitInvocationActionAbstractImpl",
            action instanceof ExplicitInvocationActionAbstractImpl);

        // test class interface.
        assertTrue("This class should implement SendSignalAction interface",
            action instanceof SendSignalAction);
    }
}
