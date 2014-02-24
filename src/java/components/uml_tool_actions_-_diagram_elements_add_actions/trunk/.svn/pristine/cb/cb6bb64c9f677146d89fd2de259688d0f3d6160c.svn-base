/*
 * Copyright (C) 2006 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.uml.actions.diagram.elements;

import com.topcoder.diagraminterchange.Dimension;
import com.topcoder.diagraminterchange.GraphElement;
import com.topcoder.diagraminterchange.GraphNode;
import com.topcoder.uml.actions.diagram.elements.actions.AddRemoveAttributeAction;
import com.topcoder.uml.actions.diagram.elements.actions.UpdateNameAction;
import com.topcoder.uml.actions.diagram.elements.actions.UpdateNamespaceAction;
import com.topcoder.uml.actions.diagram.elements.actions.UpdateSizeAction;
import com.topcoder.uml.actions.diagram.elements.actions.UpdateStereotypeAction;
import com.topcoder.uml.actions.diagram.elements.compartmentextraction.CompartmentExtractor;
import com.topcoder.uml.actions.diagram.elements.compartmentextraction.CompartmentExtractorFactory;
import com.topcoder.uml.actions.diagram.elements.compartmentextraction.ObjectType;
import com.topcoder.uml.modelmanager.UMLModelManager;
import com.topcoder.uml.projectconfiguration.ProjectConfigurationManager;
import com.topcoder.util.actionmanager.UndoableAction;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

/**
 * <p>
 * The unit test class is used for component demonstration.
 * </p>
 *
 * @author TCSDEVELOPER
 * @version 1.0
 */
public class DemoTests extends TestCase {
    /**
     * <p>
     * Setup test environment.
     * </p>
     *
     * @throws Exception to JUnit.
     */
    protected void setUp() throws Exception {
        TestHelper.loadSingleXMLConfig(ProjectConfigurationManager.class.getName(), "test_files/config.xml");
        TestHelper.loadSingleXMLConfig(ProjectConfigurationManager.class.getName() + ".objectfactory",
            "test_files/objectfactory.xml");
    }

    /**
     * <p>
     * Tears down test environment.
     * </p>
     *
     * @throws Exception to JUnit.
     */
    protected void tearDown() throws Exception {
        TestHelper.clearConfigFile(ProjectConfigurationManager.class.getName());
        TestHelper.clearConfigFile(ProjectConfigurationManager.class.getName() + ".objectfactory");
    }

    /**
     * <p>
     * Return all tests.
     * </p>
     *
     * @return all tests
     */
    public static Test suite() {
        return new TestSuite(DemoTests.class);
    }

    /**
     * <p>
     * This test case demonstrates the scenario that update the size of an element.
     * </p>
     *
     * @throws Exception to JUnit.
     */
    public void testUpdateSizeOfElement() throws Exception {
        // Update the size of element to the new size
        Dimension newSize = new Dimension();
        newSize.setWidth(50D);
        newSize.setHeight(123D);

        GraphNode element = new GraphNode();
        UndoableAction action = new UpdateSizeAction(element, newSize);
        action.execute();

        // Undo the last action
        action.undo();

        // Redo the last action
        action.redo();
    }

    /**
     * <p>
     * This test case demonstrates the scenario that add a new child element to a parent element.
     * </p>
     *
     * @throws Exception to JUnit.
     */
    public void testAddNewElement() throws Exception {
        // The parent element to add a child element
        GraphNode parent = new GraphNode();

        // a GraphElement corresponds to child to be added.
        GraphNode child = new GraphNode();

        // create a project configuration manager
        ProjectConfigurationManager manager = new ProjectConfigurationManager(new UMLModelManager());

        // create an AddDiagramElementAction instance
        UndoableAction action = new AddDiagramElementAction(parent, child, manager);

        action.execute();
        action.undo();
        action.redo();
        action.undo();
    }

    /**
     * <p>
     * This test case demonstrates the scenario that update the name of an Final Node GraphNode element.
     * </p>
     *
     * @throws Exception to JUnit.
     */
    public void testUpdateFinalNode() throws Exception {
        // creates a final node
        GraphNode finalNodeElement = TestHelper.createGraphNodeForClassifier();

        // creates a new name compartment
        GraphElement name = new GraphNode();
        name.setSemanticModel(TestHelper.createSimpleSemanticModel("Name"));

        // update the name of the final node
        CompartmentExtractorFactory factory = new CompartmentExtractorFactory();
        CompartmentExtractor extractor = factory.createCompartmentExtractor(ObjectType.Interface, finalNodeElement);
        UndoableAction action = new UpdateNameAction(extractor, name);

        action.execute();
    }

    /**
     * <p>
     * This test case demonstrates the scenario that update the stereotype of an Synchronize
     * Message element.
     * </p>
     *
     * @throws Exception to JUnit.
     */
    public void testUpdateSynchronizeMessage() throws Exception {
        // creates a Synchronize Message node
        GraphNode syncmsg = TestHelper.createGraphNodeForMessage();

        // creates a new stereotype compartment
        GraphElement stereotype = new GraphNode();
        stereotype.setSemanticModel(TestHelper.createSimpleSemanticModel("StereotypeCompartment"));

        // update the stereotype of the Synchronize Message element
        CompartmentExtractorFactory factory = new CompartmentExtractorFactory();
        CompartmentExtractor extractor = factory.createCompartmentExtractor(ObjectType.SynchronousMessage, syncmsg);
        UndoableAction action = new UpdateStereotypeAction(extractor, stereotype);

        action.execute();
    }

    /**
     * <p>
     * This test case demonstrates the scenario that update the namespace of a Use Case GraphNode element.
     * </p>
     *
     * @throws Exception to JUnit.
     */
    public void testUpdateUseCaseGraphNode() throws Exception {
        // creates a Use Case element
        GraphNode usecase = TestHelper.createGraphNodeForDefaultNode();

        // creates a new namespace node
        GraphElement namespace = new GraphNode();
        namespace.setSemanticModel(TestHelper.createSimpleSemanticModel("NamespaceCompartment"));

        // update the namespace of a Use Case GraphNode element.
        CompartmentExtractorFactory factory = new CompartmentExtractorFactory();
        CompartmentExtractor extractor = factory.createCompartmentExtractor(ObjectType.UseCase, usecase);
        UndoableAction action = new UpdateNamespaceAction(extractor, namespace);

        action.execute();
    }

    /**
     * <p>
     * This test case demonstrates the scenario that add a new attribute to an Exception element.
     * </p>
     *
     * @throws Exception to JUnit.
     */
    public void testAddNewAttribute() throws Exception {
        // creates an exception element
        GraphNode element = TestHelper.createGraphNodeForClassifier();

        // creates a new attribute element
        GraphNode attribute = new GraphNode();

        // add the new attribute to the exception
        CompartmentExtractorFactory factory = new CompartmentExtractorFactory();
        CompartmentExtractor extractor = factory.createCompartmentExtractor(ObjectType.Exception, element);
        UndoableAction action = AddRemoveAttributeAction.createAddAttributeAction(extractor, attribute);

        action.execute();
    }
}
