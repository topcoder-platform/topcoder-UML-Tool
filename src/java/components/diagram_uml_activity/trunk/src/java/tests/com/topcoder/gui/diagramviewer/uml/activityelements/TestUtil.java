/*
 * Copyright (C) 2006 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.gui.diagramviewer.uml.activityelements;

import java.io.File;
import java.lang.reflect.Field;
import java.util.Iterator;

import com.topcoder.diagraminterchange.Dimension;
import com.topcoder.diagraminterchange.GraphConnector;
import com.topcoder.diagraminterchange.GraphEdge;
import com.topcoder.diagraminterchange.GraphElement;
import com.topcoder.diagraminterchange.GraphNode;
import com.topcoder.diagraminterchange.Point;
import com.topcoder.diagraminterchange.Property;
import com.topcoder.diagraminterchange.SimpleSemanticModelElement;
import com.topcoder.diagraminterchange.Uml1SemanticModelBridge;
import com.topcoder.uml.model.activitygraphs.ObjectFlowStateImpl;
import com.topcoder.uml.model.core.Element;
import com.topcoder.uml.model.core.ModelElement;
import com.topcoder.uml.model.core.classifiers.ClassImpl;
import com.topcoder.uml.model.core.extensionmechanisms.Stereotype;
import com.topcoder.uml.model.core.extensionmechanisms.StereotypeImpl;
import com.topcoder.uml.model.core.extensionmechanisms.TagDefinition;
import com.topcoder.uml.model.core.extensionmechanisms.TagDefinitionImpl;
import com.topcoder.uml.model.core.extensionmechanisms.TaggedValue;
import com.topcoder.uml.model.core.extensionmechanisms.TaggedValueImpl;
import com.topcoder.uml.model.statemachines.Guard;
import com.topcoder.uml.model.statemachines.GuardImpl;
import com.topcoder.uml.model.statemachines.TransitionImpl;
import com.topcoder.util.config.ConfigManager;

/**
 * <p>
 * A helper class to perform those common operations which are helpful for the test.
 * </p>
 * @author TCSDEVELOPER
 * @version 1.0
 */
public class TestUtil {
    /**
     * <p>
     * This private constructor prevents to create a new instance.
     * </p>
     */
    private TestUtil() {
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
     * <p>
     * Creates a point for diagram element.
     * </p>
     * @param x
     *            x coordinate
     * @param y
     *            y coordinate
     * @return a point for diagram element
     */
    static Point createPoint(double x, double y) {
        Point pos = new Point();
        pos.setX(x);
        pos.setY(y);
        return pos;
    }

    /**
     * <p>
     * Creates a dimension for diagram element.
     * </p>
     * @param width
     *            dimension width
     * @param height
     *            dimension height
     * @return a dimension for diagram element
     */
    static Dimension createDimension(double width, double height) {
        Dimension size = new Dimension();
        size.setWidth(width);
        size.setHeight(height);
        return size;
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
    public static GraphNode createGraphNodeForActivityNode(Element elment) {
        GraphNode node = new GraphNode();
        node.setSemanticModel(createUmlSemanticModel(elment));

        // create a stereotype node
        GraphNode stereoTypeNode = new GraphNode();
        stereoTypeNode.setSemanticModel(createSimpleSemanticModel("StereotypeCompartment"));
        stereoTypeNode.setSize(createDimension(150, 120));
        stereoTypeNode.setPosition(createPoint(-10, -20 - stereoTypeNode.getSize().getHeight()));

        // create a name node
        GraphNode nameNode = new GraphNode();
        nameNode.setSemanticModel(createSimpleSemanticModel("Name"));
        nameNode.setSize(createDimension(150, 120));
        nameNode.setPosition(createPoint(-10, 60));

        node.addContained(stereoTypeNode);
        stereoTypeNode.setContainer(node);
        node.addContained(nameNode);
        nameNode.setContainer(node);

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
    static GraphNode createGraphNodeForActivityState(Element elment) {
        GraphNode root = new GraphNode();

        GraphNode node = root;
        node.setSemanticModel(createUmlSemanticModel(elment));

        // creates a NameCompartment node
        GraphNode subNode = new GraphNode();
        subNode.setSemanticModel(createSimpleSemanticModel("NameCompartment"));
        subNode.setPosition(createPoint(5, 5));
        subNode.setSize(createDimension(200, 100));

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

        // create the Transition element
        ModelElement element = new TransitionImpl();
        // set nameCompartment text
        element.setName("TransitionNameCompartment");
        // set stereotypeCompartment text
        Stereotype stereotypeOne = new StereotypeImpl();
        stereotypeOne.setName("TransitionStereotypeCompartment");
        element.addStereotype(stereotypeOne);

        root.setSemanticModel(createUmlSemanticModel(element));

        // create a Name node
        GraphNode node = new GraphNode();
        node.setSemanticModel(createSimpleSemanticModel("Name"));
        node.setPosition(createPoint(5, 5));
        node.setSize(createDimension(100, 10));
        root.addContained(node);
        node.setContainer(root);

        // create a TransitionDescription node
        node = new GraphNode();
        node.setSemanticModel(createSimpleSemanticModel("TransitionDescription"));
        node.setPosition(createPoint(5, 5));
        node.setSize(createDimension(100, 10));

        // create a GuardStart node
        GraphNode subNode = new GraphNode();
        subNode.setSemanticModel(createSimpleSemanticModel("GuardStart"));
        node.addContained(subNode);
        subNode.setContainer(node);

        // create a Guard node
        subNode = new GraphNode();
        // set descriptionCompartment test
        Guard guardImpl = new GuardImpl();
        guardImpl.setName("TransitionDescriptionCompartment");
        subNode.setSemanticModel(createUmlSemanticModel(guardImpl));
        // create a Name node
        GraphNode subSubNode = new GraphNode();
        subSubNode.setSemanticModel(createSimpleSemanticModel("Name"));
        subNode.addContained(subSubNode);
        subSubNode.setContainer(subNode);
        node.addContained(subNode);
        subNode.setContainer(node);

        // create a GuardEnd node
        subNode = new GraphNode();
        subNode.setSemanticModel(createSimpleSemanticModel("GuardEnd"));
        node.addContained(subNode);
        subNode.setContainer(node);

        root.addContained(node);
        node.setContainer(root);

        // create a stereotype node
        node = createStereotypeCompartment();
        node.setPosition(createPoint(5, 5));
        node.setSize(createDimension(100, 10));
        root.addContained(node);
        node.setContainer(root);

        GraphConnector connector = new GraphConnector();
        // create a GraphNode for connector
        node = new GraphNode();
        node.setSemanticModel(createUmlSemanticModel(new ObjectFlowStateImpl()));
        connector.setGraphElement(node);
        connector.setPosition(createPoint(5, 5));
        root.addWaypoint(createPoint(0, 0));
        root.addAnchor(connector);

        connector = new GraphConnector();
        // create a GraphNode for connector
        node = new GraphNode();
        node.setSemanticModel(createUmlSemanticModel(new ObjectFlowStateImpl()));
        connector.setGraphElement(node);
        connector.setPosition(createPoint(10, 10));
        root.addWaypoint(createPoint(20, 20));
        root.addAnchor(connector);

        return root;
    }

    /**
     * <p>
     * Creates a stereotype compartment <code>GraphNode</code>.
     * </p>
     * @return a stereotype compartment <code>GraphNode</code>:.
     */
    static GraphNode createStereotypeCompartment() {

        GraphNode node = new GraphNode();

        // create SimpleSemanticmodelElement.typeinfo = "StereotypeCompartment"
        node.setSemanticModel(createSimpleSemanticModel("StereotypeCompartment"));

        // create SimpleSemanticModelElement.typeInfo = "StereotypeStart"
        GraphElement stereotypeStart = new GraphNode();
        stereotypeStart.setSemanticModel(createSimpleSemanticModel("StereotypeStart"));

        // create Uml1SemanticModelBridgeElement.element = <UML:Stereotype>
        GraphElement umlStereotype = new GraphNode();
        umlStereotype.setSemanticModel(createUmlSemanticModel(new StereotypeImpl()));

        // create SimpleSemanticModelElement.typeInfo = "Name"
        GraphElement name = new GraphNode();
        name.setSemanticModel(createSimpleSemanticModel("Name"));
        umlStereotype.addContained(0, name);

        // create SimpleSemanticModelElement.typeInfo = "StereotypeSeparator"
        GraphElement stereotypeSeparator = new GraphNode();
        stereotypeSeparator.setSemanticModel(createSimpleSemanticModel("StereotypeSeparator"));

        // create SimpleSemanticModelElement.typeInfo = "StereotypeEnd"
        GraphElement stereotypeEnd = new GraphNode();
        stereotypeEnd.setSemanticModel(createSimpleSemanticModel("StereotypeEnd"));

        // build correct structure
        node.addContained(0, stereotypeStart);
        node.addContained(1, umlStereotype);
        node.addContained(2, stereotypeSeparator);
        node.addContained(3, umlStereotype);
        node.addContained(4, stereotypeEnd);

        return node;
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
        SimpleSemanticModelElement semanticModel = new SimpleSemanticModelElement();
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

    /**
     * Creates the tag value.
     * @param tagType
     *            the tag type
     * @param dataValue
     *            the data value
     * @return a <code>TaggedValue</code> created
     */
    static TaggedValue createTagValue(String tagType, String dataValue) {
        TagDefinition tagDefinition = new TagDefinitionImpl();
        tagDefinition.setTagType(tagType);

        TaggedValue taggedValue = new TaggedValueImpl();
        taggedValue.setType(tagDefinition);
        taggedValue.setDataValue(dataValue);

        return taggedValue;
    }

    /**
     * Removes all namespaces.
     *
     * @throws Exception
     *             when error occurs
     */
    static void removeAllNamespaces() throws Exception {
        ConfigManager manager = ConfigManager.getInstance();
        for (Iterator it = manager.getAllNamespaces(); it.hasNext();) {
            manager.removeNamespace((String) it.next());
        }
    }

    /**
     * loads the configuration file.
     *
     * @param filename
     *            the filename to load the configuration from
     * @throws Exception
     *             when error occurs
     */
    static void loadConfig(String filename) throws Exception {
        removeAllNamespaces();
        ConfigManager config = ConfigManager.getInstance();
        File file = new File(filename);

        config.add(file.getCanonicalPath());
    }
}
