/*
 * Copyright (C) 2007 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.umltool.deploy.handlers;

import java.awt.Component;
import java.awt.Point;
import java.util.ArrayList;
import java.util.List;

import com.topcoder.gui.diagramviewer.DiagramView;
import com.topcoder.gui.diagramviewer.edges.Edge;
import com.topcoder.gui.diagramviewer.edges.EdgeDragListener;
import com.topcoder.gui.diagramviewer.edges.WayPointEvent;
import com.topcoder.gui.diagramviewer.uml.sequenceelements.SequenceEdge;
import com.topcoder.umltool.deploy.DeployHelper;
import com.topcoder.umltool.deploy.MainFrame;

/**
 * <p>
 * This handler will change the vertical position of sequence edge.
 * </p>
 * <p>
 * Thread safety: This class are not required to be thread-safe. They could be used in a thread safe manner in this
 * component.
 * </p>
 *
 * @author ly, FireIce, ylouis
 * @version 1.0
 */
public class SequenceEdgeDragHandler implements EdgeDragListener {
    /**
     * <p>
     * Main frame window.
     * </p>
     */
    protected final MainFrame mainFrame;

    /**
     * <p>
     * Creates an instance of <code>EdgeDragHandler</code>.
     * </p>
     *
     * @param mainframe
     *            main frame window
     * @throws IllegalArgumentException
     *             if argument is null
     */
    public SequenceEdgeDragHandler(MainFrame mainframe) {
        DeployHelper.checkNotNull(mainframe, "mainframe");
        this.mainFrame = mainframe;
    }

    /**
     * <p>
     * Processes the edge dragged event.
     * </p>
     *
     * @param e
     *            a WayPointEvent instance used to indicate the edge drag event
     */
    public void edgeDragged(WayPointEvent e) {
        if (e == null) {
            return;
        }
        Edge edge = (Edge) e.getSource();
        dragEdge(edge, e.getOldPosition(), e.getNewPosition());
    }

    /**
     * <p>
     * Drags an edge. This will insert a new way point at new position.
     * </p>
     *
     * @param edge
     *            edge dragged
     * @param oldPosition
     *            old position dragging from
     * @param newPosition
     *            new position dragging to
     */
    private void dragEdge(Edge edge, Point oldPosition, Point newPosition) {
        double offset = newPosition.getY() - oldPosition.getY();
        List<SequenceEdge> selectedSequenceEdges = getSelectedSequenceEdge((DiagramView) edge.getParent());
        for (SequenceEdge sequenceEdge : selectedSequenceEdges) {
            DeployHelper.moveEdge(sequenceEdge, 0, (int) offset);
        }
    }

    /**
     * <p>
     * Gets the list of selected sequence edges.
     * </p>
     *
     * @param diagramView
     *            the diagram view where dragging happens
     */
    private List<SequenceEdge> getSelectedSequenceEdge(DiagramView diagramView) {
        List<SequenceEdge> selectedSequenceEdges = new ArrayList<SequenceEdge>();
        for (Component component : diagramView.getViewer().getAllSelectedElements()) {
            if (component instanceof SequenceEdge && component.getParent() == diagramView) {
                selectedSequenceEdges.add((SequenceEdge) component);
            }
        }
        return selectedSequenceEdges;
    }
}
