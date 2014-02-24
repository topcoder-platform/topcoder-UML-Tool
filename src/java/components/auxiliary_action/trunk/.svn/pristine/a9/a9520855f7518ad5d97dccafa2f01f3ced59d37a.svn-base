/*
 * Copyright (C) 2007 TopCoder Inc., All Rights Reserved.
 *
 * CopyNoteRelationshipActionFailureTest.java
 */
package com.topcoder.uml.actions.auxiliary.failuretests.comment.model;

import com.topcoder.uml.actions.auxiliary.comment.model.CopyNoteRelationshipAction;
import junit.framework.TestCase;

/**
 * <p>
 * Failure tests for <code>CopyNoteRelationshipAction</code> class.
 * </p>
 *
 * @author wiedzmin
 * @version 1.0
 */
public class CopyNoteRelationshipActionFailureTest extends TestCase {

    /**
     * <p>
     * Tests constructor CopyNoteRelationshipAction(comment, clipboard) if comment is null.
     * IllegalArgumentException is expected.
     * </p>
     */
    public void testCtorIfCommentNull() {
        try {
            new CopyNoteRelationshipAction(null, null);
            fail("IllegalArgumentException is expected because comment cannot be null.");
        } catch (IllegalArgumentException e) {
            //success
        }
    }
}