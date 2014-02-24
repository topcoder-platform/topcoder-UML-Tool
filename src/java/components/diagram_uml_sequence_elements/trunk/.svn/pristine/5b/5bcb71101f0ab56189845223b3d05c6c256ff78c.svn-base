/*
 * Copyright (C) 2007 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.gui.diagramviewer.uml.sequenceelements;

import java.awt.Dimension;
import java.util.EnumMap;

import javax.swing.JFrame;

import com.topcoder.diagraminterchange.Diagram;
import com.topcoder.diagraminterchange.GraphEdge;
import com.topcoder.diagraminterchange.GraphNode;
import com.topcoder.diagraminterchange.Uml1SemanticModelBridge;
import com.topcoder.gui.diagramviewer.edges.AnchorType;
import com.topcoder.gui.diagramviewer.uml.sequenceelements.edgeendings.ConfiguredEdgeEndingPropertyType;
import com.topcoder.uml.model.commonbehavior.links.LinkImpl;

import junit.framework.TestCase;
import junit.framework.TestSuite;
import junit.framework.Test;

/**
 * <p>
 * Unit test cases for AsynchronousMessageEdge.
 * </p>
 *
 * @author TCSDEVELOPER
 * @version 1.1
 * @since 1.0
 */
public class AsynchronousMessageEdgeTests extends TestCase {
    /**
     * <p>
     * AsynchronousMessageEdge instance for testing.
     * </p>
     */
    private AsynchronousMessageEdge edge;

    /**
     * <p>
     * GraphEdge instance for helping testing.
     * </p>
     */
    private GraphEdge graphEdge;

    /**
     * <p>
     * Sets up test environment.
     * </p>
     *
     * @throws Exception to JUnit
     */
    protected void setUp() throws Exception {
        // set up the diagram instance
        Diagram diagram = new Diagram();
        graphEdge = TestHelper.createGraphEdge();

        graphEdge.addWaypoint(TestHelper.createDiagramInterchangePoint(100, 100));
        graphEdge.addWaypoint(TestHelper.createDiagramInterchangePoint(200, 200));
        graphEdge.addWaypoint(TestHelper.createDiagramInterchangePoint(300, 400));
        diagram.addContained(graphEdge);

        edge = new AsynchronousMessageEdge(new LinkImpl(), graphEdge, TestHelper.createEdgeEndingProperties(),
            TestHelper.createSequenceEdgeProperties());
    }

    /**
     * <p>
     * Tears down test environment.
     * </p>
     *
     * @throws Exception to JUnit
     */
    protected void tearDown() throws Exception {
        graphEdge = null;
        edge = null;
    }

    /**
     * <p>
     * Returns all tests.
     * </p>
     *
     * @return all tests
     */
    public static Test suite() {
        return new TestSuite(AsynchronousMessageEdgeTests.class);
    }

    /**
     * <p>
     * Tests ctor AsynchronousMessageEdge#AsynchronousMessageEdge(Link,GraphEdge,EnumMap,EnumMap) for accuracy.
     * </p>
     *
     * <p>
     * It verifies the newly created AsynchronousMessageEdge instance should not be null.
     * </p>
     */
    public void testCtor() {
        assertNotNull("Failed to create a new AsynchronousMessageEdge instance.", edge);
    }

    /**
     * <p>
     * Tests ctor AsynchronousMessageEdge#AsynchronousMessageEdge(Link,GraphEdge,EnumMap,EnumMap) for failure.
     * </p>
     *
     * <p>
     * It tests the case that when link is null and expects IllegalArgumentException.
     * </p>
     */
    public void testCtor_NullLink() {
        try {
            new AsynchronousMessageEdge(null, graphEdge, TestHelper.createEdgeEndingProperties(),
                TestHelper.createSequenceEdgeProperties());
            fail("IllegalArgumentException expected.");
        } catch (IllegalArgumentException iae) {
            //good
        }
    }

    /**
     * <p>
     * Tests ctor AsynchronousMessageEdge#AsynchronousMessageEdge(Link,GraphEdge,EnumMap,EnumMap) for failure.
     * </p>
     *
     * <p>
     * It tests the case that when graphEdge is null and expects IllegalArgumentException.
     * </p>
     */
    public void testCtor_NullGraphEdge() {
        try {
            new AsynchronousMessageEdge(new LinkImpl(), null, TestHelper.createEdgeEndingProperties(),
                TestHelper.createSequenceEdgeProperties());
            fail("IllegalArgumentException expected.");
        } catch (IllegalArgumentException iae) {
            //good
        }
    }

    /**
     * <p>
     * Tests ctor AsynchronousMessageEdge#AsynchronousMessageEdge(Link,GraphEdge,EnumMap,EnumMap) for failure.
     * </p>
     *
     * <p>
     * It tests the case that when end property is null and expects IllegalArgumentException.
     * </p>
     */
    public void testCtor_NullEndproperty() {
        try {
            new AsynchronousMessageEdge(new LinkImpl(), graphEdge, null, TestHelper.createSequenceEdgeProperties());
            fail("IllegalArgumentException expected.");
        } catch (IllegalArgumentException iae) {
            //good
        }
    }

    /**
     * <p>
     * Tests ctor AsynchronousMessageEdge#AsynchronousMessageEdge(Link,GraphEdge,EnumMap,EnumMap) for failure.
     * </p>
     *
     * <p>
     * It tests the case that when end property is empty and expects IllegalArgumentException.
     * </p>
     */
    public void testCtor_EmptyEndproperty() {
        try {
            new AsynchronousMessageEdge(new LinkImpl(), graphEdge,
                new EnumMap<ConfiguredEdgeEndingPropertyType, String>(ConfiguredEdgeEndingPropertyType.class),
                TestHelper.createSequenceEdgeProperties());
            fail("IllegalArgumentException expected.");
        } catch (IllegalArgumentException iae) {
            //good
        }
    }

    /**
     * <p>
     * Tests ctor AsynchronousMessageEdge#AsynchronousMessageEdge(Link,GraphEdge,EnumMap,EnumMap) for failure.
     * </p>
     *
     * <p>
     * It tests the case that when edge property is null and expects IllegalArgumentException.
     * </p>
     */
    public void testCtor_NullEdgeproperty() {
        try {
            new AsynchronousMessageEdge(new LinkImpl(), graphEdge, TestHelper.createEdgeEndingProperties(), null);
            fail("IllegalArgumentException expected.");
        } catch (IllegalArgumentException iae) {
            //good
        }
    }

    /**
     * <p>
     * Tests ctor AsynchronousMessageEdge#AsynchronousMessageEdge(Link,GraphEdge,EnumMap,EnumMap) for failure.
     * </p>
     *
     * <p>
     * It tests the case that when edge property is empty and expects IllegalArgumentException.
     * </p>
     */
    public void testCtor_EmptyEdgeproperty() {
        try {
            new AsynchronousMessageEdge(new LinkImpl(), graphEdge, TestHelper.createEdgeEndingProperties(),
                new EnumMap<SequenceEdgePropertyType, String>(SequenceEdgePropertyType.class));
            fail("IllegalArgumentException expected.");
        } catch (IllegalArgumentException iae) {
            //good
        }
    }

    /**
     * <p>
     * Tests AsynchronousMessageEdge#paintComponent(Graphics) for failure.
     * </p>
     *
     * <p>
     * It tests the case that when g is null and expects IllegalArgumentException.
     * </p>
     */
    public void testPaintComponent_NullG() {
        try {
            edge.paintComponent(null);
            fail("IllegalArgumentException expected.");
        } catch (IllegalArgumentException iae) {
            //good
        }
    }

    /**
     * <p>
     * The entry of the demo program.
     * </p>
     *
     * @param args the arguments
     */
    public static void main(String[] args) {
        // set up the diagram instance
        Diagram diagram = new Diagram();
        GraphEdge edge = new GraphEdge();
        edge.addWaypoint(TestHelper.createDiagramInterchangePoint(100, 100));
        edge.addWaypoint(TestHelper.createDiagramInterchangePoint(200, 200));
        edge.addWaypoint(TestHelper.createDiagramInterchangePoint(300, 400));
        diagram.addContained(edge);

        // set up the edge instance
        AsynchronousMessageEdge gEdge = new AsynchronousMessageEdge(new LinkImpl(), edge,
            TestHelper.createEdgeEndingProperties(), TestHelper.createSequenceEdgeProperties());
        gEdge.setShowTextFields(true);
        gEdge.addTextField(new GraphNode(), "Head", AnchorType.LeftEnding);
        gEdge.addTextField(new GraphNode(), "Head2", AnchorType.LeftEnding);
        gEdge.addTextField(new GraphNode(), "Tail", AnchorType.RightEnding);
        gEdge.addTextField(new GraphNode(), "Tail2", AnchorType.RightEnding);
        gEdge.addTextField(new GraphNode(), "Middle", AnchorType.Line);
        gEdge.addTextField(new GraphNode(), "Middle2", AnchorType.Line);

        // set up the JFrame instance and show it
        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().add(gEdge);
        frame.setSize(new Dimension(500, 500));
        frame.setVisible(true);
    }
}