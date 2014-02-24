/*
 * Copyright (C) 2007 TopCoder Inc., All Rights Reserved.
 *
 * TCS Diagram_UML_Class_Edges Version 1.0 StressTest.
 *
 * @ GeneralizationEdgeStressTest.java
 */
package com.topcoder.gui.diagramviewer.uml.classedges.stresstests;

import com.topcoder.diagraminterchange.GraphEdge;
import com.topcoder.diagraminterchange.GraphNode;

import com.topcoder.gui.diagramviewer.uml.classedges.ClosedArrow;
import com.topcoder.gui.diagramviewer.uml.classedges.GeneralizationEdge;

import com.topcoder.uml.model.core.Element;
import com.topcoder.uml.model.core.ModelElement;
import com.topcoder.uml.model.core.extensionmechanisms.Stereotype;
import com.topcoder.uml.model.core.extensionmechanisms.StereotypeImpl;
import com.topcoder.uml.model.core.relationships.GeneralizationImpl;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;


/**
 * <p>
 * This class tests the <code>GeneralizationEdge</code> class for stress.
 * This stress tests addresses
 * the functionality provided by the <code>GeneralizationEdge</code> class.
 * </p>
 *
 * @author icyriver
 * @version 1.0
 */
public class GeneralizationEdgeStressTest extends TestCase {
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
     * <p>The instance of <code>GeneralizationEdge</code> for test.</p>
     */
    private GeneralizationEdge edge = null;

    /**
     * <p>Return test suite of <code>GeneralizationEdgeStressTest</code>.</p>
     *
     * @return Test suite of <code>GeneralizationEdgeStressTest</code>.
     */
    public static Test suite() {
        return new TestSuite(GeneralizationEdgeStressTest.class);
    }

    /**
     * <p>Set up the stress testing environment.</p>
     */
    protected void setUp() {
        graphEdge = new GraphEdge();

        // create the structure of the GeneralizationEdge here.
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

        Element element = StressTestHelper.setEdgeElement(new GeneralizationImpl());
        graphEdge.setSemanticModel(StressTestHelper.getBridge(element));
    }

    /**
     * <p>Basic stress test of <code>GeneralizationEdge</code>'s constructor.</p>
     *
     * @throws Exception if if any exception occurs when testing.
     */
    public void testGeneralizationEdgeCtor_Times() throws Exception {
        for (int i = 0; i < LOOPTIMES; i++) {
            edge = new GeneralizationEdge(graphEdge);

            // check the result here.
            assertNotNull("The GeneralizationEdge constructor is incorrect.",
                edge);
            assertEquals("The GeneralizationEdge constructor is incorrect.",
                nameNode, edge.getNameCompartment().getGraphNode());
            assertEquals("The GeneralizationEdge constructor is incorrect.",
                stereotypeNode, edge.getStereotypeCompartment().getGraphNode());

            // check the text here.
            assertEquals("The GeneralizationEdge constructor is incorrect.",
                "topcoderSoft", edge.getNameCompartment().getText());
            assertEquals("The GeneralizationEdge constructor is incorrect.",
                "<<type1, type2>>", edge.getStereotypeCompartment().getText());

            // check the left ending here.
            assertNull("The GeneralizationEdge constructor is incorrect.",
                edge.getLeftEnding());
            // check the right ending here.
            assertTrue("The GeneralizationEdge constructor is incorrect.",
                (edge.getRightEnding() instanceof ClosedArrow));
        }
    }

    /**
     * <p>
     * Basic stress test of <code>notifyGraphEdgeChange(String)</code> method.
     * </p>
     *
     * @throws Exception if if any exception occurs when testing.
     */
    public void testGeneralizationEdge_notifyGraphEdgeChange()
        throws Exception {
        edge = new GeneralizationEdge(graphEdge);

        for (int i = 0; i < LOOPTIMES; i++) {
            // change the size and loction of name node and stereotype node.
            nameNode.setPosition(StressTestHelper.createPoint(i, 20));
            nameNode.setSize(StressTestHelper.createDimension(50 + i, 50));
            stereotypeNode.setPosition(StressTestHelper.createPoint(30, i));
            stereotypeNode.setSize(StressTestHelper.createDimension(100, 100 +
                    i));

            // change the text of name and stereotype compartments.
            ModelElement element = new GeneralizationImpl();
            element.setName("topcoderSoft" + i);

            Stereotype stereotype1 = new StereotypeImpl();
            stereotype1.setName("type" + i);

            Stereotype stereotype2 = new StereotypeImpl();
            stereotype2.setName("new type");

            element.addStereotype(stereotype1);
            element.addStereotype(stereotype2);
            graphEdge.setSemanticModel(StressTestHelper.getBridge(element));

            // notify the graphEdge change here.
            edge.notifyGraphEdgeChange("graphEdge change");

            //  check the text change here.
            assertEquals("The GeneralizationEdge's notifyGraphEdgeChange is incorrect.",
                "topcoderSoft" + i, edge.getNameCompartment().getText());
            assertEquals("The GeneralizationEdge's notifyGraphEdgeChange is incorrect.",
                "<<" + "type" + i + ", " + "new type>>",
                edge.getStereotypeCompartment().getText());
        }
    }
}
