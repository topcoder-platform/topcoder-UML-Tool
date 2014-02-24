/*
 * Copyright (C) 2006 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.uml.actions.diagram.elements.accuracytests;

import com.topcoder.diagraminterchange.Dimension;
import com.topcoder.diagraminterchange.GraphNode;
import com.topcoder.uml.actions.diagram.elements.actions.UpdateNamespaceAction;
import com.topcoder.uml.actions.diagram.elements.compartmentextraction.DefaultNodeCompartmentExtractor;

import junit.framework.TestCase;

/**
 * Accuracy test cases for class <code>UpdateNmaespaceAction </code>.
 *
 * @author Chenhong
 * @version 1.0
 */
public class TestUpdateNamespaceActionAccuracy extends TestCase {

    /**
     * Test the constructor.
     *
     */
    public void testUpdateNamespaceAction() {
        GraphNode node = HelperUtil.createGraphNodeInstanceForDefaultNodeCompartmentExtractor();
        DefaultNodeCompartmentExtractor extractor = new DefaultNodeCompartmentExtractor(node);

        GraphNode namespaceNode = new GraphNode();
        namespaceNode.setSemanticModel(HelperUtil.createSimpleSemanticModel(EnumUtil.NAMESPACE_COMPARTMENT));

        UpdateNamespaceAction action = new UpdateNamespaceAction(extractor, namespaceNode);

        assertNotNull("The UpdateNamespaceAction instance should be created.", action);
    }

    /**
     * Test method update namespace action functionality.
     *
     * @throws Exception to junit.
     *
     */
    public void testExecute() throws Exception {
        GraphNode node = HelperUtil.createGraphNodeInstanceForDefaultNodeCompartmentExtractor();
        DefaultNodeCompartmentExtractor extractor = new DefaultNodeCompartmentExtractor(node);

        GraphNode namespaceNode = new GraphNode();
        namespaceNode.setSemanticModel(HelperUtil.createSimpleSemanticModel(EnumUtil.NAMESPACE_COMPARTMENT));

        Dimension d = new Dimension();
        d.setHeight(new Double(15));
        d.setWidth(new Double(150));

        namespaceNode.setSize(d);


        UpdateNamespaceAction action = new UpdateNamespaceAction(extractor, namespaceNode);

        assertNotNull("The UpdateNamespaceAction instance should be created.", action);

        // update the namespace node.

        action.execute();

        GraphNode back = (GraphNode) action.getExtractor().extractNamespace();

        Dimension size = back.getSize();

        assertEquals("The height should be 15.", 15.0, size.getHeight());
        assertEquals("The widtd should be 150.", 150.0, size.getWidth());
    }
}
