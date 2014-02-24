/*
 * Copyright (C) 2007 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.uml.actions.auxiliary.stresstests;

import java.awt.datatransfer.Clipboard;

import com.topcoder.diagraminterchange.Diagram;
import com.topcoder.diagraminterchange.GraphNode;
import com.topcoder.diagraminterchange.Uml1SemanticModelBridge;
import com.topcoder.uml.actions.auxiliary.comment.diagram.AddCommentGraphNodeAction;
import com.topcoder.uml.actions.auxiliary.comment.diagram.CopyCommentGraphNodeAction;
import com.topcoder.uml.actions.auxiliary.comment.diagram.CutCommentGraphNodeAction;
import com.topcoder.uml.actions.auxiliary.comment.diagram.PasteCommentGraphNodeAction;
import com.topcoder.uml.actions.auxiliary.comment.diagram.RemoveCommentGraphNodeAction;
import com.topcoder.uml.model.core.auxiliaryelements.CommentImpl;
import com.topcoder.uml.modelmanager.UMLModelManager;
import com.topcoder.uml.projectconfiguration.ProjectConfigurationManager;

import junit.framework.TestCase;

/**
 * <p>
 * Stress tests on CommentGraphNode actions.
 * </p>
 * 
 * @version 1.0
 * @author Achilles_2005
 */
public class CommentGraphNodeActionsStressTests extends TestCase {
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

    public void testCommentGraphNodeActions() throws Exception {
        GraphNode commentGraphNode = new GraphNode();
        Uml1SemanticModelBridge usmb = new Uml1SemanticModelBridge();
        usmb.setElement(new CommentImpl());
        commentGraphNode.setSemanticModel(usmb);
        Diagram diagram = new Diagram();
        UMLModelManager manager = new UMLModelManager();
        manager.setProjectLanguage("Java");
        manager.setProjectConfigurationManager(new ProjectConfigurationManager(manager));
        long start = System.currentTimeMillis();
        for (int i = 0; i < NUM; i++) {
            // create an add action to add the node to the given diagram
            AddCommentGraphNodeAction action1 = new AddCommentGraphNodeAction(commentGraphNode, diagram, manager);
            action1.execute();
            // undo the action
            action1.undo();
            // redo the action
            action1.redo();

            // create a remove action
            RemoveCommentGraphNodeAction action2 = new RemoveCommentGraphNodeAction(commentGraphNode);
            // execute the action to remove the node from the diagram
            action2.execute();
            // undo the action
            action2.undo();
            // redo the action
            action2.redo();
            action2.undo();

            // create a copy action
            Clipboard clipboard = new Clipboard("Demo");
            CopyCommentGraphNodeAction action3 = new CopyCommentGraphNodeAction(commentGraphNode, clipboard);
            // copy to the given clipboard
            action3.execute();
            // copy to system clipboard
            action3 = new CopyCommentGraphNodeAction(commentGraphNode, null);
            action3.execute();

            // create a cut action
            CutCommentGraphNodeAction action4 = new CutCommentGraphNodeAction(commentGraphNode, clipboard);
            // remove from the diagram and copy to the given clipboard
            action4.execute();
            // undo the action
            action4.undo();
            // redo the action
            action4.redo();

            // create a paste action to add the node to the given diagram
            PasteCommentGraphNodeAction action5 = new PasteCommentGraphNodeAction(commentGraphNode, diagram);
            action5.execute();
            // undo the action
            action5.undo();
            // redo the action
            action5.redo();
        }
        System.out.println("CommentGraphNode actions : " + NUM + " times, " + (System.currentTimeMillis() - start)
                + " ms.");
    }
}
