/*
 * Copyright (C) 2007 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.gui.diagramviewer.edges;

import java.awt.Dimension;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.event.MouseEvent;
import java.io.File;
import java.util.List;

import com.topcoder.diagraminterchange.Diagram;
import com.topcoder.diagraminterchange.GraphEdge;
import com.topcoder.diagraminterchange.GraphNode;
import com.topcoder.gui.diagramviewer.DiagramState;
import com.topcoder.gui.diagramviewer.DiagramView;
import com.topcoder.gui.diagramviewer.DiagramViewer;
import com.topcoder.gui.diagramviewer.edges.connectors.RectangleConnector;

import junit.framework.TestCase;
import junit.framework.TestSuite;
import junit.framework.Test;

/**
 * <p>
 * Unit test cases for Edge.
 * </p>
 *
 * @author TCSDEVELOPER
 * @version 1.0
 */
public class EdgeTests extends TestCase {
    /**
     * <p>
     * Edge instance for testing.
     * </p>
     */
    private Edge edge;

    /**
     * <p>
     * GraphEdge instance for helping testing.
     * </p>
     */
    private GraphEdge graphEdge;

    /**
     * <p>
     * LineStyle instance for helping testing.
     * </p>
     */
    private LineStyle lineStyle;

    /**
     * <p>
     * EdgeEnding instance for helping testing.
     * </p>
     */
    private EdgeEnding leftEnding;

    /**
     * <p>
     * EdgeEnding instance for helping testing.
     * </p>
     */
    private EdgeEnding rightEnding;

    /**
     * <p>
     * DiagramViewer instance for helping testing.
     * </p>
     */
    private DiagramViewer diagramViewer;

    /**
     * <p>
     * Setup test environment.
     * </p>
     *
     * @throws Exception to JUnit
     */
    protected void setUp() throws Exception {
        TestHelper.loadXMLConfig("test_files" + File.separator + "DiagramViewer.xml");

        Diagram diagram = new Diagram();
        diagram.setPosition(TestHelper.createDiagramInterchangePoint(0, 0));
        diagram.setSize(TestHelper.createDiagramInterchangeDimension(100, 50));
        graphEdge = new GraphEdge();
        diagram.addContained(graphEdge);
        graphEdge.setContainer(diagram);
        graphEdge.addWaypoint(TestHelper.createDiagramInterchangePoint(100, 100));
        graphEdge.addWaypoint(TestHelper.createDiagramInterchangePoint(200, 200));
        graphEdge.addWaypoint(TestHelper.createDiagramInterchangePoint(300, 400));

        lineStyle = new LineStyle(15, 3);
        leftEnding = new TriangleEdgeEnding();
        rightEnding = new TriangleEdgeEnding();

        edge = new MockEdge(graphEdge, lineStyle, leftEnding, rightEnding);

        diagramViewer = new DiagramViewer("DiagramViewer");
        // BugFix: UML-9432
        // old code
//        diagramViewer.add(edge);
//        diagramViewer.setSize(new Dimension(400, 400));
        DiagramView diagramView = diagramViewer.createDiagramView(diagram);
        diagramView.add(edge);
        diagramView.setSize(new Dimension(400, 400));
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

        graphEdge = null;
        lineStyle = null;
        leftEnding = null;
        rightEnding = null;
        diagramViewer = null;
        edge = null;
    }

    /**
     * <p>
     * Return all tests.
     * </p>
     *
     * @return all tests
     */
    public static Test suite() {
        return new TestSuite(EdgeTests.class);
    }

    /**
     * <p>
     * Tests ctor Edge#Edge(GraphEdge,LineStyle,EdgeEnding,EdgeEnding) for accuracy.
     * </p>
     *
     * <p>
     * Verify : the newly created Edge instance should not be null.
     * </p>
     */
    public void testCtor() {
        assertNotNull("Failed to create a new Edge instance.", edge);
    }

    /**
     * <p>
     * Tests ctor Edge#Edge(GraphEdge,LineStyle,EdgeEnding,EdgeEnding) for failure.
     * </p>
     *
     * <p>
     * It tests the case that when graphEdge is null and expects IllegalArgumentException.
     * </p>
     */
    public void testCtor_NullGraphEdge() {
        try {
            new MockEdge(null, lineStyle, leftEnding, rightEnding);
            fail("IllegalArgumentException expected.");
        } catch (IllegalArgumentException iae) {
            //good
        }
    }

    /**
     * <p>
     * Tests ctor Edge#Edge(GraphEdge,LineStyle,EdgeEnding,EdgeEnding) for failure.
     * </p>
     *
     * <p>
     * It tests the case that when lineStyle is null and expects IllegalArgumentException.
     * </p>
     */
    public void testCtor_NullLineStyle() {
        try {
            new MockEdge(graphEdge, null, leftEnding, rightEnding);
            fail("IllegalArgumentException expected.");
        } catch (IllegalArgumentException iae) {
            //good
        }
    }

    /**
     * <p>
     * Tests ctor Edge#Edge(GraphEdge,LineStyle,EdgeEnding,EdgeEnding) for accuracy.
     * </p>
     *
     * <p>
     * It tests the case that when leftEnding is null and expects success.
     * </p>
     */
    public void testCtor_NullLeftEnding() {
        assertNotNull("Failed to create a new Edge instance with null left ending.", new MockEdge(graphEdge, lineStyle,
            null, rightEnding));
    }

    /**
     * <p>
     * Tests ctor Edge#Edge(GraphEdge,LineStyle,EdgeEnding,EdgeEnding) for accuracy.
     * </p>
     *
     * <p>
     * It tests the case that when rightEnding is null and expects success.
     * </p>
     */
    public void testCtor_NullRightEnding() {
        assertNotNull("Failed to create a new Edge instance with null left ending.", new MockEdge(graphEdge, lineStyle,
            leftEnding, null));
    }

    /**
     * <p>
     * Tests ctor Edge#Edge(GraphEdge,LineStyle,EdgeEnding,EdgeEnding) for failure.
     * </p>
     *
     * <p>
     * It tests the case that when the size of way points for the graph edge
     * is less than two and expects IllegalArgumentException.
     * </p>
     */
    public void testCtor_NotEnoughWayPoints() {
        try {
            graphEdge.removeWaypoint(0);
            graphEdge.removeWaypoint(1);
            new MockEdge(graphEdge, lineStyle, leftEnding, rightEnding);
            fail("IllegalArgumentException expected.");
        } catch (IllegalArgumentException iae) {
            //good
        }
    }

    /**
     * <p>
     * Tests Edge#getWayPoints() for accuracy.
     * </p>
     *
     * <p>
     * Verify : Edge#getWayPoints() is correct.
     * </p>
     */
    public void testGetWayPoints() {
        List<SelectionCorner> corners = edge.getWayPoints();

        assertEquals("Failed to get the correct size of selection corners.", 3, corners.size());
        assertEquals("Failed to set the first selection corner center.", new Point(100, 100),
            corners.get(0).getCenter());
        assertEquals("Failed to set the second selection corner center.", new Point(200, 200),
            corners.get(1).getCenter());
        assertEquals("Failed to set the third selection corner center.", new Point(300, 400),
            corners.get(2).getCenter());
    }

    /**
     * <p>
     * Tests Edge#getDiagramViewer() for accuracy.
     * </p>
     *
     * <p>
     * Verify : Edge#getDiagramViewer() is correct.
     * </p>
     */
    public void testGetDiagramViewer() {
        assertSame("Failed to get the diagram viewer.", diagramViewer, edge.getDiagramViewer());
    }

    /**
     * <p>
     * Tests Edge#getGraphEdge() for accuracy.
     * </p>
     *
     * <p>
     * Verify : Edge#getGraphEdge() is correct.
     * </p>
     */
    public void testGetGraphEdge() {
        assertSame("Failed to get the graph edge.", graphEdge, edge.getGraphEdge());
    }

    /**
     * <p>
     * Tests Edge#notifyUnselected() for accuracy.
     * </p>
     *
     * <p>
     * Verify : Edge#notifyUnselected() is correct.
     * </p>
     */
    public void testNotifyUnselected() {
        /*
         * BugFix: BUGID UML-7684
         * Description:
         * The stereotype and edge name for edges should be shown at all times, not just when the edge is selected.
         * Solution:
         * Remove the code to assert text fields invisible, since they're always visible.
         */
        // old code
//        TextField textField1 = edge.addTextField(new GraphNode(), "text1", AnchorType.LeftEnding);
//        TextField textField2 = edge.addTextField(new GraphNode(), "text2", AnchorType.RightEnding);
//        TextField textField3 = edge.addTextField(new GraphNode(), "text3", AnchorType.Line);

        edge.notifyUnselected();

        // old code
//        assertFalse("The text fields should be hidden.", textField1.isVisible());
//        assertFalse("The text fields should be hidden.", textField2.isVisible());
//        assertFalse("The text fields should be hidden.", textField3.isVisible());

        for (SelectionCorner corner : edge.getWayPoints()) {
            assertFalse("The section corner should be hidden.", corner.isVisible());
        }
    }

    /**
     * <p>
     * Tests Edge#notifyRemoveWayPoint(int,Point) for accuracy.
     * </p>
     *
     * <p>
     * Verify : Edge#notifyRemoveWayPoint(int,Point) is correct.
     * </p>
     */
    public void testNotifyRemoveWayPoint() {
        graphEdge.removeWaypoint(0);

        edge.notifyRemoveWayPoint(0, new Point(100, 100));

        // verify the election corner should be removed
        assertEquals("Failed to remove the selection corner.", 2, edge.getWayPoints().size());
        SelectionCorner corner = edge.getWayPoints().get(0);
        assertEquals("Failed to remove the selection corner.", new Point(200, 200), corner.getCenter());
    }

    /**
     * <p>
     * Tests Edge#notifyRemoveWayPoint(int,Point) for failure.
     * </p>
     *
     * <p>
     * It tests the case that when index is negative and expects IndexOutOfBoundsException.
     * </p>
     */
    public void testNotifyRemoveWayPoint_NegativeIndex() {
        try {
            edge.notifyRemoveWayPoint(-8, new Point(100, 300));
            fail("IndexOutOfBoundsException expected.");
        } catch (IndexOutOfBoundsException e) {
            //good
        }
    }

    /**
     * <p>
     * Tests Edge#notifyRemoveWayPoint(int,Point) for failure.
     * </p>
     *
     * <p>
     * It tests the case that when index is larger than the size and expects IndexOutOfBoundsException.
     * </p>
     */
    public void testNotifyRemoveWayPoint_TooLargeIndex() {
        try {
            edge.notifyRemoveWayPoint(8, new Point(100, 300));
            fail("IndexOutOfBoundsException expected.");
        } catch (IndexOutOfBoundsException e) {
            //good
        }
    }

    /**
     * <p>
     * Tests Edge#notifyRemoveWayPoint(int,Point) for failure.
     * </p>
     *
     * <p>
     * It tests the case that when removedPoint is null and expects IllegalArgumentException.
     * </p>
     */
    public void testNotifyRemoveWayPoint_NullRemovedPoint() {
        try {
            edge.notifyRemoveWayPoint(0, null);
            fail("IllegalArgumentException expected.");
        } catch (IllegalArgumentException iae) {
            //good
        }
    }

    /**
     * <p>
     * Tests Edge#removeTextField(GraphNode) for accuracy.
     * </p>
     *
     * <p>
     * Verify : Edge#removeTextField(GraphNode) is correct.
     * </p>
     */
    public void testRemoveTextField() {
        GraphNode node = new GraphNode();
        edge.addTextField(node, "Hello", AnchorType.LeftEnding);

        edge.removeTextField(node);

        assertNull("Failed to remove the text field.", edge.getTextField(node));
    }

    /**
     * <p>
     * Tests Edge#removeTextField(GraphNode) for failure.
     * </p>
     *
     * <p>
     * It tests the case that when graphNode is null and expects IllegalArgumentException.
     * </p>
     */
    public void testRemoveTextField_NullGraphNode() {
        try {
            edge.removeTextField(null);
            fail("IllegalArgumentException expected.");
        } catch (IllegalArgumentException iae) {
            //good
        }
    }

    /**
     * <p>
     * Tests Edge#notifyAddWayPoint(int) for accuracy.
     * </p>
     *
     * <p>
     * Verify : Edge#notifyAddWayPoint(int) is correct.
     * </p>
     */
    public void testNotifyAddWayPoint() {
        graphEdge.addWaypoint(0, TestHelper.createDiagramInterchangePoint(50, 50));

        edge.notifyAddWayPoint(0);

        // verify the election corner should be added
        assertEquals("Failed to add the selection corner.", 4, edge.getWayPoints().size());
        SelectionCorner corner = edge.getWayPoints().get(0);
        assertEquals("Failed to add the selection corner.", new Point(50, 50), corner.getCenter());
    }

    /**
     * <p>
     * Tests Edge#notifyAddWayPoint(int) for failure.
     * </p>
     *
     * <p>
     * It tests the case when the index is negative and expects IndexOutOfBoundsException.
     * </p>
     */
    public void testNotifyAddWayPoint_NegativeIndex() {
        try {
            edge.notifyAddWayPoint(-98);
            fail("IndexOutOfBoundsException expected.");
        } catch (IndexOutOfBoundsException e) {
            //good
        }
    }

    /**
     * <p>
     * Tests Edge#notifyAddWayPoint(int) for failure.
     * </p>
     *
     * <p>
     * It tests the case when the index is larger than the size and expects IndexOutOfBoundsException.
     * </p>
     */
    public void testNotifyAddWayPoint_TooLargeIndex() {
        try {
            edge.notifyAddWayPoint(54);
            fail("IndexOutOfBoundsException expected.");
        } catch (IndexOutOfBoundsException e) {
            //good
        }
    }

    /**
     * <p>
     * Tests Edge#notifyChangeWayPoint(int,Point) for accuracy.
     * </p>
     *
     * <p>
     * Verify : Edge#notifyChangeWayPoint(int,Point) is correct.
     * </p>
     */
    public void testNotifyChangeWayPoint() {
        graphEdge.getWaypoints().get(0).setX(50);
        graphEdge.getWaypoints().get(0).setY(50);

        edge.notifyChangeWayPoint(0, new Point(100, 100));

        // verify the election corner should be updated
        SelectionCorner corner = edge.getWayPoints().get(0);

        assertEquals("Failed to update the selection corner.", new Point(50, 50), corner.getCenter());
    }

    /**
     * <p>
     * Tests Edge#notifyChangeWayPoint(int,Point) for failure.
     * </p>
     *
     * <p>
     * It tests the case that when index is negative and expects IndexOutOfBoundsException.
     * </p>
     */
    public void testNotifyChangeWayPoint_NegativeIndex() {
        try {
            edge.notifyChangeWayPoint(-76, new Point(134, 234));
            fail("IndexOutOfBoundsException expected.");
        } catch (IndexOutOfBoundsException e) {
            //good
        }
    }

    /**
     * <p>
     * Tests Edge#notifyChangeWayPoint(int,Point) for failure.
     * </p>
     *
     * <p>
     * It tests the case that when index is too large and expects IndexOutOfBoundsException.
     * </p>
     */
    public void testNotifyChangeWayPoint_TooLargeIndex() {
        try {
            edge.notifyChangeWayPoint(76, new Point(134, 234));
            fail("IndexOutOfBoundsException expected.");
        } catch (IndexOutOfBoundsException e) {
            //good
        }
    }

    /**
     * <p>
     * Tests Edge#notifyChangeWayPoint(int,Point) for failure.
     * </p>
     *
     * <p>
     * It tests the case that when oldPoint is null and expects IllegalArgumentException.
     * </p>
     */
    public void testNotifyChangeWayPoint_NullOldPoint() {
        try {
            edge.notifyChangeWayPoint(0, null);
            fail("IllegalArgumentException expected.");
        } catch (IllegalArgumentException iae) {
            //good
        }
    }

    /**
     * <p>
     * Tests Edge#addTextField(GraphNode,String,AnchorType) for accuracy.
     * </p>
     *
     * <p>
     * Verify : Edge#addTextField(GraphNode,String,AnchorType) is correct.
     * </p>
     */
    public void testAddTextField() {
        GraphNode node = new GraphNode();

        TextField textField = edge.addTextField(node, "Hello", AnchorType.LeftEnding);

        assertSame("Failed to add the text field.", textField, edge.getTextField(node));
    }

    /**
     * <p>
     * Tests Edge#addTextField(GraphNode,String,AnchorType) for failure.
     * </p>
     *
     * <p>
     * It tests the case that when graphNode is null and expects IllegalArgumentException.
     * </p>
     */
    public void testAddTextField_NullGraphNode() {
        try {
            edge.addTextField(null, "Hello", AnchorType.Line);
            fail("IllegalArgumentException expected.");
        } catch (IllegalArgumentException iae) {
            //good
        }
    }

    /**
     * <p>
     * Tests Edge#addTextField(GraphNode,String,AnchorType) for failure.
     * </p>
     *
     * <p>
     * It tests the case that when text is null and expects IllegalArgumentException.
     * </p>
     */
    public void testAddTextField_NullText() {
        try {
            edge.addTextField(new GraphNode(), null, AnchorType.Line);
            fail("IllegalArgumentException expected.");
        } catch (IllegalArgumentException iae) {
            //good
        }
    }

    /**
     * <p>
     * Tests Edge#addTextField(GraphNode,String,AnchorType) for failure.
     * </p>
     *
     * <p>
     * It tests the case that when type is null and expects IllegalArgumentException.
     * </p>
     */
    public void testAddTextField_NullType() {
        try {
            edge.addTextField(new GraphNode(), "Hello", null);
            fail("IllegalArgumentException expected.");
        } catch (IllegalArgumentException iae) {
            //good
        }
    }

    /**
     * <p>
     * Tests Edge#getTextField(GraphNode) for accuracy.
     * </p>
     *
     * <p>
     * Verify : Edge#getTextField(GraphNode) is correct.
     * </p>
     */
    public void testGetTextField() {
        GraphNode node = new GraphNode();
        TextField textField = edge.addTextField(node, "Hello", AnchorType.LeftEnding);

        assertSame("Failed to get the text field.", textField, edge.getTextField(node));

        assertNull("If the text field is not found, null should be returned.", edge.getTextField(new GraphNode()));
    }

    /**
     * <p>
     * Tests Edge#getTextField(GraphNode) for failure.
     * </p>
     *
     * <p>
     * It tests the case that when graphNode is null and expects IllegalArgumentException.
     * </p>
     */
    public void testGetTextField_NullGraphNode() {
        try {
            edge.getTextField(null);
            fail("IllegalArgumentException expected.");
        } catch (IllegalArgumentException iae) {
            //good
        }
    }

    /**
     * <p>
     * Tests Edge#isShowTextFields() for accuracy.
     * </p>
     *
     * <p>
     * Verify : Edge#isShowTextFields() is correct.
     * </p>
     */
    public void testIsShowTextFields() {
        assertFalse("The default value for show text fields should be false.", edge.isShowTextFields());
    }

    /**
     * <p>
     * Tests Edge#setShowTextFields(boolean) for accuracy.
     * </p>
     *
     * <p>
     * Verify : Edge#setShowTextFields(boolean) is correct.
     * </p>
     */
    public void testSetShowTextFields() {
        edge.setShowTextFields(true);

        assertTrue("Failed to set flag of showing text fields to true.", edge.isShowTextFields());
    }

    /**
     * <p>
     * Tests Edge#getActiveWidth() for accuracy.
     * </p>
     *
     * <p>
     * Verify : Edge#getActiveWidth() is correct.
     * </p>
     */
    public void testGetActiveWidth() {
        assertEquals("Failed to get the default active width.", Edge.DEFAULT_ACTIVE_WIDTH, edge.getActiveWidth());
    }

    /**
     * <p>
     * Tests Edge#setActiveWidth(int) for accuracy.
     * </p>
     *
     * <p>
     * Verify : Edge#setActiveWidth(int) is correct.
     * </p>
     */
    public void testSetActiveWidth() {
        edge.setActiveWidth(18);

        assertEquals("Failed to set the active width.", 18, edge.getActiveWidth());
    }

    /**
     * <p>
     * Tests Edge#setActiveWidth(int) for failure.
     * </p>
     *
     * <p>
     * It tests the case when the active width is zero and expects IllegalArgumentException.
     * </p>
     */
    public void testSetActiveWidth_ZeroActiveWidth() {
        try {
            edge.setActiveWidth(0);
            fail("IllegalArgumentException expected.");
        } catch (IllegalArgumentException iae) {
            //good
        }
    }

    /**
     * <p>
     * Tests Edge#setActiveWidth(int) for failure.
     * </p>
     *
     * <p>
     * It tests the case when the active width is negative and expects IllegalArgumentException.
     * </p>
     */
    public void testSetActiveWidth_NegativeActiveWidth() {
        try {
            edge.setActiveWidth(-87);
            fail("IllegalArgumentException expected.");
        } catch (IllegalArgumentException iae) {
            //good
        }
    }

    /**
     * <p>
     * Tests Edge#getAlignDeviation() for accuracy.
     * </p>
     *
     * <p>
     * Verify : Edge#getAlignDeviation() is correct.
     * </p>
     */
    public void testGetAlignDeviation() {
        assertEquals("Failed to get the default align deviation.", Edge.DEFAULT_ALIGN_DEVIATION,
            edge.getAlignDeviation());
    }

    /**
     * <p>
     * Tests Edge#setAlignDeviation(double) for accuracy.
     * </p>
     *
     * <p>
     * Verify : Edge#setAlignDeviation(double) is correct.
     * </p>
     */
    public void testSetAlignDeviation() {
        double value = 13;
        edge.setAlignDeviation(value);

        assertEquals("Failed to set the align deviation.", value, edge.getAlignDeviation());
    }

    /**
     * <p>
     * Tests Edge#setAlignDeviation(double) for failure.
     * </p>
     *
     * <p>
     * It tests the case when the align deviation is zero and expects IllegalArgumentException.
     * </p>
     */
    public void testSetAlignDeviation_ZeroIndex() {
        try {
            edge.setActiveWidth(0);
            fail("IllegalArgumentException expected.");
        } catch (IllegalArgumentException iae) {
            //good
        }
    }

    /**
     * <p>
     * Tests Edge#setAlignDeviation(double) for failure.
     * </p>
     *
     * <p>
     * It tests the case when the align deviation is negative and expects IllegalArgumentException.
     * </p>
     */
    public void testSetAlignDeviation_NegativeIndex() {
        try {
            edge.setActiveWidth(-98);
            fail("IllegalArgumentException expected.");
        } catch (IllegalArgumentException iae) {
            //good
        }
    }

    /**
     * <p>
     * Tests Edge#getLineStyle() for accuracy.
     * </p>
     *
     * <p>
     * Verify : Edge#getLineStyle() is correct.
     * </p>
     */
    public void testGetLineStyle() {
        assertSame("Failed to get the line style.", lineStyle, edge.getLineStyle());
    }

    /**
     * <p>
     * Tests Edge#getLeftEnding() for accuracy.
     * </p>
     *
     * <p>
     * Verify : Edge#getLeftEnding() is correct.
     * </p>
     */
    public void testGetLeftEnding() {
        assertSame("Failed to get the left ending.", leftEnding, edge.getLeftEnding());
    }

    /**
     * <p>
     * Tests Edge#getRightEnding() for accuracy.
     * </p>
     *
     * <p>
     * Verify : Edge#getRightEnding() is correct.
     * </p>
     */
    public void testGetRightEnding() {
        assertSame("Failed to get the right ending.", rightEnding, edge.getRightEnding());
    }

    /**
     * <p>
     * Tests Edge#passEventBehind(MouseEvent) for accuracy.
     * </p>
     *
     * <p>
     * Verify : Edge#passEventBehind(MouseEvent) is correct.
     * </p>
     */
    public void testPassEventBehind() {
        MouseEvent event = new MouseEvent(edge, MouseEvent.MOUSE_PRESSED, System.currentTimeMillis(),
            MouseEvent.BUTTON1_MASK, 5, 15, 1, false);

        edge.passEventBehind(event);
    }

    /**
     * <p>
     * Tests Edge#processMouseEvent(MouseEvent) for accuracy.
     * </p>
     *
     * <p>
     * Verify : Edge#processMouseEvent(MouseEvent) is correct.
     * </p>
     */
    public void testProcessMouseEvent() {
        MouseEvent event = new MouseEvent(edge, MouseEvent.MOUSE_PRESSED, System.currentTimeMillis(),
            MouseEvent.BUTTON1_MASK, 5, 15, 1, false);

        // the diagram viewer is in state of adding element
        diagramViewer.setNewElementType(Edge.class);
        diagramViewer.setState(DiagramState.ADD_ELEMENT_BY_CLICK);
        edge.processMouseEvent(event);

        // the diagram viewer is not in state of adding element
        diagramViewer.setState(DiagramState.SELECT_ELEMENT);
        // the mouse event will be handled normally
        edge.processMouseEvent(event);
    }

    /**
     * <p>
     * Tests Edge#processMouseEvent(MouseEvent) for accuracy.
     * </p>
     *
     * <p>
     * It tests the case that when e is null and expects no exception.
     * </p>
     */
    public void testProcessMouseEvent_NullE() {
        edge.processMouseEvent(null);
    }

    /**
     * <p>
     * Tests Edge#processMouseMotionEvent(MouseEvent) for accuracy.
     * </p>
     *
     * <p>
     * Verify : Edge#processMouseMotionEvent(MouseEvent) is correct.
     * </p>
     */
    public void testProcessMouseMotionEvent() {
        MouseEvent event = new MouseEvent(edge, MouseEvent.MOUSE_DRAGGED, System.currentTimeMillis(),
            MouseEvent.BUTTON1_MASK, 5, 15, 1, false);

        // the diagram viewer is in state of adding element
        diagramViewer.setNewElementType(Edge.class);
        diagramViewer.setState(DiagramState.ADD_ELEMENT_BY_CLICK);
        edge.processMouseMotionEvent(event);

        // the diagram viewer is not in state of adding element
        // the mouse event will be handled normally
        diagramViewer.setState(DiagramState.SELECT_ELEMENT);
        // we don't sent the old position, so it should be null
        // and IAE should be thrown
        try {
            edge.processMouseMotionEvent(event);
            fail("NullPointerException expected.");
        } catch (NullPointerException e) {
            // good
        }
    }

    /**
     * <p>
     * Tests Edge#processMouseMotionEvent(MouseEvent) for accuracy.
     * </p>
     *
     * <p>
     * It tests the case that when e is null and expects no exception.
     * </p>
     */
    public void testProcessMouseMotionEvent_NullE() {
        edge.processMouseMotionEvent(null);
    }

    /**
     * <p>
     * Tests Edge#addWayPointDragListener(WayPointListener) for accuracy.
     * </p>
     *
     * <p>
     * Verify : Edge#addWayPointDragListener(WayPointListener) is correct.
     * </p>
     */
    public void testAddWayPointDragListener() {
        WayPointListener listener = new SimpleWayPointListener();

        edge.addWayPointDragListener(listener);

        // verify the listener should be added.
        WayPointListener[] listeners = edge.getListeners(WayPointListener.class);
        assertEquals("Failed to add the way point listener.", 1, listeners.length);
        assertEquals("Failed to add the way point listener.", listener, listeners[0]);
    }

    /**
     * <p>
     * Tests Edge#addWayPointDragListener(WayPointListener) for accuracy.
     * </p>
     *
     * <p>
     * It tests the case that when listener is null and expects no exception.
     * </p>
     */
    public void testAddWayPointDragListener_NullListener() {
        edge.addWayPointDragListener(null);
    }

    /**
     * <p>
     * Tests Edge#removeWayPointDragListener(WayPointListener) for accuracy.
     * </p>
     *
     * <p>
     * Verify : Edge#removeWayPointDragListener(WayPointListener) is correct.
     * </p>
     */
    public void testRemoveWayPointDragListener() {
        WayPointListener listener = new SimpleWayPointListener();
        edge.addWayPointDragListener(listener);

        edge.removeWayPointDragListener(listener);

        // verify the listener should be removed.
        WayPointListener[] listeners = edge.getListeners(WayPointListener.class);
        assertEquals("Failed to remove the way point listener.", 0, listeners.length);
    }

    /**
     * <p>
     * Tests Edge#removeWayPointDragListener(WayPointListener) for accuracy.
     * </p>
     *
     * <p>
     * It tests the case that when listener is null and expects no exception.
     * </p>
     */
    public void testRemoveWayPointDragListener_NullListener() {
        edge.removeWayPointDragListener(null);
    }

    /**
     * <p>
     * Tests Edge#addEdgeDragListener(EdgeDragListener) for accuracy.
     * </p>
     *
     * <p>
     * Verify : Edge#addEdgeDragListener(EdgeDragListener) is correct.
     * </p>
     */
    public void testAddEdgeDragListener() {
        EdgeDragListener listener = new SimpleEdgeDragListener();

        edge.addEdgeDragListener(listener);

        // verify the listener should be added.
        EdgeDragListener[] listeners = edge.getListeners(EdgeDragListener.class);
        assertEquals("Failed to add the edge drag listener.", 1, listeners.length);
        assertEquals("Failed to add the edge drag listener.", listener, listeners[0]);
    }

    /**
     * <p>
     * Tests Edge#addEdgeDragListener(EdgeDragListener) for accuracy.
     * </p>
     *
     * <p>
     * It tests the case that when listener is null and expects no exception.
     * </p>
     */
    public void testAddEdgeDragListener_NullListener() {
        edge.addEdgeDragListener(null);
    }

    /**
     * <p>
     * Tests Edge#removeEdgeDragListener(EdgeDragListener) for accuracy.
     * </p>
     *
     * <p>
     * Verify : Edge#removeEdgeDragListener(EdgeDragListener) is correct.
     * </p>
     */
    public void testRemoveEdgeDragListener() {
        EdgeDragListener listener = new SimpleEdgeDragListener();
        edge.addEdgeDragListener(listener);

        edge.removeEdgeDragListener(listener);

        // verify the listener should be removed.
        EdgeDragListener[] listeners = edge.getListeners(EdgeDragListener.class);
        assertEquals("Failed to remove the edge drag listener.", 0, listeners.length);
    }

    /**
     * <p>
     * Tests Edge#removeEdgeDragListener(EdgeDragListener) for accuracy.
     * </p>
     *
     * <p>
     * It tests the case that when listener is null and expects no exception.
     * </p>
     */
    public void testRemoveEdgeDragListener_NullListener() {
        edge.removeEdgeDragListener(null);
    }

    /**
     * <p>
     * Tests Edge#fireEdgeDrag(WayPointEvent) for accuracy.
     * </p>
     *
     * <p>
     * Verify : Edge#fireEdgeDrag(WayPointEvent) is correct.
     * </p>
     */
    public void testFireEdgeDrag() {
        SimpleEdgeDragListener listener = new SimpleEdgeDragListener();
        edge.addEdgeDragListener(listener);

        WayPointEvent event = new WayPointEvent(edge, 0, new Point(100, 100));
        edge.fireEdgeDrag(event);

        assertSame("The event should be sent.", event, listener.getLastEvent());
    }

    /**
     * <p>
     * Tests Edge#fireEdgeDrag(WayPointEvent) for accuracy.
     * </p>
     *
     * <p>
     * It tests the case that when event is null and expects no exception.
     * </p>
     */
    public void testFireEdgeDrag_NullEvent() {
        edge.fireEdgeDrag(null);
    }

    /**
     * <p>
     * Tests Edge#fireWayPointDrag(WayPointEvent) for accuracy.
     * </p>
     *
     * <p>
     * Verify : Edge#fireWayPointDrag(WayPointEvent) is correct.
     * </p>
     */
    public void testFireWayPointDrag() {
        SimpleWayPointListener listener = new SimpleWayPointListener();
        edge.addWayPointDragListener(listener);

        WayPointEvent event = new WayPointEvent(edge, 0, new Point(100, 100));
        edge.fireWayPointDrag(event);

        assertSame("The event should be sent.", event, listener.getLastEvent());
    }

    /**
     * <p>
     * Tests Edge#fireWayPointDrag(WayPointEvent) for accuracy.
     * </p>
     *
     * <p>
     * It tests the case that when event is null and expects no exception.
     * </p>
     */
    public void testFireWayPointDrag_NullEvent() {
        edge.fireWayPointDrag(null);
    }

    /**
     * <p>
     * Tests Edge#getLeftConnector() for accuracy.
     * </p>
     *
     * <p>
     * Verify : Edge#getLeftConnector() is correct.
     * </p>
     */
    public void testGetLeftConnector() {
        assertNull("Failed to get the left connector.", edge.getLeftConnector());
    }

    /**
     * <p>
     * Tests Edge#setLeftConnector(Connector) for accuracy.
     * </p>
     *
     * <p>
     * Verify : Edge#setLeftConnector(Connector) is correct.
     * </p>
     */
    public void testSetLeftConnector() {
        Connector connector = new RectangleConnector(new Rectangle(19, 23, 54, 24));

        edge.setLeftConnector(connector);

        assertSame("Failed to set the left connector.", connector, edge.getLeftConnector());
    }

    /**
     * <p>
     * Tests Edge#setLeftConnector(Connector) for accuracy.
     * </p>
     *
     * <p>
     * It tests the case that when connector is null and expects success.
     * </p>
     */
    public void testSetLeftConnector_NullConnector() {
        edge.setLeftConnector(null);
        assertNull("Failed to get the left connector.", edge.getLeftConnector());
    }

    /**
     * <p>
     * Tests Edge#getRightConnector() for accuracy.
     * </p>
     *
     * <p>
     * Verify : Edge#getRightConnector() is correct.
     * </p>
     */
    public void testGetRightConnector() {
        assertNull("Failed to get the right connector.", edge.getRightConnector());
    }

    /**
     * <p>
     * Tests Edge#setRightConnector(Connector) for accuracy.
     * </p>
     *
     * <p>
     * Verify : Edge#setRightConnector(Connector) is correct.
     * </p>
     */
    public void testSetRightConnector() {
        Connector connector = new RectangleConnector(new Rectangle(19, 23, 54, 24));

        edge.setRightConnector(connector);

        assertSame("Failed to set the right connector.", connector, edge.getRightConnector());
    }

    /**
     * <p>
     * Tests Edge#setRightConnector(Connector) for accuracy.
     * </p>
     *
     * <p>
     * It tests the case that when connector is null and expects success.
     * </p>
     */
    public void testSetRightConnector_NullConnector() {
        edge.setRightConnector(null);
        assertNull("Failed to get the right connector.", edge.getRightConnector());
    }

    /**
     * <p>
     * Tests Edge#contains(int,int) for accuracy.
     * </p>
     *
     * <p>
     * It tests the case when the given point is in the active width of the edge and expects true.
     * </p>
     */
    public void testContainsForTrue() {
        assertTrue("The point should be in the active width of the edge.", edge.contains(101, 103));
    }

    /**
     * <p>
     * Tests Edge#contains(int,int) for accuracy.
     * </p>
     *
     * <p>
     * It tests the case when the given point is not in the active width of the edge and expects false.
     * </p>
     */
    public void testContainsForFalse() {
        assertFalse("The point should not be in the active width of the edge.", edge.contains(150, 110));
    }

    /**
     * <p>
     * Tests Edge#getSize() for accuracy.
     * </p>
     *
     * <p>
     * Verify : Edge#getSize() is correct.
     * </p>
     */
    public void testGetSize() {
        assertEquals("Failed to get the size of the edge.", new Dimension(400, 400), edge.getSize());
    }

    /**
     * <p>
     * Tests Edge#setBounds(int,int,int,int) for accuracy.
     * </p>
     *
     * <p>
     * Verify : Edge#setBounds(int,int,int,int) is correct.
     * </p>
     */
    public void testSetBounds() {
        edge.setBounds(0, 0, 500, 500);

        assertEquals("Failed to get the bounds of the edge.", new Rectangle(0, 0, 500, 500), edge.getBounds());
    }

    /**
     * <p>
     * Tests Edge#setBounds(int,int,int,int) for failure.
     * </p>
     *
     * <p>
     * It tests the case when the x is non-zero and expects IllegalArgumentException.
     * </p>
     */
    public void testSetBounds_NonZeroX() {
        try {
            edge.setBounds(6, 0, 500, 500);
            fail("IllegalArgumentException expected.");
        } catch (IllegalArgumentException iae) {
            //good
        }
    }

    /**
     * <p>
     * Tests Edge#setBounds(int,int,int,int) for failure.
     * </p>
     *
     * <p>
     * It tests the case when the y is non-zero and expects IllegalArgumentException.
     * </p>
     */
    public void testSetBounds_NonZeroY() {
        try {
            edge.setBounds(0, 5, 500, 500);
            fail("IllegalArgumentException expected.");
        } catch (IllegalArgumentException iae) {
            //good
        }
    }

    /**
     * <p>
     * Tests Edge#setBounds(int,int,int,int) for failure.
     * </p>
     *
     * <p>
     * It tests the case when the width is negative and expects IllegalArgumentException.
     * </p>
     */
    public void testSetBounds_NegativeWidth() {
        try {
            edge.setBounds(0, 0, -500, 500);
            fail("IllegalArgumentException expected.");
        } catch (IllegalArgumentException iae) {
            //good
        }
    }

    /**
     * <p>
     * Tests Edge#setBounds(int,int,int,int) for failure.
     * </p>
     *
     * <p>
     * It tests the case when the width is zero and expects IllegalArgumentException.
     * </p>
     */
    public void testSetBounds_ZeroWidth() {
        try {
            edge.setBounds(0, 0, 0, 500);
            fail("IllegalArgumentException expected.");
        } catch (IllegalArgumentException iae) {
            //good
        }
    }

    /**
     * <p>
     * Tests Edge#setBounds(int,int,int,int) for failure.
     * </p>
     *
     * <p>
     * It tests the case when the height is negative and expects IllegalArgumentException.
     * </p>
     */
    public void testSetBounds_NegativeHeight() {
        try {
            edge.setBounds(0, 0, 500, -500);
            fail("IllegalArgumentException expected.");
        } catch (IllegalArgumentException iae) {
            //good
        }
    }

    /**
     * <p>
     * Tests Edge#setBounds(int,int,int,int) for failure.
     * </p>
     *
     * <p>
     * It tests the case when the height is zero and expects IllegalArgumentException.
     * </p>
     */
    public void testSetBounds_ZeroHeight() {
        try {
            edge.setBounds(0, 0, 500, 0);
            fail("IllegalArgumentException expected.");
        } catch (IllegalArgumentException iae) {
            //good
        }
    }

    /**
     * <p>
     * Tests Edge#setLocation(int,int) for accuracy.
     * </p>
     *
     * <p>
     * Verify : Edge#setLocation(int,int) is correct.
     * </p>
     */
    public void testSetLocation() {
        edge.setBounds(0, 0, 300, 300);
        edge.setLocation(0, 0);

        assertEquals("Failed to set the location.", new Point(0, 0), edge.getLocation());
    }

    /**
     * <p>
     * Tests Edge#setLocation(int,int) for failure.
     * </p>
     *
     * <p>
     * It tests the case when the x is non-zero and expects IllegalArgumentException.
     * </p>
     */
    public void testSetLocation_NonZeroX() {
        try {
            edge.setLocation(8, 0);
            fail("IllegalArgumentException expected.");
        } catch (IllegalArgumentException iae) {
            //good
        }
    }

    /**
     * <p>
     * Tests Edge#setLocation(int,int) for failure.
     * </p>
     *
     * <p>
     * It tests the case when the y is non-zero and expects IllegalArgumentException.
     * </p>
     */
    public void testSetLocation_NonZeroY() {
        try {
            edge.setLocation(0, 10);
            fail("IllegalArgumentException expected.");
        } catch (IllegalArgumentException iae) {
            //good
        }
    }

    /**
     * <p>
     * This class extends Edge class and is used for testing.
     * </p>
     *
     * @author TCSDEVELOPER
     * @version 1.0
     */
    public class MockEdge extends Edge {
        /**
         * <p>
         * Create a MockEdge instance.
         * </p>
         *
         * @param graphEdge the associated graphEdge
         * @param lineStyle the line style of this edge
         * @param leftEnding the left ending of this edge
         * @param rightEnding the right ending of this edge.
         *
         * @throws IllegalArgumentException if graphEdge or lineStyle is null.
         */
        protected MockEdge(GraphEdge graphEdge, LineStyle lineStyle, EdgeEnding leftEnding, EdgeEnding rightEnding) {
            super(graphEdge, lineStyle, leftEnding, rightEnding);
        }

        /**
         * <p>
         * Return false all the time and it is only used for helping testing.
         * </p>
         *
         * @param event the mouse event
         *
         * @return false
         */
        protected boolean consumeEvent(MouseEvent event) {
            return false;
        }
    }
}