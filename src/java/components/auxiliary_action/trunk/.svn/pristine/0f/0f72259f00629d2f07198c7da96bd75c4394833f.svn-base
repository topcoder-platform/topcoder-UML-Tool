/*
 * Copyright (C) 2007 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.uml.actions.auxiliary.accuracytests;

import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;

import junit.framework.TestCase;

import com.topcoder.uml.actions.auxiliary.AuxiliaryElementDataFlavor;
import com.topcoder.uml.actions.auxiliary.comment.model.CopyCommentAction;
import com.topcoder.uml.model.core.auxiliaryelements.Comment;
import com.topcoder.uml.model.core.auxiliaryelements.CommentImpl;

/**
 * <p>
 * Set of accuracy tests for CopyCommentAction class.
 * </p>
 * @author TCSDEVELOPER
 * @version 1.0
 */
public class CopyCommentActionAccuracyTest extends TestCase {

    /**
     * Instance of Comment for testing.
     */
    private Comment comment;

    /**
     * Instance of Clipboard for testing.
     */
    private Clipboard clipboard;

    /**
     * Instance of CopyCommentAction for testing.
     */
    private CopyCommentAction copyCommentAction;

    /**
     * Setting up environment for each test case.
     * @throws Exception wraps all exceptions
     */
    protected void setUp() throws Exception {
        comment = new CommentImpl();
        clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
        copyCommentAction = new CopyCommentAction(comment, clipboard);
    }

    /**
     * Constructor under test CopyCommentAction(Comment, Clipboard). Accuracy
     * testing of correctly assigned values.
     * @throws Exception wraps all exceptions
     */
    public final void testCopyCommentAction() throws Exception {
        CopyCommentAction currentCopyCommentAction = new CopyCommentAction(comment, clipboard);
        assertSame("comments must be the same", comment, AccuracyTestsHelper.getFieldValue(currentCopyCommentAction,
            "comment"));
        assertSame("clipboads must be the same", clipboard, AccuracyTestsHelper.getFieldValue(
            currentCopyCommentAction, "clipboard"));
    }

    /**
     * Method under test CopyCommentAction.execute(). Accuracy testing of
     * correct execution.
     * @throws Exception wraps all exceptions
     */
    public final void testExecute() throws Exception {
        // run successfully
        copyCommentAction.execute();
        Object object = clipboard.getData(AuxiliaryElementDataFlavor.COMMENT);
        assertTrue("comment was not successfully copied", object instanceof Comment);
        assertFalse("copied comment was not cloned", ((Comment) object) == comment);
    }
}