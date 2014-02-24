/*
 * Copyright (C) 2006 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.uml.model.core.auxiliaryelements;

import com.topcoder.uml.model.core.ModelElement;
import com.topcoder.uml.model.core.ModelElementAbstractImpl;
import com.topcoder.uml.model.modelmanagement.ModelImpl;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;


/**
 * <p>
 * Unit test for <code>CommentImpl</code> class.
 * </p>
 *
 * @author TCSDEVELOPER
 * @version 1.0
 */
public class CommentImplTest extends TestCase {
    /**
     * <p>
     * Private instance used for test.
     * </p>
     */
    private CommentImpl commentImpl = null;

    /**
     * <p>
     * Aggregates all tests in this class.
     * </p>
     *
     * @return Test suite aggregating all tests.
     */
    public static Test suite() {
        TestSuite suite = new TestSuite(CommentImplTest.class);
        suite.addTest(new CollectionVariableTest("dummy", CommentImpl.class, "AnnotatedElement", "AnnotatedElements",
                ModelElement.class, ModelImpl.class).getSuite());
        suite.addTest(new ValueVariableTest("dummy", CommentImpl.class, "Body", String.class,
                new Object[] {"", " ", "\t\n", "abc"}).getSuite());

        return suite;
    }

    /**
     * <p>
     * Sets up test environment, creates object used for test.
     * </p>
     */
    protected void setUp() {
        commentImpl = new CommentImpl();
    }

    /**
     * <p>
     * Tears down test environment, disposes object used for test.
     * </p>
     */
    protected void tearDown() {
        commentImpl = null;
    }

    /**
     * <p>
     * Tests inheritance of <code>CommentImpl</code>.
     * <code>CommentImpl</code> should inherit from <code>ModelElementAbstractImpl</code>.
     * </p>
     */
    public void testCommentImplAccuracyInheritModelElementAbstractImpl() {
        assertTrue("CommentImpl should inherit from ModelElementAbstractImpl.",
            commentImpl instanceof ModelElementAbstractImpl);
    }

    /**
     * <p>
     * Tests inheritance of <code>CommentImpl</code>.
     * <code>CommentImpl</code> should inherit from <code>Comment</code>.
     * </p>
     */
    public void testCommentImplAccuracyInheritComment() {
        assertTrue("CommentImpl should inherit from Comment.", commentImpl instanceof Comment);
    }

    /**
     * <p>
     * Tests accuracy of <code>CommentImpl()</code>.
     * Variable should be set correctly.
     * </p>
     */
    public void testCommentImplAccuracy() {
        assertEquals("Variable should be set correctly.", 0, commentImpl.getAnnotatedElements().size());
        assertNull("Variable should be set correctly.", commentImpl.getBody());
    }
}
