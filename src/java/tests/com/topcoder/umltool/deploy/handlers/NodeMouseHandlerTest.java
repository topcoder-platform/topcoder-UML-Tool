/*
 * Copyright (C) 2007 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.umltool.deploy.handlers;

import java.awt.Point;
import java.awt.event.MouseEvent;

import junit.framework.TestCase;

import com.topcoder.diagraminterchange.GraphNode;
import com.topcoder.gui.diagramviewer.uml.usecaseelements.UseCaseNode;
import com.topcoder.umltool.deploy.DiagramType;
import com.topcoder.umltool.deploy.TestHelper;

/**
 * <p>
 * Test the functionality of <code>NodeMouseHandler</code> class.
 * </p>
 * @author ly, FireIce, ylouis
 * @version 1.0
 */
public class NodeMouseHandlerTest extends TestCase {

    /** An instance of <code>NodeMouseHandler</code> for testing. */
    private NodeMouseHandler handler;

    /** An instance of UseCaseNode for testing. */
    private UseCaseNode node;

    /**
     * <p>
     * Sets up the test environment. The test instance is created.
     * </p>
     * @throws Exception
     *             to junit
     */
    protected void setUp() throws Exception {
        super.setUp();
        handler = new NodeMouseHandler(TestHelper.getMainFrame());
        node = TestHelper.addUseCaseNode();
        TestHelper.getDiagramView(DiagramType.USECASE);
    }

    /**
     * Test method for 'NodeMouseHandler(MainFrame)'. The argument is null, IllegalArgumentException should be thrown.
     */
    public void testNodeMouseHandler_null() {
        try {
            new NodeMouseHandler(null);
            fail("IllegalArgumentException should be thrown.");
        } catch (IllegalArgumentException iae) {
            // Success
        }
    }

    /**
     * Test method for 'NodeMouseHandler(MainFrame)'. The instance should be created successfully.
     */
    public void testNodeMouseHandler_Accuracy() {
        assertNotNull("Test method for 'NodeMouseHandler(MainFrame)' failed.", handler);
    }

    /**
     * Test method for 'mousePressed(MouseEvent)'. A valid event is given, should perform successfully.
     */
    public void testMousePressedMouseEvent_Accuracy() {
        Point point = new Point(150, 100);
        MouseEvent event = new MouseEvent(node, MouseEvent.MOUSE_PRESSED, 1000, MouseEvent.ALT_DOWN_MASK, point.x,
                point.y, 2, true, MouseEvent.BUTTON1);
        GraphNode graphNode = node.getGraphNode();
        com.topcoder.diagraminterchange.Point positon = graphNode.getPosition();
        handler.mousePressed(event);
        Point oldPosition = (Point) TestHelper.getPrivateField(NodeMouseHandler.class, handler, "oldPosition");
        assertEquals("Old position should be recorded.", oldPosition.getX(), positon.getX());
        assertEquals("Old position should be recorded.", oldPosition.getY(), positon.getY());
    }

    /**
     * Test method for 'mousePressed(MouseEvent)'. The argument is null, should be ignored.
     */
    public void testMousePressedMouseEvent_null() {
        handler.mousePressed(null);
    }

    /**
     * Test method for 'mouseReleased(MouseEvent)'. A valid event is given, should perform successfully.
     */
    public void testMouseReleasedMouseEvent_Accuracy() {
        MouseEvent event1 = new MouseEvent(node, MouseEvent.MOUSE_PRESSED, 1000, MouseEvent.ALT_DOWN_MASK, 150, 100, 2,
                true, MouseEvent.BUTTON1);
        handler.mousePressed(event1);

        Point point = new Point(250, 100);
        MouseEvent event = new MouseEvent(node, MouseEvent.MOUSE_RELEASED, 1000, MouseEvent.ALT_DOWN_MASK, point.x,
                point.y, 2, true, MouseEvent.BUTTON1);
        GraphNode graphNode = node.getGraphNode();
        com.topcoder.diagraminterchange.Point newPosition = new com.topcoder.diagraminterchange.Point();
        newPosition.setX(500);
        newPosition.setY(300);
        graphNode.setPosition(newPosition);
        handler.mouseReleased(event);
        com.topcoder.diagraminterchange.Point position = graphNode.getPosition();
        assertEquals("New position of graph node should be kept.", position.getX(), newPosition.getX());
        assertEquals("New position of graph node should be kept.", position.getY(), newPosition.getY());
    }

    /**
     * Test method for 'mouseReleased(MouseEvent)'. The argument is null, should be ignored.
     */
    public void testmouseReleasedMouseEvent_null() {
        handler.mouseReleased(null);
    }

    /**
     * <p>
     * Tears down the test environment.
     * </p>
     */
    protected void tearDown() throws Exception {
        super.tearDown();
        handler = null;
        TestHelper.getDiagramView(DiagramType.USECASE).removeAll();
        node = null;
    }
}
