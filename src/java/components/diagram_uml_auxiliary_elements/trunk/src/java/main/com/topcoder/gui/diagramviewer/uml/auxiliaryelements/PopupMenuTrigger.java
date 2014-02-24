/*
 * Copyright (C) 2007 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.gui.diagramviewer.uml.auxiliaryelements;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JComponent;


/**
 * <p>
 * This is a event listener which listens to mouse right clicked event.
 * If the event occurs, popup menu would be shown.
 * This event listener will be registered to every <code>Node</code> or <code>Edge</code> in this component.
 * </p>
 *
 * <p>
 * This class in immutable, and thread-safe.
 * </p>
 *
 * @author maone, TCSDEVELOPER
 * @version 1.0
 */
public class PopupMenuTrigger extends MouseAdapter {
    /**
     * <p>
     * Default empty constructor.
     * </p>
     */
    public PopupMenuTrigger() {
        // empty
    }

    /**
     * <p>
     * Handles the mouse clicked event.
     * </p>
     *
     * @param e - the mouse clicked event (null will be ignored.)
     */
    public void mouseClicked(MouseEvent e) {
        // if it is not right clicked.
        if (e.getButton() != MouseEvent.BUTTON2) {
            return;
        }

        // if the source of MouseEvent e is not instance of JComponent
        if (!(e.getSource() instanceof JComponent)) {
            return;
        }

        // if PopupMenu of the source is null
        JComponent source = (JComponent) e.getSource();
        if (source.getComponentPopupMenu() == null) {
            return;
        }

        // shows the popup menu in the location where the mouse event occurs
        source.getComponentPopupMenu().show(source, e.getX(), e.getY());
    }
}
