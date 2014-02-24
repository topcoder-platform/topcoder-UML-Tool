/*
 * Copyright (C) 2007 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.umltool.deploy.actions.undoable;

import junit.framework.TestCase;

import com.topcoder.diagraminterchange.GraphNode;
import com.topcoder.gui.diagramviewer.elements.Node;
import com.topcoder.uml.model.modelmanagement.Subsystem;
import com.topcoder.umltool.deploy.DiagramType;
import com.topcoder.umltool.deploy.TestHelper;

/**
 * <p>
 * Test the functionality of <code>AddSubsystemNodeContainerAction</code> class.
 * </p>
 * @author ly, FireIce, ylouis
 * @version 1.0
 */
public class AddSubsystemNodeContainerActionTest extends TestCase {

    /** An instance of <code>AddSubsystemNodeContainerAction</code> for testing. */
    private AddSubsystemNodeContainerAction action;

    /**
     * <p>
     * Sets up the test environment. The test instance is created.
     * </p>
     * @throws Exception
     *             to junit
     */
    protected void setUp() throws Exception {
        super.setUp();

        action = new AddSubsystemNodeContainerAction(TestHelper.getMainFrame(), TestHelper
                .getDiagramView(DiagramType.USECASE), TestHelper.POSITION, TestHelper.SIZE,
                "AddSubsystemNodeContainerAction");
    }

    /**
     * Test method for 'AddSubsystemNodeContainerAction(MainFrame, DiagramView, Point, Dimension, String)'. The instance
     * should be created successfully.
     */
    public void testAddSubsystemNodeContainerAction_1() {
        assertNotNull(
                "Test method for 'AddSubsystemNodeContainerAction(MainFrame, DiagramView, Point, Dimension, String)' failed.",
                action);
    }

    /**
     * Test method for 'createModelElement()'. The model element should have been created.
     */
    public void testCreateModelElement() {
        Subsystem subsystem = (Subsystem) TestHelper.getPrivateField(AddSubsystemNodeContainerAction.class, action,
                "subsystem");
        assertNotNull("The model element should have been created.", subsystem);
    }

    /**
     * Test method for 'createGraphNode()'. The graph node should have been created.
     */
    public void testCreateGraphNode() {
        GraphNode graphNode = (GraphNode) TestHelper.getPrivateField(AddSubsystemNodeContainerAction.class, action,
                "graphNode");
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
