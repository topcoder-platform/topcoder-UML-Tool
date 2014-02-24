/*
 * Copyright (C) 2006 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.util.eventmanager.accuracytests;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

/**
 * This <code>TestCase</code> aggregates all accuracy test cases.
 *
 * @author daiwb
 * @version 1.0
 */
public class AccuracyTests extends TestCase {
    /**
     * Adds all the accuracy test suite.

     * @return the accuracy test case suite.
     */
    public static Test suite() {
        final TestSuite suite = new TestSuite();

        // Package 'com.topcoder.util.eventmanager'.
        suite.addTestSuite(ActionEventAccuracyTestCase.class);
        suite.addTestSuite(RedoChangesEventAccuracyTestCase.class);
        suite.addTestSuite(UndoChangesEventAccuracyTestCase.class);
        suite.addTestSuite(EventManagerAccuracyTestCase.class);

        return suite;
    }
}
