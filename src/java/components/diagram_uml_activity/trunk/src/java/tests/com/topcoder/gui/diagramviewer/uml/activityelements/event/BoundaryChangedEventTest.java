/*
 * Copyright (C) 2007 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.gui.diagramviewer.uml.activityelements.event;

import java.awt.Point;
import java.awt.Rectangle;
import java.util.HashMap;
import java.util.Map;

import junit.framework.TestCase;

import com.topcoder.diagraminterchange.Dimension;
import com.topcoder.diagraminterchange.GraphNode;
import com.topcoder.gui.diagramviewer.elements.SelectionCorner;
import com.topcoder.gui.diagramviewer.uml.activityelements.InitialNode;
import com.topcoder.gui.diagramviewer.uml.activityelements.TestUtil;
import com.topcoder.uml.model.core.extensionmechanisms.Stereotype;
import com.topcoder.uml.model.core.extensionmechanisms.StereotypeImpl;
import com.topcoder.uml.model.datatypes.PseudostateKind;
import com.topcoder.uml.model.statemachines.Pseudostate;
import com.topcoder.uml.model.statemachines.PseudostateImpl;

/**
 * <p>
 * Test the functionality of <code>BoundaryChangedEvent</code> class.
 * </p>
 * @author TCSDEVELOPER
 * @version 1.0
 */
public class BoundaryChangedEventTest extends TestCase {

    /** An instance of <code>BoundaryChangedEvent</code> for testing. */
    private BoundaryChangedEvent event;

    /** Message of <code>BoundaryChangedEvent</code>. */
    private String message = "test message";

    /** Old boundary of <code>BoundaryChangedEvent</code>. */
    private Rectangle oldBoundary;

    /** New boundary of <code>BoundaryChangedEvent</code>. */
    private Rectangle newBoundary;

    /** Source of this <code>BoundaryChangedEvent</code> for testing. */
    private InitialNode node;

    /**
     * <p>
     * Sets up the test environment. The test instance is created.
     * </p>
     * @throws Exception
     *             to junit
     */
    protected void setUp() throws Exception {
        super.setUp();
        oldBoundary = new Rectangle(0, 0, 20, 10);
        newBoundary = new Rectangle(10, 10, 30, 20);

        Pseudostate state = new PseudostateImpl();
        state.setKind(PseudostateKind.INITIAL);
        // set nameCompartment text
        state.setName("NameCompartment");
        // set stereotypeCompartment text
        Stereotype stereotypeOne = new StereotypeImpl();
        stereotypeOne.setName("StereotypeCompartment");
        state.addStereotype(stereotypeOne);

        GraphNode graphNode = TestUtil.createGraphNodeForActivityNode(state);
        TestUtil.addPropertiesToGraphNode(graphNode);
        Dimension size = new Dimension();
        size.setWidth(25);
        size.setHeight(10);
        graphNode.setSize(size);

        Map<String, String> properties = new HashMap<String, String>();
        properties.put("FillColor", "fill_color");
        properties.put("StrokeColor", "stroke_color");
        properties.put("FontColor", "font_color");
        properties.put("FontFamily", "font_family");
        properties.put("FontStyle", "font_style");
        properties.put("FontSize", "font_size");

        Point position = new Point(SelectionCorner.DEFAULT_RADIUS, SelectionCorner.DEFAULT_RADIUS);

        node = new InitialNode(graphNode, properties, position, new Rectangle());

        event = new BoundaryChangedEvent(node, message, oldBoundary, newBoundary);
    }

    /**
     * Test method for 'BoundaryChangedEvent(BaseNode, Rectangle, Rectangle)'. The instance should be created
     * successfully.
     */
    public void testBoundaryChangedEvent_Accuracy() {
        assertNotNull("Test method for 'BoundaryChangedEvent(BaseNode, Rectangle, Rectangle)' failed.", event);
    }

    /**
     * Test method for 'BoundaryChangedEvent(BaseNode, Rectangle, Rectangle)'. The source is null,
     * IllegalArgumentException should be thrown.
     */
    public void testBoundaryChangedEvent_null_1() {
        try {
            new BoundaryChangedEvent(null, null, oldBoundary, newBoundary);
            fail("IllegalArgumentException should be thrown.");
        } catch (IllegalArgumentException iae) {
            // Success
        }
    }

    /**
     * Test method for 'BoundaryChangedEvent(BaseNode, Rectangle, Rectangle)'. The old boundary is null,
     * IllegalArgumentException should be thrown.
     */
    public void testBoundaryChangedEvent_null_2() {
        try {
            new BoundaryChangedEvent(node, null, null, newBoundary);
            fail("IllegalArgumentException should be thrown.");
        } catch (IllegalArgumentException iae) {
            // Success
        }
    }

    /**
     * Test method for 'BoundaryChangedEvent(BaseNode, Rectangle, Rectangle)'. The new boundary is null,
     * IllegalArgumentException should be thrown.
     */
    public void testBoundaryChangedEvent_null_3() {
        try {
            new BoundaryChangedEvent(node, null, oldBoundary, null);
            fail("IllegalArgumentException should be thrown.");
        } catch (IllegalArgumentException iae) {
            // Success
        }
    }

    /**
     * Test method for 'getMessage()', message should be got correctly.
     */
    public void testGetMessage() {
        assertEquals("Message should be got correctly.", event.getMessage(), message);
    }

    /**
     * Test method for 'getOldBoundary()', old boundary should be got correctly.
     */
    public void testGetOldBoundary() {
        assertEquals("Old boundary should be got correctly.", event.getOldBoundary(), oldBoundary);
    }

    /**
     * Test method for 'getNewBoundary()', new boundary should be got correctly.
     */
    public void testGetNewBoundary() {
        assertEquals("New boundary should be got correctly.", event.getNewBoundary(), newBoundary);
    }

}
