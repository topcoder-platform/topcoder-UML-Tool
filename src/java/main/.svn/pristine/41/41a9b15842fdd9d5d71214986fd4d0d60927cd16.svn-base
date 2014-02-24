/*
 * Copyright (C) 2007 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.umltool.deploy.handlers;

import java.awt.Component;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.geom.Line2D;
import java.util.List;

import javax.swing.JComponent;

import com.topcoder.diagraminterchange.GraphEdge;
import com.topcoder.diagraminterchange.Point;
import com.topcoder.gui.diagramviewer.DiagramView;
import com.topcoder.gui.diagramviewer.edges.Edge;
import com.topcoder.gui.diagramviewer.edges.SelectionCorner;
import com.topcoder.gui.diagramviewer.uml.classelements.ClassNode;
import com.topcoder.uml.actions.general.ChangeRelationshipPathAction;
import com.topcoder.uml.model.core.ModelElement;
import com.topcoder.uml.model.core.dependencies.Dependency;
import com.topcoder.uml.model.core.relationships.Association;
import com.topcoder.uml.model.core.relationships.Generalization;
import com.topcoder.umltool.deploy.DeployHelper;
import com.topcoder.umltool.deploy.MainFrame;
import com.topcoder.umltool.deploy.actions.undoable.ChangeEdgeParticipant;

/**
 * <p>
 * This handler will move a way point of an edge when it is dragged and released.
 * </p>
 * <p>
 * Thread safety: This class are not required to be thread-safe. They could be used in a thread safe manner in this
 * component.
 * </p>
 *
 * @author ly, FireIce, ylouis
 * @version 1.0
 */
public class WayPointMouseHandler extends MouseAdapter {
    /**
     * <p>
     * Main frame window.
     * </p>
     */
    private final MainFrame mainFrame;

    /**
     * <p>
     * Represents the index for moved way point.
     * </p>
     */
    private int index1;

    /**
     * <p>
     * Represents the index for non-moved way point.
     * </p>
     */
    private int index2 = -1;

    /**
     * <p>
     * Represents the old position for moved way point.
     * </p>
     */
    private Point oldPosition1 = new Point();

    /**
     * <p>
     * Represents the old position for moved way point.
     * </p>
     */
    private Point oldPosition2 = new Point();

    private ClassNode detachedNode;

    /**
     * <p>
     * Creates an instance of <code>WayPointMouseHanler</code>.
     * </p>
     *
     * @param mainframe
     *            main frame window
     * @throws IllegalArgumentException
     *             if argument is null
     */
    public WayPointMouseHandler(MainFrame mainframe) {
        DeployHelper.checkNotNull(mainframe, "mainframe");
        this.mainFrame = mainframe;
    }

    /**
     * <p>
     * Handles the <b>MOUSE_PRESSED</b> event.
     * </p>
     * <p>
     * When mouse is pressed on a way point, record its index and old position.
     * </p>
     *
     * @param e
     *            the mouse pressed event
     */
    public void mousePressed(MouseEvent e) {
        if (e == null) {
            return;
        }
        SelectionCorner corner = (SelectionCorner) e.getSource();
        Edge edge = (Edge) corner.getParent();
        index1 = edge.getWayPoints().indexOf(corner);
        oldPosition1.setX(edge.getGraphEdge().getWaypoints().get(index1).getX());
        oldPosition1.setY(edge.getGraphEdge().getWaypoints().get(index1).getY());
        if (index1 == 0) {
            index2 = 1;
        } else if (index1 == edge.getWayPoints().size() - 1) {
            index2 = edge.getWayPoints().size() - 2;
        }

        // if it is first or last waypoints in the edge
        if (index2 != -1) {
            oldPosition2.setX(edge.getGraphEdge().getWaypoints().get(index2).getX());
            oldPosition2.setY(edge.getGraphEdge().getWaypoints().get(index2).getY());

            // gets the detached class node,
            ModelElement element = DeployHelper.getElement(edge);
            if (element instanceof Association) {
                detachedNode =
                    (ClassNode) DeployHelper.getComponent(
                        ((Association) element).getConnections().get(index1 == 0 ? 0 : 1).getParticipant(),
                        mainFrame).get(0);
            } else if (element instanceof Generalization) {
                Generalization generalization = (Generalization) element;
                if (index1 == 0) {
                    detachedNode =
                        (ClassNode) DeployHelper.getComponent(generalization.getChild(), mainFrame).get(0);
                } else {
                    detachedNode =
                        (ClassNode) DeployHelper.getComponent(generalization.getParent(), mainFrame).get(0);
                }
            } else if (element instanceof Dependency) {
                Dependency dependency = (Dependency) element;
                if (index1 == 0) {
                    detachedNode =
                        (ClassNode) DeployHelper
                            .getComponent(dependency.getClients().iterator().next(), mainFrame).get(0);
                } else {
                    detachedNode =
                        (ClassNode) DeployHelper.getComponent(dependency.getSuppliers().iterator().next(),
                            mainFrame).get(0);
                }
            }
        }

    }

    /**
     * <p>
     * Handles the <b>MOUSE_RELEASED</b> event.
     * </p>
     * <p>
     * When mouse is released, create an action for a way point moving, and pass it to event manager.
     * </p>
     *
     * @param e
     *            the mouse pressed event
     */
    public void mouseReleased(MouseEvent e) {
        if (e == null) {
            return;
        }
        SelectionCorner corner = (SelectionCorner) e.getSource();
        Edge edge = (Edge) corner.getParent();
        int size = edge.getWayPoints().size();
        if (index1 <= 0 || index1 >= size - 1) {
            // moving the first or the last waypoints, this will change the participants of the edge
            GraphEdge graphEdge = edge.getGraphEdge();

            DiagramView view = (DiagramView) edge.getParent();
            int xView = corner.getX() - view.getX();
            int yView = corner.getY() - view.getY();

            // to avoid getting the edge instead of node, we have to do the component retrieval two times
            // - first is normal retrieval
            // - second is retrieval after changing the z-order of the edge
            Component comp = view.getComponentAt(xView, yView);
            if (comp instanceof Edge) {
                Component tempComp = comp;
                int temp = view.getComponentZOrder(comp);
                view.setComponentZOrder(comp, view.getComponentCount() - 1);
                comp = view.getComponentAt(xView, yView);
                view.setComponentZOrder(tempComp, temp);
            }

            if (comp instanceof ClassNode) {
                ClassNode classNode = (ClassNode) comp;

                ChangeEdgeParticipant action =
                    new ChangeEdgeParticipant(edge, detachedNode, classNode, oldPosition1, new java.awt.Point(
                        xView, yView), index1, view, mainFrame);
                mainFrame.handleActionEvent(action, edge, "Change Edge Participant");
            } else {
                graphEdge.getWaypoints().get(index1).setX(oldPosition1.getX());
                graphEdge.getWaypoints().get(index1).setY(oldPosition1.getY());
                graphEdge.getWaypoints().get(index2).setX(oldPosition2.getX());
                graphEdge.getWaypoints().get(index2).setY(oldPosition2.getY());
                DeployHelper.updateEdgeWayPoint(edge, mainFrame);
            }
        } else {
            // moving the inner waypoints, this case will not change the participants of the edge
            java.awt.Point point = e.getPoint();
            point.x += corner.getX();
            point.y += corner.getY();
            java.awt.Point prev = edge.getWayPoints().get(index1 - 1).getCenter();
            java.awt.Point next = edge.getWayPoints().get(index1 + 1).getCenter();
            if (HandlerHelper.isAboveEdge(point, edge, new Line2D.Double(prev, next))) {
                removeWayPoint(edge);
            } else {
                moveWayPoint(edge, point);
            }
        }
    }

    /**
     * <p>
     * Removes a way point to a new position.
     * </p>
     *
     * @param edge
     *            the edge containing removed way point
     */
    private void removeWayPoint(Edge edge) {
        GraphEdge graphEdge = edge.getGraphEdge();
        graphEdge.getWaypoints().get(index1).setX(oldPosition1.getX());
        graphEdge.getWaypoints().get(index1).setY(oldPosition1.getY());
        List<Point> newWayPoints = graphEdge.getWaypoints();
        newWayPoints.remove(index1);
        ChangeRelationshipPathAction action = new ChangeRelationshipPathAction(graphEdge, newWayPoints);
        mainFrame.handleActionEvent(action, edge, "way point removed");
    }

    /**
     * <p>
     * Moves a way point to a new position.
     * </p>
     *
     * @param edge
     *            the edge containing moved way point
     * @param position
     *            new position for way point
     */
    private void moveWayPoint(Edge edge, java.awt.Point position) {
        GraphEdge graphEdge = edge.getGraphEdge();
        graphEdge.getWaypoints().get(index1).setX(oldPosition1.getX());
        graphEdge.getWaypoints().get(index1).setY(oldPosition1.getY());
        List<Point> newWayPoints = graphEdge.getWaypoints();
        Point newPosition = new Point();
        newPosition.setX(position.x);
        newPosition.setY(position.y);
        newWayPoints.set(index1, newPosition);
        ChangeRelationshipPathAction action = new ChangeRelationshipPathAction(graphEdge, newWayPoints);
        mainFrame.handleActionEvent(action, edge, "way point moved");
    }
}
