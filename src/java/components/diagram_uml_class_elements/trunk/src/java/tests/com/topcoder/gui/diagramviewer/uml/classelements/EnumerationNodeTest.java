/*
 * Copyright (C) 2007 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.gui.diagramviewer.uml.classelements;

import java.awt.Dimension;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.event.MouseEvent;
import java.util.Map;

import javax.swing.JComponent;
import javax.swing.JDialog;
import javax.swing.JFrame;

import junit.extensions.jfcunit.JFCTestCase;
import junit.extensions.jfcunit.JFCTestHelper;
import junit.extensions.jfcunit.TestHelper;
import junit.extensions.jfcunit.eventdata.MouseEventData;
import junit.extensions.jfcunit.finder.NamedComponentFinder;

import com.topcoder.diagraminterchange.GraphNode;
import com.topcoder.gui.diagramviewer.DiagramViewer;
import com.topcoder.gui.diagramviewer.TextInputBox;
import com.topcoder.gui.diagramviewer.uml.classelements.event.TextChangedEvent;
import com.topcoder.gui.diagramviewer.uml.classelements.event.TextChangedListener;
import com.topcoder.uml.model.core.Classifier;

/**
 * <p>
 * Test the functionality of <code>EnumerationNode</code> class.
 * </p>
 * @author TCSDEVELOPER
 * @version 1.0
 */
public class EnumerationNodeTest extends JFCTestCase {

    /** The absolute position of the visual node. Used for testing only. */
    private static final Point POSITION = new Point(100, 150);

    /** The size of the visual node. Used for testing only. */
    private static final Dimension SIZE = new Dimension(80, 40);

    /** An instance of <code>EnumerationNode</code> for testing. */
    private EnumerationNode enumerationNode;

    /** A GraphNode for <code>EnumerationNode</code>. */
    private GraphNode graphNode;

    /** Properties for testing. */
    private Map<String, String> properties;

    /** Boundary changed listener for <code>EnumerationNode</code>. */
    private MockedBoundaryChangedListener boundChangedListener;

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

        graphNode = TestUtil.createEnumerationGraphNode(POSITION, SIZE);
        graphNode.setContainer(new GraphNode());

        properties = TestUtil.createProperties();

        enumerationNode = new EnumerationNode(graphNode, properties);

        enumerationNode.setAttributesOperationsPopup(new TextInputBox());

        boundChangedListener = new MockedBoundaryChangedListener();
    }

    /**
     * Test method for 'EnumerationNode(GraphNode, Map)'. The instance should be created successfully.
     */
    public void testEnumerationNode_Accuracy() {
        assertNotNull("Test method for 'EnumerationNode(GraphNode, Map<String, String>)' failed.", enumerationNode);
    }

    /**
     * Test method for 'EnumerationNode(GraphNode, Map)'. The first argument is null, IllegalArgumentException should be
     * thrown.
     */
    public void testEnumerationNode_null_1() {
        try {
            new EnumerationNode(null, properties);
            fail("IllegalArgumentException should be thrown.");
        } catch (IllegalArgumentException iae) {
            // Success
        } catch (IllegalGraphElementException e) {
            fail(e.getMessage());
        }
    }

    /**
     * Test method for 'EnumerationNode(GraphNode, Map)'. The second argument is null, IllegalArgumentException should
     * be thrown.
     */
    public void testEnumerationNode_null_2() {
        try {
            new EnumerationNode(graphNode, null);
            fail("IllegalArgumentException should be thrown.");
        } catch (IllegalArgumentException iae) {
            // Success
        } catch (IllegalGraphElementException e) {
            fail(e.getMessage());
        }
    }

    /**
     * Test method for 'EnumerationNode(GraphNode, Map)'. The properties map contains null, IllegalArgumentException
     * should be thrown.
     */
    public void testEnumerationNode_contain_null() {
        try {
            Map<String, String> map = properties;
            map.put("null", null);
            new EnumerationNode(graphNode, map);
            fail("IllegalArgumentException should be thrown.");
        } catch (IllegalArgumentException iae) {
            // Success
        } catch (IllegalGraphElementException e) {
            fail(e.getMessage());
        }
    }

    /**
     * Test method for 'EnumerationNode(GraphNode, Map)'. Bad GraphNode structure is given, IllegalArgumentException
     * should be thrown.
     */
    public void testEnumerationNode_Invalid_GraphNode() {
        try {
            GraphNode node = TestUtil.createPackageGraphNode(POSITION, SIZE);
            new EnumerationNode(node, properties);
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
        int x = enumerationNode.getSelectionBound().x + (int) enumerationNode.getSelectionBound().getWidth() / 2;
        int y = enumerationNode.getSelectionBound().y + (int) enumerationNode.getSelectionBound().getHeight() / 2;
        assertTrue("The given point should be contained.", enumerationNode.contains(x, y));
    }

    /**
     * Test method for 'contains(int, int)'. Outer point is given, should be false.
     */
    public void testContains_False_1() {
        int x = -10;
        int y = -10;
        assertFalse("The given point should not be contained.", enumerationNode.contains(x, y));
    }

    /**
     * Test method for 'contains(int, int)'. A point between selection bound and graph node is given, should be false.
     */
    public void testContains_False_2() {
        int x = enumerationNode.getSelectionBound().x / 2;
        /*
         * BugFix: BUGID UML-8195
         * Description:
         * In contains, the selection corners around this node should be checked to determine whether or not the
         * point is contained.
         * Solution:
         * Code is added to check the child components.
         */
        // old code
//        int y = enumerationNode.getSelectionBound().y;
        int y = enumerationNode.getSelectionBound().y + enumerationNode.getSelectionBound().height / 4;
        assertFalse("The given point should not be contained.", enumerationNode.contains(x, y));
    }

    /**
     * Test method for 'notifyGraphNodeChange(String)'. The node should change accordingly.
     */
    public void testNotifyGraphNodeChange() {
        Classifier classifier = (Classifier) TestUtil.getElement(graphNode);
        classifier.addFeature(TestUtil.createOperation("operation_4", "void", "parameter_4", "double"));

        Rectangle oldBound = enumerationNode.getSelectionBound();
        enumerationNode.addBoundaryChangedListener(boundChangedListener);
        enumerationNode.notifyGraphNodeChange("New operation added.");
        Rectangle newBound = enumerationNode.getSelectionBound();
        assertTrue("The size should increase.", newBound.height > oldBound.height);
    }

    /**
     * Test method for 'consumeEvent(MouseEvent)'. The argument is null, should be ignored.
     */
    public void testconsumeEvent_null() {
        assertFalse("Null event should be ignored.", enumerationNode.consumeEvent(null));
    }

    /**
     * Test method for 'consumeEvent(MouseEvent)'. The argument is a valid MousePressed event, should be consumed.
     */
    public void testconsumeEvent_Valid_MousePressed() {
        MouseEvent event = new MouseEvent(TestUtil.createGeneralizationEdge(), MouseEvent.MOUSE_PRESSED, 1000,
                MouseEvent.ALT_DOWN_MASK, 0, 0, 1, false);
        assertTrue("Valid MousePressed event should be consumed.", enumerationNode.consumeEvent(event));
    }

    /**
     * Test method for 'consumeEvent(MouseEvent)'. The argument is an invalid MousePressed event, should not be
     * consumed.
     */
    public void testconsumeEvent_Invalid_MousePressed() {
        MouseEvent event = new MouseEvent(TestUtil.createAbstractionEdge(), MouseEvent.MOUSE_PRESSED, 1000,
                MouseEvent.ALT_DOWN_MASK, 0, 0, 1, false);
        assertFalse("Invalid MousePressed event should not be consumed.", enumerationNode.consumeEvent(event));
    }

    /**
     * Test method for 'consumeEvent(MouseEvent)'. The argument is a valid MouseReleased event, should be consumed.
     */
    public void testconsumeEvent_Valid_MouseReleased() {
        MouseEvent event = new MouseEvent(TestUtil.createAbstractionEdge(), MouseEvent.MOUSE_RELEASED, 1000,
                MouseEvent.ALT_DOWN_MASK, 0, 0, 1, false);
        assertTrue("Valid MouseReleased event should be consumed.", enumerationNode.consumeEvent(event));
    }

    /**
     * Test method for 'consumeEvent(MouseEvent)'. The argument is an invalid MouseReleased event, should not be
     * consumed.
     */
    public void testconsumeEvent_Invalid_MouseReleased() {
        MouseEvent event = new MouseEvent(TestUtil.createGeneralizationEdge(), MouseEvent.MOUSE_RELEASED, 1000,
                MouseEvent.ALT_DOWN_MASK, 0, 0, 1, false);
        assertFalse("Invalid MouseReleased event should not be consumed.", enumerationNode.consumeEvent(event));
    }

    /**
     * Test method for 'getPreferredGraphNodeSize()'. The default graph node size should be got correctly.
     */
    public void testGetPreferredGraphNodeSize() {
        assertNotNull("The default graph node size should be got correctly.", enumerationNode
                .getPreferredGraphNodeSize());
    }

    /**
     * Test method for 'getEnumerationLiteralCompartment()'. EnumerationLiteral compartment should be got correctly.
     */
    public void testGetEnumerationLiteralCompartment() {
        assertNotNull("EnumerationLiteral compartment should be got correctly.", enumerationNode
                .getEnumerationLiteralCompartment());
    }

    /**
     * Test method for 'notifyEnumerationLiteralVisibilityChange()'. Bound of this node should be updated correctly.
     */
    public void testNotifyEnumerationLiteralVisibilityChange() {
        int oldHeight = enumerationNode.getHeight();
        graphNode.getContaineds().get(2).setVisible(false);
        enumerationNode.notifyEnumerationLiteralVisibilityChange();
        /*
         * BugFix: BUGID UML-8195
         * Description:
         * In calculateSize, at the end of the method, the calculated size should also be compared with the user
         * defined size.
         * In notifyGraphNodeChange, the calculated preferred size should be set to the graph node to keep consistency.
         * Solution:
         * Code is added to compare with the user defined size.
         * Set the calculated size to the graph node to keep consistency.
         */
        // old code
//        assertTrue("Bound of this node should be changed.", enumerationNode.getHeight() < oldHeight);
        assertTrue("Bound of this node should be changed.", enumerationNode.getHeight() == oldHeight);
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
        enumerationNode.getNameCompartment().addTextChangedListener(textListener);

        // Then add the node to the container to show it
        enumerationNode.setName("EnumerationNode");
        enumerationNode.setVisible(true);
        TestUtil.loadConfig("test_files/DiagramViewer.xml");
        DiagramViewer viewer = new DiagramViewer("DiagramViewer");
        viewer.add(enumerationNode);

        JDialog dialog = new JDialog((JFrame) null, "EnumerationNode", true);
        dialog.setSize(500, 500);
        dialog.getContentPane().add(viewer);
        dialog.setModal(false);
        dialog.setVisible(true);
        NamedComponentFinder finder = new NamedComponentFinder(JComponent.class, "EnumerationNode");
        EnumerationNode node = (EnumerationNode) finder.find(dialog, 0);
        assertNotNull("EnumerationNode component should be displayed", node);

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

        enumerationNode = null;

        boundChangedListener = null;
    }
}
