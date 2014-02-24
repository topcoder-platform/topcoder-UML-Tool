/*
 * Copyright (C) 2007 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.umltool.deploy.elements;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

/**
 * <p>
 * This test case aggregates all Element test cases.
 * </p>
 * @author ly
 * @version 1.0
 */
public class ElementTests extends TestCase {

    /**
     * <p>
     * Aggregates all unit test cases.
     * </p>
     * @return the aggregated unit test cases
     */
    public static Test suite() {
        final TestSuite suite = new TestSuite();
        suite.addTestSuite(ClassNodeTest.class);
        suite.addTestSuite(InterfaceNodeTest.class);
        suite.addTestSuite(ExceptionNodeTest.class);
        suite.addTestSuite(PackageNodeTest.class);

        suite.addTestSuite(ActorNodeTest.class);
        suite.addTestSuite(UseCaseNodeTest.class);
        suite.addTestSuite(SubsystemNodeContainerTest.class);

        suite.addTestSuite(ObjectNodeTest.class);

        suite.addTestSuite(ActionStateTest.class);
        suite.addTestSuite(SendSignalActionTest.class);
        suite.addTestSuite(AcceptEventActionTest.class);
        suite.addTestSuite(ObjectFlowNodeTest.class);
        suite.addTestSuite(InitialNodeTest.class);
        suite.addTestSuite(FinalNodeTest.class);
        suite.addTestSuite(FlowFinalNodeTest.class);
        suite.addTestSuite(DecisionNodeTest.class);
        suite.addTestSuite(MergeNodeTest.class);
        suite.addTestSuite(ForkNodeTest.class);
        suite.addTestSuite(JoinNodeTest.class);

        suite.addTestSuite(CommentNodeTest.class);
        suite.addTestSuite(FreeTextNodeTest.class);
        suite.addTestSuite(PolylineNodeTest.class);

        suite.addTestSuite(GeneralizationEdgeTest.class);
        suite.addTestSuite(DependencyEdgeTest.class);
        suite.addTestSuite(AbstractionEdgeTest.class);
        suite.addTestSuite(AssociationEdgeTest.class);

        suite.addTestSuite(IncludeEdgeTest.class);
        suite.addTestSuite(ExtendEdgeTest.class);

        suite.addTestSuite(SynchronousMessageEdgeTest.class);
        suite.addTestSuite(CreateMessageEdgeTest.class);
        suite.addTestSuite(SendSignalMessageEdgeTest.class);
        suite.addTestSuite(AsynchronousMessageEdgeTest.class);
        suite.addTestSuite(ReturnMessageEdgeTest.class);

        suite.addTestSuite(TransitionTest.class);

        suite.addTestSuite(ClassDiagramTest.class);
        suite.addTestSuite(UseCaseDiagramTest.class);
        suite.addTestSuite(SequenceDiagramTest.class);
        suite.addTestSuite(ActivityDiagramTest.class);

        return suite;
    }

}
