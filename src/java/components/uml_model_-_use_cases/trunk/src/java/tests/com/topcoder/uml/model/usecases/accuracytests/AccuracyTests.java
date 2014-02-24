/*
 * Copyright (C) 2006 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.uml.model.usecases.accuracytests;

import com.topcoder.uml.model.usecases.UseCaseImplTestAccuracy;
import com.topcoder.uml.model.usecases.UseCaseRelationshipAbstractImplTestAccuracy;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;
import junit.framework.TestResult;

/**
 * <p>This test case aggregates all Accuracy test cases.</p>
 *
 * @author radium
 * @version 1.0
 */
public class AccuracyTests extends TestCase {

    public static Test suite() {
        final TestSuite suite = new TestSuite();
        suite.addTestSuite(ActorImplTestAccuracy.class);
        suite.addTestSuite(ExtendImplTestAccuracy.class);
        suite.addTestSuite(IncludeImplTestAccuracy.class);
        suite.addTestSuite(UseCaseRelationshipAbstractImplTestAccuracy.class);
        suite.addTestSuite(UseCaseImplTestAccuracy.class);

        return suite;
    }

}
