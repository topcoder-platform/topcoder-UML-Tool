/*
 * Copyright (C) 2007 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.gui.diagramviewer.event;

import java.awt.Rectangle;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;

import com.topcoder.gui.diagramviewer.DiagramState;
import com.topcoder.gui.diagramviewer.DiagramView;

/**
 * <p>
 * This is an event listener which monitors mouse dragged action. It maintains a
 * drag-rectangle when mouse is being dragged, this rectangle can be used to
 * draw a selection rectangle when selecting or a bounds rectangle when adding
 * new element to the Diagram View. This is the base class of other two
 * listener, one is for adding new element and another is for selecting element.
 * </p>
 * <p>
 * Thread safety: This class is immutable, but it has a Rectangle field which
 * are mutable, and the state of the Rectangle field is modified in several
 * methods, so this class is not thread safe.
 * </p>
 *
 * @author kakarotto, TCSDEVELOPER
 * @version 1.0
 */
public class MouseDragHandler extends MouseAdapter implements MouseMotionListener {

    /**
     * <p>
     * Represents the dragging rectangle when dragging mouse.
     * </p>
     * <p>
     * It is constructed in the ctor and never changed later, but its state will
     * be changed according to the mouse events. Each time the mouse is pressed,
     * it is relocated to the point where the mouse event occurs. When the mouse
     * is dragged, it is resized using the last location and location of the
     * mouse event. Can not be null. Can be accessed by getter.
     * </p>
     */
    private final Rectangle draggingRectangle;

    /**
     * <p>
     * Default constructor, initialize the dragRectangle.
     * </p>
     */
    public MouseDragHandler() {
        draggingRectangle = new Rectangle(0, 0, 0, 0);
    }

    /**
     * <p>
     * Record the draggingRectangle before dragging. If the state of
     * DiagramViewer is DiagramState.ADD_ELEMENT_BY_DRAGGING_RECTANGLE or
     * DiagramState.SELECT_ELEMENT, let the DiagramView start drawing dragging
     * rectangle.
     * </p>
     *
     * @param event the mouse event (ignore null).
     */
    public void mousePressed(MouseEvent event) {
    	/*
		 * BugFix: BUGID UML-7691
		 * Description:
		 * When dragging with the right button, the selection rectangle won't
		 * disappear.  When dragging with the right button, the correct
		 * behavior is to not display the selection rectangle at all.
		 */
    	if (event.getButton() != MouseEvent.BUTTON1) {
    		return;
    	}

        draggingRectangle.setBounds(event.getX(), event.getY(), 0, 0);
        // Obtain the DiagramView from the event:
        DiagramView view = (DiagramView) event.getSource();
        if (checkViewState(view)) {
            view.setDraggingRectangleVisible(true);
        }
    }

    /**
     * <p>
     * Resize and relocate the draggingRectangle according to the point of the
     * mouse event.
     * </p>
     *
     * @param event the mouse event (ignore null).
     */
    public void mouseDragged(MouseEvent event) {
        //Obtain the information needed by computing:
        int x0 = (int) draggingRectangle.getX();
        int y0 = (int) draggingRectangle.getY();
        int x1 = event.getX();
        int y1 = event.getY();
        /*
		 * BugFix: BUGID UML-7156
		 * Description:
		 * In this method, draggingRectangle's location should always indicate the start dragging position,
		 * and the other corner should indicate the end dragging position. However, diagram view's dragging
		 * rectangle field should be updated as a valid rectangle for painting.
		 */
        // old code
//        draggingRectangle.setBounds(Math.min(x0, x1), Math.min(y0, y1), Math.abs(x1 - x0), Math.abs(y1 - y0));
//        //Obtain the DiagramView from the event:
//        DiagramView view = (DiagramView) event.getSource();
//        if (this.checkViewState(view)) {
//            view.updateDraggingRectangle(draggingRectangle);
//        }
        // Obtain the DiagramView from the event:
        DiagramView view = (DiagramView) event.getSource();
        draggingRectangle.setBounds(x0, y0, x1 - x0, y1 - y0);
        if (this.checkViewState(view)) {
        	/*
        	 * BugFix: BUGID UML-7695
        	 */
        	// old code
//            view.updateDraggingRectangle(new Rectangle(Math.min(x0, x1), Math.min(y0, y1),
//                    Math.abs(x1 - x0), Math.abs(y1 - y0)));
            if (view.getViewer().getState() == DiagramState.SELECT_ELEMENT
                    || view.getViewer().getState() == DiagramState.ADD_ELEMENT_BY_DRAGGING_RECTANGLE) {
                view.updateDraggingRectangle(new Rectangle(Math.min(x0, x1), Math.min(y0, y1),
                        Math.abs(x1 - x0), Math.abs(y1 - y0)));
            } else {
                view.updateDraggingRectangle(new Rectangle(x0, y0, x1 - x0, y1 - y0));
            }
        }
    }

    /**
     * <p>
     * If the state of DiagramViewer is
     * DiagramState.ADD_ELEMENT_BY_DRAGGING_RECTANGLE or
     * DiagramState.SELECT_ELEMENT, let the DiagramView stop drawing dragging
     * rectangle.
     * </p>
     *
     * @param event the mouse event (ignore null).
     */
    public void mouseReleased(MouseEvent event) {
    	/*
		 * BugFix: BUGID UML-7691
		 * Description:
		 * When dragging with the right button, the selection rectangle won't
		 * disappear.  When dragging with the right button, the correct
		 * behavior is to not display the selection rectangle at all.
		 */
    	if (event.getButton() != MouseEvent.BUTTON1) {
    		return;
    	}
        // 1) Obtain the DiagramView from the event:
        DiagramView view = (DiagramView) event.getSource();
        if (this.checkViewState(view)) {
            view.setDraggingRectangleVisible(false);
            /*
    		 * BugFix: BUGID UML-7157
    		 * Description:
    		 * If the dragging rectangle is set invisible, the diagram view should be
    		 * repainted.  This way the rectangle disappears immediately.
    		 * Solution:
    		 * Repaint diagram view.
    		 */
            view.repaint();
        }
    }

    /**
     * <p>
     * Getter of the draggingRectangle, see field doc for explanation.
     * </p>
     *
     * @return the dragging rectangle
     */
    public Rectangle getDraggingRectangle() {
        return draggingRectangle;
    }

    /**
     * This is a mummy method.
     *
     * @param event the mouse event (ignore null).
     */
    public void mouseMoved(MouseEvent event) {
        // do nothing.

    }

    /**
     * check whether the given arg.
     *
     * @param view the parameter
     * @return true if view.getViewer().getState() is
     *         DiagramState.ADD_ELEMENT_BY_DRAGGING_RECTANGLE or
     *         DiagramState.SELECT_ELEMENT, false otherwise.
     */
    private boolean checkViewState(DiagramView view) {
        /*
         * BugFix: BUGID UML-7695
         */
        // old code
//        return (view.getViewer().getState() == DiagramState.ADD_ELEMENT_BY_DRAGGING_RECTANGLE || view.getViewer()
//                .getState() == DiagramState.SELECT_ELEMENT);
        DiagramState state = view.getViewer().getState();
        return (state == DiagramState.ADD_ELEMENT_BY_DRAGGING_RECTANGLE || state == DiagramState.SELECT_ELEMENT
                || state == DiagramState.ADD_SOLID_EDGE || state == DiagramState.ADD_DASHED_EDGE);
    }
}
