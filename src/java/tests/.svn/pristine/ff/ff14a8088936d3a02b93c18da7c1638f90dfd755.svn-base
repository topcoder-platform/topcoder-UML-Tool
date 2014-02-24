/*
 * Copyright (C) 2007 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.umltool.deploy.actions.undoable;

import junit.framework.TestCase;

import com.topcoder.gui.diagramviewer.DiagramView;
import com.topcoder.gui.diagramviewer.uml.usecaseelements.ExtendEdge;
import com.topcoder.gui.diagramviewer.uml.usecaseelements.UseCaseNode;
import com.topcoder.umltool.deploy.DiagramType;
import com.topcoder.umltool.deploy.MainFrame;
import com.topcoder.umltool.deploy.TestHelper;
import com.topcoder.util.actionmanager.ActionExecutionException;

/**
 * <p>
 * Test the functionality of <code>RemoveExtendEdgeAction</code> class.
 * </p>
 * @author ly, FireIce, ylouis
 * @version 1.0
 */
public class RemoveExtendEdgeActionTest extends TestCase {

    /**
     * Test method for 'RemoveExtendEdgeAction(MainFrame, ExtendEdge)'. The instance should be created successfully.
     */
    public void testRemoveExtendEdgeAction() {
        MainFrame mainFrame = TestHelper.getMainFrame();
        DiagramView view = TestHelper.getDiagramView(DiagramType.USECASE);
        UseCaseNode startNode = TestHelper.addUseCaseNode();
        UseCaseNode targetNode = TestHelper.addUseCaseNode();
        AddExtendEdgeAction addAction = new AddExtendEdgeAction(mainFrame, view, TestHelper.START, TestHelper.END,
                "ExtendEdge", startNode, targetNode);
        try {
            addAction.executeAction();
        } catch (ActionExecutionException e) {
            e.printStackTrace();
        }
        ExtendEdge edge = (ExtendEdge) addAction.getEdge();
        RemoveExtendEdgeAction removeAction = new RemoveExtendEdgeAction(TestHelper.getMainFrame(), edge);
        assertNotNull("Action instance should have been created.", removeAction);
    }
}
