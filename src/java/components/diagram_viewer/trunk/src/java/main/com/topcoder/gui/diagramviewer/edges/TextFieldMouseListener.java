/*
 * Copyright (C) 2007 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.gui.diagramviewer.edges;

import java.awt.Container;
import java.awt.Point;
import java.awt.event.MouseEvent;
import javax.swing.event.MouseInputAdapter;

/**
 * <p>
 * This class extends MouseInputAdapter class and acts as a listener to listen to the TextField's mouse event.
 * </p>
 *
 * <p>
 * It will react to the dragging event to move the position of TextField.
 * </p>
 *
 * <p>
 * This class is package private and final, it will be registered in the TextField's constructor automatically.
 * So the build-in text fields dragging functionality could be provided.
 * </p>
 *
 * <p>
 * Thread Safety : This class is mutable and is not thread safe.
 * </p>
 *
 * @author maone, TCSDEVELOPER
 * @version 1.0
 */
final class TextFieldMouseListener extends MouseInputAdapter {
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
     * The default constructor for TextFieldMouseListener class.
     * </p>
     *
     * <p>
     * Note, this constructor is package private.
     * </p>
     */
    TextFieldMouseListener() {
        // empty
    }

    /**
     * <p>
     * Handle <b>MOUSE_PRESSED</b> event.
     * </p>
     *
     * <p>
     * It is invoked when a mouse button has been pressed on a component.
     * </p>
     *
     * <p>
     * The mouse position is saved and the edge is set to active in this method.
     * The text field is set as selected.
     * </p>
     *
     * <p>
     * Note, this method will take effect only when the given mouse event is not null
     * and the source of the event is of TextField type, otherwise it does nothing.
     * </p>
     *
     * @param e the mouse pressed event
     */
    public void mousePressed(MouseEvent e) {
        if (e != null && e.getSource() instanceof TextField) {
            lastPoint = e.getPoint();

            // select the text field
            TextField textField = (TextField) e.getSource();
            textField.setSelected(true);

            lastPoint.x += textField.getX();
            lastPoint.y += textField.getY();

            // active the edge in the diagram viewer
            Container container = textField.getParent();
            if (container instanceof Edge) {
                Edge edge = (Edge) container;
                Util.setEdgeActive(edge);
            }
        }
    }

    /**
     * <p>
     * Handle the <b>MOUSE_DRAGGED</b> event.
     * </p>
     *
     * <p>
     * It is invoked when a mouse button has been pressed on a component.
     * </p>
     *
     * <p>
     * The anchorage and location of the text field are updated in this method.
     * </p>
     *
     * <p>
     * Note, this method will take effect only when the given mouse event is not null
     * and the source of the event is of TextField type, otherwise it does nothing.
     * </p>
     *
     * @param e the mouse dragged event
     */
    public void mouseDragged(MouseEvent e) {
        if (e != null && e.getSource() instanceof TextField) {
            TextField textField = (TextField) e.getSource();

            // update the location of the text field and the anchorage
            Point point = e.getPoint();
            point.x += textField.getX();
            point.y += textField.getY();

            Point offset = Util.getOffset(lastPoint, point);
            textField.setLocation(textField.getX() + offset.x, textField.getY() + offset.y);

            com.topcoder.diagraminterchange.Point position = new com.topcoder.diagraminterchange.Point();
            position.setX(textField.getX());
            position.setY(textField.getY());
            textField.getGraphNode().setPosition(position);

            textField.updateAnchorage();

            // the edge should be repainted as well because the anchorage of the text field is updated
            Container container = textField.getParent();
            if (container instanceof Edge) {
                Edge edge = (Edge) container;
                edge.repaint();
            }

            // save the mouse position
            lastPoint = point;
        }
    }
}
