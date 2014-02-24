/*
 * Copyright (C) 2006 TopCoder Inc., All Rights Reserved.
 *
 * TCS UML Model - Core Dependencies Version 1.0
 *
 * @ UnitTests.java
 */
package com.topcoder.uml.model.core.dependencies;

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
        suite.addTestSuite(UsageImplTests.class);
        suite.addTestSuite(AbstractionImplTests.class);
        suite.addTestSuite(BindingImplTests.class);
        suite.addTestSuite(DependencyImplTests.class);
        suite.addTestSuite(CoreDependenciesHelperTest.class);
        suite.addTestSuite(Demo.class);
        return suite;
    }

}
