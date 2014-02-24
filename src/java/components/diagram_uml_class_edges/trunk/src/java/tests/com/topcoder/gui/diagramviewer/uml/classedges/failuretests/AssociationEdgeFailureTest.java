/*
 * Copyright (C) 2007 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.gui.diagramviewer.uml.classedges.failuretests;

import com.topcoder.diagraminterchange.Dimension;
import com.topcoder.diagraminterchange.GraphEdge;
import com.topcoder.diagraminterchange.GraphNode;
import com.topcoder.diagraminterchange.Point;
import com.topcoder.diagraminterchange.Uml1SemanticModelBridge;
import com.topcoder.gui.diagramviewer.uml.classedges.AssociationEdge;
import com.topcoder.gui.diagramviewer.uml.classedges.IllegalGraphElementException;
import com.topcoder.uml.model.core.dependencies.BindingImpl;
import com.topcoder.uml.model.core.extensionmechanisms.Stereotype;
import com.topcoder.uml.model.core.extensionmechanisms.StereotypeImpl;
import com.topcoder.uml.model.core.relationships.Association;
import com.topcoder.uml.model.core.relationships.AssociationEnd;
import com.topcoder.uml.model.core.relationships.AssociationEndImpl;
import com.topcoder.uml.model.core.relationships.AssociationImpl;
import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;


/**
 * Failure test case of <code>AssociationEdge</code> class.
 *
 * @author still
 * @version 1.0
 */
public class AssociationEdgeFailureTest extends TestCase {
    /** GraphEdge instance used in this failure test. */
    private GraphEdge graphEdge;
    /** AssociationEdge instance used in this failure test. */
    private AssociationEdge edge;
    /**
     * Test suite of AssociationEdge.
     *
     * @return Test suite of AssociationEdge.
     */
    public static Test suite() {
        return new TestSuite(AssociationEdgeFailureTest.class);
    }

    /**
     * Initialization for all tests here.
     *
     * @throws Exception to JUnit
     */
    protected void setUp() throws Exception {
        // set up for test
        Uml1SemanticModelBridge semanticModelBridge = new Uml1SemanticModelBridge();
        Association association = new AssociationImpl();
        Stereotype stereotype = new StereotypeImpl();
        stereotype.setName("implicit");
        association.addStereotype(stereotype);

        AssociationEnd end1 = new AssociationEndImpl();
        AssociationEnd end2 = new AssociationEndImpl();
        end1.setNavigable(true);
        end2.setNavigable(true);
        association.addConnection(end1);
        association.addConnection(end2);
        semanticModelBridge.setElement(association);

        graphEdge = new GraphEdge();

        graphEdge.addWaypoint(new Point());
        graphEdge.addWaypoint(new Point());

        GraphNode node1 = new GraphNode();
        GraphNode node2 = new GraphNode();
        node1.setPosition(new Point());
        node1.setSize(new Dimension());

        node2.setPosition(new Point());
        node2.setSize(new Dimension());
        graphEdge.addContained(node1);
        graphEdge.addContained(node2);
        graphEdge.setSemanticModel(semanticModelBridge);
        edge = new AssociationEdge(graphEdge);
    }


    /**
     * <p>
     * Test of AssociationEdge(GraphEdge) for IllegalArgumentException.
     * </p>
     * IllegalArgumentException must be thrown when encountering null GraphEdge.
     *
     * @throws Exception to JUnit
     */
    public void testAssociationEdgeForException1() throws Exception {
        try {
            new AssociationEdge(null);
            // should not be here
            fail("IllegalArgumentException expected.");
        } catch (IllegalArgumentException e) {
            // should be here
        }
    }

    /**
     * <p>
     * Test of AssociationEdge(GraphEdge) for IllegalGraphElementException.
     * </p>
     * IllegalGraphElementException must be thrown when encountering bad SemanticModelBridge structure.
     */
    public void testAssociationEdgeForException2() {
        Uml1SemanticModelBridge semanticModelBridge = new Uml1SemanticModelBridge();
        graphEdge.setSemanticModel(null);
        try {
            new AssociationEdge(graphEdge);
            // should not be here
            fail("IllegalGraphElementException expected.");
        } catch (IllegalGraphElementException e) {
            // should be here
        }

        graphEdge.setSemanticModel(semanticModelBridge);
        try {
            new AssociationEdge(graphEdge);
            // should not be here
            fail("IllegalGraphElementException expected.");
        } catch (IllegalGraphElementException e) {
            // should be here
        }


        try {
            semanticModelBridge.setElement(new BindingImpl());
            edge.getGraphEdge().setSemanticModel(semanticModelBridge);
            graphEdge.setSemanticModel(semanticModelBridge);
            new AssociationEdge(graphEdge);
            // should not be here
            fail("IllegalGraphElementException expected.");
        } catch (IllegalGraphElementException e) {
            // should be here
        }


    }

    /**
     * <p>
     * Test of notifyGraphEdgeChange(String) for IllegalArgumentException.
     * </p>
     * IllegalArgumentException must be thrown when encountering null message.
     *
     * @throws Exception to JUnit
     */
    public void testNotifyGraphEdgeChangeForException1() throws Exception {
        try {
            edge.notifyGraphEdgeChange(null);
            // should not be here
            fail("IllegalArgumentException expected.");
        } catch (IllegalArgumentException e) {
            // should be here
        }
    }

    /**
     * <p>
     * Test of notifyGraphEdgeChange(String) for IllegalGraphElementException.
     * </p>
     * IllegalGraphElementException must be thrown when encountering bad SemanticModelBridge structure.
     */
    public void testNotifyGraphEdgeChangeForException2() {

        Uml1SemanticModelBridge semanticModelBridge = new Uml1SemanticModelBridge();
        graphEdge.setSemanticModel(null);
        try {
            edge.notifyGraphEdgeChange("graph edge has been changed.");
            // should not be here
            fail("IllegalGraphElementException expected.");
        } catch (IllegalGraphElementException e) {
            // should be here
        }

        graphEdge.setSemanticModel(semanticModelBridge);
        try {
            edge.notifyGraphEdgeChange("graph edge has been changed.");
            // should not be here
            fail("IllegalGraphElementException expected.");
        } catch (IllegalGraphElementException e) {
            // should be here
        }


        try {
            semanticModelBridge.setElement(new BindingImpl());
            graphEdge.setSemanticModel(semanticModelBridge);
            edge.notifyGraphEdgeChange("graph edge has been changed.");
            // should not be here
            fail("IllegalGraphElementException expected.");
        } catch (IllegalGraphElementException e) {
            // should be here
        }
    }

}
