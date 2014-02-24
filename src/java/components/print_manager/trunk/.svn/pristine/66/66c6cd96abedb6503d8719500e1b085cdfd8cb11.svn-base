/*
 * Copyright (C) 2006 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.swing.print.failuretests;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

/**
 * <p>
 * This test case aggregates all Failure test cases.
 * </p>
 *
 * @author restarter
 * @version 1.0
 */
public class FailureTests extends TestCase {

    /**
     * <p>
     * Aggregates all Failure test cases.
     * </p>
     *
     * @return the failure test suite
     */
    public static Test suite() {
        final TestSuite suite = new TestSuite();
        suite.addTestSuite(AbstractPrintFailureTest.class);
        suite.addTestSuite(DefaultComponentVisibleMakerFailureTest.class);
        suite.addTestSuite(DefaultPrintFormatRetrieverFailureTest.class);
        suite.addTestSuite(FitInPagePrintFailureTest.class);
        suite.addTestSuite(PrintManagerFailureTest.class);
        suite.addTestSuite(ScalingPrintFailureTest.class);
        return suite;
    }

}
