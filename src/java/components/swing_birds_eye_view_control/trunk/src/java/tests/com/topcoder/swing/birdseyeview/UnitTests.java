/*
 * Copyright (C) 2008 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.swing.birdseyeview;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

/**
 * <p>
 * This test case aggregates all Unit test cases.
 * </p>
 *
 * @author TCSDEVELOPER
 * @version 1.0
 */
public class UnitTests extends TestCase {

    /**
     * <p>
     * Create aggregation of unit test cases.
     * </p>
     *
     * @return
     *      the aggregation of unit test cases.
     */
    public static Test suite() {
        final TestSuite suite = new TestSuite();
        suite.addTestSuite(DemoTest.class);
        suite.addTestSuite(BirdsEyeViewTest.class);
        suite.addTestSuite(HelperTest.class);
        suite.addTestSuite(ViewPortTest.class);
        suite.addTestSuite(ViewPortEventTest.class);
        return suite;
    }

}
