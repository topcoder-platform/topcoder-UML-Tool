/**
 *
 * Copyright (c) 2006, TopCoder, Inc. All rights reserved
 */
package com.topcoder.xmi.reader.handlers.uml.model;

import com.topcoder.xmi.reader.handlers.uml.model.accuracytests.AccuracyTests;
import com.topcoder.xmi.reader.handlers.uml.model.failuretests.FailureTests;
import com.topcoder.xmi.reader.handlers.uml.model.stresstests.StressTests;

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
        suite.addTest(UnitTests.suite());
        suite.addTest(AccuracyTests.suite());
        suite.addTest(StressTests.suite());
        //unit tests
        suite.addTest(FailureTests.suite());
        
        return suite;
    }

}
