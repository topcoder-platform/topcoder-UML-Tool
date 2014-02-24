/*
 * Copyright (C) 2007 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.uml.actions.auxiliary.stresstests;

import java.awt.datatransfer.Clipboard;

import com.topcoder.uml.actions.auxiliary.comment.model.AddCommentAction;
import com.topcoder.uml.actions.auxiliary.comment.model.CopyCommentAction;
import com.topcoder.uml.actions.auxiliary.comment.model.CutCommentAction;
import com.topcoder.uml.actions.auxiliary.comment.model.PasteCommentAction;
import com.topcoder.uml.actions.auxiliary.comment.model.RemoveCommentAction;
import com.topcoder.uml.model.core.NamespaceAbstractImpl;
import com.topcoder.uml.model.core.auxiliaryelements.Comment;
import com.topcoder.uml.model.core.auxiliaryelements.CommentImpl;
import com.topcoder.uml.model.modelmanagement.Model;
import com.topcoder.uml.model.modelmanagement.ModelImpl;
import com.topcoder.uml.modelmanager.UMLModelManager;
import com.topcoder.uml.projectconfiguration.ProjectConfigurationManager;

import junit.framework.TestCase;

/**
 * <p>
 * Stress tests on Comment actions.
 * </p>
 * 
 * @version 1.0
 * @author Achilles_2005
 */
public class CommentActionsStressTests extends TestCase {
    /** Iteration number. */
    private static final int NUM = 500;

    /**
     * <p>
     * Set up the environment.
     * </p>
     */
    public void setUp() {
        TestHelper.loadConfig(TestHelper.CONFIG_FILE);
    }

    /**
     * <p>
     * Clear the environment.
     * </p>
     */
    public void tearDown() {
        TestHelper.clearConfig();
    }

    /**
     * <p>
     * Stress tests on Comment actions.
     * </p>
     * 
     * @throws Exception
     *             never happens
     */
    public void testCommentActions() throws Exception {
        Comment comment = new CommentImpl();
        UMLModelManager manager = new UMLModelManager();
        Model model = new ModelImpl();
        model.setNamespace(new NamespaceAbstractImpl() {
        });
        manager.setModel(model);
        manager.setProjectLanguage("Java");
        manager.setProjectConfigurationManager(new ProjectConfigurationManager(manager));
        long start = System.currentTimeMillis();
        for (int i = 0; i < NUM; i++) {
            // Create an add action
            AddCommentAction action1 = new AddCommentAction(comment, manager);
            // execute the action to add the comment to the Model.
            action1.execute();
            // execute action to add the comment to the given namespace
            action1 = new AddCommentAction(comment, model.getNamespace(), manager);
            action1.execute();
            // undo the action
            action1.undo();
            // redo the action
            action1.redo();

            // create a remove action
            RemoveCommentAction action2 = new RemoveCommentAction(comment);
            // execute the action to remove the comment from its namespace
            action2.execute();
            // undo the action
            action2.undo();
            // redo the action
            action2.redo();

            action2.undo();

            // create a copy action
            Clipboard clipboard = new Clipboard("Stress");
            CopyCommentAction action3 = new CopyCommentAction(comment, clipboard);
            // copy to the given clipboard
            action3.execute();
            // copy to system clipboard
            action3 = new CopyCommentAction(comment, null);
            action3.execute();

            // create a cut action
            CutCommentAction action4 = new CutCommentAction(comment, clipboard);

            // remove from its namespace and copy to the given clipboard
            action4.execute();
            // undo the action
            action4.undo();
            // redo the action
            action4.redo();

            // create a paste action
            PasteCommentAction action5 = new PasteCommentAction(comment, manager);
            // paste to the Model
            action5.execute();
            // paste to the given namespace
            action5 = new PasteCommentAction(comment, model.getNamespace(), manager);
            action5.execute();
            // undo the action
            action5.undo();
            // redo the action
            action5.redo();
        }
        System.out.println("Comment actions : " + NUM + " times, " + (System.currentTimeMillis() - start) + " ms.");
    }
}
