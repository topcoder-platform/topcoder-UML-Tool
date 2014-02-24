/*
 * Copyright (C) 2007 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.gui.diagramviewer.uml.usecaseelements.accuracytests;

import java.awt.Color;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.event.MouseEvent;
import java.util.HashMap;
import java.util.Map;

import javax.swing.TransferHandler;

import junit.framework.TestCase;

import com.topcoder.diagraminterchange.GraphNode;
import com.topcoder.gui.diagramviewer.edges.connectors.RectangleConnector;
import com.topcoder.gui.diagramviewer.uml.usecaseelements.IllegalGraphElementException;
import com.topcoder.gui.diagramviewer.uml.usecaseelements.SubsystemNodeContainer;
import com.topcoder.gui.diagramviewer.uml.usecaseelements.event.BoundaryChangedEvent;
import com.topcoder.gui.diagramviewer.uml.usecaseelements.event.BoundaryChangedListener;
import com.topcoder.gui.diagramviewer.uml.usecaseelements.event.EdgeAddEvent;
import com.topcoder.gui.diagramviewer.uml.usecaseelements.event.EdgeAddListener;
import com.topcoder.gui.diagramviewer.uml.usecaseelements.event.MockBoundaryChangedListener;
import com.topcoder.gui.diagramviewer.uml.usecaseelements.event.MockNodeAddListener;
import com.topcoder.gui.diagramviewer.uml.usecaseelements.event.NodeAddEvent;
import com.topcoder.gui.diagramviewer.uml.usecaseelements.event.NodeAddListener;

/**
 * Accuracy test for SubsystemNodeContainer.
 * 
 * @author radium
 * @version 1.0
 */
public class SubsystemNodeContainerAccuracyTest extends TestCase {
    /**
     * Mock SubSystemNodeContainer for testing.
     * 
     * @author radium
     * @version 1.0
     */
    @SuppressWarnings("serial")
    private class MockSubsystemNodeContainer extends SubsystemNodeContainer {
        /**
         * Simple constructor.
         * 
         * @param graphNode
         *            the graphNode.
         * @param properties
         *            the properties.
         * @param handler
         *            the handler.
         * @throws IllegalGraphElementException
         *             if error occurs.
         */
        public MockSubsystemNodeContainer(GraphNode graphNode, Map<String, String> properties,
            TransferHandler handler) throws IllegalGraphElementException {
            super(graphNode, properties, handler);
            // TODO Auto-generated constructor stub
        }

        /**
         * Simple implementation for testing.
         */
        public boolean consumeEvent(MouseEvent event) {
            return super.consumeEvent(event);

        }

        /**
         * Simple implementation for testing.
         */
        public void fireBoundaryChange(BoundaryChangedEvent event) {
            super.fireBoundaryChange(event);
        }

        /**
         * Simple implementation for testing.
         */
        public void fireNodeAdd(NodeAddEvent event) {
            super.fireNodeAdd(event);
        }

        /**
         * Simple implementation for testing.
         */
        public void fireEdgeAdd(EdgeAddEvent event) {
            super.fireEdgeAdd(event);
        }
    }

    /**
     * Sample SubsystemNodeContainer for testing.
     */
    private MockSubsystemNodeContainer snc;

    /**
     * Sample GraphNode for testing.
     */
    private GraphNode graphNode;

    /**
     * Setup the environment for testing.
     */
    protected void setUp() throws Exception {
        graphNode = AccuracyTestHelper.createGraphNodeForSubsystem();
        Map hashMap = new HashMap<String, String>();
        hashMap.put("String", "String");
        snc = new MockSubsystemNodeContainer(graphNode, hashMap, new TransferHandler(""));
    }

    /**
     * Test method for contains(int, int).
     */
    public void testContainsIntInt() {
        assertTrue("Should be true.", snc.contains(900, 900));
        assertFalse("Should be false.", snc.contains(2000, 2000));
    }

    /**
     * Test method for get and set TransferHandler.
     */
    public void testSetTransferHandlerTransferHandler() {
        TransferHandler tsh = new TransferHandler("hello");
        snc.setTransferHandler(tsh);
        assertEquals("Should be equal.", tsh, snc.getTransferHandler());
    }

    /**
     * Test method for getStrokeColor().
     */
    public void testGetStrokeColor() {
        assertEquals("Should be equal.", new Color(0, 0, 0), snc.getStrokeColor());
    }

    /**
     * Test method for getFontColor().
     */
    public void testGetFontColor() {
        assertEquals("Should be equal.", new Color(0, 0, 0), snc.getFontColor());
    }

    /**
     * Test method for getConnector().
     */
    public void testGetConnector() {
        assertTrue("Should be true.", snc.getConnector() instanceof RectangleConnector);
    }

    /**
     * Test method for getNameCompartment().
     */
    public void testGetNameCompartment() {
        assertSame("Should be the same.", snc.getNameCompartment().getGraphNode(), ((GraphNode) graphNode
            .getContaineds().get(0)).getContaineds().get(1));
    }

    /**
     * Test method for getStereotypeCompartment().
     */
    public void testGetStereotypeCompartment() {
        assertSame("Should be the same.", snc.getStereotypeCompartment().getGraphNode(), ((GraphNode) graphNode
            .getContaineds().get(0)).getContaineds().get(0));
    }

    /**
     * Test method for getNamespaceCompartment().
     */
    public void testGetNamespaceCompartment() {
        assertSame("Should be the same.", snc.getNamespaceCompartment().getGraphNode(), ((GraphNode) graphNode
            .getContaineds().get(0)).getContaineds().get(2));
    }

    /**
     * Test method for consumeEvent(MouseEvent).
     */
    public void testConsumeEventMouseEvent() {
        assertFalse("Should be false.", snc.consumeEvent(null));
    }

    /**
     * Test method for addBoundaryChangeListener(BoundaryChangedListener).
     */
    public void testAddBoundaryChangeListener() {
        MockBoundaryChangedListener mbc = new MockBoundaryChangedListener();
        snc.addBoundaryChangeListener(mbc);
        assertEquals("Should be equal.", 1, snc.getListeners(BoundaryChangedListener.class).length);
    }

    /**
     * Test method for removeBoundaryChangeListener(BoundaryChangedListener).
     */
    public void testRemoveBoundaryChangeListener() {
        MockBoundaryChangedListener mbc = new MockBoundaryChangedListener();
        snc.addBoundaryChangeListener(mbc);
        snc.removeBoundaryChangeListener(mbc);
        assertEquals("Should be equal.", 0, snc.getListeners(BoundaryChangedListener.class).length);
    }

    /**
     * Test method for fireBoundaryChange(BoundaryChangedEvent).
     */
    public void testFireBoundaryChange() {
        MockBoundaryChangeListenerAccuracy mbc = new MockBoundaryChangeListenerAccuracy();
        snc.addBoundaryChangeListener(mbc);
        snc.fireBoundaryChange(new BoundaryChangedEvent(snc, new Rectangle(), new Rectangle()));
        assertTrue("Should be true.", mbc.getIsExecute());
    }

    /**
     * Test method for addNodeAddListener(NodeAddListener).
     */
    public void testAddNodeAddListener() {
        NodeAddListener nal = new MockNodeAddListenerAccuracy();
        snc.addNodeAddListener(nal);
        assertEquals("Should be equal.", 1, snc.getListeners(NodeAddListener.class).length);

    }

    /**
     * Test method for removeNodeAddListener(NodeAddListener).
     */
    public void testRemoveNodeAddListener() {
        NodeAddListener nal = new MockNodeAddListener();
        snc.addNodeAddListener(nal);
        snc.removeNodeAddListener(nal);
        assertEquals("Should be equal.", 0, snc.getListeners(NodeAddListener.class).length);
    }

    /**
     * Test method for fireNodeAdd(NodeAddEvent).
     */
    public void testFireNodeAdd() {
        MockNodeAddListenerAccuracy nal = new MockNodeAddListenerAccuracy();
        snc.addNodeAddListener(nal);
        snc.fireNodeAdd(new NodeAddEvent(snc, new Point()));
        assertTrue("Should be true.", nal.getIsExcuted());

    }

    /**
     * Test method for addEdgeAddListener(EdgeAddListener).
     */
    public void testAddEdgeAddListener() {
        for (int i = 0; i < 3; i++) {
            snc.addEdgeAddListener(new MockEdgeAddListenerAccuracy());
        }
        assertEquals("Should be equal.", 3, snc.getListeners(EdgeAddListener.class).length);
    }

    /**
     * Test method for removeEdgeAddListener(EdgeAddListener).
     */
    public void testRemoveEdgeAddListener() {
        for (int i = 0; i < 3; i++) {
            EdgeAddListener eal = new MockEdgeAddListenerAccuracy();
            snc.addEdgeAddListener(eal);
            snc.removeEdgeAddListener(eal);
        }
        assertEquals("Should be equal.", 0, snc.getListeners(EdgeAddListener.class).length);
    }

    /**
     * Test method for fireEdgeAdd(EdgeAddEvent).
     */
    public void testFireEdgeAdd() {
        MockEdgeAddListenerAccuracy eal = new MockEdgeAddListenerAccuracy();
        snc.addEdgeAddListener(eal);
        snc.fireEdgeAdd(new EdgeAddEvent(snc, new Point(), false));
        assertTrue("Should be true.", eal.getIsExcuted());
    }

    /**
     * Test method for notifyStereotypeVisibilityChange(). Simple testing
     * whether it runs correctly.
     * 
     * @throws IllegalGraphElementException
     *             if error occurs.
     */
    public void testNotifyStereotypeVisibilityChange() throws IllegalGraphElementException {
        snc.notifyNamespaceVisibilityChange();
    }

    /**
     * Test method for notifyNamespaceVisibilityChange(). Simple testing whether
     * it runs correctly.
     * 
     * @throws IllegalGraphElementException
     *             if error occurs.
     */
    public void testNotifyNamespaceVisibilityChange() throws IllegalGraphElementException {
        snc.notifyNamespaceVisibilityChange();
    }

}
