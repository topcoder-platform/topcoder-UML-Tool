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
import com.topcoder.uml.model.modelmanagement.Model;
import com.topcoder.uml.model.modelmanagement.ModelImpl;
import com.topcoder.uml.modelmanager.UMLModelManager;
import com.topcoder.uml.projectconfiguration.ProjectConfigurationManager;
import com.topcoder.util.actionmanager.ActionExecutionException;

/**
 * <p>
 * Unit tests on class <code>PasteCommentAction</code>.
 * </p>
 * @version 1.0
 * @author TCSDEVELOPER
 */
public class PasteCommentActionTest extends TestCase {
    /**
     * <p>
     * Instance of <code>PasteCommentAction</code> used in this test.
     * </p>
     */
    private PasteCommentAction action;
    /**
     * <p>
     * Instance of <code>Comment</code> used in this test.
     * </p>
     */
    private Comment comment;
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
        this.manager = new UMLModelManager();
        Model model = new ModelImpl();
        model.setNamespace(new NamespaceAbstractImpl() { });
        this.manager.setModel(model);
        this.manager.setProjectConfigurationManager(new ProjectConfigurationManager(this.manager));
        this.action = new PasteCommentAction(this.comment, this.manager);
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
     * Test constructor <code>PasteCommentAction(Object content, Namespace namespace, UMLModelManager modelManager)
     * </code> for failure with null comment, <code>IllegalArgumentException</code> is expected.
     * </p>
     */
    public void testCtor1_NullComment() {
        try {
            new PasteCommentAction(null, this.manager.getModel().getNamespace(), this.manager);
            fail("IllegalArgumentException is expected!");
        } catch (IllegalArgumentException e) {
            // expected
        }
    }
    /**
     * <p>
     * Test constructor <code>PasteCommentAction(Object content, Namespace namespace, UMLModelManager modelManager)
     * </code> for failure with non-Comment comment, <code>IllegalArgumentException</code> is expected.
     * </p>
     */
    public void testCtor1_IllegalComment() {
        try {
            new PasteCommentAction("String", this.manager.getModel().getNamespace(), this.manager);
            fail("IllegalArgumentException is expected!");
        } catch (IllegalArgumentException e) {
            // expected
        }
    }
    /**
     * <p>
     * Test constructor <code>PasteCommentAction(Object content, Namespace namespace, UMLModelManager modelManager)
     * </code> for failure with null namespace, <code>IllegalArgumentException</code> is expected.
     * </p>
     */
    public void testCtor1_NullNamespace() {
        try {
            new PasteCommentAction(this.comment, null, this.manager);
            fail("IllegalArgumentException is expected!");
        } catch (IllegalArgumentException e) {
            // expected
        }
    }
    /**
     * <p>
     * Test constructor <code>PasteCommentAction(Object content, Namespace namespace, UMLModelManager modelManager)
     * </code> for failure with null modelManager, <code>IllegalArgumentException</code> is expected.
     * </p>
     */
    public void testCtor1_NullModelManager() {
        try {
            new PasteCommentAction(this.comment, this.manager.getModel().getNamespace(), null);
            fail("IllegalArgumentException is expected!");
        } catch (IllegalArgumentException e) {
            // expected
        }
    }

    /**
     * <p>
     * Test constructor <code>PasteCommentAction(Object content, Namespace namespace, UMLModelManager modelManager)
     * </code> for accuracy.
     * </p>
     */
    public void testCtor1_Accuracy() {
        assertNotNull("Failed to create the action!",
                new PasteCommentAction(this.comment, this.manager.getModel().getNamespace(), this.manager));
    }
    /**
     * <p>
     * Test constructor <code>PasteCommentAction(Object content, UMLModelManager modelManager)
     * </code> for failure with null comment, <code>IllegalArgumentException</code> is expected.
     * </p>
     */
    public void testCtor2_NullComment() {
        try {
            new PasteCommentAction(null, this.manager);
            fail("PasteCommentAction is expected!");
        } catch (IllegalArgumentException e) {
            // expected
        }
    }
    /**
     * <p>
     * Test constructor <code>PasteCommentAction(Object content, UMLModelManager modelManager)
     * </code> for failure with non-Comment comment, <code>IllegalArgumentException</code> is expected.
     * </p>
     */
    public void testCtor2_IllegalComment() {
        try {
            new PasteCommentAction("String", this.manager);
            fail("IllegalArgumentException is expected!");
        } catch (IllegalArgumentException e) {
            // expected
        }
    }
    /**
     * <p>
     * Test constructor <code>PasteCommentAction(Object content, UMLModelManager modelManager)
     * </code> for failure with null modelManager, <code>IllegalArgumentException</code> is expected.
     * </p>
     */
    public void testCtor2_NullModelManager() {
        try {
            new PasteCommentAction(this.comment, null);
            fail("IllegalArgumentException is expected!");
        } catch (IllegalArgumentException e) {
            // expected
        }
    }
    /**
     * <p>
     * Test constructor <code>PasteCommentAction(Object content, UMLModelManager modelManager)
     * </code> for failure with modelManager has null namespace, <code>IllegalArgumentException</code> is expected.
     * </p>
     */
    public void testCtor2_NullModelInModelManager() {
        try {
            new PasteCommentAction(this.comment, new UMLModelManager());
            fail("IllegalArgumentException is expected!");
        } catch (IllegalArgumentException e) {
            // expected
        }
    }
    /**
     * <p>
     * Test constructor <code>PasteCommentAction(Object content, UMLModelManager modelManager)
     * </code> for failure with modelManager has null namespace, <code>IllegalArgumentException</code> is expected.
     * </p>
     */
    public void testCtor2_NullNamespaceInModelManager() {
        this.manager.getModel().setNamespace(null);
        try {
            new PasteCommentAction(this.comment, this.manager);
            fail("IllegalArgumentException is expected!");
        } catch (IllegalArgumentException e) {
            // expected
        }
    }
    /**
     * <p>
     * Test constructor <code>AddCommentAction(Comment comment, UMLModelManager modelManager)
     * </code> for accuracy.
     * </p>
     */
    public void testCtor2_Accuracy() {
        assertNotNull("Failed to create the action!",
                new PasteCommentAction(this.comment, this.manager));
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
        Namespace namespace = this.manager.getModel().getNamespace();
        Collection<ModelElement> ownedElements = namespace.getOwnedElements();
        assertEquals("Failed to execute the action!", 1, ownedElements.size());
        assertEquals("Failed to execute the action!", this.comment, ownedElements.toArray()[0]);
        assertEquals("Failed to execute the action!",
                this.manager.getModel().getNamespace(), this.comment.getNamespace());
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
        Namespace namespace = this.manager.getModel().getNamespace();
        Collection<ModelElement> ownedElements = namespace.getOwnedElements();
        assertEquals("Failed to execute the action!", 1, ownedElements.size());
        assertEquals("Failed to execute the action!", this.comment, ownedElements.toArray()[0]);
        assertEquals("Failed to execute the action!",
                this.manager.getModel().getNamespace(), this.comment.getNamespace());

        // undo the action
        this.action.undo();
        assertTrue("Failed to undo the action!", namespace.getOwnedElements().isEmpty());
        assertNull("Failed to undo the action!", this.comment.getNamespace());
    }
    /**
     * <p>
     * Test method <code>getPresentationName()</code> for accuracy.
     * </p>
     */
    public void testGetPresentationName() {
        assertEquals("Incorrect name!", "Paste Comment Action", this.action.getPresentationName());
    }
}
