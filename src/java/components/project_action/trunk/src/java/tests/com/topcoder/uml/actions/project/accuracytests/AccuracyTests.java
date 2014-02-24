/*
 * Copyright (C) 2006 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.uml.actions.project.accuracytests;

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
     * Aggregates all tests.
     * </p>
     * @return test suite aggregating all tests.
     */
    public static Test suite() {
        final TestSuite suite = new TestSuite();
        suite.addTestSuite(CreateNewProjectActionAccuracyTests.class);
        suite.addTestSuite(ExportDiagramToImageActionAccuracyTests.class);
        suite.addTestSuite(ExportToXMIFileActionAccuracyTests.class);
        suite.addTestSuite(GenerateCodeActionAccuracyTests.class);
        suite.addTestSuite(LoadTCUMLFileActionAccuracyTests.class);
        suite.addTestSuite(LoadXMIFileActionAccuracyTests.class);
        suite.addTestSuite(PrintDiagramActionAccuracyTests.class);
        suite.addTestSuite(SaveTCUMLFileActionAccuracyTests.class);
        return suite;
    }

}
