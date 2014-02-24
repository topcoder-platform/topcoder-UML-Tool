/*
 * Copyright (C) 2007 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.gui.diagramviewer.uml.classelements.event;

import java.awt.Point;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JComponent;
import javax.swing.JPopupMenu;

import com.topcoder.gui.diagramviewer.DiagramViewer;
import com.topcoder.gui.diagramviewer.uml.classelements.BaseNode;
import com.topcoder.gui.diagramviewer.uml.classelements.GroupTextField;
import com.topcoder.gui.diagramviewer.uml.classelements.StereotypeTextField;

/**
 * <p>
 * This is an event listener which listens to mouse right button clicked event and the mouse left button clicked
 * (selection). If the right button event occurs, popup menu would be shown. If the left mouse button clicked event
 * occurs, then the corresponding text field will be selected. This event listener will be registered to every
 * operations or attributes compartments in this component automatically.
 * </p>
 * <p>
 * This class in immutable, and thread-safe.
 * </p>
 * @author MiG-29, TCSDEVELOPER
 * @version 1.0
 */
public class PopupGroupFieldTrigger extends MouseAdapter {
    /**
     * <p>
     * Creates an instance of <code>PopupGroupFieldTrigger</code>.
     * </p>
     */
    public PopupGroupFieldTrigger() {
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
        if (e.getButton() == MouseEvent.BUTTON3) {
            if (!(e.getSource() instanceof GroupTextField)) {
                return;
            }
            GroupTextField source = (GroupTextField) e.getSource();
            if (source.getParent() == null || !(source.getParent() instanceof BaseNode)) {
                return;
            }
            BaseNode node = (BaseNode) source.getParent();
            JPopupMenu popupMenu = node.getAttributesOperationsPopup();
            if (popupMenu == null) {
                return;
            }
            Point position = e.getPoint();
            popupMenu.show(source, position.x, position.y);
        } else if (e.getButton() == MouseEvent.BUTTON1 && e.getClickCount() == 1) {
            if (!(e.getSource() instanceof GroupTextField)) {
                return;
            }
            GroupTextField source = (GroupTextField) e.getSource();
            StereotypeTextField textField = source.findItem(e.getPoint());
            /*
             * BugFix: BUGID UML-8192
             * Description:
             * In mouseClicked, if the findItem method returns null, this method should simply return directly,
             * since no item is found.
             * Solution:
             * Return directly if the found text field is null.
             */
            if (textField == null) {
                return;
            }

            // Get the diagram viewer
            JComponent viewer = source;
            while (viewer != null) {
                viewer = (JComponent) viewer.getParent();
                if (viewer instanceof DiagramViewer) {
                    break;
                }
            }
            if (viewer == null) {
                return;
            }
            ((DiagramViewer) viewer).addSelectedElement(textField);
        }
    }
}
