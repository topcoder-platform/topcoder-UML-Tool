/*
 * Copyright (C) 2006 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.uml.actions.model.activity.accuracytests;

import java.awt.datatransfer.Clipboard;

import junit.framework.TestCase;

import com.topcoder.uml.actions.model.activity.CopyAcceptEventActionAction;
import com.topcoder.uml.actions.model.activity.CopyActionStateAction;
import com.topcoder.uml.actions.model.activity.CopyDecisionNodeAction;
import com.topcoder.uml.actions.model.activity.CopyFinalNodeAction;
import com.topcoder.uml.actions.model.activity.CopyFlowFinalNodeAction;
import com.topcoder.uml.actions.model.activity.CopyForkNodeAction;
import com.topcoder.uml.actions.model.activity.CopyInitialNodeAction;
import com.topcoder.uml.actions.model.activity.CopyJoinNodeAction;
import com.topcoder.uml.actions.model.activity.CopyMergeNodeAction;
import com.topcoder.uml.actions.model.activity.CopyObjectFlowStateAction;
import com.topcoder.uml.actions.model.activity.CopySendSignalActionAction;

/**
 * This class aggregates accuracy tests for all of the implementation classes of CopyStateNodeAbstractAction.
 *
 * @author ch_music
 * @version 1.0
 */
public class CopyStateNodeAbstractActionImplementationsAccuracyTests extends TestCase {

    /**
     * The clipboard to be used for testing purposes.
     */
    private Clipboard clipboard = new Clipboard("test");

    /**
     * Tests CopyAcceptEventActionAction constructor.
     */
    public void testCopyAcceptEventActionAction1() {
        assertNotNull("Constructor fails to create instance.", new CopyAcceptEventActionAction(AccuracyTestHelper
                .createAcceptEventAction(), null));
    }

    /**
     * Tests CopyAcceptEventActionAction constructor.
     */
    public void testCopyAcceptEventActionAction2() {
        assertNotNull("Constructor fails to create instance.", new CopyAcceptEventActionAction(AccuracyTestHelper
                .createAcceptEventAction(), clipboard));
    }

    /**
     * Tests CopyActionStateAction constructor.
     */
    public void testCopyActionStateAction1() {
        assertNotNull("Constructor fails to create instance.", new CopyActionStateAction(AccuracyTestHelper
                .createActionState(), null));
    }

    /**
     * Tests CopyActionStateAction constructor.
     */
    public void testCopyActionStateAction2() {
        assertNotNull("Constructor fails to create instance.", new CopyActionStateAction(AccuracyTestHelper
                .createActionState(), clipboard));
    }

    /**
     * Tests CopyDecisionNodeAction constructor.
     */
    public void testCopyDecisionNodeAction1() {
        assertNotNull("Constructor fails to create instance.", new CopyDecisionNodeAction(AccuracyTestHelper
                .createDecisionNode(), null));
    }

    /**
     * Tests CopyDecisionNodeAction constructor.
     */
    public void testCopyDecisionNodeAction2() {
        assertNotNull("Constructor fails to create instance.", new CopyDecisionNodeAction(AccuracyTestHelper
                .createDecisionNode(), clipboard));
    }

    /**
     * Tests CopyFinalNodeAction constructor.
     */
    public void testCopyFinalNodeAction1() {
        assertNotNull("Constructor fails to create instance.", new CopyFinalNodeAction(AccuracyTestHelper
                .createFinalNode(), null));
    }

    /**
     * Tests CopyFinalNodeAction constructor.
     */
    public void testCopyFinalNodeAction2() {
        assertNotNull("Constructor fails to create instance.", new CopyFinalNodeAction(AccuracyTestHelper
                .createFinalNode(), clipboard));
    }

    /**
     * Tests CopyFlowFinalNodeAction constructor.
     */
    public void testCopyFlowFinalNodeAction1() {
        assertNotNull("Constructor fails to create instance.", new CopyFlowFinalNodeAction(AccuracyTestHelper
                .createFlowFinalNode(), null));
    }

    /**
     * Tests CopyFlowFinalNodeAction constructor.
     */
    public void testCopyFlowFinalNodeAction2() {
        assertNotNull("Constructor fails to create instance.", new CopyFlowFinalNodeAction(AccuracyTestHelper
                .createFlowFinalNode(), clipboard));
    }

    /**
     * Tests CopyForkNodeAction constructor.
     */
    public void testCopyForkNodeAction1() {
        assertNotNull("Constructor fails to create instance.", new CopyForkNodeAction(AccuracyTestHelper
                .createForkNode(), null));
    }

    /**
     * Tests CopyForkNodeAction constructor.
     */
    public void testCopyForkNodeAction2() {
        assertNotNull("Constructor fails to create instance.", new CopyForkNodeAction(AccuracyTestHelper
                .createForkNode(), clipboard));
    }

    /**
     * Tests CopyInitialNodeAction constructor.
     */
    public void testCopyInitialNodeAction1() {
        assertNotNull("Constructor fails to create instance.", new CopyInitialNodeAction(AccuracyTestHelper
                .createInitialNode(), null));
    }

    /**
     * Tests CopyInitialNodeAction constructor.
     */
    public void testCopyInitialNodeAction2() {
        assertNotNull("Constructor fails to create instance.", new CopyInitialNodeAction(AccuracyTestHelper
                .createInitialNode(), clipboard));
    }

    /**
     * Tests CopyJoinNodeAction constructor.
     */
    public void testCopyJoinNodeAction1() {
        assertNotNull("Constructor fails to create instance.", new CopyJoinNodeAction(AccuracyTestHelper
                .createJoinNode(), null));
    }

    /**
     * Tests CopyJoinNodeAction constructor.
     */
    public void testCopyJoinNodeAction2() {
        assertNotNull("Constructor fails to create instance.", new CopyJoinNodeAction(AccuracyTestHelper
                .createJoinNode(), clipboard));
    }

    /**
     * Tests CopyMergeNodeAction constructor.
     */
    public void testCopyMergeNodeAction1() {
        assertNotNull("Constructor fails to create instance.", new CopyMergeNodeAction(AccuracyTestHelper
                .createMergeNode(), null));
    }

    /**
     * Tests CopyFinalNodeAction constructor.
     */
    public void testCopyMergeNodeAction2() {
        assertNotNull("Constructor fails to create instance.", new CopyMergeNodeAction(AccuracyTestHelper
                .createMergeNode(), clipboard));
    }

    /**
     * Tests CopyObjectFlowStateAction constructor.
     */
    public void testCopyObjectFlowStateAction1() {
        assertNotNull("Constructor fails to create instance.", new CopyObjectFlowStateAction(AccuracyTestHelper
                .createObjectFlowState(), null));
    }

    /**
     * Tests CopyFinalNodeAction constructor.
     */
    public void testCopyObjectFlowStateAction2() {
        assertNotNull("Constructor fails to create instance.", new CopyObjectFlowStateAction(AccuracyTestHelper
                .createObjectFlowState(), clipboard));
    }

    /**
     * Tests CopySendSignalActionAction constructor.
     */
    public void testCopySendSignalActionAction1() {
        assertNotNull("Constructor fails to create instance.", new CopySendSignalActionAction(AccuracyTestHelper
                .createSendSignalAction(), null));
    }

    /**
     * Tests CopyFinalNodeAction constructor.
     */
    public void testCopySendSignalActionAction2() {
        assertNotNull("Constructor fails to create instance.", new CopySendSignalActionAction(AccuracyTestHelper
                .createSendSignalAction(), clipboard));
    }
}
