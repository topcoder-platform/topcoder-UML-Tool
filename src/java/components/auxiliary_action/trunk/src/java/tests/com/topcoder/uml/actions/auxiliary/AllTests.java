/*
 * Copyright (C) 2007 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.uml.actions.auxiliary;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

import com.topcoder.uml.actions.auxiliary.accuracytests.AccuracyTests;
import com.topcoder.uml.actions.auxiliary.failuretests.FailureTests;
import com.topcoder.uml.actions.auxiliary.stresstests.StressTests;

/**
 * <p>
 * Aggregates all tests.
 * </p>
 *
 * @version 1.0
 * @author TCSDEVELOPER
 */
public class AllTests extends TestCase {
    /**
     * <p>
     * Aggregates all tests.
     * </p>
     *
     * @return all test cases.
     */
    public static Test suite() {
        final TestSuite suite = new TestSuite();
        // failure tests
        suite.addTest(FailureTests.suite());
        // unit tests
        suite.addTest(UnitTests.suite());
        // accuracy tests
        suite.addTest(AccuracyTests.suite());
        // stress tests
        suite.addTest(StressTests.suite());
        return suite;
    }

}
