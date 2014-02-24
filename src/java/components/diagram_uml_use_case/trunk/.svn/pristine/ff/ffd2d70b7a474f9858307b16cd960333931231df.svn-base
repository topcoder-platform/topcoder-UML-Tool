/*
 * Copyright (C) 2007 TopCoder Inc., All Rights Reserved.
 *
 * TCS Diagram_UML_Use_Case Elements Version 1.0 StressTest.
 *
 * @ ActorNodeStressTest.java
 */
package com.topcoder.gui.diagramviewer.uml.usecaseelements.stresstests;

import com.topcoder.diagraminterchange.GraphNode;

import com.topcoder.gui.diagramviewer.uml.usecaseelements.ActorNode;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

import java.awt.Dimension;

import java.util.Map;


/**
 * <p>
 * This class tests the <code>ActorNode</code> class for stress.
 * This stress tests addresses
 * the functionality provided by the <code>ActorNode</code> class.
 * </p>
 *
 * @author zmg
 * @version 1.0
 */
public class ActorNodeStressTest extends TestCase {
    /**
     * <p>The int number represents the loop times for stress test.</p>
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
     * <p>The instance of <code>ActorNode</code> for test.</p>
     */
    private ActorNode node = null;

    /**
     * <p>Return test suite of <code>ActorNodeStressTest</code>.</p>
     *
     * @return Test suite of <code>ActorNodeStressTest</code>.
     */
    public static Test suite() {
        return new TestSuite(ActorNodeStressTest.class);
    }

    /**
     * <p>Set up the stress testing environment.</p>
     */
    protected void setUp() {
        // create the properties map of BaseNode.
        properties = StressTestHelper.getProperties();

        // get the graphNode here.
        graphNode = StressTestHelper.getGraphNode(3);

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

        // create the compartments here.
        graphNode.addContained(stereotypeNode);
        graphNode.addContained(nameNode);
        graphNode.addContained(namespaceNode);
    }

    /**
     * <p>
     * Basic stress test of <code>ActorNode</code>'s constructor.
     * </p>
     *
     * @throws Exception if if any exception occurs when testing.
     */
    public void testActorNodeCtor_Times() throws Exception {
        node = new ActorNode(graphNode, properties);

        Dimension size = node.getPreferredGraphNodeSize();

        // get the width / height ratio of the actor
        double ratio = size.getHeight() / size.getWidth();

        for (int i = 0; i < LOOPTIMES; i++) {
            int width = 50 + i;
            int height = 30 + i;
            graphNode.setSize(StressTestHelper.createDimension(width, height));
            node = new ActorNode(graphNode, properties);

            // check the result here.
            assertNotNull("The ActorNode constructor is incorrect.", node);
            assertEquals("The ActorNode constructor is incorrect.", nameNode,
                node.getNameCompartment().getGraphNode());
            assertEquals("The ActorNode constructor is incorrect.",
                stereotypeNode, node.getStereotypeCompartment().getGraphNode());
            assertEquals("The ActorNode constructor is incorrect.",
                namespaceNode, node.getNamespaceCompartment().getGraphNode());

            size = node.getPreferredGraphNodeSize();
            assertTrue("Equal ratio expected.",
                ((size.getHeight() / size.getWidth()) < (ratio + 0.2)) &&
                ((size.getHeight() / size.getWidth()) > (ratio - 0.2)));

            // check the compartment text here.
            assertEquals("The ActorNode constructor is incorrect.",
                "topcoderSoft", node.getNameCompartment().getText());
            assertEquals("The ActorNode constructor is incorrect.",
                "<<type1, type2>>", node.getStereotypeCompartment().getText());
            assertEquals("The ActorNode constructor is incorrect.",
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
    public void testActorNode_notifyGraphNodeChange_Position()
        throws Exception {
        // create a actor case node here.
        node = new ActorNode(graphNode, properties);

        // change the node and test it.
        for (int i = 0; i < LOOPTIMES; i++) {
            int width = 40 + i;
            int height = 80 + i;
            graphNode.setSize(StressTestHelper.createDimension(width, height));

            int x = 10 + i;
            int y = 20 + i;
            graphNode.setPosition(StressTestHelper.createPoint(x, y));

            // notify the container change here.
            node.notifyGraphNodeChange("node changed.");
        }
    }

    /**
     * <p>
     * Basic stress test of <code>notifyGraphNodeChange()</code> method.
     * </p>
     *
     * @throws Exception if if any exception occurs when testing.
     */
    public void testActorNode_notifyGraphNodeChange_Text()
        throws Exception {
        for (int i = 0; i < LOOPTIMES; i++) {
            int width = 50 + i;
            int height = 30 + i;
            graphNode.setSize(StressTestHelper.createDimension(width, height));
            node = new ActorNode(graphNode, properties);

            //  notify the container change here.
            node.notifyGraphNodeChange("node changed.");

            // check the result here.
            assertEquals("The ActorNode notifyGraphNodeChange method is incorrect.",
                "topcoderSoft", node.getNameCompartment().getText());
            assertEquals("The ActorNode notifyGraphNodeChange method  is incorrect.",
                "<<type1, type2>>", node.getStereotypeCompartment().getText());
            assertEquals("The ActorNode notifyGraphNodeChange method  is incorrect.",
                "com.topcoder.soft", node.getNamespaceCompartment().getText());
        }
    }
}
