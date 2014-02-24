/*
 * Copyright (C) 2007 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.gui.diagramviewer.uml.auxiliaryelements;

import java.awt.Point;
import java.awt.Polygon;
import java.awt.Shape;

import javax.swing.SwingUtilities;

import com.topcoder.gui.diagramviewer.DiagramView;
import com.topcoder.gui.diagramviewer.edges.Connector;


/**
 * <p>
 * This a connector defined for comment.
 * The <code>getShape()</code> method of the node should return an instance of Polygon.
 * Otherwise, the connection point can be an unexpected value. </p>
 *
 * <p>
 * This class is immutable and thread-safe.
 * </p>
 *
 * @author maone, TCSDEVELOPER
 * @version 1.0
 */
public class CommentConnector implements Connector {
    /**
     * <p>
     * Represents the <code>CommentNode</code> instance containing this connector.
     * </p>
     *
     * <p>
     * Initialized in constructor, never changed later. Can't be <code>null</code>.
     * </p>
     */
    private final CommentNode commentNode;

    /**
     * <p>
     * Constructs a CommentConnector. Set the commentNode.
     * </p>
     *
     * @param commentNode - the node containing this connector.
     *
     * @throws IllegalArgumentException - if any arg is null.
     */
    public CommentConnector(CommentNode commentNode) {
        // Checks whether the commentNode is null,
        // if it is null, a IAE will be thrown.
        AuxiliaryElementsHelper.checkNotNull(commentNode, "commentNode");

        // Assigns value
        this.commentNode = commentNode;
    }

    /**
     * <p>
     * Implements <code>connectToShape</code> method.
     * </p>
     *
     * @return the connecting target.
     *
     * @param wayPoint - the point to connect
     *
     * @throws IllegalArgumentException - if any arg is null.
     */
    public Point getConnectionPoint(Point wayPoint) {
        // Checks whether the wayPoint is null,
        // if it is null, a IAE will be thrown.
        AuxiliaryElementsHelper.checkNotNull(wayPoint, "wayPoint");

        // Gets the shape of the commentNode,
        // if it isn't a polygon, return infinite value.
        Shape shape = this.commentNode.getShape();
        if (!(shape instanceof Polygon)) {
            return new Point(Integer.MAX_VALUE, Integer.MAX_VALUE);
        }

        // Translates the coordinate to the diagram view
        DiagramView diagramView = (DiagramView) this.commentNode.getParent();
        Polygon polygon = new Polygon();
        Polygon shapePolygon = (Polygon) shape;
        for (int i = 0; i < shapePolygon.npoints; i++) {
            Point point =
                SwingUtilities.convertPoint(this.commentNode,
                        shapePolygon.xpoints[i], shapePolygon.ypoints[i], diagramView);
            polygon.addPoint(point.x, point.y);
        }
        /*
         * BugFix: UML-9948
         * Should not be translated.
         */
        // old code
//        polygon.translate(diagramView.getX(), diagramView.getY());

        // determine the connection point on polygon.
        return AuxiliaryElementsHelper.determineConnectionPoint(wayPoint, polygon);
    }
}
