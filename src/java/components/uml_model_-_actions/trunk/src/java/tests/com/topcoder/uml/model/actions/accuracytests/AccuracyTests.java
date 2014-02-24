/*
 * Copyright (C) 2006 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.uml.model.actions.accuracytests;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;


/**
 * <p>This test case aggregates all Accuracy test cases.</p>
 *
 * @author zmg
 * @version 1.0
 */
public class AccuracyTests extends TestCase {
    /**
    * Accuracy test suite.
    * @return accuracy test suite.
    */
    public static Test suite() {
        final TestSuite suite = new TestSuite();

        //
        suite.addTest(ActionAbstractImplAccuracyTests.suite());
        suite.addTest(CallOperationActionImplAccuracyTests.suite());
        suite.addTest(ExplicitInvocationActionAbstractImplAccuracyTests.suite());
        suite.addTest(ObjectActionsAccuracyTests.suite());
        suite.addTest(PrimitiveActionAbstractImplAccuracyTests.suite());
        suite.addTest(SendSignalActionImplAccuracyTests.suite());

        return suite;
    }
}
