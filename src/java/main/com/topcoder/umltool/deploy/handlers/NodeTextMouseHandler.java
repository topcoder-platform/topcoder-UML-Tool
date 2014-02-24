/*
 * Copyright (C) 2007 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.umltool.deploy.handlers;

import java.awt.event.MouseEvent;

import javax.swing.event.MouseInputAdapter;

import com.topcoder.gui.diagramviewer.edges.TextField;

/**
 * <p>
 * This handler will pass mouse event behind.
 * </p>
 * <p>
 * Thread safety: This class are not required to be thread-safe. They could be used in a thread safe manner in this
 * component.
 * </p>
 * @author ly, FireIce, ylouis, TCSDEVELOPER
 * @version 1.0
 */
public class NodeTextMouseHandler extends MouseInputAdapter {

    /**
     * <p>
     * The default constructor for NodeTextMouseHandler class.
     * </p>
     */
    public NodeTextMouseHandler() {
        // empty
    }

    /**
     * <p>
     * Handle <b>MOUSE_PRESSED</b> event.
     * </p>
     * <p>
     * Pass behind.
     * </p>
     * @param e
     *            the mouse pressed event
     */
    public void mousePressed(MouseEvent e) {
        if (e != null && e.getSource() instanceof TextField) {
            HandlerHelper.passBehind(e);
        }
    }

    /**
     * <p>
     * Handle the <b>MOUSE_DRAGGED</b> event.
     * </p>
     * <p>
     * Pass behind.
     * </p>
     * @param e
     *            the mouse dragged event
     */
    public void mouseDragged(MouseEvent e) {
        if (e != null && e.getSource() instanceof TextField) {
            HandlerHelper.passBehind(e);
        }
    }

    /**
     * <p>
     * Handle the <b>MOUSE_RELEASED</b> event.
     * </p>
     * <p>
     * Pass behind.
     * </p>
     * @param e
     *            the mouse released event
     */
    public void mouseReleased(MouseEvent e) {
        if (e != null && e.getSource() instanceof TextField) {
            HandlerHelper.passBehind(e);
        }
    }

    /**
     * <p>
     * Handles <b>MOUSE_ENTERED</b> event.
     * </p>
     * <p>
     * Pass behind.
     * </p>
     * @param e
     *            the mouse pressed event
     */
    public void mouseEntered(MouseEvent e) {
        if (e != null && e.getSource() instanceof TextField) {
            HandlerHelper.passBehind(e);
        }
    }

    /**
     * <p>
     * Handles the <b>MOUSE_EXITED</b> event.
     * </p>
     * <p>
     * Pass behind.
     * </p>
     * @param e
     *            the mouse dragged event
     */
    public void mouseExited(MouseEvent e) {
        if (e != null && e.getSource() instanceof TextField) {
            HandlerHelper.passBehind(e);
        }
    }
}