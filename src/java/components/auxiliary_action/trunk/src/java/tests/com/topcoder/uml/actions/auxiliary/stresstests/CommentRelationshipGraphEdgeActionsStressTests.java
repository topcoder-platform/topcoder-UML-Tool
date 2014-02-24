/*
 * Copyright (C) 2007 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.uml.actions.auxiliary.stresstests;

import java.awt.datatransfer.Clipboard;

import com.topcoder.diagraminterchange.Diagram;
import com.topcoder.diagraminterchange.GraphEdge;
import com.topcoder.diagraminterchange.SimpleSemanticModelElement;
import com.topcoder.uml.actions.auxiliary.comment.diagram.AddCommentRelationshipGraphEdgeAction;
import com.topcoder.uml.actions.auxiliary.comment.diagram.CopyCommentRelationshipGraphEdgeAction;
import com.topcoder.uml.actions.auxiliary.comment.diagram.CutCommentRelationshipGraphEdgeAction;
import com.topcoder.uml.actions.auxiliary.comment.diagram.PasteCommentRelationshipGraphEdgeAction;
import com.topcoder.uml.actions.auxiliary.comment.diagram.RemoveCommentRelationshipGraphEdgeAction;
import com.topcoder.uml.modelmanager.UMLModelManager;
import com.topcoder.uml.projectconfiguration.ProjectConfigurationManager;

import junit.framework.TestCase;

/**
 * <p>
 * Stress tests on CommentRelationshipGraphEdge actions.
 * </p>
 * 
 * @version 1.0
 * @author Achilles_2005
 */
public class CommentRelationshipGraphEdgeActionsStressTests extends TestCase {
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
     * Stress tests on CommentRelationshipGraphEdge actions.
     * </p>
     * 
     * @throws Exception
     *             to JUnit
     */
    public void testCommentRelationshipGraphEdgeActions() throws Exception {
        GraphEdge commentGraphEdge = new GraphEdge();
        SimpleSemanticModelElement ssme = new SimpleSemanticModelElement();
        ssme.setTypeInfo("CommentLink");
        commentGraphEdge.setSemanticModel(ssme);
        Diagram diagram = new Diagram();
        UMLModelManager manager = new UMLModelManager();
        manager.setProjectLanguage("Java");
        manager.setProjectConfigurationManager(new ProjectConfigurationManager(manager));
        long start = System.currentTimeMillis();
        for (int i = 0; i < NUM; i++) {
            // create an add action to add the edge to the given diagram
            AddCommentRelationshipGraphEdgeAction action1 = new AddCommentRelationshipGraphEdgeAction(commentGraphEdge,
                    diagram, manager);
            action1.execute();
            // undo the action
            action1.undo();
            // redo the action
            action1.redo();

            // create a remove action
            RemoveCommentRelationshipGraphEdgeAction action2 = new RemoveCommentRelationshipGraphEdgeAction(
                    commentGraphEdge);
            // execute the action to remove the edge from its diagram
            action2.execute();
            // undo the action
            action2.undo();
            // redo the action
            action2.redo();
            action2.undo();

            // create a copy action
            Clipboard clipboard = new Clipboard("Demo");
            CopyCommentRelationshipGraphEdgeAction action3 = new CopyCommentRelationshipGraphEdgeAction(
                    commentGraphEdge, clipboard);
            // copy to the given clipboard
            action3.execute();
            // copy to system clipboard
            action3 = new CopyCommentRelationshipGraphEdgeAction(commentGraphEdge, null);
            action3.execute();

            // create a cut action
            CutCommentRelationshipGraphEdgeAction action4 = new CutCommentRelationshipGraphEdgeAction(commentGraphEdge,
                    clipboard);
            // remove from its diagram and copy to the given clipboard
            action4.execute();
            // undo the action
            action4.undo();
            // redo the action
            action4.redo();

            // create a paste action to add the edge to the given diagram
            PasteCommentRelationshipGraphEdgeAction action5 = new PasteCommentRelationshipGraphEdgeAction(
                    commentGraphEdge, diagram);
            action5.execute();
            // undo the action
            action5.undo();
            // redo the action
            action5.redo();
        }
        System.out.println("CommentRelationshipGraphEdge actions : " + NUM + " times, "
                + (System.currentTimeMillis() - start) + " ms.");
    }
}
