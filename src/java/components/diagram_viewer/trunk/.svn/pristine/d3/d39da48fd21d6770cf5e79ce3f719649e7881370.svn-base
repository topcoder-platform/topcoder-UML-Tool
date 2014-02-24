/*
 * Copyright (C) 2007 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.gui.diagramviewer;

import java.awt.event.MouseEvent;

import com.topcoder.diagraminterchange.Diagram;
import com.topcoder.diagraminterchange.Dimension;
import com.topcoder.diagraminterchange.Point;
import com.topcoder.gui.diagramviewer.elements.Node;
import com.topcoder.gui.diagramviewer.event.AddNewElementHandler;

import junit.framework.TestCase;

/**
 * <p>
 * Unit test cases for AddNewElementHandler.
 * </p>
 *
 * @author TCSDEVELOPER
 * @version 1.0
 */
public class AddNewElementHandlerUnitTests extends TestCase {

    /**
     * MouseEvent instance for testing.
     */
    private MouseEvent event;

    /**
     * AddNewElementHandler instance for testing.
     */
    private AddNewElementHandler aneh;

    /**
     * Sets up the testing environment.
     *
     * @throws Exception when error occurs
     */
    protected void setUp() throws Exception {
        UnitTestsHelper.loadConfig("config.xml");
        aneh = new AddNewElementHandler();

    }

    /**
     * <p>
     * This is the accuracy test for constructor: AddNewElementHandler().<br>
     * Target: test the creation. <br>
     * </p>
     *
     * @throws Exception when error occurs
     */
    public void testCtor1() throws Exception {
        assertNotNull("Failed to create AddNewElementHandler instance.", aneh);
    }

    /**
     * <p>
     * This is the Accuracy test for Method: mouseClicked(MouseEvent event).
     * </p>
     *
     * @throws Exception when error occurs
     */
    public void testMouseClickedAccuracy() throws Exception {
        Diagram diagram = new Diagram();
        Dimension dimension = new Dimension();
        dimension.setWidth(500.0);
        dimension.setHeight(500.0);
        diagram.setSize(dimension);

        Point point = new Point();
        point.setX(5);
        point.setY(5);
        diagram.setPosition(point);
        event = new MouseEvent(new DiagramViewer().createDiagramView(diagram), 0, 0, 0, 0, 0, 0, true);
        aneh.mouseClicked(event);

    }

    /**
     * <p>
     * This is the Accuracy test for Method: mouseReleased(MouseEvent event).
     * </p>
     *
     * @throws Exception when error occurs
     */
    public void testMouseReleasedAccuracy() throws Exception {
        DiagramViewer viewer = new DiagramViewer();
        viewer.setNewElementType(Node.class);
        viewer.setState(DiagramState.ADD_ELEMENT_BY_DRAGGING_RECTANGLE);
        Diagram diagram = new Diagram();
        Dimension dimension = new Dimension();
        dimension.setWidth(500.0);
        dimension.setHeight(500.0);
        diagram.setSize(dimension);

        Point point = new Point();
        point.setX(5);
        point.setY(5);
        diagram.setPosition(point);
        event = new MouseEvent(viewer.createDiagramView(diagram), 0, 0, 0, 0, 0, 0, true);
        aneh.mouseReleased(event);

    }

}