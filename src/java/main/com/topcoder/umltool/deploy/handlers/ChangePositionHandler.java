/*
 * Copyright (C) 2007 TopCoder Inc., All Rights Reserved.
 */

package com.topcoder.umltool.deploy.handlers;

import java.util.EventObject;
import java.util.Set;

import com.topcoder.gui.diagramviewer.elements.Node;
import com.topcoder.gui.diagramviewer.elements.NodeContainer;
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
 * Implementation of the ActionEventListener interface. This class is registered to listen to the position change of
 * node. Move the node to new position, and also set the position of edges connected to it.
 * </p>
 * <p>
 * Move the node to new position, and also set the position of edges connected to it.
 * </p>
 * <p>
 * Thread Safety: The class is immutable and thread safe.
 * </p>
 * @author ly, FireIce, ylouis, TCSDEVELOPER
 * @version 1.0
 */

public class ChangePositionHandler implements ActionEventListener {
    /**
     * <p>
     * Reference to main frame.
     * </p>
     */
    private final MainFrame mainFrame;

    /**
     * <p>
     * Creates an instance of ChangePositionHandler.
     * </p>
     * @param mainFrame
     *            main frame of uml tool
     * @throws IllegalArgumentException
     *             if argument is null
     */
    public ChangePositionHandler(MainFrame mainFrame) {
        DeployHelper.checkNotNull(mainFrame, "mainFrame");
        this.mainFrame = mainFrame;
    }

    /**
     * <p>
     * This method is called to inform the listener that the event is performed.
     * </p>
     * @param event
     *            the non null event has been performed
     * @param eventValidation
     *            the non null validation result
     * @throws IllegalArgumentException
     *             if event or eventValidation is null
     */
    public void actionPerformed(EventObject event, EventValidation eventValidation) {
        updateNodePosition(event);
    }

    /**
     * <p>
     * This method is called to inform the listener that the event is undone.
     * </p>
     * @param event
     *            the non null event has been undone
     * @param undoableAction
     *            the non null action which is undone
     * @throws IllegalArgumentException
     *             if event or undoableAction is null
     */
    public void undoActionPerformed(UndoChangesEvent event, UndoableAction undoableAction) {
        updateNodePosition(event);
        StylePanel stylePanel = mainFrame.getStylePanel();
        if (stylePanel.isVisible()) {
            stylePanel.setStyleObjectList(stylePanel.getStyleObjectList());
        }
    }

    /**
     * <p>
     * This method is called to inform the listener that the event is redone.
     * </p>
     * @param event
     *            the non null event which has been redone
     * @param undoableAction
     *            the non null action which is redone
     * @throws IllegalArgumentException
     *             if event or undoableAction is null
     */
    public void redoActionPerformed(RedoChangesEvent event, UndoableAction undoableAction) {
        updateNodePosition(event);
        StylePanel stylePanel = mainFrame.getStylePanel();
        if (stylePanel.isVisible()) {
            if (stylePanel.getStyleObjectList().size() > 0) {
                stylePanel.setStyleObjectList(stylePanel.getStyleObjectList());
            }
        }
    }

    /**
     * <p>
     * Updates the position of node contained in the event object.
     * </p>
     * @param event
     *            the event object
     */
    private void updateNodePosition(EventObject event) {
        DeployHelper.checkNotNull(event, "event");
        DeployHelper.checkNotNull(event.getSource(), "source");
        Node node = (Node) event.getSource();

        DeployHelper.nodeNotifyChange(node, "Position changed", mainFrame);
        if (node instanceof NodeContainer) {
            NodeContainer container = (NodeContainer) node;
            Set<Node> set = DeployHelper.getNodes(container);
            for (Node contained : set) {
                DeployHelper.nodeNotifyChange(contained, "Node moved", mainFrame);
            }
        }
    }
}
