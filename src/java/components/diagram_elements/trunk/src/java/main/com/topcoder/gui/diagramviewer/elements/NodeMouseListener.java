/*
 * Copyright (C) 2007 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.gui.diagramviewer.elements;

import java.awt.Point;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JComponent;

import com.topcoder.gui.diagramviewer.DiagramViewer;
import com.topcoder.gui.diagramviewer.edges.Edge;
import com.topcoder.gui.diagramviewer.edges.TextField;

/**
 * <p>
 * This listener listens to the node's mouse event. It will wrap the low level mouse dragged event, and trigger a node
 * dragged event. It also react to the mouse pressed event to set the node selected.
 * </p>
 * <p>
 * This class is package private and final, it will be registered in the node's constructor automatically. So the node
 * dragged event could be triggered by default.
 * </p>
 * <p>
 * <b>Thread Safety:</b> This class is mutable and is not thread safe.
 * </p>
 *
 * @author maone, TCSDEVELOPER
 * @version 1.0
 */
final class NodeMouseListener extends DragEventAdapter {

    /**
     * This variable indicates whether the node has just been dragged.
     */
    private boolean isDragged = false;

    /**
     * Default empty constructor.
     */
    public NodeMouseListener() {
    }

    /**
     * <p>
     * Handles the <code>MOUSE_PRESSED</code> event.
     * </p>
     * <p>
     * No restriction on the given value, null is acceptable.
     * </p>
     * <p>
     * If the source of event is not <code>Node</code>, nothing is done.
     * </p>
     *
     * @param e
     *            the mouse pressed event
     */
    public void mousePressed(MouseEvent e) {
        if (e != null && e.getSource() instanceof Node) {
            super.mousePressed(e);
            /*
             * Bugfix: UML-9575
             * To support group dragging, this strategy should be modified.
             * If the node is already selected, it should not unselect all
             * selected elements in this method, but it should do that
             * in mouseReleased if the node is not dragged.
             */
            // old code
//            // Gets the DiagramViewer instance associated
//            DiagramViewer viewer = ((Node) e.getSource()).getDiagramViewer();
//            // Select the node to the active list of diagram viewer.
//            if (viewer != null) {
//                for (JComponent jc : viewer.getAllSelectedElements()) {
//                    viewer.removeSelectedElement(jc);
//                }
//                viewer.addSelectedElement((Node) e.getSource());
//            }
        }
    }

    /**
     * <p>
     * Handles the <code>MOUSE_DRAGGED</code> event.
     * </p>
     * <p>
     * No restriction on the given value, null is acceptable.
     * </p>
     * <p>
     * If the source of event is not <code>Node</code> or the last point has not been recorded, nothing is done.
     * </p>
     *
     * @param e
     *            the mouse dragged event
     */
    public void mouseDragged(MouseEvent e) {
        if (e != null && getLastPoint() != null && e.getSource() instanceof Node) {
            /*
             * Bugfix: UML-9575
             * To support group dragging, this strategy should be modified.
             * If the node is already selected, it should not unselect all
             * selected elements in this method, but it should do that
             * in mouseReleased if the node is not dragged.
             */
            // old code
//            Node node = (Node) e.getSource();
//            Point lastPoint = getLastPoint();
//            int xOff = e.getPoint().x - lastPoint.x;
//            int yOff = e.getPoint().y - lastPoint.y;
//            Point oldPoint = node.getLocation();
//            Point newPoint = new Point(oldPoint.x + xOff, oldPoint.y + yOff);
//            node.fireNodeDrag(new LocationEvent(node, oldPoint, newPoint));
//            setLastPoint(e.getPoint());
            isDragged = true;

            // Gets the DiagramViewer instance associated
            Node node = (Node) e.getSource();
            DiagramViewer viewer = node.getDiagramViewer();

            // Select the node to the active list of diagram viewer and unselect all other selected elements, if this
            // node is not selected at first
            if (!viewer.isElementSelected(node)) {
                // Unselect old selected elements
                List<JComponent> selectedElementList = new ArrayList<JComponent>(viewer.getAllSelectedElements());
                for (JComponent element : selectedElementList) {
                    viewer.removeSelectedElement(element);
                    if (element instanceof Node) {
                        ((Node) element).notifyUnselected();
                    } else if (element instanceof Edge) {
                        ((Edge) element).notifyUnselected();
                    } else if (element instanceof TextField) {
                        element.setOpaque(false);
                        element.repaint();
                    }
                }
                viewer.addSelectedElement(node);
                node.notifySelected();
            }

            Point lastPoint = getLastPoint();
            int xOff = e.getPoint().x + node.getX() - lastPoint.x;
            int yOff = e.getPoint().y + node.getY() - lastPoint.y;

            lastPoint.x = e.getPoint().x + node.getX();
            lastPoint.y = e.getPoint().y + node.getY();
            setLastPoint(lastPoint);

            Point oldPoint = node.getLocation();
            Point newPoint = new Point(oldPoint.x + xOff, oldPoint.y + yOff);
            node.fireNodeDrag(new LocationEvent(node, oldPoint, newPoint));
        }
    }

    /*
     * Bugfix: UML-9575
     * To support group dragging, this strategy should be modified.
     * If the node is already selected, it should not unselect all
     * selected elements in this method, but it should do that
     * in mouseReleased if the node is not dragged.
     */
    /**
     * <p>
     * Handles the <code>MOUSE_RELEASED</code> event.
     * </p>
     * <p>
     * No restriction on the given value, null is acceptable.
     * </p>
     * <p>
     * If the source of event is not <code>Node</code>, nothing is done.
     * </p>
     * <p>
     * This method handles the selection change if node is not just dragged.
     * </p>
     *
     * @param e
     *            the mouse pressed event
     */
    public void mouseReleased(MouseEvent e) {
        if (e != null && e.getSource() instanceof Node) {
            // Gets the DiagramViewer instance associated
            Node node = (Node) e.getSource();
            DiagramViewer viewer = node.getDiagramViewer();

            if (!isDragged) {
                if (!e.isControlDown()) {
                    // Unselect old selected elements
                    List<JComponent> selectedElementList = new ArrayList<JComponent>(viewer.getAllSelectedElements());
                    for (JComponent element : selectedElementList) {
                        viewer.removeSelectedElement(element);
                        if (element instanceof Node) {
                            ((Node) element).notifyUnselected();
                        } else if (element instanceof Edge) {
                            ((Edge) element).notifyUnselected();
                        } else if (element instanceof TextField) {
                            element.setOpaque(false);
                            element.repaint();
                        }
                    }
                    // Select the node to the active list of diagram viewer
                    viewer.addSelectedElement(node);
                    node.notifySelected();
                } else {
                    if (viewer.isElementSelected(node)) {
                        // Unselect this node
                        viewer.removeSelectedElement(node);
                        node.notifyUnselected();
                    } else {
                        // Select this node
                        viewer.addSelectedElement(node);
                        node.notifySelected();
                    }
                }
            }

            isDragged = false;
        }
    }
}
