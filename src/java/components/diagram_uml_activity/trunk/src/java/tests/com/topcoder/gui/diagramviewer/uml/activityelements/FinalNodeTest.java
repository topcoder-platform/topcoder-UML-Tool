/*
 * Copyright (C) 2007 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.gui.diagramviewer.uml.activityelements;

import java.awt.Point;
import java.awt.Rectangle;
import java.util.HashMap;
import java.util.Map;

import javax.swing.JComponent;
import javax.swing.JDialog;
import javax.swing.JFrame;

import junit.extensions.jfcunit.JFCTestCase;
import junit.extensions.jfcunit.JFCTestHelper;
import junit.extensions.jfcunit.TestHelper;
import junit.extensions.jfcunit.eventdata.MouseEventData;
import junit.extensions.jfcunit.finder.NamedComponentFinder;

import com.topcoder.diagraminterchange.Diagram;
import com.topcoder.diagraminterchange.Dimension;
import com.topcoder.diagraminterchange.GraphNode;
import com.topcoder.gui.diagramviewer.DiagramView;
import com.topcoder.gui.diagramviewer.DiagramViewer;
import com.topcoder.gui.diagramviewer.elements.SelectionCorner;
import com.topcoder.gui.diagramviewer.uml.activityelements.event.TextChangedEvent;
import com.topcoder.gui.diagramviewer.uml.activityelements.event.TextChangedListener;
import com.topcoder.uml.model.activitygraphs.ActionStateImpl;
import com.topcoder.uml.model.core.extensionmechanisms.Stereotype;
import com.topcoder.uml.model.core.extensionmechanisms.StereotypeImpl;
import com.topcoder.uml.model.statemachines.FinalState;
import com.topcoder.uml.model.statemachines.FinalStateImpl;

/**
 * <p>
 * Test the functionality of <code>FinalNode</code> class.
 * </p>
 * @author TCSDEVELOPER
 * @version 1.0
 */
public class FinalNodeTest extends JFCTestCase {

    /** An instance of <code>FinalNode</code> for testing. */
    private FinalNode finalNode;

    /** A GraphNode for <code>FinalNode</code>. */
    private GraphNode graphNode;

    /** Properties for testing. */
    private final Map<String, String> properties = new HashMap<String, String>();

    /** Relative position of GraphNode. */
    private Point position;

    /** Selection bound of <code>FinalNode</code>. */
    private Rectangle bound = new Rectangle();

    /** Boundary changed listener for <code>FinalNode</code>. */
    private MockedBoundaryChangedListener listener;

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

        FinalState state = new FinalStateImpl();
        // set nameCompartment text
        state.setName("NameCompartment");
        // set stereotypeCompartment text
        Stereotype stereotypeOne = new StereotypeImpl();
        stereotypeOne.setName("StereotypeCompartment");
        state.addStereotype(stereotypeOne);

        graphNode = TestUtil.createGraphNodeForActivityNode(state);
        graphNode.setPosition(TestUtil.createPoint(100, 100));
        graphNode.setSize(TestUtil.createDimension(20, 20));
        graphNode.setContainer(new GraphNode());
        TestUtil.addPropertiesToGraphNode(graphNode);

        properties.put("FillColor", "fill_color");
        properties.put("StrokeColor", "stroke_color");
        properties.put("FontColor", "font_color");
        properties.put("FontFamily", "font_family");
        properties.put("FontStyle", "font_style");
        properties.put("FontSize", "font_size");

        position = new Point(SelectionCorner.DEFAULT_RADIUS * 2, SelectionCorner.DEFAULT_RADIUS * 2);

        finalNode = new FinalNode(graphNode, properties, position, bound);

        listener = new MockedBoundaryChangedListener();
    }

    /**
     * Test method for 'FinalNode(GraphNode, Map, Point, Rectangle)'. The instance should be created successfully.
     */
    public void testFinalNode_Accuracy() {
        assertNotNull("Test method for 'FinalNode(GraphNode, Map<String, String>, Point, Rectangle)' failed.",
                finalNode);
    }

    /**
     * Test method for 'FinalNode(GraphNode, Map, Point, Rectangle)'. The first argument is null,
     * IllegalArgumentException should be thrown.
     */
    public void testFinalNode_null_1() {
        try {
            new FinalNode(null, properties, position, bound);
            fail("IllegalArgumentException should be thrown.");
        } catch (IllegalArgumentException iae) {
            // Success
        } catch (IllegalGraphElementException e) {
            fail(e.getMessage());
        }
    }

    /**
     * Test method for 'FinalNode(GraphNode, Map, Point, Rectangle)'. The second argument is null,
     * IllegalArgumentException should be thrown.
     */
    public void testFinalNode_null_2() {
        try {
            new FinalNode(graphNode, null, position, bound);
            fail("IllegalArgumentException should be thrown.");
        } catch (IllegalArgumentException iae) {
            // Success
        } catch (IllegalGraphElementException e) {
            fail(e.getMessage());
        }
    }

    /**
     * Test method for 'FinalNode(GraphNode, Map, Point, Rectangle)'. The third argument is null,
     * IllegalArgumentException should be thrown.
     */
    public void testFinalNode_null_3() {
        try {
            new FinalNode(graphNode, properties, null, bound);
            fail("IllegalArgumentException should be thrown.");
        } catch (IllegalArgumentException iae) {
            // Success
        } catch (IllegalGraphElementException e) {
            fail(e.getMessage());
        }
    }

    /**
     * Test method for 'FinalNode(GraphNode, Map, Point, Rectangle)'. The fourth argument is null,
     * IllegalArgumentException should be thrown.
     */
    public void testFinalNode_null_4() {
        try {
            new FinalNode(graphNode, properties, position, null);
            fail("IllegalArgumentException should be thrown.");
        } catch (IllegalArgumentException iae) {
            // Success
        } catch (IllegalGraphElementException e) {
            fail(e.getMessage());
        }
    }

    /**
     * Test method for 'FinalNode(GraphNode, Map, Point, Rectangle)'. The properties map is empty,
     * IllegalArgumentException should be thrown.
     */
    public void testFinalNode_contain_null() {
        try {
            Map<String, String> map = properties;
            map.put("sfd", null);
            new FinalNode(graphNode, map, position, bound);
            fail("IllegalArgumentException should be thrown.");
        } catch (IllegalArgumentException iae) {
            // Success
        } catch (IllegalGraphElementException e) {
            fail(e.getMessage());
        }
    }

    /**
     * Test method for 'FinalNode(GraphNode, Map, Point, Rectangle)'. Bad GraphNode structure is given,
     * IllegalArgumentException should be thrown.
     */
    public void testFinalNode_Invalid_GraphNode() {
        try {
            GraphNode node = TestUtil.createGraphNodeForActivityState(new ActionStateImpl());
            new FinalNode(node, properties, position, bound);
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
        int x = finalNode.getSelectionBound().x + (int) Math.round(graphNode.getSize().getWidth() / 2);
        int y = finalNode.getSelectionBound().y + (int) Math.round(graphNode.getSize().getHeight() / 2);
        assertTrue("The given point should be contained.", finalNode.contains(x, y));
    }

    /**
     * Test method for 'contains(int, int)'. Outer point is given, should be false.
     */
    public void testContains_False_1() {
        int x = -10;
        int y = -10;
        assertFalse("The given point should not be contained.", finalNode.contains(x, y));
    }

    /**
     * Test method for 'contains(int, int)'. A point between selection bound and graph node is given, should be false.
     */
    public void testContains_False_2() {
        int x = finalNode.getSelectionBound().x / 2;
        int y = finalNode.getSelectionBound().y;
        assertFalse("The given point should not be contained.", finalNode.contains(x, y));
    }

    /**
     * Test method for 'notifyGraphNodeChange(String)'. The node should change accordingly.
     */
    public void testNotifyGraphNodeChange() {
        Dimension d = graphNode.getSize();
        d.setWidth(d.getWidth() + 10);
        graphNode.setSize(d);
        Rectangle oldBound = finalNode.getSelectionBound();
        finalNode.addBoundaryChangedListener(listener);
        finalNode.notifyGraphNodeChange("GraphNode's width increased.");
        Rectangle newBound = finalNode.getSelectionBound();
        int changed = newBound.width - oldBound.width;
        assertEquals("The changed size of node should be equal to graphNode's.", changed, 10);
    }

    /**
     * Test method for 'getPreferredGraphNodeSize()'. The default graph node size should be got correctly.
     */
    public void testGetPreferredGraphNodeSize() {
        assertEquals("The default graph node size should be got correctly.", finalNode.getPreferredGraphNodeSize(),
                TestUtil.getPrivateField(FinalNode.class, finalNode, "DEFAULT_SIZE"));
    }

    /**
     * Test the GUI. The component should be displayed correctly.
     * @throws Exception to jfcunit
     */
    public void testGUI() throws Exception {

        TextChangedListener textListener = new TextChangedListener() {
            public void textChanged(TextChangedEvent event) {
                TextField compartment = (TextField) event.getSource();
                compartment.setText(event.getNewValue());
            }
        };
        // register the listener
        finalNode.getNameCompartment().addTextChangedListener(textListener);

        // Then add the node to the container to show it
        finalNode.setName("FinalNode");
        finalNode.setVisible(true);
        TestUtil.loadConfig("test_files/DiagramViewer.xml");
        DiagramViewer viewer = new DiagramViewer("DiagramViewer");
        Diagram diagram = new Diagram();
        diagram.setName("Activity Diagram");
        com.topcoder.diagraminterchange.Dimension dimension =
            new com.topcoder.diagraminterchange.Dimension();
        dimension.setWidth(500.0);
        dimension.setHeight(500.0);
        com.topcoder.diagraminterchange.Point point =
            new com.topcoder.diagraminterchange.Point();
        point.setX(5);
        point.setY(5);
        diagram.setPosition(point);
        diagram.setSize(dimension);
        DiagramView view = viewer.openDiagramView(diagram);
        view.add(finalNode);

        view.addMouseListener(finalNode);

        JDialog dialog = new JDialog((JFrame) null, "FinalNode", true);
        dialog.setSize(500, 500);
        dialog.getContentPane().add(viewer);
        dialog.setModal(false);
        dialog.setVisible(true);
        NamedComponentFinder finder = new NamedComponentFinder(JComponent.class, "FinalNode");
        FinalNode node = (FinalNode) finder.find(dialog, 0);
        assertNotNull("FinalNode component should be displayed", node);

        helper.enterClickAndLeave(new MouseEventData(this, viewer, 1, true));

        TextField nameCompartment = node.getNameCompartment();
        helper.enterClickAndLeave(new MouseEventData(this, nameCompartment, 2));
        sleep(100);
        dialog.dispose();
    }
}
