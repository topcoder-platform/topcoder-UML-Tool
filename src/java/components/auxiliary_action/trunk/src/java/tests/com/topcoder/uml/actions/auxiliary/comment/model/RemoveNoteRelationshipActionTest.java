/*
 * Copyright (C) 2007 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.uml.actions.auxiliary.comment.model;

import java.util.ArrayList;
import java.util.Collection;

import junit.framework.TestCase;

import com.topcoder.uml.actions.auxiliary.UnitTestHelper;
import com.topcoder.uml.model.core.ModelElement;
import com.topcoder.uml.model.core.ModelElementAbstractImpl;
import com.topcoder.uml.model.core.auxiliaryelements.Comment;
import com.topcoder.uml.model.core.auxiliaryelements.CommentImpl;
import com.topcoder.util.actionmanager.ActionExecutionException;

/**
 * <p>
 * Unit tests on class <code>RemoveNoteRelationshipAction</code>.
 * </p>
 * @version 1.0
 * @author TCSDEVELOPER
 */
public class RemoveNoteRelationshipActionTest extends TestCase {
    /**
     * <p>
     * Instance of <code>RemoveNoteRelationshipAction</code> used in this test.
     * </p>
     */
    private RemoveNoteRelationshipAction action;
    /**
     * <p>
     * Instance of <code>Comment</code> used in this test.
     * </p>
     */
    private Comment comment;
    /**
     * <p>
     * Collection of parents.
     * </p>
     */
    private Collection<ModelElement> parents;

    /**
     * <p>
     * Set up environment.
     * </p>
     * @throws Exception to JUnit
     */
    public void setUp() throws Exception {
        UnitTestHelper.loadConfig(UnitTestHelper.CONFIG_FILE);
        this.comment = new CommentImpl();
        for (int i = 0; i < 100; i++) {
            this.comment.addAnnotatedElement(new ModelElementAbstractImpl() { });
        }
        this.parents = new ArrayList<ModelElement>(this.comment.getAnnotatedElements());
        this.action = new RemoveNoteRelationshipAction(this.comment);
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
     * Test constructor <code>RemoveNoteRelationshipAction(Comment comment)
     * </code> for failure with null comment, <code>IllegalArgumentException</code> is expected.
     * </p>
     */
    public void testCtor_NullComment() {
        try {
            new RemoveNoteRelationshipAction(null);
            fail("IllegalArgumentException is expected!");
        } catch (IllegalArgumentException e) {
            // expected
        }
    }
    /**
     * <p>
     * Test constructor <code>RemoveNoteRelationshipAction(Comment comment)
     * </code> for failure with comment without parents, <code>IllegalArgumentException</code> is expected.
     * </p>
     */
    public void testCtor_CommentWithoutParents() {
        try {
            new RemoveNoteRelationshipAction(new CommentImpl());
            fail("IllegalArgumentException is expected!");
        } catch (IllegalArgumentException e) {
            // expected
        }
    }
    /**
     * <p>
     * Test constructor <code>RemoveNoteRelationshipAction(Comment comment)
     * </code> for accuracy.
     * </p>
     */
    public void testCtor_Accuracy() {
        assertNotNull("Failed to create the action!",
                new RemoveNoteRelationshipAction(this.comment));
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

        for (ModelElement me : this.parents) {
            assertTrue("Failed to execute the action!", me.getComments().isEmpty());
        }
        assertTrue("Failed to execute the action!", this.comment.getAnnotatedElements().isEmpty());
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

        for (ModelElement me : this.parents) {
            assertTrue("Failed to execute the action!", me.getComments().isEmpty());
        }
        assertTrue("Failed to execute the action!", this.comment.getAnnotatedElements().isEmpty());

        // undo the action
        this.action.undo();
        for (ModelElement me : this.parents) {
            assertEquals("Failed to execute the action!", this.comment, me.getComments().toArray()[0]);
            assertTrue("Failed to execute the action!", this.comment.getAnnotatedElements().contains(me));
        }
    }
    /**
     * <p>
     * Test method <code>getPresentationName()</code> for accuracy.
     * </p>
     */
    public void testGetPresentationName() {
        assertEquals("Incorrect name!", "Remove Note Relationship Action", this.action.getPresentationName());
    }
}
