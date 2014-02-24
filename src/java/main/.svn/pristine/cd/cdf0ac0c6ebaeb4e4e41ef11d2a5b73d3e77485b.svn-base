/*
 * Copyright (C) 2007 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.umltool.deploy.handlers;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;

import com.topcoder.gui.diagramviewer.DiagramView;
import com.topcoder.gui.diagramviewer.edges.Edge;
import com.topcoder.gui.diagramviewer.uml.sequenceelements.SequenceEdge;
import com.topcoder.umltool.deploy.DeployHelper;
import com.topcoder.umltool.deploy.MainFrame;
import com.topcoder.umltool.deploy.actions.undoable.LayoutSequenceEdgeAction;

/**
 * <p>
 * This handler will layout sequence edges.
 * </p>
 * <p>
 * Thread safety: This class are not required to be thread-safe. They could be used in a thread safe manner in this
 * component.
 * </p>
 * @author ly, FireIce, ylouis
 * @version 1.0
 */
public class SequenceEdgeMouseHandler extends MouseAdapter {

    /**
     * <p>
     * Main frame window.
     * </p>
     */
    private final MainFrame mainFrame;

    /**
     * <p>
     * Diagram view contains the edges.
     * </p>
     */
    private DiagramView diagramView;

    /**
     * <p>
     * Old sequence edge list.
     * </p>
     */
    private List<SequenceEdge> oldEdgeList;

    /**
     * <p>
     * Creates an instance of <code>EdgeMouseHandler</code>.
     * </p>
     * @param mainframe
     *            main frame window
     * @throws IllegalArgumentException
     *             if argument is null
     */
    public SequenceEdgeMouseHandler(MainFrame mainframe) {
        DeployHelper.checkNotNull(mainframe, "mainframe");
        this.mainFrame = mainframe;
        this.diagramView = DeployHelper.getDiagramView(mainFrame);
    }

    /**
     * <p>
     * Handles the <b>MOUSE_PRESSED</b> event.
     * </p>
     * <p>
     * When mouse pressed on edge, calculate the index for a new way point.
     * </p>
     * @param e
     *            the mouse pressed event
     */
    public void mousePressed(MouseEvent e) {
        if (e == null) {
            return;
        }
        oldEdgeList = DeployHelper.getSequenceEdges(diagramView);
    }

    /**
     * <p>
     * Handles the <b>MOUSE_RELEASED</b> event.
     * </p>
     * <p>
     * When mouse is released, create an action for a way point adding, and pass it to event manager.
     * </p>
     * @param e
     *            the mouse pressed event
     */
    public void mouseReleased(MouseEvent e) {
        if (e == null) {
            return;
        }
        Edge edge = (Edge) e.getSource();
        List<SequenceEdge> newEdgeList = DeployHelper.getSequenceEdges(diagramView);
        LayoutSequenceEdgeAction action = new LayoutSequenceEdgeAction(mainFrame, oldEdgeList, newEdgeList);
        mainFrame.handleActionEvent(action, edge, action.getPresentationName());
    }
}
