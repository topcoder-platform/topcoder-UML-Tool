/*
 * Copyright (C) 2007 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.uml.actions.auxiliary.comment.model;

import java.util.Collection;

import junit.framework.TestCase;

import com.topcoder.uml.actions.auxiliary.UnitTestHelper;
import com.topcoder.uml.model.core.ModelElement;
import com.topcoder.uml.model.core.ModelElementAbstractImpl;
import com.topcoder.uml.model.core.NamespaceAbstractImpl;
import com.topcoder.uml.model.core.auxiliaryelements.Comment;
import com.topcoder.uml.model.core.auxiliaryelements.CommentImpl;
import com.topcoder.uml.model.modelmanagement.Model;
import com.topcoder.uml.model.modelmanagement.ModelImpl;
import com.topcoder.uml.modelmanager.UMLModelManager;
import com.topcoder.uml.projectconfiguration.ProjectConfigurationManager;
import com.topcoder.util.actionmanager.ActionExecutionException;

/**
 * <p>
 * Unit tests on class <code>PasteNoteRelationshipAction</code>.
 * </p>
 * @version 1.0
 * @author TCSDEVELOPER
 */
public class PasteNoteRelationshipActionTest extends TestCase {
    /**
     * <p>
     * Instance of <code>PasteNoteRelationshipAction</code> used in this test.
     * </p>
     */
    private PasteNoteRelationshipAction action;
    /**
     * <p>
     * Instance of <code>Comment</code> used in this test.
     * </p>
     */
    private Comment comment;
    /**
     * <p>
     * Instance of <code>ModelElement</code> used in this test.
     * </p>
     */
    private ModelElement parent;
    /**
     * <p>
     * Instance of <code>UMLModelManager</code> used in this test.
     */
    private UMLModelManager manager;
    /**
     * <p>
     * Set up environment.
     * </p>
     * @throws Exception to JUnit
     */
    public void setUp() throws Exception {
        UnitTestHelper.loadConfig(UnitTestHelper.CONFIG_FILE);
        this.comment = new CommentImpl();
        this.parent = new ModelElementAbstractImpl() { };
        this.manager = new UMLModelManager();
        Model model = new ModelImpl();
        model.setNamespace(new NamespaceAbstractImpl() { });
        this.manager.setModel(model);
        this.manager.setProjectConfigurationManager(new ProjectConfigurationManager(this.manager));
        this.action = new PasteNoteRelationshipAction(this.comment, this.parent);
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
     * Test constructor <code>PasteNoteRelationshipAction(Object content, ModelElement parent</code>
     * for failure with null comment,
     * <code>IllegalArgumentException</code> is expected.
     * </p>
     */
    public void testCtor_NullComment() {
        try {
            new PasteNoteRelationshipAction(null, this.parent);
            fail("IllegalArgumentException is expected!");
        } catch (IllegalArgumentException e) {
            // expected
        }
    }
    /**
     * <p>
     * Test constructor <code>PasteNoteRelationshipAction(Object content, ModelElement parent</code>
     * for failure with non-Comment content,
     * <code>IllegalArgumentException</code> is expected.
     * </p>
     */
    public void testCtor_IllegalComment() {
        try {
            new PasteNoteRelationshipAction("String", this.parent);
            fail("IllegalArgumentException is expected!");
        } catch (IllegalArgumentException e) {
            // expected
        }
    }
    /**
     * <p>
     * Test constructor <code>PasteNoteRelationshipAction(Object content, ModelElement parent</code>
     * for failure with null parent,
     * <code>IllegalArgumentException</code> is expected.
     * </p>
     */
    public void testCtor_NullParent() {
        try {
            new PasteNoteRelationshipAction(this.comment, null);
            fail("IllegalArgumentException is expected!");
        } catch (IllegalArgumentException e) {
            // expected
        }
    }
    /**
     * <p>
     * Test constructor <code>PasteNoteRelationshipAction(Object content, ModelElement parent</code>
     * for accuracy.
     * </p>
     */
    public void testCtor_Accuracy() {
        assertNotNull("Failed to create the action!",
                new PasteNoteRelationshipAction(this.comment, this.parent));
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
        Collection<Comment> comments = this.parent.getComments();
        assertEquals("Failed to execute the action!", 1, comments.size());
        assertEquals("Failed to execute the action!", this.comment, comments.toArray()[0]);
        Collection<ModelElement> elements = comment.getAnnotatedElements();
        assertEquals("Failed to execute the action!", 1, elements.size());
        assertEquals("Failed to execute the action!", this.parent, elements.toArray()[0]);
    }
    /**
     * <p>
     * Test method <code>undo()</code>.
     * </p>
     * @throws ActionExecutionException to JUnit
     */
    public void testUndo() throws ActionExecutionException {
        // execute the action
        this.action.execute();
        Collection<Comment> comments = this.parent.getComments();
        assertEquals("Failed to execute the action!", 1, comments.size());
        assertEquals("Failed to execute the action!", this.comment, comments.toArray()[0]);
        Collection<ModelElement> elements = comment.getAnnotatedElements();
        assertEquals("Failed to execute the action!", 1, elements.size());
        assertEquals("Failed to execute the action!", this.parent, elements.toArray()[0]);

        // undo the action
        this.action.undo();
        assertTrue("Failed to undo the action!", this.comment.getAnnotatedElements().isEmpty());
        assertTrue("Failed to undo the action!", this.parent.getComments().isEmpty());
    }
    /**
     * <p>
     * Test method <code>getPresentationName()</code> for accuracy.
     * </p>
     */
    public void testGetPresentationName() {
        assertEquals("Incorrect name!", "Paste Note Relationship Action", this.action.getPresentationName());
    }
}
