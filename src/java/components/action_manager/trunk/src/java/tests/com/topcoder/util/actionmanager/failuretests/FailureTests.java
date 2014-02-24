/**
 *
 * Copyright (c) 2006, TopCoder, Inc. All rights reserved
 */
 package com.topcoder.util.actionmanager.failuretests;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

/**
 * <p>This test case aggregates all Failure test cases.</p>
 *
 * @author TopCoder
 * @version 1.0
 */
public class FailureTests extends TestCase {

    /**
     * Aggregates all Failure test cases.
     * @return Test
     */
    public static Test suite() {
        final TestSuite suite = new TestSuite();

        suite.addTestSuite(FailureTestTransientUndoableAction.class);
        suite.addTestSuite(FailureTestCompoundUndoableAction.class);
        suite.addTestSuite(FailureTestActionManager.class);
        return suite;
    }

}
