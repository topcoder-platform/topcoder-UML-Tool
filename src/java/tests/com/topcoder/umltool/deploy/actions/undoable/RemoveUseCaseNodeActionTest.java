/*
 * Copyright (C) 2007 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.umltool.deploy.actions.undoable;

import junit.framework.TestCase;

import com.topcoder.gui.diagramviewer.DiagramView;
import com.topcoder.gui.diagramviewer.uml.usecaseelements.UseCaseNode;
import com.topcoder.umltool.deploy.DiagramType;
import com.topcoder.umltool.deploy.MainFrame;
import com.topcoder.umltool.deploy.TestHelper;
import com.topcoder.util.actionmanager.ActionExecutionException;

/**
 * <p>
 * Test the functionality of <code>RemoveUseCaseNodeAction</code> class.
 * </p>
 * @author ly, FireIce, ylouis
 * @version 1.0
 */
public class RemoveUseCaseNodeActionTest extends TestCase {

    /**
     * Test method for 'RemoveUseCaseNodeAction(MainFrame, UseCaseNode)'. The instance should be created successfully.
     */
    public void testRemoveUseCaseNodeAction() {
        MainFrame mainFrame = TestHelper.getMainFrame();
        DiagramView view = TestHelper.getDiagramView(DiagramType.USECASE);
        AddUseCaseNodeAction addAction = new AddUseCaseNodeAction(mainFrame, view, TestHelper.POSITION,
                TestHelper.SIZE, "UseCaseNode");
        try {
            addAction.executeAction();
        } catch (ActionExecutionException e) {
            e.printStackTrace();
        }
        UseCaseNode node = (UseCaseNode) addAction.getNode();
        RemoveUseCaseNodeAction removeAction = new RemoveUseCaseNodeAction(TestHelper.getMainFrame(), node);
        assertNotNull("Action instance should have been created.", removeAction);
    }
}
