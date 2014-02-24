/*
 * Copyright (C) 2007 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.gui.diagramviewer.event;

import java.awt.event.MouseEvent;

import com.topcoder.gui.diagramviewer.DiagramState;
import com.topcoder.gui.diagramviewer.DiagramView;

/**
 * <p>
 * This is an event listener which monitors mouse event for adding new element
 * to the Diagram View. There are two ways of adding elements: <br>
 * 1) When the mouse is clicked, this is processed in the method mouseClicked.<br>
 * 2) After the mouse draws a bounds rectangle for the element, this is
 * processed in method mouseReleased. To choose which way depends on the state
 * of the Diagram Viewer (DiagramViewer#getState()).
 * </p>
 * <p>
 * Thread safety: This class is immutable, but its super class is not thread
 * safe so is it.
 * </p>
 *
 * @author kakarotto, TCSDEVELOPER
 * @version 1.0
 */
public class AddNewElementHandler extends MouseDragHandler {

    /**
     * <p>
     * Default empty constructor.
     * </p>
     */
    public AddNewElementHandler() {
        // do nothing.
    }

    /**
     * <p>
     * If the state of the Diagram Viewer is DiagramState.ADD_ELEMENT_BY_CLICK,
     * add a new element to the Diagram View.
     * </p>
     *
     * @param event the mouse event (ignore null).
     */
    public void mouseClicked(MouseEvent event) {
        try {
            // Obtain the DiagramView from the mouse event:
            DiagramView view = (DiagramView) event.getSource();

            if (view.getViewer().getState() == DiagramState.ADD_ELEMENT_BY_CLICK) {
            	/*
        		 * BugFix: BUGID UML-7155
        		 * Description:
        		 * To call fireNewElementAdded method, the dragging rectangle should have been
        		 * provided, so listeners can know where to add the element.  A third parameter
        		 * for the dragging rectangle should be added.
        		 * Solution:
        		 * Add the dragging rectangle parameter.
        		 */
            	// old code
//                view.getViewer().fireNewElementAdded(view, view.getViewer().getNewElementType());
            	view.getViewer().fireNewElementAdded(view, view.getViewer().getNewElementType(),
                        getDraggingRectangle().getBounds());
            }
        } catch (ClassCastException cce) {
            // pass.
        }
    }

    /**
     * <p>
     * If the state of the Diagram Viewer is
     * DiagramState.ADD_ELEMENT_BY_DRAGGING_RECTANGLE, add a new element to the
     * Diagram View.
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

        super.mouseReleased(event);
        try {
            // Obtain the DiagramView from the mouse event:
            DiagramView view = (DiagramView) event.getSource();
            /*
        	 * BugFix: BUGID UML-7695
        	 */
        	// old code
//            if (view.getViewer().getState() == DiagramState.ADD_ELEMENT_BY_DRAGGING_RECTANGLE) {
            DiagramState state = view.getViewer().getState();
            if (state == DiagramState.ADD_ELEMENT_BY_DRAGGING_RECTANGLE
            		|| state == DiagramState.ADD_SOLID_EDGE
            		|| state == DiagramState.ADD_DASHED_EDGE) {
                view.getViewer().fireNewElementAdded(view, view.getViewer().getNewElementType(),
                        getDraggingRectangle().getBounds());
            }
        } catch (ClassCastException cce) {
            // pass.
        }
    }
}
