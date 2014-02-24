/*
 * Copyright (C) 2007 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.gui.diagramviewer.edges.failuretests;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

/**
 * <p>This test case aggregates all Failure test cases.</p>
 *
 * @author still
 * @version 1.0
 */
public class FailureTests extends TestCase {
    /**
     * aggregates all Failure test cases.
     *
     * @return failure test suites
     */
    public static Test suite() {
        final TestSuite suite = new TestSuite();
        suite.addTest(EdgeEndingFailureTest.suite());
        suite.addTest(EdgeFailureTest.suite());
        suite.addTest(LineStyleFailureTest.suite());

        suite.addTest(RectangleConnectorFailureTest.suite());
        suite.addTest(SelectionCornerFailureTest.suite());
        suite.addTest(TextFieldFailureTest.suite());
        suite.addTest(WayPointEventFailureTest.suite());

        return suite;
    }

}
