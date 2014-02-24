/*
 * Copyright (C) 2007 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.gui.diagramviewer.uml.usecaseelements;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.Rectangle;

import javax.swing.JFrame;

import junit.framework.TestCase;

/**
 * <p>
 * Unit test cases for SimpleArrow.
 * </p>
 *
 * @author TCSDEVELOPER
 * @version 1.0
 */
public class SimpleArrowTests extends TestCase {
    /**
     * <p>
     * Represents an instance of <code>SimpleArrow</code> uses for accuracy tests.
     * </p>
     */
    private SimpleArrow simpleArrow;

    /**
     * <p>
     * Represents another instance of <code>SimpleArrow</code> uses for accuracy tests.
     * </p>
     */
    private SimpleArrow simpleArrow1;

    /**
     * <p>
     * Sets up test environment.
     * </p>
     */
    protected void setUp() {
        simpleArrow = new SimpleArrow();
        simpleArrow1 = new SimpleArrow();
        simpleArrow1.setAngle(Math.toRadians(90));
        simpleArrow1.setEndingPoint(new Point(20, 20));
    }

    /**
     * <p>
     * Tears down test environment.
     * </p>
     */
    protected void tearDown() {
        simpleArrow = null;
        simpleArrow1 = null;
    }

    /**
     * <p>
     * Tests {@link SimpleArrow#SimpleArrow()} for accuracy.
     * </p>
     * <p>
     * It verifies the newly created SimpleArrow is not null.
     * </p>
     */
    public void testCtor() {
        assertNotNull("Failed to create a simple arrow instance.", simpleArrow);
    }

    /**
     * <p>
     * Tests {@link SimpleArrow#paintComponent(java.awt.Graphics)} for accuracy.
     * </p>
     * <p>
     * It provides the graphics, and ensures no exception will be thrown.
     * </p>
     */
    public void testPaintComponent() {
        JFrame frame = new JFrame();
        frame.setVisible(true);
        Graphics g = frame.getGraphics();
        simpleArrow.paintComponent(g);
        frame.setVisible(false);
    }

    /**
     * <p>
     * Tests {@link SimpleArrow#paintComponent(java.awt.Graphics)} for accuracy.
     * </p>
     * <p>
     * It tests the case that when g is null and expects success.
     * </p>
     */
    public void testPaintComponents_NullG() {
        simpleArrow.paintComponent(null);
        // no exception will be thrown
    }

    /**
     * <p>
     * Tests {@link SimpleArrow#contains(int, int)} for accuracy.
     * </p>
     * <p>
     * It tests the case that the point is in the triangle and expects true.
     * </p>
     */
    public void testContainsIn1() {
        assertTrue("contains behavior is abnormal.", simpleArrow.contains(0, 0));
    }

    /**
     * <p>
     * Tests {@link SimpleArrow#contains(int, int)} for accuracy.
     * </p>
     * <p>
     * It tests the case that the point is in the triangle and expects true.
     * </p>
     */
    public void testContainsIn2() {
        assertTrue("contains behavior is abnormal.", simpleArrow.contains(-10, 0));
    }

    /**
     * <p>
     * Tests {@link SimpleArrow#contains(int, int)} for accuracy.
     * </p>
     * <p>
     * It tests the case that the point is in the triangle and expects true.
     * </p>
     */
    public void testContainsIn3() {
        assertTrue("contains behavior is abnormal.", simpleArrow.contains(-5, -5));
    }

    /**
     * <p>
     * Tests {@link SimpleArrow#contains(int, int)} for accuracy.
     * </p>
     * <p>
     * It tests the case that the point is in the triangle and expects true.
     * </p>
     */
    public void testContainsOut1() {
        assertFalse("contains behavior is abnormal.", simpleArrow.contains(-5, 6));
    }

    /**
     * <p>
     * Accuracy Test of the <code>contains(int, int)</code> method.
     * It creates an instance of SimpleArrow and use some points inside for test.
     * </p>
     */
    public void testContains_Inside() {
        // check for contain
        assertTrue("The SimpleArrow should contain this point.", simpleArrow1.contains(22, 11));
        // check for contain
        assertTrue("The SimpleArrow should contain this point.", simpleArrow1.contains(20, 15));
    }

    /**
     * <p>
     * Accuracy Test of the <code>contains(int, int)</code> method.
     * It creates an instance of SimpleArrow and use some points in the bound for test.
     * </p>
     */
    public void testContains_InBound() {
        // check for contain
        assertTrue("The SimpleArrow should contain this point.", simpleArrow1.contains(20, 10));
        // check for contain
        assertTrue("The SimpleArrow should contain this point.", simpleArrow1.contains(22, 10));
        // check for contain
        assertTrue("The SimpleArrow should contain this point.", simpleArrow1.contains(20, 20));
    }

    /**
     * <p>
     * Accuracy Test of the <code>contains(int, int)</code> method.
     * It creates an instance of SimpleArrow and use some points out of bounds for test.
     * </p>
     */
    public void testContains_OutOfBounds() {
        // check for not contain
        assertFalse("The SimpleArrow should not contain this point.", simpleArrow1.contains(11, 20));
        // check for not contain
        assertFalse("The SimpleArrow should not contain this point.", simpleArrow1.contains(12, 22));
    }

    /**
     * <p>
     * The entry of the demo program.
     * </p>
     *
     * @param args the arguments
     */
    public static void main(String[] args) {
        SimpleArrow arrow = new SimpleArrow();
        arrow.setBackground(Color.red);
        arrow.setBounds(new Rectangle(1, 2, 3, 5));
        arrow.setVisible(true);
        arrow.setEndingPoint(new Point(100, 200));
        arrow.setSize(2, 5);
        arrow.setAngle(Math.PI * 1.5);

        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().add(arrow);
        frame.setSize(new Dimension(500, 500));
        frame.setVisible(true);
    }
}
