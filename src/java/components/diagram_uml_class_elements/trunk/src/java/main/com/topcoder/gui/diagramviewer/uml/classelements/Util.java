/*
 * Copyright (C) 2007 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.gui.diagramviewer.uml.classelements;

import com.topcoder.diagraminterchange.DiagramElement;
import com.topcoder.diagraminterchange.GraphElement;
import com.topcoder.diagraminterchange.GraphNode;
import com.topcoder.diagraminterchange.Property;
import com.topcoder.diagraminterchange.SemanticModelBridge;
import com.topcoder.diagraminterchange.SimpleSemanticModelElement;
import com.topcoder.diagraminterchange.Uml1SemanticModelBridge;
import com.topcoder.gui.diagramviewer.edges.Edge;
import com.topcoder.gui.diagramviewer.elements.Node;
import com.topcoder.gui.diagramviewer.elements.SelectionCornerType;
import com.topcoder.gui.diagramviewer.uml.classelements.event.BoundaryChangedEvent;
import com.topcoder.gui.diagramviewer.uml.classelements.event.EdgeAddEvent;
import com.topcoder.gui.diagramviewer.uml.classelements.event.EditBoxTrigger;
import com.topcoder.uml.model.core.Attribute;
import com.topcoder.uml.model.core.Classifier;
import com.topcoder.uml.model.core.Element;
import com.topcoder.uml.model.core.Feature;
import com.topcoder.uml.model.core.ModelElement;
import com.topcoder.uml.model.core.Namespace;
import com.topcoder.uml.model.core.Operation;
import com.topcoder.uml.model.core.Parameter;
import com.topcoder.uml.model.core.classifiers.Enumeration;
import com.topcoder.uml.model.core.classifiers.EnumerationLiteral;
import com.topcoder.uml.model.core.classifiers.Interface;
import com.topcoder.uml.model.core.dependencies.Abstraction;
import com.topcoder.uml.model.core.extensionmechanisms.Stereotype;
import com.topcoder.uml.model.core.relationships.Generalization;
import com.topcoder.uml.model.datatypes.ParameterDirectionKind;
import com.topcoder.uml.model.datatypes.VisibilityKind;
import com.topcoder.uml.model.modelmanagement.Model;
import com.topcoder.uml.model.modelmanagement.Package;

import java.awt.*;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;

/**
 * <p>
 * This class defines utilities used in this component.
 * </p>
 * <p>
 * Its modified is set to <code>public</code> to avoid repeating create helper class for the sub-packages. Since it is
 * a helper class and does not change API, so it is allowed by TCS rules.
 * </p>
 * @author TCSDEVELOPER
 * @version 1.0
 */
public final class Util {
    /**
     * <p>
     * Represent the gap distance percent.
     * </p>
     */
    static final double GAP_PERCENT = 0.2;

    /**
     * <p>
     * Visibility token for public item.
     * </p>
     */
    private static final String VB_PUBLIC = "+";

    /**
     * <p>
     * Visibility token for protected item.
     * </p>
     */
    private static final String VB_PROTECTED = "#";

    /**
     * <p>
     * Visibility token for package item.
     * </p>
     */
    private static final String VB_PACKAGE = "~";

    /**
     * <p>
     * Visibility token for private item.
     * </p>
     */
    private static final String VB_PRIVATE = "-";

    /**
     * <p>
     * Default fill color for abstract class.
     * </p>
     */
    private static final Color DEFAULT_ABSTRACT_COLOR = new Color(191, 255, 128);

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
    public static void checkNotNull(Object argument, String name) {
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
     * Checks whether the given map is <code>null</code> or contains <code>null</code> or empty string element.
     * </p>
     * @param map
     *            the map to be checked
     * @param name
     *            the name of the map
     * @throws IllegalArgumentException
     *             if the map is <code>null</code>, or contains <code>null</code> or empty string element
     */
    static void checkMapNotNullOrContainingEmpty(Map<String, String> map, String name) {
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
     * Checks whether the given collection is <code>null</code> or contains <code>null</code> element.
     * </p>
     * @param collection
     *            the collection to be checked
     * @param name
     *            the name of the collection
     * @throws IllegalArgumentException
     *             if the collection is <code>null</code> or contains <code>null</code> element
     */
    static void checkCollectionNotNull(Collection collection, String name) {
        checkNotNull(collection, name);
        for (Object element : collection) {
            if (element == null) {
                throw new IllegalArgumentException(name + " should not contain null element.");
            }
        }
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
     * Validates the sub element count of given GraphElement is more than or equal to given count.
     * </p>
     * @param element
     *            the GraphElement need to be validated
     * @param subElements
     *            sub elements list of given GraphElement
     * @param count
     *            least sub element count
     * @throws IllegalGraphElementException
     *             if validation fails
     */
    private static void validateSubElementCountMoreThan(GraphElement element, List<DiagramElement> subElements,
            int count) {
        if (subElements == null) {
            throw new IllegalGraphElementException(element, "Should have contained list.");
        }
        if (subElements.size() < count) {
            throw new IllegalGraphElementException(element, "Should contain at least " + count + " elements.");
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
        /*
         * BugFix: BUGID UML-7583 Description: getTypeInfo should be changed to getTypeinfo to match the UML Tool
         * backend. Solution: Changed to getTypeinfo.
         */
        // old code
        // if (((SimpleSemanticModelElement) bridge).getTypeInfo() != typeInfo) {
        /*
         * BugFix: BUGID UML-9572 Description: When comparing two strings, use ".equals" instead of "!=". This is
         * causing problems when loading class diagrams. Solution: Use ".equals" instead.
         */
        // old code
        // if (((SimpleSemanticModelElement) bridge).getTypeinfo() != typeInfo) {
        if (!((SimpleSemanticModelElement) bridge).getTypeInfo().equals(typeInfo)) {
            throw new IllegalGraphElementException(graphElement, "The sub element should be type" + typeInfo + ".");
        }
    }

    /**
     * <p>
     * Validates the <code>graphElement</code> for name compartment graph node structure.
     * </p>
     * @param graphElement
     *            the GraphElement containing the desired name compartment graph node structure
     * @param subElement
     *            the desired name compartment graph node structure
     * @throws IllegalGraphElementException
     *             if validation fails
     */
    private static void validateNameCompartment(GraphElement graphElement, DiagramElement subElement) {
        validateElementTypeInfo(graphElement, subElement, "NameCompartment");
        GraphElement element = (GraphElement) subElement;
        List<DiagramElement> subElements = element.getContaineds();
        validateSubElementCount(element, subElements, 3);
        validateElementTypeInfo(element, subElements.get(0), "StereotypeCompartment");
        validateElementTypeInfo(element, subElements.get(1), "Name");
        validateElementTypeInfo(element, subElements.get(2), "NamespaceCompartment");
    }

    /**
     * <p>
     * Validates the <code>graphElement</code> for an attribute compartment graph node structure.
     * </p>
     * @param graphElement
     *            the GraphElement containing the desired attribute compartment graph node structure
     * @param subElem
     *            the desired attribute compartment graph node structure
     * @throws IllegalGraphElementException
     *             if validation fails
     */
    private static void validateAttributeCompartment(GraphElement graphElement, DiagramElement subElem) {
        validateElementTypeInfo(graphElement, subElem, "AttributeCompartment");
        GraphElement subGraphElement = (GraphElement) subElem;
        List<DiagramElement> contained = subGraphElement.getContaineds();
        validateSubElementCount(subGraphElement, contained, 1);
        validateElementTypeInfo(subGraphElement, contained.get(0), "DelimitedSection");
    }

    /**
     * <p>
     * Validates the <code>graphElement</code> for an operation compartment graph node structure.
     * </p>
     * @param graphElement
     *            the GraphElement containing the desired operation compartment graph node structure
     * @param subElem
     *            the desired operation compartment graph node structure
     * @throws IllegalGraphElementException
     *             if validation fails
     */
    private static void validateOperationCompartment(GraphElement graphElement, DiagramElement subElem) {
        validateElementTypeInfo(graphElement, subElem, "OperationCompartment");
        GraphElement subGraphElement = (GraphElement) subElem;
        List<DiagramElement> contained = subGraphElement.getContaineds();
        validateSubElementCount(subGraphElement, contained, 1);
        validateElementTypeInfo(subGraphElement, contained.get(0), "DelimitedSection");
    }

    /**
     * <p>
     * Validates the <code>graphElement</code> for EnumerationLiteralCompartment graph node structure.
     * </p>
     * @param graphElement
     *            the GraphElement containing the desired EnumerationLiteralCompartment graph node structure
     * @param subElem
     *            the desired EnumerationLiteralCompartment graph node structure
     * @throws IllegalGraphElementException
     *             if validation fails
     */
    private static void validateEnumerationLiteralCompartment(GraphElement graphElement, DiagramElement subElem) {
        validateElementTypeInfo(graphElement, subElem, "EnumerationLiteralCompartment");
        GraphElement subGraphElement = (GraphElement) subElem;
        List<DiagramElement> contained = subGraphElement.getContaineds();
        validateSubElementCount(subGraphElement, contained, 1);
        validateElementTypeInfo(subGraphElement, contained.get(0), "DelimitedSection");
    }

    /**
     * <p>
     * Checks the structure of the GraphNode that corresponds to a PackageNode.
     * </p>
     * @param graphNode
     *            the GraphNode need checking
     * @throws IllegalGraphElementException
     *             if given GraphNode has bad structure
     */
    static void checkPackageGraphNode(GraphNode graphNode) {
        validateSemanticModel(graphNode, Package.class);
        List<DiagramElement> elements = graphNode.getContaineds();
        /*
         * BugFix: BUGID UML-8188 Description: In checkPackageGraphNode, the sub element count may not be 2 because a
         * package node can contain many nodes. The code for validating sub-element counts should be removed. Solution:
         * Related code is commented.
         */
        // old code
        // validateSubElementCount(graphNode, elements, 2);
        // Check the sub graph node structure of NameCompartment
        validateNameCompartment(graphNode, elements.get(0));

        validateElementTypeInfo(graphNode, elements.get(1), "BodyCompartment");
    }

    /**
     * <p>
     * Checks the structure of the GraphNode that corresponds to a ClassNode or InterfaceNode, according to the given
     * type argument.
     * </p>
     * @param graphNode
     *            the GraphNode need checking
     * @param modelType
     *            the uml element type of the root graph element, should be Class.class or Interface.class
     * @throws IllegalGraphElementException
     *             if given GraphNode has bad structure
     */
    private static void checkClassOrIntefaceGraphNode(GraphNode graphNode, Class<?> modelType) {
        validateSemanticModel(graphNode, modelType);
        List<DiagramElement> elements = graphNode.getContaineds();
        validateSubElementCount(graphNode, elements, 5);
        // Check the sub graph node structure of NameCompartment
        validateNameCompartment(graphNode, elements.get(0));

        validateElementTypeInfo(graphNode, elements.get(1), "CompartmentSeparator");

        // Check the sub graph node structure of AttributeCompartment
        validateAttributeCompartment(graphNode, elements.get(2));

        validateElementTypeInfo(graphNode, elements.get(3), "CompartmentSeparator");

        // Check the sub graph node structure of OperationCompartment
        validateOperationCompartment(graphNode, elements.get(4));
    }

    /**
     * <p>
     * Checks the structure of the GraphNode that corresponds to a EnumerationNode.
     * </p>
     * @param graphNode
     *            the GraphNode need checking
     * @throws IllegalGraphElementException
     *             if given GraphNode has bad structure
     */
    private static void checkEnumerationGraphNode(GraphNode graphNode) {
        validateSemanticModel(graphNode, Enumeration.class);
        List<DiagramElement> elements = graphNode.getContaineds();
        validateSubElementCount(graphNode, elements, 7);

        // Check the sub graph node structure of NameCompartment
        validateNameCompartment(graphNode, elements.get(0));

        validateElementTypeInfo(graphNode, elements.get(1), "CompartmentSeparator");

        // Check the sub graph node structure of EnumerationLiteralCompartment
        validateEnumerationLiteralCompartment(graphNode, elements.get(2));

        validateElementTypeInfo(graphNode, elements.get(3), "CompartmentSeparator");

        // Check the sub graph node structure of AttributeCompartment
        validateAttributeCompartment(graphNode, elements.get(4));

        validateElementTypeInfo(graphNode, elements.get(5), "CompartmentSeparator");

        // Check the sub graph node structure of OperationCompartment
        validateOperationCompartment(graphNode, elements.get(6));
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
        if (node instanceof InterfaceNode) {
            checkClassOrIntefaceGraphNode(node.getGraphNode(), Interface.class);
        } else
        /*
         * BUGR-83
         * this part was deleted to make the behaviour of enumeration the same as
         * the behaviour of exception.
         */
        /* if (node instanceof EnumerationNode) {
            checkEnumerationGraphNode(node.getGraphNode());
        } else {
            checkClassOrIntefaceGraphNode(node.getGraphNode(), com.topcoder.uml.model.core.classifiers.Class.class);
        }*/
        checkClassOrIntefaceGraphNode(node.getGraphNode(), com.topcoder.uml.model.core.classifiers.Class.class);
    }

    /**
     * <p>
     * Parses font family string.
     * </p>
     * @param value
     *            a string which represents font family
     * @return font family value, "Arial" if given argument is null
     */
    static String parseFontFamily(String value) {
        if (value == null) {
            return "Arial";
        }
        return value;
    }

    /**
     * <p>
     * Parses font style string.
     * </p>
     * @param value
     *            a string which represents font style
     * @return font style value, 0 if given argument is null or incorrect
     */
    static int parseFontStyle(String value) {
        if (value == null) {
            return 0;
        }
        try {
            return Integer.parseInt(value);
        } catch (NumberFormatException e) {
            return 0;
        }
    }

    /**
     * <p>
     * Parses font size string.
     * </p>
     * @param value
     *            a string which represents font size
     * @return font size value, 11.0 if given argument is null or incorrect
     */
    static double parseFontSize(String value) {
        if (value == null) {
            return 11.0;
        }
        try {
            return Double.parseDouble(value);
        } catch (NumberFormatException e) {
            return 11.0;
        }
    }

    /**
     * <p>
     * Parses color property string.
     * </p>
     * @param value
     *            a six characters string which means RRGGBB value (like 0F0F0F)
     * @return a Color object, null if given argument is null or incorrect
     */
    static Color parseColor(String value) {
        if (value == null || value.length() != 6) {
            return null;
        }
        int hexValue;
        try {
            hexValue = Integer.parseInt(value, 16);
        } catch (NumberFormatException e) {
            return null;
        }
        return new Color(hexValue);
    }

    /**
     * <p>
     * Gets the property in GraphNode through predefined key.
     * </p>
     * @param graphNode
     *            the graph node containing properties
     * @param properties
     *            the property names defined in node.
     * @param key
     *            the predefined key
     * @return the property value in GraphNode, null if not found
     */
    static String getPropertyValue(GraphNode graphNode, Map<String, String> properties, String key) {
        String propertyKey = properties.get(key);
        if (propertyKey == null) {
            return null;
        }
        for (Property property : graphNode.getProperties()) {
            /*
             * BugFix: BUGID UML-7176 Description: The comparison of strings should use the ".equals" method, not "==".
             * Solution: Code is modified to use the ".equals" method instead.
             */
            // old code
            // if (property.getKey() == propertyKey) {
            if (property.getKey().equals(propertyKey)) {
                return property.getValue();
            }
        }
        return null;
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
     * Update given node's boundary.
     * </p>
     * @param node
     *            the Node to be updated
     * @param radius
     *            selection corner radius
     * @param size
     *            visual size, should be recomputed with selection corners
     * @param message
     *            message for boundary changed event, could be null
     */
    static void updateNodeBound(Node node, int radius, Dimension size, String message) {
        Rectangle oldBound = node.getBounds();
        node.setRelativePosition(new Point(radius, radius));
        node.setSelectionBound(new Rectangle(new Point(radius, radius), size));
        Point position = Util.getGraphNodePosition(node.getGraphNode());
        position.x -= radius;
        position.y -= radius;
        node.setLocation(position);
        node.setSize(size.width + radius * 2, size.height + radius * 2);
        Rectangle newBound = node.getBounds();

        // Trigger the boundary changed event if necessary
        if (!oldBound.equals(newBound)) {
            BoundaryChangedEvent event = new BoundaryChangedEvent(node, oldBound, newBound, message);
            if (node instanceof PackageNode) {
                ((PackageNode) node).fireBoundaryChanged(event);
            } else if (node instanceof BaseNode) {
                ((BaseNode) node).fireBoundaryChanged(event);
            }
        }
    }

    /**
     * <p>
     * Relocates and resizes the compartments, relative to the node, and sets their properties.
     * </p>
     * <p>
     * Please note: all compartments are aligned left in this method, their X coordinates should be updated later if
     * necessary.
     * </p>
     * @param node
     *            the Node to be rearranged
     * @param radius
     *            selection corner radius
     * @return the size to hold these compartments
     */
    static Dimension rearrangeCompartments(Node node, int radius) {
        Dimension size = new Dimension(0, 0);

        GraphNode graphNode = node.getGraphNode();
        TextField stereotype;
        TextField name;
        TextField namespace;

        Color fontColor;
        if (node instanceof PackageNode) {
            stereotype = ((PackageNode) node).getStereotypeCompartment();
            name = ((PackageNode) node).getNameCompartment();
            namespace = ((PackageNode) node).getNamespaceCompartment();
            fontColor = ((PackageNode) node).getFontColor();
        } else {
            stereotype = ((BaseNode) node).getStereotypeCompartment();
            name = ((BaseNode) node).getNameCompartment();
            namespace = ((BaseNode) node).getNamespaceCompartment();
            fontColor = ((BaseNode) node).getFontColor();
        }
        Font font = node.getFont();

        String stereotypeText = Util.getStereotype(graphNode);
        stereotype.setText(stereotypeText);
        stereotype.setVisible(stereotype.getGraphNode().isVisible());

        String nameText = Util.getName(graphNode);
        name.setText(nameText);
        name.setVisible(name.getGraphNode().isVisible());

        String namespaceText = Util.getNamespace(graphNode);
        namespace.setText(namespaceText);
        namespace.setVisible(namespace.getGraphNode().isVisible());

        // Set font color
        stereotype.setFontColor(fontColor);
        name.setFontColor(fontColor);
        namespace.setFontColor(fontColor);

        // Set font
        stereotype.setFont(font);
        if (node instanceof ClassNode) {
            Classifier classifer = (Classifier) getElement(graphNode);
            Font nameFont;
            if (classifer.isAbstract()) {
                nameFont = new Font(font.getName(), Font.ITALIC, font.getSize());
            } else {
                nameFont = new Font(font.getName(), Font.PLAIN, font.getSize());
            }
            name.setFont(nameFont);
        } else {
            name.setFont(font);
        }
        Font namespaceFont = new Font(font.getName(), Font.ITALIC, font.getSize());
        namespace.setFont(namespaceFont);

        // Please note: here all compartments are aligned left, their X coordinates should be updated later if
        // necessary.
        if (stereotype.isVisible()) {
            stereotype.setLocation(radius, radius);
            stereotype.setSize(stereotype.getPreferredSize());
            Util.combineSize(size, stereotype.getSize(), name.isVisible() || namespace.isVisible());
        }
        if (name.isVisible()) {
            name.setLocation(radius, size.height + radius);
            name.setSize(name.getPreferredSize());
            Util.combineSize(size, name.getSize(), namespace.isVisible());
        }
        if (namespace.isVisible()) {
            namespace.setLocation(radius, size.height + radius);
            namespace.setSize(namespace.getPreferredSize());
            Util.combineSize(size, namespace.getSize(), false);
        }
        return size;
    }

    /**
     * <p>
     * Updates given GroupTextField's properties.
     * </p>
     * @param node
     *            the node containing the compartment
     * @param groupTextField
     *            the GroupTextField which text fields need rearrangement
     */
    static void updateGroupProperties(BaseNode node, GroupTextField groupTextField) {
        groupTextField.setFont(node.getFont());
        groupTextField.setFillColor(getFillColor(node));
        groupTextField.setFontColor(node.getFontColor());
        groupTextField.setStrokeColor(node.getStrokeColor());

        // Set the properties to contained items
        for (StereotypeTextField item : groupTextField.getItems()) {
            item.setFont(node.getFont());
        }
    }

    /**
     * <p>
     * Relocates the stereotype, name and namespace compartments according to the bounding with.
     * </p>
     * @param radius
     *            selection corner radius
     * @param node
     *            the node containing the compartments
     * @param width
     *            the bounding with
     */
    static void updateNameCompartments(int radius, Node node, int width) {
        TextField stereotype, name, namespace;

        if (node instanceof PackageNode) {
            stereotype = ((PackageNode) node).getStereotypeCompartment();
            name = ((PackageNode) node).getNameCompartment();
            namespace = ((PackageNode) node).getNamespaceCompartment();
        } else {
            stereotype = ((BaseNode) node).getStereotypeCompartment();
            name = ((BaseNode) node).getNameCompartment();
            namespace = ((BaseNode) node).getNamespaceCompartment();
        }

        // Set location
        stereotype.setLocation(radius + width / 2 - stereotype.getWidth() / 2, stereotype.getY());
        name.setLocation(radius + width / 2 - name.getWidth() / 2, name.getY());
        namespace.setLocation(radius + width / 2 - namespace.getWidth() / 2, namespace.getY());
    }

    /**
     * <p>
     * Relocates and resizes the text fields in given GroupTextField according to given width.
     * </p>
     * @param groupTextField
     *            the GroupTextField which text fields need rearrangement
     * @param width
     *            width for text fields
     */
    static void updateGroupTextField(GroupTextField groupTextField, int width) {
        // This variable holds the height position for every text field
        int height = 0;
        for (StereotypeTextField textField : groupTextField.getItems()) {
            textField.setLocation(0, height);
            textField.setSize(width, textField.getPreferredSize().height);
            height += textField.getHeight();
            // Add the gap
            height += (int) Math.round(textField.getHeight() * GAP_PERCENT);
        }
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
     * Gets the stereotype, name or namespace graph node from given <code>GraphNode</code> for BaseNode.
     * </p>
     * @param graphNode
     *            the <code>GraphNode</code> which contains desired name graph node
     * @param index
     *            the sub graph node index of name compartment graph node, 0 for stereotype, 1 for name, 2 for namespace
     * @return the name graph node
     * @throws IllegalGraphElementException
     *             if fail to get the graph node
     */
    static GraphNode getCompartmentGraphNode(GraphNode graphNode, int index) {
        Util.checkNotNull(graphNode, "graphNode");
        List<DiagramElement> elements = graphNode.getContaineds();
        validateSubElementCountMoreThan(graphNode, elements, 1);
        GraphElement nameCompartment = (GraphElement) elements.get(0);
        elements = nameCompartment.getContaineds();
        validateSubElementCount(nameCompartment, elements, 3);
        return (GraphNode) elements.get(index);
    }

    /**
     * <p>
     * Gets the visibility token for given model element.
     * </p>
     */
    private static String getVisibilityToken(ModelElement element) {
        VisibilityKind kind = element.getVisibility();
        if (kind == VisibilityKind.PUBLIC) {
            return VB_PUBLIC;
        }
        if (kind == VisibilityKind.PROTECTED) {
            return VB_PROTECTED;
        }
        if (kind == VisibilityKind.PACKAGE) {
            return VB_PACKAGE;
        }
        return VB_PRIVATE;
    }

    /**
     * <p>
     * Gets the stereotype text from a collection of stereotypes.
     * </p>
     * @param stereotypes
     *            a collection of stereotypes
     * @return the stereotype text
     */
    private static String getStereotypes(Collection<Stereotype> stereotypes) {
        /*
         * BugFix: BUGID UML-8188 Description: In getStereotypes, if there is no stereotype in the collection, an empty
         * string should be returned, instead of "<< >>". Solution: Return an empty string when there is no
         * stereotype.
         */
        // old code
        // String text = "<< ";
        String text = "";
        // This variable indicates if the first stereotype is passed
        boolean multipleStereotypes = false;
        for (Stereotype stereotype : stereotypes) {

            if (multipleStereotypes) {
                text += ", ";
            } else {
                multipleStereotypes = true;
            }
            text += stereotype.getName();
        }

        return text;
    }

    /**
     * <p>
     * Gets the attributes from given node's graph node.
     * </p>
     * @param node
     *            the node containing the graph node
     * @return the attributes
     */
    static ArrayList<StereotypeTextField> getAttributes(BaseNode node) {
        GraphNode graphNode = node.getGraphNode();
        ArrayList<StereotypeTextField> textFields = new ArrayList<StereotypeTextField>();
        GraphNode attributeCompartment;
        if (node instanceof ClassNode) {
            attributeCompartment = (GraphNode) graphNode.getContaineds().get(2);
        } else {
            attributeCompartment = (GraphNode) graphNode.getContaineds().get(4);
        }
        GraphNode section = (GraphNode) attributeCompartment.getContaineds().get(0);

        // Update each text field according to the features
        Classifier classifier = (Classifier) getElement(graphNode);
        List<Feature> features = classifier.getFeatures();
        int i = 0;
        for (Feature feature : features) {
            if (feature instanceof Attribute) {
                Attribute attribute = (Attribute) feature;

                GraphNode attributeGraphNode = findGraphNode(section, attribute);

                StereotypeTextField textField = null;

                if (attributeGraphNode != null) {
                    textField = findStereotypeTextField(node.getAttributesCompartment(), attributeGraphNode);
                } else {
                    attributeGraphNode = (GraphNode) createGraphElement(feature);
                    addContained(section, attributeGraphNode);
                }

                if (textField == null) {
                    textField = new StereotypeTextField(attributeGraphNode);
                    textField.addMouseListener(new EditBoxTrigger(textField));
                }

                textField.setVisible(true);

                textField.stereotypeVisible(!attribute.getStereotypes().isEmpty());

                textField.setStereotype("<< " + getStereotypes(attribute.getStereotypes()) + " >>");
                String typeName = "";
                if (attribute.getType() != null) {
                    typeName = attribute.getType().getName();
                }
                String text = getVisibilityToken(attribute) + attribute.getName() + ":" + typeName;
                if (attribute.getInitialValue() != null) {
                    text += "=";
                    text += attribute.getInitialValue().getBody();
                }
                textField.setText(text);

                textFields.add(textField);

                i++;
            }
        }

        // Remove redundant graph nodes
        cleanFeatueSection(section, classifier);
        return textFields;
    }

    /**
     * <p>
     * Remove redundant diagram elements from section container.
     * </p>
     * @param section
     *            the container which contains graph node for features
     * @param classifier
     *            the classifier which contains features
     */
    private static void cleanFeatueSection(GraphNode section, Classifier classifier) {
        for (DiagramElement diagramElement : new ArrayList<DiagramElement>(section.getContaineds())) {
            if (!(diagramElement instanceof GraphElement)) {
                section.removeContained(diagramElement);
            } else {
                GraphElement graphElement = (GraphElement) diagramElement;
                ModelElement element = getElement(graphElement);
                if (element == null || !(element instanceof Feature) || !classifier.containsFeature((Feature) element)) {
                    section.removeContained(diagramElement);
                }
            }
        }
    }

    /**
     * <p>
     * Finds the graph node which contains given model element from given container.
     * </p>
     * @param container
     *            the graph node which may contain the desired graph node
     * @param modelElement
     *            the model element to find contained graph node
     * @return the graph node if found, null otherwise
     */
    private static GraphNode findGraphNode(GraphNode container, ModelElement modelElement) {
        for (DiagramElement diagramElement : container.getContaineds()) {
            if (diagramElement instanceof GraphNode) {
                GraphNode graphNode = (GraphNode) diagramElement;
                if (getElement(graphNode) == modelElement) {
                    return graphNode;
                }
            }
        }
        return null;
    }

    /**
     * <p>
     * Finds the StereotypeTextField which contains given graph node from given GroupTextField.
     * </p>
     * @param groupTextField
     *            the GroupTextField which may contain desired StereotypeTextField
     * @param graphNode
     *            the GraphNode to find contained StereotypeTextField
     * @return the StereotypeTextField found, null if not found
     */
    private static StereotypeTextField findStereotypeTextField(GroupTextField groupTextField, GraphNode graphNode) {
        for (StereotypeTextField item : groupTextField.getItems()) {
            if (item.getGraphNode() == graphNode) {
                return item;
            }
        }
        return null;
    }

    /**
     * <p>
     * Sets the typeInfo of the <code>graphElement</code>.
     * </p>
     * @param graphElement
     *            the <code>GraphElement</code> which typeInfo should be set
     * @param typeInfo
     *            the typeInfo which should be set to the <code>graphElement</code>
     */
    private static void setTypeInfo(GraphElement graphElement, String typeInfo) {
        SimpleSemanticModelElement simpleElement = new SimpleSemanticModelElement();
        simpleElement.setTypeInfo(typeInfo);
        graphElement.setSemanticModel(simpleElement);
    }

    /**
     * <p>
     * Sets the element of the <code>graphElement</code> to <code>element</code>.
     * </p>
     * @param graphElement
     *            the <code>GraphElement</code> which element should be set.
     * @param element
     *            the element which should be set to the <code>graphElement</code>.
     */
    private static void setElement(GraphElement graphElement, Element element) {
        Uml1SemanticModelBridge uml1ModelBridge = new Uml1SemanticModelBridge();
        uml1ModelBridge.setElement(element);
        graphElement.setSemanticModel(uml1ModelBridge);
    }

    /**
     * <p>
     * Adds child to parent, and sets its container.
     * </p>
     * @param parent
     *            parent graph element
     * @param child
     *            child graph element
     */
    private static void addContained(GraphElement parent, DiagramElement child) {
        parent.addContained(child);
        child.setContainer(parent);
    }

    /**
     * <p>
     * Creates a valid <code>GraphElement</code> for given element.
     * </p>
     * @param element
     *            the ModelElement to create a container graph element
     * @return a valid <code>GraphElement</code> for given element
     */
    private static GraphElement createGraphElement(ModelElement element) {
        GraphElement graphElement = new GraphNode();
        setElement(graphElement, element);

        // create SimpleSemanticmodelElement.typeinfo = "Name"
        GraphElement name = new GraphNode();
        setTypeInfo(name, "Name");
        addContained(graphElement, name);

        return graphElement;
    }

    /**
     * <p>
     * Get the operation text to display.
     * </p>
     * @param operation
     *            the operation model element
     * @return a text string to display this operation
     */
    private static String getOperationText(Operation operation) {
        String text = getVisibilityToken(operation) + operation.getName();

        // Append with the parameter text
        text += "(";
        boolean multiple = false;
        Parameter returned = null;
        for (Parameter parameter : operation.getParameters()) {
            if (parameter.getKind() != ParameterDirectionKind.RETURN) {
                if (multiple) {
                    text += ",";
                } else {
                    multiple = true;
                }
                text += parameter.getName();
                text += ":";
                text += getParameterType(parameter);
            } else {
                returned = parameter;
            }
        }
        text += ")";

        // Append return type text
        if (returned != null) {
            text += ":";
            text += getParameterType(returned);
        }

        return text;
    }

    /**
     * <p>
     * Gets the type string of given parameter.
     * </p>
     * @param parameter
     *            the parameter to get type
     * @return the type
     */
    private static String getParameterType(Parameter parameter) {
        Classifier type = parameter.getType();
        return type == null ? "" : type.getName();
    }

    /**
     * <p>
     * Gets the operations from given node's graph node.
     * </p>
     * @param node
     *            the node containing the graph node
     * @return the operations
     */
    static ArrayList<StereotypeTextField> getOperations(BaseNode node) {
        GraphNode graphNode = node.getGraphNode();
        ArrayList<StereotypeTextField> textFields = new ArrayList<StereotypeTextField>();
        GraphNode operationCompartment;
        if (node instanceof ClassNode) {
            operationCompartment = (GraphNode) graphNode.getContaineds().get(4);
        } else {
            operationCompartment = (GraphNode) graphNode.getContaineds().get(6);
        }
        GraphNode section = (GraphNode) operationCompartment.getContaineds().get(0);

        // Update each text field according to the features
        Classifier classifier = (Classifier) getElement(graphNode);
        List<Feature> features = classifier.getFeatures();
        int i = 0;
        for (Feature feature : features) {
            if (feature instanceof Operation) {
                Operation operation = (Operation) feature;

                GraphNode operationGraphNode = findGraphNode(section, operation);

                StereotypeTextField textField = null;

                if (operationGraphNode != null) {
                    textField = findStereotypeTextField(node.getOperationsCompartment(), operationGraphNode);
                } else {
                    operationGraphNode = (GraphNode) createGraphElement(feature);
                    addContained(section, operationGraphNode);
                }

                if (textField == null) {
                    textField = new StereotypeTextField(operationGraphNode);
                    textField.addMouseListener(new EditBoxTrigger(textField));
                }

                textField.setVisible(true);

                textField.stereotypeVisible(!operation.getStereotypes().isEmpty());

                textField.setStereotype("<< " + getStereotypes(operation.getStereotypes()) + " >>");

                textField.setText(getOperationText(operation));

                textFields.add(textField);

                i++;
            }
        }

        // Remove redundant graph nodes
        cleanFeatueSection(section, classifier);
        return textFields;
    }

    /**
     * <p>
     * Gets the enumeration literals from graph element of EnumerationLiteralCompartment.
     * </p>
     * @param graphElement
     *            graph element of EnumerationLiteralCompartment
     * @return the enumeration literals
     */
    private static ArrayList<StereotypeTextField> getEnumerationLiteralsFromCompartment(GraphElement graphElement) {
        ArrayList<StereotypeTextField> literals = new ArrayList<StereotypeTextField>();
        GraphElement subGraphElement = (GraphElement) graphElement.getContaineds().get(0);
        List<DiagramElement> contained = subGraphElement.getContaineds();

        for (DiagramElement element : contained) {
            StereotypeTextField textField = new StereotypeTextField((GraphNode) element);
            textField.setVisible(element.isVisible());

            literals.add(textField);
        }

        return literals;
    }

    /**
     * <p>
     * Gets the enumeration literals from EnumerationNode's graph node.
     * </p>
     * @param graphNode
     *            graph node for EnumerationNode
     * @return the enumeration literals
     */
    static ArrayList<StereotypeTextField> getEnumerationLiterals(GraphNode graphNode) {
        ArrayList<StereotypeTextField> textFields = getEnumerationLiteralsFromCompartment((GraphElement) graphNode
                .getContaineds().get(2));

        // Update each text field according to the literal elements
        Enumeration element = (Enumeration) getElement(graphNode);
        int i = 0;
        for (EnumerationLiteral literal : element.getLiterals()) {
            StereotypeTextField textField = textFields.get(i);
            textField.stereotypeVisible(!literal.getStereotypes().isEmpty());
            textField.setStereotype(getStereotypes(literal.getStereotypes()));
            String text = getVisibilityToken(literal) + literal.getName();
            textField.setText(text);
            i++;
        }
        return textFields;
    }

    /**
     * <p>
     * Combines the component's size to the size. This method is used to get a bounding size for many components.
     * </p>
     * @param size
     *            the bounding size
     * @param componentSize
     *            a component's size
     * @param isGapAdded
     *            whether to add a gap after the bounding size
     */
    static void combineSize(Dimension size, Dimension componentSize, boolean isGapAdded) {
        size.width = Math.max(size.width, componentSize.width);
        size.height += componentSize.height;
        if (isGapAdded) {
            // Add the gap
            size.height += (int) Math.round(componentSize.height * GAP_PERCENT);
        }
    }

    /**
     * <p>
     * Returns the stereotype Compartment text of the <code>graphElement</code>.
     * </p>
     * @param graphElement
     *            the <code>GraphElement</code> which stereotype compartment text is returned.
     * @return the text of the stereotype compartment of <code>graphElement</code>.
     */
    private static String getStereotype(GraphElement graphElement) {
        ModelElement element = getElement(graphElement);
        Collection<Stereotype> stereotypes = element.getStereotypes();

        String stereotypeText = getStereotypes(stereotypes);

        GraphNode nameCompartment = (GraphNode) graphElement.getContaineds().get(0);
        GraphNode stereotypeCompartment = (GraphNode) nameCompartment.getContaineds().get(0);

        for (DiagramElement diagramElement : stereotypeCompartment.getContaineds()) {
            GraphNode graphNode = (GraphNode) diagramElement;

            if (graphNode.getSemanticModel() instanceof SimpleSemanticModelElement) {
                String typeInfo = getTypeInfo(graphNode);
                if (typeInfo.equals("KeywordMetaclass")) {
                    if (stereotypeText.length() == 0) {
                        stereotypeText = "interface";
                    } else {
                        stereotypeText = "interface, " + stereotypeText;
                    }
                    break;
                }
            }
        }
        if (!stereotypeText.equals("")) {
            stereotypeText = "<< " + stereotypeText + " >>";
        }
        return stereotypeText;
    }

    /**
     * <p>
     * Gets the typeInfo of the <code>graphElement</code>.
     * </p>
     * @param graphElement
     *            the <code>GraphElement</code> which typeInfo should be set
     * @return the typeInfo of the <code>graphElement</code>
     */
    private static String getTypeInfo(GraphElement graphElement) {
        SimpleSemanticModelElement simpleElement = (SimpleSemanticModelElement) graphElement.getSemanticModel();
        return simpleElement.getTypeInfo();
    }

    /**
     * <p>
     * Gets the name text from a name graph element.
     * </p>
     * @param graphElement
     *            the name graph element
     * @return the name text string
     */
    private static String getName(GraphElement graphElement) {
        ModelElement element = getElement(graphElement);
        return element.getName();
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
         * BugFix: BUGID UML-8188 Description: In getNamespace, the approach to get the namespace is wrong. This should
         * just return the name of model element's namespace. If the namespace is null, an empty string should be
         * returned. Solution: Return the name of model element's namespace instead, if it is null, return an empty
         * string.
         */
        // old code
        // Collection<ModelElement> contained = namespace.getOwnedElements();
        // // indicates if the first element is passed
        // boolean multiple = false;
        // StringBuffer sb = new StringBuffer();
        // sb.append("(from ");
        // for (ModelElement modelElement : contained) {
        // if (multiple) {
        // sb.append("::");
        // } else {
        // multiple = true;
        // }
        // sb.append(modelElement.getName());
        // }
        // sb.append(")");
        //
        // return sb.toString();
        /*
         * BugFix: UML-9991 Traversed the namespace of model element recursively above to find the entire namespace.
         */
        // old code
        // return namespace != null ? namespace.getName() : "";
        String text = "";
        while (namespace != null && !(namespace instanceof Model)) {
            if (text == "") {
                text = namespace.getName();
            } else {
                text = namespace.getName() + "::" + text;
            }
            namespace = namespace.getNamespace();
        }
        text = "from: " + text;
        return text;
    }

    /**
     * <p>
     * Computes the suitable size for contained compartments.
     * </p>
     * @param stereotype
     *            the stereotype compartment
     * @param name
     *            the name compartment
     * @param namespace
     *            the namespace compartment
     * @return the suitable size for contained compartments
     */
    static Dimension getPreferredCompartmentsSize(TextField stereotype, TextField name, TextField namespace) {
        Dimension size = new Dimension(0, 0);
        if (stereotype.isVisible()) {
            Util.combineSize(size, stereotype.getPreferredSize(), name.isVisible() || namespace.isVisible());
        }
        if (name.isVisible()) {
            Util.combineSize(size, name.getPreferredSize(), namespace.isVisible());
        }
        if (namespace.isVisible()) {
            Util.combineSize(size, namespace.getPreferredSize(), false);
        }
        return size;
    }

    /**
     * <p>
     * Creates the SelectionCornerTypes for nodes.
     * </p>
     * @return a <code>Collection</code> of SelectionCornerTypes which are applicable for the shape of nodes in this
     *         component
     */
    static Collection<SelectionCornerType> createSelectionCornerTypes() {
        Collection<SelectionCornerType> corners = new ArrayList<SelectionCornerType>();

        corners.add(SelectionCornerType.EAST);
        corners.add(SelectionCornerType.NORTHEAST);
        corners.add(SelectionCornerType.NORTH);
        corners.add(SelectionCornerType.NORTHWEST);
        corners.add(SelectionCornerType.WEST);
        corners.add(SelectionCornerType.SOUTHWEST);
        corners.add(SelectionCornerType.SOUTH);
        corners.add(SelectionCornerType.SOUTHEAST);

        return corners;
    }

    /**
     * <p>
     * Consumes the Mouse Pressed event for node.
     * </p>
     * @param node
     *            the BaseNode which consumes this event
     * @param event
     *            the mouse event
     * @param element
     *            the event source's contained element, the event source should be Edge
     * @return a flag indicating whether the event is consumed
     */
    private static boolean consumeMousePressedEvent(BaseNode node, MouseEvent event, ModelElement element) {
        boolean isStart = false;
        if (!(element instanceof Abstraction)) {
            isStart = true;
        } else {
            Abstraction abstraction = (Abstraction) element;
            for (ModelElement client : abstraction.getClients()) {
                if (client instanceof Interface) {
                    isStart = true;
                    break;
                }
            }
        }
        if (isStart) {
            EdgeAddEvent edgeAddEvent = new EdgeAddEvent(node, event.getPoint(), isStart);
            node.fireEdgeAdd(edgeAddEvent);
            return true;
        }
        return false;
    }

    /**
     * <p>
     * Consumes the Mouse Released event for node.
     * </p>
     * @param node
     *            the BaseNode which consumes this event
     * @param event
     *            the mouse event
     * @param element
     *            the event source's contained element, the event source should be Edge
     * @return a flag indicating whether the event is consumed
     */
    private static boolean consumeMouseReleasedEvent(BaseNode node, MouseEvent event, ModelElement element) {
        boolean isStart = true;
        if (!(element instanceof Generalization)) {
            isStart = false;
        } else {
            Generalization generalization = (Generalization) element;
            if (node instanceof EnumerationNode) {
                if (generalization.getChild() instanceof Enumeration) {
                    isStart = false;
                }
            } else {
                if (generalization.getChild() instanceof com.topcoder.uml.model.core.classifiers.Class)
                    isStart = false;
            }
        }
        if (!isStart) {
            EdgeAddEvent edgeAddEvent = new EdgeAddEvent(node, event.getPoint(), isStart);
            node.fireEdgeAdd(edgeAddEvent);
            return true;
        }
        return false;
    }

    /**
     * <p>
     * This is the helper method for BaseNode#consumeEvent.
     * </p>
     * @param node
     *            the BaseNode which consumes this event
     * @param event
     *            the mouse event
     * @return a flag indicating whether the event is consumed
     */
    static boolean consumeEvent(BaseNode node, MouseEvent event) {
        if (event.getSource() instanceof Node) {
            return false;
        }
        if (event.getSource() instanceof Edge) {
            Edge edge = (Edge) event.getSource();
            ModelElement element = getElement(edge.getGraphEdge());
            if (event.getID() == MouseEvent.MOUSE_PRESSED) {
                return consumeMousePressedEvent(node, event, element);
            } else if (event.getID() == MouseEvent.MOUSE_RELEASED) {
                return consumeMouseReleasedEvent(node, event, element);
            }
        }
        return false;
    }

    /**
     * <p>
     * Paints the rectangle compartment at given coordinate with given fill color and stroke color.
     * </p>
     * @param g
     *            the graphics to paint on
     * @param size
     *            the rectangle size
     * @param x
     *            x location of the rectangle
     * @param y
     *            y location of the rectangle
     * @param fillColor
     *            fill color
     * @param strokeColor
     *            stroke color
     */
    static void paintRectCompartment(Graphics g, Dimension size, int x, int y, Color fillColor, Color strokeColor) {
        g.setColor(fillColor);
        g.fillRect(x, y, size.width, size.height);
        g.setColor(strokeColor);
        g.drawRect(x, y, size.width, size.height);
    }

    /**
     * <p>
     * Helper method for BaseNode#paintComponent.
     * </p>
     * @param node
     *            the BaseNode need painting
     * @param g
     *            the graphics to paint on
     * @param nameSize
     *            name compartment size
     * @param literalSize
     *            enumeration literal compartment size if node is EnumerationNode
     * @param attributeSize
     *            attribute compartment size
     * @param operationSize
     *            operation compartment size
     */
    static void paintBaseNode(BaseNode node, Graphics g, Dimension nameSize, Dimension literalSize,
            Dimension attributeSize, Dimension operationSize) {
        Point relative = node.getRelativePosition();
        Color fillColor = getFillColor(node);
        Color strokeColor = node.getStrokeColor();
        Color oldColor = g.getColor();

        // This variable records the current Y coordinate to paint
        int height = relative.y;

        // Paint the name compartment
        paintRectCompartment(g, nameSize, relative.x, height, fillColor, strokeColor);
        height += nameSize.height;

        /*
         * BUGR-83
         * this part of code is not needed
         *
         *if (node instanceof EnumerationNode) {
         *   paintRectCompartment(g, literalSize, relative.x, height, fillColor, strokeColor);
         *   height += literalSize.height;
         *}
         */

        // Paint the attribute compartment
        paintRectCompartment(g, attributeSize, relative.x, height, fillColor, strokeColor);
        height += attributeSize.height;

        // Paint the operation compartment
        paintRectCompartment(g, operationSize, relative.x, height, fillColor, strokeColor);

        // Set the color back
        g.setColor(oldColor);
    }

    /**
     * <p>
     * Gets the fill color for given node. This method returns a default color for abstract class node. Otherwise the
     * fill color for given node is returned.
     * </p>
     * @param node
     *            the node to get fill color
     * @return the fill color
     */
    private static Color getFillColor(BaseNode node) {
        Color fillColor = node.getFillColor();
        if (node instanceof ClassNode) {
            Classifier classifer = (Classifier) getElement(node.getGraphNode());
            if (classifer.isAbstract()) {
                fillColor = DEFAULT_ABSTRACT_COLOR;
            }
        }
        return fillColor;
    }
}
