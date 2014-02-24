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
import com.topcoder.uml.model.core.extensionmechanisms.Stereotype;
import com.topcoder.uml.model.core.extensionmechanisms.StereotypeImpl;
import com.topcoder.uml.model.datatypes.PseudostateKind;
import com.topcoder.uml.model.statemachines.Pseudostate;
import com.topcoder.uml.model.statemachines.PseudostateImpl;

/**
 * <p>
 * Test the functionality of <code>EllipseConnector</code> class.
 * </p>
 * @author TCSDEVELOPER
 * @version 1.0
 */
public class EllipseConnectorTest extends TestCase {

    /** An instance of <code>EllipseConnector</code> for testing. */
    private EllipseConnector connector;

    /** Parent node of this <code>EllipseConnector</code> for testing. */
    private InitialNode node;

    /** Radius of initial node's graph node shape. */
    private int radius = 5;

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
        connector = new EllipseConnector();

        Pseudostate state = new PseudostateImpl();
        state.setKind(PseudostateKind.INITIAL);
        // set nameCompartment text
        state.setName("NameCompartment");
        // set stereotypeCompartment text
        Stereotype stereotypeOne = new StereotypeImpl();
        stereotypeOne.setName("StereotypeCompartment");
        state.addStereotype(stereotypeOne);

        GraphNode graphNode = TestUtil.createGraphNodeForActivityNode(state);
        Dimension size = new Dimension();
        size.setWidth(radius * 2);
        size.setHeight(radius * 2);
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

        node = new InitialNode(graphNode, properties, position, new Rectangle());
        connector.setParent(node);
    }

    /**
     * Test method for 'EllipseConnector()'. The instance should be created successfully.
     */
    public void testEllipseConnector_Accuracy() {
        assertNotNull("Test method for 'EllipseConnector()' failed.", connector);
    }

    /**
     * Test method for 'setParent(BaseNode)'. The argument is correct, inner field should be set correctly.
     */
    public void testSetParent_Accuracy() {
        BaseNode parent = (BaseNode) TestUtil.getPrivateField(EllipseConnector.class, connector, "parent");
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
    public void testGetConnectionPoint_Accuracy() {
        Point wayPoint = node.getSelectionBound().getLocation();
        wayPoint.x += node.getLocation().x;
        wayPoint.y += node.getLocation().y;
        Point point = connector.getConnectionPoint(wayPoint);
        Point desiredPoint = new Point(wayPoint);
        desiredPoint.x += radius - Math.sqrt(2) / 2 * radius;
        desiredPoint.y += radius - Math.sqrt(2) / 2 * radius;
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
            (new EllipseConnector()).getConnectionPoint(new Point());
            fail("IllegalStateException should be thrown.");
        } catch (IllegalStateException ise) {
            // Success
        }
    }
}
