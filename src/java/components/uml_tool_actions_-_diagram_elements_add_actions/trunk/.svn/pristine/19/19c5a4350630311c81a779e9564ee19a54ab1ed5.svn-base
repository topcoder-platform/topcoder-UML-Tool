/*
 * Copyright (C) 2006 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.uml.actions.diagram.elements.accuracytests;

import com.topcoder.diagraminterchange.Dimension;
import com.topcoder.diagraminterchange.GraphNode;
import com.topcoder.diagraminterchange.SimpleSemanticModelElement;
import com.topcoder.uml.actions.diagram.elements.compartmentextraction.DefaultNodeCompartmentExtractor;

import junit.framework.TestCase;

/**
 * Accuracy test cases for class <code>DefaultNodeCompartmentExtractor </code>.
 *
 * @author Chenhong
 * @version 1.0
 */
public class TestDefaultNodeCompartmentExtractorAccuracy extends TestCase {

    /**
     * Represents the DefaultNodeCompartmentExtractor instance for testing.
     *
     */
    private DefaultNodeCompartmentExtractor extractor = null;

    /**
     * Set up.
     */
    public void setUp() {
        GraphNode node = HelperUtil.createGraphNodeInstanceForDefaultNodeCompartmentExtractor();
        extractor = new DefaultNodeCompartmentExtractor(node);
    }

    /**
     * Test the constructor.
     *
     */
    public void testDefaultNodeCompartmentExtractor() {
        assertNotNull("The DefaultNodeCompartmentExtractor instance should be created.", extractor);
    }

    /**
     * Test method extractName.
     *
     * @throws Exception to junit.
     *
     */
    public void testExtractName() throws Exception {
        GraphNode back = (GraphNode) extractor.extractName();

        Dimension size = back.getSize();

        assertTrue("The height should be 100.", size.getHeight() == 100);
        assertTrue("The width should be 1000.", size.getWidth() == 1000);
    }

    /**
     * Test method updateName.
     *
     * @throws Exception to junit.
     */
    public void testUpdateName() throws Exception {
        GraphNode nameNode = new GraphNode();

        SimpleSemanticModelElement semanticModel = new SimpleSemanticModelElement();
        semanticModel.setTypeinfo(EnumUtil.NAME);

        nameNode.setSemanticModel(semanticModel);

        Dimension d = new Dimension();
        d.setHeight(new Double(1));
        d.setWidth(new Double(10));

        nameNode.setSize(d);

        extractor.updateName(nameNode);

        GraphNode back = (GraphNode) extractor.extractName();

        Dimension size = back.getSize();

        assertTrue("The height should be 1.", size.getHeight() == 1);
        assertTrue("The width should be 10.", size.getWidth() == 10);

    }

    /**
     * Test method extractNamespace.
     *
     * @throws Exception to junit.
     */
    public void testExtractNamespace() throws Exception  {
        GraphNode back = (GraphNode) extractor.extractNamespace();

        Dimension size = back.getSize();

        assertTrue("The height should be 100.", size.getHeight() == 100);
        assertTrue("The width should be 1000.", size.getWidth() == 1000);

    }

    /**
     * Test method updateNamespace.
     *
     * @throws Exception to junit.
     */
    public void testUpdateNamespace() throws Exception  {
        GraphNode node = new GraphNode();

        SimpleSemanticModelElement semanticModel = new SimpleSemanticModelElement();
        semanticModel.setTypeinfo(EnumUtil.NAMESPACE_COMPARTMENT);

        node.setSemanticModel(semanticModel);

        Dimension d = new Dimension();
        d.setHeight(new Double(1));
        d.setWidth(new Double(10));

        node.setSize(d);

        extractor.updateNamespace(node);

        GraphNode back = (GraphNode) extractor.extractNamespace();

        Dimension size = back.getSize();

        assertTrue("The height should be 1.", size.getHeight() == 1);
        assertTrue("The width should be 10.", size.getWidth() == 10);
    }

    /**
     * Test method extractStereotyp.
     *
     * @throws Exception to junit.
     *
     */
    public void testExtractStereotype() throws Exception  {
        GraphNode node = (GraphNode) extractor.extractStereotype();
        Dimension size = node.getSize();

        assertTrue("The height should be 100.", size.getHeight() == 100);
        assertTrue("The width should be 1000.", size.getWidth() == 1000);

    }

    /**
     * Test method updateStereotype.
     *
     * @throws Exception to junit.
     *
     */
    public void testUpdateStereotype() throws Exception  {
        GraphNode node = new GraphNode();

        SimpleSemanticModelElement semanticModel = new SimpleSemanticModelElement();
        semanticModel.setTypeinfo(EnumUtil.STEREOTYPE_COMPARTMENT);

        node.setSemanticModel(semanticModel);

        Dimension d = new Dimension();
        d.setHeight(new Double(1));
        d.setWidth(new Double(10));

        node.setSize(d);

        extractor.updateStereotype(node);

        GraphNode back = (GraphNode) extractor.extractStereotype();

        Dimension size = back.getSize();

        assertTrue("The height should be 1.", size.getHeight() == 1);
        assertTrue("The width should be 10.", size.getWidth() == 10);
    }


}
