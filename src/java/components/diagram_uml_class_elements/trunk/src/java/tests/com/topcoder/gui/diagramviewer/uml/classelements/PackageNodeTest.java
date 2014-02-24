/*
 * Copyright (C) 2007 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.gui.diagramviewer.uml.classelements;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Point;
import java.awt.Rectangle;
import java.util.Map;

import javax.swing.JComponent;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.TransferHandler;

import junit.extensions.jfcunit.JFCTestCase;
import junit.extensions.jfcunit.JFCTestHelper;
import junit.extensions.jfcunit.TestHelper;
import junit.extensions.jfcunit.eventdata.MouseEventData;
import junit.extensions.jfcunit.finder.NamedComponentFinder;

import com.topcoder.diagraminterchange.GraphNode;
import com.topcoder.gui.diagramviewer.DiagramViewer;
import com.topcoder.gui.diagramviewer.uml.classelements.event.BoundaryChangedEvent;
import com.topcoder.gui.diagramviewer.uml.classelements.event.BoundaryChangedListener;
import com.topcoder.gui.diagramviewer.uml.classelements.event.EdgeAddEvent;
import com.topcoder.gui.diagramviewer.uml.classelements.event.EdgeAddListener;
import com.topcoder.gui.diagramviewer.uml.classelements.event.NodeAddEvent;
import com.topcoder.gui.diagramviewer.uml.classelements.event.NodeAddListener;
import com.topcoder.gui.diagramviewer.uml.classelements.event.TextChangedEvent;
import com.topcoder.gui.diagramviewer.uml.classelements.event.TextChangedListener;

/**
 * <p>
 * Test the functionality of <code>PackageNode</code> class.
 * </p>
 * @author TCSDEVELOPER
 * @version 1.0
 */
public class PackageNodeTest extends JFCTestCase {

    /** The absolute position of the visual node. Used for testing only. */
    private static final Point POSITION = new Point(100, 80);

    /** The size of the visual node. Used for testing only. */
    private static final Dimension SIZE = new Dimension(80, 80);

    /** An instance of <code>PackageNode</code> for testing. */
    private PackageNode packageNode;

    /** A GraphNode for <code>PackageNode</code>. */
    private GraphNode graphNode;

    /** Properties for testing. */
    private Map<String, String> properties;

    /** TransferHandler for testing. */
    private TransferHandler handler;

    /** Boundary changed listener for <code>PackageNode</code>. */
    private MockedBoundaryChangedListener boundChangedListener;

    /** Edge add listener for <code>PackageNode</code>. */
    private MockedEdgeAddListener edgeAddListener;

    /** Node add listener for <code>PackageNode</code>. */
    private MockedNodeAddListener nodeAddListener;

    /** An instance of JFC <code>TestHelper</code> for testing. */
    private TestHelper helper = null;

    /**
     * <p>
     * Sets up the test environment. The test instance is created.
     * </p>
     * @throws Exception
     *             to junit
     */
    protected void setUp() throws Exception {
        super.setUp();

        helper = new JFCTestHelper();

        graphNode = TestUtil.createPackageGraphNode(POSITION, SIZE);
        graphNode.setContainer(new GraphNode());

        properties = TestUtil.createProperties();
        handler = new TransferHandler(null);

        packageNode = new PackageNode(graphNode, properties, handler);

        GraphNode classGraphNode = TestUtil.createClassGraphNode(new Point(120, 180), SIZE, false, false);
        ClassNode classNode = new ClassNode(classGraphNode, properties);
        packageNode.addNode(classNode);
        packageNode.notifyGraphNodeChange("ClassNode added.");

        boundChangedListener = new MockedBoundaryChangedListener();
        edgeAddListener = new MockedEdgeAddListener();
        nodeAddListener = new MockedNodeAddListener();
    }

    /**
     * Test method for 'PackageNode(GraphNode, Map)'. The instance should be created successfully.
     */
    public void testPackageNode_Accuracy() {
        assertNotNull("Test method for 'PackageNode(GraphNode, Map<String, String>)' failed.", packageNode);
    }

    /**
     * Test method for 'PackageNode(GraphNode, Map)'. The first argument is null, IllegalArgumentException should be
     * thrown.
     */
    public void testPackageNode_null_1() {
        try {
            new PackageNode(null, properties, handler);
            fail("IllegalArgumentException should be thrown.");
        } catch (IllegalArgumentException iae) {
            // Success
        } catch (IllegalGraphElementException e) {
            fail(e.getMessage());
        }
    }

    /**
     * Test method for 'PackageNode(GraphNode, Map)'. The second argument is null, IllegalArgumentException should be
     * thrown.
     */
    public void testPackageNode_null_2() {
        try {
            new PackageNode(graphNode, null, handler);
            fail("IllegalArgumentException should be thrown.");
        } catch (IllegalArgumentException iae) {
            // Success
        } catch (IllegalGraphElementException e) {
            fail(e.getMessage());
        }
    }

    /**
     * Test method for 'PackageNode(GraphNode, Map)'. The third argument is null, IllegalArgumentException should be
     * thrown.
     */
    public void testPackageNode_null_3() {
        try {
            new PackageNode(graphNode, properties, null);
            fail("IllegalArgumentException should be thrown.");
        } catch (IllegalArgumentException iae) {
            // Success
        } catch (IllegalGraphElementException e) {
            fail(e.getMessage());
        }
    }

    /**
     * Test method for 'PackageNode(GraphNode, Map)'. The properties map contains null, IllegalArgumentException should
     * be thrown.
     */
    public void testPackageNode_contain_null() {
        try {
            Map<String, String> map = properties;
            map.put("null", null);
            new PackageNode(graphNode, map, handler);
            fail("IllegalArgumentException should be thrown.");
        } catch (IllegalArgumentException iae) {
            // Success
        } catch (IllegalGraphElementException e) {
            fail(e.getMessage());
        }
    }

    /**
     * Test method for 'PackageNode(GraphNode, Map)'. Bad GraphNode structure is given, IllegalArgumentException should
     * be thrown.
     */
    public void testPackageNode_Invalid_GraphNode() {
        try {
            GraphNode node = TestUtil.createEnumerationGraphNode(POSITION, SIZE);
            new PackageNode(node, properties, handler);
            fail("IllegalGraphElementException should be thrown.");
        } catch (IllegalArgumentException iae) {
            fail(iae.getMessage());
        } catch (IllegalGraphElementException e) {
            // Success
        }
    }

    /**
     * Test method for 'contains(int, int)'. Inner point is given, should be true.
     */
    public void testContains_True() {
        int x = packageNode.getSelectionBound().x + (int) packageNode.getSelectionBound().getWidth() / 2;
        int y = packageNode.getSelectionBound().y + (int) packageNode.getSelectionBound().getHeight() / 2;
        assertTrue("The given point should be contained.", packageNode.contains(x, y));
    }

    /**
     * Test method for 'contains(int, int)'. Outer point is given, should be false.
     */
    public void testContains_False_1() {
        int x = -10;
        int y = -10;
        assertFalse("The given point should not be contained.", packageNode.contains(x, y));
    }

    /**
     * Test method for 'contains(int, int)'. A point between selection bound and graph node is given, should be false.
     */
    public void testContains_False_2() {
        int x = packageNode.getSelectionBound().x / 2;
        /*
         * BugFix: BUGID UML-8193
         * Description:
         * In contains, the selection corners around this node should be checked to determine whether or not the
         * point is contained.
         * Solution:
         * Code is added to check the child components.
         */
        // old code
//        int y = packageNode.getSelectionBound().y;
        int y = packageNode.getSelectionBound().y + packageNode.getSelectionBound().height / 4;
        assertFalse("The given point should not be contained.", packageNode.contains(x, y));
    }

    /**
     * Test method for 'setTransferHandler(TransferHandler)'. The TransferHandler should be set correctly.
     */
    public void testSetTransferHandlerTransferHandler() {
        TransferHandler newHandler = new TransferHandler("new");
        packageNode.setTransferHandler(newHandler);
        assertEquals("", packageNode.getTransferHandler(), newHandler);
    }

    /**
     * Test method for 'notifyGraphNodeChange(String)'. The node should change accordingly.
     */
    public void testNotifyGraphNodeChange() {
        packageNode.getStereotypeCompartment().getGraphNode().setVisible(false);

        Rectangle oldBound = packageNode.getSelectionBound();
        packageNode.addBoundaryChangedListener(boundChangedListener);
        packageNode.notifyGraphNodeChange("New operation added.");
        Rectangle newBound = packageNode.getSelectionBound();
        /*
         * BugFix: BUGID UML-8193
         * Description:
         * In notifyGraphNodeChange, the calculated preferred size should be set to the graph node to keep consistency.
         * Solution:
         * Compare with user defined size first, then set the calculated size to the graph node to keep consistency.
         */
        // old code
//        assertTrue("The size should increase.", newBound.height < oldBound.height);
        assertTrue("The size should increase.", newBound.height == oldBound.height);
    }

    /**
     * Test method for 'getPreferredGraphNodeSize()'. The default graph node size should be got correctly.
     */
    public void testGetPreferredGraphNodeSize() {
        assertNotNull("The default graph node size should be got correctly.", packageNode.getPreferredGraphNodeSize());
    }

    /**
     * Test method for 'consumeEvent(MouseEvent)'. The argument is null, should be ignored.
     */
    public void testconsumeEvent_null() {
        assertFalse("Null event should be ignored.", packageNode.consumeEvent(null));
    }

    /*
     * BugFix: BUGID UML-8193
     * Description:
     * In consumeEvent, this method should simply return false to let the event pass behind.
     * Solution:
     * Following code is commented.
     */
    // old code
//    /**
//     * Test method for 'consumeEvent(MouseEvent)'. The argument is a valid MouseClicked event, should be consumed.
//     */
//    public void testconsumeEvent_Valid_MouseClicked() {
//        MouseEvent event = new MouseEvent(packageNode, MouseEvent.MOUSE_CLICKED, 1000, MouseEvent.ALT_DOWN_MASK, 0, 0,
//                1, false);
//        assertTrue("Valid MouseClicked event should be consumed.", packageNode.consumeEvent(event));
//    }
//
//    /**
//     * Test method for 'consumeEvent(MouseEvent)'. The argument is an invalid MouseClicked event, should not be
//     * consumed.
//     */
//    public void testconsumeEvent_Invalid_MouseClicked() {
//        MouseEvent event = new MouseEvent(TestUtil.createGeneralizationEdge(), MouseEvent.MOUSE_CLICKED, 1000,
//                MouseEvent.ALT_DOWN_MASK, 0, 0, 1, false);
//        assertFalse("Invalid MouseClicked event should not be consumed.", packageNode.consumeEvent(event));
//    }
//
//    /**
//     * Test method for 'consumeEvent(MouseEvent)'. The argument is a valid MousePressed event, should be consumed.
//     */
//    public void testconsumeEvent_Valid_MousePressed() {
//        MouseEvent event = new MouseEvent(TestUtil.createDependencyEdge(), MouseEvent.MOUSE_PRESSED, 1000,
//                MouseEvent.ALT_DOWN_MASK, 0, 0, 1, false);
//        assertTrue("Valid MousePressed event should be consumed.", packageNode.consumeEvent(event));
//    }
//
//    /**
//     * Test method for 'consumeEvent(MouseEvent)'. The argument is an invalid MousePressed event, should not be
//     * consumed.
//     */
//    public void testconsumeEvent_Invalid_MousePressed() {
//        MouseEvent event = new MouseEvent(TestUtil.createGeneralizationEdge(), MouseEvent.MOUSE_PRESSED, 1000,
//                MouseEvent.ALT_DOWN_MASK, 0, 0, 1, false);
//        assertFalse("Invalid MousePressed event should not be consumed.", packageNode.consumeEvent(event));
//    }
//
//    /**
//     * Test method for 'consumeEvent(MouseEvent)'. The argument is a valid MouseReleased event, should be consumed.
//     */
//    public void testconsumeEvent_Valid_MouseReleased() {
//        MouseEvent event = new MouseEvent(TestUtil.createDependencyEdge(), MouseEvent.MOUSE_RELEASED, 1000,
//                MouseEvent.ALT_DOWN_MASK, 0, 0, 1, false);
//        assertTrue("Valid MouseReleased event should be consumed.", packageNode.consumeEvent(event));
//    }
//
//    /**
//     * Test method for 'consumeEvent(MouseEvent)'. The argument is an invalid MouseReleased event, should not be
//     * consumed.
//     */
//    public void testconsumeEvent_Invalid_MouseReleased() {
//        MouseEvent event = new MouseEvent(TestUtil.createGeneralizationEdge(), MouseEvent.MOUSE_RELEASED, 1000,
//                MouseEvent.ALT_DOWN_MASK, 0, 0, 1, false);
//        assertFalse("Invalid MouseReleased event should not be consumed.", packageNode.consumeEvent(event));
//    }

    /**
     * Test method for 'BaseNode.getStrokeColor()'. Stroke color of this node should be got correctly.
     */
    public void testGetStrokeColor() {
        assertEquals("Stroke color of this node should be got correctly.", packageNode.getStrokeColor(), Color.BLACK);
    }

    /**
     * Test method for 'BaseNode.getFillColor()'. Fill color of this node should be got correctly.
     */
    public void testGetFillColor() {
        assertEquals("Fill color of this node should be got correctly.", packageNode.getFillColor(), Color.YELLOW);
    }

    /**
     * Test method for 'BaseNode.getFontColor()'. Font color of this node should be got correctly.
     */
    public void testGetFontColor() {
        assertEquals("Font color of this node should be got correctly.", packageNode.getFontColor(), Color.BLACK);
    }

    /**
     * Test method for 'BaseNode.getConnector()'. Connector of this node should be got correctly.
     */
    public void testGetConnector() {
        assertNotNull("Connector of this node should be got correctly.", packageNode.getConnector());
    }

    /**
     * Test method for 'BaseNode.getNameCompartment()'. Name compartment should be got correctly.
     */
    public void testGetNameCompartment() {
        assertNotNull("Name compartment should be got correctly.", packageNode.getNameCompartment());
    }

    /**
     * Test method for 'BaseNode.getStereotypeCompartment()'. Stereotype compartment should be got correctly.
     */
    public void testGetStereotypeCompartment() {
        assertNotNull("Stereotype compartment should be got correctly.", packageNode.getStereotypeCompartment());
    }

    /**
     * Test method for 'BaseNode.getNamespaceCompartment()'. Namespace compartment should be got correctly.
     */
    public void testGetNamespaceCompartment() {
        assertNotNull("Namespace compartment should be got correctly.", packageNode.getNamespaceCompartment());
    }

    /**
     * Test method for 'notifyPropertiesChange()'. Properties of this node should be updated correctly.
     */
    public void testNotifyPropertiesChange() {
        graphNode.clearProperties();
        graphNode.addProperty(TestUtil.createProperty("FILL_COLOR", "FFFFFF"));
        packageNode.notifyPropertiesChange();
        assertEquals(packageNode.getFillColor(), Color.WHITE);
    }

    /**
     * Test method for 'BaseNode.addBoundaryChangedListener(BoundaryChangedListener)', listener should be added
     * correctly.
     */
    public void testAddBoundaryChangedListener() {
        packageNode.removeBoundaryChangedListener(boundChangedListener);
        BoundaryChangedListener[] oldListeners = packageNode.getListeners(BoundaryChangedListener.class);
        packageNode.addBoundaryChangedListener(boundChangedListener);
        BoundaryChangedListener[] newListeners = packageNode.getListeners(BoundaryChangedListener.class);
        assertEquals(oldListeners.length + 1, newListeners.length);
        assertEquals(newListeners[newListeners.length - 1], boundChangedListener);
    }

    /**
     * Test method for 'BaseNode.removeBoundaryChangedListener(BoundaryChangedListener)', listener should be removed
     * correctly.
     */
    public void testRemoveBoundaryChangedListener() {
        packageNode.addBoundaryChangedListener(boundChangedListener);
        BoundaryChangedListener[] oldListeners = packageNode.getListeners(BoundaryChangedListener.class);
        packageNode.removeBoundaryChangedListener(boundChangedListener);
        BoundaryChangedListener[] newListeners = packageNode.getListeners(BoundaryChangedListener.class);
        assertEquals(oldListeners.length - 1, newListeners.length);
    }

    /**
     * Test method for 'fireBoundaryChange(BoundaryChangedEvent)', event should be fired correctly.
     */
    public void testFireBoundaryChange() {
        packageNode.addBoundaryChangedListener(boundChangedListener);
        BoundaryChangedEvent event = new BoundaryChangedEvent(packageNode, new Rectangle(0, 0), new Rectangle(50, 50));
        packageNode.fireBoundaryChanged(event);
    }

    /**
     * Test method for 'BaseNode.notifyNamespaceVisibilityChange()'. Bound of this node should be updated correctly.
     */
    public void testNotifyNamespaceVisibilityChange() {
        int oldHeight = packageNode.getHeight();
        packageNode.getNamespaceCompartment().getGraphNode().setVisible(false);
        packageNode.notifyNamespaceVisibilityChange();
        /*
         * BugFix: BUGID UML-8193
         * Description:
         * In notifyGraphNodeChange, the calculated preferred size should be set to the graph node to keep consistency.
         * Solution:
         * Compare with user defined size first, then set the calculated size to the graph node to keep consistency.
         */
        // old code
//        assertTrue("Bound of this node should be changed.", packageNode.getHeight() < oldHeight);
        assertTrue("Bound of this node should be changed.", packageNode.getHeight() == oldHeight);
    }

    /**
     * Test method for 'notifyStereotypeVisibilityChange()'. Bound of this node should be updated correctly.
     */
    public void testNotifyStereotypeVisibilityChange() {
        int oldHeight = packageNode.getHeight();
        packageNode.getStereotypeCompartment().getGraphNode().setVisible(false);
        packageNode.notifyStereotypeVisibilityChange();
        /*
         * BugFix: BUGID UML-8193
         * Description:
         * In notifyGraphNodeChange, the calculated preferred size should be set to the graph node to keep consistency.
         * Solution:
         * Compare with user defined size first, then set the calculated size to the graph node to keep consistency.
         */
        // old code
//        assertTrue("Bound of this node should be changed.", packageNode.getHeight() < oldHeight);
        assertTrue("Bound of this node should be changed.", packageNode.getHeight() == oldHeight);
    }

    /**
     * Test method for 'BaseNode.addEdgeAddListener(EdgeAddListener)', listener should be added correctly.
     */
    public void testAddEdgeAddListener() {
        packageNode.removeEdgeAddListener(edgeAddListener);
        EdgeAddListener[] oldListeners = packageNode.getListeners(EdgeAddListener.class);
        packageNode.addEdgeAddListener(edgeAddListener);
        EdgeAddListener[] newListeners = packageNode.getListeners(EdgeAddListener.class);
        assertEquals(oldListeners.length + 1, newListeners.length);
        assertEquals(newListeners[newListeners.length - 1], edgeAddListener);
    }

    /**
     * Test method for 'BaseNode.removeEdgeAddListener(EdgeAddListener)', listener should be removed correctly.
     */
    public void testRemoveEdgeAddListener() {
        packageNode.addEdgeAddListener(edgeAddListener);
        EdgeAddListener[] oldListeners = packageNode.getListeners(EdgeAddListener.class);
        packageNode.removeEdgeAddListener(edgeAddListener);
        EdgeAddListener[] newListeners = packageNode.getListeners(EdgeAddListener.class);
        assertEquals(oldListeners.length - 1, newListeners.length);
    }

    /**
     * Test method for 'fireEdgeAdd(EdgeAddEvent)', event should be fired correctly.
     */
    public void testFireEdgeAdd() {
        packageNode.addEdgeAddListener(edgeAddListener);
        EdgeAddEvent event = new EdgeAddEvent(packageNode, new Point(0, 0), false);
        packageNode.fireEdgeAdd(event);
    }

    /**
     * Test method for 'addNodeAddListener(NodeAddListener)', listener should be added correctly.
     */
    public void testAddNodeAddListener() {
        packageNode.removeNodeAddListener(nodeAddListener);
        NodeAddListener[] oldListeners = packageNode.getListeners(NodeAddListener.class);
        packageNode.addNodeAddListener(nodeAddListener);
        NodeAddListener[] newListeners = packageNode.getListeners(NodeAddListener.class);
        assertEquals(oldListeners.length + 1, newListeners.length);
        assertEquals(newListeners[newListeners.length - 1], nodeAddListener);
    }

    /**
     * Test method for 'removeNodeAddListener(NodeAddListener)', listener should be removed correctly.
     */
    public void testRemoveNodeAddListener() {
        packageNode.addNodeAddListener(nodeAddListener);
        NodeAddListener[] oldListeners = packageNode.getListeners(NodeAddListener.class);
        packageNode.removeNodeAddListener(nodeAddListener);
        NodeAddListener[] newListeners = packageNode.getListeners(NodeAddListener.class);
        assertEquals(oldListeners.length - 1, newListeners.length);
    }

    /**
     * Test method for 'fireNodeAdd(NodeAddEvent)', event should be fired correctly.
     */
    public void testFireNodeAdd() {
        packageNode.addNodeAddListener(nodeAddListener);
        NodeAddEvent event = new NodeAddEvent(packageNode, new Point(0, 0));
        packageNode.fireNodeAdd(event);
    }

    /**
     * Test the GUI. The component should be displayed correctly.
     */
    public void testGUI() throws Exception {

        TextChangedListener textListener = new TextChangedListener() {
            public void textChanged(TextChangedEvent event) {
                TextField compartment = (TextField) event.getSource();
                compartment.setText(event.getNewText());
            }
        };
        // register the listener
        packageNode.getNameCompartment().addTextChangedListener(textListener);

        // Then add the node to the container to show it
        packageNode.setName("PackageNode");
        packageNode.setVisible(true);
        TestUtil.loadConfig("test_files/DiagramViewer.xml");
        DiagramViewer viewer = new DiagramViewer("DiagramViewer");
        viewer.add(packageNode);

        JDialog dialog = new JDialog((JFrame) null, "PackageNode", true);
        dialog.setSize(500, 500);
        dialog.getContentPane().add(viewer);
        dialog.setModal(false);
        dialog.setVisible(true);
        NamedComponentFinder finder = new NamedComponentFinder(JComponent.class, "PackageNode");
        PackageNode node = (PackageNode) finder.find(dialog, 0);
        assertNotNull("PackageNode component should be displayed", node);

        helper.enterClickAndLeave(new MouseEventData(this, viewer, 1, true));

        TextField nameCompartment = node.getNameCompartment();
        helper.enterClickAndLeave(new MouseEventData(this, nameCompartment, 2));
        sleep(100);
        dialog.dispose();
    }

    /**
     * <p>
     * Tears down the test environment.
     * </p>
     */
    protected void tearDown() throws Exception {
        super.tearDown();

        helper = null;

        graphNode = null;

        properties = null;

        handler = null;

        packageNode = null;

        boundChangedListener = null;

        edgeAddListener = null;

        nodeAddListener = null;
    }
}
