/*
 * Copyright (C) 2008 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.gui.sidemenu.accuracytests;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

/**
 * <p>
 * This test case aggregates all Accuracy test cases.
 * </p>
 *
 * @author TCSDEVELOPER
 * @version 1.0
 */
public class AccuracyTests extends TestCase {
    /**
     * <p>
     * This test case aggregates all accuracy test cases.
     * </p>
     *
     * @return all accuracy test cases.
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