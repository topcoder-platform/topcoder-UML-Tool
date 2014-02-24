/*
 * Copyright (C) 2007 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.gui.diagramviewer.uml.usecaseelements;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.Rectangle;
import java.util.Map;

import javax.swing.SwingUtilities;

import com.topcoder.diagraminterchange.GraphNode;
import com.topcoder.gui.diagramviewer.elements.SelectionCorner;

/**
 * <p>
 * This class represents an Actor node is UML diagram. It is an extension of BaseNode, which defines the most feature
 * for a node. This class only provides some specific methods to support the unique shape of actor, and also to support
 * the unique structure of actor GraphNode.
 * </p>
 * <p>
 * The structure of the GraphNode that corresponds to an Actor is as follows:
 * </p>
 * <p>
 * Uml1SemanticModelBridge.element = UML:Actor
 *   SimpleSemanticModelElement.typeInfo = "StereotypeCompartment"
 *   SimpleSemanticModelElement.typeInfo = "Name"
 *   SimpleSemanticModelElement.typeInfo = "NamespaceCompartment"
 * </p>
 * <p>
 * <b>Thread Safety</b>: This class is not thread safe, because the BaseNode class is not thread safe.
 * </p>
 *
 * @author maone, TCSDEVELOPER
 * @version 1.0
 */
public class ActorNode extends BaseNode {
    /**
     * <p>
     * Represents the number of compartments should be contained in the graphNode.
     * </p>
     */
    private static final int NUMBER_OF_COMPARTMENTS = 3;

    /*
     * BugFix: UML-9717
     */
    // old code
//    /**
//     * <p>
//     * Represent the preferred width / height ratio of the actor.
//     * </p>
//     */
//    private static final double WH_RATIO = 0.625;
    /**
     * <p>
     * Represents the default size for ActorNode.
     * </p>
     */
    private static final Dimension DEFAULT_MINIMUM_SIZE = new Dimension(40, 80);

    /**
     * <p>
     * Create a ActorNode instance.
     * </p>
     *
     * @param graphNode the graphNode representing this ActorNode
     * @param properties the properties name mapping.
     * @throws IllegalArgumentException if any argument is null.
     * @throws IllegalGraphElementException if the structure of graphNode is invalid.
     */
    public ActorNode(GraphNode graphNode, Map<String, String> properties) throws IllegalGraphElementException {
        super(checkValidGraphNode(graphNode), properties, getCompartment(graphNode, 1),
                getCompartment(graphNode, 0), getCompartment(graphNode, 2));

        super.setConnector(new ActorConnector(this));

        // set the actor node's size/relativePosition/selectionBound
        // and load the name, stereotype and namespace's information
        notifyGraphNodeChange(null);
    }

    /**
     * <p>
     * Get the preferred graph node size. Please note this is different from JComponent#getPreferredSize(). The returned
     * value indicating the preferred size of core shape of this node. This method is provided for the application to
     * set proper size of graph node.
     * </p>
     *
     * @return the preferred size of graph node.
     */
    public Dimension getPreferredGraphNodeSize() {
        /*
         * BugFix: UML-9717
         */
        // old code
//        double width = this.getGraphNode().getSize().getWidth();
//        double height = this.getGraphNode().getSize().getHeight();
//
//        if (width / height > WH_RATIO) {
//            width = height * WH_RATIO;
//        } else {
//            height = width / WH_RATIO;
//        }
//        return new Dimension((int) Math.round(width), (int) Math.round(height));
        return new Dimension(DEFAULT_MINIMUM_SIZE);
    }

    /**
     * <p>
     * Override of contains method.
     * </p>
     *
     * @return whether the given point is contained.
     * @param x the x coordinate
     * @param y the y coordinate
     */
    public boolean contains(int x, int y) {
        /*
         * BugFix: UML-10115
         * Use selection bound.
         */
        // old code
//        Point point = new Point();
//        this.getLocation(point);
//        double width = this.getGraphNode().getSize().getWidth();
//        double height = this.getGraphNode().getSize().getHeight();
//
//        Rectangle rect = new Rectangle(point.x, point.y, (int) Math.round(width), (int) Math.round(height));
        Rectangle rect = getSelectionBound();

        if (rect.contains(x, y)) {
            return true;
        }

        /*
         * BugFix: UML-10115
         */
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
     * Override of paintComponent method.
     * </p>
     * <p>
     * The Actor consists a circle (representing head), and several segments(representing body). Please see Poseidon
     * for sample.
     * </p>
     * <p>
     * NOTE, compartments are not need to paint here. Because they are added as child swing component, they can be
     * painted automatically.
     * </p>
     *
     * @param g the graphics to paint on (null is ignored.)
     */
    protected void paintComponent(Graphics g) {
        if (g != null) {
            super.paintComponent(g);

            Graphics2D g2 = (Graphics2D) g;

            // back up the old color and restore it to the Graphics after the painting is finished
            // this is required by swing component
            Color oldColor = g2.getColor();

            Rectangle bound = getSelectionBound();
            double x = bound.x;
            double y = bound.y;
            double width = bound.width;
            double height = bound.height;
            // fill the head
            g2.setColor(getFillColor());
            g2.fillOval((int) Math.round(x + width * 0.3), (int) Math.round(y),
                    (int) Math.round(width * 0.4), (int) Math.round(height / 4));
            g2.setColor(getStrokeColor());
            // draw the head
            g2.drawOval((int) Math.round(x + width * 0.3), (int) Math.round(y),
                    (int) Math.round(width * 0.4), (int) Math.round(height / 4));
            // draw the body
            g2.drawLine((int) Math.round(x + width / 2), (int) Math.round(y + height / 4),
                    (int) Math.round(x + width / 2), (int) Math.round(y + height * 5 / 8));
            // draw the hand
            g2.drawLine((int) Math.round(x), (int) Math.round(y + height * 5 / 16),
                    (int) Math.round(x + width), (int) Math.round(y + height * 5 / 16));
            // draw the foot
            g2.drawLine((int) Math.round(x + width / 2), (int) Math.round(y + height * 5 / 8),
                    (int) Math.round(x), (int) Math.round(y + height * 15 / 16));
            g2.drawLine((int) Math.round(x + width / 2), (int) Math.round(y + height * 5 / 8),
                    (int) Math.round(x + width), (int) Math.round(y + height * 15 / 16));

            // restore the color
            g2.setColor(oldColor);
        }
    }

    /**
     * <p>
     * Reload diagram interchange information from contained graphNode.
     * </p>
     * <p>
     * 1) Resize and relocate the node, boundary change event should be triggered with message. 2) Resize and relocate
     * the compartments. 3) Note, the actual size of node should be bounding rectangle of actor shape and compartments.
     * Please see <b>UML Tool - UseCase Diagram Elements Compartments.rtf</b> to retrieve size,location from the
     * graphNode.
     * </p>
     *
     * @param message telling how graphNode is changed (could be null).
     * @throws IllegalGraphElementException if the structure of graphNode is invalid.
     */
    public void notifyGraphNodeChange(String message) throws IllegalGraphElementException {
        /*
         * BugFix: UML-10116
         * Compartments should be updated first, including their text, font, font color, visibility, etc.
         * Node's graph node size should be compared with preferred size, it should be adjusted to preferred size if
         * it is too small.
         * A compartment' size should be its preferred size for new text, its location should be adjusted
         * according to node's graph node position and size, to make sure the compartment centered in horizontal
         * direction.
         */
        // old code
//        Rectangle oldBound = this.getSelectionBound();
//
//        setLocationSize();
//
//        Rectangle newBound = this.getSelectionBound();
//        if (!newBound.equals(oldBound)) {
//            BoundaryChangedEvent event = new BoundaryChangedEvent(this, oldBound, newBound);
//            fireBoundaryChange(event);
//        }
//
//        // resize and relocate name, stereotype, namespace compartments
//        Utils.updateTextFieldSizeLocation(super.getNameCompartment());
//        Utils.updateTextFieldSizeLocation(super.getStereotypeCompartment());
//        Utils.updateTextFieldSizeLocation(super.getNamespaceCompartment());
//
//        try {
//            Actor actorModel =
//                ((Actor) ((Uml1SemanticModelBridge) super.getGraphNode().getSemanticModel()).getElement());
//            super.getNameCompartment().setText(actorModel.getName());
//            super.getStereotypeCompartment().setText(Utils.getStereotypeText(null, actorModel.getStereotypes()));
//            super.getNamespaceCompartment().setText(actorModel.getNamespace().getName());
//        } catch (NullPointerException e) {
//            throw new IllegalGraphElementException(getGraphNode(), "expects a correct semantic model", e);
//        } catch (ClassCastException e) {
//            throw new IllegalGraphElementException(getGraphNode(), "the element should be instance of Actor", e);
//        }
        Utils.checkGraphNode(this);
        notifyPropertiesChange();

        // Get selection corner radius
        int radius = getSelectionCorners().iterator().next().getRadius();

        GraphNode graphNode = getGraphNode();

        TextField stereotype = getStereotypeCompartment();
        TextField name = getNameCompartment();
        TextField namespace = getNamespaceCompartment();

        Utils.updateCompartments(this);

        Dimension size = Utils.getGraphNodeSize(graphNode);
        Dimension preferredSize = getPreferredGraphNodeSize();
        if (size.width < preferredSize.width) {
            size.width = preferredSize.width;
            graphNode.getSize().setWidth(size.width);
        }
        if (size.height < preferredSize.height) {
            size.height = preferredSize.height;
            graphNode.getSize().setHeight(size.height);
        }
        Dimension actorSize = new Dimension(size);

        stereotype.setSize(stereotype.getPreferredSize());
        if (stereotype.isVisible()) {
            size.width = Math.max(size.width, stereotype.getWidth());
            size.height += stereotype.getHeight();
        }
        name.setSize(name.getPreferredSize());
        if (name.isVisible()) {
            size.width = Math.max(size.width, name.getWidth());
            size.height += name.getHeight();
        }
        namespace.setSize(namespace.getPreferredSize());
        if (namespace.isVisible()) {
            size.width = Math.max(size.width, namespace.getWidth());
            size.height += namespace.getHeight();
        }

        size.width += radius * 2;
        size.height += radius * 2;

        int y = radius;
        if (stereotype.isVisible()) {
            stereotype.setLocation((int) Math.round((size.width - stereotype.getWidth()) * 0.5), y);
            y += stereotype.getHeight();
        }
        y += actorSize.height;
        if (name.isVisible()) {
            name.setLocation((int) Math.round((size.width - name.getWidth()) * 0.5), y);
            y += name.getHeight();
        }
        if (namespace.isVisible()) {
            namespace.setLocation((int) Math.round((size.width - namespace.getWidth()) * 0.5), y);
        }

        Point location = Utils.getAbsolutePosition(graphNode);
        location.x += (int) Math.round((actorSize.width - size.width) * 0.5);
        location.y -= radius;
        if (stereotype.isVisible()) {
            location.y -= stereotype.getHeight();
        }

        Utils.updateNodeBound(this, new Rectangle(location, size), actorSize, message);

    }

    /**
     * <p>
     * Helper function that checks valid for GraphNode instance.
     * </p>
     * <p>
     * the structure should be
     * Uml1SemanticModelBridge.element = UML:Actor
     *   SimpleSemanticModelElement.typeInfo = "StereotypeCompartment"
     *   SimpleSemanticModelElement.typeInfo = "Name"
     *   SimpleSemanticModelElement.typeInfo = "NamespaceCompartment"
     * </p>
     * @param graphNode the GraphNode instance for check
     * @return the instance of GraphNode
     * @throws IllegalGraphElementException if the GraphNode is not a valid UseCase node
     */
    private static GraphNode checkValidGraphNode(GraphNode graphNode) throws IllegalGraphElementException {
        if (graphNode == null) {
            throw new IllegalArgumentException("The graphNode can not be null.");
        }

        // check if contains stereotype , name and namespace compartment.

        if (graphNode.getContaineds().size() != NUMBER_OF_COMPARTMENTS) {
            throw new IllegalGraphElementException(graphNode, "does not contain 3 compartment.");
        }

        for (int i = 0; i < NUMBER_OF_COMPARTMENTS; i++) {
            if (!(graphNode.getContaineds().get(i) instanceof GraphNode)) {
                throw new IllegalGraphElementException(graphNode, "The contained should be instance of GraphNode");
            }
        }

        return graphNode;
    }

    /**
     * <p>
     * Helper function that return the TextField based on the graphNode and index.
     * </p>
     *
     * @param graphNode the GraphNode instance that contains the information about the TextField
     * @param i the index of the TextField's information
     * @return the newly created TextField instance
     */
    private static TextField getCompartment(GraphNode graphNode, int i) {
        return new TextField((GraphNode) graphNode.getContaineds().get(i));
    }

    /**
     * <p>
     * Helper function that sets actor node's location/size/relativePosition/selectionBound.
     * </p>
     * <p>
     * This is different form Utils#setNodeSizeRelativePosition(Node, GraphNode), because the
     * swingNode#size/location should be the bounding rectangle of actor and all compartments. (including spaces for
     * selectionCorners).
     * </p>
     * @throws IllegalGraphElementException if the structure of graphNode is invalid.
     */
    private void setLocationSize() throws IllegalGraphElementException {
        int x1 = Integer.MAX_VALUE;
        int y1 = Integer.MAX_VALUE;
        int x2 = Integer.MIN_VALUE;
        int y2 = Integer.MIN_VALUE;

        int nodeWidth = (int) Math.round(super.getGraphNode().getSize().getWidth());
        int nodeHeight = (int) Math.round(super.getGraphNode().getSize().getHeight());

        try {
            Rectangle[] rects = new Rectangle[] {
                getGraphNodeRect(getNameCompartment().getGraphNode()),
                getGraphNodeRect(getStereotypeCompartment().getGraphNode()),
                getGraphNodeRect(getNamespaceCompartment().getGraphNode()),
                new Rectangle(0, 0, nodeWidth, nodeHeight)
            };

            for (Rectangle rect : rects) {
                int x = rect.x;
                int y = rect.y;
                int width = rect.width;
                int height = rect.height;
                if (x < x1) {
                    x1 = x;
                }
                if (y < y1) {
                    y1 = y;
                }
                if (x + width > x2) {
                    x2 = x + width;
                }
                if (y + height > y2) {
                    y2 = y + height;
                }
            }

            Point absolutePosition = Utils.getAbsolutePosition(super.getGraphNode());
            Point relativePosition = new Point();
            // x1 is always smaller than or equal to 0, so is y1
            relativePosition.x = -x1 + SelectionCorner.DEFAULT_RADIUS;
            relativePosition.y = -y1 + SelectionCorner.DEFAULT_RADIUS;

            setLocation(absolutePosition.x + x1, absolutePosition.y + y1);
            setSize(x2 - x1 + SelectionCorner.DEFAULT_RADIUS * 2, y2 - y1 + SelectionCorner.DEFAULT_RADIUS * 2);
            setRelativePosition(relativePosition);
            setSelectionBound(new Rectangle(relativePosition.x, relativePosition.y, nodeWidth, nodeHeight));
        } catch (NullPointerException npe) {
            throw new IllegalGraphElementException(super.getGraphNode(), "the structure of graphNode is invalid", npe);
        }
    }

    /**
     * <p>
     * Helper function that return the rectangle of the given graphNode.
     * </p>
     *
     * @param graphNode the desired graphNode
     * @return the rectangle of the given graphNode
     */
    private Rectangle getGraphNodeRect(GraphNode graphNode) {
        return new Rectangle((int) Math.round(graphNode.getPosition().getX()),
                (int) Math.round(graphNode.getPosition().getY()), (int) Math.round(graphNode.getSize().getWidth()),
                (int) Math.round(graphNode.getSize().getHeight()));
    }
}