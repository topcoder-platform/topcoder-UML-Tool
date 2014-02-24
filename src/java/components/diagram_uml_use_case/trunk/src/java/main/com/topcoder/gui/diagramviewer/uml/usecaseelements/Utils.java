/*
 * Copyright (C) 2007 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.gui.diagramviewer.uml.usecaseelements;

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
import com.topcoder.diagraminterchange.Property;
import com.topcoder.diagraminterchange.SemanticModelBridge;
import com.topcoder.diagraminterchange.Uml1SemanticModelBridge;
import com.topcoder.gui.diagramviewer.elements.Node;
import com.topcoder.gui.diagramviewer.elements.SelectionCorner;
import com.topcoder.gui.diagramviewer.elements.SelectionCornerType;
import com.topcoder.gui.diagramviewer.uml.usecaseelements.event.BoundaryChangedEvent;
import com.topcoder.uml.model.core.Element;
import com.topcoder.uml.model.core.ModelElement;
import com.topcoder.uml.model.core.Namespace;
import com.topcoder.uml.model.core.extensionmechanisms.Stereotype;
import com.topcoder.uml.model.modelmanagement.Model;
import com.topcoder.uml.model.modelmanagement.Subsystem;
import com.topcoder.uml.model.usecases.Actor;
import com.topcoder.uml.model.usecases.Extend;
import com.topcoder.uml.model.usecases.Include;
import com.topcoder.uml.model.usecases.UseCase;

/**
 * <p>
 * Helper class for this component.
 * </p>
 * <p>
 * <b>Thread Safety</b>: This class is immutable and so thread safe.
 * </p>
 *
 * @author maone, TCSDEVELOPER
 * @version 1.0
 */
public class Utils {
    /**
     * <p>
     * Represent all the eight selection corner types.
     * </p>
     */
    public static final SelectionCornerType[] DEFAULT_SELECTION_CORNER_TYPE = new SelectionCornerType[] {
        SelectionCornerType.NORTH, SelectionCornerType.NORTHWEST, SelectionCornerType.WEST,
        SelectionCornerType.SOUTHWEST, SelectionCornerType.SOUTH, SelectionCornerType.SOUTHEAST,
        SelectionCornerType.EAST, SelectionCornerType.NORTHEAST };

    /**
     * <p>
     * Represent the prefix of keyword metaclass.
     * </p>
     */
    private static final String STEREOTYPE_PREFIX = "<<";

    /**
     * <p>
     * Represent the postfix of keyword metaclass.
     * </p>
     */
    private static final String STEREOTYPE_POSTFIX = ">>";


    /**
     * <p>
     * Represents the regular expression that is used for validating a color string.
     * </p>
     */
    private static final String COLOR_REGEX = "[0-9a-fA-F]{6,6}";

    /**
     * <p>
     * This private constructor prevents to create a new instance.
     * </p>
     */
    private Utils() {
        // empty
    }

    /**
     * <p>
     * Checks whether the given Object is null.
     * </p>
     *
     * @param arg the argument to check
     * @param name the name of the argument to check
     * @throws IllegalArgumentException if the given Object is null
     */
    public static void checkNull(Object arg, String name) {
        if (arg == null) {
            throw new IllegalArgumentException(name + " should not be null.");
        }
    }

    /**
     * <p>
     * Checks whether the given properties contains null/empty element.
     * </p>
     *
     * @param properties the properties to check
     * @throws IllegalArgumentException if the given properties contains null/empty element
     */
    public static void checkValidProperties(Map<String, String> properties) {
        if (properties.containsKey(null)) {
            throw new IllegalArgumentException("properties contains null key");
        }
        if (properties.containsValue(null)) {
            throw new IllegalArgumentException("properties contains null value");
        }
        for (String str : properties.keySet()) {
            if (str.trim().length() == 0) {
                throw new IllegalArgumentException("properties contains empty key");
            }
            if (properties.get(str).trim().length() == 0) {
                throw new IllegalArgumentException("properties contains empty value");
            }
        }
    }

    /*
     * BugFix: UML-7167
     */
    // old code
//    /**
//     * <p>
//     * A helper method that calculate the minimum bounded rectangle of the given TextFields.
//     * </p>
//     * <p>
//     * If all the TextField is hidden, the Rectangle.x and Rectangle.y it return will be Integer.MAX_VALUE
//     * </p>
//     *
//     * @param textFields the array that contains textField
//     * @return the minimum bounded rect
//     * @throws IllegalArgumentException if textFields is null, or if textFields' size is 0
//     */
//    public static Rectangle getBoundedRect(TextField[] textFields) {
//        Utils.checkNull(textFields, "textFields");
//        if (textFields.length == 0) {
//            throw new IllegalArgumentException("the size of textFields should not be 0");
//        }
//        int x1 = Integer.MAX_VALUE;
//        int y1 = Integer.MAX_VALUE;
//        int x2 = Integer.MIN_VALUE;
//        int y2 = Integer.MIN_VALUE;
//
//        for (TextField textField : textFields) {
//            int x = textField.getLocation().x;
//            int y = textField.getLocation().y;
//            int width = textField.getSize().width;
//            int height = textField.getSize().height;
//            if (!textField.isVisible()) {
//                continue;
//            }
//            if (x < x1) {
//                x1 = x;
//            }
//            if (y < y1) {
//                y1 = y;
//            }
//            if (x + width > x2) {
//                x2 = x + width;
//            }
//            if (y + height > y2) {
//                y2 = y + height;
//            }
//        }
//        return new Rectangle(x1, y1, x2 - x1, y2 - y1);
//    }
    /**
     * <p>
     * A helper method that calculate the minimum bounded rectangle of the given TextFields.
     * </p>
     * <p>
     * If all the TextField is hidden, the Rectangle.x and Rectangle.y it return will be Integer.MAX_VALUE
     * </p>
     * @param textFields
     *            the array that contains textField
     * @return the minimum bounded size
     * @throws IllegalArgumentException
     *             if textFields is null, or if textFields' size is 0
     */
    public static Dimension getBoundedRect(TextField[] textFields) {
        Utils.checkNull(textFields, "textFields");
        if (textFields.length == 0) {
            throw new IllegalArgumentException("the size of textFields should not be 0");
        }

        Dimension size = new Dimension(0, 0);
        for (TextField textField : textFields) {
            if (textField.isVisible()) {
                size.width = Math.max(size.width, textField.getWidth());
                size.height += textField.getHeight();
            }
        }
        return size;
    }

    /**
     * <p>
     * A helper method to set the Node's size/relativePosition/selectionBound according to the graphNode.
     * </p>
     *
     * @param node the <code>Node</code> instance needed to be set
     * @param graphNode the <code>graphNode</code> instance provides the information
     * @throws IllegalArgumentException if any argument is null
     * @throws IllegalGraphElementException if the structure of graphNode is invalid.
     */
    public static void setNodeSizeRelativePosition(Node node, GraphNode graphNode) throws IllegalGraphElementException {
        Utils.checkNull(node, "node");
        Utils.checkNull(graphNode, "graphNode");
        try {
            node.setLocation(getAbsolutePosition(graphNode));
            node.setSize((int) Math.round(graphNode.getSize().getWidth()) + SelectionCorner.DEFAULT_RADIUS * 2,
                    (int) Math.round(graphNode.getSize().getHeight()) + SelectionCorner.DEFAULT_RADIUS * 2);
            node.setRelativePosition(new Point(SelectionCorner.DEFAULT_RADIUS, SelectionCorner.DEFAULT_RADIUS));
            node.setSelectionBound(new Rectangle(SelectionCorner.DEFAULT_RADIUS, SelectionCorner.DEFAULT_RADIUS,
                    (int) Math.round(graphNode.getSize().getWidth()),
                    (int) Math.round(graphNode.getSize().getHeight())));
        } catch (NullPointerException npe) {
            throw new IllegalGraphElementException(graphNode, "the structure of graphNode is invalid", npe);
        }
    }

    /**
     * <p>
     * The location is calculated according to the diagram hierarchy and the relative position.
     * </p>
     *
     * @param graphNode the left and top corner point of the graphNode to be calculated according to the diagram
     *            hierarchy and the relative position.
     * @throws IllegalArgumentException if <code>graphNode</code> is null
     * @return the absolute location point
     */
    public static Point getAbsolutePosition(GraphNode graphNode) {
        Utils.checkNull(graphNode, "graphNode");
        Point point = new Point();

        // the visual node's position is relative value, need to get the absolute position of the visual node
        double x = 0;
        double y = 0;

        /*
         * BugFix: UML-7165
         */
        // old code
//        GraphElement node = graphNode;
//        while (node != null) {
//            x += node.getPosition().getX();
//            y += node.getPosition().getY();
//            node = node.getContainer();
//        }
//
//        point.x = (int) Math.round(x) - SelectionCorner.DEFAULT_RADIUS;
//        point.y = (int) Math.round(y) - SelectionCorner.DEFAULT_RADIUS;
        GraphElement node = graphNode;
        while (node.getContainer() != null) {
            x += node.getPosition().getX();
            y += node.getPosition().getY();
            node = node.getContainer();
        }

        point.x = (int) Math.round(x);
        point.y = (int) Math.round(y);

        return point;
    }

    /**
     * <p>
     * This method loads a property from the properties inside the given <code>element</code> with the property name
     * <code>name</code>.
     * </p>
     * <p>
     * If the property doesn't exist, then null will be returned.
     * </p>
     * <p>
     * Note, if the given <code>element</code> or <code>name</code> is null, then null will be returned.
     * </p>
     *
     * @param element the <code>DiagramElement</code> instance to find the property
     * @param name the property name in the given <code>element</code>
     * @return the property value in String representation
     */
    public static String getStringProperty(DiagramElement element, String name) {
        if (element == null) {
            return null;
        }

        if (name == null) {
            return null;
        }

        Collection<Property> properties = element.getProperties();
        for (Property property : properties) {
            if (name.equals(property.getKey())) {
                return property.getValue();
            }
        }

        return null;
    }

    /**
     * <p>
     * Converts a color string to its corresponding Color instance.
     * </p>
     * <p>
     * If the color string is not valid, then null will be returned.
     * </p>
     * <p>
     * The color string format is <b>RRGGBB</b>
     * </p>
     *
     * @param colorString the color string
     * @return the Color instance that represents the given color string, it may be the default color if the given color
     *         string is not valid.
     */
    private static Color convertColor(String colorString) {
        if (!colorString.matches(COLOR_REGEX)) {
            return null;
        }

        int r = Integer.parseInt(colorString.substring(0, 2), 16);
        int g = Integer.parseInt(colorString.substring(2, 4), 16);
        int b = Integer.parseInt(colorString.substring(4, 6), 16);

        return new Color(r, g, b);
    }

    /**
     * <p>
     * This method loads a property from the properties inside the given <code>element</code> with the property name
     * <code>name</code>.
     * </p>
     * <p>
     * If the property doesn't exist, then null will be returned.
     * </p>
     *
     * @param element the <code>DiagramElement</code> instance to find the property
     * @param name the property name in the given <code>element</code>
     * @return the property value in Color representation
     */
    public static Color parseColorProperty(DiagramElement element, String name) {
        String value = getStringProperty(element, name);
        if (value != null) {
            return convertColor(value);
        }
        return null;
    }

    /**
     * <p>
     * This method loads a property from the properties inside the given <code>element</code> with the property name
     * <code>nameInDiagramElement</code>.
     * </p>
     * <p>
     * If the property doesn't exist, then the default value will be returned.
     * </p>
     *
     * @param element the <code>DiagramElement</code> instance to find the property
     * @param nameInDiagramElement the property name in the given <code>element</code>
     * @param defaultColor the default property color
     * @return the property value in Color representation
     */
    public static Color readColorProperty(DiagramElement element, String nameInDiagramElement, Color defaultColor) {
        Color color = Utils.parseColorProperty(element, nameInDiagramElement);
        if (color == null) {
            color = defaultColor;
        }
        return color;
    }

    /**
     * <p>
     * This method loads a property from the properties inside the given <code>element</code> with the property name
     * <code>nameInDiagramElement</code>.
     * </p>
     * <p>
     * If the property doesn't exist, then the default value will be returned.
     * </p>
     *
     * @param element the <code>DiagramElement</code> instance to find the property
     * @param nameInDiagramElement the property name in the given <code>element</code>
     * @param defaultDouble the default property double
     * @return the property value in Color representation
     */
    public static double readDoubleProperty(DiagramElement element, String nameInDiagramElement, double defaultDouble) {
        String value = Utils.getStringProperty(element, nameInDiagramElement);
        if (value != null) {
            try {
                return new Double(value);
            } catch (NumberFormatException e) {
                return defaultDouble;
            }
        }
        return defaultDouble;
    }

    /**
     * <p>
     * Compute the Projection Factor for the projection of the given point pt onto the line segment defined by given
     * start and end points.
     * </p>
     * <p>
     * The Projection Factor is computed as the following formula:
     *
     * <pre>
     *  project factor = (AC dot AB) / (||AB|| &circ; 2)
     * </pre>
     *
     * <b>C</b> is the given point <b>pt</b>, while <b>A</b> is the given start point and <b>B</b> is the given end
     * point.
     * <p>
     * <p>
     * The project factor has the following meaning:
     * <ul>
     * <li>r = 0 : P = A</li>
     * <li>r = 1 : P = B</li>
     * <li>r &lt; 0 : P is on the backward extension of AB</li>
     * <li>r &gt; 1 : P is on the forward extension of AB</li>
     * <li>0 &lt; r &lt; 1 : P is interior to AB</li>
     * </ul>
     * Note, <b>P</b> is the projected point of the given point <b>pt</b> on the segment (defined by <b>A</b> and
     * <b>B</b>)
     * </p>
     *
     * @param pt the point to get the closest point on the given segment
     * @param start the start point of the segment
     * @param stop the stop point of the segment
     * @return the project factor for the projection from the given point onto the line segment
     */
    private static double projectionFactor(Point pt, Point start, Point stop) {
        if (pt.equals(start)) {
            return 0.0;
        }

        if (pt.equals(stop)) {
            return 1.0;
        }

        double dx = stop.x - start.x;
        double dy = stop.y - start.y;

        // calculate the value of (||AB|| ^ 2)
        double len2 = dx * dx + dy * dy;

        // calculate the value of (AC dot AB) / (||AB|| ^ 2)
        return ((pt.x - start.x) * dx + (pt.y - start.y) * dy) / len2;
    }

    /**
     * <p>
     * Compute the closest point on given segment defined by the given start and end points to the given point.
     * </p>
     *
     * @param pt the point to get the closest point on the given segment
     * @param start the start point of the segment
     * @param stop the stop point of the segment
     * @param destPoint the closest point on the given segment to the given point
     * @return the closest distance from the given point to the given segment
     */
    public static double getClosestPoint(Point pt, Point start, Point stop, Point destPoint) {

        double factor = projectionFactor(pt, start, stop);

        // the closest point is interior to the segment
        if (factor > 0 && factor < 1) {
            double x = start.x + factor * (stop.x - start.x);
            double y = start.y + factor * (stop.y - start.y);

            destPoint.setLocation(x, y);
            return destPoint.distance(pt);
        }

        double dist1 = start.distance(pt);
        double dist2 = stop.distance(pt);

        // the closest point is the start point of the segment
        if (dist1 < dist2) {
            destPoint.setLocation(start);
            return dist1;
        }

        // the closest point is the end point of the segment
        destPoint.setLocation(stop);
        return dist2;
    }

    /**
     * <p>
     * Helper function that updates the TextField's size and location / visibility according to its graphNode.
     * </p>
     *
     * @param textField the TextField needs to be updated
     * @throws IllegalGraphElementException if the graphNode related to this TextField is incorrect
     */
    public static void updateTextFieldSizeLocation(TextField textField) throws IllegalGraphElementException {
        GraphNode graphNode = textField.getGraphNode();

        if (graphNode.isVisible()) {
            Dimension preferredSize = textField.getPreferredSize();
            if (textField.getWidth() < preferredSize.width) {
                textField.setSize(preferredSize);
            }

            textField.setVisible(true);
        } else {
            textField.setVisible(false);
        }
    }

    /**
     * <p>
     * Helper function that generates a stereotype string according to the given stereotypes.
     * </p>
     * <p>
     * If <code>keywordMetaclass</code> is null, it will be ignored.
     * If <code>stereotypes</code> is null, it will be ignored.
     * </p>
     *
     * @param keywordMetaclass the string of Keyword Metaclass
     * @param stereotypes the collection of stereotype
     * @return the stereotype string
     */
    public static String getStereotypeText(String keywordMetaclass, Collection<Stereotype> stereotypes) {
        String s = "";
        if (keywordMetaclass != null) {
            s = keywordMetaclass + ", ";
        }

        if (stereotypes != null) {
            for (Stereotype stereotype : stereotypes) {
                s += stereotype.getName() + ", ";
            }
        }

        String result = "";
        if (s.length() != 0) {
            s = s.substring(0, s.length() - 2);
            result = STEREOTYPE_PREFIX + s + STEREOTYPE_POSTFIX;
        }

        return result;
    }

    /**
     * <p>
     * Validates the sub element count of given GraphElement.
     * </p>
     * @param element
     *            the GraphElement need to be validated
     * @param subElements
     *            sub elements list of given GraphElement
     * @param count
     *            correct sub element count
     * @throws IllegalGraphElementException
     *             if validation fails
     */
    private static void validateSubElementCount(GraphElement element, List<DiagramElement> subElements, int count) {
        if (subElements == null) {
            throw new IllegalGraphElementException(element, "The graph element should have contained list.");
        }
        if (subElements.size() != count) {
            throw new IllegalGraphElementException(element, "The graph element should contain " + count + " elements.");
        }
    }

    /**
     * <p>
     * Validate given GraphElement semantic model.
     * </p>
     * @param graphElement
     *            the GraphElement need to be validated
     * @param modelType
     *            the uml element type of the root graph element, can be null
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
     * Checks the structure of the GraphNode that corresponds to an ActorNode.
     * </p>
     * @param graphNode
     *            the GraphNode need checking
     * @throws IllegalGraphElementException
     *             if given GraphNode has bad structure
     */
    private static void checkGraphNodeForActor(GraphNode graphNode) {
        validateSemanticModel(graphNode, Actor.class);
    }

    /**
     * <p>
     * Checks the structure of the GraphNode that corresponds to an UseCaseNode.
     * </p>
     * @param graphNode
     *            the GraphNode need checking
     * @throws IllegalGraphElementException
     *             if given GraphNode has bad structure
     */
    private static void checkGraphNodeForUseCase(GraphNode graphNode) {
        validateSemanticModel(graphNode, UseCase.class);
    }

    /**
     * <p>
     * Checks the graph node of given node.
     * </p>
     * @param node
     *            the node need checking
     * @throws IllegalGraphElementException
     *             if graph node has bad structure
     */
    static void checkGraphNode(BaseNode node) {
        if (node instanceof ActorNode) {
            checkGraphNodeForActor(node.getGraphNode());
        } else {
            checkGraphNodeForUseCase(node.getGraphNode());
        }
    }

    /**
     * <p>
     * Checks the structure of the GraphNode that corresponds to an SubsystemNodeContainer.
     * </p>
     * @param graphNode
     *            the GraphNode need checking
     * @throws IllegalGraphElementException
     *             if given GraphNode has bad structure
     */
    static void checkGraphNodeForSubsystem(GraphNode graphNode) {
        validateSemanticModel(graphNode, Subsystem.class);
    }

    /**
     * <p>
     * Checks the structure of the GraphEdge that corresponds to an BaseEdge.
     * </p>
     * @param graphEdge
     *            the GraphEdge need checking
     * @param modelType
     * @throws IllegalGraphElementException
     *             if given GraphEdge has bad structure
     */
    private static void checkGraphEdge(GraphEdge graphEdge, Class<?> modelType) {
        validateSemanticModel(graphEdge, modelType);
        List<DiagramElement> elements = graphEdge.getContaineds();
        validateSubElementCount(graphEdge, elements, 2);
    }

    /**
     * <p>
     * Checks the graph edge of given edge.
     * </p>
     * @param edge
     *            the edge need checking
     * @throws IllegalGraphElementException
     *             if graph edge has bad structure
     */
    static void checkGraphEdge(BaseEdge edge) {
        if (edge instanceof IncludeEdge) {
            checkGraphEdge(edge.getGraphEdge(), Include.class);
        } else if (edge instanceof ExtendEdge){
            checkGraphEdge(edge.getGraphEdge(), Extend.class);
        } else {
            GraphEdge graphEdge = edge.getGraphEdge();
            SemanticModelBridge sematicModel = graphEdge.getSemanticModel();
            // The associated SematicModelBridge instance is required
            if (sematicModel == null) {
                throw new IllegalGraphElementException(graphEdge, "The associated SematicModelBridge is missing.");
            }

            // The type of the associated SematicModelBridge instance is Uml1SemanticModelBridge
            if (!(sematicModel instanceof Uml1SemanticModelBridge)) {
                throw new IllegalGraphElementException(graphEdge,
                        "The associated SematicModelBridge should be of Uml1SemanticModelBridge type.");
            }
        }
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
     * Returns the <code>ModelElement</code> for given <code>GraphElement</code>.
     * </p>
     * @param graphElement
     *            the <code>GraphElement</code> which <code>ModelElement</code> is returned
     * @return the <code>ModelElement</code> of given <code>GraphElement</code>
     */
    static ModelElement getElement(GraphElement graphElement) {
        return ((ModelElement) (((Uml1SemanticModelBridge) graphElement.getSemanticModel()).getElement()));
    }

    /**
     * <p>
     * Gets the namespace text from a namespace compartment structure.
     * </p>
     * @param graphElement
     *            the namespace compartment graph element
     * @return the namespace text string
     */
    private static String getNamespace(GraphElement graphElement) {
        ModelElement element = getElement(graphElement);
        Namespace namespace = element.getNamespace();
        /*
         * BugFix: UML-9992
         * Get entire namespace.
         */
        // old code
//
//        if (namespace == null) {
//            return "";
//        }
//        if (namespace.getName() != null) {
//            return namespace.getName();
//        }
//        return "";
        String text = "";
        while (namespace != null && !(namespace instanceof Model)) {
            if (text == "") {
                text = namespace.getName();
            } else {
                text = namespace.getName() + "::" + text;
            }
            namespace = namespace.getNamespace();
        }
        return text;
    }


    /**
     * <p>
     * Updates node's compartments.
     * </p>
     * @param node
     *            the node whose compartments need updating
     */
    static void updateCompartments(Node node) {
        GraphNode graphNode = node.getGraphNode();

        TextField stereotype;
        TextField name;
        TextField namespace;

        Color fontColor;
        if (node instanceof SubsystemNodeContainer) {
            stereotype = ((SubsystemNodeContainer) node).getStereotypeCompartment();
            name = ((SubsystemNodeContainer) node).getNameCompartment();
            namespace = ((SubsystemNodeContainer) node).getNamespaceCompartment();
            fontColor = ((SubsystemNodeContainer) node).getFontColor();
        } else {
            stereotype = ((BaseNode) node).getStereotypeCompartment();
            name = ((BaseNode) node).getNameCompartment();
            namespace = ((BaseNode) node).getNamespaceCompartment();
            fontColor = ((BaseNode) node).getFontColor();
        }
        Font font = node.getFont();

        ModelElement modelElement = getElement(graphNode);

        String stereotypeText = Utils.getStereotypeText(null, modelElement.getStereotypes());
        stereotype.setText(stereotypeText);
        stereotype.setVisible(stereotype.getGraphNode().isVisible());

        String nameText = modelElement.getName();
        name.setText(nameText);
        name.setVisible(name.getGraphNode().isVisible());

        String namespaceText = getNamespace(graphNode);
        namespace.setText(namespaceText);
        namespace.setVisible(namespace.getGraphNode().isVisible());

        // Set font color
        stereotype.setFontColor(fontColor);
        name.setFontColor(fontColor);
        namespace.setFontColor(fontColor);

        // Set font
        stereotype.setFont(font);
        name.setFont(font);
        namespace.setFont(font);
    }

    /**
     * <p>
     * Update given node's boundary.
     * </p>
     * @param node
     *            the Node to be updated
     * @param newBound
     *            new boundary rectangle
     * @param selectionBound
     *            selection bound size
     * @param message
     *            message for boundary changed event, could be null
     */
    static void updateNodeBound(Node node, Rectangle newBound, Dimension selectionBound, String message) {
        Rectangle oldBound = node.getBounds();
        GraphNode graphNode = node.getGraphNode();
        Point positon = getAbsolutePosition(graphNode);
        Point relative = new Point(positon.x - newBound.x, positon.y - newBound.y);
        node.setRelativePosition(relative);
        node.setSelectionBound(new Rectangle(relative, selectionBound));
        node.setLocation(newBound.getLocation());
        node.setSize(newBound.getSize());

        // Trigger the boundary changed event if necessary
        if (!oldBound.equals(newBound)) {
            BoundaryChangedEvent event = new BoundaryChangedEvent(node, oldBound, newBound, message);
            if (node instanceof BaseNode) {
                ((BaseNode)node).fireBoundaryChange(event);
            } else {
                ((SubsystemNodeContainer)node).fireBoundaryChange(event);
            }
        }
    }
}
