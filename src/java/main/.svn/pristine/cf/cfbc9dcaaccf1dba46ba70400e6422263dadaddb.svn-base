/*
 * Copyright (C) 2007 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.umltool.deploy.actions;

import java.awt.event.ActionEvent;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;
import java.util.List;

import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.JComponent;
import javax.swing.JPopupMenu;
import javax.swing.JTabbedPane;
import javax.swing.KeyStroke;

import com.topcoder.gui.diagramviewer.DiagramViewer;
import com.topcoder.umltool.deploy.MainFrame;

/**
 * <p>
 * Shortcut menu action.
 * </p>
 *
 * @author ly, FireIce, ylouis
 * @version 1.0
 */
public class ShortcutMenuAction extends AbstractAction {

    /**
     * <p>
     * Action name.
     * <p>
     */
    private static final String ACTION_NAME = "Shortcut menu";

    /**
     * <p>
     * Action description.
     * <p>
     */
    private static final String SHORT_DESCRIPTION = "Shortcut menu.";

    /**
     * <p>
     * Acceleration key.
     * <p>
     */
    private static final KeyStroke DEFAULT_ACCELERATOR_KEY =
        KeyStroke.getKeyStroke(KeyEvent.VK_F7, InputEvent.SHIFT_MASK);

    /**
     * <p>
     * Reference to main frame.
     * <p>
     */
    private final MainFrame mainFrame;

    /**
     * <p>
     * Constructs an instance of copy element action.
     * <p>
     *
     * @param mainFrame
     *            main frame of uml tool
     */
    public ShortcutMenuAction(MainFrame mainFrame) {
        super(ACTION_NAME);
        this.putValue(Action.SHORT_DESCRIPTION, SHORT_DESCRIPTION);
        this.putValue(Action.ACCELERATOR_KEY, DEFAULT_ACCELERATOR_KEY);

        this.mainFrame = mainFrame;
    }

    /**
     * <p>
     * Performing the action.
     * <p>
     *
     * @param actionEvent
     *            the action event
     */
    public void actionPerformed(ActionEvent actionEvent) {
        DiagramViewer diagramViewer = mainFrame.getDiagramViewer();
        JTabbedPane tabbedPane = diagramViewer.getTabbedPane();
        if (tabbedPane.getSelectedIndex() == -1) {
            return;
        }

        List<JComponent> filteredSelectedElements = diagramViewer.getAllSelectedElements();
        if (filteredSelectedElements.size() == 1) {
            JComponent comp = filteredSelectedElements.get(0);
            JPopupMenu popupMenu = comp.getComponentPopupMenu();
            if (popupMenu != null) {
                popupMenu.show(comp, 10, 10);
            }
        }
    }
}
