/**
 *
 * Copyright (c) 2007, TopCoder, Inc. All rights reserved
 */
 package com.topcoder.gui.diagramviewer.uml.usecaseelements.failuretests;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

/**
 * <p>This test case aggregates all Failure test cases.</p>
 *
 * @author wiedzmin
 * @version 1.0
 */
public class FailureTests extends TestCase {

    public static Test suite() {
        final TestSuite suite = new TestSuite();
        suite.addTestSuite(ActorConnectorFailureTest.class);
        suite.addTestSuite(ActorNodeFailureTest.class);
        suite.addTestSuite(BaseEdgeFailureTest.class);
        suite.addTestSuite(BaseNodeFailureTest.class);
        suite.addTestSuite(BoundaryChangedEventFailureTest.class);
        suite.addTestSuite(EdgeAddEventFailureTest.class);
        suite.addTestSuite(EditBoxListenerFailureTest.class);
        suite.addTestSuite(EditBoxTriggerFailureTest.class);
        suite.addTestSuite(ExtendEdgeFailureTest.class);
        suite.addTestSuite(IncludeEdgeFailureTest.class);
        suite.addTestSuite(NodeAddEventFailureTest.class);
        suite.addTestSuite(SubsystemNodeContainerFailureTest.class);
        suite.addTestSuite(TextChangeEventFailureTest.class);
        suite.addTestSuite(TextFieldFailureTest.class);
        suite.addTestSuite(UseCaseConnectorFailureTest.class);
        suite.addTestSuite(UseCaseNodeFailureTest.class);
        return suite;
    }

}
