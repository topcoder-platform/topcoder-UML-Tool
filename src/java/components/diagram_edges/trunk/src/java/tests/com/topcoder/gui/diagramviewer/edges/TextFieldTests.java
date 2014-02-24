/*
 * Copyright (C) 2007 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.gui.diagramviewer.edges;

import java.awt.Point;
import java.io.File;

import com.topcoder.diagraminterchange.GraphNode;

import junit.framework.TestCase;
import junit.framework.TestSuite;
import junit.framework.Test;

/**
 * <p>
 * Unit test cases for TextField.
 * </p>
 *
 * @author TCSDEVELOPER
 * @version 1.0
 */
public class TextFieldTests extends TestCase {
    /**
     * <p>
     * TextField instance for testing.
     * </p>
     */
    private TextField textField;

    /**
     * <p>
     * GraphNode instance for testing.
     * </p>
     */
    private GraphNode node;

    /**
     * <p>
     * Edge instance for helping testing.
     * </p>
     */
    private Edge edge;

    /**
     * <p>
     * Setup test environment.
     * </p>
     *
     * @throws Exception to JUnit
     */
    protected void setUp() throws Exception {
        TestHelper.loadXMLConfig("test_files" + File.separator + "DiagramViewer.xml");

        edge = TestHelper.createEdge();
        node = new GraphNode();
        textField = edge.addTextField(node, "HelloWorld", AnchorType.LeftEnding);
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

        node = null;
        textField = null;
    }

    /**
     * <p>
     * Return all tests.
     * </p>
     *
     * @return all tests
     */
    public static Test suite() {
        return new TestSuite(TextFieldTests.class);
    }

    /**
     * <p>
     * Tests ctor TextField#TextField(GraphNode,String,AnchorType) for accuracy.
     * </p>
     *
     * <p>
     * Verify : the newly created TextField instance should not be null.
     * </p>
     */
    public void testCtor() {
        assertNotNull("Failed to create a new TextField instance.", textField);
    }

    /**
     * <p>
     * Tests ctor TextField#TextField(GraphNode,String,AnchorType) for failure.
     * </p>
     *
     * <p>
     * It tests the case that when graphNode is null and expects IllegalArgumentException.
     * </p>
     */
    public void testCtor_NullGraphNode() {
        try {
            new TextField(null, "HelloWorld", AnchorType.LeftEnding);
            fail("IllegalArgumentException expected.");
        } catch (IllegalArgumentException iae) {
            //good
        }
    }

    /**
     * <p>
     * Tests ctor TextField#TextField(GraphNode,String,AnchorType) for failure.
     * </p>
     *
     * <p>
     * It tests the case that when text is null and expects IllegalArgumentException.
     * </p>
     */
    public void testCtor_NullText() {
        try {
            new TextField(node, null, AnchorType.Line);
            fail("IllegalArgumentException expected.");
        } catch (IllegalArgumentException iae) {
            //good
        }
    }

    /**
     * <p>
     * Tests ctor TextField#TextField(GraphNode,String,AnchorType) for accuracy.
     * </p>
     *
     * <p>
     * It tests the case that when text is empty and expects success.
     * </p>
     */
    public void testCtor_EmptyText() {
        assertNotNull("Failed to create a new TextField instance.", new TextField(node, " ", AnchorType.Line));
    }

    /**
     * <p>
     * Tests ctor TextField#TextField(GraphNode,String,AnchorType) for failure.
     * </p>
     *
     * <p>
     * It tests the case that when type is null and expects IllegalArgumentException.
     * </p>
     */
    public void testCtor_NullType() {
        try {
            new TextField(node, "HelloWorld", null);
            fail("IllegalArgumentException expected.");
        } catch (IllegalArgumentException iae) {
            //good
        }
    }

    /**
     * <p>
     * Tests TextField#getAnchorType() for accuracy.
     * </p>
     *
     * <p>
     * Verify : TextField#getAnchorType() is correct.
     * </p>
     */
    public void testGetAnchorType() {
        assertEquals("Failed to get the anchor type.", AnchorType.LeftEnding, textField.getAnchorType());
    }

    /**
     * <p>
     * Tests TextField#setAnchorage(Point) for accuracy.
     * </p>
     *
     * <p>
     * Verify : TextField#setAnchorage(Point) is correct.
     * </p>
     */
    public void testSetAnchorage() {
        Point pt = new Point(24, 42);
        textField.setAnchorage(pt);

        assertEquals("Failed to set the anchorage.", pt, textField.getAnchorage());

        // verify the anchorage point should be cloned
        pt.x = 98;
        assertEquals("Failed to set the anchorage.", new Point(24, 42), textField.getAnchorage());
    }

    /**
     * <p>
     * Tests TextField#setAnchorage(Point) for failure.
     * </p>
     *
     * <p>
     * It tests the case that when anchorage is null and expects IllegalArgumentException.
     * </p>
     */
    public void testSetAnchorage_NullAnchorage() {
        try {
            textField.setAnchorage(null);
            fail("IllegalArgumentException expected.");
        } catch (IllegalArgumentException iae) {
            //good
        }
    }

    /**
     * <p>
     * Tests TextField#getAnchorage() for accuracy.
     * </p>
     *
     * <p>
     * Verify : TextField#getAnchorage() is correct.
     * </p>
     */
    public void testGetAnchorage() {
        textField = new TextField(node, "HelloWorld", AnchorType.LeftEnding);
        assertNull("The anchorage is null initially.", textField.getAnchorage());
    }

    /**
     * <p>
     * Tests TextField#updateAnchorage() for accuracy.
     * </p>
     *
     * <p>
     * Verify : TextField#updateAnchorage() is correct.
     * </p>
     */
    public void testUpdateAnchorage() {
        textField.setLocation(50, 50);
        textField.updateAnchorage();

        assertEquals("Failed to get the anchorage of the text field.", new Point(100, 100), textField.getAnchorage());
    }

    /**
     * <p>
     * Tests TextField#getGraphNode() for accuracy.
     * </p>
     *
     * <p>
     * Verify : TextField#getGraphNode() is correct.
     * </p>
     */
    public void testGetGraphNode() {
        assertSame("Failed to get the graph node.", node, textField.getGraphNode());
    }

    /**
     * <p>
     * Tests TextField#isSelected() for accuracy.
     * </p>
     *
     * <p>
     * Verify : TextField#isSelected() is correct.
     * </p>
     */
    public void testIsSelected() {
        assertFalse("The selected status should be false initially.", textField.isSelected());
    }

    /**
     * <p>
     * Tests TextField#setSelected(boolean) for accuracy.
     * </p>
     *
     * <p>
     * Verify : TextField#setSelected(boolean) is correct.
     * </p>
     */
    public void testSetSelected() {
        textField.setSelected(true);

        assertTrue("Failed to select the text field.", textField.isSelected());
    }
}