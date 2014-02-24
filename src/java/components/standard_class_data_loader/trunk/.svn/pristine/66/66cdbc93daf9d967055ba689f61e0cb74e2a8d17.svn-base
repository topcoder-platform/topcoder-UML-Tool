/*
 * Copyright (C) 2007 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.uml.standardclassloader.accuracytests;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

/**
 * <p>
 * This test case aggregates all Accuracy test cases.
 * </p>
 * @author FireIce
 * @version 1.0
 */
public class AccuracyTests extends TestCase {

    /**
     * <p>
     * Aggregates all tests in this class.
     * </p>
     * @return test suite aggregating all tests.
     */
    public static Test suite() {
        final TestSuite suite = new TestSuite();
        suite.addTestSuite(ClassDataLoaderConfigurationExceptionAccuracyTests.class);
        suite.addTestSuite(UnknownLanguageExceptionAccuracyTests.class);
        suite.addTestSuite(ClassDataLoaderStrategyAccuracyTests.class);
        suite.addTestSuite(XMLLanguageClassDataLoaderAccuracyTests.class);
        return suite;
    }

}
