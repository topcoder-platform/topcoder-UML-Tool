/*
 * Copyright (C) 2007 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.gui.diagramviewer.uml.classedges;

import java.awt.Dimension;
import java.util.List;

import javax.swing.JFrame;

import junit.framework.TestCase;

import com.topcoder.diagraminterchange.GraphEdge;
import com.topcoder.diagraminterchange.Uml1SemanticModelBridge;
import com.topcoder.uml.model.core.extensionmechanisms.Stereotype;
import com.topcoder.uml.model.core.extensionmechanisms.StereotypeImpl;
import com.topcoder.uml.model.core.relationships.Association;
import com.topcoder.uml.model.core.relationships.AssociationEnd;
import com.topcoder.uml.model.datatypes.AggregationKind;
import com.topcoder.uml.model.datatypes.Multiplicity;
import com.topcoder.uml.model.datatypes.MultiplicityImpl;
import com.topcoder.uml.model.datatypes.MultiplicityRange;
import com.topcoder.uml.model.datatypes.MultiplicityRangeImpl;

/**
 * <p>
 * Unit test cases for <code>AssociationEdge</code>.
 * </p>
 *
 * @author littlebull
 * @version 1.0
 */
public class AssociationEdgeUnitTests extends TestCase {

    /** <code>AssociationEdge</code> instance used for testing. */
    private AssociationEdge edge;

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
        graphEdge = UnitTestsHelper.createGraphEdgeForAssociationEdge();
        edge = new AssociationEdge(graphEdge);
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
            new AssociationEdge(null);
            fail("Should throw IAE.");
        } catch (IllegalArgumentException e) {
            //pass
        }
    }

    /**
     * <p>
     * Failure test of constructor.
     * With bad <code>GraphEdge</code> structure: doesn't contain 2 compartments.
     * Should throw IllegalGraphElementException.
     * </p>
     *
     * @throws Exception to JUnit
     */
    public void testCtor_Failure_Not2Compartments() throws Exception {
        graphEdge.removeContained(0);

        try {
            new AssociationEdge(graphEdge);
            fail("Should throw IllegalGraphElementException.");
        } catch (IllegalGraphElementException e) {
            //pass
        }
    }

    /**
     * <p>
     * Failure test of constructor.
     * With bad <code>GraphEdge</code> structure: not ha.
     * Should throw IllegalGraphElementException.
     * </p>
     *
     * @throws Exception to JUnit
     */
    public void testCtor_Failure_NotGraphNodeCompartments() throws Exception {
        graphEdge.removeContained(0);
        graphEdge.addContained(new GraphEdge());

        try {
            new AssociationEdge(graphEdge);
            fail("Should throw IllegalGraphElementException.");
        } catch (IllegalGraphElementException e) {
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
            new AssociationEdge(graphEdge);
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
     * Accuracy test of constructor.
     * With navigable left end, navigable right end.
     * Should create the instance with NoArrow left end, NoArrow right end.
     * </p>
     *
     * @throws Exception to JUnit
     */
    public void testCtor_Accuracy_1() throws Exception {
        //Retrieve AssociationEnd elements
        Uml1SemanticModelBridge semanticModelBridge = (Uml1SemanticModelBridge) graphEdge.getSemanticModel();
        Association association = (Association) semanticModelBridge.getElement();
        List<AssociationEnd> connectiones = association.getConnections();
        AssociationEnd leftEnd = connectiones.get(0);
        AssociationEnd rightEnd = connectiones.get(1);

        //Set up AsscoiationEnd
        leftEnd.setAggregation(null);
        leftEnd.setNavigable(true);
        rightEnd.setNavigable(true);

        //Create instance
        edge = new AssociationEdge(graphEdge);

        //Check
        assertTrue(edge.getLeftEnding() instanceof NoArrow);
        assertTrue(edge.getRightEnding() instanceof NoArrow);
    }

    /**
     * <p>
     * Accuracy test of constructor.
     * With not navigable left end, not navigable right end.
     * Should create the instance with NoArrow left end, NoArrow right end.
     * </p>
     *
     * @throws Exception to JUnit
     */
    public void testCtor_Accuracy_2() throws Exception {
        //Retrieve AssociationEnd elements
        Uml1SemanticModelBridge semanticModelBridge = (Uml1SemanticModelBridge) graphEdge.getSemanticModel();
        Association association = (Association) semanticModelBridge.getElement();
        List<AssociationEnd> connectiones = association.getConnections();
        AssociationEnd leftEnd = connectiones.get(0);
        AssociationEnd rightEnd = connectiones.get(1);

        //Set up AsscoiationEnd
        leftEnd.setAggregation(null);
        leftEnd.setNavigable(false);
        rightEnd.setNavigable(false);

        //Create instance
        edge = new AssociationEdge(graphEdge);

        //Check
        assertTrue(edge.getLeftEnding() instanceof NoArrow);
        assertTrue(edge.getRightEnding() instanceof NoArrow);
    }

    /**
     * <p>
     * Accuracy test of constructor.
     * With navigable left end, not navigable right end.
     * Should create the instance with DirectedAssociation left end, NoArrow right end.
     * </p>
     *
     * @throws Exception to JUnit
     */
    public void testCtor_Accuracy_3() throws Exception {
        //Retrieve AssociationEnd elements
        Uml1SemanticModelBridge semanticModelBridge = (Uml1SemanticModelBridge) graphEdge.getSemanticModel();
        Association association = (Association) semanticModelBridge.getElement();
        List<AssociationEnd> connectiones = association.getConnections();
        AssociationEnd leftEnd = connectiones.get(0);
        AssociationEnd rightEnd = connectiones.get(1);

        //Set up AsscoiationEnd
        leftEnd.setAggregation(null);
        leftEnd.setNavigable(true);
        rightEnd.setNavigable(false);

        //Create instance
        edge = new AssociationEdge(graphEdge);

        //Check
        assertTrue(edge.getLeftEnding() instanceof DirectedAssociation);
        assertTrue(edge.getRightEnding() instanceof NoArrow);
    }

    /**
     * <p>
     * Accuracy test of constructor.
     * With not navigable left end, navigable right end.
     * Should create the instance with NoArrow left end, DirectedAssociation right end.
     * </p>
     *
     * @throws Exception to JUnit
     */
    public void testCtor_Accuracy_4() throws Exception {
        //Retrieve AssociationEnd elements
        Uml1SemanticModelBridge semanticModelBridge = (Uml1SemanticModelBridge) graphEdge.getSemanticModel();
        Association association = (Association) semanticModelBridge.getElement();
        List<AssociationEnd> connectiones = association.getConnections();
        AssociationEnd leftEnd = connectiones.get(0);
        AssociationEnd rightEnd = connectiones.get(1);

        //Set up AsscoiationEnd
        leftEnd.setAggregation(null);
        leftEnd.setNavigable(false);
        rightEnd.setNavigable(true);

        //Create instance
        edge = new AssociationEdge(graphEdge);

        //Check
        assertTrue(edge.getLeftEnding() instanceof NoArrow);
        assertTrue(edge.getRightEnding() instanceof DirectedAssociation);
    }

    /**
     * <p>
     * Accuracy test of constructor.
     * With aggregate/not navigable left end, navigable right end.
     * Should create the instance with Aggregation left end, DirectedAssociation right end.
     * </p>
     *
     * @throws Exception to JUnit
     */
    public void testCtor_Accuracy_5() throws Exception {
        //Retrieve AssociationEnd elements
        Uml1SemanticModelBridge semanticModelBridge = (Uml1SemanticModelBridge) graphEdge.getSemanticModel();
        Association association = (Association) semanticModelBridge.getElement();
        List<AssociationEnd> connectiones = association.getConnections();
        AssociationEnd leftEnd = connectiones.get(0);
        AssociationEnd rightEnd = connectiones.get(1);

        //Set up AsscoiationEnd
        leftEnd.setAggregation(AggregationKind.AGGREGATE);
        leftEnd.setNavigable(false);
        rightEnd.setNavigable(true);

        //Create instance
        edge = new AssociationEdge(graphEdge);

        //Check
        assertTrue(edge.getLeftEnding() instanceof  Aggregation);
        assertTrue(edge.getRightEnding() instanceof DirectedAssociation);
    }

    /**
     * <p>
     * Accuracy test of constructor.
     * With aggregate/navigable left end, navigable right end.
     * Should create the instance with AggregationBiDirectional left end, NoArrow right end.
     * </p>
     *
     * @throws Exception to JUnit
     */
    public void testCtor_Accuracy_6() throws Exception {
        //Retrieve AssociationEnd elements
        Uml1SemanticModelBridge semanticModelBridge = (Uml1SemanticModelBridge) graphEdge.getSemanticModel();
        Association association = (Association) semanticModelBridge.getElement();
        List<AssociationEnd> connectiones = association.getConnections();
        AssociationEnd leftEnd = connectiones.get(0);
        AssociationEnd rightEnd = connectiones.get(1);

        //Set up AsscoiationEnd
        leftEnd.setAggregation(AggregationKind.AGGREGATE);
        leftEnd.setNavigable(true);
        rightEnd.setNavigable(true);

        //Create instance
        edge = new AssociationEdge(graphEdge);

        //Check
        assertTrue(edge.getLeftEnding() instanceof  Aggregation);
        assertTrue(edge.getRightEnding() instanceof NoArrow);
    }

    /**
     * <p>
     * Accuracy test of constructor.
     * With composite/not navigable left end, navigable right end.
     * Should create the instance with Composition left end, DirectedAssociation right end.
     * </p>
     *
     * @throws Exception to JUnit
     */
    public void testCtor_Accuracy_7() throws Exception {
        //Retrieve AssociationEnd elements
        Uml1SemanticModelBridge semanticModelBridge = (Uml1SemanticModelBridge) graphEdge.getSemanticModel();
        Association association = (Association) semanticModelBridge.getElement();
        List<AssociationEnd> connectiones = association.getConnections();
        AssociationEnd leftEnd = connectiones.get(0);
        AssociationEnd rightEnd = connectiones.get(1);

        //Set up AsscoiationEnd
        leftEnd.setAggregation(AggregationKind.COMPOSITE);
        leftEnd.setNavigable(false);
        rightEnd.setNavigable(true);

        //Create instance
        edge = new AssociationEdge(graphEdge);

        //Check
        assertTrue(edge.getLeftEnding() instanceof  Composition);
        assertTrue(edge.getRightEnding() instanceof DirectedAssociation);
    }

    /**
     * <p>
     * Accuracy test of constructor.
     * With aggregate/navigable left end, navigable right end.
     * Should create the instance with CompositionBiDirectional left end, NoArrow right end.
     * </p>
     *
     * @throws Exception to JUnit
     */
    public void testCtor_Accuracy_8() throws Exception {
        //Retrieve AssociationEnd elements
        Uml1SemanticModelBridge semanticModelBridge = (Uml1SemanticModelBridge) graphEdge.getSemanticModel();
        Association association = (Association) semanticModelBridge.getElement();
        List<AssociationEnd> connectiones = association.getConnections();
        AssociationEnd leftEnd = connectiones.get(0);
        AssociationEnd rightEnd = connectiones.get(1);

        //Set up AsscoiationEnd
        leftEnd.setAggregation(AggregationKind.COMPOSITE);
        leftEnd.setNavigable(true);
        rightEnd.setNavigable(true);

        //Create instance
        edge = new AssociationEdge(graphEdge);

        //Check
        assertTrue(edge.getLeftEnding() instanceof  Composition);
        assertTrue(edge.getRightEnding() instanceof NoArrow);
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
     * With GraphEdge has no Association element.
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
     * Update the name of Association UML element.
     * </p>
     *
     * @throws Exception to JUnit
     */
    public void testNotifyGraphEdgeChange_Accuracy_3() throws Exception {
        //Update the name Association element
        String text = "name changed";
        Uml1SemanticModelBridge semanticModelBridge =
            (Uml1SemanticModelBridge) edge.getGraphEdge().getSemanticModel();
        Association element = (Association) semanticModelBridge.getElement();
        element.setName(text);

        //Notify
        edge.notifyGraphEdgeChange("element name change");

        //Check
        assertEquals(text, edge.getNameCompartment().getText());
    }

    /**
     * <p>
     * Accuracy test of method <code>notifyGraphEdgeChange(String)</code>.
     * Update the stereotype text of Association UML element.
     * </p>
     *
     * @throws Exception to JUnit
     */
    public void testNotifyGraphEdgeChange_Accuracy_4() throws Exception {
        //Update the stereotype text of Association element
        String text = "<<create>>";
        Uml1SemanticModelBridge semanticModelBridge =
            (Uml1SemanticModelBridge) edge.getGraphEdge().getSemanticModel();
        Association element = (Association) semanticModelBridge.getElement();
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
     * Accuracy test of method <code>notifyGraphEdgeChange(String)</code>.
     * Update the name text of left AssociationEnd UML element.
     * </p>
     *
     * @throws Exception to JUnit
     */
    public void testNotifyGraphEdgeChange_Accuracy_5() throws Exception {
        //Update the name text of left AssociationEnd element
        String text = "left association end";
        Uml1SemanticModelBridge semanticModelBridge =
            (Uml1SemanticModelBridge) edge.getGraphEdge().getSemanticModel();
        Association element = (Association) semanticModelBridge.getElement();
        AssociationEnd leftAssociationEnd = element.getConnections().get(0);
        leftAssociationEnd.setName(text);

        //Notify
        edge.notifyGraphEdgeChange("left AssociationEnd name text change");

        //Check
        assertEquals(text, ((ActiveEdgeEnding) edge.getLeftEnding()).getNameCompartment().getText());
    }

    /**
     * <p>
     * Accuracy test of method <code>notifyGraphEdgeChange(String)</code>.
     * Update the multiplicity text of left AssociationEnd UML element.
     * </p>
     *
     * @throws Exception to JUnit
     */
    public void testNotifyGraphEdgeChange_Accuracy_6() throws Exception {
        //Update the multiplicity text of left AssociationEnd element
        String text = "1..10";
        Uml1SemanticModelBridge semanticModelBridge =
            (Uml1SemanticModelBridge) edge.getGraphEdge().getSemanticModel();
        Association element = (Association) semanticModelBridge.getElement();
        AssociationEnd leftAssociationEnd = element.getConnections().get(0);
        MultiplicityRange range = new MultiplicityRangeImpl();
        range.setLower(1);
        range.setUpper(10);
        Multiplicity multiplicity = new MultiplicityImpl();
        multiplicity.addRange(range);
        leftAssociationEnd.setMultiplicity(multiplicity);

        //Notify
        edge.notifyGraphEdgeChange("left AssociationEnd multiplicity text change");

        //Check
        assertEquals(text, ((ActiveEdgeEnding) edge.getLeftEnding()).getMultiplicityCompartment().getText());
    }

    /**
     * <p>
     * Accuracy test of method <code>notifyGraphEdgeChange(String)</code>.
     * Update the name text of right AssociationEnd UML element.
     * </p>
     *
     * @throws Exception to JUnit
     */
    public void testNotifyGraphEdgeChange_Accuracy_7() throws Exception {
        //Update the name text of right AssociationEnd element
        String text = "right association end";
        Uml1SemanticModelBridge semanticModelBridge =
            (Uml1SemanticModelBridge) edge.getGraphEdge().getSemanticModel();
        Association element = (Association) semanticModelBridge.getElement();
        AssociationEnd rightAssociationEnd = element.getConnections().get(1);
        rightAssociationEnd.setName(text);

        //Notify
        edge.notifyGraphEdgeChange("right AssociationEnd name text change");

        //Check
        assertEquals(text, ((ActiveEdgeEnding) edge.getRightEnding()).getNameCompartment().getText());
    }

    /**
     * <p>
     * Accuracy test of method <code>notifyGraphEdgeChange(String)</code>.
     * Update the multiplicity text of right AssociationEnd UML element.
     * </p>
     *
     * @throws Exception to JUnit
     */
    public void testNotifyGraphEdgeChange_Accuracy_8() throws Exception {
        //Update the multiplicity text of right AssociationEnd element
        String text = "1..10";
        Uml1SemanticModelBridge semanticModelBridge =
            (Uml1SemanticModelBridge) edge.getGraphEdge().getSemanticModel();
        Association element = (Association) semanticModelBridge.getElement();
        AssociationEnd rightAssociationEnd = element.getConnections().get(1);
        MultiplicityRange range = new MultiplicityRangeImpl();
        range.setLower(1);
        range.setUpper(10);
        Multiplicity multiplicity = new MultiplicityImpl();
        multiplicity.addRange(range);
        rightAssociationEnd.setMultiplicity(multiplicity);

        //Notify
        edge.notifyGraphEdgeChange("right AssociationEnd name text change");

        //Check
        assertEquals(text, ((ActiveEdgeEnding) edge.getRightEnding()).getMultiplicityCompartment().getText());
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
        AssociationEdge edge = new AssociationEdge(UnitTestsHelper.createGraphEdgeForAssociationEdge());

        // set up the JFrame instance and show it
        JFrame frame = new JFrame();
        frame.setTitle("[Demo]AssociationEdge");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        frame.add(edge);

        frame.setSize(new Dimension(500, 500));
        frame.setVisible(true);
    }
}
