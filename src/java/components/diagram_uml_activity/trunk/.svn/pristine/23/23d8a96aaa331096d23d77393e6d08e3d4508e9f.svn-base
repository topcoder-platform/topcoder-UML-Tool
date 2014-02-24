/*
 * Copyright (C) 2007 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.gui.diagramviewer.uml.activityelements;

import java.awt.Color;
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
import com.topcoder.diagraminterchange.Property;
import com.topcoder.gui.diagramviewer.DiagramView;
import com.topcoder.gui.diagramviewer.DiagramViewer;
import com.topcoder.gui.diagramviewer.elements.SelectionCorner;
import com.topcoder.gui.diagramviewer.uml.activityelements.event.BoundaryChangedListener;
import com.topcoder.gui.diagramviewer.uml.activityelements.event.TextChangedEvent;
import com.topcoder.gui.diagramviewer.uml.activityelements.event.TextChangedListener;
import com.topcoder.uml.model.activitygraphs.ActionStateImpl;
import com.topcoder.uml.model.core.extensionmechanisms.Stereotype;
import com.topcoder.uml.model.core.extensionmechanisms.StereotypeImpl;
import com.topcoder.uml.model.datatypes.PseudostateKind;
import com.topcoder.uml.model.statemachines.Pseudostate;
import com.topcoder.uml.model.statemachines.PseudostateImpl;

/**
 * <p>
 * Test the functionality of <code>InitialNode</code> class and <code>BaseNode</code> class.
 * </p>
 * @author TCSDEVELOPER
 * @version 1.0
 */
public class InitialNodeTest extends JFCTestCase {

    /** An instance of <code>InitialNode</code> for testing. */
    private InitialNode initialNode;

    /** A GraphNode for <code>InitialNode</code>. */
    private GraphNode graphNode;

    /** Properties for testing. */
    private final Map<String, String> properties = new HashMap<String, String>();

    /** Relative position of GraphNode. */
    private Point position;

    /** Selection bound of <code>InitialNode</code>. */
    private Rectangle bound = new Rectangle();

    /** Boundary changed listener for <code>InitialNode</code>. */
    private MockedBoundaryChangedListener listener;

    /** Fill color property of this node's graph node. */
    private Property fillColor;

    /** Stroke color property of this node's graph node. */
    private Property strokeColor;

    /** Font color property of this node's graph node. */
    private Property fontColor;

    /** Font family property of this node's graph node. */
    private Property fontFamily;

    /** Font style property of this node's graph node. */
    private Property fontStyle;

    /** Font size property of this node's graph node. */
    private Property fontSize;

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

        Pseudostate state = new PseudostateImpl();
        state.setKind(PseudostateKind.INITIAL);
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

        // Red Color
        fillColor = TestUtil.createProperty("fill_color", "FF0000");
        graphNode.addProperty(fillColor);
        // Green Color
        strokeColor = TestUtil.createProperty("stroke_color", "00FF00");
        graphNode.addProperty(strokeColor);
        // Blue Color
        fontColor = TestUtil.createProperty("font_color", "0000FF");
        graphNode.addProperty(fontColor);
        fontFamily = TestUtil.createProperty("font_family", "Arial");
        graphNode.addProperty(fontFamily);
        fontStyle = TestUtil.createProperty("font_style", "1");
        graphNode.addProperty(fontStyle);
        fontSize = TestUtil.createProperty("font_size", "12.0");
        graphNode.addProperty(fontSize);

        properties.put("FillColor", "fill_color");
        properties.put("StrokeColor", "stroke_color");
        properties.put("FontColor", "font_color");
        properties.put("FontFamily", "font_family");
        properties.put("FontStyle", "font_style");
        properties.put("FontSize", "font_size");

        position = new Point(SelectionCorner.DEFAULT_RADIUS * 2, SelectionCorner.DEFAULT_RADIUS * 2);

        initialNode = new InitialNode(graphNode, properties, position, bound);

        listener = new MockedBoundaryChangedListener();
    }

    /**
     * Test method for 'InitialNode(GraphNode, Map, Point, Rectangle)'. The instance should be created successfully.
     */
    public void testInitialNode_Accuracy() {
        assertNotNull("Test method for 'InitialNode(GraphNode, Map<String, String>, Point, Rectangle)' failed.",
                initialNode);
    }

    /**
     * Test method for 'InitialNode(GraphNode, Map, Point, Rectangle)'. The first argument is null,
     * IllegalArgumentException should be thrown.
     */
    public void testInitialNode_null_1() {
        try {
            new InitialNode(null, properties, position, bound);
            fail("IllegalArgumentException should be thrown.");
        } catch (IllegalArgumentException iae) {
            // Success
        } catch (IllegalGraphElementException e) {
            fail(e.getMessage());
        }
    }

    /**
     * Test method for 'InitialNode(GraphNode, Map, Point, Rectangle)'. The second argument is null,
     * IllegalArgumentException should be thrown.
     */
    public void testInitialNode_null_2() {
        try {
            new InitialNode(graphNode, null, position, bound);
            fail("IllegalArgumentException should be thrown.");
        } catch (IllegalArgumentException iae) {
            // Success
        } catch (IllegalGraphElementException e) {
            fail(e.getMessage());
        }
    }

    /**
     * Test method for 'InitialNode(GraphNode, Map, Point, Rectangle)'. The third argument is null,
     * IllegalArgumentException should be thrown.
     */
    public void testInitialNode_null_3() {
        try {
            new InitialNode(graphNode, properties, null, bound);
            fail("IllegalArgumentException should be thrown.");
        } catch (IllegalArgumentException iae) {
            // Success
        } catch (IllegalGraphElementException e) {
            fail(e.getMessage());
        }
    }

    /**
     * Test method for 'InitialNode(GraphNode, Map, Point, Rectangle)'. The fourth argument is null,
     * IllegalArgumentException should be thrown.
     */
    public void testInitialNode_null_4() {
        try {
            new InitialNode(graphNode, properties, position, null);
            fail("IllegalArgumentException should be thrown.");
        } catch (IllegalArgumentException iae) {
            // Success
        } catch (IllegalGraphElementException e) {
            fail(e.getMessage());
        }
    }

    /**
     * Test method for 'InitialNode(GraphNode, Map, Point, Rectangle)'. The properties map is empty,
     * IllegalArgumentException should be thrown.
     */
    public void testInitialNode_contain_null() {
        try {
            Map<String, String> map = properties;
            map.put("sfd", null);
            new InitialNode(graphNode, map, position, bound);
            fail("IllegalArgumentException should be thrown.");
        } catch (IllegalArgumentException iae) {
            // Success
        } catch (IllegalGraphElementException e) {
            fail(e.getMessage());
        }
    }

    /**
     * Test method for 'InitialNode(GraphNode, Map, Point, Rectangle)'. Bad GraphNode structure is given,
     * IllegalArgumentException should be thrown.
     */
    public void testInitialNode_Invalid_GraphNode() {
        try {
            GraphNode node = TestUtil.createGraphNodeForActivityState(new ActionStateImpl());
            new InitialNode(node, properties, position, bound);
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
        int x = initialNode.getSelectionBound().x + (int) Math.round(graphNode.getSize().getWidth() / 2);
        int y = initialNode.getSelectionBound().y + (int) Math.round(graphNode.getSize().getHeight() / 2);
        assertTrue("The given point should be contained.", initialNode.contains(x, y));
    }

    /**
     * Test method for 'contains(int, int)'. Outer point is given, should be false.
     */
    public void testContains_False_1() {
        int x = -10;
        int y = -10;
        assertFalse("The given point should not be contained.", initialNode.contains(x, y));
    }

    /**
     * Test method for 'contains(int, int)'. A point between selection bound and graph node is given, should be false.
     */
    public void testContains_False_2() {
        int x = initialNode.getSelectionBound().x / 2;
        int y = initialNode.getSelectionBound().y;
        assertFalse("The given point should not be contained.", initialNode.contains(x, y));
    }

    /**
     * Test method for 'notifyGraphNodeChange(String)'. The node should change accordingly.
     */
    public void testNotifyGraphNodeChange() {
        Dimension d = graphNode.getSize();
        d.setWidth(d.getWidth() + 10);
        graphNode.setSize(d);
        Rectangle oldBound = initialNode.getSelectionBound();
        initialNode.addBoundaryChangedListener(listener);
        initialNode.notifyGraphNodeChange("GraphNode's width increased.");
        Rectangle newBound = initialNode.getSelectionBound();
        int changed = newBound.width - oldBound.width;
        assertEquals("The changed size of node should be equal to graphNode's.", changed, 10);
    }

    /**
     * Test method for 'getPreferredGraphNodeSize()'. The default graph node size should be got correctly.
     */
    public void testGetPreferredGraphNodeSize() {
        assertEquals("The default graph node size should be got correctly.", initialNode.getPreferredGraphNodeSize(),
                TestUtil.getPrivateField(InitialNode.class, initialNode, "DEFAULT_SIZE"));
    }

    /**
     * Test method for 'BaseNode.getConnector()'. Connector of this node should be got correctly.
     */
    public void testGetConnector() {
        assertNotNull("Connector of this node should be got correctly.", initialNode.getConnector());
    }

    /**
     * Test method for 'BaseNode.getFillColor()'. Fill color of this node should be got correctly.
     */
    public void testGetFillColor() {
        assertEquals("Fill color of this node should be got correctly.", initialNode.getFillColor(), Color.RED);
    }

    /**
     * Test method for 'BaseNode.getStrokeColor()'. Stroke color of this node should be got correctly.
     */
    public void testGetStrokeColor() {
        assertEquals("Stroke color of this node should be got correctly.", initialNode.getStrokeColor(), Color.GREEN);
    }

    /**
     * Test method for 'BaseNode.getFontColor()'. Font color of this node should be got correctly.
     */
    public void testGetFontColor() {
        assertEquals("Font color of this node should be got correctly.", initialNode.getFontColor(), Color.BLUE);
    }

    /**
     * Test method for 'BaseNode.getNameCompartment()'. Name compartment should be got correctly.
     */
    public void testGetNameCompartment() {
        assertNotNull("Name compartment should be got correctly.", initialNode.getNameCompartment());
    }

    /**
     * Test method for 'BaseNode.getStereotypeCompartment()'. Stereotype compartment should be got correctly.
     */
    public void testGetStereotypeCompartment() {
        assertNotNull("Stereotype compartment should be got correctly.", initialNode.getStereotypeCompartment());
    }

    /**
     * Test method for 'notifyNameCompartmentVisibilityChange()'. Bound of this node should be updated correctly.
     */
    public void testNotifyNameCompartmentVisibilityChange() {
        int oldHeight = initialNode.getHeight();
        graphNode.getContaineds().get(1).setVisible(false);
        initialNode.notifyNameCompartmentVisibilityChange();
        assertTrue("Bound of this node should be changed.", initialNode.getHeight() < oldHeight);
    }

    /**
     * Test method for 'notifyStereotypeCompartmentVisibilityChange()'. Bound of this node should be updated correctly.
     */
    public void testNotifyStereotypeCompartmentVisibilityChange() {
        int oldHeight = initialNode.getHeight();
        graphNode.getContaineds().get(0).setVisible(false);
        initialNode.notifyStereotypeCompartmentVisibilityChange();
        assertTrue("Bound of this node should be changed.", initialNode.getHeight() < oldHeight);
    }

    /**
     * Test method for 'notifyPropertiesChange()'. Properties of this node should be updated correctly.
     */
    public void testNotifyPropertiesChange() {
        graphNode.removeProperty(fillColor);
        fillColor.setValue("FFFFFF");
        graphNode.addProperty(fillColor);
        initialNode.notifyPropertiesChange();
        assertEquals(initialNode.getFillColor(), Color.WHITE);
    }

    /**
     * Test method for 'BaseNode.addBoundaryChangeListener(BoundaryChangedListener)', listener should be added
     * correctly.
     */
    public void testAddBoundaryChangeListener() {
        initialNode.removeBoundaryChangedListener(listener);
        BoundaryChangedListener[] oldListeners = initialNode.getListeners(BoundaryChangedListener.class);
        initialNode.addBoundaryChangedListener(listener);
        BoundaryChangedListener[] newListeners = initialNode.getListeners(BoundaryChangedListener.class);
        assertEquals(oldListeners.length + 1, newListeners.length);
        assertEquals(newListeners[newListeners.length - 1], listener);
    }

    /**
     * Test method for 'BaseNode.removeBoundaryChangeListener(BoundaryChangedListener)', listener should be removed
     * correctly.
     */
    public void testRemoveBoundaryChangeListener() {
        initialNode.addBoundaryChangedListener(listener);
        BoundaryChangedListener[] oldListeners = initialNode.getListeners(BoundaryChangedListener.class);
        initialNode.removeBoundaryChangedListener(listener);
        BoundaryChangedListener[] newListeners = initialNode.getListeners(BoundaryChangedListener.class);
        assertEquals(oldListeners.length - 1, newListeners.length);
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
        initialNode.getNameCompartment().addTextChangedListener(textListener);

        // Then add the node to the container to show it
        initialNode.setName("InitialNode");
        initialNode.setVisible(true);
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
        view.add(initialNode);

        view.addMouseListener(initialNode);
        JDialog dialog = new JDialog((JFrame) null, "InitialNode", true);
        dialog.setSize(500, 500);
        dialog.getContentPane().add(viewer);
        dialog.setModal(false);
        dialog.setVisible(true);
        NamedComponentFinder finder = new NamedComponentFinder(JComponent.class, "InitialNode");
        InitialNode node = (InitialNode) finder.find(dialog, 0);
        assertNotNull("InitialNode component should be displayed", node);

        helper.enterClickAndLeave(new MouseEventData(this, viewer, 1, true));

        TextField nameCompartment = node.getNameCompartment();
        helper.enterClickAndLeave(new MouseEventData(this, nameCompartment, 2));
        sleep(100);
        dialog.dispose();
    }
}
