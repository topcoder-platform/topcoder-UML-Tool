/*
 * Copyright (C) 2007 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.gui.diagramviewer.uml.usecaseelements;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.Rectangle;
import java.util.HashMap;
import java.util.Map;

import javax.swing.JFrame;
import javax.swing.JMenuItem;
import javax.swing.JPopupMenu;
import javax.swing.TransferHandler;

import junit.framework.TestCase;

import com.topcoder.diagraminterchange.GraphEdge;
import com.topcoder.diagraminterchange.GraphElement;
import com.topcoder.diagraminterchange.GraphNode;
import com.topcoder.gui.diagramviewer.edges.Connector;
import com.topcoder.gui.diagramviewer.edges.connectors.RectangleConnector;
import com.topcoder.gui.diagramviewer.uml.usecaseelements.event.BoundaryChangedEvent;
import com.topcoder.gui.diagramviewer.uml.usecaseelements.event.BoundaryChangedListener;
import com.topcoder.gui.diagramviewer.uml.usecaseelements.event.EdgeAddEvent;
import com.topcoder.gui.diagramviewer.uml.usecaseelements.event.EdgeAddListener;
import com.topcoder.gui.diagramviewer.uml.usecaseelements.event.MockBoundaryChangedListener;
import com.topcoder.gui.diagramviewer.uml.usecaseelements.event.MockEdgeAddListener;
import com.topcoder.gui.diagramviewer.uml.usecaseelements.event.MockNodeAddListener;
import com.topcoder.gui.diagramviewer.uml.usecaseelements.event.NodeAddEvent;
import com.topcoder.gui.diagramviewer.uml.usecaseelements.event.NodeAddListener;

/**
 * <p>
 * Unit test cases for SubsystemNodeContainer.
 * </p>
 *
 * @author TCSDEVELOPER
 * @version 1.0
 */
public class SubsystemNodeContainerTests extends TestCase {
    /**
     * <p>
     * SubsystemNodeContainer instance for testing.
     * </p>
     */
    private SubsystemNodeContainer nodeContainer;

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
        graphNode = TestHelper.createGraphNodeForSubsystem();
        try {
            nodeContainer = new SubsystemNodeContainer(graphNode, TestHelper.createProperties(),
                    new TransferHandler(""));
        } catch (IllegalGraphElementException e) {
            TestCase.fail("no IllegalGraphElementException will be thrown");
        }
    }

    /**
     * <p>
     * Tears down test environment.
     * </p>
     */
    protected void tearDown() {
        nodeContainer = null;
    }

    /**
     * <p>
     * Tests {@link SubsystemNodeContainer#SubsystemNodeContainer(GraphNode, Map, TransferHandler)} for accuracy.
     * </p>
     * <p>
     * It verifies the newly created SubsystemNodeContainer is not null.
     * </p>
     */
    public void testCtor() {
        assertNotNull("Failed to create a SubsystemNodeConainer instance.", nodeContainer);
    }

    /**
     * <p>
     * Tests {@link SubsystemNodeContainer#SubsystemNodeContainer(GraphNode, Map, TransferHandler)} for accuracy.
     * </p>
     * <p>
     * It tests the case that when GraphNode is null and expects IllegalArgumentException.
     * </p>
     */
    public void testCtor_NullGraphNode() {
        try {
            new SubsystemNodeContainer(null, TestHelper.createProperties(), new TransferHandler(""));
            fail("IllegalArgumentException expected.");
        } catch (IllegalArgumentException iae) {
            // the expected case
        } catch (IllegalGraphElementException e) {
            fail("no IllegalGraphElementException will be thrown.");
        }
    }

    /**
     * <p>
     * Tests {@link SubsystemNodeContainer#SubsystemNodeContainer(GraphNode, Map, TransferHandler)} for accuracy.
     * </p>
     * <p>
     * It tests the case that when properties is null and expects IllegalArgumentException.
     * </p>
     */
    public void testCtor_NullProperties() {
        try {
            new SubsystemNodeContainer(TestHelper.createGraphNodeForSubsystem(), null, new TransferHandler(""));
            fail("IllegalArgumentException expected.");
        } catch (IllegalArgumentException iae) {
            // the expected case
        } catch (IllegalGraphElementException e) {
            fail("no IllegalGraphElementException will be thrown.");
        }
    }

    /**
     * <p>
     * Tests {@link SubsystemNodeContainer#SubsystemNodeContainer(GraphNode, Map, TransferHandler)} for accuracy.
     * </p>
     * <p>
     * It tests the case that when properties contains null value and expects IllegalArgumentException.
     * </p>
     */
    public void testCtor_PropertiesContainsNull() {
        try {
            Map<String, String> properties = new HashMap<String, String>();
            properties.put(null, null);
            new SubsystemNodeContainer(TestHelper.createGraphNodeForSubsystem(), properties, new TransferHandler(""));
            fail("IllegalArgumentException expected.");
        } catch (IllegalArgumentException iae) {
            // the expected case
        } catch (IllegalGraphElementException e) {
            fail("no IllegalGraphElementException will be thrown.");
        }
    }

    /**
     * <p>
     * Tests {@link SubsystemNodeContainer#SubsystemNodeContainer(GraphNode, Map, TransferHandler)} for accuracy.
     * </p>
     * <p>
     * It tests the case that when properties contains empty value and expects IllegalArgumentException.
     * </p>
     */
    public void testCtor_PropertiesContainsEmpty() {
        try {
            Map<String, String> properties = new HashMap<String, String>();
            properties.put(" ", "");
            new SubsystemNodeContainer(TestHelper.createGraphNodeForSubsystem(), properties, new TransferHandler(""));
            fail("IllegalArgumentException expected.");
        } catch (IllegalArgumentException iae) {
            // the expected case
        } catch (IllegalGraphElementException e) {
            fail("no IllegalGraphElementException will be thrown.");
        }
    }

    /**
     * <p>
     * Tests {@link SubsystemNodeContainer#SubsystemNodeContainer(GraphNode, Map, TransferHandler)} for accuracy.
     * </p>
     * <p>
     * It tests the case that when handler is null and expects IllegalArgumentException.
     * </p>
     */
    public void testCtor_NullHandler() {
        try {
            new SubsystemNodeContainer(TestHelper.createGraphNodeForSubsystem(), TestHelper.createProperties(), null);
            fail("IllegalArgumentException expected.");
        } catch (IllegalArgumentException iae) {
            // the expected case
        } catch (IllegalGraphElementException e) {
            fail("no IllegalGraphElementException will be thrown.");
        }
    }

    /**
     * <p>
     * Tests {@link SubsystemNodeContainer#SubsystemNodeContainer(GraphNode, Map, TransferHandler) for failure.
     * </p>
     * <p>
     * If the GraphNode structure is not valid, IllegalGraphElementException should be raised.
     * </p>
     */
    public void testCtor_BadGraphNode1() {
        Map<String, String> map = new HashMap<String, String>();
        GraphNode node = new GraphNode();
        GraphNode name = TestHelper.createNameCompartment();
        node.addContained(name);

        try {
            new SubsystemNodeContainer(node, map, new TransferHandler("transfer"));
            fail("IllegalGraphElementException is expected.");
        } catch (IllegalGraphElementException e) {
            // ok.
        }
    }

    /**
     * <p>
     * Tests {@link SubsystemNodeContainer#SubsystemNodeContainer(GraphNode, Map, TransferHandler) for failure.
     * </p>
     * <p>
     * If the GraphNode structure is not valid, IllegalGraphElementException should be raised.
     * </p>
     */
    public void testCtor_BadGraphNode2() {
        Map<String, String> map = new HashMap<String, String>();
        GraphNode node = new GraphNode();
        GraphNode name = TestHelper.createNameCompartment();

        name.addContained(new GraphEdge());
        name.addContained(new GraphEdge());
        name.addContained(new GraphEdge());

        node.addContained(name);

        try {
            new SubsystemNodeContainer(node, map, new TransferHandler("transfer"));
            fail("IllegalGraphElementException is expected.");
        } catch (IllegalGraphElementException e) {
            // ok.
        }
    }

    /**
     * <p>
     * Tests {@link SubsystemNodeContainer#setTransferHandler(TransferHandler)} for accuracy.
     * </p>
     * <p>
     * It verifies SubsystemNodeContainer#setTransferHandler(TransferHandler) is correct.
     * </p>
     */
    public void testSetTransferHandler() {
        try {
            nodeContainer.setTransferHandler(new TransferHandler(""));
            // the expected case
        } catch (IllegalArgumentException iae) {
            fail("no IllegalArgumentException should be thrown.");
        }
    }

    /**
     * <p>
     * Tests {@link SubsystemNodeContainer#setTransferHandler(TransferHandler)} for failure.
     * </p>
     * <p>
     * It tests the case that when newHandler is null and expects IllegalArgumentException.
     * </p>
     */
    public void testSetTransferHandler_NullHandler() {
        try {
            nodeContainer.setTransferHandler(null);
            fail("IllegalArgumentException expected.");
        } catch (IllegalArgumentException iae) {
            // the expected case
        }
    }

    /**
     * <p>
     * Tests {@link SubsystemNodeContainer#contains(int, int)} for accuracy.
     * </p>
     * <p>
     * It pass the point within it and expects true.
     * </p>
     */
    public void testContainsIn1() {
        assertFalse("contains behavior is abnormal", nodeContainer.contains(0, 0));
    }

    /**
     * <p>
     * Tests {@link SubsystemNodeContainer#contains(int, int)} for accuracy.
     * </p>
     * <p>
     * It pass the point within it and expects true.
     * </p>
     */
    public void testContainsIn2() {
        assertTrue("contains behavior is abnormal", nodeContainer.contains(395, 395));
    }

    /**
     * <p>
     * Tests {@link SubsystemNodeContainer#contains(int, int)} for accuracy.
     * </p>
     * <p>
     * It pass the point out  of it and expects false.
     * </p>
     */
    public void testContainsOut1() {
        assertFalse("contains behavior is abnormal", nodeContainer.contains(600, 600));
    }

    /**
     * <p>
     * Tests {@link SubsystemNodeContainer#contains(int, int)} for accuracy.
     * </p>
     * <p>
     * It pass the point out  of it and expects false.
     * </p>
     */
    public void testContainsOut2() {
        assertFalse("contains behavior is abnormal", nodeContainer.contains(300, 500));
    }

    /**
     * <p>
     * Tests {@link SubsystemNodeContainer#paintComponent(java.awt.Graphics)} for accuracy.
     * </p>
     * <p>
     * It provides the graphics, and ensures no exception will be thrown.
     * </p>
     */
    public void testPaintComponent() {
        JFrame frame = new JFrame();
        frame.setVisible(true);
        Graphics g = frame.getGraphics();
        nodeContainer.paintComponent(g);
        frame.setVisible(false);
    }

    /**
     * <p>
     * Tests {@link SubsystemNodeContainer#paintComponent(java.awt.Graphics)} for accuracy.
     * </p>
     * <p>
     * It tests the case that when g is null and expects success.
     * </p>
     */
    public void testPaintComponent_NullG() {
        nodeContainer.paintComponent(null);
        // no exception will be thrown
    }

    /**
     * <p>
     * Tests {@link SubsystemNodeContainer#getStrokeColor()} for accuracy.
     * </p>
     * <p>
     * It verifies the default color will use, when the passed graphNode contains no color information.
     * </p>
     */
    public void testGetStrokeColor() {
        assertEquals("Failed to get the color correctly.", Color.BLACK, nodeContainer.getStrokeColor());
    }

    /**
     * <p>
     * Tests {@link SubsystemNodeContainer#getFillColor()} for accuracy.
     * </p>
     * <p>
     * It verifies the default color will use, when the passed graphNode contains no color information.
     * </p>
     */
    public void testGetFillColor() {
        assertEquals("Failed to get the color correctly.", Color.WHITE, nodeContainer.getFillColor());
    }

    /**
     * <p>
     * Tests {@link SubsystemNodeContainer#getFontColor()} for accuracy.
     * </p>
     * <p>
     * It verifies the default color will use, when the passed graphNode contains no color information.
     * </p>
     */
    public void testGetFontColor() {
        assertEquals("Failed to get the color correctly.", Color.BLACK, nodeContainer.getFontColor());
    }

    /**
     * <p>
     * Tests {@link SubsystemNodeContainer#getFont()} for accuracy.
     * </p>
     * <p>
     * It verifies the default font size will use, when the passed graphNode doesn't contain such information.
     * </p>
     */
    public void testGetFontSize() {
        assertEquals("Failed to get the font size correctly.", 10, nodeContainer.getFont().getSize());
    }

    /**
     * <p>
     * Tests {@link SubsystemNodeContainer#getFont()} for accuracy.
     * </p>
     * <p>
     * It verifies the default font family will use, when the passed graphNode doesn't contain such information.
     * </p>
     */
    public void testGetFontFamily() {
        assertEquals("Failed to get the font size correctly.", "Arial", nodeContainer.getFont().getFamily());
    }

    /**
     * <p>
     * Tests {@link SubsystemNodeContainer#getConnector()} for accuracy.
     * </p>
     * <p>
     * It verifies SubsystemNodeContainer#getConnector() is correct.
     * </p>
     */
    public void testGetConnector() {
        Connector connector = nodeContainer.getConnector();
        assertTrue("Failed to get connector.", connector instanceof RectangleConnector);
    }

    /**
     * <p>
     * Tests {@link SubsystemNodeContainer#getNameCompartment()} for accuracy.
     * </p>
     * <p>
     * It verifies SubsystemNodeContainer#getNameCompartment() is correct.
     * </p>
     */
    public void testGetNameCompartment() {
        assertSame("Failed to get name compartment.", nodeContainer.getNameCompartment().getGraphNode(),
                ((GraphNode) graphNode.getContaineds().get(0)).getContaineds().get(1));
    }

    /**
     * <p>
     * Tests {@link SubsystemNodeContainer#getStereotypeCompartment()} for accuracy.
     * </p>
     * <p>
     * It verifies SubsystemNodeContainer#getStereotypeCompartment() is correct.
     * </p>
     */
    public void testGetStereotypeCompartment() {
        assertSame("Failed to get stereotype compartment.", nodeContainer.getStereotypeCompartment().getGraphNode(),
                ((GraphNode) graphNode.getContaineds().get(0)).getContaineds().get(0));
    }

    /**
     * <p>
     * Tests {@link SubsystemNodeContainer#getNamespaceCompartment()} for accuracy.
     * </p>
     * <p>
     * It verifies SubsystemNodeContainer#getNamespaceCompartment() is correct.
     * </p>
     */
    public void testGetNamespaceCompartment() {
        assertSame("Failed to get namespace compartment.", nodeContainer.getNamespaceCompartment().getGraphNode(),
                ((GraphNode) graphNode.getContaineds().get(0)).getContaineds().get(2));
    }

    /**
     * <p>
     * Tests {@link SubsystemNodeContainer#notifyPropertiesChange()} for accuracy.
     * </p>
     * <p>
     * It changes the properties in graphNode, notify the base node, and verifies it works correctly.
     * </p>
     */
    public void testNotifyPropertiesChange_FillColor() {
        graphNode.addProperty(TestHelper.createProperty("FillColor", "0000FF"));
        nodeContainer.notifyPropertiesChange();
        assertEquals("notifyPropertiesChange is fail.", new Color(0, 0, 255), nodeContainer.getFillColor());
    }

    /**
     * <p>
     * Tests {@link SubsystemNodeContainer#notifyPropertiesChange()} for accuracy.
     * </p>
     * <p>
     * It changes the properties in graphNode, notify the base node, and verifies it works correctly.
     * </p>
     */
    public void testNotifyPropertiesChange_StrokeColor() {
        graphNode.addProperty(TestHelper.createProperty("StrokeColor", "00FF00"));
        nodeContainer.notifyPropertiesChange();
        assertEquals("notifyPropertiesChange is fail.", new Color(0, 255, 0), nodeContainer.getStrokeColor());
    }

    /**
     * <p>
     * Tests {@link SubsystemNodeContainer#notifyPropertiesChange()} for accuracy.
     * </p>
     * <p>
     * It changes the properties in graphNode, and notify the base node, and verifies it works correctly.
     * </p>
     */
    public void testNotifyPropertiesChange_FontColor() {
        graphNode.addProperty(TestHelper.createProperty("FontColor", "FF0000"));
        nodeContainer.notifyPropertiesChange();
        assertEquals("notifyPropertiesChange is fail.", new Color(255, 0, 0), nodeContainer.getFontColor());
    }

    /**
     * <p>
     * Tests {@link SubsystemNodeContainer#notifyPropertiesChange()} for accuracy.
     * </p>
     * <p>
     * It changes the properties in graphNode, and notify the base node, and verifies it works correctly.
     * </p>
     */
    public void testNotifyPropertiesChange_FontSize() {
        graphNode.addProperty(TestHelper.createProperty("FontSize", "14"));
        nodeContainer.notifyPropertiesChange();
        assertEquals("notifyPropertiesChange is fail.", 14, nodeContainer.getFont().getSize());
    }

    /**
     * <p>
     * Tests {@link SubsystemNodeContainer#notifyPropertiesChange()} for accuracy.
     * </p>
     * <p>
     * It changes the properties in graphNode, and notify the base node, and verifies it works correctly.
     * </p>
     */
    public void testNotifyPropertiesChange_FontFamily() {
        graphNode.addProperty(TestHelper.createProperty("FontFamily", "Arial"));
        nodeContainer.notifyPropertiesChange();
        assertEquals("notifyPropertiesChange is fail.", "Arial", nodeContainer.getFont().getFamily());
    }

    /**
     * <p>
     * Tests {@link SubsystemNodeContainer#notifyGraphNodeChange(String)} for accuracy.
     * </p>
     * <p>
     * It verifies the BoundaryChangedEvent will be fired.
     * </p>
     */
    public void testNotifyGraphNodeChange() {
        MockBoundaryChangedListener listener = new MockBoundaryChangedListener();
        nodeContainer.addBoundaryChangeListener(listener);
        graphNode.getSize().setHeight(300);
        graphNode.getSize().setWidth(200);
        try {
            nodeContainer.notifyGraphNodeChange("boundary is changed");
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
        graphNode.setSize(TestHelper.getDimension(30, 50));
        graphNode.setPosition(TestHelper.getPoint(100, 200));

        nodeContainer.notifyGraphNodeChange("change");

        // get the size to test.
        assertEquals("Equal size expected.", 90.0, nodeContainer.getSize().getHeight());
        assertEquals("Equal size expected.", 110.0, nodeContainer.getSize().getWidth());

        // get the relative position to test.
        assertEquals("Equal relative position expected.", 5.0, nodeContainer.getRelativePosition().getX());
        assertEquals("Equal relative position expected.", 5.0, nodeContainer.getRelativePosition().getY());

        // get the bound to test.
        assertEquals("Equal bound expected.", 5, nodeContainer.getSelectionBound().x);
        assertEquals("Equal bound expected.", 5, nodeContainer.getSelectionBound().y);
        assertEquals("Equal bound expected.", 80, nodeContainer.getSelectionBound().height);
        assertEquals("Equal bound expected.", 100, nodeContainer.getSelectionBound().width);
    }

    /**
     * <p>
     * Unit Test of the <code>notifyGraphNodeChange(String)</code> method.
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

        nodeContainer.notifyGraphNodeChange("change");
    }

    /**
     * <p>
     * Unit Test of the <code>notifyGraphNodeChange(String)</code> method.
     * </p>
     *
     * @throws Exception to JUnit.
     */
    public void testNotifyGraphNodeChange_Name() throws Exception {
        nodeContainer.notifyGraphNodeChange("change");
        assertEquals("Default package", nodeContainer.getNameCompartment().getText());
    }

    /**
     * <p>
     * Unit Test of the <code>notifyGraphNodeChange(String)</code> method.
     * </p>
     *
     * @throws Exception to JUnit.
     */
    public void testNotifyGraphNodeChange_Stereotype() throws Exception {
        nodeContainer.notifyGraphNodeChange("change");
        assertEquals("", nodeContainer.getStereotypeCompartment().getText());
    }

    /**
     * <p>
     * Unit Test of the <code>notifyGraphNodeChange(String)</code> method.
     * </p>
     *
     * @throws Exception to JUnit.
     */
    public void testNotifyGraphNodeChange_Namespace() throws Exception {
        nodeContainer.notifyGraphNodeChange("change");
        assertEquals("com.topcoder", nodeContainer.getNamespaceCompartment().getText());
    }

    /**
     * <p>
     * Tests {@link SubsystemNodeContainer#getPreferredGraphNodeSize()} for accuracy.
     * </p>
     * <p>
     * It verifies SubsystemNodeContainer#getPreferredGraphNodeSize() is correct.
     * </p>
     *
     * @throws IllegalGraphElementException to JUnit
     */
    public void testGetPreferredGraphNodeSize() throws IllegalGraphElementException {
        nodeContainer.notifyGraphNodeChange("change");
        assertEquals("getPreferredGraphNodeSize behavior is abnormal", new Dimension(100, 80),
                nodeContainer.getPreferredGraphNodeSize());
    }

    /**
     * <p>
     * Tests {@link SubsystemNodeContainer#getPreferredGraphNodeSize()} for accuracy.
     * </p>
     * <p>
     * It changes its compartments, and expects the dimension will change also.
     * </p>
     *
     * @throws IllegalGraphElementException to JUnit
     */
    public void testGetPreferredGraphNodeSize2() throws IllegalGraphElementException {
        nodeContainer.notifyGraphNodeChange("change");
        Dimension oldDimension = nodeContainer.getPreferredGraphNodeSize();

        GraphElement element = (GraphElement) graphNode.getContaineds().get(0);
        GraphNode nameNode = (GraphNode) element.getContaineds().get(1);

        // change the size and location name graphNode.
        nameNode.setPosition(TestHelper.getPoint(100.0, 100.0));
        nameNode.setSize(TestHelper.getDimension(10, 5));

        nodeContainer.notifyGraphNodeChange("change");
        Dimension newDimension = nodeContainer.getPreferredGraphNodeSize();

        assertTrue("getPreferredGraphNodeSize behavior is abnormal", oldDimension.equals(newDimension));
    }

    /**
     * <p>
     * Tests {@link SubsystemNodeContainer#getPreferredGraphNodeSize()} for accuracy.
     * </p>
     * <p>
     * It changes its compartments, and expects the dimension will change also.
     * </p>
     *
     * @throws IllegalGraphElementException to JUnit
     */
    public void testGetPreferredGraphNodeSize3() throws IllegalGraphElementException {
        nodeContainer.notifyGraphNodeChange("change");
        Dimension oldDimension = nodeContainer.getPreferredGraphNodeSize();

        nodeContainer.addNode("BodyCompartment", new ActorNode(TestHelper.createGraphNodeForActor(),
                TestHelper.createProperties()));

        Dimension newDimension = nodeContainer.getPreferredGraphNodeSize();

        assertTrue("getPreferredGraphNodeSize behavior is abnormal", oldDimension.equals(newDimension));
    }

    /**
     * <p>
     * Tests {@link SubsystemNodeContainer#getPreferredGraphNodeSize()} for accuracy.
     * </p>
     * <p>
     * It tests the case that all its compartments are hidden, and it has no child node, and expects default size.
     * </p>
     *
     * @throws IllegalGraphElementException to JUnit
     */
    public void testGetPreferredGraphNodeSize4() throws IllegalGraphElementException {
        GraphElement element = (GraphElement) graphNode.getContaineds().get(0);
        GraphNode nameNode = (GraphNode) element.getContaineds().get(1);
        GraphNode stereotypeNode = (GraphNode) element.getContaineds().get(0);
        GraphNode namespaceNode = (GraphNode) element.getContaineds().get(2);

        //hides all compartments
        nameNode.setVisible(false);
        stereotypeNode.setVisible(false);
        namespaceNode.setVisible(false);

        nodeContainer.notifyGraphNodeChange("change");

        Dimension dimension = nodeContainer.getPreferredGraphNodeSize();

        assertEquals("getPreferredGraphNodeSize behavior is abnormal", new Dimension(100, 80), dimension);
    }

    /**
     * <p>
     * Tests {@link SubsystemNodeContainer#consumeEvent(java.awt.event.MouseEvent)} for accuracy.
     * </p>
     * <p>
     * It tests the case that when event is null and expects success.
     * </p>
     */
    public void testConsumeEvent1() {
        nodeContainer.consumeEvent(null);
    }

    /*
     * BugFix: UML-7162
     */
    // old code
//    /**
//     * <p>
//     * Tests {@link SubsystemNodeContainer#consumeEvent(java.awt.event.MouseEvent)} for accuracy.
//     * </p>
//     * <p>
//     * It stimulates the case of adding node, and expects success.
//     * </p>
//     */
//    public void testConsumeEvent2() {
//        DiagramViewer viewer = DiagramViewer.getInstance();
//        MockNodeAddListener listener = new MockNodeAddListener();
//
//        viewer.setAddingNodeElement(true);
//        MouseEvent e = new MouseEvent(nodeContainer, MouseEvent.MOUSE_CLICKED,
//                0, 0, 0, 0, 1, false, MouseEvent.BUTTON1);
//        nodeContainer.addNodeAddListener(listener);
//        nodeContainer.consumeEvent(e);
//
//        assertTrue("consumeEvent is incorrect", listener.getIsExecute());
//
//        viewer.setAddingNodeElement(false);
//    }
//
//    /**
//     * <p>
//     * Tests {@link SubsystemNodeContainer#consumeEvent(java.awt.event.MouseEvent)} for accuracy.
//     * </p>
//     * <p>
//     * It stimulates the case of adding common edge, and expects success.
//     * </p>
//     */
//    public void testConsumeEvent3() {
//        DiagramViewer viewer = DiagramViewer.getInstance();
//        MockEdgeAddListener listener = new MockEdgeAddListener();
//
//        viewer.setAddingEdgeElement(true);
//        viewer.setAddingIncludeExtendEdge(false);
//        MouseEvent e = new MouseEvent(nodeContainer, MouseEvent.MOUSE_PRESSED,
//                0, 0, 0, 0, 1, false, MouseEvent.BUTTON1);
//        nodeContainer.addEdgeAddListener(listener);
//        nodeContainer.consumeEvent(e);
//
//        assertTrue("consumeEvent is incorrect", listener.getIsExecute());
//        assertTrue("consumeEvent is incorrect", listener.getEdgeAddEvent().isStart());
//
//        viewer.setAddingEdgeElement(false);
//        viewer.setAddingIncludeExtendEdge(false);
//    }
//
//    /**
//     * <p>
//     * Tests {@link SubsystemNodeContainer#consumeEvent(java.awt.event.MouseEvent)} for accuracy.
//     * </p>
//     * <p>
//     * It stimulates the case of adding common edge, and expects success.
//     * </p>
//     */
//    public void testConsumeEvent4() {
//        DiagramViewer viewer = DiagramViewer.getInstance();
//        MockEdgeAddListener listener = new MockEdgeAddListener();
//
//        viewer.setAddingEdgeElement(true);
//        viewer.setAddingIncludeExtendEdge(false);
//        MouseEvent e = new MouseEvent(nodeContainer, MouseEvent.MOUSE_RELEASED,
//                0, 0, 0, 0, 1, false, MouseEvent.BUTTON1);
//        nodeContainer.addEdgeAddListener(listener);
//        nodeContainer.consumeEvent(e);
//
//        assertTrue("consumeEvent is incorrect", listener.getIsExecute());
//        assertFalse("consumeEvent is incorrect", listener.getEdgeAddEvent().isStart());
//
//        viewer.setAddingEdgeElement(false);
//        viewer.setAddingIncludeExtendEdge(false);
//    }
//
//    /**
//     * <p>
//     * Tests {@link SubsystemNodeContainer#consumeEvent(java.awt.event.MouseEvent)} for accuracy.
//     * </p>
//     * <p>
//     * It stimulates the case of adding include edge, and expects success.
//     * </p>
//     */
//    public void testConsumeEvent5() {
//        DiagramViewer viewer = DiagramViewer.getInstance();
//        MockEdgeAddListener listener = new MockEdgeAddListener();
//
//        viewer.setAddingEdgeElement(true);
//        viewer.setAddingIncludeExtendEdge(true);
//        MouseEvent e = new MouseEvent(nodeContainer, MouseEvent.MOUSE_RELEASED,
//                0, 0, 0, 0, 1, false, MouseEvent.BUTTON1);
//        nodeContainer.addEdgeAddListener(listener);
//        nodeContainer.consumeEvent(e);
//
//        assertFalse("consumeEvent is incorrect", listener.getIsExecute());
//
//        viewer.setAddingEdgeElement(false);
//        viewer.setAddingIncludeExtendEdge(false);
//    }

    /**
     * <p>
     * Tests SubsystemNodeContainer#addBoundaryChangeListener(BoundaryChangedListener) for accuracy.
     * </p>
     * <p>
     * It verifies SubsystemNodeContainer#addBoundaryChangeListener(BoundaryChangedListener) is correct.
     * </p>
     */
    public void testAddBoundaryChangeListener() {
        BoundaryChangedListener listener = new MockBoundaryChangedListener();
        nodeContainer.addBoundaryChangeListener(listener);

        assertEquals("Expected the length of listeners is one.", 1, nodeContainer
                .getListeners(BoundaryChangedListener.class).length);
        assertEquals("Failed to set the listener correctly.", listener, nodeContainer
                .getListeners(BoundaryChangedListener.class)[0]);
    }

    /**
     * <p>
     * Tests SubsystemNodeContainer#addBoundaryChangeListener(BoundaryChangedListener) for accuracy.
     * </p>
     * <p>
     * It tests the case that when listener is null and expects success.
     * </p>
     */
    public void testAddBoundaryChangedListener_NullListener() {
        nodeContainer.addBoundaryChangeListener(null);

        assertEquals("Failed to set the listener correctly.", 0, nodeContainer
                .getListeners(BoundaryChangedListener.class).length);
    }

    /**
     * <p>
     * Tests SubsystemNodeContainer#removeBoundaryChangeListener(BoundaryChangedListener) for accuracy.
     * </p>
     * <p>
     * It verifies SubsystemNodeContainer#removeBoundaryChangeListener(BoundaryChangedListener) is correct.
     * </p>
     */
    public void testRemoveBoundaryChangedListener() {
        BoundaryChangedListener listener = new MockBoundaryChangedListener();
        nodeContainer.addBoundaryChangeListener(listener);

        nodeContainer.removeBoundaryChangeListener(listener);

        assertEquals("Failed to remove the listener correctly.", 0, nodeContainer
                .getListeners(BoundaryChangedListener.class).length);
    }

    /**
     * <p>
     * Tests SubsystemNodeContainer#removeBoundaryChangeListener(BoundaryChangedListener) for accuracy.
     * </p>
     * <p>
     * It tests the case that when listener is null and expects success.
     * </p>
     */
    public void testRemoveBoundaryChangedListener_NullListener() {
        BoundaryChangedListener listener = new MockBoundaryChangedListener();
        nodeContainer.addBoundaryChangeListener(listener);

        nodeContainer.removeBoundaryChangeListener(null);

        assertEquals("Failed to remove the listener correctly.", 1, nodeContainer
                .getListeners(BoundaryChangedListener.class).length);
    }

    /**
     * <p>
     * Tests SubsystemNodeContainer#fireBoundaryChange(BoundaryChangedEvent) for accuracy.
     * </p>
     * <p>
     * It verifies SubsystemNodeContainer#fireBoundaryChange(BoundaryChangedEvent) is correct.
     * </p>
     */
    public void testFireBoundaryChange() {
        MockBoundaryChangedListener listener = new MockBoundaryChangedListener();
        BoundaryChangedEvent event = new BoundaryChangedEvent(TestHelper.createSubsystemNodeContainer(),
                new Rectangle(), new Rectangle());

        nodeContainer.addBoundaryChangeListener(listener);

        nodeContainer.fireBoundaryChange(event);

        assertTrue("Failed to fire the listener correctly.", listener.getIsExecute());
        assertEquals("Failed to fire the listener correctly.", event, listener.getBoundaryChangedEvent());
    }

    /**
     * <p>
     * Tests SubsystemNodeContainer#fireBoundaryChange(BoundaryChangedEvent) for accuracy.
     * </p>
     * <p>
     * It tests the case that when listener is null and expects success.
     * </p>
     */
    public void testFireBoundaryChange_NullEvent() {
        MockBoundaryChangedListener listener = new MockBoundaryChangedListener();
        nodeContainer.addBoundaryChangeListener(listener);

        nodeContainer.fireBoundaryChange(null);

        assertFalse("Failed to fire the listener correctly.", listener.getIsExecute());
    }

    /**
     * <p>
     * Tests TextField#addNodeAddListener(NodeAddListener) for accuracy.
     * </p>
     * <p>
     * It verifies TextField#addNodeAddListener(NodeAddListener) is correct.
     * </p>
     */
    public void testAddNodeAddListener() {
        NodeAddListener listener = new MockNodeAddListener();
        nodeContainer.addNodeAddListener(listener);

        assertEquals("Expected the length of listeners is one.", 1,
                nodeContainer.getListeners(NodeAddListener.class).length);
        assertEquals("Failed to set the listener correctly.", listener, nodeContainer
                .getListeners(NodeAddListener.class)[0]);
    }

    /**
     * <p>
     * Tests TextField#addNodeAddListener(NodeAddListener) for accuracy.
     * </p>
     * <p>
     * It tests the case that when listener is null and expects success.
     * </p>
     */
    public void testAddNodeAddListener_NullListener() {
        nodeContainer.addNodeAddListener(null);

        assertEquals("Failed to set the listener correctly.", 0,
                nodeContainer.getListeners(NodeAddListener.class).length);
    }

    /**
     * <p>
     * Tests TextField#removeNodeAddListener(NodeAddListener) for accuracy.
     * </p>
     * <p>
     * It verifies TextField#removeNodeAddListener(NodeAddListener) is correct.
     * </p>
     */
    public void testRemoveNodeAddListener() {
        NodeAddListener listener = new MockNodeAddListener();
        nodeContainer.addNodeAddListener(listener);

        nodeContainer.removeNodeAddListener(listener);

        assertEquals("Failed to remove the listener correctly.", 0,
                nodeContainer.getListeners(NodeAddListener.class).length);
    }

    /**
     * <p>
     * Tests TextField#removeNodeAddListener(NodeAddListener) for accuracy.
     * </p>
     * <p>
     * It tests the case that when listener is null and expects success.
     * </p>
     */
    public void testRemoveNodeAddListener_NullListener() {
        NodeAddListener listener = new MockNodeAddListener();
        nodeContainer.addNodeAddListener(listener);

        nodeContainer.removeNodeAddListener(null);

        assertEquals("Failed to remove the listener correctly.", 1,
                nodeContainer.getListeners(NodeAddListener.class).length);
    }

    /**
     * <p>
     * Tests TextField#fireNodeAdd(NodeAddEvent) for accuracy.
     * </p>
     * <p>
     * It verifies TextField#fireNodeAdd(NodeAddEvent) is correct.
     * </p>
     */
    public void testFireNodeAdd() {
        MockNodeAddListener listener = new MockNodeAddListener();
        NodeAddEvent event = new NodeAddEvent(TestHelper.createSubsystemNodeContainer(), new Point());

        nodeContainer.addNodeAddListener(listener);

        nodeContainer.fireNodeAdd(event);

        assertTrue("Failed to fire the listener correctly.", listener.getIsExecute());
        assertEquals("Failed to fire the listener correctly.", event, listener.getNodeAddEvent());
    }

    /**
     * <p>
     * Tests TextField#fireNodeAdd(NodeAddEvent) for accuracy.
     * </p>
     * <p>
     * It tests the case that when listener is null and expects success.
     * </p>
     */
    public void testFireNodeAdd_NullEvent() {
        MockNodeAddListener listener = new MockNodeAddListener();
        nodeContainer.addNodeAddListener(listener);

        nodeContainer.fireNodeAdd(null);

        assertFalse("Failed to fire the listener correctly.", listener.getIsExecute());
    }

    /**
     * <p>
     * Tests TextField#addEdgeAddListener(EdgeAddListener) for accuracy.
     * </p>
     * <p>
     * It verifies TextField#addEdgeAddListener(EdgeAddListener) is correct.
     * </p>
     */
    public void testAddEdgeAddListener() {
        EdgeAddListener listener = new MockEdgeAddListener();
        nodeContainer.addEdgeAddListener(listener);

        assertEquals("Expected the length of listeners is one.", 1,
                nodeContainer.getListeners(EdgeAddListener.class).length);
        assertEquals("Failed to set the listener correctly.", listener, nodeContainer
                .getListeners(EdgeAddListener.class)[0]);
    }

    /**
     * <p>
     * Tests TextField#addEdgeAddListener(EdgeAddListener) for accuracy.
     * </p>
     * <p>
     * It tests the case that when listener is null and expects success.
     * </p>
     */
    public void testAddEdgeAddListener_NullListener() {
        nodeContainer.addEdgeAddListener(null);

        assertEquals("Failed to set the listener correctly.", 0,
                nodeContainer.getListeners(EdgeAddListener.class).length);
    }

    /**
     * <p>
     * Tests TextField#removeEdgeAddListener(EdgeAddListener) for accuracy.
     * </p>
     * <p>
     * It verifies TextField#removeEdgeAddListener(EdgeAddListener) is correct.
     * </p>
     */
    public void testRemoveEdgeAddListener() {
        EdgeAddListener listener = new MockEdgeAddListener();
        nodeContainer.addEdgeAddListener(listener);

        nodeContainer.removeEdgeAddListener(listener);

        assertEquals("Failed to remove the listener correctly.", 0,
                nodeContainer.getListeners(EdgeAddListener.class).length);
    }

    /**
     * <p>
     * Tests TextField#removeEdgeAddListener(EdgeAddListener) for accuracy.
     * </p>
     * <p>
     * It tests the case that when listener is null and expects success.
     * </p>
     */
    public void testRemoveEdgeAddListener_NullListener() {
        EdgeAddListener listener = new MockEdgeAddListener();
        nodeContainer.addEdgeAddListener(listener);

        nodeContainer.removeEdgeAddListener(null);

        assertEquals("Failed to remove the listener correctly.", 1,
                nodeContainer.getListeners(EdgeAddListener.class).length);
    }

    /**
     * <p>
     * Tests TextField#fireEdgeAdd(EdgeAddEvent) for accuracy.
     * </p>
     * <p>
     * It verifies TextField#fireEdgeAdd(EdgeAddEvent) is correct.
     * </p>
     */
    public void testFireEdgeAdd() {
        MockEdgeAddListener listener = new MockEdgeAddListener();
        EdgeAddEvent event = new EdgeAddEvent(TestHelper.createSubsystemNodeContainer(), new Point(), true);

        nodeContainer.addEdgeAddListener(listener);

        nodeContainer.fireEdgeAdd(event);

        assertTrue("Failed to fire the listener correctly.", listener.getIsExecute());
        assertEquals("Failed to fire the listener correctly.", event, listener.getEdgeAddEvent());
    }

    /**
     * <p>
     * Tests TextField#fireEdgeAdd(EdgeAddEvent) for accuracy.
     * </p>
     * <p>
     * It tests the case that when listener is null and expects success.
     * </p>
     */
    public void testFireEdgeAdd_NullEvent() {
        MockEdgeAddListener listener = new MockEdgeAddListener();
        nodeContainer.addEdgeAddListener(listener);

        nodeContainer.fireEdgeAdd(null);

        assertFalse("Failed to fire the listener correctly.", listener.getIsExecute());
    }

    /**
     * <p>
     * Tests {@link SubsystemNodeContainer#notifyNamespaceVisibilityChange()} for accuracy.
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

        nodeContainer.notifyNamespaceVisibilityChange();
        assertTrue("failed to notify namespace visibility change",
                nodeContainer.getNamespaceCompartment().isVisible());
    }

    /**
     * <p>
     * Tests {@link SubsystemNodeContainer#notifyNamespaceVisibilityChange()} for accuracy.
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

        nodeContainer.notifyNamespaceVisibilityChange();
        assertFalse("failed to notify namespace visibility change",
                nodeContainer.getNamespaceCompartment().isVisible());
    }

    /**
     * <p>
     * Tests {@link SubsystemNodeContainer#notifyStereotypeVisibilityChange()} for accuracy.
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

        nodeContainer.notifyStereotypeVisibilityChange();
        assertTrue("failed to notify stereotype visibility change",
                nodeContainer.getStereotypeCompartment().isVisible());
    }

    /**
     * <p>
     * Tests {@link SubsystemNodeContainer#notifyStereotypeVisibilityChange()} for accuracy.
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

        nodeContainer.notifyStereotypeVisibilityChange();
        assertFalse("failed to notify stereotype visibility change",
                nodeContainer.getStereotypeCompartment().isVisible());
    }
    /**
     * <p>
     * The entry of the demo program.
     * </p>
     * <p>
     * This also test the accuracy of {@link PopupMenuTrigger#mouseClicked(MouseEvent).
     * You can right click in the rectangle in the SWING application to test it.
     * </p>
     *
     * @param args the arguments
     */
    public static void main(String[] args) {
        SubsystemNodeContainer subsystem;
        try {
            subsystem = new SubsystemNodeContainer(TestHelper.createGraphNodeForSubsystem(),
                    TestHelper.createProperties(), new TransferHandler(""));
            subsystem.notifyGraphNodeChange("change");

            // set the menu
            JPopupMenu menu = new JPopupMenu("Menu");
            menu.add(new JMenuItem("Test1"));
            menu.add(new JMenuItem("Test2"));
            menu.add(new JMenuItem("Test3"));
            subsystem.setComponentPopupMenu(menu);

            JFrame frame = new JFrame();
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setLayout(null);
            frame.getContentPane().add(subsystem);
            frame.setSize(new Dimension(500, 500));
            frame.setVisible(true);
        } catch (IllegalGraphElementException e) {
            e.printStackTrace();
        }
    }
}