/*
 * Copyright (C) 2006 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.uml.actions.diagram.elements.accuracytests;

import com.topcoder.diagraminterchange.Dimension;
import com.topcoder.diagraminterchange.GraphNode;
import com.topcoder.diagraminterchange.SimpleSemanticModelElement;
import com.topcoder.uml.actions.diagram.elements.compartmentextraction.ClassifierCompartmentExtractor;

import junit.framework.TestCase;

/**
 * Accuracy test cases for class <code>ClassifierCompartmentExtractor </code>.
 *
 * @author Chenhong
 * @version 1.0
 */
public class TestClassifierCompartmentExtractorAccuracy extends TestCase {

    /**
     * Represents the ClassifierCompartmentExtractor instance for testing.
     */
    private ClassifierCompartmentExtractor extractor = null;

    /**
     * Set up.
     */
    public void setUp() {
        GraphNode node = HelperUtil.createGraphNodeForClassifierCompartment();

        extractor = new ClassifierCompartmentExtractor(node);
    }

    /**
     * Test the constructor.
     *
     */
    public void testClassifierCompartmentExtractor() {
        assertNotNull("The ClassifierCompartmentExtractor instance should be created.", extractor);
    }

    /**
     * Test method extractAttribute compartment.
     * <p>
     * Attribute compartment will have only one child which is DelimitedSection element.
     *
     * <pre>
     *    SimpleSemanticModelElement.typeInfo = &quot;AttributeCompartment&amp;rdquo
     *                  SimpleSemanticModelElement.typeInfo = &quot;DelimitedSection&quot;
     *                        Uml1SemanticModelBridge.element = &lt;UML:Attribute&gt;
     *                        Uml1SemanticModelBridge.element = &lt;UML:Attribute&gt;
     *                        repeat...
     * </pre>
     *
     * </p>
     *
     * @throws Exception
     *             to junit.
     */
    public void testExtractAttribute() throws Exception {
        GraphNode back = (GraphNode) extractor.extractAttribute();

        Dimension d = back.getSize();
        assertTrue("The height should be 1.", d.getHeight() == 1);
        assertTrue("The width should be 10.", d.getWidth() == 10);

        // there should be one DelimitedSecion attribute under the attribute compartment.

        assertEquals("There should  1 attribute property.", 1, back.countContaineds());
    }

    /**
     * Test method updateAttribute.
     *
     * <p>
     * This test case is very simple. As there is only one child for AttributeCompartment.
     * we only have to create an element of DelimitedSection which contains a set of UML:Attribute
     * and try to update it to the former one. In this test case, there is no child UML:Attribute.
     * <p>
     *
     * @throws Exception
     *             to junit.
     */
    public void testUpdateAttribute() throws Exception {
        SimpleSemanticModelElement semanticModel = new SimpleSemanticModelElement();

        GraphNode attribute = new GraphNode();
        semanticModel.setTypeinfo(EnumUtil.ATTRIBUTE_COMPARTMENT);
        attribute.setSemanticModel(semanticModel);
        attribute.setVisible(true);


        GraphNode delimitedSection = new GraphNode();
        SimpleSemanticModelElement semanticModel2 = new SimpleSemanticModelElement();
        semanticModel2.setTypeinfo(EnumUtil.DELIMITED_SECTION);
        delimitedSection.setSemanticModel(semanticModel2);

        GraphNode subAttribute = new GraphNode();

        // add one attribute into the DelimitedSection.
        SimpleSemanticModelElement  model = new SimpleSemanticModelElement();
        model.setTypeinfo("Exception");
        subAttribute.setSemanticModel(model);

        delimitedSection.addContained(subAttribute);
        subAttribute.setContainer(delimitedSection);

        attribute.addContained(delimitedSection);
        delimitedSection.setContainer(attribute);


        extractor.updateAttribute(attribute);

        GraphNode back = (GraphNode) extractor.extractAttribute();

        assertTrue("The visible should be updated to true.", back.isVisible());

        assertEquals("There should be 1 DelimitedSection element.", 1, back.countContaineds());

        GraphNode delimitedNode = (GraphNode) back.getContaineds().get(0);

        assertEquals("There should be 1 subOperation.", 1, delimitedNode.countContaineds());

    }

    /**
     * Test method extractOperation.
     *
     * <p>
     * for this Operation compartment the structure looks like this
     * <pre>
     *      SimpleSemanticModelElement.typeInfo = &quot;OperationCompartment&amp;rdquo
     *            SimpleSemanticModelElement.typeInfo = &quot;DelimitedSection&quot;
     *               Uml1SemanticModelBridge.element = &lt;UML:Operation&gt;
     *               Uml1SemanticModelBridge.element = &lt;UML:Operation&gt;
     *               repeat...
     * </pre>
     * </p>
     *
     * <p>
     * There should be one child for OperationCompartment which is DelimitedSection element.
     * And the DelimitedSection element will contain a set of UML:Operation.
     * </p>
     *
     * @throws Exception
     *             to junit.
     *
     */
    public void testExtractOperation() throws Exception {
        GraphNode operationNode = (GraphNode) extractor.extractOperation();

        // check the size for the Operation Compartment.
        Dimension d = operationNode.getSize();
        assertTrue("The height should be 1.", d.getHeight() == 1);
        assertTrue("The width should be 10.", d.getWidth() == 10);

        assertEquals("There should be 1 child.", 1, operationNode.countContaineds());
    }

    /**
     * Test method updateOperation.
     *
     * <p>
     * This test case is very simple. The DelimitedSection will have no UML:Operation element and try to update.
     * </p>
     *
     * @throws Exception
     *             to junit.
     */
    public void testUpdateOperation() throws Exception {
        // create a Operation compartment instance.
        GraphNode operation = new GraphNode();
        SimpleSemanticModelElement semanticModel = new SimpleSemanticModelElement();
        semanticModel.setTypeinfo(EnumUtil.OPERATION_COMPARTMENT);

        operation.setSemanticModel(semanticModel);

        // create DelimitedSection element and set DelimitedSection element to the child of Operation
        // Compartment element.
        GraphNode delimitedSection = new GraphNode();
        SimpleSemanticModelElement semanticModel2 = new SimpleSemanticModelElement();
        semanticModel2.setTypeinfo(EnumUtil.DELIMITED_SECTION);
        delimitedSection.setSemanticModel(semanticModel2);

        operation.setVisible(true);

        // create one UML:Operation element.

        GraphNode subOperation = new GraphNode();
        SimpleSemanticModelElement model = new SimpleSemanticModelElement();
        model.setTypeinfo("Excetpion");

        subOperation.setSemanticModel(model);

        delimitedSection.addContained(subOperation);
        subOperation.setContainer(delimitedSection);

        operation.addContained(delimitedSection);
        delimitedSection.setContainer(operation);

        // update the operation compartment.
        extractor.updateOperation(operation);

        GraphNode back = (GraphNode) extractor.extractOperation();

        assertTrue("The visible should be updated to true.", back.isVisible());

        assertEquals("There should be 1 DelimitedSection element.", 1, back.countContaineds());

        GraphNode delimitedNode = (GraphNode) back.getContaineds().get(0);

        assertEquals("There should be 1 subOperation.", 1, delimitedNode.countContaineds());
    }
}