/*
 * Copyright (C) 2008 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.gui.sectionlayout.stresstests;

import com.topcoder.gui.sectionlayout.DockContainerPanelStressTests;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

/**
 * <p>This test case aggregates all Stress test cases.</p>
 *
 * @author TopCoder
 * @version 1.0
 */
public class StressTests extends TestCase {

    public static Test suite() {
        final TestSuite suite = new TestSuite();
        suite.addTestSuite(DockContainerPanelStressTests.class);
        suite.addTestSuite(DefaultSectionHeaderUIStressTests.class);
        suite.addTestSuite(DialogFloatContainerStressTests.class);
        suite.addTestSuite(SectionDockContainerStressTests.class);
        suite.addTestSuite(SectionStressTests.class);
        return suite;
    }
}