/*
 * Copyright (C) 2007 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.umltool.deploy.actions.undoable;

import junit.framework.TestCase;

import com.topcoder.gui.diagramviewer.DiagramView;
import com.topcoder.gui.diagramviewer.uml.usecaseelements.SubsystemNodeContainer;
import com.topcoder.umltool.deploy.DiagramType;
import com.topcoder.umltool.deploy.MainFrame;
import com.topcoder.umltool.deploy.TestHelper;
import com.topcoder.util.actionmanager.ActionExecutionException;

/**
 * <p>
 * Test the functionality of <code>RemoveSubsystemNodeContainerAction</code> class.
 * </p>
 * @author ly, FireIce, ylouis
 * @version 1.0
 */
public class RemoveSubsystemNodeContainerActionTest extends TestCase {

    /**
     * Test method for 'RemoveSubsystemNodeContainerAction(MainFrame, SubsystemNodeContainer)'. The instance should be
     * created successfully.
     */
    public void testRemoveSubsystemNodeContainerAction() {
        MainFrame mainFrame = TestHelper.getMainFrame();
        DiagramView view = TestHelper.getDiagramView(DiagramType.USECASE);
        AddSubsystemNodeContainerAction addAction = new AddSubsystemNodeContainerAction(mainFrame, view,
                TestHelper.POSITION, TestHelper.SIZE, "SubsystemNodeContainer");
        try {
            addAction.executeAction();
        } catch (ActionExecutionException e) {
            e.printStackTrace();
        }
        SubsystemNodeContainer node = (SubsystemNodeContainer) addAction.getNode();
        RemoveSubsystemNodeContainerAction removeAction = new RemoveSubsystemNodeContainerAction(TestHelper
                .getMainFrame(), node);
        assertNotNull("Action instance should have been created.", removeAction);
    }
}
