/*
 * Copyright (C) 2007 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.gui.diagramviewer.uml.activityelements;

import java.awt.Font;
import java.util.HashMap;
import java.util.Map;

import com.topcoder.diagraminterchange.Dimension;
import com.topcoder.diagraminterchange.GraphEdge;
import com.topcoder.diagraminterchange.GraphNode;
import com.topcoder.diagraminterchange.Point;
import com.topcoder.diagraminterchange.Property;

import junit.framework.TestCase;

/**
 * <p>
 * Test the functionality of <code>Transition</code> class.
 * </p>
 * @author TCSDEVELOPER
 * @version 1.0
 */
public class TransitionTest extends TestCase {

    /** An instance of <code>Transition</code> for testing. */
    private Transition transition;

    /** A GraphEdge for <code>Transition</code>. */
    private GraphEdge graphEdge;

    /** Properties for testing. */
    private final Map<String, String> properties = new HashMap<String, String>();

    /**
     * <p>
     * Sets up the test environment. The test instance is created.
     * </p>
     * @throws Exception
     *             to junit
     */
    protected void setUp() throws Exception {
        super.setUp();

        graphEdge = TestUtil.createGraphEdgeForTransition();
        transition = new Transition(graphEdge);
        transition.setFont(new Font("Arial", Font.PLAIN, 10));

        addPropertiesToGraphEdge(graphEdge);

        properties.put("FillColor", "fill_color");
        properties.put("StrokeColor", "stroke_color");
        properties.put("FontColor", "font_color");
        properties.put("FontFamily", "font_family");
        properties.put("FontStyle", "font_style");
        properties.put("FontSize", "font_size");

        transition.setProperties(properties);
    }

    /**
     * <p>
     * This method adds properties for testing to given graph edge.
     * <p>
     * The fill color is red, stroke color is green, font color is blue, font family is Courier, font style is BOLD, and
     * font size is 12.0
     * </p>
     * </p>
     * @param graphEdge
     *            a graph edge to add properties
     */
    private static void addPropertiesToGraphEdge(GraphEdge graphEdge) {
        // Red Color
        Property fillColor = TestUtil.createProperty("fill_color", "#FF0000");
        graphEdge.addProperty(fillColor);
        // Green Color
        Property strokeColor = TestUtil.createProperty("stroke_color", "#00FF00");
        graphEdge.addProperty(strokeColor);
        // Blue Color
        Property fontColor = TestUtil.createProperty("font_color", "#0000FF");
        graphEdge.addProperty(fontColor);

        Property fontFamily = TestUtil.createProperty("font_family", "Arial");
        graphEdge.addProperty(fontFamily);

        Property fontStyle = TestUtil.createProperty("font_style", "1");
        graphEdge.addProperty(fontStyle);

        Property fontSize = TestUtil.createProperty("font_size", "12.0");
        graphEdge.addProperty(fontSize);
    }

    /**
     * Test method for 'Transition(GraphEdge)'. The instance should be created successfully.
     */
    public void testTransition_Accuracy() {
        assertNotNull("Test method for 'Transition(GraphEdge)' failed.", transition);
    }

    /**
     * Test method for 'Transition(GraphEdge)'. The argument is null, IllegalArgumentException should be thrown.
     */
    public void testTransition_null() {
        try {
            new Transition(null);
            fail("IllegalArgumentException should be thrown.");
        } catch (IllegalArgumentException iae) {
            // Success
        } catch (IllegalGraphElementException e) {
            fail(e.getMessage());
        }
    }

    /**
     * Test method for 'getNameCompartment()', name compartment should be got correctly.
     */
    public void testGetNameCompartment() {
        assertNotNull("Test method for 'getNameCompartment()' failed.", transition.getNameCompartment());
    }

    /**
     * Test method for 'getDescriptionCompartment()', description compartment should be got correctly.
     */
    public void testGetDescriptionCompartment() {
        assertNotNull("Test method for 'getDescriptionCompartment()' failed.", transition.getDescriptionCompartment());
    }

    /**
     * Test method for 'getStereotypeCompartment()', stereotype compartment should be got correctly.
     */
    public void testGetStereotypeCompartment() {
        assertNotNull("Test method for 'getStereotypeCompartment()' failed.", transition.getStereotypeCompartment());
    }

    /**
     * Test method for 'notifyGraphEdgeChange()', the compartments should change accordingly.
     */
    public void testNotifyGraphEdgeChange() {
        graphEdge.removeContained(2);
        // create a new stereotype node
        GraphNode node = new GraphNode();
        node.setSemanticModel(TestUtil.createSimpleSemanticModel("StereotypeCompartment"));
        Point pos = new Point();
        pos.setX(5);
        pos.setY(5);
        node.setPosition(pos);
        Dimension size = new Dimension();
        size.setWidth(10);
        size.setHeight(5);
        node.setSize(size);
        graphEdge.addContained(2, node);
        node.setContainer(graphEdge);
        TextField oldCompartment = transition.getStereotypeCompartment();
        transition.notifyGraphEdgeChange();
        TextField newCompartment = transition.getStereotypeCompartment();
        assertEquals("Test method for 'testNotifyGraphEdgeChange()' failed.", oldCompartment, newCompartment);
    }

}
