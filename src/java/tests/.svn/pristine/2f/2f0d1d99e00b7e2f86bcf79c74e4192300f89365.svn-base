/*
 * Copyright (C) 2007 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.umltool.deploy.handlers;

import java.awt.Point;

import junit.framework.TestCase;

import com.topcoder.diagraminterchange.GraphNode;
import com.topcoder.gui.diagramviewer.elements.LocationEvent;
import com.topcoder.gui.diagramviewer.uml.usecaseelements.UseCaseNode;
import com.topcoder.umltool.deploy.TestHelper;

/**
 * <p>
 * Test the functionality of <code>NodeDragHandler</code> class.
 * </p>
 * @author ly, FireIce, ylouis
 * @version 1.0
 */
public class NodeDragHandlerTest extends TestCase {

    /** An instance of <code>NodeDragHandler</code> for testing. */
    private NodeDragHandler handler;

    /**
     * <p>
     * Sets up the test environment. The test instance is created.
     * </p>
     * @throws Exception
     *             to junit
     */
    protected void setUp() throws Exception {
        super.setUp();
        handler = new NodeDragHandler(TestHelper.getMainFrame());
    }

    /**
     * Test method for 'NodeDragHandler(MainFrame)'. The instance should be created successfully.
     */
    public void testNodeDragHandler_Accuracy() {
        assertNotNull("Test method for 'NodeDragHandler(MainFrame)' failed.", handler);
    }

    /**
     * Test method for 'NodeDragHandler(MainFrame)'. The argument is null, IllegalArgumentException should be thrown.
     */
    public void testEdgeMouseHandler_null() {
        try {
            new NodeDragHandler(null);
            fail("IllegalArgumentException should be thrown.");
        } catch (IllegalArgumentException iae) {
            // Success
        }
    }

    /**
     * Test method for 'nodeDragged(LocationEvent)'. A valid event is passed, node's bound should be changed correctly.
     */
    public void testNodeDragged_Accuracy() {
        UseCaseNode node = TestHelper.addUseCaseNode();
        TestHelper.getMainFrame().getDiagramViewer().addSelectedElement(node);
        GraphNode graphNode = node.getGraphNode();
        Point oldLocation = new Point();
        oldLocation.x = (int) graphNode.getPosition().getX();
        oldLocation.y = (int) graphNode.getPosition().getY();
        Point newLocation = new Point(oldLocation);
        newLocation.x *= 2;
        newLocation.y *= 2;

        LocationEvent event = new LocationEvent(node, oldLocation, newLocation);
        handler.nodeDragged(event);

        Point position = new Point();
        position.x = (int) graphNode.getPosition().getX();
        position.y = (int) graphNode.getPosition().getY();

        assertEquals("Test method for 'cornerDragged(SelectionBoundEvent)' failed.", position, newLocation);
    }

    /**
     * Test method for 'nodeDragged(LocationEvent)'. The argument is null, should be ignored.
     */
    public void testNodeDragged_null() {

        handler.nodeDragged(null);
    }

    /**
     * <p>
     * Tears down the test environment.
     * </p>
     */
    protected void tearDown() throws Exception {
        super.tearDown();
        handler = null;
    }
}
