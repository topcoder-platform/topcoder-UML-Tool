/*
 * Copyright (C) 2007 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.umltool.deploy.actions.undoable;

import java.awt.Component;

import com.topcoder.diagraminterchange.Diagram;
import com.topcoder.diagraminterchange.GraphEdge;
import com.topcoder.diagraminterchange.GraphNode;
import com.topcoder.diagraminterchange.Point;
import com.topcoder.gui.diagramviewer.DiagramView;
import com.topcoder.gui.diagramviewer.edges.Edge;
import com.topcoder.gui.diagramviewer.elements.Node;
import com.topcoder.gui.diagramviewer.uml.auxiliaryelements.PolylineNode;
import com.topcoder.uml.actions.general.UndoableAbstractAction;
import com.topcoder.umltool.deploy.DeployHelper;

/**
 * <p>
 * This action doesn't actually move the diagram, it move the contained elements instead.
 * </p>
 * @author ly, FireIce, ylouis
 * @version 1.0
 */
public class MoveDiagramAction extends UndoableAbstractAction {

    /**
     * <p>
     * Represents the presentation name.
     * </p>
     */
    private static final String PRESENTATION = "Diagram moved";

    /**
     * <p>
     * Represents the diagram view where this edge should be added.
     * </p>
     */
    private DiagramView diagramView;

    /**
     * <p>
     * Represents the offset in x direction.
     * </p>
     */
    private int xOff;

    /**
     * <p>
     * Represents the offset in y direction.
     * </p>
     */
    private int yOff;

    /**
     * <p>
     * Creates an instance of <code>MoveDiagramAction</code>.
     * </p>
     * @param view
     *            diagram view
     * @param xOff
     *            the offset in x direction
     * @param yOff
     *            the offset in y direction
     */
    public MoveDiagramAction(DiagramView view, int xOff, int yOff) {
        super(PRESENTATION);
        this.diagramView = view;
        this.xOff = xOff;
        this.yOff = yOff;
    }

    /**
     * <p>
     * The method actually undo the edit that was made. If any exception prevents redo/undo methods from completing
     * successfully, it should be log with logError.
     * </p>
     */
    public void undoAction() {
        move(xOff, yOff);
    }

    /**
     * <p>
     * The method actually redo the edit. If any exception prevents redo/undo methods from completing successfully, it
     * should be log with logError.
     * </p>
     */
    public void redoAction() {
        move(-xOff, -yOff);
    }

    /**
     * <p>
     * The method actually execute this auction.
     * </p>
     */
    public void executeAction() {
        move(-xOff, -yOff);
    }

    /**
     * <p>
     * Moves the contained nodes and edges.
     * </p>
     * @param x
     *            offset in x direction
     * @param y
     *            offset in y direction
     */
    private void move(int x, int y) {
        for (Component component : diagramView.getComponents()) {
            if (component instanceof PolylineNode) {
                PolylineNode polylineNode = (PolylineNode) component;
                for (Point wayPoint : polylineNode.getPolyline().getWaypoints()) {
                    wayPoint.setX(wayPoint.getX() + x);
                    wayPoint.setY(wayPoint.getY() + y);
                }
                polylineNode.notifyUpdate();
                polylineNode.repaint();
            } else if (component instanceof Node) {
                Node node = (Node) component;
                GraphNode graphNode = node.getGraphNode();
                if (graphNode.getContainer() instanceof Diagram) {
                    Point position = graphNode.getPosition();
                    position.setX(position.getX() + x);
                    position.setY(position.getY() + y);
                }
                node.setLocation(node.getX() + x, node.getY() + y);
            } else if (component instanceof Edge) {
                Edge edge = (Edge) component;
                GraphEdge graphEdge = edge.getGraphEdge();
                for (Point wayPoint : graphEdge.getWaypoints()) {
                    int index = graphEdge.getWaypoints().indexOf(wayPoint);
                    java.awt.Point oldPoint = new java.awt.Point();
                    oldPoint.x = (int) (wayPoint.getX());
                    oldPoint.y = (int) (wayPoint.getY());
                    wayPoint.setX(wayPoint.getX() + x);
                    wayPoint.setY(wayPoint.getY() + y);
                    edge.notifyChangeWayPoint(index, oldPoint);
                }
                DeployHelper.edgeNotifyChange(edge);
                edge.notifyUnselected();
            }
        }
    }
}
