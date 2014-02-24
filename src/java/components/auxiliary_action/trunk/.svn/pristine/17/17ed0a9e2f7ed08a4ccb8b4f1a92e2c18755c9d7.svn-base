/*
 * Copyright (C) 2007 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.uml.actions.auxiliary.comment.model;

import java.util.Collection;

import junit.framework.TestCase;

import com.topcoder.uml.actions.auxiliary.UnitTestHelper;
import com.topcoder.uml.model.core.ModelElement;
import com.topcoder.uml.model.core.Namespace;
import com.topcoder.uml.model.core.NamespaceAbstractImpl;
import com.topcoder.uml.model.core.auxiliaryelements.Comment;
import com.topcoder.uml.model.core.auxiliaryelements.CommentImpl;
import com.topcoder.util.actionmanager.ActionExecutionException;

/**
 * <p>
 * Unit tests on class <code>RemoveCommentAction</code>.
 * </p>
 * @version 1.0
 * @author TCSDEVELOPER
 */
public class RemoveCommentActionTest extends TestCase {
    /**
     * <p>
     * Instance of <code>RemoveCommentAction</code> used in this test.
     * </p>
     */
    private RemoveCommentAction action;
    /**
     * <p>
     * Instance of <code>Comment</code> used in this test.
     * </p>
     */
    private Comment comment;
    /**
     * <p>
     * Instance of <code>Namespace</code> used in this test.
     */
    private Namespace namespace;

    /**
     * <p>
     * Set up environment.
     * </p>
     * @throws Exception to JUnit
     */
    public void setUp() throws Exception {
        UnitTestHelper.loadConfig(UnitTestHelper.CONFIG_FILE);
        this.comment = new CommentImpl();
        this.namespace = new NamespaceAbstractImpl() { };
        this.comment.setNamespace(this.namespace);
        this.action = new RemoveCommentAction(this.comment);
    }
    /**
     * <p>
     * Clear the environment.
     * </p>
     */
    public void tearDown() {
        UnitTestHelper.clearConfig();
    }

    /**
     * <p>
     * Test constructor <code>RemoveCommentAction(Comment comment)
     * </code> for failure with null comment, <code>IllegalArgumentException</code> is expected.
     * </p>
     */
    public void testCtor_NullComment() {
        try {
            new RemoveCommentAction(null);
            fail("IllegalArgumentException is expected!");
        } catch (IllegalArgumentException e) {
            // expected
        }
    }
    /**
     * <p>
     * Test constructor <code>RemoveCommentAction(Comment comment)
     * </code> for failure with comment without namespace, <code>IllegalArgumentException</code> is expected.
     * </p>
     */
    public void testCtor_CommentWithoutNamespace() {
        this.comment.setNamespace(null);
        try {
            new RemoveCommentAction(this.comment);
            fail("IllegalArgumentException is expected!");
        } catch (IllegalArgumentException e) {
            // expected
        }
    }
    /**
     * <p>
     * Test constructor <code>RemoveCommentAction(Comment comment)
     * </code> for accuracy.
     * </p>
     */
    public void testCtor_Accuracy() {
        assertNotNull("Failed to create the action!",
                new RemoveCommentAction(this.comment));
    }

    /**
     * <p>
     * Test method <code>execute()</code> for accuracy.
     * </p>
     * @throws ActionExecutionException to JUnit
     *
     */
    public void testExecute() throws ActionExecutionException {
        // execute the action
        this.action.execute();

        Collection<ModelElement> ownedElements = this.namespace.getOwnedElements();
        assertTrue("Failed to execute the action!", ownedElements.isEmpty());
        assertNull("Failed to execute the action!", this.comment.getNamespace());
    }

    /**
     * <p>
     * Test method <code>undo()</code> for accuracy.
     * </p>
     * @throws ActionExecutionException to JUnit
     *
     */
    public void testUndo() throws ActionExecutionException {
        // execute the action
        this.action.execute();

        Collection<ModelElement> ownedElements = this.namespace.getOwnedElements();
        assertTrue("Failed to execute the action!", ownedElements.isEmpty());
        assertNull("Failed to execute the action!", this.comment.getNamespace());

        // undo the action
        this.action.undo();
        ownedElements = this.namespace.getOwnedElements();
        assertEquals("Failed to execute the action!", 1, ownedElements.size());
        assertEquals("Failed to execute the action!", this.comment, ownedElements.toArray()[0]);
        assertEquals("Failed to execute the action!", this.namespace, this.comment.getNamespace());
    }
    /**
     * <p>
     * Test method <code>getPresentationName()</code> for accuracy.
     * </p>
     */
    public void testGetPresentationName() {
        assertEquals("Incorrect name!", "Remove Comment Action", this.action.getPresentationName());
    }
}
