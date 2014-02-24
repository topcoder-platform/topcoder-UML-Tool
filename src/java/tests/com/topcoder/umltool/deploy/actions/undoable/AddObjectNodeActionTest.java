/*
 * Copyright (C) 2007 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.umltool.deploy.actions.undoable;

import java.awt.Point;

import junit.framework.TestCase;

import com.topcoder.gui.diagramviewer.DiagramView;
import com.topcoder.gui.diagramviewer.uml.sequenceelements.ObjectNode;
import com.topcoder.umltool.deploy.DiagramType;
import com.topcoder.umltool.deploy.MainFrame;
import com.topcoder.umltool.deploy.TestHelper;
import com.topcoder.util.actionmanager.ActionExecutionException;

/**
 * <p>
 * Test the functionality of <code>AddObjectNodeAction</code> class.
 * </p>
 * @author ly, FireIce, ylouis
 * @version 1.0
 */
public class AddObjectNodeActionTest extends TestCase {
    /** Reference to main frame for testing */
    private MainFrame mainFrame;

    /** Reference to diagram view for testing */
    private DiagramView diagramView;

    /** Adding position of the object node */
    private Point position;

    /** Object node to add */
    private ObjectNode objectNode;

    /** An instance of <code>AddObjectNodeAction</code> for testing. */
    private AddObjectNodeAction action;

    /**
     * <p>
     * Sets up the test environment. The test instance is created.
     * </p>
     * @throws Exception
     *             to junit
     */
    protected void setUp() throws Exception {
        super.setUp();
        mainFrame = TestHelper.getMainFrame();
        diagramView = TestHelper.getDiagramView(DiagramType.SEQUENCE);

        position = new Point(100, 100);
        action = new AddObjectNodeAction(mainFrame, diagramView, position);
        objectNode = (ObjectNode) action.getNode();
    }

    /**
     * Test method for 'AddObjectNodeAction(MainFrame, DiagramView, Point)'. The action instance should not be null.
     */
    public void testAddObjectNodeAction_Accuracy() {
        assertNotNull("Test method for 'AddObjectNodeAction(MainFrame, DiagramView, Point)' failed.", action);
    }

    /**
     * Test method for 'AddObjectNodeAction(MainFrame, DiagramView, Point)'. The argument is null,
     * IllegalArgumentException should be thrown.
     */
    public void testAddObjectNodeAction_Null_1() {
        try {
            new AddObjectNodeAction(null, diagramView, position);
            fail("IllegalArgumentException should be thrown.");
        } catch (IllegalArgumentException iae) {
            // Success
        }
    }

    /**
     * Test method for 'AddObjectNodeAction(MainFrame, DiagramView, Point)'. The argument is null,
     * IllegalArgumentException should be thrown.
     */
    public void testAddObjectNodeAction_Null_2() {
        try {
            new AddObjectNodeAction(mainFrame, null, position);
            fail("IllegalArgumentException should be thrown.");
        } catch (IllegalArgumentException iae) {
            // Success
        }
    }

    /**
     * Test method for 'AddObjectNodeAction(MainFrame, DiagramView, Point)'. The argument is null,
     * IllegalArgumentException should be thrown.
     */
    public void testAddObjectNodeAction_Null_3() {
        try {
            new AddObjectNodeAction(mainFrame, diagramView, null);
            fail("IllegalArgumentException should be thrown.");
        } catch (IllegalArgumentException iae) {
            // Success
        }
    }

    /**
     * Test method for 'AddObjectNodeAction.executeAction()'. Object node should added to diagram view.
     */
    public void testExecuteAction() {
        try {
            action.executeAction();
        } catch (ActionExecutionException e) {
            fail(e.getMessage());
        }
        assertTrue("Object node should added to diagram view", TestHelper.isContainedInDiagramView(diagramView,
                objectNode));
        action.undoAction();
    }

    /**
     * Test method for 'AddObjectNodeAction.redoAction()'. Object node should added to diagram view.
     */
    public void testRedoAction() {
        try {
            action.executeAction();
        } catch (ActionExecutionException e) {
            fail(e.getMessage());
        }
        action.undoAction();
        action.redoAction();
        assertTrue("Object node should added to diagram view", TestHelper.isContainedInDiagramView(diagramView,
                objectNode));
        action.undoAction();
    }

    /**
     * Test method for 'AddObjectNodeAction.createModelElement()'
     */
    public void testCreateModelElement() {
        action.createModelElement();
        assertNotNull("Created model element should not be null", TestHelper.getPrivateField(AddObjectNodeAction.class,
                action, "object"));
    }

    /**
     * Test method for 'AddObjectNodeAction.createGraphNode()'
     */
    public void testCreateGraphNode() {
        action.createGraphNode();
        assertNotNull("Created graph node should not be null", TestHelper.getPrivateField(AddObjectNodeAction.class,
                action, "graphNode"));
    }

    /**
     * Test method for 'AddObjectNodeAction.createNode()'
     */
    public void testCreateNode() {
        action.createNode();
        assertNotNull("Created object node should not be null", TestHelper.getPrivateField(AddNodeAction.class, action,
                "node"));
    }

    /**
     * <p>
     * Tears down the test environment.
     * </p>
     */
    protected void tearDown() throws Exception {
        super.tearDown();

        mainFrame = null;
        diagramView = null;
        position = null;
        action = null;
    }

}
