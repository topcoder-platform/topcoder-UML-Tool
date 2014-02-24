/*
 * Copyright (C) 2007 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.gui.diagramviewer.uml.activityelements;

import java.awt.Point;
import java.awt.Rectangle;
import java.util.HashMap;
import java.util.Map;

import junit.framework.TestCase;

import com.topcoder.diagraminterchange.Dimension;
import com.topcoder.diagraminterchange.GraphNode;
import com.topcoder.gui.diagramviewer.elements.SelectionCorner;
import com.topcoder.uml.model.activitygraphs.ObjectFlowStateImpl;
import com.topcoder.uml.model.core.ModelElement;
import com.topcoder.uml.model.core.extensionmechanisms.Stereotype;
import com.topcoder.uml.model.core.extensionmechanisms.StereotypeImpl;

/**
 * <p>
 * Test the functionality of <code>RectangleConnector</code> class.
 * </p>
 * @author TCSDEVELOPER
 * @version 1.0
 */
public class RectangleConnectorTest extends TestCase {

    /** An instance of <code>RectangleConnector</code> for testing. */
    private RectangleConnector connector;

    /** Parent node of this <code>RectangleConnector</code> for testing. */
    private ObjectFlowNode node;

    /** Rectangle width of object flow node's graph node shape. */
    private int width = 200;

    /** Rectangle height of object flow node's graph node shape. */
    private int height = 100;

    /** Allowable distance error. */
    private int epsilon = 1;

    /**
     * <p>
     * Sets up the test environment. The test instance is created.
     * </p>
     * @throws Exception
     *             to junit
     */
    protected void setUp() throws Exception {
        super.setUp();
        connector = new RectangleConnector();

        ModelElement state = new ObjectFlowStateImpl();
        // set nameCompartment text
        state.setName("NameCompartment");
        // set stereotypeCompartment text
        Stereotype stereotypeOne = new StereotypeImpl();
        stereotypeOne.setName("StereotypeCompartment");
        state.addStereotype(stereotypeOne);

        GraphNode graphNode = TestUtil.createGraphNodeForActivityState(state);
        Dimension size = new Dimension();
        size.setWidth(width);
        size.setHeight(height);
        graphNode.setSize(size);
        TestUtil.addPropertiesToGraphNode(graphNode);

        Map<String, String> properties = new HashMap<String, String>();
        properties.put("FillColor", "fill_color");
        properties.put("StrokeColor", "stroke_color");
        properties.put("FontColor", "font_color");
        properties.put("FontFamily", "font_family");
        properties.put("FontStyle", "font_style");
        properties.put("FontSize", "font_size");

        Point position = new Point(SelectionCorner.DEFAULT_RADIUS * 2, SelectionCorner.DEFAULT_RADIUS * 2);

        node = new ObjectFlowNode(graphNode, properties, position, new Rectangle());
        connector.setParent(node);
    }

    /**
     * Test method for 'RectangleConnector()'. The instance should be created successfully.
     */
    public void testRectangleConnector_Accuracy() {
        assertNotNull("Test method for 'RectangleConnector()' failed.", connector);
    }

    /**
     * Test method for 'setParent(BaseNode)'. The argument is correct, inner field should be set correctly.
     */
    public void testSetParent_Accuracy() {
        BaseNode parent = (BaseNode) TestUtil.getPrivateField(RectangleConnector.class, connector, "parent");
        assertEquals("Parent should be set correctly.", parent, node);
    }

    /**
     * Test method for 'setParent(BaseNode)'. The argument is null, IllegalArgumentException should be thrown.
     */
    public void testSetParent_null() {
        try {
            connector.setParent(null);
            fail("IllegalArgumentException should be thrown.");
        } catch (IllegalArgumentException iae) {
            // Success
        }
    }

    /**
     * Test method for 'getConnectionPoint(Point)'. The connection point should be got correctly.
     */
    public void testGetConnectionPoint_Accuracy_1() {
        Point wayPoint = node.getSelectionBound().getLocation();
        wayPoint.x += node.getLocation().x;
        wayPoint.y += node.getLocation().y;
        Point desiredPoint = new Point(wayPoint);
        wayPoint.x -= 5;
        wayPoint.y -= 5;
        Point point = connector.getConnectionPoint(wayPoint);
        assertTrue("The connection point should be got correctly.", point.distance(desiredPoint) < epsilon);
    }

    /**
     * Test method for 'getConnectionPoint(Point)'. The connection point should be got correctly.
     */
    public void testGetConnectionPoint_Accuracy_2() {
        Point wayPoint = node.getSelectionBound().getLocation();
        wayPoint.x += node.getLocation().x + node.getSelectionBound().width;
        wayPoint.y += node.getLocation().y + node.getSelectionBound().height;
        Point desiredPoint = new Point(wayPoint);
        wayPoint.x += 5;
        wayPoint.y += 5;
        Point point = connector.getConnectionPoint(wayPoint);
        assertTrue("The connection point should be got correctly.", point.distance(desiredPoint) < epsilon);
    }

    /**
     * Test method for 'getConnectionPoint(Point)'. The argument is null, IllegalArgumentException should be thrown.
     */
    public void testGetConnectionPoint_null() {
        try {
            connector.getConnectionPoint(null);
            fail("IllegalArgumentException should be thrown.");
        } catch (IllegalArgumentException iae) {
            // Success
        }
    }

    /**
     * Test method for 'getConnectionPoint(Point)'. The parent is null, IllegalStateException should be thrown.
     */
    public void testGetConnectionPoint_Parent_null() {
        try {
            (new RectangleConnector()).getConnectionPoint(new Point());
            fail("IllegalStateException should be thrown.");
        } catch (IllegalStateException ise) {
            // Success
        }
    }
}
