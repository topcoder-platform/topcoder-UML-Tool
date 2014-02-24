/*
 * Copyright (C) 2007 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.gui.diagramviewer.uml.classelements.event;

import java.awt.Point;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JPopupMenu;

import com.topcoder.gui.diagramviewer.elements.Node;
import com.topcoder.gui.diagramviewer.uml.classelements.BaseNode;
import com.topcoder.gui.diagramviewer.uml.classelements.PackageNode;

/**
 * <p>
 * This is an event listener which listens to mouse right clicked event. If the event occurs, popup menu would be shown.
 * This event listener will be registered to every node or edge in this component automatically.
 * </p>
 * <p>
 * This class in immutable, and thread-safe.
 * </p>
 * @author MiG-29, TCSDEVELOPER
 * @version 1.0
 */
public class PopupMenuTrigger extends MouseAdapter {

    /**
     * <p>
     * Default empty constructor for creating an instance of <code>PopupMenuTrigger</code>.
     * </p>
     */
    public PopupMenuTrigger() {
    }

    /**
     * <p>
     * Handles the mouse clicked event.
     * </p>
     * @param e
     *            the mouse clicked event, null will be ignored
     */
    public void mouseClicked(MouseEvent e) {
        if (e == null) {
            return;
        }
        if (e.getButton() != MouseEvent.BUTTON3) {
            return;
        }
        if (!(e.getSource() instanceof BaseNode || e.getSource() instanceof PackageNode)) {
            return;
        }
        Node source = (Node) e.getSource();
        JPopupMenu popupMenu = source.getComponentPopupMenu();
        if (popupMenu == null) {
            return;
        }
        Point position = e.getPoint();
        popupMenu.show(source, position.x, position.y);
    }
}
