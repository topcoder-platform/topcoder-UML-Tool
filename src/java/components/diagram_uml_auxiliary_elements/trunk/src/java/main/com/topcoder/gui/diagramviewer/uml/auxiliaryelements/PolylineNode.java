/*
 * Copyright (C) 2007 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.gui.diagramviewer.uml.auxiliaryelements;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Polygon;
import java.awt.Rectangle;
import java.awt.geom.Line2D;
import java.awt.geom.Point2D;
import java.util.ArrayList;
import java.util.List;

import com.topcoder.diagraminterchange.DiagramElement;
import com.topcoder.diagraminterchange.Dimension;
import com.topcoder.diagraminterchange.GraphNode;
import com.topcoder.diagraminterchange.Polyline;


/**
 * <p>
 * This node represents a polyline in diagram interchange.
 * It extends from base node to use the properties defined in it.
 * </p>
 *
 * <p>
 * This class is immutable but its base class is not thread-safe.
 * </p>
 *
 * @author maone, TCSDEVELOPER
 * @version 1.0
 */
public class PolylineNode extends BaseNode {
    /**
     * <p>
     * Represents the polyline instance associated with this Node.
     * This Node will display the polyline represented by this instance.
     * </p>
     *
     * <p>
     * Initialized in constructor, and never changed later.
     * Can be accessed by getter.
     * </p>
     */
    private final Polyline polyline;

    /**
     * <p>
     * Constructs a PolylineNode.
     * Passes the dummy <code>new GraphNode()</code> to super constructor, and store polyline.
     * </p>
     *
     * @param polyline - the polyline instance.
     * @param properties - the porperty mappings.
     *
     * @throws IllegalArgumentException - if given arg is null
     */
    public PolylineNode(Polyline polyline, PropertyMapping properties) {
        // Passes a dummy new GraphNode() and properties to super constructor.
        // the super constructor will check whether the properties is null,
        // and if it is null, a IAE will be thrown.
        super(new GraphNode(), properties);

        // Checks whether the polyline is null,
        // if it is null, a IAE will be thrown.
        AuxiliaryElementsHelper.checkNotNull(polyline, "polyline");

        // Assigns value.
        this.polyline = polyline;

        this.notifyPropertiesChange();
    }

    /**
     * <p>
     * Gets the polyline field. See field doc for explanation.
     * </p>
     *
     * @return the polyLine value
     */
    public Polyline getPolyline() {
        return this.polyline;
    }

    /**
     * <p>
     * Determines whether the point is contained.
     * Determines whether the point is in the bounding rect.
     * </p>
     *
     * @return whether the point is contained.
     *
     * @param x - the x coordinate
     * @param y - the y coordinate
     */
    public boolean contains(int x, int y) {
        /*
         * BugFix: UML-9954
         */
        // old code
//        return this.getBounds().contains(new Point(x, y));
        return super.contains(x, y);
    }

    /**
     * <p>
     * Paints the polyline.
     * </p>
     *
     * <p>
     * NOTE, <code>null</code> param will be ignored to follow SWING convention.
     * </p>
     *
     * @param g - the graphics to paint on.(null will be silently ignored)
     */
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        // gets the corresponding Graphics2D
        Graphics2D g2d = (Graphics2D) g;

        // back up the old color and restore it to the Graphics after the painting is finished
        // this is required by swing component
        Color oldColor = g2d.getColor();

        // gets the wayPoints.
        /*
         * BugFix: UML-9955
         * The way points' coordinates is relative to parent container, they should be converted
         * to this node before painting.
         */
        // old code
//        List<com.topcoder.diagraminterchange.Point> wayPoints = this.polyline.getWaypoints();
        List<com.topcoder.diagraminterchange.Point> wayPoints = new ArrayList<com.topcoder.diagraminterchange.Point>();
        for (com.topcoder.diagraminterchange.Point point : this.polyline.getWaypoints()) {
            com.topcoder.diagraminterchange.Point newPoint = new com.topcoder.diagraminterchange.Point();
            newPoint.setX(point.getX() - this.getX());
            newPoint.setY(point.getY() - this.getY());
            wayPoints.add(newPoint);
        }

        // the start and end point of a segment.
        com.topcoder.diagraminterchange.Point start;
        com.topcoder.diagraminterchange.Point end;

        /*
         * BugFix: UML-9955
         * Fill first, then draw.
         */
        // if the starting point and ending point is same.
        start = wayPoints.get(0);
        end = wayPoints.get(wayPoints.size() - 1);
        if (polyline.isClosed()) {
            // constructs a corresponding Polygon.
            int[] xpoints = new int[wayPoints.size()];
            int[] ypoints = new int[wayPoints.size()];
            for (int i = 0; i < wayPoints.size(); i++) {
                xpoints[i] = (int) wayPoints.get(i).getX();
                ypoints[i] = (int) wayPoints.get(i).getY();
            }
            Polygon polygon = new Polygon(xpoints, ypoints, wayPoints.size());

            // fills the polygon with super.getFillColor().
            Color fillColor = super.getFillColor();
            if (fillColor != null) {
                g2d.setColor(fillColor);
            } else {
                g2d.setColor(Color.white);
            }
            g2d.fillPolygon(polygon);
        }

        // gets first point.
        start = wayPoints.get(0);

        // paints the segment one by one.
        for (int i = 1; i < wayPoints.size(); i++) {
            end = wayPoints.get(i);
            Color strokeColor = super.getStrokeColor();
            if (strokeColor != null) {
                g2d.setColor(strokeColor);
            } else {
                g2d.setColor(Color.black);
            }
            g2d.drawLine((int) start.getX(), (int) start.getY(), (int) end.getX(), (int) end.getY());
            start = end;
        }

        // restores the oldColor
        g2d.setColor(oldColor);
    }

    /**
     * <p>
     * Gets the polyline storing properties.
     * </p>
     *
     * @return the polyline storing properties.
     */
    protected DiagramElement getPropertiesDiagramElement() {
        return polyline;
    }

    /**
     * <p>
     * Notifies the polyline is updated.
     * Should recalculate the size of the node.
     * </p>
     */
    public void notifyUpdate() {
        // gets the bounding rect of all the points on polyline.
        // gets the wayPoints.
        List<com.topcoder.diagraminterchange.Point> wayPoints = this.polyline.getWaypoints();

        // the start and end point of a segment.
        com.topcoder.diagraminterchange.Point start;
        com.topcoder.diagraminterchange.Point end;

        // gets first point.
        start = wayPoints.get(0);

        // the bounding rectangle of this node
        /*
         * BugFix: UML-9956
         * Initialized as first line segment's bounds
         */
        // old code
//        Rectangle bound = this.getBounds();
        end = wayPoints.get(1);
        Line2D.Double firstLine =
            new Line2D.Double(
                    new Point2D.Double(start.getX(), start.getY()), new Point2D.Double(end.getX(), end.getY()));
        Rectangle bound = firstLine.getBounds();
        start = end;

        // gets the bounding rect of the segment one by one.
        // and then union it to the bounding rect of this node.
        /*
         * BugFix: UML-9956
         * Combined with other line segments' bounds
         */
        // old code
//        for (int i = 1; i < wayPoints.size(); i++) {
        for (int i = 2; i < wayPoints.size(); i++) {
            end = wayPoints.get(i);

            // gets the line segment defined by the start and end point
            Line2D.Double line =
                new Line2D.Double(
                        new Point2D.Double(start.getX(), start.getY()), new Point2D.Double(end.getX(), end.getY()));

            // gets the bounding rectangle of the line, and then union it to the bounding rectangle of this node.
            bound = bound.union(line.getBounds());

            start = end;
        }

        /*
         * BugFix: UML-9956
         * Set the location and size according to bound and selection corners
         */
        // old code
//        // extends the bounding rectangle by half selection corner in four directions.
//        bound.setLocation(bound.x + SelectionCorner.DEFAULT_RADIUS, bound.y + SelectionCorner.DEFAULT_RADIUS);
//        bound.setSize(bound.width + SelectionCorner.DEFAULT_RADIUS, bound.height + SelectionCorner.DEFAULT_RADIUS);
        int radius = getSelectionCorners().iterator().next().getRadius();
        this.setLocation(bound.x - radius, bound.y - radius);
        this.setSize(bound.width + radius*2, bound.height + radius*2);

        /*
         * BugFix: UML-9956
         * Update graph node
         */
        com.topcoder.diagraminterchange.Point position = new com.topcoder.diagraminterchange.Point();
        position.setX(bound.x);
        position.setY(bound.y);
        Dimension size = new Dimension();
        size.setWidth(bound.width);
        size.setHeight(bound.height);
        this.getGraphNode().setPosition(position);
        this.getGraphNode().setSize(size);

        /*
         * BugFix: UML-9956
         * Set selection bound
         */
        // old code
//        // updates bounding rectangle of this node.
//        this.setBounds(bound);
        bound.x = radius;
        bound.y = radius;
        this.setSelectionBound(bound);
    }
}
