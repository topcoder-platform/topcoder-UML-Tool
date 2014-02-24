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
 * This implementation handles the diagram element removed event. It will remove the corresponding Node from
 * corresponding NodeContainer. This is an UndoableAction.
 * </p>
 * @author ly, FireIce, ylouis
 * @version 1.0
 */
public class RemoveDiagramElementHandler implements ActionEventListener {

    /**
     * <p>
     * Main frame window.
     * </p>
     */
    private final MainFrame mainFrame;

    /**
     * <p>
     * Creates an instance of <code>RemoveDiagramElementHanlder</code>.
     * </p>
     * @param mainframe
     *            main frame window
     * @throws IllegalArgumentException
     *             if the argument is null
     */
    public RemoveDiagramElementHandler(MainFrame mainframe) {
        DeployHelper.checkNotNull(mainframe, "mainframe");
        this.mainFrame = mainframe;
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
        DeployHelper.checkNotNull(event, "event");
        DeployHelper.checkNotNull(eventValidation, "eventValidation");
        if (event.getSource() instanceof Node) {
            Node node = (Node) event.getSource();
            DeployHelper.removeFromOwner(node);
            DeployHelper.removeNodeFromContainer(node, mainFrame);
        }
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
        DeployHelper.checkNotNull(event, "event");
        DeployHelper.checkNotNull(undoableAction, "undoableAction");
        if (event.getSource() instanceof Node) {
            Node node = (Node) event.getSource();
            DeployHelper.addNodeToContainer(node, mainFrame);
            DeployHelper.addToOwner(node);
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
        DeployHelper.checkNotNull(event, "event");
        DeployHelper.checkNotNull(undoableAction, "undoableAction");
        if (event.getSource() instanceof Node) {
            Node node = (Node) event.getSource();
            DeployHelper.removeFromOwner(node);
            DeployHelper.removeNodeFromContainer(node, mainFrame);
        }
    }

}
