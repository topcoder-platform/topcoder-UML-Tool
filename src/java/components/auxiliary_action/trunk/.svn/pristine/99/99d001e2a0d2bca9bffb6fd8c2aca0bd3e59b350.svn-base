/*
 * Copyright (C) 2007 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.uml.actions.auxiliary.stresstests;

import com.topcoder.uml.actions.auxiliary.comment.model.ChangeCommentTextAction;
import com.topcoder.uml.model.core.auxiliaryelements.Comment;
import com.topcoder.uml.model.core.auxiliaryelements.CommentImpl;

import junit.framework.TestCase;

/**
 * <p>
 * Stress tests on ChangeCommentTextAction.
 * </p>
 * @version 1.0
 * @author Achilles_2005
 */
public class ChangeCommentTextActionStressTests extends TestCase {
    /** Iteration number. */
    private static final int NUM = 10000;
    /**
     * <p>
     * Set up the environment.
     * </p>
     */
    public void setUp() {
        TestHelper.loadConfig(TestHelper.CONFIG_FILE);
    }
    
    /**
     * <p>
     * Clear the environment.
     * </p>
     */
    public void tearDown() {
        TestHelper.clearConfig();
    }
    /**
     * <p>
     * Stress tests on the ChangeCommentTextAction.
     * </p>
     * @throws Exception never happens
     */
    public void testChangeCommentTextAction() throws Exception {
        Comment comment = new CommentImpl();
        comment.setBody("Text");
        ChangeCommentTextAction action = new ChangeCommentTextAction(comment, "new-text");
        long start = System.currentTimeMillis();
        for (int i = 0; i < NUM; i++) {
            // execite
            action.execute();
            // undo
            action.undo();
            // redo
            action.redo();
        }
        System.out.println("ChangeCommentTextAction : " + NUM + " times, "
                + (System.currentTimeMillis() - start) + " ms.");
    }
}
