/*
 * Copyright (C) 2007 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.umltool.deploy.actions.undoable;

import com.topcoder.gui.diagramviewer.DiagramView;
import com.topcoder.gui.diagramviewer.uml.activityelements.AcceptEventAction;
import com.topcoder.umltool.deploy.DiagramType;
import com.topcoder.umltool.deploy.MainFrame;
import com.topcoder.umltool.deploy.TestHelper;
import com.topcoder.util.actionmanager.ActionExecutionException;

import junit.framework.TestCase;

/**
 * <p>
 * Test the functionality of <code>RemoveAcceptEventActionAction</code> class.
 * </p>
 * @author ly, FireIce, ylouis
 * @version 1.0
 */
public class RemoveAcceptEventActionActionTest extends TestCase {

    /**
     * Test method for 'RemoveAcceptEventActionAction(MainFrame, AcceptEventAction)'. The instance should be created
     * successfully.
     */
    public void testRemoveAcceptEventActionAction() {
        MainFrame mainFrame = TestHelper.getMainFrame();
        DiagramView view = TestHelper.getDiagramView(DiagramType.ACTIVITY);
        AddAcceptEventActionAction addAction = new AddAcceptEventActionAction(mainFrame, view, TestHelper.POSITION,
                TestHelper.SIZE, "AcceptEventAction");
        try {
            addAction.executeAction();
        } catch (ActionExecutionException e) {
            e.printStackTrace();
        }
        AcceptEventAction node = (AcceptEventAction) addAction.getNode();
        RemoveAcceptEventActionAction removeAction = new RemoveAcceptEventActionAction(TestHelper.getMainFrame(), node);
        assertNotNull("Action instance should have been created.", removeAction);
    }
}
