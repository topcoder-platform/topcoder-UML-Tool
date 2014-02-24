/*
 * Copyright (C) 2006 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.uml.actions.model.sequence.failuretests;

import com.topcoder.uml.actions.model.sequence.MessageUtilFailureTest;
import com.topcoder.uml.actions.model.sequence.ObjectUtilFailureTest;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

/**
 * <p>
 * This test case aggregates all Failure test cases.
 * </p>
 *
 * @author TopCoder
 * @version 1.0
 */
public class FailureTests extends TestCase {

    /**
     * <p>
     * Aggregates all Failure test cases.
     * </p>
     *
     * @return the failure test cases
     */
    public static Test suite() {
        final TestSuite suite = new TestSuite();

        suite.addTestSuite(AddAsynchronousMessageActionFailureTest.class);
        suite.addTestSuite(AddCreateMessageActionFailureTest.class);
        suite.addTestSuite(AddMessageActionFailureTest.class);
        suite.addTestSuite(AddObjectActionFailureTest.class);
        suite.addTestSuite(AddReturnMessageActionFailureTest.class);
        suite.addTestSuite(AddSendSignalMessageActionFailureTest.class);
        suite.addTestSuite(AddSynchronousMessageActionFailureTest.class);
        suite.addTestSuite(CollaborationTransferFailureTest.class);
        suite.addTestSuite(CopyAsynchronousMessageActionFailureTest.class);
        suite.addTestSuite(CopyCreateMessageActionFailureTest.class);
        suite.addTestSuite(CopyMessageActionFailureTest.class);
        suite.addTestSuite(CopyObjectActionFailureTest.class);
        suite.addTestSuite(CopyReturnMessageActionFailureTest.class);
        suite.addTestSuite(CopySendSignalMessageActionFailureTest.class);
        suite.addTestSuite(CopySynchronousMessageActionFailureTest.class);
        suite.addTestSuite(CutAsynchronousMessageActionFailureTest.class);
        suite.addTestSuite(CutCreateMessageActionFailureTest.class);
        suite.addTestSuite(CutMessageActionFailureTest.class);
        suite.addTestSuite(CutObjectActionFailureTest.class);
        suite.addTestSuite(CutReturnMessageActionFailureTest.class);
        suite.addTestSuite(CutSendSignalMessageActionFailureTest.class);
        suite.addTestSuite(CutSynchronousMessageActionFailureTest.class);
        suite.addTestSuite(MessageUndoableActionFailureTest.class);
        suite.addTestSuite(MessageUtilFailureTest.class);
        suite.addTestSuite(ObjectUndoableActionFailureTest.class);
        suite.addTestSuite(ObjectUtilFailureTest.class);
        suite.addTestSuite(PasteAsynchronousMessageActionFailureTest.class);
        suite.addTestSuite(PasteCreateMessageActionFailureTest.class);
        suite.addTestSuite(PasteMessageActionFailureTest.class);
        suite.addTestSuite(PasteObjectActionFailureTest.class);
        suite.addTestSuite(PasteReturnMessageActionFailureTest.class);
        suite.addTestSuite(PasteSendSignalMessageActionFailureTest.class);
        suite.addTestSuite(PasteSynchronousMessageActionFailureTest.class);
        suite.addTestSuite(RemoveAsynchronousMessageActionFailureTest.class);
        suite.addTestSuite(RemoveCreateMessageActionFailureTest.class);
        suite.addTestSuite(RemoveMessageActionFailureTest.class);
        suite.addTestSuite(RemoveObjectActionFailureTest.class);
        suite.addTestSuite(RemoveReturnMessageActionFailureTest.class);
        suite.addTestSuite(RemoveSendSignalMessageActionFailureTest.class);
        suite.addTestSuite(RemoveSynchronousMessageActionFailureTest.class);
        // suite.addTestSuite(CopyHelperFailureTest.class);
        return suite;
    }

}
