/*
 * Copyright (C) 2007 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.umltool.deploy.actions.undoable;

import junit.framework.TestCase;

import com.topcoder.diagraminterchange.GraphNode;
import com.topcoder.gui.diagramviewer.elements.Node;
import com.topcoder.uml.model.usecases.UseCase;
import com.topcoder.umltool.deploy.DiagramType;
import com.topcoder.umltool.deploy.TestHelper;

/**
 * <p>
 * Test the functionality of <code>AddUseCaseNodeAction</code> class.
 * </p>
 * @author ly, FireIce, ylouis
 * @version 1.0
 */
public class AddUseCaseNodeActionTest extends TestCase {

    /** An instance of <code>AddUseCaseNodeAction</code> for testing. */
    private AddUseCaseNodeAction action;

    /**
     * <p>
     * Sets up the test environment. The test instance is created.
     * </p>
     * @throws Exception
     *             to junit
     */
    protected void setUp() throws Exception {
        super.setUp();

        action = new AddUseCaseNodeAction(TestHelper.getMainFrame(), TestHelper.getDiagramView(DiagramType.USECASE),
                TestHelper.POSITION, TestHelper.SIZE, "AddUseCaseNodeAction");
    }

    /**
     * Test method for 'AddUseCaseNodeAction(MainFrame, DiagramView, Point, Dimension, String)'. The instance should be
     * created successfully.
     */
    public void testAddUseCaseNodeAction_1() {
        assertNotNull(
                "Test method for 'AddUseCaseNodeAction(MainFrame, DiagramView, Point, Dimension, String)' failed.",
                action);
    }

    /**
     * Test method for 'AddUseCaseNodeAction(MainFrame, DiagramView, Point, Dimension, String, NodeContainer)'. The
     * instance should be created successfully.
     */
    public void testAddUseCaseNodeAction_2() {
        AddUseCaseNodeAction action = new AddUseCaseNodeAction(TestHelper.getMainFrame(), TestHelper
                .getDiagramView(DiagramType.USECASE), TestHelper.POSITION, TestHelper.SIZE, "AddUseCaseNodeAction",
                null);
        assertNotNull(
                "Test method for 'AddUseCaseNodeAction(MainFrame, DiagramView, Point, Dimension, String, NodeContainer)' failed.",
                action);
    }

    /**
     * Test method for 'createModelElement()'. The model element should have been created.
     */
    public void testCreateModelElement() {
        UseCase usecase = (UseCase) TestHelper.getPrivateField(AddUseCaseNodeAction.class, action, "usecase");
        assertNotNull("The model element should have been created.", usecase);
    }

    /**
     * Test method for 'createGraphNode()'. The graph node should have been created.
     */
    public void testCreateGraphNode() {
        GraphNode graphNode = (GraphNode) TestHelper.getPrivateField(AddUseCaseNodeAction.class, action, "graphNode");
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
