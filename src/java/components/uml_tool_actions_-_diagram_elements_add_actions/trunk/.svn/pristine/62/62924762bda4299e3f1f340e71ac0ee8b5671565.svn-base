/*
 * Copyright (C) 2006 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.uml.actions.diagram.elements.accuracytests;

import com.topcoder.diagraminterchange.Dimension;
import com.topcoder.diagraminterchange.GraphEdge;
import com.topcoder.diagraminterchange.GraphNode;
import com.topcoder.diagraminterchange.SimpleSemanticModelElement;
import com.topcoder.uml.actions.diagram.elements.compartmentextraction.DefaultEdgeCompartmentExtractor;

import junit.framework.TestCase;

/**
 * Accuracy test cases for class <code>DefaultEdgeCompartmentExtractor </code>.
 *
 * @author Chenhong
 * @version 1.0
 */
public class TestDefaultEdgeCompartmentExtractor extends TestCase {
    /**
     * Represents the DefaultEdgeCompartmentExtractor instance for testing.
     */
    private DefaultEdgeCompartmentExtractor extractor = null;

    /**
     * Create DefaultEdgeCompartmentExtractor instance for testing.
     */
    public void setUp() {
        GraphEdge edge = new GraphEdge();

        extractor = new DefaultEdgeCompartmentExtractor(edge);
    }

    /**
     * Test the constructor <code> DefaultEdgeCompartmentExtractor(GraphNode node) </code>.
     *
     * <p>
     * No exception should be raised and the expected instance should not be null.
     * </p>
     */
    public void testDefaultEdgeCompartmentExtractor() {
        assertNotNull("The DefaultEdgeCompartmentExtractor instance should be created.", extractor);
    }

    /**
     * Test method <code>GraphElement extractName() </code>.
     *
     * <p>
     * In this test case, the logic is very simple. First creat a valid GraphNode instance. Set the visible to true
     * (the default value should be false), and expected that the extractor graph element has the visible true.
     * </p>
     *
     * <p>
     * Also the size should be checked.
     * </p>
     *
     * @throws Exception
     *             to junit.
     */
    public void testExtractName() throws Exception {
        GraphEdge root = HelperUtil.createGraphEdgeInstance();

        extractor = new DefaultEdgeCompartmentExtractor(root);

        GraphNode back = (GraphNode) extractor.extractName();
        assertTrue("The visible should be true for this GraphElement.", back.isVisible());

        Dimension d = back.getSize();

        assertTrue("The height should be 100.", d.getHeight()  == 100);
        assertTrue("The width should be 1000.", d.getWidth() == 1000);
    }

    /**
     * Test method <code>void updateName(GraphElement newElement) </code>.
     *
     * <p>
     * In this test case, the logic is simple. First creat a valid GraphNode instance. Set the visible to true (the
     * default value should be false), and expected that the extractor graph element has the visible value of true.
     *
     * For update, an element with visible false is created and should be updated correctly.
     * </p>
     *
     * <p>
     * Also the dimension size should be updated too.
     * </p>
     *
     * @throws Exception
     *             to junit.
     *
     */
    public void testUpdateName() throws Exception {
        GraphEdge root = HelperUtil.createGraphEdgeInstance();

        extractor = new DefaultEdgeCompartmentExtractor(root);

        GraphNode back = (GraphNode) extractor.extractName();
        assertTrue("The visible should be true for this GraphElement.", back.isVisible());

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

        back = (GraphNode) extractor.extractName();

        assertFalse("The visible should be false as it is updated.", back.isVisible());

        // check the dimension size.

        Dimension d = back.getSize();

        assertTrue("The height should be 10.", d.getHeight()  == 10);
        assertTrue("The width should be 100.", d.getWidth() == 100);

    }

    /**
     * Test method <code>GraphElement extractStereotype() </code>.
     *
     * <p>
     * Mainly check the size of the stereotype node.
     * </p>
     *
     * @throws Exception to junit.
     *
     */
    public void testExtractStereotype() throws Exception {
        GraphEdge root = HelperUtil.createGraphEdgeInstance();

        extractor = new DefaultEdgeCompartmentExtractor(root);

        GraphNode back = (GraphNode) extractor.extractStereotype();


        Dimension d = back.getSize();

        assertTrue("The height should be 100.", d.getHeight() == 100);
        assertTrue("The width should be 1000.", d.getWidth() == 1000);
    }

    /**
     * Test method <code>void updateStereotype(GraphElement newElement) </code>.
     *
     * @throws Exception to junit.
     *
     */
    public void testUpdateStereotype() throws Exception {

        GraphEdge root = HelperUtil.createGraphEdgeInstance();

        extractor = new DefaultEdgeCompartmentExtractor(root);

        GraphNode back = (GraphNode) extractor.extractStereotype();


        Dimension d = back.getSize();

        assertTrue("The height should be 100.", d.getHeight() == 100);
        assertTrue("The width should be 1000.", d.getWidth() == 1000);


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

        back = (GraphNode) extractor.extractStereotype();

        d = back.getSize();

        assertTrue("The height should be 10.", d.getHeight()  == 10);
        assertTrue("The width should be 100.", d.getWidth() == 100);
    }
}
