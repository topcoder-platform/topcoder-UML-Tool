/*
 * Copyright (C) 2007 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.gui.diagramviewer.uml.classedges.accuracytests;

import com.topcoder.diagraminterchange.GraphEdge;
import com.topcoder.diagraminterchange.GraphNode;
import com.topcoder.diagraminterchange.Uml1SemanticModelBridge;

import com.topcoder.gui.diagramviewer.uml.classedges.AbstractionEdge;
import com.topcoder.gui.diagramviewer.uml.classedges.TextField;

import com.topcoder.uml.model.core.dependencies.Abstraction;
import com.topcoder.uml.model.core.extensionmechanisms.Stereotype;
import com.topcoder.uml.model.core.extensionmechanisms.StereotypeImpl;

import junit.framework.TestCase;


/**
 * <p>Test the accuracy of AbstractionEdge class.</p>
 *
 * @author KLW
 * @version 1.0
 */
public class AbstractionEdgeAccuracyTests extends TestCase {
    /**
     * <p>The AbstractionEdge instance on which to perform tests.</p>
     */
    private AbstractionEdge edge;

    /** <code>GraphEdge</code> instance used for testing. */
    private GraphEdge graphEdge;

    /**
     * <p>Sets up test environment.</p>
     *
     * @throws Exception to JUnit
     */
    protected void setUp() throws Exception {
        graphEdge = AccuracyTestHelper.createGraphEdgeForAbstractionEdge();
        edge = new AbstractionEdge(graphEdge);
    }

    /**
     * <p>Tears down test environment.</p>
     */
    protected void tearDown() {
        graphEdge = null;
        edge = null;
    }

    /**
     * <p>Accuracy test of constructor. Should create the instance successfully.</p>
     *
     * @throws Exception to JUnit
     */
    public void testCtor() throws Exception {
        assertNotNull("It should not be null.", edge);
    }

    /**
     * <p>Accuracy test of method <code>notifyGraphEdgeChange(String)</code>. Update the
     * name of Abstraction UML element.</p>
     *
     * @throws Exception to JUnit
     */
    public void testNotifyGraphEdgeChange3() throws Exception {
        //Update the name Abstraction element
        String text = "name changed";
        Uml1SemanticModelBridge semanticModelBridge = (Uml1SemanticModelBridge) edge.getGraphEdge()
                                                                                    .getSemanticModel();
        Abstraction element = (Abstraction) semanticModelBridge.getElement();
        element.setName(text);

        //Notify
        edge.notifyGraphEdgeChange("element name change");

        //Check
        assertEquals(text, edge.getNameCompartment().getText());
    }

    /**
     * <p>Accuracy test of method <code>notifyGraphEdgeChange(String)</code>. Update the
     * stereotype text of Abstraction UML element.</p>
     *
     * @throws Exception to JUnit
     */
    public void testNotifyGraphEdgeChange4() throws Exception {
        //Update the stereotype text of Abstraction element
        String text = "<<create>>";
        Uml1SemanticModelBridge semanticModelBridge = (Uml1SemanticModelBridge) edge.getGraphEdge()
                                                                                    .getSemanticModel();
        Abstraction element = (Abstraction) semanticModelBridge.getElement();
        element.clearStereotypes();

        Stereotype item1 = new StereotypeImpl();
        item1.setName("create");
        element.addStereotype(item1);

        //Notify
        edge.notifyGraphEdgeChange("element stereotype text change");

        //Check
        assertEquals(text, edge.getStereotypeCompartment().getText());
    }
}
