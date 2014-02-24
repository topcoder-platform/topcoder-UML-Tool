/*
 * Copyright (C) 2007 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.uml.actions.auxiliary.stresstests;

import java.awt.datatransfer.Clipboard;

import com.topcoder.diagraminterchange.Diagram;
import com.topcoder.diagraminterchange.GraphEdge;
import com.topcoder.diagraminterchange.Polyline;
import com.topcoder.uml.actions.auxiliary.diagram.AddPolylineAction;
import com.topcoder.uml.actions.auxiliary.diagram.CopyPolylineAction;
import com.topcoder.uml.actions.auxiliary.diagram.CutPolylineAction;
import com.topcoder.uml.actions.auxiliary.diagram.PastePolylineAction;
import com.topcoder.uml.actions.auxiliary.diagram.RemovePolylineAction;
import com.topcoder.uml.modelmanager.UMLModelManager;
import com.topcoder.uml.projectconfiguration.ProjectConfigurationManager;

import junit.framework.TestCase;

/**
 * <p>
 * Stress tests on PolylineGraphNode actions.
 * </p>
 * 
 * @version 1.0
 * @author Achilles_2005
 */
public class PolylineGraphNodeActionsStressTests extends TestCase {
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
     * Stress tests on PolylineGraphNode actions.
     * </p>
     * 
     * @throws Exception
     *             to JUnit
     */
    public void testPolylineGraphNodeActions() throws Exception {
        GraphEdge polylineGraphEdge = new GraphEdge();
        polylineGraphEdge.addContained(new Polyline());
        Diagram diagram = new Diagram();
        UMLModelManager manager = new UMLModelManager();
        manager.setProjectLanguage("Java");
        manager.setProjectConfigurationManager(new ProjectConfigurationManager(manager));
        long start = System.currentTimeMillis();
        for (int i = 0; i < NUM; i++) {
            // create an add action to add the edge to the given diagram
            AddPolylineAction action1 = new AddPolylineAction(polylineGraphEdge, diagram, manager);
            action1.execute();
            // undo the action
            action1.undo();
            // redo the action
            action1.redo();

            // create a remove action
            RemovePolylineAction action2 = new RemovePolylineAction(polylineGraphEdge);
            // execute the action to remove the edge from its diagram
            action2.execute();
            // undo the action
            action2.undo();
            // redo the action
            action2.redo();
            action2.undo();

            // create a copy action
            Clipboard clipboard = new Clipboard("Demo");
            CopyPolylineAction action3 = new CopyPolylineAction(polylineGraphEdge, clipboard);
            // copy to the given clipboard
            action3.execute();

            // copy to system clipboard
            action3 = new CopyPolylineAction(polylineGraphEdge, null);
            action3.execute();

            // create a cut action
            CutPolylineAction action4 = new CutPolylineAction(polylineGraphEdge, clipboard);
            // remove from its diagram and copy to the given clipboard
            action4.execute();
            // undo the action
            action4.undo();
            // redo the action
            action4.redo();

            // create a paste action to add the edge to the given diagram
            PastePolylineAction action5 = new PastePolylineAction(polylineGraphEdge, diagram);
            action5.execute();
            // undo the action
            action5.undo();
            // redo the action
            action5.redo();
        }
        System.out.println("PolylineGraphNode actions : " + NUM + " times, " + (System.currentTimeMillis() - start)
                + " ms.");
    }
}
