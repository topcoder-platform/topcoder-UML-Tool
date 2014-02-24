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
import java.awt.geom.Ellipse2D;
import java.util.Map;
import java.util.ArrayList;

import javax.swing.SwingUtilities;

import com.topcoder.diagraminterchange.GraphElement;
import com.topcoder.diagraminterchange.GraphNode;

/**
 * <p>
 * This class represents an UseCase node is UML diagram. It is an extension of BaseNode, which defines the most feature
 * for a node. This class only provides some specific methods to support the unique shape of usecase (an ellipse), and
 * also to support the unique structure of usecase GraphNode.
 * </p>
 * <p>
 * The structure of the GraphNode that corresponds to a UseCase is as follows:
 * </p>
 * <p>
 * Uml1SemanticModelBridge.element = UML:UseCase
 *   SimpleSemanticModelElement.typeInfo = "NameCompartment"
 *      SimpleSemanticModelElement.typeInfo = "StereotypeCompartment"
 *      SimpleSemanticModelElement.typeInfo = "Name"
 *      SimpleSemanticModelElement.typeInfo = "NamespaceCompartment¡±
 * </p>
 * <p>
 * <b>Thread Safety</b>: This class is not thread safe, because the BaseNode class is not thread safe.
 * </p>
 *
 * @author maone, TCSDEVELOPER
 * @version 1.0
 */
public class UseCaseNode extends BaseNode {
    /**
     * <p>
     * Represents the number of compartments should be contained in the graphNode.
     * </p>
     */
    private static final int NUMBER_OF_COMPARTMENTS = 3;

    /**
     * <p>
     * This ratio is used to calculate the width of the minimum ellipse than contains the rectangle.
     * </p>
     */
    private static final double ELLIPSE_RECTANGLE_WIDTH_RATIO = 1.40625;

    /**
     * <p>
     * This ratio is used to calculate the height of the minimum ellipse than contains the rectangle.
     * </p>
     */
    private static final double ELLIPSE_RECTANGLE_HEIGHT_RATIO = 1.47059;

    /**
     * <p>
     * Represents the default width of UseCaseNode, if it contains nothing.
     * </p>
     */
    private static final int DEFAULT_WIDTH = 90;

    /**
     * <p>
     * Represents the default height of UseCaseNode, if it contains nothing.
     * </p>
     */
    private static final int DEFAULT_HEIGHT = 50;

    /**
     * <p>
     * Creates a UseCaseNode.
     * </p>
     *
     * @param graphNode the graphNode representing this UseCaseNode
     * @param properties the properties name mapping.
     * @throws IllegalArgumentException if any argument is null.
     * @throws IllegalGraphElementException if the structure of graphNode is invalid.
     */
    public UseCaseNode(GraphNode graphNode, Map<String, String> properties) throws IllegalGraphElementException {
        super(checkValidGraphNode(graphNode), properties, getCompartment(graphNode, 1),
                getCompartment(graphNode, 0), getCompartment(graphNode, 2));

        super.setConnector(new UseCaseConnector(this));

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
        TextField[] textFields = new TextField[] {super.getNameCompartment(), super.getStereotypeCompartment(),
                super.getNamespaceCompartment()};
        /*
         * BugFix: UML-7167
         */
        // old code
//        Rectangle rect = Utils.getBoundedRect(textFields);
//
//        // if all its compartments are hidden, the default size will return
//        if (rect.x == Integer.MAX_VALUE) {


	// set all the compartments so that they have the minimum possible width.
	for (TextField field : textFields) {
	    setLineBreaks(field, 0);
	    field.setSize(field.getPreferredSize());
	}
	// get the bounded rect when the compartments have the minimum possible width
	Dimension rect1 = Utils.getBoundedRect(textFields);	
	GraphNode graphNode = getGraphNode();
	Dimension graphSize = Utils.getGraphNodeSize(graphNode);
	int graphNodeWidth = (int) graphSize.getWidth();
	// restore the compartments to their old width.
	for (TextField field : textFields) {
	    setLineBreaks(field, graphNodeWidth);
	    field.setSize(field.getPreferredSize());
	}
	// get the bounded rect where the compartments have their current width.
	Dimension rect2 = Utils.getBoundedRect(textFields);	
	// if all its compartments are hidden, the default size will return
        if (rect1.width == 0 && rect1.height == 0) {
            return new Dimension(DEFAULT_WIDTH, DEFAULT_HEIGHT);
        }

        // this will calculate a ellipse that can contain this rectangle
        double width = rect1.width * ELLIPSE_RECTANGLE_WIDTH_RATIO;
        double height = rect2.height * ELLIPSE_RECTANGLE_HEIGHT_RATIO;

        /*
         * Bugfix: UML-9574
         * The width and height should be able to be independently adjusted.
         */
        // old code
//        // adjust the width / height ratio so that it looks good
//        if (width / height > WH_RATIO) {
//            height = width / WH_RATIO;
//        } else {
//            width = height * WH_RATIO;
//        }
        return new Dimension((int) Math.round(width), (int) Math.round(height));
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
         * BugFix: UML-7163
         */
        // old code
//        Point point = new Point();
//        this.getLocation(point);
//        double width = this.getGraphNode().getSize().getWidth();
//        double height = this.getGraphNode().getSize().getHeight();
//
//        Ellipse2D.Double ellipse = new Ellipse2D.Double(point.getX(), point.getY(), width, height);
//        return ellipse.contains(x, y);
        Point point = getRelativePosition();
        double width = this.getGraphNode().getSize().getWidth();
        double height = this.getGraphNode().getSize().getHeight();

        Ellipse2D.Double ellipse = new Ellipse2D.Double(point.getX(), point.getY(), width, height);
        if (ellipse.contains(x, y)) {
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
     * Override of paintComponent method.
     * </p>
     * <p>
     * NOTE, compartments are not need to paint here.
     * Because they are added as child swing component, they can be painted automatically.
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
            int x = bound.x;
            int y = bound.y;
            int width = bound.width;
            int height = bound.height;

            g2.setColor(getFillColor());
            g2.fillOval(x, y, width, height);

            g2.setColor(getStrokeColor());
            g2.drawOval(x, y, width - 1, height - 1);

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
     * the compartments. 3) Note, the actual size of node should be bounding rectangle of usecase shape and
     * compartments. Please see <b>UML Tool - UseCase Diagram Elements Compartments.rtf</b> to retrieve size,location
     * from the graphNode.
     * </p>
     *
     * @param message telling how graphNode is changed (could be null).
     * @throws IllegalGraphElementException if the structure of graphNode is invalid.
     */
    public void notifyGraphNodeChange(String message) throws IllegalGraphElementException {
        /*
         * BugFix: UML-10121
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
//        Utils.setNodeSizeRelativePosition(this, super.getGraphNode());
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
//            UseCase useCaseModel =
//                ((UseCase) ((Uml1SemanticModelBridge) super.getGraphNode().getSemanticModel()).getElement());
//            super.getNameCompartment().setText(useCaseModel.getName());
//            super.getStereotypeCompartment().setText(Utils.getStereotypeText(null, useCaseModel.getStereotypes()));
//            super.getNamespaceCompartment().setText(useCaseModel.getNamespace().getName());
//        } catch (NullPointerException e) {
//            throw new IllegalGraphElementException(getGraphNode(), "expects a correct semantic model", e);
//        } catch (ClassCastException e) {
//            throw new IllegalGraphElementException(getGraphNode(), "the element should be instance of UseCase", e);
//        }
        Utils.checkGraphNode(this);

        GraphNode graphNode = getGraphNode();
        TextField stereotype = getStereotypeCompartment();
        TextField name = getNameCompartment();
        TextField namespace = getNamespaceCompartment();        

	Utils.updateCompartments(this);
        Dimension size = Utils.getGraphNodeSize(graphNode);
        Dimension compartmentSize = new Dimension(0, 0);
	setLineBreaks(stereotype, (int) size.getWidth());
	stereotype.setSize(stereotype.getPreferredSize());
        if (stereotype.isVisible()) {
            compartmentSize.width = Math.max(compartmentSize.width, stereotype.getWidth());
            compartmentSize.height += stereotype.getHeight();
        }	
	setLineBreaks(name, (int) size.getWidth());
        name.setSize(name.getPreferredSize());
        if (name.isVisible()) {
            compartmentSize.width = Math.max(compartmentSize.width, name.getWidth());
            compartmentSize.height += name.getHeight();
        }
	setLineBreaks(namespace, (int) size.getWidth());
        namespace.setSize(namespace.getPreferredSize());
        if (namespace.isVisible()) {
            compartmentSize.width = Math.max(compartmentSize.width, namespace.getWidth());
            compartmentSize.height += namespace.getHeight();
        }

        notifyPropertiesChange();

        // Get selection corner radius
        int radius = getSelectionCorners().iterator().next().getRadius();


        Dimension preferredSize = getPreferredGraphNodeSize();
        if (size.width < preferredSize.width) {
            size.width = preferredSize.width;
            graphNode.getSize().setWidth(size.width);
        }
        if (size.height < preferredSize.height) {
            size.height = preferredSize.height;
            graphNode.getSize().setHeight(size.height);
        }

        size.width += radius * 2;
        size.height += radius * 2;

        int y = (int) Math.round((size.height - compartmentSize.height) * 0.5);
        if (stereotype.isVisible()) {
            stereotype.setLocation((int) Math.round((size.width - stereotype.getWidth()) * 0.5), y);
            y += stereotype.getHeight();
        }
        if (name.isVisible()) {
            name.setLocation((int) Math.round((size.width - name.getWidth()) * 0.5), y);
            y += name.getHeight();
        }
        if (namespace.isVisible()) {
            namespace.setLocation((int) Math.round((size.width - namespace.getWidth()) * 0.5), y);
        }

        Point location = Utils.getAbsolutePosition(graphNode);
        location.x -= radius;
        location.y -= radius;

        Utils.updateNodeBound(this, new Rectangle(location, size), Utils.getGraphNodeSize(graphNode), message);
    }

    /**
     * <p>
     * Helper function that sets the number of line breaks for the TextField.
     * </p>
     * @param textField the TextField to set the line breaks for.     
     */
    private void setLineBreaks(TextField textField, int width){
	GraphNode graphNode = getGraphNode();
	textField.setLineBreaks(new ArrayList<Integer>());
	String originalText = new String(textField.getText());
	ArrayList<Integer> lBreaks = new ArrayList<Integer>();
	int lastLineBreak = 0;	
	for (int i = 0; i <= originalText.length(); i = Math.max(originalText.indexOf(" ", i + 1), i + 1)) {
	    String txt = originalText.substring(lastLineBreak, i);
	    textField.setText(txt);
	    Dimension prefSize = textField.getPreferredSize();
	    double prefWidth = prefSize.width * ELLIPSE_RECTANGLE_WIDTH_RATIO; 
	    int pWidth = (int) Math.round(prefWidth);
	    if (pWidth >= width) {
		int lineBreakIndex = txt.lastIndexOf(" ");
		if (txt.lastIndexOf(" ") != -1 && txt.trim().lastIndexOf(" ") != -1) {
		    lBreaks.add(lastLineBreak + lineBreakIndex);
		    lastLineBreak += lineBreakIndex;
		}
	    }

	}
	textField.setText(originalText);
	textField.setLineBreaks(lBreaks);	    
	    
    }

    /**
     * <p>
     * Helper function that checks valid for GraphNode instance.
     * </p>
     * <p>
     * the structure should be
     * Uml1SemanticModelBridge.element = UML:UseCase
     *   SimpleSemanticModelElement.typeInfo = "NameCompartment"
     *      SimpleSemanticModelElement.typeInfo = "StereotypeCompartment"
     *      SimpleSemanticModelElement.typeInfo = "Name"
     *      SimpleSemanticModelElement.typeInfo = "NamespaceCompartment¡±
     * </p>
     * @param graphNode the GraphNode instance for check
     * @return the instance of GraphNode
     * @throws IllegalGraphElementException if the GraphNode is not a valid UseCase node
     */
    private static GraphNode checkValidGraphNode(GraphNode graphNode) throws IllegalGraphElementException {
        if (graphNode == null) {
            throw new IllegalArgumentException("The graphNode can not be null.");
        }

        if (graphNode.getContaineds().size() == 0) {
            throw new IllegalGraphElementException(graphNode,
                    "The contained should not be empty, there should be one NameCompartment.");
        }

        GraphElement element = (GraphElement) graphNode.getContaineds().get(0);

        // check if contains stereotype , name and namespace compartment.

        if (element.getContaineds().size() != NUMBER_OF_COMPARTMENTS) {
            throw new IllegalGraphElementException(graphNode, "does not contain 3 compartment.");
        }

        for (int i = 0; i < NUMBER_OF_COMPARTMENTS; i++) {
            if (!(element.getContaineds().get(i) instanceof GraphNode)) {
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
        GraphElement element = (GraphElement) graphNode.getContaineds().get(0);

        return new TextField((GraphNode) element.getContaineds().get(i));
    }
}