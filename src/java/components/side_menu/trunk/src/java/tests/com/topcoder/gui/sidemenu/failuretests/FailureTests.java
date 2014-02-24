/*
 * Copyright (C) 2008 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.gui.sidemenu.failuretests;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

/**
 * <p>
 * This test case aggregates all Failure test cases.
 * </p>
 *
 * @author TCSDEVELOPER
 * @version 1.0
 */
public class FailureTests extends TestCase {
    /**
     * Aggregate all tests.
     * @return TestSuite
     */
    public static Test suite() {
        final TestSuite suite = new TestSuite();
        suite.addTestSuite(AbstractSideMenuPanelTest.class);
        suite.addTestSuite(DefaultCollapsedSideMenuPanelTest.class);
        suite.addTestSuite(DefaultExpandedSideMenuPanelTest.class);
        suite.addTestSuite(DefaultSideMenuModelTest.class);
        suite.addTestSuite(SideMenuPanelTest.class);

        return suite;
    }

}
