/*
 * Copyright (C) 2007 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.gui.diagramviewer.elements;

import java.awt.Cursor;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.event.MouseEvent;

import javax.swing.JComponent;

import com.topcoder.gui.diagramviewer.DiagramView;

/**
 * <p>
 * This listener listens to the selection corner's mouse event. It will wrap the low level mouse dragged event, and
 * trigger a selection corner moved event.
 * </p>
 * <p>
 * This class is package private and final, it will be registered in the Node's constructor automatically. So the
 * selection corner moved event could be triggered by default.
 * </p>
 * <p>
 * <b>Thread Safety:</b> This class is mutable and is not thread safe.
 * </p>
 *
 * @author maone, TCSDEVELOPER
 * @version 1.0
 */
final class SelectionCornerMouseListener extends DragEventAdapter {

    /**
     * <p>
     * Represents the node containing selection corner.
     * </p>
     * <p>
     * It is initialized in the constructor, can't null. Never changed after set.
     * </p>
     */
    private final Node node;

    /**
     * <p>
     * Create a <code>SelectionCornerMouseListener</code> instance.
     * </p>
     *
     * @param node
     *            the node containing selection corner.
     * @throws IllegalArgumentException
     *             if <code>node</code> is null
     */
    public SelectionCornerMouseListener(Node node) {
        if (node == null) {
            throw new IllegalArgumentException("node should not be null.");
        }
        this.node = node;
    }

    /**
     * <p>
     * Handles the <code>MOUSE_PRESSED</code> event. Changes the mouse cursor according to the selection corner's type.
     * </p>
     * <p>
     * No restriction on the given value, null is acceptable.
     * </p>
     * <p>
     * If the source of event is not <code>SelectionCorner</code>, nothing is done.
     * </p>
     *
     * @param e
     *            the mouse pressed event
     */
    public void mousePressed(MouseEvent e) {
        if (e != null && e.getSource() instanceof SelectionCorner) {
            // record the last point
            super.mousePressed(e);
            // set cursor according the type of selection corner
            setCursor((SelectionCorner) e.getSource());
        }
    }

    /**
     * <p>
     * Handles the <code>MOUSE_RELEASED</code> event. Restores the mouse cursor.
     * </p>
     * <p>
     * No restriction on the given value, null is acceptable.
     * </p>
     * <p>
     * If the source of event is not <code>SelectionCorner</code>, nothing is done.
     * </p>
     *
     * @param e
     *            the mouse released event
     */
    public void mouseReleased(MouseEvent e) {
        if (e != null && e.getSource() instanceof SelectionCorner) {
            ((SelectionCorner) e.getSource()).setCursor(Cursor.getDefaultCursor());
        }
    }

    /*
     * Bugfix: UML-9715
     * Adds mouseEntered method and mouseExited method
     */
    /**
     * <p>
     * Handles the <code>MOUSE_ENTERED</code> event. Changes the mouse cursor according to the selection corner's type.
     * </p>
     * <p>
     * No restriction on the given value, null is acceptable.
     * </p>
     * <p>
     * If the source of event is not <code>SelectionCorner</code>, nothing is done.
     * </p>
     *
     * @param e
     *            the mouse pressed event
     */
    public void mouseEntered(MouseEvent e) {
        if (e != null && e.getSource() instanceof SelectionCorner) {
            // set cursor according the type of selection corner
            setCursor((SelectionCorner) e.getSource());
        }
    }

    /**
     * <p>
     * Handles the <code>MOUSE_EXITED</code> event. Restores the mouse cursor.
     * </p>
     * <p>
     * No restriction on the given value, null is acceptable.
     * </p>
     * <p>
     * If the source of event is not <code>SelectionCorner</code>, nothing is done.
     * </p>
     *
     * @param e
     *            the mouse released event
     */
    public void mouseExited(MouseEvent e) {
        if (e != null && e.getSource() instanceof SelectionCorner) {
            ((SelectionCorner) e.getSource()).setCursor(Cursor.getDefaultCursor());
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
     * If the source of event is not <code>SelectionCorner</code> or the last point has not been recorded, nothing is
     * done.
     * </p>
     *
     * @param e
     *            the mouse dragged event
     */
    public void mouseDragged(MouseEvent e) {
        if (e != null && getLastPoint() != null && e.getSource() instanceof SelectionCorner) {
            SelectionCorner corner = (SelectionCorner) e.getSource();
            // set cursor according the type of selection corner
            setCursor(corner);
            // calculate the offset
            Point point = new Point(e.getPoint());
            JComponent component = (JComponent)e.getSource();
            while (component != null && !(component instanceof DiagramView)) {
                point.x += component.getX();
                point.y += component.getY();
                component = (JComponent) component.getParent();
            }
            int offx = point.x - getLastPoint().x;
            int offy = point.y - getLastPoint().y;

            // calculate the new bound
            // Node#getSelectionBound will return a cloned Rectangle, it is safe to set the values of the object
            Rectangle newBound = node.getSelectionBound();
            if (corner.getType() == SelectionCornerType.EAST) {
                newBound.width += offx;
            } else if (corner.getType() == SelectionCornerType.SOUTH) {
                newBound.height += offy;
            } else if (corner.getType() == SelectionCornerType.WEST) {
                newBound.x += offx;
                newBound.width -= offx;
            } else if (corner.getType() == SelectionCornerType.NORTH) {
                newBound.y += offy;
                newBound.height -= offy;
            } else if (corner.getType() == SelectionCornerType.SOUTHEAST) {
                newBound.width += offx;
                newBound.height += offy;
            } else if (corner.getType() == SelectionCornerType.SOUTHWEST) {
                newBound.x += offx;
                newBound.width -= offx;
                newBound.height += offy;
            } else if (corner.getType() == SelectionCornerType.NORTHEAST) {
                newBound.width += offx;
                newBound.y += offy;
                newBound.height -= offy;
            } else {
                newBound.x += offx;
                newBound.width -= offx;
                newBound.y += offy;
                newBound.height -= offy;
            }
            // fire the listeners
            node.fireCornerDrag(new SelectionBoundEvent(node, node.getSelectionBound(), newBound));
            setLastPoint(point);
        }
    }

    /**
     * <p>
     * Sets the cursor according the type of selection corner.
     * </p>
     *
     * @param corner
     *            the selection corner to set cursor.
     */
    private void setCursor(SelectionCorner corner) {
        if (corner.getType() == SelectionCornerType.EAST) {
            corner.setCursor(Cursor.getPredefinedCursor(Cursor.E_RESIZE_CURSOR));
        } else if (corner.getType() == SelectionCornerType.SOUTH) {
            corner.setCursor(Cursor.getPredefinedCursor(Cursor.S_RESIZE_CURSOR));
        } else if (corner.getType() == SelectionCornerType.WEST) {
            corner.setCursor(Cursor.getPredefinedCursor(Cursor.W_RESIZE_CURSOR));
        } else if (corner.getType() == SelectionCornerType.NORTH) {
            corner.setCursor(Cursor.getPredefinedCursor(Cursor.N_RESIZE_CURSOR));
        } else if (corner.getType() == SelectionCornerType.SOUTHEAST) {
            corner.setCursor(Cursor.getPredefinedCursor(Cursor.SE_RESIZE_CURSOR));
        } else if (corner.getType() == SelectionCornerType.SOUTHWEST) {
            corner.setCursor(Cursor.getPredefinedCursor(Cursor.SW_RESIZE_CURSOR));
        } else if (corner.getType() == SelectionCornerType.NORTHEAST) {
            corner.setCursor(Cursor.getPredefinedCursor(Cursor.NE_RESIZE_CURSOR));
        } else {
            corner.setCursor(Cursor.getPredefinedCursor(Cursor.NW_RESIZE_CURSOR));
        }
    }
}
