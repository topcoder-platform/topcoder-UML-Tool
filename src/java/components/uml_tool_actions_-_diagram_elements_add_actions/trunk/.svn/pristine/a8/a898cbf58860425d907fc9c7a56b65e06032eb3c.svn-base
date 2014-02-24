/*
 * Copyright (C) 2006 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.uml.actions.diagram.elements.accuracytests;

import com.topcoder.diagraminterchange.Dimension;
import com.topcoder.diagraminterchange.GraphNode;
import com.topcoder.uml.actions.diagram.elements.actions.UpdateStereotypeAction;
import com.topcoder.uml.actions.diagram.elements.compartmentextraction.ActivityNodeCompartmentExtractor;

import junit.framework.TestCase;

/**
 * Accuracy test cases for class <code>UpdateStereotypeAction </code>.
 *
 * @author Chenhong
 * @version 1.0
 */
public class TestUpdateStereotypeActionAccuracy extends TestCase {

    /**
     * Test the constructor.
     *
     */
    public void testUpdateStereotypeAction() {
        GraphNode root = HelperUtil.createGraphNodeInstance();

        ActivityNodeCompartmentExtractor extractor = new ActivityNodeCompartmentExtractor(root);

        Dimension d = new Dimension();
        d.setHeight(new Double(1));
        d.setWidth(new Double(10000));


        GraphNode stereoTypeNode = new GraphNode();
        stereoTypeNode.setSemanticModel(HelperUtil.createSimpleSemanticModel(EnumUtil.STEREOTYPE_COMPARTMENT));
        stereoTypeNode.setSize(d);

        UpdateStereotypeAction action = new UpdateStereotypeAction(extractor, stereoTypeNode);

        assertNotNull("The UpdateStereotypeAction instance should not be null.", action);
    }

    /**
     * Test method for update stereotype.
     *
     * @throws Exception to junit.
     *
     */
    public void testExecute() throws Exception {
        GraphNode root = HelperUtil.createGraphNodeInstance();

        ActivityNodeCompartmentExtractor extractor = new ActivityNodeCompartmentExtractor(root);

        Dimension d = new Dimension();
        d.setHeight(new Double(1));
        d.setWidth(new Double(10000));


        GraphNode stereoTypeNode = new GraphNode();
        stereoTypeNode.setSemanticModel(HelperUtil.createSimpleSemanticModel(EnumUtil.STEREOTYPE_COMPARTMENT));
        stereoTypeNode.setSize(d);

        UpdateStereotypeAction action = new UpdateStereotypeAction(extractor, stereoTypeNode);

        assertNotNull("The UpdateStereotypeAction instance should not be null.", action);

        // update the stereotype.

        action.execute();

        GraphNode back = (GraphNode) action.getExtractor().extractStereotype();

        Dimension size = back.getSize();

        assertEquals("The height should be 1.", 1.0, size.getHeight());
        assertEquals("The width should be 10000", 10000.0, size.getWidth());
    }
}
