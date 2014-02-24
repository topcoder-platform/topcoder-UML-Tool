/*
 * Copyright (C) 2006 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.uml.model.core.classifiers.failuretests;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;


/**
 * <p>
 * This test case aggregates all Failure test cases.
 * </p>
 *
 * @author Xuchen
 * @version 1.0
 */
public class FailureTests extends TestCase {
    /**
     * Aggregate all failure test cases.
     *
     * @return Test instance.
     */
    public static Test suite() {
        final TestSuite suite = new TestSuite();

        suite.addTestSuite(EnumerationImplFailureTests.class);

        return suite;
    }
}
