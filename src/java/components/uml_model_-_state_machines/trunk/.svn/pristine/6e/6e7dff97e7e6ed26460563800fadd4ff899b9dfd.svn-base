/**
 *
 * Copyright (c) 2006, TopCoder, Inc. All rights reserved
 */
package com.topcoder.uml.model.statemachines;

import com.topcoder.uml.model.statemachines.accuracytests.AccuracyTests;
import com.topcoder.uml.model.statemachines.failuretests.FailureTests;
import com.topcoder.uml.model.statemachines.stresstests.StressTests;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

/**
 * This test case aggregates all test cases.
 *
 * @author catcher
 * @version 1.0
 */
public class AllTests extends TestCase {
    /**
     * Aggregates all test cases.
     *
     * @return the aggregated test cases
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
