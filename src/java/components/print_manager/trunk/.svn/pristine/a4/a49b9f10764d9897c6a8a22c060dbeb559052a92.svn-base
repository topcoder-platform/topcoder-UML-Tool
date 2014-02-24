/*
 * Copyright (C) 2007 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.swing.print.accuracytests;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

/**
 * <p>
 * This class aggregates all accuracy tests for the component Print Manager. The version tested is 1.0.
 * </p>
 * 
 * @author ch_music
 * @version 1.0
 */
public class AccuracyTests extends TestCase {

    public static Test suite() {
        final TestSuite suite = new TestSuite();

        suite.addTest(new TestSuite(AbstractPrintAccuracyTests.class));
        suite.addTest(new TestSuite(ConfigurationExceptionAccuracyTests.class));
        suite.addTest(new TestSuite(PrintFormatRetrieveExceptionAccuracyTests.class));
        suite.addTest(new TestSuite(PrintingExceptionAccuracyTests.class));
        suite.addTest(new TestSuite(PrintManagerAccuracyTests.class));

        suite.addTest(new TestSuite(DefaultComponentVisibleMakerAccuracyTests.class));
        suite.addTest(new TestSuite(DefaultPrintFormatRetrieverAccuracyTests.class));
        
        suite.addTest(new TestSuite(OverallPrintingAccuracyTests.class));

        return suite;
    }
}
