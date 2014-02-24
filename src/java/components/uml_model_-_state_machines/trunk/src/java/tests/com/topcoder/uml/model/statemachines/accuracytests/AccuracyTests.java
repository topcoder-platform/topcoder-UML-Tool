/**
 *
 * Copyright (c) 2006, TopCoder, Inc. All rights reserved
 */
package com.topcoder.uml.model.statemachines.accuracytests;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

/**
 * <p>This test case aggregates all Accuracy test cases.</p>
 *
 * @author TopCoder
 * @version 1.0
 */
public class AccuracyTests extends TestCase {

    public static Test suite() {
        final TestSuite suite = new TestSuite();
        suite.addTestSuite(AbstractStateImplAccuracyTests.class);
        suite.addTestSuite(CompositeStateImplAccuracyTests.class);
        suite.addTestSuite(FinalStateImplAccuracyTests.class);
        suite.addTestSuite(GuardImplAccuracyTests.class);
        suite.addTestSuite(PseudostateImplAccuracyTests.class);
        suite.addTestSuite(SimpleStateImplAccuracyTests.class);
        suite.addTestSuite(StateMachineImplAccuracyTests.class);
        suite.addTestSuite(StateVertexAbstractImplAccuracyTests.class);
        suite.addTestSuite(TransitionImplAcuracyTests.class);
        return suite;
    }

}
