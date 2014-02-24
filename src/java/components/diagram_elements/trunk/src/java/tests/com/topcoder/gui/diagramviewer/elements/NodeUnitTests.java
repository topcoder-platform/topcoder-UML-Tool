/*
 * Copyright (C) 2007 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.gui.diagramviewer.elements;

import java.awt.Point;
import java.awt.Rectangle;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;

import javax.swing.JComponent;
import javax.swing.event.EventListenerList;

import com.topcoder.diagraminterchange.GraphNode;
import com.topcoder.gui.diagramviewer.DiagramViewer;
import com.topcoder.gui.diagramviewer.ConfigurationException;

import junit.framework.TestCase;

/**
 * Unit test for the <code>Node</code> class.
 *
 * @author TCSDEVELOPER
 * @version 1.0
 */
public class NodeUnitTests extends TestCase {

    /**
     * Represents the mock node class used for test.
     */
    private class MockNode extends Node {

        /**
         * <p>
         * Constructs a <code>MockNode</code> instance.
         * </p>
         *
         * @param graphNode
         *            the <code>GraphNode</code> instance associated to this node
         * @param position
         *            the relative position of visual node
         * @param bound
         *            the selection bound of corners
         * @param corners
         *            all the supported selection corners
         * @throws IllegalArgumentException
         *             if <code>graphNode</code>, <code>position</code>, <code>bound</code> or <code>corners</code>
         *             is null, or <code>corners</code> contains null element or duplicated elements
         */
        public MockNode(GraphNode graphNode, Point position, Rectangle bound, Collection<SelectionCornerType> corners) {
            super(graphNode, position, bound, corners);
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

        /**
         * <p>
         * Gets the diagram viewer containing this node.
         * </p>
         *
         * @return the diagram viewer containing this node.
         */
        public DiagramViewer getDiagramViewer() {
            return super.getDiagramViewer();
        }

        /**
         * <p>
         * Gets selection corners belonging to this node.
         * </p>
         *
         * @return an unmodifiable collection of selection corners belonging to this node
         */
        public Collection<SelectionCorner> getSelectionCorners() {
            return super.getSelectionCorners();
        }

        /**
         * <p>
         * Passes event to the element behind this edge (considering the diagram view hierarchy, not the graph node
         * container hierarchy).
         * </p>
         *
         * @param event
         *            the mouse event to be passed
         */
        public void passEventBehind(MouseEvent event) {
            super.passEventBehind(event);
        }

        /**
         * <p>
         * Overrides the <code>processMouseEvent</code> method of base class.
         * </p>
         *
         * @param e
         *            the mouse event
         */
        public void processMouseEvent(MouseEvent e) {
            super.processMouseEvent(e);
        }

        /**
         * <p>
         * Overrides the <code>processMouseMotionEvent</code> method of base class.
         * </p>
         *
         * @param e
         *            the mouse event
         */
        public void processMouseMotionEvent(MouseEvent e) {
            super.processMouseMotionEvent(e);
        }

        /**
         * <p>
         * Notifies all listeners registered interest for node drag event.
         * </p>
         *
         * @param event
         *            the node drag event
         */
        public void fireNodeDrag(LocationEvent event) {
            super.fireNodeDrag(event);
        }

        /**
         * <p>
         * Notifies all listeners registered interest for corner drag event.
         * </p>
         *
         * @param event
         *            the node drag event
         */
        public void fireCornerDrag(SelectionBoundEvent event) {
            super.fireCornerDrag(event);
        }
    }

    /**
     * Represents the <code>GraphNode</code> instance used for test.
     */
    private final GraphNode graphNode = new GraphNode();

    /**
     * Represents the <code>Point</code> instance used for test.
     */
    private final Point position = new Point(100, 200);

    /**
     * Represents the <code>Rectangle</code> instance used for test.
     */
    private final Rectangle bound = new Rectangle(50, 150, 100, 100);

    /**
     * Represents the <code>SelectionCornerType</code> collection used for test.
     */
    private Collection<SelectionCornerType> corners;

    /**
     * Represents the <code>MockNode</code> instance used to test against.
     */
    private MockNode node = null;

    /**
     * Sets up the test environment.
     */
    protected void setUp() throws Exception {
        TestHelper.loadXMLConfig("test_files/DiagramViewer.xml");

        corners = new ArrayList<SelectionCornerType>();
        corners.add(SelectionCornerType.EAST);
        corners.add(SelectionCornerType.SOUTH);
        corners.add(SelectionCornerType.WEST);
        corners.add(SelectionCornerType.NORTH);
        corners.add(SelectionCornerType.NORTHEAST);
        corners.add(SelectionCornerType.NORTHWEST);
        corners.add(SelectionCornerType.SOUTHEAST);
        corners.add(SelectionCornerType.SOUTHWEST);

        node = new MockNode(graphNode, position, bound, corners);
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
     * Test for the inheritance, <code>Node</code> class should extend from the <code>JComponent</code> class.
     */
    public void testInheritanceFromJComponent() {
        assertTrue("Node class should extend from the JComponent class.",
            JComponent.class.isAssignableFrom(Node.class));
    }

    /**
     * Test the constructor <code>Node(GraphNode, Point, Rectangle, Collection)</code> with null <code>graphNode</code>,
     * IllegalArgumentException should be thrown.
     */
    public void testConstructorWithNullGraphNode() {
        try {
            new MockNode(null, position, bound, corners);
            fail("IllegalArgumentException should be thrown.");
        } catch (IllegalArgumentException e) {
            // success
        }
    }

    /**
     * Test the constructor <code>Node(GraphNode, Point, Rectangle, Collection)</code> with null <code>position</code>,
     * IllegalArgumentException should be thrown.
     */
    public void testConstructorWithNullPosition() {
        try {
            new MockNode(graphNode, null, bound, corners);
            fail("IllegalArgumentException should be thrown.");
        } catch (IllegalArgumentException e) {
            // success
        }
    }

    /**
     * Test the constructor <code>Node(GraphNode, Point, Rectangle, Collection)</code> with null <code>bound</code>,
     * IllegalArgumentException should be thrown.
     */
    public void testConstructorWithNullBound() {
        try {
            new MockNode(graphNode, position, null, corners);
            fail("IllegalArgumentException should be thrown.");
        } catch (IllegalArgumentException e) {
            // success
        }
    }

    /**
     * Test the constructor <code>Node(GraphNode, Point, Rectangle, Collection)</code> with null <code>corners</code>,
     * IllegalArgumentException should be thrown.
     */
    public void testConstructorWithNullCorners() {
        try {
            new MockNode(graphNode, position, bound, null);
            fail("IllegalArgumentException should be thrown.");
        } catch (IllegalArgumentException e) {
            // success
        }
    }

    /**
     * Test the constructor <code>Node(GraphNode, Point, Rectangle, Collection)</code> with invalid <code>corners</code>
     * which contains null, IllegalArgumentException should be thrown.
     */
    public void testConstructorWithInvalidCornersContainNull() {
        corners.add(null);
        try {
            new MockNode(graphNode, position, bound, corners);
            fail("IllegalArgumentException should be thrown.");
        } catch (IllegalArgumentException e) {
            // success
        }
    }

    /**
     * Test the constructor <code>Node(GraphNode, Point, Rectangle, Collection)</code> with invalid <code>corners</code>
     * which contains duplicated elements, IllegalArgumentException should be thrown.
     */
    public void testConstructorWithInvalidCornersContainDuplicate() {
        corners.add(SelectionCornerType.EAST);
        try {
            new MockNode(graphNode, position, bound, corners);
            fail("IllegalArgumentException should be thrown.");
        } catch (IllegalArgumentException e) {
            // success
        }
    }

    /**
     * Accuracy test for the constructor <code>Node(GraphNode, Point, Rectangle, Collection)</code>, instance should be
     * created.
     */
    public void testConstructorAccuracy() {
        Node n = new MockNode(graphNode, position, bound, corners);
        assertNotNull("Node instance should be created.", n);
        assertTrue("The graphNode field should be set.",
            TestHelper.getPrivateField(Node.class, n, "graphNode").equals(graphNode));
        assertTrue("The relativePosition field should be set.",
            TestHelper.getPrivateField(Node.class, n, "relativePosition").equals(position));
        assertTrue("The selectionBound field should be set.",
            TestHelper.getPrivateField(Node.class, n, "selectionBound").equals(bound));
        assertTrue("MouseListener should be registered.", n.getMouseListeners().length == 1);
        assertTrue("MouseMotionListener should be registered.", n.getMouseMotionListeners().length == 1);
        // validate corners
        Collection<SelectionCorner> c
            = (Collection<SelectionCorner>) TestHelper.getPrivateField(Node.class, n, "corners");
        assertTrue("The corners should contain eight elements.", corners.size() == 8);
        for (SelectionCorner corner : c) {
            assertTrue("MouseListener should be registered.", corner.getMouseListeners().length == 1);
            assertTrue("MouseMotionListener should be registered.", corner.getMouseMotionListeners().length == 1);
            assertTrue("The center should be set correctly.",
                TestHelper.validateCornerCenter(bound, corner.getType(), corner.getCenter()));
        }
    }

    /**
     * Accuracy test for the method <code>getGraphNode()</code>, the value of <code>graphNode</code> should be
     * returned.
     */
    public void testGetGraphNodeAccuracy() {
        assertTrue("The graphNode field should be returned.", node.getGraphNode().equals(graphNode));
    }

    /**
     * Accuracy test for the method <code>getDiagramViewer()</code> when the node has no parent, null should be
     * returned.
     */
    public void testGetDiagramViewerWhenNoParentAccuracy() {
        assertNull("Null should be returned.", node.getDiagramViewer());
    }

    /**
     * Accuracy test for the method <code>getDiagramViewer()</code> when the node has the parent which is not type of
     * <code>DiagramViewer</code>, null should be returned.
     */
    public void testGetDiagramViewerWhenNotDiagramViewerAccuracy() {
        // the parent is not DiagramViewer
        new MockNode(graphNode, position, bound, corners).add(node);
        assertNull("Null should be returned.", node.getDiagramViewer());
    }

    /**
     * Accuracy test for the method <code>getDiagramViewer()</code> when the node has the parent which is type of
     * <code>DiagramViewer</code>, the parent should be returned.
     */
    public void testGetDiagramViewerWhenDiagramViewerAccuracy() throws ConfigurationException {
        // the parent is DiagramViewer
        new DiagramViewer("DiagramViewer");
        assertNull("Null should be returned.", node.getDiagramViewer());
    }

    /**
     * Accuracy test for the method <code>notifyUnselected()</code>, all selection corners should be set to invisible.
     */
    public void testNotifyUnselectedAccuracy() {
        Collection<SelectionCorner> c
            = (Collection<SelectionCorner>) TestHelper.getPrivateField(Node.class, node, "corners");
        for (SelectionCorner corner : c) {
            corner.setVisible(true);
        }
        node.notifyUnselected();
        for (SelectionCorner corner : c) {
            assertFalse("The visible flag should be set to false.", corner.isVisible());
        }
    }

    /**
     * Accuracy test for the method <code>getLocation(Point)</code> with null <code>point</code>, a new point which
     * contains the result should be returned.
     */
    public void testGetLocationWithNullAccuracy() {
        Point point = node.getLocation(null);
        assertTrue("The location should be (-100, -200).", point.equals(new Point(-100, -200)));
    }

    /**
     * Accuracy test for the method <code>getLocation(Point)</code> with non-null <code>point</code>, the point which
     * contains the result should be returned.
     */
    public void testGetLocationWithNonNullAccuracy() {
        Point ori = new Point();
        Point point = node.getLocation(ori);
        assertTrue("The returned point should be the origin one.", ori == point);
        assertTrue("The location should be (-100, -200).", point.equals(new Point(-100, -200)));
    }

    /**
     * Accuracy test for the method <code>getSelectionCorners()</code>, the unmodifiable collection should be returned.
     */
    public void testGetSelectionCornersAccuracy() {
        assertTrue("The size of returned collection should be eight.", node.getSelectionCorners().size() == 8);
    }

    /**
     * Test the method <code>setRelativePosition(Point)</code> with null <code>position</code>, IllegalArgumentException
     * should be thrown.
     */
    public void testSetRelativePositionWithNullPosition() {
        try {
            node.setRelativePosition(null);
            fail("IllegalArgumentException should be thrown.");
        } catch (IllegalArgumentException e) {
            // success
        }
    }

    /**
     * Accuracy test for the method <code>setRelativePosition(Point)</code>, the value of <code>relativePosition</code>
     * field should be set.
     */
    public void testSetRelativePositionAccuracy() {
        Point newPosition = new Point(300, 400);
        node.setRelativePosition(newPosition);
        assertTrue("The relativePosition field should be set.",
            TestHelper.getPrivateField(Node.class, node, "relativePosition").equals(newPosition));
    }

    /**
     * Accuracy test for the method <code>getRelativePosition()</code>, the value of <code>relativePosition</code> field
     * should be returned.
     */
    public void testGetRelativePositionAccuracy() {
        assertTrue("The relativePosition field should be returned.", node.getRelativePosition().equals(position));
    }

    /**
     * Test the method <code>setSelectionBound(Rectangle)</code> with null <code>bound</code>, IllegalArgumentException
     * should be thrown.
     */
    public void testSetSelectionBoundWithNullBound() {
        try {
            node.setSelectionBound(null);
            fail("IllegalArgumentException should be thrown.");
        } catch (IllegalArgumentException e) {
            // success
        }
    }

    /**
     * Accuracy test for the method <code>setSelectionBound(Rectangle)</code>, the value of <code>selectionBound</code>
     * field should be set.
     */
    public void testSetSelectionBoundAccuracy() {
        Rectangle newBound = new Rectangle(300, 400, 200, 200);
        node.setSelectionBound(newBound);
        assertTrue("The selectionBound field should be set.",
            TestHelper.getPrivateField(Node.class, node, "selectionBound").equals(newBound));
        // validate corners
        Collection<SelectionCorner> c
            = (Collection<SelectionCorner>) TestHelper.getPrivateField(Node.class, node, "corners");
        for (SelectionCorner corner : c) {
            assertTrue("The center should be set correctly.",
                TestHelper.validateCornerCenter(newBound, corner.getType(), corner.getCenter()));
        }
    }

    /**
     * Accuracy test for the method <code>getSelectionBound()</code>, the value of <code>selectionBound</code> field
     * should be returned.
     */
    public void testGetSelectionBoundAccuracy() {
        assertTrue("The selectionBound field should be returned.", node.getSelectionBound().equals(bound));
    }

    /**
     * Accuracy test for the method <code>passEventBehind(MouseEvent)</code>, the result of this method is determined
     * by Diagram Viewer.
     */
    public void testPassEventBehindAccuracy() {
        node.passEventBehind(new MouseEvent(node, 0, new Date().getTime(), 0, 100, 100, 0, false));
    }

    /**
     * Accuracy test for the method <code>processMouseEvent(MouseEvent)</code> with null event, nothing should be done.
     */
    public void testProcessMouseEventWithNullEventAccuracy() {
        node.processMouseEvent(null);
        // nothing should be done
    }

    /**
     * Accuracy test for the method <code>processMouseEvent(MouseEvent)</code> with non-null event, the event should be
     * processed.
     */
    public void testProcessMouseEventWithNonNullEventAccuracy() {
        node.processMouseEvent(new MouseEvent(node, 0, new Date().getTime(), 0, 100, 200, 0, false));
        // event should be processed
    }

    /**
     * Accuracy test for the method <code>processMouseMotionEvent(MouseEvent)</code> with null event, nothing should
     * be done.
     */
    public void testProcessMouseMotionEventWithNullEventAccuracy() {
        node.processMouseMotionEvent(null);
        // nothing should be done
    }

    /**
     * Accuracy test for the method <code>processMouseMotionEvent(MouseEvent)</code> with non-null event, the event
     * should be processed.
     */
    public void testProcessMouseMotionEventWithNonNullEventAccuracy() {
        node.processMouseMotionEvent(new MouseEvent(node, 0, new Date().getTime(), 0, 100, 200, 0, false));
        // event should be processed
    }

    /**
     * Accuracy test for the method <code>addNodeDragListener(NodeDragListener)</code> with null <code>listener</code>,
     * nothing should happen.
     */
    public void testAddNodeDragListenerWithNullListenerAccuracy() {
        node.addNodeDragListener(null);
        EventListenerList eventListenerList
            = (EventListenerList) TestHelper.getPrivateField(JComponent.class, node, "listenerList");
        assertTrue("No listener should be added.", eventListenerList.getListenerCount(NodeDragListener.class) == 0);
    }

    /**
     * Accuracy test for the method <code>addNodeDragListener(NodeDragListener)</code> with non-null
     * <code>listener</code>, the listener should be added.
     */
    public void testAddNodeDragListenerWithNonNullListenerAccuracy() {
        node.addNodeDragListener(new MockNodeDragListener());
        EventListenerList eventListenerList
            = (EventListenerList) TestHelper.getPrivateField(JComponent.class, node, "listenerList");
        assertTrue("The listener should be added.", eventListenerList.getListenerCount(NodeDragListener.class) == 1);
    }

    /**
     * Accuracy test for the method <code>removeNodeDragListener(NodeDragListener)</code> with null
     * <code>listener</code>, nothing should happen.
     */
    public void testRemoveNodeDragListenerWithNullListenerAccuracy() {
        EventListenerList eventListenerList
            = (EventListenerList) TestHelper.getPrivateField(JComponent.class, node, "listenerList");
        eventListenerList.add(NodeDragListener.class, new MockNodeDragListener());
        node.removeNodeDragListener(null);
        assertTrue("No listener should be removed.", eventListenerList.getListenerCount(NodeDragListener.class) == 1);
    }

    /**
     * Accuracy test for the method <code>removeNodeDragListener(NodeDragListener)</code> with non-null
     * <code>listener</code>, the listener should be removed.
     */
    public void testRemoveNodeDragListenerWithNonNullListenerAccuracy() {
        NodeDragListener l = new MockNodeDragListener();
        EventListenerList eventListenerList
            = (EventListenerList) TestHelper.getPrivateField(JComponent.class, node, "listenerList");
        eventListenerList.add(NodeDragListener.class, l);
        node.removeNodeDragListener(l);
        assertTrue("The listener should be removed.", eventListenerList.getListenerCount(NodeDragListener.class) == 0);
    }

    /**
     * Accuracy test for the method <code>fireNodeDrag(LocationEvent)</code> with null <code>event</code>, nothing
     * should happen.
     */
    public void testFireNodeDragWithNullEventAccuracy() {
        MockNodeDragListener l = new MockNodeDragListener();
        node.addNodeDragListener(l);
        node.fireNodeDrag(null);
        assertFalse("The listener should not be fired.", l.isFired());
    }

    /**
     * Accuracy test for the method <code>fireNodeDrag(LocationEvent)</code> with non-null <code>event</code>,
     * listeners should be fired.
     */
    public void testFireNodeDragWithNonNullEventAccuracy() {
        MockNodeDragListener l = new MockNodeDragListener();
        node.addNodeDragListener(l);
        node.fireNodeDrag(new LocationEvent(node, new Point(), new Point()));
        assertTrue("The listener should be fired.", l.isFired());
    }

    /**
     * Accuracy test for the method <code>addCornerDragListener(CornerDragListener)</code> with null
     * <code>listener</code>, nothing should happen.
     */
    public void testAddCornerDragListenerWithNullEventAccuracy() {
        node.addCornerDragListener(null);
        EventListenerList eventListenerList
            = (EventListenerList) TestHelper.getPrivateField(JComponent.class, node, "listenerList");
        assertTrue("No listener should be added.", eventListenerList.getListenerCount(CornerDragListener.class) == 0);
    }

    /**
     * Accuracy test for the method <code>addCornerDragListener(CornerDragListener)</code> with non-null
     * <code>listener</code>, the listener should be added.
     */
    public void testAddCornerDragListenerWithNonNullListenerAccuracy() {
        node.addCornerDragListener(new MockCornerDragListener());
        EventListenerList eventListenerList
            = (EventListenerList) TestHelper.getPrivateField(JComponent.class, node, "listenerList");
        assertTrue("The listener should be added.", eventListenerList.getListenerCount(CornerDragListener.class) == 1);
    }

    /**
     * Accuracy test for the method <code>removeCornerDragListener(CornerDragListener)</code> with null
     * <code>listener</code>, nothing should happen.
     */
    public void testRemoveCornerDragListenerWithNullListenerAccuracy() {
        EventListenerList eventListenerList
            = (EventListenerList) TestHelper.getPrivateField(JComponent.class, node, "listenerList");
        eventListenerList.add(CornerDragListener.class, new MockCornerDragListener());
        node.removeCornerDragListener(null);
        assertTrue("No listener should be removed.", eventListenerList.getListenerCount(CornerDragListener.class) == 1);
    }

    /**
     * Accuracy test for the method <code>removeCornerDragListener(CornerDragListener)</code> with non-null
     * <code>listener</code>, the listener should be removed.
     */
    public void testRemoveCornerDragListenerWithNonNullListenerAccuracy() {
        MockCornerDragListener l = new MockCornerDragListener();
        EventListenerList eventListenerList
            = (EventListenerList) TestHelper.getPrivateField(JComponent.class, node, "listenerList");
        eventListenerList.add(CornerDragListener.class, l);
        node.removeCornerDragListener(l);
        assertTrue("The listener should be removed.",
            eventListenerList.getListenerCount(CornerDragListener.class) == 0);
    }

    /**
     * Accuracy test for the method <code>fireCornerDrag(SelectionBoundEvent)</code> with null <code>event</code>,
     * nothing should happen.
     */
    public void testFireCornerDragWithNullEventAccuracy() {
        MockCornerDragListener l = new MockCornerDragListener();
        node.addCornerDragListener(l);
        node.fireCornerDrag(null);
        assertFalse("The listener should not be fired.", l.isFired());
    }

    /**
     * Accuracy test for the method <code>fireCornerDrag(SelectionBoundEvent)</code> with non-null <code>event</code>,
     * listeners should be fired.
     */
    public void testFireCornerDragWithNonNullEventAccuracy() {
        MockCornerDragListener l = new MockCornerDragListener();
        node.addCornerDragListener(l);
        node.fireCornerDrag(new SelectionBoundEvent(node, new Rectangle(), new Rectangle()));
        assertTrue("The listener should be fired.", l.isFired());
    }
}
