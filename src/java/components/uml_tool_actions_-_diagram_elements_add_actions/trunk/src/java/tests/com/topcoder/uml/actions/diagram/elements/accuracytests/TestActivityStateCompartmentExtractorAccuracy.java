/*
 * Copyright (C) 2006 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.uml.actions.diagram.elements.accuracytests;

import com.topcoder.diagraminterchange.Dimension;
import com.topcoder.diagraminterchange.GraphNode;
import com.topcoder.diagraminterchange.SimpleSemanticModelElement;
import com.topcoder.uml.actions.diagram.elements.compartmentextraction.ActivityStateCompartmentExtractor;

import junit.framework.TestCase;

/**
 * Accuracy test cases for class <code>ActivityStateCompartmentExtractor </code>.
 *
 * @author Chenhong
 * @version 1.0
 */
public class TestActivityStateCompartmentExtractorAccuracy extends TestCase {

    /**
     * Represents the ActivityStateCompartmentExtractor instance for testing.
     */
    private ActivityStateCompartmentExtractor extractor = null;

    /**
     * Test the constructor.
     *
     */
    public void testActivityStateCompartmentExtractor() {
        GraphNode node = new GraphNode();
        extractor = new ActivityStateCompartmentExtractor(node);

        assertNotNull("The ActivityStateCompartmentExtractor instance should not be null.", extractor);
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
        GraphNode root = HelperUtil.createGraphNodeInstanceForActivityState();

        extractor = new ActivityStateCompartmentExtractor(root);

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
        GraphNode root = HelperUtil.createGraphNodeInstanceForActivityState();

        extractor = new ActivityStateCompartmentExtractor(root);

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

}
