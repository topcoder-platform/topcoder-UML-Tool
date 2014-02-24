/*
 * Copyright (C) 2007 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.uml.actions.auxiliary.comment.model;

import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;

import junit.framework.TestCase;

import com.topcoder.uml.actions.auxiliary.AuxiliaryElementDataFlavor;
import com.topcoder.uml.actions.auxiliary.UnitTestHelper;
import com.topcoder.uml.model.core.Namespace;
import com.topcoder.uml.model.core.NamespaceAbstractImpl;
import com.topcoder.uml.model.core.auxiliaryelements.Comment;
import com.topcoder.uml.model.core.auxiliaryelements.CommentImpl;

/**
 * <p>
 * Unit tests on class <code>CutCommentAction</code>.
 * </p>
 * @version 1.0
 * @author TCSDEVELOPER
 */
public class CutCommentActionTest extends TestCase {
    /**
     * <p>
     * Instance of <code>CutCommentAction</code> used in this test.
     * </p>
     */
    private CutCommentAction action;
    /**
     * <p>
     * Instance of <code>Comment</code> used in this test.
     * </p>
     */
    private Comment comment;
    /**
     * <p>
     * Instance of <code>Namespace</code> used in this test.
     * </p>
     */
    private Namespace namespace;

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
        this.namespace = new NamespaceAbstractImpl() { };
        this.comment.setNamespace(this.namespace);
        this.clipboard = new Clipboard("CutCommentActionTest");
        this.action = new CutCommentAction(this.comment, this.clipboard);
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
     * Test constructor <code>CutCommentAction(Comment comment, Clipboard clipboard)
     * </code> for failure with null comment, <code>IllegalArgumentException</code> is expected.
     * </p>
     */
    public void testCtor_NullComment() {
        try {
            new CutCommentAction(null, null);
            fail("IllegalArgumentException is expected!");
        } catch (IllegalArgumentException e) {
            // expected
        }
    }
    /**
     * <p>
     * Test constructor <code>CutCommentAction(Comment comment, Clipboard clipboard)
     * </code> for failure with comment without namespace, <code>IllegalArgumentException</code> is expected.
     * </p>
     */
    public void testCtor_CommentWithoutNamespace() {
        try {
            new CutCommentAction(new CommentImpl(), null);
            fail("IllegalArgumentException is expected!");
        } catch (IllegalArgumentException e) {
            // expected
        }
    }
    /**
     * <p>
     * Test constructor <code>CutCommentAction(Comment comment, Clipboard clipboard)
     * </code> for accuracy.
     * </p>
     */
    public void testCtor_Accuracy1() {
        assertNotNull("Failed to create the action!",
                new CutCommentAction(this.comment, null));
    }
    /**
     * <p>
     * Test constructor <code>CutCommentAction(Comment comment, Clipboard clipboard)
     * </code> for accuracy.
     * </p>
     */
    public void testCtor_Accuracy2() {
        assertNotNull("Failed to create the action!",
                new CutCommentAction(this.comment, Toolkit.getDefaultToolkit().getSystemClipboard()));
    }
    /**
     * <p>
     * Test method <code>execute()</code> for accuracy.
     * </p>
     * @throws Exception to JUnit
     */
    public void testExecute() throws Exception {
        // execute the action
        this.action.execute();
        Object obj = this.clipboard.getData(AuxiliaryElementDataFlavor.COMMENT);
        assertNotNull("Failed to execute the action!", obj);
        assertTrue("Failed to execute the action!", obj instanceof Comment);
        assertNull("Failed to execute the action!", this.comment.getNamespace());
        assertTrue("Failed to execute the action!", this.namespace.getOwnedElements().isEmpty());
    }
    /**
     * <p>
     * Test method <code>undo()</code> for accuracy.
     * </p>
     * @throws Exception to JUnit
     */
    public void testUndo() throws Exception {
        // execute the action
        this.action.execute();
        Object obj = this.clipboard.getData(AuxiliaryElementDataFlavor.COMMENT);
        assertNotNull("Failed to execute the action!", obj);
        assertTrue("Failed to execute the action!", obj instanceof Comment);
        UnitTestHelper.assertEquals(this.comment, (Comment) obj, "Failed to execute the action!");
        assertNull("Failed to execute the action!", this.comment.getNamespace());
        assertTrue("Failed to execute the action!", this.namespace.getOwnedElements().isEmpty());

        // undo the action
        this.action.undo();
        assertEquals("Failed to undo the action!", this.namespace, this.comment.getNamespace());
        assertEquals("Failed to undo the action!", this.comment, this.namespace.getOwnedElements().toArray()[0]);
    }
    /**
     * <p>
     * Test method <code>getPresentationName()</code> for accuracy.
     * </p>
     */
    public void testGetPresentationName() {
        assertEquals("Incorrect name!", "Cut Comment Action", this.action.getPresentationName());
    }
}
