/*
 * Copyright (C) 2007 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.gui.diagramviewer.uml.classedges.event;

import com.topcoder.gui.diagramviewer.uml.classedges.ActiveEdgeEnding;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JPopupMenu;

/**
 * <p>
 * This is an event listener which listens to mouse right clicked event for active edge endings. If the event occurs,
 * popup menu for edge ending would be shown. This event listener will be registered to every active edge ending (and
 * their TextField) in this component automatically.
 * </p>
 *
 * <p>
 * <b>Thread Safety:</b> This class in immutable, and thread-safe.
 * </p>
 *
 * @author MiG-29, littlebull
 * @version 1.0
 */
public class PopupMenuEndingTrigger extends MouseAdapter {

    /**
     * <p>
     * Default empty constructor.
     * </p>
     */
    public PopupMenuEndingTrigger() {
    }

    /**
     * <p>
     * Handle the mouse clicked event. If it is a right clicked event, popup menu of source active edge ending will be
     * shown.
     * </p>
     *
     * @param event
     *            the mouse clicked event.
     */
    public void mouseClicked(MouseEvent event) {
        //NOTE: I've confused by right mouse click, through my test,
        //both MouseEvent.BUTTON2 and MouseEvent.BUTTON3 means right mouse click when using different mouse ;(

        if (event == null || event.getButton() == MouseEvent.BUTTON1) {
            return;
        }

        if (event.getSource() instanceof ActiveEdgeEnding) {
            JPopupMenu popup = ((ActiveEdgeEnding) event.getSource()).getComponentPopupMenu();
            if (popup != null) {
                popup.show((ActiveEdgeEnding) event.getSource(), event.getPoint().x, event.getPoint().y);
            }
        }
    }
}
