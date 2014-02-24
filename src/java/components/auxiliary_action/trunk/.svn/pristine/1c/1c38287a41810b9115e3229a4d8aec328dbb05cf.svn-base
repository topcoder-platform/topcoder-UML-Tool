/*
 * Copyright (C) 2007 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.uml.actions.auxiliary.comment.model;

import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.util.ArrayList;
import java.util.Collection;

import junit.framework.TestCase;

import com.topcoder.uml.actions.auxiliary.AuxiliaryElementDataFlavor;
import com.topcoder.uml.actions.auxiliary.UnitTestHelper;
import com.topcoder.uml.model.core.ModelElement;
import com.topcoder.uml.model.core.ModelElementAbstractImpl;
import com.topcoder.uml.model.core.auxiliaryelements.Comment;
import com.topcoder.uml.model.core.auxiliaryelements.CommentImpl;

/**
 * <p>
 * Unit tests on class <code>CutNoteRelationshipAction</code>.
 * </p>
 * @version 1.0
 * @author TCSDEVELOPER
 */
public class CutNoteRelationshipActionTest extends TestCase {
    /**
     * <p>
     * Instance of <code>CutNoteRelationshipAction</code> used in this test.
     * </p>
     */
    private CutNoteRelationshipAction action;
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
     * Instance of <code>Clipboard</code> used in this test.
     */
    private Clipboard clipboard;

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
            this.comment.addAnnotatedElement(new ModelElementAbstractImpl(){});
        }
        this.parents = new ArrayList<ModelElement>(this.comment.getAnnotatedElements());
        this.clipboard = new Clipboard("CutNoteRelationshipActionTest");
        this.action = new CutNoteRelationshipAction(this.comment, this.clipboard);
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
     * Test constructor <code>CutNoteRelationshipAction(Comment comment, Clipboard clipboard)
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
     * Test constructor <code>CutNoteRelationshipAction(Comment comment, Clipboard clipboard)
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
     * Test constructor <code>CutNoteRelationshipAction(Comment comment, Clipboard clipboard)
     * </code> for accuracy.
     * </p>
     */
    public void testCtor_Accuracy1() {
        assertNotNull("Failed to create the action!",
                new CutNoteRelationshipAction(this.comment, null));
    }
    /**
     * <p>
     * Test constructor <code>CutNoteRelationshipAction(Comment comment, Clipboard clipboard)
     * </code> for accuracy.
     * </p>
     */
    public void testCtor_Accuracy2() {
        assertNotNull("Failed to create the action!",
                new CutNoteRelationshipAction(this.comment, Toolkit.getDefaultToolkit().getSystemClipboard()));
    }
    /**
     * <p>
     * Test method <code>execute()</code> for accuracy.
     * </p>
     * @throws Exception to JUnit
     *
     */
    public void testExecute() throws Exception {
        // execute the action
        this.action.execute();

        Object obj = clipboard.getData(AuxiliaryElementDataFlavor.NOTE_RELATIONSHIP);
        assertNotNull("Failed to execute the action!", obj);
        assertTrue("Failed to execute the action!", obj instanceof Comment);
        UnitTestHelper.assertEquals(this.comment, (Comment) obj, "Failed to execute the action!");
        for (ModelElement me : this.parents) {
            assertTrue("Failed to execute the action!", me.getComments().isEmpty());
        }
        assertTrue("Failed to execute the action!", this.comment.getAnnotatedElements().isEmpty());
    }
    /**
     * <p>
     * Test method <code>undo()</code> for accuracy.
     * </p>
     * @throws Exception to JUnit
     *
     */
    public void testUndo() throws Exception {
        // execute the action
        this.action.execute();

        Object obj = clipboard.getData(AuxiliaryElementDataFlavor.NOTE_RELATIONSHIP);
        assertNotNull("Failed to execute the action!", obj);
        assertTrue("Failed to execute the action!", obj instanceof Comment);
        UnitTestHelper.assertEquals(this.comment, (Comment) obj, "Failed to execute the action!");

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
        assertEquals("Incorrect name!", "Cut Note Relationship Action", this.action.getPresentationName());
    }
}
