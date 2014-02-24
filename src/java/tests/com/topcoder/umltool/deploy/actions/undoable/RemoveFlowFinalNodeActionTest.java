/*
 * Copyright (C) 2007 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.umltool.deploy.actions.undoable;

import junit.framework.TestCase;

import com.topcoder.gui.diagramviewer.DiagramView;
import com.topcoder.gui.diagramviewer.uml.activityelements.FlowFinalNode;
import com.topcoder.umltool.deploy.DiagramType;
import com.topcoder.umltool.deploy.MainFrame;
import com.topcoder.umltool.deploy.TestHelper;
import com.topcoder.util.actionmanager.ActionExecutionException;

/**
 * <p>
 * Test the functionality of <code>RemoveFlowFinalNodeAction</code> class.
 * </p>
 * @author ly, FireIce, ylouis
 * @version 1.0
 */
public class RemoveFlowFinalNodeActionTest extends TestCase {

    /**
     * Test method for 'RemoveFlowFinalNodeAction(MainFrame, FlowFinalNode)'. The instance should be created
     * successfully.
     */
    public void testRemoveFlowFinalNodeAction() {
        MainFrame mainFrame = TestHelper.getMainFrame();
        DiagramView view = TestHelper.getDiagramView(DiagramType.ACTIVITY);
        AddFlowFinalNodeAction addAction = new AddFlowFinalNodeAction(mainFrame, view, TestHelper.POSITION,
                TestHelper.SIZE, "FlowFinalNode");
        try {
            addAction.executeAction();
        } catch (ActionExecutionException e) {
            e.printStackTrace();
        }
        FlowFinalNode node = (FlowFinalNode) addAction.getNode();
        RemoveFlowFinalNodeAction removeAction = new RemoveFlowFinalNodeAction(TestHelper.getMainFrame(), node);
        assertNotNull("Action instance should have been created.", removeAction);
    }
}
