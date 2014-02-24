/*
 * Copyright (C) 2007 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.umltool.deploy.actions.undoable;

import junit.framework.TestCase;

import com.topcoder.gui.diagramviewer.DiagramView;
import com.topcoder.gui.diagramviewer.uml.activityelements.InitialNode;
import com.topcoder.umltool.deploy.DiagramType;
import com.topcoder.umltool.deploy.MainFrame;
import com.topcoder.umltool.deploy.TestHelper;
import com.topcoder.util.actionmanager.ActionExecutionException;

/**
 * <p>
 * Test the functionality of <code>RemoveInitialNodeAction</code> class.
 * </p>
 * @author ly, FireIce, ylouis
 * @version 1.0
 */
public class RemoveInitialNodeActionTest extends TestCase {

    /**
     * Test method for 'RemoveInitialNodeAction(MainFrame, InitialNode)'. The instance should be created successfully.
     */
    public void testRemoveInitialNodeAction() {
        MainFrame mainFrame = TestHelper.getMainFrame();
        DiagramView view = TestHelper.getDiagramView(DiagramType.ACTIVITY);
        AddInitialNodeAction addAction = new AddInitialNodeAction(mainFrame, view, TestHelper.POSITION,
                TestHelper.SIZE, "InitialNode");
        try {
            addAction.executeAction();
        } catch (ActionExecutionException e) {
            e.printStackTrace();
        }
        InitialNode node = (InitialNode) addAction.getNode();
        RemoveInitialNodeAction removeAction = new RemoveInitialNodeAction(TestHelper.getMainFrame(), node);
        assertNotNull("Action instance should have been created.", removeAction);
    }
}
