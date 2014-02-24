/*
 * Copyright (C) 2006 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.uml.actions.model.usecase.accuracytests;

import com.topcoder.uml.actions.model.usecase.AccuracyTestActorUtil;
import com.topcoder.uml.actions.model.usecase.AccuracyTestAddAction;
import com.topcoder.uml.actions.model.usecase.AccuracyTestCopyAction;
import com.topcoder.uml.actions.model.usecase.AccuracyTestCutAction;
import com.topcoder.uml.actions.model.usecase.AccuracyTestExtendUtil;
import com.topcoder.uml.actions.model.usecase.AccuracyTestIncludeUtil;
import com.topcoder.uml.actions.model.usecase.AccuracyTestPasteAction;
import com.topcoder.uml.actions.model.usecase.AccuracyTestRemoveAction;
import com.topcoder.uml.actions.model.usecase.AccuracyTestSubsystemUtil;
import com.topcoder.uml.actions.model.usecase.AccuracyTestUseCaseUtil;
import com.topcoder.uml.actions.model.usecase.AccuracyTestUsecaseToolUtil;
import com.topcoder.uml.actions.model.usecase.AccuracyTestUsecaseUndoableAction;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

/**
 * This test case aggregates all accuracy test cases.
 *
 * @author vividmxx
 * @version 1.0
 */
public class AccuracyTests extends TestCase {

    /**
     * Aggregates all Accuracy test cases.
     *
     * @return the aggregated Accuracy test cases
     */
    public static Test suite() {
        final TestSuite suite = new TestSuite();
        suite.addTestSuite(AccuracyTestUsecaseToolUtil.class);
        suite.addTestSuite(AccuracyTestCopyAction.class);
        suite.addTestSuite(AccuracyTestUsecaseUndoableAction.class);
        suite.addTestSuite(AccuracyTestCutAction.class);
        suite.addTestSuite(AccuracyTestRemoveAction.class);
        suite.addTestSuite(AccuracyTestAddAction.class);
        suite.addTestSuite(AccuracyTestPasteAction.class);

        suite.addTestSuite(AccuracyTestActorUtil.class);
        suite.addTestSuite(AccuracyTestSubsystemUtil.class);
        suite.addTestSuite(AccuracyTestUseCaseUtil.class);
        suite.addTestSuite(AccuracyTestExtendUtil.class);
        suite.addTestSuite(AccuracyTestIncludeUtil.class);

        suite.addTestSuite(AccuracyTestInvalidDataContentException.class);
        suite.addTestSuite(AccuracyTestModelTransfer.class);

        suite.addTestSuite(AccuracyTestAddActorAction.class);
        suite.addTestSuite(AccuracyTestAddSubsystemAction.class);
        suite.addTestSuite(AccuracyTestAddUseCaseAction.class);
        suite.addTestSuite(AccuracyTestAddExtendAction.class);
        suite.addTestSuite(AccuracyTestAddIncludeAction.class);

        suite.addTestSuite(AccuracyTestCopyActorAction.class);
        suite.addTestSuite(AccuracyTestCopyExtendAction.class);
        suite.addTestSuite(AccuracyTestCopyIncludeAction.class);
        suite.addTestSuite(AccuracyTestCopySubsystemAction.class);
        suite.addTestSuite(AccuracyTestCopyUseCaseAction.class);

        suite.addTestSuite(AccuracyTestCutActorAction.class);
        suite.addTestSuite(AccuracyTestCutExtendAction.class);
        suite.addTestSuite(AccuracyTestCutIncludeAction.class);
        suite.addTestSuite(AccuracyTestCutSubsystemAction.class);
        suite.addTestSuite(AccuracyTestCutUseCaseAction.class);

        suite.addTestSuite(AccuracyTestRemoveActorAction.class);
        suite.addTestSuite(AccuracyTestRemoveExtendAction.class);
        suite.addTestSuite(AccuracyTestRemoveIncludeAction.class);
        suite.addTestSuite(AccuracyTestRemoveSubsystemAction.class);
        suite.addTestSuite(AccuracyTestRemoveUseCaseAction.class);

        suite.addTestSuite(AccuracyTestPasteActorAction.class);
        suite.addTestSuite(AccuracyTestPasteExtendAction.class);
        suite.addTestSuite(AccuracyTestPasteIncludeAction.class);
        suite.addTestSuite(AccuracyTestPasteUseCaseAction.class);
        suite.addTestSuite(AccuracyTestPasteSubsystemAction.class);
        return suite;
    }
}
