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
import com.topcoder.diagraminterchange.GraphElement;
import com.topcoder.diagraminterchange.GraphNode;
import com.topcoder.gui.diagramviewer.uml.usecaseelements.event.MockBoundaryChangedListener;

/**
 * <p>
 * Unit test cases for UseCaseNode.
 * </p>
 *
 * @author TCSDEVELOPER
 * @version 1.0
 */
public class UseCaseNodeTests extends TestCase {
    /**
     * <p>
     * UseCaseNode instance for testing.
     * </p>
     */
    private UseCaseNode useCaseNode;

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
            graphNode = TestHelper.createGraphNodeForUseCase();
            useCaseNode = new UseCaseNode(graphNode, new HashMap<String, String>());
        } catch (IllegalGraphElementException e) {
            fail("no IllegalGraphElementException will be thrown.");
        }
    }

    /**
     * <p>
     * Tears down test environment.
     * </p>
     */
    protected void tearDown() {
        useCaseNode = null;
    }

    /**
     * <p>
     * Tests {@link UseCaseNode#UseCaseNode(GraphNode, java.util.Map)} for accuracy.
     * </p>
     * <p>
     * It verifies the newly created instance is not null.
     * </p>
     */
    public void testCtor() {
        assertNotNull("Failed to created the UseCaseNode instance.", useCaseNode);
    }

    /**
     * <p>
     * Tests {@link UseCaseNode#UseCaseNode(GraphNode, java.util.Map)} for failure.
     * </p>
     * <p>
     * It tests the case that when graphNode is null and expects IllegalArgumentException.
     * </p>
     */
    public void testCtor_NullGraphNode() {
        try {
            new UseCaseNode(null, new HashMap<String, String>());
            fail("NullPointerException expected.");
        } catch (IllegalArgumentException e) {
            // the expected case
        } catch (IllegalGraphElementException e) {
            fail("no IllegalGraphElementException will be thrown.");
        }
    }

    /**
     * <p>
     * Tests {@link UseCaseNode#UseCaseNode(GraphNode, java.util.Map)} for failure.
     * </p>
     * <p>
     * It tests the case that when properties is null and expects IllegalArgumentException.
     * </p>
     */
    public void testCtor_NullProperties() {
        try {
            new UseCaseNode(TestHelper.createGraphNodeForUseCase(), null);
            fail("IllegalArgumentException expected.");
        } catch (IllegalArgumentException iae) {
            // the expected case
        } catch (IllegalGraphElementException e) {
            fail("no IllegalGraphElementException will be thrown.");
        }
    }

    /**
     * <p>
     * Tests {@link UseCaseNode#UseCaseNode(GraphNode, Map)} for failure.
     * </p>
     * <p>
     * It tests the case that when the passed graphNode's structure is bad, and expects IllegalGraphElementException.
     * </p>
     *
     * @throws Exception to JUnit.
     */
    public void testCtor_BadGraphNode1() throws Exception {
        GraphNode node = new GraphNode();

        Map<String, String> map = new HashMap<String, String>();
        try {
            new UseCaseNode(node, map);
            fail("IllegalGraphElementException is expected.");
        } catch (IllegalGraphElementException e) {
            // ok.
        }
    }

    /**
     * <p>
     * Tests {@link UseCaseNode#UseCaseNode(GraphNode, Map)} for failure.
     * </p>
     * <p>
     * It tests the case that when the passed graphNode's structure is bad, and expects IllegalGraphElementException.
     * </p>
     *
     * @throws Exception to JUnit.
     */
    public void testCtor_BadGraphNode2() throws Exception {
        GraphNode node = new GraphNode();

        node.addContained(new GraphNode());

        Map<String, String> map = new HashMap<String, String>();
        try {
            new UseCaseNode(node, map);
            fail("IllegalGraphElementException is expected.");
        } catch (IllegalGraphElementException e) {
            // ok.
        }
    }

    /**
     * <p>
     * Tests {@link UseCaseNode#UseCaseNode(GraphNode, Map)} for failure.
     * </p>
     * <p>
     * It tests the case that when the passed graphNode's structure is bad, and expects IllegalGraphElementException.
     * </p>
     *
     * @throws Exception to JUnit.
     */
    public void testCtor_BadGraphNode3() throws Exception {
        GraphNode node = new GraphNode();

        GraphNode sub = new GraphNode();
        sub.addContained(new GraphNode());

        node.addContained(sub);

        Map<String, String> map = new HashMap<String, String>();
        try {
            new UseCaseNode(node, map);
            fail("IllegalGraphElementException is expected.");
        } catch (IllegalGraphElementException e) {
            // ok.
        }
    }

    /**
     * <p>
     * Tests {@link UseCaseNode#UseCaseNode(GraphNode, Map)} for failure.
     * </p>
     * <p>
     * It tests the case that when the passed graphNode's structure is bad, and expects IllegalGraphElementException.
     * </p>
     *
     * @throws Exception to JUnit.
     */
    public void testCtor_BadGraphNode4() throws Exception {
        GraphNode node = new GraphNode();

        GraphNode sub = new GraphNode();
        sub.addContained(new GraphNode());
        sub.addContained(new GraphNode());

        node.addContained(sub);

        Map<String, String> map = new HashMap<String, String>();
        try {
            new UseCaseNode(node, map);
            fail("IllegalGraphElementException is expected.");
        } catch (IllegalGraphElementException e) {
            // ok.
        }
    }

    /**
     * <p>
     * Tests {@link UseCaseNode#UseCaseNode(GraphNode, Map)} for failure.
     * </p>
     * <p>
     * It tests the case that when the passed graphNode's structure is bad, and expects IllegalGraphElementException.
     * </p>
     *
     * @throws Exception to JUnit.
     */
    public void testCtor_BadGraphNode5() throws Exception {
        GraphNode node = new GraphNode();

        GraphNode sub = new GraphNode();
        sub.addContained(new GraphEdge());
        sub.addContained(new GraphNode());
        sub.addContained(new GraphNode());

        node.addContained(sub);

        Map<String, String> map = new HashMap<String, String>();
        try {
            new UseCaseNode(node, map);
            fail("IllegalGraphElementException is expected.");
        } catch (IllegalGraphElementException e) {
            // ok.
        }
    }

    /**
     * <p>
     * Tests {@link UseCaseNode#UseCaseNode(GraphNode, Map)} for failure.
     * </p>
     * <p>
     * It tests the case that when the passed graphNode's structure is bad, and expects IllegalGraphElementException.
     * </p>
     *
     * @throws Exception to JUnit.
     */
    public void testCtor_BadGraphNode6() throws Exception {
        GraphNode node = new GraphNode();

        GraphNode sub = new GraphNode();
        sub.addContained(new GraphNode());
        sub.addContained(new GraphNode());
        sub.addContained(new GraphEdge());

        node.addContained(sub);

        Map<String, String> map = new HashMap<String, String>();
        try {
            new UseCaseNode(node, map);
            fail("IllegalGraphElementException is expected.");
        } catch (IllegalGraphElementException e) {
            // ok.
        }
    }

    /**
     * <p>
     * Tests {@link UseCaseNode#getPreferredGraphNodeSize()} for accuracy.
     * </p>
     * <p>
     * It verifies the dimension's width and height is at the right ratio.
     * </p>
     */
    public void testGetPreferredGraphNodeSize() {
        useCaseNode.getPreferredGraphNodeSize();
        /*
         * Bugfix: UML-9574
         * The width and height should be able to be independently adjusted.
         */
        // old code
//        double ratio = dimension.width * 1.0 / dimension.height;
//        assertTrue("getPreferredGraphNodeSize behavior is abnormal.", ratio > 1.79 && ratio < 1.81);
    }

    /**
     * <p>
     * Tests {@link UseCaseNode#getPreferredGraphNodeSize()} for accuracy.
     * </p>
     * <p>
     * It changes its compartments, and expects the dimension will change also.
     * </p>
     *
     * @throws IllegalGraphElementException to JUnit
     */
    public void testGetPreferredGraphNodeSize2() throws IllegalGraphElementException {
        useCaseNode.notifyGraphNodeChange("change");
        Dimension oldDimension = useCaseNode.getPreferredGraphNodeSize();

        GraphElement element = (GraphElement) graphNode.getContaineds().get(0);
        GraphNode nameNode = (GraphNode) element.getContaineds().get(1);

        // change the size and location name graphNode.
        nameNode.setPosition(TestHelper.getPoint(100.0, 100.0));
        nameNode.setSize(TestHelper.getDimension(4.5, 2.3));

        useCaseNode.notifyGraphNodeChange("change");
        Dimension newDimension = useCaseNode.getPreferredGraphNodeSize();

        /*
         * Bugfix: UML-9574
         * The width and height should be able to be independently adjusted.
         */
        // old code
//        double ratio = newDimension.width * 1.0 / newDimension.height;
//        assertTrue("getPreferredGraphNodeSize behavior is abnormal.", ratio > 1.79 && ratio < 1.81);
        assertTrue("getPreferredGraphNodeSize behavior is abnormal", oldDimension.equals(newDimension));
    }

    /**
     * <p>
     * Tests {@link UseCaseNode#getPreferredGraphNodeSize()} for accuracy.
     * </p>
     * <p>
     * It tests the case that all its compartments are hidden, and expects default size.
     * </p>
     *
     * @throws IllegalGraphElementException to JUnit
     */
    public void testGetPreferredGraphNodeSize3() throws IllegalGraphElementException {
        GraphElement element = (GraphElement) graphNode.getContaineds().get(0);
        GraphNode nameNode = (GraphNode) element.getContaineds().get(1);
        GraphNode stereotypeNode = (GraphNode) element.getContaineds().get(0);
        GraphNode namespaceNode = (GraphNode) element.getContaineds().get(2);

        nameNode.setVisible(false);
        stereotypeNode.setVisible(false);
        namespaceNode.setVisible(false);

        useCaseNode.notifyGraphNodeChange("change");
        Dimension dimension = useCaseNode.getPreferredGraphNodeSize();

        /*
         * Bugfix: UML-9574
         * The width and height should be able to be independently adjusted.
         */
        // old code
//        double ratio = dimension.width * 1.0 / dimension.height;
//        assertTrue("getPreferredGraphNodeSize behavior is abnormal.", ratio > 1.79 && ratio < 1.81);
        assertEquals("getPreferredGraphNoedSize behavior is abnormal", new Dimension(90, 50), dimension);
    }

    /**
     * <p>
     * Tests {@link UseCaseNode#contains(int, int)} for accuracy.
     * </p>
     * <p>
     * It pass the point within it and expects true.
     * </p>
     */
    public void testContains1() {
        assertTrue("contains behavior is abnormal.", useCaseNode.contains(30, 30));
    }

    /**
     * <p>
     * Tests {@link UseCaseNode#contains(int, int)} for accuracy.
     * </p>
     * <p>
     * It pass the point out of it and expects false.
     * </p>
     */
    public void testContains2() {
        assertFalse("contains behavior is abnormal.", useCaseNode.contains(179, 99));
    }

    /**
     * <p>
     * Tests {@link UseCaseNode#contains(int, int)} for accuracy.
     * </p>
     * <p>
     * It pass the point out of it and expects false.
     * </p>
     */
    public void testContains3() {
        assertFalse("contains behavior is abnormal.", useCaseNode.contains(150, 150));
    }

    /**
     * <p>
     * Tests {@link UseCaseNode#contains(int, int)} for accuracy.
     * </p>
     * <p>
     * It pass the point out of it and expects false.
     * </p>
     */
    public void testContains4() {
        assertFalse("contains behavior is abnormal.", useCaseNode.contains(0, 100));
    }

    /**
     * <p>
     * Tests {@link UseCaseNode#contains(int, int)} for accuracy.
     * </p>
     * <p>
     * It pass the point out of it and expects false.
     * </p>
     */
    public void testContains5() {
        assertFalse("contains behavior is abnormal.", useCaseNode.contains(180, 0));
    }

    /**
     * <p>
     * Tests {@link UseCaseNode#paintComponent(java.awt.Graphics)} for accuracy.
     * </p>
     * <p>
     * It provides the graphics, and ensures no exception will be thrown.
     * </p>
     */
    public void testPaintComponent() {
        JFrame frame = new JFrame();
        frame.setVisible(true);
        Graphics g = frame.getGraphics();
        useCaseNode.paintComponent(g);
        frame.setVisible(false);
    }

    /**
     * <p>
     * Tests {@link UseCaseNode#paintComponent(java.awt.Graphics)} for accuracy.
     * </p>
     * <p>
     * It tests the case that when g is null and expects success.
     * </p>
     */
    public void testPaintComponents_NullG() {
        useCaseNode.paintComponent(null);
        // no exception will be thrown
    }

    /**
     * <p>
     * Tests {@link UseCaseNode#notifyGraphNodeChange(String)} for accuracy.
     * </p>
     * <p>
     * It verifies the BoundaryChangedEvent will be fired.
     * </p>
     */
    public void testNotifyGraphNodeChange() {
        MockBoundaryChangedListener listener = new MockBoundaryChangedListener();
        useCaseNode.addBoundaryChangeListener(listener);
        graphNode.getSize().setHeight(300);
        graphNode.getSize().setWidth(200);
        try {
            useCaseNode.notifyGraphNodeChange("boundary is changed");
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
    public void testNotifyGraphNodeChange_Node() throws Exception {
        graphNode.setSize(TestHelper.getDimension(60, 100));
        graphNode.setPosition(TestHelper.getPoint(100, 200));

        useCaseNode.notifyGraphNodeChange("change");

        // get the size to test.
        assertEquals("Equal size expected.", 110.0, useCaseNode.getSize().getHeight());
        assertEquals("Equal size expected.", 103.0, useCaseNode.getSize().getWidth());

        // get the bound to test.
        assertEquals("Equal bound expected.", 5, useCaseNode.getSelectionBound().x);
        assertEquals("Equal bound expected.", 5, useCaseNode.getSelectionBound().y);
        assertEquals("Equal bound expected.", 100, useCaseNode.getSelectionBound().height);
        assertEquals("Equal bound expected.", 93, useCaseNode.getSelectionBound().width);
    }

    /**
     * <p>
     * Accuracy Test of the <code>notifyGraphNodeChange(String)</code> method.
     * </p>
     *
     * @throws Exception to JUnit.
     */
    public void testNotifyGraphNodeChange_Compartments() throws Exception {
        GraphElement element = (GraphElement) graphNode.getContaineds().get(0);
        GraphNode nameNode = (GraphNode) element.getContaineds().get(1);
        GraphNode stereotypeNode = (GraphNode) element.getContaineds().get(0);
        GraphNode namespaceNode = (GraphNode) element.getContaineds().get(2);

        // change the size and location name graphNode.
        nameNode.setPosition(TestHelper.getPoint(5.0, 9.0));
        nameNode.setSize(TestHelper.getDimension(4.5, 2.3));

        // change the size and location stereotype graphNode.
        stereotypeNode.setPosition(TestHelper.getPoint(20.0, 30.0));
        stereotypeNode.setSize(TestHelper.getDimension(5.2, 3.4));

        // change the size and location namespace graphNode.
        namespaceNode.setPosition(TestHelper.getPoint(19.0, 31.0));
        namespaceNode.setSize(TestHelper.getDimension(5.2, 6.7));

        useCaseNode.notifyGraphNodeChange("change");
    }

    /**
     * <p>
     * Unit Test of the <code>notifyGraphNodeChange(String)</code> method.
     * </p>
     *
     * @throws Exception to JUnit.
     */
    public void testNotifyGraphNodeChange_Name() throws Exception {
        useCaseNode.notifyGraphNodeChange("change");
        assertEquals("Use_Case_1", useCaseNode.getNameCompartment().getText());
    }

    /**
     * <p>
     * Unit Test of the <code>notifyGraphNodeChange(String)</code> method.
     * </p>
     *
     * @throws Exception to JUnit.
     */
    public void testNotifyGraphNodeChange_Stereotype() throws Exception {
        useCaseNode.notifyGraphNodeChange("change");
        assertEquals("<<utility>>", useCaseNode.getStereotypeCompartment().getText());
    }

    /**
     * <p>
     * Unit Test of the <code>notifyGraphNodeChange(String)</code> method.
     * </p>
     *
     * @throws Exception to JUnit.
     */
    public void testNotifyGraphNodeChange_Namespace() throws Exception {
        useCaseNode.notifyGraphNodeChange("change");
        assertEquals("com.topcoder", useCaseNode.getNamespaceCompartment().getText());
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
        GraphElement element = (GraphElement) graphNode.getContaineds().get(0);
        GraphNode namespaceNode = (GraphNode) element.getContaineds().get(2);
        namespaceNode.setVisible(true);

        useCaseNode.notifyNamespaceVisibilityChange();
        assertTrue("failed to notify namespace visibility change", useCaseNode.getNamespaceCompartment().isVisible());
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
        GraphElement element = (GraphElement) graphNode.getContaineds().get(0);
        GraphNode namespaceNode = (GraphNode) element.getContaineds().get(2);
        namespaceNode.setVisible(false);

        useCaseNode.notifyNamespaceVisibilityChange();
        assertFalse("failed to notify namespace visibility change", useCaseNode.getNamespaceCompartment().isVisible());
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
        GraphElement element = (GraphElement) graphNode.getContaineds().get(0);
        GraphNode stereotypeNode = (GraphNode) element.getContaineds().get(0);
        stereotypeNode.setVisible(true);

        useCaseNode.notifyStereotypeVisibilityChange();
        assertTrue("failed to notify stereotype visibility change", useCaseNode.getStereotypeCompartment().isVisible());
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
        GraphElement element = (GraphElement) graphNode.getContaineds().get(0);
        GraphNode stereotypeNode = (GraphNode) element.getContaineds().get(0);
        stereotypeNode.setVisible(false);

        useCaseNode.notifyStereotypeVisibilityChange();
        assertFalse("failed to notify stereotype visibility change",
                useCaseNode.getStereotypeCompartment().isVisible());
    }

    /**
     * <p>
     * The entry of the demo program.
     * </p>
     *
     * @param args the arguments
     */
    public static void main(String[] args) {
        UseCaseNode useCaseNode;
        try {
            useCaseNode = new UseCaseNode(TestHelper.createGraphNodeForUseCase(), TestHelper.createProperties());
            useCaseNode.getGraphNode().addProperty(TestHelper.createProperty("FillColor", "FFFFFF"));
            useCaseNode.notifyPropertiesChange();
            useCaseNode.notifyGraphNodeChange("change");

            JFrame frame = new JFrame();
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setLayout(null);
            frame.getContentPane().add(useCaseNode);
            frame.setSize(new Dimension(500, 500));
            frame.setVisible(true);
        } catch (IllegalGraphElementException e) {
            e.printStackTrace();
        }
    }
}
