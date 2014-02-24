/*
 * Copyright (C) 2006 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.util.eventmanager.failuretests;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

/**
 * <p>This test case aggregates all Failure test cases.</p>
 *
 * @author King_Bette
 * @version 1.0
 */
public class FailureTests extends TestCase {
    /**
     * <p>Get all unit test suite.</p>
     *
     * @return all unit test suit.
     */
    public static Test suite() {
        final TestSuite suite = new TestSuite();
        suite.addTest(ActionEventFailureTest.suite());
        suite.addTest(EventManagerFailureTest.suite());
        suite.addTest(RedoChangesEventFailureTest.suite());
        suite.addTest(UndoChangesEventFailureTest.suite());
        return suite;
    }

}
