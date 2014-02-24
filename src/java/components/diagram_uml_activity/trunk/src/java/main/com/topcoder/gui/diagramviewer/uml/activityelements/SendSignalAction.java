/*
 * Copyright (C) 2007 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.gui.diagramviewer.uml.activityelements;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.Polygon;
import java.awt.Rectangle;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Map;

import javax.swing.SwingUtilities;

import com.topcoder.diagraminterchange.GraphNode;
import com.topcoder.gui.diagramviewer.elements.SelectionCornerType;
import com.topcoder.uml.model.statemachines.SimpleState;

/**
 * <p>
 * This class is a concrete <code>Node</code>. It takes its information from the SimpleState with a tag definition
 * attached (TagDefinition(&quot;SendSignalAction&quot;).value=&quot;True&quot;) from the UML Model and from the
 * <code>GraphNode</code> associated with it. It extends the <code>BaseNode</code> to share the common
 * initialization and operation, but override the methods to provide its own rendering and structure.
 * </p>
 * <p>
 * This node contains compartments in its <code>GraphNode</code> shape.
 * </p>
 * <p>
 * Thread safety : This class is not thread safe, because the BaseNode class is not thread safe.
 * </p>
 * @author kakarotto, TCSDEVELOPER
 * @version 1.0
 */
public class SendSignalAction extends BaseNode {
    /**
     * <p>
     * Represents the default graph node size. If no compartment is visible, it will be returned by
     * <code>getPreferredGraphNodeSize</code> method.
     * </p>
     */
    private static final Dimension DEFAULT_SIZE = new Dimension(140, 30);

    /**
     * <p>
     * The number of vertices. Initialized to 5, and never changed later.
     * </p>
     */
    private static final int NPOINTS = 5;

    /**
     * <p>
     * Represents the peak distance. Default set to 20.
     * </p>
     */
    private static final int PEAK = 20;

    /**
     * <p>
     * Represents the shape of this node. It is a polygon with five vertices. Initialized and changed in
     * <code>notifyGraphNodeChange</code> method.
     * </p>
     */
    private Polygon shape;

    /**
     * <p>
     * Creates an <code>SendSignalAction</code> instance.
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
    public SendSignalAction(GraphNode graphNode, Map<String, String> properties, Point position, Rectangle bound) {
        super(graphNode, properties, new RectangleConnector(), position, bound, generateSelectionCorners());
        ((RectangleConnector) getConnector()).setParent(this);
        notifyGraphNodeChange("SendSignalAction instance created.");
    }

    /**
     * <p>
     * Generates the selection corners for this node.
     * </p>
     * @return the selection corners for this node
     */
    private static Collection<SelectionCornerType> generateSelectionCorners() {
        Collection<SelectionCornerType> corners = new ArrayList<SelectionCornerType>();
        corners.add(SelectionCornerType.NORTH);
        corners.add(SelectionCornerType.WEST);
        corners.add(SelectionCornerType.SOUTH);
        corners.add(SelectionCornerType.EAST);
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
     * Since the <code>GraphNode</code> shape contains compartments, this method only checks whether the coordinate is
     * in the shape of the <code>GraphNode</code> shape.
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
//        return shape.contains(x, y);
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
     * Rendering process of this node. Simply draw the polygon shape.
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
//        graphics.drawPolygon(shape);
        graphics.setColor(getFillColor());
        graphics.fillPolygon(shape);
        graphics.setColor(getStrokeColor());
        graphics.drawPolygon(shape);

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
        Util.checkActionGraphNode(graphNode, SimpleState.class);
        notifyPropertiesChange();
        Util.rearrangeAction(message, this);
        // Create the new shape
        Point position = getRelativePosition();
        Dimension d = Util.getGraphNodeSize(graphNode);
        int[] xpoints = new int[NPOINTS];
        int[] ypoints = new int[NPOINTS];
        xpoints[0] = xpoints[1] = position.x;
        ypoints[0] = ypoints[4] = position.y;
        ypoints[1] = ypoints[2] = position.y + d.height;
        xpoints[2] = xpoints[4] = position.x + d.width - PEAK;
        xpoints[3] = position.x + d.width;
        ypoints[3] = position.y + (int) Math.round(d.height * 0.5);
        shape = new Polygon(xpoints, ypoints, NPOINTS);
        revalidate();
    }

    /**
     * <p>
     * Gets the preferred graph node size. Please note this is different from JComponent#getPreferredSize(). The
     * returned value indicating the preferred size of core shape of this node. This method is provided for the
     * application to set proper size of graph node.
     * </p>
     * <p>
     * For this node, if no compartment is shown, default size will be preferred. Otherwise a minimum bounding round
     * will be calculated to hold visible compartments, and this round's rectangle bound size will be preferred.
     * </p>
     * @return the preferred size of graph node
     */
    public Dimension getPreferredGraphNodeSize() {
        TextField stereotypeCompartment = getStereotypeCompartment();
        TextField nameCompartment = getNameCompartment();
        if (!stereotypeCompartment.isVisible() && !nameCompartment.isVisible()) {
            return DEFAULT_SIZE;
        }
        Dimension size = new Dimension(DEFAULT_SIZE);
        Dimension d = Util.getPreferredCompartmentsSize(stereotypeCompartment, nameCompartment);
        if (d.width + PEAK > DEFAULT_SIZE.width) {
            size.width = d.width + PEAK;
        }
        if (d.height > DEFAULT_SIZE.height) {
            size.height = d.height;
        }
        return size;
    }

}
