/*
 * Copyright (C) 2006 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.gui.panels.zoom;

import java.awt.Container;
import java.awt.Point;

import javax.swing.JLabel;

/**
 * <p>
 * This class provided Label and Point to show mouse event information. The Label shows the current mouse coordinates in
 * the CoordinateArea.
 * </p>
 *
 * @author TCSDEVELOPER
 * @version 1.0
 */
public class DemoController {
    /**
     * <p>
     * JLabel object used to show the current cursor coordinates in the CoordinateArea.
     * </p>
     */
    private JLabel label;

    /**
     * <p>
     * The cursor's last click coordinates in the CoordinateArea.
     * </p>
     */
    private Point clickPoint;

    /**
     * <p>
     * The cursor's current coordinates in the CoordinateArea.
     * </p>
     */
    private Point cursorPoint;

    /**
     * <p>
     * Adds the JLabel object to the specified Container.
     * </p>
     *
     * @param container the Container which the JLabel added to
     */
    public void buildUI(Container container) {
        label = new JLabel();
        resetLabel();
        container.add(label);
    }

    /**
     * <p>
     * Updates the current cursor coordinats information stored in the cursorPoint and the label text.
     * </p>
     *
     * @param x the x coordinate of cursor
     * @param y the y coordinate of cursor
     */
    public void updateCursorLocation(int x, int y) {
        if (x < 0 || y < 0) {
            cursorPoint = null;
            updateLabel();
            return;
        }

        if (cursorPoint == null) {
            cursorPoint = new Point();
        }

        cursorPoint.x = x;
        cursorPoint.y = y;
        updateLabel();
    }

    /**
     * <p>
     * Updates the cursor clicked Point information.
     * </p>
     *
     * @param p the new clicked Point
     */
    public void updateClickPoint(Point p) {
        clickPoint = p;
        updateLabel();
    }

    /**
     * <p>
     * Resets the label text.
     * </p>
     */
    public void resetLabel() {
        cursorPoint = null;
        updateLabel();
    }

    /**
     * <p>
     * Updates the label text.
     * </p>
     */
    protected void updateLabel() {
        String text = "";

        if ((clickPoint == null) && (cursorPoint == null)) {
            text = "Click or move the cursor within the framed area.";
        } else {

            if (clickPoint != null) {
                text += "The last click was at (" + clickPoint.x + ", " + clickPoint.y + "). ";
            }

            if (cursorPoint != null) {
                text += "The cursor is at (" + cursorPoint.x + ", " + cursorPoint.y + "). ";
            }
        }

        label.setText(text);
    }
}
