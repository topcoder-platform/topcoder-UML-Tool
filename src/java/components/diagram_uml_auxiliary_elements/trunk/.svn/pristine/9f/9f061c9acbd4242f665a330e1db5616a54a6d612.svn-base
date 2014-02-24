/*
 * Copyright (C) 2007 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.gui.diagramviewer.uml.auxiliaryelements;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.Rectangle;

import com.topcoder.diagraminterchange.GraphNode;
import com.topcoder.diagraminterchange.TextElement;
import com.topcoder.gui.diagramviewer.elements.SelectionCorner;


/**
 * <p>
 * This node represents free text in UML diagram.
 * Free text is displayed in a rectangle with no border.
 * The free text resides in the rectangle.
 * </p>
 *
 * <p>
 * The major function in this class implementation is to provide a custom look to <code>FreeTextNode</code>.
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
public class FreeTextNode extends TextNode {
    /**
     * <p>
     * The bound of the free text.
     * </p>
     *
     * <p>
     * It is initialized in constructor, and can be updated. Never <code>null</code>.
     * </p>
     */
    private Rectangle boundary = null;

    /**
     * <p>
     * Represents the <code>TextElement</code> instance.
     * It is retrieved from <code>graphNode</code> in constructor.
     * Never changed later, can't <code>null</code>.
     * </p>
     */
    private final TextElement textElement;

    /**
     * <p>
     * Constructs a FreeTextNode. Set the textElement, boundary, graphNode and the properties.
     * </p>
     *
     * @param graphNode - the graphNode corresponding to this Node
     * @param properties - the porperty mappings.
     *
     * @throws IllegalArgumentException - if any arg is null
     * @throws IllegalGraphNodeException - if given graphNode is illegal for FreeText
     */
    public FreeTextNode(GraphNode graphNode, PropertyMapping properties) {
        // Passes graphNode and properties to super constructor.
        // the super constructor will check whether the properties is null,
        // and if it is null, a IAE will be thrown.
        // the super constructor will configured the 8 corners.
        // The Helper class will check whether the graphNode is null,
        // and if it is null, a IAE will be thrown.
        // The Helper class will also check whether the graphNode is a FreeText Node,
        // and if it isn't a Comment Node, a IGE will be thrown.
        // if it is valid, itself will returned.
        super(AuxiliaryElementsHelper.validateGraphNodeForFreeTextNode(graphNode), properties);

        // Retrieves textElement instance
        this.textElement = (TextElement) getGraphNode().getContaineds().get(0);

        // initializes the boundary
        this.boundary =
            new Rectangle((int) graphNode.getPosition().getX(), (int) graphNode.getPosition().getY(),
                (int) graphNode.getSize().getWidth(), (int) graphNode.getSize().getHeight());
    }

    /**
     * <p>
     * Gets the textElement instance.
     * </p>
     *
     * @return textElement instance.
     */
    public TextElement getTextElement() {
        return this.textElement;
    }

    /**
     * <p>
     * Computes the preferred size if given text is set.
     * </p>
     *
     * @return the preferred node size for given text.
     *
     * @param text - the text to measure
     *
     * @throws IllegalArgumentException - if text is null, (empty is allowed here)
     */
    public Dimension getPreferredSize(String text) {
        // Checks whether the text is null, if it is null, a IAE will be thrown.
        AuxiliaryElementsHelper.checkNotNull(text, "text");

        // measures the text
        Dimension dim = super.measureText(text);

        // Since there are 8 conners, add the biggest radius to the size is proper.
        int radius = 0;
        for (SelectionCorner corner : this.getSelectionCorners()) {
            if (radius < corner.getRadius()) {
                radius = corner.getRadius();
            }
        }

        // add margin
        dim.width += 2 * radius;
        dim.height += 2 * radius;

        return dim;
    }

    /**
     * <p>
     * Recalculates the size of the node when the graphNode or comment is changed.
     * </p>
     *
     * @throws IllegalGraphNodeException -
     *         if the given graphNode is illegal, e.g. the graphNode is actually for other diagram elements.
     */
    public void notifyUpdate() {
        // The Helper class will check whether the graphNode is a FreeText Node,
        // and if it isn't a Comment Node, a IGE will be thrown.
        AuxiliaryElementsHelper.validateGraphNodeForFreeTextNode(this.getGraphNode());

        // calculates the required size.
        Dimension size =
            new Dimension((int) getGraphNode().getSize().getWidth(), (int) getGraphNode().getSize().getHeight());

        Dimension preferredSize = getPreferredSize();
        size.width = Math.max(size.width, preferredSize.width);
        size.height = Math.max(size.height, preferredSize.height);
        getGraphNode().getSize().setWidth(size.width);
        getGraphNode().getSize().setHeight(size.height);

        /*
         * BugFix: UML-9952
         * The size should consider the selection corners.
         */
        int radius = getSelectionCorners().iterator().next().getRadius();
        size.width += radius * 2;
        size.height += radius * 2;

        // Gets the old bounding rectangle of this node
        Rectangle oldBoundary = this.getBounds();

        /*
         * BugFix: UML-9952
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
                        this, oldBoundary, newBoundary, "The Boundary of this FreeTextNode changed."));

        // Sets relative position
        this.setRelativePosition(new Point(SelectionCorner.DEFAULT_RADIUS, SelectionCorner.DEFAULT_RADIUS));
        /*
         * BugFix: UML-9952
         * Set the selection bound.
         */
        this.setSelectionBound(new Rectangle(getRelativePosition(), new Dimension(size.width - 2*radius, size.height - 2* radius)));

        // Reconstructs this.shape as a Recatangle.
        this.boundary = newBoundary;
    }

    /**
     * <p>
     * Gets the text to be displayed.
     * </p>
     *
     * @return the free text
     */
    public String getText() {
        return this.textElement.getText();
    }

    /**
     * <p>
     * Determines whether given point is contained in the shape.
     * </p>
     *
     * @return whether the point is contained in shape.
     *
     * @param x - the x coordinate value
     * @param y - the y coordinate vlaue
     */
    public boolean contains(int x, int y) {
        return super.contains(x, y);
    }

    /**
     * <p>
     * Paints this component.
     * </p>
     *
     * <p>
     * NOTE, <code>null</code> will be ignored by SWING convention.
     * </p>
     *
     * @param g - the graphics to paint on. (null will be ignored)
     */
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        // gets the corresponding Graphics2D
        Graphics2D g2d = (Graphics2D) g;

        /*
         * BugFix: UML-9953
         * Paint the node according to its selection bound.
         */
        // old code
//        // gets the position and size and translates the coordinate to the diagram view
//        DiagramView diagramView = (DiagramView) this.getParent();
//        com.topcoder.diagraminterchange.Point graphNodePosition = this.getGraphNode().getPosition();
//        com.topcoder.diagraminterchange.Dimension size = this.getGraphNode().getSize();
//        Point position = new Point((int) graphNodePosition.getX(), (int) graphNodePosition.getY());
//        position = SwingUtilities.convertPoint(this, position.x, position.y, diagramView);

        // back up the old color and restore it to the Graphics after the painting is finished
        // this is required by swing component
        Color oldColor = g2d.getColor();

        /*
         * BugFix: UML-9953
         * Paint the node according to its selection bound.
         */
        // old code
//        // fills bound
//        Color fillColor = super.getFillColor();
//        if (fillColor != null) {
//            g2d.setColor(fillColor);
//            g2d.fillRect(position.x, position.y, (int) size.getWidth(), (int) size.getHeight());
//        }
//
//        // draws bound
//        Color strokeColor = super.getStrokeColor();
//        if (strokeColor != null) {
//            g2d.setColor(strokeColor);
//            g2d.drawRect(position.x, position.y, (int) size.getWidth(), (int) size.getHeight());
//        } else {
//            return;
//        }
//
//        // calculates the offset of text, it should be (r/2,r/2),
//        // while r is the radius of the NORTHWEST SelectionCorner.
//        int radius = 0;
//        for (SelectionCorner corner : this.getSelectionCorners()) {
//            if (corner.equals(SelectionCornerType.NORTHWEST)) {
//                radius = corner.getRadius();
//                break;
//            }
//        }
        int radius = getSelectionCorners().iterator().next().getRadius();

        // fills bound
        Color fillColor = super.getFillColor();
        if (fillColor != null) {
            g2d.setColor(fillColor);
            g2d.fillRect(radius, radius, getSelectionBound().width, getSelectionBound().height);
        }

        // draws bound
        Color strokeColor = super.getStrokeColor();
        if (strokeColor != null) {
            g2d.setColor(strokeColor);
            g2d.drawRect(radius, radius, getSelectionBound().width, getSelectionBound().height);
        } else {
            return;
        }

        // paints Text
        g.setColor(this.getFontColor());
        /*
         * BugFix: UML-9953
         * Paint the node according to its selection bound.
         */
        // old code
//        Point offset = new Point(this.boundary.x + radius, this.boundary.y + radius);
//        offset = SwingUtilities.convertPoint(this, offset.x, offset.y, diagramView);
//        super.paintText(g, offset);
        super.paintText(g, new Point(radius, radius));

        // restores the oldColor
        g2d.setColor(oldColor);
    }
}
