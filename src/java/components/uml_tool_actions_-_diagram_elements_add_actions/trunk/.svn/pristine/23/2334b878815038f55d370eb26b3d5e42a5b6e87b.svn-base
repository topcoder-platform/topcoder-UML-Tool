/*
 * Copyright (C) 2006 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.uml.actions.diagram.elements.accuracytests;

import com.topcoder.diagraminterchange.Dimension;
import com.topcoder.diagraminterchange.GraphEdge;
import com.topcoder.diagraminterchange.GraphNode;
import com.topcoder.diagraminterchange.SimpleSemanticModelElement;
import com.topcoder.diagraminterchange.Uml1SemanticModelBridge;
import com.topcoder.uml.actions.diagram.elements.compartmentextraction.AssociationCompartmentExtractor;
import com.topcoder.uml.model.core.Element;
import com.topcoder.uml.model.core.relationships.AssociationEndImpl;

import junit.framework.TestCase;

/**
 * Accuracy test cases for class <code>AssociationCompartmentExtractor </code>.
 *
 * @author Chenhong
 * @version 1.0
 */
public class TestAssociationCompartmentExtractorAccuracy extends TestCase {

    /**
     * Represents the AssociationCompartmentExtractor instance for testing.
     */
    private AssociationCompartmentExtractor extractor = null;

    /**
     * Test the constructor.
     *
     */
    public void testAssociationCompartmentExtractor() {
        GraphEdge edge = new GraphEdge();
        extractor = new AssociationCompartmentExtractor(edge);

        assertNotNull("The AssociationCompartmentExtractor instance should be created.", extractor);
    }

    /**
     * Test method <code>GraphElement extractName() </code>.
     *
     * <p>
     * Mainly check for the Dimension property.
     * </p>
     *
     * @throws Exception to junit.
     */
    public void testExtractName() throws Exception {
        GraphEdge edge = HelperUtil.createGraphEdgeInstanceForAssociationCompartment();

        extractor = new AssociationCompartmentExtractor(edge);

        GraphNode back = (GraphNode) extractor.extractName();

        Dimension size = back.getSize();

        assertTrue("The height should be 100.", size.getHeight() == 100);
        assertTrue("The width should be 1000.", size.getWidth() == 1000);
    }

    /**
     * Test method for updateName.
     *
     * @throws Exception to junit.
     *
     */
    public void testUpdateName() throws Exception {
        GraphEdge edge = HelperUtil.createGraphEdgeInstanceForAssociationCompartment();
        extractor = new AssociationCompartmentExtractor(edge);


        GraphNode node = new GraphNode();

        SimpleSemanticModelElement semanticModel = new SimpleSemanticModelElement();
        semanticModel.setTypeinfo(EnumUtil.NAME);

        node.setSemanticModel(semanticModel);

        Dimension dimension = new Dimension();
        dimension.setHeight(new Double(10));
        dimension.setWidth(new Double(100));

        node.setSize(dimension);

        // update the Name compartment.
        extractor.updateName(node);

        GraphNode back = (GraphNode) extractor.extractName();
        Dimension size = back.getSize();

        assertTrue("The height should be 10.", size.getHeight() == 10);
        assertTrue("The width should be 100.", size.getWidth() == 100);
    }

    /**
     * Test method extractStereotype.
     *
     * @throws Exception to junit.
     */
    public void testExtractStereotype() throws Exception {
        GraphEdge edge = HelperUtil.createGraphEdgeInstanceForAssociationCompartment();
        extractor = new AssociationCompartmentExtractor(edge);

        GraphNode back  = (GraphNode) extractor.extractStereotype();

        Dimension size = back.getSize();

        assertTrue("The height should be 100.", size.getHeight() == 100);
        assertTrue("The width should be 1000.", size.getWidth() == 1000);
    }

    /**
     * Test method updateStereotype.
     *
     * @throws Exception to junit.
     */
    public void testUpdateStereotype() throws Exception  {
        GraphEdge edge = HelperUtil.createGraphEdgeInstanceForAssociationCompartment();
        extractor = new AssociationCompartmentExtractor(edge);

        GraphNode node = new GraphNode();

        SimpleSemanticModelElement semanticModel = new SimpleSemanticModelElement();
        semanticModel.setTypeinfo(EnumUtil.STEREOTYPE_COMPARTMENT);

        node.setSemanticModel(semanticModel);

        Dimension dimension = new Dimension();
        dimension.setHeight(new Double(10));
        dimension.setWidth(new Double(100));

        node.setSize(dimension);

        // update the stereotype node.
        extractor.updateStereotype(node);

        GraphNode back = (GraphNode) extractor.extractStereotype();

        Dimension d = back.getSize();

        assertTrue("The height should be 10.", d.getHeight()  == 10);
        assertTrue("The width should be 100.", d.getWidth() == 100);
    }

    /**
     * Test method extractFirstAssociationEnd.
     *
     * @throws Exception to junit.
     *
     */
    public void testExtractFirstAssociationEnd() throws Exception {
        GraphEdge edge = HelperUtil.createGraphEdgeInstanceForAssociationCompartment();
        extractor = new AssociationCompartmentExtractor(edge);


        GraphNode back = (GraphNode) extractor.extractFirstAssociationEnd();
        Dimension size = back.getSize();

        assertTrue("The height should be 100.", size.getHeight() == 100);
        assertTrue("The width should be 1000.", size.getWidth() == 1000);
    }

    /**
     * Test method updateFirstAssociationEnd.
     *
     * @throws Exception to junit.
     *
     */
    public void testUpdateFirstAssociationEnd() throws Exception {
        GraphEdge edge = HelperUtil.createGraphEdgeInstanceForAssociationCompartment();
        extractor = new AssociationCompartmentExtractor(edge);

        Dimension d = new Dimension();
        d.setHeight(new Double(1));
        d.setWidth(new Double(10));

        GraphNode firstAssociationEndNode = new GraphNode();
        firstAssociationEndNode.setSemanticModel(createUmlSemanticModel(new AssociationEndImpl()));
        firstAssociationEndNode.setSize(d);


        extractor.updateFirstAssociationEnd(firstAssociationEndNode);

        GraphNode back = (GraphNode) extractor.extractFirstAssociationEnd();

        Dimension size = back.getSize();
        assertTrue("The height should be 1.", size.getHeight() == 1);
        assertTrue("The width should be 10.", size.getWidth() == 10);

    }

    /**
     * Test method extractSecondAssociationEnd.
     *
     * @throws Exception to junit.
     */
    public void testExtractSecondAssociationEnd() throws Exception  {
        GraphEdge edge = HelperUtil.createGraphEdgeInstanceForAssociationCompartment();
        extractor = new AssociationCompartmentExtractor(edge);

        GraphNode back = (GraphNode) extractor.extractSecondAssociationEnd();
        Dimension size = back.getSize();

        assertTrue("The height should be 100.", size.getHeight() == 100);
        assertTrue("The width should be 1000.", size.getWidth() == 1000);
    }


    /**
     * Test method updateSecondAssociationEnd.
     *
     * @throws Exception to junit.
     *
     */
    public void testUpdateSecondAssociationEnd() throws Exception {
        GraphEdge edge = HelperUtil.createGraphEdgeInstanceForAssociationCompartment();
        extractor = new AssociationCompartmentExtractor(edge);

        Dimension d = new Dimension();
        d.setHeight(new Double(1));
        d.setWidth(new Double(10));

        GraphNode secondAssociationEndNode = new GraphNode();
        secondAssociationEndNode.setSemanticModel(createUmlSemanticModel(new AssociationEndImpl()));
        secondAssociationEndNode.setSize(d);

        extractor.updateSecondAssociationEnd(secondAssociationEndNode);

        GraphNode back = (GraphNode) extractor.extractSecondAssociationEnd();
        Dimension size = back.getSize();
        assertTrue("The height should be 1.", size.getHeight() == 1);
        assertTrue("The width should be 10.", size.getWidth() == 10);
    }



    /**
     * <p>
     * Greates a Uml1SemanticModelBridge instance with the given uml element.
     * </p>
     *
     * @param element a uml element
     *
     * @return a SimpleSemanticModelElement instance.
     */
    private static Uml1SemanticModelBridge createUmlSemanticModel(Element element) {
        Uml1SemanticModelBridge bridge = new Uml1SemanticModelBridge();
        bridge.setElement(element);
        return bridge;
    }
}
