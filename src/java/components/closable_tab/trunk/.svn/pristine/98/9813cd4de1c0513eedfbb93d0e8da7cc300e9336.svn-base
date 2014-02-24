/*
 * Copyright (c) 2008, TopCoder, Inc. All rights reserved
 */
package com.topcoder.gui.closabletabbedpane.stresstests;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

/**
 * <p>
 * This test case aggregates all stress test cases.
 * </p>
 *
 * @author Littleken
 * @version 1.0
 */
public class StressTests extends TestCase {

    /**
     * <p>
     * The test suite.
     * </p>
     *
     * @return the test suite
     */
    public static Test suite() {

        final TestSuite suite = new TestSuite();

        suite.addTestSuite(ClosableTabbedPaneUnitTest.class);
        suite.addTestSuite(DirectionalActiveTabSelectorStressTest.class);
        suite.addTestSuite(PreviousActiveTabSelectorStressTest.class);
        suite.addTestSuite(FunctionalStressTest.class);

        return suite;
    }

}
