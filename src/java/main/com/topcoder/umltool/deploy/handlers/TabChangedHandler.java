/*
 * Copyright (C) 2007 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.umltool.deploy.handlers;

import java.awt.Cursor;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JComponent;
import javax.swing.JTabbedPane;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import com.topcoder.diagraminterchange.Diagram;
import com.topcoder.gui.diagramviewer.DiagramState;
import com.topcoder.gui.diagramviewer.DiagramView;
import com.topcoder.gui.diagramviewer.DiagramViewer;
import com.topcoder.gui.panels.zoom.ZoomPane;
import com.topcoder.gui.panels.zoom.ZoomPanel;
import com.topcoder.umltool.deploy.DeployHelper;
import com.topcoder.umltool.deploy.DiagramType;
import com.topcoder.umltool.deploy.MainFrame;

/**
 * <p>
 * This handler will switch tool panel's state when diagram viewer's tab is switched.
 * </p>
 * <p>
 * Thread safety: This class are not required to be thread-safe. They could be used in a thread safe manner in this
 * component.
 * </p>
 *
 * @author ly, FireIce, ylouis
 * @version 1.0
 */
public class TabChangedHandler implements ChangeListener, FocusListener {

    /**
     * <p>
     * Main frame window.
     * </p>
     */
    private final MainFrame mainFrame;

    /**
     * <p>
     * Creates an instance of <code>TabChangedHandler</code>.
     * </p>
     *
     * @param mainframe
     *            the main frame window
     */
    public TabChangedHandler(MainFrame mainframe) {
        this.mainFrame = mainframe;
    }

    /**
     * <p>
     * Switches tool panel's state when when diagram viewer's tab is switched.
     * </p>
     *
     * @param e
     *            a ChangeEvent object
     */
    public void stateChanged(ChangeEvent e) {
        if (e == null) {
            return;
        }
        JTabbedPane tabbedPane = (JTabbedPane) e.getSource();
        if (tabbedPane.getSelectedIndex() == -1) {
            return;
        }
        ZoomPanel zoomPanel = (ZoomPanel) tabbedPane.getSelectedComponent();
        ZoomPane zoomPane = (ZoomPane) zoomPanel.getViewport().getComponent(0);
        DiagramView view = (DiagramView) zoomPane.getComponent(0);
        Diagram diagram = view.getDiagram();
        String diagramType = DeployHelper.getTypeInfo(diagram);
        view.getViewer().setState(DiagramState.SELECT_ELEMENT);
        view.setCursor(Cursor.getDefaultCursor());
        if (diagramType.equals(DeployHelper.DIAGRAM_TYPEINFO[DiagramType.ACTIVITY.ordinal()])) {
            mainFrame.getToolPanel().SetToolPanelType(DiagramType.ACTIVITY);
        } else if (diagramType.equals(DeployHelper.DIAGRAM_TYPEINFO[DiagramType.CLASS.ordinal()])) {
            mainFrame.getToolPanel().SetToolPanelType(DiagramType.CLASS);
        } else if (diagramType.equals(DeployHelper.DIAGRAM_TYPEINFO[DiagramType.SEQUENCE.ordinal()])) {
            mainFrame.getToolPanel().SetToolPanelType(DiagramType.SEQUENCE);
        } else {
            mainFrame.getToolPanel().SetToolPanelType(DiagramType.USECASE);
        }
        DiagramViewer viewer = mainFrame.getDiagramViewer();
        List<JComponent> components = new ArrayList<JComponent>(viewer.getAllSelectedElements());
        for (JComponent component : components) {
            if (component instanceof DiagramView) {
                viewer.removeSelectedElement(component);
            }
        }
        viewer.addSelectedElement(view);
        DeployHelper.notifySelectionChanged(mainFrame, view.getViewer());
    }

    /**
     * <p>
     * Notifies diagram view selection.
     * </p>
     *
     * @param e
     *            a ChangeEvent object
     */
    public void focusGained(FocusEvent e) {
        if (e == null) {
            return;
        }
        JTabbedPane tabbedPane = (JTabbedPane) e.getSource();
        if (tabbedPane.getSelectedIndex() == -1) {
            return;
        }
        ZoomPanel zoomPanel = (ZoomPanel) tabbedPane.getSelectedComponent();
        ZoomPane zoomPane = (ZoomPane) zoomPanel.getViewport().getComponent(0);
        DiagramView view = (DiagramView) zoomPane.getComponent(0);
        DiagramViewer viewer = mainFrame.getDiagramViewer();
        viewer.addSelectedElement(view);
        DeployHelper.notifySelectionChanged(mainFrame, view.getViewer());
    }

    public void focusLost(FocusEvent e) {
        // nothing to do
    }

}
