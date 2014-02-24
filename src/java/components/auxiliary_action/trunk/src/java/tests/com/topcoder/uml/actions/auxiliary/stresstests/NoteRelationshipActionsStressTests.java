/*
 * Copyright (C) 2007 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.uml.actions.auxiliary.stresstests;

import java.awt.datatransfer.Clipboard;

import com.topcoder.uml.actions.auxiliary.comment.model.AddNoteRelationshipAction;
import com.topcoder.uml.actions.auxiliary.comment.model.CopyNoteRelationshipAction;
import com.topcoder.uml.actions.auxiliary.comment.model.CutNoteRelationshipAction;
import com.topcoder.uml.actions.auxiliary.comment.model.PasteNoteRelationshipAction;
import com.topcoder.uml.actions.auxiliary.comment.model.RemoveNoteRelationshipAction;
import com.topcoder.uml.model.core.ModelElement;
import com.topcoder.uml.model.core.ModelElementAbstractImpl;
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
 * Stress tests on NoteRelationship actions.
 * </p>
 * 
 * @version 1.0
 * @author Achilles_2005
 */
public class NoteRelationshipActionsStressTests extends TestCase {
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
     * Stress tests on NoteRelationship actions.
     * </p>
     * 
     * @throws Exception
     *             to JUnit
     */
    public void testNoteRelationshipActions() throws Exception {
        Comment comment = new CommentImpl();
        ModelElement parent = new ModelElementAbstractImpl() {
        };
        UMLModelManager manager = new UMLModelManager();
        Model model = new ModelImpl();
        model.setNamespace(new NamespaceAbstractImpl() {
        });
        manager.setModel(model);
        manager.setProjectLanguage("Java");
        manager.setProjectConfigurationManager(new ProjectConfigurationManager(manager));
        long start = System.currentTimeMillis();
        for (int i = 0; i < NUM; i++) {
            // create an add action to add the note to the given modelElement
            AddNoteRelationshipAction action1 = new AddNoteRelationshipAction(comment, parent, manager);
            action1.execute();
            // undo the action
            action1.undo();
            // redo the action
            action1.redo();

            // create a remove action
            RemoveNoteRelationshipAction action2 = new RemoveNoteRelationshipAction(comment);
            // execute the action to remove the note from its annotated elements
            action2.execute();
            // undo the action
            action2.undo();
            // redo the action
            action2.redo();
            action2.undo();

            // create a copy action
            Clipboard clipboard = new Clipboard("Demo");
            CopyNoteRelationshipAction action3 = new CopyNoteRelationshipAction(comment, clipboard);
            // copy to the given clipboard
            action3.execute();
            // copy to system clipboard
            action3 = new CopyNoteRelationshipAction(comment, null);
            action3.execute();

            // create a cut action
            CutNoteRelationshipAction action4 = new CutNoteRelationshipAction(comment, clipboard);
            // remove from its annotated elements and copy to the given
            // clipboard
            action4.execute();
            // undo the action
            action4.undo();
            // redo the action
            action4.redo();

            // create a paste action to add the note to the given modelElement
            PasteNoteRelationshipAction action5 = new PasteNoteRelationshipAction(comment, parent);
            action5.execute();
            // undo the action
            action5.undo();
            // redo the action
            action5.redo();
        }
        System.out.println("NoteRelationship actions : " + NUM + " times, "
                + (System.currentTimeMillis() - start) + " ms.");
    }
}
