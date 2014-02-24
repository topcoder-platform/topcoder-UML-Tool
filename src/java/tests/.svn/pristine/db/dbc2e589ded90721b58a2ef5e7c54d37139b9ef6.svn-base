/*
 * Copyright (C) 2007 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.umltool.deploy.actions.undoable;

import junit.framework.TestCase;

import com.topcoder.gui.diagramviewer.DiagramView;
import com.topcoder.gui.diagramviewer.uml.activityelements.ActionState;
import com.topcoder.gui.diagramviewer.uml.activityelements.Transition;
import com.topcoder.umltool.deploy.DiagramType;
import com.topcoder.umltool.deploy.MainFrame;
import com.topcoder.umltool.deploy.TestHelper;
import com.topcoder.util.actionmanager.ActionExecutionException;

/**
 * <p>
 * Test the functionality of <code>RemoveTransitionAction</code> class.
 * </p>
 * @author ly, FireIce, ylouis
 * @version 1.0
 */
public class RemoveTransitionActionTest extends TestCase {

    /**
     * Test method for 'RemoveTransitionAction(MainFrame, Transition)'. The instance should be created successfully.
     */
    public void testRemoveTransitionAction() {
        MainFrame mainFrame = TestHelper.getMainFrame();
        DiagramView view = TestHelper.getDiagramView(DiagramType.ACTIVITY);
        ActionState startNode = TestHelper.addActionState();
        ActionState targetNode = TestHelper.addActionState();
        AddTransitionAction addAction = new AddTransitionAction(mainFrame, view, TestHelper.START, TestHelper.END,
                "Transition", startNode, targetNode);
        try {
            addAction.executeAction();
        } catch (ActionExecutionException e) {
            e.printStackTrace();
        }
        Transition edge = (Transition) addAction.getEdge();
        RemoveTransitionAction removeAction = new RemoveTransitionAction(TestHelper.getMainFrame(), edge);
        assertNotNull("Action instance should have been created.", removeAction);
    }
}
