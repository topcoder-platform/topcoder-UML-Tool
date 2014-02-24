/*
 * Copyright (C) 2007 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.umltool.xmiconverters.poseidon5.accuracytests;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;


/**
 * <p>This test case aggregates all accuracy test cases.</p>
 *
 * @author KLW
 * @author bbskill
 * @version 1.0
 * @version 1.1
 */
public class AccuracyTests extends TestCase {
    /**
     * <p>Returns the suite of all accuracy test cases.</p>
     *
     * @return the suite of all accuracy test cases
     */
    public static Test suite() {
        final TestSuite suite = new TestSuite();
        suite.addTestSuite(ZUMLActivityDiagramImplAccuracyTests.class);
        suite.addTestSuite(ActivityDiagramConversionFacadeAccuracyTests.class);
        return suite;
    }
}
