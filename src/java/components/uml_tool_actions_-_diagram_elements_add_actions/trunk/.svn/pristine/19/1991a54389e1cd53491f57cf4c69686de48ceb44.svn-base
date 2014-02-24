/*
 * Copyright (C) 2006 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.uml.actions.diagram.elements.actions;

import com.topcoder.diagraminterchange.Dimension;
import com.topcoder.diagraminterchange.GraphNode;
import com.topcoder.diagraminterchange.SimpleSemanticModelElement;
import com.topcoder.diagraminterchange.Uml1SemanticModelBridge;
import com.topcoder.uml.actions.diagram.elements.accuracytests.EnumUtil;
import com.topcoder.uml.actions.diagram.elements.accuracytests.HelperUtil;
import com.topcoder.uml.actions.diagram.elements.actions.AddRemoveAction;
import com.topcoder.uml.actions.diagram.elements.actions.AddRemoveAttributeAction;
import com.topcoder.uml.actions.diagram.elements.compartmentextraction.ClassifierCompartmentExtractor;
import com.topcoder.uml.model.core.Element;
import com.topcoder.uml.model.core.classifiers.ClassImpl;

import junit.framework.TestCase;

/**
 * Accuracy test cases for class <code>AddRemoveAttributeAction </code>.
 *
 * @author Chenhong
 * @version 1.0
 */
public class TestAddRemoveAttributeActionAccuracy extends TestCase {

    /**
     * Test method
     * <p>
     * static AddRemoveAction createRemoveAttributeAction(CompartmentExtractor extractor, GraphNode attribute).
     * </p>
     *
     * @throws Exception
     *             to junit.
     */
    public void testCreateRemoveAttributeAction() throws Exception {

        GraphNode attributeNode = HelperUtil.createGraphNodeForClassifierCompartment();
        ClassifierCompartmentExtractor extractor = new ClassifierCompartmentExtractor(attributeNode);

        GraphNode node = (GraphNode) extractor.extractAttribute();

        AddRemoveAction action = AddRemoveAttributeAction.createRemoveAttributeAction(extractor, node);

        assertNotNull("The AddRemoveAction should be created.", action);
    }

    /**
     * Test method
     * <p>
     * static AddRemoveAction createAddAttributeAction(CompartmentExtractor extractor, GraphNode attribute).
     * </p>
     *
     * @throws Exception
     *             to junit.
     */
    public void testCreateAddAttributeAction() throws Exception {
        GraphNode attributeNode = HelperUtil.createGraphNodeForClassifierCompartment();
        ClassifierCompartmentExtractor extractor = new ClassifierCompartmentExtractor(attributeNode);
        GraphNode node = new GraphNode();
        AddRemoveAction action = AddRemoveAttributeAction.createRemoveAttributeAction(extractor, node);
        assertNotNull("The AddRemoveAction should be created.", action);
    }

    /**
     * Test method executeRemove.
     *
     * <p>
     * The logic for this test case is very simple although there is a large block of code here.
     * <li>First create a GraphNode instance for ClassifierCompartmentExtractor (Please note the blocked code)</li>
     * <li>Check for the containeds.;</li>
     * <li>Do the remove execute.</li>
     * <li>Check for the containeds.</li>
     * </p>
     *
     * @throws Exception
     *             to junit.
     *
     */
    public void testExecuteRemove() throws Exception {
        GraphNode root = new GraphNode();
        root.setSemanticModel(createUmlSemanticModel(new ClassImpl()));

        // create a name compartment and add it to the root GraphNode.
        GraphNode nameCompartment = new GraphNode();
        nameCompartment.setSemanticModel(createSimpleSemanticModel(EnumUtil.NAME_COMPARTMENT));
        root.addContained(nameCompartment);
        nameCompartment.setContainer(root);

        GraphNode stereoTypeNode = new GraphNode();
        stereoTypeNode.setSemanticModel(createSimpleSemanticModel(EnumUtil.STEREOTYPE_COMPARTMENT));
        nameCompartment.addContained(stereoTypeNode);
        stereoTypeNode.setContainer(nameCompartment);

        GraphNode nameNode = new GraphNode();
        nameNode.setSemanticModel(createSimpleSemanticModel(EnumUtil.NAME));
        nameCompartment.addContained(nameNode);
        nameNode.setContainer(nameCompartment);

        GraphNode namespaceNode = new GraphNode();
        namespaceNode.setSemanticModel(createSimpleSemanticModel(EnumUtil.NAMESPACE_COMPARTMENT));
        nameCompartment.addContained(namespaceNode);
        namespaceNode.setContainer(nameCompartment);

        GraphNode compartmentSeperator = new GraphNode();
        compartmentSeperator.setSemanticModel(createSimpleSemanticModel(EnumUtil.COMPARTMENT_SEPERATOR));
        root.addContained(compartmentSeperator);
        compartmentSeperator.setContainer(root);

        GraphNode attribute = new GraphNode();
        attribute.setVisible(true);
        attribute.setSemanticModel(createSimpleSemanticModel(EnumUtil.ATTRIBUTE_COMPARTMENT));

        Dimension d = new Dimension();
        d.setHeight(new Double(1));
        d.setWidth(new Double(10));

        GraphNode delimitedSection = new GraphNode();
        delimitedSection.setSemanticModel(createSimpleSemanticModel(EnumUtil.DELIMITED_SECTION));

        /** ************* Here is sub Node added to the Attribute Compartment node ******** */
        /*
         * The DelimitedSection is the only child for AttributeCompartment. Here, there is one UML:Attribute elements
         * defined.
         */

        GraphNode subAttribute = new GraphNode();
        subAttribute.setSemanticModel(createSimpleSemanticModel(EnumUtil.HEADER_COMPARTMENT));

        delimitedSection.addContained(subAttribute);
        subAttribute.setContainer(delimitedSection);

        attribute.addContained(delimitedSection);
        delimitedSection.setContainer(attribute);

        // Note this subAttribute node should be removed successfully.
        /** *********** Ending for the sub Property. ********************************** */

        root.addContained(attribute);
        attribute.setContainer(root);

        GraphNode node = new GraphNode();
        node.setSemanticModel(createSimpleSemanticModel(EnumUtil.COMPARTMENT_SEPERATOR));

        root.addContained(node);
        node.setContainer(root);

        node = new GraphNode();
        node.setSemanticModel(createSimpleSemanticModel(EnumUtil.OPERATION_COMPARTMENT));

        GraphNode delimitedSectionOperation = new GraphNode();
        delimitedSectionOperation.setSemanticModel(createSimpleSemanticModel(EnumUtil.DELIMITED_SECTION));
        delimitedSectionOperation.setSize(d);
        node.addContained(delimitedSectionOperation);
        delimitedSectionOperation.setContainer(node);

        root.addContained(node);
        node.setContainer(root);

        /** ****************** Ending for create the GraphNode for ClassifierCompartmentExtractor **************** */
        // after the creation of the GraphNode.
        ClassifierCompartmentExtractor extractor = new ClassifierCompartmentExtractor(root);

        AddRemoveAttributeAction action = (AddRemoveAttributeAction) AddRemoveAttributeAction
                .createRemoveAttributeAction(extractor, subAttribute);

        assertEquals("The containeds should be 1.", 1, action.getExtractor().extractAttribute().countContaineds());

        GraphNode delimitedSectionNode = (GraphNode) action.getExtractor().extractAttribute().getContaineds().get(0);

        /*
         * The structure is
         * <pre>
         *  1 level AttributeCompatment element
         *        2 level DelimitedSection element
         *            3 level subAttribute  element.
         * </pre>
         *
         * In this test case, the Attribute Compartment element can be gotten from action.getExtractor().
         * extractAttribute() method.
         *
         * The DelimitedSection element can be gotten from AttributeCompartment instance.getContaineds().get(0) as there
         * will be only one child of AttributeCompartment.
         *
         * At last we check if it is correct removed from the delimitedSection element.
         */
        assertTrue("The subAttribute should be contained in the delimitedSection node.", delimitedSectionNode
                .containsContained(subAttribute));

        // remove the subAttribute GraphNode.
        action.executeRemove();

        delimitedSectionNode = (GraphNode) action.getExtractor().extractAttribute().getContaineds().get(0);

        assertFalse("The subAttribute should be removed", delimitedSectionNode.containsContained(subAttribute));
    }

    /**
     * Test for add.
     *
     * <p>
     * The logic for test add is very simple.
     * <li>First create a attribute element and try to add.</li>
     * Here simply check for the countContaineds property.
     * </p>
     *
     * @throws Exception
     *             to junit.
     *
     */
    public void testExecuteAdd() throws Exception {
        // Create a subAttribute GraphNode instance for adding.
        GraphNode subAttribute = new GraphNode();
        subAttribute.setSemanticModel(createSimpleSemanticModel(EnumUtil.NAME));

        GraphNode root = HelperUtil.createGraphNodeForClassifierCompartment();
        ClassifierCompartmentExtractor extractor = new ClassifierCompartmentExtractor(root);

        AddRemoveAttributeAction action = (AddRemoveAttributeAction) AddRemoveAttributeAction
                .createRemoveAttributeAction(extractor, subAttribute);

        GraphNode delimitedSectionNode = (GraphNode) action.getExtractor().extractAttribute().getContaineds().get(0);

        assertFalse("The subAttribute should be not added yet.", delimitedSectionNode.containsContained(subAttribute));
        // add the attribute node.
        action.executeAdd();

        delimitedSectionNode = (GraphNode) action.getExtractor().extractAttribute().getContaineds().get(0);

        assertTrue("The subAttribute should now be added.", delimitedSectionNode.containsContained(subAttribute));
    }

    /**
     * <p>
     * Greates a SimpleSemanticModelElement instance with the type.
     * </p>
     *
     * @param typeInfo
     *            the type information
     * @return a SimpleSemanticModelElement instance with the given type information.
     */
    private static SimpleSemanticModelElement createSimpleSemanticModel(String typeInfo) {
        SimpleSemanticModelElement semanticModel = new SimpleSemanticModelElement();
        semanticModel.setTypeinfo(typeInfo);
        return semanticModel;
    }

    /**
     * <p>
     * Greates a Uml1SemanticModelBridge instance with the given uml element.
     * </p>
     *
     * @param element
     *            a uml element
     *
     * @return a SimpleSemanticModelElement instance.
     */
    private static Uml1SemanticModelBridge createUmlSemanticModel(Element element) {
        Uml1SemanticModelBridge bridge = new Uml1SemanticModelBridge();
        bridge.setElement(element);
        return bridge;
    }
}