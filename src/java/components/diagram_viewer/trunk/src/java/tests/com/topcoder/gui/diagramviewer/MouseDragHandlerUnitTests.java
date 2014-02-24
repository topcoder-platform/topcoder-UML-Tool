/*
 * Copyright (C) 2007 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.gui.diagramviewer;

import java.awt.Rectangle;
import java.awt.event.MouseEvent;

import junit.framework.TestCase;

import com.topcoder.diagraminterchange.Diagram;
import com.topcoder.diagraminterchange.Dimension;
import com.topcoder.diagraminterchange.Point;
import com.topcoder.gui.diagramviewer.elements.Node;
import com.topcoder.gui.diagramviewer.event.MouseDragHandler;

/**
 * <p>
 * Unit test cases for MouseDragHandler.
 * </p>
 *
 * @author TCSDEVELOPER
 * @version 1.0
 */

public class MouseDragHandlerUnitTests extends TestCase {

    /**
     * MouseEvent instance for testing.
     */
    private MouseEvent event;

    /**
     * MouseDragHandler instance for testing.
     */
    private MouseDragHandler mdh;

    /**
     * Sets up the testing environment.
     *
     * @throws Exception when error occurs
     */
    protected void setUp() throws Exception {
        // loads the valid configuration
        UnitTestsHelper.loadConfig("config.xml");
        mdh = new MouseDragHandler();
    }

    /**
     * <p>
     * This is the accuracy test for constructor: MouseDragHandler(). <br>
     * Target: test the creation. <br>
     * </p>
     *
     * @throws Exception when error occurs
     */
    public void testCtor1() throws Exception {
        assertNotNull("Failed to create MouseDragHandler instance.", mdh);
    }

    /**
     * <p>
     * This is the Accuracy test for Method: mousePressed(MouseEvent event).
     * </p>
     *
     * @throws Exception when error occurs
     */
    public void testMousePressedAccuracy() throws Exception {
        Diagram diagram = new Diagram();
        Dimension dimension = new Dimension();
        dimension.setWidth(500.0);
        dimension.setHeight(500.0);
        diagram.setSize(dimension);

        Point point = new Point();
        point.setX(5);
        point.setY(5);
        diagram.setPosition(point);

        DiagramViewer viewer = new DiagramViewer();
        viewer.setNewElementType(Node.class);
        event = new MouseEvent(viewer.createDiagramView(diagram), 0, 0, 0, 0, 0, 0, true);
        mdh.mousePressed(event);
        viewer.setState(DiagramState.ADD_ELEMENT_BY_DRAGGING_RECTANGLE);
        event = new MouseEvent(viewer.createDiagramView(diagram), 0, 0, 0, 0, 0, 0, true);

        mdh.mousePressed(event);
        viewer.setState(DiagramState.ADD_ELEMENT_BY_CLICK);
        event = new MouseEvent(viewer.createDiagramView(diagram), 0, 0, 0, 0, 0, 0, true);

        mdh.mousePressed(event);

    }

    /**
     * <p>
     * This is the Accuracy test for Method: mouseReleased(MouseEvent event).
     * </p>
     *
     * @throws Exception when error occurs
     */
    public void testMouseReleasedAccuracy() throws Exception {
        Diagram diagram = new Diagram();
        Dimension dimension = new Dimension();
        dimension.setWidth(500.0);
        dimension.setHeight(500.0);
        diagram.setSize(dimension);

        Point point = new Point();
        point.setX(5);
        point.setY(5);
        diagram.setPosition(point);

        DiagramViewer viewer = new DiagramViewer();
        viewer.setNewElementType(Node.class);
        event = new MouseEvent(viewer.createDiagramView(diagram), 0, 0, 0, 0, 0, 0, true);
        mdh.mouseReleased(event);
        viewer.setState(DiagramState.ADD_ELEMENT_BY_DRAGGING_RECTANGLE);
        event = new MouseEvent(viewer.createDiagramView(diagram), 0, 0, 0, 0, 0, 0, true);

        mdh.mouseReleased(event);

        viewer.setState(DiagramState.ADD_ELEMENT_BY_CLICK);
        event = new MouseEvent(viewer.createDiagramView(diagram), 0, 0, 0, 0, 0, 0, true);

        mdh.mouseReleased(event);


    }

    /**
     * <p>
     * This is the Accuracy test for Method: getDraggingRectangle().
     * </p>
     *
     * @throws Exception when error occurs
     */
    public void testGetDraggingRectangleAccuracy() throws Exception {
        assertEquals("Fail to get DraggingRectangle.", this.mdh.getDraggingRectangle(), new Rectangle(0, 0, 0, 0));
    }

    /**
     * <p>
     * This is the Accuracy test for Method: mouseMoved(MouseEvent event).
     * </p>
     *
     * @throws Exception when error occurs
     */
    public void testMouseMovedAccuracy() throws Exception {
        Diagram diagram = new Diagram();
        Dimension dimension = new Dimension();
        dimension.setWidth(500.0);
        dimension.setHeight(500.0);
        diagram.setSize(dimension);

        Point point = new Point();
        point.setX(5);
        point.setY(5);
        diagram.setPosition(point);

        DiagramViewer viewer = new DiagramViewer();
        viewer.setNewElementType(Node.class);
        event = new MouseEvent(viewer.createDiagramView(diagram), 0, 0, 0, 0, 0, 0, true);
        mdh.mouseMoved(event);

    }

}