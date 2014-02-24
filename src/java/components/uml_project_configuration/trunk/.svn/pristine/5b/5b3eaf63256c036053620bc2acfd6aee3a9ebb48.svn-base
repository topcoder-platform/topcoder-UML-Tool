/**
 *
 * Copyright (c) 2006, TopCoder, Inc. All rights reserved
 */
package com.topcoder.uml.projectconfiguration;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

import com.topcoder.uml.projectconfiguration.accuracytests.AccuracyTests;
import com.topcoder.uml.projectconfiguration.failuretests.FailureTests;
import com.topcoder.uml.projectconfiguration.stresstests.StressTests;

/**
 * <p>This test case aggregates all test cases.</p>
 *
 * @author TopCoder
 * @version 1.0
 */
public class AllTests extends TestCase {

    public static Test suite() {
        final TestSuite suite = new TestSuite();
        
        //stress tests
        suite.addTest(UnitTests.suite());
        
        suite.addTest(AccuracyTests.suite());
        
        suite.addTest(FailureTests.suite());
        
        suite.addTest(StressTests.suite());
        
        return suite;
    }

}
