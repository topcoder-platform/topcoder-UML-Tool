/*
 * Copyright (C) 2007 TopCoder Inc., All Rights Reserved.
 */

package com.topcoder.gui.diagramviewer;

import java.awt.Graphics;
import java.awt.Rectangle;

import javax.swing.TransferHandler;

import com.topcoder.diagraminterchange.Diagram;
import com.topcoder.diagraminterchange.Dimension;
import com.topcoder.diagraminterchange.Point;

import junit.framework.TestCase;

/**
 * <p>
 * Unit test cases for DiagramView.
 * </p>
 *
 * @author TCSDEVELOPER
 * @version 1.0
 */
public class DiagramViewUnitTests extends TestCase {

    /**
     * DiagramViewer instance for testing.
     */
    private DiagramViewer viewer;

    /**
     * DiagramView instance for testing.
     */
    private DiagramView view;

    /**
     * Diagram instance for testing.
     */
    private Diagram diagram;

    /**
     * Sets up the testing environment.
     *
     * @throws Exception when error occurs
     */
    protected void setUp() throws Exception {
        // loads the configuration
        UnitTestsHelper.loadConfig("config.xml");
        viewer = new DiagramViewer();
        diagram = new Diagram();
        diagram.setName("Mock Diagram");
        Dimension dimension = new Dimension();
        dimension.setWidth(500.0);
        dimension.setHeight(500.0);
        diagram.setSize(dimension);
        Point point = new Point();
        point.setX(5);
        point.setY(5);
        diagram.setPosition(point);
        Diagram diagram2 = new Diagram();
        diagram2.setSize(dimension);
        diagram2.setPosition(point);
        diagram.setContainer(diagram2);
        viewer.setBackgroundGridVisible(true);
        view = viewer.createDiagramView(diagram);
        view.setDraggingRectangleVisible(true);
    }

    /**
     * Clears the testing environment.
     *
     * @throws Exception when error occurs
     */
    protected void tearDown() throws Exception {
        UnitTestsHelper.removeAllNamespaces();
    }

    /**
     * <p>
     * This is the accuracy test for constructor: DiagramView(Diagram diagram,
     * DiagramViewer viewer). <br>
     * Target: test the creation. <br>
     * </p>
     *
     * @throws Exception when error occurs
     */
    public void testCtor() throws Exception {
        assertNotNull("Failed to create DiagramView instance.", new DiagramView(diagram, viewer));
        assertNotNull("Failed to create DiagramView instance.", this.view);
    }

    /**
     * <p>
     * This is the failure test for constructor: DiagramView(Diagram diagram,
     * DiagramViewer viewer).<br>
     * Failure condition: at least one of the arg is null. <br>
     * Expected: IllegalArgumentException. <br>
     * </p>
     *
     * @throws Exception when error occurs
     */
    public void testCtorWithInValidValue() throws Exception {
        try {
            new DiagramView(null, viewer);
            fail("IllegalArgumentException is excepted.");
        } catch (IllegalArgumentException e) {
            // pass.
        }

        try {
            new DiagramView(diagram, null);
            fail("IllegalArgumentException is excepted.");
        } catch (IllegalArgumentException e) {
            // pass.
        }

        try {
            new DiagramView(null, null);
            fail("IllegalArgumentException is excepted.");
        } catch (IllegalArgumentException e) {
            // pass.
        }

    }

    /**
     * <p>
     * This is the Accuracy test for Method: paintComponent(Graphics graphics).
     * </p>
     *
     * @throws Exception when error occurs
     */
    public void testPaintComponentAccuracy() throws Exception {
        Graphics graphics = new MockGrahpics();
        graphics.create(0, 0, 10, 10);
        view.paintComponent(graphics);
    }

    /**
     * <p>
     * This is the Accuracy test for Method: getDiagram().
     * </p>
     *
     * @throws Exception when error occurs
     */
    public void testGetDiagramAccuracy() throws Exception {
        assertEquals("Fail to get Diagram", this.diagram, view.getDiagram());
    }

    /**
     * <p>
     * This is the Accuracy test for Method: getViewer().
     * </p>
     *
     * @throws Exception when error occurs
     */
    public void testGetViewerAccuracy() throws Exception {
        assertEquals("Fail to get DiagramViewer", this.viewer, view.getViewer());
    }

    /**
     * <p>
     * This is the Accuracy test for Method: setTransferHandler(TransferHandler
     * newTransferHandler) .
     * </p>
     *
     * @throws Exception when error occurs
     */
    public void testSetTransferHandlerAccuracy() throws Exception {
        this.view.setTransferHandler(new TransferHandler("Test"));
    }

    /**
     * <p>
     * This is the failure test for constructor: notifyDiagramChanged().<br>
     * Failure condition: The handler is null. <br>
     * Expected: IllegalArgumentException. <br>
     * </p>
     *
     * @throws Exception when error occurs
     */
    public void testSetTransferHandlerWithNull() throws Exception {
        try {
            this.view.setTransferHandler(null);
            fail("IllegalArgumentException is excepted.");
        } catch (IllegalArgumentException e) {
            // pass.
        }
    }

    /**
     * <p>
     * This is the Accuracy test for Method: setTransferHandler(TransferHandler
     * newTransferHandler) .
     * </p>
     *
     * @throws Exception when error occurs
     */
    public void testNotifyDiagramChangedAccuracy() throws Exception {
        this.view.notifyDiagramChanged();
    }

    /**
     * <p>
     * This is the Accuracy test for Method: getPreferredDiagramSize() .
     * </p>
     *
     * @throws Exception when error occurs
     */
    public void testGetPreferredDiagramSizeAccuracy() throws Exception {
        assertNotNull("Failed to getPreferredDiagramSize.", this.view.getPreferredDiagramSize());
    }

    /**
     * <p>
     * This is the Accuracy test for Method: updateDraggingRectangle(Rectangle
     * rectangle) .
     * </p>
     *
     * @throws Exception when error occurs
     */
    public void testUpdateDraggingRectangleAccuracy() throws Exception {
        this.view.updateDraggingRectangle(new Rectangle());
    }

    /**
     * <p>
     * This is the failure test for constructor:
     * updateDraggingRectangle(Rectangle rectangle).<br>
     * Failure condition: The rectangle is null. <br>
     * Expected: IllegalArgumentException. <br>
     * </p>
     *
     * @throws Exception when error occurs
     */
    public void testUpdateDraggingRectangleWithNull() throws Exception {
        try {
            this.view.updateDraggingRectangle(null);
            fail("IllegalArgumentException is excepted.");
        } catch (IllegalArgumentException e) {
            // pass.
        }
    }

    /**
     * <p>
     * This is the Accuracy test for Method: setDraggingRectangleVisible(boolean
     * draggingRectangleVisible) .
     * </p>
     *
     * @throws Exception when error occurs
     */
    public void testSetDraggingRectangleVisibleAccuracy() throws Exception {
        this.view.setDraggingRectangleVisible(true);
        assertTrue("Failed to setDraggingRectangleVisible.", this.view.isDraggingRectangleVisible());
        this.view.setDraggingRectangleVisible(false);
        assertFalse("Failed to setDraggingRectangleVisible.", this.view.isDraggingRectangleVisible());
    }

    /**
     * <p>
     * This is the Accuracy test for Method: isDraggingRectangleVisible() .
     * </p>
     *
     * @throws Exception when error occurs
     */
    public void testIsDraggingRectangleVisibleAccuracy() throws Exception {
        this.view.setDraggingRectangleVisible(true);
        assertTrue("Failed to setDraggingRectangleVisible.", this.view.isDraggingRectangleVisible());
        this.view.setDraggingRectangleVisible(false);
        assertFalse("Failed to setDraggingRectangleVisible.", this.view.isDraggingRectangleVisible());
    }

}
