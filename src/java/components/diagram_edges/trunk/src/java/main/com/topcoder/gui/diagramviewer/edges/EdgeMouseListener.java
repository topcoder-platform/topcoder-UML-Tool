/*
 * Copyright (C) 2007 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.gui.diagramviewer.edges;

import java.awt.Point;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JComponent;
import javax.swing.event.MouseInputAdapter;

import com.topcoder.gui.diagramviewer.DiagramViewer;
import com.topcoder.gui.diagramviewer.elements.Node;

/**
 * <p>
 * This class extends MouseInputAdapter class and acts as a listener to listen to the Edge's mouse event.
 * </p>
 *
 * <p>
 * It will wrap the low level mouse dragged event, and trigger a edge moved event.
 * It also react to the mouse pressed event to set the edge selected.
 * </p>
 *
 * <p>
 * Note, this class is package private and final, it will be registered in the Edge's
 * constructor automatically. So the edge dragged and pressed event can be triggered by default.
 * </p>
 *
 * <p>
 * Thread Safety : This class is mutable and is not thread safe.
 * </p>
 *
 * @author maone, TCSDEVELOPER
 * @version 1.0
 */
final class EdgeMouseListener extends MouseInputAdapter {
    /**
     * <p>
     * Represents the last mouse point.
     * </p>
     *
     * <p>
     * It is null initially and set in mousePressed and mouseDragged event.
     * </p>
     *
     * <p>
     * This variable is used to hold the dragging history.
     * </p>
     */
    private Point lastPoint;

    /**
     * <p>
     * The default constructor for EdgeMouseListener class.
     * </p>
     *
     * <p>
     * Note, this constructor is package private.
     * </p>
     */
    EdgeMouseListener() {
        // empty
    }

    /**
     * <p>
     * Handle the <b>MOUSE_PRESSED</b> event.
     * </p>
     *
     * <p>
     * It is invoked when a mouse button has been pressed on a component.
     * </p>
     *
     * <p>
     * The mouse position is saved and the edge is set to active in this method.
     * The edge will be notified as selected.
     * </p>
     *
     * <p>
     * Note, this method will take effect only when the given mouse event is not null
     * and the source of the event is of Edge type, otherwise it does nothing.
     * </p>
     *
     * @param e the mouse pressed event.
     */
    public void mousePressed(MouseEvent e) {
        if (e != null && e.getSource() instanceof Edge) {
            this.lastPoint = e.getPoint();
            Edge edge = (Edge) e.getSource();

            // BugFix: UML-9433
            // old code
//            // active the edge in the diagram viewer
//            Util.setEdgeActive(edge);
//
//            // select the edge
//            edge.notifySelected();
            DiagramViewer viewer = edge.getDiagramViewer();
            if (!e.isControlDown()) {
                // Unselect old selected elements
                List<JComponent> selectedElementList = new ArrayList<JComponent>(
                        viewer.getAllSelectedElements());
                for (JComponent element : selectedElementList) {
                    viewer.removeSelectedElement(element);
                    if (element instanceof Node) {
                        ((Node) element).notifyUnselected();
                    } else if (element instanceof Edge) {
                        ((Edge) element).notifyUnselected();
                    }
                }
                // Select the node to the active list of diagram viewer
                viewer.addSelectedElement(edge);
                edge.notifySelected();
            } else {
                if (viewer.isElementSelected(edge)) {
                    // Unselect this node
                    viewer.removeSelectedElement(edge);
                    edge.notifyUnselected();
                } else {
                    // Select this node
                    viewer.addSelectedElement(edge);
                    edge.notifySelected();
                }
            }
        }
    }

    /**
     * <p>
     * Handle the <b>MOUSE_DRAGGED</b> event.
     * </p>
     *
     * <p>
     * It is invoked when a mouse button is pressed on a component and then
     * dragged.
     * </p>
     *
     * <p>
     * The way point event will be sent out to the corresponding listener by
     * this method.
     * </p>
     *
     * <p>
     * Note, this method will take effect only when the given mouse event is not null
     * and the source of the event is of Edge type, otherwise it does nothing.
     * </p>
     *
     * @param e the mouse dragged event.
     */
    public void mouseDragged(MouseEvent e) {
        if (e != null && e.getSource() instanceof Edge) {
            Point offset = Util.getOffset(lastPoint, e.getPoint());
            Edge edge = (Edge) e.getSource();

            // fire the event to the corresponding listeners
            edge.fireEdgeDrag(new WayPointEvent(edge, lastPoint, offset));

            // keep track of the last mouse point
            this.lastPoint = e.getPoint();
        }
    }
}
