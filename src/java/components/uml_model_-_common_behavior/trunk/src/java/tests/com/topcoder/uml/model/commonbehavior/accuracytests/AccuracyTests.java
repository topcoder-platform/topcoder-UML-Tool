/*
 * Copyright (C) 2006 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.uml.model.commonbehavior.accuracytests;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

/**
 * <p>
 * This test case aggregates all Accuracy test cases.
 * </p>
 *
 * @author iamajia
 * @version 1.0
 */
public class AccuracyTests extends TestCase {
    /**
     * Aggregates all tests in this class.
     *
     * @return Test suite aggregating all tests.
     */
    public static Test suite() {
        final TestSuite suite = new TestSuite();
        suite.addTestSuite(InstanceAbstractImplAccuracyTest.class);
        suite.addTestSuite(LinkEndImplAccuracyTest.class);
        suite.addTestSuite(LinkImplAccuracyTest.class);
        suite.addTestSuite(ObjectImplAccuracyTest.class);
        suite.addTestSuite(ProcedureImplAccuracyTest.class);
        suite.addTestSuite(StimulusImplAccuracyTest.class);
        return suite;
    }

}
