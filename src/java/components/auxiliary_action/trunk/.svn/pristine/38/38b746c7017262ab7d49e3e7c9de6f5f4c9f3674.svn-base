/*
 * Copyright (C) 2007 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.uml.actions.auxiliary.stresstests;

import java.awt.datatransfer.Clipboard;

import com.topcoder.diagraminterchange.Diagram;
import com.topcoder.diagraminterchange.GraphNode;
import com.topcoder.diagraminterchange.SimpleSemanticModelElement;
import com.topcoder.diagraminterchange.TextElement;
import com.topcoder.uml.actions.auxiliary.diagram.AddFreeTextAction;
import com.topcoder.uml.actions.auxiliary.diagram.CopyFreeTextAction;
import com.topcoder.uml.actions.auxiliary.diagram.CutFreeTextAction;
import com.topcoder.uml.actions.auxiliary.diagram.PasteFreeTextAction;
import com.topcoder.uml.actions.auxiliary.diagram.RemoveFreeTextAction;
import com.topcoder.uml.modelmanager.UMLModelManager;
import com.topcoder.uml.projectconfiguration.ProjectConfigurationManager;

import junit.framework.TestCase;

/**
 * <p>
 * Stress tests on FreeTextGraphNode actions.
 * </p>
 * 
 * @version 1.0
 * @author Achilles_2005
 */
public class FreeTextGraphNodeActionsStressTests extends TestCase {
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
     * Stress tests on FreeTextGraphNode actions.
     * </p>
     *
     * @throws Exception
     *             to JUnit
     */
    public void testFreeTextGraphNodeActions() throws Exception {
        GraphNode freeTextGraphNode = new GraphNode();
        SimpleSemanticModelElement ssme = new SimpleSemanticModelElement();
        ssme.setTypeInfo("FreeText");
        freeTextGraphNode.setSemanticModel(ssme);
        freeTextGraphNode.addContained(new TextElement());
        Diagram diagram = new Diagram();
        UMLModelManager manager = new UMLModelManager();
        manager.setProjectLanguage("Java");
        manager.setProjectConfigurationManager(new ProjectConfigurationManager(manager));
        long start = System.currentTimeMillis();
        for (int i = 0; i < NUM; i++) {
            // create an add action to add the node to the given diagram
            AddFreeTextAction action1 = new AddFreeTextAction(freeTextGraphNode, diagram, manager);
            action1.execute();
            // undo the action
            action1.undo();
            // redo the action
            action1.redo();

            // create a remove action
            RemoveFreeTextAction action2 = new RemoveFreeTextAction(freeTextGraphNode);

            // execute the action to remove the node from its diagram
            action2.execute();
            // undo the action
            action2.undo();
            // redo the action
            action2.redo();
            action2.undo();

            // create a copy action
            Clipboard clipboard = new Clipboard("Demo");
            CopyFreeTextAction action3 = new CopyFreeTextAction(freeTextGraphNode, clipboard);
            // copy to the given clipboard
            action3.execute();
            // copy to system clipboard
            action3 = new CopyFreeTextAction(freeTextGraphNode, null);
            action3.execute();

            // create a cut action
            CutFreeTextAction action4 = new CutFreeTextAction(freeTextGraphNode, clipboard);
            // remove from its diagram and copy to the given clipboard
            action4.execute();
            // undo the action
            action4.undo();
            // redo the action
            action4.redo();

            // create a paste action to add the node to the given diagram
            PasteFreeTextAction action5 = new PasteFreeTextAction(freeTextGraphNode, diagram);
            action5.execute();
            // undo the action
            action5.undo();
            // redo the action
            action5.redo();
        }
        System.out.println("FreeTextGraphNode actions : " + NUM + " times, " + (System.currentTimeMillis() - start)
                + " ms.");
    }
}
