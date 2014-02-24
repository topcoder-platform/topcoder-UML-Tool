/*
 * Copyright (C) 2007 TopCoder Inc., All Rights Reserved.
 *
 * TCS Diagram_Edges Version 1.0 Accuracytests.
 *
 * @ EdgeAccuracyTests.java
 */
package com.topcoder.gui.diagramviewer.edges.accuracytests;

import com.topcoder.diagraminterchange.GraphEdge;
import com.topcoder.diagraminterchange.GraphNode;

import com.topcoder.gui.diagramviewer.edges.AnchorType;
import com.topcoder.gui.diagramviewer.edges.Edge;
import com.topcoder.gui.diagramviewer.edges.LineStyle;
import com.topcoder.gui.diagramviewer.edges.TextField;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

import java.awt.Dimension;
import java.awt.Point;
import java.awt.geom.Line2D;

import javax.swing.JFrame;


/**
 * <p>
 * The <code>Edge</code>'s Accuracy Tests.
 * This accuracy tests addresses the functionality provided
 * by the <code>Edge</code> class.
 * </p>
 *
 * @author zmg
 * @version 1.0
 */
public class EdgeAccuracyTests extends TestCase {
    /**
     * <p>
     * Represents a text uses for creating <code>TextField</code>.
     * </p>
     */
    private static String text = "AccuracyTests";

    /**
     * <p>
     * Represents an instance of <code>Edge</code> uses for accuracy tests.
     * </p>
     */
    private Edge test = null;

    /**
     * <p>
     * Represents an instance of <code>GraphEdge</code> uses for accuracy tests.
     * </p>
     */
    private GraphEdge graphEdge = null;

    /**
     * <p>
     * Represents an instance of <code>GraphNode</code> uses for
     * creating <code>TextField</code>.
     * </p>
     */
    private GraphNode graphNode = null;

    /**
     * <p>
     * Represents an instance of <code>GraphNode</code> uses for
     * creating <code>TextField</code>.
     * </p>
     */
    private GraphNode graphNode1 = null;

    /**
     * <p>
     * Represents an instance of <code>GraphNode</code> uses for
     * creating <code>TextField</code>.
     * </p>
     */
    private GraphNode graphNode2 = null;

    /**
     * <p>
     * Represents an instance of <code>GraphNode</code> uses for
     * creating <code>TextField</code>.
     * </p>
     */
    private GraphNode graphNode3 = null;

    /**
     * <p>
     * Represents an instance of <code>GraphNode</code> uses for
     * creating <code>TextField</code>.
     * </p>
     */
    private GraphNode graphNode4 = null;

    /**
     * <p>
     * Represents an instance of <code>TextField</code> uses for test.
     * </p>
     */
    private TextField textField1 = null;

    /**
     * <p>
     * Represents an instance of <code>TextField</code> uses for test.
     * </p>
     */
    private TextField textField2 = null;

    /**
     * <p>
     * Represents an instance of <code>TextField</code> uses for test.
     * </p>
     */
    private TextField textField3 = null;

    /**
     * <p>
     * Represents an instance of <code>TextField</code> uses for test.
     * </p>
     */
    private TextField textField4 = null;

    /**
     * <p>
     * Test suite of <code>EdgeAccuracyTests</code>.
     * </p>
     *
     * @return Test suite of <code>EdgeAccuracyTests</code>.
     */
    public static Test suite() {
        return new TestSuite(EdgeAccuracyTests.class);
    }

    /**
     * <p>
     * Initialization for all tests here.
     * </p>
     */
    protected void setUp() {
        graphNode = new GraphNode();
        graphEdge = TestHelper.getGraphEdge();
        test = new MockEdge(graphEdge, new LineStyle(5, 2), null, null);
    }

    /**
     * <p>
     * Accuracy Test of the <code>Edge</code>'s constructor.
     * </p>
     */
    public void testConstructor() {
        // creat a new instance to check the constructor.
        assertNotNull("Constructor should work well.", test);

        //  get the contained waypoints to check the constructor.
        assertEquals("The contained waypoints should be 4.", 4,
            test.getWayPoints().size());
    }

    /**
     * <p>
     * Accuracy Test of the <code>contains(int, int)</code>
     * method.
     * </p>
     */
    public void testContains() {
        //  check the edge contains the point or not.
        assertTrue("The edge should contain this point.", test.contains(2, 3));
        // check the edge contains the point or not.
        assertTrue("The edge should contain this point.", test.contains(15, 7));
        // check the edge contains the point or not.
        assertTrue("The edge should contain this point.", test.contains(33, 0));
        double number = Line2D.ptSegDist(0, 0, 10, 10, -3, 0);
        System.out.println("number" + number);
        // set the active width.
        test.setActiveWidth(1);

        // check the edge contains the point or not.
        assertFalse("The edge should not contain this point.",
            test.contains(15, 7));
    }

    /**
     * <p>
     * Accuracy Test of the <code>addTextField()</code> method.
     * </p>
     */
    public void testAddTextField_Line() {
        graphNode.setPosition(TestHelper.getWaypoint(12, 13));
        graphNode.setContainer(graphEdge);

        TextField textField = test.addTextField(graphNode, text, AnchorType.Line);
        // get the contained graphNode to check the constructor.
        assertEquals("The contained graphNode should be equals.", graphNode,
            textField.getGraphNode());

        // get the anchorage point.
        Point anchorage = textField.getAnchorage();
        //  get the position of the anchorage point to check the method.
        assertEquals("The anchorage point should be at (12, 10).", 12,
            anchorage.x);
        assertEquals("The anchorage point should be at (12, 10).", 10,
            anchorage.y);
    }

    /**
     * <p>
     * Accuracy Test of the <code>addTextField()</code> method.
     * </p>
     */
    public void testAddTextField_LeftEnding() {
        graphNode.setPosition(TestHelper.getWaypoint(25, 13));

        TextField textField = test.addTextField(graphNode, text,
                AnchorType.LeftEnding);
        // get the contained graphNode to check the constructor.
        assertEquals("The contained graphNode should be equals.", graphNode,
            textField.getGraphNode());

        // get the anchorage point.
        Point anchorage = textField.getAnchorage();
        // get the position of the anchorage point to check the method.
        assertEquals("The anchorage point should be at (0, 0).", 0, anchorage.x);
        assertEquals("The anchorage point should be at (0, 0).", 0, anchorage.y);
    }

    /**
     * <p>
     * Accuracy Test of the <code>addTextField()</code> method.
     * </p>
     */
    public void testAddTextField_RightEnding() {
        graphNode.setPosition(TestHelper.getWaypoint(5, 7));

        TextField textField = test.addTextField(graphNode, text,
                AnchorType.RightEnding);
        // get the contained graphNode to check the constructor.
        assertEquals("The contained graphNode should be equals.", graphNode,
            textField.getGraphNode());

        // get the anchorage point.
        Point anchorage = textField.getAnchorage();
        //  get the position of the anchorage point to check the method.
        assertEquals("The anchorage point should be at (30, 0).", 30,
            anchorage.x);
        assertEquals("The anchorage point should be at (0, 0).", 0, anchorage.y);
    }

    /**
     * <p>
     * Accuracy Test of the <code>getSize()</code> method.
     * </p>
     */
    public void testGetSize() {
        // get the size to check the method.
        assertEquals("The size should be equals.", new Dimension(0, 0),
            test.getSize());

        // add the edge to a frame.
        JFrame compon = new JFrame();
        compon.setSize(new Dimension(10, 10));
        compon.add(test);
        // get the size to check the method.
        assertEquals("The size should be equals.", new Dimension(0, 0),
            test.getSize());
    }

    /**
     * <p>
     * Accuracy Test of the <code>notifyRemoveWayPoint()</code> method.
     * </p>
     */
    public void testNotifyRemoveWayPoint() {
        addTextFieldToEdge();
        graphEdge.removeWaypoint(1);
        test.notifyRemoveWayPoint(1, new Point(10, 10));
        // get the number of way point to check the method.
        assertEquals("The number of way point should be 3.", 3,
            test.getWayPoints().size());

        // get the textField1 to check the method.
        assertTrue("The textField1 should be there, can not be removed.",
            checkTextFieldForEqual(textField1, test.getTextField(graphNode1)));
        //  get the textField4 to check the method.
        assertTrue("The textField4 should be there, can not be removed.",
            checkTextFieldForEqual(textField4, test.getTextField(graphNode4)));
    }

    /**
     * <p>
     * Accuracy Test of the <code>notifyRemoveWayPoint()</code> method.
     * </p>
     */
    public void testNotifyRemoveWayPoint_LeftEnding() {
        addTextFieldToEdge();
        graphEdge.removeWaypoint(0);
        test.notifyRemoveWayPoint(0, new Point(0, 0));
        // get the number of way point to check the method.
        assertEquals("The number of way point should be 3.", 3,
            test.getWayPoints().size());

        // get the textField2 to check the method.
        assertTrue("The textField2 should be there, can not be removed.",
            checkTextFieldForEqual(textField2, test.getTextField(graphNode2)));

        //get the textField4 to check the method.
        assertTrue("The textField4 should be there, can not be removed.",
            checkTextFieldForEqual(textField4, test.getTextField(graphNode4)));
    }

    /**
     * <p>
     * Accuracy Test of the <code>notifyRemoveWayPoint()</code> method.
     * </p>
     */
    public void testNotifyAddWayPoint() {
        addTextFieldToEdge();

        graphEdge.addWaypoint(2, TestHelper.getWaypoint(10, 30));
        test.notifyAddWayPoint(2);
        // get the number of way point to check the method.
        assertEquals("The number of way point should be 5.", 5,
            test.getWayPoints().size());

        // get the textField1 to check the method.
        assertTrue("The textField1 should be there, can not be removed.",
            checkTextFieldForEqual(textField1, test.getTextField(graphNode1)));

        // get the textField4 to check the method.
        assertTrue("The textField4 should be there, can not be removed.",
            checkTextFieldForEqual(textField4, test.getTextField(graphNode4)));
    }

    /**
     * <p>
     * Accuracy Test of the <code>notifyChangeWayPoint()</code> method.
     * </p>
     */
    public void testNotifyChangeWayPoint() {
        addTextFieldToEdge();

        graphEdge.setWaypoint(2, TestHelper.getWaypoint(10, 20));
        test.notifyChangeWayPoint(2, new Point(20, 10));
        // get the number of way point to check the method.
        assertEquals("The number of way point should be 4.", 4,
            test.getWayPoints().size());
    }

    /**
     * <p>
     * Accuracy Test of the <code>addTextField()</code>, <code>getTextField()</code>
     * and <code>removeTextField()</code>methods.
     * </p>
     */
    public void testTextField_Operation() {
        addTextFieldToEdge();
        // get the textField2 to check the method.
        assertTrue("The textField2 should be there.",
                checkTextFieldForEqual(textField2, test.getTextField(graphNode2)));

        // get the textField4 to check the method.
        assertTrue("The textField4 should be there.",
                checkTextFieldForEqual(textField4, test.getTextField(graphNode4)));

        // remove the textField2.
        test.removeTextField(graphNode2);
        //  get the textField2 to check the method.
        assertNull("The textField2 should not exist.", test.getTextField(graphNode2));

        // remove the textField4.
        test.removeTextField(graphNode4);
        // get the textField4 to check the method.
        assertNull("The textField4 should not exist.", test.getTextField(graphNode4));
    }

    /**
     * <p>
     * Helper method use to add some textField to the edge.
     * </p>
     */
    public void addTextFieldToEdge() {
        graphNode1 = new GraphNode();
        graphNode1.setContainer(graphEdge);
        graphNode1.setPosition(TestHelper.getWaypoint(25, 13));

        textField1 = test.addTextField(graphNode1, text, AnchorType.LeftEnding);

        graphNode2 = new GraphNode();
        graphNode2.setContainer(graphEdge);
        graphNode2.setPosition(TestHelper.getWaypoint(12, 13));

        // the anchorage will be set to (12, 10).
        textField2 = test.addTextField(graphNode2, text, AnchorType.Line);

        graphNode3 = new GraphNode();
        graphNode3.setContainer(graphEdge);
        graphNode3.setPosition(TestHelper.getWaypoint(8, 6));

        // the anchorage will be set to (7, 7).
        textField3 = test.addTextField(graphNode3, text, AnchorType.Line);

        graphNode4 = new GraphNode();
        graphNode4.setContainer(graphEdge);
        graphNode4.setPosition(TestHelper.getWaypoint(5, 7));

        textField4 = test.addTextField(graphNode4, text, AnchorType.RightEnding);
    }

    /**
     * <p>
     * Helper method use to check the given textFields equal or not.
     * </p>
     *
     * @param textField1 a textField to be compared.
     * @param textField2 a textField to be compared.
     *
     * @return true if the given textFields are equal, false otherwise.
     */
    public boolean checkTextFieldForEqual(TextField textField1,
        TextField textField2) {
        if ((textField1.getAnchorage().equals(textField2.getAnchorage())) &&
                (textField1.getGraphNode().equals(textField2.getGraphNode()))) {
            return true;
        }
        return false;
    }
}
