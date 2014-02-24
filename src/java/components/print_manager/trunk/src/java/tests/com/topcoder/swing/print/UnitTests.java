/**
 *
 * Copyright (c) 2006, TopCoder, Inc. All rights reserved
 */
package com.topcoder.swing.print;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

import com.topcoder.swing.print.impl.DefaultComponentVisibleMakerTest;
import com.topcoder.swing.print.impl.DefaultPrintFormatRetrieverTest;

/**
 * <p>This test case aggregates all Unit test cases.</p>
 *
 * @author TopCoder
 * @version 1.0
 */
public class UnitTests extends TestCase {

    public static Test suite() {
        final TestSuite suite = new TestSuite();
        suite.addTestSuite(ConfigurationExceptionTest.class);
        suite.addTestSuite(PrintFormatRetrieveExceptionTest.class);
        suite.addTestSuite(PrintingExceptionTest.class);
        suite.addTestSuite(AbstractPrintTest.class);
        suite.addTestSuite(ScalingPrintTest.class);
        suite.addTestSuite(FitInPagePrintTest.class);
        suite.addTestSuite(PrintManagerTest.class);
        suite.addTestSuite(DefaultComponentVisibleMakerTest.class);
        suite.addTestSuite(DefaultPrintFormatRetrieverTest.class);
        suite.addTestSuite(ParameterCheckTest.class);
        return suite;
    }

}
