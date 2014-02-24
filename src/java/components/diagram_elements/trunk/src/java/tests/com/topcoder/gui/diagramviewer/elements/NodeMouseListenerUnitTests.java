/*
 * Copyright (C) 2007 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.gui.diagramviewer.elements;

import java.awt.Point;
import java.awt.Rectangle;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.Date;

import com.topcoder.diagraminterchange.Diagram;
import com.topcoder.diagraminterchange.GraphNode;
import com.topcoder.gui.diagramviewer.ConfigurationException;
import com.topcoder.gui.diagramviewer.DiagramView;
import com.topcoder.gui.diagramviewer.DiagramViewer;

import junit.framework.TestCase;

/**
 * Unit test for <code>NodeMouseListener</code> class.
 *
 * @author TCSDEVELOPER
 * @version 1.0
 */
public class NodeMouseListenerUnitTests extends TestCase {

    /**
     * Represents the mock node used for test.
     */
    private class MockNode extends Node {

        /**
         * Holds the passed in <code>LocationEvent</code> instance.
         */
        private LocationEvent passedinEvent = null;

        /**
         * The default constructor.
         */
        public MockNode() {
            super(new GraphNode(), new Point(), new Rectangle(), new ArrayList<SelectionCornerType>());
        }

        /**
         * Simply returns false.
         *
         * @param event
         *            ignored
         * @return always false
         */
        protected boolean consumeEvent(MouseEvent event) {
            return false;
        }

        /**
         * Notifies all listeners registered interest for node drag event.
         *
         * @param e
         *            the location event
         */
        public void fireNodeDrag(LocationEvent e) {
            passedinEvent = e;
        }

        /**
         * Gets the passed in <code>LocationEvent</code> instance.
         *
         * @return the passed in <code>LocationEvent</code> instance
         */
        public LocationEvent getPassedinEvent() {
            return passedinEvent;
        }
    }

    /**
     * Represents the <code>MouseEvent</code> instance with non-Node source used for test.
     */
    private final MouseEvent nonNodeEvent = new MouseEvent(new SelectionCorner(SelectionCornerType.EAST, new Point()),
        0, new Date().getTime(), 0, 100, 200, 0, false);

    /**
     * Represents the <code>MouseEvent</code> instance with Node source used for test.
     */
    private MouseEvent nodeEvent = null;

    /**
     * Represents the <code>MockNode</code> instance used for test.
     */
    private MockNode node = null;

    /**
     * Represents the <code>NodeMouseListener</code> instance used to test against.
     */
    private NodeMouseListener listener;

    /**
     * Sets up the test environment.
     * @throws Exception to junit
     */
    protected void setUp() throws Exception {
        TestHelper.loadXMLConfig("test_files/DiagramViewer.xml");
        node = new MockNode();
        nodeEvent = new MouseEvent(node, 0, new Date().getTime(), 0, 100, 200, 0, false, MouseEvent.BUTTON1);
        listener = new NodeMouseListener();
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
     * Test for the inheritance, <code>NodeMouseListener</code> class should extend from the
     * <code>DragEventAdapter</code> class.
     */
    public void testInheritanceFromDragEventAdapter() {
        assertTrue("NodeMouseListener class should extend from the DragEventAdapter class.",
            DragEventAdapter.class.isAssignableFrom(NodeMouseListener.class));
    }

    /**
     * Accuracy test for the constructor <code>NodeMouseListener()</code>, instance should be created.
     */
    public void testConstructor() {
        NodeMouseListener l = new NodeMouseListener();
        assertNotNull("NodeMouseListener instance should be created.", l);
        assertNull("The lastPoint field should be null.",
            TestHelper.getPrivateField(DragEventAdapter.class, l, "lastPoint"));
    }

    /**
     * Accuracy test for the method <code>mousePressed(MouseEvent)</code> with null event, nothing should be done.
     */
    public void testMousePressedWithNullEventAccuracy() {
        listener.mousePressed(null);
        assertNull("The lastPoint field should be null.",
            TestHelper.getPrivateField(DragEventAdapter.class, listener, "lastPoint"));
    }

    /**
     * Accuracy test for the method <code>mousePressed(MouseEvent)</code> with non-node event, nothing should be done.
     */
    public void testMousePressedWithNonNodeEventAccuracy() {
        listener.mousePressed(nonNodeEvent);
        assertNull("The lastPoint field should be null.",
            TestHelper.getPrivateField(DragEventAdapter.class, listener, "lastPoint"));
    }

    /**
     * Accuracy test for the method <code>mousePressed(MouseEvent)</code> with node event, <code>lastPoint</code> field
     * should be set.
     */
    public void testMousePressedWithNodeEventAccuracy() {
        listener.mousePressed(nodeEvent);
        Point lastPoint = (Point) TestHelper.getPrivateField(DragEventAdapter.class, listener, "lastPoint");
        assertTrue("The lastPoint field should be set.", lastPoint.equals(new Point(100, 200)));
    }

    /**
     * Accuracy test for the method <code>mouseDragged(MouseEvent)</code> with null event, nothing should be done.
     */
    public void testMouseDraggedWithNullEventAccuracy() {
        listener.mouseDragged(null);
        assertNull("Nothing should happen.", node.getPassedinEvent());
    }

    /**
     * Accuracy test for the method <code>mouseDragged(MouseEvent)</code> with non-node event, nothing should be done.
     */
    public void testMouseDraggedWithNonNodeEventAccuracy() {
        listener.mouseDragged(nonNodeEvent);
        assertNull("Nothing should happen.", node.getPassedinEvent());
    }

    /**
     * Accuracy test for the method <code>mouseDragged(MouseEvent)</code> when the last point has not been set, nothing
     * should be done.
     */
    public void testMouseDraggedWithWhenNoLastPointAccuracy() {
        listener.mouseDragged(nodeEvent);
        assertNull("Nothing should happen.", node.getPassedinEvent());
    }

    /**
     * Accuracy test for the method <code>mouseDragged(MouseEvent)</code> with node event, listeners should be fired.
     * @throws ConfigurationException if fail to create diagram viewer
     */
    public void testMouseDraggedWithNodeEventAccuracy() throws ConfigurationException {
        DiagramViewer diagramViewer = new DiagramViewer("DiagramViewer");
        Diagram diagram = new Diagram();
        diagram.setPosition(TestHelper.createDiagramInterchangePoint(0, 0));
        diagram.setSize(TestHelper.createDiagramInterchangeDimension(100, 50));
        DiagramView diagramView = diagramViewer.createDiagramView(diagram);
        diagramView.add(node);
        TestHelper.setPrivateField(DragEventAdapter.class, listener, "lastPoint", new Point(10, 20));
        listener.mouseDragged(nodeEvent);
        assertNotNull("Event should be fired.", node.getPassedinEvent());
        // get the event
        LocationEvent e = node.getPassedinEvent();
        assertTrue("The source should be node.", e.getSource().equals(node));
        assertTrue("The old location should be correct.", e.getOldLocation().equals(new Point(0, 0)));
        assertTrue("The new location should be correct.", e.getNewLocation().equals(new Point(90, 180)));
    }
}
