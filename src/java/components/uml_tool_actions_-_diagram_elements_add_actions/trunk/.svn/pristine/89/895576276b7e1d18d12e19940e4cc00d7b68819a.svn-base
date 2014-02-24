/*
 * Copyright (C) 2006 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.uml.actions.diagram.elements.accuracytests;

import com.topcoder.diagraminterchange.Dimension;
import com.topcoder.diagraminterchange.GraphNode;
import com.topcoder.diagraminterchange.SimpleSemanticModelElement;
import com.topcoder.uml.actions.diagram.elements.compartmentextraction.ObjectCompartmentExtractor;

import junit.framework.TestCase;

/**
 * Accuracy test cases for class <code>ObjectCompartmentExtractor </code>.
 *
 * @author Chenhong
 * @version 1.0
 */
public class TestObjectCompartmentExtractorAccuracy extends TestCase {

    /**
     * Represents the ObjectCompartmentExtractor instance for testing.
     */
    private ObjectCompartmentExtractor extractor = null;

    /**
     * Set up.
     */
    public void setUp() {
        GraphNode node = HelperUtil.createGraphNodeInstanceForObjectCompartmentExtractor();

        extractor = new ObjectCompartmentExtractor(node);
    }

    /**
     * Test constructor.
     *
     */
    public void testObjectCompartmentExtractor() {
        assertNotNull("The ObjectCompartmentExtrator instance should be created.", extractor);
    }

    /**
     * Test method extractName.
     *
     * @throws Exception to junit.
     */
    public void testExtractName() throws Exception  {
        GraphNode node = (GraphNode) extractor.extractName();

        Dimension size = node.getSize();

        assertTrue("The height should be 100", size.getHeight() == 100);
        assertTrue("The width should be 100.", size.getWidth() == 100);

    }

    /**
     * Test method updateName.
     *
     * @throws Exception
     *
     */
    public void testUpdateName() throws Exception  {
        GraphNode nameNode = new GraphNode();
        SimpleSemanticModelElement semanticModel = new SimpleSemanticModelElement();
        semanticModel.setTypeinfo(EnumUtil.NAME);

        nameNode.setSemanticModel(semanticModel);

        Dimension d = new Dimension();
        d.setHeight(new Double(1));
        d.setWidth(new Double(1));

        nameNode.setSize(d);

        extractor.updateName(nameNode);

        GraphNode node = (GraphNode) extractor.extractName();

        Dimension size = node.getSize();

        assertTrue("The height should be 1.", size.getHeight() == 1);
        assertTrue("The width should be 1.", size.getWidth() == 1);



    }

    /**
     * Test method extractStereotype.
     *
     * @throws Exception to junit.
     *
     */
    public void testExtractStereotype() throws Exception  {
        GraphNode node = (GraphNode) extractor.extractStereotype();

        Dimension size = node.getSize();

        assertTrue("The height should be 100", size.getHeight() == 100);
        assertTrue("The width should be 100.", size.getWidth() == 100);

    }


    /**
     * Test method updateStereotype.
     * @throws Exception to junit.
     */
    public void testUpdateStereotype() throws Exception {
        GraphNode stereoTypeNode = new GraphNode();
        SimpleSemanticModelElement semanticModel = new SimpleSemanticModelElement();
        semanticModel.setTypeinfo(EnumUtil.STEREOTYPE_COMPARTMENT);

        stereoTypeNode.setSemanticModel(semanticModel);

        Dimension d = new Dimension();
        d.setHeight(new Double(1));
        d.setWidth(new Double(1));

        stereoTypeNode.setSize(d);

        extractor.updateStereotype(stereoTypeNode);

        GraphNode node = (GraphNode) extractor.extractStereotype();

        Dimension size = node.getSize();

        assertTrue("The height should be 1.", size.getHeight() == 1);
        assertTrue("The width should be 1.", size.getWidth() == 1);

    }

}
