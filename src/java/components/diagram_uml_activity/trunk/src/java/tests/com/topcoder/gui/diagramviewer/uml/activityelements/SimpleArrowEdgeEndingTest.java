/*
 * Copyright (C) 2007 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.gui.diagramviewer.uml.activityelements;

import java.awt.Point;

import javax.swing.JComponent;
import javax.swing.JDialog;
import javax.swing.JFrame;

import junit.extensions.jfcunit.JFCTestCase;
import junit.extensions.jfcunit.finder.NamedComponentFinder;

/**
 * <p>
 * Test the functionality of <code>SimpleArrowEdgeEnding</code> class.
 * </p>
 * @author TCSDEVELOPER
 * @version 1.0
 */
public class SimpleArrowEdgeEndingTest extends JFCTestCase {
    /** An instance of <code>SimpleArrowEdgeEnding</code> for testing. */
    private SimpleArrowEdgeEnding edgeEnding;

    /** Ending point. */
    private Point endingPoint;

    /**
     * <p>
     * Sets up the test environment. The test instance is created.
     * </p>
     * @throws Exception
     *             to junit
     */
    protected void setUp() throws Exception {
        super.setUp();
        endingPoint = new Point(20, 20);
        edgeEnding = new SimpleArrowEdgeEnding(-3 * Math.PI / 4, endingPoint);
    }

    /**
     * Test method for 'SimpleArrowEdgeEnding(double, Point)'. The instance should be created successfully.
     */
    public void testSimpleArrow_Accuracy() {
        assertNotNull("Test method for 'RectangleConnector()' failed.", edgeEnding);
    }

    /**
     * Test method for 'SimpleArrowEdgeEnding(double, Point)'. The endingPoint argument is null,
     * IllegalArgumentException should be thrown.
     */
    public void testSimpleArrow_null() {
        try {
            new SimpleArrowEdgeEnding(0, null);
            fail("IllegalArgumentException should be thrown.");
        } catch (IllegalArgumentException iae) {
            // Success
        }
    }

    /**
     * Test method for 'contains(int, int)'. Inner point is given, should be true.
     */
    public void testContains_True() {
        Point point = new Point(endingPoint.x + 1, endingPoint.y + 1);
        assertTrue("The given point should be contained.", edgeEnding.contains(point.x, point.y));
    }

    /**
     * Test method for 'contains(int, int)'. Outer point is given, should be false.
     */
    public void testContains_False() {
        Point point = new Point(endingPoint.x - 1, endingPoint.y - 1);
        assertFalse("The given point should not be contained.", edgeEnding.contains(point.x, point.y));
    }

    /**
     * Test the GUI. The component should be displayed correctly.
     */
    public void testGUI() {
        edgeEnding.setName("SimpleArrowEdgeEnding");
        JDialog dialog = new JDialog((JFrame) null, "SimpleArrowEdgeEnding", true);
        dialog.setSize(200, 200);
        dialog.getContentPane().add(edgeEnding);
        dialog.setModal(false);
        dialog.setVisible(true);
        NamedComponentFinder finder = new NamedComponentFinder(JComponent.class, "SimpleArrowEdgeEnding");
        SimpleArrowEdgeEnding ending = (SimpleArrowEdgeEnding) finder.find(dialog, 0);
        assertNotNull("SendSignalAction component should be displayed", ending);
        sleep(100);
        dialog.dispose();
    }
}
