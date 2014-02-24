/*
 * Copyright (C) 2007 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.gui.diagramviewer.uml.classelements;

import java.awt.Component;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.Map;

import javax.swing.SwingUtilities;

import com.topcoder.diagraminterchange.GraphNode;
import com.topcoder.gui.diagramviewer.uml.classelements.event.PopupGroupFieldTrigger;

/**
 * <p>
 * This class represents an Enumeration node in UML diagram. It is an extension of C, which defines the most
 * features for a node. This class only provides some specific methods to support the unique shape of enumeration (with
 * an additional EnumerationLiteral compartment), to support the mouse events processing, and also to support the unique
 * structure of enumeration GraphNode.
 * </p>
 * <p>
 * This class is not thread safe, because the BaseNode class is not thread safe.
 * </p>
 * @author MiG-29, TCSDEVELOPER
 * @version 1.0
 */
public class EnumerationNode extends BaseNode {

    /**
     * <p>
     * Represents the enumeration literal compartment's graph node index in the graph node structure.
     * </p>
     */
    private static final int LITERAL_INDEX = 2;

    /**
     * <p>
     * Represents the attribute compartment's graph node index in the graph node structure.
     * </p>
     */
    private static final int ATTRIBUTE_INDEX = 4;

    /**
     * <p>
     * Represents the operation compartment's graph node index in the graph node structure.
     * </p>
     */
    private static final int OPERATION_INDEX = 6;

    /**
     * <p>
     * Represents the EnumerationLiteralCompartment of this node. Created and initialized in constructor, never changed
     * later, can't be null. Can be accessed by getter.
     * </p>
     * <p>
     * The data/size/location of this compartment will be updated in notifyGraphNodeChange method.
     * </p>
     */
    private final GroupTextField enumerationLiteral;

    /**
     * <p>
     * Represents the size of name compartment.
     * </p>
     */
    private Dimension nameSize;

    /**
     * <p>
     * Represents the size of enumeration literal compartment.
     * </p>
     */
    private Dimension literalSize;

    /**
     * <p>
     * Represents the size of attribute compartment.
     * </p>
     */
    private Dimension attributeSize;

    /**
     * <p>
     * Represents the size of operation compartment.
     * </p>
     */
    private Dimension operationSize;

    /**
     * <p>
     * Represents the bounding size of compartments.
     * </p>
     */
    private Dimension size;

    /**
     * <p>
     * Create an EnumerationNode.
     * </p>
     * @param graphNode
     *            the graphNode representing this EnumerationNode
     * @param properties
     *            the properties name mapping
     */
    public EnumerationNode(GraphNode graphNode, Map<String, String> properties) {
        super(graphNode, properties, new TextField(Util.getCompartmentGraphNode(graphNode, 1)), new TextField(Util
                .getCompartmentGraphNode(graphNode, 0)), new TextField(Util.getCompartmentGraphNode(graphNode, 2)));

        // Create a connector for this instance
        setConnector(new EnumerationConnector(this));

        // Create enumeration literal compartment
        enumerationLiteral = new GroupTextField(new ArrayList<StereotypeTextField>());

        // Register PopupGroupFieldTrigger to the compartment to allow popup menu
        enumerationLiteral.addMouseListener(new PopupGroupFieldTrigger());

        // Add as child components
        add(enumerationLiteral);

        // Notify the EnumerationNode instance is created
        notifyGraphNodeChange("EnumerationNode instance created.");
    }

    /**
     * <p>
     * Gets the preferred graph node size. Please note this is different from JComponent#getPreferredSize(). The
     * returned value indicating the preferred size of core shape of this node. This method is provided for the
     * application to set proper size of graph node.
     * </p>
     * @return the preferred size of graph node
     */
    public Dimension getPreferredGraphNodeSize() {
        // Get preferred size to hold stereotype, name and namespace compartments
        Dimension preferredSize = Util.getPreferredCompartmentsSize(getStereotypeCompartment(), getNameCompartment(),
                getNamespaceCompartment());

        // Combine with the preferred size of enumeration literals compartment
        if (enumerationLiteral.isVisible()) {
            Dimension preferredLiteralSize = enumerationLiteral.getPreferredSize();
            Util.combineSize(preferredSize, preferredLiteralSize, false);
        }

        // Combine with the preferred size of attributes compartment
        if (getAttributesCompartment().isVisible()) {
            Dimension preferredAttributeSize = getAttributesCompartment().getPreferredSize();
            Util.combineSize(preferredSize, preferredAttributeSize, false);
        }

        // Combine with the preferred size of operations compartment
        if (getOperationsCompartment().isVisible()) {
            Dimension preferredOperationSize = getOperationsCompartment().getPreferredSize();
            Util.combineSize(preferredSize, preferredOperationSize, false);
        }

        // If the size's width or height is small than the default minimum, adjust it
        preferredSize.width = Math.max(preferredSize.width, DEFAULT_MINIMUM_SIZE.width);
        preferredSize.height = Math.max(preferredSize.height, DEFAULT_MINIMUM_SIZE.height);
        return preferredSize;
    }

    /**
     * <p>
     * Determines whether given coordinate is in the shape of this component for the sake of mouse processing.
     * </p>
     * @param x
     *            the x coordinate
     * @param y
     *            the y coordinate
     * @return whether the given point is contained
     */
    public boolean contains(int x, int y) {
        /*
         * BugFix: BUGID UML-8195
         * Description:
         * In contains, the selection corners around this node should be checked to determine whether or not the
         * point is contained.
         * Solution:
         * Code is added to check the child components.
         */
        // old code
//        return new Rectangle(getRelativePosition(), size).contains(x, y);
        if (new Rectangle(getRelativePosition(), size).contains(x, y)) {
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
     * Rendering process of this node.
     * </p>
     * @param g
     *            the graphics to paint on (null is ignored)
     */
    protected void paintComponent(Graphics g) {
        if (g != null) {
            Util.paintBaseNode(this, g, nameSize, literalSize, attributeSize, operationSize);
        }
    }

    /**
     * <p>
     * Reloads diagram interchange information from contained graphNode.
     * </p>
     * @param message
     *            telling how graphNode is changed (could be null)
     */
    public void notifyGraphNodeChange(String message) {
        GraphNode graphNode = getGraphNode();
        Util.checkGraphNode(this);
        notifyPropertiesChange();

        // Get selection corner radius
        int radius = getSelectionCorners().iterator().next().getRadius();

        // Calculate the preferred size for this node and its contained compartments
        calculateSize(radius, graphNode);

        /*
         * BugFix: BUGID UML-8195
         * Description:
         * In notifyGraphNodeChange, the calculated preferred size should be set to the graph node to keep consistency.
         * Solution:
         * Set the calculated size to the graph node to keep consistency.
         */
        // Set the calculated size to graph node
        getGraphNode().getSize().setWidth(size.width);
        getGraphNode().getSize().setHeight(size.height);

        // Update all contained compartments according to the size calculated
        updateAllCompartments(radius);

        // Update this node's boundary
        Util.updateNodeBound(this, radius, size, message);
    }

    /**
     * <p>
     * Calculates the node and its compartments' preferred sizes.
     * </p>
     * @param radius
     *            selection corner radius
     * @param graphNode
     *            the graphNode representing this node
     */
    private void calculateSize(int radius, GraphNode graphNode) {
        // Relocate and resize stereotype, name and namespace compartments, set their properties, and get the size to
        // hold them
        nameSize = Util.rearrangeCompartments(this, radius);

        size = new Dimension(nameSize);

        GraphNode literalNode = (GraphNode) graphNode.getContaineds().get(LITERAL_INDEX);
        literalSize = new Dimension(0, 0);
        enumerationLiteral.setVisible(literalNode.isVisible());
        if (literalNode.isVisible()) {
            enumerationLiteral.setItems(Util.getEnumerationLiterals(graphNode));
            // Set properties to enumeration literal compartment
            Util.updateGroupProperties(this, enumerationLiteral);
            literalSize = enumerationLiteral.getPreferredSize();
            Util.combineSize(size, literalSize, false);
        }

        GraphNode attributesNode = (GraphNode) graphNode.getContaineds().get(ATTRIBUTE_INDEX);
        GroupTextField attributes = getAttributesCompartment();
        attributeSize = new Dimension(0, 0);
        attributes.setVisible(attributesNode.isVisible());
        if (attributesNode.isVisible()) {
            attributes.setItems(Util.getAttributes(this));
            // Set properties to attribute compartment
            Util.updateGroupProperties(this, attributes);
            attributeSize = attributes.getPreferredSize();
            Util.combineSize(size, attributeSize, false);
        }

        GraphNode operationNode = (GraphNode) graphNode.getContaineds().get(OPERATION_INDEX);
        GroupTextField operations = getOperationsCompartment();
        operationSize = new Dimension(0, 0);
        operations.setVisible(operationNode.isVisible());
        if (operationNode.isVisible()) {
            operations.setItems(Util.getOperations(this));
            // Set properties to operation compartment
            Util.updateGroupProperties(this, operations);
            operationSize = operations.getPreferredSize();
            Util.combineSize(size, operationSize, false);
        }

        // Adjust to default if necessary
        compareWithDefault();
        /*
         * BugFix: BUGID UML-8195
         * Description:
         * In calculateSize, at the end of the method, the calculated size should also be compared with the user
         * defined size.
         * Solution:
         * Code is added to compare with the user defined size.
         */
        // Adjust to user defined if necessary
        compareWithUserDefined();
    }

    /*
     * BugFix: BUGID UML-8195
     * Description:
     * In calculateSize, at the end of the method, the calculated size should also be compared with the user
     * defined size.
     * Solution:
     * Code is added to compare with the user defined size.
     */
    /**
     * <p>
     * Compares the size with user defined size, resize if necessary.
     * </p>
     */
    private void compareWithUserDefined() {
        GraphNode graphNode = getGraphNode();
        Dimension userDefined = new Dimension();
        userDefined.width = (int) Math.ceil(graphNode.getSize().getWidth());
        userDefined.height = (int) Math.ceil(graphNode.getSize().getHeight());
        size.width = Math.max(size.width, userDefined.width);
        if (size.height < userDefined.height) {
            // Enlarge the operation attribute compartment
            operationSize.height += userDefined.height - size.height;
            size.height = userDefined.height;
        }
    }

    /**
     * <p>
     * Compares the size with default size, resize if necessary.
     * </p>
     */
    private void compareWithDefault() {
        size.width = Math.max(size.width, DEFAULT_MINIMUM_SIZE.width);
        if (size.height < DEFAULT_MINIMUM_SIZE.height) {
            // Enlarge the operation attribute compartment
            operationSize.height += DEFAULT_MINIMUM_SIZE.height - size.height;
            size.height = DEFAULT_MINIMUM_SIZE.height;
        }
    }

    /**
     * <p>
     * Updates all compartments contained.
     * </p>
     * @param radius
     *            selection corner radius
     */
    private void updateAllCompartments(int radius) {
        // Update the X coordinates for stereotype, name and namespace compartments
        Util.updateNameCompartments(radius, this, size.width);
        nameSize.width = size.width;

        // All compartments and its contained text fields' width should be set same with this node's visual width
        if (enumerationLiteral.isVisible()) {
            // Update enumeration literal items' location and size
            Util.updateGroupTextField(enumerationLiteral, size.width);
            literalSize.width = size.width;
            enumerationLiteral.setLocation(radius, radius + nameSize.height);
            enumerationLiteral.setSize(literalSize);
        }
        GroupTextField attributes = getAttributesCompartment();
        if (attributes.isVisible()) {
            // Update attribute items' location and size
            Util.updateGroupTextField(attributes, size.width);
            attributeSize.width = size.width;
            attributes.setLocation(radius, radius + nameSize.height + literalSize.height);
            attributes.setSize(attributeSize);
        }
        GroupTextField operations = getOperationsCompartment();
        if (operations.isVisible()) {
            // Update operation items' location and size
            Util.updateGroupTextField(operations, size.width);
            operationSize.width = size.width;
            operations.setLocation(radius, radius + nameSize.height + literalSize.height + attributeSize.height);
            operations.setSize(operationSize);
        }
    }

    /**
     * <p>
     * Consumes the event when the diagram viewer is in the status of adding new element. The concrete edge type
     * checking is implemented here.
     * </p>
     * @param event
     *            the mouse event
     * @return a flag indicating whether the event is consumed
     */
    protected boolean consumeEvent(MouseEvent event) {
        if (event == null || event.getSource() == null) {
            return false;
        }
        return Util.consumeEvent(this, event);
    }

    /**
     * <p>
     * Getter of EnumerationLiteralCompartment belonging to this node.
     * </p>
     * @return The value of the enumerationLiteral field
     */
    public GroupTextField getEnumerationLiteralCompartment() {
        return enumerationLiteral;
    }

    /**
     * <p>
     * Notifies the "isVisible" attribute of EnumerationLiteralCompartment has been changed. This is a convenient
     * variant of notifyGraphNodeChange method.
     * </p>
     * <p>
     * The visual appearance of this node would change according to the current value of GraphNode. JComponent node's
     * boundary may be changed to accommodate the new GraphNode value.
     * </p>
     * @throws IllegalGraphElementException
     *             if the contained graphNode is incorrect
     */
    public void notifyEnumerationLiteralVisibilityChange() {
        notifyGraphNodeChange("EnumerationLiteralCompartment's visibility is changed.");
    }
}
