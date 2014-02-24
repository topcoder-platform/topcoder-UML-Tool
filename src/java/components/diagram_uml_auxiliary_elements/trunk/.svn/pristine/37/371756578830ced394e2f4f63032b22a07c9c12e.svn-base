/*
 * Copyright (C) 2007 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.gui.diagramviewer.uml.auxiliaryelements;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.Polygon;
import java.awt.Rectangle;
import java.awt.Shape;

import javax.swing.SwingUtilities;

import com.topcoder.diagraminterchange.GraphNode;
import com.topcoder.diagraminterchange.Uml1SemanticModelBridge;
import com.topcoder.gui.diagramviewer.edges.Connector;
import com.topcoder.gui.diagramviewer.elements.SelectionCorner;
import com.topcoder.uml.model.core.auxiliaryelements.Comment;


/**
 * <p>
 * This node represents a Comment in UML diagram.
 * A comment is displayed as a rectangle with one folded corner.
 * The comment text resides in the rectangle.
 * </p>
 *
 * <p>
 * The major function in this class implementation is to provide a custom look to <code>CommentNode</code>.
 * All other functions are defined in base <code>TextNode</code> class.
 * </p>
 *
 * <p>
 * This class is mutable, and not thread-safe.
 * </p>
 *
 * @author maone, TCSDEVELOPER
 * @version 1.0
 */
public class CommentNode extends TextNode {
    /**
     * <p>
     * Represents the margin size around the text.
     * This value is also used as the size of folded corner.
     * </p>
     */
    private static final int MARGIN = 10;

    /**
     * <p>
     * Constant for vertex number.
     * </p>
     */
    private static final int VERTEX_NUMBER = 5;

    /**
     * <p>
     * The shape of the comment. It should be a polygon.
     * </p>
     *
     * <p>
     * It is initialized in constructor, and can be updated. Never <code>null</code>.
     * </p>
     */
    private Shape shape = null;

    /**
     * <p>
     * Represents the connector used for edge to connect to this <code>CommentNode</code>.
     * </p>
     *
     * <p>
     * It is initialized as a <code>CommentConnector</code> in constructor.
     * And never changed later.
     * It can be accessed by getter.
     * </p>
     */
    private final Connector connector;

    /**
     * <p>
     * Represents the comment instance.
     * It is retrieved from <code>graphNode</code> in constructor.
     * Never changed later, can't <code>null</code>.
     * </p>
     */
    private final Comment comment;

    /**
     * <p>
     * Variable used to draw folded corner.
     * </p>
     */
    private int[][] cornerPoints = new int[3][2];

    /**
     * <p>
     * Constructs a CommentNode. Set the comment, shape, properties, graphNode and the connetcor.
     * </p>
     *
     * @param graphNode - the graphNode corresponding to this Node
     * @param properties - the porperty mappings.
     *
     * @throws IllegalArgumentException - if any arg is null
     * @throws IllegalGraphNodeException - if graphNode isn't a Comment Node.
     */
    public CommentNode(GraphNode graphNode, PropertyMapping properties) {
        // Passes graphNode and properties to super constructor.
        // the super constructor will check whether the properties is null,
        // and if it is null, a IAE will be thrown.
        // the super constructor will configured the 8 corners.
        // The Helper class will check whether the graphNode is null,
        // and if it is null, a IAE will be thrown.
        // The Helper class will also check whether the graphNode is a Comment Node,
        // and if it isn't a Comment Node, a IGE will be thrown.
        // if it is valid, itself will returned.
        super(AuxiliaryElementsHelper.validateGraphNodeForCommentNode(graphNode), properties);

        // Retrieves comment instance
        this.comment =
            (Comment) ((Uml1SemanticModelBridge) getGraphNode().getSemanticModel()).getElement();

        // Constructs this.shape as a Polygon.
        this.shape = getPolygonFromBound();

        // initializes the connector
        this.connector = new CommentConnector(this);
    }

    /**
     * <p>
     * Gets the Comment instance.
     * </p>
     *
     * @return comment instance.
     */
    public Comment getComment() {
        return this.comment;
    }

    /**
     * <p>
     * Computes the preferred size if given text is set.
     * </p>
     *
     * @return the preferred node size for given text.
     *
     * @param text - the text to be measured
     */
    public Dimension getPreferredSize(String text) {
        if (text == null) {
            text = "";
        }

        // measures the Text
        /*
         * BugFix : BUGR - 68
         * Support line wrapping.
         * Solution : Don't resize the node, it can be done manually. 
         */
        // old code
        //Dimension dim = super.measureText(text);
        Dimension dim = new Dimension(5, 5);

        // add the margin
        dim.width += 2 * MARGIN;
        dim.height += 2 * MARGIN;

        return dim;
    }

    /**
     * <p>
     * Recalculates the size of the node when the graphNode or comment is changed.
     * </p>
     *
     * @throws IllegalGraphNodeException - if the contained graphNode is invalid to represent a CommentNode
     */
    public void notifyUpdate() {
        // The Helper class will check whether the graphNode is a Comment Node,
        // and if it isn't a Comment Node, a IGE will be thrown.
        AuxiliaryElementsHelper.validateGraphNodeForCommentNode(this.getGraphNode());

        // calculates the required size.
        Dimension size =
            new Dimension((int) getGraphNode().getSize().getWidth(), (int) getGraphNode().getSize().getHeight());

        Dimension preferredSize = getPreferredSize();
        size.width = Math.max(size.width, preferredSize.width);
        size.height = Math.max(size.height, preferredSize.height);
        /*
         * BugFix : BUGR - 68
         * Support line wrapping.
         * Solution : Don't resize the node, it can be done manually. 
         */
        // old code
        // getGraphNode().getSize().setWidth(size.width);
        // getGraphNode().getSize().setHeight(size.height);

        /*
         * BugFix: UML-9949
         * The size should consider the selection corners.
         */
        int radius = getSelectionCorners().iterator().next().getRadius();
        size.width += radius * 2;
        size.height += radius * 2;

        // Gets the old bounding rectangle of this node
        Rectangle oldBoundary = this.getBounds();

        /*
         * BugFix: UML-9949
         * Set the location.
         */
        Point position = new Point((int) (getGraphNode().getPosition().getX() - radius),
                (int) (getGraphNode().getPosition().getY() - radius));
        this.setLocation(position);

        // Resizes the node
        this.setSize(size);

        // Gets the new bounding rectangle of this node
        Rectangle newBoundary = this.getBounds();

        // Trigger the BoundaryChangeEvent
        this.fireBoundaryChange(
                new BoundaryChangeEvent(
                        this, oldBoundary, newBoundary, "The Boundary of this CommentNode changed."));

        // Sets relative position
        this.setRelativePosition(new Point(SelectionCorner.DEFAULT_RADIUS, SelectionCorner.DEFAULT_RADIUS));
        /*
         * BugFix: UML-9949
         * Set the selection bound.
         */
        this.setSelectionBound(new Rectangle(getRelativePosition(), new Dimension(size.width - 2*radius, size.height - 2* radius)));

        // Reconstructs this.shape as a Polygon.
        this.shape = getPolygonFromBound();
    }

    /**
     * <p>
     * Gets the text to be displayed.
     * </p>
     *
     * @return the comment text.
     */
    public String getText() {
        return this.comment.getBody();
    }

    /**
     * <p>
     * Determines whether given point is contained in the shape.
     * </p>
     *
     * @return whether the point is contained in shape.
     *
     * @param x - the x coordinate value
     * @param y - the y coordinate value
     */
    public boolean contains(int x, int y) {
        /*
         * BugFix: BUGID UML-9713
         * The selection corners around this node should be checked to determine whether or not the
         * point is contained.
         */
        // old code
//        return shape.contains(new Point(x, y));
        if (shape.contains(new Point(x, y))) {
            return true;
        }
        // check the child components
        for (int i = 0; i < getComponentCount(); i++) {
            Component c = getComponent(i);
            Point pt = SwingUtilities.convertPoint(this, x, y, c);
            if (c.contains(pt.x, pt.y)) {
                return true;
            }
        }
        return false;
    }

    /**
     * <p>
     * Gets the shape of the comment.
     * It is expected to be a polygon.
     * </p>
     *
     * @return this.shape.
     */
    public Shape getShape() {
        return this.shape;
    }

    /**
     * <p>
     * Gets the connector field.
     * See field doc for explanation.
     * </p>
     *
     * @return the connector.
     */
    public Connector getConnector() {
        return this.connector;
    }

    /**
     * <p>
     * Paints this component.
     * </p>
     *
     * @param g - the graphics to paint on. (null will be silently ignored)
     */
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        // gets the corresponding Graphics2D
        Graphics2D g2d = (Graphics2D) g;

        // back up the old color and restore it to the Graphics after the painting is finished
        // this is required by swing component
        Color oldColor = g2d.getColor();

        // fills shape
        Color fillColor = super.getFillColor();
        if (fillColor == null) {
            g2d.setColor(Color.white);
        } else {
            g2d.setColor(fillColor);
        }
        g2d.fill(this.shape);

        // draws shape with stroke color (if null, use black)
        Color strokeColor = super.getStrokeColor();
        if (strokeColor == null) {
            g2d.setColor(Color.black);
        } else {
            g2d.setColor(strokeColor);
        }
        g2d.draw(this.shape);

        // draws the folded corner.
        g2d.drawLine(cornerPoints[0][0], cornerPoints[0][1], cornerPoints[2][0], cornerPoints[2][1]);
        g2d.drawLine(cornerPoints[1][0], cornerPoints[1][1], cornerPoints[2][0], cornerPoints[2][1]);

        // paints Text
        g.setColor(this.getFontColor());
        /*
         * BugFix: UML-9950
         * Paint the comment text.
         */
        // old code
//        DiagramView diagramView = (DiagramView) this.getParent();
//        Point offset = new Point(this.getX() + MARGIN, this.getY() + MARGIN);
//        offset = SwingUtilities.convertPoint(this, offset.x, offset.y, diagramView);

        /*
         * BugFix : BUGR - 68
         * Support line wrapping.
         * Solution : Supply maximum width and height to limit the wrapping. 
         */
        // old code
        //super.paintText(g, new Point(MARGIN, MARGIN));
        super.paintTextWrap(g, new Point(MARGIN, MARGIN), this.getSize().width,
                this.getSize().height);

        // restore the oldColor
        g2d.setColor(oldColor);
    }

    /**
     * <p>
     * <strong>Helper function:</strong>
     * This function gets a polygon from a boundary.
     * </p>
     *
     * @return the corresponding polygon
     */
    private Polygon getPolygonFromBound() {
        // A rectangle with a folded corner will have 5 vertexes.
        int npoints = VERTEX_NUMBER;
        int[] xpoints = new int[5];
        int[] ypoints = new int[5];

        // Gets the position and the size.
        /*
         * BugFix: UML-9951
         * The polygon shape should have coordinates relative to this node
         */
        // old code
//        com.topcoder.diagraminterchange.Point position = this.getGraphNode().getPosition();
//        com.topcoder.diagraminterchange.Dimension size = this.getGraphNode().getSize();
//
//        // Gets the 5 vertextes in clockwise, from the left-up vertex.
//        xpoints[0] = (int) position.getX();
//        ypoints[0] = (int) position.getY();
//        xpoints[1] = (int) position.getX() + (int) size.getWidth() - MARGIN;
//        ypoints[1] = (int) position.getY();
//        xpoints[2] = (int) position.getX() + (int) size.getWidth();
//        ypoints[2] = (int) position.getY() + MARGIN;
//        xpoints[3] = (int) position.getX() + (int) size.getWidth();
//        ypoints[3] = (int) position.getY() + (int) size.getHeight();
//        xpoints[4] = (int) position.getX();
//        ypoints[4] = (int) position.getY() + (int) size.getHeight();
        Point relative = getRelativePosition();
        Dimension size =
            new Dimension((int) getGraphNode().getSize().getWidth(), (int) getGraphNode().getSize().getHeight());
        // Gets the 5 vertextes in clockwise, from the left-up vertex.
        xpoints[0] = relative.x;
        ypoints[0] = relative.y;
        xpoints[1] = relative.x + size.width - MARGIN;
        ypoints[1] = relative.y;
        xpoints[2] = relative.x + size.width;
        ypoints[2] = relative.y + MARGIN;
        xpoints[3] = relative.x + size.width;
        ypoints[3] = relative.y + size.height;
        xpoints[4] = relative.x;
        ypoints[4] = relative.y + size.height;

        // Updates the cornerPoints.
        cornerPoints[0][0] = xpoints[1];
        cornerPoints[0][1] = ypoints[1];
        cornerPoints[1][0] = xpoints[2];
        cornerPoints[1][1] = ypoints[2];
        cornerPoints[2][0] = xpoints[1];
        cornerPoints[2][1] = ypoints[2];

        return new Polygon(xpoints, ypoints, npoints);
    }
}
