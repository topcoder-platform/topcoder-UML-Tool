/*
 * Copyright (C) 2007 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.gui.diagramviewer.uml.usecaseelements;

import java.util.HashMap;
import java.util.Map;

import javax.swing.TransferHandler;

import junit.framework.TestCase;

import com.topcoder.diagraminterchange.Dimension;
import com.topcoder.diagraminterchange.GraphEdge;
import com.topcoder.diagraminterchange.GraphElement;
import com.topcoder.diagraminterchange.GraphNode;
import com.topcoder.diagraminterchange.Point;
import com.topcoder.diagraminterchange.Property;
import com.topcoder.diagraminterchange.SimpleSemanticModelElement;
import com.topcoder.diagraminterchange.Uml1SemanticModelBridge;
import com.topcoder.uml.model.core.Namespace;
import com.topcoder.uml.model.core.extensionmechanisms.Stereotype;
import com.topcoder.uml.model.core.extensionmechanisms.StereotypeImpl;
import com.topcoder.uml.model.core.relationships.Relationship;
import com.topcoder.uml.model.modelmanagement.Subsystem;
import com.topcoder.uml.model.modelmanagement.SubsystemImpl;
import com.topcoder.uml.model.usecases.Actor;
import com.topcoder.uml.model.usecases.ActorImpl;
import com.topcoder.uml.model.usecases.UseCase;
import com.topcoder.uml.model.usecases.UseCaseImpl;

/**
 * <p>
 * A helper class to perform those common operations which are helpful for the test.
 * </p>
 *
 * @author TCSDEVELOPER
 * @version 1.0
 */
public class TestHelper {
    /**
     * <p>
     * This private constructor prevents to create a new instance.
     * </p>
     */
    private TestHelper() {
        // empty
    }

    /**
     * <p>
     * Creates an <code>SubsystemNodeContainer</code> instance for testing.
     * </p>
     *
     * @return an <code>SubsystemNodeContainer</code> instance for testing.
     */
    public static SubsystemNodeContainer createSubsystemNodeContainer() {
        Map<String, String> properties = new HashMap<String, String>();
        TransferHandler handler = new TransferHandler("");
        SubsystemNodeContainer nodeContainer = null;
        try {
            nodeContainer = new SubsystemNodeContainer(TestHelper.createGraphNodeForSubsystem(), properties, handler);
        } catch (IllegalGraphElementException e) {
            TestCase.fail("no IllegalGraphElementException will be thrown");
        }
        return nodeContainer;
    }

    /**
     * <p>
     * Creates an <code>TextField</code> instance for testing.
     * </p>
     *
     * @return an <code>TextFieldr</code> instance for testing.
     */
    public static TextField createTextField() {
        GraphNode graphNode = new GraphNode();

        return new TextField(graphNode);
    }

    /**
     * <p>
     * This method creates a <code>Property</code> defined in Diagram Interchange component.
     * </p>
     *
     * @param key the property key
     * @param value the property value
     *
     * @return the property instance
     */
    public static Property createProperty(String key, String value) {
        Property prop = new Property();
        prop.setKey(key);
        prop.setValue(value);

        return prop;
    }

    /**
     * <p>
     * This method creates a <code>GraphNode</code> for testing.
     * </p>
     *
     * @return a <code>GraphNode</code> for testing.
     */
    public static GraphNode createGraphNode() {
        GraphNode node = new GraphNode();

        node.addProperty(createProperty("FillColor", "555555"));
        node.addProperty(createProperty("StrokeColor", "00FF00"));
        node.addProperty(createProperty("FontColor", "FF0000"));
        node.addProperty(createProperty("FontSize", "12"));
        node.addProperty(createProperty("FontFamily", "Arial"));

        return node;
    }

    /**
     * <p>
     * This method return a default properties mapping.
     * </p>
     *
     * @return the default properties mapping
     */
    public static Map<String, String> createProperties() {
        Map<String, String> properties = new HashMap<String, String>();
        properties.put("StrokeColor", "StrokeColor");
        properties.put("FillColor", "FillColor");
        properties.put("FontColor", "FontColor");
        properties.put("FontSize", "FontSize");
        properties.put("FontFamily", "FontFamily");

        return properties;
    }

    /**
     * <p>
     * This method creates a default graphNode for SubsystemNodeContainer.
     * </p>
     * <p>
     * The structure of the GraphNode that corresponds to a Subsystem should be:
     * Uml1SemanticModelBridge.element = UML:Subsystem
     *   SimpleSemanticModelElement.typeInfo = "NameCompartment"
     *     SimpleSemanticModelElement.typeInfo = "StereotypeCompartment"
     *     SimpleSemanticModelElement.typeInfo = "Name"
     *     SimpleSemanticModelElement.typeInfo = "NamespaceCompartment¡±
     *   SimpleSemanticModelElement.typeInfo = "BodyCompartment"
     * </p>
     *
     * @return the default graphNode for SubsystemNodeContainer
     */
    public static GraphNode createGraphNodeForSubsystem() {
        GraphNode nameNode = new GraphNode();

        for (int i = 0; i < 3; i++) {
            GraphNode childNode = new GraphNode();

            childNode.setPosition(TestHelper.getPoint(0, 12 * i));
            childNode.setSize(TestHelper.getDimension(100, 22));

            nameNode.addContained(childNode);
        }

        nameNode.setPosition(TestHelper.getPoint(250, 150));
        nameNode.setSize(TestHelper.getDimension(200, 320));

        GraphNode graphNode = new GraphNode();
        graphNode.addContained(nameNode);
        graphNode.addContained(new GraphNode());

        graphNode.setPosition(TestHelper.getPoint(5, 5));
        graphNode.setSize(TestHelper.getDimension(400, 400));

        // create a subsystem
        Subsystem subsystem = new SubsystemImpl();

        // set name
        subsystem.setName("Default package");

        // set namespace
        Namespace namespace = new MockNamespaceImpl();
        namespace.setName("com.topcoder");
        subsystem.setNamespace(namespace);

        // create a semantic model
        Uml1SemanticModelBridge semanticModel = new Uml1SemanticModelBridge();
        semanticModel.setElement(subsystem);

        graphNode.setSemanticModel(semanticModel);

        return graphNode;
    }

    /**
     * <p>
     * This method creates a default graphNode for ActorNode.
     * </p>
     * <p>
     * The structure of the GraphNode that corresponds to an Actor should be:
     * Uml1SemanticModelBridge.element = UML:Actor
     *   SimpleSemanticModelElement.typeInfo = "StereotypeCompartment"
     *   SimpleSemanticModelElement.typeInfo = "Name"
     *   SimpleSemanticModelElement.typeInfo = "NamespaceCompartment"
     * </p>
     *
     * @return the default graphNode for ActorNode
     */
    public static GraphNode createGraphNodeForActor() {
        GraphNode graphNode = new GraphNode();

        for (int i = 0; i < 3; i++) {
            GraphNode childNode = new GraphNode();

            childNode.setPosition(TestHelper.getPoint(0, 12 * i));
            childNode.setSize(TestHelper.getDimension(100, 22));

            graphNode.addContained(childNode);
        }

        graphNode.setPosition(TestHelper.getPoint(10, 10));
        graphNode.setSize(TestHelper.getDimension(200, 320));

        // create an actor
        Actor actor = new ActorImpl();

        // set name
        actor.setName("Actor_1");

        // set stereotype
        Stereotype stereotype = new StereotypeImpl();
        stereotype.setName("interface");
        actor.addStereotype(stereotype);

        // set namespace
        Namespace namespace = new MockNamespaceImpl();
        namespace.setName("com.topcoder");
        actor.setNamespace(namespace);

        // create a semantic model
        Uml1SemanticModelBridge semanticModel = new Uml1SemanticModelBridge();
        semanticModel.setElement(actor);

        graphNode.setSemanticModel(semanticModel);

        return graphNode;
    }

    /**
     * <p>
     * This method creates another graphNode for ActorNode.
     * </p>
     * <p>
     * The location of its compartments is out of the rectangle of the actor.
     * </p>
     * <p>
     * The structure of the GraphNode that corresponds to an Actor should be:
     * Uml1SemanticModelBridge.element = UML:Actor
     *   SimpleSemanticModelElement.typeInfo = "StereotypeCompartment"
     *   SimpleSemanticModelElement.typeInfo = "Name"
     *   SimpleSemanticModelElement.typeInfo = "NamespaceCompartment"
     * </p>
     *
     * @return the default graphNode for ActorNode
     */
    public static GraphNode createGraphNodeForActor1() {
        GraphNode graphNode = new GraphNode();

        // create stereotype compartment
        GraphNode childNode = new GraphNode();
        childNode.setPosition(TestHelper.getPoint(75, -5));
        childNode.setSize(TestHelper.getDimension(100, 20));
        graphNode.addContained(childNode);

        // create name compartment
        childNode = new GraphNode();
        childNode.setPosition(TestHelper.getPoint(80, 330));
        childNode.setSize(TestHelper.getDimension(100, 20));
        graphNode.addContained(childNode);

        // create namespace compartment
        childNode = new GraphNode();
        childNode.setPosition(TestHelper.getPoint(80, 340));
        childNode.setSize(TestHelper.getDimension(100, 20));
        graphNode.addContained(childNode);

        graphNode.setPosition(TestHelper.getPoint(5, 20));
        graphNode.setSize(TestHelper.getDimension(200, 320));

        // create an actor
        Actor actor = new ActorImpl();

        // set name
        actor.setName("Actor_1");

        // set stereotype
        Stereotype stereotype = new StereotypeImpl();
        stereotype.setName("interface");
        actor.addStereotype(stereotype);

        // set namespace
        Namespace namespace = new MockNamespaceImpl();
        namespace.setName("com.topcoder");
        actor.setNamespace(namespace);

        // create a semantic model
        Uml1SemanticModelBridge semanticModel = new Uml1SemanticModelBridge();
        semanticModel.setElement(actor);

        graphNode.setSemanticModel(semanticModel);

        return graphNode;
    }

    /**
     * <p>
     * This method creates a default graphNode for UseCaseNode.
     * </p>
     * <p>
     * The structure of the GraphNode that corresponds to a UseCase should be:
     * Uml1SemanticModelBridge.element = UML:UseCase
     *   SimpleSemanticModelElement.typeInfo = "NameCompartment"
     *      SimpleSemanticModelElement.typeInfo = "StereotypeCompartment"
     *      SimpleSemanticModelElement.typeInfo = "Name"
     *      SimpleSemanticModelElement.typeInfo = "NamespaceCompartment¡±
     * </p>
     *
     * @return the default graphNode for UseCaseNode
     */
    public static GraphNode createGraphNodeForUseCase() {
        GraphNode graphNode = new GraphNode();
        GraphNode graphNodeName = new GraphNode();

        for (int i = 0; i < 3; i++) {
            GraphNode childNode = new GraphNode();

            childNode.setPosition(TestHelper.getPoint(60, 20 + 20 * i));
            childNode.setSize(TestHelper.getDimension(100, 22));

            graphNodeName.addContained(childNode);
        }

        graphNode.addContained(graphNodeName);

        graphNode.setPosition(TestHelper.getPoint(150, 150));
        graphNode.setSize(TestHelper.getDimension(180, 100));

        // create a use case
        UseCase usecase = new UseCaseImpl();

        // set name
        usecase.setName("Use_Case_1");

        // set stereotype
        Stereotype stereotype = new StereotypeImpl();
        stereotype.setName("utility");
        usecase.addStereotype(stereotype);

        // set namespace
        Namespace namespace = new MockNamespaceImpl();
        namespace.setName("com.topcoder");
        usecase.setNamespace(namespace);

        // create a semantic model
        Uml1SemanticModelBridge semanticModel = new Uml1SemanticModelBridge();
        semanticModel.setElement(usecase);

        graphNode.setSemanticModel(semanticModel);

        return graphNode;
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
     * This method creates a default graphEdge for Edge.
     * </p>
     *
     * @param relationship the relationship model element
     * @return the default graphEdge for Edge
     */
    public static GraphEdge createGraphEdgeForEdge(Relationship relationship) {
        GraphEdge graphEdge = new GraphEdge();

        for (int i = 0; i < 2; i++) {
            GraphNode childNode = new GraphNode();
            childNode.setPosition(TestHelper.getPoint(20, 20 * i));
            childNode.setSize(TestHelper.getDimension(110, 22));
            graphEdge.addContained(childNode);
        }
        setTypeInfo((GraphElement) graphEdge.getContaineds().get(0), "StereotypeCompartment");
        setTypeInfo((GraphElement) graphEdge.getContaineds().get(1), "Name");

        graphEdge.addWaypoint(TestHelper.createDiagramInterchangePoint(100, 100));
        graphEdge.addWaypoint(TestHelper.createDiagramInterchangePoint(250, 200));

        // set name
        relationship.setName("no name");

        // set stereotype
        Stereotype stereotype = new StereotypeImpl();
        stereotype.setName("implicit");
        relationship.addStereotype(stereotype);

        // create a semantic model
        Uml1SemanticModelBridge semanticModel = new Uml1SemanticModelBridge();
        semanticModel.setElement(relationship);

        graphEdge.setSemanticModel(semanticModel);

        return graphEdge;
    }

    /**
     * <p>
     * This method creates a Point instance defined in Diagram Interchange component.
     * </p>
     *
     * @param x the x-coordinate position of the point
     * @param y the y-coordinate position of the points
     *
     * @return the point instance defined in Diagram Interchange component with the given x and y coordinate value.
     */
    public static com.topcoder.diagraminterchange.Point createDiagramInterchangePoint(int x, int y) {
        com.topcoder.diagraminterchange.Point pt = new com.topcoder.diagraminterchange.Point();
        pt.setX(x);
        pt.setY(y);

        return pt;
    }

    /**
     * <p>
     * Gets an instance of <code>Point</code> for accuracy tests.
     * </p>
     *
     * @param x the x coordinate of the point.
     * @param y the y coordinate of the point.
     *
     * @return the instance of <code>Point</code> with the given coordinates
     */
    static Point getPoint(double x, double y) {
        // create the Point.
        Point point = new Point();
        // set the (x, y).
        point.setX(x);
        point.setY(y);

        return point;
    }

    /**
     * <p>
     * Gets an instance of <code>Dimension</code> for accuracy tests.
     * </p>
     *
     * @param width the width of the point.
     * @param height the height of the dimension.
     *
     * @return the instance of <code>Dimension</code> with the given height and width.
     */
    static Dimension getDimension(double width, double height) {
        // create the Dimension.
        Dimension dimension = new Dimension();
        // set the height.
        dimension.setHeight(height);
        // set the width.
        dimension.setWidth(width);

        return dimension;
    }

    /**
     * <p>
     * Create a Name compartment for SubSystem.
     * </p>
     *
     * @return a Name GraphNode element.
     */
    public static GraphNode createNameCompartment() {
        GraphNode name = new GraphNode();

        com.topcoder.diagraminterchange.Point point = new com.topcoder.diagraminterchange.Point();
        point.setX(10.0);
        point.setY(10.0);

        com.topcoder.diagraminterchange.Dimension dimension = new com.topcoder.diagraminterchange.Dimension();
        dimension.setHeight(1);
        dimension.setWidth(1);

        name.setPosition(point);
        name.setSize(dimension);
        return name;
    }

    /**
     * <p>
     * Create a Namespace compartment for SubSystem.
     * </p>
     *
     * @return a Namespace GraphNode element.
     */
    public static GraphNode createNamespaceCompartment() {
        GraphNode namespace = new GraphNode();

        com.topcoder.diagraminterchange.Point point = new com.topcoder.diagraminterchange.Point();
        point.setX(10.0);
        point.setY(10.0);

        com.topcoder.diagraminterchange.Dimension dimension = new com.topcoder.diagraminterchange.Dimension();
        dimension.setHeight(1);
        dimension.setWidth(1);

        namespace.setPosition(point);
        namespace.setSize(dimension);
        return namespace;
    }
}