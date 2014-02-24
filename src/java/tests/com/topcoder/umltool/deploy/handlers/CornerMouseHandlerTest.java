/*
 * Copyright (C) 2007 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.umltool.deploy.handlers;

import java.awt.Point;
import java.awt.event.MouseEvent;

import com.topcoder.diagraminterchange.Dimension;
import com.topcoder.diagraminterchange.GraphNode;
import com.topcoder.gui.diagramviewer.elements.SelectionCorner;
import com.topcoder.gui.diagramviewer.uml.usecaseelements.UseCaseNode;
import com.topcoder.umltool.deploy.TestHelper;

import junit.framework.TestCase;

/**
 * <p>
 * Test the functionality of <code>CornerMouseHandler</code> class.
 * </p>
 * @author ly, FireIce, ylouis
 * @version 1.0
 */
public class CornerMouseHandlerTest extends TestCase {

    /** An instance of <code>CornerMouseHandler</code> for testing. */
    private CornerMouseHandler handler;

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
        handler = new CornerMouseHandler(TestHelper.getMainFrame());
        node = TestHelper.addUseCaseNode();
    }

    /**
     * Test method for 'CornerMouseHandler(MainFrame)'. The instance should be created successfully.
     */
    public void testCornerMouseHandler_Accuracy() {
        assertNotNull("Test method for 'CornerMouseHandler(MainFrame)' failed.", handler);
    }

    /**
     * Test method for 'CornerMouseHandler(MainFrame)'. The argument is null, IllegalArgumentException should be thrown.
     */
    public void testCornerMouseHandler_null() {
        try {
            new CornerMouseHandler(null);
            fail("IllegalArgumentException should be thrown.");
        } catch (IllegalArgumentException iae) {
            // Success
        }
    }

    /**
     * Test method for 'mousePressed(MouseEvent)'. A valid event is given, should perform successfully.
     */
    public void testMousePressedMouseEvent_Accuracy() {
        SelectionCorner corner = node.getSelectionCorners().iterator().next();
        Point point = new Point(150, 100);
        MouseEvent event = new MouseEvent(corner, MouseEvent.MOUSE_PRESSED, 1000, MouseEvent.ALT_DOWN_MASK, point.x,
                point.y, 2, true, MouseEvent.BUTTON1);
        GraphNode graphNode = node.getGraphNode();
        com.topcoder.diagraminterchange.Point positon = graphNode.getPosition();
        Dimension size = graphNode.getSize();
        handler.mousePressed(event);
        com.topcoder.diagraminterchange.Point oldPosition = (com.topcoder.diagraminterchange.Point) TestHelper
                .getPrivateField(CornerMouseHandler.class, handler, "oldPosition");
        Dimension oldSize = (Dimension) TestHelper.getPrivateField(CornerMouseHandler.class, handler, "oldSize");
        assertEquals("Old position should be recorded.", oldPosition.getX(), positon.getX());
        assertEquals("Old position should be recorded.", oldPosition.getY(), positon.getY());
        assertEquals("Old size should be recored.", oldSize.getWidth(), size.getWidth());
        assertEquals("Old size should be recored.", oldSize.getHeight(), size.getHeight());
    }

    /**
     * Test method for 'mousePressed(MouseEvent)'. The argument is null, should be ignored.
     */
    public void testMousePressedMouseEvent_null() {
        handler.mousePressed(null);
    }

    /**
     * Test method for 'mouseReleased(MouseEvent)'.A valid event is given, should perform successfully.
     */
    public void testMouseReleasedMouseEvent_Accuracy() {
        SelectionCorner corner = node.getSelectionCorners().iterator().next();
        Point point = new Point(250, 100);
        MouseEvent event = new MouseEvent(corner, MouseEvent.MOUSE_RELEASED, 1000, MouseEvent.ALT_DOWN_MASK, point.x,
                point.y, 2, true, MouseEvent.BUTTON1);
        GraphNode graphNode = node.getGraphNode();
        com.topcoder.diagraminterchange.Point newPosition = new com.topcoder.diagraminterchange.Point();
        newPosition.setX(500);
        newPosition.setY(300);
        Dimension newSize = new Dimension();
        newSize.setWidth(200);
        newSize.setHeight(200);
        graphNode.setPosition(newPosition);
        graphNode.setSize(newSize);
        handler.mouseReleased(event);
        com.topcoder.diagraminterchange.Point position = graphNode.getPosition();
        Dimension size = graphNode.getSize();
        assertEquals("New position of graph node should be kept.", position.getX(), newPosition.getX());
        assertEquals("New position of graph node should be kept.", position.getY(), newPosition.getY());
        assertEquals("New size of graph node should be kept.", size.getWidth(), newSize.getWidth());
        assertEquals("New size of graph node should be kept.", size.getHeight(), newSize.getHeight());
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
        node = null;
    }

}
