/*
 * Copyright (C) 2007 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.gui.diagramviewer.event;

import java.awt.Point;
import java.awt.Rectangle;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JComponent;

import com.topcoder.gui.diagramviewer.DVHelper;
import com.topcoder.gui.diagramviewer.DiagramView;
import com.topcoder.gui.diagramviewer.DiagramViewer;
import com.topcoder.gui.diagramviewer.edges.Edge;
import com.topcoder.gui.diagramviewer.edges.TextField;
import com.topcoder.gui.diagramviewer.elements.Node;

/**
 * <p>
 * The default implementation of SelectionListener that checks which elements
 * intersect the rectangle and updates the selected elements list.
 * </p>
 * <p>
 * Thread safety: this class is immutable and not thread safe.
 * </p>
 *
 * @author kakarotto, TCSDEVELOPER
 * @version 1.0
 */
public class SelectionHandler implements SelectionListener {

    /**
     * <p>
     * Default empty constructor.
     * </p>
     */
    public SelectionHandler() {
        // empty.
    }

    /**
     * <p>
     * Checks which element of the DiagramView object intersects the selection
     * rectangle and updates the selected elements list of the DiagramViewer
     * object.
     * </p>
     *
     * @param event the selection event that provides the information about the
     *            selection rectangle
     * @throws IllegalArgumentException if the argument is null
     */
    public void selectionRectangleChanged(SelectionEvent event) {
        DVHelper.validateNotNull(event, "event");
        //Obtain the DiagramView:
        DiagramView view = (DiagramView) event.getSource();
        /*
		 * BugFix: BUGID UML-7158
		 * Description:
		 * The Rectangle#intersects method has been used to determine whether the
		 * dragging rectangle intersects the element's bound. However, if the
		 * dragging rectangle is so small that its width or height is zero, this
		 * method returns false  no matter what.
		 * BugFix: BUGID UML-7159
		 * Description:
		 * If an element is selected, the selection corners need to be shown.
		 * If an element is no longer selected, the selection corners need to be
		 * hidden.
		 */
        // old code
//        // Obtain the selection rectangle from the event:
//        Rectangle rectangle = event.getSelectionRectangle();
//        // for each element in the DiagramView (view.getComponent(i));
//        for (int i = 0; i < view.getComponentCount(); i++) {
//            JComponent element = (JComponent) view.getComponent(i);
//            if ((element instanceof Node) || (element instanceof Edge)) {
//                if (rectangle.intersects(element.getBounds())) {
//                    view.getViewer().addSelectedElement(element);
//                } else {
//                    view.getViewer().removeSelectedElement(element);
//                }
//            }
//
//        }
        // Clear DiagramViewer
        DiagramViewer diagramViewer=view.getViewer();
        List<JComponent> selectedElements = new ArrayList<JComponent>(diagramViewer.getAllSelectedElements());
        for (JComponent component : selectedElements) {
            diagramViewer.removeSelectedElement(component);
            if (component instanceof Node) {
                ((Node) component).notifyUnselected();
            } else if (component instanceof Edge) {
                ((Edge) component).notifyUnselected();
            } else if (component instanceof TextField) {
                component.setOpaque(false);
            }
        }
        // Obtain the selection rectangle from the event:
        Rectangle rectangle = new Rectangle(event.getSelectionRectangle());
        // Make sure its size is positive
        int x0 = rectangle.x;
        int y0 = rectangle.y;
        int x1 = rectangle.x + rectangle.width;
        int y1 = rectangle.y + rectangle.height;
        rectangle.setBounds(Math.min(x0, x1), Math.min(y0, y1), Math.abs(x1 - x0), Math.abs(y1 - y0));
        // for each element in the DiagramView (view.getComponent(i));
        for (int i = 0; i < view.getComponentCount(); i++) {
            JComponent element = (JComponent) view.getComponent(i);
            if ((element instanceof Node)) {
                if (isIntersect(rectangle, element.getBounds())) {
                    view.getViewer().addSelectedElement(element);
                    ((Node) element).notifySelected();
                } else {
                    view.getViewer().removeSelectedElement(element);
                    ((Node) element).notifyUnselected();
                }
            } else if (element instanceof Edge) {
                Edge edge = (Edge) element;
                int size = edge.getWayPoints().size();
                boolean isSelected = false;
                for (int j = 0; j < size - 1; j++) {
                    Point start = edge.getWayPoints().get(j).getCenter();
                    Point end = edge.getWayPoints().get(j + 1).getCenter();
                    if (rectangle.intersectsLine(start.x, start.y, end.x, end.y)) {
                        isSelected = true;
                        break;
                    }
                }
                if (isSelected) {
                    view.getViewer().addSelectedElement(element);
                    edge.notifySelected();
                } else {
                    view.getViewer().removeSelectedElement(element);
                    edge.notifyUnselected();
                }
            }
        }
        if(diagramViewer.getAllSelectedElements().size()==0){
            diagramViewer.addSelectedElement(view);
        }
    }

    /**
     * <p>
     * Checks whether two rectangle intersects.
     * </p>
     * <p>
     * Note, if one rectangle's width or height is zero, but it's contained in the other rectangle, this method will
     * return true.
     * </p>
     * @param first
     *            first rectangle
     * @param second
     *            second rectangle
     * @return whether given two rectangles intersect
     */
    private boolean isIntersect(Rectangle first, Rectangle second) {
        if (first.contains(second.x, second.y) || second.contains(first.x, first.y)) {
            return true;
        }
        return first.intersects(second);
    }
}
