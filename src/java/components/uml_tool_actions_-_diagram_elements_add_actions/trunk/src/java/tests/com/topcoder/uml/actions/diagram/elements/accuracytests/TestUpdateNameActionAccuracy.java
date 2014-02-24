/*
 * Copyright (C) 2006 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.uml.actions.diagram.elements.accuracytests;

import com.topcoder.diagraminterchange.Dimension;
import com.topcoder.diagraminterchange.GraphNode;
import com.topcoder.uml.actions.diagram.elements.actions.UpdateNameAction;
import com.topcoder.uml.actions.diagram.elements.compartmentextraction.ActivityNodeCompartmentExtractor;

import junit.framework.TestCase;

/**
 * Accuracy test cases for class <code>UpdateNameAction </code>.
 *
 * @author Chenhong
 * @version 1.0
 */
public class TestUpdateNameActionAccuracy extends TestCase {

    /**
     * Test the constructor.
     *
     */
    public void testUpdateNameAction() {
        GraphNode root = HelperUtil.createGraphNodeInstance();

        ActivityNodeCompartmentExtractor extractor = new ActivityNodeCompartmentExtractor(root);

        Dimension d = new Dimension();
        d.setHeight(new Double(1));
        d.setWidth(new Double(10000));

        GraphNode nameNode = new GraphNode();
        nameNode.setSemanticModel(HelperUtil.createSimpleSemanticModel(EnumUtil.NAME));
        nameNode.setVisible(true);

        nameNode.setSize(d);

        UpdateNameAction action = new UpdateNameAction(extractor, nameNode);

        assertNotNull("The UpdateNameAction instance should be created.", action);
    }

    /**
     * Test updateName note action functionality.
     *
     * @throws Exception
     *             to junit.
     */
    public void testExecute() throws Exception {
        GraphNode root = HelperUtil.createGraphNodeInstance();

        ActivityNodeCompartmentExtractor extractor = new ActivityNodeCompartmentExtractor(root);

        Dimension d = new Dimension();
        d.setHeight(new Double(1));
        d.setWidth(new Double(10000));

        GraphNode nameNode = new GraphNode();
        nameNode.setSemanticModel(HelperUtil.createSimpleSemanticModel(EnumUtil.NAME));
        nameNode.setVisible(true);

        nameNode.setSize(d);

        UpdateNameAction action = new UpdateNameAction(extractor, nameNode);

        assertNotNull("The UpdateNameAction instance should be created.", action);

        // update the name node.
        action.execute();

        GraphNode back = (GraphNode) action.getExtractor().extractName();

        Dimension size = back.getSize();

        assertEquals("The height should be 1.", 1.0, size.getHeight());
        assertEquals("The widtd should be 10000.", 10000.0, size.getWidth());
    }
}