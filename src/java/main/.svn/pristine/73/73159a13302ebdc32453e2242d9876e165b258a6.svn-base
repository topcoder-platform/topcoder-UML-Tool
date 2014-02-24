/*
 * Copyright (C) 2007 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.umltool.deploy.actions;

import java.awt.Component;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.JTabbedPane;
import javax.swing.KeyStroke;

import com.topcoder.gui.diagramviewer.DiagramView;
import com.topcoder.gui.diagramviewer.DiagramViewer;
import com.topcoder.gui.diagramviewer.edges.Edge;
import com.topcoder.gui.diagramviewer.elements.Node;
import com.topcoder.gui.panels.zoom.ZoomPane;
import com.topcoder.gui.panels.zoom.ZoomPanel;
import com.topcoder.umltool.deploy.MainFrame;

/**
 * <p>
 * Select all elements action.
 * </p>
 *
 * @author ly, FireIce, ylouis
 * @version 1.0
 */
public class SelectAllElementsAction extends AbstractAction {

    /**
     * <p>
     * Action name.
     * <p>
     */
    private static final String ACTION_NAME = "Select All Elements";

    /**
     * <p>
     * Action description.
     * <p>
     */
    private static final String SHORT_DESCRIPTION = "Select All Elements.";

    /**
     * <p>
     * Acceleration key.
     * <p>
     */
    private static final KeyStroke DEFAULT_ACCELERATOR_KEY =
        KeyStroke.getKeyStroke('A', Toolkit.getDefaultToolkit().getMenuShortcutKeyMask());

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
    public SelectAllElementsAction(MainFrame mainFrame) {
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
        ZoomPanel zoomPanel = (ZoomPanel) tabbedPane.getSelectedComponent();
        ZoomPane zoomPane = (ZoomPane) zoomPanel.getViewport().getComponent(0);
        DiagramView view = (DiagramView) zoomPane.getComponent(0);

        for (Component comp : view.getComponents()) {
            if (comp instanceof Edge) {
                Edge edge = (Edge) comp;
                diagramViewer.addSelectedElement(edge);
                edge.notifySelected();
            } else if (comp instanceof Node) {
                Node node = (Node) comp;
                diagramViewer.addSelectedElement(node);
                node.notifySelected();
            }
        }
    }
}
