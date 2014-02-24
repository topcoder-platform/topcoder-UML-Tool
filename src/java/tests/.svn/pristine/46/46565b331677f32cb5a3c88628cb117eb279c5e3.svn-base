/*
 * Copyright (C) 2007 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.umltool.deploy.actions.undoable;

import junit.framework.TestCase;

import com.topcoder.gui.diagramviewer.DiagramView;
import com.topcoder.gui.diagramviewer.uml.usecaseelements.IncludeEdge;
import com.topcoder.gui.diagramviewer.uml.usecaseelements.UseCaseNode;
import com.topcoder.umltool.deploy.DiagramType;
import com.topcoder.umltool.deploy.MainFrame;
import com.topcoder.umltool.deploy.TestHelper;
import com.topcoder.util.actionmanager.ActionExecutionException;

/**
 * <p>
 * Test the functionality of <code>RemoveIncludeEdgeAction</code> class.
 * </p>
 * @author ly, FireIce, ylouis
 * @version 1.0
 */
public class RemoveIncludeEdgeActionTest extends TestCase {

    /**
     * Test method for 'RemoveIncludeEdgeAction(MainFrame, IncludeEdge)'. The instance should be created successfully.
     */
    public void testRemoveIncludeEdgeAction() {
        MainFrame mainFrame = TestHelper.getMainFrame();
        DiagramView view = TestHelper.getDiagramView(DiagramType.USECASE);
        UseCaseNode startNode = TestHelper.addUseCaseNode();
        UseCaseNode targetNode = TestHelper.addUseCaseNode();
        AddIncludeEdgeAction addAction = new AddIncludeEdgeAction(mainFrame, view, TestHelper.START, TestHelper.END,
                "IncludeEdge", startNode, targetNode);
        try {
            addAction.executeAction();
        } catch (ActionExecutionException e) {
            e.printStackTrace();
        }
        IncludeEdge edge = (IncludeEdge) addAction.getEdge();
        RemoveIncludeEdgeAction removeAction = new RemoveIncludeEdgeAction(TestHelper.getMainFrame(), edge);
        assertNotNull("Action instance should have been created.", removeAction);
    }
}
