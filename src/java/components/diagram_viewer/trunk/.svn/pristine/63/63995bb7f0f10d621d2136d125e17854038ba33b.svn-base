/*
 * Copyright (C) 2007 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.gui.diagramviewer;

import java.awt.Rectangle;

import junit.framework.TestCase;

import com.topcoder.diagraminterchange.Diagram;
import com.topcoder.diagraminterchange.Dimension;
import com.topcoder.diagraminterchange.Point;
import com.topcoder.gui.diagramviewer.event.SelectionEvent;

/**
 * <p>
 * Unit test cases for SelectionEvent.
 * </p>
 *
 * @author TCSDEVELOPER
 * @version 1.0
 */
public class SelectionEventUnitTests extends TestCase {

    /**
     * <p>
     * Rectangle DiagramView instance for testing.
     * </p>
     */
    private Rectangle rectangle;

    /**
     * DiagramView instance for testing.
     */
    private DiagramView source;

    /**
     * SelectionEvent instance for testing.
     */
    private SelectionEvent se;

    /**
     * Sets up the testing environment.
     *
     * @throws Exception when error occurs
     */
    protected void setUp() throws Exception {
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

        this.source = new DiagramViewer().createDiagramView(diagram);
        this.rectangle = new Rectangle();
        se = new SelectionEvent(this.source, this.rectangle);
    }

    /**
     * <p>
     * This is the accuracy test for constructor: SelectionEvent(DiagramView
     * source, Class type). <br>
     * Target: test the creation. <br>
     * </p>
     *
     * @throws Exception when error occurs
     */
    public void testCtor() throws Exception {
        assertNotNull("Failed to create SelectionEvent instance.", se);
    }

    /**
     * <p>
     * This is the failure test for constructor: SelectionEvent(DiagramView
     * source, Class type).<br>
     * Failure condition: at least one of the are is null. <br>
     * Expected: IllegalArgumentException. <br>
     * </p>
     *
     * @throws Exception when error occurs
     */
    public void testCtorWithNullValue() throws Exception {
        try {
            new SelectionEvent(null, this.rectangle);
            fail("IllegalArgumentException is excepted.");
        } catch (IllegalArgumentException e) {
            // pass.
        }

        try {
            new SelectionEvent(this.source, null);
            fail("IllegalArgumentException is excepted.");
        } catch (IllegalArgumentException e) {
            // pass.
        }
        try {
            new SelectionEvent(null, null);
            fail("IllegalArgumentException is excepted.");
        } catch (IllegalArgumentException e) {
            // pass.
        }
    }

    /**
     * <p>
     * This is the Accuracy test for Method: getSelectionRectangle().
     * </p>
     *
     * @throws Exception when error occurs
     */
    public void testGetSelectionRectangleAccuracy() throws Exception {
        assertEquals("Failed to get SelectionRectangle.", this.rectangle, se.getSelectionRectangle());

    }

}
