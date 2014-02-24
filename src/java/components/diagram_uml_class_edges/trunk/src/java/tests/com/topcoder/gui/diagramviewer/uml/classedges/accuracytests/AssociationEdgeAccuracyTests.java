/*
 * Copyright (C) 2007 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.gui.diagramviewer.uml.classedges.accuracytests;

import com.topcoder.diagraminterchange.GraphEdge;
import com.topcoder.diagraminterchange.GraphNode;
import com.topcoder.diagraminterchange.Uml1SemanticModelBridge;

import com.topcoder.gui.diagramviewer.uml.classedges.ActiveEdgeEnding;
import com.topcoder.gui.diagramviewer.uml.classedges.Aggregation;
import com.topcoder.gui.diagramviewer.uml.classedges.AggregationBiDirectional;
import com.topcoder.gui.diagramviewer.uml.classedges.AssociationEdge;
import com.topcoder.gui.diagramviewer.uml.classedges.Composition;
import com.topcoder.gui.diagramviewer.uml.classedges.CompositionBiDirectional;
import com.topcoder.gui.diagramviewer.uml.classedges.DirectedAssociation;
import com.topcoder.gui.diagramviewer.uml.classedges.NoArrow;
import com.topcoder.gui.diagramviewer.uml.classedges.TextField;

import com.topcoder.uml.model.core.extensionmechanisms.Stereotype;
import com.topcoder.uml.model.core.extensionmechanisms.StereotypeImpl;
import com.topcoder.uml.model.core.relationships.Association;
import com.topcoder.uml.model.core.relationships.AssociationEnd;
import com.topcoder.uml.model.datatypes.AggregationKind;
import com.topcoder.uml.model.datatypes.Multiplicity;
import com.topcoder.uml.model.datatypes.MultiplicityImpl;
import com.topcoder.uml.model.datatypes.MultiplicityRange;
import com.topcoder.uml.model.datatypes.MultiplicityRangeImpl;

import junit.framework.TestCase;

import java.util.List;


/**
 * <p>Test the accuracy of AssociationEdge class.</p>
 *
 * @author KLW
 * @version 1.0
 */
public class AssociationEdgeAccuracyTests extends TestCase {
    /** <code>AssociationEdge</code> instance used for testing. */
    private AssociationEdge edge;

    /** <code>GraphEdge</code> instance used for testing. */
    private GraphEdge graphEdge;

    /**
     * <p>Sets up test environment.</p>
     *
     * @throws Exception to JUnit
     */
    protected void setUp() throws Exception {
        graphEdge = AccuracyTestHelper.createGraphEdgeForAssociationEdge();
        edge = new AssociationEdge(graphEdge);
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
        assertNotNull("Should create the instance successfully.", edge);
    }

    /**
     * <p>Accuracy test of constructor. With navigable left end, navigable right end.
     * Should create the instance with NoArrow left end, NoArrow right end.</p>
     *
     * @throws Exception to JUnit
     */
    public void testCtor1() throws Exception {
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
     * <p>Accuracy test of constructor. With not navigable left end, not navigable right
     * end. Should create the instance with NoArrow left end, NoArrow right end.</p>
     *
     * @throws Exception to JUnit
     */
    public void testCtor2() throws Exception {
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
     * <p>Accuracy test of constructor. With navigable left end, not navigable right end.
     * Should create the instance with DirectedAssociation left end, NoArrow right end.</p>
     *
     * @throws Exception to JUnit
     */
    public void testCtor3() throws Exception {
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
     * <p>Accuracy test of constructor. With not navigable left end, navigable right end.
     * Should create the instance with NoArrow left end, DirectedAssociation right end.</p>
     *
     * @throws Exception to JUnit
     */
    public void testCtor4() throws Exception {
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
     * <p>Accuracy test of constructor. With aggregate/not navigable left end, navigable
     * right end. Should create the instance with Aggregation left end, DirectedAssociation right
     * end.</p>
     *
     * @throws Exception to JUnit
     */
    public void testCtor5() throws Exception {
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
        assertTrue(edge.getLeftEnding() instanceof Aggregation);
        assertTrue(edge.getRightEnding() instanceof DirectedAssociation);
    }

    /**
     * <p>Accuracy test of constructor. With aggregate/navigable left end, navigable right
     * end. Should create the instance with AggregationBiDirectional left end, NoArrow right end.</p>
     *
     * @throws Exception to JUnit
     */
    public void testCtor6() throws Exception {
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
        assertTrue(edge.getLeftEnding() instanceof Aggregation);
        assertTrue(edge.getRightEnding() instanceof NoArrow);
    }

    /**
     * <p>Accuracy test of constructor. With composite/not navigable left end, navigable
     * right end. Should create the instance with Composition left end, DirectedAssociation right
     * end.</p>
     *
     * @throws Exception to JUnit
     */
    public void testCtor7() throws Exception {
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
        assertTrue(edge.getLeftEnding() instanceof Composition);
        assertTrue(edge.getRightEnding() instanceof DirectedAssociation);
    }

    /**
     * <p>Accuracy test of constructor. With aggregate/navigable left end, navigable right
     * end. Should create the instance with CompositionBiDirectional left end, NoArrow right end.</p>
     *
     * @throws Exception to JUnit
     */
    public void testCtor8() throws Exception {
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
        assertTrue(edge.getLeftEnding() instanceof Composition);
        assertTrue(edge.getRightEnding() instanceof NoArrow);
    }

    /**
     * <p>Accuracy test of method <code>notifyGraphEdgeChange(String)</code>. Update the
     * name of Association UML element.</p>
     *
     * @throws Exception to JUnit
     */
    public void testNotifyGraphEdgeChange3() throws Exception {
        //Update the name Association element
        String text = "name changed";
        Uml1SemanticModelBridge semanticModelBridge = (Uml1SemanticModelBridge) edge.getGraphEdge()
                                                                                    .getSemanticModel();
        Association element = (Association) semanticModelBridge.getElement();
        element.setName(text);

        //Notify
        edge.notifyGraphEdgeChange("element name change");

        //Check
        assertEquals(text, edge.getNameCompartment().getText());
    }

    /**
     * <p>Accuracy test of method <code>notifyGraphEdgeChange(String)</code>. Update the
     * stereotype text of Association UML element.</p>
     *
     * @throws Exception to JUnit
     */
    public void testNotifyGraphEdgeChange4() throws Exception {
        //Update the stereotype text of Association element
        String text = "<<create>>";
        Uml1SemanticModelBridge semanticModelBridge = (Uml1SemanticModelBridge) edge.getGraphEdge()
                                                                                    .getSemanticModel();
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
     * <p>Accuracy test of method <code>notifyGraphEdgeChange(String)</code>. Update the
     * name text of left AssociationEnd UML element.</p>
     *
     * @throws Exception to JUnit
     */
    public void testNotifyGraphEdgeChange5() throws Exception {
        //Update the name text of left AssociationEnd element
        String text = "left association end";
        Uml1SemanticModelBridge semanticModelBridge = (Uml1SemanticModelBridge) edge.getGraphEdge()
                                                                                    .getSemanticModel();
        Association element = (Association) semanticModelBridge.getElement();
        AssociationEnd leftAssociationEnd = element.getConnections().get(0);
        leftAssociationEnd.setName(text);

        //Notify
        edge.notifyGraphEdgeChange("left AssociationEnd name text change");

        //Check
        assertEquals(text, ((ActiveEdgeEnding) edge.getLeftEnding()).getNameCompartment().getText());
    }

    /**
     * <p>Accuracy test of method <code>notifyGraphEdgeChange(String)</code>. Update the
     * multiplicity text of left AssociationEnd UML element.</p>
     *
     * @throws Exception to JUnit
     */
    public void testNotifyGraphEdgeChange6() throws Exception {
        //Update the multiplicity text of left AssociationEnd element
        String text = "1..10";
        Uml1SemanticModelBridge semanticModelBridge = (Uml1SemanticModelBridge) edge.getGraphEdge()
                                                                                    .getSemanticModel();
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
        assertEquals(text,
            ((ActiveEdgeEnding) edge.getLeftEnding()).getMultiplicityCompartment().getText());
    }

    /**
     * <p>Accuracy test of method <code>notifyGraphEdgeChange(String)</code>. Update the
     * name text of right AssociationEnd UML element.</p>
     *
     * @throws Exception to JUnit
     */
    public void testNotifyGraphEdgeChange7() throws Exception {
        //Update the name text of right AssociationEnd element
        String text = "right association end";
        Uml1SemanticModelBridge semanticModelBridge = (Uml1SemanticModelBridge) edge.getGraphEdge()
                                                                                    .getSemanticModel();
        Association element = (Association) semanticModelBridge.getElement();
        AssociationEnd rightAssociationEnd = element.getConnections().get(1);
        rightAssociationEnd.setName(text);

        //Notify
        edge.notifyGraphEdgeChange("right AssociationEnd name text change");

        //Check
        assertEquals(text, ((ActiveEdgeEnding) edge.getRightEnding()).getNameCompartment().getText());
    }

    /**
     * <p>Accuracy test of method <code>notifyGraphEdgeChange(String)</code>. Update the
     * multiplicity text of right AssociationEnd UML element.</p>
     *
     * @throws Exception to JUnit
     */
    public void testNotifyGraphEdgeChange8() throws Exception {
        //Update the multiplicity text of right AssociationEnd element
        String text = "1..10";
        Uml1SemanticModelBridge semanticModelBridge = (Uml1SemanticModelBridge) edge.getGraphEdge()
                                                                                    .getSemanticModel();
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
        assertEquals(text,
            ((ActiveEdgeEnding) edge.getRightEnding()).getMultiplicityCompartment().getText());
    }
}
