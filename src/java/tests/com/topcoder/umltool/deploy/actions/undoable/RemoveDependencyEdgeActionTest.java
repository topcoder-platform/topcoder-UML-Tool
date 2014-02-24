/*
 * Copyright (C) 2007 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.umltool.deploy.actions.undoable;

import junit.framework.TestCase;

import com.topcoder.gui.diagramviewer.DiagramView;
import com.topcoder.gui.diagramviewer.uml.classedges.DependencyEdge;
import com.topcoder.gui.diagramviewer.uml.usecaseelements.UseCaseNode;
import com.topcoder.umltool.deploy.DiagramType;
import com.topcoder.umltool.deploy.MainFrame;
import com.topcoder.umltool.deploy.TestHelper;
import com.topcoder.util.actionmanager.ActionExecutionException;

/**
 * <p>
 * Test the functionality of <code>RemoveDependencyEdgeAction</code> class.
 * </p>
 * @author ly, FireIce, ylouis
 * @version 1.0
 */
public class RemoveDependencyEdgeActionTest extends TestCase {

    /**
     * Test method for 'RemoveDependencyEdgeAction(MainFrame, DependencyEdge)'. The instance should be created
     * successfully.
     */
    public void testRemoveDependencyEdgeAction() {
        MainFrame mainFrame = TestHelper.getMainFrame();
        DiagramView view = TestHelper.getDiagramView(DiagramType.USECASE);
        UseCaseNode startNode = TestHelper.addUseCaseNode();
        UseCaseNode targetNode = TestHelper.addUseCaseNode();
        AddDependencyEdgeAction addAction = new AddDependencyEdgeAction(mainFrame, view, TestHelper.START,
                TestHelper.END, "DependencyEdge", startNode, targetNode);
        try {
            addAction.executeAction();
        } catch (ActionExecutionException e) {
            e.printStackTrace();
        }
        DependencyEdge edge = (DependencyEdge) addAction.getEdge();
        RemoveDependencyEdgeAction removeAction = new RemoveDependencyEdgeAction(TestHelper.getMainFrame(), edge);
        assertNotNull("Action instance should have been created.", removeAction);
    }
}
