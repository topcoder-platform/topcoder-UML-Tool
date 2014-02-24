/*
 * Copyright (C) 2007 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.umltool.deploy.handlers;

import java.awt.Point;
import java.awt.event.MouseEvent;

import javax.swing.JPopupMenu;

import com.topcoder.gui.diagramviewer.DiagramView;
import com.topcoder.gui.diagramviewer.DiagramViewer;
import com.topcoder.gui.diagramviewer.edges.Util;
import com.topcoder.gui.diagramviewer.elements.Node;
import com.topcoder.gui.diagramviewer.uml.classelements.StereotypeTextField;
import com.topcoder.gui.panels.style.StylePanel;
import com.topcoder.umltool.deploy.DeployHelper;
import com.topcoder.umltool.deploy.MainFrame;

/**
 * <p>
 * This implementation of MouseAdapter will check which graph element is selected, and update style panel, document tree
 * panel, property panel and documentation panel in the main frame.
 * </p>
 * <p>
 * Thread safety: This class are not required to be thread-safe. They could be used in a thread safe manner in this
 * component.
 * </p>
 * @author TCSDEVELOPER
 * @version 1.0
 */
public class FeatureSelectionHandler extends CompartmentMouseHandler {
    /**
     * <p>
     * The MainFrame associated with this handler.
     * </p>
     */
    private final MainFrame mainFrame;

    /**
     * <p>
     * Creates an instance of FeatureSelectionHandler with the mainframe.
     * </p>
     * @param mainFrame
     *            the mainframe
     * @throws IllegalArgumentException
     *             if argument is null
     */
    public FeatureSelectionHandler(MainFrame mainFrame) {
        DeployHelper.checkNotNull(mainFrame, "mainFrame");
        this.mainFrame = mainFrame;
    }

    /**
     * <p>
     * Updates panels when mouse is pressed.
     * </p>
     * @param e
     *            the mouse event
     */
    public void mousePressed(MouseEvent e) {
        if (e == null) {
            return;
        }
        if (e.getSource() instanceof StereotypeTextField) {
            // Gets the DiagramViewer instance associated
            StereotypeTextField textField = (StereotypeTextField) e.getSource();
            Node node = (Node) textField.getParent().getParent();
            DiagramView view = (DiagramView) node.getParent();
            DiagramViewer viewer = view.getViewer();
            if (!Util.isControlDown(e)) {
                DeployHelper.clearSelected(viewer);

                // Select the text field to the active list of diagram viewer
                viewer.addSelectedElement(textField);
                textField.requestFocus();
                textField.setOpaque(true);
                textField.repaint();
            } else {
                if (viewer.isElementSelected(textField)) {
                    // Unselect this text field
                    viewer.removeSelectedElement(textField);
                    textField.setOpaque(false);
                    textField.repaint();
                } else {
                    // Select this text field
                    viewer.addSelectedElement(textField);
                    textField.requestFocus();
                    textField.setOpaque(true);
                    textField.repaint();
                }
            }
            DeployHelper.notifySelectionChanged(mainFrame, view);
            textField.requestFocus(true);
            //BUGR-116 - call popup for attributes and operations
            if(e.getButton() == MouseEvent.BUTTON3){
            	JPopupMenu popupMenu = textField.getComponentPopupMenu();
                if (popupMenu == null) {
                    return;
                }
                Point position = e.getPoint();
                popupMenu.show(e.getComponent(), position.x, position.y);
            }
        }
    }

    /**
     * <p>
     * Handle the <b>MOUSE_DRAGGED</b> event.
     * </p>
     * <p>
     * Empty.
     * </p>
     * @param e
     *            the mouse dragged event
     */
    public void mouseDragged(MouseEvent e) {
    }

    /**
     * <p>
     * Updates the style panel when mouse is released.
     * </p>
     * @param e
     *            the mouse event
     */
    public void mouseReleased(MouseEvent e) {
        if (e == null) {
            return;
        }
        StylePanel stylePanel = mainFrame.getStylePanel();
        stylePanel.setStyleObjectList(stylePanel.getStyleObjectList());
    }
}
