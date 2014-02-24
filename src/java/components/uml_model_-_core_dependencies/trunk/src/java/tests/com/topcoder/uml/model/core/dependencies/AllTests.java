/*
 * Copyright (C) 2006 TopCoder Inc., All Rights Reserved.
 *
 * TCS UML Model - Core Dependencies Version 1.0
 *
 * @ AllTests.java
 */
package com.topcoder.uml.model.core.dependencies;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;
import com.topcoder.uml.model.core.dependencies.accuracytests.AccuracyTests;
import com.topcoder.uml.model.core.dependencies.failuretests.FailureTests;
import com.topcoder.uml.model.core.dependencies.stresstests.StressTests;

/**
 * <p>This test case aggregates all test cases.</p>
 *
 * @author TCSDEVELOPER
 * @version 1.0
 */
public class AllTests extends TestCase {
    /**
     * Return the test suite for unit tests.
     *
     * @return The test suite for unit tests
     */
    public static Test suite() {
        final TestSuite suite = new TestSuite();

        //unit tests
        suite.addTest(UnitTests.suite());

        //accuracy tests
        suite.addTest(AccuracyTests.suite());

        //failure tests
        suite.addTest(FailureTests.suite());

        //stress tests
        suite.addTest(StressTests.suite());

        return suite;
    }

}
