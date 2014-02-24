/*
 * Copyright (C) 2008 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.gui.closabletabbedpane;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

/**
 * <p>
 * This test case aggregates all Unit test cases.
 * </p>
 * @author TCSDEVELOPER
 * @version 1.0
 */
public class UnitTests extends TestCase {

    /**
     * <p>
     * Aggregates all tests in this class.
     * </p>
     * @return Test suite aggregating all tests.
     */
    public static Test suite() {
        final TestSuite suite = new TestSuite();
        suite.addTest(ClosableTabbedPaneConfigurationExceptionUnitTest.suite());
        suite.addTest(ClosableTabbedPaneEventUnitTest.suite());
        suite.addTest(ClosableTabbedPaneHelperUnitTest.suite());
        suite.addTest(CloseButtonStateUnitTest.suite());
        suite.addTest(DirectionalActiveTabSelectorUnitTest.suite());
        suite.addTest(PreviousActiveTabSelectorUnitTest.suite());

        suite.addTest(ClosableTabbedPaneUnitTest1.suite());
        suite.addTest(ClosableTabbedPaneUnitTest2.suite());
        suite.addTest(MainUnitTest.suite());
        return suite;
    }

}
