/*
 * Copyright (C) 2007 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.umltool.deploy.handlers;

import java.util.EventObject;

import com.topcoder.gui.diagramviewer.DiagramView;
import com.topcoder.gui.diagramviewer.elements.Node;
import com.topcoder.gui.panels.style.StylePanel;
import com.topcoder.umltool.deploy.DeployHelper;
import com.topcoder.umltool.deploy.MainFrame;
import com.topcoder.util.actionmanager.UndoableAction;
import com.topcoder.util.eventmanager.ActionEventListener;
import com.topcoder.util.eventmanager.EventValidation;
import com.topcoder.util.eventmanager.RedoChangesEvent;
import com.topcoder.util.eventmanager.UndoChangesEvent;

/**
 * <p>
 * Implementation of the ActionEventListener interface. This class is registered to listen to the size change of node.
 * Change the node to new size.
 * </p>
 * <p>
 * Thread Safety: The class is immutable and thread safe.
 * </p>
 * @author ly, FireIce, ylouis, TCSDEVELOPER
 * @version 1.0
 */
public class ChangeSizeHandler implements ActionEventListener {
    /**
     * <p>
     * The mainframe associated with this handler.
     * </p>
     */
    private final MainFrame mainFrame;

    /**
     * <p>
     * Creates an instance of ChangeSizeHandler with the mainframe.
     * </p>
     * @param mainFrame
     *            the mainframe
     */
    public ChangeSizeHandler(MainFrame mainFrame) {
        DeployHelper.checkNotNull(mainFrame, "mainFrame");
        this.mainFrame = mainFrame;
    }

    /**
     * <p>
     * This method is called to inform the handler that the event is performed.
     * </p>
     * @param event
     *            the non null event has been performed
     * @param eventValidation
     *            the non null validation result
     * @throws IllegalArgumentException
     *             if event or eventValidation is null
     */
    public void actionPerformed(EventObject event, EventValidation eventValidation) {
        performAction(event);
    }

    /**
     * <p>
     * This method is called to inform the handler that the event is undone.
     * </p>
     * @param event
     *            the non null event has been undone
     * @param undoableAction
     *            the non null action which is undone
     * @throws IllegalArgumentException
     *             if event or undoableAction is null
     */
    public void undoActionPerformed(UndoChangesEvent event, UndoableAction undoableAction) {
        performAction(event);
        StylePanel stylePanel = mainFrame.getStylePanel();
        if (stylePanel.isVisible()) {
            stylePanel.setStyleObjectList(stylePanel.getStyleObjectList());
        }
    }

    /**
     * <p>
     * This method is called to inform the handler that the event is redone.
     * </p>
     * @param event
     *            the non null event which has been redone
     * @param undoableAction
     *            the non null action which is redone
     * @throws IllegalArgumentException
     *             if event or undoableAction is null
     */
    public void redoActionPerformed(RedoChangesEvent event, UndoableAction undoableAction) {
        performAction(event);
        StylePanel stylePanel = mainFrame.getStylePanel();
        if (stylePanel.isVisible()) {
            if (stylePanel.getStyleObjectList().size() > 0) {
                stylePanel.setStyleObjectList(stylePanel.getStyleObjectList());
            }
        }
    }

    /**
     * <p>
     * Updates the size of node or edge contained in the event object.
     * </p>
     * @param event
     *            the event object
     */
    private void updateNodeSize(EventObject event) {
        Node node = (Node) event.getSource();
        DeployHelper.nodeNotifyChange(node, "Size changed", mainFrame);
    }

    /**
     * <p>
     * Updates the style of node or diagram view contained in the event object.
     * </p>
     * @param event
     *            the event object
     */
    private void performAction(EventObject event) {
        DeployHelper.checkNotNull(event, "event");
        DeployHelper.checkNotNull(event.getSource(), "source");
        Object source = event.getSource();
        if (source instanceof Node) {
            updateNodeSize(event);
        } else if (source instanceof DiagramView) {
            DiagramView view = (DiagramView) source;
            DeployHelper.resizeDiagramView(view);
        }
    }
}
