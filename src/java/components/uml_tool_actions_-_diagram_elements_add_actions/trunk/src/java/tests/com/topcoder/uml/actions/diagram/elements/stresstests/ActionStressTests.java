/*
 * Copyright (C) 2006 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.uml.actions.diagram.elements.stresstests;

import com.topcoder.diagraminterchange.Dimension;
import com.topcoder.diagraminterchange.GraphEdge;
import com.topcoder.diagraminterchange.GraphElement;
import com.topcoder.diagraminterchange.GraphNode;

import com.topcoder.uml.actions.diagram.elements.AddDiagramElementAction;
import com.topcoder.uml.actions.diagram.elements.actions.UpdateFirstAssociationEndAction;
import com.topcoder.uml.actions.diagram.elements.actions.UpdateNameAction;
import com.topcoder.uml.actions.diagram.elements.actions.UpdateNamespaceAction;
import com.topcoder.uml.actions.diagram.elements.actions.UpdateSecondAssociationEndAction;
import com.topcoder.uml.actions.diagram.elements.actions.UpdateSizeAction;
import com.topcoder.uml.actions.diagram.elements.actions.UpdateStereotypeAction;
import com.topcoder.uml.actions.diagram.elements.compartmentextraction.AssociationCompartmentExtractor;
import com.topcoder.uml.actions.diagram.elements.compartmentextraction.CompartmentExtractor;
import com.topcoder.uml.actions.diagram.elements.compartmentextraction.DefaultNodeCompartmentExtractor;
import com.topcoder.uml.modelmanager.UMLModelManager;
import com.topcoder.uml.projectconfiguration.ProjectConfigurationManager;

import com.topcoder.util.actionmanager.Action;
import com.topcoder.util.actionmanager.UndoableAction;

import junit.framework.TestCase;


/**
 * Stress test for all Action class.
 *
 * @author lyt
 * @version 1.0
 */
public class ActionStressTests extends TestCase {
    /**
     * <p>
     * Setup test environment.
     * </p>
     *
     * @throws Exception to JUnit.
     */
    protected void setUp() throws Exception {
        StressTestHelper.loadConfig();
    }

    /**
     * <p>
     * Tears down test environment.
     * </p>
     *
     * @throws Exception to JUnit.
     */
    protected void tearDown() throws Exception {
        StressTestHelper.clearConfig();
    }

    /**
     * <p>
     * Stress test for UpdateSizeAction.
     * </p>
     *
     * @throws Exception to JUnit.
     */
    public void testUpdateSizeAction() throws Exception {
        StressTestHelper.startTimer();

        for (int cnt = 0; cnt < StressTestHelper.testCount; ++cnt) {
            // Update the size of element to the new size
            Dimension newSize = new Dimension();
            newSize.setWidth((50 + cnt) % 1000D);
            newSize.setHeight((100 + cnt) % 1000D);

            GraphNode element = new GraphNode();
            UndoableAction action = new UpdateSizeAction(element, newSize);
            action.execute();

            // Undo the last action
            action.undo();

            // Redo the last action
            action.redo();
        }

        StressTestHelper.printTime("UpdateSizeAction#execute()", StressTestHelper.testCount);
    }

    /**
     * <p>
     * Stress test for UpdateNameAction.
     * </p>
     *
     * @throws Exception to JUnit.
     */
    public void testUpdateNameAction() throws Exception {
        StressTestHelper.startTimer();

        GraphEdge edge = StressTestHelper.createGraphEdgeForAssociation();
        CompartmentExtractor extractor = new AssociationCompartmentExtractor(edge);
        GraphElement newElement = extractor.extractName();

        Action action = new UpdateNameAction(extractor, newElement);

        for (int cnt = 0; cnt < StressTestHelper.testCount; ++cnt) {
            action.execute();
        }

        StressTestHelper.printTime("UpdateNameAction#execute()", StressTestHelper.testCount);
    }

    /**
     * <p>
     * Stress test for UpdateNamespaceAction.
     * </p>
     *
     * @throws Exception to JUnit.
     */
    public void testUpdateNamespaceAction() throws Exception {
        StressTestHelper.startTimer();

        GraphNode node = StressTestHelper.createGraphNodeForClassifier();
        CompartmentExtractor extractor = new DefaultNodeCompartmentExtractor(node);
        GraphElement newElement = extractor.extractNamespace();

        Action action = new UpdateNamespaceAction(extractor, newElement);

        for (int cnt = 0; cnt < StressTestHelper.testCount; ++cnt) {
            action.execute();
        }

        StressTestHelper.printTime("UpdateNamespaceAction#execute()", StressTestHelper.testCount);
    }

    /**
     * <p>
     * Stress test for UpdateStereotypeAction.
     * </p>
     *
     * @throws Exception to JUnit.
     */
    public void testUpdateStereotypeAction() throws Exception {
        StressTestHelper.startTimer();

        GraphEdge edge = StressTestHelper.createGraphEdgeForAssociation();
        CompartmentExtractor extractor = new AssociationCompartmentExtractor(edge);
        GraphElement newElement = extractor.extractStereotype();

        Action action = new UpdateStereotypeAction(extractor, newElement);

        for (int cnt = 0; cnt < StressTestHelper.testCount; ++cnt) {
            action.execute();
        }

        StressTestHelper.printTime("UpdateStereotypeAction#execute()", StressTestHelper.testCount);
    }

    /**
     * <p>
     * Stress test for AddDiagramElementAction.
     * </p>
     *
     * @throws Exception to JUnit.
     */
    public void testAddDiagramElementAction1() throws Exception {
        StressTestHelper.startTimer();

        GraphNode curNode = new GraphNode();

        for (int cnt = 0; cnt < StressTestHelper.testCount; ++cnt) {
            GraphNode child = new GraphNode();

            ProjectConfigurationManager manager = new ProjectConfigurationManager(new UMLModelManager());

            // create an AddDiagramElementAction instance
            UndoableAction action = new AddDiagramElementAction(curNode, child, manager);

            action.execute();
            action.undo();
            action.redo();
            curNode = child;
        }

        StressTestHelper.printTime("AddDiagramElementAction#execute()", StressTestHelper.testCount);
    }

    /**
     * <p>
     * Stress test for AddDiagramElementAction.
     * </p>
     *
     * @throws Exception to JUnit.
     */
    public void testAddDiagramElementAction2() throws Exception {
        StressTestHelper.startTimer();

        GraphNode curNode = new GraphNode();

        for (int cnt = 0; cnt < StressTestHelper.testCount; ++cnt) {
            GraphNode child = new GraphNode();

            ProjectConfigurationManager manager = new ProjectConfigurationManager(new UMLModelManager());

            // create an AddDiagramElementAction instance
            UndoableAction action = new AddDiagramElementAction(curNode, child, manager);

            action.execute();
            action.undo();
            action.redo();
        }

        StressTestHelper.printTime("AddDiagramElementAction#execute()", StressTestHelper.testCount);
    }

    /**
     * <p>
     * Stress test for UpdateFirstAssociationEndAction.
     * </p>
     *
     * @throws Exception to JUnit.
     */
    public void testUpdateFirstAssociationEndAction() throws Exception {
        StressTestHelper.startTimer();

        GraphEdge edge = StressTestHelper.createGraphEdgeForAssociation();
        CompartmentExtractor extractor = new AssociationCompartmentExtractor(edge);
        GraphElement newElement = extractor.extractSecondAssociationEnd();

        Action action = new UpdateFirstAssociationEndAction(extractor, newElement);

        for (int cnt = 0; cnt < StressTestHelper.testCount; ++cnt) {
            action.execute();
        }

        StressTestHelper.printTime("UpdateFirstAssociationEndAction#execute()", StressTestHelper.testCount);
    }

    /**
     * <p>
     * Stress test for UpdateSecondAssociationEndAction.
     * </p>
     *
     * @throws Exception to JUnit.
     */
    public void testUpdateSecondAssociationEndAction()
        throws Exception {
        StressTestHelper.startTimer();

        GraphEdge edge = StressTestHelper.createGraphEdgeForAssociation();
        CompartmentExtractor extractor = new AssociationCompartmentExtractor(edge);
        GraphElement newElement = extractor.extractFirstAssociationEnd();

        Action action = new UpdateSecondAssociationEndAction(extractor, newElement);

        for (int cnt = 0; cnt < StressTestHelper.testCount; ++cnt) {
            action.execute();
        }

        StressTestHelper.printTime("UpdateSecondAssociationEndAction#execute()", StressTestHelper.testCount);
    }
}
