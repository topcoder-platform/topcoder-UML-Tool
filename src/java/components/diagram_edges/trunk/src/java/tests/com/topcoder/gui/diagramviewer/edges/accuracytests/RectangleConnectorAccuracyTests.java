/*
 * Copyright (C) 2007 TopCoder Inc., All Rights Reserved.
 *
 * TCS Diagram_Edges Version 1.0 Accuracytests.
 *
 * @ RectangleConnectorAccuracyTests.java
 */
package com.topcoder.gui.diagramviewer.edges.accuracytests;

import com.topcoder.gui.diagramviewer.edges.connectors.RectangleConnector;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

import java.awt.Point;
import java.awt.Rectangle;


/**
 * <p>
 * The <code>RectangleConnector</code>'s Accuracy Tests.
 * This accuracy tests addresses the functionality provided
 * by the <code>RectangleConnector</code> class.
 * </p>
 *
 * @author zmg
 * @version 1.0
 */
public class RectangleConnectorAccuracyTests extends TestCase {
    /**
     * <p>
     * Represents an instance of <code>RectangleConnector</code> uses for accuracy tests.
     * </p>
     */
    private RectangleConnector test = null;

    /**
     * <p>
     * Represents an instance of <code>Rectangle</code> uses for accuracy tests.
     * </p>
     */
    private Rectangle rectangle = null;

    /**
     * <p>
     * Test suite of <code>RectangleConnectorAccuracyTests</code>.
     * </p>
     *
     * @return Test suite of <code>RectangleConnectorAccuracyTests</code>.
     */
    public static Test suite() {
        return new TestSuite(RectangleConnectorAccuracyTests.class);
    }

    /**
     * <p>
     * Initialization for all tests here.
     * </p>
     */
    protected void setUp() {
        rectangle = new Rectangle(0, 0, 4, 3);
        test = new RectangleConnector(rectangle);
    }

    /**
     * <p>
     * Accuracy Test of the <code>LineStyle</code>'s constructor.
     * </p>
     */
    public void testConstructor() {
        // creat a new instance to check the constructor.
        assertNotNull("Constructor should work well.", test);

        // get the attribute rectangle to check the constructor.
        assertEquals("The rectangle should be equals.", rectangle,
            test.getRectangle());

        assertTrue("", rectangle.contains(new Point(2, 2)));
    }

    /**
     * <p>
     * Accuracy Test of the <code>setRectangle(Rectangle)</code> and <code>getRectangle()</code>
     * methods.
     * </p>
     */
    public void testRectangle_Operation() {
        // get the attribute rectangle to check the constructor.
        assertEquals("The rectangle should be equals.", rectangle,
            test.getRectangle());

        rectangle = new Rectangle(5, 3);
        // set the dashLength.
        test.setRectangle(rectangle);
        //  get the attribute rectangle to check the constructor.
        assertEquals("The rectangle should be equals.", rectangle,
            test.getRectangle());
    }

    /**
     * <p>
     * Accuracy Test of the <code>getConnectionPoint(Point)</code>
     * method.
     * It tests with the point up the rectangle.
     * </p>
     */
    public void testgetConnectionPoint_Up() {
        // creat a new wayPoint.
        Point point = new Point(2, 6);

        // get the nearest connection point.
        Point connection = test.getConnectionPoint(point);
        //  get the position of the connection point to check the constructor.
        assertEquals("The connection point should be at (2, 4).", 2,
            connection.x);
        assertEquals("The connection point should be at (2, 3).", 3,
            connection.y);
    }

    /**
     * <p>
     * Accuracy Test of the <code>getConnectionPoint(Point)</code>
     * method.
     * It tests with the point below the rectangle.
     * </p>
     */
    public void testgetConnectionPoint_Down() {
        // creat a new wayPoint.
        Point point = new Point(2, -2);

        // get the nearest connection point
        Point connection = test.getConnectionPoint(point);
        //  get the position of the connection point to check the method.
        assertEquals("The connection point should be at (2, 0).", 2,
            connection.x);
        assertEquals("The connection point should be at (2, 0).", 0,
            connection.y);
    }

    /**
     * <p>
     * Accuracy Test of the <code>getConnectionPoint(Point)</code>
     * method.
     * It tests with the point on the left of this rectangle.
     * </p>
     */
    public void testgetConnectionPoint_Left() {
        // creat a new wayPoint.
        Point point = new Point(-2, 2);

        // get the nearest connection point
        Point connection = test.getConnectionPoint(point);
        //  get the position of the connection point to check the method.
        assertEquals("The connection point should be at (0, 2).", 0,
            connection.x);
        assertEquals("The connection point should be at (0, 2).", 2,
            connection.y);
    }

    /**
     * <p>
     * Accuracy Test of the <code>getConnectionPoint(Point)</code>
     * method.
     * It tests with the point on the right of this rectangle.
     * </p>
     */
    public void testgetConnectionPoint_Right() {
        // creat a new wayPoint.
        Point point = new Point(5, 2);

        // get the nearest connection point
        Point connection = test.getConnectionPoint(point);
        //  get the position of the connection point to check the method.
        assertEquals("The connection point should be at (4, 2).", 4,
            connection.x);
        assertEquals("The connection point should be at (3, 2).", 2,
            connection.y);
    }
}
