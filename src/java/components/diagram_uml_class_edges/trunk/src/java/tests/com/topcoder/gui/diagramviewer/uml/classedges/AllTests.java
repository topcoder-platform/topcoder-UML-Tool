/*
 * Copyright (c) 2007, TopCoder, Inc. All rights reserved
 */
package com.topcoder.gui.diagramviewer.uml.classedges;

import com.topcoder.gui.diagramviewer.uml.classedges.failuretests.FailureTests;
import com.topcoder.gui.diagramviewer.uml.classedges.accuracytests.AccuracyTests;
import com.topcoder.gui.diagramviewer.uml.classedges.stresstests.StressTests;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

/**
 * <p>
 * This test case aggregates all test cases.
 * </p>
 *
 * @author TopCoder
 * @version 1.0
 */
public class AllTests extends TestCase {

    /**
     * <p>
     * Test suite of all test cases.
     * </p>
     *
     * @return the test suite
     */
    public static Test suite() {
        final TestSuite suite = new TestSuite();

        //unit tests
        suite.addTest(UnitTests.suite());

        //failure tests
        suite.addTest(FailureTests.suite());

        //accuracy tests
        suite.addTest(AccuracyTests.suite());

        //stress tests
        suite.addTest(StressTests.suite());

        return suite;
    }

}
