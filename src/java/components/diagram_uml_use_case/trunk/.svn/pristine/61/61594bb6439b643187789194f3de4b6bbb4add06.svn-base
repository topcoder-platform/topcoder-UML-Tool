/*
 * Copyright (C) 2007 TopCoder Inc., All Rights Reserved.
 *
 * TCS Diagram_UML_Use_Case Elements Version 1.0 StressTest.
 *
 * @ BaseEdgeStressTest.java
 */
package com.topcoder.gui.diagramviewer.uml.usecaseelements.stresstests;

import com.topcoder.diagraminterchange.GraphEdge;
import com.topcoder.diagraminterchange.GraphNode;

import com.topcoder.gui.diagramviewer.uml.usecaseelements.BaseEdge;
import com.topcoder.gui.diagramviewer.uml.usecaseelements.IncludeEdge;

import com.topcoder.uml.model.core.Element;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;


/**
 * <p>
 * This class tests the <code>BaseEdge</code> class for stress.
 * This stress tests addresses
 * the functionality provided by the <code>BaseEdge</code> class.
 * </p>
 *
 * @author zmg
 * @version 1.0
 */
public class BaseEdgeStressTest extends TestCase {
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
     * <p>The instance of <code>BaseEdge</code> for test.</p>
     */
    private BaseEdge edge = null;

    /**
     * <p>Return test suite of <code>BaseEdgeStressTest</code>.</p>
     *
     * @return Test suite of <code>BaseEdgeStressTest</code>.
     */
    public static Test suite() {
        return new TestSuite(BaseEdgeStressTest.class);
    }

    /**
     * <p>Set up the stress testing environment.</p>
     */
    protected void setUp() {
        graphEdge = new GraphEdge();

        // create the structure of the Subsystem here.
        nameNode = new GraphNode();
        stereotypeNode = new GraphNode();

        // set the initializing size and position.
        nameNode.setPosition(StressTestHelper.createPoint(0, 0));
        nameNode.setSize(StressTestHelper.createDimension(10, 10));
        stereotypeNode.setPosition(StressTestHelper.createPoint(0, 0));
        stereotypeNode.setSize(StressTestHelper.createDimension(10, 10));

        graphEdge.addContained(stereotypeNode);
        graphEdge.addContained(nameNode);

        stereotypeNode.setContainer(graphEdge);
        nameNode.setContainer(graphEdge);

        // set the position and size of graphNode.
        graphEdge.addWaypoint(StressTestHelper.createPoint(100, 200));
        graphEdge.addWaypoint(StressTestHelper.createPoint(100, 300));
        graphEdge.setPosition(StressTestHelper.createPoint(100, 200));

        Element element = StressTestHelper.getEdgeElement();
        graphEdge.setSemanticModel(StressTestHelper.getBridge(element));
    }

    /**
     * <p>Basic stress test of <code>BaseEdge</code>'s constructor.</p>
     *
     * @throws Exception if if any exception occurs when testing.
     */
    public void testBaseEdgeCtor_Times() throws Exception {
        for (int i = 0; i < LOOPTIMES; i++) {
            edge = new IncludeEdge(graphEdge);

            // check the result here.
            assertNotNull("The BaseEdge constructor is incorrect.", edge);
            assertEquals("The BaseEdge constructor is incorrect.", nameNode,
                edge.getNameCompartment().getGraphNode());
            assertEquals("The BaseEdge constructor is incorrect.",
                stereotypeNode, edge.getStereotypeCompartment().getGraphNode());

            // check the text here.
            assertEquals("The IncludeEdge constructor is incorrect.",
                "topcoderSoft", edge.getNameCompartment().getText());
            assertEquals("The IncludeEdge constructor is incorrect.",
                "<<" + "include, " + "type1, type2>>",
                edge.getStereotypeCompartment().getText());
        }
    }

    /**
     * <p>
     * Basic stress test of <code>notifyGraphEdgeChange()</code> method.
     * </p>
     *
     * @throws Exception if if any exception occurs when testing.
     */
    public void testBaseEdge_notifyGraphEdgeChange() throws Exception {
        edge = new IncludeEdge(graphEdge);

        for (int i = 0; i < LOOPTIMES; i++) {
            // change the name node and stereotype node.
            nameNode.setPosition(StressTestHelper.createPoint(i, 20));
            nameNode.setSize(StressTestHelper.createDimension(50 + i, 50));
            stereotypeNode.setPosition(StressTestHelper.createPoint(30, i));
            stereotypeNode.setSize(StressTestHelper.createDimension(100, 100 +
                    i));

            // notify the graphEdge change here.
            edge.notifyGraphEdgeChange();
        }
    }

    /**
     * <p>
     * Basic stress test of <code>notifyGraphEdgeChange()</code> method.
     * </p>
     *
     * @throws Exception if if any exception occurs when testing.
     */
    public void testBaseEdge_notifyGraphEdgeChange_Text()
        throws Exception {
        for (int i = 0; i < LOOPTIMES; i++) {
            edge = new SimpleBaseEdge(graphEdge, null);
            // notify the edge change here.
            edge.notifyGraphEdgeChange();

            // check the result here.
            assertEquals("The BaseEdge's notifyGraphEdgeChange is incorrect.",
                "topcoderSoft", edge.getNameCompartment().getText());
            assertEquals("The BaseEdge's notifyGraphEdgeChange is incorrect.",
                "<<type1, type2>>", edge.getStereotypeCompartment().getText());

            edge = new SimpleBaseEdge(graphEdge, "include" + i);

            // notify the edge change here.
            edge.notifyGraphEdgeChange();

            // check the result here.
            assertEquals("The BaseEdge's notifyGraphEdgeChange is incorrect.",
                "topcoderSoft", edge.getNameCompartment().getText());
            assertEquals("The BaseEdge's notifyGraphEdgeChange is incorrect.",
                "<<" + "include" + i + ", " + "type1, type2>>",
                edge.getStereotypeCompartment().getText());
        }
    }
}
