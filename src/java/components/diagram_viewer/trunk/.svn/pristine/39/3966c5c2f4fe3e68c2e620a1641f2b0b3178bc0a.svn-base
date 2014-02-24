/*
 * Copyright (C) 2007 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.gui.diagramviewer.event;

import java.awt.Rectangle;
import java.awt.event.MouseEvent;

import com.topcoder.gui.diagramviewer.DiagramState;
import com.topcoder.gui.diagramviewer.DiagramView;

/**
 * <p>
 * This is an event listener which monitors mouse dragged action for selecting
 * elements. It inherits MouseDragHandler to record drag rectangle when dragging
 * mouse. When mouse dragged event occurs, it checks which elements intersect
 * the rectangle and updates the list of 'selected' elements of the
 * DiagramViewer.
 * </p>
 * <p>
 * Thread safety: This class is immutable, but its super class is not thread
 * safe so is it.
 * </p>
 *
 * @author kakarotto, TCSDEVELOPER
 * @version 1.0
 */
public class SelectElementsHandler extends MouseDragHandler {

    /**
     * <p>
     * Default empty constructor.
     * </p>
     */
    public SelectElementsHandler() {
        // do nothing.
    }

    /**
     * <p>
     * Checks which elements intersect the rectangle and updates the list of
     * 'selected' elements of the DiagramViewer, and trigger selection change
     * event.
     * </p>
     *
     * @param event the mouse event (ignore null).
     */
    public void mouseDragged(MouseEvent event) {
        super.mouseDragged(event);
        // Obtain the DiagramView:
        DiagramView view = (DiagramView) event.getSource();
        /*
		 * BugFix: BUGID UML-7160
		 * Description:
		 * The selection changed event should only be raised if the Diagram Viewer is in
		 * the SELECT_ELEMENT state.
		 * Solution:
		 * Only when viewer is in SELECT_ELEMENT state, the change will be fired.
		 */
    	// old code
//        // Trigger a SelectionChangeEvent:
//        view.getViewer().fireSelectionRectangleChange(view, getDraggingRectangle());
        if (view.getViewer().getState() == DiagramState.SELECT_ELEMENT) {
            // Trigger a SelectionChangeEvent:
            view.getViewer().fireSelectionRectangleChange(view, getDraggingRectangle());
        }
    }

    /*
     * Bugfix: UML-9712
     * Add mouseClicked method.
     */
    /**
     * <p>
     * If the state of the Diagram Viewer is DiagramState.SELECT_ELEMENT,
     * trigger selection change event.
     * </p>
     *
     * @param event the mouse event (ignore null).
     */
    public void mouseClicked(MouseEvent event) {
        // Obtain the DiagramView:
        DiagramView view = (DiagramView) event.getSource();
        if (view.getViewer().getState() == DiagramState.SELECT_ELEMENT) {
            // Trigger a SelectionChangeEvent:
            view.updateDraggingRectangle(new Rectangle(event.getX(), event.getY(), 0, 0));
            view.getViewer().fireSelectionRectangleChange(view, getDraggingRectangle());
        }
    }
}
