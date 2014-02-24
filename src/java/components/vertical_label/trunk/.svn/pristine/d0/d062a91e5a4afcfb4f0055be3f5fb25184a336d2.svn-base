/*
 * Copyright (C) 2008 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.gui.verticallabel;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;
import com.topcoder.gui.verticallabel.accuracytests.AccuracyTests;
import com.topcoder.gui.verticallabel.failuretests.FailureTests;
import com.topcoder.gui.verticallabel.stresstests.StressTests;

/**
 * This test case aggregates all test cases.
 *
 * @author TopCoder
 * @version 1.0
 */
public class AllTests extends TestCase {

    /**
     * This test case aggregates all test cases.
     *
     * @return a test suite containing all test cases.
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
