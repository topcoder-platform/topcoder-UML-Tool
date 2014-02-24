/*
 * Copyright (C) 2006 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.uml.model.core.classifiers.accuracytests;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;


/**
 * <p>This test case aggregates all accuracy test cases.</p>
 *
 * @author icyriver
 * @version 1.0
 */
public class AccuracyTests extends TestCase {
    /**
     * <p>Initialize the AccuracyTests to test.</p>
     *
     * @return a TestSuite for AccuracyTests.
     */
    public static Test suite() {
        final TestSuite suite = new TestSuite();

        // add all classes accuracy tests here.
        suite.addTest(ClassImplAccuracyTest.suite());
        suite.addTest(DataTypeImplAccuracyTest.suite());
        suite.addTest(InterfaceImplAccuracyTest.suite());
        suite.addTest(PrimitiveImplAccuracyTest.suite());
        suite.addTest(ProgrammingLanguageDataTypeImplAccuracyTest.suite());
        suite.addTest(EnumerationImplAccuracyTest.suite());
        suite.addTest(EnumerationLiteralImplAccuracyTest.suite());

        return suite;
    }
}
