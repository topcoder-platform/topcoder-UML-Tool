/*
 * Copyright (C) 2007 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.gui.diagramviewer.uml.activityelements;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Point;
import java.awt.Rectangle;
import java.util.Collection;
import java.util.List;
import java.util.Map;

import com.topcoder.diagraminterchange.DiagramElement;
import com.topcoder.diagraminterchange.GraphEdge;
import com.topcoder.diagraminterchange.GraphElement;
import com.topcoder.diagraminterchange.GraphNode;
import com.topcoder.diagraminterchange.SemanticModelBridge;
import com.topcoder.diagraminterchange.SimpleSemanticModelElement;
import com.topcoder.diagraminterchange.Uml1SemanticModelBridge;
import com.topcoder.gui.diagramviewer.elements.SelectionCorner;
import com.topcoder.gui.diagramviewer.uml.activityelements.event.BoundaryChangedEvent;
import com.topcoder.uml.model.core.Element;
import com.topcoder.uml.model.core.ModelElement;
import com.topcoder.uml.model.core.extensionmechanisms.Stereotype;
import com.topcoder.uml.model.statemachines.Transition;

/**
 * <p>
 * This is a helper class for the component to check argument.
 * </p>
 * @author TCSDEVELOPER, TCSDEVELOPER
 * @version 1.0
 */
final class Util {

    /**
     * <p>
     * The private constructor prevents creation.
     * </p>
     */
    private Util() {
        // do nothing
    }

    /**
     * <p>
     * Checks whether the given argument is <code>null</code>.
     * </p>
     * @param argument
     *            the argument to be checked
     * @param name
     *            the name of the argument
     * @throws IllegalArgumentException
     *             if the argument is <code>null</code>
     */
    static void checkNotNull(Object argument, String name) {
        if (argument == null) {
            throw new IllegalArgumentException(name + " should not be null.");
        }
    }

    /**
     * <p>
     * Checks whether the given argument is <code>null</code> or empty string.
     * </p>
     * @param argument
     *            the argument to be checked
     * @param name
     *            the name of the argument
     * @throws IllegalArgumentException
     *             if the argument is <code>null</code> or empty string
     */
    static void checkNotNullOrEmptyString(String argument, String name) {
        checkNotNull(argument, name);
        if (argument.trim().length() == 0) {
            throw new IllegalArgumentException(name + " should not be empty string.");
        }
    }

    /**
     * <p>
     * Checks whether the given map is <code>null</code> or empty or contains <code>null</code> element.
     * </p>
     * @param map
     *            the map to be checked
     * @param name
     *            the name of the map
     * @throws IllegalArgumentException
     *             if the map is <code>null</code> or empty or contains <code>null</code> element.
     */
    static void chekMapNotNullOrContainingEmpty(Map<String, String> map, String name) {
        checkNotNull(map, name);
        for (String key : map.keySet()) {
            checkNotNullOrEmptyString(key, "key of map");
        }
        for (String value : map.values()) {
            checkNotNullOrEmptyString(value, "value of map");
        }
    }

    /**
     * <p>
     * Check the structure of the GraphEdge that corresponds to a Transition.
     * </p>
     * @param graphEdge
     *            the GraphEdge need checking
     * @throws IllegalGraphElementException
     *             if given GraphNode has bad structure
     */
    static void checkGraphEdge(GraphEdge graphEdge) {
        validateSemanticModel(graphEdge, Transition.class);
        List<DiagramElement> elements = graphEdge.getContaineds();
        if (elements.size() != 3) {
            throw new IllegalGraphElementException(graphEdge, "Should contain two elements.");
        }
        validateElementTypeInfo(graphEdge, elements.get(0), "Name");
        validateElementTypeInfo(graphEdge, elements.get(1), "TransitionDescription");
        validateElementTypeInfo(graphEdge, elements.get(2), "StereotypeCompartment");
    }

    /**
     * <p>
     * Check the structure of the GraphNode that corresponds to an InitialNode, ForkNode, JoinNode, DecisionNode,
     * MergeNode, FlowFinalNode, and FinalNode.
     * </p>
     * @param graphNode
     *            the GraphNode need checking
     * @param modelType
     *            the uml element type of the root graph element, can be null
     * @throws IllegalGraphElementException
     *             if given GraphNode has bad structure
     */
    static void checkNodeGraphNode(GraphNode graphNode, Class<?> modelType) {
        validateSemanticModel(graphNode, modelType);
        List<DiagramElement> elements = graphNode.getContaineds();
        if (elements.size() != 2) {
            throw new IllegalGraphElementException(graphNode, "Should contain two elements.");
        }
        validateElementTypeInfo(graphNode, elements.get(0), "StereotypeCompartment");
        validateElementTypeInfo(graphNode, elements.get(1), "Name");
    }

    /**
     * <p>
     * Check the structure of the GraphNode that corresponds to an ObjectFlowNode, ActionState, SendSignalAction, and
     * AcceptEventAction
     * </p>
     * @param graphNode
     *            the GraphNode need checking
     * @param modelType
     *            the uml element type of the root graph element, can be null
     * @throws IllegalGraphElementException
     *             if given GraphNode has bad structure
     */
    static void checkActionGraphNode(GraphNode graphNode, Class<?> modelType) {
        validateSemanticModel(graphNode, modelType);
        List<DiagramElement> elements = graphNode.getContaineds();
        validateSubElementCount(graphNode, elements, 1);
        validateElementTypeInfo(graphNode, elements.get(0), "NameCompartment");

        GraphElement element = (GraphElement) elements.get(0);
        List<DiagramElement> subElements = element.getContaineds();
        validateSubElementCount(element, subElements, 1);
        validateElementTypeInfo(element, subElements.get(0), "NameAndType");

        element = (GraphElement) subElements.get(0);
        subElements = element.getContaineds();
        validateElementTypeInfo(element, subElements.get(0), "Name");
    }

    /**
     * <p>
     * Validates the sub element count of given GraphElement.
     * </p>
     * @param element
     *            the GraphElement need to be validated
     * @param subElements
     *            sub elements list of given GraphElement
     * @throws IllegalGraphElementException
     *             if validation fails
     */
    private static void validateSubElementCount(GraphElement element, List<DiagramElement> subElements, int count) {
        if (subElements.size() != count) {
            throw new IllegalGraphElementException(element, "Should contain " + count + " elements.");
        }
    }

    /**
     * <p>
     * Validate given GraphElement semantic model.
     * </p>
     * @param graphElement
     *            the GraphElement need to be validated
     * @throws IllegalGraphElementException
     *             if validation fails
     */
    private static void validateSemanticModel(GraphElement graphElement, Class<?> modelType) {
        SemanticModelBridge sematicModel = graphElement.getSemanticModel();
        // The associated SematicModelBridge instance is required
        if (sematicModel == null) {
            throw new IllegalGraphElementException(graphElement, "The associated SematicModelBridge is missing.");
        }

        // The type of the associated SematicModelBridge instance is Uml1SemanticModelBridge
        if (!(sematicModel instanceof Uml1SemanticModelBridge)) {
            throw new IllegalGraphElementException(graphElement,
                    "The associated SematicModelBridge should be of Uml1SemanticModelBridge type.");
        }
        // The associated Element is checked
        if (modelType != null) {
            Uml1SemanticModelBridge umlSematicModel = (Uml1SemanticModelBridge) sematicModel;
            Element modelElement = umlSematicModel.getElement();

            // Null is not allowed
            if (modelElement == null) {
                throw new IllegalGraphElementException(graphElement,
                        "No UML model element is associated with the Uml1SemanticModelBridge.");
            }

            // check the class type
            if (!modelType.isAssignableFrom(modelElement.getClass())) {
                throw new IllegalGraphElementException(graphElement,
                        "The uml model element type is not the same, it should be " + modelType + ", instead of "
                                + modelElement.getClass());
            }
        }
    }

    /**
     * <p>
     * Validate type information of given DiagramElement contained by given GraphElement.
     * </p>
     * @param graphElement
     *            the GraphElement need to be validated
     * @param subElem
     *            element contained by given GraphElement
     * @param typeInfo
     *            the required type information
     * @throws IllegalGraphElementException
     *             if validation fails
     */
    private static void validateElementTypeInfo(GraphElement graphElement, DiagramElement subElem, String typeInfo) {
        if (subElem == null) {
            throw new IllegalGraphElementException(graphElement, "The sub element is missing.");
        }
        if (!(subElem instanceof GraphElement)) {
            throw new IllegalGraphElementException(graphElement, "The sub element should be GraphElement instance.");
        }
        SemanticModelBridge bridge = ((GraphElement) subElem).getSemanticModel();
        if (!(bridge instanceof SimpleSemanticModelElement)) {
            throw new IllegalGraphElementException(graphElement,
                    "The sub element should have a SimpleSemanticModelElement attribute.");
        }
        if (!((SimpleSemanticModelElement) bridge).getTypeInfo().equals(typeInfo)) {
            throw new IllegalGraphElementException(graphElement, "The sub element should be type" + typeInfo + ".");
        }
    }

    /**
     * <p>
     * Check whether given point is contained by compartments of given BaseNode.
     * </p>
     * @param node
     *            the node which compartments need checking
     * @param x
     *            the x coordinate of the point
     * @param y
     *            the y coordinate of the point
     * @return true if any compartment contains (x,y)
     */
    static boolean containedByCompartments(BaseNode node, int x, int y) {
        // Check the stereotype compartment
        TextField stereotypeCompartment = node.getStereotypeCompartment();
        if (stereotypeCompartment.isVisible()) {
            if (stereotypeCompartment.getBounds().contains(x, y)) {
                return true;
            }
        }
        // Check the name compartment
        TextField nameCompartment = node.getNameCompartment();
        if (nameCompartment.isVisible()) {
            if (nameCompartment.getBounds().contains(x, y)) {
                return true;
            }
        }
        return false;
    }

    /**
     * <p>
     * Gets the size of GraphNode.
     * </p>
     * @param graphNode
     *            the GraphNode
     * @return the size of given GraphNode
     * @throws IllegalGraphElementException
     *             if the structure of graphNode is invalid
     */
    static Dimension getGraphNodeSize(GraphNode graphNode) {
        Dimension d = new Dimension();
        if (graphNode.getSize() == null) {
            throw new IllegalGraphElementException(graphNode, "Size of given GraphNode is null.");
        }
        d.width = Math.round((float) (graphNode.getSize().getWidth()));
        d.height = Math.round((float) (graphNode.getSize().getHeight()));
        return d;
    }

    /**
     * <p>
     * Gets the position of corresponding GraphNode.
     * </p>
     * @return the position of the GraphNode
     * @throws IllegalGraphElementException
     *             if the structure of graphNode is invalid
     */
    static Point getGraphNodePosition(GraphNode graphNode) {
        // The visual node's position is relative value, need to get the absolute position of the visual node
        double x = 0;
        double y = 0;
        for (GraphElement node = graphNode; node.getContainer() != null; node = node.getContainer()) {
            if (node.getPosition() == null) {
                throw new IllegalGraphElementException(graphNode, "Position of GraphNode is null.");
            }
            x += node.getPosition().getX();
            y += node.getPosition().getY();
        }
        return new Point(Math.round((float) x), Math.round((float) y));
    }

    /**
     * <p>
     * Rearrange the node and its compartments for InitialNode, ForkNode, JoinNode, DecisionNode, MergeNode,
     * FlowFinalNode, and FinalNode.
     * </p>
     * @param message
     *            telling how graphNode is changed, could be null
     * @param node
     *            the BaseNode to be rearranged
     */
    static void rearrangeNode(String message, BaseNode node) {
        Rectangle oldRectangle = node.getBounds();
        Point position = Util.getGraphNodePosition(node.getGraphNode());
        Dimension d = Util.getGraphNodeSize(node.getGraphNode());

        TextField stereotypeCompartment = node.getStereotypeCompartment();
        String stereotypeText = getStereotypeCompartment(node.getGraphNode());
        GraphNode stereotype = (GraphNode) node.getGraphNode().getContaineds().get(0);
        if (stereotypeCompartment == null) {
            stereotypeCompartment = createCompartment(node, stereotypeText, stereotype);
            node.setStereotypeCompartment(stereotypeCompartment);
        }
        stereotypeCompartment.setText(stereotypeText);
        stereotypeCompartment.setVisible(stereotype.isVisible());

        TextField nameCompartment = node.getNameCompartment();
        String nameText = getElement(node.getGraphNode()).getName();
        GraphNode name = (GraphNode) node.getGraphNode().getContaineds().get(1);
        if (nameCompartment == null) {
            nameCompartment = createCompartment(node, nameText, name);
            node.setNameCompartment(nameCompartment);
        }
        nameCompartment.setText(nameText);
        nameCompartment.setVisible(name.isVisible());

        // update font and font color for compartments
        Font font = node.getFont();
        Color fontColor = node.getFontColor();
        // Set font color
        stereotypeCompartment.setFontColor(fontColor);
        nameCompartment.setFontColor(fontColor);
        // Set font
        stereotypeCompartment.setFont(font);
        nameCompartment.setFont(font);

        Dimension stereotypeSize = stereotypeCompartment.getPreferredSize();
        Point stereotypePos = new Point();
        stereotypePos.x = (int) Math.round(position.x + (d.width - stereotypeSize.width) * 0.5);
        stereotypePos.y = position.y - stereotypeSize.height;
        Point location = new Point(position);
        Dimension size = new Dimension(d);
        if (stereotype.isVisible()) {
            if (stereotypePos.x < location.x) {
                location.x = stereotypePos.x;
            }
            location.y = stereotypePos.y;
            if (stereotypeSize.width > size.width) {
                size.width = stereotypeSize.width;
            }
            size.height += stereotypeSize.height;
        }
        Dimension nameSize = nameCompartment.getPreferredSize();
        Point namePos = new Point();
        namePos.x = (int) Math.round(position.x + (d.width - nameSize.width) * 0.5);
        namePos.y = position.y + d.height;
        if (name.isVisible()) {
            if (namePos.x < location.x) {
                location.x = namePos.x;
            }
            if (nameSize.width > size.width) {
                size.width = nameSize.width;
            }
            size.height += nameSize.height;
        }
        updateNodeBound(node, location, size);

        // Relocate and resize the compartments, relative to the node
        rearrangeCompartments(node, stereotypePos, stereotypeSize, namePos, nameSize);

        // Trigger the boundary change event
        Rectangle newRectangle = node.getBounds();
        if (!oldRectangle.equals(newRectangle)) {
            BoundaryChangedEvent event = new BoundaryChangedEvent(node, message, oldRectangle, newRectangle);
            node.fireBoundaryChanged(event);
        }
    }

    /**
     * <p>
     * Creates a TextField compartment.
     * </p>
     * @param node
     *            BaseNode which contains the created text field
     * @param text
     *            compartment text
     * @param graphNode
     *            corresponding graph node
     * @return a TextField compartment created
     */
    private static TextField createCompartment(BaseNode node, String text, GraphNode graphNode) {
        TextField compartment = new TextField(graphNode);
        compartment.setFontColor(node.getFontColor());
        compartment.setText(text);
        compartment.setVisible(graphNode.isVisible());
        compartment.setFont(node.getFont());
        return compartment;
    }

    /**
     * <p>
     * Relocates and resizes the compartment.
     * </p>
     * @param compartment
     *            the compartment to be arranged
     * @param location
     *            new location of compartment
     * @param size
     *            the size of corresponding compartment
     */
    static void arrangeCompartment(TextField compartment, Point location, Dimension size) {
        compartment.setLocation(location);
        compartment.setSize(size);
    }

    /**
     * <p>
     * Update given node's boundary.
     * </p>
     * @param node
     *            the BaseNode to be rearranged
     * @param location
     *            initial location, should be recomputed with selection corners
     * @param size
     *            initial size, should be recomputed with selection corners
     */
    private static void updateNodeBound(BaseNode node, Point location, Dimension size) {
        Point position = Util.getGraphNodePosition(node.getGraphNode());
        Dimension d = Util.getGraphNodeSize(node.getGraphNode());

        location.x -= SelectionCorner.DEFAULT_RADIUS * 2;
        location.y -= SelectionCorner.DEFAULT_RADIUS * 2;
        size.width += SelectionCorner.DEFAULT_RADIUS * 4;
        size.height += SelectionCorner.DEFAULT_RADIUS * 4;

        node.setLocation(location);
        node.setSize(size);

        Point relative = new Point(position);
        relative.x -= location.x;
        relative.y -= location.y;
        node.setRelativePosition(relative);
        node.setSelectionBound(new Rectangle(relative, d));
    }

    /**
     * <p>
     * Resizes and relocates given node for ObjectFlowNode, ActionState, SendSignalAction, and AcceptEventAction.
     * </p>
     * @param message
     *            telling how graphNode is changed, could be null
     * @param node
     *            the BaseNode to be rearranged
     */
    static void rearrangeAction(String message, BaseNode node) {
        Rectangle oldRectangle = node.getBounds();
        Point position = Util.getGraphNodePosition(node.getGraphNode());
        Dimension d = Util.getGraphNodeSize(node.getGraphNode());

        TextField stereotypeCompartment = node.getStereotypeCompartment();
        /*
         * BugFix: BUGID UML-7598
         * Description:
         * The display text for the name and stereotype compartments should be retrieved from the model element.
         * The text field should be set visible or invisible according to he text.
         * Solution:
         * Retrieve the text from model element, and set the text field invisible if the text is empty, otherwise
         * visible.
         */
        // old code
//        String stereotypeText = "";
//        GraphNode stereotype;
//        stereotypeText = getStereotypeCompartment(node.getGraphNode());
//        // TODO StereotypeCompartment is not present in the GraphNode structure of these node, So we can't fetch
//        // the location and size of stereotypeCompartment. Here maybe we set a wrong text field, improvement will be
//        // made in future.
//        stereotype = node.getGraphNode();
//        stereotypeCompartment = createCompartment(node, stereotypeText, stereotype);
//        node.setStereotypeCompartment(stereotypeCompartment);
        String stereotypeText = getStereotypeCompartment(node.getGraphNode());
        GraphNode stereotype;
        if (stereotypeCompartment == null) {
            // TODO StereotypeCompartment is not present in the GraphNode structure of these node, So we can't fetch
            // the location and size of stereotypeCompartment. Here maybe we set a wrong text field, improvement will be
            // made in future.
            stereotype = new GraphNode();
            stereotype.setVisible(true);
            stereotypeCompartment = createCompartment(node, stereotypeText, stereotype);
            node.setStereotypeCompartment(stereotypeCompartment);
        }
        stereotype = stereotypeCompartment.getGraphNode();
        stereotypeCompartment.setText(stereotypeText);
        stereotypeCompartment.setVisible(stereotype.isVisible());

        TextField nameCompartment = node.getNameCompartment();
        /*
         * BugFix: BUGID UML-7598
         * Description:
         * The display text for the name and stereotype compartments should be retrieved from the model element.
         * The text field should be set visible or invisible according to he text.
         * Solution:
         * Retrieve the text from model element, and set the text field invisible if the text is empty, otherwise
         * visible.
         */
        // old code
//        String nameText = "";
//        GraphNode name;
//        nameText = getElement(node.getGraphNode()).getName();
//        name = (GraphNode) node.getGraphNode().getContaineds().get(0);
//        nameCompartment = createCompartment(node, nameText, name);
//        node.setNameCompartment(nameCompartment);
        String nameText = getElement(node.getGraphNode()).getName();
        GraphNode name = (GraphNode) node.getGraphNode().getContaineds().get(0);
        if (nameCompartment == null) {
            nameCompartment = createCompartment(node, nameText, name);
            node.setNameCompartment(nameCompartment);
        }
        nameCompartment.setText(nameText);
        nameCompartment.setVisible(name.isVisible());

        Dimension stereotypeSize = stereotypeCompartment.getPreferredSize();
        Point stereotypePos = new Point(position);
        stereotypePos.x = (int) Math.round(position.x + (d.width - stereotypeSize.width) * 0.5);

        Dimension nameSize = nameCompartment.getPreferredSize();
        Point namePos = new Point(position);
        namePos.x = (int) Math.round(position.x + (d.width - nameSize.width) * 0.5);

        if (stereotype.isVisible() && name.isVisible()) {
            int height = stereotypeSize.height + nameSize.height;
            stereotypePos.y = (int) Math.round(position.y + (d.height - height) * 0.5);
            namePos.y = (int) Math.round(position.y + (d.height - height) * 0.5 + stereotypeSize.height);
        } else if (stereotype.isVisible() && !name.isVisible()) {
            stereotypePos.y = (int) Math.round(position.y + (d.height - stereotypeSize.height) * 0.5);
        } else if (!stereotype.isVisible() && name.isVisible()) {
            namePos.y = (int) Math.round(position.y + (d.height - nameSize.height) * 0.5);
        }

        /*
         * BugFix: BUGID UML-7598
         * Description:
         * The font and font color should be used.
         * Solution:
         * Set the font and font color to text fields.
         */
        // update font and font color for compartments
        Font font = node.getFont();
        Color fontColor = node.getFontColor();
        // Set font color
        stereotypeCompartment.setFontColor(fontColor);
        nameCompartment.setFontColor(fontColor);
        // Set font
        stereotypeCompartment.setFont(font);
        nameCompartment.setFont(font);

        Point location = new Point(position);
        // To get a new preferred size for node, set the compartments temporarily
        arrangeCompartment(stereotypeCompartment, stereotypePos, stereotypeSize);
        arrangeCompartment(nameCompartment, namePos, nameSize);
        Dimension size = node.getPreferredGraphNodeSize();
        if (size.width < d.width) {
            size.width = d.width;
        } else {
            location.x = (int) Math.round(position.x + (d.width - size.width) * 0.5);
        }
        if (size.height < d.height) {
            size.height = d.height;
        } else {
            location.y = (int) Math.round(position.y + (d.height - size.height) * 0.5);
        }
        setGraphNode(node, location, size);
        updateNodeBound(node, location, size);

        // Relocate and resize the compartments, relative to the node
        rearrangeCompartments(node, stereotypePos, stereotypeSize, namePos, nameSize);

        // Trigger the boundary change event
        Rectangle newRectangle = node.getBounds();
        if (!oldRectangle.equals(newRectangle)) {
            BoundaryChangedEvent event = new BoundaryChangedEvent(node, message, oldRectangle, newRectangle);
            node.fireBoundaryChanged(event);
        }
    }

    /**
     * <p>
     * Relocates and resizes the compartments, relative to the node.
     * </p>
     * @param node
     *            the BaseNode to be rearranged
     * @param stereotypePos
     *            stereotype compartment position, should be recomputed relative to the node
     * @param stereotypeSize
     *            stereotype compartment size
     * @param namePos
     *            name compartment position, should be recomputed relative to the node
     * @param nameSize
     *            name compartment size
     */
    private static void rearrangeCompartments(BaseNode node, Point stereotypePos, Dimension stereotypeSize,
            Point namePos, Dimension nameSize) {
        stereotypePos.x -= node.getLocation().x;
        stereotypePos.y -= node.getLocation().y;
        namePos.x -= node.getLocation().x;
        namePos.y -= node.getLocation().y;
        arrangeCompartment(node.getStereotypeCompartment(), stereotypePos, stereotypeSize);
        arrangeCompartment(node.getNameCompartment(), namePos, nameSize);
    }

    /**
     * <p>
     * Sets graph node position and size for given BaseNode.
     * </p>
     * @param node
     *            the BaseNode to be set
     * @param location
     *            swing position of graph node
     * @param size
     *            size of graph node
     */
    private static void setGraphNode(BaseNode node, Point location, Dimension size) {
        Point position = getGraphNodePosition(node.getGraphNode());
        com.topcoder.diagraminterchange.Point oldPosition = node.getGraphNode().getPosition();
        com.topcoder.diagraminterchange.Point newPosition = new com.topcoder.diagraminterchange.Point();
        double x = oldPosition != null ? oldPosition.getX() : 0;
        double y = oldPosition != null ? oldPosition.getY() : 0;
        newPosition.setX(x + location.x - position.x);
        newPosition.setY(y + location.y - position.y);
        node.getGraphNode().setPosition(newPosition);
        com.topcoder.diagraminterchange.Dimension newSize = new com.topcoder.diagraminterchange.Dimension();
        newSize.setWidth(size.width);
        newSize.setHeight(size.height);
        node.getGraphNode().setSize(newSize);
    }

    /**
     * <p>
     * Gets a preferred size to contain given two compartments. At least one compartment is visible.
     * </p>
     * @param stereotypeCompartment
     *            stereotype compartment of node
     * @param nameCompartment
     *            name compartment of node
     * @return a preferred size for containing given two compartments
     */
    static Dimension getPreferredCompartmentsSize(TextField stereotypeCompartment, TextField nameCompartment) {
        if (stereotypeCompartment.isVisible() && !nameCompartment.isVisible()) {
            return stereotypeCompartment.getPreferredSize();
        }
        if (!stereotypeCompartment.isVisible() && nameCompartment.isVisible()) {
            return nameCompartment.getPreferredSize();
        }
        Dimension stereotypeSize = stereotypeCompartment.getPreferredSize();
        Dimension nameSize = nameCompartment.getPreferredSize();
        Dimension d = new Dimension();
        d.width = Math.max(stereotypeSize.width, nameSize.width);
        d.height = stereotypeSize.height + nameSize.height;
        return d;
    }

    /**
     * <p>
     * Returns the stereotype compartment text of given <code>GraphElement</code>.
     * </p>
     * @param graphElement
     *            the <code>GraphElement</code> which stereotype compartment text is returned
     * @return the text of the stereotype compartment of given <code>GraphElement</code>
     */
    public static String getStereotypeCompartment(GraphElement graphElement) {

        ModelElement element = (ModelElement) ((Uml1SemanticModelBridge) graphElement.getSemanticModel()).getElement();

        Collection<Stereotype> stereotypes = element.getStereotypes();

        StringBuffer stringBuffer = new StringBuffer();

        for (Stereotype stereotype : stereotypes) {
            stringBuffer.append(stereotype.getName());
            stringBuffer.append(", ");
        }
        if (stringBuffer.length() > 0) {
            stringBuffer.insert(0, " << ");
            // Replace the last comma
            stringBuffer.replace(stringBuffer.length() - 2, stringBuffer.length(), " >> ");
        }

        return stringBuffer.toString();
    }

    /**
     * <p>
     * Returns the <code>ModelElement</code> for given <code>GraphElement</code>.
     * </p>
     * @param graphElement
     *            the <code>GraphElement</code> which <code>ModelElement</code> is returned
     * @return the <code>ModelElement</code> of given <code>GraphElement</code>
     */
    public static ModelElement getElement(GraphElement graphElement) {
        return ((ModelElement) (((Uml1SemanticModelBridge) graphElement.getSemanticModel()).getElement()));
    }
}
