/*
 * Copyright (C) 2007 TopCoder Inc., All Rights Reserved.
 *
 * TCS Diagram_UML_Use_Case Elements Version 1.0 StressTest.
 *
 * @ UseCaseNodeStressTest.java
 */
package com.topcoder.gui.diagramviewer.uml.usecaseelements.stresstests;

import com.topcoder.diagraminterchange.GraphNode;

import com.topcoder.gui.diagramviewer.uml.usecaseelements.UseCaseNode;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

import java.util.Map;


/**
 * <p>
 * This class tests the <code>UseCaseNode</code> class for stress. This stress tests
 * addresses the functionality provided by the <code>UseCaseNode</code> class.
 * </p>
 *
 * @author zmg
 * @version 1.0
 */
public class UseCaseNodeStressTest extends TestCase {
    /**
     * <p>
     * The int number represents the loop times for stress test.
     * </p>
     */
    private static final int LOOPTIMES = 100;

    /**
     * <p>The <code>GraphNode</code> instance used for test.</p>
     */
    private GraphNode graphNode = null;

    /**
     * <p>The <code>Map</code> instance used for test.</p>
     */
    private Map<String, String> properties = null;

    /**
     * <p>The <code>GraphNode</code> instance used for test.</p>
     */
    private GraphNode nameNode = null;

    /**
     * <p>The <code>GraphNode</code> instance used for test.</p>
     */
    private GraphNode stereotypeNode = null;

    /**
     * <p>The <code>GraphNode</code> instance used for test.</p>
     */
    private GraphNode namespaceNode = null;

    /**
     * <p>The instance of <code>UseCaseNode</code> for test.</p>
     */
    private UseCaseNode node = null;

    /**
     * <p>Return test suite of <code>UseCaseNodeStressTest</code>.</p>
     *
     * @return Test suite of <code>UseCaseNodeStressTest</code>.
     */
    public static Test suite() {
        return new TestSuite(UseCaseNodeStressTest.class);
    }

    /**
     * <p>Set up the stress testing environment.</p>
     */
    protected void setUp() {
        // create the properties map of BaseNode.
        properties = StressTestHelper.getProperties();

        // get the graphNode here.
        graphNode = StressTestHelper.getGraphNode(2);

        // create the structure of the Subsystem here.
        nameNode = new GraphNode();
        stereotypeNode = new GraphNode();
        namespaceNode = new GraphNode();

        // set the initializing size and position.
        nameNode.setPosition(StressTestHelper.createPoint(0, 0));
        nameNode.setSize(StressTestHelper.createDimension(10, 10));
        stereotypeNode.setPosition(StressTestHelper.createPoint(0, 0));
        stereotypeNode.setSize(StressTestHelper.createDimension(10, 10));
        namespaceNode.setPosition(StressTestHelper.createPoint(0, 0));
        namespaceNode.setSize(StressTestHelper.createDimension(10, 10));

        // create the NameCompartment here.
        GraphNode nameCompartment = new GraphNode();

        nameCompartment.addContained(stereotypeNode);
        nameCompartment.addContained(nameNode);
        nameCompartment.addContained(namespaceNode);

        graphNode.addContained(nameCompartment);
    }

    /**
     * <p>Basic stress test of <code>UseCaseNode</code>'s constructor.</p>
     *
     * @throws Exception if if any exception occurs when testing.
     */
    public void testUseCaseNodeCtor_Times() throws Exception {
        for (int i = 0; i < LOOPTIMES; i++) {
            int width = 50 + i;
            int height = 30 + i;
            graphNode.setSize(StressTestHelper.createDimension(width, height));
            node = new UseCaseNode(graphNode, properties);

            // check the result here.
            assertNotNull("The UseCaseNode constructor is incorrect.", node);
            assertEquals("The UseCaseNode constructor is incorrect.", nameNode,
                node.getNameCompartment().getGraphNode());
            assertEquals("The UseCaseNode constructor is incorrect.",
                stereotypeNode, node.getStereotypeCompartment().getGraphNode());
            assertEquals("The UseCaseNode constructor is incorrect.",
                namespaceNode, node.getNamespaceCompartment().getGraphNode());

            // check the compartment text here.
            assertEquals("The UseCaseNode constructor is incorrect.",
                "topcoderSoft", node.getNameCompartment().getText());
            assertEquals("The UseCaseNode constructor is incorrect.",
                "<<type1, type2>>", node.getStereotypeCompartment().getText());
            assertEquals("The UseCaseNode constructor is incorrect.",
                "com.topcoder.soft", node.getNamespaceCompartment().getText());
        }
    }

    /**
     * <p>
     * Basic stress test of <code>notifyGraphNodeChange()</code> method.
     * </p>
     *
     * @throws Exception if if any exception occurs when testing.
     */
    public void testUseCaseNode_notifyGraphNodeChange_AbsolutePosition()
        throws Exception {
        GraphNode dv = new GraphNode();
        dv.setPosition(StressTestHelper.createPoint(0, 0));
        GraphNode ssNode = StressTestHelper.getGraphNode(1);
        ssNode.setSize(StressTestHelper.createDimension(400, 800));
        ssNode.setPosition(StressTestHelper.createPoint(100, 200));
        ssNode.setContainer(dv);
        graphNode.setContainer(ssNode);
        ssNode.addContained(graphNode);

        // create a use case node here.
        node = new UseCaseNode(graphNode, properties);

        // change the node and test it.
        for (int i = 0; i < LOOPTIMES; i++) {
            int width = 40 + i;
            int height = 80 + i;
            graphNode.setSize(StressTestHelper.createDimension(width, height));

            int x = 10 + i;
            int y = 20 + i;
            graphNode.setPosition(StressTestHelper.createPoint(x, y));

            // notify the node change here.
            node.notifyGraphNodeChange("node changed.");

            // check the Node here.

            // get the location to test.
            assertEquals("The notifyGraphNodeChange method is incorrect.",
                105 + i, node.getLocation().x);
            assertEquals("The notifyGraphNodeChange method is incorrect.",
                215 + i, node.getLocation().y);
        }
    }

    /**
     * <p>
     * Basic stress test of <code>notifyGraphNodeChange()</code> method.
     * </p>
     *
     * @throws Exception if if any exception occurs when testing.
     */
    public void testUseCaseNode_notifyGraphNodeChange_Text()
        throws Exception {
        for (int i = 0; i < LOOPTIMES; i++) {
            int width = 50 + i;
            int height = 30 + i;
            graphNode.setSize(StressTestHelper.createDimension(width, height));
            node = new UseCaseNode(graphNode, properties);

            //  notify the node change here.
            node.notifyGraphNodeChange("node changed.");

            // check the result here.
            assertEquals("The UseCaseNode notifyGraphNodeChange method is incorrect.",
                "topcoderSoft", node.getNameCompartment().getText());
            assertEquals("The UseCaseNode notifyGraphNodeChange method is incorrect.",
                "<<type1, type2>>", node.getStereotypeCompartment().getText());
            assertEquals("The UseCaseNode notifyGraphNodeChange method is incorrect.",
                "com.topcoder.soft", node.getNamespaceCompartment().getText());
        }
    }
}
