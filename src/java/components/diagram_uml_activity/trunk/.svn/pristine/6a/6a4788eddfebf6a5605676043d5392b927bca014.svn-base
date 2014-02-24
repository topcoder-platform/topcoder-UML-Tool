/*
 * Copyright (C) 2007 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.gui.diagramviewer.uml.activityelements.failuretests;

import java.lang.reflect.Field;

import com.topcoder.diagraminterchange.Dimension;
import com.topcoder.diagraminterchange.GraphEdge;
import com.topcoder.diagraminterchange.GraphNode;
import com.topcoder.diagraminterchange.Point;
import com.topcoder.diagraminterchange.Property;
import com.topcoder.diagraminterchange.SimpleSemanticModelElement;
import com.topcoder.diagraminterchange.Uml1SemanticModelBridge;
import com.topcoder.uml.model.core.Element;
import com.topcoder.uml.model.core.classifiers.ClassImpl;
import com.topcoder.uml.model.core.extensionmechanisms.StereotypeImpl;
import com.topcoder.uml.model.statemachines.GuardImpl;
import com.topcoder.uml.model.statemachines.TransitionImpl;

/**
 * <p>
 * A helper class to perform those common operations which are helpful for the test.
 * </p>
 * @author TCSDEVELOPER
 * @version 1.0
 */
class FailureTestHelper {
    /**
     * <p>
     * This private constructor prevents to create a new instance.
     * </p>
     */
    private FailureTestHelper() {
    }

    /**
     * <p>
     * Creates a property with given key and value.
     * </p>
     * @param key
     *            the property key
     * @param value
     *            the property value
     * @return a new property created
     */
    static Property createProperty(String key, String value) {
        Property p = new Property();
        p.setKey(key);
        p.setValue(value);
        return p;
    }

    /**
     * Gets the value of a private field in the given class. The field has the given name. The value is retrieved from
     * the given instance. If the instance is null, the field is a static field. If any error occurs, null is returned.
     * @param type
     *            the class which the private field belongs to
     * @param instance
     *            the instance which the private field belongs to
     * @param name
     *            the name of the private field to be retrieved
     * @return the value of the private field
     */
    public static Object getPrivateField(Class<?> type, Object instance, String name) {
        Field field = null;
        Object obj = null;
        try {
            // Get the reflection of the field
            field = type.getDeclaredField(name);
            // Set the field accessible.
            field.setAccessible(true);
            // Get the value
            obj = field.get(instance);
        } catch (NoSuchFieldException e) {
            // Ignore
        } catch (IllegalAccessException e) {
            // Ignore
        } finally {
            if (field != null) {
                // Reset the accessibility
                field.setAccessible(false);
            }
        }

        return obj;
    }

    /**
     * <p>
     * This method adds properties for testing to given graph node.
     * <p>
     * The fill color is red, stroke color is green, font color is blue, font family is Courier, font style is BOLD, and
     * font size is 12.0
     * </p>
     * </p>
     * @param graphNode
     *            a graph node to add properties
     */
    public static void addPropertiesToGraphNode(GraphNode graphNode) {
        // Red Color
        Property fillColor = createProperty("fill_color", "FF0000");
        graphNode.addProperty(fillColor);
        // Green Color
        Property strokeColor = createProperty("stroke_color", "00FF00");
        graphNode.addProperty(strokeColor);
        // Blue Color
        Property fontColor = createProperty("font_color", "0000FF");
        graphNode.addProperty(fontColor);

        Property fontFamily = createProperty("font_family", "Arial");
        graphNode.addProperty(fontFamily);

        Property fontStyle = createProperty("font_style", "1");
        graphNode.addProperty(fontStyle);

        Property fontSize = createProperty("font_size", "12.0");
        graphNode.addProperty(fontSize);
    }

    /**
     * <p>
     * This method creates a GraphNode instance that follows the structures of ActivityNode.
     * </p>
     * @param elment
     *            the uml element
     * @return a GraphNode instance that follows the structures of ActivityNode.
     */
    public static GraphNode createGraphNodeForState(Element elment) {
        GraphNode node = new GraphNode();
        node.setSemanticModel(createUmlSemanticModel(elment));
        node.setSize(new Dimension());
        node.setPosition(new Point());

        // create a StereotypeCompartment node
        GraphNode stereotypeCompartment = createValidStereotypeCompartment();

        node.addContained(stereotypeCompartment);
        stereotypeCompartment.setContainer(node);

        // create a name node
        GraphNode nameNode = new GraphNode();
        nameNode.setSemanticModel(createSimpleSemanticModel("Name"));
        nameNode.setPosition(new Point());

        node.addContained(nameNode);
        nameNode.setContainer(node);

        addPropertiesToGraphNode(node);
        return node;
    }

    /**
     * <p>
     * Creates a valid stereotype compartment <code>GraphNode</code>.
     * </p>
     * @return a valid stereotype compartment <code>GraphNode</code>:.
     */
    private static GraphNode createValidStereotypeCompartment() {

        GraphNode node = new GraphNode();

        // create SimpleSemanticmodelElement.typeinfo = "StereotypeCompartment"
        node.setSemanticModel(createSimpleSemanticModel("StereotypeCompartment"));

        // create node under stereotype node.
        GraphNode metaclass = new GraphNode();
        // for interface
        metaclass.setSemanticModel(createSimpleSemanticModel("KeywordMetaclass"));

        // create SimpleSemanticModelElement.typeInfo = "StereotypeStart"
        GraphNode stereotypeStart = new GraphNode();
        stereotypeStart.setSemanticModel(createSimpleSemanticModel("StereotypeStart"));

        // create SimpleSemanticModelElement.typeInfo = "Name"
        GraphNode name = new GraphNode();
        name.setSemanticModel(createSimpleSemanticModel("Name"));

        // create Uml1SemanticModelBridgeElement.element = <UML:Stereotype>
        GraphNode umlStereotype = new GraphNode();
        umlStereotype.setSemanticModel(createUmlSemanticModel(new StereotypeImpl()));
        umlStereotype.addContained(name);

        // create SimpleSemanticModelElement.typeInfo = "StereotypeSeparator"
        GraphNode stereotypeSeparator = new GraphNode();
        stereotypeSeparator.setSemanticModel(createSimpleSemanticModel("StereotypeSeparator"));

        // create SimpleSemanticModelElement.typeInfo = "StereotypeEnd"
        GraphNode stereotypeEnd = new GraphNode();
        stereotypeEnd.setSemanticModel(createSimpleSemanticModel("StereotypeEnd"));

        // build correct structure
        node.addContained(0, metaclass);
        metaclass.setContainer(node);
        node.addContained(1, stereotypeStart);
        stereotypeStart.setContainer(node);
        node.addContained(2, umlStereotype);
        umlStereotype.setContainer(node);
        node.addContained(3, stereotypeSeparator);
        stereotypeSeparator.setContainer(node);
        node.addContained(4, umlStereotype);
        umlStereotype.setContainer(node);
        node.addContained(5, stereotypeEnd);
        stereotypeEnd.setContainer(node);

        return node;
    }

    /**
     * <p>
     * This method creates a GraphNode instance that follows the structures of ActivityState.
     * </p>
     * @param elment
     *            the uml element
     * @return a GraphNode instance that follows the structures of ActivityState.
     */
    static GraphNode createGraphNodeForAction(Element elment) {
        GraphNode node = new GraphNode();
        GraphNode root = node;
        node.setSize(new Dimension());
        node.setPosition(new Point());
        node.setSemanticModel(createUmlSemanticModel(elment));

        // creates a NameCompartment node
        GraphNode subNode = new GraphNode();
        subNode.setSemanticModel(createSimpleSemanticModel("NameCompartment"));
        subNode.setPosition(new Point());
        subNode.setSize(new Dimension());

        node.addContained(subNode);
        subNode.setContainer(node);
        node = subNode;

        // creates a NameAndType node
        subNode = new GraphNode();
        subNode.setSemanticModel(createSimpleSemanticModel("NameAndType"));

        node.addContained(subNode);
        subNode.setContainer(node);
        node = subNode;

        // creates a Name node
        subNode = new GraphNode();
        subNode.setSemanticModel(createSimpleSemanticModel("Name"));

        node.addContained(subNode);
        subNode.setContainer(node);

        subNode = new GraphNode();
        subNode.setSemanticModel(createSimpleSemanticModel("TypeSeparator"));

        node.addContained(subNode);
        subNode.setContainer(node);
        node = subNode;

        subNode = new GraphNode();
        subNode.setSemanticModel(createUmlSemanticModel(new ClassImpl()));

        node.addContained(subNode);
        subNode.setContainer(node);
        node = subNode;

        subNode = new GraphNode();
        subNode.setSemanticModel(createSimpleSemanticModel("Name"));
        node.addContained(subNode);
        subNode.setContainer(node);

        addPropertiesToGraphNode(root);
        return root;
    }

    /**
     * <p>
     * This method creates a GraphEdge instance that follows the structures of Transition.
     * </p>
     * @return a GraphEdge instance that follows the structures of Transition.
     */
    static GraphEdge createGraphEdgeForTransition() {
        GraphEdge root = new GraphEdge();
        root.setSemanticModel(createUmlSemanticModel(new TransitionImpl()));

        // creates a Name node
        GraphNode node = new GraphNode();
        node.setSemanticModel(createSimpleSemanticModel("Name"));
        node.setPosition(new Point());
        node.setSize(new Dimension());
        root.addContained(node);
        node.setContainer(root);

        // creates a TransitionDescription node
        node = new GraphNode();
        node.setSemanticModel(createSimpleSemanticModel("TransitionDescription"));
        node.setPosition(new Point());
        node.setSize(new Dimension());

        // creates a GuardStart node
        GraphNode subNode = new GraphNode();
        subNode.setSemanticModel(createSimpleSemanticModel("GuardStart"));
        node.addContained(subNode);
        subNode.setContainer(node);

        // creates a Guard node
        subNode = new GraphNode();
        subNode.setSemanticModel(createUmlSemanticModel(new GuardImpl()));
        // creates a Name node
        GraphNode subSubNode = new GraphNode();
        subSubNode.setSemanticModel(createSimpleSemanticModel("Name"));
        subNode.addContained(subSubNode);
        subSubNode.setContainer(subNode);
        node.addContained(subNode);
        subNode.setContainer(node);

        // creates a GuardEnd node
        subNode = new GraphNode();
        subNode.setSemanticModel(createSimpleSemanticModel("GuardEnd"));
        node.addContained(subNode);
        subNode.setContainer(node);

        root.addContained(node);
        node.setContainer(root);

        // create a stereotype node
        GraphNode stereotypeCompartment = createValidStereotypeCompartment();
        root.addContained(stereotypeCompartment);
        stereotypeCompartment.setContainer(root);

        return root;
    }

    /**
     * <p>
     * This method creates a SimpleSemanticModelElement instance with the given type information.
     * </p>
     * @param typeInfo
     *            the type information
     * @return a SimpleSemanticModelElement instance with the given type information.
     */
    static SimpleSemanticModelElement createSimpleSemanticModel(String typeInfo) {
        SimpleSemanticModelElement semanticModel;
        semanticModel = new SimpleSemanticModelElement();
        semanticModel.setTypeInfo(typeInfo);
        return semanticModel;
    }

    /**
     * <p>
     * This method creates a Uml1SemanticModelBridge instance with the given uml element.
     * </p>
     * @param element
     *            a uml element to be associated
     * @return a SimpleSemanticModelElement instance with the given uml element.
     */
    static Uml1SemanticModelBridge createUmlSemanticModel(Element element) {
        Uml1SemanticModelBridge bridge = new Uml1SemanticModelBridge();
        bridge.setElement(element);
        return bridge;
    }

}
