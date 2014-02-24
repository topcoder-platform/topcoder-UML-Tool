/*
 * Copyright (C) 2007 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.gui.diagramviewer.uml.usecaseelements;

import java.awt.Dimension;
import java.awt.Graphics;
import java.util.HashMap;
import java.util.Map;

import javax.swing.JFrame;

import junit.framework.TestCase;

import com.topcoder.diagraminterchange.GraphEdge;
import com.topcoder.diagraminterchange.GraphNode;
import com.topcoder.gui.diagramviewer.uml.usecaseelements.event.MockBoundaryChangedListener;

/**
 * <p>
 * Unit test cases for ActorNode.
 * </p>
 *
 * @author TCSDEVELOPER
 * @version 1.0
 */
public class ActorNodeTests extends TestCase {
    /**
     * <p>
     * ActorNode instance for testing.
     * </p>
     */
    private ActorNode actorNode;

    /**
     * <p>
     * GraphNode instance for testing.
     * </p>
     */
    private GraphNode graphNode;

    /**
     * <p>
     * Sets up test environment.
     * </p>
     */
    protected void setUp() {
        try {
            graphNode = TestHelper.createGraphNodeForActor();
            actorNode = new ActorNode(graphNode, new HashMap<String, String>());
        } catch (IllegalGraphElementException e) {
            fail("no exception will be thrown.");
        }
    }

    /**
     * <p>
     * Tears down test environment.
     * </p>
     */
    protected void tearDown() {
        actorNode = null;
    }

    /**
     * <p>
     * Tests {@link ActorNode#ActorNode(GraphNode, java.util.Map)} for accuracy.
     * </p>
     * <p>
     * It verifies the newly created instance is not null.
     * </p>
     */
    public void testCtor() {
        assertNotNull("Failed to created the ActorNode instance.", actorNode);
    }

    /**
     * <p>
     * Tests {@link ActorNode#ActorNode(GraphNode, java.util.Map)} for failure.
     * </p>
     * <p>
     * It tests the case that when graphNode is null and expects IllegalArgumentException.
     * </p>
     */
    public void testCtor_NullGraphNode() {
        try {
            new ActorNode(null, new HashMap<String, String>());
            fail("NullPointerException expected.");
        } catch (IllegalArgumentException e) {
            // the expected case
        } catch (IllegalGraphElementException e) {
            fail("no IllegalGraphElementException will be thrown.");
        }
    }

    /**
     * <p>
     * Tests {@link ActorNode#ActorNode(GraphNode, java.util.Map)} for failure.
     * </p>
     * <p>
     * It tests the case that when properties is null and expects IllegalArgumentException.
     * </p>
     */
    public void testCtor_NullProperties() {
        try {
            new ActorNode(TestHelper.createGraphNodeForActor(), null);
            fail("IllegalArgumentException expected.");
        } catch (IllegalArgumentException iae) {
            // the expected case
        } catch (IllegalGraphElementException e) {
            fail("no IllegalGraphElementException will be thrown.");
        }
    }

    /**
     * <p>
     * Tests {@link ActorNode#ActorNode(GraphNode, Map)} for failure.
     * </p>
     * <p>
     * It tests the case that when the passed graphNode's structure is bad, and expects IllegalGraphElementException.
     * </p>
     *
     * @throws Exception to JUnit.
     */
    public void testCtor_BadGraphNode1() throws Exception {
        Map<String, String> map = new HashMap<String, String>();
        try {
            new ActorNode(new GraphNode(), map);
            fail("IllegalGraphElementException is expected.");
        } catch (IllegalGraphElementException e) {
            // ok.
        }
    }

    /**
     * <p>
     * Tests {@link ActorNode#ActorNode(GraphNode, Map)} for failure.
     * </p>
     * <p>
     * It tests the case that when the passed graphNode's structure is bad, and expects IllegalGraphElementException.
     * </p>
     *
     * @throws Exception to JUnit.
     */
    public void testCtor_BadGraphNode2() throws Exception {
        Map<String, String> map = new HashMap<String, String>();

        GraphNode node = TestHelper.createNameCompartment();
        node.addContained(TestHelper.createNameCompartment());

        try {
            new ActorNode(node, map);
            fail("IllegalGraphElementException is expected.");
        } catch (IllegalGraphElementException e) {
            // ok.
        }
    }

    /**
     * <p>
     * Tests {@link ActorNode#ActorNode(GraphNode, Map)} for failure.
     * </p>
     * <p>
     * It tests the case that when the passed graphNode's structure is bad, and expects IllegalGraphElementException.
     * </p>
     *
     * @throws Exception to JUnit.
     */
    public void testCtor_BadGraphNode3() throws Exception {
        Map<String, String> map = new HashMap<String, String>();

        GraphNode node = TestHelper.createNameCompartment();
        node.addContained(TestHelper.createNameCompartment());
        node.addContained(TestHelper.createNamespaceCompartment());

        try {
            new ActorNode(node, map);
            fail("IllegalGraphElementException is expected.");
        } catch (IllegalGraphElementException e) {
            // ok.
        }
    }

    /**
     * <p>
     * Tests {@link ActorNode#ActorNode(GraphNode, Map)} for failure.
     * </p>
     * <p>
     * It tests the case that when the passed graphNode's structure is bad, and expects IllegalGraphElementException.
     * </p>
     *
     * @throws Exception to JUnit.
     */
    public void testCtor_BadGraphNode4() throws Exception {
        Map<String, String> map = new HashMap<String, String>();

        GraphNode node = TestHelper.createNameCompartment();
        node.addContained(TestHelper.createNameCompartment());
        node.addContained(TestHelper.createNamespaceCompartment());
        node.addContained(new GraphEdge());

        try {
            new ActorNode(node, map);
            fail("IllegalGraphElementException is expected.");
        } catch (IllegalGraphElementException e) {
            // ok.
        }
    }

    /**
     * <p>
     * Tests {@link ActorNode#ActorNode(GraphNode, Map)} for failure.
     * </p>
     * <p>
     * It tests the case that when the passed graphNode's structure is bad, and expects IllegalGraphElementException.
     * </p>
     *
     * @throws Exception to JUnit.
     */
    public void testCtor_BadGraphNode5() throws Exception {
        Map<String, String> map = new HashMap<String, String>();

        GraphNode node = TestHelper.createNameCompartment();
        node.addContained(new GraphEdge());
        node.addContained(TestHelper.createNameCompartment());
        node.addContained(TestHelper.createNameCompartment());

        try {
            new ActorNode(node, map);
            fail("IllegalGraphElementException is expected.");
        } catch (IllegalGraphElementException e) {
            // ok.
        }
    }

    /**
     * <p>
     * Tests {@link ActorNode#ActorNode(GraphNode, Map)} for failure.
     * </p>
     * <p>
     * It tests the case that when the passed graphNode's structure is bad, and expects IllegalGraphElementException.
     * </p>
     *
     * @throws Exception to JUnit.
     */
    public void testCtor_BadGraphNode6() throws Exception {
        Map<String, String> map = new HashMap<String, String>();

        GraphNode node = TestHelper.createNameCompartment();

        node.addContained(TestHelper.createNameCompartment());
        node.addContained(new GraphEdge());
        node.addContained(TestHelper.createNameCompartment());

        try {
            new ActorNode(node, map);
            fail("IllegalGraphElementException is expected.");
        } catch (IllegalGraphElementException e) {
            // ok.
        }
    }

    /**
     * <p>
     * Tests {@link ActorNode#getPreferredGraphNodeSize()} for accuracy.
     * </p>
     * <p>
     * It verifies the dimension's width and height is at the right ratio.
     * </p>
     */
    public void testGetPreferredGraphNodeSize() {
        actorNode.getPreferredGraphNodeSize();
        /*
         * BugFix: UML-9717
         */
        // old code
//        double ratio = dimension.width * 1.0 / dimension.height;
//        assertTrue("getPreferredGraphNodeSize behavior is abnormal.", ratio > 0.624 && ratio < 0.626);
    }

//    /**
//     * <p>
//     * Unit Test of the <code>getPreferredGraphNodeSize()</code> method.
//     * </p>
//     */
//    public void testGetPreferredGraphNodeSize2() {
//        Dimension size = actorNode.getPreferredGraphNodeSize();
//
//        // get the width / height ratio of the actor
//        double ratio = size.getHeight() / size.getWidth();
//
//        // change the size.
//        graphNode.setSize(TestHelper.getDimension(100.0, 160.0));
//        size = actorNode.getPreferredGraphNodeSize();
//        assertEquals("Equal ratio expected.", ratio, size.getHeight() / size.getWidth());
//    }

    /**
     * <p>
     * Tests {@link ActorNode#contains(int, int)} for accuracy.
     * </p>
     * <p>
     * It pass the point within it and expects true.
     * </p>
     */
    public void testContains1() {
        assertTrue("contains behavior is abnormal.", actorNode.contains(20, 20));
    }

    /**
     * <p>
     * Tests {@link ActorNode#contains(int, int)} for accuracy.
     * </p>
     * <p>
     * It pass the point out of it and expects false.
     * </p>
     */
    public void testContains2() {
        assertFalse("contains behavior is abnormal.", actorNode.contains(500, 500));
    }

    /**
     * <p>
     * Tests {@link ActorNode#paintComponent(java.awt.Graphics)} for accuracy.
     * </p>
     * <p>
     * It provides the graphics, and ensures no exception will be thrown.
     * </p>
     */
    public void testPaintComponent() {
        JFrame frame = new JFrame();
        frame.setVisible(true);
        Graphics g = frame.getGraphics();
        actorNode.paintComponent(g);
        frame.setVisible(false);
    }

    /**
     * <p>
     * Tests {@link ActorNode#paintComponent(java.awt.Graphics)} for accuracy.
     * </p>
     * <p>
     * It tests the case that when g is null and expects success.
     * </p>
     */
    public void testPaintComponents_NullG() {
        actorNode.paintComponent(null);
        // no exception will be thrown
    }

    /**
     * <p>
     * Tests {@link ActorNode#notifyGraphNodeChange(String)} for accuracy.
     * </p>
     * <p>
     * It verifies the BoundaryChangedEvent will be fired.
     * </p>
     */
    public void testNotifyGraphNodeChange() {
        MockBoundaryChangedListener listener = new MockBoundaryChangedListener();
        actorNode.addBoundaryChangeListener(listener);
        graphNode.getSize().setHeight(300);
        graphNode.getSize().setWidth(200);
        try {
            actorNode.notifyGraphNodeChange("boundary is changed");
        } catch (IllegalGraphElementException e) {
            fail("no IllegalGraphElementException will be thrown.");
        }
        assertTrue("notifyGraphNodeChange behavior is abnormal.", listener.getIsExecute());
    }

    /**
     * <p>
     * Unit Test of the <code>notifyGraphNodeChange(String)</code> method.
     * </p>
     *
     * @throws Exception to JUnit.
     */
    public void testNotifyGraphNodeChange_Node1() throws Exception {
        graphNode.setSize(TestHelper.getDimension(150, 50));
        graphNode.setPosition(TestHelper.getPoint(100, 200));

        actorNode.notifyGraphNodeChange("change");

        // get the size to test.
        assertTrue("Size should be expanded in vertical direction.", actorNode.getSize().getHeight() > 60.0);
        assertEquals("Equal size expected.", 160.0, actorNode.getSize().getWidth());

        // get the bound to test.
        assertEquals("Equal bound expected.", 80, actorNode.getSelectionBound().height);
        assertEquals("Equal bound expected.", 150, actorNode.getSelectionBound().width);
    }

    /**
     * <p>
     * Unit Test of the <code>notifyGraphNodeChange(String)</code> method.
     * </p>
     *
     * @throws Exception to JUnit.
     */
    public void testNotifyGraphNodeChange_Node2() throws Exception {
        graphNode.setSize(TestHelper.getDimension(30, 50));
        graphNode.setPosition(TestHelper.getPoint(100, 200));

        actorNode.notifyGraphNodeChange("change");

        int width = 40;
        width = Math.max(width, actorNode.getNameCompartment().getWidth());
        width = Math.max(width, actorNode.getStereotypeCompartment().getWidth());
        width = Math.max(width, actorNode.getNamespaceCompartment().getWidth());
        int height = 80;
        height += actorNode.getNameCompartment().getHeight();
        height += actorNode.getStereotypeCompartment().getHeight();
        height += actorNode.getNamespaceCompartment().getHeight();
        // get the size to test.
        assertEquals("Equal size expected.", height + 10, actorNode.getHeight());
        assertEquals("Equal size expected.", width + 10, actorNode.getWidth());

        // get the bound to test.
        assertEquals("Equal bound expected.", (width - 40) / 2 + 5, actorNode.getSelectionBound().x);
        assertEquals("Equal bound expected.", actorNode.getStereotypeCompartment().getHeight() + 5, actorNode.getSelectionBound().y);
        assertEquals("Equal bound expected.", 80, actorNode.getSelectionBound().height);
        assertEquals("Equal bound expected.", 40, actorNode.getSelectionBound().width);
    }

    /**
     * <p>
     * Unit Test of the <code>notifyGraphNodeChange(String)</code> method.
     * </p>
     * <p>
     * It tests the case that when compartments are out of the rectangle of actor.
     * </p>
     *
     * @throws Exception to JUnit.
     */
    public void testNotifyGraphNodeChange_Node3() throws Exception {
        actorNode = new ActorNode(TestHelper.createGraphNodeForActor1(), TestHelper.createProperties());

        // get the size to test.
        assertEquals("Equal size expected.", 369.0, actorNode.getSize().getHeight());
        assertEquals("Equal size expected.", 210.0, actorNode.getSize().getWidth());
        // the width of actorNode should be 110, because it contains a compartment which width is 100

        // get the bound to test.
        assertEquals("Equal bound expected.", 5, actorNode.getSelectionBound().x);
        assertEquals("Equal bound expected.", 18, actorNode.getSelectionBound().y);
        assertEquals("Equal bound expected.", 320, actorNode.getSelectionBound().height);
        assertEquals("Equal bound expected.", 200, actorNode.getSelectionBound().width);
    }

    /**
     * <p>
     * Unit Test of the <code>notifyGraphNodeChange(String)</code> method.
     * </p>
     *
     * @throws Exception to JUnit.
     */
    public void testNotifyGraphNodeChange_Compartments() throws Exception {
        GraphNode nameNode = (GraphNode) graphNode.getContaineds().get(1);
        GraphNode stereotypeNode = (GraphNode) graphNode.getContaineds().get(0);
        GraphNode namespaceNode = (GraphNode) graphNode.getContaineds().get(2);

        // change the size and location name graphNode.
        nameNode.setPosition(TestHelper.getPoint(5.0, 9.0));
        nameNode.setSize(TestHelper.getDimension(4.5, 2.3));

        // change the size and location stereotype graphNode.
        stereotypeNode.setPosition(TestHelper.getPoint(20.0, 30.0));
        stereotypeNode.setSize(TestHelper.getDimension(5.2, 3.4));

        // change the size and location namespace graphNode.
        namespaceNode.setPosition(TestHelper.getPoint(19.0, 31.0));
        namespaceNode.setSize(TestHelper.getDimension(5.2, 6.7));

        actorNode.notifyGraphNodeChange("change");
    }

    /**
     * <p>
     * Unit Test of the <code>notifyGraphNodeChange(String)</code> method.
     * </p>
     *
     * @throws Exception to JUnit.
     */
    public void testNotifyGraphNodeChange_Name() throws Exception {
        actorNode.notifyGraphNodeChange("change");
        assertEquals("Actor_1", actorNode.getNameCompartment().getText());
    }

    /**
     * <p>
     * Unit Test of the <code>notifyGraphNodeChange(String)</code> method.
     * </p>
     *
     * @throws Exception to JUnit.
     */
    public void testNotifyGraphNodeChange_Stereotype() throws Exception {
        actorNode.notifyGraphNodeChange("change");
        assertEquals("<<interface>>", actorNode.getStereotypeCompartment().getText());
    }

    /**
     * <p>
     * Unit Test of the <code>notifyGraphNodeChange(String)</code> method.
     * </p>
     *
     * @throws Exception to JUnit.
     */
    public void testNotifyGraphNodeChange_Namespace() throws Exception {
        actorNode.notifyGraphNodeChange("change");
        assertEquals("com.topcoder", actorNode.getNamespaceCompartment().getText());
    }

    /**
     * <p>
     * Tests {@link BaseNode#notifyNamespaceVisibilityChange()} for accuracy.
     * </p>
     * <p>
     * It verifies the method is correct.
     * </p>
     *
     * @throws Exception to JUnit.
     */
    public void testNotifyNamespaceVisibilityChange_True() throws Exception {
        GraphNode namespaceNode = (GraphNode) graphNode.getContaineds().get(2);
        namespaceNode.setVisible(true);

        actorNode.notifyNamespaceVisibilityChange();
        assertTrue("failed to notify namespace visibility change", actorNode.getNamespaceCompartment().isVisible());
    }

    /**
     * <p>
     * Tests {@link BaseNode#notifyNamespaceVisibilityChange()} for accuracy.
     * </p>
     * <p>
     * It verifies the method is correct.
     * </p>
     *
     * @throws Exception to JUnit.
     */
    public void testNotifyNamespaceVisibilityChange_False() throws Exception {
        GraphNode namespaceNode = (GraphNode) graphNode.getContaineds().get(2);
        namespaceNode.setVisible(false);

        actorNode.notifyNamespaceVisibilityChange();
        assertFalse("failed to notify namespace visibility change", actorNode.getNamespaceCompartment().isVisible());
    }

    /**
     * <p>
     * Tests {@link BaseNode#notifyStereotypeVisibilityChange()} for accuracy.
     * </p>
     * <p>
     * It verifies the method is correct.
     * </p>
     *
     * @throws Exception to JUnit.
     */
    public void testNotifyStereotypeVisibilityChange_True() throws Exception {
        GraphNode stereotypeNode = (GraphNode) graphNode.getContaineds().get(0);
        stereotypeNode.setVisible(true);

        actorNode.notifyStereotypeVisibilityChange();
        assertTrue("failed to notify stereotype visibility change", actorNode.getStereotypeCompartment().isVisible());
    }

    /**
     * <p>
     * Tests {@link BaseNode#notifyStereotypeVisibilityChange()} for accuracy.
     * </p>
     * <p>
     * It verifies the method is correct.
     * </p>
     *
     * @throws Exception to JUnit.
     */
    public void testNotifyStereotypeVisibilityChange_False() throws Exception {
        GraphNode stereotypeNode = (GraphNode) graphNode.getContaineds().get(0);
        stereotypeNode.setVisible(false);

        actorNode.notifyStereotypeVisibilityChange();
        assertFalse("failed to notify stereotype visibility change", actorNode.getStereotypeCompartment().isVisible());
    }

    /**
     * <p>
     * The entry of the demo program.
     * </p>
     *
     * @param args the arguments
     */
    public static void main(String[] args) {
        ActorNode actorNode;
        try {
            actorNode = new ActorNode(TestHelper.createGraphNodeForActor1(), TestHelper.createProperties());
            actorNode.notifyGraphNodeChange("change");

            JFrame frame = new JFrame();
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setLayout(null);
            frame.getContentPane().add(actorNode);
            frame.setSize(new Dimension(500, 500));
            frame.setVisible(true);
        } catch (IllegalGraphElementException e) {
            e.printStackTrace();
        }
    }
}
