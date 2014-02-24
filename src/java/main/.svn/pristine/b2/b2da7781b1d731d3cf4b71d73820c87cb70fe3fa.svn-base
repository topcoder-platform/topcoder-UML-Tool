/*
 * Copyright (C) 2007 TopCoder Inc., All Rights Reserved.
 */

package com.topcoder.umltool.deploy.handlers;

import java.awt.Color;
import java.awt.dnd.DropTarget;
import java.util.EventObject;

import com.topcoder.diagraminterchange.Diagram;
import com.topcoder.diagraminterchange.Dimension;
import com.topcoder.diagraminterchange.Point;
import com.topcoder.gui.diagramviewer.DiagramView;
import com.topcoder.gui.diagramviewer.DiagramViewer;
import com.topcoder.gui.panels.zoom.ZoomPane;
import com.topcoder.uml.actions.diagram.CreateActivityDiagramAction;
import com.topcoder.uml.actions.diagram.CreateDiagramAction;
import com.topcoder.umltool.deploy.DeployHelper;
import com.topcoder.umltool.deploy.MainFrame;
import com.topcoder.util.actionmanager.Action;
import com.topcoder.util.actionmanager.UndoableAction;
import com.topcoder.util.eventmanager.ActionEvent;
import com.topcoder.util.eventmanager.ActionEventListener;
import com.topcoder.util.eventmanager.EventValidation;
import com.topcoder.util.eventmanager.RedoChangesEvent;
import com.topcoder.util.eventmanager.UndoChangesEvent;

/**
 * <p>
 * Implementation of the ActionEventListener interface. This class is registered to listen to the creation of diagram.
 * </p>
 * <p>
 * New a DiagramView using the created diagram.
 * </p>
 * <p>
 * Thread Safety: The class is immutable and thread safe.
 * </p>
 * @author ly, FireIce, ylouis
 * @version 1.0
 */

public class CreateDiagramHandler implements ActionEventListener {
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
        DeployHelper.checkNotNull(eventValidation, "eventValidation");
        createDiagramView(event);
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
        DeployHelper.checkNotNull(event.getSource(), "source");

        MainFrame mainFrame = (MainFrame) event.getSource();
        DiagramViewer viewer = mainFrame.getDiagramViewer();

        Diagram diagram = null;
        Action action = ((ActionEvent) event).getAction();
        if (action instanceof CreateDiagramAction) {
            diagram = ((CreateDiagramAction) action).getDiagram();

        } else if (action instanceof CreateActivityDiagramAction) {
            diagram = ((CreateActivityDiagramAction) action).getDiagram();
        }
        viewer.closeDiagramView(diagram);
        viewer.revalidate();
        mainFrame.getDocumentTree().updateTree();
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
        DeployHelper.checkNotNull(undoableAction, "undoableAction");
        createDiagramView(event);
    }

    /**
     * <p>
     * Gets the diagram from CreateDiagramAction and opens a view.
     * </p>
     * @param event
     *            the create diagram action event
     */
    private void createDiagramView(EventObject event) {
        DeployHelper.checkNotNull(event, "event");
        DeployHelper.checkNotNull(event.getSource(), "source");

        MainFrame mainFrame = (MainFrame) event.getSource();
        DiagramViewer viewer = mainFrame.getDiagramViewer();
        Dimension dimension = new Dimension();
        int gap = mainFrame.getDiagramViewer().getDiagramViewGap();
        dimension.setWidth(mainFrame.getDiagramViewer().getWidth() - gap * 2);
        dimension.setHeight(mainFrame.getDiagramViewer().getHeight() - gap * 2);
        Point point = new Point();
        point.setX(gap);
        point.setY(gap);

        // Gets the diagram from action
        Diagram diagram = null;
        Action action = ((ActionEvent) event).getAction();
        DiagramView view = null;
        mainFrame.getDocumentTree().updateTree();
        if (action instanceof CreateDiagramAction) {
            diagram = ((CreateDiagramAction) action).getDiagram();
        } else if (action instanceof CreateActivityDiagramAction) {
            diagram = ((CreateActivityDiagramAction) action).getDiagram();
        }

        // set position and size to diagram
        diagram.setPosition(point);
        diagram.setSize(dimension);

        // set view and zoom pane.
        DeployHelper.clearSelected(viewer);
        view = viewer.openDiagramView(diagram);

        DropTarget dropTarget = new DropTarget(view, new ViewDropTargetHandler(mainFrame));
        view.setDropTarget(dropTarget);

        DiagramViewDragHandler viewDragHandler = new DiagramViewDragHandler();
        view.addMouseListener(viewDragHandler);
        view.addMouseMotionListener(viewDragHandler);

        java.awt.Dimension preferredSize = new java.awt.Dimension((int) Math.ceil(diagram.getSize().getWidth()),
                (int) Math.ceil(diagram.getSize().getHeight()));
        view.setSize(preferredSize);
        view.setPreferredSize(preferredSize);
        preferredSize.width += gap * 2;
        preferredSize.height += gap * 2;
        ZoomPane zoomPane = (ZoomPane) view.getParent();
        zoomPane.setSize(preferredSize);
        zoomPane.setPreferredSize(preferredSize);

        view.setBackground(Color.WHITE);
        view.setOpaque(true);
        view.setComponentPopupMenu(mainFrame.getPopupMenu());

        viewer.revalidate();
    }

}
