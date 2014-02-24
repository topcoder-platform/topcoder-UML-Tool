/*
 * Copyright (C) 2007 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.umltool.deploy.actions.undoable;

import junit.framework.TestCase;

import com.topcoder.gui.diagramviewer.DiagramView;
import com.topcoder.gui.diagramviewer.uml.activityelements.ObjectFlowNode;
import com.topcoder.umltool.deploy.DiagramType;
import com.topcoder.umltool.deploy.MainFrame;
import com.topcoder.umltool.deploy.TestHelper;
import com.topcoder.util.actionmanager.ActionExecutionException;

/**
 * <p>
 * Test the functionality of <code>RemoveObjectFlowNodeAction</code> class.
 * </p>
 * @author ly, FireIce, ylouis
 * @version 1.0
 */
public class RemoveObjectFlowNodeActionTest extends TestCase {

    /**
     * Test method for 'RemoveObjectFlowNodeAction(MainFrame, ObjectFlowNode)'. The instance should be created
     * successfully.
     */
    public void testRemoveObjectFlowNodeAction() {
        MainFrame mainFrame = TestHelper.getMainFrame();
        DiagramView view = TestHelper.getDiagramView(DiagramType.ACTIVITY);
        AddObjectFlowNodeAction addAction = new AddObjectFlowNodeAction(mainFrame, view, TestHelper.POSITION,
                TestHelper.SIZE, "ObjectFlowNode");
        try {
            addAction.executeAction();
        } catch (ActionExecutionException e) {
            e.printStackTrace();
        }
        ObjectFlowNode node = (ObjectFlowNode) addAction.getNode();
        RemoveObjectFlowNodeAction removeAction = new RemoveObjectFlowNodeAction(TestHelper.getMainFrame(), node);
        assertNotNull("Action instance should have been created.", removeAction);
    }
}
