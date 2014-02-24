/*
 * Copyright (C) 2007 TopCoder Inc., All Rights Reserved.
 */

package com.topcoder.gui.diagramviewer.uml.usecaseelements.event;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JComponent;
import javax.swing.JPopupMenu;

/**
 * <p>
 * This is an event listener which listens to mouse right clicked event. If the event occurs, popup menu would be shown.
 * This event listener will be registered to every node or edge in this component automatically.
 * </p>
 * <p>
 * <b>Thread Safety</b>: This class in immutable, and thread-safe.
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
     * Handle the mouse clicked event. If it is a right clicked event, popup menu of source component will be shown.
     * </p>
     *
     * @param e the mouse clicked event. (null should be ignored).
     */
    public void mouseClicked(MouseEvent e) {
        if (e == null) {
            return;
        }
        if (e.getButton() != MouseEvent.BUTTON2) {
            return;
        }
        if (!(e.getSource() instanceof JComponent)) {
            return;
        }

        // try to get the source's popup menu
        JPopupMenu popupMenu = ((JComponent) e.getSource()).getComponentPopupMenu();

        // if it has popup menu, shows it
        if (popupMenu != null) {
            popupMenu.show((JComponent) e.getSource(), e.getPoint().x, e.getPoint().y);
        }
    }
}
