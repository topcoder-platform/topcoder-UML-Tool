/*
 * Copyright (C) 2006 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.uml.model.actions;

import com.topcoder.uml.model.actions.messagingactions.CallOperationActionImplTest;
import com.topcoder.uml.model.actions.messagingactions.ExplicitInvocationActionAbstractImplTest;
import com.topcoder.uml.model.actions.messagingactions.SendSignalActionImplTest;
import com.topcoder.uml.model.actions.objectactions.CreateObjectActionImplTest;
import com.topcoder.uml.model.actions.objectactions.DestroyObjectActionImplTest;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;


/**
 * <p>This test case aggregates all Unit test cases.</p>
 *
 * @author TopCoder
 * @version 1.0
 */
public class UnitTests extends TestCase {
    /**
     * <p>Initialize the UnitTests to test.</p>
     *
     * @return a TestSuite for UnitTests.
     */
    public static Test suite() {
        final TestSuite suite = new TestSuite();

        //
        suite.addTest(PrimitiveActionAbstractImplTest.suite());
        suite.addTest(ActionAbstractImplTest.suite());
        suite.addTest(DemoTest.suite());

        suite.addTest(CallOperationActionImplTest.suite());
        suite.addTest(ExplicitInvocationActionAbstractImplTest.suite());
        suite.addTest(SendSignalActionImplTest.suite());

        suite.addTest(CreateObjectActionImplTest.suite());
        suite.addTest(DestroyObjectActionImplTest.suite());

        return suite;
    }
}
