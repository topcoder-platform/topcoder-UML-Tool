/**
 *
 * Copyright (c) 2007, TopCoder, Inc. All rights reserved
 */
package com.topcoder.umltool.xmiconverters.poseidon5;

import com.topcoder.umltool.xmiconverters.poseidon5.accuracytests.AccuracyTests;
import com.topcoder.umltool.xmiconverters.poseidon5.failuretests.FailureTests;
import com.topcoder.umltool.xmiconverters.poseidon5.stresstests.StressTests;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

/**
 * <p>This test case aggregates all test cases.</p>
 *
 * @author TopCoder
 * @version 1.0
 */
public class AllTests extends TestCase {

    public static Test suite() {
        final TestSuite suite = new TestSuite();

        //unit tests
        suite.addTest(UnitTests.suite());

        suite.addTest(FailureTests.suite());
        
        suite.addTest(AccuracyTests.suite());
        
        suite.addTest(StressTests.suite());

        return suite;
    }

}
