/*
 * Copyright (C) 2006 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.uml.actions.model.activity.accuracytests;

import java.awt.datatransfer.Clipboard;

import junit.framework.TestCase;

import com.topcoder.uml.actions.model.activity.CutAcceptEventActionAction;
import com.topcoder.uml.actions.model.activity.CutActionStateAction;
import com.topcoder.uml.actions.model.activity.CutDecisionNodeAction;
import com.topcoder.uml.actions.model.activity.CutFinalNodeAction;
import com.topcoder.uml.actions.model.activity.CutFlowFinalNodeAction;
import com.topcoder.uml.actions.model.activity.CutForkNodeAction;
import com.topcoder.uml.actions.model.activity.CutInitialNodeAction;
import com.topcoder.uml.actions.model.activity.CutJoinNodeAction;
import com.topcoder.uml.actions.model.activity.CutMergeNodeAction;
import com.topcoder.uml.actions.model.activity.CutObjectFlowStateAction;
import com.topcoder.uml.actions.model.activity.CutSendSignalActionAction;
import com.topcoder.uml.actions.model.activity.CutStateNodeAbstractAction;

/**
 * This class aggregates accuracy tests for all the concrete implementation classes of CutStateNodeAbstractAction
 * abstract class.
 *
 * @author ch_music
 * @version 1.0
 */
public class CutStateNodeAbstractActionImplementationsAccuracyTests extends TestCase {

    /**
     * A placeholder for the implementation class instance to be tested.
     */
    public CutStateNodeAbstractAction test;

    /**
     * The clipboard to be used for testing purposes.
     */
    private Clipboard clipboard = new Clipboard("test");

    /**
     * Sets up the environment.
     *
     * @throws Exception to JUnit
     */
    public void setUp() throws Exception {
        AccuracyTestHelper.loadConfig(AccuracyTestHelper.LOG_NAMESPACE, AccuracyTestHelper.LOG_CONFIGPATH);
    }

    /**
     * Tears down the environment.
     *
     * @throws Exception to JUnit
     */
    protected void tearDown() throws Exception {
        AccuracyTestHelper.tearConfig();
    }

    /**
     * Tests CutAcceptEventActionAction constructor.
     */
    public void testCutAcceptEventActionAction1() {
        test = new CutAcceptEventActionAction(AccuracyTestHelper.createAcceptEventAction(), null);
        assertNotNull("Constructor fails to create instance.", test);
        assertEquals("Constructor fails to set correct presentation name.", "Cut Accept Event Action", test
                .getPresentationName());
    }

    /**
     * Tests CutAcceptEventActionAction constructor.
     */
    public void testCutAcceptEventActionAction2() {
        test = new CutAcceptEventActionAction(AccuracyTestHelper.createAcceptEventAction(), clipboard);
        assertNotNull("Constructor fails to create instance.", test);
        assertEquals("Constructor fails to set correct presentation name.", "Cut Accept Event Action", test
                .getPresentationName());
    }

    /**
     * Tests CutActionStateAction constructor.
     */
    public void testCutActionStateAction1() {
        test = new CutActionStateAction(AccuracyTestHelper.createActionState(), null);
        assertNotNull("Constructor fails to create instance.", test);
        assertEquals("Constructor fails to set correct presentation name.", "Cut Action State", test
                .getPresentationName());
    }

    /**
     * Tests CutActionStateAction constructor.
     */
    public void testCutActionStateAction2() {
        test = new CutActionStateAction(AccuracyTestHelper.createActionState(), clipboard);
        assertNotNull("Constructor fails to create instance.", test);
        assertEquals("Constructor fails to set correct presentation name.", "Cut Action State", test
                .getPresentationName());
    }

    /**
     * Tests CutDecisionNodeAction constructor.
     */
    public void testCutDecisionNodeAction1() {
        test = new CutDecisionNodeAction(AccuracyTestHelper.createDecisionNode(), null);
        assertNotNull("Constructor fails to create instance.", test);
        assertEquals("Constructor fails to set correct presentation name.", "Cut Decision Node", test
                .getPresentationName());
    }

    /**
     * Tests CutDecisionNodeAction constructor.
     */
    public void testCutDecisionNodeAction2() {
        test = new CutDecisionNodeAction(AccuracyTestHelper.createDecisionNode(), clipboard);
        assertNotNull("Constructor fails to create instance.", test);
        assertEquals("Constructor fails to set correct presentation name.", "Cut Decision Node", test
                .getPresentationName());
    }

    /**
     * Tests CutFinalNodeAction constructor.
     */
    public void testCutFinalNodeAction1() {
        test = new CutFinalNodeAction(AccuracyTestHelper.createFinalNode(), null);
        assertNotNull("Constructor fails to create instance.", test);
        assertEquals("Constructor fails to set correct presentation name.", "Cut Final Node", test
                .getPresentationName());
    }

    /**
     * Tests CutFinalNodeAction constructor.
     */
    public void testCutFinalNodeAction2() {
        test = new CutFinalNodeAction(AccuracyTestHelper.createFinalNode(), clipboard);
        assertNotNull("Constructor fails to create instance.", test);
        assertEquals("Constructor fails to set correct presentation name.", "Cut Final Node", test
                .getPresentationName());
    }

    /**
     * Tests CutFlowFinalNodeAction constructor.
     */
    public void testCutFlowFinalNodeAction1() {
        test = new CutFlowFinalNodeAction(AccuracyTestHelper.createFlowFinalNode(), null);
        assertNotNull("Constructor fails to create instance.", test);
        assertEquals("Constructor fails to set correct presentation name.", "Cut Flow Final Node", test
                .getPresentationName());
    }

    /**
     * Tests CutFlowFinalNodeAction constructor.
     */
    public void testCutFlowFinalNodeAction2() {
        test = new CutFlowFinalNodeAction(AccuracyTestHelper.createFlowFinalNode(), clipboard);
        assertNotNull("Constructor fails to create instance.", test);
        assertEquals("Constructor fails to set correct presentation name.", "Cut Flow Final Node", test
                .getPresentationName());
    }

    /**
     * Tests CutForkNodeAction constructor.
     */
    public void testCutForkNodeAction1() {
        test = new CutForkNodeAction(AccuracyTestHelper.createForkNode(), null);
        assertNotNull("Constructor fails to create instance.", test);
        assertEquals("Constructor fails to set correct presentation name.", "Cut Fork Node", test
                .getPresentationName());
    }

    /**
     * Tests CutForkNodeAction constructor.
     */
    public void testCutForkNodeAction2() {
        test = new CutForkNodeAction(AccuracyTestHelper.createForkNode(), clipboard);
        assertNotNull("Constructor fails to create instance.", test);
        assertEquals("Constructor fails to set correct presentation name.", "Cut Fork Node", test
                .getPresentationName());
    }

    /**
     * Tests CutInitialNodeAction constructor.
     */
    public void testCutInitialNodeAction1() {
        test = new CutInitialNodeAction(AccuracyTestHelper.createInitialNode(), null);
        assertNotNull("Constructor fails to create instance.", test);
        assertEquals("Constructor fails to set correct presentation name.", "Cut Initial Node", test
                .getPresentationName());
    }

    /**
     * Tests CutInitialNodeAction constructor.
     */
    public void testCutInitialNodeAction2() {
        test = new CutInitialNodeAction(AccuracyTestHelper.createInitialNode(), clipboard);
        assertNotNull("Constructor fails to create instance.", test);
        assertEquals("Constructor fails to set correct presentation name.", "Cut Initial Node", test
                .getPresentationName());
    }

    /**
     * Tests CutJoinNodeAction constructor.
     */
    public void testCutJoinNodeAction1() {
        test = new CutJoinNodeAction(AccuracyTestHelper.createJoinNode(), null);
        assertNotNull("Constructor fails to create instance.", test);
        assertEquals("Constructor fails to set correct presentation name.", "Cut Join Node", test
                .getPresentationName());
    }

    /**
     * Tests CutJoinNodeAction constructor.
     */
    public void testCutJoinNodeAction2() {
        test = new CutJoinNodeAction(AccuracyTestHelper.createJoinNode(), clipboard);
        assertNotNull("Constructor fails to create instance.", test);
        assertEquals("Constructor fails to set correct presentation name.", "Cut Join Node", test
                .getPresentationName());
    }

    /**
     * Tests CutMergeNodeAction constructor.
     */
    public void testCutMergeNodeAction1() {
        test = new CutMergeNodeAction(AccuracyTestHelper.createMergeNode(), null);
        assertNotNull("Constructor fails to create instance.", test);
        assertEquals("Constructor fails to set correct presentation name.", "Cut Merge Node", test
                .getPresentationName());
    }

    /**
     * Tests CutFinalNodeAction constructor.
     */
    public void testCutMergeNodeAction2() {
        test = new CutMergeNodeAction(AccuracyTestHelper.createMergeNode(), clipboard);
        assertNotNull("Constructor fails to create instance.", test);
        assertEquals("Constructor fails to set correct presentation name.", "Cut Merge Node", test
                .getPresentationName());
    }

    /**
     * Tests CutObjectFlowStateAction constructor.
     */
    public void testCutObjectFlowStateAction1() {
        test = new CutObjectFlowStateAction(AccuracyTestHelper.createObjectFlowState(), null);
        assertNotNull("Constructor fails to create instance.", test);
        assertEquals("Constructor fails to set correct presentation name.", "Cut Object Flow State", test
                .getPresentationName());
    }

    /**
     * Tests CutFinalNodeAction constructor.
     */
    public void testCutObjectFlowStateAction2() {
        test = new CutObjectFlowStateAction(AccuracyTestHelper.createObjectFlowState(), clipboard);
        assertNotNull("Constructor fails to create instance.", test);
        assertEquals("Constructor fails to set correct presentation name.", "Cut Object Flow State", test
                .getPresentationName());
    }

    /**
     * Tests CutSendSignalActionAction constructor.
     */
    public void testCutSendSignalActionAction1() {
        test = new CutSendSignalActionAction(AccuracyTestHelper.createSendSignalAction(), null);
        assertNotNull("Constructor fails to create instance.", test);
        assertEquals("Constructor fails to set correct presentation name.", "Cut Send Signal Action", test
                .getPresentationName());
    }

    /**
     * Tests CutFinalNodeAction constructor.
     */
    public void testCutSendSignalActionAction2() {
        test = new CutSendSignalActionAction(AccuracyTestHelper.createSendSignalAction(), clipboard);
        assertNotNull("Constructor fails to create instance.", test);
        assertEquals("Constructor fails to set correct presentation name.", "Cut Send Signal Action", test
                .getPresentationName());
    }
}
