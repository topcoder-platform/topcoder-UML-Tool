/*
 * Copyright (C) 2007 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.gui.diagramviewer.uml.activityelements.failuretests;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

/**
 * <p>
 * This test case aggregates all Failure test cases.
 * </p>
 * @author FireIce
 * @version 1.0
 */
public class FailureTests extends TestCase {

    /**
     * <p>
     * Aggregates all failure tests.
     * </p>
     * @return test suite aggregating all failure tests.
     */
    public static Test suite() {
        final TestSuite suite = new TestSuite();

        suite.addTestSuite(AcceptEventActionFailureTests.class);
        suite.addTestSuite(ActionStateFailureTests.class);
        suite.addTestSuite(BaseNodeFailureTests.class);
        suite.addTestSuite(BoundaryChangedEventFailureTests.class);
        suite.addTestSuite(DecisionNodeFailureTests.class);
        suite.addTestSuite(EllipseConnectorFailureTests.class);
        suite.addTestSuite(FinalNodeFailureTests.class);
        suite.addTestSuite(FlowFinalNodeFailureTests.class);
        suite.addTestSuite(ForkNodeFailureTests.class);
        suite.addTestSuite(InitalNodeFailureTests.class);
        suite.addTestSuite(JoinNodeFailureTests.class);
        suite.addTestSuite(MergeNodeFailureTests.class);
        suite.addTestSuite(ObjectFlowNodeFailureTests.class);
        suite.addTestSuite(RectangleConnectorFailureTests.class);
        suite.addTestSuite(SendSignalActionFailureTests.class);
        suite.addTestSuite(SimpleArrowEdgeEndingFailureTests.class);
        suite.addTestSuite(TextChangedEventFailureTests.class);
        suite.addTestSuite(TextFieldFailureTests.class);
        suite.addTestSuite(TextInputListenerFailureTests.class);
        suite.addTestSuite(TextInputTriggerFailureTests.class);
        suite.addTestSuite(TransitionFailureTests.class);
        return suite;
    }

}
