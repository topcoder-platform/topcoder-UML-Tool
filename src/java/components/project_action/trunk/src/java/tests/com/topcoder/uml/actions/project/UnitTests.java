/*
 * Copyright (C) 2006 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.uml.actions.project;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

/**
 * <p>
 * This test case aggregates all Unit test cases.
 * </p>
 *
 * @author TCSDEVELOPER
 * @version 1.0
 */
public class UnitTests extends TestCase {

    /**
     * <p>
     * This method aggregates all Unit test cases.
     * </p>
     *
     * @return Aggregated unit test cases.
     */
    public static Test suite() {
        final TestSuite suite = new TestSuite();
        suite.addTest(CreateNewProjectActionUnitTest.suite());
        suite.addTest(ExportDiagramToImageActionUnitTest.suite());
        suite.addTest(ExportDiagramToImageActionUnitTest1.suite());
        suite.addTest(ExportToXMIFileActionUnitTest.suite());
        suite.addTest(GenerateCodeActionUnitTest.suite());
        suite.addTest(HelperUnitTest.suite());
        suite.addTest(LoadTCUMLFileActionUnitTest.suite());
        suite.addTest(LoadXMIFileActionUnitTest.suite());
        suite.addTest(PrintDiagramActionUnitTest.suite());
        suite.addTest(SaveTCUMLFileActionUnitTest.suite());
        suite.addTest(Demo.suite());
        return suite;
    }

}
