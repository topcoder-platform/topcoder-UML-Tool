/*
 * Copyright (C) 2007 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.umltool.deploy.actions.undoable;

import junit.framework.TestCase;

import com.topcoder.diagraminterchange.GraphEdge;
import com.topcoder.gui.diagramviewer.DiagramView;
import com.topcoder.gui.diagramviewer.edges.Edge;
import com.topcoder.gui.diagramviewer.uml.activityelements.ActionState;
import com.topcoder.uml.model.statemachines.TransitionImpl;
import com.topcoder.umltool.deploy.DiagramType;
import com.topcoder.umltool.deploy.MainFrame;
import com.topcoder.umltool.deploy.TestHelper;

/**
 * <p>
 * Test the functionality of <code>AddTransitionAction</code> class.
 * </p>
 * @author ly, FireIce, ylouis
 * @version 1.0
 */
public class AddTransitionActionTest extends TestCase {

    /** An instance of <code>AddTransitionAction</code> for testing. */
    private AddTransitionAction action;

    /**
     * <p>
     * Sets up the test environment. The test instance is created.
     * </p>
     * @throws Exception
     *             to junit
     */
    protected void setUp() throws Exception {
        super.setUp();

        ActionState startNode = TestHelper.addActionState();
        ActionState targetNode = TestHelper.addActionState();
        action = new AddTransitionAction(TestHelper.getMainFrame(), TestHelper.getDiagramView(DiagramType.ACTIVITY),
                TestHelper.START, TestHelper.END, "AddTransitionAction", startNode, targetNode);
    }

    /**
     * Test method for 'AddTransitionAction(MainFrame, DiagramView, Point, Dimension, String)'. The instance should be
     * created successfully.
     */
    public void testAddTransitionAction_1() {
        assertNotNull(
                "Test method for 'AddTransitionAction(MainFrame, DiagramView, Point, Dimension, String)' failed.",
                action);
    }

    /**
     * Test method for 'AddTransitionAction(MainFrame, DiagramView, Point, Dimension, String, NodeContainer)'. The
     * instance should be created successfully.
     */
    public void testAddTransitionAction_2() {
        ActionState startNode = TestHelper.addActionState();
        MainFrame mainFrame = TestHelper.getMainFrame();
        DiagramView view = TestHelper.getDiagramView(DiagramType.ACTIVITY);
        AddTransitionAction action = new AddTransitionAction(mainFrame, view, TestHelper.START, TestHelper.END,
                "AddTransitionAction", startNode, new AddActionStateAction(mainFrame, view, TestHelper.POSITION,
                        TestHelper.SIZE, "Action State"));
        assertNotNull(
                "Test method for 'AddTransitionAction(MainFrame, DiagramView, Point, Dimension, String, NodeContainer)' failed.",
                action);
    }

    /**
     * Test method for 'createModelElement()'. The model element should have been created.
     */
    public void testCreateModelElement() {
        action.createModelElement();
        TransitionImpl transition = (TransitionImpl) TestHelper.getPrivateField(AddTransitionAction.class, action,
                "transition");
        assertNotNull("The model element should have been created.", transition);
    }

    /**
     * Test method for 'createGraphNode()'. The graph node should have been created.
     */
    public void testCreateGraphNode() {
        action.createModelElement();
        action.createGraphEdge();
        GraphEdge graphEdge = (GraphEdge) TestHelper.getPrivateField(AddTransitionAction.class, action, "graphEdge");
        assertNotNull("The graph node should have been created.", graphEdge);
    }

    /**
     * Test method for 'createNode()'. The node should have been created.
     */
    public void testCreateNode() {
        action.createModelElement();
        action.createGraphEdge();
        action.createEdge();
        Edge edge = (Edge) TestHelper.getPrivateField(AddEdgeAction.class, action, "edge");
        assertNotNull("The node should have been created.", edge);
    }

    /**
     * <p>
     * Tears down the test environment.
     * </p>
     */
    protected void tearDown() throws Exception {
        super.tearDown();
    }
}
