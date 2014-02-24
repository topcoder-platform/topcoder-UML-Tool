/*
 * Copyright (C) 2007 TopCoder Inc., All Rights Reserved.
 *
 * TCS Diagram_Edges Version 1.0 Accuracytests.
 *
 * @ TextFieldAccuracyTests.java
 */
package com.topcoder.gui.diagramviewer.edges.accuracytests;

import com.topcoder.diagraminterchange.GraphNode;

import com.topcoder.gui.diagramviewer.edges.AnchorType;
import com.topcoder.gui.diagramviewer.edges.Edge;
import com.topcoder.gui.diagramviewer.edges.TextField;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

import java.awt.Color;
import java.awt.Point;


/**
 * <p>
 * The <code>TextField</code>'s Accuracy Tests.
 * This accuracy tests addresses the functionality provided
 * by the <code>TextField</code> class.
 * </p>
 *
 * @author zmg
 * @version 1.0
 */
public class TextFieldAccuracyTests extends TestCase {
    /**
     * <p>
     * Represents a text uses for creating <code>TextField</code>.
     * </p>
     */
    private static String text = "AccuracyTests";

    /**
     * <p>
     * Represents an instance of <code>TextField</code> uses for accuracy tests.
     * </p>
     */
    private TextField test = null;

    /**
     * <p>
     * Represents an instance of <code>Edge</code> uses for accuracy tests.
     * </p>
     */
    private Edge edge = null;

    /**
     * <p>
     * Represents an instance of <code>GraphNode</code> uses for
     * creating <code>TextField</code>.
     * </p>
     */
    private GraphNode graphNode = null;

    /**
     * <p>
     * Test suite of <code>TextFieldAccuracyTests</code>.
     * </p>
     *
     * @return Test suite of <code>TextFieldAccuracyTests</code>.
     */
    public static Test suite() {
        return new TestSuite(TextFieldAccuracyTests.class);
    }

    /**
     * <p>
     * Initialization for all tests here.
     * </p>
     */
    protected void setUp() {
        graphNode = new GraphNode();
        test = new TextField(graphNode, text, AnchorType.LeftEnding);
        edge = TestHelper.getEdge();
        edge.add(test);
    }

    /**
     * <p>
     * Accuracy Test of the <code>TextField</code>'s constructor.
     * </p>
     */
    public void testConstructor() {
        // creat a new instance to check the constructor.
        assertNotNull("Constructor should work well.", test);

        // get the attribute graphNode to check the constructor.
        assertEquals("The graphNode should be equals.", graphNode,
            test.getGraphNode());
        // get the attribute anchorType to check the constructor.
        assertEquals("The anchorType should be equals.", AnchorType.LeftEnding,
            test.getAnchorType());
        // get the attribute anchorage to check the constructor.
        assertNull("The anchorage should be null.", test.getAnchorage());
        // get the attribute isSelected to check the constructor.
        assertFalse("The isSelected should be false.", test.isSelected());
    }

    /**
     * <p>
     * Accuracy Test of the <code>setAnchorage(Point)</code> and <code>getAnchorage()</code>
     * methods.
     * </p>
     */
    public void testAnchorage_Operation() {
        // get the attribute anchorage to check the get operation.
        assertNull("The anchorage should be null.", test.getAnchorage());
        // set the anchorage.
        test.setAnchorage(new Point(1, 2));
        //  get the attribute anchorage to check the set operation.
        assertEquals("The anchorage should be set to Point(1, 2).",
            new Point(1, 2), test.getAnchorage());
    }

    /**
     * <p>
     * Accuracy Test of the <code>setSelected(boolean)</code> and <code>isSelected()</code>
     * methods.
     * </p>
     */
    public void testSelected_Operation() {
        // set the isSelected.
        test.setSelected(true);
        // get the attribute isSelected to check the set operation.
        assertTrue("The isSelected should be true.", test.isSelected());
        // get the background to check the set operation.
        assertEquals("The background should be set to Color.YELLOW.",
            Color.YELLOW, test.getBackground());

        // set the isSelected.
        test.setSelected(false);
        // get the attribute isSelected to check the set operation.
        assertFalse("The isSelected should be false.", test.isSelected());
        //  get the background to check the default value.
        assertEquals("The background should be set to Color(0, 0, 0, 0).",
            new Color(0, 0, 0, 0), test.getBackground());
    }

    /**
     * <p>
     * Accuracy Test of the <code>updateAnchorage()</code>
     * method. It tests when the anchorage point on the line.
     * </p>
     */
    public void testupdateAnchorage_OnLine() {
        // creat the TextField with the AnchorType.Line.
        test = new TextField(graphNode, text, AnchorType.Line);
        edge = TestHelper.getEdge();
        edge.add(test);

        // move the location to (12, 13).
        test.setLocation(12, 13);
        test.updateAnchorage();

        // get the anchorage point.
        Point anchorage = test.getAnchorage();
        // get the position of the anchorage point to check the method.
        assertEquals("The anchorage point should be at (12, 10).", 12,
            anchorage.x);
        assertEquals("The anchorage point should be at (12, 10).", 10,
            anchorage.y);

        //  move the location to (22, 13).
        test.setLocation(22, 13);
        test.updateAnchorage();

        // get the anchorage point.
        anchorage = test.getAnchorage();
        // get the position of the anchorage point to check the method.
        assertEquals("The anchorage point should be at (20, 10).", 20,
            anchorage.x);
        assertEquals("The anchorage point should be at (20, 10).", 10,
            anchorage.y);
    }

    /**
     * <p>
     * Accuracy Test of the <code>updateAnchorage()</code>
     * method. It tests when the anchorage point on the LeftEnding.
     * </p>
     */
    public void testupdateAnchorage_LeftEnding() {
        // the TextField is with the AnchorType.LeftEnding.

        // move the location to (25, 13).
        test.setLocation(25, 13);
        test.updateAnchorage();

        // get the anchorage point.
        Point anchorage = test.getAnchorage();
        // get the position of the anchorage point to check the method.
        assertEquals("The anchorage point should be at (0, 0).", 0, anchorage.x);
        assertEquals("The anchorage point should be at (0, 0).", 0, anchorage.y);
    }

    /**
     * <p>
     * Accuracy Test of the <code>updateAnchorage()</code>
     * method. It tests when the anchorage point on the RightEnding.
     * </p>
     */
    public void testupdateAnchorage_RightEnding() {
        // creat the TextField with the AnchorType.RightEnding.
        test = new TextField(graphNode, text, AnchorType.RightEnding);
        edge = TestHelper.getEdge();
        edge.add(test);

        // move the location to (5, 7).
        test.setLocation(5, 7);
        test.updateAnchorage();

        // get the anchorage point.
        Point anchorage = test.getAnchorage();
        // get the position of the anchorage point to check the method.
        assertEquals("The anchorage point should be at (30, 0).", 30,
            anchorage.x);
        assertEquals("The anchorage point should be at (0, 0).", 0, anchorage.y);
    }
}
