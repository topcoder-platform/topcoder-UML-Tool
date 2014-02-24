/*
 * Copyright (C) 2007 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.umltool.deploy.actions.undoable;

import junit.framework.TestCase;

import com.topcoder.diagraminterchange.GraphNode;
import com.topcoder.gui.diagramviewer.elements.Node;
import com.topcoder.uml.model.activitygraphs.ActionState;
import com.topcoder.umltool.deploy.DiagramType;
import com.topcoder.umltool.deploy.TestHelper;

/**
 * <p>
 * Test the functionality of <code>AddActionStateAction</code> class.
 * </p>
 * @author ly, FireIce, ylouis
 * @version 1.0
 */
public class AddActionStateActionTest extends TestCase {

    /** An instance of <code>AddActionStateAction</code> for testing. */
    private AddActionStateAction action;

    /**
     * <p>
     * Sets up the test environment. The test instance is created.
     * </p>
     * @throws Exception
     *             to junit
     */
    protected void setUp() throws Exception {
        super.setUp();

        action = new AddActionStateAction(TestHelper.getMainFrame(), TestHelper.getDiagramView(DiagramType.ACTIVITY),
                TestHelper.POSITION, TestHelper.SIZE, "AddActionStateAction");
    }

    /**
     * Test method for 'AddActionStateAction(MainFrame, DiagramView, Point, Dimension, String)'. The instance should be
     * created successfully.
     */
    public void testAddActionStateAction_1() {
        assertNotNull(
                "Test method for 'AddActionStateAction(MainFrame, DiagramView, Point, Dimension, String)' failed.",
                action);
    }

    /**
     * Test method for 'createModelElement()'. The model element should have been created.
     */
    public void testCreateModelElement() {
        ActionState element = (ActionState) TestHelper.getPrivateField(AddActionStateAction.class, action, "element");
        assertNotNull("The model element should have been created.", element);
    }

    /**
     * Test method for 'createGraphNode()'. The graph node should have been created.
     */
    public void testCreateGraphNode() {
        GraphNode graphNode = (GraphNode) TestHelper.getPrivateField(AddActionStateAction.class, action, "graphNode");
        assertNotNull("The graph node should have been created.", graphNode);
    }

    /**
     * Test method for 'createNode()'. The node should have been created.
     */
    public void testCreateNode() {
        Node node = (Node) TestHelper.getPrivateField(AddNodeAction.class, action, "node");
        assertNotNull("The node should have been created.", node);
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
