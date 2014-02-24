/**
 *
 * Copyright (c) 2006, TopCoder, Inc. All rights reserved
 */
package com.topcoder.swing.imageexporter;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

/**
 * <p>This test case aggregates all Unit test cases.</p>
 *
 * @author TopCoder
 * @version 1.0
 */
public class UnitTests extends TestCase {

    public static Test suite() {
        final TestSuite suite = new TestSuite();
        suite.addTestSuite(Demo.class);

        suite.addTestSuite(ImageExporterConfigurationExceptionTest.class);
        suite.addTestSuite(ImageExporterExceptionTest.class);
        suite.addTestSuite(JComponentVisibleMakerExceptionTest.class);
        suite.addTestSuite(ConfigHelperTest.class);
        suite.addTestSuite(DefaultVisibleMakerTest.class);
        suite.addTestSuite(ImageManipulationImageExporterExportTest.class);
        suite.addTestSuite(ImageManipulationImageExporterTest.class);
        suite.addTestSuite(ImageExporterExportTest.class);
        suite.addTestSuite(ImageExporterConfigTest.class);
        suite.addTestSuite(ParameterCheckTest.class);
        return suite;
    }

}
