/*
 * Copyright (C) 2007 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.umltool.deploy.actions.undoable;

import junit.framework.TestCase;

import com.topcoder.gui.diagramviewer.DiagramView;
import com.topcoder.gui.diagramviewer.uml.activityelements.DecisionNode;
import com.topcoder.umltool.deploy.DiagramType;
import com.topcoder.umltool.deploy.MainFrame;
import com.topcoder.umltool.deploy.TestHelper;
import com.topcoder.util.actionmanager.ActionExecutionException;

/**
 * <p>
 * Test the functionality of <code>RemoveDecisionNodeAction</code> class.
 * </p>
 * @author ly, FireIce, ylouis
 * @version 1.0
 */
public class RemoveDecisionNodeActionTest extends TestCase {

    /**
     * Test method for 'RemoveDecisionNodeAction(MainFrame, DecisionNode)'. The instance should be created successfully.
     */
    public void testRemoveDecisionNodeAction() {
        MainFrame mainFrame = TestHelper.getMainFrame();
        DiagramView view = TestHelper.getDiagramView(DiagramType.ACTIVITY);
        AddDecisionNodeAction addAction = new AddDecisionNodeAction(mainFrame, view, TestHelper.POSITION,
                TestHelper.SIZE, "DecisionNode");
        try {
            addAction.executeAction();
        } catch (ActionExecutionException e) {
            e.printStackTrace();
        }
        DecisionNode node = (DecisionNode) addAction.getNode();
        RemoveDecisionNodeAction removeAction = new RemoveDecisionNodeAction(TestHelper.getMainFrame(), node);
        assertNotNull("Action instance should have been created.", removeAction);
    }
}
