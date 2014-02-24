/*
 * Copyright (C) 2006 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.uml.actions.model.sequence.accuracytests;

import com.topcoder.uml.actions.model.sequence.AddMessageActionAccuracyTests;
import com.topcoder.uml.actions.model.sequence.CopyMessageActionAccuracyTests;
import com.topcoder.uml.actions.model.sequence.CutMessageActionAccuracyTests;
import com.topcoder.uml.actions.model.sequence.MessageUndoableActionAccuracyTests;
import com.topcoder.uml.actions.model.sequence.MessageUtilAccuracyTests;
import com.topcoder.uml.actions.model.sequence.ObjectUndoableActionAccuracyTests;
import com.topcoder.uml.actions.model.sequence.ObjectUtilAccuracyTests;
import com.topcoder.uml.actions.model.sequence.PasteMessageActionAccuracyTests;
import com.topcoder.uml.actions.model.sequence.RemoveMessageActionAccuracyTests;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

/**
 * <p>
 * This test case aggregates all accuracy test cases.
 * </p>
 *
 * @author FireIce
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
        suite.addTestSuite(AddAsynchronousMessageActionAccuracyTests.class);
        suite.addTestSuite(AddSynchronousMessageActionAccuracyTests.class);
        suite.addTestSuite(AddCreateMessageActionAccuracyTests.class);
        suite.addTestSuite(AddReturnMessageActionAccuracyTests.class);
        suite.addTestSuite(AddSendSignalMessageActionAccuracyTests.class);

        suite.addTestSuite(CopyAsynchronousMessageActionAccuracyTests.class);
        suite.addTestSuite(CopySynchronousMessageActionAccuracyTests.class);
        suite.addTestSuite(CopyCreateMessageActionAccuracyTests.class);
        suite.addTestSuite(CopyReturnMessageActionAccuracyTests.class);
        suite.addTestSuite(CopySendSignalMessageActionAccuracyTests.class);

        suite.addTestSuite(CutAsynchronousMessageActionAccuracyTests.class);
        suite.addTestSuite(CutSynchronousMessageActionAccuracyTests.class);
        suite.addTestSuite(CutCreateMessageActionAccuracyTests.class);
        suite.addTestSuite(CutReturnMessageActionAccuracyTests.class);
        suite.addTestSuite(CutSendSignalMessageActionAccuracyTests.class);

        suite.addTestSuite(PasteAsynchronousMessageActionAccuracyTests.class);
        suite.addTestSuite(PasteSynchronousMessageActionAccuracyTests.class);
        suite.addTestSuite(PasteCreateMessageActionAccuracyTests.class);
        suite.addTestSuite(PasteReturnMessageActionAccuracyTests.class);
        suite.addTestSuite(PasteSendSignalMessageActionAccuracyTests.class);

        suite.addTestSuite(RemoveAsynchronousMessageActionAccuracyTests.class);
        suite.addTestSuite(RemoveSynchronousMessageActionAccuracyTests.class);
        suite.addTestSuite(RemoveCreateMessageActionAccuracyTests.class);
        suite.addTestSuite(RemoveReturnMessageActionAccuracyTests.class);
        suite.addTestSuite(RemoveSendSignalMessageActionAccuracyTests.class);

        suite.addTestSuite(CollaborationTransferAccuracyTests.class);
        suite.addTestSuite(AddObjectActionAccuracyTests.class);
        suite.addTestSuite(CopyObjectActionAccuracyTests.class);
        suite.addTestSuite(CutObjectActionAccuracyTests.class);
        suite.addTestSuite(PasteObjectActionAccuracyTests.class);
        suite.addTestSuite(RemoveObjectActionAccuracyTests.class);

        suite.addTestSuite(AddMessageActionAccuracyTests.class);
        suite.addTestSuite(CopyMessageActionAccuracyTests.class);
        suite.addTestSuite(CutMessageActionAccuracyTests.class);
        suite.addTestSuite(PasteMessageActionAccuracyTests.class);
        suite.addTestSuite(RemoveMessageActionAccuracyTests.class);

        suite.addTestSuite(ObjectUndoableActionAccuracyTests.class);
        suite.addTestSuite(MessageUndoableActionAccuracyTests.class);
        suite.addTestSuite(MessageUtilAccuracyTests.class);
        suite.addTestSuite(ObjectUtilAccuracyTests.class);

        return suite;
    }
}
