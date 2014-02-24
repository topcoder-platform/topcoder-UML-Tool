/*
 * Copyright (C) 2006 TopCoder Inc., All Rights Reserved.
 */

package com.topcoder.uml.model.core;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

import com.topcoder.uml.model.core.accuracytests.AccuracyTests;
import com.topcoder.uml.model.core.failuretests.FailureTests;
import com.topcoder.uml.model.core.stresstests.StressTests;

/**
 * This test case aggregates all unit test cases.
 * @author vividmxx
 * @version 1.0
 */
public class AllTests extends TestCase {

    /**
     * Aggregates all unit test cases.
     * @return the aggregated unit test cases.
     */
    public static Test suite() {
        TestSuite suite = new TestSuite();

        suite.addTest(UnitTests.suite());
        suite.addTest(AccuracyTests.suite());
        suite.addTest(FailureTests.suite());
        suite.addTest(StressTests.suite());

        return suite;
    }
}
