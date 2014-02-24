/*
 * Copyright (C) 2006 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.uml.actions.model.activity;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

/**
 * <p>This test case aggregates all Unit test cases.</p>
 *
 * @author TCSDEVELOPER
 * @version 1.0
 */
public class UnitTests extends TestCase {

    /**
     * <p>
     * This test case aggregates all Unit test cases.
     * </p>
     *
     * @return all Unit test cases.
     */
    public static Test suite() {
        final TestSuite suite = new TestSuite();

        suite.addTest(RemoveMergeNodeActionTests.suite());
        suite.addTest(CopySendSignalActionActionTests.suite());
        suite.addTest(RemoveJoinNodeActionTests.suite());
        suite.addTest(PasteStateNodeAbstractActionTests.suite());
        suite.addTest(UtilTests.suite());
        suite.addTest(RemoveSendSignalActionActionTests.suite());
        suite.addTest(AddMergeNodeActionTests.suite());
        suite.addTest(PasteMergeNodeActionTests.suite());
        suite.addTest(ActivityObjectCloneExceptionTests.suite());
        suite.addTest(PasteForkNodeActionTests.suite());
        suite.addTest(RemoveStateNodeAbstractActionTests.suite());
        suite.addTest(PasteSendSignalActionActionTests.suite());
        suite.addTest(ActivityObjectClipboardUtilityTests.suite());
        suite.addTest(CopyInitialNodeActionTests.suite());
        suite.addTest(CutSendSignalActionActionTests.suite());
        suite.addTest(CutFlowFinalNodeActionTests.suite());
        suite.addTest(PasteInitialNodeActionTests.suite());
        suite.addTest(ActivityObjectCloneUtilityTests.suite());
        suite.addTest(PasteFinalNodeActionTests.suite());
        suite.addTest(CopyJoinNodeActionTests.suite());
        suite.addTest(RemoveTransitionActionTests.suite());
        suite.addTest(CopyObjectFlowStateActionTests.suite());
        suite.addTest(CutDecisionNodeActionTests.suite());
        suite.addTest(CopyForkNodeActionTests.suite());
        suite.addTest(CopyDecisionNodeActionTests.suite());
        suite.addTest(RemoveInitialNodeActionTests.suite());
        suite.addTest(RemoveActionStateActionTests.suite());
        suite.addTest(CutActionStateActionTests.suite());
        suite.addTest(CutTransitionActionTests.suite());
        suite.addTest(CutFinalNodeActionTests.suite());
        suite.addTest(CutMergeNodeActionTests.suite());
        suite.addTest(AddStateNodeAbstractActionTests.suite());
        suite.addTest(PasteActionStateActionTests.suite());
        suite.addTest(CutJoinNodeActionTests.suite());
        suite.addTest(CutObjectFlowStateActionTests.suite());
        suite.addTest(AddJoinNodeActionTests.suite());
        suite.addTest(CopyAcceptEventActionActionTests.suite());
        suite.addTest(PasteJoinNodeActionTests.suite());
        suite.addTest(AddInitialNodeActionTests.suite());
        suite.addTest(AddSendSignalActionActionTests.suite());
        suite.addTest(AddFinalNodeActionTests.suite());
        suite.addTest(PasteFlowFinalNodeActionTests.suite());
        suite.addTest(CopyFlowFinalNodeActionTests.suite());
        suite.addTest(PasteTransitionActionTests.suite());
        suite.addTest(ActivityDataFlavorTests.suite());
        suite.addTest(AddDecisionNodeActionTests.suite());
        suite.addTest(RemoveObjectFlowStateActionTests.suite());
        suite.addTest(RemoveForkNodeActionTests.suite());
        suite.addTest(AddForkNodeActionTests.suite());
        suite.addTest(ActivityObjectSelectionTests.suite());
        suite.addTest(CutAcceptEventActionActionTests.suite());
        suite.addTest(RemoveFinalNodeActionTests.suite());
        suite.addTest(CutInitialNodeActionTests.suite());
        suite.addTest(CopyTransitionActionTests.suite());
        suite.addTest(CopyFinalNodeActionTests.suite());
        suite.addTest(CutForkNodeActionTests.suite());
        suite.addTest(CutStateNodeAbstractActionTests.suite());
        suite.addTest(CopyMergeNodeActionTests.suite());
        suite.addTest(AddObjectFlowStateActionTests.suite());
        suite.addTest(CopyStateNodeAbstractActionTests.suite());
        suite.addTest(PasteAcceptEventActionActionTests.suite());
        suite.addTest(PasteObjectFlowStateActionTests.suite());
        suite.addTest(AddActionStateActionTests.suite());
        suite.addTest(AbstractActivityUndoableActionTests.suite());
        suite.addTest(AddFlowFinalNodeActionTests.suite());
        suite.addTest(CopyActionStateActionTests.suite());
        suite.addTest(AddTransitionActionTests.suite());
        suite.addTest(PasteDecisionNodeActionTests.suite());
        suite.addTest(AddAcceptEventActionActionTests.suite());
        suite.addTest(RemoveFlowFinalNodeActionTests.suite());
        suite.addTest(RemoveAcceptEventActionActionTests.suite());
        suite.addTest(RemoveDecisionNodeActionTests.suite());

        suite.addTest(DemoTests.suite());

        return suite;
    }

}
