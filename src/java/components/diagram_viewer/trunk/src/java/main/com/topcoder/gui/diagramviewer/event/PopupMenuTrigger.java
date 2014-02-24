/*
 * Copyright (C) 2007 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.gui.diagramviewer.event;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JPopupMenu;

import com.topcoder.gui.diagramviewer.DiagramView;

/**
 * <p>
 * This is an event listener which listens to mouse right clicked event. If the
 * event occurs, Popupmenu would be shown. This event listener will be
 * registered to the DiagramView in this component automatically.
 * </p>
 * <p>
 * Thread safety: This class is immutable, and thread-safe.
 * </p>
 *
 * @author kakarotto, TCSDEVELOPER
 * @version 1.0
 */
public class PopupMenuTrigger extends MouseAdapter {

    /**
     * <p>
     * Default empty constructor.
     * </p>
     */
    public PopupMenuTrigger() {
        // empty.
    }

    /**
     * <p>
     * Handle the mouse clicked event. If it is a right clicked event, popup
     * menu of source component will be shown.
     * </p>
     *
     * @param event the mouse event (ignore null).
     */
    public void mouseClicked(MouseEvent event) {

        // it is not right clicked.
        if (event.getButton() == MouseEvent.BUTTON2 && (event.getSource() instanceof DiagramView)) {
            JPopupMenu jPopupMenu = ((DiagramView) event.getSource()).getViewer().getComponentPopupMenu();

            if (jPopupMenu != null) {
                // Show the Popupmenu in e.getPoint location.
                jPopupMenu.show(jPopupMenu.getComponent(), event.getX(), event.getY());
            }
        }

    }
}
