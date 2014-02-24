/*
 * Copyright (C) 2007 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.umltool.deploy.handlers;

import java.awt.event.MouseEvent;

import javax.swing.event.MouseInputAdapter;

/**
 * <p>
 * This handler will pass mouse event behind.
 * </p>
 * <p>
 * Thread safety: This class are not required to be thread-safe. They could be used in a thread safe manner in this
 * component.
 * </p>
 * @author ly, FireIce, ylouis
 * @version 1.0
 */
public class FeatureAddButtonMouseHandler extends MouseInputAdapter {

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
        if (e != null) {
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
        if (e != null) {
            HandlerHelper.passBehind(e);
        }
    }
}