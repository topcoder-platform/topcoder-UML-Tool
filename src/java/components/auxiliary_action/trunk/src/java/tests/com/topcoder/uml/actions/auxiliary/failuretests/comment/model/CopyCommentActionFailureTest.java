/*
 * Copyright (C) 2007 TopCoder Inc., All Rights Reserved.
 *
 * CopyCommentActionFailureTest.java
 */
package com.topcoder.uml.actions.auxiliary.failuretests.comment.model;

import junit.framework.TestCase;
import com.topcoder.uml.actions.auxiliary.comment.model.CopyCommentAction;

/**
 * <p>
 * Failure tests for <code>CopyCommentAction</code> class.
 * </p>
 *
 * @author wiedzmin
 * @version 1.0
 */
public class CopyCommentActionFailureTest extends TestCase {

    /**
     * <p>
     * Tests constructor CopyCommentAction(comment, clipboard) if comment is null.
     * IllegalArgumentException is expected.
     * </p>
     */
    public void testCtorIfCommentNull() {
        try {
            new CopyCommentAction(null, null);
            fail("IllegalArgumentException is expected because comment cannot be null.");
        } catch (IllegalArgumentException e) {
            //success
        }
    }
}