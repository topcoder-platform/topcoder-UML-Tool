/*
 * Copyright (C) 2006 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.uml.actions.diagram.elements.accuracytests;

import com.topcoder.diagraminterchange.Dimension;
import com.topcoder.diagraminterchange.GraphNode;
import com.topcoder.diagraminterchange.SimpleSemanticModelElement;
import com.topcoder.uml.actions.diagram.elements.compartmentextraction.MessageCompartmentExtractor;

import junit.framework.TestCase;

/**
 * Accuracy test cases for class <code>MessageCompartmentExtractor </code>.
 *
 * @author Chenhong
 * @version 1.0
 */
public class TestMessageCompartmentExtractorAccuracy extends TestCase {

    /**
     * Represents the MessageCompartmentExtractor instance for testing.
     */
    private MessageCompartmentExtractor extractor = null;

    /**
     * Set up.
     */
    public void setUp() {
        GraphNode node = HelperUtil.createGraphNodeInstanceForMessageCompartmentExtractor();

        extractor = new MessageCompartmentExtractor(node);
    }

    /**
     * Test the constructor.
     *
     */
    public void testMessageCompartmentExtractor() {
        assertNotNull("The MessageCompartmentExtractor instance should be created.", extractor);
    }

    /**
     * Test method extractStereotype.
     *
     * @throws Exception
     *             to junit.
     *
     */
    public void testExtractStereotype() throws Exception {
        GraphNode node = (GraphNode) extractor.extractStereotype();

        Dimension size = node.getSize();

        assertTrue("The height should be 50", size.getHeight() == 50);
        assertTrue("The width should be 5.", size.getWidth() == 5);
    }

    /**
     * Test method updateStereotype.
     *
     * @throws Exception
     *             to junit.
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