/*
 * Copyright (C) 2007 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.gui.diagramviewer.uml.usecaseelements.accuracytests;

import java.util.HashMap;
import java.util.Map;

import javax.swing.TransferHandler;

import junit.framework.TestCase;

import com.topcoder.diagraminterchange.Dimension;
import com.topcoder.diagraminterchange.GraphEdge;
import com.topcoder.diagraminterchange.GraphNode;
import com.topcoder.diagraminterchange.Point;
import com.topcoder.diagraminterchange.Property;
import com.topcoder.diagraminterchange.Uml1SemanticModelBridge;
import com.topcoder.gui.diagramviewer.uml.usecaseelements.IllegalGraphElementException;
import com.topcoder.gui.diagramviewer.uml.usecaseelements.SubsystemNodeContainer;
import com.topcoder.uml.model.core.Namespace;
import com.topcoder.uml.model.core.extensionmechanisms.Stereotype;
import com.topcoder.uml.model.core.extensionmechanisms.StereotypeImpl;
import com.topcoder.uml.model.core.relationships.Relationship;
import com.topcoder.uml.model.modelmanagement.Subsystem;
import com.topcoder.uml.model.modelmanagement.SubsystemImpl;
import com.topcoder.uml.model.usecases.Actor;
import com.topcoder.uml.model.usecases.ActorImpl;
import com.topcoder.uml.model.usecases.IncludeImpl;
import com.topcoder.uml.model.usecases.UseCase;
import com.topcoder.uml.model.usecases.UseCaseImpl;

/**
 * <p>
 * A helper class to create relative instance for testing..
 * </p>
 *
 * @author radium
 * @version 1.0
 */
public class AccuracyTestHelper {
    /**
     * <p>
     * This private constructor prevents creating a new instance.
     * </p>
     */
    private AccuracyTestHelper() {
        // empty
    }

    /**
     * <p>
     * Creates a SubsystemNodeContainer instance for testing.
     * </p>
     *
     * @return SubsystemNodeContainer.
     */
    public static SubsystemNodeContainer createSubsystemNodeContainer() {
        Map<String, String> properties = new HashMap<String, String>();
        properties.put("String", "String");
        TransferHandler handler = new TransferHandler("");
        SubsystemNodeContainer snc = null;
        try {
            snc = new SubsystemNodeContainer(AccuracyTestHelper.createGraphNodeForSubsystem(), properties, handler);
        } catch (IllegalGraphElementException e) {
            TestCase.fail("Should not throw exception here.");
        }
        return snc;
    }

    /**
     * <p>
     * This method creates a <code>Property</code> defined in Diagram
     * Interchange component.
     * </p>
     *
     * @param key
     *            the property key
     * @param value
     *            the property value
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
     * This method creates a default graphNode for SubsystemNodeContainer.
     * </p>
     *
     * @return the default graphNode for SubsystemNodeContainer
     */
    public static GraphNode createGraphNodeForSubsystem() {
        GraphNode nameNode = new GraphNode();

        for (int i = 0; i < 3; i++) {
            GraphNode childNode = new GraphNode();

            childNode.setPosition(AccuracyTestHelper.createPoint(0, 12 * i));
            childNode.setSize(AccuracyTestHelper.createDimension(100, 22));

            nameNode.addContained(childNode);
        }

        nameNode.setPosition(AccuracyTestHelper.createPoint(20, 20));
        nameNode.setSize(AccuracyTestHelper.createDimension(100, 100));

        GraphNode graphNode = new GraphNode();
        graphNode.addContained(nameNode);
        graphNode.addContained(new GraphNode());

        graphNode.setPosition(AccuracyTestHelper.createPoint(20, 20));
        graphNode.setSize(AccuracyTestHelper.createDimension(1000, 1000));

        // create a subsystem
        Subsystem subsystem = new SubsystemImpl();

        // set namespace
        Namespace namespace = new MockNamespaceImplAcucracy();
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
     *
     * @return the default graphNode for ActorNode
     */
    public static GraphNode createGraphNodeForActor() {
        GraphNode graphNode = new GraphNode();

        for (int i = 0; i < 3; i++) {
            GraphNode childNode = new GraphNode();

            childNode.setPosition(AccuracyTestHelper.createPoint(0, 12 * i));
            childNode.setSize(AccuracyTestHelper.createDimension(100, 22));

            graphNode.addContained(childNode);
        }

        graphNode.setPosition(AccuracyTestHelper.createPoint(20, 20));
        graphNode.setSize(AccuracyTestHelper.createDimension(100, 100));

        // create an actor
        Actor actor = new ActorImpl();


        // set stereotype
        Stereotype stereotype = new StereotypeImpl();
        actor.addStereotype(stereotype);

        // set namespace
        Namespace namespace = new MockAccuracyNamespaceImpl();
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
     *
     * @return the default graphNode for UseCaseNode
     */
    public static GraphNode createGraphNodeForUseCase() {
        GraphNode graphNode = new GraphNode();
        GraphNode graphNodeName = new GraphNode();

        for (int i = 0; i < 3; i++) {
            GraphNode childNode = new GraphNode();

            childNode.setPosition(AccuracyTestHelper.createPoint(60, 20 + 20 * i));
            childNode.setSize(AccuracyTestHelper.createDimension(100, 22));

            graphNodeName.addContained(childNode);
        }

        graphNode.addContained(graphNodeName);

        graphNode.setPosition(AccuracyTestHelper.createPoint(20, 20));
        graphNode.setSize(AccuracyTestHelper.createDimension(100, 100));

        // create a use case
        UseCase usecase = new UseCaseImpl();

        // set stereotype
        Stereotype stereotype = new StereotypeImpl();
        usecase.addStereotype(stereotype);

        // set namespace
        Namespace namespace = new MockAccuracyNamespaceImpl();
        usecase.setNamespace(namespace);

        // create a semantic model
        Uml1SemanticModelBridge semanticModel = new Uml1SemanticModelBridge();
        semanticModel.setElement(usecase);

        graphNode.setSemanticModel(semanticModel);

        return graphNode;
    }

    /**
     * <p>
     * This method creates a default graphEdge for Edge.
     * </p>
     *
     * @return the default graphEdge for Edge
     */
    public static GraphEdge createGraphEdgeForEdge() {
        GraphEdge graphEdge = new GraphEdge();

        for (int i = 0; i < 2; i++) {
            GraphNode childNode = new GraphNode();
            childNode.setPosition(AccuracyTestHelper.createPoint(20 * i, 10));
            childNode.setSize(AccuracyTestHelper.createDimension(40, 12));
            graphEdge.addContained(childNode);
        }
        graphEdge.addWaypoint(AccuracyTestHelper.createDiagramInterchangePoint(100, 100));
        graphEdge.addWaypoint(AccuracyTestHelper.createDiagramInterchangePoint(250, 200));

        // create a Relationship
        Relationship relationship = new IncludeImpl();

        // set stereotype
        Stereotype stereotype = new StereotypeImpl();

        // create a semantic model
        Uml1SemanticModelBridge semanticModel = new Uml1SemanticModelBridge();
        semanticModel.setElement(relationship);

        graphEdge.setSemanticModel(semanticModel);

        return graphEdge;
    }

    /**
     * <p>
     * This method creates a Point instance defined in Diagram Interchange
     * component.
     * </p>
     *
     * @param x
     *            the x-coordinate position of the point
     * @param y
     *            the y-coordinate position of the points
     * @return the point instance defined in Diagram Interchange component with
     *         the given x and y coordinate value.
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
     * @param x
     *            the x coordinate of the point.
     * @param y
     *            the y coordinate of the point.
     * @return the instance of <code>Point</code> with the given coordinates
     */
    public static Point createPoint(double x, double y) {
        Point point = new Point();
        point.setX(x);
        point.setY(y);

        return point;
    }

    /**
     * <p>
     * Gets an instance of Dimension for accuracy tests.
     * </p>
     *
     * @param width
     *            the width of the point.
     * @param height
     *            the height of the dimension.
     * @return the instance of <code>Dimension</code> with the given height
     *         and width.
     */
    public static Dimension createDimension(double width, double height) {
        Dimension dimension = new Dimension();
        dimension.setHeight(height);
        dimension.setWidth(width);
        return dimension;
    }

    /**
     * Create an ActorNode for testing AcotorConnector.
     *
     * @return ActorNode.
     */
    public static GraphNode createGraphNodeForActorConnector() {
        GraphNode graphNode = new GraphNode();

        for (int i = 0; i < 3; i++) {
            GraphNode childNode = new GraphNode();

            childNode.setPosition(AccuracyTestHelper.createPoint(0, 12 * i));
            childNode.setSize(AccuracyTestHelper.createDimension(100, 22));

            graphNode.addContained(childNode);
        }

        graphNode.setPosition(AccuracyTestHelper.createPoint(0, 0));
        graphNode.setSize(AccuracyTestHelper.createDimension(100, 100));

        // create an actor
        Actor actor = new ActorImpl();



        // set stereotype
        Stereotype stereotype = new StereotypeImpl();


        // set namespace
        Namespace namespace = new MockAccuracyNamespaceImpl();
        actor.setNamespace(namespace);

        // create a semantic model
        Uml1SemanticModelBridge semanticModel = new Uml1SemanticModelBridge();
        semanticModel.setElement(actor);

        graphNode.setSemanticModel(semanticModel);

        return graphNode;
    }

    /**
     * Create UseCaseNode for UseCaseConnector testing.
     *
     * @return UseCaseNode.
     */
    public static GraphNode createGraphNodeForUseCaseConnector() {
        GraphNode graphNode = new GraphNode();
        GraphNode graphNodeName = new GraphNode();

        for (int i = 0; i < 3; i++) {
            GraphNode childNode = new GraphNode();

            childNode.setPosition(AccuracyTestHelper.createPoint(60, 20 + 20 * i));
            childNode.setSize(AccuracyTestHelper.createDimension(100, 22));

            graphNodeName.addContained(childNode);
        }
        graphNode.addContained(graphNodeName);

        graphNode.setPosition(AccuracyTestHelper.createPoint(-50, -50));
        graphNode.setSize(AccuracyTestHelper.createDimension(100, 100));

        // create a use case
        UseCase usecase = new UseCaseImpl();

        // set stereotype
        Stereotype stereotype = new StereotypeImpl();

        // set namespace
        Namespace namespace = new MockAccuracyNamespaceImpl();
        usecase.setNamespace(namespace);
        // create a semantic model
        Uml1SemanticModelBridge semanticModel = new Uml1SemanticModelBridge();
        semanticModel.setElement(usecase);

        graphNode.setSemanticModel(semanticModel);

        return graphNode;
    }

}
