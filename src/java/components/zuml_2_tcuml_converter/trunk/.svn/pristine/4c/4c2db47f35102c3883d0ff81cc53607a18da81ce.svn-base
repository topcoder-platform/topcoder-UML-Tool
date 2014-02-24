/*
 * Copyright (C) 2007 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.umltool.xmiconverters.poseidon5.accuracytests;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

/**
 * <p>This test case aggregates all Accuracy test cases.</p>
 *
 * @author abram
 * @version 1.0
 */
public class AccuracyTests extends TestCase {

    /**
     * Accuracy Test-suite.
     *
     * @return the Accuracy Test-suite
     */
    public static Test suite() {
        final TestSuite suite = new TestSuite();

        // main class
        suite.addTest(XMIConvertersUtilAccuracyTest.suite());
        suite.addTest(DefaultXMIConverterAccuracyTest.suite());
        suite.addTest(XMIConverterHandlerAccuracyTest.suite());
        suite.addTest(DefaultXMIConverterChainAccuracyTest.suite());

        // converter class
        suite.addTest(DiagramSizeConverterAccuracyTest.suite());
        suite.addTest(DiagramTitleConverterAccuracyTest.suite());
        suite.addTest(GraphPropertiesConverterAccuracyTest.suite());
        suite.addTest(RenameConverterAccuracyTest.suite());
        suite.addTest(IgnoreOperationInMethodConverterAccuracyTest.suite());

        // handler class
        suite.addTest(ZUMLHeaderHandlerAccuracyTest.suite());
        suite.addTest(ZUMLMethodHandlerAccuracyTest.suite());

        // property transformer class
        suite.addTest(RegexToLowerPropertyValueTransformerAccuracyTest.suite());

        // exception class
        suite.addTest(XMIConverterConfigurationExceptionAccuracyTest.suite());
        suite.addTest(UnsupportedVersionExceptionAccuracyTest.suite());


        return suite;
    }

}
