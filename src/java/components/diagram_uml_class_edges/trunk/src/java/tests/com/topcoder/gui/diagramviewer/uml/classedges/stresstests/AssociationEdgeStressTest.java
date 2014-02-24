/*
 * Copyright (C) 2007 TopCoder Inc., All Rights Reserved.
 *
 * TCS Diagram_UML_Class_Edges Version 1.0 StressTest.
 *
 * @ AssociationEdgeStressTest.java
 */
package com.topcoder.gui.diagramviewer.uml.classedges.stresstests;

import com.topcoder.diagraminterchange.GraphEdge;
import com.topcoder.diagraminterchange.GraphNode;
import com.topcoder.diagraminterchange.Uml1SemanticModelBridge;

import com.topcoder.gui.diagramviewer.uml.classedges.ActiveEdgeEnding;
import com.topcoder.gui.diagramviewer.uml.classedges.AssociationEdge;
import com.topcoder.gui.diagramviewer.uml.classedges.TextField;

import com.topcoder.uml.model.core.ModelElement;
import com.topcoder.uml.model.core.extensionmechanisms.Stereotype;
import com.topcoder.uml.model.core.extensionmechanisms.StereotypeImpl;
import com.topcoder.uml.model.core.relationships.Association;
import com.topcoder.uml.model.core.relationships.AssociationEnd;
import com.topcoder.uml.model.core.relationships.AssociationEndImpl;
import com.topcoder.uml.model.core.relationships.AssociationImpl;
import com.topcoder.uml.model.datatypes.Multiplicity;
import com.topcoder.uml.model.datatypes.MultiplicityImpl;
import com.topcoder.uml.model.datatypes.MultiplicityRange;
import com.topcoder.uml.model.datatypes.MultiplicityRangeImpl;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;


/**
 * <p>
 * This class tests the <code>AssociationEdge</code> class for stress.
 * This stress tests addresses
 * the functionality provided by the <code>AssociationEdge</code> class.
 * </p>
 *
 * @author icyriver
 * @version 1.0
 */
public class AssociationEdgeStressTest extends TestCase {
    /**
    * <p>The string represents the division of multiplicity text.</p>
    */
    private static final String DIV = "  ";

    /**
     * <p>The string represents the range characters of multiplicity text.</p>
     */
    private static final String RANGE = "..";

    /**
     * <p>The int number represents the loop times for stress test.</p>
     */
    private static final int LOOPTIMES = 100;

    /**
     * <p>The <code>GraphEdge</code> instance used for test.</p>
     */
    private GraphEdge graphEdge = null;

    /**
     * <p>The <code>GraphNode</code> instance used for test.</p>
     */
    private GraphNode nameNode = null;

    /**
     * <p>The <code>GraphNode</code> instance used for test.</p>
     */
    private GraphNode stereotypeNode = null;

    /**
     * <p>The instance of <code>AssociationEdge</code> for test.</p>
     */
    private AssociationEdge edge = null;

    /**
     * <p>Return test suite of <code>AssociationEdgeStressTest</code>.</p>
     *
     * @return Test suite of <code>AssociationEdgeStressTest</code>.
     */
    public static Test suite() {
        return new TestSuite(AssociationEdgeStressTest.class);
    }

    /**
     * <p>Set up the stress testing environment.</p>
     */
    protected void setUp() {
        graphEdge = new GraphEdge();

        // create the structure of the AssociationEdge here.
        nameNode = new GraphNode();
        stereotypeNode = new GraphNode();

        // set the initializing size and position.
        nameNode.setPosition(StressTestHelper.createPoint(0, 0));
        nameNode.setSize(StressTestHelper.createDimension(10, 10));
        stereotypeNode.setPosition(StressTestHelper.createPoint(0, 0));
        stereotypeNode.setSize(StressTestHelper.createDimension(10, 10));

        graphEdge.addContained(nameNode);
        graphEdge.addContained(stereotypeNode);

        stereotypeNode.setContainer(graphEdge);
        nameNode.setContainer(graphEdge);

        // set the waypoint of graphEdge.
        graphEdge.addWaypoint(StressTestHelper.createPoint(54, 70));
        graphEdge.addWaypoint(StressTestHelper.createPoint(100, 300));
        graphEdge.setPosition(StressTestHelper.createPoint(30, 100));

        Association association = new AssociationImpl();

        // add left ending first.
        int[] lows = new int[] {1, 2, 3};
        int[] upps = new int[] {4, 5, 6};
        association.addConnection(getAssociationEnd(lows, upps, "left"));

        // add right ending.
        lows = new int[] {7, 8, 9};
        upps = new int[] {10, 11, 12};
        association.addConnection(getAssociationEnd(lows, upps, "right"));

        AssociationEnd leftEnd = association.getConnections().get(0);
        GraphNode leftEndGraphNode = createGraphNodeForAssociationEnd(leftEnd);

        AssociationEnd rightEnd = association.getConnections().get(1);
        GraphNode rightEndGraphNode = createGraphNodeForAssociationEnd(rightEnd);

        // Add two graph nodes for association ends to graph edge
        graphEdge.addContained(0, leftEndGraphNode);
        graphEdge.addContained(1, rightEndGraphNode);

        ModelElement element = StressTestHelper.setEdgeElement(association);

        graphEdge.setSemanticModel(StressTestHelper.getBridge(element));
    }

    /**
     * <p>
     * Creates the graph node for association end.
     * </p>
     *
     * @param associationEnd
     *            the association end to create graph node
     * @return the graph node for given association end
     */
    private static GraphNode createGraphNodeForAssociationEnd(AssociationEnd associationEnd) {
        Uml1SemanticModelBridge semanticModel;
        semanticModel = new Uml1SemanticModelBridge();
        semanticModel.setElement(associationEnd);
        GraphNode graphNode = new GraphNode();
        graphNode.setSemanticModel(semanticModel);

        // Add the graph nodes for name compartment and multiplicity compartment
        GraphNode name = new GraphNode();
        GraphNode visibility = new GraphNode();
        GraphNode multiplicity = new GraphNode();

        graphNode.addContained(name);
        graphNode.addContained(visibility);
        graphNode.addContained(multiplicity);

        return graphNode;
    }

    /**
     * <p>Basic stress test of <code>AssociationEdge</code>'s constructor.</p>
     *
     * @throws Exception if if any exception occurs when testing.
     */
    public void testAssociationEdgeCtor_Times() throws Exception {
        for (int i = 0; i < LOOPTIMES; i++) {
            edge = new AssociationEdge(graphEdge);

            // check the result here.
            assertNotNull("The AssociationEdge constructor is incorrect.", edge);
            assertEquals("The AssociationEdge constructor is incorrect.",
                nameNode, edge.getNameCompartment().getGraphNode());
            assertEquals("The AssociationEdge constructor is incorrect.",
                stereotypeNode, edge.getStereotypeCompartment().getGraphNode());

            // check the text here.
            assertEquals("The AssociationEdge constructor is incorrect.",
                "topcoderSoft", edge.getNameCompartment().getText());
            assertEquals("The AssociationEdge constructor is incorrect.",
                "<<type1, type2>>", edge.getStereotypeCompartment().getText());

            // get left ending to test the constructor.
            ActiveEdgeEnding left = (ActiveEdgeEnding) edge.getLeftEnding();

            // get the name compartment.
            TextField name = left.getNameCompartment();
            // check the text of the name compartment here.
            assertEquals("The AssociationEdge constructor is incorrect.",
                "left", name.getText());

            // get the multiplicity compartment.
            TextField multiplicity = left.getMultiplicityCompartment();
            // check the text of the multiplicity compartment here.
            assertEquals("The AssociationEdge constructor is incorrect.",
                "1..4  2..5  3..6", multiplicity.getText());

            // get right ending to test the constructor.
            ActiveEdgeEnding right = (ActiveEdgeEnding) edge.getRightEnding();
            // get the name compartment.
            name = right.getNameCompartment();
            // check the text of the name compartment here.
            assertEquals("The AssociationEdge constructor is incorrect.",
                "right", name.getText());

            // get the multiplicity compartment.
            multiplicity = right.getMultiplicityCompartment();
            // check the text of the multiplicity compartment here.
            assertEquals("The AssociationEdge constructor is incorrect.",
                "7..10  8..11  9..12", multiplicity.getText());
        }
    }

    /**
     * <p>
     * Basic stress test of <code>notifyGraphEdgeChange(String)</code> method.
     * </p>
     *
     * @throws Exception if if any exception occurs when testing.
     */
    public void testAssociationEdge_notifyGraphEdgeChange()
        throws Exception {
        edge = new AssociationEdge(graphEdge);

        for (int i = 0; i < LOOPTIMES; i++) {
            // change the size and loction of name node and stereotype node.
            nameNode.setPosition(StressTestHelper.createPoint(i, 20));
            nameNode.setSize(StressTestHelper.createDimension(50 + i, 50));
            stereotypeNode.setPosition(StressTestHelper.createPoint(30, i));
            stereotypeNode.setSize(StressTestHelper.createDimension(100, 100 +
                    i));

            // change the text of name and stereotype compartments.
            Association association = new AssociationImpl();
            association.setName("topcoderSoft" + i);

            Stereotype stereotype1 = new StereotypeImpl();
            stereotype1.setName("type" + i);

            Stereotype stereotype2 = new StereotypeImpl();
            stereotype2.setName("new type");

            association.addStereotype(stereotype1);
            association.addStereotype(stereotype2);

            // change left ending first.
            int[] lows = new int[] {i, 1 + i, 2 + i};
            int[] upps = new int[] {3 + i, 4 + i, 5 + i};
            association.addConnection(getAssociationEnd(lows, upps, "left" + i));

            // change right ending.
            lows = new int[] {6 + i, 7 + i, 8 + i};
            upps = new int[] {9 + i, 10 + i, 11 + i};
            association.addConnection(getAssociationEnd(lows, upps, "right" +
                    i));
            graphEdge.setSemanticModel(StressTestHelper.getBridge(association));

            // notify the graphEdge change here.
            edge.notifyGraphEdgeChange("graphEdge change");

            //  check the text change here.
            assertEquals("The AssociationEdge's notifyGraphEdgeChange is incorrect.",
                "topcoderSoft" + i, edge.getNameCompartment().getText());
            assertEquals("The AssociationEdge's notifyGraphEdgeChange is incorrect.",
                "<<" + "type" + i + ", " + "new type>>",
                edge.getStereotypeCompartment().getText());

            // get left ending to test the constructor.
            ActiveEdgeEnding left = (ActiveEdgeEnding) edge.getLeftEnding();

            // get the name compartment.
            TextField name = left.getNameCompartment();
            // check the text of the name compartment here.
            assertEquals("The AssociationEdge constructor is incorrect.",
                "left" + i, name.getText());

            // get the multiplicity compartment.
            TextField multiplicity = left.getMultiplicityCompartment();
            // check the text of the multiplicity compartment here.
            assertEquals("The AssociationEdge constructor is incorrect.",
                i + RANGE + (3 + i) + DIV + (1 + i) + RANGE + (4 + i) + DIV +
                (2 + i) + RANGE + (5 + i), multiplicity.getText());

            // get right ending to test the constructor.
            ActiveEdgeEnding right = (ActiveEdgeEnding) edge.getRightEnding();
            // get the name compartment.
            name = right.getNameCompartment();
            // check the text of the name compartment here.
            assertEquals("The AssociationEdge constructor is incorrect.",
                "right" + i, name.getText());

            // get the multiplicity compartment.
            multiplicity = right.getMultiplicityCompartment();
            // check the text of the multiplicity compartment here.
            assertEquals("The AssociationEdge constructor is incorrect.",
                (6 + i) + RANGE + (9 + i) + DIV + (7 + i) + RANGE + (10 + i) +
                DIV + (8 + i) + RANGE + (11 + i), multiplicity.getText());
        }
    }

    /**
     * <p>
     * Helper method used to get an instance of <code>AssociationEnd</code>
     * with the given element.
     * </p>
     *
     * @param lows the lower range used to set the <code>AssociationEnd</code>.
     * @param upps the upper range used to set the <code>AssociationEnd</code>.
     * @param name the name of the <code>AssociationEnd</code>.
     *
     * @return an instance of <code>AssociationEnd</code> that contains the
     *         given values.
     */
    private AssociationEnd getAssociationEnd(int[] lows, int[] upps, String name) {
        AssociationEnd ending = new AssociationEndImpl();
        ending.setName(name);

        Multiplicity multiplicity = new MultiplicityImpl();

        for (int i = 0, m = lows.length; i < m; i++) {
            MultiplicityRange range = new MultiplicityRangeImpl();
            range.setLower(lows[i]);
            range.setUpper(upps[i]);
            multiplicity.addRange(range);
        }

        ending.setMultiplicity(multiplicity);

        return ending;
    }
}
