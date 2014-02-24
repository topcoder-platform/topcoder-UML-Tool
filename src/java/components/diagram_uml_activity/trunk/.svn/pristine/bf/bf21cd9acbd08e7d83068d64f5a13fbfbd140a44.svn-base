/*
 * Copyright (C) 2007 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.gui.diagramviewer.uml.activityelements;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.geom.Ellipse2D;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Map;

import javax.swing.SwingUtilities;

import com.topcoder.diagraminterchange.GraphNode;
import com.topcoder.gui.diagramviewer.elements.SelectionCornerType;
import com.topcoder.uml.model.statemachines.FinalState;

/**
 * <p>
 * This class is a concrete <code>Node</code>. It takes its information from the FinalState with a tag definition
 * attached (TagDefinition(&quot;FinalNodeType&quot;).value=&quot;FlowFinalNode&quot;) from the UML Model and from the
 * <code>GraphNode</code> associated with it. It extends the <code>BaseNode</code> to share the common
 * initialization and operation, but override the methods to provide its own rendering and structure.
 * </p>
 * <p>
 * This node doesn't contain compartments in its <code>GraphNode</code> shape.
 * </p>
 * <p>
 * Thread safety : This class is not thread safe, because the BaseNode class is not thread safe.
 * </p>
 * @author kakarotto, TCSDEVELOPER
 * @version 1.0
 */
public class FlowFinalNode extends BaseNode {
    /**
     * <p>
     * Represents the default graph node size. It will be returned by <code>getPreferredGraphNodeSize</code> method.
     * </p>
     */
    private static final Dimension DEFAULT_SIZE = new Dimension(20, 20);

    /**
     * <p>
     * Represents the outer shape of this node. It is a circle. Initialized and changed in
     * <code>notifyGraphNodeChange</code> method.
     * </p>
     */
    private Ellipse2D shape;

    /**
     * <p>
     * Creates a <code>FlowFinalNode</code> instance.
     * </p>
     * @param graphNode
     *            the graphNode representing this node
     * @param properties
     *            the properties name mapping
     * @param position
     *            the relative position of visual node
     * @param bound
     *            the selection bound of corners
     * @throws IllegalArgumentException
     *             if given graphNode, properties, position, or bound, or properties contains null/empty element
     * @throws IllegalGraphElementException
     *             if the structure of graphNode is invalid
     */
    public FlowFinalNode(GraphNode graphNode, Map<String, String> properties, Point position, Rectangle bound) {
        super(graphNode, properties, new EllipseConnector(), position, bound, generateSelectionCorners());
        ((EllipseConnector) getConnector()).setParent(this);
        notifyGraphNodeChange("FlowFinalNode instance created.");
    }

    /**
     * <p>
     * Generates the selection corners for this node.
     * </p>
     * @return the selection corners for this node
     */
    private static Collection<SelectionCornerType> generateSelectionCorners() {
        Collection<SelectionCornerType> corners = new ArrayList<SelectionCornerType>();
        corners.add(SelectionCornerType.NORTHWEST);
        corners.add(SelectionCornerType.SOUTHWEST);
        corners.add(SelectionCornerType.SOUTHEAST);
        corners.add(SelectionCornerType.NORTHEAST);
        return corners;
    }

    /**
     * <p>
     * Determines whether given coordinate is in the shape of this component for the sake of mouse processing.
     * </p>
     * <p>
     * Since the <code>GraphNode</code> shape doesn't contain compartments, this method will check whether the
     * coordinate is in the shape of compartments besides checking the <code>GraphNode</code> shape.
     * </p>
     * @param x
     *            the x coordinate of the point
     * @param y
     *            the y coordinate of the point
     * @return true if this component logically contains (x,y)
     */
    public boolean contains(int x, int y) {
        if (!super.contains(x, y))
            return false;
        /*
         * BugFix: BUGID UML-7582
         * Description:
         * For all elements, the contains method needs to check whether a given point is contained in the child
         * component.
         * Solution:
         * Add code to check the child components to determine whether the point is contained.
         */
        // old code
//        if (shape.contains(x, y))
//            return true;
//        return Util.containedByCompartments(this, x, y);
        if (shape.contains(x, y)) {
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
     * Rendering process of this node. Draw an outer circle, then draw an inner cross.
     * </p>
     * <p>
     * Since compartments are added as child in super class, they will be drawn automatically.
     * </p>
     * @param graphics
     *            the graphics context in which to paint
     */
    protected void paintComponent(Graphics graphics) {
        Color oldColor = graphics.getColor();
        /*
         * BugFix: BUGID UML-7581
         * Description:
         * All node types need to ensure they use the stroke and fill colors correctly.
         * Solution:
         * Add code to use both stroke color and fill color to draw.
         */
        // old code
//        graphics.setColor(getStrokeColor());
//        graphics.drawOval((int) shape.getX(), (int) shape.getY(), (int) shape.getWidth(), (int) shape.getHeight());
        graphics.setColor(getFillColor());
        graphics.fillOval((int) shape.getX(), (int) shape.getY(), (int) shape.getWidth(), (int) shape.getHeight());
        graphics.setColor(getStrokeColor());
        graphics.drawOval((int) shape.getX(), (int) shape.getY(), (int) shape.getWidth() - 1, (int) shape.getHeight() - 1);

        // Draw inner cross
        graphics.drawLine((int) Math.round(shape.getCenterX() - Math.sqrt(2) / 2 * shape.getWidth() / 2), (int) Math
                .round(shape.getCenterY() - Math.sqrt(2) / 2 * shape.getHeight() / 2), (int) Math.round(shape
                .getCenterX()
                + Math.sqrt(2) / 2 * shape.getWidth() / 2), (int) Math.round(shape.getCenterY() + Math.sqrt(2) / 2
                * shape.getHeight() / 2));
        graphics.drawLine((int) Math.round(shape.getCenterX() - Math.sqrt(2) / 2 * shape.getWidth() / 2), (int) Math
                .round(shape.getCenterY() + Math.sqrt(2) / 2 * shape.getHeight() / 2), (int) Math.round(shape
                .getCenterX()
                + Math.sqrt(2) / 2 * shape.getWidth() / 2), (int) Math.round(shape.getCenterY() - Math.sqrt(2) / 2
                * shape.getHeight() / 2));
        graphics.setColor(oldColor);
    }

    /**
     * <p>
     * Reloads diagram interchange information from contained <code>GraphNode</code>.
     * </p>
     * <p>
     * This method will resize and relocate this node and contained compartments. Boundary changed event would be
     * triggered with given message if necessary.
     * </p>
     * @param message
     *            telling how graphNode is changed, could be null
     * @throws IllegalGraphElementException
     *             if the structure of <code>GraphNode</code> is invalid
     */
    public void notifyGraphNodeChange(String message) {
        GraphNode graphNode = getGraphNode();
        Util.checkNodeGraphNode(graphNode, FinalState.class);
        notifyPropertiesChange();
        Util.rearrangeNode(message, this);
        // Create the new shape
        Point position = getRelativePosition();
        Dimension d = Util.getGraphNodeSize(graphNode);
        shape = new Ellipse2D.Double(position.x, position.y, d.width, d.height);
        revalidate();
    }

    /**
     * <p>
     * Gets the preferred graph node size. Please note this is different from JComponent#getPreferredSize(). The
     * returned value indicating the preferred size of core shape of this node. This method is provided for the
     * application to set proper size of graph node.
     * </p>
     * <p>
     * For this node, because compartments are not contained in the shape of <code>GraphNode</code>, this method
     * simply return the predefined default shape size.
     * </p>
     * @return the preferred size of graph node
     */
    public Dimension getPreferredGraphNodeSize() {
        return DEFAULT_SIZE;
    }
}
