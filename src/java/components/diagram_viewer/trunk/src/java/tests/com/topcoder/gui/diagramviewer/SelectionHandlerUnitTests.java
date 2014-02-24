/*
 * Copyright (C) 2007 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.gui.diagramviewer;

import java.awt.Rectangle;

import com.topcoder.diagraminterchange.Diagram;
import com.topcoder.diagraminterchange.Dimension;
import com.topcoder.diagraminterchange.Point;
import com.topcoder.gui.diagramviewer.event.SelectionEvent;
import com.topcoder.gui.diagramviewer.event.SelectionHandler;

import junit.framework.TestCase;

/**
 * <p>
 * Unit test cases for SelectionHandler.
 * </p>
 *
 * @author TCSDEVELOPER
 * @version 1.0
 */
public class SelectionHandlerUnitTests extends TestCase {

    /**
     * SelectionHandler instance for testing.
     */
    private SelectionHandler hander;

    /**
     * Sets up the testing environment.
     *
     * @throws Exception when error occurs
     */
    protected void setUp() throws Exception {
        hander = new SelectionHandler();
    }

    /**
     * <p>
     * This is the accuracy test for constructor: SelectionHandler(). <br>
     * Target: test the creation. <br>
     * </p>
     *
     * @throws Exception when error occurs
     */
    public void testCtor() throws Exception {
        assertNotNull("Failed to create SelectionHandler instance.", this.hander);
    }

    /**
     * <p>
     * This is the Accuracy test for Method:
     * selectionRectangleChanged(SelectionEvent event).
     * </p>
     *
     * @throws Exception when error occurs
     */
    public void testSelectionRectangleChanged() throws Exception {
        UnitTestsHelper.loadConfig("config.xml");
        Diagram diagram = new Diagram();
        Dimension dimension = new Dimension();
        dimension.setWidth(500.0);
        dimension.setHeight(500.0);
        diagram.setSize(dimension);

        Point point = new Point();
        point.setX(5);
        point.setY(5);
        diagram.setPosition(point);
        DiagramView viewer = new DiagramViewer().createDiagramView(diagram);
        Rectangle rectangle = new Rectangle();
        SelectionEvent event = new SelectionEvent(viewer, rectangle);
        this.hander.selectionRectangleChanged(event);

    }

    /**
     * <p>
     * This is failure test for Method: selectionRectangleChanged(SelectionEvent
     * event).<br>
     * Failure condition: the event is null. <br>
     * Expected: IlleagalArgumentException. <br>
     * </p>
     *
     * @throws Exception when error occurs
     */
    public void testSelectionRectangleChangedWithNullEvent() throws Exception {
        try {
            this.hander.selectionRectangleChanged(null);
            fail("IlleagalArgumentException is excepted.");
        } catch (IllegalArgumentException e) {
            // pass.
        }
    }

}
