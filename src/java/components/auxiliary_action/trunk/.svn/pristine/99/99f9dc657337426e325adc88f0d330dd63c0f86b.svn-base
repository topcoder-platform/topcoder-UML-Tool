/*
 * Copyright (C) 2007 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.uml.actions.auxiliary.stresstests;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;
import junit.framework.TestResult;

/**
 * <p>
 * This test case aggregates all Stress test cases.
 * </p>
 *
 * @author Achilles_2005
 * @version 1.0
 */
public class StressTests extends TestCase {
    /**
     * <p>
     * Aggregates all stress tests.
     * </p>
     * @return stress tests.
     */
    public static Test suite() {
        final TestSuite suite = new TestSuite();
        suite.addTestSuite(ChangeCommentTextActionStressTests.class);
        suite.addTestSuite(CommentActionsStressTests.class);
        suite.addTestSuite(CommentGraphNodeActionsStressTests.class);
        suite.addTestSuite(CommentRelationshipGraphEdgeActionsStressTests.class);
        suite.addTestSuite(FreeTextGraphNodeActionsStressTests.class);
        suite.addTestSuite(NoteRelationshipActionsStressTests.class);
        suite.addTestSuite(PolylineGraphNodeActionsStressTests.class);
        return suite;
    }
}
