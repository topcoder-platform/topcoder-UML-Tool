/*
 * Copyright (C) 2006 TopCoder Inc., All Rights Reserved.
 *
 * TCS UML Model - Collaborations Version 1.0
 *
 * @ UnitTests.java
 */
package com.topcoder.uml.model.collaborations;

import com.topcoder.uml.model.collaborations.collaborationinstances.CollaborationInstanceSetImplTest;
import com.topcoder.uml.model.collaborations.collaborationinstances.CollaborationsHelperTest;
import com.topcoder.uml.model.collaborations.collaborationinteractions.CollaborationImplTest;
import com.topcoder.uml.model.collaborations.collaborationroles.MessageImplTest;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

/**
 * <p>This test case aggregates all Unit test cases.</p>
 *
 * @author yinzi
 * @version 1.0
 */
public class UnitTests extends TestCase {
    /**
     * Return the test suite for unit tests.
     *
     * @return The test suite for unit tests
     */
    public static Test suite() {
        final TestSuite suite = new TestSuite();
        // Test each class
        suite.addTestSuite(MessageImplTest.class);
        suite.addTestSuite(CollaborationInstanceSetImplTest.class);
        suite.addTestSuite(CollaborationImplTest.class);
        suite.addTestSuite(CollaborationsHelperTest.class);
        suite.addTestSuite(Demo.class);
        return suite;
    }

}
