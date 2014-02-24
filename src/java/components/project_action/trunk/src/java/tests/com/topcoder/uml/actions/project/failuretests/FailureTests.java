/**
 *
 * Copyright (c) 2006, TopCoder, Inc. All rights reserved
 */
 package com.topcoder.uml.actions.project.failuretests;

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

    public static Test suite() {
        final TestSuite suite = new TestSuite();
        
        suite.addTestSuite(CreateNewProjectActionFailureTest.class);
        suite.addTestSuite(ExportDiagramToImageActionFailureTest.class);
        suite.addTestSuite(ExportToXMIFileActionFailureTest.class);
        suite.addTestSuite(GenerateCodeActionFailureTest.class);
        suite.addTestSuite(LoadTCUMLFileActionFailureTest.class);
        suite.addTestSuite(LoadXMIFileActionFailureTest.class);
        suite.addTestSuite(PrintDiagramActionFailureTest.class);
        suite.addTestSuite(SaveTCUMLFileActionFailureTest.class);
        return suite;
    }

}
