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
import java.util.Map;

import javax.swing.SwingUtilities;

import com.topcoder.diagraminterchange.GraphNode;

/**
 * <p>
 * This class represents a Class node in UML diagram. It is an extension of BaseNode, which defines the most features
 * for a node. This class only provides some specific methods to support the unique shape of class, the mouse events
 * processing, and also the unique structure of class GraphNode.
 * </p>
 * <p>
 * This class is not thread safe, because the BaseNode class is not thread safe.
 * </p>
 * @author MiG-29, TCSDEVELOPER
 * @version 1.0
 */
public class ClassNode extends BaseNode {

    /**
     * <p>
     * Represents the attribute compartment's graph node index in the graph node structure.
     * </p>
     */
    private static final int ATTRIBUTE_INDEX = 2;

    /**
     * <p>
     * Represents the operation compartment's graph node index in the graph node structure.
     * </p>
     */
    private static final int OPERATION_INDEX = 4;

    /**
     * <p>
     * Represents the size of name compartment.
     * </p>
     */
    private Dimension nameSize;

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
     * Represents flag if node is markerd as external.
     * </p>
     */
    private boolean external;
    
    /**
     * <p>
     * Represents the default size of the node when it is marked as external
     * </p>
     */
    public static final Dimension DEFAULT_EXTERNAL_SIZE = new Dimension(150, 40);
    
    /**
     * <p>
     * Property used to indicate if component was already resized to default
     * size after it was marked as external
     * </p> 
     */
    private boolean externalResized;

    /**
     * Gets value of external property
     * @return
     */
    public boolean isExternal() {
		return external;
	}

    /**
     * sets value of external property
     * @param external new value
     */
	public void setExternal(boolean external) {
		this.external = external;
		externalResized = false;
	}

	/**
     * <p>
     * Creates a <code>ClassNode</code> instance.
     * </p>
     * @param graphNode
     *            the graphNode representing this ClassNode
     * @param properties
     *            the properties name mapping
     * @throws IllegalArgumentException
     *             if given graphNode or properties is null, or properties map contains null/empty element
     * @throws IllegalGraphElementException
     *             if the structure of graphNode is invalid
     */
    public ClassNode(GraphNode graphNode, Map<String, String> properties) {
        super(graphNode, properties, new TextField(Util.getCompartmentGraphNode(graphNode, 1)), new TextField(Util
                .getCompartmentGraphNode(graphNode, 0)), new TextField(Util.getCompartmentGraphNode(graphNode, 2)));

        // Create a connector for this instance
        setConnector(new ClassConnector(this));

        // Notify the ClassNode instance is created
        notifyGraphNodeChange("ClassNode instance created.");
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
         * BugFix: BUGID UML-8194
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
            if (c.isVisible()) {
                Point pt = SwingUtilities.convertPoint(this, x, y, c);
                if (c.contains(pt.x, pt.y)) {
                    return true;
                }
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
            Util.paintBaseNode(this, g, nameSize, null, attributeSize, operationSize);
        }
    }

    /**
     * <p>
     * Reloads diagram interchange information from contained graphNode.
     * </p>
     * @param message
     *            telling how graphNode is changed (could be null)
     * @throws IllegalGraphElementException
     *             if the structure of graphNode is invalid
     */
    public void notifyGraphNodeChange(String message) {
        Util.checkGraphNode(this);

        getAttributesCompartment().setItems(Util.getAttributes(this));
        getOperationsCompartment().setItems(Util.getOperations(this));

        notifyPropertiesChange();

        // Get selection corner radius
        int radius = getSelectionCorners().iterator().next().getRadius();

        // Calculate the preferred size for this node and its contained compartments
        calculateSize(radius, getGraphNode());

        /*
         * BugFix: BUGID UML-8194
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

        GraphNode attributesNode = (GraphNode) graphNode.getContaineds().get(ATTRIBUTE_INDEX);
        GroupTextField attributes = getAttributesCompartment();
        attributeSize = new Dimension(0, 0);
        attributes.setVisible(attributesNode.isVisible());
        if (attributesNode.isVisible()) {
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
            // Set properties to operation compartment
            Util.updateGroupProperties(this, operations);
            operationSize = operations.getPreferredSize();
            Util.combineSize(size, operationSize, false);
        }

        // Adjust to default if necessary
        compareWithDefault();
        /*
         * BugFix: BUGID UML-8194
         * Description:
         * In calculateSize, at the end of the method, the calculated size should also be compared with the user
         * defined size.
         * Solution:
         * Code is added to compare with the user defined size.
         */
        // Adjust to user defined if necessary
        compareWithUserDefined();
        
        //Adjust to external mode view
        compareWithExternalDefault();
    }

    /**
     * <p>
     * Compares the size with default size for external class.
     * </p>
     */
    private void compareWithExternalDefault() {
        if(isExternal() && !externalResized){
        	externalResized = true;;
        	size.height = DEFAULT_EXTERNAL_SIZE.height;
        	size.width = DEFAULT_EXTERNAL_SIZE.width;
        }
	}

	/*
     * BugFix: BUGID UML-8194
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
            /*
             * Bugfixe: UML-9704
             */
            // old code
//            // Enlarge the operation attribute compartment
//            operationSize.height += userDefined.height - size.height;
            if (getOperationsCompartment().isVisible()) {
                // Enlarge the operation compartment
                operationSize.height += userDefined.height - size.height;
            } else if (getAttributesCompartment().isVisible()) {
                // Enlarge the attribute compartment
                attributeSize.height += userDefined.height - size.height;
            } else {
                // Enlarge the name compartment
                nameSize.height += userDefined.height - size.height;
            }

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
            /*
             * Bugfixe: UML-9704
             */
            // old code
            // Enlarge the operation attribute compartment
            //operationSize.height += DEFAULT_MINIMUM_SIZE.height - size.height;
            if (getOperationsCompartment().isVisible()) {
                // Enlarge the operation compartment
                operationSize.height += DEFAULT_MINIMUM_SIZE.height - size.height;
            } else if (getAttributesCompartment().isVisible()) {
                // Enlarge the attribute compartment
                attributeSize.height += DEFAULT_MINIMUM_SIZE.height - size.height;
            } else {
                // Enlarge the name compartment
                nameSize.height += DEFAULT_MINIMUM_SIZE.height - size.height;
            }

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
        GroupTextField attributes = getAttributesCompartment();
        if (attributes.isVisible()) {
            // Update attribute items' location and size
            Util.updateGroupTextField(attributes, size.width);
            attributeSize.width = size.width;
            attributes.setLocation(radius, radius + nameSize.height);
            attributes.setSize(attributeSize);
        }
        GroupTextField operations = getOperationsCompartment();
        if (operations.isVisible()) {
            // Update operation items' location and size
            Util.updateGroupTextField(operations, size.width);
            operationSize.width = size.width;
            operations.setLocation(radius, radius + nameSize.height + attributeSize.height);
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
}
