/*
 * Copyright (C) 2007 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.umltool.deploy.actions.undoable;

import junit.framework.TestCase;

import com.topcoder.gui.diagramviewer.DiagramView;
import com.topcoder.gui.diagramviewer.uml.activityelements.JoinNode;
import com.topcoder.umltool.deploy.DiagramType;
import com.topcoder.umltool.deploy.MainFrame;
import com.topcoder.umltool.deploy.TestHelper;
import com.topcoder.util.actionmanager.ActionExecutionException;

/**
 * <p>
 * Test the functionality of <code>RemoveJoinNodeAction</code> class.
 * </p>
 * @author ly, FireIce, ylouis
 * @version 1.0
 */
public class RemoveJoinNodeActionTest extends TestCase {

    /**
     * Test method for 'RemoveJoinNodeAction(MainFrame, JoinNode)'. The instance should be created successfully.
     */
    public void testRemoveJoinNodeAction() {
        MainFrame mainFrame = TestHelper.getMainFrame();
        DiagramView view = TestHelper.getDiagramView(DiagramType.ACTIVITY);
        AddJoinNodeAction addAction = new AddJoinNodeAction(mainFrame, view, TestHelper.POSITION, TestHelper.SIZE,
                "JoinNode");
        try {
            addAction.executeAction();
        } catch (ActionExecutionException e) {
            e.printStackTrace();
        }
        JoinNode node = (JoinNode) addAction.getNode();
        RemoveJoinNodeAction removeAction = new RemoveJoinNodeAction(TestHelper.getMainFrame(), node);
        assertNotNull("Action instance should have been created.", removeAction);
    }
}
