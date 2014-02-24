/*
 * Copyright (C) 2007 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.umltool.deploy.handlers;

import java.util.EventObject;

import com.topcoder.gui.diagramviewer.edges.Edge;
import com.topcoder.umltool.deploy.DeployHelper;
import com.topcoder.umltool.deploy.MainFrame;
import com.topcoder.util.actionmanager.UndoableAction;
import com.topcoder.util.eventmanager.ActionEventListener;
import com.topcoder.util.eventmanager.EventValidation;
import com.topcoder.util.eventmanager.RedoChangesEvent;
import com.topcoder.util.eventmanager.UndoChangesEvent;

/**
 * <p>
 * Implementation of the ActionEventListener interface. This class is registered to listen to the way point change of
 * edge
 * </p>
 * <p>
 * This handler will notify the edge its way points has been changed.
 * </p>
 * <p>
 * Thread Safety: The class is immutable and thread safe.
 * </p>
 * @author ly, FireIce, ylouis
 * @version 1.0
 */
public class ChangeRelationshipPathHandler implements ActionEventListener {

    /**
     * <p>
     * Main frame window.
     * </p>
     */
    private final MainFrame mainFrame;

    /**
     * <p>
     * Creates an instance of <code>ChangeRelationPathHandler</code>.
     * </p>
     * @param mainframe
     *            main frame window
     * @throws IllegalArgumentException
     *             if argument is null
     */
    public ChangeRelationshipPathHandler(MainFrame mainframe) {
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
     *             if event is null
     */
    public void actionPerformed(EventObject event, EventValidation eventValidation) {
        DeployHelper.checkNotNull(event, "event");
        Edge edge = (Edge) event.getSource();
        updateEdges(edge);
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
     *             if event is null
     */
    public void undoActionPerformed(UndoChangesEvent event, UndoableAction undoableAction) {
        DeployHelper.checkNotNull(event, "event");
        Edge edge = (Edge) event.getSource();
        updateEdges(edge);
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
     *             if event is null
     */
    public void redoActionPerformed(RedoChangesEvent event, UndoableAction undoableAction) {
        DeployHelper.checkNotNull(event, "event");
        Edge edge = (Edge) event.getSource();
        updateEdges(edge);
    }

    /**
     * <p>
     * Updates edge when its way point has been changed.
     * </p>
     * @param edge
     *            the edge whose way point has been changed
     */
    private void updateEdges(Edge edge) {
        DeployHelper.updateEdgeWayPoint(edge, mainFrame);
    }
}
