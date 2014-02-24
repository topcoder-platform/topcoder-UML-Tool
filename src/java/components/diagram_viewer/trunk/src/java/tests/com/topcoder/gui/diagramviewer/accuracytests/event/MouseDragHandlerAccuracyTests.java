/*
 * Copyright (C) 2007 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.gui.diagramviewer.accuracytests.event;

import java.awt.Rectangle;
import java.awt.event.MouseEvent;
import java.io.File;

import com.topcoder.diagraminterchange.Diagram;
import com.topcoder.diagraminterchange.Dimension;
import com.topcoder.diagraminterchange.Point;
import com.topcoder.gui.diagramviewer.DiagramState;
import com.topcoder.gui.diagramviewer.DiagramView;
import com.topcoder.gui.diagramviewer.DiagramViewer;
import com.topcoder.gui.diagramviewer.accuracytests.AccuracyTestsHelper;
import com.topcoder.gui.diagramviewer.elements.Node;
import com.topcoder.gui.diagramviewer.event.MouseDragHandler;

import junit.framework.TestCase;

/**
 * <p>
 * Accuracy test case for <c>MouseDragHandler</c>.
 * </p>
 *
 * @author tianniu
 * @version 1.0
 */
public class MouseDragHandlerAccuracyTests extends TestCase {

    /**
     * <p>
     * The path of config file used for test.
     * </p>
     */
    private static final String CONFIG = "accuracyTests" + File.separator + "AccuracyDefaultConfig.xml";

    /**
     * Represent the instance of <c>MouseDragHandler</c> used for test.
     */
    private MouseDragHandler handler;

    /**
     * Represent the instance of <c>MouseEvent</c> used for test.
     */
    private MouseEvent event;

    /**
     * Represent the instance of <c>DiagramView</c> used for test.
     */
    private DiagramView view;

    /**
     * <p>
     * Set up test environment.
     * </p>
     *
     * @throws Exception
     *         if any error occurs when set up
     */
    protected void setUp() throws Exception {
        AccuracyTestsHelper.loadConfig(CONFIG);
        handler = new MouseDragHandler();

        Diagram diagram = new Diagram();
        Dimension dimension = new Dimension();
        dimension.setWidth(500.0);
        dimension.setHeight(500.0);
        diagram.setSize(dimension);

        Point point = new Point();
        point.setX(5);
        point.setY(5);
        diagram.setPosition(point);

        view = new DiagramViewer().createDiagramView(diagram);
        /*
		 * BugFix: BUGID UML-7691
		 * Description:
		 * When dragging with the right button, the selection rectangle won't
		 * disappear.  When dragging with the right button, the correct
		 * behavior is to not display the selection rectangle at all.
		 */
        // old code
//        event = new MouseEvent(view, 0, 0, 0, 0, 0, 0, true);
        event = new MouseEvent(view, 0, 0, 0, 0, 0, 0, true, MouseEvent.BUTTON1);
    }

    /**
     * <p>
     * Tear down test environment.
     * </p>
     *
     * @throws Exception
     *         if any error occurs when tear down
     */
    protected void tearDown() throws Exception {
        AccuracyTestsHelper.removeAllNamespaces();
    }

    /**
     * <p>
     * Accuracy test for the constructor <code>MouseDragHandler</code>. The instance of <code>MouseDragHandler</code>
     * should be created successfully.
     * </p>
     */
    public void testConstructorAccuracy() {
        assertNotNull("instance of MouseDragHandler should be created", new MouseDragHandler());
    }

    /**
     * <p>
     * Accuracy test for the method <code>mousePressed</code> when the state is SELECT_ELEMENT.
     * </p>
     */
    public void testmousePressedAccuracy() {
        try {
            view.getViewer().setNewElementType(Node.class);
            view.getViewer().setState(DiagramState.SELECT_ELEMENT);
            handler.mousePressed(event);
            assertTrue("the Rectangle should be Visible", view.isDraggingRectangleVisible());
        } catch (Exception e) {
            fail(e.getMessage());
        }
    }

    /**
     * <p>
     * Accuracy test for the method <code>mousePressed</code> when the state is CLICK.
     * </p>
     */
    public void testmousePressedAccuracy2() {
        try {
            view.getViewer().setNewElementType(Node.class);
            view.getViewer().setState(DiagramState.ADD_ELEMENT_BY_CLICK);
            handler.mousePressed(event);
            assertFalse("the Rectangle should not be Visible", view.isDraggingRectangleVisible());
        } catch (Exception e) {
            fail(e.getMessage());
        }
    }

    /**
     * <p>
     * Accuracy test for the method <code>mouseDragged</code>.
     * </p>
     */
    public void testmouseDraggedAccuracy() {
        try {
            view.getViewer().setNewElementType(Node.class);
            view.getViewer().setState(DiagramState.ADD_ELEMENT_BY_CLICK);
            handler.mouseDragged(event);
        } catch (Exception e) {
            fail(e.getMessage());
        }
    }

    /**
     * <p>
     * Accuracy test for the method <code>mouseReleased</code> the Rectangle should not be Visible.
     * </p>
     */
    public void testmouseReleasedAccuracy() {
        try {
            view.getViewer().setState(DiagramState.SELECT_ELEMENT);
            handler.mouseReleased(event);
            assertFalse("the Rectangle should not be Visible", view.isDraggingRectangleVisible());
        } catch (Exception e) {
            fail(e.getMessage());
        }
    }

    /**
     * <p>
     * Accuracy test for the method <code>mouseReleased</code> the Rectangle should be Visible.
     * </p>
     */
    public void testmouseReleasedAccuracy2() {
        try {
            view.getViewer().setNewElementType(Node.class);
            view.getViewer().setState(DiagramState.ADD_ELEMENT_BY_CLICK);
            view.setDraggingRectangleVisible(true);
            handler.mouseReleased(event);
            assertTrue("the Rectangle should be Visible", view.isDraggingRectangleVisible());
        } catch (Exception e) {
            fail(e.getMessage());
        }
    }

    /**
     * <p>
     * Accuracy test for the method <code>getDraggingRectangle</code> The draggingRectangle should be returned.
     * </p>
     */
    public void testgetDraggingRectangleAccuracy() {
        try {
            assertEquals("the draggingRectangle should be returned", new Rectangle(0, 0, 0, 0), handler
                            .getDraggingRectangle());
        } catch (Exception e) {
            fail(e.getMessage());
        }
    }

}
