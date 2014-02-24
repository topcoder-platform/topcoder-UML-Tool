/*
 * Copyright (C) 2006 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.swing.imageexporter;

import com.topcoder.swing.imageexporter.accuracytests.AccuracyTests;
import com.topcoder.swing.imageexporter.failuretests.FailureTests;
import com.topcoder.swing.imageexporter.stresstests.StressTests;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

/**
 * <p>
 * This test case aggregates all test cases.
 * </p>
 *
 * @author TCSDEVELOPER
 * @version 1.0
 */
public class AllTests extends TestCase {
    /**
     * Returns aggregated unit tests.
     *
     * @return aggregated unit tests.
     */
    public static Test suite() {
        final TestSuite suite = new TestSuite();
        // unit tests
        suite.addTest(FailureTests.suite());
        suite.addTest(UnitTests.suite());
        suite.addTest(StressTests.suite());
        suite.addTest(AccuracyTests.suite());
        return suite;
    }

}
