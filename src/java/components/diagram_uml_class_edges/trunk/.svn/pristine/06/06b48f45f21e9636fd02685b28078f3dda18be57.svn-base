/*
 * Copyright (C) 2007 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.gui.diagramviewer.uml.classedges;

import java.awt.Dimension;

import javax.swing.JFrame;

import com.topcoder.diagraminterchange.GraphEdge;
import com.topcoder.diagraminterchange.GraphNode;
import com.topcoder.diagraminterchange.Uml1SemanticModelBridge;
import com.topcoder.uml.model.core.extensionmechanisms.StereotypeImpl;
import com.topcoder.uml.model.core.dependencies.Dependency;
import com.topcoder.uml.model.core.extensionmechanisms.Stereotype;

import junit.framework.TestCase;

/**
 * <p>
 * Unit test cases for <code>DependencyEdge</code>.
 * </p>
 *
 * @author littlebull
 * @version 1.0
 */
public class DependencyEdgeUnitTests extends TestCase {

    /** <code>DependencyEdge</code> instance used for testing. */
    private DependencyEdge edge;

    /** <code>GraphEdge</code> instance used for testing. */
    private GraphEdge graphEdge;

    /**
     * <p>
     * Sets up test environment.
     * </p>
     *
     * @throws Exception to JUnit
     */
    protected void setUp() throws Exception {
        graphEdge = UnitTestsHelper.createGraphEdgeForDependencyEdge();
        edge = new DependencyEdge(graphEdge);
    }

    /**
     * <p>
     * Tears down test environment.
     * </p>
     */
    protected void tearDown() {
        graphEdge = null;
        edge = null;
    }

    /**
     * <p>
     * Failure test of constructor.
     * With null <code>graphEdge</code>.
     * Should throw IAE.
     * </p>
     *
     * @throws Exception to JUnit
     */
    public void testCtor_Failure_NullGraphEdge() throws Exception {
        try {
            new DependencyEdge(null);
            fail("Should throw IAE.");
        } catch (IllegalArgumentException e) {
            //pass
        }
    }

    /**
     * <p>
     * Failure test of constructor.
     * With bad <code>GraphEdge</code> structure: doesn't contain 2 way points.
     * Should throw IllegalGraphElementException.
     * </p>
     *
     * @throws Exception to JUnit
     */
    public void testCtor_Failure_Not2WayPoints() throws Exception {
        graphEdge.removeWaypoint(0);

        try {
            new DependencyEdge(graphEdge);
            fail("Should throw IllegalGraphElementException.");
        } catch (IllegalGraphElementException e) {
            //pass
        }
    }

    /**
     * <p>
     * Accuracy test of constructor.
     * Should create the instance successfully.
     * </p>
     *
     * @throws Exception to JUnit
     */
    public void testCtor_Accuracy() throws Exception {
        assertNotNull("Should create the instance successfully.", edge);
    }

    /**
     * <p>
     * Failure test of method <code>notifyGraphEdgeChange(String)</code>.
     * With null message.
     * Should throw IAE.
     * </p>
     *
     * @throws Exception to JUnit
     */
    public void testNotifyGraphEdgeChange_Failure_NullMessage() throws Exception {
        try {
            edge.notifyGraphEdgeChange(null);
            fail("Should throw IAE.");
        } catch (IllegalArgumentException e) {
            //pass
        }
    }

    /**
     * <p>
     * Failure test of method <code>notifyGraphEdgeChange(String)</code>.
     * With GraphEdge has null SemanticModel.
     * Should throw IllegalGraphElementException.
     * </p>
     *
     * @throws Exception to JUnit
     */
    public void testNotifyGraphEdgeChange_Failure_1() throws Exception {
        edge.getGraphEdge().setSemanticModel(null);

        try {
            edge.notifyGraphEdgeChange("failure test");
            fail("Should throw IllegalGraphElementException.");
        } catch (IllegalGraphElementException e) {
            //pass
        }
    }

    /**
     * <p>
     * Failure test of method <code>notifyGraphEdgeChange(String)</code>.
     * With GraphEdge has no Dependency element.
     * Should throw IllegalGraphElementException.
     * </p>
     *
     * @throws Exception to JUnit
     */
    public void testNotifyGraphEdgeChange_Failure_2() throws Exception {
        Uml1SemanticModelBridge semanticModelBridge =
            (Uml1SemanticModelBridge) edge.getGraphEdge().getSemanticModel();
        semanticModelBridge.setElement(new StereotypeImpl());

        try {
            edge.notifyGraphEdgeChange("failure test");
            fail("Should throw IllegalGraphElementException.");
        } catch (IllegalGraphElementException e) {
            //pass
        }
    }

    /**
     * <p>
     * Accuracy test of method <code>notifyGraphEdgeChange(String)</code>.
     * Update the name of Dependency UML element.
     * </p>
     *
     * @throws Exception to JUnit
     */
    public void testNotifyGraphEdgeChange_Accuracy_3() throws Exception {
        //Update the name Abstraction element
        String text = "name changed";
        Uml1SemanticModelBridge semanticModelBridge =
            (Uml1SemanticModelBridge) edge.getGraphEdge().getSemanticModel();
        Dependency element = (Dependency) semanticModelBridge.getElement();
        element.setName(text);

        //Notify
        edge.notifyGraphEdgeChange("element name change");

        //Check
        assertEquals(text, edge.getNameCompartment().getText());
    }

    /**
     * <p>
     * Accuracy test of method <code>notifyGraphEdgeChange(String)</code>.
     * Update the stereotype text of Dependency UML element.
     * </p>
     *
     * @throws Exception to JUnit
     */
    public void testNotifyGraphEdgeChange_Accuracy_4() throws Exception {
        //Update the stereotype text of Abstraction element
        String text = "<<create>>";
        Uml1SemanticModelBridge semanticModelBridge =
            (Uml1SemanticModelBridge) edge.getGraphEdge().getSemanticModel();
        Dependency element = (Dependency) semanticModelBridge.getElement();
        element.clearStereotypes();
        Stereotype item1 = new StereotypeImpl();
        item1.setName("create");
        element.addStereotype(item1);

        //Notify
        edge.notifyGraphEdgeChange("element stereotype text change");

        //Check
        assertEquals(text, edge.getStereotypeCompartment().getText());
    }

    /**
     * <p>
     * The entry of the demo program.
     * </p>
     *
     * @param args the arguments
     *
     * @throws Exception
     */
    public static void main(String[] args) throws Exception {
        // set up the abstraction edge instance
        DependencyEdge edge = new DependencyEdge(UnitTestsHelper.createGraphEdgeForDependencyEdge());

        // set up the JFrame instance and show it
        JFrame frame = new JFrame();
        frame.setTitle("[Demo]DependencyEdge");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        frame.add(edge);

        frame.setSize(new Dimension(500, 500));
        frame.setVisible(true);
    }
}
