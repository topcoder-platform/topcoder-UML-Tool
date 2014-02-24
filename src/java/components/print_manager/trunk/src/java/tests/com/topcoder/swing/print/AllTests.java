/**
 * Copyright (c) 2006, TopCoder, Inc. All rights reserved
 */
package com.topcoder.swing.print;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

import com.topcoder.swing.print.accuracytests.AccuracyTests;
import com.topcoder.swing.print.failuretests.FailureTests;
import com.topcoder.swing.print.stresstests.StressTests;

/**
 * <p>
 * This test case aggregates all test cases.
 * </p>
 *
 * @author restarter
 * @version 1.0
 */
public class AllTests extends TestCase {

    /**
     * <p>
     * Aggregates all test cases.
     * </p>
     *
     * @return the test suite
     */
    public static Test suite() {
        final TestSuite suite = new TestSuite();
        // unit tests
        suite.addTest(UnitTests.suite());
        // accuracy tests
        suite.addTest(AccuracyTests.suite());
        // failure tests
        suite.addTest(FailureTests.suite());
        // stress tests
        suite.addTest(StressTests.suite());
        return suite;
    }

}
