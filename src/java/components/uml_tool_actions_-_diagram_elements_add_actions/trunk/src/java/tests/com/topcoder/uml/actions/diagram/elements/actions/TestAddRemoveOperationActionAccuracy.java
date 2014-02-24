/*
 * Copyright (C) 2006 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.uml.actions.diagram.elements.actions;

import com.topcoder.diagraminterchange.GraphNode;
import com.topcoder.uml.actions.diagram.elements.accuracytests.EnumUtil;
import com.topcoder.uml.actions.diagram.elements.accuracytests.HelperUtil;
import com.topcoder.uml.actions.diagram.elements.compartmentextraction.ClassifierCompartmentExtractor;

import junit.framework.TestCase;

/**
 * Accuracy test cases for class <code>AddRemoveOperationAction </code>.
 *
 * @author Chenhong
 * @version 1.0
 */
public class TestAddRemoveOperationActionAccuracy extends TestCase {

    /**
     * Test the method for
     * <p>
     * static AddRemoveAction createRemoveOperationAction(CompartmentExtractor extractor, GraphNode operation)
     * </p>
     *
     */
    public void testCreateRemoveOperationAction() {
        GraphNode delimitedSection = new GraphNode();
        delimitedSection.setSemanticModel(HelperUtil.createSimpleSemanticModel(EnumUtil.DELIMITED_SECTION));

        GraphNode root = HelperUtil.createGraphNodeForClassifierCompartment();
        ClassifierCompartmentExtractor extractor = new ClassifierCompartmentExtractor(root);

        AddRemoveAction action = AddRemoveOperationAction.createRemoveOperationAction(extractor, delimitedSection);

        assertNotNull("The AddRemoveOperationAction should be created.", action);
    }

    /**
     * Test method for
     * <p>
     * static AddRemoveAction createAddOperationAction(CompartmentExtractor extractor, GraphNode operation).
     * </p>
     *
     */
    public void testCreateAddOperationAction() {
        GraphNode delimitedSection = new GraphNode();
        delimitedSection.setSemanticModel(HelperUtil.createSimpleSemanticModel(EnumUtil.DELIMITED_SECTION));

        GraphNode root = HelperUtil.createGraphNodeForClassifierCompartment();
        ClassifierCompartmentExtractor extractor = new ClassifierCompartmentExtractor(root);

        AddRemoveAction action = AddRemoveOperationAction.createAddOperationAction(extractor, delimitedSection);

        assertNotNull("The AddRemoveOperationAction should be created.", action);
    }

    /**
     * Test method add operation.
     *
     * <p>
     * The Operation is very similar to Attribute.
     * </p>
     *
     * <p>
     * This test case is very simple. First create a Operation element and try to add it.
     * </p>
     *
     * @throws Exception
     *             to junit.
     *
     */
    public void testExecuteAdd() throws Exception {
        GraphNode subOperation = new GraphNode();
        subOperation.setSemanticModel(HelperUtil.createSimpleSemanticModel(EnumUtil.NAME));

        GraphNode root = HelperUtil.createGraphNodeForClassifierCompartment();
        ClassifierCompartmentExtractor extractor = new ClassifierCompartmentExtractor(root);

        AddRemoveAction action = AddRemoveOperationAction.createAddOperationAction(extractor, subOperation);


        assertEquals("There should be 1 node.", 1, action.getExtractor().extractOperation().countContaineds());

        GraphNode delimitedSectionNode = (GraphNode) action.getExtractor().extractOperation().getContaineds().get(0);

        assertFalse("The subOperation is not added yet.", delimitedSectionNode.containsContained(subOperation));

        // add an operation.
        action.executeAdd();

        delimitedSectionNode = (GraphNode) action.getExtractor().extractOperation().getContaineds().get(0);

        assertTrue("The subOperation should be added.", delimitedSectionNode.containsContained(subOperation));
    }

    /**
     * Test method for remove operation.
     *
     * <p>
     * The logic is very simple. First add and later remove.
     * </p>
     *
     * <p>
     * The structure of Operation is very similar to Attribute. So you can refer to
     * TestAddRemoveAttributeActionAccuracy.java for detail.
     * </p>
     *
     * @throws Exception
     *             to junit.
     */
    public void testExecuteRemove() throws Exception {
        GraphNode subOperation = new GraphNode();
        subOperation.setSemanticModel(HelperUtil.createSimpleSemanticModel(EnumUtil.NAME));

        GraphNode root = HelperUtil.createGraphNodeForClassifierCompartment();
        ClassifierCompartmentExtractor extractor = new ClassifierCompartmentExtractor(root);

        AddRemoveAction action = AddRemoveOperationAction.createAddOperationAction(extractor, subOperation);

        GraphNode delimitedSectionNode = (GraphNode) action.getExtractor().extractOperation().getContaineds().get(0);

        assertFalse("The subOperation is not added yet.", delimitedSectionNode.containsContained(subOperation));

        action.executeAdd();

        delimitedSectionNode = (GraphNode) action.getExtractor().extractOperation().getContaineds().get(0);

        assertTrue("The subOperation should be added.", delimitedSectionNode.containsContained(subOperation));

        action.executeRemove();

        delimitedSectionNode = (GraphNode) action.getExtractor().extractOperation().getContaineds().get(0);

        assertFalse("The subOperation should be removed.", delimitedSectionNode.containsContained(subOperation));
    }
}