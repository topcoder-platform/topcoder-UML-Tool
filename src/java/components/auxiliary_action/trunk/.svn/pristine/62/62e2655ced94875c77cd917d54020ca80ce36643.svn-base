/*
 * Copyright (C) 2007 TopCoder Inc., All Rights Reserved.
 *
 * PasteNoteRelationshipActionFailureTest.java
 */
package com.topcoder.uml.actions.auxiliary.failuretests.comment.model;

import com.topcoder.uml.actions.auxiliary.comment.model.PasteNoteRelationshipAction;
import com.topcoder.uml.actions.auxiliary.failuretests.Helper;
import com.topcoder.uml.model.core.ModelElement;
import com.topcoder.uml.model.core.ModelElementAbstractImpl;
import com.topcoder.uml.model.core.auxiliaryelements.Comment;
import com.topcoder.uml.model.core.auxiliaryelements.CommentImpl;
import junit.framework.TestCase;

import javax.swing.undo.CannotUndoException;

/**
 * <p>
 * Failure tests for <code>PasteNoteRelationshipAction</code> class.
 * </p>
 *
 * @author wiedzmin
 * @version 1.0
 */
public class PasteNoteRelationshipActionFailureTest extends TestCase {

    /**Comment that is used for testing.*/
    private Comment comment;

    /**ModelElement that is used for testing.*/
    private ModelElement parent;

   /**
     * <p>
     * Set up environment.
     * </p>
    *
    * @throws Exception exception
     */
    public void setUp() throws Exception {
       Helper.clearNamespace();
       Helper.initNamespace();

       comment = new CommentImpl();
       parent = new ModelElementAbstractImpl() {};
    }

    /**
     * <p>
     * Tear down.
     * </p>
     *
     * @throws Exception exception
     */
    public void tearDown() throws Exception {
        Helper.clearNamespace();
    }

    /**
     * <p>
     * Tests constructor PasteNoteRelationshipAction(content, parent) if content is null.
     * IllegalArgumentException is expected.
     * </p>
     */
    public void testCtor1IfContentNull() {
        try {
            new PasteNoteRelationshipAction(null, parent);
            fail("IllegalArgumentException is expected because content cannot be null.");
        } catch (IllegalArgumentException e) {
            //success
        }
    }

    /**
     * <p>
     * Tests constructor PasteNoteRelationshipAction(content, parent) if content is not instance of Comment.
     * IllegalArgumentException is expected.
     * </p>
     */
    public void testCtor1IfContentNonComment() {
        try {
            new PasteNoteRelationshipAction(new Object(), parent);
            fail("IllegalArgumentException is expected because content must be instance of Comment.");
        } catch (IllegalArgumentException e) {
            //success
        }
    }

    /**
     * <p>
     * Tests constructor PasteNoteRelationshipAction(content, parent) if parent is null.
     * IllegalArgumentException is expected.
     * </p>
     */
    public void testCtor1IfParentNull() {
        try {
            new PasteNoteRelationshipAction(comment, null);
            fail("IllegalArgumentException is expected because parent cannot be null.");
        } catch (IllegalArgumentException e) {
            //success
        }
    }

    /**
     * <p>
     * Tests method undo() if action is already dead.
     * CannotUndoException is expected.
     * </p>
     */
    public void testUndoIfDead() {
        PasteNoteRelationshipAction action = new PasteNoteRelationshipAction(comment, parent);
        action.die();
        try {
            action.undo();
            fail("CannotUndoException is expected because action is already dead.");
        } catch (CannotUndoException e) {
            //success
        }
    }
}