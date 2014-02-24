/**
 *
 * Copyright (c) 2006, TopCoder, Inc. All rights reserved
 */
 package com.topcoder.uml.model.datatypes.failuretests;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

/**
 * <p>This test case aggregates all Failure test cases.</p>
 *
 * @author TopCoder
 * @version 1.0
 */
public class FailureTests extends TestCase {

    /**
     * Aggreate all the failure tests.
     *
     * @return a suite of failure tests.
     */
    public static Test suite() {
        final TestSuite suite = new TestSuite();

        suite.addTestSuite(MultiplicityImplFailureTest.class);
        suite.addTestSuite(MultiplicityRangeImplFailureTest.class);
        
        return suite;
    }

}
