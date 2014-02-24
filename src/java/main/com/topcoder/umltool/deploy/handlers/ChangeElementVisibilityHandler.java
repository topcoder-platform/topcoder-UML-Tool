/*
 * Copyright (C) 2007 TopCoder Inc., All Rights Reserved.
 */

package com.topcoder.umltool.deploy.handlers;

import java.util.EventObject;

import com.topcoder.gui.diagramviewer.elements.Node;
import com.topcoder.umltool.deploy.DeployHelper;
import com.topcoder.umltool.deploy.MainFrame;
import com.topcoder.util.actionmanager.UndoableAction;
import com.topcoder.util.eventmanager.ActionEventListener;
import com.topcoder.util.eventmanager.EventValidation;
import com.topcoder.util.eventmanager.RedoChangesEvent;
import com.topcoder.util.eventmanager.UndoChangesEvent;

/**
 * <p>
 * Implementation of the ActionEventListener interface. This class is registered to listen to the visibility change of
 * node's graph elements. This handler simply notify the node its graph node structure has been changed.
 * </p>
 * <p>
 * Thread Safety: The class is immutable and thread safe.
 * </p>
 * @author ly
 * @version 1.0
 */

public class ChangeElementVisibilityHandler implements ActionEventListener {
    /**
     * <p>
     * Reference to main frame.
     * </p>
     */
    private final MainFrame mainFrame;

    /**
     * <p>
     * Creates an instance of ChangeElementVisibilityHandler.
     * </p>
     * @param mainFrame
     *            main frame of uml tool
     * @throws IllegalArgumentException
     *             if argument is null
     */
    public ChangeElementVisibilityHandler(MainFrame mainFrame) {
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
        notifyNode(event);
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
        notifyNode(event);
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
        notifyNode(event);
    }

    /**
     * <p>
     * Notifies the node whose graph node structure has been changed. The node instance can be got from event.
     * </p>
     * @param event
     *            the event object (ignore null)
     */
    private void notifyNode(EventObject event) {
        if (event == null || !(event.getSource() instanceof Node)) {
            return;
        }
        DeployHelper.nodeNotifyChange((Node) event.getSource(),
                "Visibility of contained graph element has been changed.", mainFrame);
    }
}
