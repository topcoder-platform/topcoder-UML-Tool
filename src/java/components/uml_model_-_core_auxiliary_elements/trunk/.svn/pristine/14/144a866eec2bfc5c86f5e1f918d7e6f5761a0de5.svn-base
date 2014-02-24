/*
 * Copyright (C) 2006 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.uml.model.core.auxiliaryelements;

import com.topcoder.uml.model.core.ModelElement;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;


/**
 * <p>
 * Unit test for <code>Comment</code> class.
 * </p>
 *
 * @author TCSDEVELOPER
 * @version 1.0
 */
public class CommentTest extends TestCase {
    /**
     * <p>
     * Aggregates all tests in this class.
     * </p>
     *
     * @return Test suite aggregating all tests.
     */
    public static Test suite() {
        TestSuite suite = new TestSuite(CommentTest.class);

        return suite;
    }

    /**
     * <p>
     * Tests inheritance of <code>Comment</code>.
     * <code>Comment</code> should inherit from <code>ModelElement</code>.
     * </p>
     */
    public void testCommentAccuracyInheritModelElement() {
        assertTrue("Comment should inherit from ModelElement",
            Comment.class.getInterfaces()[0].equals(ModelElement.class));
    }
}
