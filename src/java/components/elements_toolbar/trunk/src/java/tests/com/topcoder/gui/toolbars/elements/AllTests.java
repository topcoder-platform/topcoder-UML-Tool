/*
 * Copyright (C) 2006 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.gui.toolbars.elements;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

import com.topcoder.gui.toolbars.elements.accuracytests.AccuracyTests;
import com.topcoder.gui.toolbars.elements.failuretests.FailureTests;
import com.topcoder.gui.toolbars.elements.stresstests.StressTests;

/**
 * <p>This test case aggregates all test cases.</p>
 *
 * @author ch_music
 * @version 1.0
 */
public class AllTests extends TestCase {

    /**
     * <p>
     * Returns a Test object containing all the unit tests.
     * </p>
     *
     * @return a Test object containing all the unit tests
     */
    public static Test suite() {
        final TestSuite suite = new TestSuite();

        // unit tests.
        suite.addTest(UnitTests.suite());

        // failure tests.
        suite.addTest(FailureTests.suite());

        // stress tests.
        suite.addTest(StressTests.suite());

        // accuracy tests.
        suite.addTest(AccuracyTests.suite());

        return suite;
    }
}
