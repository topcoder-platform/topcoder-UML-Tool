/*
 * Copyright (C) 2007 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.gui.diagramviewer;

import java.awt.event.MouseEvent;

import junit.framework.TestCase;

import com.topcoder.diagraminterchange.Diagram;
import com.topcoder.diagraminterchange.Dimension;
import com.topcoder.diagraminterchange.Point;
import com.topcoder.gui.diagramviewer.elements.Node;
import com.topcoder.gui.diagramviewer.event.SelectElementsHandler;

/**
 * <p>
 * Unit test cases for SelectElementsHandler.
 * </p>
 *
 * @author TCSDEVELOPER
 * @version 1.0
 */

public class SelectElementsHandlerUnitTests extends TestCase {
    /**
     * SelectElementsHandler instance for testing.
     */
    private SelectElementsHandler seh;

    /**
     * Sets up the testing environment.
     *
     * @throws Exception when error occurs
     */
    protected void setUp() throws Exception {
        UnitTestsHelper.loadConfig("config.xml");
        seh = new SelectElementsHandler();
    }

    /**
     * <p>
     * This is the accuracy test for constructor:
     * SelectElementsHandler(DiagramView source, Class type). <br>
     * Target: test the creation. <br>
     * </p>
     *
     * @throws Exception when error occurs
     */
    public void testCtor1() throws Exception {
        assertNotNull("Failed to create SelectElementsHandler instance.", seh);
    }

    /**
     * <p>
     * This is the Accuracy test for Method: mouseDragged(MouseEvent event).
     * </p>
     *
     * @throws Exception when error occurs
     */
    public void testMouseDraggedAccuracy() throws Exception {
        Diagram diagram = new Diagram();
        Dimension dimension = new Dimension();
        dimension.setWidth(500.0);
        dimension.setHeight(500.0);
        diagram.setSize(dimension);

        Point point = new Point();
        point.setX(5);
        point.setY(5);
        diagram.setPosition(point);

        MouseEvent event;
        DiagramViewer viewer = new DiagramViewer();
        viewer.setNewElementType(Node.class);
        event = new MouseEvent(viewer.createDiagramView(diagram), 0, 0, 0, 0, 0, 0, true);
        seh.mouseDragged(event);
        viewer.setState(DiagramState.ADD_ELEMENT_BY_DRAGGING_RECTANGLE);
        event = new MouseEvent(viewer.createDiagramView(diagram), 0, 0, 0, 0, 0, 0, true);

        seh.mouseDragged(event);
        viewer.setState(DiagramState.ADD_ELEMENT_BY_CLICK);
        event = new MouseEvent(viewer.createDiagramView(diagram), 0, 0, 0, 0, 0, 0, true);

        seh.mouseDragged(event);

    }

}
