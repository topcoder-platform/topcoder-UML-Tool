/*
 * Copyright (C) 2007 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.gui.diagramviewer.elements;

import java.awt.Graphics;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.Collection;

import junit.framework.TestCase;

import com.topcoder.diagraminterchange.GraphNode;
import com.topcoder.gui.diagramviewer.DiagramViewer;
import com.topcoder.gui.diagramviewer.ConfigurationException;

/**
 * The Diagram Elements component provides a general framework for representing graphically the Diagram Interchange
 * graph nodes that can be added to the diagram view from the Diagram Viewer component. This class provides the demo
 * usage of this component.
 *
 * @author TCSDEVELOPER
 * @version 1.0
 */
public class DemoTests extends TestCase {

    /**
     * Represents an concrete implementation of <code>Node</code> class. It is only used in demo.
     */
    private static class RectNode extends Node {

        /**
         * Creates a <code>RectNode</code> with the given graph node.
         *
         * @param graphNode
         *            the <code>GraphNode</code> instance associated to this node
         */
        public RectNode(GraphNode graphNode) {
            // corner types and relative position are specified by default
            super(graphNode, new Point(5, 5), getBound(), getDefaultCornerTypes());

            // make the size larger than actual bound
            super.setSize(getBound().width + 10, getBound().height + 10);
        }

        /**
         * Gets the default selection corner types.
         *
         * @return the default selection corner types
         */
        private static final Collection<SelectionCornerType> getDefaultCornerTypes() {
            Collection<SelectionCornerType> types = new ArrayList<SelectionCornerType>();
            types.add(SelectionCornerType.EAST);
            types.add(SelectionCornerType.SOUTH);
            types.add(SelectionCornerType.WEST);
            types.add(SelectionCornerType.NORTH);
            types.add(SelectionCornerType.NORTHEAST);
            types.add(SelectionCornerType.NORTHWEST);
            types.add(SelectionCornerType.SOUTHEAST);
            types.add(SelectionCornerType.SOUTHWEST);
            return types;
        }

        /**
         * Gets the default selection bound.
         *
         * @return the default selection bound
         */
        private static final Rectangle getBound() {
            return new Rectangle(100, 100, 100, 100);
        }

        /**
         * Overrides to paint custom look.
         *
         * @param g
         *            the <code>Graphics</code> to paint on
         */
        protected void paintComponent(Graphics g) {
            // draw a rectangle
        }

        /**
         * Overrides to define custom shape.
         *
         * @param x
         *            the x coordinate of point
         * @param y
         *            the y coordinate of point
         * @return true if the given point is in the circle, otherwise false
         */
        public boolean contains(int x, int y) {
            return false;
        }

        /**
         * Simply return false.
         *
         * @param event
         *            ignore
         * @return always false
         */
        protected boolean consumeEvent(MouseEvent event) {
            return false;
        }
    }

    /**
     * Sets up the test environment.
     */
    protected void setUp() throws Exception {
        TestHelper.loadXMLConfig("test_files/DiagramViewer.xml");
    }

    /**
     * <p>
     * Tears down test environment.
     * </p>
     *
     * @throws Exception to JUnit
     */
    protected void tearDown() throws Exception {
        TestHelper.clearConfig();
    }

    /**
     * This test case provides the usage of <code>Node</code>.
     */
    public void testUseNode() throws ConfigurationException {
        // create a node instance
        RectNode node = new RectNode(new GraphNode());

        // add it to diagram viewer
        DiagramViewer viewer = new DiagramViewer("DiagramViewer");
        viewer.add(node);

        // register the node drag event
        node.addNodeDragListener(new MockNodeDragListener());

        // register the selection corner drag event
        node.addCornerDragListener(new MockCornerDragListener());
    }

    /**
     * This test case provides the usage of <code>NodeContainer</code>.
     */
    public void testUseNodeContainer() {
        // create a node instance
        RectNode node = new RectNode(new GraphNode());

        // create a NodeContainer instance
        NodeContainer container = new DefaultContainer();

        // manipulate node directly contained in it

        // add a directly contained node
        container.add(node);

        // get all directly contained nodes
        container.getNodes();

        // remove a directly contained node
        container.remove(node);

        // clear all directly contained nodes
        container.clearNodes();

        // manipulate nodes contained in compartment

        // add a node to certain compartment
        container.add("Compartment1", node);

        // get all nodes contained in certain compartment
        container.getNodes("Compartment1");

        // remove a node from certain compartment
        container.remove(node);

        // clear all nodes in certain compartment
        container.clearNodes("Compartment1");

        // get all compartments
        container.getCompartments();
    }
}
